/**
 */
package system.tests;

import junit.textui.TestRunner;

import system.RosActionServerReference;
import system.RossystemFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Ros Action Server Reference</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RosActionServerReferenceTest extends InterfaceReferenceTest {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main(String[] args) {
        TestRunner.run(RosActionServerReferenceTest.class);
    }

    /**
     * Constructs a new Ros Action Server Reference test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RosActionServerReferenceTest(String name) {
        super(name);
    }

    /**
     * Returns the fixture for this Ros Action Server Reference test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected RosActionServerReference getFixture() {
        return (RosActionServerReference)fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        setFixture(RossystemFactory.eINSTANCE.createRosActionServerReference());
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

} //RosActionServerReferenceTest
