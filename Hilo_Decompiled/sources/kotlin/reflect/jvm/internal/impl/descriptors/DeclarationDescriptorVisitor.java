package kotlin.reflect.jvm.internal.impl.descriptors;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public interface DeclarationDescriptorVisitor<R, D> {
    R visitClassDescriptor(ClassDescriptor classDescriptor, D d10);

    R visitConstructorDescriptor(ConstructorDescriptor constructorDescriptor, D d10);

    R visitFunctionDescriptor(FunctionDescriptor functionDescriptor, D d10);

    R visitModuleDeclaration(ModuleDescriptor moduleDescriptor, D d10);

    R visitPackageFragmentDescriptor(PackageFragmentDescriptor packageFragmentDescriptor, D d10);

    R visitPackageViewDescriptor(PackageViewDescriptor packageViewDescriptor, D d10);

    R visitPropertyDescriptor(PropertyDescriptor propertyDescriptor, D d10);

    R visitPropertyGetterDescriptor(PropertyGetterDescriptor propertyGetterDescriptor, D d10);

    R visitPropertySetterDescriptor(PropertySetterDescriptor propertySetterDescriptor, D d10);

    R visitReceiverParameterDescriptor(ReceiverParameterDescriptor receiverParameterDescriptor, D d10);

    R visitTypeAliasDescriptor(TypeAliasDescriptor typeAliasDescriptor, D d10);

    R visitTypeParameterDescriptor(TypeParameterDescriptor typeParameterDescriptor, D d10);

    R visitValueParameterDescriptor(ValueParameterDescriptor valueParameterDescriptor, D d10);
}
