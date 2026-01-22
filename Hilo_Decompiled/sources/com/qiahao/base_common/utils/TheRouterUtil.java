package com.qiahao.base_common.utils;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.qiahao.base_common.path.AppController;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\b\u0010\u000f\u001a\u00020\bH\u0002R6\u0010\u0004\u001a*\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005j\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/qiahao/base_common/utils/TheRouterUtil;", "", "<init>", "()V", "mHashMapListener", "Ljava/util/HashMap;", "", "Lkotlin/Function0;", "", "Lkotlin/collections/HashMap;", "isRun", "", "addToDelayRun", "clazz", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "delayCallBack", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTheRouterUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TheRouterUtil.kt\ncom/qiahao/base_common/utils/TheRouterUtil\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,43:1\n216#2,2:44\n*S KotlinDebug\n*F\n+ 1 TheRouterUtil.kt\ncom/qiahao/base_common/utils/TheRouterUtil\n*L\n34#1:44,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class TheRouterUtil {
    private static boolean isRun;

    @NotNull
    public static final TheRouterUtil INSTANCE = new TheRouterUtil();

    @NotNull
    private static final HashMap<String, Function0<Unit>> mHashMapListener = new HashMap<>();

    private TheRouterUtil() {
    }

    private final void delayCallBack() {
        if (isRun) {
            return;
        }
        isRun = true;
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.base_common.utils.q
            @Override // java.lang.Runnable
            public final void run() {
                TheRouterUtil.delayCallBack$lambda$1();
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void delayCallBack$lambda$1() {
        if (AppController.INSTANCE.getService() == null) {
            isRun = false;
            INSTANCE.delayCallBack();
            return;
        }
        Iterator<Map.Entry<String, Function0<Unit>>> it = mHashMapListener.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().invoke();
        }
        mHashMapListener.clear();
        isRun = false;
    }

    public final void addToDelayRun(@NotNull String clazz, @NotNull Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (AppController.INSTANCE.getService() != null) {
            listener.invoke();
        } else {
            mHashMapListener.put(clazz, listener);
            delayCallBack();
        }
    }
}
