/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.reliability.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import de.uka.ipd.sdq.pcm.reliability.util.ReliabilityAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ReliabilityItemProviderAdapterFactory extends ReliabilityAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReliabilityItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.reliability.HardwareInducedFailureType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HardwareInducedFailureTypeItemProvider hardwareInducedFailureTypeItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.reliability.HardwareInducedFailureType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createHardwareInducedFailureTypeAdapter() {
		if (hardwareInducedFailureTypeItemProvider == null) {
			hardwareInducedFailureTypeItemProvider = new HardwareInducedFailureTypeItemProvider(this);
		}

		return hardwareInducedFailureTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.reliability.ExternalFailureOccurrenceDescription} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExternalFailureOccurrenceDescriptionItemProvider externalFailureOccurrenceDescriptionItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.reliability.ExternalFailureOccurrenceDescription}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createExternalFailureOccurrenceDescriptionAdapter() {
		if (externalFailureOccurrenceDescriptionItemProvider == null) {
			externalFailureOccurrenceDescriptionItemProvider = new ExternalFailureOccurrenceDescriptionItemProvider(this);
		}

		return externalFailureOccurrenceDescriptionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.reliability.ResourceTimeoutFailureType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceTimeoutFailureTypeItemProvider resourceTimeoutFailureTypeItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.reliability.ResourceTimeoutFailureType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createResourceTimeoutFailureTypeAdapter() {
		if (resourceTimeoutFailureTypeItemProvider == null) {
			resourceTimeoutFailureTypeItemProvider = new ResourceTimeoutFailureTypeItemProvider(this);
		}

		return resourceTimeoutFailureTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.reliability.NetworkInducedFailureType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NetworkInducedFailureTypeItemProvider networkInducedFailureTypeItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.reliability.NetworkInducedFailureType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createNetworkInducedFailureTypeAdapter() {
		if (networkInducedFailureTypeItemProvider == null) {
			networkInducedFailureTypeItemProvider = new NetworkInducedFailureTypeItemProvider(this);
		}

		return networkInducedFailureTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.reliability.InternalFailureOccurrenceDescription} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InternalFailureOccurrenceDescriptionItemProvider internalFailureOccurrenceDescriptionItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.reliability.InternalFailureOccurrenceDescription}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createInternalFailureOccurrenceDescriptionAdapter() {
		if (internalFailureOccurrenceDescriptionItemProvider == null) {
			internalFailureOccurrenceDescriptionItemProvider = new InternalFailureOccurrenceDescriptionItemProvider(this);
		}

		return internalFailureOccurrenceDescriptionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.reliability.SoftwareInducedFailureType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SoftwareInducedFailureTypeItemProvider softwareInducedFailureTypeItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.reliability.SoftwareInducedFailureType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSoftwareInducedFailureTypeAdapter() {
		if (softwareInducedFailureTypeItemProvider == null) {
			softwareInducedFailureTypeItemProvider = new SoftwareInducedFailureTypeItemProvider(this);
		}

		return softwareInducedFailureTypeItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (hardwareInducedFailureTypeItemProvider != null) hardwareInducedFailureTypeItemProvider.dispose();
		if (softwareInducedFailureTypeItemProvider != null) softwareInducedFailureTypeItemProvider.dispose();
		if (internalFailureOccurrenceDescriptionItemProvider != null) internalFailureOccurrenceDescriptionItemProvider.dispose();
		if (networkInducedFailureTypeItemProvider != null) networkInducedFailureTypeItemProvider.dispose();
		if (externalFailureOccurrenceDescriptionItemProvider != null) externalFailureOccurrenceDescriptionItemProvider.dispose();
		if (resourceTimeoutFailureTypeItemProvider != null) resourceTimeoutFailureTypeItemProvider.dispose();
	}

}
