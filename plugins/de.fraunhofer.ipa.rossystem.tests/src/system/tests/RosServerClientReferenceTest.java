/**
 */
package system.tests;

import junit.textui.TestRunner;

import system.RosServerClientReference;
import system.RossystemFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Ros Server Client Reference</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RosServerClientReferenceTest extends InterfaceReferenceTest {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main(String[] args) {
        TestRunner.run(RosServerClientReferenceTest.class);
    }

    /**
     * Constructs a new Ros Server Client Reference test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RosServerClientReferenceTest(String name) {
        super(name);
    }

    /**
     * Returns the fixture for this Ros Server Client Reference test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected RosServerClientReference getFixture() {
        return (RosServerClientReference)fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        setFixture(RossystemFactory.eINSTANCE.createRosServerClientReference());
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

} //RosServerClientReferenceTest
