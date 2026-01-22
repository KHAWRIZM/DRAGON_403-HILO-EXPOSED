package com.qiahao.nextvideo.ui.reusable.viewcontroller.controller;

import android.view.View;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.taobao.accs.common.Constants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import nd.a;
import org.jetbrains.annotations.NotNull;

@Deprecated(message = "")
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000b\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0003R\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/ViewController;", "<init>", "()V", "Landroid/view/View;", "view", "", "viewWillUnload", "(Landroid/view/View;)V", "", Constants.SHARED_MESSAGE_ID_FILE, "showProgressDialog", "(Ljava/lang/String;)V", "", "messageRes", "(I)V", "dismissProgressDialog", "Lnd/a;", "compositeDisposable", "Lnd/a;", "getCompositeDisposable", "()Lnd/a;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class BaseViewController extends ViewController {

    @NotNull
    private final a compositeDisposable = new a();

    public final void dismissProgressDialog() {
        HiloBaseActivity hiloBaseActivity = get_activity();
        if (hiloBaseActivity != null) {
            HiloBaseActivity.dismissProgressDialog$default(hiloBaseActivity, false, null, 3, null);
        }
    }

    @NotNull
    public final a getCompositeDisposable() {
        return this.compositeDisposable;
    }

    public final void showProgressDialog(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, Constants.SHARED_MESSAGE_ID_FILE);
        HiloBaseActivity hiloBaseActivity = get_activity();
        if (hiloBaseActivity != null) {
            HiloBaseActivity.showProgressDialog$default(hiloBaseActivity, message, false, (Function0) null, 6, (Object) null);
        }
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public void viewWillUnload(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.viewWillUnload(view);
        this.compositeDisposable.d();
    }

    public final void showProgressDialog(int messageRes) {
        HiloBaseActivity hiloBaseActivity = get_activity();
        if (hiloBaseActivity != null) {
            HiloBaseActivity.showProgressDialog$default(hiloBaseActivity, messageRes, false, (Function0) null, 6, (Object) null);
        }
    }
}
