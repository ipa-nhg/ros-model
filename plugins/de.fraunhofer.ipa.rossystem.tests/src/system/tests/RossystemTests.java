/**
 */
package system.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>system</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class RossystemTests extends TestSuite {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main(String[] args) {
        TestRunner.run(suite());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static Test suite() {
        TestSuite suite = new RossystemTests("system Tests");
        suite.addTestSuite(SystemTest.class);
        suite.addTestSuite(RosSystemTest.class);
        return suite;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RossystemTests(String name) {
        super(name);
    }

} //RossystemTests
