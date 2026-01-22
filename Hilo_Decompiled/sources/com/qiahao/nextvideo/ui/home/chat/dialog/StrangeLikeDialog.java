package com.qiahao.nextvideo.ui.home.chat.dialog;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.databinding.DialogStrangeLikeBinding;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0015H\u0014J\b\u0010\u0016\u001a\u00020\rH\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/chat/dialog/StrangeLikeDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogStrangeLikeBinding;", "context", "Landroid/content/Context;", "otherUser", "Lcom/qiahao/base_common/model/common/User;", "<init>", "(Landroid/content/Context;Lcom/qiahao/base_common/model/common/User;)V", "getOtherUser", "()Lcom/qiahao/base_common/model/common/User;", "mListener", "Lkotlin/Function0;", "", "getMListener", "()Lkotlin/jvm/functions/Function0;", "setMListener", "(Lkotlin/jvm/functions/Function0;)V", "getLayoutResId", "", "isNeedFullScreen", "", "onInitialize", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nStrangeLikeDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StrangeLikeDialog.kt\ncom/qiahao/nextvideo/ui/home/chat/dialog/StrangeLikeDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,51:1\n61#2,9:52\n61#2,9:61\n61#2,9:70\n61#2,9:79\n*S KotlinDebug\n*F\n+ 1 StrangeLikeDialog.kt\ncom/qiahao/nextvideo/ui/home/chat/dialog/StrangeLikeDialog\n*L\n37#1:52,9\n40#1:61,9\n43#1:70,9\n46#1:79,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class StrangeLikeDialog extends BaseBindingDialog<DialogStrangeLikeBinding> {

    @Nullable
    private Function0<Unit> mListener;

    @Nullable
    private final User otherUser;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StrangeLikeDialog(@NotNull Context context, @Nullable User user) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.otherUser = user;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_strange_like;
    }

    @Nullable
    public final Function0<Unit> getMListener() {
        return this.mListener;
    }

    @Nullable
    public final User getOtherUser() {
        return this.otherUser;
    }

    protected boolean isNeedFullScreen() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onInitialize() {
        String str;
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        QMUIRadiusImageView qMUIRadiusImageView = ((DialogStrangeLikeBinding) getBinding()).leftAvatar;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "leftAvatar");
        User user = this.otherUser;
        String str2 = null;
        if (user != null) {
            str = user.getAvatar();
        } else {
            str = null;
        }
        ImageKtxKt.loadImage$default(qMUIRadiusImageView, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
        QMUIRadiusImageView qMUIRadiusImageView2 = ((DialogStrangeLikeBinding) getBinding()).rightAvatar;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView2, "rightAvatar");
        User user2 = UserStore.INSTANCE.getShared().getUser();
        if (user2 != null) {
            str2 = user2.getAvatar();
        }
        ImageKtxKt.loadImage$default(qMUIRadiusImageView2, str2, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
        ConstraintLayout constraintLayout = ((DialogStrangeLikeBinding) getBinding()).constraint;
        ShapeUtil shapeUtil = ShapeUtil.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        constraintLayout.setBackground(ShapeUtil.createShape$default(shapeUtil, context, 2131101214, 2131101214, 15, (GradientDrawable.Orientation) null, false, 48, (Object) null));
        ((DialogStrangeLikeBinding) getBinding()).like.setBackground(shapeUtil.createShape("#FF8D81", "#FF4977", 25, GradientDrawable.Orientation.TOP_BOTTOM));
        final TextView textView = ((DialogStrangeLikeBinding) getBinding()).like;
        final long j = 800;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.dialog.StrangeLikeDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    Function0<Unit> mListener = this.getMListener();
                    if (mListener != null) {
                        mListener.invoke();
                    }
                }
            }
        });
        final ImageView imageView = ((DialogStrangeLikeBinding) getBinding()).close;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.dialog.StrangeLikeDialog$onInitialize$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
        final FrameLayout frameLayout = ((DialogStrangeLikeBinding) getBinding()).frameLayout;
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.dialog.StrangeLikeDialog$onInitialize$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(frameLayout) > j || (frameLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(frameLayout, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
        final ConstraintLayout constraintLayout2 = ((DialogStrangeLikeBinding) getBinding()).constraint;
        constraintLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.dialog.StrangeLikeDialog$onInitialize$$inlined$singleClick$default$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout2) > j || (constraintLayout2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(constraintLayout2, currentTimeMillis);
                    ConstraintLayout constraintLayout3 = constraintLayout2;
                }
            }
        });
    }

    public final void setMListener(@Nullable Function0<Unit> function0) {
        this.mListener = function0;
    }

    public /* synthetic */ StrangeLikeDialog(Context context, User user, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : user);
    }
}
