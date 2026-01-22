package com.qiahao.nextvideo.data.model;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\t\u001a\u00020\n2\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\rJ\"\u0010\u000e\u001a\u00020\n2\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\rJ\"\u0010\u000f\u001a\u00020\n2\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/qiahao/nextvideo/data/model/BinderThirdType;", "", "<init>", "()V", "PHONE", "", "GOOGLE", "FACEBOOK", "APPLE", "isBinderPhone", "", "type", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "isBinderGoogle", "isBinderFacebook", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBinderThirdType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BinderThirdType.kt\ncom/qiahao/nextvideo/data/model/BinderThirdType\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,43:1\n1869#2,2:44\n1869#2,2:46\n1869#2,2:48\n*S KotlinDebug\n*F\n+ 1 BinderThirdType.kt\ncom/qiahao/nextvideo/data/model/BinderThirdType\n*L\n16#1:44,2\n26#1:46,2\n36#1:48,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class BinderThirdType {
    public static final int APPLE = 4;
    public static final int FACEBOOK = 3;
    public static final int GOOGLE = 2;

    @NotNull
    public static final BinderThirdType INSTANCE = new BinderThirdType();
    public static final int PHONE = 1;

    private BinderThirdType() {
    }

    public final boolean isBinderFacebook(@Nullable ArrayList<Integer> type) {
        boolean z = false;
        if (type != null) {
            Iterator<T> it = type.iterator();
            while (it.hasNext()) {
                if (((Number) it.next()).intValue() == 3) {
                    z = true;
                }
            }
        }
        return z;
    }

    public final boolean isBinderGoogle(@Nullable ArrayList<Integer> type) {
        boolean z = false;
        if (type != null) {
            Iterator<T> it = type.iterator();
            while (it.hasNext()) {
                if (((Number) it.next()).intValue() == 2) {
                    z = true;
                }
            }
        }
        return z;
    }

    public final boolean isBinderPhone(@Nullable ArrayList<Integer> type) {
        boolean z = false;
        if (type != null) {
            Iterator<T> it = type.iterator();
            while (it.hasNext()) {
                if (((Number) it.next()).intValue() == 1) {
                    z = true;
                }
            }
        }
        return z;
    }
}
