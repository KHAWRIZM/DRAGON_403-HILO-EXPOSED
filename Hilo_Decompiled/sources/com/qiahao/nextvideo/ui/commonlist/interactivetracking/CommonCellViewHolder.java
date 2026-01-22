package com.qiahao.nextvideo.ui.commonlist.interactivetracking;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.a;
import androidx.recyclerview.widget.RecyclerView;
import c5.h;
import com.bumptech.glide.Glide;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.common.User;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.CellFansBinding;
import com.qiahao.nextvideo.ui.login.VerificationCodeFragment;
import com.qiahao.nextvideo.ui.matchinghistoric.ProfileDetailUIModel;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.ui.reusable.views.list.ViewHolder;
import com.qiahao.nextvideo.utilities.ResourceUtilsKt;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import pe.b;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\fH\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\rH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/CommonCellViewHolder;", "Lcom/qiahao/nextvideo/ui/reusable/views/list/ViewHolder;", "binding", "Lcom/qiahao/nextvideo/databinding/CellFansBinding;", "<init>", "(Lcom/qiahao/nextvideo/databinding/CellFansBinding;)V", "getBinding", "()Lcom/qiahao/nextvideo/databinding/CellFansBinding;", VerificationCodeFragment.TYPE_BIND, "", "uiModel", "Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/LikeMeCellUIModel;", "Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/ILikeCellUIModel;", "Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/VisitorCellUIModel;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCommonCellViewHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommonCellViewHolder.kt\ncom/qiahao/nextvideo/ui/commonlist/interactivetracking/CommonCellViewHolder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,308:1\n1#2:309\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CommonCellViewHolder extends ViewHolder {

    @NotNull
    public static final String Like = "Like";

    @NotNull
    public static final String VideoCall = "VideoCall";

    @NotNull
    private final CellFansBinding binding;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CommonCellViewHolder(@NotNull CellFansBinding cellFansBinding) {
        super(r0);
        Intrinsics.checkNotNullParameter(cellFansBinding, "binding");
        View root = cellFansBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        this.binding = cellFansBinding;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x018d, code lost:
    
        if (r0.isLike() == true) goto L٥٩;
     */
    /* JADX WARN: Type inference failed for: r6v14, types: [com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView, android.view.View] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void bind(@NotNull LikeMeCellUIModel uiModel) {
        Integer level;
        Integer level2;
        Integer level3;
        Integer level4;
        Intrinsics.checkNotNullParameter(uiModel, "uiModel");
        this.binding.videoCallButton.setTag(VideoCall);
        this.binding.likeCallButton.setTag(Like);
        this.binding.videoCallButton.setVisibility(8);
        this.binding.likeCallButton.setVisibility(8);
        ImageUIModel iconCircleDisplayImageUIModel = uiModel.getIconCircleDisplayImageUIModel();
        if (iconCircleDisplayImageUIModel != null) {
            QMUIRadiusImageView qMUIRadiusImageView = this.binding.iconCircleImageView;
            qMUIRadiusImageView.setVisibility(0);
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "apply(...)");
            ViewUtilitiesKt.bind$default(qMUIRadiusImageView, iconCircleDisplayImageUIModel, null, 2, null);
        }
        Integer titleDrawableStart = uiModel.getTitleDrawableStart();
        if (titleDrawableStart != null) {
            int intValue = titleDrawableStart.intValue();
            AppCompatTextView appCompatTextView = this.binding.titleTextView;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView, "titleTextView");
            Resources resources = ((RecyclerView.ViewHolder) this).itemView.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            ViewUtilitiesKt.setDrawableLeft(appCompatTextView, ResourceUtilsKt.getDrawable(resources, intValue, 0));
        }
        String endTopText = uiModel.getEndTopText();
        if (endTopText != null) {
            this.binding.endTopTextView.setVisibility(0);
            CellFansBinding cellFansBinding = this.binding;
            cellFansBinding.endTopTextView.setText(endTopText + " " + cellFansBinding.getRoot().getContext().getString(2131951988));
        }
        NobleInfo noble = uiModel.getNoble();
        if (((noble == null || (level4 = noble.getLevel()) == null) ? 0 : level4.intValue()) > 0) {
            AppCompatTextView appCompatTextView2 = this.binding.titleTextView;
            UserService.Companion companion = UserService.INSTANCE;
            NobleInfo noble2 = uiModel.getNoble();
            appCompatTextView2.setTextColor(UserService.Companion.getNobleColor$default(companion, (noble2 == null || (level3 = noble2.getLevel()) == null) ? 0 : level3.intValue(), 0, 2, null));
        } else {
            this.binding.timeTextView.setTextColor(Color.parseColor("#ff000000"));
        }
        String title = uiModel.getTitle();
        if (title != null) {
            AppCompatTextView appCompatTextView3 = this.binding.titleTextView;
            appCompatTextView3.setVisibility(0);
            appCompatTextView3.setText(title);
        }
        CharSequence titleRightTagText = uiModel.getTitleRightTagText();
        if (titleRightTagText != null) {
            AppCompatTextView appCompatTextView4 = this.binding.titleRightTagTextView;
            appCompatTextView4.setVisibility(0);
            appCompatTextView4.setText(titleRightTagText);
        }
        Integer titleRightTagDrawable = uiModel.getTitleRightTagDrawable();
        if (titleRightTagDrawable != null) {
            int intValue2 = titleRightTagDrawable.intValue();
            ?? r6 = this.binding.titleRightTagTextView;
            r6.setVisibility(0);
            r6.setCompoundDrawablesWithIntrinsicBounds(intValue2, 0, 0, 0);
        }
        Integer titleRightTagBackgroundResID = uiModel.getTitleRightTagBackgroundResID();
        if (titleRightTagBackgroundResID != null) {
            int intValue3 = titleRightTagBackgroundResID.intValue();
            this.binding.titleRightTagTextView.setVisibility(0);
            this.binding.titleRightTagTextView.setBackgroundResource(intValue3);
        }
        if (uiModel.getSubtitle() != null) {
            AppCompatTextView appCompatTextView5 = this.binding.subtitleTextView;
            appCompatTextView5.setVisibility(0);
            appCompatTextView5.setText(uiModel.getSubtitle());
        }
        ImageUIModel subtitleLeftIconImageUIModel = uiModel.getSubtitleLeftIconImageUIModel();
        if (subtitleLeftIconImageUIModel != null) {
            AppCompatImageView appCompatImageView = this.binding.subtitleLeftIconImageView;
            appCompatImageView.setVisibility(0);
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "apply(...)");
            ViewUtilitiesKt.bind$default(appCompatImageView, subtitleLeftIconImageUIModel, null, 2, null);
        }
        if (uiModel.getEndTextSize() != null) {
            this.binding.endTextView.setTextSize(r0.intValue());
        }
        ImageUIModel endIconDisplayImageUIModel = uiModel.getEndIconDisplayImageUIModel();
        if (endIconDisplayImageUIModel != null) {
            AppCompatImageView appCompatImageView2 = this.binding.endIconImageView;
            appCompatImageView2.setVisibility(0);
            Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "apply(...)");
            ViewUtilitiesKt.bind$default(appCompatImageView2, endIconDisplayImageUIModel, null, 2, null);
        }
        String endIconClickTag = uiModel.getEndIconClickTag();
        if (endIconClickTag != null) {
            this.binding.endIconImageView.setTag(endIconClickTag);
        }
        ProfileDetailUIModel nextUIModel = uiModel.getNextUIModel();
        boolean z = nextUIModel != null;
        if (z) {
            this.binding.videoCallButton.setVisibility(0);
        } else {
            this.binding.likeCallButton.setVisibility(0);
        }
        String endText = uiModel.getEndText();
        if (endText != null) {
            AppCompatTextView appCompatTextView6 = this.binding.endTextView;
            appCompatTextView6.setVisibility(0);
            appCompatTextView6.setText(endText);
        }
        this.binding.unreadPotView.setAlpha(uiModel.getHasRead() ? 0.0f : 1.0f);
        this.binding.iconVip.setVisibility(uiModel.isVip() ? 0 : 8);
        NobleInfo noble3 = uiModel.getNoble();
        if (((noble3 == null || (level2 = noble3.getLevel()) == null) ? 0 : level2.intValue()) > 0) {
            this.binding.iconVip.setVisibility(8);
            CellFansBinding cellFansBinding2 = this.binding;
            ImageView imageView = cellFansBinding2.iconNoble;
            Context context = cellFansBinding2.getRoot().getContext();
            UserService.Companion companion2 = UserService.INSTANCE;
            NobleInfo noble4 = uiModel.getNoble();
            imageView.setImageDrawable(a.getDrawable(context, companion2.getNobleDrawableRes((noble4 == null || (level = noble4.getLevel()) == null) ? 0 : level.intValue())));
            this.binding.iconNoble.setVisibility(0);
            return;
        }
        this.binding.iconNoble.setVisibility(8);
    }

    @NotNull
    public final CellFansBinding getBinding() {
        return this.binding;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x01ae, code lost:
    
        if (r0.isLike() == true) goto L٦٦;
     */
    /* JADX WARN: Type inference failed for: r6v14, types: [com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView, android.view.View] */
    @SuppressLint({"UseCompatLoadingForDrawables"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void bind(@NotNull ILikeCellUIModel uiModel) {
        Integer level;
        Integer level2;
        Integer level3;
        Integer level4;
        Intrinsics.checkNotNullParameter(uiModel, "uiModel");
        this.binding.videoCallButton.setTag(VideoCall);
        this.binding.likeCallButton.setTag(Like);
        this.binding.videoCallButton.setVisibility(8);
        this.binding.likeCallButton.setVisibility(8);
        ImageUIModel iconCircleDisplayImageUIModel = uiModel.getIconCircleDisplayImageUIModel();
        if (iconCircleDisplayImageUIModel != null) {
            QMUIRadiusImageView qMUIRadiusImageView = this.binding.iconCircleImageView;
            qMUIRadiusImageView.setVisibility(0);
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "apply(...)");
            ViewUtilitiesKt.bind$default(qMUIRadiusImageView, iconCircleDisplayImageUIModel, null, 2, null);
        }
        Integer titleDrawableStart = uiModel.getTitleDrawableStart();
        if (titleDrawableStart != null) {
            int intValue = titleDrawableStart.intValue();
            AppCompatTextView appCompatTextView = this.binding.titleTextView;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView, "titleTextView");
            Resources resources = ((RecyclerView.ViewHolder) this).itemView.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            ViewUtilitiesKt.setDrawableLeft(appCompatTextView, ResourceUtilsKt.getDrawable(resources, intValue, 0));
        }
        String endTopText = uiModel.getEndTopText();
        if (endTopText != null) {
            this.binding.endTopTextView.setVisibility(0);
            CellFansBinding cellFansBinding = this.binding;
            cellFansBinding.endTopTextView.setText(endTopText + " " + cellFansBinding.getRoot().getContext().getString(2131951988));
        }
        NobleInfo noble = uiModel.getNoble();
        if (((noble == null || (level4 = noble.getLevel()) == null) ? 0 : level4.intValue()) > 0) {
            AppCompatTextView appCompatTextView2 = this.binding.titleTextView;
            UserService.Companion companion = UserService.INSTANCE;
            NobleInfo noble2 = uiModel.getNoble();
            appCompatTextView2.setTextColor(UserService.Companion.getNobleColor$default(companion, (noble2 == null || (level3 = noble2.getLevel()) == null) ? 0 : level3.intValue(), 0, 2, null));
        } else {
            this.binding.timeTextView.setTextColor(Color.parseColor("#ff000000"));
        }
        String title = uiModel.getTitle();
        if (title != null) {
            AppCompatTextView appCompatTextView3 = this.binding.titleTextView;
            appCompatTextView3.setVisibility(0);
            appCompatTextView3.setText(title);
        }
        CharSequence titleRightTagText = uiModel.getTitleRightTagText();
        if (titleRightTagText != null) {
            AppCompatTextView appCompatTextView4 = this.binding.titleRightTagTextView;
            appCompatTextView4.setVisibility(0);
            appCompatTextView4.setText(titleRightTagText);
        }
        Integer titleRightTagDrawable = uiModel.getTitleRightTagDrawable();
        if (titleRightTagDrawable != null) {
            int intValue2 = titleRightTagDrawable.intValue();
            ?? r6 = this.binding.titleRightTagTextView;
            r6.setVisibility(0);
            r6.setCompoundDrawablesWithIntrinsicBounds(intValue2, 0, 0, 0);
        }
        Integer titleRightTagBackgroundResID = uiModel.getTitleRightTagBackgroundResID();
        if (titleRightTagBackgroundResID != null) {
            int intValue3 = titleRightTagBackgroundResID.intValue();
            this.binding.titleRightTagTextView.setVisibility(0);
            this.binding.titleRightTagTextView.setBackgroundResource(intValue3);
        }
        if (uiModel.getSubtitle() != null) {
            AppCompatTextView appCompatTextView5 = this.binding.subtitleTextView;
            appCompatTextView5.setVisibility(0);
            appCompatTextView5.setText(uiModel.getSubtitle());
        }
        ImageUIModel subtitleLeftIconImageUIModel = uiModel.getSubtitleLeftIconImageUIModel();
        if (subtitleLeftIconImageUIModel != null) {
            AppCompatImageView appCompatImageView = this.binding.subtitleLeftIconImageView;
            appCompatImageView.setVisibility(0);
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "apply(...)");
            ViewUtilitiesKt.bind$default(appCompatImageView, subtitleLeftIconImageUIModel, null, 2, null);
        }
        if (uiModel.getEndTextSize() != null) {
            this.binding.endTextView.setTextSize(r0.intValue());
        }
        ImageUIModel endIconDisplayImageUIModel = uiModel.getEndIconDisplayImageUIModel();
        if (endIconDisplayImageUIModel != null) {
            AppCompatImageView appCompatImageView2 = this.binding.endIconImageView;
            appCompatImageView2.setVisibility(0);
            Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "apply(...)");
            ViewUtilitiesKt.bind$default(appCompatImageView2, endIconDisplayImageUIModel, null, 2, null);
        }
        String endIconClickTag = uiModel.getEndIconClickTag();
        if (endIconClickTag != null) {
            this.binding.endIconImageView.setTag(endIconClickTag);
        }
        String endText = uiModel.getEndText();
        if (endText != null) {
            AppCompatTextView appCompatTextView6 = this.binding.endTextView;
            appCompatTextView6.setVisibility(0);
            appCompatTextView6.setText(endText);
        }
        this.binding.unreadPotView.setAlpha(uiModel.getHasRead() ? 0.0f : 1.0f);
        ProfileDetailUIModel nextUIModel = uiModel.getNextUIModel();
        boolean z = nextUIModel != null;
        if (z) {
            this.binding.videoCallButton.setVisibility(0);
        } else {
            this.binding.likeCallButton.setVisibility(0);
        }
        this.binding.iconVip.setVisibility(uiModel.isVip() ? 0 : 8);
        NobleInfo noble3 = uiModel.getNoble();
        if (((noble3 == null || (level2 = noble3.getLevel()) == null) ? 0 : level2.intValue()) > 0) {
            this.binding.iconVip.setVisibility(8);
            CellFansBinding cellFansBinding2 = this.binding;
            ImageView imageView = cellFansBinding2.iconNoble;
            Context context = cellFansBinding2.getRoot().getContext();
            UserService.Companion companion2 = UserService.INSTANCE;
            NobleInfo noble4 = uiModel.getNoble();
            imageView.setImageDrawable(a.getDrawable(context, companion2.getNobleDrawableRes((noble4 == null || (level = noble4.getLevel()) == null) ? 0 : level.intValue())));
            this.binding.iconNoble.setVisibility(0);
            return;
        }
        this.binding.iconNoble.setVisibility(8);
    }

    /* JADX WARN: Type inference failed for: r5v9, types: [com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView, android.view.View] */
    @SuppressLint({"UseCompatLoadingForDrawables"})
    public final void bind(@NotNull VisitorCellUIModel uiModel) {
        Integer level;
        Integer level2;
        Integer level3;
        Integer level4;
        Intrinsics.checkNotNullParameter(uiModel, "uiModel");
        this.binding.videoCallButton.setTag(VideoCall);
        this.binding.likeCallButton.setTag(Like);
        Integer titleDrawableStart = uiModel.getTitleDrawableStart();
        if (titleDrawableStart != null) {
            int intValue = titleDrawableStart.intValue();
            AppCompatTextView appCompatTextView = this.binding.titleTextView;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView, "titleTextView");
            Resources resources = ((RecyclerView.ViewHolder) this).itemView.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            ViewUtilitiesKt.setDrawableLeft(appCompatTextView, ResourceUtilsKt.getDrawable(resources, intValue, 0));
        }
        String endTopText = uiModel.getEndTopText();
        if (endTopText != null) {
            this.binding.endTopTextView.setVisibility(0);
            CellFansBinding cellFansBinding = this.binding;
            cellFansBinding.endTopTextView.setText(endTopText + " " + cellFansBinding.getRoot().getContext().getString(2131951988));
        }
        NobleInfo noble = uiModel.getNoble();
        Object obj = null;
        if (((noble == null || (level4 = noble.getLevel()) == null) ? 0 : level4.intValue()) > 0) {
            AppCompatTextView appCompatTextView2 = this.binding.titleTextView;
            UserService.Companion companion = UserService.INSTANCE;
            NobleInfo noble2 = uiModel.getNoble();
            appCompatTextView2.setTextColor(UserService.Companion.getNobleColor$default(companion, (noble2 == null || (level3 = noble2.getLevel()) == null) ? 0 : level3.intValue(), 0, 2, null));
        } else {
            this.binding.timeTextView.setTextColor(Color.parseColor("#ff000000"));
        }
        String title = uiModel.getTitle();
        if (title != null) {
            AppCompatTextView appCompatTextView3 = this.binding.titleTextView;
            appCompatTextView3.setVisibility(0);
            appCompatTextView3.setText(title);
        }
        CharSequence titleRightTagText = uiModel.getTitleRightTagText();
        if (titleRightTagText != null) {
            AppCompatTextView appCompatTextView4 = this.binding.titleRightTagTextView;
            appCompatTextView4.setVisibility(0);
            appCompatTextView4.setText(titleRightTagText);
        }
        Integer titleRightTagDrawable = uiModel.getTitleRightTagDrawable();
        if (titleRightTagDrawable != null) {
            int intValue2 = titleRightTagDrawable.intValue();
            ?? r5 = this.binding.titleRightTagTextView;
            r5.setVisibility(0);
            r5.setCompoundDrawablesWithIntrinsicBounds(intValue2, 0, 0, 0);
        }
        Integer titleRightTagBackgroundResID = uiModel.getTitleRightTagBackgroundResID();
        if (titleRightTagBackgroundResID != null) {
            int intValue3 = titleRightTagBackgroundResID.intValue();
            this.binding.titleRightTagTextView.setVisibility(0);
            this.binding.titleRightTagTextView.setBackgroundResource(intValue3);
        }
        if (uiModel.getSubtitle() != null) {
            AppCompatTextView appCompatTextView5 = this.binding.subtitleTextView;
            appCompatTextView5.setVisibility(0);
            appCompatTextView5.setText(uiModel.getSubtitle());
        }
        ImageUIModel subtitleLeftIconImageUIModel = uiModel.getSubtitleLeftIconImageUIModel();
        if (subtitleLeftIconImageUIModel != null) {
            AppCompatImageView appCompatImageView = this.binding.subtitleLeftIconImageView;
            appCompatImageView.setVisibility(0);
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "apply(...)");
            ViewUtilitiesKt.bind$default(appCompatImageView, subtitleLeftIconImageUIModel, null, 2, null);
        }
        if (uiModel.getEndTextSize() != null) {
            this.binding.endTextView.setTextSize(r1.intValue());
        }
        ImageUIModel endIconDisplayImageUIModel = uiModel.getEndIconDisplayImageUIModel();
        if (endIconDisplayImageUIModel != null) {
            AppCompatImageView appCompatImageView2 = this.binding.endIconImageView;
            appCompatImageView2.setVisibility(0);
            Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "apply(...)");
            ViewUtilitiesKt.bind$default(appCompatImageView2, endIconDisplayImageUIModel, null, 2, null);
        }
        String endIconClickTag = uiModel.getEndIconClickTag();
        if (endIconClickTag != null) {
            this.binding.endIconImageView.setTag(endIconClickTag);
        }
        String endText = uiModel.getEndText();
        if (endText != null) {
            AppCompatTextView appCompatTextView6 = this.binding.endTextView;
            appCompatTextView6.setVisibility(0);
            appCompatTextView6.setText(endText);
        }
        this.binding.timeVerticalLineView.setVisibility(0);
        this.binding.timeTextView.setVisibility(0);
        this.binding.timeTextView.setText(((RecyclerView.ViewHolder) this).itemView.getContext().getString(2131953987, String.valueOf(uiModel.getTimeCount())));
        this.binding.unreadPotView.setAlpha(uiModel.getHasRead() ? 0.0f : 1.0f);
        this.binding.iconVip.setVisibility(uiModel.isVip() ? 0 : 8);
        NobleInfo noble3 = uiModel.getNoble();
        if (((noble3 == null || (level2 = noble3.getLevel()) == null) ? 0 : level2.intValue()) > 0) {
            this.binding.iconVip.setVisibility(8);
            CellFansBinding cellFansBinding2 = this.binding;
            ImageView imageView = cellFansBinding2.iconNoble;
            Context context = cellFansBinding2.getRoot().getContext();
            UserService.Companion companion2 = UserService.INSTANCE;
            NobleInfo noble4 = uiModel.getNoble();
            imageView.setImageDrawable(a.getDrawable(context, companion2.getNobleDrawableRes((noble4 == null || (level = noble4.getLevel()) == null) ? 0 : level.intValue())));
            this.binding.iconNoble.setVisibility(0);
        } else {
            this.binding.iconNoble.setVisibility(8);
        }
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null && user.isVip()) {
            this.binding.textShade.setVisibility(8);
            ProfileDetailUIModel nextUIModel = uiModel.getNextUIModel();
            if (nextUIModel != null && nextUIModel.isLike()) {
                this.binding.videoCallButton.setVisibility(0);
                this.binding.likeCallButton.setVisibility(8);
            } else {
                this.binding.videoCallButton.setVisibility(8);
                this.binding.likeCallButton.setVisibility(0);
            }
            ImageUIModel iconCircleDisplayImageUIModel = uiModel.getIconCircleDisplayImageUIModel();
            if (iconCircleDisplayImageUIModel != null) {
                QMUIRadiusImageView qMUIRadiusImageView = this.binding.iconCircleImageView;
                qMUIRadiusImageView.setVisibility(0);
                Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "apply(...)");
                ViewUtilitiesKt.bind$default(qMUIRadiusImageView, iconCircleDisplayImageUIModel, null, 2, null);
                return;
            }
            return;
        }
        this.binding.textShade.setVisibility(0);
        this.binding.videoCallButton.setVisibility(8);
        this.binding.likeCallButton.setVisibility(8);
        ImageUIModel iconCircleDisplayImageUIModel2 = uiModel.getIconCircleDisplayImageUIModel();
        boolean isEmpty = TextUtils.isEmpty(iconCircleDisplayImageUIModel2 != null ? iconCircleDisplayImageUIModel2.getImageUrl() : null);
        ImageUIModel iconCircleDisplayImageUIModel3 = uiModel.getIconCircleDisplayImageUIModel();
        if (isEmpty) {
            if (iconCircleDisplayImageUIModel3 != null) {
                obj = iconCircleDisplayImageUIModel3.getPlaceholder();
            }
        } else if (iconCircleDisplayImageUIModel3 != null) {
            obj = iconCircleDisplayImageUIModel3.getImageUrl();
        }
        Glide.with(this.binding.iconCircleImageView.getContext()).p(obj).q0(h.p0(new b(5, 5))).D0(this.binding.iconCircleImageView);
    }
}
