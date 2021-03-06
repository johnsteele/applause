package org.applause.specification.codegen.ios;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import org.applause.lang.applauseDsl.Entity;
import org.applause.lang.applauseDsl.Model;
import org.applause.lang.applauseDsl.NamedElement;
import org.applause.lang.generator.ios.dataaccess.APIClientHeaderFileCompiler;
import org.applause.lang.generator.ios.dataaccess.APIClientModuleFileCompiler;
import org.applause.specification.ApplauseDslInjectorProvider;
import org.applause.specification.ApplauseDslTestCreator;
import org.applause.specification.codegen.ios.APIClientGeneratorEntityAPIClientSpec;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.jnario.runner.Contains;
import org.jnario.runner.CreateWith;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.junit.Assert;
import org.junit.runner.RunWith;

@Contains(APIClientGeneratorEntityAPIClientSpec.class)
@Named("API Client Generator")
@RunWith(ExampleGroupRunner.class)
@InjectWith(ApplauseDslInjectorProvider.class)
@CreateWith(ApplauseDslTestCreator.class)
@SuppressWarnings("all")
public class APIClientGeneratorSpec {
  @Inject
  @Extension
  @org.jnario.runner.Extension
  public ParseHelper<Model> _parseHelper;
  
  @Inject
  @Extension
  @org.jnario.runner.Extension
  public APIClientHeaderFileCompiler _aPIClientHeaderFileCompiler;
  
  @Inject
  @Extension
  @org.jnario.runner.Extension
  public APIClientModuleFileCompiler _aPIClientModuleFileCompiler;
  
  private Entity entity(final CharSequence input, final String entityName) {
    try {
      Entity _xblockexpression = null;
      {
        final Model model = this._parseHelper.parse(input);
        EList<NamedElement> _elements = model.getElements();
        Iterable<Entity> _filter = Iterables.<Entity>filter(_elements, Entity.class);
        final Function1<Entity,Boolean> _function = new Function1<Entity,Boolean>() {
          public Boolean apply(final Entity it) {
            String _name = it.getName();
            boolean _equals = Objects.equal(_name, entityName);
            return Boolean.valueOf(_equals);
          }
        };
        Entity _findFirst = IterableExtensions.<Entity>findFirst(_filter, _function);
        _xblockexpression = (_findFirst);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void isGeneratedHeaderFileFromModel(final CharSequence expectedGeneratedCode, final String entityName, final CharSequence input) {
    final Entity entity = this.entity(input, entityName);
    final CharSequence result = this._aPIClientHeaderFileCompiler.compileHeaderFile(entity);
    String _string = result.toString();
    String _string_1 = expectedGeneratedCode.toString();
    Matcher<String> _equalTo = CoreMatchers.<String>equalTo(_string_1);
    Assert.<String>assertThat(_string, _equalTo);
  }
  
  public void isGeneratedModuleFileFromModel(final CharSequence expectedGeneratedCode, final String entityName, final CharSequence input) {
    final Entity entity = this.entity(input, entityName);
    final CharSequence result = this._aPIClientModuleFileCompiler.compileModuleFile(entity);
    String _string = result.toString();
    String _string_1 = expectedGeneratedCode.toString();
    Matcher<String> _equalTo = CoreMatchers.<String>equalTo(_string_1);
    Assert.<String>assertThat(_string, _equalTo);
  }
}
