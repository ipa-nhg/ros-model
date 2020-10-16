/*
 * generated by Xtext 2.23.0
 */
package de.fraunhofer.ipa.componentInterface.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import de.fraunhofer.ipa.componentInterface.ide.contentassist.antlr.internal.InternalComponentInterfaceParser;
import de.fraunhofer.ipa.componentInterface.services.ComponentInterfaceGrammarAccess;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;

public class ComponentInterfaceParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(ComponentInterfaceGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, ComponentInterfaceGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getEStringAccess().getAlternatives(), "rule__EString__Alternatives");
			builder.put(grammarAccess.getParameterValueAccess().getAlternatives(), "rule__ParameterValue__Alternatives");
			builder.put(grammarAccess.getComponentInterfaceAccess().getGroup(), "rule__ComponentInterface__Group__0");
			builder.put(grammarAccess.getComponentInterfaceAccess().getGroup_4(), "rule__ComponentInterface__Group_4__0");
			builder.put(grammarAccess.getComponentInterfaceAccess().getGroup_5_0(), "rule__ComponentInterface__Group_5_0__0");
			builder.put(grammarAccess.getComponentInterfaceAccess().getGroup_5_0_3(), "rule__ComponentInterface__Group_5_0_3__0");
			builder.put(grammarAccess.getComponentInterfaceAccess().getGroup_5_1(), "rule__ComponentInterface__Group_5_1__0");
			builder.put(grammarAccess.getComponentInterfaceAccess().getGroup_5_1_3(), "rule__ComponentInterface__Group_5_1_3__0");
			builder.put(grammarAccess.getComponentInterfaceAccess().getGroup_5_2(), "rule__ComponentInterface__Group_5_2__0");
			builder.put(grammarAccess.getComponentInterfaceAccess().getGroup_5_2_3(), "rule__ComponentInterface__Group_5_2_3__0");
			builder.put(grammarAccess.getComponentInterfaceAccess().getGroup_5_3(), "rule__ComponentInterface__Group_5_3__0");
			builder.put(grammarAccess.getComponentInterfaceAccess().getGroup_5_3_3(), "rule__ComponentInterface__Group_5_3_3__0");
			builder.put(grammarAccess.getComponentInterfaceAccess().getGroup_5_4(), "rule__ComponentInterface__Group_5_4__0");
			builder.put(grammarAccess.getComponentInterfaceAccess().getGroup_5_4_3(), "rule__ComponentInterface__Group_5_4_3__0");
			builder.put(grammarAccess.getComponentInterfaceAccess().getGroup_5_5(), "rule__ComponentInterface__Group_5_5__0");
			builder.put(grammarAccess.getComponentInterfaceAccess().getGroup_5_5_3(), "rule__ComponentInterface__Group_5_5_3__0");
			builder.put(grammarAccess.getComponentInterfaceAccess().getGroup_5_6(), "rule__ComponentInterface__Group_5_6__0");
			builder.put(grammarAccess.getComponentInterfaceAccess().getGroup_5_6_3(), "rule__ComponentInterface__Group_5_6_3__0");
			builder.put(grammarAccess.getRosPublisherAccess().getGroup(), "rule__RosPublisher__Group__0");
			builder.put(grammarAccess.getRosPublisherAccess().getGroup_4(), "rule__RosPublisher__Group_4__0");
			builder.put(grammarAccess.getRosSubscriberAccess().getGroup(), "rule__RosSubscriber__Group__0");
			builder.put(grammarAccess.getRosSubscriberAccess().getGroup_4(), "rule__RosSubscriber__Group_4__0");
			builder.put(grammarAccess.getRosServiceServerAccess().getGroup(), "rule__RosServiceServer__Group__0");
			builder.put(grammarAccess.getRosServiceServerAccess().getGroup_4(), "rule__RosServiceServer__Group_4__0");
			builder.put(grammarAccess.getRosServiceClientAccess().getGroup(), "rule__RosServiceClient__Group__0");
			builder.put(grammarAccess.getRosServiceClientAccess().getGroup_4(), "rule__RosServiceClient__Group_4__0");
			builder.put(grammarAccess.getRosActionServerAccess().getGroup(), "rule__RosActionServer__Group__0");
			builder.put(grammarAccess.getRosActionServerAccess().getGroup_4(), "rule__RosActionServer__Group_4__0");
			builder.put(grammarAccess.getRosActionClientAccess().getGroup(), "rule__RosActionClient__Group__0");
			builder.put(grammarAccess.getRosActionClientAccess().getGroup_4(), "rule__RosActionClient__Group_4__0");
			builder.put(grammarAccess.getRosParameterAccess().getGroup(), "rule__RosParameter__Group__0");
			builder.put(grammarAccess.getRosParameterAccess().getGroup_4(), "rule__RosParameter__Group_4__0");
			builder.put(grammarAccess.getRosParameterAccess().getGroup_7(), "rule__RosParameter__Group_7__0");
			builder.put(grammarAccess.getParameterListAccess().getGroup(), "rule__ParameterList__Group__0");
			builder.put(grammarAccess.getParameterListAccess().getGroup_3(), "rule__ParameterList__Group_3__0");
			builder.put(grammarAccess.getParameterArrayAccess().getGroup(), "rule__ParameterArray__Group__0");
			builder.put(grammarAccess.getParameterArrayAccess().getGroup_3(), "rule__ParameterArray__Group_3__0");
			builder.put(grammarAccess.getParameterStructAccess().getGroup(), "rule__ParameterStruct__Group__0");
			builder.put(grammarAccess.getParameterStructAccess().getGroup_1(), "rule__ParameterStruct__Group_1__0");
			builder.put(grammarAccess.getParameterStructAccess().getGroup_1_2(), "rule__ParameterStruct__Group_1_2__0");
			builder.put(grammarAccess.getParameterStructMemberAccess().getGroup(), "rule__ParameterStructMember__Group__0");
			builder.put(grammarAccess.getComponentInterfaceAccess().getNameAssignment_3(), "rule__ComponentInterface__NameAssignment_3");
			builder.put(grammarAccess.getComponentInterfaceAccess().getNameSpaceAssignment_4_1(), "rule__ComponentInterface__NameSpaceAssignment_4_1");
			builder.put(grammarAccess.getComponentInterfaceAccess().getRospublisherAssignment_5_0_2(), "rule__ComponentInterface__RospublisherAssignment_5_0_2");
			builder.put(grammarAccess.getComponentInterfaceAccess().getRospublisherAssignment_5_0_3_1(), "rule__ComponentInterface__RospublisherAssignment_5_0_3_1");
			builder.put(grammarAccess.getComponentInterfaceAccess().getRossubscriberAssignment_5_1_2(), "rule__ComponentInterface__RossubscriberAssignment_5_1_2");
			builder.put(grammarAccess.getComponentInterfaceAccess().getRossubscriberAssignment_5_1_3_1(), "rule__ComponentInterface__RossubscriberAssignment_5_1_3_1");
			builder.put(grammarAccess.getComponentInterfaceAccess().getRosserviceserverAssignment_5_2_2(), "rule__ComponentInterface__RosserviceserverAssignment_5_2_2");
			builder.put(grammarAccess.getComponentInterfaceAccess().getRosserviceserverAssignment_5_2_3_1(), "rule__ComponentInterface__RosserviceserverAssignment_5_2_3_1");
			builder.put(grammarAccess.getComponentInterfaceAccess().getRosserviceclientAssignment_5_3_2(), "rule__ComponentInterface__RosserviceclientAssignment_5_3_2");
			builder.put(grammarAccess.getComponentInterfaceAccess().getRosserviceclientAssignment_5_3_3_1(), "rule__ComponentInterface__RosserviceclientAssignment_5_3_3_1");
			builder.put(grammarAccess.getComponentInterfaceAccess().getRosactionserverAssignment_5_4_2(), "rule__ComponentInterface__RosactionserverAssignment_5_4_2");
			builder.put(grammarAccess.getComponentInterfaceAccess().getRosactionserverAssignment_5_4_3_1(), "rule__ComponentInterface__RosactionserverAssignment_5_4_3_1");
			builder.put(grammarAccess.getComponentInterfaceAccess().getRosactionclientAssignment_5_5_2(), "rule__ComponentInterface__RosactionclientAssignment_5_5_2");
			builder.put(grammarAccess.getComponentInterfaceAccess().getRosactionclientAssignment_5_5_3_1(), "rule__ComponentInterface__RosactionclientAssignment_5_5_3_1");
			builder.put(grammarAccess.getComponentInterfaceAccess().getRosparameterAssignment_5_6_2(), "rule__ComponentInterface__RosparameterAssignment_5_6_2");
			builder.put(grammarAccess.getComponentInterfaceAccess().getRosparameterAssignment_5_6_3_1(), "rule__ComponentInterface__RosparameterAssignment_5_6_3_1");
			builder.put(grammarAccess.getRosPublisherAccess().getNameAssignment_2(), "rule__RosPublisher__NameAssignment_2");
			builder.put(grammarAccess.getRosPublisherAccess().getNsAssignment_4_1(), "rule__RosPublisher__NsAssignment_4_1");
			builder.put(grammarAccess.getRosPublisherAccess().getPublisherAssignment_6(), "rule__RosPublisher__PublisherAssignment_6");
			builder.put(grammarAccess.getRosSubscriberAccess().getNameAssignment_2(), "rule__RosSubscriber__NameAssignment_2");
			builder.put(grammarAccess.getRosSubscriberAccess().getNsAssignment_4_1(), "rule__RosSubscriber__NsAssignment_4_1");
			builder.put(grammarAccess.getRosSubscriberAccess().getSubscriberAssignment_6(), "rule__RosSubscriber__SubscriberAssignment_6");
			builder.put(grammarAccess.getRosServiceServerAccess().getNameAssignment_2(), "rule__RosServiceServer__NameAssignment_2");
			builder.put(grammarAccess.getRosServiceServerAccess().getNsAssignment_4_1(), "rule__RosServiceServer__NsAssignment_4_1");
			builder.put(grammarAccess.getRosServiceServerAccess().getSrvserverAssignment_6(), "rule__RosServiceServer__SrvserverAssignment_6");
			builder.put(grammarAccess.getRosServiceClientAccess().getNameAssignment_2(), "rule__RosServiceClient__NameAssignment_2");
			builder.put(grammarAccess.getRosServiceClientAccess().getNsAssignment_4_1(), "rule__RosServiceClient__NsAssignment_4_1");
			builder.put(grammarAccess.getRosServiceClientAccess().getSrvclientAssignment_6(), "rule__RosServiceClient__SrvclientAssignment_6");
			builder.put(grammarAccess.getRosActionServerAccess().getNameAssignment_2(), "rule__RosActionServer__NameAssignment_2");
			builder.put(grammarAccess.getRosActionServerAccess().getNsAssignment_4_1(), "rule__RosActionServer__NsAssignment_4_1");
			builder.put(grammarAccess.getRosActionServerAccess().getActserverAssignment_6(), "rule__RosActionServer__ActserverAssignment_6");
			builder.put(grammarAccess.getRosActionClientAccess().getNameAssignment_2(), "rule__RosActionClient__NameAssignment_2");
			builder.put(grammarAccess.getRosActionClientAccess().getNsAssignment_4_1(), "rule__RosActionClient__NsAssignment_4_1");
			builder.put(grammarAccess.getRosActionClientAccess().getActclientAssignment_6(), "rule__RosActionClient__ActclientAssignment_6");
			builder.put(grammarAccess.getRosParameterAccess().getNameAssignment_2(), "rule__RosParameter__NameAssignment_2");
			builder.put(grammarAccess.getRosParameterAccess().getNsAssignment_4_1(), "rule__RosParameter__NsAssignment_4_1");
			builder.put(grammarAccess.getRosParameterAccess().getParameterAssignment_6(), "rule__RosParameter__ParameterAssignment_6");
			builder.put(grammarAccess.getRosParameterAccess().getValueAssignment_7_1(), "rule__RosParameter__ValueAssignment_7_1");
			builder.put(grammarAccess.getParameterStringAccess().getValueAssignment(), "rule__ParameterString__ValueAssignment");
			builder.put(grammarAccess.getParameterBase64Access().getValueAssignment(), "rule__ParameterBase64__ValueAssignment");
			builder.put(grammarAccess.getParameterIntegerAccess().getValueAssignment(), "rule__ParameterInteger__ValueAssignment");
			builder.put(grammarAccess.getParameterDoubleAccess().getValueAssignment(), "rule__ParameterDouble__ValueAssignment");
			builder.put(grammarAccess.getParameterBooleanAccess().getValueAssignment(), "rule__ParameterBoolean__ValueAssignment");
			builder.put(grammarAccess.getParameterListAccess().getValueAssignment_2(), "rule__ParameterList__ValueAssignment_2");
			builder.put(grammarAccess.getParameterListAccess().getValueAssignment_3_1(), "rule__ParameterList__ValueAssignment_3_1");
			builder.put(grammarAccess.getParameterArrayAccess().getValueAssignment_2(), "rule__ParameterArray__ValueAssignment_2");
			builder.put(grammarAccess.getParameterArrayAccess().getValueAssignment_3_1(), "rule__ParameterArray__ValueAssignment_3_1");
			builder.put(grammarAccess.getParameterStructAccess().getValueAssignment_1_1(), "rule__ParameterStruct__ValueAssignment_1_1");
			builder.put(grammarAccess.getParameterStructAccess().getValueAssignment_1_2_2(), "rule__ParameterStruct__ValueAssignment_1_2_2");
			builder.put(grammarAccess.getParameterStructMemberAccess().getNameAssignment_0(), "rule__ParameterStructMember__NameAssignment_0");
			builder.put(grammarAccess.getParameterStructMemberAccess().getValueAssignment_3(), "rule__ParameterStructMember__ValueAssignment_3");
			builder.put(grammarAccess.getComponentInterfaceAccess().getUnorderedGroup_5(), "rule__ComponentInterface__UnorderedGroup_5");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private ComponentInterfaceGrammarAccess grammarAccess;

	@Override
	protected InternalComponentInterfaceParser createParser() {
		InternalComponentInterfaceParser result = new InternalComponentInterfaceParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public ComponentInterfaceGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(ComponentInterfaceGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
