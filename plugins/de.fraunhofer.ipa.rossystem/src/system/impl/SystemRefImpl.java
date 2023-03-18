/**
 */
package system.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import system.RossystemPackage;
import system.SystemRef;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link system.impl.SystemRefImpl#getSystemRef <em>System Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SystemRefImpl extends AbstaractComponentImpl implements SystemRef {
    /**
     * The cached value of the '{@link #getSystemRef() <em>System Ref</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSystemRef()
     * @generated
     * @ordered
     */
    protected system.System systemRef;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SystemRefImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RossystemPackage.Literals.SYSTEM_REF;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public system.System getSystemRef() {
        if (systemRef != null && systemRef.eIsProxy()) {
            InternalEObject oldSystemRef = (InternalEObject)systemRef;
            systemRef = (system.System)eResolveProxy(oldSystemRef);
            if (systemRef != oldSystemRef) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, RossystemPackage.SYSTEM_REF__SYSTEM_REF, oldSystemRef, systemRef));
            }
        }
        return systemRef;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public system.System basicGetSystemRef() {
        return systemRef;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setSystemRef(system.System newSystemRef) {
        system.System oldSystemRef = systemRef;
        systemRef = newSystemRef;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RossystemPackage.SYSTEM_REF__SYSTEM_REF, oldSystemRef, systemRef));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case RossystemPackage.SYSTEM_REF__SYSTEM_REF:
                if (resolve) return getSystemRef();
                return basicGetSystemRef();
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
            case RossystemPackage.SYSTEM_REF__SYSTEM_REF:
                setSystemRef((system.System)newValue);
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
            case RossystemPackage.SYSTEM_REF__SYSTEM_REF:
                setSystemRef((system.System)null);
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
            case RossystemPackage.SYSTEM_REF__SYSTEM_REF:
                return systemRef != null;
        }
        return super.eIsSet(featureID);
    }

} //SystemRefImpl
