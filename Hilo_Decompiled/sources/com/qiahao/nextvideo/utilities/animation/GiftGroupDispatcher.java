package com.qiahao.nextvideo.utilities.animation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import c5.g;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.ViewGiftNoticeBinding;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.animation.GiftGroupDispatcher;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView2;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o4.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00162\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0002\u0016\u0017B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\f\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0011\u001a\u000e0\u0010R\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/qiahao/nextvideo/utilities/animation/GiftGroupDispatcher;", "Lcom/qiahao/nextvideo/utilities/animation/a;", "Lcom/qiahao/nextvideo/utilities/animation/GiftNoticeUIModel;", "Landroid/content/Context;", "mContext", "", "sumNumber", "<init>", "(Landroid/content/Context;I)V", "oldObj", "newObj", "", "isSameView", "(Lcom/qiahao/nextvideo/utilities/animation/GiftNoticeUIModel;Lcom/qiahao/nextvideo/utilities/animation/GiftNoticeUIModel;)Z", "Landroid/view/ViewGroup;", "viewGroup", "Lcom/qiahao/nextvideo/utilities/animation/a$b;", "createViewHolder", "(Landroid/view/ViewGroup;)Lcom/qiahao/nextvideo/utilities/animation/a$b;", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "Companion", "GiftDispatcherViewHolder", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GiftGroupDispatcher extends a {

    @NotNull
    private static final String TAG = "GiftGroupDispatcher";

    @NotNull
    private final Context mContext;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0080\u0004\u0018\u00002\u000e0\u0001R\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/qiahao/nextvideo/utilities/animation/GiftGroupDispatcher$GiftDispatcherViewHolder;", "Lcom/qiahao/nextvideo/utilities/animation/a$b;", "Lcom/qiahao/nextvideo/utilities/animation/a;", "Lcom/qiahao/nextvideo/utilities/animation/GiftNoticeUIModel;", "Lcom/qiahao/nextvideo/databinding/ViewGiftNoticeBinding;", "binding", "<init>", "(Lcom/qiahao/nextvideo/utilities/animation/GiftGroupDispatcher;Lcom/qiahao/nextvideo/databinding/ViewGiftNoticeBinding;)V", "uiModel", "", "isSame", "", "bindView", "(Lcom/qiahao/nextvideo/utilities/animation/GiftNoticeUIModel;Z)V", "Lcom/qiahao/nextvideo/databinding/ViewGiftNoticeBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/ViewGiftNoticeBinding;", "isRefresh", "Z", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public final class GiftDispatcherViewHolder extends com.qiahao.nextvideo.utilities.animation.a.b {

        @NotNull
        private final ViewGiftNoticeBinding binding;
        private boolean isRefresh;
        final /* synthetic */ GiftGroupDispatcher this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GiftDispatcherViewHolder(@NotNull GiftGroupDispatcher giftGroupDispatcher, ViewGiftNoticeBinding viewGiftNoticeBinding) {
            super(viewGiftNoticeBinding.getRoot());
            Intrinsics.checkNotNullParameter(viewGiftNoticeBinding, "binding");
            this.this$0 = giftGroupDispatcher;
            this.binding = viewGiftNoticeBinding;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bindView$lambda$2$lambda$1(GiftDispatcherViewHolder giftDispatcherViewHolder, GiftNoticeUIModel giftNoticeUIModel) {
            StringBuilder sb2;
            AppCompatTextView appCompatTextView = giftDispatcherViewHolder.binding.comboGiftCountTipTextView;
            AnimationUtility animationUtility = AnimationUtility.INSTANCE;
            Intrinsics.checkNotNull(appCompatTextView);
            animationUtility.giftCombo(appCompatTextView);
            if (ViewUtilitiesKt.getRightToLeftDirection()) {
                long count = giftNoticeUIModel.getCount();
                sb2 = new StringBuilder();
                sb2.append(count);
                sb2.append(" x");
            } else {
                long count2 = giftNoticeUIModel.getCount();
                sb2 = new StringBuilder();
                sb2.append("x ");
                sb2.append(count2);
            }
            appCompatTextView.setText(sb2.toString());
            giftDispatcherViewHolder.isRefresh = false;
        }

        @NotNull
        public final ViewGiftNoticeBinding getBinding() {
            return this.binding;
        }

        public void bindView(@Nullable final GiftNoticeUIModel uiModel, boolean isSame) {
            StringBuilder sb2;
            Log.d(GiftGroupDispatcher.TAG, "isSameView: " + (uiModel != null ? uiModel.hashCode() : 0) + " 礼物的数值新 " + (uiModel != null ? Long.valueOf(uiModel.getCount()) : null));
            if (uiModel != null) {
                GiftGroupDispatcher giftGroupDispatcher = this.this$0;
                if (isSame) {
                    if (this.isRefresh) {
                        return;
                    }
                    this.isRefresh = true;
                    this.binding.comboGiftCountTipTextView.postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.utilities.animation.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            GiftGroupDispatcher.GiftDispatcherViewHolder.bindView$lambda$2$lambda$1(GiftGroupDispatcher.GiftDispatcherViewHolder.this, uiModel);
                        }
                    }, 200L);
                } else {
                    AnimationUtility animationUtility = AnimationUtility.INSTANCE;
                    View view = this.itemView;
                    Intrinsics.checkNotNullExpressionValue(view, "itemView");
                    animationUtility.giftBannerTransfer(view);
                    QMUIRadiusImageView2 qMUIRadiusImageView2 = this.binding.circleImageView;
                    Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView2, "circleImageView");
                    ImageKtxKt.loadImage$default(qMUIRadiusImageView2, uiModel.getSenderPicture(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (g) null, 49150, (Object) null);
                    AppCompatImageView appCompatImageView = this.binding.giftIconImageView;
                    Intrinsics.checkNotNullExpressionValue(appCompatImageView, "giftIconImageView");
                    ImageKtxKt.loadImage$default(appCompatImageView, uiModel.getGiftIcon(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232497, (g) null, 49150, (Object) null);
                    AppCompatTextView appCompatTextView = this.binding.comboGiftCountTipTextView;
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
                    appCompatTextView.setText(sb2.toString());
                    this.binding.fromNicknameTextView.setText(DataExternalKt.maxLengthSuffix(uiModel.getFromNickname(), 8, "..."));
                    this.binding.toNicknameTextView.setText(DataExternalKt.maxLengthSuffix(uiModel.getToNickname(), 8, "..."));
                    this.isRefresh = false;
                }
                if (uiModel.getNobleLevel() == 7) {
                    this.binding.fromNicknameTextView.setTextColor(Color.parseColor("#ffff00"));
                    this.binding.toNicknameTextView.setTextColor(Color.parseColor("#ffff00"));
                    this.binding.send.setTextColor(Color.parseColor("#ffffff"));
                    this.binding.bg.setImageDrawable(androidx.core.content.a.getDrawable(giftGroupDispatcher.getContext(), R.drawable.bg_gift_noble7));
                } else if (uiModel.getNobleLevel() == 8) {
                    this.binding.fromNicknameTextView.setTextColor(Color.parseColor("#ffff00"));
                    this.binding.toNicknameTextView.setTextColor(Color.parseColor("#ffff00"));
                    this.binding.send.setTextColor(Color.parseColor("#ffffff"));
                    this.binding.bg.setImageDrawable(androidx.core.content.a.getDrawable(giftGroupDispatcher.getContext(), R.drawable.bg_gift_noble8));
                } else if (uiModel.getNobleLevel() >= 9) {
                    this.binding.fromNicknameTextView.setTextColor(Color.parseColor("#ffff00"));
                    this.binding.toNicknameTextView.setTextColor(Color.parseColor("#ffff00"));
                    this.binding.send.setTextColor(Color.parseColor("#ffffff"));
                    this.binding.bg.setImageDrawable(androidx.core.content.a.getDrawable(giftGroupDispatcher.getContext(), R.drawable.bg_gift_noble9));
                } else {
                    this.binding.fromNicknameTextView.setTextColor(Color.parseColor("#ffffff"));
                    this.binding.toNicknameTextView.setTextColor(Color.parseColor("#ffffff"));
                    this.binding.send.setTextColor(Color.parseColor("#ffca22"));
                    this.binding.bg.setImageDrawable(androidx.core.content.a.getDrawable(giftGroupDispatcher.getContext(), R.drawable.bg_gift_notice));
                }
                if (uiModel.isMystery()) {
                    QMUIRadiusImageView2 qMUIRadiusImageView22 = this.binding.circleImageView;
                    Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView22, "circleImageView");
                    ImageKtxKt.loadImage$default(qMUIRadiusImageView22, (String) null, (Uri) null, (File) null, 2131232937, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
                } else {
                    QMUIRadiusImageView2 qMUIRadiusImageView23 = this.binding.circleImageView;
                    Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView23, "circleImageView");
                    ImageKtxKt.loadImage$default(qMUIRadiusImageView23, uiModel.getSenderPicture(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (g) null, 49150, (Object) null);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GiftGroupDispatcher(@NotNull Context context, int i) {
        super(context, i);
        Intrinsics.checkNotNullParameter(context, "mContext");
        this.mContext = context;
    }

    @Override // com.qiahao.nextvideo.utilities.animation.a
    @NotNull
    public com.qiahao.nextvideo.utilities.animation.a.b createViewHolder(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        ViewGiftNoticeBinding inflate = ViewGiftNoticeBinding.inflate(LayoutInflater.from(this.mContext), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new GiftDispatcherViewHolder(this, inflate);
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.utilities.animation.a
    public boolean isSameView(@Nullable GiftNoticeUIModel oldObj, @Nullable GiftNoticeUIModel newObj) {
        if (!Intrinsics.areEqual(oldObj != null ? Long.valueOf(oldObj.getId()) : null, newObj != null ? Long.valueOf(newObj.getId()) : null)) {
            return false;
        }
        if (!Intrinsics.areEqual(oldObj != null ? oldObj.getFromNickname() : null, newObj != null ? newObj.getFromNickname() : null)) {
            return false;
        }
        if (!Intrinsics.areEqual(oldObj != null ? oldObj.getToNickname() : null, newObj != null ? newObj.getToNickname() : null)) {
            return false;
        }
        long count = oldObj != null ? oldObj.getCount() : 0L;
        long count2 = newObj != null ? newObj.getCount() : 0L;
        if (newObj == null) {
            return true;
        }
        newObj.setCount(count + count2);
        return true;
    }
}
