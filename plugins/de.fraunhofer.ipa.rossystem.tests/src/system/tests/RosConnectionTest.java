/**
 */
package system.tests;

import junit.textui.TestRunner;

import system.RosConnection;
import system.RossystemFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Ros Connection</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RosConnectionTest extends ConnectionTest {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main(String[] args) {
        TestRunner.run(RosConnectionTest.class);
    }

    /**
     * Constructs a new Ros Connection test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RosConnectionTest(String name) {
        super(name);
    }

    /**
     * Returns the fixture for this Ros Connection test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected RosConnection getFixture() {
        return (RosConnection)fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        setFixture(RossystemFactory.eINSTANCE.createRosConnection());
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

} //RosConnectionTest
