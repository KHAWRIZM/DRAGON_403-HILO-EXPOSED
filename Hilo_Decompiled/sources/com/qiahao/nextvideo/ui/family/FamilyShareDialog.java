package com.qiahao.nextvideo.ui.family;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.FamilyInfo;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogFamilyShareBinding;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0017\u001a\u00020\bH\u0014J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/qiahao/nextvideo/ui/family/FamilyShareDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogFamilyShareBinding;", "mContext", "Landroid/content/Context;", "familyInfo", "Lcom/qiahao/base_common/model/common/FamilyInfo;", FamilySettingFragment.FAMILY_NUMBER, "", "<init>", "(Landroid/content/Context;Lcom/qiahao/base_common/model/common/FamilyInfo;I)V", "getMContext", "()Landroid/content/Context;", "getFamilyInfo", "()Lcom/qiahao/base_common/model/common/FamilyInfo;", "getNumber", "()I", "listener", "Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;", "getListener", "()Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;", "setListener", "(Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;)V", "getLayoutResId", "onInitialize", "", "setDialogListener", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFamilyShareDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FamilyShareDialog.kt\ncom/qiahao/nextvideo/ui/family/FamilyShareDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,45:1\n61#2,9:46\n61#2,9:55\n*S KotlinDebug\n*F\n+ 1 FamilyShareDialog.kt\ncom/qiahao/nextvideo/ui/family/FamilyShareDialog\n*L\n31#1:46,9\n35#1:55,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FamilyShareDialog extends BaseBindingDialog<DialogFamilyShareBinding> {

    @NotNull
    private final FamilyInfo familyInfo;

    @Nullable
    private OnCommonDialogListener listener;

    @NotNull
    private final Context mContext;
    private final int number;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FamilyShareDialog(@NotNull Context context, @NotNull FamilyInfo familyInfo, int i) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "mContext");
        Intrinsics.checkNotNullParameter(familyInfo, "familyInfo");
        this.mContext = context;
        this.familyInfo = familyInfo;
        this.number = i;
    }

    @NotNull
    public final FamilyInfo getFamilyInfo() {
        return this.familyInfo;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_family_share;
    }

    @Nullable
    public final OnCommonDialogListener getListener() {
        return this.listener;
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    public final int getNumber() {
        return this.number;
    }

    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        TextView textView = ((DialogFamilyShareBinding) getBinding()).title;
        String format = String.format(ResourcesKtxKt.getStringById(this, 2131952691), Arrays.copyOf(new Object[]{Integer.valueOf(this.number)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView.setText(format);
        QMUIRadiusImageView qMUIRadiusImageView = ((DialogFamilyShareBinding) getBinding()).avatar;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "avatar");
        ImageKtxKt.loadImage$default(qMUIRadiusImageView, this.familyInfo.getIcon(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231930, (c5.g) null, 49150, (Object) null);
        ((DialogFamilyShareBinding) getBinding()).centerLayout.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, this.mContext, 2131099983, 2131099983, 10, (GradientDrawable.Orientation) null, false, 48, (Object) null));
        final TextView textView2 = ((DialogFamilyShareBinding) getBinding()).confirm;
        final long j = 800;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyShareDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView2) > j || (textView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView2, currentTimeMillis);
                    OnCommonDialogListener listener = this.getListener();
                    if (listener != null) {
                        listener.confirm();
                    }
                    this.dismiss();
                }
            }
        });
        final TextView textView3 = ((DialogFamilyShareBinding) getBinding()).cancel;
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyShareDialog$onInitialize$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView3) > j || (textView3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView3, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
    }

    @NotNull
    public final FamilyShareDialog setDialogListener(@NotNull OnCommonDialogListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        return this;
    }

    public final void setListener(@Nullable OnCommonDialogListener onCommonDialogListener) {
        this.listener = onCommonDialogListener;
    }
}
