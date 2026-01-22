package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.DeprecationCausedByFunctionNInfo;
import kotlin.reflect.jvm.internal.impl.load.java.UtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JavaDescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureBuildingUtilsKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.deprecation.DescriptorBasedDeprecationInfoKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nsignatureEnhancement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 signatureEnhancement.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/SignatureEnhancement\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,296:1\n1557#2:297\n1628#2,3:298\n1557#2:301\n1628#2,3:302\n1557#2:306\n1628#2,3:307\n1755#2,3:310\n1755#2,3:313\n1567#2:316\n1598#2,4:317\n1557#2:321\n1628#2,3:322\n1557#2:325\n1628#2,3:326\n1#3:305\n*S KotlinDebug\n*F\n+ 1 signatureEnhancement.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/SignatureEnhancement\n*L\n55#1:297\n55#1:298,3\n66#1:301\n66#1:302,3\n123#1:306\n123#1:307,3\n144#1:310,3\n150#1:313,3\n156#1:316\n156#1:317,4\n170#1:321\n170#1:322,3\n220#1:325\n220#1:326,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class SignatureEnhancement {

    @NotNull
    private final JavaTypeEnhancement typeEnhancement;

    public SignatureEnhancement(@NotNull JavaTypeEnhancement typeEnhancement) {
        Intrinsics.checkNotNullParameter(typeEnhancement, "typeEnhancement");
        this.typeEnhancement = typeEnhancement;
    }

    private final boolean containsFunctionN(KotlinType kotlinType) {
        return TypeUtils.contains(kotlinType, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$$Lambda$4
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Boolean containsFunctionN$lambda$16;
                containsFunctionN$lambda$16 = SignatureEnhancement.containsFunctionN$lambda$16((UnwrappedType) obj);
                return containsFunctionN$lambda$16;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean containsFunctionN$lambda$16(UnwrappedType unwrappedType) {
        boolean z10;
        ClassifierDescriptor classifierDescriptor = unwrappedType.getConstructor().mo١٩٢٣getDeclarationDescriptor();
        if (classifierDescriptor == null) {
            return Boolean.FALSE;
        }
        Name name = classifierDescriptor.getName();
        JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
        if (Intrinsics.areEqual(name, javaToKotlinClassMap.getFUNCTION_N_FQ_NAME().shortName()) && Intrinsics.areEqual(DescriptorUtilsKt.fqNameOrNull(classifierDescriptor), javaToKotlinClassMap.getFUNCTION_N_FQ_NAME())) {
            z10 = true;
        } else {
            z10 = false;
        }
        return Boolean.valueOf(z10);
    }

    private final KotlinType enhance(CallableMemberDescriptor callableMemberDescriptor, Annotated annotated, boolean z10, LazyJavaResolverContext lazyJavaResolverContext, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, TypeEnhancementInfo typeEnhancementInfo, boolean z11, Function1<? super CallableMemberDescriptor, ? extends KotlinType> function1) {
        SignatureParts signatureParts = new SignatureParts(annotated, z10, lazyJavaResolverContext, annotationQualifierApplicabilityType, false, 16, null);
        KotlinType invoke = function1.invoke(callableMemberDescriptor);
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "getOverriddenDescriptors(...)");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(overriddenDescriptors, 10));
        for (CallableMemberDescriptor callableMemberDescriptor2 : overriddenDescriptors) {
            Intrinsics.checkNotNull(callableMemberDescriptor2);
            arrayList.add(function1.invoke(callableMemberDescriptor2));
        }
        return enhance(signatureParts, invoke, arrayList, typeEnhancementInfo, z11);
    }

    static /* synthetic */ KotlinType enhance$default(SignatureEnhancement signatureEnhancement, CallableMemberDescriptor callableMemberDescriptor, Annotated annotated, boolean z10, LazyJavaResolverContext lazyJavaResolverContext, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, TypeEnhancementInfo typeEnhancementInfo, boolean z11, Function1 function1, int i10, Object obj) {
        return signatureEnhancement.enhance(callableMemberDescriptor, annotated, z10, lazyJavaResolverContext, annotationQualifierApplicabilityType, typeEnhancementInfo, (i10 & 32) != 0 ? false : z11, function1);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x021a A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final <D extends CallableMemberDescriptor> D enhanceSignature(D d10, LazyJavaResolverContext lazyJavaResolverContext) {
        D d11;
        KotlinType kotlinType;
        JavaMethodDescriptor javaMethodDescriptor;
        PredefinedFunctionEnhancementInfo predefinedFunctionEnhancementInfo;
        boolean z10;
        PropertyDescriptor propertyDescriptor;
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType;
        TypeEnhancementInfo typeEnhancementInfo;
        KotlinType enhance$default;
        KotlinType returnType;
        boolean z11;
        Pair<CallableDescriptor.UserDataKey<?>, ?> pair;
        boolean z12;
        boolean z13;
        boolean z14;
        KotlinType type;
        TypeEnhancementInfo typeEnhancementInfo2;
        List<TypeEnhancementInfo> parametersInfo;
        String errorsSinceLanguageVersion;
        FunctionDescriptor functionDescriptor;
        ValueParameterDescriptor valueParameterDescriptor;
        PropertyDescriptorImpl propertyDescriptorImpl;
        PropertyGetterDescriptorImpl getter;
        if (!(d10 instanceof JavaCallableMemberDescriptor)) {
            return d10;
        }
        boolean z15 = true;
        if (d10.getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE && d10.getOriginal().getOverriddenDescriptors().size() == 1) {
            return d10;
        }
        LazyJavaResolverContext copyWithNewDefaultTypeQualifiers = ContextKt.copyWithNewDefaultTypeQualifiers(lazyJavaResolverContext, getDefaultAnnotations(d10, lazyJavaResolverContext));
        if ((d10 instanceof JavaPropertyDescriptor) && (getter = (propertyDescriptorImpl = (PropertyDescriptorImpl) d10).getGetter()) != null && !getter.isDefault()) {
            PropertyGetterDescriptorImpl getter2 = propertyDescriptorImpl.getGetter();
            Intrinsics.checkNotNull(getter2);
            d11 = getter2;
        } else {
            d11 = d10;
        }
        TypeEnhancementInfo typeEnhancementInfo3 = null;
        if (d10.getExtensionReceiverParameter() != null) {
            if (d11 instanceof FunctionDescriptor) {
                functionDescriptor = (FunctionDescriptor) d11;
            } else {
                functionDescriptor = null;
            }
            if (functionDescriptor != null) {
                valueParameterDescriptor = (ValueParameterDescriptor) functionDescriptor.getUserData(JavaMethodDescriptor.ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER);
            } else {
                valueParameterDescriptor = null;
            }
            kotlinType = enhanceValueParameter(d10, valueParameterDescriptor, copyWithNewDefaultTypeQualifiers, null, false, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$$Lambda$0
                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    KotlinType enhanceSignature$lambda$2;
                    enhanceSignature$lambda$2 = SignatureEnhancement.enhanceSignature$lambda$2((CallableMemberDescriptor) obj);
                    return enhanceSignature$lambda$2;
                }
            });
        } else {
            kotlinType = null;
        }
        if (d10 instanceof JavaMethodDescriptor) {
            javaMethodDescriptor = (JavaMethodDescriptor) d10;
        } else {
            javaMethodDescriptor = null;
        }
        if (javaMethodDescriptor != null) {
            SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
            DeclarationDescriptor containingDeclaration = javaMethodDescriptor.getContainingDeclaration();
            Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            String signature = MethodSignatureBuildingUtilsKt.signature(signatureBuildingComponents, (ClassDescriptor) containingDeclaration, MethodSignatureMappingKt.computeJvmDescriptor$default(javaMethodDescriptor, false, false, 3, null));
            if (signature != null) {
                PredefinedFunctionEnhancementInfo predefinedFunctionEnhancementInfo2 = PredefinedEnhancementInfoKt.getPREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE().get(signature);
                if (predefinedFunctionEnhancementInfo2 != null) {
                    if (predefinedFunctionEnhancementInfo2.getErrorsSinceLanguageVersion() != null && ((errorsSinceLanguageVersion = predefinedFunctionEnhancementInfo2.getErrorsSinceLanguageVersion()) == null || !StringsKt.startsWith$default(errorsSinceLanguageVersion, "2.", false, 2, (Object) null))) {
                        throw new IllegalStateException("Check failed.");
                    }
                    if (predefinedFunctionEnhancementInfo2.getErrorsSinceLanguageVersion() != null) {
                        predefinedFunctionEnhancementInfo2 = predefinedFunctionEnhancementInfo2.getWarningModeClone();
                    }
                } else {
                    predefinedFunctionEnhancementInfo2 = null;
                }
                predefinedFunctionEnhancementInfo = predefinedFunctionEnhancementInfo2;
                if (predefinedFunctionEnhancementInfo != null) {
                    predefinedFunctionEnhancementInfo.getParametersInfo().size();
                    ((JavaMethodDescriptor) d10).getValueParameters().size();
                }
                if ((!UtilsKt.isJspecifyEnabledInStrictMode(lazyJavaResolverContext.getComponents().getJavaTypeEnhancementState()) || copyWithNewDefaultTypeQualifiers.getComponents().getSettings().getIgnoreNullabilityForErasedValueParameters()) && UtilsKt.hasErasedValueParameters(d10)) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                List<ValueParameterDescriptor> valueParameters = d11.getValueParameters();
                String str = "getValueParameters(...)";
                Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(valueParameters, 10));
                for (final ValueParameterDescriptor valueParameterDescriptor2 : valueParameters) {
                    if (predefinedFunctionEnhancementInfo != null && (parametersInfo = predefinedFunctionEnhancementInfo.getParametersInfo()) != null) {
                        typeEnhancementInfo2 = (TypeEnhancementInfo) CollectionsKt.getOrNull(parametersInfo, valueParameterDescriptor2.getIndex());
                    } else {
                        typeEnhancementInfo2 = typeEnhancementInfo3;
                    }
                    ArrayList arrayList2 = arrayList;
                    arrayList2.add(enhanceValueParameter(d10, valueParameterDescriptor2, copyWithNewDefaultTypeQualifiers, typeEnhancementInfo2, z10, new Function1(valueParameterDescriptor2) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$$Lambda$1
                        private final ValueParameterDescriptor arg$0;

                        {
                            this.arg$0 = valueParameterDescriptor2;
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public Object invoke(Object obj) {
                            KotlinType enhanceSignature$lambda$9$lambda$8;
                            enhanceSignature$lambda$9$lambda$8 = SignatureEnhancement.enhanceSignature$lambda$9$lambda$8(this.arg$0, (CallableMemberDescriptor) obj);
                            return enhanceSignature$lambda$9$lambda$8;
                        }
                    }));
                    arrayList = arrayList2;
                    str = str;
                    typeEnhancementInfo3 = null;
                }
                ArrayList arrayList3 = arrayList;
                String str2 = str;
                if (!(d10 instanceof PropertyDescriptor)) {
                    propertyDescriptor = (PropertyDescriptor) d10;
                } else {
                    propertyDescriptor = null;
                }
                if (propertyDescriptor == null && JavaDescriptorUtilKt.isJavaField(propertyDescriptor)) {
                    annotationQualifierApplicabilityType = AnnotationQualifierApplicabilityType.FIELD;
                } else {
                    annotationQualifierApplicabilityType = AnnotationQualifierApplicabilityType.METHOD_RETURN_TYPE;
                }
                AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType2 = annotationQualifierApplicabilityType;
                if (predefinedFunctionEnhancementInfo == null) {
                    typeEnhancementInfo = predefinedFunctionEnhancementInfo.getReturnTypeInfo();
                } else {
                    typeEnhancementInfo = null;
                }
                enhance$default = enhance$default(this, d10, d11, true, copyWithNewDefaultTypeQualifiers, annotationQualifierApplicabilityType2, typeEnhancementInfo, false, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$$Lambda$2
                    @Override // kotlin.jvm.functions.Function1
                    public Object invoke(Object obj) {
                        KotlinType enhanceSignature$lambda$10;
                        enhanceSignature$lambda$10 = SignatureEnhancement.enhanceSignature$lambda$10((CallableMemberDescriptor) obj);
                        return enhanceSignature$lambda$10;
                    }
                }, 32, null);
                returnType = d10.getReturnType();
                Intrinsics.checkNotNull(returnType);
                if (!containsFunctionN(returnType)) {
                    ReceiverParameterDescriptor extensionReceiverParameter = d10.getExtensionReceiverParameter();
                    if (extensionReceiverParameter != null && (type = extensionReceiverParameter.getType()) != null) {
                        z13 = containsFunctionN(type);
                    } else {
                        z13 = false;
                    }
                    if (!z13) {
                        List<ValueParameterDescriptor> valueParameters2 = d10.getValueParameters();
                        Intrinsics.checkNotNullExpressionValue(valueParameters2, str2);
                        if (!(valueParameters2 instanceof Collection) || !valueParameters2.isEmpty()) {
                            Iterator<T> it = valueParameters2.iterator();
                            while (it.hasNext()) {
                                KotlinType type2 = ((ValueParameterDescriptor) it.next()).getType();
                                Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
                                if (containsFunctionN(type2)) {
                                    z14 = true;
                                    break;
                                }
                            }
                        }
                        z14 = false;
                        if (!z14) {
                            z11 = false;
                            if (z11) {
                                pair = TuplesKt.to(DescriptorBasedDeprecationInfoKt.getDEPRECATED_FUNCTION_KEY(), new DeprecationCausedByFunctionNInfo(d10));
                            } else {
                                pair = null;
                            }
                            if (kotlinType == null && enhance$default == null) {
                                if (!arrayList3.isEmpty()) {
                                    Iterator it2 = arrayList3.iterator();
                                    while (it2.hasNext()) {
                                        if (((KotlinType) it2.next()) != null) {
                                            z12 = true;
                                        } else {
                                            z12 = false;
                                        }
                                        if (z12) {
                                            break;
                                        }
                                    }
                                }
                                z15 = false;
                                if (!z15 && pair == null) {
                                    return d10;
                                }
                            }
                            JavaCallableMemberDescriptor javaCallableMemberDescriptor = (JavaCallableMemberDescriptor) d10;
                            if (kotlinType == null) {
                                ReceiverParameterDescriptor extensionReceiverParameter2 = d10.getExtensionReceiverParameter();
                                if (extensionReceiverParameter2 != null) {
                                    kotlinType = extensionReceiverParameter2.getType();
                                } else {
                                    kotlinType = null;
                                }
                            }
                            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
                            int i10 = 0;
                            for (Object obj : arrayList3) {
                                int i11 = i10 + 1;
                                if (i10 < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                KotlinType kotlinType2 = (KotlinType) obj;
                                if (kotlinType2 == null) {
                                    kotlinType2 = d10.getValueParameters().get(i10).getType();
                                    Intrinsics.checkNotNullExpressionValue(kotlinType2, "getType(...)");
                                }
                                arrayList4.add(kotlinType2);
                                i10 = i11;
                            }
                            if (enhance$default == null) {
                                enhance$default = d10.getReturnType();
                                Intrinsics.checkNotNull(enhance$default);
                            }
                            JavaCallableMemberDescriptor enhance = javaCallableMemberDescriptor.enhance(kotlinType, arrayList4, enhance$default, pair);
                            Intrinsics.checkNotNull(enhance, "null cannot be cast to non-null type D of org.jetbrains.kotlin.load.java.typeEnhancement.SignatureEnhancement.enhanceSignature");
                            return enhance;
                        }
                    }
                }
                z11 = true;
                if (z11) {
                }
                if (kotlinType == null) {
                    if (!arrayList3.isEmpty()) {
                    }
                    z15 = false;
                    if (!z15) {
                        return d10;
                    }
                }
                JavaCallableMemberDescriptor javaCallableMemberDescriptor2 = (JavaCallableMemberDescriptor) d10;
                if (kotlinType == null) {
                }
                ArrayList arrayList42 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
                int i102 = 0;
                while (r5.hasNext()) {
                }
                if (enhance$default == null) {
                }
                JavaCallableMemberDescriptor enhance2 = javaCallableMemberDescriptor2.enhance(kotlinType, arrayList42, enhance$default, pair);
                Intrinsics.checkNotNull(enhance2, "null cannot be cast to non-null type D of org.jetbrains.kotlin.load.java.typeEnhancement.SignatureEnhancement.enhanceSignature");
                return enhance2;
            }
        }
        predefinedFunctionEnhancementInfo = null;
        if (predefinedFunctionEnhancementInfo != null) {
        }
        if (!UtilsKt.isJspecifyEnabledInStrictMode(lazyJavaResolverContext.getComponents().getJavaTypeEnhancementState())) {
        }
        z10 = true;
        List<ValueParameterDescriptor> valueParameters3 = d11.getValueParameters();
        String str3 = "getValueParameters(...)";
        Intrinsics.checkNotNullExpressionValue(valueParameters3, "getValueParameters(...)");
        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(valueParameters3, 10));
        while (r17.hasNext()) {
        }
        ArrayList arrayList32 = arrayList5;
        String str22 = str3;
        if (!(d10 instanceof PropertyDescriptor)) {
        }
        if (propertyDescriptor == null) {
        }
        annotationQualifierApplicabilityType = AnnotationQualifierApplicabilityType.METHOD_RETURN_TYPE;
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType22 = annotationQualifierApplicabilityType;
        if (predefinedFunctionEnhancementInfo == null) {
        }
        enhance$default = enhance$default(this, d10, d11, true, copyWithNewDefaultTypeQualifiers, annotationQualifierApplicabilityType22, typeEnhancementInfo, false, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$$Lambda$2
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj2) {
                KotlinType enhanceSignature$lambda$10;
                enhanceSignature$lambda$10 = SignatureEnhancement.enhanceSignature$lambda$10((CallableMemberDescriptor) obj2);
                return enhanceSignature$lambda$10;
            }
        }, 32, null);
        returnType = d10.getReturnType();
        Intrinsics.checkNotNull(returnType);
        if (!containsFunctionN(returnType)) {
        }
        z11 = true;
        if (z11) {
        }
        if (kotlinType == null) {
        }
        JavaCallableMemberDescriptor javaCallableMemberDescriptor22 = (JavaCallableMemberDescriptor) d10;
        if (kotlinType == null) {
        }
        ArrayList arrayList422 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList32, 10));
        int i1022 = 0;
        while (r5.hasNext()) {
        }
        if (enhance$default == null) {
        }
        JavaCallableMemberDescriptor enhance22 = javaCallableMemberDescriptor22.enhance(kotlinType, arrayList422, enhance$default, pair);
        Intrinsics.checkNotNull(enhance22, "null cannot be cast to non-null type D of org.jetbrains.kotlin.load.java.typeEnhancement.SignatureEnhancement.enhanceSignature");
        return enhance22;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KotlinType enhanceSignature$lambda$10(CallableMemberDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        KotlinType returnType = it.getReturnType();
        Intrinsics.checkNotNull(returnType);
        return returnType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KotlinType enhanceSignature$lambda$2(CallableMemberDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ReceiverParameterDescriptor extensionReceiverParameter = it.getExtensionReceiverParameter();
        Intrinsics.checkNotNull(extensionReceiverParameter);
        KotlinType type = extensionReceiverParameter.getType();
        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        return type;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KotlinType enhanceSignature$lambda$9$lambda$8(ValueParameterDescriptor valueParameterDescriptor, CallableMemberDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        KotlinType type = it.getValueParameters().get(valueParameterDescriptor.getIndex()).getType();
        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        return type;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enhanceTypeParameterBounds$lambda$15$lambda$14(UnwrappedType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it instanceof RawType;
    }

    private final KotlinType enhanceValueParameter(CallableMemberDescriptor callableMemberDescriptor, ValueParameterDescriptor valueParameterDescriptor, LazyJavaResolverContext lazyJavaResolverContext, TypeEnhancementInfo typeEnhancementInfo, boolean z10, Function1<? super CallableMemberDescriptor, ? extends KotlinType> function1) {
        LazyJavaResolverContext lazyJavaResolverContext2;
        LazyJavaResolverContext copyWithNewDefaultTypeQualifiers;
        if (valueParameterDescriptor != null && (copyWithNewDefaultTypeQualifiers = ContextKt.copyWithNewDefaultTypeQualifiers(lazyJavaResolverContext, valueParameterDescriptor.getAnnotations())) != null) {
            lazyJavaResolverContext2 = copyWithNewDefaultTypeQualifiers;
        } else {
            lazyJavaResolverContext2 = lazyJavaResolverContext;
        }
        return enhance(callableMemberDescriptor, valueParameterDescriptor, false, lazyJavaResolverContext2, AnnotationQualifierApplicabilityType.VALUE_PARAMETER, typeEnhancementInfo, z10, function1);
    }

    private final <D extends CallableMemberDescriptor> Annotations getDefaultAnnotations(D d10, LazyJavaResolverContext lazyJavaResolverContext) {
        LazyJavaClassDescriptor lazyJavaClassDescriptor;
        ClassifierDescriptor topLevelContainingClassifier = DescriptorUtilKt.getTopLevelContainingClassifier(d10);
        if (topLevelContainingClassifier == null) {
            return d10.getAnnotations();
        }
        List<JavaAnnotation> list = null;
        if (topLevelContainingClassifier instanceof LazyJavaClassDescriptor) {
            lazyJavaClassDescriptor = (LazyJavaClassDescriptor) topLevelContainingClassifier;
        } else {
            lazyJavaClassDescriptor = null;
        }
        if (lazyJavaClassDescriptor != null) {
            list = lazyJavaClassDescriptor.getModuleAnnotations();
        }
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new LazyJavaAnnotationDescriptor(lazyJavaResolverContext, (JavaAnnotation) it.next(), true));
            }
            return Annotations.Companion.create(CollectionsKt.plus((Iterable) d10.getAnnotations(), (Iterable) arrayList));
        }
        return d10.getAnnotations();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final <D extends CallableMemberDescriptor> Collection<D> enhanceSignatures(@NotNull LazyJavaResolverContext c10, @NotNull Collection<? extends D> platformSignatures) {
        Intrinsics.checkNotNullParameter(c10, "c");
        Intrinsics.checkNotNullParameter(platformSignatures, "platformSignatures");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(platformSignatures, 10));
        Iterator<T> it = platformSignatures.iterator();
        while (it.hasNext()) {
            arrayList.add(enhanceSignature((CallableMemberDescriptor) it.next(), c10));
        }
        return arrayList;
    }

    @NotNull
    public final KotlinType enhanceSuperType(@NotNull KotlinType type, @NotNull LazyJavaResolverContext context) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(context, "context");
        KotlinType enhance$default = enhance$default(this, new SignatureParts(null, false, context, AnnotationQualifierApplicabilityType.TYPE_USE, true), type, CollectionsKt.emptyList(), null, false, 12, null);
        if (enhance$default != null) {
            return enhance$default;
        }
        return type;
    }

    @NotNull
    public final List<KotlinType> enhanceTypeParameterBounds(@NotNull TypeParameterDescriptor typeParameter, @NotNull List<? extends KotlinType> bounds, @NotNull LazyJavaResolverContext context) {
        Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(bounds, 10));
        for (KotlinType kotlinType : bounds) {
            if (!TypeUtilsKt.contains(kotlinType, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$$Lambda$3
                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    boolean enhanceTypeParameterBounds$lambda$15$lambda$14;
                    enhanceTypeParameterBounds$lambda$15$lambda$14 = SignatureEnhancement.enhanceTypeParameterBounds$lambda$15$lambda$14((UnwrappedType) obj);
                    return Boolean.valueOf(enhanceTypeParameterBounds$lambda$15$lambda$14);
                }
            })) {
                KotlinType enhance$default = enhance$default(this, new SignatureParts(typeParameter, false, context, AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, false, 16, null), kotlinType, CollectionsKt.emptyList(), null, false, 12, null);
                if (enhance$default != null) {
                    kotlinType = enhance$default;
                }
            }
            arrayList.add(kotlinType);
        }
        return arrayList;
    }

    static /* synthetic */ KotlinType enhance$default(SignatureEnhancement signatureEnhancement, SignatureParts signatureParts, KotlinType kotlinType, List list, TypeEnhancementInfo typeEnhancementInfo, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            typeEnhancementInfo = null;
        }
        return signatureEnhancement.enhance(signatureParts, kotlinType, list, typeEnhancementInfo, (i10 & 8) != 0 ? false : z10);
    }

    private final KotlinType enhance(SignatureParts signatureParts, KotlinType kotlinType, List<? extends KotlinType> list, TypeEnhancementInfo typeEnhancementInfo, boolean z10) {
        return this.typeEnhancement.enhance(kotlinType, signatureParts.computeIndexedQualifiers(kotlinType, list, typeEnhancementInfo, z10), signatureParts.getSkipRawTypeArguments());
    }
}
