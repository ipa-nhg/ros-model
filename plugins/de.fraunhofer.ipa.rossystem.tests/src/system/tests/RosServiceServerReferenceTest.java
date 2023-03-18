/**
 */
package system.tests;

import junit.textui.TestRunner;

import system.RosServiceServerReference;
import system.RossystemFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Ros Service Server Reference</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RosServiceServerReferenceTest extends InterfaceReferenceTest {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main(String[] args) {
        TestRunner.run(RosServiceServerReferenceTest.class);
    }

    /**
     * Constructs a new Ros Service Server Reference test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RosServiceServerReferenceTest(String name) {
        super(name);
    }

    /**
     * Returns the fixture for this Ros Service Server Reference test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected RosServiceServerReference getFixture() {
        return (RosServiceServerReference)fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        setFixture(RossystemFactory.eINSTANCE.createRosServiceServerReference());
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

} //RosServiceServerReferenceTest
