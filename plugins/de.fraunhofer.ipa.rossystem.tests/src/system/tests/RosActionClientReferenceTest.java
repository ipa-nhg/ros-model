/**
 */
package system.tests;

import junit.textui.TestRunner;

import system.RosActionClientReference;
import system.RossystemFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Ros Action Client Reference</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RosActionClientReferenceTest extends InterfaceReferenceTest {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main(String[] args) {
        TestRunner.run(RosActionClientReferenceTest.class);
    }

    /**
     * Constructs a new Ros Action Client Reference test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RosActionClientReferenceTest(String name) {
        super(name);
    }

    /**
     * Returns the fixture for this Ros Action Client Reference test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected RosActionClientReference getFixture() {
        return (RosActionClientReference)fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        setFixture(RossystemFactory.eINSTANCE.createRosActionClientReference());
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

} //RosActionClientReferenceTest
