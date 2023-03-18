/**
 */
package system;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ros Node Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link system.RosNodeRef#getRosNodeRef <em>Ros Node Ref</em>}</li>
 * </ul>
 *
 * @see system.RossystemPackage#getRosNodeRef()
 * @model
 * @generated
 */
public interface RosNodeRef extends AbstaractComponent {
    /**
     * Returns the value of the '<em><b>Ros Node Ref</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ros Node Ref</em>' reference.
     * @see #setRosNodeRef(RosNode)
     * @see system.RossystemPackage#getRosNodeRef_RosNodeRef()
     * @model required="true"
     * @generated
     */
    RosNode getRosNodeRef();

    /**
     * Sets the value of the '{@link system.RosNodeRef#getRosNodeRef <em>Ros Node Ref</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ros Node Ref</em>' reference.
     * @see #getRosNodeRef()
     * @generated
     */
    void setRosNodeRef(RosNode value);

} // RosNodeRef
