package com.qiahao.base_common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KClasses;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u0002H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u0001*\u0002H\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/qiahao/base_common/utils/DeepCopy;", "", "<init>", "()V", "deepCopy", "T", "(Ljava/lang/Object;)Ljava/lang/Object;", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDeepCopy.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeepCopy.kt\ncom/qiahao/base_common/utils/DeepCopy\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,42:1\n1563#2:43\n1634#2,2:44\n230#2,2:46\n1636#2:48\n1#3:49\n*S KotlinDebug\n*F\n+ 1 DeepCopy.kt\ncom/qiahao/base_common/utils/DeepCopy\n*L\n22#1:43\n22#1:44,2\n26#1:46,2\n22#1:48\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class DeepCopy {

    @NotNull
    public static final DeepCopy INSTANCE = new DeepCopy();

    private DeepCopy() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final <T> T deepCopy(@NotNull T t10) {
        KClass kClass;
        Pair pair;
        Intrinsics.checkNotNullParameter(t10, "<this>");
        if (!Reflection.getOrCreateKotlinClass(t10.getClass()).isData()) {
            return t10;
        }
        KFunction primaryConstructor = KClasses.getPrimaryConstructor(Reflection.getOrCreateKotlinClass(t10.getClass()));
        Intrinsics.checkNotNull(primaryConstructor);
        List<KParameter> parameters = primaryConstructor.getParameters();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(parameters, 10));
        for (KParameter kParameter : parameters) {
            for (KProperty1 kProperty1 : KClasses.getMemberProperties(Reflection.getOrCreateKotlinClass(t10.getClass()))) {
                if (Intrinsics.areEqual(kProperty1.getName(), kParameter.getName())) {
                    Object obj = kProperty1.get(t10);
                    KClassifier classifier = kParameter.getType().getClassifier();
                    Object obj2 = null;
                    if (classifier instanceof KClass) {
                        kClass = (KClass) classifier;
                    } else {
                        kClass = null;
                    }
                    if (kClass != null && kClass.isData()) {
                        if (obj != null) {
                            obj2 = INSTANCE.deepCopy(obj);
                        }
                        pair = TuplesKt.to(kParameter, obj2);
                    } else {
                        pair = TuplesKt.to(kParameter, obj);
                    }
                    arrayList.add(pair);
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        return (T) primaryConstructor.callBy(MapsKt.toMap(arrayList));
    }
}
