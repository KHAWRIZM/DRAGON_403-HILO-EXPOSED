package com.qhqc.core.basic.utils;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007¨\u0006\u000b"}, d2 = {"Lcom/qhqc/core/basic/utils/FixFragmentHelper;", "", "()V", "condition", "", "intercept", "", "context", "Landroid/content/Context;", "bundle", "Landroid/os/Bundle;", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFixFragmentHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FixFragmentHelper.kt\ncom/qhqc/core/basic/utils/FixFragmentHelper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,33:1\n1863#2,2:34\n*S KotlinDebug\n*F\n+ 1 FixFragmentHelper.kt\ncom/qhqc/core/basic/utils/FixFragmentHelper\n*L\n28#1:34,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class FixFragmentHelper {

    @NotNull
    public static final FixFragmentHelper INSTANCE = new FixFragmentHelper();

    private FixFragmentHelper() {
    }

    private final boolean condition() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 != 29 && i10 != 28) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final void intercept(@Nullable Context context, @Nullable Bundle bundle) {
        Set<String> keySet;
        Bundle bundle2;
        if (context != null && bundle != null && INSTANCE.condition()) {
            bundle.setClassLoader(context.getClass().getClassLoader());
            Bundle bundle3 = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
            if (bundle3 != null && (keySet = bundle3.keySet()) != null) {
                Intrinsics.checkNotNull(keySet);
                Iterator<T> it = keySet.iterator();
                while (it.hasNext()) {
                    Object obj = bundle3.get((String) it.next());
                    if (obj instanceof Bundle) {
                        bundle2 = (Bundle) obj;
                    } else {
                        bundle2 = null;
                    }
                    if (bundle2 != null) {
                        bundle2.setClassLoader(context.getClass().getClassLoader());
                    }
                }
            }
        }
    }
}
