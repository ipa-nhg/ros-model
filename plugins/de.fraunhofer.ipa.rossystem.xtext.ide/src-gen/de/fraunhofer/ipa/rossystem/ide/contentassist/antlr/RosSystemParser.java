/*
 * generated by Xtext 2.16.0
 */
package de.fraunhofer.ipa.rossystem.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import de.fraunhofer.ipa.rossystem.ide.contentassist.antlr.internal.InternalRosSystemParser;
import de.fraunhofer.ipa.rossystem.services.RosSystemGrammarAccess;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;

public class RosSystemParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(RosSystemGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, RosSystemGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getEStringAccess().getAlternatives(), "rule__EString__Alternatives");
			builder.put(grammarAccess.getRosSystemAccess().getGroup(), "rule__RosSystem__Group__0");
			builder.put(grammarAccess.getRosSystemAccess().getGroup_5(), "rule__RosSystem__Group_5__0");
			builder.put(grammarAccess.getRosSystemAccess().getGroup_5_2(), "rule__RosSystem__Group_5_2__0");
			builder.put(grammarAccess.getRosSystemAccess().getGroup_5_2_1(), "rule__RosSystem__Group_5_2_1__0");
			builder.put(grammarAccess.getRosSystemAccess().getGroup_6(), "rule__RosSystem__Group_6__0");
			builder.put(grammarAccess.getRosSystemAccess().getGroup_6_2(), "rule__RosSystem__Group_6_2__0");
			builder.put(grammarAccess.getRosSystemAccess().getGroup_6_2_1(), "rule__RosSystem__Group_6_2_1__0");
			builder.put(grammarAccess.getRosSystemAccess().getGroup_7(), "rule__RosSystem__Group_7__0");
			builder.put(grammarAccess.getRosSystemAccess().getGroup_7_2(), "rule__RosSystem__Group_7_2__0");
			builder.put(grammarAccess.getRosSystemAccess().getGroup_7_2_1(), "rule__RosSystem__Group_7_2_1__0");
			builder.put(grammarAccess.getRosSystemAccess().getGroup_8(), "rule__RosSystem__Group_8__0");
			builder.put(grammarAccess.getRosSystemAccess().getGroup_8_2(), "rule__RosSystem__Group_8_2__0");
			builder.put(grammarAccess.getRosSystemAccess().getGroup_8_2_1(), "rule__RosSystem__Group_8_2_1__0");
			builder.put(grammarAccess.getTopicConnectionAccess().getGroup(), "rule__TopicConnection__Group__0");
			builder.put(grammarAccess.getTopicConnectionAccess().getGroup_6(), "rule__TopicConnection__Group_6__0");
			builder.put(grammarAccess.getTopicConnectionAccess().getGroup_11(), "rule__TopicConnection__Group_11__0");
			builder.put(grammarAccess.getServiceConnectionAccess().getGroup(), "rule__ServiceConnection__Group__0");
			builder.put(grammarAccess.getServiceConnectionAccess().getGroup_6(), "rule__ServiceConnection__Group_6__0");
			builder.put(grammarAccess.getActionConnectionAccess().getGroup(), "rule__ActionConnection__Group__0");
			builder.put(grammarAccess.getComponentInterfaceAccess().getGroup(), "rule__ComponentInterface__Group__0");
			builder.put(grammarAccess.getComponentInterfaceAccess().getGroup_4(), "rule__ComponentInterface__Group_4__0");
			builder.put(grammarAccess.getComponentInterfaceAccess().getGroup_5(), "rule__ComponentInterface__Group_5__0");
			builder.put(grammarAccess.getComponentInterfaceAccess().getGroup_5_3(), "rule__ComponentInterface__Group_5_3__0");
			builder.put(grammarAccess.getComponentInterfaceAccess().getGroup_6(), "rule__ComponentInterface__Group_6__0");
			builder.put(grammarAccess.getComponentInterfaceAccess().getGroup_6_3(), "rule__ComponentInterface__Group_6_3__0");
			builder.put(grammarAccess.getComponentInterfaceAccess().getGroup_7(), "rule__ComponentInterface__Group_7__0");
			builder.put(grammarAccess.getComponentInterfaceAccess().getGroup_7_3(), "rule__ComponentInterface__Group_7_3__0");
			builder.put(grammarAccess.getComponentInterfaceAccess().getGroup_8(), "rule__ComponentInterface__Group_8__0");
			builder.put(grammarAccess.getComponentInterfaceAccess().getGroup_8_3(), "rule__ComponentInterface__Group_8_3__0");
			builder.put(grammarAccess.getComponentInterfaceAccess().getGroup_9(), "rule__ComponentInterface__Group_9__0");
			builder.put(grammarAccess.getComponentInterfaceAccess().getGroup_9_3(), "rule__ComponentInterface__Group_9_3__0");
			builder.put(grammarAccess.getComponentInterfaceAccess().getGroup_10(), "rule__ComponentInterface__Group_10__0");
			builder.put(grammarAccess.getComponentInterfaceAccess().getGroup_10_3(), "rule__ComponentInterface__Group_10_3__0");
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
			builder.put(grammarAccess.getRosSystemAccess().getNameAssignment_4(), "rule__RosSystem__NameAssignment_4");
			builder.put(grammarAccess.getRosSystemAccess().getRosComponentAssignment_5_2_0(), "rule__RosSystem__RosComponentAssignment_5_2_0");
			builder.put(grammarAccess.getRosSystemAccess().getRosComponentAssignment_5_2_1_1(), "rule__RosSystem__RosComponentAssignment_5_2_1_1");
			builder.put(grammarAccess.getRosSystemAccess().getTopicConnectionsAssignment_6_2_0(), "rule__RosSystem__TopicConnectionsAssignment_6_2_0");
			builder.put(grammarAccess.getRosSystemAccess().getTopicConnectionsAssignment_6_2_1_1(), "rule__RosSystem__TopicConnectionsAssignment_6_2_1_1");
			builder.put(grammarAccess.getRosSystemAccess().getServiceConnectionsAssignment_7_2_0(), "rule__RosSystem__ServiceConnectionsAssignment_7_2_0");
			builder.put(grammarAccess.getRosSystemAccess().getServiceConnectionsAssignment_7_2_1_1(), "rule__RosSystem__ServiceConnectionsAssignment_7_2_1_1");
			builder.put(grammarAccess.getRosSystemAccess().getActionConnectionsAssignment_8_2_0(), "rule__RosSystem__ActionConnectionsAssignment_8_2_0");
			builder.put(grammarAccess.getRosSystemAccess().getActionConnectionsAssignment_8_2_1_1(), "rule__RosSystem__ActionConnectionsAssignment_8_2_1_1");
			builder.put(grammarAccess.getTopicConnectionAccess().getTopicNameAssignment_1(), "rule__TopicConnection__TopicNameAssignment_1");
			builder.put(grammarAccess.getTopicConnectionAccess().getFromAssignment_5(), "rule__TopicConnection__FromAssignment_5");
			builder.put(grammarAccess.getTopicConnectionAccess().getFromAssignment_6_1(), "rule__TopicConnection__FromAssignment_6_1");
			builder.put(grammarAccess.getTopicConnectionAccess().getToAssignment_10(), "rule__TopicConnection__ToAssignment_10");
			builder.put(grammarAccess.getTopicConnectionAccess().getToAssignment_11_1(), "rule__TopicConnection__ToAssignment_11_1");
			builder.put(grammarAccess.getServiceConnectionAccess().getServiceNameAssignment_1(), "rule__ServiceConnection__ServiceNameAssignment_1");
			builder.put(grammarAccess.getServiceConnectionAccess().getFromAssignment_5(), "rule__ServiceConnection__FromAssignment_5");
			builder.put(grammarAccess.getServiceConnectionAccess().getFromAssignment_6_1(), "rule__ServiceConnection__FromAssignment_6_1");
			builder.put(grammarAccess.getServiceConnectionAccess().getToAssignment_9(), "rule__ServiceConnection__ToAssignment_9");
			builder.put(grammarAccess.getActionConnectionAccess().getActionNameAssignment_1(), "rule__ActionConnection__ActionNameAssignment_1");
			builder.put(grammarAccess.getActionConnectionAccess().getFromAssignment_4(), "rule__ActionConnection__FromAssignment_4");
			builder.put(grammarAccess.getActionConnectionAccess().getToAssignment_6(), "rule__ActionConnection__ToAssignment_6");
			builder.put(grammarAccess.getComponentInterfaceAccess().getNameAssignment_3(), "rule__ComponentInterface__NameAssignment_3");
			builder.put(grammarAccess.getComponentInterfaceAccess().getNameSpaceAssignment_4_1(), "rule__ComponentInterface__NameSpaceAssignment_4_1");
			builder.put(grammarAccess.getComponentInterfaceAccess().getRospublisherAssignment_5_2(), "rule__ComponentInterface__RospublisherAssignment_5_2");
			builder.put(grammarAccess.getComponentInterfaceAccess().getRospublisherAssignment_5_3_1(), "rule__ComponentInterface__RospublisherAssignment_5_3_1");
			builder.put(grammarAccess.getComponentInterfaceAccess().getRossubscriberAssignment_6_2(), "rule__ComponentInterface__RossubscriberAssignment_6_2");
			builder.put(grammarAccess.getComponentInterfaceAccess().getRossubscriberAssignment_6_3_1(), "rule__ComponentInterface__RossubscriberAssignment_6_3_1");
			builder.put(grammarAccess.getComponentInterfaceAccess().getRosserviceserverAssignment_7_2(), "rule__ComponentInterface__RosserviceserverAssignment_7_2");
			builder.put(grammarAccess.getComponentInterfaceAccess().getRosserviceserverAssignment_7_3_1(), "rule__ComponentInterface__RosserviceserverAssignment_7_3_1");
			builder.put(grammarAccess.getComponentInterfaceAccess().getRosserviceclientAssignment_8_2(), "rule__ComponentInterface__RosserviceclientAssignment_8_2");
			builder.put(grammarAccess.getComponentInterfaceAccess().getRosserviceclientAssignment_8_3_1(), "rule__ComponentInterface__RosserviceclientAssignment_8_3_1");
			builder.put(grammarAccess.getComponentInterfaceAccess().getRosactionserverAssignment_9_2(), "rule__ComponentInterface__RosactionserverAssignment_9_2");
			builder.put(grammarAccess.getComponentInterfaceAccess().getRosactionserverAssignment_9_3_1(), "rule__ComponentInterface__RosactionserverAssignment_9_3_1");
			builder.put(grammarAccess.getComponentInterfaceAccess().getRosactionclientAssignment_10_2(), "rule__ComponentInterface__RosactionclientAssignment_10_2");
			builder.put(grammarAccess.getComponentInterfaceAccess().getRosactionclientAssignment_10_3_1(), "rule__ComponentInterface__RosactionclientAssignment_10_3_1");
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
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private RosSystemGrammarAccess grammarAccess;

	@Override
	protected InternalRosSystemParser createParser() {
		InternalRosSystemParser result = new InternalRosSystemParser(null);
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

	public RosSystemGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(RosSystemGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
