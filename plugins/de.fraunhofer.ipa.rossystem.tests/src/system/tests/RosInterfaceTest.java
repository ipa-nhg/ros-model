/**
 */
package system.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import system.RosInterface;
import system.RossystemFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Ros Interface</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RosInterfaceTest extends TestCase {

    /**
     * The fixture for this Ros Interface test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RosInterface fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main(String[] args) {
        TestRunner.run(RosInterfaceTest.class);
    }

    /**
     * Constructs a new Ros Interface test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RosInterfaceTest(String name) {
        super(name);
    }

    /**
     * Sets the fixture for this Ros Interface test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void setFixture(RosInterface fixture) {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Ros Interface test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RosInterface getFixture() {
        return fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        setFixture(RossystemFactory.eINSTANCE.createRosInterface());
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

} //RosInterfaceTest
