package com.qiahao.nextvideo.ui.upload;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogUploadBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u0014\u001a\u00020\u000bH\u0002J\b\u0010\u0015\u001a\u00020\u000bH\u0002J\u000e\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/qiahao/nextvideo/ui/upload/UploadDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "mCurrentContext", "Landroid/content/Context;", "theme", "", "<init>", "(Landroid/content/Context;I)V", "getMCurrentContext", "()Landroid/content/Context;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "binding", "Lcom/qiahao/nextvideo/databinding/DialogUploadBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/DialogUploadBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/DialogUploadBinding;)V", "initDataBinding", "initStyle", "transferToGooglePlay", "context", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class UploadDialog extends AppCompatDialog {
    public DialogUploadBinding binding;

    @NotNull
    private final Context mCurrentContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadDialog(@NotNull Context context, int i) {
        super(context, i);
        Intrinsics.checkNotNullParameter(context, "mCurrentContext");
        this.mCurrentContext = context;
    }

    private final void initDataBinding() {
        setBinding(DialogUploadBinding.inflate(LayoutInflater.from(this.mCurrentContext), null, false));
        setContentView(getBinding().getRoot());
        getBinding().goToGoogle.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.upload.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UploadDialog.initDataBinding$lambda$0(UploadDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initDataBinding$lambda$0(UploadDialog uploadDialog, View view) {
        uploadDialog.transferToGooglePlay(uploadDialog.mCurrentContext);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initStyle() {
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        window.setDimAmount(0.0f);
        Object systemService = getContext().getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(new DisplayMetrics());
        Window window2 = getWindow();
        Intrinsics.checkNotNull(window2);
        WindowManager.LayoutParams attributes = window2.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        attributes.horizontalMargin = 0.0f;
        Window window3 = getWindow();
        Intrinsics.checkNotNull(window3);
        window3.setAttributes(attributes);
        Window window4 = getWindow();
        Intrinsics.checkNotNull(window4);
        window4.getDecorView().setPadding(0, 0, 0, 0);
    }

    @NotNull
    public final DialogUploadBinding getBinding() {
        DialogUploadBinding dialogUploadBinding = this.binding;
        if (dialogUploadBinding != null) {
            return dialogUploadBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    @NotNull
    public final Context getMCurrentContext() {
        return this.mCurrentContext;
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
        initStyle();
    }

    public final void setBinding(@NotNull DialogUploadBinding dialogUploadBinding) {
        Intrinsics.checkNotNullParameter(dialogUploadBinding, "<set-?>");
        this.binding = dialogUploadBinding;
    }

    public final void transferToGooglePlay(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.qiahao.nextvideo"));
            intent.setPackage("com.android.vending");
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Exception unused) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            String string = context.getString(2131952667);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            Toast normal$default = HiloToasty.Companion.normal$default(companion, context, string, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
    }

    public /* synthetic */ UploadDialog(Context context, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? R.style.HiloBottomSheetDialog : i);
    }
}
