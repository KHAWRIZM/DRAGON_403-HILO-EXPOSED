package com.qiahao.nextvideo.network;

import android.annotation.SuppressLint;
import com.qiahao.base_common.network.BaseServer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import md.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pd.g;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/qiahao/nextvideo/network/AppServer;", "", "<init>", "()V", "apis", "Lcom/qiahao/nextvideo/network/ServerApi;", "getApis", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SuppressLint({"CheckResult"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AppServer {

    @NotNull
    public static final AppServer INSTANCE = new AppServer();

    @Nullable
    private static ServerApi apis;

    static {
        BaseServer.INSTANCE.getSelectedServerChange().observeOn(b.c()).subscribe(new g() { // from class: com.qiahao.nextvideo.network.AppServer.1
            public final void accept(String str) {
                AppServer.apis = null;
            }
        });
    }

    private AppServer() {
    }

    @NotNull
    public final ServerApi getApis() {
        if (apis == null) {
            synchronized (AppServer.class) {
                try {
                    if (apis == null) {
                        apis = (ServerApi) BaseServer.INSTANCE.createApis(ServerApi.class);
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        ServerApi serverApi = apis;
        Intrinsics.checkNotNull(serverApi);
        return serverApi;
    }
}
