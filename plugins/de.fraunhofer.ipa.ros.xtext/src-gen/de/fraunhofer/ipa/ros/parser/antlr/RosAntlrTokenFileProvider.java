/*
 * generated by Xtext 2.16.0
 */
package de.fraunhofer.ipa.ros.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class RosAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("de/fraunhofer/ipa/ros/parser/antlr/internal/InternalRos.tokens");
	}
}
