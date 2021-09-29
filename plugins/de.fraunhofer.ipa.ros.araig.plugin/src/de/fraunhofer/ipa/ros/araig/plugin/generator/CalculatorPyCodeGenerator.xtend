package de.fraunhofer.ipa.ros.araig.plugin.generator;

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.xtext.generator.IOutputConfigurationProvider
import org.eclipse.xtext.generator.OutputConfiguration
import java.util.Set
import ros.Node

class CustomOutputProvider implements IOutputConfigurationProvider {
	public final static String CALCULATOR_OUTPUT = "CALCULATOR_OUTPUT"
	
	override Set<OutputConfiguration> getOutputConfigurations() {
		var OutputConfiguration observer_config = new OutputConfiguration(CALCULATOR_OUTPUT)
		observer_config.setDescription("CALCULATOR_OUTPUT");
		observer_config.setOutputDirectory("./src-gen/calculators/");
		observer_config.setOverrideExistingResources(true);
		observer_config.setCreateOutputDirectory(true);
		observer_config.setCleanUpDerivedResources(true);
		observer_config.setSetDerivedProperty(true);
		return newHashSet(observer_config)
	}
}


class CalculatorPyCodeGenerator extends AbstractGenerator {

	int count_sub
	String header_name
	String pointer_name
	String class_name
	
	def void createXtextGenerationFolder (IFileSystemAccess2 fsa, IGeneratorContext context) {
		fsa.generateFile("lock",CustomOutputProvider::CALCULATOR_OUTPUT,'''''');
		fsa.deleteFile("lock",CustomOutputProvider::CALCULATOR_OUTPUT);
	}

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
			for (node : resource.allContents.toIterable.filter(Node)){
				fsa.generateFile(node.getName()+".py",CustomOutputProvider::CALCULATOR_OUTPUT,node.compile)
				}
			}

def compile(Node node) {
	count_sub = node.subscriber.size
	header_name = node.name
'''
#include <nodelet/nodelet.h>
#include <pluginlib/class_list_macros.h>
#include <string>

«««#include "ambs_components/ambs_calculators/comparators/float_param_comparator.h"
#include "ambs_components/ambs_calculators/comparators/«node.name».h"

namespace ambs_calculators
{

«««class CompFloatParamNodelet : public nodelet::Nodelet
class «node.name»Nodelet : public nodelet::Nodelet
{
public:
  «node.name»Nodelet() {}
  ~«node.name»Nodelet() {}

  virtual void onInit()
      {
        ros::NodeHandle nh = this->getMTPrivateNodeHandle();
        std::string name = nh.getUnresolvedNamespace();
        name = name.substr(name.find_last_of('/') + 1);

        NODELET_INFO_STREAM("Initialising nodelet... [" << name << "]");
«««        class_pointer_.reset(new CompFloatParam(nh, name));
        class_pointer_.reset(new plugin_object(nh, name));
        
«««        class_pointer_->init(
«««		"in_start", "in_stop", "in_reset", "in_float"
«««		"out_done", "out_comparison");
        class_pointer_->init(
        «FOR pub:node.publisher»
        "«pub.name»",
        «ENDFOR»
        «FOR sub:node.subscriber»
        "«sub.name»",
        «ENDFOR»
		);
      }

private:
«««    boost::shared_ptr<CompFloatParam> class_pointer_;
    boost::shared_ptr<plugin_object> class_pointer_;
};

}  // namespace ambs_calculators

«««PLUGINLIB_EXPORT_CLASS(ambs_calculators::CompFloatParamNodelet,
«««                       nodelet::Nodelet);
PLUGINLIB_EXPORT_CLASS(ambs_calculators::«node.name»Nodelet,
                       nodelet::Nodelet);                   
'''
}

}