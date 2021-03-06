/*
 * generated by Xtext 2.13.0
 */
package de.fraunhofer.ipa.rossystem

import org.eclipse.xtext.generator.IOutputConfigurationProvider
import de.fraunhofer.ipa.rossystem.generator.CustomOutputProvider
import com.google.inject.Binder


/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
class RosSystemRuntimeModule extends AbstractRosSystemRuntimeModule {
		
	override void configure(Binder binder) {
		super.configure(binder)
		binder.bind(IOutputConfigurationProvider).to(CustomOutputProvider).asEagerSingleton()
	}

}
