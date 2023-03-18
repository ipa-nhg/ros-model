/**
 */
package system.tests;

import junit.textui.TestRunner;

import system.RosSubscriberReference;
import system.RossystemFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Ros Subscriber Reference</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RosSubscriberReferenceTest extends InterfaceReferenceTest {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main(String[] args) {
        TestRunner.run(RosSubscriberReferenceTest.class);
    }

    /**
     * Constructs a new Ros Subscriber Reference test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RosSubscriberReferenceTest(String name) {
        super(name);
    }

    /**
     * Returns the fixture for this Ros Subscriber Reference test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected RosSubscriberReference getFixture() {
        return (RosSubscriberReference)fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        setFixture(RossystemFactory.eINSTANCE.createRosSubscriberReference());
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

} //RosSubscriberReferenceTest
