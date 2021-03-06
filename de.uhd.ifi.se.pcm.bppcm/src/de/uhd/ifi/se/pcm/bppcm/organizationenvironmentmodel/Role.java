/**
 */
package de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.Role#getActors <em>Actors</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.OrganizationenvironmentmodelPackage#getRole()
 * @model
 * @generated
 */
public interface Role extends Entity {
	/**
	 * Returns the value of the '<em><b>Actors</b></em>' reference list.
	 * The list contents are of type {@link de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.ActorResource}.
	 * It is bidirectional and its opposite is '{@link de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.ActorResource#getRoles <em>Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actors</em>' reference list.
	 * @see de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.OrganizationenvironmentmodelPackage#getRole_Actors()
	 * @see de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.ActorResource#getRoles
	 * @model opposite="roles"
	 * @generated
	 */
	EList<ActorResource> getActors();

} // Role
