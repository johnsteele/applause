package de.itemis.mobilizer.ui.generator;

import org.eclipse.core.resources.IFile;
import org.eclipse.xtext.builder.IXtextBuilderParticipant.IBuildContext;

public class BuildStrategyFactory {
	
	public static AbstractBuildStrategy getBuildStrategy(IBuildContext context) {
		IFile androidManifest = context.getBuiltProject().getFile("AndroidManifest.xml");
		IFile wp7Solution = context.getBuiltProject().getFile("ItemisAppWP7.sln");
		if (androidManifest.exists()) {
			return new AndroidBuildStrategy(context);
		}
		else {
			if (wp7Solution.exists()) {
				return new WP7BuildStrategy(context);
			}
			else {
				return new IPhoneBuildStrategy(context);
			}
		}
	}

}
