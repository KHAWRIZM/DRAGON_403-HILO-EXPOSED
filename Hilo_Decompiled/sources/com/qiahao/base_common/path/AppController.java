package com.qiahao.base_common.path;

import androidx.annotation.Keep;
import com.qiahao.base_common.support.AppService;
import com.therouter.TheRouter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/qiahao/base_common/path/AppController;", "", "<init>", "()V", "service", "Lcom/qiahao/base_common/support/AppService;", "getService", "()Lcom/qiahao/base_common/support/AppService;", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class AppController {

    @NotNull
    public static final AppController INSTANCE = new AppController();

    @Nullable
    private static final AppService service = (AppService) TheRouter.get(AppService.class, new Object[0]);

    private AppController() {
    }

    @Nullable
    public final AppService getService() {
        return service;
    }
}
