package com.qiahao.base_common;

import androidx.annotation.Keep;
import com.qiahao.base_common.service.BaseService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/qiahao/base_common/AllModuleServiceManager;", "", "<init>", "()V", "mAppService", "Lcom/qiahao/base_common/service/BaseService;", "getMAppService", "()Lcom/qiahao/base_common/service/BaseService;", "setMAppService", "(Lcom/qiahao/base_common/service/BaseService;)V", "getAppService", "setAppService", "", "baseService", "Companion", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class AllModuleServiceManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Keep
    @Nullable
    private static AllModuleServiceManager instance;

    @Nullable
    private BaseService mAppService;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00048B@\u0002X\u0083\u000e¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/qiahao/base_common/AllModuleServiceManager$Companion;", "", "<init>", "()V", "Lcom/qiahao/base_common/AllModuleServiceManager;", "get", "()Lcom/qiahao/base_common/AllModuleServiceManager;", "instance", "Lcom/qiahao/base_common/AllModuleServiceManager;", "a", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final AllModuleServiceManager a() {
            if (AllModuleServiceManager.instance == null) {
                AllModuleServiceManager.instance = new AllModuleServiceManager(null);
            }
            return AllModuleServiceManager.instance;
        }

        @Keep
        @NotNull
        public final synchronized AllModuleServiceManager get() {
            AllModuleServiceManager a10;
            a10 = a();
            Intrinsics.checkNotNull(a10);
            return a10;
        }

        private Companion() {
        }
    }

    public /* synthetic */ AllModuleServiceManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Nullable
    /* renamed from: getAppService, reason: from getter */
    public final BaseService getMAppService() {
        return this.mAppService;
    }

    @Nullable
    public final BaseService getMAppService() {
        return this.mAppService;
    }

    public final void setAppService(@NotNull BaseService baseService) {
        Intrinsics.checkNotNullParameter(baseService, "baseService");
        this.mAppService = baseService;
    }

    public final void setMAppService(@Nullable BaseService baseService) {
        this.mAppService = baseService;
    }

    private AllModuleServiceManager() {
    }
}
