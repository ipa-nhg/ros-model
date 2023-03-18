/**
 */
package system.tests;

import junit.textui.TestRunner;

import system.RossystemFactory;
import system.SystemRef;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>System Ref</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SystemRefTest extends AbstaractComponentTest {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main(String[] args) {
        TestRunner.run(SystemRefTest.class);
    }

    /**
     * Constructs a new System Ref test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SystemRefTest(String name) {
        super(name);
    }

    /**
     * Returns the fixture for this System Ref test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected SystemRef getFixture() {
        return (SystemRef)fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        setFixture(RossystemFactory.eINSTANCE.createSystemRef());
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

} //SystemRefTest
