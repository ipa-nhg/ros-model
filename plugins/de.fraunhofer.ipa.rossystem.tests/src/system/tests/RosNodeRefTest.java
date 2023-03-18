/**
 */
package system.tests;

import junit.textui.TestRunner;

import system.RosNodeRef;
import system.RossystemFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Ros Node Ref</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RosNodeRefTest extends AbstaractComponentTest {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main(String[] args) {
        TestRunner.run(RosNodeRefTest.class);
    }

    /**
     * Constructs a new Ros Node Ref test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RosNodeRefTest(String name) {
        super(name);
    }

    /**
     * Returns the fixture for this Ros Node Ref test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected RosNodeRef getFixture() {
        return (RosNodeRef)fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        setFixture(RossystemFactory.eINSTANCE.createRosNodeRef());
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

} //RosNodeRefTest
