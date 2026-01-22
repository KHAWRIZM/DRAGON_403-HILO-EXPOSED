package com.qiahao.nextvideo.utilities.animation;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import c5.g;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.databinding.ViewGiftNoticeBinding;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView2;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o4.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u001aB\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\f\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0011\u001a\u000e0\u0010R\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/qiahao/nextvideo/utilities/animation/GiftDispatcher;", "Lcom/qiahao/nextvideo/utilities/animation/a;", "Lcom/qiahao/nextvideo/utilities/animation/GiftNoticeUIModel;", "Landroid/content/Context;", "context", "", "sumNumber", "<init>", "(Landroid/content/Context;I)V", "oldObj", "newObj", "", "isSameView", "(Lcom/qiahao/nextvideo/utilities/animation/GiftNoticeUIModel;Lcom/qiahao/nextvideo/utilities/animation/GiftNoticeUIModel;)Z", "Landroid/view/ViewGroup;", "viewGroup", "Lcom/qiahao/nextvideo/utilities/animation/a$b;", "createViewHolder", "(Landroid/view/ViewGroup;)Lcom/qiahao/nextvideo/utilities/animation/a$b;", "", "comboCount", "J", "getComboCount", "()J", "setComboCount", "(J)V", "GiftDispatcherViewHolder", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GiftDispatcher extends a {
    private long comboCount;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0080\u0004\u0018\u00002\u000e0\u0001R\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/utilities/animation/GiftDispatcher$GiftDispatcherViewHolder;", "Lcom/qiahao/nextvideo/utilities/animation/a$b;", "Lcom/qiahao/nextvideo/utilities/animation/a;", "Lcom/qiahao/nextvideo/utilities/animation/GiftNoticeUIModel;", "Lcom/qiahao/nextvideo/databinding/ViewGiftNoticeBinding;", "binding", "<init>", "(Lcom/qiahao/nextvideo/utilities/animation/GiftDispatcher;Lcom/qiahao/nextvideo/databinding/ViewGiftNoticeBinding;)V", "uiModel", "", "isSame", "", "bindView", "(Lcom/qiahao/nextvideo/utilities/animation/GiftNoticeUIModel;Z)V", "Lcom/qiahao/nextvideo/databinding/ViewGiftNoticeBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/ViewGiftNoticeBinding;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public final class GiftDispatcherViewHolder extends com.qiahao.nextvideo.utilities.animation.a.b {

        @NotNull
        private final ViewGiftNoticeBinding binding;
        final /* synthetic */ GiftDispatcher this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GiftDispatcherViewHolder(@NotNull GiftDispatcher giftDispatcher, ViewGiftNoticeBinding viewGiftNoticeBinding) {
            super(viewGiftNoticeBinding.getRoot());
            Intrinsics.checkNotNullParameter(viewGiftNoticeBinding, "binding");
            this.this$0 = giftDispatcher;
            this.binding = viewGiftNoticeBinding;
        }

        @NotNull
        public final ViewGiftNoticeBinding getBinding() {
            return this.binding;
        }

        public void bindView(@Nullable GiftNoticeUIModel uiModel, boolean isSame) {
            StringBuilder sb2;
            if (uiModel != null) {
                GiftDispatcher giftDispatcher = this.this$0;
                if (isSame) {
                    giftDispatcher.setComboCount(giftDispatcher.getComboCount() + uiModel.getCount());
                    uiModel.setCount(giftDispatcher.getComboCount());
                    AnimationUtility animationUtility = AnimationUtility.INSTANCE;
                    AppCompatTextView appCompatTextView = this.binding.comboGiftCountTipTextView;
                    Intrinsics.checkNotNullExpressionValue(appCompatTextView, "comboGiftCountTipTextView");
                    animationUtility.giftCombo(appCompatTextView);
                } else {
                    giftDispatcher.setComboCount(uiModel.getCount());
                    uiModel.setCount(giftDispatcher.getComboCount());
                    AnimationUtility animationUtility2 = AnimationUtility.INSTANCE;
                    View view = this.itemView;
                    Intrinsics.checkNotNullExpressionValue(view, "itemView");
                    animationUtility2.giftBannerTransfer(view);
                }
                if (uiModel.isMystery()) {
                    QMUIRadiusImageView2 qMUIRadiusImageView2 = this.binding.circleImageView;
                    Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView2, "circleImageView");
                    ImageKtxKt.loadImage$default(qMUIRadiusImageView2, (String) null, (Uri) null, (File) null, 2131232937, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
                } else {
                    QMUIRadiusImageView2 qMUIRadiusImageView22 = this.binding.circleImageView;
                    Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView22, "circleImageView");
                    ImageKtxKt.loadImage$default(qMUIRadiusImageView22, uiModel.getSenderPicture(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (g) null, 49150, (Object) null);
                }
                AppCompatImageView appCompatImageView = this.binding.giftIconImageView;
                Intrinsics.checkNotNullExpressionValue(appCompatImageView, "giftIconImageView");
                ImageKtxKt.loadImage$default(appCompatImageView, uiModel.getGiftIcon(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232497, (g) null, 49150, (Object) null);
                AppCompatTextView appCompatTextView2 = this.binding.comboGiftCountTipTextView;
                if (ViewUtilitiesKt.getRightToLeftDirection()) {
                    long count = uiModel.getCount();
                    sb2 = new StringBuilder();
                    sb2.append(count);
                    sb2.append(" x");
                } else {
                    long count2 = uiModel.getCount();
                    sb2 = new StringBuilder();
                    sb2.append("x ");
                    sb2.append(count2);
                }
                appCompatTextView2.setText(sb2.toString());
                this.binding.fromNicknameTextView.setText(uiModel.getFromNickname());
                this.binding.toNicknameTextView.setText(uiModel.getToNickname());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GiftDispatcher(@NotNull Context context, int i) {
        super(context, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.comboCount = 1L;
    }

    @Override // com.qiahao.nextvideo.utilities.animation.a
    @NotNull
    public com.qiahao.nextvideo.utilities.animation.a.b createViewHolder(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        ViewGiftNoticeBinding inflate = ViewGiftNoticeBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new GiftDispatcherViewHolder(this, inflate);
    }

    public final long getComboCount() {
        return this.comboCount;
    }

    public final void setComboCount(long j) {
        this.comboCount = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.utilities.animation.a
    public boolean isSameView(@Nullable GiftNoticeUIModel oldObj, @Nullable GiftNoticeUIModel newObj) {
        return Intrinsics.areEqual(oldObj != null ? Long.valueOf(oldObj.getId()) : null, newObj != null ? Long.valueOf(newObj.getId()) : null);
    }
}
