package com.qiahao.nextvideo.ui.login;

import android.content.Context;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Checkable;
import android.widget.TextView;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.utils.language.LanguageHelper;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.ViewVerifyDialogBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\rH\u0016R7\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/qiahao/nextvideo/ui/login/VerifyDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/ViewVerifyDialogBinding;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "listener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "str", "", "getListener", "()Lkotlin/jvm/functions/Function1;", "setListener", "(Lkotlin/jvm/functions/Function1;)V", "getLayoutResId", "", "onInitialize", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nVerifyDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VerifyDialog.kt\ncom/qiahao/nextvideo/ui/login/VerifyDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,68:1\n61#2,9:69\n*S KotlinDebug\n*F\n+ 1 VerifyDialog.kt\ncom/qiahao/nextvideo/ui/login/VerifyDialog\n*L\n47#1:69,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class VerifyDialog extends BaseBindingDialog<ViewVerifyDialogBinding> {

    @Nullable
    private Function1<? super String, Unit> listener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerifyDialog(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$0(VerifyDialog verifyDialog, String str) {
        Intrinsics.checkNotNullParameter(str, "data");
        Function1<? super String, Unit> function1 = verifyDialog.listener;
        if (function1 != null) {
            function1.invoke(str);
        }
        verifyDialog.dismiss();
        return Unit.INSTANCE;
    }

    protected int getLayoutResId() {
        return R.layout.view_verify_dialog;
    }

    @Nullable
    public final Function1<String, Unit> getListener() {
        return this.listener;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        WebView webView = ((ViewVerifyDialogBinding) getBinding()).webView;
        Intrinsics.checkNotNullExpressionValue(webView, "webView");
        VerifyJsInterface verifyJsInterface = new VerifyJsInterface(context, webView, new Function1() { // from class: com.qiahao.nextvideo.ui.login.q0
            public final Object invoke(Object obj) {
                Unit onInitialize$lambda$0;
                onInitialize$lambda$0 = VerifyDialog.onInitialize$lambda$0(VerifyDialog.this, (String) obj);
                return onInitialize$lambda$0;
            }
        });
        WebView webView2 = ((ViewVerifyDialogBinding) getBinding()).webView;
        WebSettings settings = webView2.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(true);
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        webView2.addJavascriptInterface(verifyJsInterface, "androidJsObject");
        ((ViewVerifyDialogBinding) getBinding()).webView.loadUrl("file:android_asset/sms_verify/verify.html?language=" + LanguageHelper.INSTANCE.getSystemLanguage().getLanguage());
        final TextView textView = ((ViewVerifyDialogBinding) getBinding()).cancel;
        final long j = 800;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.login.VerifyDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
    }

    public final void setListener(@Nullable Function1<? super String, Unit> function1) {
        this.listener = function1;
    }
}
