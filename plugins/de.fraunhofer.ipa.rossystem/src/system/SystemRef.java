/**
 */
package system;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link system.SystemRef#getSystemRef <em>System Ref</em>}</li>
 * </ul>
 *
 * @see system.RossystemPackage#getSystemRef()
 * @model
 * @generated
 */
public interface SystemRef extends AbstaractComponent {
    /**
     * Returns the value of the '<em><b>System Ref</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>System Ref</em>' reference.
     * @see #setSystemRef(system.System)
     * @see system.RossystemPackage#getSystemRef_SystemRef()
     * @model required="true"
     * @generated
     */
    system.System getSystemRef();

    /**
     * Sets the value of the '{@link system.SystemRef#getSystemRef <em>System Ref</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>System Ref</em>' reference.
     * @see #getSystemRef()
     * @generated
     */
    void setSystemRef(system.System value);

} // SystemRef
