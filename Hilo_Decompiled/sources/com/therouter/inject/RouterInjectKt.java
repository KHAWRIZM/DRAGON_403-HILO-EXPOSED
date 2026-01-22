package com.therouter.inject;

import com.qiahao.nextvideo.ui.home.chat.dialog.MessageMenuDialog;
import com.therouter.TheRouterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"mRecyclerBin", "Lcom/therouter/inject/RecyclerBin;", "routerInjectDebugLog", "", "msg", "", MessageMenuDialog.BLOCK, "Lkotlin/Function0;", "router_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class RouterInjectKt {

    @NotNull
    private static final RecyclerBin mRecyclerBin = new RecyclerBin();

    private static final void routerInjectDebugLog(String str, Function0<Unit> function0) {
        TheRouterKt.debug("RouterInject", str, function0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void routerInjectDebugLog$default(String str, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = new Function0<Unit>() { // from class: com.therouter.inject.RouterInjectKt$routerInjectDebugLog$1
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m١٧٩invoke() {
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m١٧٩invoke();
                    return Unit.INSTANCE;
                }
            };
        }
        routerInjectDebugLog(str, function0);
    }
}
