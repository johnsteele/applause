package org.applause.lang.generator.ios.ui;

import com.google.inject.Inject;
import org.applause.lang.applauseDsl.Screen;
import org.applause.lang.generator.ios.IosOutputConfigurationProvider;
import org.applause.lang.generator.ios.ui.DefaultListScreenClassExtensions;
import org.applause.lang.generator.ios.ui.DefaultListScreenHeaderFileCompiler;
import org.applause.lang.generator.ios.ui.DefaultListScreenModuleFileCompiler;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class DefaultListScreenCompiler {
  @Inject
  @Extension
  private DefaultListScreenHeaderFileCompiler _defaultListScreenHeaderFileCompiler;
  
  @Inject
  @Extension
  private DefaultListScreenModuleFileCompiler _defaultListScreenModuleFileCompiler;
  
  @Inject
  @Extension
  private DefaultListScreenClassExtensions _defaultListScreenClassExtensions;
  
  public void doGenerate(final Screen it, final IFileSystemAccess fsa) {
    String _screenHeaderFileName = this._defaultListScreenClassExtensions.screenHeaderFileName(it);
    CharSequence _compileHeader = this._defaultListScreenHeaderFileCompiler.compileHeader(it);
    fsa.generateFile(_screenHeaderFileName, IosOutputConfigurationProvider.IOS_OUTPUT_CONTROLLERS, _compileHeader);
    String _screenModuleFileName = this._defaultListScreenClassExtensions.screenModuleFileName(it);
    CharSequence _compileModule = this._defaultListScreenModuleFileCompiler.compileModule(it);
    fsa.generateFile(_screenModuleFileName, IosOutputConfigurationProvider.IOS_OUTPUT_CONTROLLERS, _compileModule);
  }
}
