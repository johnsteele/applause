/*
 * generated by Xtext
 */
package org.applause.util.xcode.projectfile.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.IOutlineTreeStructureProvider;

/**
 * Use this class to register components to be used within the IDE.
 */
public class PbxprojUiModule extends org.applause.util.xcode.projectfile.ui.AbstractPbxprojUiModule {
	public PbxprojUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	@Override
	public Class<? extends IOutlineTreeProvider> bindIOutlineTreeProvider() {
		return org.applause.util.xcode.projectfile.ui.outline.XtendPbxprojOutlineTreeProvider.class;
	}
	
	@Override
	public Class<? extends IOutlineTreeStructureProvider> bindIOutlineTreeStructureProvider() {
		return org.applause.util.xcode.projectfile.ui.outline.XtendPbxprojOutlineTreeProvider.class;
	}
}
