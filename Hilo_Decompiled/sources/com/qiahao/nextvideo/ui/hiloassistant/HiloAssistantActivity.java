package com.qiahao.nextvideo.ui.hiloassistant;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.Window;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u00012\u00020\u0002:\u0001\u0010B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\fH\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/ui/hiloassistant/HiloAssistantActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseActivity;", "Lcom/qiahao/nextvideo/ui/hiloassistant/HiloAssistantViewControllerDelegate;", "<init>", "()V", "rootViewController", "Lcom/qiahao/nextvideo/ui/hiloassistant/HiloAssistantViewController;", "getRootViewController", "()Lcom/qiahao/nextvideo/ui/hiloassistant/HiloAssistantViewController;", "setRootViewController", "(Lcom/qiahao/nextvideo/ui/hiloassistant/HiloAssistantViewController;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "needFinishActivity", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class HiloAssistantActivity extends HiloBaseActivity implements HiloAssistantViewControllerDelegate {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private HiloAssistantViewController rootViewController;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/qiahao/nextvideo/ui/hiloassistant/HiloAssistantActivity$Companion;", "", "<init>", "()V", "start", "", "context", "Landroid/content/Context;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void start(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, (Class<?>) HiloAssistantActivity.class));
        }

        private Companion() {
        }
    }

    @JvmStatic
    public static final void start(@NotNull Context context) {
        INSTANCE.start(context);
    }

    @Nullable
    public final HiloAssistantViewController getRootViewController() {
        return this.rootViewController;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.ui.hiloassistant.HiloAssistantViewControllerDelegate
    public void needFinishActivity() {
        finish();
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HiloAssistantViewController hiloAssistantViewController = new HiloAssistantViewController();
        hiloAssistantViewController.setMHiloAssistantViewControllerDelegate(this);
        this.rootViewController = hiloAssistantViewController;
        Window controllerWindowNotNull = getControllerWindowNotNull();
        HiloAssistantViewController hiloAssistantViewController2 = this.rootViewController;
        Intrinsics.checkNotNull(hiloAssistantViewController2);
        controllerWindowNotNull.setRootViewController(hiloAssistantViewController2);
    }

    public final void setRootViewController(@Nullable HiloAssistantViewController hiloAssistantViewController) {
        this.rootViewController = hiloAssistantViewController;
    }
}
