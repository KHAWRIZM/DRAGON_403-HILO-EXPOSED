package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\ntypeEnhancement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 typeEnhancement.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/JavaTypeEnhancement\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,261:1\n1#2:262\n3436#3,7:263\n1734#3,3:270\n3436#3,7:273\n*S KotlinDebug\n*F\n+ 1 typeEnhancement.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/JavaTypeEnhancement\n*L\n117#1:263,7\n143#1:270,3\n155#1:273,7\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class JavaTypeEnhancement {

    @NotNull
    private final JavaResolverSettings javaResolverSettings;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Result {
        private final int subtreeSize;

        @Nullable
        private final KotlinType type;

        public Result(@Nullable KotlinType kotlinType, int i10) {
            this.type = kotlinType;
            this.subtreeSize = i10;
        }

        public final int getSubtreeSize() {
            return this.subtreeSize;
        }

        @Nullable
        public final KotlinType getType() {
            return this.type;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class SimpleResult {
        private final boolean forWarnings;
        private final int subtreeSize;

        @Nullable
        private final SimpleType type;

        public SimpleResult(@Nullable SimpleType simpleType, int i10, boolean z10) {
            this.type = simpleType;
            this.subtreeSize = i10;
            this.forWarnings = z10;
        }

        public final boolean getForWarnings() {
            return this.forWarnings;
        }

        public final int getSubtreeSize() {
            return this.subtreeSize;
        }

        @Nullable
        public final SimpleType getType() {
            return this.type;
        }
    }

    public JavaTypeEnhancement(@NotNull JavaResolverSettings javaResolverSettings) {
        Intrinsics.checkNotNullParameter(javaResolverSettings, "javaResolverSettings");
        this.javaResolverSettings = javaResolverSettings;
    }

    private final SimpleResult enhanceInflexible(SimpleType simpleType, Function1<? super Integer, JavaTypeQualifiers> function1, int i10, TypeComponentPosition typeComponentPosition, boolean z10, boolean z11) {
        boolean z12;
        ClassifierDescriptor enhanceMutability;
        Boolean enhancedNullability;
        TypeConstructor constructor;
        EnhancedTypeAnnotations enhancedTypeAnnotations;
        Annotations annotations;
        Annotations compositeAnnotationsOrSingle;
        boolean isMarkedNullable;
        boolean z13;
        Result result;
        TypeProjection typeProjection;
        Function1<? super Integer, JavaTypeQualifiers> function12 = function1;
        boolean shouldEnhance = TypeComponentPositionKt.shouldEnhance(typeComponentPosition);
        if (z11 && z10) {
            z12 = false;
        } else {
            z12 = true;
        }
        KotlinType kotlinType = null;
        if (!shouldEnhance && simpleType.getArguments().isEmpty()) {
            return new SimpleResult(null, 1, false);
        }
        ClassifierDescriptor classifierDescriptor = simpleType.getConstructor().mo١٩٢٣getDeclarationDescriptor();
        if (classifierDescriptor == null) {
            return new SimpleResult(null, 1, false);
        }
        JavaTypeQualifiers invoke = function12.invoke(Integer.valueOf(i10));
        enhanceMutability = TypeEnhancementKt.enhanceMutability(classifierDescriptor, invoke, typeComponentPosition);
        enhancedNullability = TypeEnhancementKt.getEnhancedNullability(invoke, typeComponentPosition);
        if (enhanceMutability == null || (constructor = enhanceMutability.getTypeConstructor()) == null) {
            constructor = simpleType.getConstructor();
        }
        TypeConstructor typeConstructor = constructor;
        int i11 = i10 + 1;
        List<TypeProjection> arguments = simpleType.getArguments();
        List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
        Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
        Iterator<T> it = arguments.iterator();
        Iterator<T> it2 = parameters.iterator();
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(arguments, 10), CollectionsKt.collectionSizeOrDefault(parameters, 10)));
        while (it.hasNext() && it2.hasNext()) {
            Object next = it.next();
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) it2.next();
            TypeProjection typeProjection2 = (TypeProjection) next;
            if (!z12) {
                z13 = z12;
                result = new Result(kotlinType, 0);
            } else {
                z13 = z12;
                if (!typeProjection2.isStarProjection()) {
                    result = enhancePossiblyFlexible(typeProjection2.getType().unwrap(), function12, i11, z11);
                } else if (function12.invoke(Integer.valueOf(i11)).getNullability() == NullabilityQualifier.FORCE_FLEXIBILITY) {
                    UnwrappedType unwrap = typeProjection2.getType().unwrap();
                    result = new Result(KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible(unwrap).makeNullableAsSpecified(false), FlexibleTypesKt.upperIfFlexible(unwrap).makeNullableAsSpecified(true)), 1);
                } else {
                    result = new Result(null, 1);
                }
            }
            i11 += result.getSubtreeSize();
            if (result.getType() != null) {
                KotlinType type = result.getType();
                Variance projectionKind = typeProjection2.getProjectionKind();
                Intrinsics.checkNotNullExpressionValue(projectionKind, "getProjectionKind(...)");
                typeProjection = TypeUtilsKt.createProjection(type, projectionKind, typeParameterDescriptor);
            } else if (enhanceMutability != null && !typeProjection2.isStarProjection()) {
                KotlinType type2 = typeProjection2.getType();
                Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
                Variance projectionKind2 = typeProjection2.getProjectionKind();
                Intrinsics.checkNotNullExpressionValue(projectionKind2, "getProjectionKind(...)");
                typeProjection = TypeUtilsKt.createProjection(type2, projectionKind2, typeParameterDescriptor);
            } else if (enhanceMutability != null) {
                typeProjection = TypeUtils.makeStarProjection(typeParameterDescriptor);
            } else {
                typeProjection = null;
            }
            arrayList.add(typeProjection);
            function12 = function1;
            z12 = z13;
            kotlinType = null;
        }
        int i12 = i11 - i10;
        if (enhanceMutability == null && enhancedNullability == null) {
            if (!arrayList.isEmpty()) {
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    if (((TypeProjection) it3.next()) == null) {
                    }
                }
            }
            return new SimpleResult(null, i12, false);
        }
        Annotations annotations2 = simpleType.getAnnotations();
        enhancedTypeAnnotations = TypeEnhancementKt.ENHANCED_MUTABILITY_ANNOTATIONS;
        if (enhanceMutability == null) {
            enhancedTypeAnnotations = null;
        }
        Annotations enhanced_nullability_annotations = TypeEnhancementKt.getENHANCED_NULLABILITY_ANNOTATIONS();
        if (enhancedNullability != null) {
            annotations = enhanced_nullability_annotations;
        } else {
            annotations = null;
        }
        boolean z14 = false;
        compositeAnnotationsOrSingle = TypeEnhancementKt.compositeAnnotationsOrSingle(CollectionsKt.listOfNotNull((Object[]) new Annotations[]{annotations2, enhancedTypeAnnotations, annotations}));
        TypeAttributes defaultAttributes = TypeAttributesKt.toDefaultAttributes(compositeAnnotationsOrSingle);
        List<TypeProjection> arguments2 = simpleType.getArguments();
        Iterator it4 = arrayList.iterator();
        Iterator<T> it5 = arguments2.iterator();
        ArrayList arrayList2 = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(arrayList, 10), CollectionsKt.collectionSizeOrDefault(arguments2, 10)));
        while (it4.hasNext() && it5.hasNext()) {
            Object next2 = it4.next();
            TypeProjection typeProjection3 = (TypeProjection) it5.next();
            TypeProjection typeProjection4 = (TypeProjection) next2;
            if (typeProjection4 != null) {
                typeProjection3 = typeProjection4;
            }
            arrayList2.add(typeProjection3);
        }
        if (enhancedNullability != null) {
            isMarkedNullable = enhancedNullability.booleanValue();
        } else {
            isMarkedNullable = simpleType.isMarkedNullable();
        }
        SimpleType simpleType$default = KotlinTypeFactory.simpleType$default(defaultAttributes, typeConstructor, arrayList2, isMarkedNullable, (KotlinTypeRefiner) null, 16, (Object) null);
        if (invoke.getDefinitelyNotNull()) {
            simpleType$default = notNullTypeParameter(simpleType$default);
        }
        if (enhancedNullability != null && invoke.isNullabilityQualifierForWarning()) {
            z14 = true;
        }
        return new SimpleResult(simpleType$default, i12, z14);
    }

    static /* synthetic */ SimpleResult enhanceInflexible$default(JavaTypeEnhancement javaTypeEnhancement, SimpleType simpleType, Function1 function1, int i10, TypeComponentPosition typeComponentPosition, boolean z10, boolean z11, int i11, Object obj) {
        boolean z12;
        boolean z13;
        if ((i11 & 8) != 0) {
            z12 = false;
        } else {
            z12 = z10;
        }
        if ((i11 & 16) != 0) {
            z13 = false;
        } else {
            z13 = z11;
        }
        return javaTypeEnhancement.enhanceInflexible(simpleType, function1, i10, typeComponentPosition, z12, z13);
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0096, code lost:
    
        if (r13 == null) goto L٤٠;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Result enhancePossiblyFlexible(UnwrappedType unwrappedType, Function1<? super Integer, JavaTypeQualifiers> function1, int i10, boolean z10) {
        KotlinType type;
        KotlinType type2;
        KotlinType kotlinType = null;
        if (KotlinTypeKt.isError(unwrappedType)) {
            return new Result(null, 1);
        }
        if (unwrappedType instanceof FlexibleType) {
            boolean z11 = unwrappedType instanceof RawType;
            FlexibleType flexibleType = (FlexibleType) unwrappedType;
            SimpleResult enhanceInflexible = enhanceInflexible(flexibleType.getLowerBound(), function1, i10, TypeComponentPosition.FLEXIBLE_LOWER, z11, z10);
            SimpleResult enhanceInflexible2 = enhanceInflexible(flexibleType.getUpperBound(), function1, i10, TypeComponentPosition.FLEXIBLE_UPPER, z11, z10);
            enhanceInflexible.getSubtreeSize();
            enhanceInflexible2.getSubtreeSize();
            if (enhanceInflexible.getType() != null || enhanceInflexible2.getType() != null) {
                if (!enhanceInflexible.getForWarnings() && !enhanceInflexible2.getForWarnings()) {
                    if (z11) {
                        SimpleType type3 = enhanceInflexible.getType();
                        if (type3 == null) {
                            type3 = flexibleType.getLowerBound();
                        }
                        SimpleType type4 = enhanceInflexible2.getType();
                        if (type4 == null) {
                            type4 = flexibleType.getUpperBound();
                        }
                        kotlinType = new RawTypeImpl(type3, type4);
                    } else {
                        SimpleType type5 = enhanceInflexible.getType();
                        if (type5 == null) {
                            type5 = flexibleType.getLowerBound();
                        }
                        SimpleType type6 = enhanceInflexible2.getType();
                        if (type6 == null) {
                            type6 = flexibleType.getUpperBound();
                        }
                        kotlinType = KotlinTypeFactory.flexibleType(type5, type6);
                    }
                } else {
                    SimpleType type7 = enhanceInflexible2.getType();
                    if (type7 != null) {
                        SimpleType type8 = enhanceInflexible.getType();
                        if (type8 == null) {
                            type8 = type7;
                        }
                        type2 = KotlinTypeFactory.flexibleType(type8, type7);
                    }
                    type2 = enhanceInflexible.getType();
                    Intrinsics.checkNotNull(type2);
                    kotlinType = TypeWithEnhancementKt.wrapEnhancement(unwrappedType, type2);
                }
            }
            return new Result(kotlinType, enhanceInflexible.getSubtreeSize());
        }
        if (unwrappedType instanceof SimpleType) {
            SimpleResult enhanceInflexible$default = enhanceInflexible$default(this, (SimpleType) unwrappedType, function1, i10, TypeComponentPosition.INFLEXIBLE, false, z10, 8, null);
            if (enhanceInflexible$default.getForWarnings()) {
                type = TypeWithEnhancementKt.wrapEnhancement(unwrappedType, enhanceInflexible$default.getType());
            } else {
                type = enhanceInflexible$default.getType();
            }
            return new Result(type, enhanceInflexible$default.getSubtreeSize());
        }
        throw new NoWhenBranchMatchedException();
    }

    private final SimpleType notNullTypeParameter(SimpleType simpleType) {
        if (this.javaResolverSettings.getCorrectNullabilityForNotNullTypeParameter()) {
            return SpecialTypesKt.makeSimpleTypeDefinitelyNotNullOrNotNull(simpleType, true);
        }
        return new NotNullTypeParameterImpl(simpleType);
    }

    @Nullable
    public final KotlinType enhance(@NotNull KotlinType kotlinType, @NotNull Function1<? super Integer, JavaTypeQualifiers> qualifiers, boolean z10) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        Intrinsics.checkNotNullParameter(qualifiers, "qualifiers");
        return enhancePossiblyFlexible(kotlinType.unwrap(), qualifiers, 0, z10).getType();
    }
}
