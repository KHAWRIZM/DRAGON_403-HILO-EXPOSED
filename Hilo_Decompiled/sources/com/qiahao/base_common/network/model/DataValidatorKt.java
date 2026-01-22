package com.qiahao.base_common.network.model;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KClasses;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¨\u0006\u0004"}, d2 = {"validate", "", "obj", "", "base_common_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDataValidator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataValidator.kt\ncom/qiahao/base_common/network/model/DataValidatorKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,35:1\n1869#2,2:36\n*S KotlinDebug\n*F\n+ 1 DataValidator.kt\ncom/qiahao/base_common/network/model/DataValidatorKt\n*L\n21#1:36,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class DataValidatorKt {
    public static final void validate(@Nullable Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                validate(it.next());
            }
            return;
        }
        for (KProperty1 kProperty1 : KClasses.getDeclaredMemberProperties(Reflection.getOrCreateKotlinClass(obj.getClass()))) {
            V call = kProperty1.getGetter().call(obj);
            if (!kProperty1.getReturnType().isMarkedNullable() && call == 0) {
                String str = "Field " + kProperty1 + " is missing";
                System.out.println((Object) str);
                throw new IOException(str);
            }
            if (call != 0) {
                validate(call);
            }
        }
    }
}
