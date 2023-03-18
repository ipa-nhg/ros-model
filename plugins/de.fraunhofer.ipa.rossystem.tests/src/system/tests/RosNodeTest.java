/**
 */
package system.tests;

import junit.textui.TestRunner;

import system.RosNode;
import system.RossystemFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Ros Node</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RosNodeTest extends ComponentTest {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main(String[] args) {
        TestRunner.run(RosNodeTest.class);
    }

    /**
     * Constructs a new Ros Node test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RosNodeTest(String name) {
        super(name);
    }

    /**
     * Returns the fixture for this Ros Node test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected RosNode getFixture() {
        return (RosNode)fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        setFixture(RossystemFactory.eINSTANCE.createRosNode());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#tearDown()
     * @generated
     */
    @Override
    protected void tearDown() throws Exception {
        setFixture(null);
    }

} //RosNodeTest
