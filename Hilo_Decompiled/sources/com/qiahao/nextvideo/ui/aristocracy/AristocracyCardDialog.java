package com.qiahao.nextvideo.ui.aristocracy;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.noble.NobleUse;
import com.qiahao.nextvideo.databinding.DialogAristocracyCardBinding;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/ui/aristocracy/AristocracyCardDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogAristocracyCardBinding;", "context", "Landroid/content/Context;", "mData", "Lcom/qiahao/nextvideo/data/noble/NobleUse;", "<init>", "(Landroid/content/Context;Lcom/qiahao/nextvideo/data/noble/NobleUse;)V", "getMData", "()Lcom/qiahao/nextvideo/data/noble/NobleUse;", "getLayoutResId", "", "isNeedFullScreen", "", "onInitialize", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAristocracyCardDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AristocracyCardDialog.kt\ncom/qiahao/nextvideo/ui/aristocracy/AristocracyCardDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,43:1\n61#2,9:44\n*S KotlinDebug\n*F\n+ 1 AristocracyCardDialog.kt\ncom/qiahao/nextvideo/ui/aristocracy/AristocracyCardDialog\n*L\n32#1:44,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AristocracyCardDialog extends BaseBindingDialog<DialogAristocracyCardBinding> {

    @Nullable
    private final NobleUse mData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AristocracyCardDialog(@NotNull Context context, @Nullable NobleUse nobleUse) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mData = nobleUse;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_aristocracy_card;
    }

    @Nullable
    public final NobleUse getMData() {
        return this.mData;
    }

    protected boolean isNeedFullScreen() {
        return true;
    }

    public void onInitialize() {
        String str;
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        ((DialogAristocracyCardBinding) getBinding()).ok.setEnabled(true);
        setBackgroundDrawableColor(Color.parseColor("#e5000000"));
        final TextView textView = ((DialogAristocracyCardBinding) getBinding()).ok;
        final long j = 800;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.aristocracy.AristocracyCardDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
        QMUIRadiusImageView qMUIRadiusImageView = ((DialogAristocracyCardBinding) getBinding()).avatar;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "avatar");
        UserStore.Companion companion = UserStore.INSTANCE;
        User user = companion.getShared().getUser();
        String str2 = null;
        if (user != null) {
            str = user.getAvatar();
        } else {
            str = null;
        }
        ImageKtxKt.loadImage$default(qMUIRadiusImageView, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
        TextView textView2 = ((DialogAristocracyCardBinding) getBinding()).name;
        User user2 = companion.getShared().getUser();
        if (user2 != null) {
            str2 = user2.getNick();
        }
        textView2.setText(str2);
        NobleUse nobleUse = this.mData;
        if (nobleUse != null) {
            ImageView imageView = ((DialogAristocracyCardBinding) getBinding()).image;
            Intrinsics.checkNotNullExpressionValue(imageView, "image");
            ImageKtxKt.loadImage$default(imageView, nobleUse.getImg(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            ((DialogAristocracyCardBinding) getBinding()).content.setText(nobleUse.getMsg());
        }
    }

    public /* synthetic */ AristocracyCardDialog(Context context, NobleUse nobleUse, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : nobleUse);
    }
}
