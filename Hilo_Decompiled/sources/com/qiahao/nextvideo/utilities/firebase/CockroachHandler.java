package com.qiahao.nextvideo.utilities.firebase;

import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.oudi.core.support.ActivityLifecycleManager;
import com.oudi.utils.log.LogUtil;
import com.qiahao.base_common.utils.HiloToasty;
import com.wanjian.cockroach.ExceptionHandler;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\u000b\u001a\u00020\u0005H\u0014J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0014J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002¨\u0006\u000f"}, d2 = {"Lcom/qiahao/nextvideo/utilities/firebase/CockroachHandler;", "Lcom/wanjian/cockroach/ExceptionHandler;", "<init>", "()V", "onUncaughtExceptionHappened", "", "thread", "Ljava/lang/Thread;", "throwable", "", "onBandageExceptionHappened", "onEnterSafeMode", "onMayBeBlackScreen", "e", "uploadLoad", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CockroachHandler extends ExceptionHandler {
    private static final void onBandageExceptionHappened$lambda$2(Throwable th) {
        String message;
        if (th != null && (message = th.getMessage()) != null) {
            HiloToasty.Companion.normal$default(HiloToasty.Companion, ActivityLifecycleManager.INSTANCE.currentActivity(), message, false, 4, (Object) null);
            LogUtil.e$default(LogUtil.INSTANCE, "eTag", "全局捕获到的异常" + message, false, 4, (Object) null);
        }
    }

    private static final void onUncaughtExceptionHappened$lambda$0(Throwable th) {
        String str;
        HiloToasty.Companion.normal$default(HiloToasty.Companion, ActivityLifecycleManager.INSTANCE.currentActivity(), "捕获到导致崩溃的异常", false, 4, (Object) null);
        LogUtil logUtil = LogUtil.INSTANCE;
        if (th == null || (str = th.getMessage()) == null) {
            str = "";
        }
        LogUtil.e$default(logUtil, "eTag", "全局捕获到的异常" + str, false, 4, (Object) null);
    }

    private final void uploadLoad(Throwable throwable) {
        if (throwable != null) {
            FirebaseCrashlytics.getInstance().recordException(throwable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.wanjian.cockroach.ExceptionHandler
    public void onBandageExceptionHappened(@Nullable Throwable throwable) {
        try {
            uploadLoad(throwable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.wanjian.cockroach.ExceptionHandler
    public void onEnterSafeMode() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.wanjian.cockroach.ExceptionHandler
    public void onMayBeBlackScreen(@Nullable Throwable e) {
        super.onMayBeBlackScreen(e);
        try {
            uploadLoad(e);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.wanjian.cockroach.ExceptionHandler
    public void onUncaughtExceptionHappened(@Nullable Thread thread, @Nullable Throwable throwable) {
        try {
            uploadLoad(throwable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
