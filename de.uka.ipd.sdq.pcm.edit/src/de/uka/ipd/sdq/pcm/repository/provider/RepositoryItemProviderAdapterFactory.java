/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.provider;

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

import de.uka.ipd.sdq.pcm.repository.util.RepositoryAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class RepositoryItemProviderAdapterFactory extends RepositoryAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
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
	public RepositoryItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.repository.Repository} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RepositoryItemProvider repositoryItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.Repository}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRepositoryAdapter() {
		if (repositoryItemProvider == null) {
			repositoryItemProvider = new RepositoryItemProvider(this);
		}

		return repositoryItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.repository.RequiredCharacterisation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequiredCharacterisationItemProvider requiredCharacterisationItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.RequiredCharacterisation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRequiredCharacterisationAdapter() {
		if (requiredCharacterisationItemProvider == null) {
			requiredCharacterisationItemProvider = new RequiredCharacterisationItemProvider(this);
		}

		return requiredCharacterisationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.repository.Parameter} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterItemProvider parameterItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.Parameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createParameterAdapter() {
		if (parameterItemProvider == null) {
			parameterItemProvider = new ParameterItemProvider(this);
		}

		return parameterItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.repository.OperationInterface} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationInterfaceItemProvider operationInterfaceItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.OperationInterface}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOperationInterfaceAdapter() {
		if (operationInterfaceItemProvider == null) {
			operationInterfaceItemProvider = new OperationInterfaceItemProvider(this);
		}

		return operationInterfaceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.repository.OperationSignature} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationSignatureItemProvider operationSignatureItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.OperationSignature}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOperationSignatureAdapter() {
		if (operationSignatureItemProvider == null) {
			operationSignatureItemProvider = new OperationSignatureItemProvider(this);
		}

		return operationSignatureItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.repository.ExceptionType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExceptionTypeItemProvider exceptionTypeItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.ExceptionType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createExceptionTypeAdapter() {
		if (exceptionTypeItemProvider == null) {
			exceptionTypeItemProvider = new ExceptionTypeItemProvider(this);
		}

		return exceptionTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.repository.OperationRequiredRole} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationRequiredRoleItemProvider operationRequiredRoleItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.OperationRequiredRole}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOperationRequiredRoleAdapter() {
		if (operationRequiredRoleItemProvider == null) {
			operationRequiredRoleItemProvider = new OperationRequiredRoleItemProvider(this);
		}

		return operationRequiredRoleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.repository.SinkRole} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SinkRoleItemProvider sinkRoleItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.SinkRole}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSinkRoleAdapter() {
		if (sinkRoleItemProvider == null) {
			sinkRoleItemProvider = new SinkRoleItemProvider(this);
		}

		return sinkRoleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.repository.EventGroup} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventGroupItemProvider eventGroupItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.EventGroup}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEventGroupAdapter() {
		if (eventGroupItemProvider == null) {
			eventGroupItemProvider = new EventGroupItemProvider(this);
		}

		return eventGroupItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.repository.EventType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventTypeItemProvider eventTypeItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.EventType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEventTypeAdapter() {
		if (eventTypeItemProvider == null) {
			eventTypeItemProvider = new EventTypeItemProvider(this);
		}

		return eventTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.repository.SourceRole} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SourceRoleItemProvider sourceRoleItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.SourceRole}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSourceRoleAdapter() {
		if (sourceRoleItemProvider == null) {
			sourceRoleItemProvider = new SourceRoleItemProvider(this);
		}

		return sourceRoleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.repository.InfrastructureProvidedRole} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InfrastructureProvidedRoleItemProvider infrastructureProvidedRoleItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.InfrastructureProvidedRole}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createInfrastructureProvidedRoleAdapter() {
		if (infrastructureProvidedRoleItemProvider == null) {
			infrastructureProvidedRoleItemProvider = new InfrastructureProvidedRoleItemProvider(this);
		}

		return infrastructureProvidedRoleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.repository.BasicComponent} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BasicComponentItemProvider basicComponentItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.BasicComponent}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBasicComponentAdapter() {
		if (basicComponentItemProvider == null) {
			basicComponentItemProvider = new BasicComponentItemProvider(this);
		}

		return basicComponentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.repository.CompleteComponentType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompleteComponentTypeItemProvider completeComponentTypeItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.CompleteComponentType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCompleteComponentTypeAdapter() {
		if (completeComponentTypeItemProvider == null) {
			completeComponentTypeItemProvider = new CompleteComponentTypeItemProvider(this);
		}

		return completeComponentTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.repository.ProvidesComponentType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProvidesComponentTypeItemProvider providesComponentTypeItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.ProvidesComponentType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createProvidesComponentTypeAdapter() {
		if (providesComponentTypeItemProvider == null) {
			providesComponentTypeItemProvider = new ProvidesComponentTypeItemProvider(this);
		}

		return providesComponentTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.repository.OperationProvidedRole} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationProvidedRoleItemProvider operationProvidedRoleItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.OperationProvidedRole}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOperationProvidedRoleAdapter() {
		if (operationProvidedRoleItemProvider == null) {
			operationProvidedRoleItemProvider = new OperationProvidedRoleItemProvider(this);
		}

		return operationProvidedRoleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.repository.PassiveResource} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PassiveResourceItemProvider passiveResourceItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.PassiveResource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPassiveResourceAdapter() {
		if (passiveResourceItemProvider == null) {
			passiveResourceItemProvider = new PassiveResourceItemProvider(this);
		}

		return passiveResourceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.repository.CompositeDataType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeDataTypeItemProvider compositeDataTypeItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.CompositeDataType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCompositeDataTypeAdapter() {
		if (compositeDataTypeItemProvider == null) {
			compositeDataTypeItemProvider = new CompositeDataTypeItemProvider(this);
		}

		return compositeDataTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.repository.InnerDeclaration} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InnerDeclarationItemProvider innerDeclarationItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.InnerDeclaration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createInnerDeclarationAdapter() {
		if (innerDeclarationItemProvider == null) {
			innerDeclarationItemProvider = new InnerDeclarationItemProvider(this);
		}

		return innerDeclarationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.repository.InfrastructureSignature} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InfrastructureSignatureItemProvider infrastructureSignatureItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.InfrastructureSignature}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createInfrastructureSignatureAdapter() {
		if (infrastructureSignatureItemProvider == null) {
			infrastructureSignatureItemProvider = new InfrastructureSignatureItemProvider(this);
		}

		return infrastructureSignatureItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InfrastructureRequiredRoleItemProvider infrastructureRequiredRoleItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createInfrastructureRequiredRoleAdapter() {
		if (infrastructureRequiredRoleItemProvider == null) {
			infrastructureRequiredRoleItemProvider = new InfrastructureRequiredRoleItemProvider(this);
		}

		return infrastructureRequiredRoleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.repository.InfrastructureInterface} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InfrastructureInterfaceItemProvider infrastructureInterfaceItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.InfrastructureInterface}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createInfrastructureInterfaceAdapter() {
		if (infrastructureInterfaceItemProvider == null) {
			infrastructureInterfaceItemProvider = new InfrastructureInterfaceItemProvider(this);
		}

		return infrastructureInterfaceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.repository.CompositeComponent} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeComponentItemProvider compositeComponentItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.CompositeComponent}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCompositeComponentAdapter() {
		if (compositeComponentItemProvider == null) {
			compositeComponentItemProvider = new CompositeComponentItemProvider(this);
		}

		return compositeComponentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.repository.PrimitiveDataType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrimitiveDataTypeItemProvider primitiveDataTypeItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.PrimitiveDataType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPrimitiveDataTypeAdapter() {
		if (primitiveDataTypeItemProvider == null) {
			primitiveDataTypeItemProvider = new PrimitiveDataTypeItemProvider(this);
		}

		return primitiveDataTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.repository.CollectionDataType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectionDataTypeItemProvider collectionDataTypeItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.CollectionDataType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCollectionDataTypeAdapter() {
		if (collectionDataTypeItemProvider == null) {
			collectionDataTypeItemProvider = new CollectionDataTypeItemProvider(this);
		}

		return collectionDataTypeItemProvider;
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
		if (passiveResourceItemProvider != null) passiveResourceItemProvider.dispose();
		if (basicComponentItemProvider != null) basicComponentItemProvider.dispose();
		if (parameterItemProvider != null) parameterItemProvider.dispose();
		if (repositoryItemProvider != null) repositoryItemProvider.dispose();
		if (requiredCharacterisationItemProvider != null) requiredCharacterisationItemProvider.dispose();
		if (eventGroupItemProvider != null) eventGroupItemProvider.dispose();
		if (eventTypeItemProvider != null) eventTypeItemProvider.dispose();
		if (exceptionTypeItemProvider != null) exceptionTypeItemProvider.dispose();
		if (infrastructureSignatureItemProvider != null) infrastructureSignatureItemProvider.dispose();
		if (infrastructureInterfaceItemProvider != null) infrastructureInterfaceItemProvider.dispose();
		if (infrastructureRequiredRoleItemProvider != null) infrastructureRequiredRoleItemProvider.dispose();
		if (operationSignatureItemProvider != null) operationSignatureItemProvider.dispose();
		if (operationInterfaceItemProvider != null) operationInterfaceItemProvider.dispose();
		if (operationRequiredRoleItemProvider != null) operationRequiredRoleItemProvider.dispose();
		if (sourceRoleItemProvider != null) sourceRoleItemProvider.dispose();
		if (sinkRoleItemProvider != null) sinkRoleItemProvider.dispose();
		if (operationProvidedRoleItemProvider != null) operationProvidedRoleItemProvider.dispose();
		if (infrastructureProvidedRoleItemProvider != null) infrastructureProvidedRoleItemProvider.dispose();
		if (completeComponentTypeItemProvider != null) completeComponentTypeItemProvider.dispose();
		if (providesComponentTypeItemProvider != null) providesComponentTypeItemProvider.dispose();
		if (compositeComponentItemProvider != null) compositeComponentItemProvider.dispose();
		if (primitiveDataTypeItemProvider != null) primitiveDataTypeItemProvider.dispose();
		if (collectionDataTypeItemProvider != null) collectionDataTypeItemProvider.dispose();
		if (compositeDataTypeItemProvider != null) compositeDataTypeItemProvider.dispose();
		if (innerDeclarationItemProvider != null) innerDeclarationItemProvider.dispose();
	}

}
