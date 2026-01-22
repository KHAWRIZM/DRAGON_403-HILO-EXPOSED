package com.qiahao.nextvideo.ui.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.qiahao.nextvideo.HiloApplication;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.MainActivity;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.utilities.ActivityUtilKt;
import kotlin.Metadata;
import q6.c;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\t\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/ui/splash/SplashActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseActivity;", "<init>", "()V", "getLayoutResId", "", "onInitialize", "", "onResume", "onBackPressed", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SplashActivity extends HiloBaseActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_splash;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onBackPressed() {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.setFlags(268435456);
        startActivity(intent);
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        HiloApplication.INSTANCE.setRestartFlag(0);
        setShowGiftTip(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onResume() {
        super.onResume();
        ActivityUtilKt.setSystemBarsVisibility(this, false, false);
        if (Build.VERSION.SDK_INT >= 28) {
            c.a(getWindow().getAttributes(), 1);
        }
        startActivity(new Intent((Context) this, (Class<?>) MainActivity.class));
        finish();
    }
}
