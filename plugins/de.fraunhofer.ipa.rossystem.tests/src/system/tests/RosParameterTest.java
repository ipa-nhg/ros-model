/**
 */
package system.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import system.RosParameter;
import system.RossystemFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Ros Parameter</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RosParameterTest extends TestCase {

    /**
     * The fixture for this Ros Parameter test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RosParameter fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main(String[] args) {
        TestRunner.run(RosParameterTest.class);
    }

    /**
     * Constructs a new Ros Parameter test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RosParameterTest(String name) {
        super(name);
    }

    /**
     * Sets the fixture for this Ros Parameter test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void setFixture(RosParameter fixture) {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Ros Parameter test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RosParameter getFixture() {
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
        setFixture(RossystemFactory.eINSTANCE.createRosParameter());
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

} //RosParameterTest
