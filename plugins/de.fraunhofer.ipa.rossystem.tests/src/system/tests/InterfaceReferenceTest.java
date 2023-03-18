/**
 */
package system.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import system.InterfaceReference;
import system.RossystemFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Interface Reference</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class InterfaceReferenceTest extends TestCase {

    /**
     * The fixture for this Interface Reference test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected InterfaceReference fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main(String[] args) {
        TestRunner.run(InterfaceReferenceTest.class);
    }

    /**
     * Constructs a new Interface Reference test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InterfaceReferenceTest(String name) {
        super(name);
    }

    /**
     * Sets the fixture for this Interface Reference test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void setFixture(InterfaceReference fixture) {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Interface Reference test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected InterfaceReference getFixture() {
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
        setFixture(RossystemFactory.eINSTANCE.createInterfaceReference());
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

} //InterfaceReferenceTest
