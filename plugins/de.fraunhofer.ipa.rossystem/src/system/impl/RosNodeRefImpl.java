/**
 */
package system.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import system.RosNode;
import system.RosNodeRef;
import system.RossystemPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ros Node Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link system.impl.RosNodeRefImpl#getRosNodeRef <em>Ros Node Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RosNodeRefImpl extends AbstaractComponentImpl implements RosNodeRef {
    /**
     * The cached value of the '{@link #getRosNodeRef() <em>Ros Node Ref</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRosNodeRef()
     * @generated
     * @ordered
     */
    protected RosNode rosNodeRef;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RosNodeRefImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RossystemPackage.Literals.ROS_NODE_REF;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public RosNode getRosNodeRef() {
        if (rosNodeRef != null && rosNodeRef.eIsProxy()) {
            InternalEObject oldRosNodeRef = (InternalEObject)rosNodeRef;
            rosNodeRef = (RosNode)eResolveProxy(oldRosNodeRef);
            if (rosNodeRef != oldRosNodeRef) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, RossystemPackage.ROS_NODE_REF__ROS_NODE_REF, oldRosNodeRef, rosNodeRef));
            }
        }
        return rosNodeRef;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RosNode basicGetRosNodeRef() {
        return rosNodeRef;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setRosNodeRef(RosNode newRosNodeRef) {
        RosNode oldRosNodeRef = rosNodeRef;
        rosNodeRef = newRosNodeRef;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RossystemPackage.ROS_NODE_REF__ROS_NODE_REF, oldRosNodeRef, rosNodeRef));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case RossystemPackage.ROS_NODE_REF__ROS_NODE_REF:
                if (resolve) return getRosNodeRef();
                return basicGetRosNodeRef();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case RossystemPackage.ROS_NODE_REF__ROS_NODE_REF:
                setRosNodeRef((RosNode)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case RossystemPackage.ROS_NODE_REF__ROS_NODE_REF:
                setRosNodeRef((RosNode)null);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case RossystemPackage.ROS_NODE_REF__ROS_NODE_REF:
                return rosNodeRef != null;
        }
        return super.eIsSet(featureID);
    }

} //RosNodeRefImpl
