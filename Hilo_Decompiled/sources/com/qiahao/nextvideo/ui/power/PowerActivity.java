package com.qiahao.nextvideo.ui.power;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u00012\u00020\u0002:\u0001\u0010B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\fH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/ui/power/PowerActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseActivity;", "Lcom/qiahao/nextvideo/ui/power/PowerDetailListener;", "<init>", "()V", "mPowerId", "", "getMPowerId", "()J", "setMPowerId", "(J)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "callBack", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PowerActivity extends HiloBaseActivity implements PowerDetailListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private long mPowerId;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/ui/power/PowerActivity$Companion;", "", "<init>", "()V", "start", "", "context", "Landroid/content/Context;", "powerId", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void start(@NotNull Context context, long powerId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) PowerActivity.class);
            intent.putExtra("power_id", powerId);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    @JvmStatic
    public static final void start(@NotNull Context context, long j) {
        INSTANCE.start(context, j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.ui.power.PowerDetailListener
    public void callBack() {
        finish();
    }

    public final long getMPowerId() {
        return this.mPowerId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        long longExtra = getIntent().getLongExtra("power_id", 0L);
        this.mPowerId = longExtra;
        if (longExtra == 0) {
            return;
        }
        PowerDetailViewController powerDetailViewController = new PowerDetailViewController(this.mPowerId, true);
        powerDetailViewController.setDelegate(this);
        getControllerWindowNotNull().setRootViewController(powerDetailViewController);
    }

    public final void setMPowerId(long j) {
        this.mPowerId = j;
    }
}
