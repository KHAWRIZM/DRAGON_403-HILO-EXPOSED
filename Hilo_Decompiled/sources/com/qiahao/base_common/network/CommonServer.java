package com.qiahao.base_common.network;

import android.annotation.SuppressLint;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pd.g;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/qiahao/base_common/network/CommonServer;", "", "<init>", "()V", "apis", "Lcom/qiahao/base_common/network/CommonApi;", "getApis", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SuppressLint({"CheckResult"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class CommonServer {

    @NotNull
    public static final CommonServer INSTANCE = new CommonServer();

    @Nullable
    private static CommonApi apis;

    static {
        BaseServer.INSTANCE.getSelectedServerChange().observeOn(md.b.c()).subscribe(new g() { // from class: com.qiahao.base_common.network.CommonServer.1
            @Override // pd.g
            public final void accept(String str) {
                CommonServer.apis = null;
            }
        });
    }

    private CommonServer() {
    }

    @NotNull
    public final CommonApi getApis() {
        if (apis == null) {
            synchronized (CommonServer.class) {
                try {
                    if (apis == null) {
                        apis = (CommonApi) BaseServer.INSTANCE.createApis(CommonApi.class);
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        CommonApi commonApi = apis;
        Intrinsics.checkNotNull(commonApi);
        return commonApi;
    }
}
