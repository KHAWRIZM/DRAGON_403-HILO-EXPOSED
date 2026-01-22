package com.therouter;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u001a\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0006\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"applicationContext", "Landroid/content/Context;", "getApplicationContext", "setContext", "", "c", "(Landroid/content/Context;)Lkotlin/Unit;", "router_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class InnerTheRouterContentProviderKt {

    @Nullable
    private static Context applicationContext;

    @Nullable
    public static final Context getApplicationContext() {
        return applicationContext;
    }

    @Nullable
    public static final Unit setContext(@Nullable Context context) {
        if (context != null) {
            applicationContext = context;
            return Unit.INSTANCE;
        }
        return null;
    }
}
