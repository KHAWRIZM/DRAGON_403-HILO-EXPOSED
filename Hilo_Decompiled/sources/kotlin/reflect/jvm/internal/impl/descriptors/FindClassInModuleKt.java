package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.ResolutionAnchorProviderKt;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nfindClassInModule.kt\nKotlin\n*S Kotlin\n*F\n+ 1 findClassInModule.kt\norg/jetbrains/kotlin/descriptors/FindClassInModuleKt\n*L\n1#1,66:1\n43#1,2:67\n*S KotlinDebug\n*F\n+ 1 findClassInModule.kt\norg/jetbrains/kotlin/descriptors/FindClassInModuleKt\n*L\n23#1:67,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class FindClassInModuleKt {
    @Nullable
    public static final ClassDescriptor findClassAcrossModuleDependencies(@NotNull ModuleDescriptor moduleDescriptor, @NotNull ClassId classId) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        ClassifierDescriptor findClassifierAcrossModuleDependencies = findClassifierAcrossModuleDependencies(moduleDescriptor, classId);
        if (findClassifierAcrossModuleDependencies instanceof ClassDescriptor) {
            return (ClassDescriptor) findClassifierAcrossModuleDependencies;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x011f  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final ClassifierDescriptor findClassifierAcrossModuleDependencies(@NotNull ModuleDescriptor moduleDescriptor, @NotNull ClassId classId) {
        ClassifierDescriptor classifierDescriptor;
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        ModuleDescriptor resolutionAnchorIfAny = ResolutionAnchorProviderKt.getResolutionAnchorIfAny(moduleDescriptor);
        if (resolutionAnchorIfAny == null) {
            PackageViewDescriptor packageViewDescriptor = moduleDescriptor.getPackage(classId.getPackageFqName());
            List<Name> pathSegments = classId.getRelativeClassName().pathSegments();
            classifierDescriptor = packageViewDescriptor.getMemberScope().mo١٩٢٥getContributedClassifier((Name) CollectionsKt.first((List) pathSegments), NoLookupLocation.FROM_DESERIALIZATION);
            if (classifierDescriptor == null) {
                return null;
            }
            for (Name name : pathSegments.subList(1, pathSegments.size())) {
                if (!(classifierDescriptor instanceof ClassDescriptor)) {
                    return null;
                }
                ClassifierDescriptor classifierDescriptor2 = ((ClassDescriptor) classifierDescriptor).getUnsubstitutedInnerClassesScope().mo١٩٢٥getContributedClassifier(name, NoLookupLocation.FROM_DESERIALIZATION);
                if (classifierDescriptor2 instanceof ClassDescriptor) {
                    classifierDescriptor = (ClassDescriptor) classifierDescriptor2;
                } else {
                    classifierDescriptor = null;
                }
                if (classifierDescriptor == null) {
                    return null;
                }
            }
        } else {
            PackageViewDescriptor packageViewDescriptor2 = resolutionAnchorIfAny.getPackage(classId.getPackageFqName());
            List<Name> pathSegments2 = classId.getRelativeClassName().pathSegments();
            ClassifierDescriptor classifierDescriptor3 = packageViewDescriptor2.getMemberScope().mo١٩٢٥getContributedClassifier((Name) CollectionsKt.first((List) pathSegments2), NoLookupLocation.FROM_DESERIALIZATION);
            if (classifierDescriptor3 != null) {
                for (Name name2 : pathSegments2.subList(1, pathSegments2.size())) {
                    if (classifierDescriptor3 instanceof ClassDescriptor) {
                        ClassifierDescriptor classifierDescriptor4 = ((ClassDescriptor) classifierDescriptor3).getUnsubstitutedInnerClassesScope().mo١٩٢٥getContributedClassifier(name2, NoLookupLocation.FROM_DESERIALIZATION);
                        if (classifierDescriptor4 instanceof ClassDescriptor) {
                            classifierDescriptor3 = (ClassDescriptor) classifierDescriptor4;
                        } else {
                            classifierDescriptor3 = null;
                        }
                        if (classifierDescriptor3 != null) {
                        }
                    }
                }
                if (classifierDescriptor3 != null) {
                    PackageViewDescriptor packageViewDescriptor3 = moduleDescriptor.getPackage(classId.getPackageFqName());
                    List<Name> pathSegments3 = classId.getRelativeClassName().pathSegments();
                    classifierDescriptor = packageViewDescriptor3.getMemberScope().mo١٩٢٥getContributedClassifier((Name) CollectionsKt.first((List) pathSegments3), NoLookupLocation.FROM_DESERIALIZATION);
                    if (classifierDescriptor == null) {
                        return null;
                    }
                    for (Name name3 : pathSegments3.subList(1, pathSegments3.size())) {
                        if (!(classifierDescriptor instanceof ClassDescriptor)) {
                            return null;
                        }
                        ClassifierDescriptor classifierDescriptor5 = ((ClassDescriptor) classifierDescriptor).getUnsubstitutedInnerClassesScope().mo١٩٢٥getContributedClassifier(name3, NoLookupLocation.FROM_DESERIALIZATION);
                        if (classifierDescriptor5 instanceof ClassDescriptor) {
                            classifierDescriptor = (ClassDescriptor) classifierDescriptor5;
                        } else {
                            classifierDescriptor = null;
                        }
                        if (classifierDescriptor == null) {
                            return null;
                        }
                    }
                } else {
                    return classifierDescriptor3;
                }
            }
            classifierDescriptor3 = null;
            if (classifierDescriptor3 != null) {
            }
        }
        return classifierDescriptor;
    }

    @NotNull
    public static final ClassDescriptor findNonGenericClassAcrossDependencies(@NotNull ModuleDescriptor moduleDescriptor, @NotNull ClassId classId, @NotNull NotFoundClasses notFoundClasses) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        Intrinsics.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        ClassDescriptor findClassAcrossModuleDependencies = findClassAcrossModuleDependencies(moduleDescriptor, classId);
        if (findClassAcrossModuleDependencies != null) {
            return findClassAcrossModuleDependencies;
        }
        return notFoundClasses.getClass(classId, SequencesKt.toList(SequencesKt.map(SequencesKt.generateSequence(classId, new PropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ClassId) obj).getOuterClassId();
            }
        }), new Function1() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt$$Lambda$0
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                int findNonGenericClassAcrossDependencies$lambda$1;
                findNonGenericClassAcrossDependencies$lambda$1 = FindClassInModuleKt.findNonGenericClassAcrossDependencies$lambda$1((ClassId) obj);
                return Integer.valueOf(findNonGenericClassAcrossDependencies$lambda$1);
            }
        })));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int findNonGenericClassAcrossDependencies$lambda$1(ClassId it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return 0;
    }

    @Nullable
    public static final TypeAliasDescriptor findTypeAliasAcrossModuleDependencies(@NotNull ModuleDescriptor moduleDescriptor, @NotNull ClassId classId) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        ClassifierDescriptor findClassifierAcrossModuleDependencies = findClassifierAcrossModuleDependencies(moduleDescriptor, classId);
        if (findClassifierAcrossModuleDependencies instanceof TypeAliasDescriptor) {
            return (TypeAliasDescriptor) findClassifierAcrossModuleDependencies;
        }
        return null;
    }
}
