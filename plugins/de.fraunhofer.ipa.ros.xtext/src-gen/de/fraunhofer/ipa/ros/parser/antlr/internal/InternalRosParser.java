package de.fraunhofer.ipa.ros.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import de.fraunhofer.ipa.ros.services.RosGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalRosParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ParameterStructMember", "ExternalDependency", "RelativeNamespace", "PrivateNamespace", "GlobalNamespace", "Serviceclient", "Serviceserver", "Actionclient", "Actionserver", "Dependencies", "ParameterAny", "FromGitRepo", "Subscribers", "Parameters", "Publishers", "GraphName", "Feedback_1", "Float32_1", "Float64_1", "Response", "Duration", "Feedback", "Message_1", "Request", "String_2", "Uint16_1", "Uint32_1", "Uint64_1", "Boolean", "Integer", "Action_1", "Default", "Float32", "Float64", "Int16_1", "Int32_1", "Int64_1", "Message", "Result_1", "Service", "Uint8_1", "Array", "Base64", "Double", "Header", "String", "Struct", "Action", "Bool_1", "Byte_1", "Int8_1", "Result", "Specs", "String_1", "Uint16", "Uint32", "Uint64", "Value_1", "Goal_1", "Int16", "Int32", "Int64", "Node_1", "Type_1", "Uint8", "Value", "Date", "List", "Bool", "Byte", "Goal", "Int8", "Msg", "Name", "Node", "Srv", "Time", "Type", "Any", "Ns", "LeftSquareBracketRightSquareBracket", "Comma", "HyphenMinus", "Colon", "LeftSquareBracket", "RightSquareBracket", "RULE_DIGIT", "RULE_BINARY", "RULE_BOOLEAN", "RULE_DECINT", "RULE_DOUBLE", "RULE_DAY", "RULE_MONTH", "RULE_YEAR", "RULE_HOUR", "RULE_MIN_SEC", "RULE_DATE_TIME", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_MESSAGE_ASIGMENT", "RULE_BEGIN", "RULE_END", "RULE_SL_COMMENT", "RULE_ROS_CONVENTION_A", "RULE_ROS_CONVENTION_PARAM", "RULE_ML_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int Float32_1=21;
    public static final int Node=78;
    public static final int RULE_DATE_TIME=100;
    public static final int Uint64_1=31;
    public static final int String=49;
    public static final int Int16=63;
    public static final int Float32=36;
    public static final int Goal=74;
    public static final int Bool=72;
    public static final int Uint16=58;
    public static final int Boolean=32;
    public static final int ExternalDependency=5;
    public static final int Uint8=68;
    public static final int Parameters=17;
    public static final int RULE_ID=101;
    public static final int Actionclient=11;
    public static final int RULE_DIGIT=90;
    public static final int GlobalNamespace=8;
    public static final int Node_1=66;
    public static final int Int16_1=38;
    public static final int Header=48;
    public static final int RULE_INT=103;
    public static final int Byte=73;
    public static final int RULE_ML_COMMENT=110;
    public static final int LeftSquareBracket=88;
    public static final int Specs=56;
    public static final int Base64=46;
    public static final int Message_1=26;
    public static final int Comma=85;
    public static final int HyphenMinus=86;
    public static final int RULE_MESSAGE_ASIGMENT=104;
    public static final int Goal_1=62;
    public static final int LeftSquareBracketRightSquareBracket=84;
    public static final int Int32=64;
    public static final int Publishers=18;
    public static final int Serviceserver=10;
    public static final int RULE_DECINT=93;
    public static final int Uint32=59;
    public static final int FromGitRepo=15;
    public static final int Msg=76;
    public static final int RULE_HOUR=98;
    public static final int Int8=75;
    public static final int Default=35;
    public static final int Actionserver=12;
    public static final int Int8_1=54;
    public static final int Uint16_1=29;
    public static final int Type=81;
    public static final int Float64=37;
    public static final int Int32_1=39;
    public static final int Result_1=42;
    public static final int RULE_BINARY=91;
    public static final int String_1=57;
    public static final int Subscribers=16;
    public static final int String_2=28;
    public static final int RULE_DAY=95;
    public static final int RULE_BEGIN=105;
    public static final int RULE_BOOLEAN=92;
    public static final int RelativeNamespace=6;
    public static final int RULE_YEAR=97;
    public static final int Feedback_1=20;
    public static final int Result=55;
    public static final int Name=77;
    public static final int RULE_MIN_SEC=99;
    public static final int ParameterAny=14;
    public static final int List=71;
    public static final int Dependencies=13;
    public static final int RightSquareBracket=89;
    public static final int PrivateNamespace=7;
    public static final int GraphName=19;
    public static final int Byte_1=53;
    public static final int Float64_1=22;
    public static final int Duration=24;
    public static final int Uint32_1=30;
    public static final int Action_1=34;
    public static final int Double=47;
    public static final int Type_1=67;
    public static final int Value=69;
    public static final int Uint64=60;
    public static final int Action=51;
    public static final int RULE_END=106;
    public static final int Message=41;
    public static final int Value_1=61;
    public static final int Time=80;
    public static final int RULE_STRING=102;
    public static final int Bool_1=52;
    public static final int Any=82;
    public static final int Struct=50;
    public static final int RULE_SL_COMMENT=107;
    public static final int Uint8_1=44;
    public static final int RULE_DOUBLE=94;
    public static final int Feedback=25;
    public static final int ParameterStructMember=4;
    public static final int Srv=79;
    public static final int RULE_ROS_CONVENTION_A=108;
    public static final int RULE_ROS_CONVENTION_PARAM=109;
    public static final int Colon=87;
    public static final int EOF=-1;
    public static final int Ns=83;
    public static final int RULE_WS=111;
    public static final int Request=27;
    public static final int Int64_1=40;
    public static final int Service=43;
    public static final int RULE_ANY_OTHER=112;
    public static final int Date=70;
    public static final int Response=23;
    public static final int Integer=33;
    public static final int Array=45;
    public static final int Serviceclient=9;
    public static final int Int64=65;
    public static final int RULE_MONTH=96;

    // delegates
    // delegators


        public InternalRosParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalRosParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);

        }


    public String[] getTokenNames() { return InternalRosParser.tokenNames; }
    public String getGrammarFileName() { return "InternalRosParser.g"; }



        private RosGrammarAccess grammarAccess;

        public InternalRosParser(TokenStream input, RosGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
            return "PackageSet";
        }

        @Override
        protected RosGrammarAccess getGrammarAccess() {
            return grammarAccess;
        }




    // $ANTLR start "entryRulePackageSet"
    // InternalRosParser.g:57:1: entryRulePackageSet returns [EObject current=null] : iv_rulePackageSet= rulePackageSet EOF ;
    public final EObject entryRulePackageSet() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageSet = null;


        try {
            // InternalRosParser.g:57:51: (iv_rulePackageSet= rulePackageSet EOF )
            // InternalRosParser.g:58:2: iv_rulePackageSet= rulePackageSet EOF
            {
             newCompositeNode(grammarAccess.getPackageSetRule());
            pushFollow(FOLLOW_1);
            iv_rulePackageSet=rulePackageSet();

            state._fsp--;

             current =iv_rulePackageSet;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePackageSet"


    // $ANTLR start "rulePackageSet"
    // InternalRosParser.g:64:1: rulePackageSet returns [EObject current=null] : ( () ( (lv_package_1_0= rulePackage_Impl ) )* ) ;
    public final EObject rulePackageSet() throws RecognitionException {
        EObject current = null;

        EObject lv_package_1_0 = null;



            enterRule();

        try {
            // InternalRosParser.g:70:2: ( ( () ( (lv_package_1_0= rulePackage_Impl ) )* ) )
            // InternalRosParser.g:71:2: ( () ( (lv_package_1_0= rulePackage_Impl ) )* )
            {
            // InternalRosParser.g:71:2: ( () ( (lv_package_1_0= rulePackage_Impl ) )* )
            // InternalRosParser.g:72:3: () ( (lv_package_1_0= rulePackage_Impl ) )*
            {
            // InternalRosParser.g:72:3: ()
            // InternalRosParser.g:73:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getPackageSetAccess().getPackageSetAction_0(),
                                current);


            }

            // InternalRosParser.g:79:3: ( (lv_package_1_0= rulePackage_Impl ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==Node||LA1_0==RULE_ID||LA1_0==RULE_ROS_CONVENTION_A) ) {
                    alt1=1;
                }


                switch (alt1) {
                case 1 :
                    // InternalRosParser.g:80:4: (lv_package_1_0= rulePackage_Impl )
                    {
                    // InternalRosParser.g:80:4: (lv_package_1_0= rulePackage_Impl )
                    // InternalRosParser.g:81:5: lv_package_1_0= rulePackage_Impl
                    {

                                        newCompositeNode(grammarAccess.getPackageSetAccess().getPackagePackage_ImplParserRuleCall_1_0());

                    pushFollow(FOLLOW_3);
                    lv_package_1_0=rulePackage_Impl();

                    state._fsp--;


                                        if (current==null) {
                                            current = createModelElementForParent(grammarAccess.getPackageSetRule());
                                        }
                                        add(
                                            current,
                                            "package",
                                            lv_package_1_0,
                                            "de.fraunhofer.ipa.ros.Ros.Package_Impl");
                                        afterParserOrEnumRuleCall();


                    }


                    }
                    break;

                default :
                    break loop1;
                }
            } while (true);


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePackageSet"


    // $ANTLR start "entryRulePackage_Impl"
    // InternalRosParser.g:102:1: entryRulePackage_Impl returns [EObject current=null] : iv_rulePackage_Impl= rulePackage_Impl EOF ;
    public final EObject entryRulePackage_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackage_Impl = null;


        try {
            // InternalRosParser.g:102:53: (iv_rulePackage_Impl= rulePackage_Impl EOF )
            // InternalRosParser.g:103:2: iv_rulePackage_Impl= rulePackage_Impl EOF
            {
             newCompositeNode(grammarAccess.getPackage_ImplRule());
            pushFollow(FOLLOW_1);
            iv_rulePackage_Impl=rulePackage_Impl();

            state._fsp--;

             current =iv_rulePackage_Impl;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePackage_Impl"


    // $ANTLR start "rulePackage_Impl"
    // InternalRosParser.g:109:1: rulePackage_Impl returns [EObject current=null] : ( () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) ) )? (otherlv_6= Specs this_BEGIN_7= RULE_BEGIN ( (lv_spec_8_0= ruleSpecBase ) )* this_END_9= RULE_END )? (otherlv_10= Dependencies otherlv_11= LeftSquareBracket ( (lv_dependency_12_0= ruleDependency ) ) (otherlv_13= Comma ( (lv_dependency_14_0= ruleDependency ) ) )* otherlv_15= RightSquareBracket )? this_END_16= RULE_END ) ;
    public final EObject rulePackage_Impl() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token this_BEGIN_7=null;
        Token this_END_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token this_END_16=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_fromGitRepo_5_0 = null;

        EObject lv_spec_8_0 = null;

        EObject lv_dependency_12_0 = null;

        EObject lv_dependency_14_0 = null;



            enterRule();

        try {
            // InternalRosParser.g:115:2: ( ( () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) ) )? (otherlv_6= Specs this_BEGIN_7= RULE_BEGIN ( (lv_spec_8_0= ruleSpecBase ) )* this_END_9= RULE_END )? (otherlv_10= Dependencies otherlv_11= LeftSquareBracket ( (lv_dependency_12_0= ruleDependency ) ) (otherlv_13= Comma ( (lv_dependency_14_0= ruleDependency ) ) )* otherlv_15= RightSquareBracket )? this_END_16= RULE_END ) )
            // InternalRosParser.g:116:2: ( () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) ) )? (otherlv_6= Specs this_BEGIN_7= RULE_BEGIN ( (lv_spec_8_0= ruleSpecBase ) )* this_END_9= RULE_END )? (otherlv_10= Dependencies otherlv_11= LeftSquareBracket ( (lv_dependency_12_0= ruleDependency ) ) (otherlv_13= Comma ( (lv_dependency_14_0= ruleDependency ) ) )* otherlv_15= RightSquareBracket )? this_END_16= RULE_END )
            {
            // InternalRosParser.g:116:2: ( () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) ) )? (otherlv_6= Specs this_BEGIN_7= RULE_BEGIN ( (lv_spec_8_0= ruleSpecBase ) )* this_END_9= RULE_END )? (otherlv_10= Dependencies otherlv_11= LeftSquareBracket ( (lv_dependency_12_0= ruleDependency ) ) (otherlv_13= Comma ( (lv_dependency_14_0= ruleDependency ) ) )* otherlv_15= RightSquareBracket )? this_END_16= RULE_END )
            // InternalRosParser.g:117:3: () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) ) )? (otherlv_6= Specs this_BEGIN_7= RULE_BEGIN ( (lv_spec_8_0= ruleSpecBase ) )* this_END_9= RULE_END )? (otherlv_10= Dependencies otherlv_11= LeftSquareBracket ( (lv_dependency_12_0= ruleDependency ) ) (otherlv_13= Comma ( (lv_dependency_14_0= ruleDependency ) ) )* otherlv_15= RightSquareBracket )? this_END_16= RULE_END
            {
            // InternalRosParser.g:117:3: ()
            // InternalRosParser.g:118:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getPackage_ImplAccess().getPackageAction_0(),
                                current);


            }

            // InternalRosParser.g:124:3: ( (lv_name_1_0= ruleRosNames ) )
            // InternalRosParser.g:125:4: (lv_name_1_0= ruleRosNames )
            {
            // InternalRosParser.g:125:4: (lv_name_1_0= ruleRosNames )
            // InternalRosParser.g:126:5: lv_name_1_0= ruleRosNames
            {

                                newCompositeNode(grammarAccess.getPackage_ImplAccess().getNameRosNamesParserRuleCall_1_0());

            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleRosNames();

            state._fsp--;


                                if (current==null) {
                                    current = createModelElementForParent(grammarAccess.getPackage_ImplRule());
                                }
                                set(
                                    current,
                                    "name",
                                    lv_name_1_0,
                                    "de.fraunhofer.ipa.ros.Basics.RosNames");
                                afterParserOrEnumRuleCall();


            }


            }

            otherlv_2=(Token)match(input,Colon,FOLLOW_5);

                        newLeafNode(otherlv_2, grammarAccess.getPackage_ImplAccess().getColonKeyword_2());

            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_6);

                        newLeafNode(this_BEGIN_3, grammarAccess.getPackage_ImplAccess().getBEGINTerminalRuleCall_3());

            // InternalRosParser.g:151:3: (otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==FromGitRepo) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalRosParser.g:152:4: otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) )
                    {
                    otherlv_4=(Token)match(input,FromGitRepo,FOLLOW_7);

                                    newLeafNode(otherlv_4, grammarAccess.getPackage_ImplAccess().getFromGitRepoKeyword_4_0());

                    // InternalRosParser.g:156:4: ( (lv_fromGitRepo_5_0= ruleEString ) )
                    // InternalRosParser.g:157:5: (lv_fromGitRepo_5_0= ruleEString )
                    {
                    // InternalRosParser.g:157:5: (lv_fromGitRepo_5_0= ruleEString )
                    // InternalRosParser.g:158:6: lv_fromGitRepo_5_0= ruleEString
                    {

                                            newCompositeNode(grammarAccess.getPackage_ImplAccess().getFromGitRepoEStringParserRuleCall_4_1_0());

                    pushFollow(FOLLOW_8);
                    lv_fromGitRepo_5_0=ruleEString();

                    state._fsp--;


                                            if (current==null) {
                                                current = createModelElementForParent(grammarAccess.getPackage_ImplRule());
                                            }
                                            set(
                                                current,
                                                "fromGitRepo",
                                                lv_fromGitRepo_5_0,
                                                "de.fraunhofer.ipa.ros.Basics.EString");
                                            afterParserOrEnumRuleCall();


                    }


                    }


                    }
                    break;

            }

            // InternalRosParser.g:176:3: (otherlv_6= Specs this_BEGIN_7= RULE_BEGIN ( (lv_spec_8_0= ruleSpecBase ) )* this_END_9= RULE_END )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==Specs) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalRosParser.g:177:4: otherlv_6= Specs this_BEGIN_7= RULE_BEGIN ( (lv_spec_8_0= ruleSpecBase ) )* this_END_9= RULE_END
                    {
                    otherlv_6=(Token)match(input,Specs,FOLLOW_5);

                                    newLeafNode(otherlv_6, grammarAccess.getPackage_ImplAccess().getSpecsKeyword_5_0());

                    this_BEGIN_7=(Token)match(input,RULE_BEGIN,FOLLOW_9);

                                    newLeafNode(this_BEGIN_7, grammarAccess.getPackage_ImplAccess().getBEGINTerminalRuleCall_5_1());

                    // InternalRosParser.g:185:4: ( (lv_spec_8_0= ruleSpecBase ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==HyphenMinus) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                        case 1 :
                            // InternalRosParser.g:186:5: (lv_spec_8_0= ruleSpecBase )
                            {
                            // InternalRosParser.g:186:5: (lv_spec_8_0= ruleSpecBase )
                            // InternalRosParser.g:187:6: lv_spec_8_0= ruleSpecBase
                            {

                                                    newCompositeNode(grammarAccess.getPackage_ImplAccess().getSpecSpecBaseParserRuleCall_5_2_0());

                            pushFollow(FOLLOW_9);
                            lv_spec_8_0=ruleSpecBase();

                            state._fsp--;


                                                    if (current==null) {
                                                        current = createModelElementForParent(grammarAccess.getPackage_ImplRule());
                                                    }
                                                    add(
                                                        current,
                                                        "spec",
                                                        lv_spec_8_0,
                                                        "de.fraunhofer.ipa.ros.Ros.SpecBase");
                                                    afterParserOrEnumRuleCall();


                            }


                            }
                            break;

                        default :
                            break loop3;
                        }
                    } while (true);

                    this_END_9=(Token)match(input,RULE_END,FOLLOW_10);

                                    newLeafNode(this_END_9, grammarAccess.getPackage_ImplAccess().getENDTerminalRuleCall_5_3());


                    }
                    break;

            }

            // InternalRosParser.g:209:3: (otherlv_10= Dependencies otherlv_11= LeftSquareBracket ( (lv_dependency_12_0= ruleDependency ) ) (otherlv_13= Comma ( (lv_dependency_14_0= ruleDependency ) ) )* otherlv_15= RightSquareBracket )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==Dependencies) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalRosParser.g:210:4: otherlv_10= Dependencies otherlv_11= LeftSquareBracket ( (lv_dependency_12_0= ruleDependency ) ) (otherlv_13= Comma ( (lv_dependency_14_0= ruleDependency ) ) )* otherlv_15= RightSquareBracket
                    {
                    otherlv_10=(Token)match(input,Dependencies,FOLLOW_11);

                                    newLeafNode(otherlv_10, grammarAccess.getPackage_ImplAccess().getDependenciesKeyword_6_0());

                    otherlv_11=(Token)match(input,LeftSquareBracket,FOLLOW_12);

                                    newLeafNode(otherlv_11, grammarAccess.getPackage_ImplAccess().getLeftSquareBracketKeyword_6_1());

                    // InternalRosParser.g:218:4: ( (lv_dependency_12_0= ruleDependency ) )
                    // InternalRosParser.g:219:5: (lv_dependency_12_0= ruleDependency )
                    {
                    // InternalRosParser.g:219:5: (lv_dependency_12_0= ruleDependency )
                    // InternalRosParser.g:220:6: lv_dependency_12_0= ruleDependency
                    {

                                            newCompositeNode(grammarAccess.getPackage_ImplAccess().getDependencyDependencyParserRuleCall_6_2_0());

                    pushFollow(FOLLOW_13);
                    lv_dependency_12_0=ruleDependency();

                    state._fsp--;


                                            if (current==null) {
                                                current = createModelElementForParent(grammarAccess.getPackage_ImplRule());
                                            }
                                            add(
                                                current,
                                                "dependency",
                                                lv_dependency_12_0,
                                                "de.fraunhofer.ipa.ros.Ros.Dependency");
                                            afterParserOrEnumRuleCall();


                    }


                    }

                    // InternalRosParser.g:237:4: (otherlv_13= Comma ( (lv_dependency_14_0= ruleDependency ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==Comma) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                        case 1 :
                            // InternalRosParser.g:238:5: otherlv_13= Comma ( (lv_dependency_14_0= ruleDependency ) )
                            {
                            otherlv_13=(Token)match(input,Comma,FOLLOW_12);

                                                newLeafNode(otherlv_13, grammarAccess.getPackage_ImplAccess().getCommaKeyword_6_3_0());

                            // InternalRosParser.g:242:5: ( (lv_dependency_14_0= ruleDependency ) )
                            // InternalRosParser.g:243:6: (lv_dependency_14_0= ruleDependency )
                            {
                            // InternalRosParser.g:243:6: (lv_dependency_14_0= ruleDependency )
                            // InternalRosParser.g:244:7: lv_dependency_14_0= ruleDependency
                            {

                                                        newCompositeNode(grammarAccess.getPackage_ImplAccess().getDependencyDependencyParserRuleCall_6_3_1_0());

                            pushFollow(FOLLOW_13);
                            lv_dependency_14_0=ruleDependency();

                            state._fsp--;


                                                        if (current==null) {
                                                            current = createModelElementForParent(grammarAccess.getPackage_ImplRule());
                                                        }
                                                        add(
                                                            current,
                                                            "dependency",
                                                            lv_dependency_14_0,
                                                            "de.fraunhofer.ipa.ros.Ros.Dependency");
                                                        afterParserOrEnumRuleCall();


                            }


                            }


                            }
                            break;

                        default :
                            break loop5;
                        }
                    } while (true);

                    otherlv_15=(Token)match(input,RightSquareBracket,FOLLOW_14);

                                    newLeafNode(otherlv_15, grammarAccess.getPackage_ImplAccess().getRightSquareBracketKeyword_6_4());


                    }
                    break;

            }

            this_END_16=(Token)match(input,RULE_END,FOLLOW_2);

                        newLeafNode(this_END_16, grammarAccess.getPackage_ImplAccess().getENDTerminalRuleCall_7());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePackage_Impl"


    // $ANTLR start "entryRuleNode"
    // InternalRosParser.g:275:1: entryRuleNode returns [EObject current=null] : iv_ruleNode= ruleNode EOF ;
    public final EObject entryRuleNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNode = null;


        try {
            // InternalRosParser.g:275:45: (iv_ruleNode= ruleNode EOF )
            // InternalRosParser.g:276:2: iv_ruleNode= ruleNode EOF
            {
             newCompositeNode(grammarAccess.getNodeRule());
            pushFollow(FOLLOW_1);
            iv_ruleNode=ruleNode();

            state._fsp--;

             current =iv_ruleNode;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNode"


    // $ANTLR start "ruleNode"
    // InternalRosParser.g:282:1: ruleNode returns [EObject current=null] : (otherlv_0= Node_1 ( (lv_name_1_0= ruleRosNames ) ) ( (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END ) | (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END ) | (otherlv_10= Serviceserver this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END ) | (otherlv_14= Serviceclient this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END ) | (otherlv_18= Actionserver this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END ) | (otherlv_22= Actionclient this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END ) | (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END ) )* ) ;
    public final EObject ruleNode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token this_BEGIN_3=null;
        Token this_END_5=null;
        Token otherlv_6=null;
        Token this_BEGIN_7=null;
        Token this_END_9=null;
        Token otherlv_10=null;
        Token this_BEGIN_11=null;
        Token this_END_13=null;
        Token otherlv_14=null;
        Token this_BEGIN_15=null;
        Token this_END_17=null;
        Token otherlv_18=null;
        Token this_BEGIN_19=null;
        Token this_END_21=null;
        Token otherlv_22=null;
        Token this_BEGIN_23=null;
        Token this_END_25=null;
        Token otherlv_26=null;
        Token this_BEGIN_27=null;
        Token this_END_29=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_publisher_4_0 = null;

        EObject lv_subscriber_8_0 = null;

        EObject lv_serviceserver_12_0 = null;

        EObject lv_serviceclient_16_0 = null;

        EObject lv_actionserver_20_0 = null;

        EObject lv_actionclient_24_0 = null;

        EObject lv_parameter_28_0 = null;



            enterRule();

        try {
            // InternalRosParser.g:288:2: ( (otherlv_0= Node_1 ( (lv_name_1_0= ruleRosNames ) ) ( (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END ) | (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END ) | (otherlv_10= Serviceserver this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END ) | (otherlv_14= Serviceclient this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END ) | (otherlv_18= Actionserver this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END ) | (otherlv_22= Actionclient this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END ) | (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END ) )* ) )
            // InternalRosParser.g:289:2: (otherlv_0= Node_1 ( (lv_name_1_0= ruleRosNames ) ) ( (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END ) | (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END ) | (otherlv_10= Serviceserver this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END ) | (otherlv_14= Serviceclient this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END ) | (otherlv_18= Actionserver this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END ) | (otherlv_22= Actionclient this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END ) | (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END ) )* )
            {
            // InternalRosParser.g:289:2: (otherlv_0= Node_1 ( (lv_name_1_0= ruleRosNames ) ) ( (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END ) | (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END ) | (otherlv_10= Serviceserver this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END ) | (otherlv_14= Serviceclient this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END ) | (otherlv_18= Actionserver this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END ) | (otherlv_22= Actionclient this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END ) | (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END ) )* )
            // InternalRosParser.g:290:3: otherlv_0= Node_1 ( (lv_name_1_0= ruleRosNames ) ) ( (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END ) | (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END ) | (otherlv_10= Serviceserver this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END ) | (otherlv_14= Serviceclient this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END ) | (otherlv_18= Actionserver this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END ) | (otherlv_22= Actionclient this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END ) | (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END ) )*
            {
            otherlv_0=(Token)match(input,Node_1,FOLLOW_15);

                        newLeafNode(otherlv_0, grammarAccess.getNodeAccess().getNodeKeyword_0());

            // InternalRosParser.g:294:3: ( (lv_name_1_0= ruleRosNames ) )
            // InternalRosParser.g:295:4: (lv_name_1_0= ruleRosNames )
            {
            // InternalRosParser.g:295:4: (lv_name_1_0= ruleRosNames )
            // InternalRosParser.g:296:5: lv_name_1_0= ruleRosNames
            {

                                newCompositeNode(grammarAccess.getNodeAccess().getNameRosNamesParserRuleCall_1_0());

            pushFollow(FOLLOW_16);
            lv_name_1_0=ruleRosNames();

            state._fsp--;


                                if (current==null) {
                                    current = createModelElementForParent(grammarAccess.getNodeRule());
                                }
                                set(
                                    current,
                                    "name",
                                    lv_name_1_0,
                                    "de.fraunhofer.ipa.ros.Basics.RosNames");
                                afterParserOrEnumRuleCall();


            }


            }

            // InternalRosParser.g:313:3: ( (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END ) | (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END ) | (otherlv_10= Serviceserver this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END ) | (otherlv_14= Serviceclient this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END ) | (otherlv_18= Actionserver this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END ) | (otherlv_22= Actionclient this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END ) | (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END ) )*
            loop14:
            do {
                int alt14=8;
                switch ( input.LA(1) ) {
                case Publishers:
                    {
                    alt14=1;
                    }
                    break;
                case Subscribers:
                    {
                    alt14=2;
                    }
                    break;
                case Serviceserver:
                    {
                    alt14=3;
                    }
                    break;
                case Serviceclient:
                    {
                    alt14=4;
                    }
                    break;
                case Actionserver:
                    {
                    alt14=5;
                    }
                    break;
                case Actionclient:
                    {
                    alt14=6;
                    }
                    break;
                case Parameters:
                    {
                    alt14=7;
                    }
                    break;

                }

                switch (alt14) {
                case 1 :
                    // InternalRosParser.g:314:4: (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END )
                    {
                    // InternalRosParser.g:314:4: (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END )
                    // InternalRosParser.g:315:5: otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END
                    {
                    otherlv_2=(Token)match(input,Publishers,FOLLOW_5);

                                        newLeafNode(otherlv_2, grammarAccess.getNodeAccess().getPublishersKeyword_2_0_0());

                    this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_17);

                                        newLeafNode(this_BEGIN_3, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_0_1());

                    // InternalRosParser.g:323:5: ( (lv_publisher_4_0= rulePublisher ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>=RULE_ID && LA7_0<=RULE_STRING)) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                        case 1 :
                            // InternalRosParser.g:324:6: (lv_publisher_4_0= rulePublisher )
                            {
                            // InternalRosParser.g:324:6: (lv_publisher_4_0= rulePublisher )
                            // InternalRosParser.g:325:7: lv_publisher_4_0= rulePublisher
                            {

                                                        newCompositeNode(grammarAccess.getNodeAccess().getPublisherPublisherParserRuleCall_2_0_2_0());

                            pushFollow(FOLLOW_17);
                            lv_publisher_4_0=rulePublisher();

                            state._fsp--;


                                                        if (current==null) {
                                                            current = createModelElementForParent(grammarAccess.getNodeRule());
                                                        }
                                                        add(
                                                            current,
                                                            "publisher",
                                                            lv_publisher_4_0,
                                                            "de.fraunhofer.ipa.ros.Ros.Publisher");
                                                        afterParserOrEnumRuleCall();


                            }


                            }
                            break;

                        default :
                            break loop7;
                        }
                    } while (true);

                    this_END_5=(Token)match(input,RULE_END,FOLLOW_16);

                                        newLeafNode(this_END_5, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_0_3());


                    }


                    }
                    break;
                case 2 :
                    // InternalRosParser.g:348:4: (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END )
                    {
                    // InternalRosParser.g:348:4: (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END )
                    // InternalRosParser.g:349:5: otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END
                    {
                    otherlv_6=(Token)match(input,Subscribers,FOLLOW_5);

                                        newLeafNode(otherlv_6, grammarAccess.getNodeAccess().getSubscribersKeyword_2_1_0());

                    this_BEGIN_7=(Token)match(input,RULE_BEGIN,FOLLOW_17);

                                        newLeafNode(this_BEGIN_7, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_1_1());

                    // InternalRosParser.g:357:5: ( (lv_subscriber_8_0= ruleSubscriber ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0>=RULE_ID && LA8_0<=RULE_STRING)) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                        case 1 :
                            // InternalRosParser.g:358:6: (lv_subscriber_8_0= ruleSubscriber )
                            {
                            // InternalRosParser.g:358:6: (lv_subscriber_8_0= ruleSubscriber )
                            // InternalRosParser.g:359:7: lv_subscriber_8_0= ruleSubscriber
                            {

                                                        newCompositeNode(grammarAccess.getNodeAccess().getSubscriberSubscriberParserRuleCall_2_1_2_0());

                            pushFollow(FOLLOW_17);
                            lv_subscriber_8_0=ruleSubscriber();

                            state._fsp--;


                                                        if (current==null) {
                                                            current = createModelElementForParent(grammarAccess.getNodeRule());
                                                        }
                                                        add(
                                                            current,
                                                            "subscriber",
                                                            lv_subscriber_8_0,
                                                            "de.fraunhofer.ipa.ros.Ros.Subscriber");
                                                        afterParserOrEnumRuleCall();


                            }


                            }
                            break;

                        default :
                            break loop8;
                        }
                    } while (true);

                    this_END_9=(Token)match(input,RULE_END,FOLLOW_16);

                                        newLeafNode(this_END_9, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_1_3());


                    }


                    }
                    break;
                case 3 :
                    // InternalRosParser.g:382:4: (otherlv_10= Serviceserver this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END )
                    {
                    // InternalRosParser.g:382:4: (otherlv_10= Serviceserver this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END )
                    // InternalRosParser.g:383:5: otherlv_10= Serviceserver this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END
                    {
                    otherlv_10=(Token)match(input,Serviceserver,FOLLOW_5);

                                        newLeafNode(otherlv_10, grammarAccess.getNodeAccess().getServiceserverKeyword_2_2_0());

                    this_BEGIN_11=(Token)match(input,RULE_BEGIN,FOLLOW_17);

                                        newLeafNode(this_BEGIN_11, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_2_1());

                    // InternalRosParser.g:391:5: ( (lv_serviceserver_12_0= ruleServiceServer ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0>=RULE_ID && LA9_0<=RULE_STRING)) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                        case 1 :
                            // InternalRosParser.g:392:6: (lv_serviceserver_12_0= ruleServiceServer )
                            {
                            // InternalRosParser.g:392:6: (lv_serviceserver_12_0= ruleServiceServer )
                            // InternalRosParser.g:393:7: lv_serviceserver_12_0= ruleServiceServer
                            {

                                                        newCompositeNode(grammarAccess.getNodeAccess().getServiceserverServiceServerParserRuleCall_2_2_2_0());

                            pushFollow(FOLLOW_17);
                            lv_serviceserver_12_0=ruleServiceServer();

                            state._fsp--;


                                                        if (current==null) {
                                                            current = createModelElementForParent(grammarAccess.getNodeRule());
                                                        }
                                                        add(
                                                            current,
                                                            "serviceserver",
                                                            lv_serviceserver_12_0,
                                                            "de.fraunhofer.ipa.ros.Ros.ServiceServer");
                                                        afterParserOrEnumRuleCall();


                            }


                            }
                            break;

                        default :
                            break loop9;
                        }
                    } while (true);

                    this_END_13=(Token)match(input,RULE_END,FOLLOW_16);

                                        newLeafNode(this_END_13, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_2_3());


                    }


                    }
                    break;
                case 4 :
                    // InternalRosParser.g:416:4: (otherlv_14= Serviceclient this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END )
                    {
                    // InternalRosParser.g:416:4: (otherlv_14= Serviceclient this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END )
                    // InternalRosParser.g:417:5: otherlv_14= Serviceclient this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END
                    {
                    otherlv_14=(Token)match(input,Serviceclient,FOLLOW_5);

                                        newLeafNode(otherlv_14, grammarAccess.getNodeAccess().getServiceclientKeyword_2_3_0());

                    this_BEGIN_15=(Token)match(input,RULE_BEGIN,FOLLOW_17);

                                        newLeafNode(this_BEGIN_15, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_3_1());

                    // InternalRosParser.g:425:5: ( (lv_serviceclient_16_0= ruleServiceClient ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( ((LA10_0>=RULE_ID && LA10_0<=RULE_STRING)) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                        case 1 :
                            // InternalRosParser.g:426:6: (lv_serviceclient_16_0= ruleServiceClient )
                            {
                            // InternalRosParser.g:426:6: (lv_serviceclient_16_0= ruleServiceClient )
                            // InternalRosParser.g:427:7: lv_serviceclient_16_0= ruleServiceClient
                            {

                                                        newCompositeNode(grammarAccess.getNodeAccess().getServiceclientServiceClientParserRuleCall_2_3_2_0());

                            pushFollow(FOLLOW_17);
                            lv_serviceclient_16_0=ruleServiceClient();

                            state._fsp--;


                                                        if (current==null) {
                                                            current = createModelElementForParent(grammarAccess.getNodeRule());
                                                        }
                                                        add(
                                                            current,
                                                            "serviceclient",
                                                            lv_serviceclient_16_0,
                                                            "de.fraunhofer.ipa.ros.Ros.ServiceClient");
                                                        afterParserOrEnumRuleCall();


                            }


                            }
                            break;

                        default :
                            break loop10;
                        }
                    } while (true);

                    this_END_17=(Token)match(input,RULE_END,FOLLOW_16);

                                        newLeafNode(this_END_17, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_3_3());


                    }


                    }
                    break;
                case 5 :
                    // InternalRosParser.g:450:4: (otherlv_18= Actionserver this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END )
                    {
                    // InternalRosParser.g:450:4: (otherlv_18= Actionserver this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END )
                    // InternalRosParser.g:451:5: otherlv_18= Actionserver this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END
                    {
                    otherlv_18=(Token)match(input,Actionserver,FOLLOW_5);

                                        newLeafNode(otherlv_18, grammarAccess.getNodeAccess().getActionserverKeyword_2_4_0());

                    this_BEGIN_19=(Token)match(input,RULE_BEGIN,FOLLOW_17);

                                        newLeafNode(this_BEGIN_19, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_4_1());

                    // InternalRosParser.g:459:5: ( (lv_actionserver_20_0= ruleActionServer ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( ((LA11_0>=RULE_ID && LA11_0<=RULE_STRING)) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                        case 1 :
                            // InternalRosParser.g:460:6: (lv_actionserver_20_0= ruleActionServer )
                            {
                            // InternalRosParser.g:460:6: (lv_actionserver_20_0= ruleActionServer )
                            // InternalRosParser.g:461:7: lv_actionserver_20_0= ruleActionServer
                            {

                                                        newCompositeNode(grammarAccess.getNodeAccess().getActionserverActionServerParserRuleCall_2_4_2_0());

                            pushFollow(FOLLOW_17);
                            lv_actionserver_20_0=ruleActionServer();

                            state._fsp--;


                                                        if (current==null) {
                                                            current = createModelElementForParent(grammarAccess.getNodeRule());
                                                        }
                                                        add(
                                                            current,
                                                            "actionserver",
                                                            lv_actionserver_20_0,
                                                            "de.fraunhofer.ipa.ros.Ros.ActionServer");
                                                        afterParserOrEnumRuleCall();


                            }


                            }
                            break;

                        default :
                            break loop11;
                        }
                    } while (true);

                    this_END_21=(Token)match(input,RULE_END,FOLLOW_16);

                                        newLeafNode(this_END_21, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_4_3());


                    }


                    }
                    break;
                case 6 :
                    // InternalRosParser.g:484:4: (otherlv_22= Actionclient this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END )
                    {
                    // InternalRosParser.g:484:4: (otherlv_22= Actionclient this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END )
                    // InternalRosParser.g:485:5: otherlv_22= Actionclient this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END
                    {
                    otherlv_22=(Token)match(input,Actionclient,FOLLOW_5);

                                        newLeafNode(otherlv_22, grammarAccess.getNodeAccess().getActionclientKeyword_2_5_0());

                    this_BEGIN_23=(Token)match(input,RULE_BEGIN,FOLLOW_17);

                                        newLeafNode(this_BEGIN_23, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_5_1());

                    // InternalRosParser.g:493:5: ( (lv_actionclient_24_0= ruleActionClient ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0>=RULE_ID && LA12_0<=RULE_STRING)) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                        case 1 :
                            // InternalRosParser.g:494:6: (lv_actionclient_24_0= ruleActionClient )
                            {
                            // InternalRosParser.g:494:6: (lv_actionclient_24_0= ruleActionClient )
                            // InternalRosParser.g:495:7: lv_actionclient_24_0= ruleActionClient
                            {

                                                        newCompositeNode(grammarAccess.getNodeAccess().getActionclientActionClientParserRuleCall_2_5_2_0());

                            pushFollow(FOLLOW_17);
                            lv_actionclient_24_0=ruleActionClient();

                            state._fsp--;


                                                        if (current==null) {
                                                            current = createModelElementForParent(grammarAccess.getNodeRule());
                                                        }
                                                        add(
                                                            current,
                                                            "actionclient",
                                                            lv_actionclient_24_0,
                                                            "de.fraunhofer.ipa.ros.Ros.ActionClient");
                                                        afterParserOrEnumRuleCall();


                            }


                            }
                            break;

                        default :
                            break loop12;
                        }
                    } while (true);

                    this_END_25=(Token)match(input,RULE_END,FOLLOW_16);

                                        newLeafNode(this_END_25, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_5_3());


                    }


                    }
                    break;
                case 7 :
                    // InternalRosParser.g:518:4: (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END )
                    {
                    // InternalRosParser.g:518:4: (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END )
                    // InternalRosParser.g:519:5: otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END
                    {
                    otherlv_26=(Token)match(input,Parameters,FOLLOW_5);

                                        newLeafNode(otherlv_26, grammarAccess.getNodeAccess().getParametersKeyword_2_6_0());

                    this_BEGIN_27=(Token)match(input,RULE_BEGIN,FOLLOW_17);

                                        newLeafNode(this_BEGIN_27, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_6_1());

                    // InternalRosParser.g:527:5: ( (lv_parameter_28_0= ruleParameter ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( ((LA13_0>=RULE_ID && LA13_0<=RULE_STRING)) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                        case 1 :
                            // InternalRosParser.g:528:6: (lv_parameter_28_0= ruleParameter )
                            {
                            // InternalRosParser.g:528:6: (lv_parameter_28_0= ruleParameter )
                            // InternalRosParser.g:529:7: lv_parameter_28_0= ruleParameter
                            {

                                                        newCompositeNode(grammarAccess.getNodeAccess().getParameterParameterParserRuleCall_2_6_2_0());

                            pushFollow(FOLLOW_17);
                            lv_parameter_28_0=ruleParameter();

                            state._fsp--;


                                                        if (current==null) {
                                                            current = createModelElementForParent(grammarAccess.getNodeRule());
                                                        }
                                                        add(
                                                            current,
                                                            "parameter",
                                                            lv_parameter_28_0,
                                                            "de.fraunhofer.ipa.ros.Basics.Parameter");
                                                        afterParserOrEnumRuleCall();


                            }


                            }
                            break;

                        default :
                            break loop13;
                        }
                    } while (true);

                    this_END_29=(Token)match(input,RULE_END,FOLLOW_16);

                                        newLeafNode(this_END_29, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_6_3());


                    }


                    }
                    break;

                default :
                    break loop14;
                }
            } while (true);


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNode"


    // $ANTLR start "entryRuleSpecBase"
    // InternalRosParser.g:556:1: entryRuleSpecBase returns [EObject current=null] : iv_ruleSpecBase= ruleSpecBase EOF ;
    public final EObject entryRuleSpecBase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecBase = null;


        try {
            // InternalRosParser.g:556:49: (iv_ruleSpecBase= ruleSpecBase EOF )
            // InternalRosParser.g:557:2: iv_ruleSpecBase= ruleSpecBase EOF
            {
             newCompositeNode(grammarAccess.getSpecBaseRule());
            pushFollow(FOLLOW_1);
            iv_ruleSpecBase=ruleSpecBase();

            state._fsp--;

             current =iv_ruleSpecBase;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSpecBase"


    // $ANTLR start "ruleSpecBase"
    // InternalRosParser.g:563:1: ruleSpecBase returns [EObject current=null] : (this_TopicSpec_0= ruleTopicSpec | this_ServiceSpec_1= ruleServiceSpec | this_ActionSpec_2= ruleActionSpec ) ;
    public final EObject ruleSpecBase() throws RecognitionException {
        EObject current = null;

        EObject this_TopicSpec_0 = null;

        EObject this_ServiceSpec_1 = null;

        EObject this_ActionSpec_2 = null;



            enterRule();

        try {
            // InternalRosParser.g:569:2: ( (this_TopicSpec_0= ruleTopicSpec | this_ServiceSpec_1= ruleServiceSpec | this_ActionSpec_2= ruleActionSpec ) )
            // InternalRosParser.g:570:2: (this_TopicSpec_0= ruleTopicSpec | this_ServiceSpec_1= ruleServiceSpec | this_ActionSpec_2= ruleActionSpec )
            {
            // InternalRosParser.g:570:2: (this_TopicSpec_0= ruleTopicSpec | this_ServiceSpec_1= ruleServiceSpec | this_ActionSpec_2= ruleActionSpec )
            int alt15=3;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==HyphenMinus) ) {
                switch ( input.LA(2) ) {
                case Srv:
                    {
                    alt15=2;
                    }
                    break;
                case Action_1:
                    {
                    alt15=3;
                    }
                    break;
                case Msg:
                    {
                    alt15=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalRosParser.g:571:3: this_TopicSpec_0= ruleTopicSpec
                    {

                                newCompositeNode(grammarAccess.getSpecBaseAccess().getTopicSpecParserRuleCall_0());

                    pushFollow(FOLLOW_2);
                    this_TopicSpec_0=ruleTopicSpec();

                    state._fsp--;


                                current = this_TopicSpec_0;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 2 :
                    // InternalRosParser.g:580:3: this_ServiceSpec_1= ruleServiceSpec
                    {

                                newCompositeNode(grammarAccess.getSpecBaseAccess().getServiceSpecParserRuleCall_1());

                    pushFollow(FOLLOW_2);
                    this_ServiceSpec_1=ruleServiceSpec();

                    state._fsp--;


                                current = this_ServiceSpec_1;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 3 :
                    // InternalRosParser.g:589:3: this_ActionSpec_2= ruleActionSpec
                    {

                                newCompositeNode(grammarAccess.getSpecBaseAccess().getActionSpecParserRuleCall_2());

                    pushFollow(FOLLOW_2);
                    this_ActionSpec_2=ruleActionSpec();

                    state._fsp--;


                                current = this_ActionSpec_2;
                                afterParserOrEnumRuleCall();


                    }
                    break;

            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSpecBase"


    // $ANTLR start "entryRuleTopicSpec"
    // InternalRosParser.g:601:1: entryRuleTopicSpec returns [EObject current=null] : iv_ruleTopicSpec= ruleTopicSpec EOF ;
    public final EObject entryRuleTopicSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTopicSpec = null;


        try {
            // InternalRosParser.g:601:50: (iv_ruleTopicSpec= ruleTopicSpec EOF )
            // InternalRosParser.g:602:2: iv_ruleTopicSpec= ruleTopicSpec EOF
            {
             newCompositeNode(grammarAccess.getTopicSpecRule());
            pushFollow(FOLLOW_1);
            iv_ruleTopicSpec=ruleTopicSpec();

            state._fsp--;

             current =iv_ruleTopicSpec;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTopicSpec"


    // $ANTLR start "ruleTopicSpec"
    // InternalRosParser.g:608:1: ruleTopicSpec returns [EObject current=null] : ( () rulePreListElement otherlv_2= Msg ( ( (lv_name_3_1= ruleEString | lv_name_3_2= Header | lv_name_3_3= String ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Message_1 (this_BEGIN_6= RULE_BEGIN ( (lv_message_7_0= ruleMessageDefinition ) ) this_END_8= RULE_END )? this_END_9= RULE_END ) ;
    public final EObject ruleTopicSpec() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_name_3_2=null;
        Token lv_name_3_3=null;
        Token this_BEGIN_4=null;
        Token otherlv_5=null;
        Token this_BEGIN_6=null;
        Token this_END_8=null;
        Token this_END_9=null;
        AntlrDatatypeRuleToken lv_name_3_1 = null;

        EObject lv_message_7_0 = null;



            enterRule();

        try {
            // InternalRosParser.g:614:2: ( ( () rulePreListElement otherlv_2= Msg ( ( (lv_name_3_1= ruleEString | lv_name_3_2= Header | lv_name_3_3= String ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Message_1 (this_BEGIN_6= RULE_BEGIN ( (lv_message_7_0= ruleMessageDefinition ) ) this_END_8= RULE_END )? this_END_9= RULE_END ) )
            // InternalRosParser.g:615:2: ( () rulePreListElement otherlv_2= Msg ( ( (lv_name_3_1= ruleEString | lv_name_3_2= Header | lv_name_3_3= String ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Message_1 (this_BEGIN_6= RULE_BEGIN ( (lv_message_7_0= ruleMessageDefinition ) ) this_END_8= RULE_END )? this_END_9= RULE_END )
            {
            // InternalRosParser.g:615:2: ( () rulePreListElement otherlv_2= Msg ( ( (lv_name_3_1= ruleEString | lv_name_3_2= Header | lv_name_3_3= String ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Message_1 (this_BEGIN_6= RULE_BEGIN ( (lv_message_7_0= ruleMessageDefinition ) ) this_END_8= RULE_END )? this_END_9= RULE_END )
            // InternalRosParser.g:616:3: () rulePreListElement otherlv_2= Msg ( ( (lv_name_3_1= ruleEString | lv_name_3_2= Header | lv_name_3_3= String ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Message_1 (this_BEGIN_6= RULE_BEGIN ( (lv_message_7_0= ruleMessageDefinition ) ) this_END_8= RULE_END )? this_END_9= RULE_END
            {
            // InternalRosParser.g:616:3: ()
            // InternalRosParser.g:617:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getTopicSpecAccess().getTopicSpecAction_0(),
                                current);


            }


                        newCompositeNode(grammarAccess.getTopicSpecAccess().getPreListElementParserRuleCall_1());

            pushFollow(FOLLOW_18);
            rulePreListElement();

            state._fsp--;


                        afterParserOrEnumRuleCall();

            otherlv_2=(Token)match(input,Msg,FOLLOW_19);

                        newLeafNode(otherlv_2, grammarAccess.getTopicSpecAccess().getMsgKeyword_2());

            // InternalRosParser.g:634:3: ( ( (lv_name_3_1= ruleEString | lv_name_3_2= Header | lv_name_3_3= String ) ) )
            // InternalRosParser.g:635:4: ( (lv_name_3_1= ruleEString | lv_name_3_2= Header | lv_name_3_3= String ) )
            {
            // InternalRosParser.g:635:4: ( (lv_name_3_1= ruleEString | lv_name_3_2= Header | lv_name_3_3= String ) )
            // InternalRosParser.g:636:5: (lv_name_3_1= ruleEString | lv_name_3_2= Header | lv_name_3_3= String )
            {
            // InternalRosParser.g:636:5: (lv_name_3_1= ruleEString | lv_name_3_2= Header | lv_name_3_3= String )
            int alt16=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case RULE_STRING:
                {
                alt16=1;
                }
                break;
            case Header:
                {
                alt16=2;
                }
                break;
            case String:
                {
                alt16=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalRosParser.g:637:6: lv_name_3_1= ruleEString
                    {

                                            newCompositeNode(grammarAccess.getTopicSpecAccess().getNameEStringParserRuleCall_3_0_0());

                    pushFollow(FOLLOW_5);
                    lv_name_3_1=ruleEString();

                    state._fsp--;


                                            if (current==null) {
                                                current = createModelElementForParent(grammarAccess.getTopicSpecRule());
                                            }
                                            set(
                                                current,
                                                "name",
                                                lv_name_3_1,
                                                "de.fraunhofer.ipa.ros.Basics.EString");
                                            afterParserOrEnumRuleCall();


                    }
                    break;
                case 2 :
                    // InternalRosParser.g:653:6: lv_name_3_2= Header
                    {
                    lv_name_3_2=(Token)match(input,Header,FOLLOW_5);

                                            newLeafNode(lv_name_3_2, grammarAccess.getTopicSpecAccess().getNameHeaderKeyword_3_0_1());


                                            if (current==null) {
                                                current = createModelElement(grammarAccess.getTopicSpecRule());
                                            }
                                            setWithLastConsumed(current, "name", lv_name_3_2, null);


                    }
                    break;
                case 3 :
                    // InternalRosParser.g:664:6: lv_name_3_3= String
                    {
                    lv_name_3_3=(Token)match(input,String,FOLLOW_5);

                                            newLeafNode(lv_name_3_3, grammarAccess.getTopicSpecAccess().getNameStringKeyword_3_0_2());


                                            if (current==null) {
                                                current = createModelElement(grammarAccess.getTopicSpecRule());
                                            }
                                            setWithLastConsumed(current, "name", lv_name_3_3, null);


                    }
                    break;

            }


            }


            }

            this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_20);

                        newLeafNode(this_BEGIN_4, grammarAccess.getTopicSpecAccess().getBEGINTerminalRuleCall_4());

            otherlv_5=(Token)match(input,Message_1,FOLLOW_21);

                        newLeafNode(otherlv_5, grammarAccess.getTopicSpecAccess().getMessageKeyword_5());

            // InternalRosParser.g:685:3: (this_BEGIN_6= RULE_BEGIN ( (lv_message_7_0= ruleMessageDefinition ) ) this_END_8= RULE_END )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_BEGIN) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalRosParser.g:686:4: this_BEGIN_6= RULE_BEGIN ( (lv_message_7_0= ruleMessageDefinition ) ) this_END_8= RULE_END
                    {
                    this_BEGIN_6=(Token)match(input,RULE_BEGIN,FOLLOW_22);

                                    newLeafNode(this_BEGIN_6, grammarAccess.getTopicSpecAccess().getBEGINTerminalRuleCall_6_0());

                    // InternalRosParser.g:690:4: ( (lv_message_7_0= ruleMessageDefinition ) )
                    // InternalRosParser.g:691:5: (lv_message_7_0= ruleMessageDefinition )
                    {
                    // InternalRosParser.g:691:5: (lv_message_7_0= ruleMessageDefinition )
                    // InternalRosParser.g:692:6: lv_message_7_0= ruleMessageDefinition
                    {

                                            newCompositeNode(grammarAccess.getTopicSpecAccess().getMessageMessageDefinitionParserRuleCall_6_1_0());

                    pushFollow(FOLLOW_14);
                    lv_message_7_0=ruleMessageDefinition();

                    state._fsp--;


                                            if (current==null) {
                                                current = createModelElementForParent(grammarAccess.getTopicSpecRule());
                                            }
                                            set(
                                                current,
                                                "message",
                                                lv_message_7_0,
                                                "de.fraunhofer.ipa.ros.Ros.MessageDefinition");
                                            afterParserOrEnumRuleCall();


                    }


                    }

                    this_END_8=(Token)match(input,RULE_END,FOLLOW_14);

                                    newLeafNode(this_END_8, grammarAccess.getTopicSpecAccess().getENDTerminalRuleCall_6_2());


                    }
                    break;

            }

            this_END_9=(Token)match(input,RULE_END,FOLLOW_2);

                        newLeafNode(this_END_9, grammarAccess.getTopicSpecAccess().getENDTerminalRuleCall_7());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTopicSpec"


    // $ANTLR start "entryRuleServiceSpec"
    // InternalRosParser.g:722:1: entryRuleServiceSpec returns [EObject current=null] : iv_ruleServiceSpec= ruleServiceSpec EOF ;
    public final EObject entryRuleServiceSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceSpec = null;


        try {
            // InternalRosParser.g:722:52: (iv_ruleServiceSpec= ruleServiceSpec EOF )
            // InternalRosParser.g:723:2: iv_ruleServiceSpec= ruleServiceSpec EOF
            {
             newCompositeNode(grammarAccess.getServiceSpecRule());
            pushFollow(FOLLOW_1);
            iv_ruleServiceSpec=ruleServiceSpec();

            state._fsp--;

             current =iv_ruleServiceSpec;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleServiceSpec"


    // $ANTLR start "ruleServiceSpec"
    // InternalRosParser.g:729:1: ruleServiceSpec returns [EObject current=null] : ( () rulePreListElement otherlv_2= Srv ( (lv_name_3_0= ruleEString ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Request (this_BEGIN_6= RULE_BEGIN ( (lv_request_7_0= ruleMessageDefinition ) ) this_END_8= RULE_END )? otherlv_9= Response (this_BEGIN_10= RULE_BEGIN ( (lv_response_11_0= ruleMessageDefinition ) ) this_END_12= RULE_END )? this_END_13= RULE_END ) ;
    public final EObject ruleServiceSpec() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_4=null;
        Token otherlv_5=null;
        Token this_BEGIN_6=null;
        Token this_END_8=null;
        Token otherlv_9=null;
        Token this_BEGIN_10=null;
        Token this_END_12=null;
        Token this_END_13=null;
        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_request_7_0 = null;

        EObject lv_response_11_0 = null;



            enterRule();

        try {
            // InternalRosParser.g:735:2: ( ( () rulePreListElement otherlv_2= Srv ( (lv_name_3_0= ruleEString ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Request (this_BEGIN_6= RULE_BEGIN ( (lv_request_7_0= ruleMessageDefinition ) ) this_END_8= RULE_END )? otherlv_9= Response (this_BEGIN_10= RULE_BEGIN ( (lv_response_11_0= ruleMessageDefinition ) ) this_END_12= RULE_END )? this_END_13= RULE_END ) )
            // InternalRosParser.g:736:2: ( () rulePreListElement otherlv_2= Srv ( (lv_name_3_0= ruleEString ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Request (this_BEGIN_6= RULE_BEGIN ( (lv_request_7_0= ruleMessageDefinition ) ) this_END_8= RULE_END )? otherlv_9= Response (this_BEGIN_10= RULE_BEGIN ( (lv_response_11_0= ruleMessageDefinition ) ) this_END_12= RULE_END )? this_END_13= RULE_END )
            {
            // InternalRosParser.g:736:2: ( () rulePreListElement otherlv_2= Srv ( (lv_name_3_0= ruleEString ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Request (this_BEGIN_6= RULE_BEGIN ( (lv_request_7_0= ruleMessageDefinition ) ) this_END_8= RULE_END )? otherlv_9= Response (this_BEGIN_10= RULE_BEGIN ( (lv_response_11_0= ruleMessageDefinition ) ) this_END_12= RULE_END )? this_END_13= RULE_END )
            // InternalRosParser.g:737:3: () rulePreListElement otherlv_2= Srv ( (lv_name_3_0= ruleEString ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Request (this_BEGIN_6= RULE_BEGIN ( (lv_request_7_0= ruleMessageDefinition ) ) this_END_8= RULE_END )? otherlv_9= Response (this_BEGIN_10= RULE_BEGIN ( (lv_response_11_0= ruleMessageDefinition ) ) this_END_12= RULE_END )? this_END_13= RULE_END
            {
            // InternalRosParser.g:737:3: ()
            // InternalRosParser.g:738:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getServiceSpecAccess().getServiceSpecAction_0(),
                                current);


            }


                        newCompositeNode(grammarAccess.getServiceSpecAccess().getPreListElementParserRuleCall_1());

            pushFollow(FOLLOW_23);
            rulePreListElement();

            state._fsp--;


                        afterParserOrEnumRuleCall();

            otherlv_2=(Token)match(input,Srv,FOLLOW_7);

                        newLeafNode(otherlv_2, grammarAccess.getServiceSpecAccess().getSrvKeyword_2());

            // InternalRosParser.g:755:3: ( (lv_name_3_0= ruleEString ) )
            // InternalRosParser.g:756:4: (lv_name_3_0= ruleEString )
            {
            // InternalRosParser.g:756:4: (lv_name_3_0= ruleEString )
            // InternalRosParser.g:757:5: lv_name_3_0= ruleEString
            {

                                newCompositeNode(grammarAccess.getServiceSpecAccess().getNameEStringParserRuleCall_3_0());

            pushFollow(FOLLOW_5);
            lv_name_3_0=ruleEString();

            state._fsp--;


                                if (current==null) {
                                    current = createModelElementForParent(grammarAccess.getServiceSpecRule());
                                }
                                set(
                                    current,
                                    "name",
                                    lv_name_3_0,
                                    "de.fraunhofer.ipa.ros.Basics.EString");
                                afterParserOrEnumRuleCall();


            }


            }

            this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_24);

                        newLeafNode(this_BEGIN_4, grammarAccess.getServiceSpecAccess().getBEGINTerminalRuleCall_4());

            otherlv_5=(Token)match(input,Request,FOLLOW_25);

                        newLeafNode(otherlv_5, grammarAccess.getServiceSpecAccess().getRequestKeyword_5());

            // InternalRosParser.g:782:3: (this_BEGIN_6= RULE_BEGIN ( (lv_request_7_0= ruleMessageDefinition ) ) this_END_8= RULE_END )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_BEGIN) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalRosParser.g:783:4: this_BEGIN_6= RULE_BEGIN ( (lv_request_7_0= ruleMessageDefinition ) ) this_END_8= RULE_END
                    {
                    this_BEGIN_6=(Token)match(input,RULE_BEGIN,FOLLOW_22);

                                    newLeafNode(this_BEGIN_6, grammarAccess.getServiceSpecAccess().getBEGINTerminalRuleCall_6_0());

                    // InternalRosParser.g:787:4: ( (lv_request_7_0= ruleMessageDefinition ) )
                    // InternalRosParser.g:788:5: (lv_request_7_0= ruleMessageDefinition )
                    {
                    // InternalRosParser.g:788:5: (lv_request_7_0= ruleMessageDefinition )
                    // InternalRosParser.g:789:6: lv_request_7_0= ruleMessageDefinition
                    {

                                            newCompositeNode(grammarAccess.getServiceSpecAccess().getRequestMessageDefinitionParserRuleCall_6_1_0());

                    pushFollow(FOLLOW_14);
                    lv_request_7_0=ruleMessageDefinition();

                    state._fsp--;


                                            if (current==null) {
                                                current = createModelElementForParent(grammarAccess.getServiceSpecRule());
                                            }
                                            set(
                                                current,
                                                "request",
                                                lv_request_7_0,
                                                "de.fraunhofer.ipa.ros.Ros.MessageDefinition");
                                            afterParserOrEnumRuleCall();


                    }


                    }

                    this_END_8=(Token)match(input,RULE_END,FOLLOW_26);

                                    newLeafNode(this_END_8, grammarAccess.getServiceSpecAccess().getENDTerminalRuleCall_6_2());


                    }
                    break;

            }

            otherlv_9=(Token)match(input,Response,FOLLOW_21);

                        newLeafNode(otherlv_9, grammarAccess.getServiceSpecAccess().getResponseKeyword_7());

            // InternalRosParser.g:815:3: (this_BEGIN_10= RULE_BEGIN ( (lv_response_11_0= ruleMessageDefinition ) ) this_END_12= RULE_END )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_BEGIN) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalRosParser.g:816:4: this_BEGIN_10= RULE_BEGIN ( (lv_response_11_0= ruleMessageDefinition ) ) this_END_12= RULE_END
                    {
                    this_BEGIN_10=(Token)match(input,RULE_BEGIN,FOLLOW_22);

                                    newLeafNode(this_BEGIN_10, grammarAccess.getServiceSpecAccess().getBEGINTerminalRuleCall_8_0());

                    // InternalRosParser.g:820:4: ( (lv_response_11_0= ruleMessageDefinition ) )
                    // InternalRosParser.g:821:5: (lv_response_11_0= ruleMessageDefinition )
                    {
                    // InternalRosParser.g:821:5: (lv_response_11_0= ruleMessageDefinition )
                    // InternalRosParser.g:822:6: lv_response_11_0= ruleMessageDefinition
                    {

                                            newCompositeNode(grammarAccess.getServiceSpecAccess().getResponseMessageDefinitionParserRuleCall_8_1_0());

                    pushFollow(FOLLOW_14);
                    lv_response_11_0=ruleMessageDefinition();

                    state._fsp--;


                                            if (current==null) {
                                                current = createModelElementForParent(grammarAccess.getServiceSpecRule());
                                            }
                                            set(
                                                current,
                                                "response",
                                                lv_response_11_0,
                                                "de.fraunhofer.ipa.ros.Ros.MessageDefinition");
                                            afterParserOrEnumRuleCall();


                    }


                    }

                    this_END_12=(Token)match(input,RULE_END,FOLLOW_14);

                                    newLeafNode(this_END_12, grammarAccess.getServiceSpecAccess().getENDTerminalRuleCall_8_2());


                    }
                    break;

            }

            this_END_13=(Token)match(input,RULE_END,FOLLOW_2);

                        newLeafNode(this_END_13, grammarAccess.getServiceSpecAccess().getENDTerminalRuleCall_9());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleServiceSpec"


    // $ANTLR start "entryRuleActionSpec"
    // InternalRosParser.g:852:1: entryRuleActionSpec returns [EObject current=null] : iv_ruleActionSpec= ruleActionSpec EOF ;
    public final EObject entryRuleActionSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActionSpec = null;


        try {
            // InternalRosParser.g:852:51: (iv_ruleActionSpec= ruleActionSpec EOF )
            // InternalRosParser.g:853:2: iv_ruleActionSpec= ruleActionSpec EOF
            {
             newCompositeNode(grammarAccess.getActionSpecRule());
            pushFollow(FOLLOW_1);
            iv_ruleActionSpec=ruleActionSpec();

            state._fsp--;

             current =iv_ruleActionSpec;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActionSpec"


    // $ANTLR start "ruleActionSpec"
    // InternalRosParser.g:859:1: ruleActionSpec returns [EObject current=null] : ( () rulePreListElement otherlv_2= Action_1 ( (lv_name_3_0= ruleEString ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Goal_1 (this_BEGIN_6= RULE_BEGIN ( (lv_goal_7_0= ruleMessageDefinition ) ) this_END_8= RULE_END )? otherlv_9= Result_1 (this_BEGIN_10= RULE_BEGIN ( (lv_result_11_0= ruleMessageDefinition ) ) this_END_12= RULE_END )? otherlv_13= Feedback_1 (this_BEGIN_14= RULE_BEGIN ( (lv_feedback_15_0= ruleMessageDefinition ) ) this_END_16= RULE_END )? this_END_17= RULE_END ) ;
    public final EObject ruleActionSpec() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_4=null;
        Token otherlv_5=null;
        Token this_BEGIN_6=null;
        Token this_END_8=null;
        Token otherlv_9=null;
        Token this_BEGIN_10=null;
        Token this_END_12=null;
        Token otherlv_13=null;
        Token this_BEGIN_14=null;
        Token this_END_16=null;
        Token this_END_17=null;
        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_goal_7_0 = null;

        EObject lv_result_11_0 = null;

        EObject lv_feedback_15_0 = null;



            enterRule();

        try {
            // InternalRosParser.g:865:2: ( ( () rulePreListElement otherlv_2= Action_1 ( (lv_name_3_0= ruleEString ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Goal_1 (this_BEGIN_6= RULE_BEGIN ( (lv_goal_7_0= ruleMessageDefinition ) ) this_END_8= RULE_END )? otherlv_9= Result_1 (this_BEGIN_10= RULE_BEGIN ( (lv_result_11_0= ruleMessageDefinition ) ) this_END_12= RULE_END )? otherlv_13= Feedback_1 (this_BEGIN_14= RULE_BEGIN ( (lv_feedback_15_0= ruleMessageDefinition ) ) this_END_16= RULE_END )? this_END_17= RULE_END ) )
            // InternalRosParser.g:866:2: ( () rulePreListElement otherlv_2= Action_1 ( (lv_name_3_0= ruleEString ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Goal_1 (this_BEGIN_6= RULE_BEGIN ( (lv_goal_7_0= ruleMessageDefinition ) ) this_END_8= RULE_END )? otherlv_9= Result_1 (this_BEGIN_10= RULE_BEGIN ( (lv_result_11_0= ruleMessageDefinition ) ) this_END_12= RULE_END )? otherlv_13= Feedback_1 (this_BEGIN_14= RULE_BEGIN ( (lv_feedback_15_0= ruleMessageDefinition ) ) this_END_16= RULE_END )? this_END_17= RULE_END )
            {
            // InternalRosParser.g:866:2: ( () rulePreListElement otherlv_2= Action_1 ( (lv_name_3_0= ruleEString ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Goal_1 (this_BEGIN_6= RULE_BEGIN ( (lv_goal_7_0= ruleMessageDefinition ) ) this_END_8= RULE_END )? otherlv_9= Result_1 (this_BEGIN_10= RULE_BEGIN ( (lv_result_11_0= ruleMessageDefinition ) ) this_END_12= RULE_END )? otherlv_13= Feedback_1 (this_BEGIN_14= RULE_BEGIN ( (lv_feedback_15_0= ruleMessageDefinition ) ) this_END_16= RULE_END )? this_END_17= RULE_END )
            // InternalRosParser.g:867:3: () rulePreListElement otherlv_2= Action_1 ( (lv_name_3_0= ruleEString ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Goal_1 (this_BEGIN_6= RULE_BEGIN ( (lv_goal_7_0= ruleMessageDefinition ) ) this_END_8= RULE_END )? otherlv_9= Result_1 (this_BEGIN_10= RULE_BEGIN ( (lv_result_11_0= ruleMessageDefinition ) ) this_END_12= RULE_END )? otherlv_13= Feedback_1 (this_BEGIN_14= RULE_BEGIN ( (lv_feedback_15_0= ruleMessageDefinition ) ) this_END_16= RULE_END )? this_END_17= RULE_END
            {
            // InternalRosParser.g:867:3: ()
            // InternalRosParser.g:868:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getActionSpecAccess().getActionSpecAction_0(),
                                current);


            }


                        newCompositeNode(grammarAccess.getActionSpecAccess().getPreListElementParserRuleCall_1());

            pushFollow(FOLLOW_27);
            rulePreListElement();

            state._fsp--;


                        afterParserOrEnumRuleCall();

            otherlv_2=(Token)match(input,Action_1,FOLLOW_7);

                        newLeafNode(otherlv_2, grammarAccess.getActionSpecAccess().getActionKeyword_2());

            // InternalRosParser.g:885:3: ( (lv_name_3_0= ruleEString ) )
            // InternalRosParser.g:886:4: (lv_name_3_0= ruleEString )
            {
            // InternalRosParser.g:886:4: (lv_name_3_0= ruleEString )
            // InternalRosParser.g:887:5: lv_name_3_0= ruleEString
            {

                                newCompositeNode(grammarAccess.getActionSpecAccess().getNameEStringParserRuleCall_3_0());

            pushFollow(FOLLOW_5);
            lv_name_3_0=ruleEString();

            state._fsp--;


                                if (current==null) {
                                    current = createModelElementForParent(grammarAccess.getActionSpecRule());
                                }
                                set(
                                    current,
                                    "name",
                                    lv_name_3_0,
                                    "de.fraunhofer.ipa.ros.Basics.EString");
                                afterParserOrEnumRuleCall();


            }


            }

            this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_28);

                        newLeafNode(this_BEGIN_4, grammarAccess.getActionSpecAccess().getBEGINTerminalRuleCall_4());

            otherlv_5=(Token)match(input,Goal_1,FOLLOW_29);

                        newLeafNode(otherlv_5, grammarAccess.getActionSpecAccess().getGoalKeyword_5());

            // InternalRosParser.g:912:3: (this_BEGIN_6= RULE_BEGIN ( (lv_goal_7_0= ruleMessageDefinition ) ) this_END_8= RULE_END )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_BEGIN) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalRosParser.g:913:4: this_BEGIN_6= RULE_BEGIN ( (lv_goal_7_0= ruleMessageDefinition ) ) this_END_8= RULE_END
                    {
                    this_BEGIN_6=(Token)match(input,RULE_BEGIN,FOLLOW_22);

                                    newLeafNode(this_BEGIN_6, grammarAccess.getActionSpecAccess().getBEGINTerminalRuleCall_6_0());

                    // InternalRosParser.g:917:4: ( (lv_goal_7_0= ruleMessageDefinition ) )
                    // InternalRosParser.g:918:5: (lv_goal_7_0= ruleMessageDefinition )
                    {
                    // InternalRosParser.g:918:5: (lv_goal_7_0= ruleMessageDefinition )
                    // InternalRosParser.g:919:6: lv_goal_7_0= ruleMessageDefinition
                    {

                                            newCompositeNode(grammarAccess.getActionSpecAccess().getGoalMessageDefinitionParserRuleCall_6_1_0());

                    pushFollow(FOLLOW_14);
                    lv_goal_7_0=ruleMessageDefinition();

                    state._fsp--;


                                            if (current==null) {
                                                current = createModelElementForParent(grammarAccess.getActionSpecRule());
                                            }
                                            set(
                                                current,
                                                "goal",
                                                lv_goal_7_0,
                                                "de.fraunhofer.ipa.ros.Ros.MessageDefinition");
                                            afterParserOrEnumRuleCall();


                    }


                    }

                    this_END_8=(Token)match(input,RULE_END,FOLLOW_30);

                                    newLeafNode(this_END_8, grammarAccess.getActionSpecAccess().getENDTerminalRuleCall_6_2());


                    }
                    break;

            }

            otherlv_9=(Token)match(input,Result_1,FOLLOW_31);

                        newLeafNode(otherlv_9, grammarAccess.getActionSpecAccess().getResultKeyword_7());

            // InternalRosParser.g:945:3: (this_BEGIN_10= RULE_BEGIN ( (lv_result_11_0= ruleMessageDefinition ) ) this_END_12= RULE_END )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_BEGIN) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalRosParser.g:946:4: this_BEGIN_10= RULE_BEGIN ( (lv_result_11_0= ruleMessageDefinition ) ) this_END_12= RULE_END
                    {
                    this_BEGIN_10=(Token)match(input,RULE_BEGIN,FOLLOW_22);

                                    newLeafNode(this_BEGIN_10, grammarAccess.getActionSpecAccess().getBEGINTerminalRuleCall_8_0());

                    // InternalRosParser.g:950:4: ( (lv_result_11_0= ruleMessageDefinition ) )
                    // InternalRosParser.g:951:5: (lv_result_11_0= ruleMessageDefinition )
                    {
                    // InternalRosParser.g:951:5: (lv_result_11_0= ruleMessageDefinition )
                    // InternalRosParser.g:952:6: lv_result_11_0= ruleMessageDefinition
                    {

                                            newCompositeNode(grammarAccess.getActionSpecAccess().getResultMessageDefinitionParserRuleCall_8_1_0());

                    pushFollow(FOLLOW_14);
                    lv_result_11_0=ruleMessageDefinition();

                    state._fsp--;


                                            if (current==null) {
                                                current = createModelElementForParent(grammarAccess.getActionSpecRule());
                                            }
                                            set(
                                                current,
                                                "result",
                                                lv_result_11_0,
                                                "de.fraunhofer.ipa.ros.Ros.MessageDefinition");
                                            afterParserOrEnumRuleCall();


                    }


                    }

                    this_END_12=(Token)match(input,RULE_END,FOLLOW_32);

                                    newLeafNode(this_END_12, grammarAccess.getActionSpecAccess().getENDTerminalRuleCall_8_2());


                    }
                    break;

            }

            otherlv_13=(Token)match(input,Feedback_1,FOLLOW_21);

                        newLeafNode(otherlv_13, grammarAccess.getActionSpecAccess().getFeedbackKeyword_9());

            // InternalRosParser.g:978:3: (this_BEGIN_14= RULE_BEGIN ( (lv_feedback_15_0= ruleMessageDefinition ) ) this_END_16= RULE_END )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_BEGIN) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalRosParser.g:979:4: this_BEGIN_14= RULE_BEGIN ( (lv_feedback_15_0= ruleMessageDefinition ) ) this_END_16= RULE_END
                    {
                    this_BEGIN_14=(Token)match(input,RULE_BEGIN,FOLLOW_22);

                                    newLeafNode(this_BEGIN_14, grammarAccess.getActionSpecAccess().getBEGINTerminalRuleCall_10_0());

                    // InternalRosParser.g:983:4: ( (lv_feedback_15_0= ruleMessageDefinition ) )
                    // InternalRosParser.g:984:5: (lv_feedback_15_0= ruleMessageDefinition )
                    {
                    // InternalRosParser.g:984:5: (lv_feedback_15_0= ruleMessageDefinition )
                    // InternalRosParser.g:985:6: lv_feedback_15_0= ruleMessageDefinition
                    {

                                            newCompositeNode(grammarAccess.getActionSpecAccess().getFeedbackMessageDefinitionParserRuleCall_10_1_0());

                    pushFollow(FOLLOW_14);
                    lv_feedback_15_0=ruleMessageDefinition();

                    state._fsp--;


                                            if (current==null) {
                                                current = createModelElementForParent(grammarAccess.getActionSpecRule());
                                            }
                                            set(
                                                current,
                                                "feedback",
                                                lv_feedback_15_0,
                                                "de.fraunhofer.ipa.ros.Ros.MessageDefinition");
                                            afterParserOrEnumRuleCall();


                    }


                    }

                    this_END_16=(Token)match(input,RULE_END,FOLLOW_14);

                                    newLeafNode(this_END_16, grammarAccess.getActionSpecAccess().getENDTerminalRuleCall_10_2());


                    }
                    break;

            }

            this_END_17=(Token)match(input,RULE_END,FOLLOW_2);

                        newLeafNode(this_END_17, grammarAccess.getActionSpecAccess().getENDTerminalRuleCall_11());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActionSpec"


    // $ANTLR start "entryRuleMessageDefinition"
    // InternalRosParser.g:1015:1: entryRuleMessageDefinition returns [EObject current=null] : iv_ruleMessageDefinition= ruleMessageDefinition EOF ;
    public final EObject entryRuleMessageDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageDefinition = null;


        try {
            // InternalRosParser.g:1015:58: (iv_ruleMessageDefinition= ruleMessageDefinition EOF )
            // InternalRosParser.g:1016:2: iv_ruleMessageDefinition= ruleMessageDefinition EOF
            {
             newCompositeNode(grammarAccess.getMessageDefinitionRule());
            pushFollow(FOLLOW_1);
            iv_ruleMessageDefinition=ruleMessageDefinition();

            state._fsp--;

             current =iv_ruleMessageDefinition;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMessageDefinition"


    // $ANTLR start "ruleMessageDefinition"
    // InternalRosParser.g:1022:1: ruleMessageDefinition returns [EObject current=null] : ( () ( (lv_MessagePart_1_0= ruleMessagePart ) )* ) ;
    public final EObject ruleMessageDefinition() throws RecognitionException {
        EObject current = null;

        EObject lv_MessagePart_1_0 = null;



            enterRule();

        try {
            // InternalRosParser.g:1028:2: ( ( () ( (lv_MessagePart_1_0= ruleMessagePart ) )* ) )
            // InternalRosParser.g:1029:2: ( () ( (lv_MessagePart_1_0= ruleMessagePart ) )* )
            {
            // InternalRosParser.g:1029:2: ( () ( (lv_MessagePart_1_0= ruleMessagePart ) )* )
            // InternalRosParser.g:1030:3: () ( (lv_MessagePart_1_0= ruleMessagePart ) )*
            {
            // InternalRosParser.g:1030:3: ()
            // InternalRosParser.g:1031:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getMessageDefinitionAccess().getMessageDefinitionAction_0(),
                                current);


            }

            // InternalRosParser.g:1037:3: ( (lv_MessagePart_1_0= ruleMessagePart ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=Duration && LA23_0<=Feedback)||LA23_0==Message||LA23_0==Service||LA23_0==Action||LA23_0==Result||LA23_0==Value||LA23_0==Goal||LA23_0==Name||(LA23_0>=Time && LA23_0<=Type)||(LA23_0>=RULE_ID && LA23_0<=RULE_STRING)||LA23_0==RULE_MESSAGE_ASIGMENT) ) {
                    alt23=1;
                }


                switch (alt23) {
                case 1 :
                    // InternalRosParser.g:1038:4: (lv_MessagePart_1_0= ruleMessagePart )
                    {
                    // InternalRosParser.g:1038:4: (lv_MessagePart_1_0= ruleMessagePart )
                    // InternalRosParser.g:1039:5: lv_MessagePart_1_0= ruleMessagePart
                    {

                                        newCompositeNode(grammarAccess.getMessageDefinitionAccess().getMessagePartMessagePartParserRuleCall_1_0());

                    pushFollow(FOLLOW_33);
                    lv_MessagePart_1_0=ruleMessagePart();

                    state._fsp--;


                                        if (current==null) {
                                            current = createModelElementForParent(grammarAccess.getMessageDefinitionRule());
                                        }
                                        add(
                                            current,
                                            "MessagePart",
                                            lv_MessagePart_1_0,
                                            "de.fraunhofer.ipa.ros.Basics.MessagePart");
                                        afterParserOrEnumRuleCall();


                    }


                    }
                    break;

                default :
                    break loop23;
                }
            } while (true);


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMessageDefinition"


    // $ANTLR start "entryRulePublisher"
    // InternalRosParser.g:1060:1: entryRulePublisher returns [EObject current=null] : iv_rulePublisher= rulePublisher EOF ;
    public final EObject entryRulePublisher() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePublisher = null;


        try {
            // InternalRosParser.g:1060:50: (iv_rulePublisher= rulePublisher EOF )
            // InternalRosParser.g:1061:2: iv_rulePublisher= rulePublisher EOF
            {
             newCompositeNode(grammarAccess.getPublisherRule());
            pushFollow(FOLLOW_1);
            iv_rulePublisher=rulePublisher();

            state._fsp--;

             current =iv_rulePublisher;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePublisher"


    // $ANTLR start "rulePublisher"
    // InternalRosParser.g:1067:1: rulePublisher returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) ;
    public final EObject rulePublisher() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token this_END_8=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_namespace_7_0 = null;



            enterRule();

        try {
            // InternalRosParser.g:1073:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) )
            // InternalRosParser.g:1074:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            {
            // InternalRosParser.g:1074:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            // InternalRosParser.g:1075:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END
            {
            // InternalRosParser.g:1075:3: ()
            // InternalRosParser.g:1076:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getPublisherAccess().getPublisherAction_0(),
                                current);


            }

            // InternalRosParser.g:1082:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRosParser.g:1083:4: (lv_name_1_0= ruleEString )
            {
            // InternalRosParser.g:1083:4: (lv_name_1_0= ruleEString )
            // InternalRosParser.g:1084:5: lv_name_1_0= ruleEString
            {

                                newCompositeNode(grammarAccess.getPublisherAccess().getNameEStringParserRuleCall_1_0());

            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


                                if (current==null) {
                                    current = createModelElementForParent(grammarAccess.getPublisherRule());
                                }
                                set(
                                    current,
                                    "name",
                                    lv_name_1_0,
                                    "de.fraunhofer.ipa.ros.Basics.EString");
                                afterParserOrEnumRuleCall();


            }


            }

            otherlv_2=(Token)match(input,Colon,FOLLOW_5);

                        newLeafNode(otherlv_2, grammarAccess.getPublisherAccess().getColonKeyword_2());

            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_34);

                        newLeafNode(this_BEGIN_3, grammarAccess.getPublisherAccess().getBEGINTerminalRuleCall_3());

            otherlv_4=(Token)match(input,Type_1,FOLLOW_7);

                        newLeafNode(otherlv_4, grammarAccess.getPublisherAccess().getTypeKeyword_4());

            // InternalRosParser.g:1113:3: ( ( ruleEString ) )
            // InternalRosParser.g:1114:4: ( ruleEString )
            {
            // InternalRosParser.g:1114:4: ( ruleEString )
            // InternalRosParser.g:1115:5: ruleEString
            {

                                if (current==null) {
                                    current = createModelElement(grammarAccess.getPublisherRule());
                                }


                                newCompositeNode(grammarAccess.getPublisherAccess().getMessageTopicSpecCrossReference_5_0());

            pushFollow(FOLLOW_35);
            ruleEString();

            state._fsp--;


                                afterParserOrEnumRuleCall();


            }


            }

            // InternalRosParser.g:1129:3: (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==Ns) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalRosParser.g:1130:4: otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) )
                    {
                    otherlv_6=(Token)match(input,Ns,FOLLOW_36);

                                    newLeafNode(otherlv_6, grammarAccess.getPublisherAccess().getNsKeyword_6_0());

                    // InternalRosParser.g:1134:4: ( (lv_namespace_7_0= ruleNamespace ) )
                    // InternalRosParser.g:1135:5: (lv_namespace_7_0= ruleNamespace )
                    {
                    // InternalRosParser.g:1135:5: (lv_namespace_7_0= ruleNamespace )
                    // InternalRosParser.g:1136:6: lv_namespace_7_0= ruleNamespace
                    {

                                            newCompositeNode(grammarAccess.getPublisherAccess().getNamespaceNamespaceParserRuleCall_6_1_0());

                    pushFollow(FOLLOW_14);
                    lv_namespace_7_0=ruleNamespace();

                    state._fsp--;


                                            if (current==null) {
                                                current = createModelElementForParent(grammarAccess.getPublisherRule());
                                            }
                                            set(
                                                current,
                                                "namespace",
                                                lv_namespace_7_0,
                                                "de.fraunhofer.ipa.ros.Basics.Namespace");
                                            afterParserOrEnumRuleCall();


                    }


                    }


                    }
                    break;

            }

            this_END_8=(Token)match(input,RULE_END,FOLLOW_2);

                        newLeafNode(this_END_8, grammarAccess.getPublisherAccess().getENDTerminalRuleCall_7());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePublisher"


    // $ANTLR start "entryRuleSubscriber"
    // InternalRosParser.g:1162:1: entryRuleSubscriber returns [EObject current=null] : iv_ruleSubscriber= ruleSubscriber EOF ;
    public final EObject entryRuleSubscriber() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubscriber = null;


        try {
            // InternalRosParser.g:1162:51: (iv_ruleSubscriber= ruleSubscriber EOF )
            // InternalRosParser.g:1163:2: iv_ruleSubscriber= ruleSubscriber EOF
            {
             newCompositeNode(grammarAccess.getSubscriberRule());
            pushFollow(FOLLOW_1);
            iv_ruleSubscriber=ruleSubscriber();

            state._fsp--;

             current =iv_ruleSubscriber;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubscriber"


    // $ANTLR start "ruleSubscriber"
    // InternalRosParser.g:1169:1: ruleSubscriber returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) ;
    public final EObject ruleSubscriber() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token this_END_8=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_namespace_7_0 = null;



            enterRule();

        try {
            // InternalRosParser.g:1175:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) )
            // InternalRosParser.g:1176:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            {
            // InternalRosParser.g:1176:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            // InternalRosParser.g:1177:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END
            {
            // InternalRosParser.g:1177:3: ()
            // InternalRosParser.g:1178:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getSubscriberAccess().getSubscriberAction_0(),
                                current);


            }

            // InternalRosParser.g:1184:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRosParser.g:1185:4: (lv_name_1_0= ruleEString )
            {
            // InternalRosParser.g:1185:4: (lv_name_1_0= ruleEString )
            // InternalRosParser.g:1186:5: lv_name_1_0= ruleEString
            {

                                newCompositeNode(grammarAccess.getSubscriberAccess().getNameEStringParserRuleCall_1_0());

            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


                                if (current==null) {
                                    current = createModelElementForParent(grammarAccess.getSubscriberRule());
                                }
                                set(
                                    current,
                                    "name",
                                    lv_name_1_0,
                                    "de.fraunhofer.ipa.ros.Basics.EString");
                                afterParserOrEnumRuleCall();


            }


            }

            otherlv_2=(Token)match(input,Colon,FOLLOW_5);

                        newLeafNode(otherlv_2, grammarAccess.getSubscriberAccess().getColonKeyword_2());

            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_34);

                        newLeafNode(this_BEGIN_3, grammarAccess.getSubscriberAccess().getBEGINTerminalRuleCall_3());

            otherlv_4=(Token)match(input,Type_1,FOLLOW_7);

                        newLeafNode(otherlv_4, grammarAccess.getSubscriberAccess().getTypeKeyword_4());

            // InternalRosParser.g:1215:3: ( ( ruleEString ) )
            // InternalRosParser.g:1216:4: ( ruleEString )
            {
            // InternalRosParser.g:1216:4: ( ruleEString )
            // InternalRosParser.g:1217:5: ruleEString
            {

                                if (current==null) {
                                    current = createModelElement(grammarAccess.getSubscriberRule());
                                }


                                newCompositeNode(grammarAccess.getSubscriberAccess().getMessageTopicSpecCrossReference_5_0());

            pushFollow(FOLLOW_35);
            ruleEString();

            state._fsp--;


                                afterParserOrEnumRuleCall();


            }


            }

            // InternalRosParser.g:1231:3: (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==Ns) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalRosParser.g:1232:4: otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) )
                    {
                    otherlv_6=(Token)match(input,Ns,FOLLOW_36);

                                    newLeafNode(otherlv_6, grammarAccess.getSubscriberAccess().getNsKeyword_6_0());

                    // InternalRosParser.g:1236:4: ( (lv_namespace_7_0= ruleNamespace ) )
                    // InternalRosParser.g:1237:5: (lv_namespace_7_0= ruleNamespace )
                    {
                    // InternalRosParser.g:1237:5: (lv_namespace_7_0= ruleNamespace )
                    // InternalRosParser.g:1238:6: lv_namespace_7_0= ruleNamespace
                    {

                                            newCompositeNode(grammarAccess.getSubscriberAccess().getNamespaceNamespaceParserRuleCall_6_1_0());

                    pushFollow(FOLLOW_14);
                    lv_namespace_7_0=ruleNamespace();

                    state._fsp--;


                                            if (current==null) {
                                                current = createModelElementForParent(grammarAccess.getSubscriberRule());
                                            }
                                            set(
                                                current,
                                                "namespace",
                                                lv_namespace_7_0,
                                                "de.fraunhofer.ipa.ros.Basics.Namespace");
                                            afterParserOrEnumRuleCall();


                    }


                    }


                    }
                    break;

            }

            this_END_8=(Token)match(input,RULE_END,FOLLOW_2);

                        newLeafNode(this_END_8, grammarAccess.getSubscriberAccess().getENDTerminalRuleCall_7());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubscriber"


    // $ANTLR start "entryRuleServiceServer"
    // InternalRosParser.g:1264:1: entryRuleServiceServer returns [EObject current=null] : iv_ruleServiceServer= ruleServiceServer EOF ;
    public final EObject entryRuleServiceServer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceServer = null;


        try {
            // InternalRosParser.g:1264:54: (iv_ruleServiceServer= ruleServiceServer EOF )
            // InternalRosParser.g:1265:2: iv_ruleServiceServer= ruleServiceServer EOF
            {
             newCompositeNode(grammarAccess.getServiceServerRule());
            pushFollow(FOLLOW_1);
            iv_ruleServiceServer=ruleServiceServer();

            state._fsp--;

             current =iv_ruleServiceServer;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleServiceServer"


    // $ANTLR start "ruleServiceServer"
    // InternalRosParser.g:1271:1: ruleServiceServer returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) ;
    public final EObject ruleServiceServer() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token this_END_8=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_namespace_7_0 = null;



            enterRule();

        try {
            // InternalRosParser.g:1277:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) )
            // InternalRosParser.g:1278:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            {
            // InternalRosParser.g:1278:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            // InternalRosParser.g:1279:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END
            {
            // InternalRosParser.g:1279:3: ()
            // InternalRosParser.g:1280:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getServiceServerAccess().getServiceServerAction_0(),
                                current);


            }

            // InternalRosParser.g:1286:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRosParser.g:1287:4: (lv_name_1_0= ruleEString )
            {
            // InternalRosParser.g:1287:4: (lv_name_1_0= ruleEString )
            // InternalRosParser.g:1288:5: lv_name_1_0= ruleEString
            {

                                newCompositeNode(grammarAccess.getServiceServerAccess().getNameEStringParserRuleCall_1_0());

            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


                                if (current==null) {
                                    current = createModelElementForParent(grammarAccess.getServiceServerRule());
                                }
                                set(
                                    current,
                                    "name",
                                    lv_name_1_0,
                                    "de.fraunhofer.ipa.ros.Basics.EString");
                                afterParserOrEnumRuleCall();


            }


            }

            otherlv_2=(Token)match(input,Colon,FOLLOW_5);

                        newLeafNode(otherlv_2, grammarAccess.getServiceServerAccess().getColonKeyword_2());

            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_34);

                        newLeafNode(this_BEGIN_3, grammarAccess.getServiceServerAccess().getBEGINTerminalRuleCall_3());

            otherlv_4=(Token)match(input,Type_1,FOLLOW_7);

                        newLeafNode(otherlv_4, grammarAccess.getServiceServerAccess().getTypeKeyword_4());

            // InternalRosParser.g:1317:3: ( ( ruleEString ) )
            // InternalRosParser.g:1318:4: ( ruleEString )
            {
            // InternalRosParser.g:1318:4: ( ruleEString )
            // InternalRosParser.g:1319:5: ruleEString
            {

                                if (current==null) {
                                    current = createModelElement(grammarAccess.getServiceServerRule());
                                }


                                newCompositeNode(grammarAccess.getServiceServerAccess().getServiceServiceSpecCrossReference_5_0());

            pushFollow(FOLLOW_35);
            ruleEString();

            state._fsp--;


                                afterParserOrEnumRuleCall();


            }


            }

            // InternalRosParser.g:1333:3: (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==Ns) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalRosParser.g:1334:4: otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) )
                    {
                    otherlv_6=(Token)match(input,Ns,FOLLOW_36);

                                    newLeafNode(otherlv_6, grammarAccess.getServiceServerAccess().getNsKeyword_6_0());

                    // InternalRosParser.g:1338:4: ( (lv_namespace_7_0= ruleNamespace ) )
                    // InternalRosParser.g:1339:5: (lv_namespace_7_0= ruleNamespace )
                    {
                    // InternalRosParser.g:1339:5: (lv_namespace_7_0= ruleNamespace )
                    // InternalRosParser.g:1340:6: lv_namespace_7_0= ruleNamespace
                    {

                                            newCompositeNode(grammarAccess.getServiceServerAccess().getNamespaceNamespaceParserRuleCall_6_1_0());

                    pushFollow(FOLLOW_14);
                    lv_namespace_7_0=ruleNamespace();

                    state._fsp--;


                                            if (current==null) {
                                                current = createModelElementForParent(grammarAccess.getServiceServerRule());
                                            }
                                            set(
                                                current,
                                                "namespace",
                                                lv_namespace_7_0,
                                                "de.fraunhofer.ipa.ros.Basics.Namespace");
                                            afterParserOrEnumRuleCall();


                    }


                    }


                    }
                    break;

            }

            this_END_8=(Token)match(input,RULE_END,FOLLOW_2);

                        newLeafNode(this_END_8, grammarAccess.getServiceServerAccess().getENDTerminalRuleCall_7());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleServiceServer"


    // $ANTLR start "entryRuleServiceClient"
    // InternalRosParser.g:1366:1: entryRuleServiceClient returns [EObject current=null] : iv_ruleServiceClient= ruleServiceClient EOF ;
    public final EObject entryRuleServiceClient() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceClient = null;


        try {
            // InternalRosParser.g:1366:54: (iv_ruleServiceClient= ruleServiceClient EOF )
            // InternalRosParser.g:1367:2: iv_ruleServiceClient= ruleServiceClient EOF
            {
             newCompositeNode(grammarAccess.getServiceClientRule());
            pushFollow(FOLLOW_1);
            iv_ruleServiceClient=ruleServiceClient();

            state._fsp--;

             current =iv_ruleServiceClient;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleServiceClient"


    // $ANTLR start "ruleServiceClient"
    // InternalRosParser.g:1373:1: ruleServiceClient returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) ;
    public final EObject ruleServiceClient() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token this_END_8=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_namespace_7_0 = null;



            enterRule();

        try {
            // InternalRosParser.g:1379:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) )
            // InternalRosParser.g:1380:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            {
            // InternalRosParser.g:1380:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            // InternalRosParser.g:1381:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END
            {
            // InternalRosParser.g:1381:3: ()
            // InternalRosParser.g:1382:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getServiceClientAccess().getServiceClientAction_0(),
                                current);


            }

            // InternalRosParser.g:1388:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRosParser.g:1389:4: (lv_name_1_0= ruleEString )
            {
            // InternalRosParser.g:1389:4: (lv_name_1_0= ruleEString )
            // InternalRosParser.g:1390:5: lv_name_1_0= ruleEString
            {

                                newCompositeNode(grammarAccess.getServiceClientAccess().getNameEStringParserRuleCall_1_0());

            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


                                if (current==null) {
                                    current = createModelElementForParent(grammarAccess.getServiceClientRule());
                                }
                                set(
                                    current,
                                    "name",
                                    lv_name_1_0,
                                    "de.fraunhofer.ipa.ros.Basics.EString");
                                afterParserOrEnumRuleCall();


            }


            }

            otherlv_2=(Token)match(input,Colon,FOLLOW_5);

                        newLeafNode(otherlv_2, grammarAccess.getServiceClientAccess().getColonKeyword_2());

            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_34);

                        newLeafNode(this_BEGIN_3, grammarAccess.getServiceClientAccess().getBEGINTerminalRuleCall_3());

            otherlv_4=(Token)match(input,Type_1,FOLLOW_7);

                        newLeafNode(otherlv_4, grammarAccess.getServiceClientAccess().getTypeKeyword_4());

            // InternalRosParser.g:1419:3: ( ( ruleEString ) )
            // InternalRosParser.g:1420:4: ( ruleEString )
            {
            // InternalRosParser.g:1420:4: ( ruleEString )
            // InternalRosParser.g:1421:5: ruleEString
            {

                                if (current==null) {
                                    current = createModelElement(grammarAccess.getServiceClientRule());
                                }


                                newCompositeNode(grammarAccess.getServiceClientAccess().getServiceServiceSpecCrossReference_5_0());

            pushFollow(FOLLOW_35);
            ruleEString();

            state._fsp--;


                                afterParserOrEnumRuleCall();


            }


            }

            // InternalRosParser.g:1435:3: (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==Ns) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalRosParser.g:1436:4: otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) )
                    {
                    otherlv_6=(Token)match(input,Ns,FOLLOW_36);

                                    newLeafNode(otherlv_6, grammarAccess.getServiceClientAccess().getNsKeyword_6_0());

                    // InternalRosParser.g:1440:4: ( (lv_namespace_7_0= ruleNamespace ) )
                    // InternalRosParser.g:1441:5: (lv_namespace_7_0= ruleNamespace )
                    {
                    // InternalRosParser.g:1441:5: (lv_namespace_7_0= ruleNamespace )
                    // InternalRosParser.g:1442:6: lv_namespace_7_0= ruleNamespace
                    {

                                            newCompositeNode(grammarAccess.getServiceClientAccess().getNamespaceNamespaceParserRuleCall_6_1_0());

                    pushFollow(FOLLOW_14);
                    lv_namespace_7_0=ruleNamespace();

                    state._fsp--;


                                            if (current==null) {
                                                current = createModelElementForParent(grammarAccess.getServiceClientRule());
                                            }
                                            set(
                                                current,
                                                "namespace",
                                                lv_namespace_7_0,
                                                "de.fraunhofer.ipa.ros.Basics.Namespace");
                                            afterParserOrEnumRuleCall();


                    }


                    }


                    }
                    break;

            }

            this_END_8=(Token)match(input,RULE_END,FOLLOW_2);

                        newLeafNode(this_END_8, grammarAccess.getServiceClientAccess().getENDTerminalRuleCall_7());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleServiceClient"


    // $ANTLR start "entryRuleActionServer"
    // InternalRosParser.g:1468:1: entryRuleActionServer returns [EObject current=null] : iv_ruleActionServer= ruleActionServer EOF ;
    public final EObject entryRuleActionServer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActionServer = null;


        try {
            // InternalRosParser.g:1468:53: (iv_ruleActionServer= ruleActionServer EOF )
            // InternalRosParser.g:1469:2: iv_ruleActionServer= ruleActionServer EOF
            {
             newCompositeNode(grammarAccess.getActionServerRule());
            pushFollow(FOLLOW_1);
            iv_ruleActionServer=ruleActionServer();

            state._fsp--;

             current =iv_ruleActionServer;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActionServer"


    // $ANTLR start "ruleActionServer"
    // InternalRosParser.g:1475:1: ruleActionServer returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) ;
    public final EObject ruleActionServer() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token this_END_8=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_namespace_7_0 = null;



            enterRule();

        try {
            // InternalRosParser.g:1481:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) )
            // InternalRosParser.g:1482:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            {
            // InternalRosParser.g:1482:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            // InternalRosParser.g:1483:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END
            {
            // InternalRosParser.g:1483:3: ()
            // InternalRosParser.g:1484:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getActionServerAccess().getActionServerAction_0(),
                                current);


            }

            // InternalRosParser.g:1490:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRosParser.g:1491:4: (lv_name_1_0= ruleEString )
            {
            // InternalRosParser.g:1491:4: (lv_name_1_0= ruleEString )
            // InternalRosParser.g:1492:5: lv_name_1_0= ruleEString
            {

                                newCompositeNode(grammarAccess.getActionServerAccess().getNameEStringParserRuleCall_1_0());

            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


                                if (current==null) {
                                    current = createModelElementForParent(grammarAccess.getActionServerRule());
                                }
                                set(
                                    current,
                                    "name",
                                    lv_name_1_0,
                                    "de.fraunhofer.ipa.ros.Basics.EString");
                                afterParserOrEnumRuleCall();


            }


            }

            otherlv_2=(Token)match(input,Colon,FOLLOW_5);

                        newLeafNode(otherlv_2, grammarAccess.getActionServerAccess().getColonKeyword_2());

            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_34);

                        newLeafNode(this_BEGIN_3, grammarAccess.getActionServerAccess().getBEGINTerminalRuleCall_3());

            otherlv_4=(Token)match(input,Type_1,FOLLOW_7);

                        newLeafNode(otherlv_4, grammarAccess.getActionServerAccess().getTypeKeyword_4());

            // InternalRosParser.g:1521:3: ( ( ruleEString ) )
            // InternalRosParser.g:1522:4: ( ruleEString )
            {
            // InternalRosParser.g:1522:4: ( ruleEString )
            // InternalRosParser.g:1523:5: ruleEString
            {

                                if (current==null) {
                                    current = createModelElement(grammarAccess.getActionServerRule());
                                }


                                newCompositeNode(grammarAccess.getActionServerAccess().getActionActionSpecCrossReference_5_0());

            pushFollow(FOLLOW_35);
            ruleEString();

            state._fsp--;


                                afterParserOrEnumRuleCall();


            }


            }

            // InternalRosParser.g:1537:3: (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==Ns) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalRosParser.g:1538:4: otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) )
                    {
                    otherlv_6=(Token)match(input,Ns,FOLLOW_36);

                                    newLeafNode(otherlv_6, grammarAccess.getActionServerAccess().getNsKeyword_6_0());

                    // InternalRosParser.g:1542:4: ( (lv_namespace_7_0= ruleNamespace ) )
                    // InternalRosParser.g:1543:5: (lv_namespace_7_0= ruleNamespace )
                    {
                    // InternalRosParser.g:1543:5: (lv_namespace_7_0= ruleNamespace )
                    // InternalRosParser.g:1544:6: lv_namespace_7_0= ruleNamespace
                    {

                                            newCompositeNode(grammarAccess.getActionServerAccess().getNamespaceNamespaceParserRuleCall_6_1_0());

                    pushFollow(FOLLOW_14);
                    lv_namespace_7_0=ruleNamespace();

                    state._fsp--;


                                            if (current==null) {
                                                current = createModelElementForParent(grammarAccess.getActionServerRule());
                                            }
                                            set(
                                                current,
                                                "namespace",
                                                lv_namespace_7_0,
                                                "de.fraunhofer.ipa.ros.Basics.Namespace");
                                            afterParserOrEnumRuleCall();


                    }


                    }


                    }
                    break;

            }

            this_END_8=(Token)match(input,RULE_END,FOLLOW_2);

                        newLeafNode(this_END_8, grammarAccess.getActionServerAccess().getENDTerminalRuleCall_7());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActionServer"


    // $ANTLR start "entryRuleActionClient"
    // InternalRosParser.g:1570:1: entryRuleActionClient returns [EObject current=null] : iv_ruleActionClient= ruleActionClient EOF ;
    public final EObject entryRuleActionClient() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActionClient = null;


        try {
            // InternalRosParser.g:1570:53: (iv_ruleActionClient= ruleActionClient EOF )
            // InternalRosParser.g:1571:2: iv_ruleActionClient= ruleActionClient EOF
            {
             newCompositeNode(grammarAccess.getActionClientRule());
            pushFollow(FOLLOW_1);
            iv_ruleActionClient=ruleActionClient();

            state._fsp--;

             current =iv_ruleActionClient;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActionClient"


    // $ANTLR start "ruleActionClient"
    // InternalRosParser.g:1577:1: ruleActionClient returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) ;
    public final EObject ruleActionClient() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token this_END_8=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_namespace_7_0 = null;



            enterRule();

        try {
            // InternalRosParser.g:1583:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) )
            // InternalRosParser.g:1584:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            {
            // InternalRosParser.g:1584:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            // InternalRosParser.g:1585:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END
            {
            // InternalRosParser.g:1585:3: ()
            // InternalRosParser.g:1586:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getActionClientAccess().getActionClientAction_0(),
                                current);


            }

            // InternalRosParser.g:1592:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRosParser.g:1593:4: (lv_name_1_0= ruleEString )
            {
            // InternalRosParser.g:1593:4: (lv_name_1_0= ruleEString )
            // InternalRosParser.g:1594:5: lv_name_1_0= ruleEString
            {

                                newCompositeNode(grammarAccess.getActionClientAccess().getNameEStringParserRuleCall_1_0());

            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


                                if (current==null) {
                                    current = createModelElementForParent(grammarAccess.getActionClientRule());
                                }
                                set(
                                    current,
                                    "name",
                                    lv_name_1_0,
                                    "de.fraunhofer.ipa.ros.Basics.EString");
                                afterParserOrEnumRuleCall();


            }


            }

            otherlv_2=(Token)match(input,Colon,FOLLOW_5);

                        newLeafNode(otherlv_2, grammarAccess.getActionClientAccess().getColonKeyword_2());

            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_34);

                        newLeafNode(this_BEGIN_3, grammarAccess.getActionClientAccess().getBEGINTerminalRuleCall_3());

            otherlv_4=(Token)match(input,Type_1,FOLLOW_7);

                        newLeafNode(otherlv_4, grammarAccess.getActionClientAccess().getTypeKeyword_4());

            // InternalRosParser.g:1623:3: ( ( ruleEString ) )
            // InternalRosParser.g:1624:4: ( ruleEString )
            {
            // InternalRosParser.g:1624:4: ( ruleEString )
            // InternalRosParser.g:1625:5: ruleEString
            {

                                if (current==null) {
                                    current = createModelElement(grammarAccess.getActionClientRule());
                                }


                                newCompositeNode(grammarAccess.getActionClientAccess().getActionActionSpecCrossReference_5_0());

            pushFollow(FOLLOW_35);
            ruleEString();

            state._fsp--;


                                afterParserOrEnumRuleCall();


            }


            }

            // InternalRosParser.g:1639:3: (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==Ns) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalRosParser.g:1640:4: otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) )
                    {
                    otherlv_6=(Token)match(input,Ns,FOLLOW_36);

                                    newLeafNode(otherlv_6, grammarAccess.getActionClientAccess().getNsKeyword_6_0());

                    // InternalRosParser.g:1644:4: ( (lv_namespace_7_0= ruleNamespace ) )
                    // InternalRosParser.g:1645:5: (lv_namespace_7_0= ruleNamespace )
                    {
                    // InternalRosParser.g:1645:5: (lv_namespace_7_0= ruleNamespace )
                    // InternalRosParser.g:1646:6: lv_namespace_7_0= ruleNamespace
                    {

                                            newCompositeNode(grammarAccess.getActionClientAccess().getNamespaceNamespaceParserRuleCall_6_1_0());

                    pushFollow(FOLLOW_14);
                    lv_namespace_7_0=ruleNamespace();

                    state._fsp--;


                                            if (current==null) {
                                                current = createModelElementForParent(grammarAccess.getActionClientRule());
                                            }
                                            set(
                                                current,
                                                "namespace",
                                                lv_namespace_7_0,
                                                "de.fraunhofer.ipa.ros.Basics.Namespace");
                                            afterParserOrEnumRuleCall();


                    }


                    }


                    }
                    break;

            }

            this_END_8=(Token)match(input,RULE_END,FOLLOW_2);

                        newLeafNode(this_END_8, grammarAccess.getActionClientAccess().getENDTerminalRuleCall_7());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActionClient"


    // $ANTLR start "entryRuleDependency"
    // InternalRosParser.g:1672:1: entryRuleDependency returns [EObject current=null] : iv_ruleDependency= ruleDependency EOF ;
    public final EObject entryRuleDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDependency = null;


        try {
            // InternalRosParser.g:1672:51: (iv_ruleDependency= ruleDependency EOF )
            // InternalRosParser.g:1673:2: iv_ruleDependency= ruleDependency EOF
            {
             newCompositeNode(grammarAccess.getDependencyRule());
            pushFollow(FOLLOW_1);
            iv_ruleDependency=ruleDependency();

            state._fsp--;

             current =iv_ruleDependency;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDependency"


    // $ANTLR start "ruleDependency"
    // InternalRosParser.g:1679:1: ruleDependency returns [EObject current=null] : (this_PackageDependency_0= rulePackageDependency | this_ExternalDependency_1= ruleExternalDependency ) ;
    public final EObject ruleDependency() throws RecognitionException {
        EObject current = null;

        EObject this_PackageDependency_0 = null;

        EObject this_ExternalDependency_1 = null;



            enterRule();

        try {
            // InternalRosParser.g:1685:2: ( (this_PackageDependency_0= rulePackageDependency | this_ExternalDependency_1= ruleExternalDependency ) )
            // InternalRosParser.g:1686:2: (this_PackageDependency_0= rulePackageDependency | this_ExternalDependency_1= ruleExternalDependency )
            {
            // InternalRosParser.g:1686:2: (this_PackageDependency_0= rulePackageDependency | this_ExternalDependency_1= ruleExternalDependency )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=RULE_ID && LA30_0<=RULE_STRING)) ) {
                alt30=1;
            }
            else if ( (LA30_0==ExternalDependency) ) {
                alt30=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // InternalRosParser.g:1687:3: this_PackageDependency_0= rulePackageDependency
                    {

                                newCompositeNode(grammarAccess.getDependencyAccess().getPackageDependencyParserRuleCall_0());

                    pushFollow(FOLLOW_2);
                    this_PackageDependency_0=rulePackageDependency();

                    state._fsp--;


                                current = this_PackageDependency_0;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 2 :
                    // InternalRosParser.g:1696:3: this_ExternalDependency_1= ruleExternalDependency
                    {

                                newCompositeNode(grammarAccess.getDependencyAccess().getExternalDependencyParserRuleCall_1());

                    pushFollow(FOLLOW_2);
                    this_ExternalDependency_1=ruleExternalDependency();

                    state._fsp--;


                                current = this_ExternalDependency_1;
                                afterParserOrEnumRuleCall();


                    }
                    break;

            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDependency"


    // $ANTLR start "entryRulePackageDependency"
    // InternalRosParser.g:1708:1: entryRulePackageDependency returns [EObject current=null] : iv_rulePackageDependency= rulePackageDependency EOF ;
    public final EObject entryRulePackageDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageDependency = null;


        try {
            // InternalRosParser.g:1708:58: (iv_rulePackageDependency= rulePackageDependency EOF )
            // InternalRosParser.g:1709:2: iv_rulePackageDependency= rulePackageDependency EOF
            {
             newCompositeNode(grammarAccess.getPackageDependencyRule());
            pushFollow(FOLLOW_1);
            iv_rulePackageDependency=rulePackageDependency();

            state._fsp--;

             current =iv_rulePackageDependency;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePackageDependency"


    // $ANTLR start "rulePackageDependency"
    // InternalRosParser.g:1715:1: rulePackageDependency returns [EObject current=null] : ( ( ruleEString ) ) ;
    public final EObject rulePackageDependency() throws RecognitionException {
        EObject current = null;


            enterRule();

        try {
            // InternalRosParser.g:1721:2: ( ( ( ruleEString ) ) )
            // InternalRosParser.g:1722:2: ( ( ruleEString ) )
            {
            // InternalRosParser.g:1722:2: ( ( ruleEString ) )
            // InternalRosParser.g:1723:3: ( ruleEString )
            {
            // InternalRosParser.g:1723:3: ( ruleEString )
            // InternalRosParser.g:1724:4: ruleEString
            {

                            if (current==null) {
                                current = createModelElement(grammarAccess.getPackageDependencyRule());
                            }


                            newCompositeNode(grammarAccess.getPackageDependencyAccess().getPackagePackageCrossReference_0());

            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;


                            afterParserOrEnumRuleCall();


            }


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePackageDependency"


    // $ANTLR start "entryRuleExternalDependency"
    // InternalRosParser.g:1741:1: entryRuleExternalDependency returns [EObject current=null] : iv_ruleExternalDependency= ruleExternalDependency EOF ;
    public final EObject entryRuleExternalDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalDependency = null;


        try {
            // InternalRosParser.g:1741:59: (iv_ruleExternalDependency= ruleExternalDependency EOF )
            // InternalRosParser.g:1742:2: iv_ruleExternalDependency= ruleExternalDependency EOF
            {
             newCompositeNode(grammarAccess.getExternalDependencyRule());
            pushFollow(FOLLOW_1);
            iv_ruleExternalDependency=ruleExternalDependency();

            state._fsp--;

             current =iv_ruleExternalDependency;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExternalDependency"


    // $ANTLR start "ruleExternalDependency"
    // InternalRosParser.g:1748:1: ruleExternalDependency returns [EObject current=null] : ( () otherlv_1= ExternalDependency ( (lv_name_2_0= ruleEString ) ) ) ;
    public final EObject ruleExternalDependency() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;



            enterRule();

        try {
            // InternalRosParser.g:1754:2: ( ( () otherlv_1= ExternalDependency ( (lv_name_2_0= ruleEString ) ) ) )
            // InternalRosParser.g:1755:2: ( () otherlv_1= ExternalDependency ( (lv_name_2_0= ruleEString ) ) )
            {
            // InternalRosParser.g:1755:2: ( () otherlv_1= ExternalDependency ( (lv_name_2_0= ruleEString ) ) )
            // InternalRosParser.g:1756:3: () otherlv_1= ExternalDependency ( (lv_name_2_0= ruleEString ) )
            {
            // InternalRosParser.g:1756:3: ()
            // InternalRosParser.g:1757:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getExternalDependencyAccess().getExternalDependencyAction_0(),
                                current);


            }

            otherlv_1=(Token)match(input,ExternalDependency,FOLLOW_7);

                        newLeafNode(otherlv_1, grammarAccess.getExternalDependencyAccess().getExternalDependencyKeyword_1());

            // InternalRosParser.g:1767:3: ( (lv_name_2_0= ruleEString ) )
            // InternalRosParser.g:1768:4: (lv_name_2_0= ruleEString )
            {
            // InternalRosParser.g:1768:4: (lv_name_2_0= ruleEString )
            // InternalRosParser.g:1769:5: lv_name_2_0= ruleEString
            {

                                newCompositeNode(grammarAccess.getExternalDependencyAccess().getNameEStringParserRuleCall_2_0());

            pushFollow(FOLLOW_2);
            lv_name_2_0=ruleEString();

            state._fsp--;


                                if (current==null) {
                                    current = createModelElementForParent(grammarAccess.getExternalDependencyRule());
                                }
                                set(
                                    current,
                                    "name",
                                    lv_name_2_0,
                                    "de.fraunhofer.ipa.ros.Basics.EString");
                                afterParserOrEnumRuleCall();


            }


            }


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExternalDependency"


    // $ANTLR start "entryRuleNamespace"
    // InternalRosParser.g:1790:1: entryRuleNamespace returns [EObject current=null] : iv_ruleNamespace= ruleNamespace EOF ;
    public final EObject entryRuleNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamespace = null;


        try {
            // InternalRosParser.g:1790:50: (iv_ruleNamespace= ruleNamespace EOF )
            // InternalRosParser.g:1791:2: iv_ruleNamespace= ruleNamespace EOF
            {
             newCompositeNode(grammarAccess.getNamespaceRule());
            pushFollow(FOLLOW_1);
            iv_ruleNamespace=ruleNamespace();

            state._fsp--;

             current =iv_ruleNamespace;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNamespace"


    // $ANTLR start "ruleNamespace"
    // InternalRosParser.g:1797:1: ruleNamespace returns [EObject current=null] : (this_GlobalNamespace_0= ruleGlobalNamespace | this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl | this_PrivateNamespace_2= rulePrivateNamespace ) ;
    public final EObject ruleNamespace() throws RecognitionException {
        EObject current = null;

        EObject this_GlobalNamespace_0 = null;

        EObject this_RelativeNamespace_Impl_1 = null;

        EObject this_PrivateNamespace_2 = null;



            enterRule();

        try {
            // InternalRosParser.g:1803:2: ( (this_GlobalNamespace_0= ruleGlobalNamespace | this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl | this_PrivateNamespace_2= rulePrivateNamespace ) )
            // InternalRosParser.g:1804:2: (this_GlobalNamespace_0= ruleGlobalNamespace | this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl | this_PrivateNamespace_2= rulePrivateNamespace )
            {
            // InternalRosParser.g:1804:2: (this_GlobalNamespace_0= ruleGlobalNamespace | this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl | this_PrivateNamespace_2= rulePrivateNamespace )
            int alt31=3;
            switch ( input.LA(1) ) {
            case GlobalNamespace:
                {
                alt31=1;
                }
                break;
            case RelativeNamespace:
                {
                alt31=2;
                }
                break;
            case PrivateNamespace:
                {
                alt31=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // InternalRosParser.g:1805:3: this_GlobalNamespace_0= ruleGlobalNamespace
                    {

                                newCompositeNode(grammarAccess.getNamespaceAccess().getGlobalNamespaceParserRuleCall_0());

                    pushFollow(FOLLOW_2);
                    this_GlobalNamespace_0=ruleGlobalNamespace();

                    state._fsp--;


                                current = this_GlobalNamespace_0;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 2 :
                    // InternalRosParser.g:1814:3: this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl
                    {

                                newCompositeNode(grammarAccess.getNamespaceAccess().getRelativeNamespace_ImplParserRuleCall_1());

                    pushFollow(FOLLOW_2);
                    this_RelativeNamespace_Impl_1=ruleRelativeNamespace_Impl();

                    state._fsp--;


                                current = this_RelativeNamespace_Impl_1;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 3 :
                    // InternalRosParser.g:1823:3: this_PrivateNamespace_2= rulePrivateNamespace
                    {

                                newCompositeNode(grammarAccess.getNamespaceAccess().getPrivateNamespaceParserRuleCall_2());

                    pushFollow(FOLLOW_2);
                    this_PrivateNamespace_2=rulePrivateNamespace();

                    state._fsp--;


                                current = this_PrivateNamespace_2;
                                afterParserOrEnumRuleCall();


                    }
                    break;

            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNamespace"


    // $ANTLR start "entryRuleGraphName"
    // InternalRosParser.g:1835:1: entryRuleGraphName returns [String current=null] : iv_ruleGraphName= ruleGraphName EOF ;
    public final String entryRuleGraphName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleGraphName = null;


        try {
            // InternalRosParser.g:1835:49: (iv_ruleGraphName= ruleGraphName EOF )
            // InternalRosParser.g:1836:2: iv_ruleGraphName= ruleGraphName EOF
            {
             newCompositeNode(grammarAccess.getGraphNameRule());
            pushFollow(FOLLOW_1);
            iv_ruleGraphName=ruleGraphName();

            state._fsp--;

             current =iv_ruleGraphName.getText();
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGraphName"


    // $ANTLR start "ruleGraphName"
    // InternalRosParser.g:1842:1: ruleGraphName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= GraphName ;
    public final AntlrDatatypeRuleToken ruleGraphName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


            enterRule();

        try {
            // InternalRosParser.g:1848:2: (kw= GraphName )
            // InternalRosParser.g:1849:2: kw= GraphName
            {
            kw=(Token)match(input,GraphName,FOLLOW_2);

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getGraphNameAccess().getGraphNameKeyword());


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGraphName"


    // $ANTLR start "entryRuleGlobalNamespace"
    // InternalRosParser.g:1857:1: entryRuleGlobalNamespace returns [EObject current=null] : iv_ruleGlobalNamespace= ruleGlobalNamespace EOF ;
    public final EObject entryRuleGlobalNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGlobalNamespace = null;


        try {
            // InternalRosParser.g:1857:56: (iv_ruleGlobalNamespace= ruleGlobalNamespace EOF )
            // InternalRosParser.g:1858:2: iv_ruleGlobalNamespace= ruleGlobalNamespace EOF
            {
             newCompositeNode(grammarAccess.getGlobalNamespaceRule());
            pushFollow(FOLLOW_1);
            iv_ruleGlobalNamespace=ruleGlobalNamespace();

            state._fsp--;

             current =iv_ruleGlobalNamespace;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGlobalNamespace"


    // $ANTLR start "ruleGlobalNamespace"
    // InternalRosParser.g:1864:1: ruleGlobalNamespace returns [EObject current=null] : ( () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) ;
    public final EObject ruleGlobalNamespace() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_parts_3_0 = null;

        AntlrDatatypeRuleToken lv_parts_5_0 = null;



            enterRule();

        try {
            // InternalRosParser.g:1870:2: ( ( () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) )
            // InternalRosParser.g:1871:2: ( () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            {
            // InternalRosParser.g:1871:2: ( () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            // InternalRosParser.g:1872:3: () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            {
            // InternalRosParser.g:1872:3: ()
            // InternalRosParser.g:1873:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getGlobalNamespaceAccess().getGlobalNamespaceAction_0(),
                                current);


            }

            otherlv_1=(Token)match(input,GlobalNamespace,FOLLOW_37);

                        newLeafNode(otherlv_1, grammarAccess.getGlobalNamespaceAccess().getGlobalNamespaceKeyword_1());

            // InternalRosParser.g:1883:3: (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==LeftSquareBracket) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalRosParser.g:1884:4: otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket
                    {
                    otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_38);

                                    newLeafNode(otherlv_2, grammarAccess.getGlobalNamespaceAccess().getLeftSquareBracketKeyword_2_0());

                    // InternalRosParser.g:1888:4: ( (lv_parts_3_0= ruleGraphName ) )
                    // InternalRosParser.g:1889:5: (lv_parts_3_0= ruleGraphName )
                    {
                    // InternalRosParser.g:1889:5: (lv_parts_3_0= ruleGraphName )
                    // InternalRosParser.g:1890:6: lv_parts_3_0= ruleGraphName
                    {

                                            newCompositeNode(grammarAccess.getGlobalNamespaceAccess().getPartsGraphNameParserRuleCall_2_1_0());

                    pushFollow(FOLLOW_13);
                    lv_parts_3_0=ruleGraphName();

                    state._fsp--;


                                            if (current==null) {
                                                current = createModelElementForParent(grammarAccess.getGlobalNamespaceRule());
                                            }
                                            add(
                                                current,
                                                "parts",
                                                lv_parts_3_0,
                                                "de.fraunhofer.ipa.ros.Basics.GraphName");
                                            afterParserOrEnumRuleCall();


                    }


                    }

                    // InternalRosParser.g:1907:4: (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==Comma) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                        case 1 :
                            // InternalRosParser.g:1908:5: otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) )
                            {
                            otherlv_4=(Token)match(input,Comma,FOLLOW_38);

                                                newLeafNode(otherlv_4, grammarAccess.getGlobalNamespaceAccess().getCommaKeyword_2_2_0());

                            // InternalRosParser.g:1912:5: ( (lv_parts_5_0= ruleGraphName ) )
                            // InternalRosParser.g:1913:6: (lv_parts_5_0= ruleGraphName )
                            {
                            // InternalRosParser.g:1913:6: (lv_parts_5_0= ruleGraphName )
                            // InternalRosParser.g:1914:7: lv_parts_5_0= ruleGraphName
                            {

                                                        newCompositeNode(grammarAccess.getGlobalNamespaceAccess().getPartsGraphNameParserRuleCall_2_2_1_0());

                            pushFollow(FOLLOW_13);
                            lv_parts_5_0=ruleGraphName();

                            state._fsp--;


                                                        if (current==null) {
                                                            current = createModelElementForParent(grammarAccess.getGlobalNamespaceRule());
                                                        }
                                                        add(
                                                            current,
                                                            "parts",
                                                            lv_parts_5_0,
                                                            "de.fraunhofer.ipa.ros.Basics.GraphName");
                                                        afterParserOrEnumRuleCall();


                            }


                            }


                            }
                            break;

                        default :
                            break loop32;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,RightSquareBracket,FOLLOW_2);

                                    newLeafNode(otherlv_6, grammarAccess.getGlobalNamespaceAccess().getRightSquareBracketKeyword_2_3());


                    }
                    break;

            }


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGlobalNamespace"


    // $ANTLR start "entryRuleRelativeNamespace_Impl"
    // InternalRosParser.g:1941:1: entryRuleRelativeNamespace_Impl returns [EObject current=null] : iv_ruleRelativeNamespace_Impl= ruleRelativeNamespace_Impl EOF ;
    public final EObject entryRuleRelativeNamespace_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelativeNamespace_Impl = null;


        try {
            // InternalRosParser.g:1941:63: (iv_ruleRelativeNamespace_Impl= ruleRelativeNamespace_Impl EOF )
            // InternalRosParser.g:1942:2: iv_ruleRelativeNamespace_Impl= ruleRelativeNamespace_Impl EOF
            {
             newCompositeNode(grammarAccess.getRelativeNamespace_ImplRule());
            pushFollow(FOLLOW_1);
            iv_ruleRelativeNamespace_Impl=ruleRelativeNamespace_Impl();

            state._fsp--;

             current =iv_ruleRelativeNamespace_Impl;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelativeNamespace_Impl"


    // $ANTLR start "ruleRelativeNamespace_Impl"
    // InternalRosParser.g:1948:1: ruleRelativeNamespace_Impl returns [EObject current=null] : ( () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) ;
    public final EObject ruleRelativeNamespace_Impl() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_parts_3_0 = null;

        AntlrDatatypeRuleToken lv_parts_5_0 = null;



            enterRule();

        try {
            // InternalRosParser.g:1954:2: ( ( () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) )
            // InternalRosParser.g:1955:2: ( () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            {
            // InternalRosParser.g:1955:2: ( () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            // InternalRosParser.g:1956:3: () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            {
            // InternalRosParser.g:1956:3: ()
            // InternalRosParser.g:1957:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getRelativeNamespace_ImplAccess().getRelativeNamespaceAction_0(),
                                current);


            }

            otherlv_1=(Token)match(input,RelativeNamespace,FOLLOW_37);

                        newLeafNode(otherlv_1, grammarAccess.getRelativeNamespace_ImplAccess().getRelativeNamespaceKeyword_1());

            // InternalRosParser.g:1967:3: (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==LeftSquareBracket) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalRosParser.g:1968:4: otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket
                    {
                    otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_38);

                                    newLeafNode(otherlv_2, grammarAccess.getRelativeNamespace_ImplAccess().getLeftSquareBracketKeyword_2_0());

                    // InternalRosParser.g:1972:4: ( (lv_parts_3_0= ruleGraphName ) )
                    // InternalRosParser.g:1973:5: (lv_parts_3_0= ruleGraphName )
                    {
                    // InternalRosParser.g:1973:5: (lv_parts_3_0= ruleGraphName )
                    // InternalRosParser.g:1974:6: lv_parts_3_0= ruleGraphName
                    {

                                            newCompositeNode(grammarAccess.getRelativeNamespace_ImplAccess().getPartsGraphNameParserRuleCall_2_1_0());

                    pushFollow(FOLLOW_13);
                    lv_parts_3_0=ruleGraphName();

                    state._fsp--;


                                            if (current==null) {
                                                current = createModelElementForParent(grammarAccess.getRelativeNamespace_ImplRule());
                                            }
                                            add(
                                                current,
                                                "parts",
                                                lv_parts_3_0,
                                                "de.fraunhofer.ipa.ros.Basics.GraphName");
                                            afterParserOrEnumRuleCall();


                    }


                    }

                    // InternalRosParser.g:1991:4: (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==Comma) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                        case 1 :
                            // InternalRosParser.g:1992:5: otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) )
                            {
                            otherlv_4=(Token)match(input,Comma,FOLLOW_38);

                                                newLeafNode(otherlv_4, grammarAccess.getRelativeNamespace_ImplAccess().getCommaKeyword_2_2_0());

                            // InternalRosParser.g:1996:5: ( (lv_parts_5_0= ruleGraphName ) )
                            // InternalRosParser.g:1997:6: (lv_parts_5_0= ruleGraphName )
                            {
                            // InternalRosParser.g:1997:6: (lv_parts_5_0= ruleGraphName )
                            // InternalRosParser.g:1998:7: lv_parts_5_0= ruleGraphName
                            {

                                                        newCompositeNode(grammarAccess.getRelativeNamespace_ImplAccess().getPartsGraphNameParserRuleCall_2_2_1_0());

                            pushFollow(FOLLOW_13);
                            lv_parts_5_0=ruleGraphName();

                            state._fsp--;


                                                        if (current==null) {
                                                            current = createModelElementForParent(grammarAccess.getRelativeNamespace_ImplRule());
                                                        }
                                                        add(
                                                            current,
                                                            "parts",
                                                            lv_parts_5_0,
                                                            "de.fraunhofer.ipa.ros.Basics.GraphName");
                                                        afterParserOrEnumRuleCall();


                            }


                            }


                            }
                            break;

                        default :
                            break loop34;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,RightSquareBracket,FOLLOW_2);

                                    newLeafNode(otherlv_6, grammarAccess.getRelativeNamespace_ImplAccess().getRightSquareBracketKeyword_2_3());


                    }
                    break;

            }


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelativeNamespace_Impl"


    // $ANTLR start "entryRulePrivateNamespace"
    // InternalRosParser.g:2025:1: entryRulePrivateNamespace returns [EObject current=null] : iv_rulePrivateNamespace= rulePrivateNamespace EOF ;
    public final EObject entryRulePrivateNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrivateNamespace = null;


        try {
            // InternalRosParser.g:2025:57: (iv_rulePrivateNamespace= rulePrivateNamespace EOF )
            // InternalRosParser.g:2026:2: iv_rulePrivateNamespace= rulePrivateNamespace EOF
            {
             newCompositeNode(grammarAccess.getPrivateNamespaceRule());
            pushFollow(FOLLOW_1);
            iv_rulePrivateNamespace=rulePrivateNamespace();

            state._fsp--;

             current =iv_rulePrivateNamespace;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrivateNamespace"


    // $ANTLR start "rulePrivateNamespace"
    // InternalRosParser.g:2032:1: rulePrivateNamespace returns [EObject current=null] : ( () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) ;
    public final EObject rulePrivateNamespace() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_parts_3_0 = null;

        AntlrDatatypeRuleToken lv_parts_5_0 = null;



            enterRule();

        try {
            // InternalRosParser.g:2038:2: ( ( () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) )
            // InternalRosParser.g:2039:2: ( () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            {
            // InternalRosParser.g:2039:2: ( () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            // InternalRosParser.g:2040:3: () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            {
            // InternalRosParser.g:2040:3: ()
            // InternalRosParser.g:2041:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getPrivateNamespaceAccess().getPrivateNamespaceAction_0(),
                                current);


            }

            otherlv_1=(Token)match(input,PrivateNamespace,FOLLOW_37);

                        newLeafNode(otherlv_1, grammarAccess.getPrivateNamespaceAccess().getPrivateNamespaceKeyword_1());

            // InternalRosParser.g:2051:3: (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==LeftSquareBracket) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalRosParser.g:2052:4: otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket
                    {
                    otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_38);

                                    newLeafNode(otherlv_2, grammarAccess.getPrivateNamespaceAccess().getLeftSquareBracketKeyword_2_0());

                    // InternalRosParser.g:2056:4: ( (lv_parts_3_0= ruleGraphName ) )
                    // InternalRosParser.g:2057:5: (lv_parts_3_0= ruleGraphName )
                    {
                    // InternalRosParser.g:2057:5: (lv_parts_3_0= ruleGraphName )
                    // InternalRosParser.g:2058:6: lv_parts_3_0= ruleGraphName
                    {

                                            newCompositeNode(grammarAccess.getPrivateNamespaceAccess().getPartsGraphNameParserRuleCall_2_1_0());

                    pushFollow(FOLLOW_13);
                    lv_parts_3_0=ruleGraphName();

                    state._fsp--;


                                            if (current==null) {
                                                current = createModelElementForParent(grammarAccess.getPrivateNamespaceRule());
                                            }
                                            add(
                                                current,
                                                "parts",
                                                lv_parts_3_0,
                                                "de.fraunhofer.ipa.ros.Basics.GraphName");
                                            afterParserOrEnumRuleCall();


                    }


                    }

                    // InternalRosParser.g:2075:4: (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )*
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==Comma) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                        case 1 :
                            // InternalRosParser.g:2076:5: otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) )
                            {
                            otherlv_4=(Token)match(input,Comma,FOLLOW_38);

                                                newLeafNode(otherlv_4, grammarAccess.getPrivateNamespaceAccess().getCommaKeyword_2_2_0());

                            // InternalRosParser.g:2080:5: ( (lv_parts_5_0= ruleGraphName ) )
                            // InternalRosParser.g:2081:6: (lv_parts_5_0= ruleGraphName )
                            {
                            // InternalRosParser.g:2081:6: (lv_parts_5_0= ruleGraphName )
                            // InternalRosParser.g:2082:7: lv_parts_5_0= ruleGraphName
                            {

                                                        newCompositeNode(grammarAccess.getPrivateNamespaceAccess().getPartsGraphNameParserRuleCall_2_2_1_0());

                            pushFollow(FOLLOW_13);
                            lv_parts_5_0=ruleGraphName();

                            state._fsp--;


                                                        if (current==null) {
                                                            current = createModelElementForParent(grammarAccess.getPrivateNamespaceRule());
                                                        }
                                                        add(
                                                            current,
                                                            "parts",
                                                            lv_parts_5_0,
                                                            "de.fraunhofer.ipa.ros.Basics.GraphName");
                                                        afterParserOrEnumRuleCall();


                            }


                            }


                            }
                            break;

                        default :
                            break loop36;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,RightSquareBracket,FOLLOW_2);

                                    newLeafNode(otherlv_6, grammarAccess.getPrivateNamespaceAccess().getRightSquareBracketKeyword_2_3());


                    }
                    break;

            }


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrivateNamespace"


    // $ANTLR start "entryRuleParameter"
    // InternalRosParser.g:2109:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalRosParser.g:2109:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalRosParser.g:2110:2: iv_ruleParameter= ruleParameter EOF
            {
             newCompositeNode(grammarAccess.getParameterRule());
            pushFollow(FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalRosParser.g:2116:1: ruleParameter returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= Ns ( (lv_namespace_5_0= ruleNamespace ) ) )? otherlv_6= Type_1 ( (lv_type_7_0= ruleParameterType ) ) (otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) ) )? this_END_10= RULE_END ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token this_END_10=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_namespace_5_0 = null;

        EObject lv_type_7_0 = null;

        EObject lv_value_9_0 = null;



            enterRule();

        try {
            // InternalRosParser.g:2122:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= Ns ( (lv_namespace_5_0= ruleNamespace ) ) )? otherlv_6= Type_1 ( (lv_type_7_0= ruleParameterType ) ) (otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) ) )? this_END_10= RULE_END ) )
            // InternalRosParser.g:2123:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= Ns ( (lv_namespace_5_0= ruleNamespace ) ) )? otherlv_6= Type_1 ( (lv_type_7_0= ruleParameterType ) ) (otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) ) )? this_END_10= RULE_END )
            {
            // InternalRosParser.g:2123:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= Ns ( (lv_namespace_5_0= ruleNamespace ) ) )? otherlv_6= Type_1 ( (lv_type_7_0= ruleParameterType ) ) (otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) ) )? this_END_10= RULE_END )
            // InternalRosParser.g:2124:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= Ns ( (lv_namespace_5_0= ruleNamespace ) ) )? otherlv_6= Type_1 ( (lv_type_7_0= ruleParameterType ) ) (otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) ) )? this_END_10= RULE_END
            {
            // InternalRosParser.g:2124:3: ()
            // InternalRosParser.g:2125:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getParameterAccess().getParameterAction_0(),
                                current);


            }

            // InternalRosParser.g:2131:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRosParser.g:2132:4: (lv_name_1_0= ruleEString )
            {
            // InternalRosParser.g:2132:4: (lv_name_1_0= ruleEString )
            // InternalRosParser.g:2133:5: lv_name_1_0= ruleEString
            {

                                newCompositeNode(grammarAccess.getParameterAccess().getNameEStringParserRuleCall_1_0());

            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


                                if (current==null) {
                                    current = createModelElementForParent(grammarAccess.getParameterRule());
                                }
                                set(
                                    current,
                                    "name",
                                    lv_name_1_0,
                                    "de.fraunhofer.ipa.ros.Basics.EString");
                                afterParserOrEnumRuleCall();


            }


            }

            otherlv_2=(Token)match(input,Colon,FOLLOW_5);

                        newLeafNode(otherlv_2, grammarAccess.getParameterAccess().getColonKeyword_2());

            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_39);

                        newLeafNode(this_BEGIN_3, grammarAccess.getParameterAccess().getBEGINTerminalRuleCall_3());

            // InternalRosParser.g:2158:3: (otherlv_4= Ns ( (lv_namespace_5_0= ruleNamespace ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==Ns) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalRosParser.g:2159:4: otherlv_4= Ns ( (lv_namespace_5_0= ruleNamespace ) )
                    {
                    otherlv_4=(Token)match(input,Ns,FOLLOW_36);

                                    newLeafNode(otherlv_4, grammarAccess.getParameterAccess().getNsKeyword_4_0());

                    // InternalRosParser.g:2163:4: ( (lv_namespace_5_0= ruleNamespace ) )
                    // InternalRosParser.g:2164:5: (lv_namespace_5_0= ruleNamespace )
                    {
                    // InternalRosParser.g:2164:5: (lv_namespace_5_0= ruleNamespace )
                    // InternalRosParser.g:2165:6: lv_namespace_5_0= ruleNamespace
                    {

                                            newCompositeNode(grammarAccess.getParameterAccess().getNamespaceNamespaceParserRuleCall_4_1_0());

                    pushFollow(FOLLOW_34);
                    lv_namespace_5_0=ruleNamespace();

                    state._fsp--;


                                            if (current==null) {
                                                current = createModelElementForParent(grammarAccess.getParameterRule());
                                            }
                                            set(
                                                current,
                                                "namespace",
                                                lv_namespace_5_0,
                                                "de.fraunhofer.ipa.ros.Basics.Namespace");
                                            afterParserOrEnumRuleCall();


                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,Type_1,FOLLOW_40);

                        newLeafNode(otherlv_6, grammarAccess.getParameterAccess().getTypeKeyword_5());

            // InternalRosParser.g:2187:3: ( (lv_type_7_0= ruleParameterType ) )
            // InternalRosParser.g:2188:4: (lv_type_7_0= ruleParameterType )
            {
            // InternalRosParser.g:2188:4: (lv_type_7_0= ruleParameterType )
            // InternalRosParser.g:2189:5: lv_type_7_0= ruleParameterType
            {

                                newCompositeNode(grammarAccess.getParameterAccess().getTypeParameterTypeParserRuleCall_6_0());

            pushFollow(FOLLOW_41);
            lv_type_7_0=ruleParameterType();

            state._fsp--;


                                if (current==null) {
                                    current = createModelElementForParent(grammarAccess.getParameterRule());
                                }
                                set(
                                    current,
                                    "type",
                                    lv_type_7_0,
                                    "de.fraunhofer.ipa.ros.Basics.ParameterType");
                                afterParserOrEnumRuleCall();


            }


            }

            // InternalRosParser.g:2206:3: (otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==Value_1) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalRosParser.g:2207:4: otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) )
                    {
                    otherlv_8=(Token)match(input,Value_1,FOLLOW_42);

                                    newLeafNode(otherlv_8, grammarAccess.getParameterAccess().getValueKeyword_7_0());

                    // InternalRosParser.g:2211:4: ( (lv_value_9_0= ruleParameterValue ) )
                    // InternalRosParser.g:2212:5: (lv_value_9_0= ruleParameterValue )
                    {
                    // InternalRosParser.g:2212:5: (lv_value_9_0= ruleParameterValue )
                    // InternalRosParser.g:2213:6: lv_value_9_0= ruleParameterValue
                    {

                                            newCompositeNode(grammarAccess.getParameterAccess().getValueParameterValueParserRuleCall_7_1_0());

                    pushFollow(FOLLOW_14);
                    lv_value_9_0=ruleParameterValue();

                    state._fsp--;


                                            if (current==null) {
                                                current = createModelElementForParent(grammarAccess.getParameterRule());
                                            }
                                            set(
                                                current,
                                                "value",
                                                lv_value_9_0,
                                                "de.fraunhofer.ipa.ros.Basics.ParameterValue");
                                            afterParserOrEnumRuleCall();


                    }


                    }


                    }
                    break;

            }

            this_END_10=(Token)match(input,RULE_END,FOLLOW_2);

                        newLeafNode(this_END_10, grammarAccess.getParameterAccess().getENDTerminalRuleCall_8());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleParameterType"
    // InternalRosParser.g:2239:1: entryRuleParameterType returns [EObject current=null] : iv_ruleParameterType= ruleParameterType EOF ;
    public final EObject entryRuleParameterType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterType = null;


        try {
            // InternalRosParser.g:2239:54: (iv_ruleParameterType= ruleParameterType EOF )
            // InternalRosParser.g:2240:2: iv_ruleParameterType= ruleParameterType EOF
            {
             newCompositeNode(grammarAccess.getParameterTypeRule());
            pushFollow(FOLLOW_1);
            iv_ruleParameterType=ruleParameterType();

            state._fsp--;

             current =iv_ruleParameterType;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterType"


    // $ANTLR start "ruleParameterType"
    // InternalRosParser.g:2246:1: ruleParameterType returns [EObject current=null] : (this_ParameterListType_0= ruleParameterListType | this_ParameterStructType_1= ruleParameterStructType | this_ParameterIntegerType_2= ruleParameterIntegerType | this_ParameterStringType_3= ruleParameterStringType | this_ParameterDoubleType_4= ruleParameterDoubleType | this_ParameterBooleanType_5= ruleParameterBooleanType | this_ParameterBase64Type_6= ruleParameterBase64Type | this_ParameterArrayType_7= ruleParameterArrayType ) ;
    public final EObject ruleParameterType() throws RecognitionException {
        EObject current = null;

        EObject this_ParameterListType_0 = null;

        EObject this_ParameterStructType_1 = null;

        EObject this_ParameterIntegerType_2 = null;

        EObject this_ParameterStringType_3 = null;

        EObject this_ParameterDoubleType_4 = null;

        EObject this_ParameterBooleanType_5 = null;

        EObject this_ParameterBase64Type_6 = null;

        EObject this_ParameterArrayType_7 = null;



            enterRule();

        try {
            // InternalRosParser.g:2252:2: ( (this_ParameterListType_0= ruleParameterListType | this_ParameterStructType_1= ruleParameterStructType | this_ParameterIntegerType_2= ruleParameterIntegerType | this_ParameterStringType_3= ruleParameterStringType | this_ParameterDoubleType_4= ruleParameterDoubleType | this_ParameterBooleanType_5= ruleParameterBooleanType | this_ParameterBase64Type_6= ruleParameterBase64Type | this_ParameterArrayType_7= ruleParameterArrayType ) )
            // InternalRosParser.g:2253:2: (this_ParameterListType_0= ruleParameterListType | this_ParameterStructType_1= ruleParameterStructType | this_ParameterIntegerType_2= ruleParameterIntegerType | this_ParameterStringType_3= ruleParameterStringType | this_ParameterDoubleType_4= ruleParameterDoubleType | this_ParameterBooleanType_5= ruleParameterBooleanType | this_ParameterBase64Type_6= ruleParameterBase64Type | this_ParameterArrayType_7= ruleParameterArrayType )
            {
            // InternalRosParser.g:2253:2: (this_ParameterListType_0= ruleParameterListType | this_ParameterStructType_1= ruleParameterStructType | this_ParameterIntegerType_2= ruleParameterIntegerType | this_ParameterStringType_3= ruleParameterStringType | this_ParameterDoubleType_4= ruleParameterDoubleType | this_ParameterBooleanType_5= ruleParameterBooleanType | this_ParameterBase64Type_6= ruleParameterBase64Type | this_ParameterArrayType_7= ruleParameterArrayType )
            int alt40=8;
            switch ( input.LA(1) ) {
            case List:
                {
                alt40=1;
                }
                break;
            case Struct:
                {
                alt40=2;
                }
                break;
            case Integer:
                {
                alt40=3;
                }
                break;
            case String:
                {
                alt40=4;
                }
                break;
            case Double:
                {
                alt40=5;
                }
                break;
            case Boolean:
                {
                alt40=6;
                }
                break;
            case Base64:
                {
                alt40=7;
                }
                break;
            case Array:
                {
                alt40=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // InternalRosParser.g:2254:3: this_ParameterListType_0= ruleParameterListType
                    {

                                newCompositeNode(grammarAccess.getParameterTypeAccess().getParameterListTypeParserRuleCall_0());

                    pushFollow(FOLLOW_2);
                    this_ParameterListType_0=ruleParameterListType();

                    state._fsp--;


                                current = this_ParameterListType_0;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 2 :
                    // InternalRosParser.g:2263:3: this_ParameterStructType_1= ruleParameterStructType
                    {

                                newCompositeNode(grammarAccess.getParameterTypeAccess().getParameterStructTypeParserRuleCall_1());

                    pushFollow(FOLLOW_2);
                    this_ParameterStructType_1=ruleParameterStructType();

                    state._fsp--;


                                current = this_ParameterStructType_1;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 3 :
                    // InternalRosParser.g:2272:3: this_ParameterIntegerType_2= ruleParameterIntegerType
                    {

                                newCompositeNode(grammarAccess.getParameterTypeAccess().getParameterIntegerTypeParserRuleCall_2());

                    pushFollow(FOLLOW_2);
                    this_ParameterIntegerType_2=ruleParameterIntegerType();

                    state._fsp--;


                                current = this_ParameterIntegerType_2;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 4 :
                    // InternalRosParser.g:2281:3: this_ParameterStringType_3= ruleParameterStringType
                    {

                                newCompositeNode(grammarAccess.getParameterTypeAccess().getParameterStringTypeParserRuleCall_3());

                    pushFollow(FOLLOW_2);
                    this_ParameterStringType_3=ruleParameterStringType();

                    state._fsp--;


                                current = this_ParameterStringType_3;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 5 :
                    // InternalRosParser.g:2290:3: this_ParameterDoubleType_4= ruleParameterDoubleType
                    {

                                newCompositeNode(grammarAccess.getParameterTypeAccess().getParameterDoubleTypeParserRuleCall_4());

                    pushFollow(FOLLOW_2);
                    this_ParameterDoubleType_4=ruleParameterDoubleType();

                    state._fsp--;


                                current = this_ParameterDoubleType_4;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 6 :
                    // InternalRosParser.g:2299:3: this_ParameterBooleanType_5= ruleParameterBooleanType
                    {

                                newCompositeNode(grammarAccess.getParameterTypeAccess().getParameterBooleanTypeParserRuleCall_5());

                    pushFollow(FOLLOW_2);
                    this_ParameterBooleanType_5=ruleParameterBooleanType();

                    state._fsp--;


                                current = this_ParameterBooleanType_5;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 7 :
                    // InternalRosParser.g:2308:3: this_ParameterBase64Type_6= ruleParameterBase64Type
                    {

                                newCompositeNode(grammarAccess.getParameterTypeAccess().getParameterBase64TypeParserRuleCall_6());

                    pushFollow(FOLLOW_2);
                    this_ParameterBase64Type_6=ruleParameterBase64Type();

                    state._fsp--;


                                current = this_ParameterBase64Type_6;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 8 :
                    // InternalRosParser.g:2317:3: this_ParameterArrayType_7= ruleParameterArrayType
                    {

                                newCompositeNode(grammarAccess.getParameterTypeAccess().getParameterArrayTypeParserRuleCall_7());

                    pushFollow(FOLLOW_2);
                    this_ParameterArrayType_7=ruleParameterArrayType();

                    state._fsp--;


                                current = this_ParameterArrayType_7;
                                afterParserOrEnumRuleCall();


                    }
                    break;

            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterType"


    // $ANTLR start "entryRuleParameterValue"
    // InternalRosParser.g:2329:1: entryRuleParameterValue returns [EObject current=null] : iv_ruleParameterValue= ruleParameterValue EOF ;
    public final EObject entryRuleParameterValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterValue = null;


        try {
            // InternalRosParser.g:2329:55: (iv_ruleParameterValue= ruleParameterValue EOF )
            // InternalRosParser.g:2330:2: iv_ruleParameterValue= ruleParameterValue EOF
            {
             newCompositeNode(grammarAccess.getParameterValueRule());
            pushFollow(FOLLOW_1);
            iv_ruleParameterValue=ruleParameterValue();

            state._fsp--;

             current =iv_ruleParameterValue;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterValue"


    // $ANTLR start "ruleParameterValue"
    // InternalRosParser.g:2336:1: ruleParameterValue returns [EObject current=null] : (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct ) ;
    public final EObject ruleParameterValue() throws RecognitionException {
        EObject current = null;

        EObject this_ParameterString_0 = null;

        EObject this_ParameterBase64_1 = null;

        EObject this_ParameterInteger_2 = null;

        EObject this_ParameterDouble_3 = null;

        EObject this_ParameterBoolean_4 = null;

        EObject this_ParameterList_5 = null;

        EObject this_ParameterStruct_6 = null;



            enterRule();

        try {
            // InternalRosParser.g:2342:2: ( (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct ) )
            // InternalRosParser.g:2343:2: (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct )
            {
            // InternalRosParser.g:2343:2: (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct )
            int alt41=7;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case RULE_STRING:
                {
                alt41=1;
                }
                break;
            case RULE_BINARY:
                {
                alt41=2;
                }
                break;
            case RULE_DECINT:
                {
                alt41=3;
                }
                break;
            case RULE_DOUBLE:
                {
                alt41=4;
                }
                break;
            case RULE_BOOLEAN:
                {
                alt41=5;
                }
                break;
            case LeftSquareBracket:
                {
                int LA41_6 = input.LA(2);

                if ( (LA41_6==ParameterStructMember) ) {
                    alt41=7;
                }
                else if ( (LA41_6==Comma||(LA41_6>=LeftSquareBracket && LA41_6<=RightSquareBracket)||(LA41_6>=RULE_BINARY && LA41_6<=RULE_DOUBLE)||(LA41_6>=RULE_ID && LA41_6<=RULE_STRING)) ) {
                    alt41=6;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 41, 6, input);

                    throw nvae;
                }
                }
                break;
            case EOF:
            case Comma:
            case RightSquareBracket:
            case RULE_END:
                {
                alt41=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // InternalRosParser.g:2344:3: this_ParameterString_0= ruleParameterString
                    {

                                newCompositeNode(grammarAccess.getParameterValueAccess().getParameterStringParserRuleCall_0());

                    pushFollow(FOLLOW_2);
                    this_ParameterString_0=ruleParameterString();

                    state._fsp--;


                                current = this_ParameterString_0;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 2 :
                    // InternalRosParser.g:2353:3: this_ParameterBase64_1= ruleParameterBase64
                    {

                                newCompositeNode(grammarAccess.getParameterValueAccess().getParameterBase64ParserRuleCall_1());

                    pushFollow(FOLLOW_2);
                    this_ParameterBase64_1=ruleParameterBase64();

                    state._fsp--;


                                current = this_ParameterBase64_1;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 3 :
                    // InternalRosParser.g:2362:3: this_ParameterInteger_2= ruleParameterInteger
                    {

                                newCompositeNode(grammarAccess.getParameterValueAccess().getParameterIntegerParserRuleCall_2());

                    pushFollow(FOLLOW_2);
                    this_ParameterInteger_2=ruleParameterInteger();

                    state._fsp--;


                                current = this_ParameterInteger_2;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 4 :
                    // InternalRosParser.g:2371:3: this_ParameterDouble_3= ruleParameterDouble
                    {

                                newCompositeNode(grammarAccess.getParameterValueAccess().getParameterDoubleParserRuleCall_3());

                    pushFollow(FOLLOW_2);
                    this_ParameterDouble_3=ruleParameterDouble();

                    state._fsp--;


                                current = this_ParameterDouble_3;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 5 :
                    // InternalRosParser.g:2380:3: this_ParameterBoolean_4= ruleParameterBoolean
                    {

                                newCompositeNode(grammarAccess.getParameterValueAccess().getParameterBooleanParserRuleCall_4());

                    pushFollow(FOLLOW_2);
                    this_ParameterBoolean_4=ruleParameterBoolean();

                    state._fsp--;


                                current = this_ParameterBoolean_4;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 6 :
                    // InternalRosParser.g:2389:3: this_ParameterList_5= ruleParameterList
                    {

                                newCompositeNode(grammarAccess.getParameterValueAccess().getParameterListParserRuleCall_5());

                    pushFollow(FOLLOW_2);
                    this_ParameterList_5=ruleParameterList();

                    state._fsp--;


                                current = this_ParameterList_5;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 7 :
                    // InternalRosParser.g:2398:3: this_ParameterStruct_6= ruleParameterStruct
                    {

                                newCompositeNode(grammarAccess.getParameterValueAccess().getParameterStructParserRuleCall_6());

                    pushFollow(FOLLOW_2);
                    this_ParameterStruct_6=ruleParameterStruct();

                    state._fsp--;


                                current = this_ParameterStruct_6;
                                afterParserOrEnumRuleCall();


                    }
                    break;

            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterValue"


    // $ANTLR start "entryRuleParameterListType"
    // InternalRosParser.g:2410:1: entryRuleParameterListType returns [EObject current=null] : iv_ruleParameterListType= ruleParameterListType EOF ;
    public final EObject entryRuleParameterListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterListType = null;


        try {
            // InternalRosParser.g:2410:58: (iv_ruleParameterListType= ruleParameterListType EOF )
            // InternalRosParser.g:2411:2: iv_ruleParameterListType= ruleParameterListType EOF
            {
             newCompositeNode(grammarAccess.getParameterListTypeRule());
            pushFollow(FOLLOW_1);
            iv_ruleParameterListType=ruleParameterListType();

            state._fsp--;

             current =iv_ruleParameterListType;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterListType"


    // $ANTLR start "ruleParameterListType"
    // InternalRosParser.g:2417:1: ruleParameterListType returns [EObject current=null] : ( () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket ) ;
    public final EObject ruleParameterListType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_sequence_3_0 = null;

        EObject lv_sequence_5_0 = null;



            enterRule();

        try {
            // InternalRosParser.g:2423:2: ( ( () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket ) )
            // InternalRosParser.g:2424:2: ( () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket )
            {
            // InternalRosParser.g:2424:2: ( () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket )
            // InternalRosParser.g:2425:3: () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket
            {
            // InternalRosParser.g:2425:3: ()
            // InternalRosParser.g:2426:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getParameterListTypeAccess().getParameterListTypeAction_0(),
                                current);


            }

            otherlv_1=(Token)match(input,List,FOLLOW_11);

                        newLeafNode(otherlv_1, grammarAccess.getParameterListTypeAccess().getListKeyword_1());

            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_40);

                        newLeafNode(otherlv_2, grammarAccess.getParameterListTypeAccess().getLeftSquareBracketKeyword_2());

            // InternalRosParser.g:2440:3: ( (lv_sequence_3_0= ruleParameterType ) )
            // InternalRosParser.g:2441:4: (lv_sequence_3_0= ruleParameterType )
            {
            // InternalRosParser.g:2441:4: (lv_sequence_3_0= ruleParameterType )
            // InternalRosParser.g:2442:5: lv_sequence_3_0= ruleParameterType
            {

                                newCompositeNode(grammarAccess.getParameterListTypeAccess().getSequenceParameterTypeParserRuleCall_3_0());

            pushFollow(FOLLOW_13);
            lv_sequence_3_0=ruleParameterType();

            state._fsp--;


                                if (current==null) {
                                    current = createModelElementForParent(grammarAccess.getParameterListTypeRule());
                                }
                                add(
                                    current,
                                    "sequence",
                                    lv_sequence_3_0,
                                    "de.fraunhofer.ipa.ros.Basics.ParameterType");
                                afterParserOrEnumRuleCall();


            }


            }

            // InternalRosParser.g:2459:3: (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==Comma) ) {
                    alt42=1;
                }


                switch (alt42) {
                case 1 :
                    // InternalRosParser.g:2460:4: otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) )
                    {
                    otherlv_4=(Token)match(input,Comma,FOLLOW_40);

                                    newLeafNode(otherlv_4, grammarAccess.getParameterListTypeAccess().getCommaKeyword_4_0());

                    // InternalRosParser.g:2464:4: ( (lv_sequence_5_0= ruleParameterType ) )
                    // InternalRosParser.g:2465:5: (lv_sequence_5_0= ruleParameterType )
                    {
                    // InternalRosParser.g:2465:5: (lv_sequence_5_0= ruleParameterType )
                    // InternalRosParser.g:2466:6: lv_sequence_5_0= ruleParameterType
                    {

                                            newCompositeNode(grammarAccess.getParameterListTypeAccess().getSequenceParameterTypeParserRuleCall_4_1_0());

                    pushFollow(FOLLOW_13);
                    lv_sequence_5_0=ruleParameterType();

                    state._fsp--;


                                            if (current==null) {
                                                current = createModelElementForParent(grammarAccess.getParameterListTypeRule());
                                            }
                                            add(
                                                current,
                                                "sequence",
                                                lv_sequence_5_0,
                                                "de.fraunhofer.ipa.ros.Basics.ParameterType");
                                            afterParserOrEnumRuleCall();


                    }


                    }


                    }
                    break;

                default :
                    break loop42;
                }
            } while (true);

            otherlv_6=(Token)match(input,RightSquareBracket,FOLLOW_2);

                        newLeafNode(otherlv_6, grammarAccess.getParameterListTypeAccess().getRightSquareBracketKeyword_5());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterListType"


    // $ANTLR start "entryRuleParameterStructType"
    // InternalRosParser.g:2492:1: entryRuleParameterStructType returns [EObject current=null] : iv_ruleParameterStructType= ruleParameterStructType EOF ;
    public final EObject entryRuleParameterStructType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStructType = null;


        try {
            // InternalRosParser.g:2492:60: (iv_ruleParameterStructType= ruleParameterStructType EOF )
            // InternalRosParser.g:2493:2: iv_ruleParameterStructType= ruleParameterStructType EOF
            {
             newCompositeNode(grammarAccess.getParameterStructTypeRule());
            pushFollow(FOLLOW_1);
            iv_ruleParameterStructType=ruleParameterStructType();

            state._fsp--;

             current =iv_ruleParameterStructType;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterStructType"


    // $ANTLR start "ruleParameterStructType"
    // InternalRosParser.g:2499:1: ruleParameterStructType returns [EObject current=null] : ( () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket ) ;
    public final EObject ruleParameterStructType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_parameterstructypetmember_3_0 = null;

        EObject lv_parameterstructypetmember_5_0 = null;



            enterRule();

        try {
            // InternalRosParser.g:2505:2: ( ( () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket ) )
            // InternalRosParser.g:2506:2: ( () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket )
            {
            // InternalRosParser.g:2506:2: ( () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket )
            // InternalRosParser.g:2507:3: () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket
            {
            // InternalRosParser.g:2507:3: ()
            // InternalRosParser.g:2508:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getParameterStructTypeAccess().getParameterStructTypeAction_0(),
                                current);


            }

            otherlv_1=(Token)match(input,Struct,FOLLOW_11);

                        newLeafNode(otherlv_1, grammarAccess.getParameterStructTypeAccess().getStructKeyword_1());

            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_7);

                        newLeafNode(otherlv_2, grammarAccess.getParameterStructTypeAccess().getLeftSquareBracketKeyword_2());

            // InternalRosParser.g:2522:3: ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) )
            // InternalRosParser.g:2523:4: (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember )
            {
            // InternalRosParser.g:2523:4: (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember )
            // InternalRosParser.g:2524:5: lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember
            {

                                newCompositeNode(grammarAccess.getParameterStructTypeAccess().getParameterstructypetmemberParameterStructTypeMemberParserRuleCall_3_0());

            pushFollow(FOLLOW_13);
            lv_parameterstructypetmember_3_0=ruleParameterStructTypeMember();

            state._fsp--;


                                if (current==null) {
                                    current = createModelElementForParent(grammarAccess.getParameterStructTypeRule());
                                }
                                add(
                                    current,
                                    "parameterstructypetmember",
                                    lv_parameterstructypetmember_3_0,
                                    "de.fraunhofer.ipa.ros.Basics.ParameterStructTypeMember");
                                afterParserOrEnumRuleCall();


            }


            }

            // InternalRosParser.g:2541:3: (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==Comma) ) {
                    alt43=1;
                }


                switch (alt43) {
                case 1 :
                    // InternalRosParser.g:2542:4: otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) )
                    {
                    otherlv_4=(Token)match(input,Comma,FOLLOW_7);

                                    newLeafNode(otherlv_4, grammarAccess.getParameterStructTypeAccess().getCommaKeyword_4_0());

                    // InternalRosParser.g:2546:4: ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) )
                    // InternalRosParser.g:2547:5: (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember )
                    {
                    // InternalRosParser.g:2547:5: (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember )
                    // InternalRosParser.g:2548:6: lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember
                    {

                                            newCompositeNode(grammarAccess.getParameterStructTypeAccess().getParameterstructypetmemberParameterStructTypeMemberParserRuleCall_4_1_0());

                    pushFollow(FOLLOW_13);
                    lv_parameterstructypetmember_5_0=ruleParameterStructTypeMember();

                    state._fsp--;


                                            if (current==null) {
                                                current = createModelElementForParent(grammarAccess.getParameterStructTypeRule());
                                            }
                                            add(
                                                current,
                                                "parameterstructypetmember",
                                                lv_parameterstructypetmember_5_0,
                                                "de.fraunhofer.ipa.ros.Basics.ParameterStructTypeMember");
                                            afterParserOrEnumRuleCall();


                    }


                    }


                    }
                    break;

                default :
                    break loop43;
                }
            } while (true);

            otherlv_6=(Token)match(input,RightSquareBracket,FOLLOW_2);

                        newLeafNode(otherlv_6, grammarAccess.getParameterStructTypeAccess().getRightSquareBracketKeyword_5());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterStructType"


    // $ANTLR start "entryRuleParameterIntegerType"
    // InternalRosParser.g:2574:1: entryRuleParameterIntegerType returns [EObject current=null] : iv_ruleParameterIntegerType= ruleParameterIntegerType EOF ;
    public final EObject entryRuleParameterIntegerType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterIntegerType = null;


        try {
            // InternalRosParser.g:2574:61: (iv_ruleParameterIntegerType= ruleParameterIntegerType EOF )
            // InternalRosParser.g:2575:2: iv_ruleParameterIntegerType= ruleParameterIntegerType EOF
            {
             newCompositeNode(grammarAccess.getParameterIntegerTypeRule());
            pushFollow(FOLLOW_1);
            iv_ruleParameterIntegerType=ruleParameterIntegerType();

            state._fsp--;

             current =iv_ruleParameterIntegerType;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterIntegerType"


    // $ANTLR start "ruleParameterIntegerType"
    // InternalRosParser.g:2581:1: ruleParameterIntegerType returns [EObject current=null] : ( () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )? ) ;
    public final EObject ruleParameterIntegerType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



            enterRule();

        try {
            // InternalRosParser.g:2587:2: ( ( () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )? ) )
            // InternalRosParser.g:2588:2: ( () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )? )
            {
            // InternalRosParser.g:2588:2: ( () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )? )
            // InternalRosParser.g:2589:3: () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )?
            {
            // InternalRosParser.g:2589:3: ()
            // InternalRosParser.g:2590:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getParameterIntegerTypeAccess().getParameterIntegerTypeAction_0(),
                                current);


            }

            otherlv_1=(Token)match(input,Integer,FOLLOW_43);

                        newLeafNode(otherlv_1, grammarAccess.getParameterIntegerTypeAccess().getIntegerKeyword_1());

            // InternalRosParser.g:2600:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==Default) ) {
                int LA44_1 = input.LA(2);

                if ( (LA44_1==RULE_DECINT) ) {
                    alt44=1;
                }
            }
            switch (alt44) {
                case 1 :
                    // InternalRosParser.g:2601:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_44);

                                    newLeafNode(otherlv_2, grammarAccess.getParameterIntegerTypeAccess().getDefaultKeyword_2_0());

                    // InternalRosParser.g:2605:4: ( (lv_default_3_0= ruleParameterInteger ) )
                    // InternalRosParser.g:2606:5: (lv_default_3_0= ruleParameterInteger )
                    {
                    // InternalRosParser.g:2606:5: (lv_default_3_0= ruleParameterInteger )
                    // InternalRosParser.g:2607:6: lv_default_3_0= ruleParameterInteger
                    {

                                            newCompositeNode(grammarAccess.getParameterIntegerTypeAccess().getDefaultParameterIntegerParserRuleCall_2_1_0());

                    pushFollow(FOLLOW_2);
                    lv_default_3_0=ruleParameterInteger();

                    state._fsp--;


                                            if (current==null) {
                                                current = createModelElementForParent(grammarAccess.getParameterIntegerTypeRule());
                                            }
                                            set(
                                                current,
                                                "default",
                                                lv_default_3_0,
                                                "de.fraunhofer.ipa.ros.Basics.ParameterInteger");
                                            afterParserOrEnumRuleCall();


                    }


                    }


                    }
                    break;

            }


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterIntegerType"


    // $ANTLR start "entryRuleParameterStringType"
    // InternalRosParser.g:2629:1: entryRuleParameterStringType returns [EObject current=null] : iv_ruleParameterStringType= ruleParameterStringType EOF ;
    public final EObject entryRuleParameterStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStringType = null;


        try {
            // InternalRosParser.g:2629:60: (iv_ruleParameterStringType= ruleParameterStringType EOF )
            // InternalRosParser.g:2630:2: iv_ruleParameterStringType= ruleParameterStringType EOF
            {
             newCompositeNode(grammarAccess.getParameterStringTypeRule());
            pushFollow(FOLLOW_1);
            iv_ruleParameterStringType=ruleParameterStringType();

            state._fsp--;

             current =iv_ruleParameterStringType;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterStringType"


    // $ANTLR start "ruleParameterStringType"
    // InternalRosParser.g:2636:1: ruleParameterStringType returns [EObject current=null] : ( () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )? ) ;
    public final EObject ruleParameterStringType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



            enterRule();

        try {
            // InternalRosParser.g:2642:2: ( ( () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )? ) )
            // InternalRosParser.g:2643:2: ( () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )? )
            {
            // InternalRosParser.g:2643:2: ( () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )? )
            // InternalRosParser.g:2644:3: () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )?
            {
            // InternalRosParser.g:2644:3: ()
            // InternalRosParser.g:2645:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getParameterStringTypeAccess().getParameterStringTypeAction_0(),
                                current);


            }

            otherlv_1=(Token)match(input,String,FOLLOW_43);

                        newLeafNode(otherlv_1, grammarAccess.getParameterStringTypeAccess().getStringKeyword_1());

            // InternalRosParser.g:2655:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==Default) ) {
                int LA45_1 = input.LA(2);

                if ( ((LA45_1>=RULE_ID && LA45_1<=RULE_STRING)) ) {
                    alt45=1;
                }
            }
            switch (alt45) {
                case 1 :
                    // InternalRosParser.g:2656:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_7);

                                    newLeafNode(otherlv_2, grammarAccess.getParameterStringTypeAccess().getDefaultKeyword_2_0());

                    // InternalRosParser.g:2660:4: ( (lv_default_3_0= ruleParameterString ) )
                    // InternalRosParser.g:2661:5: (lv_default_3_0= ruleParameterString )
                    {
                    // InternalRosParser.g:2661:5: (lv_default_3_0= ruleParameterString )
                    // InternalRosParser.g:2662:6: lv_default_3_0= ruleParameterString
                    {

                                            newCompositeNode(grammarAccess.getParameterStringTypeAccess().getDefaultParameterStringParserRuleCall_2_1_0());

                    pushFollow(FOLLOW_2);
                    lv_default_3_0=ruleParameterString();

                    state._fsp--;


                                            if (current==null) {
                                                current = createModelElementForParent(grammarAccess.getParameterStringTypeRule());
                                            }
                                            set(
                                                current,
                                                "default",
                                                lv_default_3_0,
                                                "de.fraunhofer.ipa.ros.Basics.ParameterString");
                                            afterParserOrEnumRuleCall();


                    }


                    }


                    }
                    break;

            }


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterStringType"


    // $ANTLR start "entryRuleParameterDoubleType"
    // InternalRosParser.g:2684:1: entryRuleParameterDoubleType returns [EObject current=null] : iv_ruleParameterDoubleType= ruleParameterDoubleType EOF ;
    public final EObject entryRuleParameterDoubleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterDoubleType = null;


        try {
            // InternalRosParser.g:2684:60: (iv_ruleParameterDoubleType= ruleParameterDoubleType EOF )
            // InternalRosParser.g:2685:2: iv_ruleParameterDoubleType= ruleParameterDoubleType EOF
            {
             newCompositeNode(grammarAccess.getParameterDoubleTypeRule());
            pushFollow(FOLLOW_1);
            iv_ruleParameterDoubleType=ruleParameterDoubleType();

            state._fsp--;

             current =iv_ruleParameterDoubleType;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterDoubleType"


    // $ANTLR start "ruleParameterDoubleType"
    // InternalRosParser.g:2691:1: ruleParameterDoubleType returns [EObject current=null] : ( () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )? ) ;
    public final EObject ruleParameterDoubleType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



            enterRule();

        try {
            // InternalRosParser.g:2697:2: ( ( () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )? ) )
            // InternalRosParser.g:2698:2: ( () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )? )
            {
            // InternalRosParser.g:2698:2: ( () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )? )
            // InternalRosParser.g:2699:3: () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )?
            {
            // InternalRosParser.g:2699:3: ()
            // InternalRosParser.g:2700:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getParameterDoubleTypeAccess().getParameterDoubleTypeAction_0(),
                                current);


            }

            otherlv_1=(Token)match(input,Double,FOLLOW_43);

                        newLeafNode(otherlv_1, grammarAccess.getParameterDoubleTypeAccess().getDoubleKeyword_1());

            // InternalRosParser.g:2710:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==Default) ) {
                int LA46_1 = input.LA(2);

                if ( (LA46_1==RULE_DOUBLE) ) {
                    alt46=1;
                }
            }
            switch (alt46) {
                case 1 :
                    // InternalRosParser.g:2711:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_45);

                                    newLeafNode(otherlv_2, grammarAccess.getParameterDoubleTypeAccess().getDefaultKeyword_2_0());

                    // InternalRosParser.g:2715:4: ( (lv_default_3_0= ruleParameterDouble ) )
                    // InternalRosParser.g:2716:5: (lv_default_3_0= ruleParameterDouble )
                    {
                    // InternalRosParser.g:2716:5: (lv_default_3_0= ruleParameterDouble )
                    // InternalRosParser.g:2717:6: lv_default_3_0= ruleParameterDouble
                    {

                                            newCompositeNode(grammarAccess.getParameterDoubleTypeAccess().getDefaultParameterDoubleParserRuleCall_2_1_0());

                    pushFollow(FOLLOW_2);
                    lv_default_3_0=ruleParameterDouble();

                    state._fsp--;


                                            if (current==null) {
                                                current = createModelElementForParent(grammarAccess.getParameterDoubleTypeRule());
                                            }
                                            set(
                                                current,
                                                "default",
                                                lv_default_3_0,
                                                "de.fraunhofer.ipa.ros.Basics.ParameterDouble");
                                            afterParserOrEnumRuleCall();


                    }


                    }


                    }
                    break;

            }


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterDoubleType"


    // $ANTLR start "entryRuleParameterBooleanType"
    // InternalRosParser.g:2739:1: entryRuleParameterBooleanType returns [EObject current=null] : iv_ruleParameterBooleanType= ruleParameterBooleanType EOF ;
    public final EObject entryRuleParameterBooleanType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterBooleanType = null;


        try {
            // InternalRosParser.g:2739:61: (iv_ruleParameterBooleanType= ruleParameterBooleanType EOF )
            // InternalRosParser.g:2740:2: iv_ruleParameterBooleanType= ruleParameterBooleanType EOF
            {
             newCompositeNode(grammarAccess.getParameterBooleanTypeRule());
            pushFollow(FOLLOW_1);
            iv_ruleParameterBooleanType=ruleParameterBooleanType();

            state._fsp--;

             current =iv_ruleParameterBooleanType;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterBooleanType"


    // $ANTLR start "ruleParameterBooleanType"
    // InternalRosParser.g:2746:1: ruleParameterBooleanType returns [EObject current=null] : ( () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )? ) ;
    public final EObject ruleParameterBooleanType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



            enterRule();

        try {
            // InternalRosParser.g:2752:2: ( ( () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )? ) )
            // InternalRosParser.g:2753:2: ( () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )? )
            {
            // InternalRosParser.g:2753:2: ( () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )? )
            // InternalRosParser.g:2754:3: () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )?
            {
            // InternalRosParser.g:2754:3: ()
            // InternalRosParser.g:2755:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getParameterBooleanTypeAccess().getParameterBooleanTypeAction_0(),
                                current);


            }

            otherlv_1=(Token)match(input,Boolean,FOLLOW_43);

                        newLeafNode(otherlv_1, grammarAccess.getParameterBooleanTypeAccess().getBooleanKeyword_1());

            // InternalRosParser.g:2765:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==Default) ) {
                int LA47_1 = input.LA(2);

                if ( (LA47_1==RULE_BOOLEAN) ) {
                    alt47=1;
                }
            }
            switch (alt47) {
                case 1 :
                    // InternalRosParser.g:2766:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_46);

                                    newLeafNode(otherlv_2, grammarAccess.getParameterBooleanTypeAccess().getDefaultKeyword_2_0());

                    // InternalRosParser.g:2770:4: ( (lv_default_3_0= ruleParameterBoolean ) )
                    // InternalRosParser.g:2771:5: (lv_default_3_0= ruleParameterBoolean )
                    {
                    // InternalRosParser.g:2771:5: (lv_default_3_0= ruleParameterBoolean )
                    // InternalRosParser.g:2772:6: lv_default_3_0= ruleParameterBoolean
                    {

                                            newCompositeNode(grammarAccess.getParameterBooleanTypeAccess().getDefaultParameterBooleanParserRuleCall_2_1_0());

                    pushFollow(FOLLOW_2);
                    lv_default_3_0=ruleParameterBoolean();

                    state._fsp--;


                                            if (current==null) {
                                                current = createModelElementForParent(grammarAccess.getParameterBooleanTypeRule());
                                            }
                                            set(
                                                current,
                                                "default",
                                                lv_default_3_0,
                                                "de.fraunhofer.ipa.ros.Basics.ParameterBoolean");
                                            afterParserOrEnumRuleCall();


                    }


                    }


                    }
                    break;

            }


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterBooleanType"


    // $ANTLR start "entryRuleParameterBase64Type"
    // InternalRosParser.g:2794:1: entryRuleParameterBase64Type returns [EObject current=null] : iv_ruleParameterBase64Type= ruleParameterBase64Type EOF ;
    public final EObject entryRuleParameterBase64Type() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterBase64Type = null;


        try {
            // InternalRosParser.g:2794:60: (iv_ruleParameterBase64Type= ruleParameterBase64Type EOF )
            // InternalRosParser.g:2795:2: iv_ruleParameterBase64Type= ruleParameterBase64Type EOF
            {
             newCompositeNode(grammarAccess.getParameterBase64TypeRule());
            pushFollow(FOLLOW_1);
            iv_ruleParameterBase64Type=ruleParameterBase64Type();

            state._fsp--;

             current =iv_ruleParameterBase64Type;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterBase64Type"


    // $ANTLR start "ruleParameterBase64Type"
    // InternalRosParser.g:2801:1: ruleParameterBase64Type returns [EObject current=null] : ( () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )? ) ;
    public final EObject ruleParameterBase64Type() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



            enterRule();

        try {
            // InternalRosParser.g:2807:2: ( ( () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )? ) )
            // InternalRosParser.g:2808:2: ( () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )? )
            {
            // InternalRosParser.g:2808:2: ( () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )? )
            // InternalRosParser.g:2809:3: () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )?
            {
            // InternalRosParser.g:2809:3: ()
            // InternalRosParser.g:2810:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getParameterBase64TypeAccess().getParameterBase64TypeAction_0(),
                                current);


            }

            otherlv_1=(Token)match(input,Base64,FOLLOW_43);

                        newLeafNode(otherlv_1, grammarAccess.getParameterBase64TypeAccess().getBase64Keyword_1());

            // InternalRosParser.g:2820:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==Default) ) {
                int LA48_1 = input.LA(2);

                if ( (LA48_1==RULE_BINARY) ) {
                    alt48=1;
                }
            }
            switch (alt48) {
                case 1 :
                    // InternalRosParser.g:2821:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_47);

                                    newLeafNode(otherlv_2, grammarAccess.getParameterBase64TypeAccess().getDefaultKeyword_2_0());

                    // InternalRosParser.g:2825:4: ( (lv_default_3_0= ruleParameterBase64 ) )
                    // InternalRosParser.g:2826:5: (lv_default_3_0= ruleParameterBase64 )
                    {
                    // InternalRosParser.g:2826:5: (lv_default_3_0= ruleParameterBase64 )
                    // InternalRosParser.g:2827:6: lv_default_3_0= ruleParameterBase64
                    {

                                            newCompositeNode(grammarAccess.getParameterBase64TypeAccess().getDefaultParameterBase64ParserRuleCall_2_1_0());

                    pushFollow(FOLLOW_2);
                    lv_default_3_0=ruleParameterBase64();

                    state._fsp--;


                                            if (current==null) {
                                                current = createModelElementForParent(grammarAccess.getParameterBase64TypeRule());
                                            }
                                            set(
                                                current,
                                                "default",
                                                lv_default_3_0,
                                                "de.fraunhofer.ipa.ros.Basics.ParameterBase64");
                                            afterParserOrEnumRuleCall();


                    }


                    }


                    }
                    break;

            }


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterBase64Type"


    // $ANTLR start "entryRuleParameterArrayType"
    // InternalRosParser.g:2849:1: entryRuleParameterArrayType returns [EObject current=null] : iv_ruleParameterArrayType= ruleParameterArrayType EOF ;
    public final EObject entryRuleParameterArrayType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterArrayType = null;


        try {
            // InternalRosParser.g:2849:59: (iv_ruleParameterArrayType= ruleParameterArrayType EOF )
            // InternalRosParser.g:2850:2: iv_ruleParameterArrayType= ruleParameterArrayType EOF
            {
             newCompositeNode(grammarAccess.getParameterArrayTypeRule());
            pushFollow(FOLLOW_1);
            iv_ruleParameterArrayType=ruleParameterArrayType();

            state._fsp--;

             current =iv_ruleParameterArrayType;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterArrayType"


    // $ANTLR start "ruleParameterArrayType"
    // InternalRosParser.g:2856:1: ruleParameterArrayType returns [EObject current=null] : (otherlv_0= Array this_BEGIN_1= RULE_BEGIN otherlv_2= Type ( (lv_type_3_0= ruleParameterType ) ) (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )? this_END_6= RULE_END ) ;
    public final EObject ruleParameterArrayType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_BEGIN_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token this_END_6=null;
        EObject lv_type_3_0 = null;

        EObject lv_default_5_0 = null;



            enterRule();

        try {
            // InternalRosParser.g:2862:2: ( (otherlv_0= Array this_BEGIN_1= RULE_BEGIN otherlv_2= Type ( (lv_type_3_0= ruleParameterType ) ) (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )? this_END_6= RULE_END ) )
            // InternalRosParser.g:2863:2: (otherlv_0= Array this_BEGIN_1= RULE_BEGIN otherlv_2= Type ( (lv_type_3_0= ruleParameterType ) ) (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )? this_END_6= RULE_END )
            {
            // InternalRosParser.g:2863:2: (otherlv_0= Array this_BEGIN_1= RULE_BEGIN otherlv_2= Type ( (lv_type_3_0= ruleParameterType ) ) (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )? this_END_6= RULE_END )
            // InternalRosParser.g:2864:3: otherlv_0= Array this_BEGIN_1= RULE_BEGIN otherlv_2= Type ( (lv_type_3_0= ruleParameterType ) ) (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )? this_END_6= RULE_END
            {
            otherlv_0=(Token)match(input,Array,FOLLOW_5);

                        newLeafNode(otherlv_0, grammarAccess.getParameterArrayTypeAccess().getArrayKeyword_0());

            this_BEGIN_1=(Token)match(input,RULE_BEGIN,FOLLOW_48);

                        newLeafNode(this_BEGIN_1, grammarAccess.getParameterArrayTypeAccess().getBEGINTerminalRuleCall_1());

            otherlv_2=(Token)match(input,Type,FOLLOW_40);

                        newLeafNode(otherlv_2, grammarAccess.getParameterArrayTypeAccess().getTypeKeyword_2());

            // InternalRosParser.g:2876:3: ( (lv_type_3_0= ruleParameterType ) )
            // InternalRosParser.g:2877:4: (lv_type_3_0= ruleParameterType )
            {
            // InternalRosParser.g:2877:4: (lv_type_3_0= ruleParameterType )
            // InternalRosParser.g:2878:5: lv_type_3_0= ruleParameterType
            {

                                newCompositeNode(grammarAccess.getParameterArrayTypeAccess().getTypeParameterTypeParserRuleCall_3_0());

            pushFollow(FOLLOW_49);
            lv_type_3_0=ruleParameterType();

            state._fsp--;


                                if (current==null) {
                                    current = createModelElementForParent(grammarAccess.getParameterArrayTypeRule());
                                }
                                set(
                                    current,
                                    "type",
                                    lv_type_3_0,
                                    "de.fraunhofer.ipa.ros.Basics.ParameterType");
                                afterParserOrEnumRuleCall();


            }


            }

            // InternalRosParser.g:2895:3: (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==Default) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalRosParser.g:2896:4: otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) )
                    {
                    otherlv_4=(Token)match(input,Default,FOLLOW_11);

                                    newLeafNode(otherlv_4, grammarAccess.getParameterArrayTypeAccess().getDefaultKeyword_4_0());

                    // InternalRosParser.g:2900:4: ( (lv_default_5_0= ruleParameterList ) )
                    // InternalRosParser.g:2901:5: (lv_default_5_0= ruleParameterList )
                    {
                    // InternalRosParser.g:2901:5: (lv_default_5_0= ruleParameterList )
                    // InternalRosParser.g:2902:6: lv_default_5_0= ruleParameterList
                    {

                                            newCompositeNode(grammarAccess.getParameterArrayTypeAccess().getDefaultParameterListParserRuleCall_4_1_0());

                    pushFollow(FOLLOW_14);
                    lv_default_5_0=ruleParameterList();

                    state._fsp--;


                                            if (current==null) {
                                                current = createModelElementForParent(grammarAccess.getParameterArrayTypeRule());
                                            }
                                            set(
                                                current,
                                                "default",
                                                lv_default_5_0,
                                                "de.fraunhofer.ipa.ros.Basics.ParameterList");
                                            afterParserOrEnumRuleCall();


                    }


                    }


                    }
                    break;

            }

            this_END_6=(Token)match(input,RULE_END,FOLLOW_2);

                        newLeafNode(this_END_6, grammarAccess.getParameterArrayTypeAccess().getENDTerminalRuleCall_5());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterArrayType"


    // $ANTLR start "entryRuleParameterList"
    // InternalRosParser.g:2928:1: entryRuleParameterList returns [EObject current=null] : iv_ruleParameterList= ruleParameterList EOF ;
    public final EObject entryRuleParameterList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterList = null;


        try {
            // InternalRosParser.g:2928:54: (iv_ruleParameterList= ruleParameterList EOF )
            // InternalRosParser.g:2929:2: iv_ruleParameterList= ruleParameterList EOF
            {
             newCompositeNode(grammarAccess.getParameterListRule());
            pushFollow(FOLLOW_1);
            iv_ruleParameterList=ruleParameterList();

            state._fsp--;

             current =iv_ruleParameterList;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterList"


    // $ANTLR start "ruleParameterList"
    // InternalRosParser.g:2935:1: ruleParameterList returns [EObject current=null] : ( () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket ) ;
    public final EObject ruleParameterList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_value_2_0 = null;

        EObject lv_value_4_0 = null;



            enterRule();

        try {
            // InternalRosParser.g:2941:2: ( ( () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket ) )
            // InternalRosParser.g:2942:2: ( () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket )
            {
            // InternalRosParser.g:2942:2: ( () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket )
            // InternalRosParser.g:2943:3: () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket
            {
            // InternalRosParser.g:2943:3: ()
            // InternalRosParser.g:2944:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getParameterListAccess().getParameterSequenceAction_0(),
                                current);


            }

            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_42);

                        newLeafNode(otherlv_1, grammarAccess.getParameterListAccess().getLeftSquareBracketKeyword_1());

            // InternalRosParser.g:2954:3: ( (lv_value_2_0= ruleParameterValue ) )
            // InternalRosParser.g:2955:4: (lv_value_2_0= ruleParameterValue )
            {
            // InternalRosParser.g:2955:4: (lv_value_2_0= ruleParameterValue )
            // InternalRosParser.g:2956:5: lv_value_2_0= ruleParameterValue
            {

                                newCompositeNode(grammarAccess.getParameterListAccess().getValueParameterValueParserRuleCall_2_0());

            pushFollow(FOLLOW_13);
            lv_value_2_0=ruleParameterValue();

            state._fsp--;


                                if (current==null) {
                                    current = createModelElementForParent(grammarAccess.getParameterListRule());
                                }
                                add(
                                    current,
                                    "value",
                                    lv_value_2_0,
                                    "de.fraunhofer.ipa.ros.Basics.ParameterValue");
                                afterParserOrEnumRuleCall();


            }


            }

            // InternalRosParser.g:2973:3: (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==Comma) ) {
                    alt50=1;
                }


                switch (alt50) {
                case 1 :
                    // InternalRosParser.g:2974:4: otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) )
                    {
                    otherlv_3=(Token)match(input,Comma,FOLLOW_42);

                                    newLeafNode(otherlv_3, grammarAccess.getParameterListAccess().getCommaKeyword_3_0());

                    // InternalRosParser.g:2978:4: ( (lv_value_4_0= ruleParameterValue ) )
                    // InternalRosParser.g:2979:5: (lv_value_4_0= ruleParameterValue )
                    {
                    // InternalRosParser.g:2979:5: (lv_value_4_0= ruleParameterValue )
                    // InternalRosParser.g:2980:6: lv_value_4_0= ruleParameterValue
                    {

                                            newCompositeNode(grammarAccess.getParameterListAccess().getValueParameterValueParserRuleCall_3_1_0());

                    pushFollow(FOLLOW_13);
                    lv_value_4_0=ruleParameterValue();

                    state._fsp--;


                                            if (current==null) {
                                                current = createModelElementForParent(grammarAccess.getParameterListRule());
                                            }
                                            add(
                                                current,
                                                "value",
                                                lv_value_4_0,
                                                "de.fraunhofer.ipa.ros.Basics.ParameterValue");
                                            afterParserOrEnumRuleCall();


                    }


                    }


                    }
                    break;

                default :
                    break loop50;
                }
            } while (true);

            otherlv_5=(Token)match(input,RightSquareBracket,FOLLOW_2);

                        newLeafNode(otherlv_5, grammarAccess.getParameterListAccess().getRightSquareBracketKeyword_4());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterList"


    // $ANTLR start "entryRuleParameterAny"
    // InternalRosParser.g:3006:1: entryRuleParameterAny returns [EObject current=null] : iv_ruleParameterAny= ruleParameterAny EOF ;
    public final EObject entryRuleParameterAny() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterAny = null;


        try {
            // InternalRosParser.g:3006:53: (iv_ruleParameterAny= ruleParameterAny EOF )
            // InternalRosParser.g:3007:2: iv_ruleParameterAny= ruleParameterAny EOF
            {
             newCompositeNode(grammarAccess.getParameterAnyRule());
            pushFollow(FOLLOW_1);
            iv_ruleParameterAny=ruleParameterAny();

            state._fsp--;

             current =iv_ruleParameterAny;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterAny"


    // $ANTLR start "ruleParameterAny"
    // InternalRosParser.g:3013:1: ruleParameterAny returns [EObject current=null] : ( () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )? ) ;
    public final EObject ruleParameterAny() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_value_3_0 = null;



            enterRule();

        try {
            // InternalRosParser.g:3019:2: ( ( () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )? ) )
            // InternalRosParser.g:3020:2: ( () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )? )
            {
            // InternalRosParser.g:3020:2: ( () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )? )
            // InternalRosParser.g:3021:3: () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )?
            {
            // InternalRosParser.g:3021:3: ()
            // InternalRosParser.g:3022:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getParameterAnyAccess().getParameterAnyAction_0(),
                                current);


            }

            otherlv_1=(Token)match(input,ParameterAny,FOLLOW_50);

                        newLeafNode(otherlv_1, grammarAccess.getParameterAnyAccess().getParameterAnyKeyword_1());

            // InternalRosParser.g:3032:3: (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==Value) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalRosParser.g:3033:4: otherlv_2= Value ( (lv_value_3_0= ruleEString ) )
                    {
                    otherlv_2=(Token)match(input,Value,FOLLOW_7);

                                    newLeafNode(otherlv_2, grammarAccess.getParameterAnyAccess().getValueKeyword_2_0());

                    // InternalRosParser.g:3037:4: ( (lv_value_3_0= ruleEString ) )
                    // InternalRosParser.g:3038:5: (lv_value_3_0= ruleEString )
                    {
                    // InternalRosParser.g:3038:5: (lv_value_3_0= ruleEString )
                    // InternalRosParser.g:3039:6: lv_value_3_0= ruleEString
                    {

                                            newCompositeNode(grammarAccess.getParameterAnyAccess().getValueEStringParserRuleCall_2_1_0());

                    pushFollow(FOLLOW_2);
                    lv_value_3_0=ruleEString();

                    state._fsp--;


                                            if (current==null) {
                                                current = createModelElementForParent(grammarAccess.getParameterAnyRule());
                                            }
                                            set(
                                                current,
                                                "value",
                                                lv_value_3_0,
                                                "de.fraunhofer.ipa.ros.Basics.EString");
                                            afterParserOrEnumRuleCall();


                    }


                    }


                    }
                    break;

            }


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterAny"


    // $ANTLR start "entryRuleParameterString"
    // InternalRosParser.g:3061:1: entryRuleParameterString returns [EObject current=null] : iv_ruleParameterString= ruleParameterString EOF ;
    public final EObject entryRuleParameterString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterString = null;


        try {
            // InternalRosParser.g:3061:56: (iv_ruleParameterString= ruleParameterString EOF )
            // InternalRosParser.g:3062:2: iv_ruleParameterString= ruleParameterString EOF
            {
             newCompositeNode(grammarAccess.getParameterStringRule());
            pushFollow(FOLLOW_1);
            iv_ruleParameterString=ruleParameterString();

            state._fsp--;

             current =iv_ruleParameterString;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterString"


    // $ANTLR start "ruleParameterString"
    // InternalRosParser.g:3068:1: ruleParameterString returns [EObject current=null] : ( (lv_value_0_0= ruleEString ) ) ;
    public final EObject ruleParameterString() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



            enterRule();

        try {
            // InternalRosParser.g:3074:2: ( ( (lv_value_0_0= ruleEString ) ) )
            // InternalRosParser.g:3075:2: ( (lv_value_0_0= ruleEString ) )
            {
            // InternalRosParser.g:3075:2: ( (lv_value_0_0= ruleEString ) )
            // InternalRosParser.g:3076:3: (lv_value_0_0= ruleEString )
            {
            // InternalRosParser.g:3076:3: (lv_value_0_0= ruleEString )
            // InternalRosParser.g:3077:4: lv_value_0_0= ruleEString
            {

                            newCompositeNode(grammarAccess.getParameterStringAccess().getValueEStringParserRuleCall_0());

            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleEString();

            state._fsp--;


                            if (current==null) {
                                current = createModelElementForParent(grammarAccess.getParameterStringRule());
                            }
                            set(
                                current,
                                "value",
                                lv_value_0_0,
                                "de.fraunhofer.ipa.ros.Basics.EString");
                            afterParserOrEnumRuleCall();


            }


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterString"


    // $ANTLR start "entryRuleParameterBase64"
    // InternalRosParser.g:3097:1: entryRuleParameterBase64 returns [EObject current=null] : iv_ruleParameterBase64= ruleParameterBase64 EOF ;
    public final EObject entryRuleParameterBase64() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterBase64 = null;


        try {
            // InternalRosParser.g:3097:56: (iv_ruleParameterBase64= ruleParameterBase64 EOF )
            // InternalRosParser.g:3098:2: iv_ruleParameterBase64= ruleParameterBase64 EOF
            {
             newCompositeNode(grammarAccess.getParameterBase64Rule());
            pushFollow(FOLLOW_1);
            iv_ruleParameterBase64=ruleParameterBase64();

            state._fsp--;

             current =iv_ruleParameterBase64;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterBase64"


    // $ANTLR start "ruleParameterBase64"
    // InternalRosParser.g:3104:1: ruleParameterBase64 returns [EObject current=null] : ( (lv_value_0_0= ruleBase64Binary ) ) ;
    public final EObject ruleParameterBase64() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



            enterRule();

        try {
            // InternalRosParser.g:3110:2: ( ( (lv_value_0_0= ruleBase64Binary ) ) )
            // InternalRosParser.g:3111:2: ( (lv_value_0_0= ruleBase64Binary ) )
            {
            // InternalRosParser.g:3111:2: ( (lv_value_0_0= ruleBase64Binary ) )
            // InternalRosParser.g:3112:3: (lv_value_0_0= ruleBase64Binary )
            {
            // InternalRosParser.g:3112:3: (lv_value_0_0= ruleBase64Binary )
            // InternalRosParser.g:3113:4: lv_value_0_0= ruleBase64Binary
            {

                            newCompositeNode(grammarAccess.getParameterBase64Access().getValueBase64BinaryParserRuleCall_0());

            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleBase64Binary();

            state._fsp--;


                            if (current==null) {
                                current = createModelElementForParent(grammarAccess.getParameterBase64Rule());
                            }
                            set(
                                current,
                                "value",
                                lv_value_0_0,
                                "de.fraunhofer.ipa.ros.Basics.Base64Binary");
                            afterParserOrEnumRuleCall();


            }


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterBase64"


    // $ANTLR start "entryRuleParameterInteger"
    // InternalRosParser.g:3133:1: entryRuleParameterInteger returns [EObject current=null] : iv_ruleParameterInteger= ruleParameterInteger EOF ;
    public final EObject entryRuleParameterInteger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterInteger = null;


        try {
            // InternalRosParser.g:3133:57: (iv_ruleParameterInteger= ruleParameterInteger EOF )
            // InternalRosParser.g:3134:2: iv_ruleParameterInteger= ruleParameterInteger EOF
            {
             newCompositeNode(grammarAccess.getParameterIntegerRule());
            pushFollow(FOLLOW_1);
            iv_ruleParameterInteger=ruleParameterInteger();

            state._fsp--;

             current =iv_ruleParameterInteger;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterInteger"


    // $ANTLR start "ruleParameterInteger"
    // InternalRosParser.g:3140:1: ruleParameterInteger returns [EObject current=null] : ( (lv_value_0_0= ruleInteger0 ) ) ;
    public final EObject ruleParameterInteger() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



            enterRule();

        try {
            // InternalRosParser.g:3146:2: ( ( (lv_value_0_0= ruleInteger0 ) ) )
            // InternalRosParser.g:3147:2: ( (lv_value_0_0= ruleInteger0 ) )
            {
            // InternalRosParser.g:3147:2: ( (lv_value_0_0= ruleInteger0 ) )
            // InternalRosParser.g:3148:3: (lv_value_0_0= ruleInteger0 )
            {
            // InternalRosParser.g:3148:3: (lv_value_0_0= ruleInteger0 )
            // InternalRosParser.g:3149:4: lv_value_0_0= ruleInteger0
            {

                            newCompositeNode(grammarAccess.getParameterIntegerAccess().getValueInteger0ParserRuleCall_0());

            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleInteger0();

            state._fsp--;


                            if (current==null) {
                                current = createModelElementForParent(grammarAccess.getParameterIntegerRule());
                            }
                            set(
                                current,
                                "value",
                                lv_value_0_0,
                                "de.fraunhofer.ipa.ros.Basics.Integer0");
                            afterParserOrEnumRuleCall();


            }


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterInteger"


    // $ANTLR start "entryRuleParameterDouble"
    // InternalRosParser.g:3169:1: entryRuleParameterDouble returns [EObject current=null] : iv_ruleParameterDouble= ruleParameterDouble EOF ;
    public final EObject entryRuleParameterDouble() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterDouble = null;


        try {
            // InternalRosParser.g:3169:56: (iv_ruleParameterDouble= ruleParameterDouble EOF )
            // InternalRosParser.g:3170:2: iv_ruleParameterDouble= ruleParameterDouble EOF
            {
             newCompositeNode(grammarAccess.getParameterDoubleRule());
            pushFollow(FOLLOW_1);
            iv_ruleParameterDouble=ruleParameterDouble();

            state._fsp--;

             current =iv_ruleParameterDouble;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterDouble"


    // $ANTLR start "ruleParameterDouble"
    // InternalRosParser.g:3176:1: ruleParameterDouble returns [EObject current=null] : ( (lv_value_0_0= ruleDouble0 ) ) ;
    public final EObject ruleParameterDouble() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



            enterRule();

        try {
            // InternalRosParser.g:3182:2: ( ( (lv_value_0_0= ruleDouble0 ) ) )
            // InternalRosParser.g:3183:2: ( (lv_value_0_0= ruleDouble0 ) )
            {
            // InternalRosParser.g:3183:2: ( (lv_value_0_0= ruleDouble0 ) )
            // InternalRosParser.g:3184:3: (lv_value_0_0= ruleDouble0 )
            {
            // InternalRosParser.g:3184:3: (lv_value_0_0= ruleDouble0 )
            // InternalRosParser.g:3185:4: lv_value_0_0= ruleDouble0
            {

                            newCompositeNode(grammarAccess.getParameterDoubleAccess().getValueDouble0ParserRuleCall_0());

            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleDouble0();

            state._fsp--;


                            if (current==null) {
                                current = createModelElementForParent(grammarAccess.getParameterDoubleRule());
                            }
                            set(
                                current,
                                "value",
                                lv_value_0_0,
                                "de.fraunhofer.ipa.ros.Basics.Double0");
                            afterParserOrEnumRuleCall();


            }


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterDouble"


    // $ANTLR start "entryRuleParameterBoolean"
    // InternalRosParser.g:3205:1: entryRuleParameterBoolean returns [EObject current=null] : iv_ruleParameterBoolean= ruleParameterBoolean EOF ;
    public final EObject entryRuleParameterBoolean() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterBoolean = null;


        try {
            // InternalRosParser.g:3205:57: (iv_ruleParameterBoolean= ruleParameterBoolean EOF )
            // InternalRosParser.g:3206:2: iv_ruleParameterBoolean= ruleParameterBoolean EOF
            {
             newCompositeNode(grammarAccess.getParameterBooleanRule());
            pushFollow(FOLLOW_1);
            iv_ruleParameterBoolean=ruleParameterBoolean();

            state._fsp--;

             current =iv_ruleParameterBoolean;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterBoolean"


    // $ANTLR start "ruleParameterBoolean"
    // InternalRosParser.g:3212:1: ruleParameterBoolean returns [EObject current=null] : ( (lv_value_0_0= ruleboolean0 ) ) ;
    public final EObject ruleParameterBoolean() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



            enterRule();

        try {
            // InternalRosParser.g:3218:2: ( ( (lv_value_0_0= ruleboolean0 ) ) )
            // InternalRosParser.g:3219:2: ( (lv_value_0_0= ruleboolean0 ) )
            {
            // InternalRosParser.g:3219:2: ( (lv_value_0_0= ruleboolean0 ) )
            // InternalRosParser.g:3220:3: (lv_value_0_0= ruleboolean0 )
            {
            // InternalRosParser.g:3220:3: (lv_value_0_0= ruleboolean0 )
            // InternalRosParser.g:3221:4: lv_value_0_0= ruleboolean0
            {

                            newCompositeNode(grammarAccess.getParameterBooleanAccess().getValueBoolean0ParserRuleCall_0());

            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleboolean0();

            state._fsp--;


                            if (current==null) {
                                current = createModelElementForParent(grammarAccess.getParameterBooleanRule());
                            }
                            set(
                                current,
                                "value",
                                lv_value_0_0,
                                "de.fraunhofer.ipa.ros.Basics.boolean0");
                            afterParserOrEnumRuleCall();


            }


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterBoolean"


    // $ANTLR start "entryRuleParameterStruct"
    // InternalRosParser.g:3241:1: entryRuleParameterStruct returns [EObject current=null] : iv_ruleParameterStruct= ruleParameterStruct EOF ;
    public final EObject entryRuleParameterStruct() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStruct = null;


        try {
            // InternalRosParser.g:3241:56: (iv_ruleParameterStruct= ruleParameterStruct EOF )
            // InternalRosParser.g:3242:2: iv_ruleParameterStruct= ruleParameterStruct EOF
            {
             newCompositeNode(grammarAccess.getParameterStructRule());
            pushFollow(FOLLOW_1);
            iv_ruleParameterStruct=ruleParameterStruct();

            state._fsp--;

             current =iv_ruleParameterStruct;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterStruct"


    // $ANTLR start "ruleParameterStruct"
    // InternalRosParser.g:3248:1: ruleParameterStruct returns [EObject current=null] : ( () (otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterStructMember ) ) (otherlv_3= Comma otherlv_4= LeftSquareBracket ( (lv_value_5_0= ruleParameterStructMember ) ) otherlv_6= RightSquareBracket )* otherlv_7= RightSquareBracket )? ) ;
    public final EObject ruleParameterStruct() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_value_2_0 = null;

        EObject lv_value_5_0 = null;



            enterRule();

        try {
            // InternalRosParser.g:3254:2: ( ( () (otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterStructMember ) ) (otherlv_3= Comma otherlv_4= LeftSquareBracket ( (lv_value_5_0= ruleParameterStructMember ) ) otherlv_6= RightSquareBracket )* otherlv_7= RightSquareBracket )? ) )
            // InternalRosParser.g:3255:2: ( () (otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterStructMember ) ) (otherlv_3= Comma otherlv_4= LeftSquareBracket ( (lv_value_5_0= ruleParameterStructMember ) ) otherlv_6= RightSquareBracket )* otherlv_7= RightSquareBracket )? )
            {
            // InternalRosParser.g:3255:2: ( () (otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterStructMember ) ) (otherlv_3= Comma otherlv_4= LeftSquareBracket ( (lv_value_5_0= ruleParameterStructMember ) ) otherlv_6= RightSquareBracket )* otherlv_7= RightSquareBracket )? )
            // InternalRosParser.g:3256:3: () (otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterStructMember ) ) (otherlv_3= Comma otherlv_4= LeftSquareBracket ( (lv_value_5_0= ruleParameterStructMember ) ) otherlv_6= RightSquareBracket )* otherlv_7= RightSquareBracket )?
            {
            // InternalRosParser.g:3256:3: ()
            // InternalRosParser.g:3257:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getParameterStructAccess().getParameterStructAction_0(),
                                current);


            }

            // InternalRosParser.g:3263:3: (otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterStructMember ) ) (otherlv_3= Comma otherlv_4= LeftSquareBracket ( (lv_value_5_0= ruleParameterStructMember ) ) otherlv_6= RightSquareBracket )* otherlv_7= RightSquareBracket )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==LeftSquareBracket) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalRosParser.g:3264:4: otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterStructMember ) ) (otherlv_3= Comma otherlv_4= LeftSquareBracket ( (lv_value_5_0= ruleParameterStructMember ) ) otherlv_6= RightSquareBracket )* otherlv_7= RightSquareBracket
                    {
                    otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_51);

                                    newLeafNode(otherlv_1, grammarAccess.getParameterStructAccess().getLeftSquareBracketKeyword_1_0());

                    // InternalRosParser.g:3268:4: ( (lv_value_2_0= ruleParameterStructMember ) )
                    // InternalRosParser.g:3269:5: (lv_value_2_0= ruleParameterStructMember )
                    {
                    // InternalRosParser.g:3269:5: (lv_value_2_0= ruleParameterStructMember )
                    // InternalRosParser.g:3270:6: lv_value_2_0= ruleParameterStructMember
                    {

                                            newCompositeNode(grammarAccess.getParameterStructAccess().getValueParameterStructMemberParserRuleCall_1_1_0());

                    pushFollow(FOLLOW_13);
                    lv_value_2_0=ruleParameterStructMember();

                    state._fsp--;


                                            if (current==null) {
                                                current = createModelElementForParent(grammarAccess.getParameterStructRule());
                                            }
                                            add(
                                                current,
                                                "value",
                                                lv_value_2_0,
                                                "de.fraunhofer.ipa.ros.Basics.ParameterStructMember");
                                            afterParserOrEnumRuleCall();


                    }


                    }

                    // InternalRosParser.g:3287:4: (otherlv_3= Comma otherlv_4= LeftSquareBracket ( (lv_value_5_0= ruleParameterStructMember ) ) otherlv_6= RightSquareBracket )*
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==Comma) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                        case 1 :
                            // InternalRosParser.g:3288:5: otherlv_3= Comma otherlv_4= LeftSquareBracket ( (lv_value_5_0= ruleParameterStructMember ) ) otherlv_6= RightSquareBracket
                            {
                            otherlv_3=(Token)match(input,Comma,FOLLOW_11);

                                                newLeafNode(otherlv_3, grammarAccess.getParameterStructAccess().getCommaKeyword_1_2_0());

                            otherlv_4=(Token)match(input,LeftSquareBracket,FOLLOW_51);

                                                newLeafNode(otherlv_4, grammarAccess.getParameterStructAccess().getLeftSquareBracketKeyword_1_2_1());

                            // InternalRosParser.g:3296:5: ( (lv_value_5_0= ruleParameterStructMember ) )
                            // InternalRosParser.g:3297:6: (lv_value_5_0= ruleParameterStructMember )
                            {
                            // InternalRosParser.g:3297:6: (lv_value_5_0= ruleParameterStructMember )
                            // InternalRosParser.g:3298:7: lv_value_5_0= ruleParameterStructMember
                            {

                                                        newCompositeNode(grammarAccess.getParameterStructAccess().getValueParameterStructMemberParserRuleCall_1_2_2_0());

                            pushFollow(FOLLOW_52);
                            lv_value_5_0=ruleParameterStructMember();

                            state._fsp--;


                                                        if (current==null) {
                                                            current = createModelElementForParent(grammarAccess.getParameterStructRule());
                                                        }
                                                        add(
                                                            current,
                                                            "value",
                                                            lv_value_5_0,
                                                            "de.fraunhofer.ipa.ros.Basics.ParameterStructMember");
                                                        afterParserOrEnumRuleCall();


                            }


                            }

                            otherlv_6=(Token)match(input,RightSquareBracket,FOLLOW_13);

                                                newLeafNode(otherlv_6, grammarAccess.getParameterStructAccess().getRightSquareBracketKeyword_1_2_3());


                            }
                            break;

                        default :
                            break loop52;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,RightSquareBracket,FOLLOW_2);

                                    newLeafNode(otherlv_7, grammarAccess.getParameterStructAccess().getRightSquareBracketKeyword_1_3());


                    }
                    break;

            }


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterStruct"


    // $ANTLR start "entryRuleParameterDate"
    // InternalRosParser.g:3329:1: entryRuleParameterDate returns [EObject current=null] : iv_ruleParameterDate= ruleParameterDate EOF ;
    public final EObject entryRuleParameterDate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterDate = null;


        try {
            // InternalRosParser.g:3329:54: (iv_ruleParameterDate= ruleParameterDate EOF )
            // InternalRosParser.g:3330:2: iv_ruleParameterDate= ruleParameterDate EOF
            {
             newCompositeNode(grammarAccess.getParameterDateRule());
            pushFollow(FOLLOW_1);
            iv_ruleParameterDate=ruleParameterDate();

            state._fsp--;

             current =iv_ruleParameterDate;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterDate"


    // $ANTLR start "ruleParameterDate"
    // InternalRosParser.g:3336:1: ruleParameterDate returns [EObject current=null] : ( (lv_value_0_0= ruleDateTime0 ) ) ;
    public final EObject ruleParameterDate() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



            enterRule();

        try {
            // InternalRosParser.g:3342:2: ( ( (lv_value_0_0= ruleDateTime0 ) ) )
            // InternalRosParser.g:3343:2: ( (lv_value_0_0= ruleDateTime0 ) )
            {
            // InternalRosParser.g:3343:2: ( (lv_value_0_0= ruleDateTime0 ) )
            // InternalRosParser.g:3344:3: (lv_value_0_0= ruleDateTime0 )
            {
            // InternalRosParser.g:3344:3: (lv_value_0_0= ruleDateTime0 )
            // InternalRosParser.g:3345:4: lv_value_0_0= ruleDateTime0
            {

                            newCompositeNode(grammarAccess.getParameterDateAccess().getValueDateTime0ParserRuleCall_0());

            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleDateTime0();

            state._fsp--;


                            if (current==null) {
                                current = createModelElementForParent(grammarAccess.getParameterDateRule());
                            }
                            set(
                                current,
                                "value",
                                lv_value_0_0,
                                "de.fraunhofer.ipa.ros.Basics.DateTime0");
                            afterParserOrEnumRuleCall();


            }


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterDate"


    // $ANTLR start "entryRuleParameterStructMember"
    // InternalRosParser.g:3365:1: entryRuleParameterStructMember returns [EObject current=null] : iv_ruleParameterStructMember= ruleParameterStructMember EOF ;
    public final EObject entryRuleParameterStructMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStructMember = null;


        try {
            // InternalRosParser.g:3365:62: (iv_ruleParameterStructMember= ruleParameterStructMember EOF )
            // InternalRosParser.g:3366:2: iv_ruleParameterStructMember= ruleParameterStructMember EOF
            {
             newCompositeNode(grammarAccess.getParameterStructMemberRule());
            pushFollow(FOLLOW_1);
            iv_ruleParameterStructMember=ruleParameterStructMember();

            state._fsp--;

             current =iv_ruleParameterStructMember;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterStructMember"


    // $ANTLR start "ruleParameterStructMember"
    // InternalRosParser.g:3372:1: ruleParameterStructMember returns [EObject current=null] : (otherlv_0= ParameterStructMember ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN ( (lv_value_4_0= ruleParameterValue ) ) this_END_5= RULE_END ) ;
    public final EObject ruleParameterStructMember() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token this_BEGIN_3=null;
        Token this_END_5=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_value_4_0 = null;



            enterRule();

        try {
            // InternalRosParser.g:3378:2: ( (otherlv_0= ParameterStructMember ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN ( (lv_value_4_0= ruleParameterValue ) ) this_END_5= RULE_END ) )
            // InternalRosParser.g:3379:2: (otherlv_0= ParameterStructMember ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN ( (lv_value_4_0= ruleParameterValue ) ) this_END_5= RULE_END )
            {
            // InternalRosParser.g:3379:2: (otherlv_0= ParameterStructMember ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN ( (lv_value_4_0= ruleParameterValue ) ) this_END_5= RULE_END )
            // InternalRosParser.g:3380:3: otherlv_0= ParameterStructMember ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN ( (lv_value_4_0= ruleParameterValue ) ) this_END_5= RULE_END
            {
            otherlv_0=(Token)match(input,ParameterStructMember,FOLLOW_7);

                        newLeafNode(otherlv_0, grammarAccess.getParameterStructMemberAccess().getParameterStructMemberKeyword_0());

            // InternalRosParser.g:3384:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRosParser.g:3385:4: (lv_name_1_0= ruleEString )
            {
            // InternalRosParser.g:3385:4: (lv_name_1_0= ruleEString )
            // InternalRosParser.g:3386:5: lv_name_1_0= ruleEString
            {

                                newCompositeNode(grammarAccess.getParameterStructMemberAccess().getNameEStringParserRuleCall_1_0());

            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


                                if (current==null) {
                                    current = createModelElementForParent(grammarAccess.getParameterStructMemberRule());
                                }
                                set(
                                    current,
                                    "name",
                                    lv_name_1_0,
                                    "de.fraunhofer.ipa.ros.Basics.EString");
                                afterParserOrEnumRuleCall();


            }


            }

            otherlv_2=(Token)match(input,Colon,FOLLOW_5);

                        newLeafNode(otherlv_2, grammarAccess.getParameterStructMemberAccess().getColonKeyword_2());

            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_42);

                        newLeafNode(this_BEGIN_3, grammarAccess.getParameterStructMemberAccess().getBEGINTerminalRuleCall_3());

            // InternalRosParser.g:3411:3: ( (lv_value_4_0= ruleParameterValue ) )
            // InternalRosParser.g:3412:4: (lv_value_4_0= ruleParameterValue )
            {
            // InternalRosParser.g:3412:4: (lv_value_4_0= ruleParameterValue )
            // InternalRosParser.g:3413:5: lv_value_4_0= ruleParameterValue
            {

                                newCompositeNode(grammarAccess.getParameterStructMemberAccess().getValueParameterValueParserRuleCall_4_0());

            pushFollow(FOLLOW_14);
            lv_value_4_0=ruleParameterValue();

            state._fsp--;


                                if (current==null) {
                                    current = createModelElementForParent(grammarAccess.getParameterStructMemberRule());
                                }
                                set(
                                    current,
                                    "value",
                                    lv_value_4_0,
                                    "de.fraunhofer.ipa.ros.Basics.ParameterValue");
                                afterParserOrEnumRuleCall();


            }


            }

            this_END_5=(Token)match(input,RULE_END,FOLLOW_2);

                        newLeafNode(this_END_5, grammarAccess.getParameterStructMemberAccess().getENDTerminalRuleCall_5());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterStructMember"


    // $ANTLR start "entryRuleParameterStructTypeMember"
    // InternalRosParser.g:3438:1: entryRuleParameterStructTypeMember returns [EObject current=null] : iv_ruleParameterStructTypeMember= ruleParameterStructTypeMember EOF ;
    public final EObject entryRuleParameterStructTypeMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStructTypeMember = null;


        try {
            // InternalRosParser.g:3438:66: (iv_ruleParameterStructTypeMember= ruleParameterStructTypeMember EOF )
            // InternalRosParser.g:3439:2: iv_ruleParameterStructTypeMember= ruleParameterStructTypeMember EOF
            {
             newCompositeNode(grammarAccess.getParameterStructTypeMemberRule());
            pushFollow(FOLLOW_1);
            iv_ruleParameterStructTypeMember=ruleParameterStructTypeMember();

            state._fsp--;

             current =iv_ruleParameterStructTypeMember;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterStructTypeMember"


    // $ANTLR start "ruleParameterStructTypeMember"
    // InternalRosParser.g:3445:1: ruleParameterStructTypeMember returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) ) ) ;
    public final EObject ruleParameterStructTypeMember() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_type_1_0 = null;



            enterRule();

        try {
            // InternalRosParser.g:3451:2: ( ( ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) ) ) )
            // InternalRosParser.g:3452:2: ( ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) ) )
            {
            // InternalRosParser.g:3452:2: ( ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) ) )
            // InternalRosParser.g:3453:3: ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) )
            {
            // InternalRosParser.g:3453:3: ( (lv_name_0_0= ruleEString ) )
            // InternalRosParser.g:3454:4: (lv_name_0_0= ruleEString )
            {
            // InternalRosParser.g:3454:4: (lv_name_0_0= ruleEString )
            // InternalRosParser.g:3455:5: lv_name_0_0= ruleEString
            {

                                newCompositeNode(grammarAccess.getParameterStructTypeMemberAccess().getNameEStringParserRuleCall_0_0());

            pushFollow(FOLLOW_40);
            lv_name_0_0=ruleEString();

            state._fsp--;


                                if (current==null) {
                                    current = createModelElementForParent(grammarAccess.getParameterStructTypeMemberRule());
                                }
                                set(
                                    current,
                                    "name",
                                    lv_name_0_0,
                                    "de.fraunhofer.ipa.ros.Basics.EString");
                                afterParserOrEnumRuleCall();


            }


            }

            // InternalRosParser.g:3472:3: ( (lv_type_1_0= ruleParameterType ) )
            // InternalRosParser.g:3473:4: (lv_type_1_0= ruleParameterType )
            {
            // InternalRosParser.g:3473:4: (lv_type_1_0= ruleParameterType )
            // InternalRosParser.g:3474:5: lv_type_1_0= ruleParameterType
            {

                                newCompositeNode(grammarAccess.getParameterStructTypeMemberAccess().getTypeParameterTypeParserRuleCall_1_0());

            pushFollow(FOLLOW_2);
            lv_type_1_0=ruleParameterType();

            state._fsp--;


                                if (current==null) {
                                    current = createModelElementForParent(grammarAccess.getParameterStructTypeMemberRule());
                                }
                                set(
                                    current,
                                    "type",
                                    lv_type_1_0,
                                    "de.fraunhofer.ipa.ros.Basics.ParameterType");
                                afterParserOrEnumRuleCall();


            }


            }


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterStructTypeMember"


    // $ANTLR start "entryRuleBase64Binary"
    // InternalRosParser.g:3495:1: entryRuleBase64Binary returns [String current=null] : iv_ruleBase64Binary= ruleBase64Binary EOF ;
    public final String entryRuleBase64Binary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBase64Binary = null;


        try {
            // InternalRosParser.g:3495:52: (iv_ruleBase64Binary= ruleBase64Binary EOF )
            // InternalRosParser.g:3496:2: iv_ruleBase64Binary= ruleBase64Binary EOF
            {
             newCompositeNode(grammarAccess.getBase64BinaryRule());
            pushFollow(FOLLOW_1);
            iv_ruleBase64Binary=ruleBase64Binary();

            state._fsp--;

             current =iv_ruleBase64Binary.getText();
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBase64Binary"


    // $ANTLR start "ruleBase64Binary"
    // InternalRosParser.g:3502:1: ruleBase64Binary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_BINARY_0= RULE_BINARY ;
    public final AntlrDatatypeRuleToken ruleBase64Binary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BINARY_0=null;


            enterRule();

        try {
            // InternalRosParser.g:3508:2: (this_BINARY_0= RULE_BINARY )
            // InternalRosParser.g:3509:2: this_BINARY_0= RULE_BINARY
            {
            this_BINARY_0=(Token)match(input,RULE_BINARY,FOLLOW_2);

                    current.merge(this_BINARY_0);


                    newLeafNode(this_BINARY_0, grammarAccess.getBase64BinaryAccess().getBINARYTerminalRuleCall());


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBase64Binary"


    // $ANTLR start "entryRuleboolean0"
    // InternalRosParser.g:3519:1: entryRuleboolean0 returns [String current=null] : iv_ruleboolean0= ruleboolean0 EOF ;
    public final String entryRuleboolean0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleboolean0 = null;


        try {
            // InternalRosParser.g:3519:48: (iv_ruleboolean0= ruleboolean0 EOF )
            // InternalRosParser.g:3520:2: iv_ruleboolean0= ruleboolean0 EOF
            {
             newCompositeNode(grammarAccess.getBoolean0Rule());
            pushFollow(FOLLOW_1);
            iv_ruleboolean0=ruleboolean0();

            state._fsp--;

             current =iv_ruleboolean0.getText();
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleboolean0"


    // $ANTLR start "ruleboolean0"
    // InternalRosParser.g:3526:1: ruleboolean0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_BOOLEAN_0= RULE_BOOLEAN ;
    public final AntlrDatatypeRuleToken ruleboolean0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BOOLEAN_0=null;


            enterRule();

        try {
            // InternalRosParser.g:3532:2: (this_BOOLEAN_0= RULE_BOOLEAN )
            // InternalRosParser.g:3533:2: this_BOOLEAN_0= RULE_BOOLEAN
            {
            this_BOOLEAN_0=(Token)match(input,RULE_BOOLEAN,FOLLOW_2);

                    current.merge(this_BOOLEAN_0);


                    newLeafNode(this_BOOLEAN_0, grammarAccess.getBoolean0Access().getBOOLEANTerminalRuleCall());


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleboolean0"


    // $ANTLR start "entryRuleDouble0"
    // InternalRosParser.g:3543:1: entryRuleDouble0 returns [String current=null] : iv_ruleDouble0= ruleDouble0 EOF ;
    public final String entryRuleDouble0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDouble0 = null;


        try {
            // InternalRosParser.g:3543:47: (iv_ruleDouble0= ruleDouble0 EOF )
            // InternalRosParser.g:3544:2: iv_ruleDouble0= ruleDouble0 EOF
            {
             newCompositeNode(grammarAccess.getDouble0Rule());
            pushFollow(FOLLOW_1);
            iv_ruleDouble0=ruleDouble0();

            state._fsp--;

             current =iv_ruleDouble0.getText();
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDouble0"


    // $ANTLR start "ruleDouble0"
    // InternalRosParser.g:3550:1: ruleDouble0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_DOUBLE_0= RULE_DOUBLE ;
    public final AntlrDatatypeRuleToken ruleDouble0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DOUBLE_0=null;


            enterRule();

        try {
            // InternalRosParser.g:3556:2: (this_DOUBLE_0= RULE_DOUBLE )
            // InternalRosParser.g:3557:2: this_DOUBLE_0= RULE_DOUBLE
            {
            this_DOUBLE_0=(Token)match(input,RULE_DOUBLE,FOLLOW_2);

                    current.merge(this_DOUBLE_0);


                    newLeafNode(this_DOUBLE_0, grammarAccess.getDouble0Access().getDOUBLETerminalRuleCall());


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDouble0"


    // $ANTLR start "entryRuleInteger0"
    // InternalRosParser.g:3567:1: entryRuleInteger0 returns [String current=null] : iv_ruleInteger0= ruleInteger0 EOF ;
    public final String entryRuleInteger0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInteger0 = null;


        try {
            // InternalRosParser.g:3567:48: (iv_ruleInteger0= ruleInteger0 EOF )
            // InternalRosParser.g:3568:2: iv_ruleInteger0= ruleInteger0 EOF
            {
             newCompositeNode(grammarAccess.getInteger0Rule());
            pushFollow(FOLLOW_1);
            iv_ruleInteger0=ruleInteger0();

            state._fsp--;

             current =iv_ruleInteger0.getText();
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInteger0"


    // $ANTLR start "ruleInteger0"
    // InternalRosParser.g:3574:1: ruleInteger0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_DECINT_0= RULE_DECINT ;
    public final AntlrDatatypeRuleToken ruleInteger0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DECINT_0=null;


            enterRule();

        try {
            // InternalRosParser.g:3580:2: (this_DECINT_0= RULE_DECINT )
            // InternalRosParser.g:3581:2: this_DECINT_0= RULE_DECINT
            {
            this_DECINT_0=(Token)match(input,RULE_DECINT,FOLLOW_2);

                    current.merge(this_DECINT_0);


                    newLeafNode(this_DECINT_0, grammarAccess.getInteger0Access().getDECINTTerminalRuleCall());


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInteger0"


    // $ANTLR start "entryRuleDateTime0"
    // InternalRosParser.g:3591:1: entryRuleDateTime0 returns [String current=null] : iv_ruleDateTime0= ruleDateTime0 EOF ;
    public final String entryRuleDateTime0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDateTime0 = null;


        try {
            // InternalRosParser.g:3591:49: (iv_ruleDateTime0= ruleDateTime0 EOF )
            // InternalRosParser.g:3592:2: iv_ruleDateTime0= ruleDateTime0 EOF
            {
             newCompositeNode(grammarAccess.getDateTime0Rule());
            pushFollow(FOLLOW_1);
            iv_ruleDateTime0=ruleDateTime0();

            state._fsp--;

             current =iv_ruleDateTime0.getText();
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDateTime0"


    // $ANTLR start "ruleDateTime0"
    // InternalRosParser.g:3598:1: ruleDateTime0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_DATE_TIME_0= RULE_DATE_TIME ;
    public final AntlrDatatypeRuleToken ruleDateTime0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DATE_TIME_0=null;


            enterRule();

        try {
            // InternalRosParser.g:3604:2: (this_DATE_TIME_0= RULE_DATE_TIME )
            // InternalRosParser.g:3605:2: this_DATE_TIME_0= RULE_DATE_TIME
            {
            this_DATE_TIME_0=(Token)match(input,RULE_DATE_TIME,FOLLOW_2);

                    current.merge(this_DATE_TIME_0);


                    newLeafNode(this_DATE_TIME_0, grammarAccess.getDateTime0Access().getDATE_TIMETerminalRuleCall());


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDateTime0"


    // $ANTLR start "entryRuleMessagePart"
    // InternalRosParser.g:3615:1: entryRuleMessagePart returns [EObject current=null] : iv_ruleMessagePart= ruleMessagePart EOF ;
    public final EObject entryRuleMessagePart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessagePart = null;


        try {
            // InternalRosParser.g:3615:52: (iv_ruleMessagePart= ruleMessagePart EOF )
            // InternalRosParser.g:3616:2: iv_ruleMessagePart= ruleMessagePart EOF
            {
             newCompositeNode(grammarAccess.getMessagePartRule());
            pushFollow(FOLLOW_1);
            iv_ruleMessagePart=ruleMessagePart();

            state._fsp--;

             current =iv_ruleMessagePart;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMessagePart"


    // $ANTLR start "ruleMessagePart"
    // InternalRosParser.g:3622:1: ruleMessagePart returns [EObject current=null] : ( ( ( (lv_Data_0_1= ruleKEYWORD | lv_Data_0_2= RULE_MESSAGE_ASIGMENT | lv_Data_0_3= ruleEString ) ) ) otherlv_1= Colon ( (lv_Type_2_0= ruleAbstractType ) ) ) ;
    public final EObject ruleMessagePart() throws RecognitionException {
        EObject current = null;

        Token lv_Data_0_2=null;
        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_Data_0_1 = null;

        AntlrDatatypeRuleToken lv_Data_0_3 = null;

        EObject lv_Type_2_0 = null;



            enterRule();

        try {
            // InternalRosParser.g:3628:2: ( ( ( ( (lv_Data_0_1= ruleKEYWORD | lv_Data_0_2= RULE_MESSAGE_ASIGMENT | lv_Data_0_3= ruleEString ) ) ) otherlv_1= Colon ( (lv_Type_2_0= ruleAbstractType ) ) ) )
            // InternalRosParser.g:3629:2: ( ( ( (lv_Data_0_1= ruleKEYWORD | lv_Data_0_2= RULE_MESSAGE_ASIGMENT | lv_Data_0_3= ruleEString ) ) ) otherlv_1= Colon ( (lv_Type_2_0= ruleAbstractType ) ) )
            {
            // InternalRosParser.g:3629:2: ( ( ( (lv_Data_0_1= ruleKEYWORD | lv_Data_0_2= RULE_MESSAGE_ASIGMENT | lv_Data_0_3= ruleEString ) ) ) otherlv_1= Colon ( (lv_Type_2_0= ruleAbstractType ) ) )
            // InternalRosParser.g:3630:3: ( ( (lv_Data_0_1= ruleKEYWORD | lv_Data_0_2= RULE_MESSAGE_ASIGMENT | lv_Data_0_3= ruleEString ) ) ) otherlv_1= Colon ( (lv_Type_2_0= ruleAbstractType ) )
            {
            // InternalRosParser.g:3630:3: ( ( (lv_Data_0_1= ruleKEYWORD | lv_Data_0_2= RULE_MESSAGE_ASIGMENT | lv_Data_0_3= ruleEString ) ) )
            // InternalRosParser.g:3631:4: ( (lv_Data_0_1= ruleKEYWORD | lv_Data_0_2= RULE_MESSAGE_ASIGMENT | lv_Data_0_3= ruleEString ) )
            {
            // InternalRosParser.g:3631:4: ( (lv_Data_0_1= ruleKEYWORD | lv_Data_0_2= RULE_MESSAGE_ASIGMENT | lv_Data_0_3= ruleEString ) )
            // InternalRosParser.g:3632:5: (lv_Data_0_1= ruleKEYWORD | lv_Data_0_2= RULE_MESSAGE_ASIGMENT | lv_Data_0_3= ruleEString )
            {
            // InternalRosParser.g:3632:5: (lv_Data_0_1= ruleKEYWORD | lv_Data_0_2= RULE_MESSAGE_ASIGMENT | lv_Data_0_3= ruleEString )
            int alt54=3;
            switch ( input.LA(1) ) {
            case Duration:
            case Feedback:
            case Message:
            case Service:
            case Action:
            case Result:
            case Value:
            case Goal:
            case Name:
            case Time:
            case Type:
                {
                alt54=1;
                }
                break;
            case RULE_MESSAGE_ASIGMENT:
                {
                alt54=2;
                }
                break;
            case RULE_ID:
            case RULE_STRING:
                {
                alt54=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }

            switch (alt54) {
                case 1 :
                    // InternalRosParser.g:3633:6: lv_Data_0_1= ruleKEYWORD
                    {

                                            newCompositeNode(grammarAccess.getMessagePartAccess().getDataKEYWORDParserRuleCall_0_0_0());

                    pushFollow(FOLLOW_4);
                    lv_Data_0_1=ruleKEYWORD();

                    state._fsp--;


                                            if (current==null) {
                                                current = createModelElementForParent(grammarAccess.getMessagePartRule());
                                            }
                                            set(
                                                current,
                                                "Data",
                                                lv_Data_0_1,
                                                "de.fraunhofer.ipa.ros.Basics.KEYWORD");
                                            afterParserOrEnumRuleCall();


                    }
                    break;
                case 2 :
                    // InternalRosParser.g:3649:6: lv_Data_0_2= RULE_MESSAGE_ASIGMENT
                    {
                    lv_Data_0_2=(Token)match(input,RULE_MESSAGE_ASIGMENT,FOLLOW_4);

                                            newLeafNode(lv_Data_0_2, grammarAccess.getMessagePartAccess().getDataMESSAGE_ASIGMENTTerminalRuleCall_0_0_1());


                                            if (current==null) {
                                                current = createModelElement(grammarAccess.getMessagePartRule());
                                            }
                                            setWithLastConsumed(
                                                current,
                                                "Data",
                                                lv_Data_0_2,
                                                "de.fraunhofer.ipa.ros.Basics.MESSAGE_ASIGMENT");


                    }
                    break;
                case 3 :
                    // InternalRosParser.g:3664:6: lv_Data_0_3= ruleEString
                    {

                                            newCompositeNode(grammarAccess.getMessagePartAccess().getDataEStringParserRuleCall_0_0_2());

                    pushFollow(FOLLOW_4);
                    lv_Data_0_3=ruleEString();

                    state._fsp--;


                                            if (current==null) {
                                                current = createModelElementForParent(grammarAccess.getMessagePartRule());
                                            }
                                            set(
                                                current,
                                                "Data",
                                                lv_Data_0_3,
                                                "de.fraunhofer.ipa.ros.Basics.EString");
                                            afterParserOrEnumRuleCall();


                    }
                    break;

            }


            }


            }

            otherlv_1=(Token)match(input,Colon,FOLLOW_53);

                        newLeafNode(otherlv_1, grammarAccess.getMessagePartAccess().getColonKeyword_1());

            // InternalRosParser.g:3686:3: ( (lv_Type_2_0= ruleAbstractType ) )
            // InternalRosParser.g:3687:4: (lv_Type_2_0= ruleAbstractType )
            {
            // InternalRosParser.g:3687:4: (lv_Type_2_0= ruleAbstractType )
            // InternalRosParser.g:3688:5: lv_Type_2_0= ruleAbstractType
            {

                                newCompositeNode(grammarAccess.getMessagePartAccess().getTypeAbstractTypeParserRuleCall_2_0());

            pushFollow(FOLLOW_2);
            lv_Type_2_0=ruleAbstractType();

            state._fsp--;


                                if (current==null) {
                                    current = createModelElementForParent(grammarAccess.getMessagePartRule());
                                }
                                set(
                                    current,
                                    "Type",
                                    lv_Type_2_0,
                                    "de.fraunhofer.ipa.ros.Basics.AbstractType");
                                afterParserOrEnumRuleCall();


            }


            }


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMessagePart"


    // $ANTLR start "entryRuleAbstractType"
    // InternalRosParser.g:3709:1: entryRuleAbstractType returns [EObject current=null] : iv_ruleAbstractType= ruleAbstractType EOF ;
    public final EObject entryRuleAbstractType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractType = null;


        try {
            // InternalRosParser.g:3709:53: (iv_ruleAbstractType= ruleAbstractType EOF )
            // InternalRosParser.g:3710:2: iv_ruleAbstractType= ruleAbstractType EOF
            {
             newCompositeNode(grammarAccess.getAbstractTypeRule());
            pushFollow(FOLLOW_1);
            iv_ruleAbstractType=ruleAbstractType();

            state._fsp--;

             current =iv_ruleAbstractType;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbstractType"


    // $ANTLR start "ruleAbstractType"
    // InternalRosParser.g:3716:1: ruleAbstractType returns [EObject current=null] : (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_TopicSpecRef_29= ruleTopicSpecRef | this_ArrayTopicSpecRef_30= ruleArrayTopicSpecRef ) ;
    public final EObject ruleAbstractType() throws RecognitionException {
        EObject current = null;

        EObject this_bool_0 = null;

        EObject this_int8_1 = null;

        EObject this_uint8_2 = null;

        EObject this_int16_3 = null;

        EObject this_uint16_4 = null;

        EObject this_int32_5 = null;

        EObject this_uint32_6 = null;

        EObject this_int64_7 = null;

        EObject this_uint64_8 = null;

        EObject this_float32_9 = null;

        EObject this_float64_10 = null;

        EObject this_string0_11 = null;

        EObject this_byte_12 = null;

        EObject this_time_13 = null;

        EObject this_duration_14 = null;

        EObject this_Header_15 = null;

        EObject this_boolArray_16 = null;

        EObject this_int8Array_17 = null;

        EObject this_uint8Array_18 = null;

        EObject this_int16Array_19 = null;

        EObject this_uint16Array_20 = null;

        EObject this_int32Array_21 = null;

        EObject this_uint32Array_22 = null;

        EObject this_int64Array_23 = null;

        EObject this_uint64Array_24 = null;

        EObject this_float32Array_25 = null;

        EObject this_float64Array_26 = null;

        EObject this_string0Array_27 = null;

        EObject this_byteArray_28 = null;

        EObject this_TopicSpecRef_29 = null;

        EObject this_ArrayTopicSpecRef_30 = null;



            enterRule();

        try {
            // InternalRosParser.g:3722:2: ( (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_TopicSpecRef_29= ruleTopicSpecRef | this_ArrayTopicSpecRef_30= ruleArrayTopicSpecRef ) )
            // InternalRosParser.g:3723:2: (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_TopicSpecRef_29= ruleTopicSpecRef | this_ArrayTopicSpecRef_30= ruleArrayTopicSpecRef )
            {
            // InternalRosParser.g:3723:2: (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_TopicSpecRef_29= ruleTopicSpecRef | this_ArrayTopicSpecRef_30= ruleArrayTopicSpecRef )
            int alt55=31;
            alt55 = dfa55.predict(input);
            switch (alt55) {
                case 1 :
                    // InternalRosParser.g:3724:3: this_bool_0= rulebool
                    {

                                newCompositeNode(grammarAccess.getAbstractTypeAccess().getBoolParserRuleCall_0());

                    pushFollow(FOLLOW_2);
                    this_bool_0=rulebool();

                    state._fsp--;


                                current = this_bool_0;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 2 :
                    // InternalRosParser.g:3733:3: this_int8_1= ruleint8
                    {

                                newCompositeNode(grammarAccess.getAbstractTypeAccess().getInt8ParserRuleCall_1());

                    pushFollow(FOLLOW_2);
                    this_int8_1=ruleint8();

                    state._fsp--;


                                current = this_int8_1;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 3 :
                    // InternalRosParser.g:3742:3: this_uint8_2= ruleuint8
                    {

                                newCompositeNode(grammarAccess.getAbstractTypeAccess().getUint8ParserRuleCall_2());

                    pushFollow(FOLLOW_2);
                    this_uint8_2=ruleuint8();

                    state._fsp--;


                                current = this_uint8_2;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 4 :
                    // InternalRosParser.g:3751:3: this_int16_3= ruleint16
                    {

                                newCompositeNode(grammarAccess.getAbstractTypeAccess().getInt16ParserRuleCall_3());

                    pushFollow(FOLLOW_2);
                    this_int16_3=ruleint16();

                    state._fsp--;


                                current = this_int16_3;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 5 :
                    // InternalRosParser.g:3760:3: this_uint16_4= ruleuint16
                    {

                                newCompositeNode(grammarAccess.getAbstractTypeAccess().getUint16ParserRuleCall_4());

                    pushFollow(FOLLOW_2);
                    this_uint16_4=ruleuint16();

                    state._fsp--;


                                current = this_uint16_4;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 6 :
                    // InternalRosParser.g:3769:3: this_int32_5= ruleint32
                    {

                                newCompositeNode(grammarAccess.getAbstractTypeAccess().getInt32ParserRuleCall_5());

                    pushFollow(FOLLOW_2);
                    this_int32_5=ruleint32();

                    state._fsp--;


                                current = this_int32_5;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 7 :
                    // InternalRosParser.g:3778:3: this_uint32_6= ruleuint32
                    {

                                newCompositeNode(grammarAccess.getAbstractTypeAccess().getUint32ParserRuleCall_6());

                    pushFollow(FOLLOW_2);
                    this_uint32_6=ruleuint32();

                    state._fsp--;


                                current = this_uint32_6;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 8 :
                    // InternalRosParser.g:3787:3: this_int64_7= ruleint64
                    {

                                newCompositeNode(grammarAccess.getAbstractTypeAccess().getInt64ParserRuleCall_7());

                    pushFollow(FOLLOW_2);
                    this_int64_7=ruleint64();

                    state._fsp--;


                                current = this_int64_7;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 9 :
                    // InternalRosParser.g:3796:3: this_uint64_8= ruleuint64
                    {

                                newCompositeNode(grammarAccess.getAbstractTypeAccess().getUint64ParserRuleCall_8());

                    pushFollow(FOLLOW_2);
                    this_uint64_8=ruleuint64();

                    state._fsp--;


                                current = this_uint64_8;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 10 :
                    // InternalRosParser.g:3805:3: this_float32_9= rulefloat32
                    {

                                newCompositeNode(grammarAccess.getAbstractTypeAccess().getFloat32ParserRuleCall_9());

                    pushFollow(FOLLOW_2);
                    this_float32_9=rulefloat32();

                    state._fsp--;


                                current = this_float32_9;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 11 :
                    // InternalRosParser.g:3814:3: this_float64_10= rulefloat64
                    {

                                newCompositeNode(grammarAccess.getAbstractTypeAccess().getFloat64ParserRuleCall_10());

                    pushFollow(FOLLOW_2);
                    this_float64_10=rulefloat64();

                    state._fsp--;


                                current = this_float64_10;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 12 :
                    // InternalRosParser.g:3823:3: this_string0_11= rulestring0
                    {

                                newCompositeNode(grammarAccess.getAbstractTypeAccess().getString0ParserRuleCall_11());

                    pushFollow(FOLLOW_2);
                    this_string0_11=rulestring0();

                    state._fsp--;


                                current = this_string0_11;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 13 :
                    // InternalRosParser.g:3832:3: this_byte_12= rulebyte
                    {

                                newCompositeNode(grammarAccess.getAbstractTypeAccess().getByteParserRuleCall_12());

                    pushFollow(FOLLOW_2);
                    this_byte_12=rulebyte();

                    state._fsp--;


                                current = this_byte_12;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 14 :
                    // InternalRosParser.g:3841:3: this_time_13= ruletime
                    {

                                newCompositeNode(grammarAccess.getAbstractTypeAccess().getTimeParserRuleCall_13());

                    pushFollow(FOLLOW_2);
                    this_time_13=ruletime();

                    state._fsp--;


                                current = this_time_13;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 15 :
                    // InternalRosParser.g:3850:3: this_duration_14= ruleduration
                    {

                                newCompositeNode(grammarAccess.getAbstractTypeAccess().getDurationParserRuleCall_14());

                    pushFollow(FOLLOW_2);
                    this_duration_14=ruleduration();

                    state._fsp--;


                                current = this_duration_14;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 16 :
                    // InternalRosParser.g:3859:3: this_Header_15= ruleHeader
                    {

                                newCompositeNode(grammarAccess.getAbstractTypeAccess().getHeaderParserRuleCall_15());

                    pushFollow(FOLLOW_2);
                    this_Header_15=ruleHeader();

                    state._fsp--;


                                current = this_Header_15;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 17 :
                    // InternalRosParser.g:3868:3: this_boolArray_16= ruleboolArray
                    {

                                newCompositeNode(grammarAccess.getAbstractTypeAccess().getBoolArrayParserRuleCall_16());

                    pushFollow(FOLLOW_2);
                    this_boolArray_16=ruleboolArray();

                    state._fsp--;


                                current = this_boolArray_16;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 18 :
                    // InternalRosParser.g:3877:3: this_int8Array_17= ruleint8Array
                    {

                                newCompositeNode(grammarAccess.getAbstractTypeAccess().getInt8ArrayParserRuleCall_17());

                    pushFollow(FOLLOW_2);
                    this_int8Array_17=ruleint8Array();

                    state._fsp--;


                                current = this_int8Array_17;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 19 :
                    // InternalRosParser.g:3886:3: this_uint8Array_18= ruleuint8Array
                    {

                                newCompositeNode(grammarAccess.getAbstractTypeAccess().getUint8ArrayParserRuleCall_18());

                    pushFollow(FOLLOW_2);
                    this_uint8Array_18=ruleuint8Array();

                    state._fsp--;


                                current = this_uint8Array_18;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 20 :
                    // InternalRosParser.g:3895:3: this_int16Array_19= ruleint16Array
                    {

                                newCompositeNode(grammarAccess.getAbstractTypeAccess().getInt16ArrayParserRuleCall_19());

                    pushFollow(FOLLOW_2);
                    this_int16Array_19=ruleint16Array();

                    state._fsp--;


                                current = this_int16Array_19;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 21 :
                    // InternalRosParser.g:3904:3: this_uint16Array_20= ruleuint16Array
                    {

                                newCompositeNode(grammarAccess.getAbstractTypeAccess().getUint16ArrayParserRuleCall_20());

                    pushFollow(FOLLOW_2);
                    this_uint16Array_20=ruleuint16Array();

                    state._fsp--;


                                current = this_uint16Array_20;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 22 :
                    // InternalRosParser.g:3913:3: this_int32Array_21= ruleint32Array
                    {

                                newCompositeNode(grammarAccess.getAbstractTypeAccess().getInt32ArrayParserRuleCall_21());

                    pushFollow(FOLLOW_2);
                    this_int32Array_21=ruleint32Array();

                    state._fsp--;


                                current = this_int32Array_21;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 23 :
                    // InternalRosParser.g:3922:3: this_uint32Array_22= ruleuint32Array
                    {

                                newCompositeNode(grammarAccess.getAbstractTypeAccess().getUint32ArrayParserRuleCall_22());

                    pushFollow(FOLLOW_2);
                    this_uint32Array_22=ruleuint32Array();

                    state._fsp--;


                                current = this_uint32Array_22;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 24 :
                    // InternalRosParser.g:3931:3: this_int64Array_23= ruleint64Array
                    {

                                newCompositeNode(grammarAccess.getAbstractTypeAccess().getInt64ArrayParserRuleCall_23());

                    pushFollow(FOLLOW_2);
                    this_int64Array_23=ruleint64Array();

                    state._fsp--;


                                current = this_int64Array_23;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 25 :
                    // InternalRosParser.g:3940:3: this_uint64Array_24= ruleuint64Array
                    {

                                newCompositeNode(grammarAccess.getAbstractTypeAccess().getUint64ArrayParserRuleCall_24());

                    pushFollow(FOLLOW_2);
                    this_uint64Array_24=ruleuint64Array();

                    state._fsp--;


                                current = this_uint64Array_24;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 26 :
                    // InternalRosParser.g:3949:3: this_float32Array_25= rulefloat32Array
                    {

                                newCompositeNode(grammarAccess.getAbstractTypeAccess().getFloat32ArrayParserRuleCall_25());

                    pushFollow(FOLLOW_2);
                    this_float32Array_25=rulefloat32Array();

                    state._fsp--;


                                current = this_float32Array_25;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 27 :
                    // InternalRosParser.g:3958:3: this_float64Array_26= rulefloat64Array
                    {

                                newCompositeNode(grammarAccess.getAbstractTypeAccess().getFloat64ArrayParserRuleCall_26());

                    pushFollow(FOLLOW_2);
                    this_float64Array_26=rulefloat64Array();

                    state._fsp--;


                                current = this_float64Array_26;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 28 :
                    // InternalRosParser.g:3967:3: this_string0Array_27= rulestring0Array
                    {

                                newCompositeNode(grammarAccess.getAbstractTypeAccess().getString0ArrayParserRuleCall_27());

                    pushFollow(FOLLOW_2);
                    this_string0Array_27=rulestring0Array();

                    state._fsp--;


                                current = this_string0Array_27;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 29 :
                    // InternalRosParser.g:3976:3: this_byteArray_28= rulebyteArray
                    {

                                newCompositeNode(grammarAccess.getAbstractTypeAccess().getByteArrayParserRuleCall_28());

                    pushFollow(FOLLOW_2);
                    this_byteArray_28=rulebyteArray();

                    state._fsp--;


                                current = this_byteArray_28;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 30 :
                    // InternalRosParser.g:3985:3: this_TopicSpecRef_29= ruleTopicSpecRef
                    {

                                newCompositeNode(grammarAccess.getAbstractTypeAccess().getTopicSpecRefParserRuleCall_29());

                    pushFollow(FOLLOW_2);
                    this_TopicSpecRef_29=ruleTopicSpecRef();

                    state._fsp--;


                                current = this_TopicSpecRef_29;
                                afterParserOrEnumRuleCall();


                    }
                    break;
                case 31 :
                    // InternalRosParser.g:3994:3: this_ArrayTopicSpecRef_30= ruleArrayTopicSpecRef
                    {

                                newCompositeNode(grammarAccess.getAbstractTypeAccess().getArrayTopicSpecRefParserRuleCall_30());

                    pushFollow(FOLLOW_2);
                    this_ArrayTopicSpecRef_30=ruleArrayTopicSpecRef();

                    state._fsp--;


                                current = this_ArrayTopicSpecRef_30;
                                afterParserOrEnumRuleCall();


                    }
                    break;

            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractType"


    // $ANTLR start "entryRulebool"
    // InternalRosParser.g:4006:1: entryRulebool returns [EObject current=null] : iv_rulebool= rulebool EOF ;
    public final EObject entryRulebool() throws RecognitionException {
        EObject current = null;

        EObject iv_rulebool = null;


        try {
            // InternalRosParser.g:4006:45: (iv_rulebool= rulebool EOF )
            // InternalRosParser.g:4007:2: iv_rulebool= rulebool EOF
            {
             newCompositeNode(grammarAccess.getBoolRule());
            pushFollow(FOLLOW_1);
            iv_rulebool=rulebool();

            state._fsp--;

             current =iv_rulebool;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulebool"


    // $ANTLR start "rulebool"
    // InternalRosParser.g:4013:1: rulebool returns [EObject current=null] : ( () otherlv_1= Bool ) ;
    public final EObject rulebool() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


            enterRule();

        try {
            // InternalRosParser.g:4019:2: ( ( () otherlv_1= Bool ) )
            // InternalRosParser.g:4020:2: ( () otherlv_1= Bool )
            {
            // InternalRosParser.g:4020:2: ( () otherlv_1= Bool )
            // InternalRosParser.g:4021:3: () otherlv_1= Bool
            {
            // InternalRosParser.g:4021:3: ()
            // InternalRosParser.g:4022:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getBoolAccess().getBoolAction_0(),
                                current);


            }

            otherlv_1=(Token)match(input,Bool,FOLLOW_2);

                        newLeafNode(otherlv_1, grammarAccess.getBoolAccess().getBoolKeyword_1());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulebool"


    // $ANTLR start "entryRuleint8"
    // InternalRosParser.g:4036:1: entryRuleint8 returns [EObject current=null] : iv_ruleint8= ruleint8 EOF ;
    public final EObject entryRuleint8() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint8 = null;


        try {
            // InternalRosParser.g:4036:45: (iv_ruleint8= ruleint8 EOF )
            // InternalRosParser.g:4037:2: iv_ruleint8= ruleint8 EOF
            {
             newCompositeNode(grammarAccess.getInt8Rule());
            pushFollow(FOLLOW_1);
            iv_ruleint8=ruleint8();

            state._fsp--;

             current =iv_ruleint8;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleint8"


    // $ANTLR start "ruleint8"
    // InternalRosParser.g:4043:1: ruleint8 returns [EObject current=null] : ( () otherlv_1= Int8 ) ;
    public final EObject ruleint8() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


            enterRule();

        try {
            // InternalRosParser.g:4049:2: ( ( () otherlv_1= Int8 ) )
            // InternalRosParser.g:4050:2: ( () otherlv_1= Int8 )
            {
            // InternalRosParser.g:4050:2: ( () otherlv_1= Int8 )
            // InternalRosParser.g:4051:3: () otherlv_1= Int8
            {
            // InternalRosParser.g:4051:3: ()
            // InternalRosParser.g:4052:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getInt8Access().getInt8Action_0(),
                                current);


            }

            otherlv_1=(Token)match(input,Int8,FOLLOW_2);

                        newLeafNode(otherlv_1, grammarAccess.getInt8Access().getInt8Keyword_1());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleint8"


    // $ANTLR start "entryRuleuint8"
    // InternalRosParser.g:4066:1: entryRuleuint8 returns [EObject current=null] : iv_ruleuint8= ruleuint8 EOF ;
    public final EObject entryRuleuint8() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint8 = null;


        try {
            // InternalRosParser.g:4066:46: (iv_ruleuint8= ruleuint8 EOF )
            // InternalRosParser.g:4067:2: iv_ruleuint8= ruleuint8 EOF
            {
             newCompositeNode(grammarAccess.getUint8Rule());
            pushFollow(FOLLOW_1);
            iv_ruleuint8=ruleuint8();

            state._fsp--;

             current =iv_ruleuint8;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleuint8"


    // $ANTLR start "ruleuint8"
    // InternalRosParser.g:4073:1: ruleuint8 returns [EObject current=null] : ( () otherlv_1= Uint8 ) ;
    public final EObject ruleuint8() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


            enterRule();

        try {
            // InternalRosParser.g:4079:2: ( ( () otherlv_1= Uint8 ) )
            // InternalRosParser.g:4080:2: ( () otherlv_1= Uint8 )
            {
            // InternalRosParser.g:4080:2: ( () otherlv_1= Uint8 )
            // InternalRosParser.g:4081:3: () otherlv_1= Uint8
            {
            // InternalRosParser.g:4081:3: ()
            // InternalRosParser.g:4082:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getUint8Access().getUint8Action_0(),
                                current);


            }

            otherlv_1=(Token)match(input,Uint8,FOLLOW_2);

                        newLeafNode(otherlv_1, grammarAccess.getUint8Access().getUint8Keyword_1());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleuint8"


    // $ANTLR start "entryRuleint16"
    // InternalRosParser.g:4096:1: entryRuleint16 returns [EObject current=null] : iv_ruleint16= ruleint16 EOF ;
    public final EObject entryRuleint16() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint16 = null;


        try {
            // InternalRosParser.g:4096:46: (iv_ruleint16= ruleint16 EOF )
            // InternalRosParser.g:4097:2: iv_ruleint16= ruleint16 EOF
            {
             newCompositeNode(grammarAccess.getInt16Rule());
            pushFollow(FOLLOW_1);
            iv_ruleint16=ruleint16();

            state._fsp--;

             current =iv_ruleint16;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleint16"


    // $ANTLR start "ruleint16"
    // InternalRosParser.g:4103:1: ruleint16 returns [EObject current=null] : ( () otherlv_1= Int16 ) ;
    public final EObject ruleint16() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


            enterRule();

        try {
            // InternalRosParser.g:4109:2: ( ( () otherlv_1= Int16 ) )
            // InternalRosParser.g:4110:2: ( () otherlv_1= Int16 )
            {
            // InternalRosParser.g:4110:2: ( () otherlv_1= Int16 )
            // InternalRosParser.g:4111:3: () otherlv_1= Int16
            {
            // InternalRosParser.g:4111:3: ()
            // InternalRosParser.g:4112:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getInt16Access().getInt16Action_0(),
                                current);


            }

            otherlv_1=(Token)match(input,Int16,FOLLOW_2);

                        newLeafNode(otherlv_1, grammarAccess.getInt16Access().getInt16Keyword_1());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleint16"


    // $ANTLR start "entryRuleuint16"
    // InternalRosParser.g:4126:1: entryRuleuint16 returns [EObject current=null] : iv_ruleuint16= ruleuint16 EOF ;
    public final EObject entryRuleuint16() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint16 = null;


        try {
            // InternalRosParser.g:4126:47: (iv_ruleuint16= ruleuint16 EOF )
            // InternalRosParser.g:4127:2: iv_ruleuint16= ruleuint16 EOF
            {
             newCompositeNode(grammarAccess.getUint16Rule());
            pushFollow(FOLLOW_1);
            iv_ruleuint16=ruleuint16();

            state._fsp--;

             current =iv_ruleuint16;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleuint16"


    // $ANTLR start "ruleuint16"
    // InternalRosParser.g:4133:1: ruleuint16 returns [EObject current=null] : ( () otherlv_1= Uint16 ) ;
    public final EObject ruleuint16() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


            enterRule();

        try {
            // InternalRosParser.g:4139:2: ( ( () otherlv_1= Uint16 ) )
            // InternalRosParser.g:4140:2: ( () otherlv_1= Uint16 )
            {
            // InternalRosParser.g:4140:2: ( () otherlv_1= Uint16 )
            // InternalRosParser.g:4141:3: () otherlv_1= Uint16
            {
            // InternalRosParser.g:4141:3: ()
            // InternalRosParser.g:4142:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getUint16Access().getUint16Action_0(),
                                current);


            }

            otherlv_1=(Token)match(input,Uint16,FOLLOW_2);

                        newLeafNode(otherlv_1, grammarAccess.getUint16Access().getUint16Keyword_1());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleuint16"


    // $ANTLR start "entryRuleint32"
    // InternalRosParser.g:4156:1: entryRuleint32 returns [EObject current=null] : iv_ruleint32= ruleint32 EOF ;
    public final EObject entryRuleint32() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint32 = null;


        try {
            // InternalRosParser.g:4156:46: (iv_ruleint32= ruleint32 EOF )
            // InternalRosParser.g:4157:2: iv_ruleint32= ruleint32 EOF
            {
             newCompositeNode(grammarAccess.getInt32Rule());
            pushFollow(FOLLOW_1);
            iv_ruleint32=ruleint32();

            state._fsp--;

             current =iv_ruleint32;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleint32"


    // $ANTLR start "ruleint32"
    // InternalRosParser.g:4163:1: ruleint32 returns [EObject current=null] : ( () otherlv_1= Int32 ) ;
    public final EObject ruleint32() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


            enterRule();

        try {
            // InternalRosParser.g:4169:2: ( ( () otherlv_1= Int32 ) )
            // InternalRosParser.g:4170:2: ( () otherlv_1= Int32 )
            {
            // InternalRosParser.g:4170:2: ( () otherlv_1= Int32 )
            // InternalRosParser.g:4171:3: () otherlv_1= Int32
            {
            // InternalRosParser.g:4171:3: ()
            // InternalRosParser.g:4172:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getInt32Access().getInt32Action_0(),
                                current);


            }

            otherlv_1=(Token)match(input,Int32,FOLLOW_2);

                        newLeafNode(otherlv_1, grammarAccess.getInt32Access().getInt32Keyword_1());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleint32"


    // $ANTLR start "entryRuleuint32"
    // InternalRosParser.g:4186:1: entryRuleuint32 returns [EObject current=null] : iv_ruleuint32= ruleuint32 EOF ;
    public final EObject entryRuleuint32() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint32 = null;


        try {
            // InternalRosParser.g:4186:47: (iv_ruleuint32= ruleuint32 EOF )
            // InternalRosParser.g:4187:2: iv_ruleuint32= ruleuint32 EOF
            {
             newCompositeNode(grammarAccess.getUint32Rule());
            pushFollow(FOLLOW_1);
            iv_ruleuint32=ruleuint32();

            state._fsp--;

             current =iv_ruleuint32;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleuint32"


    // $ANTLR start "ruleuint32"
    // InternalRosParser.g:4193:1: ruleuint32 returns [EObject current=null] : ( () otherlv_1= Uint32 ) ;
    public final EObject ruleuint32() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


            enterRule();

        try {
            // InternalRosParser.g:4199:2: ( ( () otherlv_1= Uint32 ) )
            // InternalRosParser.g:4200:2: ( () otherlv_1= Uint32 )
            {
            // InternalRosParser.g:4200:2: ( () otherlv_1= Uint32 )
            // InternalRosParser.g:4201:3: () otherlv_1= Uint32
            {
            // InternalRosParser.g:4201:3: ()
            // InternalRosParser.g:4202:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getUint32Access().getUint32Action_0(),
                                current);


            }

            otherlv_1=(Token)match(input,Uint32,FOLLOW_2);

                        newLeafNode(otherlv_1, grammarAccess.getUint32Access().getUint32Keyword_1());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleuint32"


    // $ANTLR start "entryRuleint64"
    // InternalRosParser.g:4216:1: entryRuleint64 returns [EObject current=null] : iv_ruleint64= ruleint64 EOF ;
    public final EObject entryRuleint64() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint64 = null;


        try {
            // InternalRosParser.g:4216:46: (iv_ruleint64= ruleint64 EOF )
            // InternalRosParser.g:4217:2: iv_ruleint64= ruleint64 EOF
            {
             newCompositeNode(grammarAccess.getInt64Rule());
            pushFollow(FOLLOW_1);
            iv_ruleint64=ruleint64();

            state._fsp--;

             current =iv_ruleint64;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleint64"


    // $ANTLR start "ruleint64"
    // InternalRosParser.g:4223:1: ruleint64 returns [EObject current=null] : ( () otherlv_1= Int64 ) ;
    public final EObject ruleint64() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


            enterRule();

        try {
            // InternalRosParser.g:4229:2: ( ( () otherlv_1= Int64 ) )
            // InternalRosParser.g:4230:2: ( () otherlv_1= Int64 )
            {
            // InternalRosParser.g:4230:2: ( () otherlv_1= Int64 )
            // InternalRosParser.g:4231:3: () otherlv_1= Int64
            {
            // InternalRosParser.g:4231:3: ()
            // InternalRosParser.g:4232:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getInt64Access().getInt64Action_0(),
                                current);


            }

            otherlv_1=(Token)match(input,Int64,FOLLOW_2);

                        newLeafNode(otherlv_1, grammarAccess.getInt64Access().getInt64Keyword_1());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleint64"


    // $ANTLR start "entryRuleuint64"
    // InternalRosParser.g:4246:1: entryRuleuint64 returns [EObject current=null] : iv_ruleuint64= ruleuint64 EOF ;
    public final EObject entryRuleuint64() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint64 = null;


        try {
            // InternalRosParser.g:4246:47: (iv_ruleuint64= ruleuint64 EOF )
            // InternalRosParser.g:4247:2: iv_ruleuint64= ruleuint64 EOF
            {
             newCompositeNode(grammarAccess.getUint64Rule());
            pushFollow(FOLLOW_1);
            iv_ruleuint64=ruleuint64();

            state._fsp--;

             current =iv_ruleuint64;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleuint64"


    // $ANTLR start "ruleuint64"
    // InternalRosParser.g:4253:1: ruleuint64 returns [EObject current=null] : ( () otherlv_1= Uint64 ) ;
    public final EObject ruleuint64() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


            enterRule();

        try {
            // InternalRosParser.g:4259:2: ( ( () otherlv_1= Uint64 ) )
            // InternalRosParser.g:4260:2: ( () otherlv_1= Uint64 )
            {
            // InternalRosParser.g:4260:2: ( () otherlv_1= Uint64 )
            // InternalRosParser.g:4261:3: () otherlv_1= Uint64
            {
            // InternalRosParser.g:4261:3: ()
            // InternalRosParser.g:4262:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getUint64Access().getUint64Action_0(),
                                current);


            }

            otherlv_1=(Token)match(input,Uint64,FOLLOW_2);

                        newLeafNode(otherlv_1, grammarAccess.getUint64Access().getUint64Keyword_1());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleuint64"


    // $ANTLR start "entryRulefloat32"
    // InternalRosParser.g:4276:1: entryRulefloat32 returns [EObject current=null] : iv_rulefloat32= rulefloat32 EOF ;
    public final EObject entryRulefloat32() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefloat32 = null;


        try {
            // InternalRosParser.g:4276:48: (iv_rulefloat32= rulefloat32 EOF )
            // InternalRosParser.g:4277:2: iv_rulefloat32= rulefloat32 EOF
            {
             newCompositeNode(grammarAccess.getFloat32Rule());
            pushFollow(FOLLOW_1);
            iv_rulefloat32=rulefloat32();

            state._fsp--;

             current =iv_rulefloat32;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulefloat32"


    // $ANTLR start "rulefloat32"
    // InternalRosParser.g:4283:1: rulefloat32 returns [EObject current=null] : ( () otherlv_1= Float32 ) ;
    public final EObject rulefloat32() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


            enterRule();

        try {
            // InternalRosParser.g:4289:2: ( ( () otherlv_1= Float32 ) )
            // InternalRosParser.g:4290:2: ( () otherlv_1= Float32 )
            {
            // InternalRosParser.g:4290:2: ( () otherlv_1= Float32 )
            // InternalRosParser.g:4291:3: () otherlv_1= Float32
            {
            // InternalRosParser.g:4291:3: ()
            // InternalRosParser.g:4292:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getFloat32Access().getFloat32Action_0(),
                                current);


            }

            otherlv_1=(Token)match(input,Float32,FOLLOW_2);

                        newLeafNode(otherlv_1, grammarAccess.getFloat32Access().getFloat32Keyword_1());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulefloat32"


    // $ANTLR start "entryRulefloat64"
    // InternalRosParser.g:4306:1: entryRulefloat64 returns [EObject current=null] : iv_rulefloat64= rulefloat64 EOF ;
    public final EObject entryRulefloat64() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefloat64 = null;


        try {
            // InternalRosParser.g:4306:48: (iv_rulefloat64= rulefloat64 EOF )
            // InternalRosParser.g:4307:2: iv_rulefloat64= rulefloat64 EOF
            {
             newCompositeNode(grammarAccess.getFloat64Rule());
            pushFollow(FOLLOW_1);
            iv_rulefloat64=rulefloat64();

            state._fsp--;

             current =iv_rulefloat64;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulefloat64"


    // $ANTLR start "rulefloat64"
    // InternalRosParser.g:4313:1: rulefloat64 returns [EObject current=null] : ( () otherlv_1= Float64 ) ;
    public final EObject rulefloat64() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


            enterRule();

        try {
            // InternalRosParser.g:4319:2: ( ( () otherlv_1= Float64 ) )
            // InternalRosParser.g:4320:2: ( () otherlv_1= Float64 )
            {
            // InternalRosParser.g:4320:2: ( () otherlv_1= Float64 )
            // InternalRosParser.g:4321:3: () otherlv_1= Float64
            {
            // InternalRosParser.g:4321:3: ()
            // InternalRosParser.g:4322:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getFloat64Access().getFloat64Action_0(),
                                current);


            }

            otherlv_1=(Token)match(input,Float64,FOLLOW_2);

                        newLeafNode(otherlv_1, grammarAccess.getFloat64Access().getFloat64Keyword_1());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulefloat64"


    // $ANTLR start "entryRulestring0"
    // InternalRosParser.g:4336:1: entryRulestring0 returns [EObject current=null] : iv_rulestring0= rulestring0 EOF ;
    public final EObject entryRulestring0() throws RecognitionException {
        EObject current = null;

        EObject iv_rulestring0 = null;


        try {
            // InternalRosParser.g:4336:48: (iv_rulestring0= rulestring0 EOF )
            // InternalRosParser.g:4337:2: iv_rulestring0= rulestring0 EOF
            {
             newCompositeNode(grammarAccess.getString0Rule());
            pushFollow(FOLLOW_1);
            iv_rulestring0=rulestring0();

            state._fsp--;

             current =iv_rulestring0;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulestring0"


    // $ANTLR start "rulestring0"
    // InternalRosParser.g:4343:1: rulestring0 returns [EObject current=null] : ( () otherlv_1= String_1 ) ;
    public final EObject rulestring0() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


            enterRule();

        try {
            // InternalRosParser.g:4349:2: ( ( () otherlv_1= String_1 ) )
            // InternalRosParser.g:4350:2: ( () otherlv_1= String_1 )
            {
            // InternalRosParser.g:4350:2: ( () otherlv_1= String_1 )
            // InternalRosParser.g:4351:3: () otherlv_1= String_1
            {
            // InternalRosParser.g:4351:3: ()
            // InternalRosParser.g:4352:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getString0Access().getStringAction_0(),
                                current);


            }

            otherlv_1=(Token)match(input,String_1,FOLLOW_2);

                        newLeafNode(otherlv_1, grammarAccess.getString0Access().getStringKeyword_1());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulestring0"


    // $ANTLR start "entryRulebyte"
    // InternalRosParser.g:4366:1: entryRulebyte returns [EObject current=null] : iv_rulebyte= rulebyte EOF ;
    public final EObject entryRulebyte() throws RecognitionException {
        EObject current = null;

        EObject iv_rulebyte = null;


        try {
            // InternalRosParser.g:4366:45: (iv_rulebyte= rulebyte EOF )
            // InternalRosParser.g:4367:2: iv_rulebyte= rulebyte EOF
            {
             newCompositeNode(grammarAccess.getByteRule());
            pushFollow(FOLLOW_1);
            iv_rulebyte=rulebyte();

            state._fsp--;

             current =iv_rulebyte;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulebyte"


    // $ANTLR start "rulebyte"
    // InternalRosParser.g:4373:1: rulebyte returns [EObject current=null] : ( () otherlv_1= Byte ) ;
    public final EObject rulebyte() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


            enterRule();

        try {
            // InternalRosParser.g:4379:2: ( ( () otherlv_1= Byte ) )
            // InternalRosParser.g:4380:2: ( () otherlv_1= Byte )
            {
            // InternalRosParser.g:4380:2: ( () otherlv_1= Byte )
            // InternalRosParser.g:4381:3: () otherlv_1= Byte
            {
            // InternalRosParser.g:4381:3: ()
            // InternalRosParser.g:4382:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getByteAccess().getByteAction_0(),
                                current);


            }

            otherlv_1=(Token)match(input,Byte,FOLLOW_2);

                        newLeafNode(otherlv_1, grammarAccess.getByteAccess().getByteKeyword_1());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulebyte"


    // $ANTLR start "entryRuletime"
    // InternalRosParser.g:4396:1: entryRuletime returns [EObject current=null] : iv_ruletime= ruletime EOF ;
    public final EObject entryRuletime() throws RecognitionException {
        EObject current = null;

        EObject iv_ruletime = null;


        try {
            // InternalRosParser.g:4396:45: (iv_ruletime= ruletime EOF )
            // InternalRosParser.g:4397:2: iv_ruletime= ruletime EOF
            {
             newCompositeNode(grammarAccess.getTimeRule());
            pushFollow(FOLLOW_1);
            iv_ruletime=ruletime();

            state._fsp--;

             current =iv_ruletime;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuletime"


    // $ANTLR start "ruletime"
    // InternalRosParser.g:4403:1: ruletime returns [EObject current=null] : ( () otherlv_1= Time ) ;
    public final EObject ruletime() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


            enterRule();

        try {
            // InternalRosParser.g:4409:2: ( ( () otherlv_1= Time ) )
            // InternalRosParser.g:4410:2: ( () otherlv_1= Time )
            {
            // InternalRosParser.g:4410:2: ( () otherlv_1= Time )
            // InternalRosParser.g:4411:3: () otherlv_1= Time
            {
            // InternalRosParser.g:4411:3: ()
            // InternalRosParser.g:4412:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getTimeAccess().getTimeAction_0(),
                                current);


            }

            otherlv_1=(Token)match(input,Time,FOLLOW_2);

                        newLeafNode(otherlv_1, grammarAccess.getTimeAccess().getTimeKeyword_1());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruletime"


    // $ANTLR start "entryRuleduration"
    // InternalRosParser.g:4426:1: entryRuleduration returns [EObject current=null] : iv_ruleduration= ruleduration EOF ;
    public final EObject entryRuleduration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleduration = null;


        try {
            // InternalRosParser.g:4426:49: (iv_ruleduration= ruleduration EOF )
            // InternalRosParser.g:4427:2: iv_ruleduration= ruleduration EOF
            {
             newCompositeNode(grammarAccess.getDurationRule());
            pushFollow(FOLLOW_1);
            iv_ruleduration=ruleduration();

            state._fsp--;

             current =iv_ruleduration;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleduration"


    // $ANTLR start "ruleduration"
    // InternalRosParser.g:4433:1: ruleduration returns [EObject current=null] : ( () otherlv_1= Duration ) ;
    public final EObject ruleduration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


            enterRule();

        try {
            // InternalRosParser.g:4439:2: ( ( () otherlv_1= Duration ) )
            // InternalRosParser.g:4440:2: ( () otherlv_1= Duration )
            {
            // InternalRosParser.g:4440:2: ( () otherlv_1= Duration )
            // InternalRosParser.g:4441:3: () otherlv_1= Duration
            {
            // InternalRosParser.g:4441:3: ()
            // InternalRosParser.g:4442:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getDurationAccess().getDurationAction_0(),
                                current);


            }

            otherlv_1=(Token)match(input,Duration,FOLLOW_2);

                        newLeafNode(otherlv_1, grammarAccess.getDurationAccess().getDurationKeyword_1());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleduration"


    // $ANTLR start "entryRuleboolArray"
    // InternalRosParser.g:4456:1: entryRuleboolArray returns [EObject current=null] : iv_ruleboolArray= ruleboolArray EOF ;
    public final EObject entryRuleboolArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleboolArray = null;


        try {
            // InternalRosParser.g:4456:50: (iv_ruleboolArray= ruleboolArray EOF )
            // InternalRosParser.g:4457:2: iv_ruleboolArray= ruleboolArray EOF
            {
             newCompositeNode(grammarAccess.getBoolArrayRule());
            pushFollow(FOLLOW_1);
            iv_ruleboolArray=ruleboolArray();

            state._fsp--;

             current =iv_ruleboolArray;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleboolArray"


    // $ANTLR start "ruleboolArray"
    // InternalRosParser.g:4463:1: ruleboolArray returns [EObject current=null] : ( () otherlv_1= Bool_1 ) ;
    public final EObject ruleboolArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


            enterRule();

        try {
            // InternalRosParser.g:4469:2: ( ( () otherlv_1= Bool_1 ) )
            // InternalRosParser.g:4470:2: ( () otherlv_1= Bool_1 )
            {
            // InternalRosParser.g:4470:2: ( () otherlv_1= Bool_1 )
            // InternalRosParser.g:4471:3: () otherlv_1= Bool_1
            {
            // InternalRosParser.g:4471:3: ()
            // InternalRosParser.g:4472:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getBoolArrayAccess().getBoolArrayAction_0(),
                                current);


            }

            otherlv_1=(Token)match(input,Bool_1,FOLLOW_2);

                        newLeafNode(otherlv_1, grammarAccess.getBoolArrayAccess().getBoolKeyword_1());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleboolArray"


    // $ANTLR start "entryRuleint8Array"
    // InternalRosParser.g:4486:1: entryRuleint8Array returns [EObject current=null] : iv_ruleint8Array= ruleint8Array EOF ;
    public final EObject entryRuleint8Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint8Array = null;


        try {
            // InternalRosParser.g:4486:50: (iv_ruleint8Array= ruleint8Array EOF )
            // InternalRosParser.g:4487:2: iv_ruleint8Array= ruleint8Array EOF
            {
             newCompositeNode(grammarAccess.getInt8ArrayRule());
            pushFollow(FOLLOW_1);
            iv_ruleint8Array=ruleint8Array();

            state._fsp--;

             current =iv_ruleint8Array;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleint8Array"


    // $ANTLR start "ruleint8Array"
    // InternalRosParser.g:4493:1: ruleint8Array returns [EObject current=null] : ( () otherlv_1= Int8_1 ) ;
    public final EObject ruleint8Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


            enterRule();

        try {
            // InternalRosParser.g:4499:2: ( ( () otherlv_1= Int8_1 ) )
            // InternalRosParser.g:4500:2: ( () otherlv_1= Int8_1 )
            {
            // InternalRosParser.g:4500:2: ( () otherlv_1= Int8_1 )
            // InternalRosParser.g:4501:3: () otherlv_1= Int8_1
            {
            // InternalRosParser.g:4501:3: ()
            // InternalRosParser.g:4502:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getInt8ArrayAccess().getInt8ArrayAction_0(),
                                current);


            }

            otherlv_1=(Token)match(input,Int8_1,FOLLOW_2);

                        newLeafNode(otherlv_1, grammarAccess.getInt8ArrayAccess().getInt8Keyword_1());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleint8Array"


    // $ANTLR start "entryRuleuint8Array"
    // InternalRosParser.g:4516:1: entryRuleuint8Array returns [EObject current=null] : iv_ruleuint8Array= ruleuint8Array EOF ;
    public final EObject entryRuleuint8Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint8Array = null;


        try {
            // InternalRosParser.g:4516:51: (iv_ruleuint8Array= ruleuint8Array EOF )
            // InternalRosParser.g:4517:2: iv_ruleuint8Array= ruleuint8Array EOF
            {
             newCompositeNode(grammarAccess.getUint8ArrayRule());
            pushFollow(FOLLOW_1);
            iv_ruleuint8Array=ruleuint8Array();

            state._fsp--;

             current =iv_ruleuint8Array;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleuint8Array"


    // $ANTLR start "ruleuint8Array"
    // InternalRosParser.g:4523:1: ruleuint8Array returns [EObject current=null] : ( () otherlv_1= Uint8_1 ) ;
    public final EObject ruleuint8Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


            enterRule();

        try {
            // InternalRosParser.g:4529:2: ( ( () otherlv_1= Uint8_1 ) )
            // InternalRosParser.g:4530:2: ( () otherlv_1= Uint8_1 )
            {
            // InternalRosParser.g:4530:2: ( () otherlv_1= Uint8_1 )
            // InternalRosParser.g:4531:3: () otherlv_1= Uint8_1
            {
            // InternalRosParser.g:4531:3: ()
            // InternalRosParser.g:4532:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getUint8ArrayAccess().getUint8ArrayAction_0(),
                                current);


            }

            otherlv_1=(Token)match(input,Uint8_1,FOLLOW_2);

                        newLeafNode(otherlv_1, grammarAccess.getUint8ArrayAccess().getUint8Keyword_1());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleuint8Array"


    // $ANTLR start "entryRuleint16Array"
    // InternalRosParser.g:4546:1: entryRuleint16Array returns [EObject current=null] : iv_ruleint16Array= ruleint16Array EOF ;
    public final EObject entryRuleint16Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint16Array = null;


        try {
            // InternalRosParser.g:4546:51: (iv_ruleint16Array= ruleint16Array EOF )
            // InternalRosParser.g:4547:2: iv_ruleint16Array= ruleint16Array EOF
            {
             newCompositeNode(grammarAccess.getInt16ArrayRule());
            pushFollow(FOLLOW_1);
            iv_ruleint16Array=ruleint16Array();

            state._fsp--;

             current =iv_ruleint16Array;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleint16Array"


    // $ANTLR start "ruleint16Array"
    // InternalRosParser.g:4553:1: ruleint16Array returns [EObject current=null] : ( () otherlv_1= Int16_1 ) ;
    public final EObject ruleint16Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


            enterRule();

        try {
            // InternalRosParser.g:4559:2: ( ( () otherlv_1= Int16_1 ) )
            // InternalRosParser.g:4560:2: ( () otherlv_1= Int16_1 )
            {
            // InternalRosParser.g:4560:2: ( () otherlv_1= Int16_1 )
            // InternalRosParser.g:4561:3: () otherlv_1= Int16_1
            {
            // InternalRosParser.g:4561:3: ()
            // InternalRosParser.g:4562:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getInt16ArrayAccess().getInt16ArrayAction_0(),
                                current);


            }

            otherlv_1=(Token)match(input,Int16_1,FOLLOW_2);

                        newLeafNode(otherlv_1, grammarAccess.getInt16ArrayAccess().getInt16Keyword_1());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleint16Array"


    // $ANTLR start "entryRuleuint16Array"
    // InternalRosParser.g:4576:1: entryRuleuint16Array returns [EObject current=null] : iv_ruleuint16Array= ruleuint16Array EOF ;
    public final EObject entryRuleuint16Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint16Array = null;


        try {
            // InternalRosParser.g:4576:52: (iv_ruleuint16Array= ruleuint16Array EOF )
            // InternalRosParser.g:4577:2: iv_ruleuint16Array= ruleuint16Array EOF
            {
             newCompositeNode(grammarAccess.getUint16ArrayRule());
            pushFollow(FOLLOW_1);
            iv_ruleuint16Array=ruleuint16Array();

            state._fsp--;

             current =iv_ruleuint16Array;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleuint16Array"


    // $ANTLR start "ruleuint16Array"
    // InternalRosParser.g:4583:1: ruleuint16Array returns [EObject current=null] : ( () otherlv_1= Uint16_1 ) ;
    public final EObject ruleuint16Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


            enterRule();

        try {
            // InternalRosParser.g:4589:2: ( ( () otherlv_1= Uint16_1 ) )
            // InternalRosParser.g:4590:2: ( () otherlv_1= Uint16_1 )
            {
            // InternalRosParser.g:4590:2: ( () otherlv_1= Uint16_1 )
            // InternalRosParser.g:4591:3: () otherlv_1= Uint16_1
            {
            // InternalRosParser.g:4591:3: ()
            // InternalRosParser.g:4592:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getUint16ArrayAccess().getUint16ArrayAction_0(),
                                current);


            }

            otherlv_1=(Token)match(input,Uint16_1,FOLLOW_2);

                        newLeafNode(otherlv_1, grammarAccess.getUint16ArrayAccess().getUint16Keyword_1());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleuint16Array"


    // $ANTLR start "entryRuleint32Array"
    // InternalRosParser.g:4606:1: entryRuleint32Array returns [EObject current=null] : iv_ruleint32Array= ruleint32Array EOF ;
    public final EObject entryRuleint32Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint32Array = null;


        try {
            // InternalRosParser.g:4606:51: (iv_ruleint32Array= ruleint32Array EOF )
            // InternalRosParser.g:4607:2: iv_ruleint32Array= ruleint32Array EOF
            {
             newCompositeNode(grammarAccess.getInt32ArrayRule());
            pushFollow(FOLLOW_1);
            iv_ruleint32Array=ruleint32Array();

            state._fsp--;

             current =iv_ruleint32Array;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleint32Array"


    // $ANTLR start "ruleint32Array"
    // InternalRosParser.g:4613:1: ruleint32Array returns [EObject current=null] : ( () otherlv_1= Int32_1 ) ;
    public final EObject ruleint32Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


            enterRule();

        try {
            // InternalRosParser.g:4619:2: ( ( () otherlv_1= Int32_1 ) )
            // InternalRosParser.g:4620:2: ( () otherlv_1= Int32_1 )
            {
            // InternalRosParser.g:4620:2: ( () otherlv_1= Int32_1 )
            // InternalRosParser.g:4621:3: () otherlv_1= Int32_1
            {
            // InternalRosParser.g:4621:3: ()
            // InternalRosParser.g:4622:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getInt32ArrayAccess().getInt32ArrayAction_0(),
                                current);


            }

            otherlv_1=(Token)match(input,Int32_1,FOLLOW_2);

                        newLeafNode(otherlv_1, grammarAccess.getInt32ArrayAccess().getInt32Keyword_1());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleint32Array"


    // $ANTLR start "entryRuleuint32Array"
    // InternalRosParser.g:4636:1: entryRuleuint32Array returns [EObject current=null] : iv_ruleuint32Array= ruleuint32Array EOF ;
    public final EObject entryRuleuint32Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint32Array = null;


        try {
            // InternalRosParser.g:4636:52: (iv_ruleuint32Array= ruleuint32Array EOF )
            // InternalRosParser.g:4637:2: iv_ruleuint32Array= ruleuint32Array EOF
            {
             newCompositeNode(grammarAccess.getUint32ArrayRule());
            pushFollow(FOLLOW_1);
            iv_ruleuint32Array=ruleuint32Array();

            state._fsp--;

             current =iv_ruleuint32Array;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleuint32Array"


    // $ANTLR start "ruleuint32Array"
    // InternalRosParser.g:4643:1: ruleuint32Array returns [EObject current=null] : ( () otherlv_1= Uint32_1 ) ;
    public final EObject ruleuint32Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


            enterRule();

        try {
            // InternalRosParser.g:4649:2: ( ( () otherlv_1= Uint32_1 ) )
            // InternalRosParser.g:4650:2: ( () otherlv_1= Uint32_1 )
            {
            // InternalRosParser.g:4650:2: ( () otherlv_1= Uint32_1 )
            // InternalRosParser.g:4651:3: () otherlv_1= Uint32_1
            {
            // InternalRosParser.g:4651:3: ()
            // InternalRosParser.g:4652:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getUint32ArrayAccess().getUint32ArrayAction_0(),
                                current);


            }

            otherlv_1=(Token)match(input,Uint32_1,FOLLOW_2);

                        newLeafNode(otherlv_1, grammarAccess.getUint32ArrayAccess().getUint32Keyword_1());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleuint32Array"


    // $ANTLR start "entryRuleint64Array"
    // InternalRosParser.g:4666:1: entryRuleint64Array returns [EObject current=null] : iv_ruleint64Array= ruleint64Array EOF ;
    public final EObject entryRuleint64Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint64Array = null;


        try {
            // InternalRosParser.g:4666:51: (iv_ruleint64Array= ruleint64Array EOF )
            // InternalRosParser.g:4667:2: iv_ruleint64Array= ruleint64Array EOF
            {
             newCompositeNode(grammarAccess.getInt64ArrayRule());
            pushFollow(FOLLOW_1);
            iv_ruleint64Array=ruleint64Array();

            state._fsp--;

             current =iv_ruleint64Array;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleint64Array"


    // $ANTLR start "ruleint64Array"
    // InternalRosParser.g:4673:1: ruleint64Array returns [EObject current=null] : ( () otherlv_1= Int64_1 ) ;
    public final EObject ruleint64Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


            enterRule();

        try {
            // InternalRosParser.g:4679:2: ( ( () otherlv_1= Int64_1 ) )
            // InternalRosParser.g:4680:2: ( () otherlv_1= Int64_1 )
            {
            // InternalRosParser.g:4680:2: ( () otherlv_1= Int64_1 )
            // InternalRosParser.g:4681:3: () otherlv_1= Int64_1
            {
            // InternalRosParser.g:4681:3: ()
            // InternalRosParser.g:4682:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getInt64ArrayAccess().getInt64ArrayAction_0(),
                                current);


            }

            otherlv_1=(Token)match(input,Int64_1,FOLLOW_2);

                        newLeafNode(otherlv_1, grammarAccess.getInt64ArrayAccess().getInt64Keyword_1());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleint64Array"


    // $ANTLR start "entryRuleuint64Array"
    // InternalRosParser.g:4696:1: entryRuleuint64Array returns [EObject current=null] : iv_ruleuint64Array= ruleuint64Array EOF ;
    public final EObject entryRuleuint64Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint64Array = null;


        try {
            // InternalRosParser.g:4696:52: (iv_ruleuint64Array= ruleuint64Array EOF )
            // InternalRosParser.g:4697:2: iv_ruleuint64Array= ruleuint64Array EOF
            {
             newCompositeNode(grammarAccess.getUint64ArrayRule());
            pushFollow(FOLLOW_1);
            iv_ruleuint64Array=ruleuint64Array();

            state._fsp--;

             current =iv_ruleuint64Array;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleuint64Array"


    // $ANTLR start "ruleuint64Array"
    // InternalRosParser.g:4703:1: ruleuint64Array returns [EObject current=null] : ( () otherlv_1= Uint64_1 ) ;
    public final EObject ruleuint64Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


            enterRule();

        try {
            // InternalRosParser.g:4709:2: ( ( () otherlv_1= Uint64_1 ) )
            // InternalRosParser.g:4710:2: ( () otherlv_1= Uint64_1 )
            {
            // InternalRosParser.g:4710:2: ( () otherlv_1= Uint64_1 )
            // InternalRosParser.g:4711:3: () otherlv_1= Uint64_1
            {
            // InternalRosParser.g:4711:3: ()
            // InternalRosParser.g:4712:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getUint64ArrayAccess().getUint64ArrayAction_0(),
                                current);


            }

            otherlv_1=(Token)match(input,Uint64_1,FOLLOW_2);

                        newLeafNode(otherlv_1, grammarAccess.getUint64ArrayAccess().getUint64Keyword_1());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleuint64Array"


    // $ANTLR start "entryRulefloat32Array"
    // InternalRosParser.g:4726:1: entryRulefloat32Array returns [EObject current=null] : iv_rulefloat32Array= rulefloat32Array EOF ;
    public final EObject entryRulefloat32Array() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefloat32Array = null;


        try {
            // InternalRosParser.g:4726:53: (iv_rulefloat32Array= rulefloat32Array EOF )
            // InternalRosParser.g:4727:2: iv_rulefloat32Array= rulefloat32Array EOF
            {
             newCompositeNode(grammarAccess.getFloat32ArrayRule());
            pushFollow(FOLLOW_1);
            iv_rulefloat32Array=rulefloat32Array();

            state._fsp--;

             current =iv_rulefloat32Array;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulefloat32Array"


    // $ANTLR start "rulefloat32Array"
    // InternalRosParser.g:4733:1: rulefloat32Array returns [EObject current=null] : ( () otherlv_1= Float32_1 ) ;
    public final EObject rulefloat32Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


            enterRule();

        try {
            // InternalRosParser.g:4739:2: ( ( () otherlv_1= Float32_1 ) )
            // InternalRosParser.g:4740:2: ( () otherlv_1= Float32_1 )
            {
            // InternalRosParser.g:4740:2: ( () otherlv_1= Float32_1 )
            // InternalRosParser.g:4741:3: () otherlv_1= Float32_1
            {
            // InternalRosParser.g:4741:3: ()
            // InternalRosParser.g:4742:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getFloat32ArrayAccess().getFloat32ArrayAction_0(),
                                current);


            }

            otherlv_1=(Token)match(input,Float32_1,FOLLOW_2);

                        newLeafNode(otherlv_1, grammarAccess.getFloat32ArrayAccess().getFloat32Keyword_1());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulefloat32Array"


    // $ANTLR start "entryRulefloat64Array"
    // InternalRosParser.g:4756:1: entryRulefloat64Array returns [EObject current=null] : iv_rulefloat64Array= rulefloat64Array EOF ;
    public final EObject entryRulefloat64Array() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefloat64Array = null;


        try {
            // InternalRosParser.g:4756:53: (iv_rulefloat64Array= rulefloat64Array EOF )
            // InternalRosParser.g:4757:2: iv_rulefloat64Array= rulefloat64Array EOF
            {
             newCompositeNode(grammarAccess.getFloat64ArrayRule());
            pushFollow(FOLLOW_1);
            iv_rulefloat64Array=rulefloat64Array();

            state._fsp--;

             current =iv_rulefloat64Array;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulefloat64Array"


    // $ANTLR start "rulefloat64Array"
    // InternalRosParser.g:4763:1: rulefloat64Array returns [EObject current=null] : ( () otherlv_1= Float64_1 ) ;
    public final EObject rulefloat64Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


            enterRule();

        try {
            // InternalRosParser.g:4769:2: ( ( () otherlv_1= Float64_1 ) )
            // InternalRosParser.g:4770:2: ( () otherlv_1= Float64_1 )
            {
            // InternalRosParser.g:4770:2: ( () otherlv_1= Float64_1 )
            // InternalRosParser.g:4771:3: () otherlv_1= Float64_1
            {
            // InternalRosParser.g:4771:3: ()
            // InternalRosParser.g:4772:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getFloat64ArrayAccess().getFloat64ArrayAction_0(),
                                current);


            }

            otherlv_1=(Token)match(input,Float64_1,FOLLOW_2);

                        newLeafNode(otherlv_1, grammarAccess.getFloat64ArrayAccess().getFloat64Keyword_1());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulefloat64Array"


    // $ANTLR start "entryRulestring0Array"
    // InternalRosParser.g:4786:1: entryRulestring0Array returns [EObject current=null] : iv_rulestring0Array= rulestring0Array EOF ;
    public final EObject entryRulestring0Array() throws RecognitionException {
        EObject current = null;

        EObject iv_rulestring0Array = null;


        try {
            // InternalRosParser.g:4786:53: (iv_rulestring0Array= rulestring0Array EOF )
            // InternalRosParser.g:4787:2: iv_rulestring0Array= rulestring0Array EOF
            {
             newCompositeNode(grammarAccess.getString0ArrayRule());
            pushFollow(FOLLOW_1);
            iv_rulestring0Array=rulestring0Array();

            state._fsp--;

             current =iv_rulestring0Array;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulestring0Array"


    // $ANTLR start "rulestring0Array"
    // InternalRosParser.g:4793:1: rulestring0Array returns [EObject current=null] : ( () otherlv_1= String_2 ) ;
    public final EObject rulestring0Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


            enterRule();

        try {
            // InternalRosParser.g:4799:2: ( ( () otherlv_1= String_2 ) )
            // InternalRosParser.g:4800:2: ( () otherlv_1= String_2 )
            {
            // InternalRosParser.g:4800:2: ( () otherlv_1= String_2 )
            // InternalRosParser.g:4801:3: () otherlv_1= String_2
            {
            // InternalRosParser.g:4801:3: ()
            // InternalRosParser.g:4802:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getString0ArrayAccess().getStringArrayAction_0(),
                                current);


            }

            otherlv_1=(Token)match(input,String_2,FOLLOW_2);

                        newLeafNode(otherlv_1, grammarAccess.getString0ArrayAccess().getStringKeyword_1());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulestring0Array"


    // $ANTLR start "entryRulebyteArray"
    // InternalRosParser.g:4816:1: entryRulebyteArray returns [EObject current=null] : iv_rulebyteArray= rulebyteArray EOF ;
    public final EObject entryRulebyteArray() throws RecognitionException {
        EObject current = null;

        EObject iv_rulebyteArray = null;


        try {
            // InternalRosParser.g:4816:50: (iv_rulebyteArray= rulebyteArray EOF )
            // InternalRosParser.g:4817:2: iv_rulebyteArray= rulebyteArray EOF
            {
             newCompositeNode(grammarAccess.getByteArrayRule());
            pushFollow(FOLLOW_1);
            iv_rulebyteArray=rulebyteArray();

            state._fsp--;

             current =iv_rulebyteArray;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulebyteArray"


    // $ANTLR start "rulebyteArray"
    // InternalRosParser.g:4823:1: rulebyteArray returns [EObject current=null] : ( () otherlv_1= Byte_1 ) ;
    public final EObject rulebyteArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


            enterRule();

        try {
            // InternalRosParser.g:4829:2: ( ( () otherlv_1= Byte_1 ) )
            // InternalRosParser.g:4830:2: ( () otherlv_1= Byte_1 )
            {
            // InternalRosParser.g:4830:2: ( () otherlv_1= Byte_1 )
            // InternalRosParser.g:4831:3: () otherlv_1= Byte_1
            {
            // InternalRosParser.g:4831:3: ()
            // InternalRosParser.g:4832:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getByteArrayAccess().getByteArrayAction_0(),
                                current);


            }

            otherlv_1=(Token)match(input,Byte_1,FOLLOW_2);

                        newLeafNode(otherlv_1, grammarAccess.getByteArrayAccess().getByteKeyword_1());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulebyteArray"


    // $ANTLR start "entryRuleHeader"
    // InternalRosParser.g:4846:1: entryRuleHeader returns [EObject current=null] : iv_ruleHeader= ruleHeader EOF ;
    public final EObject entryRuleHeader() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHeader = null;


        try {
            // InternalRosParser.g:4846:47: (iv_ruleHeader= ruleHeader EOF )
            // InternalRosParser.g:4847:2: iv_ruleHeader= ruleHeader EOF
            {
             newCompositeNode(grammarAccess.getHeaderRule());
            pushFollow(FOLLOW_1);
            iv_ruleHeader=ruleHeader();

            state._fsp--;

             current =iv_ruleHeader;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHeader"


    // $ANTLR start "ruleHeader"
    // InternalRosParser.g:4853:1: ruleHeader returns [EObject current=null] : ( () otherlv_1= Header ) ;
    public final EObject ruleHeader() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


            enterRule();

        try {
            // InternalRosParser.g:4859:2: ( ( () otherlv_1= Header ) )
            // InternalRosParser.g:4860:2: ( () otherlv_1= Header )
            {
            // InternalRosParser.g:4860:2: ( () otherlv_1= Header )
            // InternalRosParser.g:4861:3: () otherlv_1= Header
            {
            // InternalRosParser.g:4861:3: ()
            // InternalRosParser.g:4862:4:
            {

                            current = forceCreateModelElement(
                                grammarAccess.getHeaderAccess().getHeaderAction_0(),
                                current);


            }

            otherlv_1=(Token)match(input,Header,FOLLOW_2);

                        newLeafNode(otherlv_1, grammarAccess.getHeaderAccess().getHeaderKeyword_1());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHeader"


    // $ANTLR start "entryRuleTopicSpecRef"
    // InternalRosParser.g:4876:1: entryRuleTopicSpecRef returns [EObject current=null] : iv_ruleTopicSpecRef= ruleTopicSpecRef EOF ;
    public final EObject entryRuleTopicSpecRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTopicSpecRef = null;


        try {
            // InternalRosParser.g:4876:53: (iv_ruleTopicSpecRef= ruleTopicSpecRef EOF )
            // InternalRosParser.g:4877:2: iv_ruleTopicSpecRef= ruleTopicSpecRef EOF
            {
             newCompositeNode(grammarAccess.getTopicSpecRefRule());
            pushFollow(FOLLOW_1);
            iv_ruleTopicSpecRef=ruleTopicSpecRef();

            state._fsp--;

             current =iv_ruleTopicSpecRef;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTopicSpecRef"


    // $ANTLR start "ruleTopicSpecRef"
    // InternalRosParser.g:4883:1: ruleTopicSpecRef returns [EObject current=null] : ( ( ruleEString ) ) ;
    public final EObject ruleTopicSpecRef() throws RecognitionException {
        EObject current = null;


            enterRule();

        try {
            // InternalRosParser.g:4889:2: ( ( ( ruleEString ) ) )
            // InternalRosParser.g:4890:2: ( ( ruleEString ) )
            {
            // InternalRosParser.g:4890:2: ( ( ruleEString ) )
            // InternalRosParser.g:4891:3: ( ruleEString )
            {
            // InternalRosParser.g:4891:3: ( ruleEString )
            // InternalRosParser.g:4892:4: ruleEString
            {

                            if (current==null) {
                                current = createModelElement(grammarAccess.getTopicSpecRefRule());
                            }


                            newCompositeNode(grammarAccess.getTopicSpecRefAccess().getTopicSpecTopicSpecCrossReference_0());

            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;


                            afterParserOrEnumRuleCall();


            }


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTopicSpecRef"


    // $ANTLR start "entryRuleArrayTopicSpecRef"
    // InternalRosParser.g:4909:1: entryRuleArrayTopicSpecRef returns [EObject current=null] : iv_ruleArrayTopicSpecRef= ruleArrayTopicSpecRef EOF ;
    public final EObject entryRuleArrayTopicSpecRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayTopicSpecRef = null;


        try {
            // InternalRosParser.g:4909:58: (iv_ruleArrayTopicSpecRef= ruleArrayTopicSpecRef EOF )
            // InternalRosParser.g:4910:2: iv_ruleArrayTopicSpecRef= ruleArrayTopicSpecRef EOF
            {
             newCompositeNode(grammarAccess.getArrayTopicSpecRefRule());
            pushFollow(FOLLOW_1);
            iv_ruleArrayTopicSpecRef=ruleArrayTopicSpecRef();

            state._fsp--;

             current =iv_ruleArrayTopicSpecRef;
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArrayTopicSpecRef"


    // $ANTLR start "ruleArrayTopicSpecRef"
    // InternalRosParser.g:4916:1: ruleArrayTopicSpecRef returns [EObject current=null] : ( ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket ) ;
    public final EObject ruleArrayTopicSpecRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


            enterRule();

        try {
            // InternalRosParser.g:4922:2: ( ( ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket ) )
            // InternalRosParser.g:4923:2: ( ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket )
            {
            // InternalRosParser.g:4923:2: ( ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket )
            // InternalRosParser.g:4924:3: ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket
            {
            // InternalRosParser.g:4924:3: ( ( ruleEString ) )
            // InternalRosParser.g:4925:4: ( ruleEString )
            {
            // InternalRosParser.g:4925:4: ( ruleEString )
            // InternalRosParser.g:4926:5: ruleEString
            {

                                if (current==null) {
                                    current = createModelElement(grammarAccess.getArrayTopicSpecRefRule());
                                }


                                newCompositeNode(grammarAccess.getArrayTopicSpecRefAccess().getTopicSpecTopicSpecCrossReference_0_0());

            pushFollow(FOLLOW_54);
            ruleEString();

            state._fsp--;


                                afterParserOrEnumRuleCall();


            }


            }

            otherlv_1=(Token)match(input,LeftSquareBracketRightSquareBracket,FOLLOW_2);

                        newLeafNode(otherlv_1, grammarAccess.getArrayTopicSpecRefAccess().getLeftSquareBracketRightSquareBracketKeyword_1());


            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArrayTopicSpecRef"


    // $ANTLR start "entryRuleKEYWORD"
    // InternalRosParser.g:4948:1: entryRuleKEYWORD returns [String current=null] : iv_ruleKEYWORD= ruleKEYWORD EOF ;
    public final String entryRuleKEYWORD() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKEYWORD = null;


        try {
            // InternalRosParser.g:4948:47: (iv_ruleKEYWORD= ruleKEYWORD EOF )
            // InternalRosParser.g:4949:2: iv_ruleKEYWORD= ruleKEYWORD EOF
            {
             newCompositeNode(grammarAccess.getKEYWORDRule());
            pushFollow(FOLLOW_1);
            iv_ruleKEYWORD=ruleKEYWORD();

            state._fsp--;

             current =iv_ruleKEYWORD.getText();
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKEYWORD"


    // $ANTLR start "ruleKEYWORD"
    // InternalRosParser.g:4955:1: ruleKEYWORD returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Goal | kw= Message | kw= Result | kw= Feedback | kw= Name | kw= Value | kw= Service | kw= Type | kw= Action | kw= Duration | kw= Time ) ;
    public final AntlrDatatypeRuleToken ruleKEYWORD() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


            enterRule();

        try {
            // InternalRosParser.g:4961:2: ( (kw= Goal | kw= Message | kw= Result | kw= Feedback | kw= Name | kw= Value | kw= Service | kw= Type | kw= Action | kw= Duration | kw= Time ) )
            // InternalRosParser.g:4962:2: (kw= Goal | kw= Message | kw= Result | kw= Feedback | kw= Name | kw= Value | kw= Service | kw= Type | kw= Action | kw= Duration | kw= Time )
            {
            // InternalRosParser.g:4962:2: (kw= Goal | kw= Message | kw= Result | kw= Feedback | kw= Name | kw= Value | kw= Service | kw= Type | kw= Action | kw= Duration | kw= Time )
            int alt56=11;
            switch ( input.LA(1) ) {
            case Goal:
                {
                alt56=1;
                }
                break;
            case Message:
                {
                alt56=2;
                }
                break;
            case Result:
                {
                alt56=3;
                }
                break;
            case Feedback:
                {
                alt56=4;
                }
                break;
            case Name:
                {
                alt56=5;
                }
                break;
            case Value:
                {
                alt56=6;
                }
                break;
            case Service:
                {
                alt56=7;
                }
                break;
            case Type:
                {
                alt56=8;
                }
                break;
            case Action:
                {
                alt56=9;
                }
                break;
            case Duration:
                {
                alt56=10;
                }
                break;
            case Time:
                {
                alt56=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }

            switch (alt56) {
                case 1 :
                    // InternalRosParser.g:4963:3: kw= Goal
                    {
                    kw=(Token)match(input,Goal,FOLLOW_2);

                                current.merge(kw);
                                newLeafNode(kw, grammarAccess.getKEYWORDAccess().getGoalKeyword_0());


                    }
                    break;
                case 2 :
                    // InternalRosParser.g:4969:3: kw= Message
                    {
                    kw=(Token)match(input,Message,FOLLOW_2);

                                current.merge(kw);
                                newLeafNode(kw, grammarAccess.getKEYWORDAccess().getMessageKeyword_1());


                    }
                    break;
                case 3 :
                    // InternalRosParser.g:4975:3: kw= Result
                    {
                    kw=(Token)match(input,Result,FOLLOW_2);

                                current.merge(kw);
                                newLeafNode(kw, grammarAccess.getKEYWORDAccess().getResultKeyword_2());


                    }
                    break;
                case 4 :
                    // InternalRosParser.g:4981:3: kw= Feedback
                    {
                    kw=(Token)match(input,Feedback,FOLLOW_2);

                                current.merge(kw);
                                newLeafNode(kw, grammarAccess.getKEYWORDAccess().getFeedbackKeyword_3());


                    }
                    break;
                case 5 :
                    // InternalRosParser.g:4987:3: kw= Name
                    {
                    kw=(Token)match(input,Name,FOLLOW_2);

                                current.merge(kw);
                                newLeafNode(kw, grammarAccess.getKEYWORDAccess().getNameKeyword_4());


                    }
                    break;
                case 6 :
                    // InternalRosParser.g:4993:3: kw= Value
                    {
                    kw=(Token)match(input,Value,FOLLOW_2);

                                current.merge(kw);
                                newLeafNode(kw, grammarAccess.getKEYWORDAccess().getValueKeyword_5());


                    }
                    break;
                case 7 :
                    // InternalRosParser.g:4999:3: kw= Service
                    {
                    kw=(Token)match(input,Service,FOLLOW_2);

                                current.merge(kw);
                                newLeafNode(kw, grammarAccess.getKEYWORDAccess().getServiceKeyword_6());


                    }
                    break;
                case 8 :
                    // InternalRosParser.g:5005:3: kw= Type
                    {
                    kw=(Token)match(input,Type,FOLLOW_2);

                                current.merge(kw);
                                newLeafNode(kw, grammarAccess.getKEYWORDAccess().getTypeKeyword_7());


                    }
                    break;
                case 9 :
                    // InternalRosParser.g:5011:3: kw= Action
                    {
                    kw=(Token)match(input,Action,FOLLOW_2);

                                current.merge(kw);
                                newLeafNode(kw, grammarAccess.getKEYWORDAccess().getActionKeyword_8());


                    }
                    break;
                case 10 :
                    // InternalRosParser.g:5017:3: kw= Duration
                    {
                    kw=(Token)match(input,Duration,FOLLOW_2);

                                current.merge(kw);
                                newLeafNode(kw, grammarAccess.getKEYWORDAccess().getDurationKeyword_9());


                    }
                    break;
                case 11 :
                    // InternalRosParser.g:5023:3: kw= Time
                    {
                    kw=(Token)match(input,Time,FOLLOW_2);

                                current.merge(kw);
                                newLeafNode(kw, grammarAccess.getKEYWORDAccess().getTimeKeyword_10());


                    }
                    break;

            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKEYWORD"


    // $ANTLR start "entryRuleEString"
    // InternalRosParser.g:5032:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalRosParser.g:5032:47: (iv_ruleEString= ruleEString EOF )
            // InternalRosParser.g:5033:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule());
            pushFollow(FOLLOW_1);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText();
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalRosParser.g:5039:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


            enterRule();

        try {
            // InternalRosParser.g:5045:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalRosParser.g:5046:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalRosParser.g:5046:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==RULE_STRING) ) {
                alt57=1;
            }
            else if ( (LA57_0==RULE_ID) ) {
                alt57=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }
            switch (alt57) {
                case 1 :
                    // InternalRosParser.g:5047:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2);

                                current.merge(this_STRING_0);


                                newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());


                    }
                    break;
                case 2 :
                    // InternalRosParser.g:5055:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2);

                                current.merge(this_ID_1);


                                newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1());


                    }
                    break;

            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleRosNames"
    // InternalRosParser.g:5066:1: entryRuleRosNames returns [String current=null] : iv_ruleRosNames= ruleRosNames EOF ;
    public final String entryRuleRosNames() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRosNames = null;


        try {
            // InternalRosParser.g:5066:48: (iv_ruleRosNames= ruleRosNames EOF )
            // InternalRosParser.g:5067:2: iv_ruleRosNames= ruleRosNames EOF
            {
             newCompositeNode(grammarAccess.getRosNamesRule());
            pushFollow(FOLLOW_1);
            iv_ruleRosNames=ruleRosNames();

            state._fsp--;

             current =iv_ruleRosNames.getText();
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRosNames"


    // $ANTLR start "ruleRosNames"
    // InternalRosParser.g:5073:1: ruleRosNames returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ROS_CONVENTION_A_0= RULE_ROS_CONVENTION_A | this_ID_1= RULE_ID | kw= Node ) ;
    public final AntlrDatatypeRuleToken ruleRosNames() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ROS_CONVENTION_A_0=null;
        Token this_ID_1=null;
        Token kw=null;


            enterRule();

        try {
            // InternalRosParser.g:5079:2: ( (this_ROS_CONVENTION_A_0= RULE_ROS_CONVENTION_A | this_ID_1= RULE_ID | kw= Node ) )
            // InternalRosParser.g:5080:2: (this_ROS_CONVENTION_A_0= RULE_ROS_CONVENTION_A | this_ID_1= RULE_ID | kw= Node )
            {
            // InternalRosParser.g:5080:2: (this_ROS_CONVENTION_A_0= RULE_ROS_CONVENTION_A | this_ID_1= RULE_ID | kw= Node )
            int alt58=3;
            switch ( input.LA(1) ) {
            case RULE_ROS_CONVENTION_A:
                {
                alt58=1;
                }
                break;
            case RULE_ID:
                {
                alt58=2;
                }
                break;
            case Node:
                {
                alt58=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }

            switch (alt58) {
                case 1 :
                    // InternalRosParser.g:5081:3: this_ROS_CONVENTION_A_0= RULE_ROS_CONVENTION_A
                    {
                    this_ROS_CONVENTION_A_0=(Token)match(input,RULE_ROS_CONVENTION_A,FOLLOW_2);

                                current.merge(this_ROS_CONVENTION_A_0);


                                newLeafNode(this_ROS_CONVENTION_A_0, grammarAccess.getRosNamesAccess().getROS_CONVENTION_ATerminalRuleCall_0());


                    }
                    break;
                case 2 :
                    // InternalRosParser.g:5089:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2);

                                current.merge(this_ID_1);


                                newLeafNode(this_ID_1, grammarAccess.getRosNamesAccess().getIDTerminalRuleCall_1());


                    }
                    break;
                case 3 :
                    // InternalRosParser.g:5097:3: kw= Node
                    {
                    kw=(Token)match(input,Node,FOLLOW_2);

                                current.merge(kw);
                                newLeafNode(kw, grammarAccess.getRosNamesAccess().getNodeKeyword_2());


                    }
                    break;

            }


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRosNames"


    // $ANTLR start "entryRulePreListElement"
    // InternalRosParser.g:5106:1: entryRulePreListElement returns [String current=null] : iv_rulePreListElement= rulePreListElement EOF ;
    public final String entryRulePreListElement() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePreListElement = null;



            HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_SL_COMMENT");

        try {
            // InternalRosParser.g:5108:2: (iv_rulePreListElement= rulePreListElement EOF )
            // InternalRosParser.g:5109:2: iv_rulePreListElement= rulePreListElement EOF
            {
             newCompositeNode(grammarAccess.getPreListElementRule());
            pushFollow(FOLLOW_1);
            iv_rulePreListElement=rulePreListElement();

            state._fsp--;

             current =iv_rulePreListElement.getText();
            match(input,EOF,FOLLOW_2);

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

                myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRulePreListElement"


    // $ANTLR start "rulePreListElement"
    // InternalRosParser.g:5118:1: rulePreListElement returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= HyphenMinus ;
    public final AntlrDatatypeRuleToken rulePreListElement() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


            enterRule();
            HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_SL_COMMENT");

        try {
            // InternalRosParser.g:5125:2: (kw= HyphenMinus )
            // InternalRosParser.g:5126:2: kw= HyphenMinus
            {
            kw=(Token)match(input,HyphenMinus,FOLLOW_2);

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getPreListElementAccess().getHyphenMinusKeyword());


            }


                leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

                myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "rulePreListElement"

    // Delegated rules


    protected DFA55 dfa55 = new DFA55(this);
    static final String dfa_1s = "\42\uffff";
    static final String dfa_2s = "\36\uffff\2\40\2\uffff";
    static final String dfa_3s = "\1\25\35\uffff\2\30\2\uffff";
    static final String dfa_4s = "\1\146\35\uffff\2\152\2\uffff";
    static final String dfa_5s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\2\uffff\1\36\1\37";
    static final String dfa_6s = "\42\uffff}>";
    static final String[] dfa_7s = {
            "\1\32\1\33\1\uffff\1\17\3\uffff\1\34\1\25\1\27\1\31\4\uffff\1\12\1\13\1\24\1\26\1\30\3\uffff\1\23\3\uffff\1\20\3\uffff\1\21\1\35\1\22\2\uffff\1\14\1\5\1\7\1\11\2\uffff\1\4\1\6\1\10\2\uffff\1\3\3\uffff\1\1\1\15\1\uffff\1\2\4\uffff\1\16\24\uffff\1\37\1\36",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\2\40\17\uffff\1\40\1\uffff\1\40\7\uffff\1\40\3\uffff\1\40\15\uffff\1\40\4\uffff\1\40\2\uffff\1\40\2\uffff\2\40\2\uffff\1\41\20\uffff\2\40\1\uffff\1\40\1\uffff\1\40",
            "\2\40\17\uffff\1\40\1\uffff\1\40\7\uffff\1\40\3\uffff\1\40\15\uffff\1\40\4\uffff\1\40\2\uffff\1\40\2\uffff\2\40\2\uffff\1\41\20\uffff\2\40\1\uffff\1\40\1\uffff\1\40",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA55 extends DFA {

        public DFA55(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 55;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "3723:2: (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_TopicSpecRef_29= ruleTopicSpecRef | this_ArrayTopicSpecRef_30= ruleArrayTopicSpecRef )";
        }
    }


    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000002L,0x0000102000004000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x010000000000A000L,0x0000040000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000000L,0x0000006000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0100000000002000L,0x0000040000000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000000L,0x0000040000400000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000002000L,0x0000040000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000020L,0x0000006000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000000L,0x0000000002200000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000071E00L,0x0000102000004000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000071E02L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000000L,0x0000046000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0003000000000000L,0x0000006000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000000L,0x0000060000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x00880A0003000000L,0x0000056000032420L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000800000L,0x0000020000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000040000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000100000L,0x0000020000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x00880A0003000002L,0x0000016000032420L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000000L,0x0000040000080000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x00000000000001C0L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080008L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0006E00300000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x2000000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x0000006079000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000800000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x9E7111F0F1600000L,0x0000006000010B13L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});

}
