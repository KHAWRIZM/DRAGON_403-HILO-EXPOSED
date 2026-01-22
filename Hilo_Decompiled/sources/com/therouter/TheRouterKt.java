package com.therouter;

import android.util.Log;
import com.qiahao.nextvideo.ui.home.chat.dialog.MessageMenuDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\rH\u0000\u001a(\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\rH\u0000\u001a \u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0000\u001a\u0006\u0010\u0011\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u001a\u0010\u0002\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"inited", "", "theRouterUseAutoInit", "getTheRouterUseAutoInit", "()Z", "setTheRouterUseAutoInit", "(Z)V", "debug", "", "tag", "", "msg", MessageMenuDialog.BLOCK, "Lkotlin/Function0;", "debugOnly", "require", "pass", "theRouterInited", "router_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class TheRouterKt {
    private static boolean inited = false;
    private static boolean theRouterUseAutoInit = true;

    public static final void debug(@NotNull String str, @NotNull String str2, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "msg");
        Intrinsics.checkNotNullParameter(function0, MessageMenuDialog.BLOCK);
        if (TheRouter.isDebug()) {
            Log.d("TheRouter::" + str, str2);
            function0.invoke();
            return;
        }
        TheRouter.getLogCat().invoke("TheRouter::" + str, str2);
    }

    public static /* synthetic */ void debug$default(String str, String str2, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = new Function0<Unit>() { // from class: com.therouter.TheRouterKt$debug$1
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m١٧٠invoke() {
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m١٧٠invoke();
                    return Unit.INSTANCE;
                }
            };
        }
        debug(str, str2, function0);
    }

    public static final void debugOnly(@NotNull String str, @NotNull String str2, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "msg");
        Intrinsics.checkNotNullParameter(function0, MessageMenuDialog.BLOCK);
        if (TheRouter.isDebug()) {
            Log.d("TheRouter::" + str, str2);
            function0.invoke();
        }
    }

    public static /* synthetic */ void debugOnly$default(String str, String str2, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = new Function0<Unit>() { // from class: com.therouter.TheRouterKt$debugOnly$1
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m١٧١invoke() {
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m١٧١invoke();
                    return Unit.INSTANCE;
                }
            };
        }
        debugOnly(str, str2, function0);
    }

    public static final boolean getTheRouterUseAutoInit() {
        return theRouterUseAutoInit;
    }

    public static final void require(boolean z, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "msg");
        if (!z) {
            if (!TheRouter.isDebug()) {
                TheRouter.getLogCat().invoke("TheRouter::" + str, str2);
                return;
            }
            throw new IllegalArgumentException("TheRouter::" + str + "::" + str2);
        }
    }

    public static final void setTheRouterUseAutoInit(boolean z) {
        theRouterUseAutoInit = z;
    }

    public static final boolean theRouterInited() {
        return inited;
    }
}
