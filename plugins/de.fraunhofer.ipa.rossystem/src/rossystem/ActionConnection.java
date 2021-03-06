/**
 */
package rossystem;

import componentInterface.RosActionClient;
import componentInterface.RosActionServer;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link rossystem.ActionConnection#getFrom <em>From</em>}</li>
 *   <li>{@link rossystem.ActionConnection#getTo <em>To</em>}</li>
 *   <li>{@link rossystem.ActionConnection#getActionName <em>Action Name</em>}</li>
 * </ul>
 *
 * @see rossystem.RossystemPackage#getActionConnection()
 * @model
 * @generated
 */
public interface ActionConnection extends EObject {
	/**
	 * Returns the value of the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' reference.
	 * @see #setFrom(RosActionServer)
	 * @see rossystem.RossystemPackage#getActionConnection_From()
	 * @model required="true"
	 * @generated
	 */
	RosActionServer getFrom();

	/**
	 * Sets the value of the '{@link rossystem.ActionConnection#getFrom <em>From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' reference.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(RosActionServer value);

	/**
	 * Returns the value of the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To</em>' reference.
	 * @see #setTo(RosActionClient)
	 * @see rossystem.RossystemPackage#getActionConnection_To()
	 * @model required="true"
	 * @generated
	 */
	RosActionClient getTo();

	/**
	 * Sets the value of the '{@link rossystem.ActionConnection#getTo <em>To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To</em>' reference.
	 * @see #getTo()
	 * @generated
	 */
	void setTo(RosActionClient value);

	/**
	 * Returns the value of the '<em><b>Action Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Name</em>' attribute.
	 * @see #setActionName(String)
	 * @see rossystem.RossystemPackage#getActionConnection_ActionName()
	 * @model required="true"
	 * @generated
	 */
	String getActionName();

	/**
	 * Sets the value of the '{@link rossystem.ActionConnection#getActionName <em>Action Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action Name</em>' attribute.
	 * @see #getActionName()
	 * @generated
	 */
	void setActionName(String value);

} // ActionConnection
