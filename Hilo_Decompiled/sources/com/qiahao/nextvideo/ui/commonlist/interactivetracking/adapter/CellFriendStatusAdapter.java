package com.qiahao.nextvideo.ui.commonlist.interactivetracking.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.a;
import androidx.databinding.ViewDataBinding;
import c5.g;
import c5.h;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.k;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.oudi.utils.ktx.StringKtxKt;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.CellFansBinding;
import com.qiahao.nextvideo.ui.commonlist.interactivetracking.CellUIModel;
import com.qiahao.nextvideo.ui.commonlist.interactivetracking.CommonCellViewHolder;
import com.qiahao.nextvideo.ui.commonlist.interactivetracking.ILikeCellUIModel;
import com.qiahao.nextvideo.ui.commonlist.interactivetracking.LikeMeCellUIModel;
import com.qiahao.nextvideo.ui.commonlist.interactivetracking.PraiseCellUIModel;
import com.qiahao.nextvideo.ui.commonlist.interactivetracking.VisitorCellUIModel;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.utilities.ResourceUtilsKt;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import o4.j;
import org.jetbrains.annotations.NotNull;
import pe.b;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0003J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0010H\u0003J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0012H\u0003J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0014H\u0003¨\u0006\u0015"}, d2 = {"Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/adapter/CellFriendStatusAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/CellUIModel;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/CellFansBinding;", "<init>", "()V", "convert", "", "holder", "item", "bindLikeMe", "binding", "uiModel", "Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/LikeMeCellUIModel;", "bindILike", "Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/ILikeCellUIModel;", "bindVisitor", "Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/VisitorCellUIModel;", "bindPraise", "Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/PraiseCellUIModel;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCellFriendStatusAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CellFriendStatusAdapter.kt\ncom/qiahao/nextvideo/ui/commonlist/interactivetracking/adapter/CellFriendStatusAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,437:1\n1#2:438\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CellFriendStatusAdapter extends BaseQuickAdapter<CellUIModel, BaseDataBindingHolder<CellFansBinding>> {
    public CellFriendStatusAdapter() {
        super(R.layout.cell_fans, (List) null, 2, (DefaultConstructorMarker) null);
        addChildClickViewIds(new int[]{R.id.video_call_button, R.id.like_call_button});
    }

    /* JADX WARN: Type inference failed for: r6v8, types: [com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView, android.view.View] */
    @SuppressLint({"UseCompatLoadingForDrawables", "SetTextI18n"})
    private final void bindILike(CellFansBinding binding, ILikeCellUIModel uiModel) {
        int i;
        float f;
        int i2;
        int i3;
        int i4;
        Integer level;
        Integer level2;
        int i5;
        Integer level3;
        Integer level4;
        binding.videoCallButton.setTag(CommonCellViewHolder.VideoCall);
        binding.likeCallButton.setTag(CommonCellViewHolder.Like);
        binding.videoCallButton.setVisibility(8);
        binding.likeCallButton.setVisibility(8);
        ImageUIModel iconCircleDisplayImageUIModel = uiModel.getIconCircleDisplayImageUIModel();
        if (iconCircleDisplayImageUIModel != null) {
            QMUIRadiusImageView qMUIRadiusImageView = binding.iconCircleImageView;
            qMUIRadiusImageView.setVisibility(0);
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "apply(...)");
            ViewUtilitiesKt.bind$default(qMUIRadiusImageView, iconCircleDisplayImageUIModel, null, 2, null);
        }
        Integer titleDrawableStart = uiModel.getTitleDrawableStart();
        if (titleDrawableStart != null) {
            int intValue = titleDrawableStart.intValue();
            AppCompatTextView appCompatTextView = binding.titleTextView;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView, "titleTextView");
            Resources resources = binding.getRoot().getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            ViewUtilitiesKt.setDrawableLeft(appCompatTextView, ResourceUtilsKt.getDrawable(resources, intValue, 0));
        }
        String endTopText = uiModel.getEndTopText();
        if (endTopText != null) {
            binding.endTopTextView.setVisibility(0);
            binding.endTopTextView.setText(endTopText + " " + binding.getRoot().getContext().getString(2131951988));
        }
        NobleInfo noble = uiModel.getNoble();
        if (noble != null && (level4 = noble.getLevel()) != null) {
            i = level4.intValue();
        } else {
            i = 0;
        }
        if (i > 0) {
            AppCompatTextView appCompatTextView2 = binding.titleTextView;
            UserService.Companion companion = UserService.INSTANCE;
            NobleInfo noble2 = uiModel.getNoble();
            if (noble2 != null && (level3 = noble2.getLevel()) != null) {
                i5 = level3.intValue();
            } else {
                i5 = 0;
            }
            appCompatTextView2.setTextColor(UserService.Companion.getNobleColor$default(companion, i5, 0, 2, null));
        } else {
            binding.timeTextView.setTextColor(Color.parseColor("#ff000000"));
        }
        String title = uiModel.getTitle();
        if (title != null) {
            AppCompatTextView appCompatTextView3 = binding.titleTextView;
            appCompatTextView3.setVisibility(0);
            appCompatTextView3.setText(title);
        }
        CharSequence titleRightTagText = uiModel.getTitleRightTagText();
        if (titleRightTagText != null) {
            AppCompatTextView appCompatTextView4 = binding.titleRightTagTextView;
            appCompatTextView4.setVisibility(0);
            appCompatTextView4.setText(titleRightTagText);
        }
        Integer titleRightTagDrawable = uiModel.getTitleRightTagDrawable();
        if (titleRightTagDrawable != null) {
            int intValue2 = titleRightTagDrawable.intValue();
            ?? r6 = binding.titleRightTagTextView;
            r6.setVisibility(0);
            r6.setCompoundDrawablesWithIntrinsicBounds(intValue2, 0, 0, 0);
        }
        Integer titleRightTagBackgroundResID = uiModel.getTitleRightTagBackgroundResID();
        if (titleRightTagBackgroundResID != null) {
            int intValue3 = titleRightTagBackgroundResID.intValue();
            binding.titleRightTagTextView.setVisibility(0);
            binding.titleRightTagTextView.setBackgroundResource(intValue3);
        }
        if (uiModel.getSubtitle() != null) {
            AppCompatTextView appCompatTextView5 = binding.subtitleTextView;
            appCompatTextView5.setVisibility(0);
            appCompatTextView5.setText(uiModel.getSubtitle());
        }
        ImageUIModel subtitleLeftIconImageUIModel = uiModel.getSubtitleLeftIconImageUIModel();
        if (subtitleLeftIconImageUIModel != null) {
            AppCompatImageView appCompatImageView = binding.subtitleLeftIconImageView;
            appCompatImageView.setVisibility(0);
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "apply(...)");
            ViewUtilitiesKt.bind$default(appCompatImageView, subtitleLeftIconImageUIModel, null, 2, null);
        }
        if (uiModel.getEndTextSize() != null) {
            binding.endTextView.setTextSize(r0.intValue());
        }
        ImageUIModel endIconDisplayImageUIModel = uiModel.getEndIconDisplayImageUIModel();
        if (endIconDisplayImageUIModel != null) {
            AppCompatImageView appCompatImageView2 = binding.endIconImageView;
            appCompatImageView2.setVisibility(0);
            Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "apply(...)");
            ViewUtilitiesKt.bind$default(appCompatImageView2, endIconDisplayImageUIModel, null, 2, null);
        }
        String endIconClickTag = uiModel.getEndIconClickTag();
        if (endIconClickTag != null) {
            binding.endIconImageView.setTag(endIconClickTag);
        }
        String endText = uiModel.getEndText();
        if (endText != null) {
            AppCompatTextView appCompatTextView6 = binding.endTextView;
            appCompatTextView6.setVisibility(0);
            appCompatTextView6.setText(endText);
        }
        View view = binding.unreadPotView;
        if (uiModel.getHasRead()) {
            f = 0.0f;
        } else {
            f = 1.0f;
        }
        view.setAlpha(f);
        ImageView imageView = binding.iconVip;
        if (uiModel.isVip()) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        NobleInfo noble3 = uiModel.getNoble();
        if (noble3 != null && (level2 = noble3.getLevel()) != null) {
            i3 = level2.intValue();
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            binding.iconVip.setVisibility(8);
            ImageView imageView2 = binding.iconNoble;
            Context context = binding.getRoot().getContext();
            UserService.Companion companion2 = UserService.INSTANCE;
            NobleInfo noble4 = uiModel.getNoble();
            if (noble4 != null && (level = noble4.getLevel()) != null) {
                i4 = level.intValue();
            } else {
                i4 = 0;
            }
            imageView2.setImageDrawable(a.getDrawable(context, companion2.getNobleDrawableRes(i4)));
            binding.iconNoble.setVisibility(0);
            return;
        }
        binding.iconNoble.setVisibility(8);
    }

    /* JADX WARN: Type inference failed for: r6v8, types: [com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView, android.view.View] */
    @SuppressLint({"SetTextI18n"})
    private final void bindLikeMe(CellFansBinding binding, LikeMeCellUIModel uiModel) {
        int i;
        float f;
        int i2;
        int i3;
        int i4;
        Integer level;
        Integer level2;
        int i5;
        Integer level3;
        Integer level4;
        binding.videoCallButton.setTag(CommonCellViewHolder.VideoCall);
        binding.likeCallButton.setTag(CommonCellViewHolder.Like);
        binding.videoCallButton.setVisibility(8);
        binding.likeCallButton.setVisibility(8);
        ImageUIModel iconCircleDisplayImageUIModel = uiModel.getIconCircleDisplayImageUIModel();
        if (iconCircleDisplayImageUIModel != null) {
            QMUIRadiusImageView qMUIRadiusImageView = binding.iconCircleImageView;
            qMUIRadiusImageView.setVisibility(0);
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "apply(...)");
            ViewUtilitiesKt.bind$default(qMUIRadiusImageView, iconCircleDisplayImageUIModel, null, 2, null);
        }
        Integer titleDrawableStart = uiModel.getTitleDrawableStart();
        if (titleDrawableStart != null) {
            int intValue = titleDrawableStart.intValue();
            AppCompatTextView appCompatTextView = binding.titleTextView;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView, "titleTextView");
            Resources resources = binding.getRoot().getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            ViewUtilitiesKt.setDrawableLeft(appCompatTextView, ResourceUtilsKt.getDrawable(resources, intValue, 0));
        }
        String endTopText = uiModel.getEndTopText();
        if (endTopText != null) {
            binding.endTopTextView.setVisibility(0);
            binding.endTopTextView.setText(endTopText + " " + binding.getRoot().getContext().getString(2131951988));
        }
        NobleInfo noble = uiModel.getNoble();
        if (noble != null && (level4 = noble.getLevel()) != null) {
            i = level4.intValue();
        } else {
            i = 0;
        }
        if (i > 0) {
            AppCompatTextView appCompatTextView2 = binding.titleTextView;
            UserService.Companion companion = UserService.INSTANCE;
            NobleInfo noble2 = uiModel.getNoble();
            if (noble2 != null && (level3 = noble2.getLevel()) != null) {
                i5 = level3.intValue();
            } else {
                i5 = 0;
            }
            appCompatTextView2.setTextColor(UserService.Companion.getNobleColor$default(companion, i5, 0, 2, null));
        } else {
            binding.timeTextView.setTextColor(Color.parseColor("#ff000000"));
        }
        String title = uiModel.getTitle();
        if (title != null) {
            AppCompatTextView appCompatTextView3 = binding.titleTextView;
            appCompatTextView3.setVisibility(0);
            appCompatTextView3.setText(title);
        }
        CharSequence titleRightTagText = uiModel.getTitleRightTagText();
        if (titleRightTagText != null) {
            AppCompatTextView appCompatTextView4 = binding.titleRightTagTextView;
            appCompatTextView4.setVisibility(0);
            appCompatTextView4.setText(titleRightTagText);
        }
        Integer titleRightTagDrawable = uiModel.getTitleRightTagDrawable();
        if (titleRightTagDrawable != null) {
            int intValue2 = titleRightTagDrawable.intValue();
            ?? r6 = binding.titleRightTagTextView;
            r6.setVisibility(0);
            r6.setCompoundDrawablesWithIntrinsicBounds(intValue2, 0, 0, 0);
        }
        Integer titleRightTagBackgroundResID = uiModel.getTitleRightTagBackgroundResID();
        if (titleRightTagBackgroundResID != null) {
            int intValue3 = titleRightTagBackgroundResID.intValue();
            binding.titleRightTagTextView.setVisibility(0);
            binding.titleRightTagTextView.setBackgroundResource(intValue3);
        }
        if (uiModel.getSubtitle() != null) {
            AppCompatTextView appCompatTextView5 = binding.subtitleTextView;
            appCompatTextView5.setVisibility(0);
            appCompatTextView5.setText(uiModel.getSubtitle());
        }
        ImageUIModel subtitleLeftIconImageUIModel = uiModel.getSubtitleLeftIconImageUIModel();
        if (subtitleLeftIconImageUIModel != null) {
            AppCompatImageView appCompatImageView = binding.subtitleLeftIconImageView;
            appCompatImageView.setVisibility(0);
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "apply(...)");
            ViewUtilitiesKt.bind$default(appCompatImageView, subtitleLeftIconImageUIModel, null, 2, null);
        }
        if (uiModel.getEndTextSize() != null) {
            binding.endTextView.setTextSize(r0.intValue());
        }
        ImageUIModel endIconDisplayImageUIModel = uiModel.getEndIconDisplayImageUIModel();
        if (endIconDisplayImageUIModel != null) {
            AppCompatImageView appCompatImageView2 = binding.endIconImageView;
            appCompatImageView2.setVisibility(0);
            Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "apply(...)");
            ViewUtilitiesKt.bind$default(appCompatImageView2, endIconDisplayImageUIModel, null, 2, null);
        }
        String endIconClickTag = uiModel.getEndIconClickTag();
        if (endIconClickTag != null) {
            binding.endIconImageView.setTag(endIconClickTag);
        }
        String endText = uiModel.getEndText();
        if (endText != null) {
            AppCompatTextView appCompatTextView6 = binding.endTextView;
            appCompatTextView6.setVisibility(0);
            appCompatTextView6.setText(endText);
        }
        View view = binding.unreadPotView;
        if (uiModel.getHasRead()) {
            f = 0.0f;
        } else {
            f = 1.0f;
        }
        view.setAlpha(f);
        ImageView imageView = binding.iconVip;
        if (uiModel.isVip()) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        NobleInfo noble3 = uiModel.getNoble();
        if (noble3 != null && (level2 = noble3.getLevel()) != null) {
            i3 = level2.intValue();
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            binding.iconVip.setVisibility(8);
            ImageView imageView2 = binding.iconNoble;
            Context context = binding.getRoot().getContext();
            UserService.Companion companion2 = UserService.INSTANCE;
            NobleInfo noble4 = uiModel.getNoble();
            if (noble4 != null && (level = noble4.getLevel()) != null) {
                i4 = level.intValue();
            } else {
                i4 = 0;
            }
            imageView2.setImageDrawable(a.getDrawable(context, companion2.getNobleDrawableRes(i4)));
            binding.iconNoble.setVisibility(0);
            return;
        }
        binding.iconNoble.setVisibility(8);
    }

    /* JADX WARN: Type inference failed for: r4v8, types: [com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView, android.view.View] */
    @SuppressLint({"SetTextI18n"})
    private final void bindPraise(CellFansBinding binding, PraiseCellUIModel uiModel) {
        int i;
        float f;
        int i2;
        int i3;
        int i4;
        Integer level;
        Integer level2;
        int i5;
        Integer level3;
        Integer level4;
        binding.videoCallButton.setTag(CommonCellViewHolder.VideoCall);
        binding.likeCallButton.setTag(CommonCellViewHolder.Like);
        Integer titleDrawableStart = uiModel.getTitleDrawableStart();
        if (titleDrawableStart != null) {
            int intValue = titleDrawableStart.intValue();
            AppCompatTextView appCompatTextView = binding.titleTextView;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView, "titleTextView");
            Resources resources = binding.getRoot().getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            ViewUtilitiesKt.setDrawableLeft(appCompatTextView, ResourceUtilsKt.getDrawable(resources, intValue, 0));
        }
        String endTopText = uiModel.getEndTopText();
        if (endTopText != null) {
            binding.endTopTextView.setVisibility(0);
            binding.endTopTextView.setText(endTopText + " " + binding.getRoot().getContext().getString(2131951988));
        }
        binding.timeVerticalLineView.setVisibility(0);
        binding.timeTextView.setVisibility(0);
        binding.timeTextView.setText(getContext().getString(2131953987, String.valueOf(uiModel.getTimeCount())));
        NobleInfo noble = uiModel.getNoble();
        if (noble != null && (level4 = noble.getLevel()) != null) {
            i = level4.intValue();
        } else {
            i = 0;
        }
        if (i > 0) {
            AppCompatTextView appCompatTextView2 = binding.titleTextView;
            UserService.Companion companion = UserService.INSTANCE;
            NobleInfo noble2 = uiModel.getNoble();
            if (noble2 != null && (level3 = noble2.getLevel()) != null) {
                i5 = level3.intValue();
            } else {
                i5 = 0;
            }
            appCompatTextView2.setTextColor(UserService.Companion.getNobleColor$default(companion, i5, 0, 2, null));
        } else {
            binding.timeTextView.setTextColor(Color.parseColor("#ff000000"));
        }
        String title = uiModel.getTitle();
        if (title != null) {
            AppCompatTextView appCompatTextView3 = binding.titleTextView;
            appCompatTextView3.setVisibility(0);
            appCompatTextView3.setText(title);
        }
        CharSequence titleRightTagText = uiModel.getTitleRightTagText();
        if (titleRightTagText != null) {
            AppCompatTextView appCompatTextView4 = binding.titleRightTagTextView;
            appCompatTextView4.setVisibility(0);
            appCompatTextView4.setText(titleRightTagText);
        }
        Integer titleRightTagDrawable = uiModel.getTitleRightTagDrawable();
        if (titleRightTagDrawable != null) {
            int intValue2 = titleRightTagDrawable.intValue();
            ?? r4 = binding.titleRightTagTextView;
            r4.setVisibility(0);
            r4.setCompoundDrawablesWithIntrinsicBounds(intValue2, 0, 0, 0);
        }
        Integer titleRightTagBackgroundResID = uiModel.getTitleRightTagBackgroundResID();
        if (titleRightTagBackgroundResID != null) {
            int intValue3 = titleRightTagBackgroundResID.intValue();
            binding.titleRightTagTextView.setVisibility(0);
            binding.titleRightTagTextView.setBackgroundResource(intValue3);
        }
        if (uiModel.getSubtitle() != null) {
            AppCompatTextView appCompatTextView5 = binding.subtitleTextView;
            appCompatTextView5.setVisibility(0);
            appCompatTextView5.setText(uiModel.getSubtitle());
        }
        ImageUIModel subtitleLeftIconImageUIModel = uiModel.getSubtitleLeftIconImageUIModel();
        if (subtitleLeftIconImageUIModel != null) {
            AppCompatImageView appCompatImageView = binding.subtitleLeftIconImageView;
            appCompatImageView.setVisibility(0);
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "apply(...)");
            ViewUtilitiesKt.bind$default(appCompatImageView, subtitleLeftIconImageUIModel, null, 2, null);
        }
        if (uiModel.getEndTextSize() != null) {
            binding.endTextView.setTextSize(r0.intValue());
        }
        ImageUIModel endIconDisplayImageUIModel = uiModel.getEndIconDisplayImageUIModel();
        if (endIconDisplayImageUIModel != null) {
            AppCompatImageView appCompatImageView2 = binding.endIconImageView;
            appCompatImageView2.setVisibility(0);
            Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "apply(...)");
            ViewUtilitiesKt.bind$default(appCompatImageView2, endIconDisplayImageUIModel, null, 2, null);
        }
        String endIconClickTag = uiModel.getEndIconClickTag();
        if (endIconClickTag != null) {
            binding.endIconImageView.setTag(endIconClickTag);
        }
        String endText = uiModel.getEndText();
        if (endText != null) {
            AppCompatTextView appCompatTextView6 = binding.endTextView;
            appCompatTextView6.setVisibility(0);
            appCompatTextView6.setText(endText);
        }
        View view = binding.unreadPotView;
        if (uiModel.getHasRead()) {
            f = 0.0f;
        } else {
            f = 1.0f;
        }
        view.setAlpha(f);
        ImageView imageView = binding.iconVip;
        if (uiModel.isVip()) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        NobleInfo noble3 = uiModel.getNoble();
        if (noble3 != null && (level2 = noble3.getLevel()) != null) {
            i3 = level2.intValue();
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            binding.iconVip.setVisibility(8);
            ImageView imageView2 = binding.iconNoble;
            Context context = binding.getRoot().getContext();
            UserService.Companion companion2 = UserService.INSTANCE;
            NobleInfo noble4 = uiModel.getNoble();
            if (noble4 != null && (level = noble4.getLevel()) != null) {
                i4 = level.intValue();
            } else {
                i4 = 0;
            }
            imageView2.setImageDrawable(a.getDrawable(context, companion2.getNobleDrawableRes(i4)));
            binding.iconNoble.setVisibility(0);
        } else {
            binding.iconNoble.setVisibility(8);
        }
        ImageUIModel iconCircleDisplayImageUIModel = uiModel.getIconCircleDisplayImageUIModel();
        if (iconCircleDisplayImageUIModel != null) {
            QMUIRadiusImageView qMUIRadiusImageView = binding.iconCircleImageView;
            qMUIRadiusImageView.setVisibility(0);
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "apply(...)");
            ViewUtilitiesKt.bind$default(qMUIRadiusImageView, iconCircleDisplayImageUIModel, null, 2, null);
        }
    }

    /* JADX WARN: Type inference failed for: r6v10, types: [com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView, android.view.View] */
    @SuppressLint({"UseCompatLoadingForDrawables", "SetTextI18n"})
    private final void bindVisitor(CellFansBinding binding, VisitorCellUIModel uiModel) {
        int i;
        float f;
        int i2;
        int i3;
        k D0;
        int i4;
        Integer level;
        Integer level2;
        int i5;
        Integer level3;
        Integer level4;
        boolean z = true;
        binding.videoCallButton.setTag(CommonCellViewHolder.VideoCall);
        binding.likeCallButton.setTag(CommonCellViewHolder.Like);
        Integer titleDrawableStart = uiModel.getTitleDrawableStart();
        if (titleDrawableStart != null) {
            int intValue = titleDrawableStart.intValue();
            AppCompatTextView appCompatTextView = binding.titleTextView;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView, "titleTextView");
            Resources resources = binding.getRoot().getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            ViewUtilitiesKt.setDrawableLeft(appCompatTextView, ResourceUtilsKt.getDrawable(resources, intValue, 0));
        }
        String endTopText = uiModel.getEndTopText();
        if (endTopText != null) {
            binding.endTopTextView.setVisibility(0);
            binding.endTopTextView.setText(endTopText + " " + binding.getRoot().getContext().getString(2131951988));
        }
        NobleInfo noble = uiModel.getNoble();
        if (noble != null && (level4 = noble.getLevel()) != null) {
            i = level4.intValue();
        } else {
            i = 0;
        }
        if (i > 0) {
            AppCompatTextView appCompatTextView2 = binding.titleTextView;
            UserService.Companion companion = UserService.INSTANCE;
            NobleInfo noble2 = uiModel.getNoble();
            if (noble2 != null && (level3 = noble2.getLevel()) != null) {
                i5 = level3.intValue();
            } else {
                i5 = 0;
            }
            appCompatTextView2.setTextColor(UserService.Companion.getNobleColor$default(companion, i5, 0, 2, null));
        } else {
            binding.timeTextView.setTextColor(Color.parseColor("#ff000000"));
        }
        String title = uiModel.getTitle();
        if (title != null) {
            AppCompatTextView appCompatTextView3 = binding.titleTextView;
            appCompatTextView3.setVisibility(0);
            appCompatTextView3.setText(title);
        }
        CharSequence titleRightTagText = uiModel.getTitleRightTagText();
        if (titleRightTagText != null) {
            AppCompatTextView appCompatTextView4 = binding.titleRightTagTextView;
            appCompatTextView4.setVisibility(0);
            appCompatTextView4.setText(titleRightTagText);
        }
        Integer titleRightTagDrawable = uiModel.getTitleRightTagDrawable();
        if (titleRightTagDrawable != null) {
            int intValue2 = titleRightTagDrawable.intValue();
            ?? r6 = binding.titleRightTagTextView;
            r6.setVisibility(0);
            r6.setCompoundDrawablesWithIntrinsicBounds(intValue2, 0, 0, 0);
        }
        Integer titleRightTagBackgroundResID = uiModel.getTitleRightTagBackgroundResID();
        if (titleRightTagBackgroundResID != null) {
            int intValue3 = titleRightTagBackgroundResID.intValue();
            binding.titleRightTagTextView.setVisibility(0);
            binding.titleRightTagTextView.setBackgroundResource(intValue3);
        }
        if (uiModel.getSubtitle() != null) {
            AppCompatTextView appCompatTextView5 = binding.subtitleTextView;
            appCompatTextView5.setVisibility(0);
            appCompatTextView5.setText(uiModel.getSubtitle());
        }
        ImageUIModel subtitleLeftIconImageUIModel = uiModel.getSubtitleLeftIconImageUIModel();
        if (subtitleLeftIconImageUIModel != null) {
            AppCompatImageView appCompatImageView = binding.subtitleLeftIconImageView;
            appCompatImageView.setVisibility(0);
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "apply(...)");
            ViewUtilitiesKt.bind$default(appCompatImageView, subtitleLeftIconImageUIModel, null, 2, null);
        }
        if (uiModel.getEndTextSize() != null) {
            binding.endTextView.setTextSize(r2.intValue());
        }
        ImageUIModel endIconDisplayImageUIModel = uiModel.getEndIconDisplayImageUIModel();
        if (endIconDisplayImageUIModel != null) {
            AppCompatImageView appCompatImageView2 = binding.endIconImageView;
            appCompatImageView2.setVisibility(0);
            Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "apply(...)");
            ViewUtilitiesKt.bind$default(appCompatImageView2, endIconDisplayImageUIModel, null, 2, null);
        }
        String endIconClickTag = uiModel.getEndIconClickTag();
        if (endIconClickTag != null) {
            binding.endIconImageView.setTag(endIconClickTag);
        }
        String endText = uiModel.getEndText();
        if (endText != null) {
            AppCompatTextView appCompatTextView6 = binding.endTextView;
            appCompatTextView6.setVisibility(0);
            appCompatTextView6.setText(endText);
        }
        binding.timeVerticalLineView.setVisibility(0);
        binding.timeTextView.setVisibility(0);
        binding.timeTextView.setText(getContext().getString(2131953987, String.valueOf(uiModel.getTimeCount())));
        View view = binding.unreadPotView;
        if (uiModel.getHasRead()) {
            f = 0.0f;
        } else {
            f = 1.0f;
        }
        view.setAlpha(f);
        ImageView imageView = binding.iconVip;
        if (uiModel.isVip()) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        NobleInfo noble3 = uiModel.getNoble();
        if (noble3 != null && (level2 = noble3.getLevel()) != null) {
            i3 = level2.intValue();
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            binding.iconVip.setVisibility(8);
            ImageView imageView2 = binding.iconNoble;
            Context context = binding.getRoot().getContext();
            UserService.Companion companion2 = UserService.INSTANCE;
            NobleInfo noble4 = uiModel.getNoble();
            if (noble4 != null && (level = noble4.getLevel()) != null) {
                i4 = level.intValue();
            } else {
                i4 = 0;
            }
            imageView2.setImageDrawable(a.getDrawable(context, companion2.getNobleDrawableRes(i4)));
            binding.iconNoble.setVisibility(0);
        } else {
            binding.iconNoble.setVisibility(8);
        }
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user == null || !user.isVip()) {
            z = false;
        }
        if (z) {
            binding.textShade.setVisibility(8);
            QMUIRadiusImageView qMUIRadiusImageView = binding.iconCircleImageView;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "iconCircleImageView");
            ImageKtxKt.loadImage$default(qMUIRadiusImageView, uiModel.getAvatar(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231930, (g) null, 49150, (Object) null);
            return;
        }
        binding.textShade.setVisibility(0);
        binding.videoCallButton.setVisibility(8);
        binding.likeCallButton.setVisibility(8);
        String avatar = uiModel.getAvatar();
        if (avatar == null) {
            avatar = "";
        }
        if (StringKtxKt.checkEndGif(avatar)) {
            D0 = Glide.with(binding.iconCircleImageView.getContext()).o(2131232432).q0(h.p0(new b(5, 5))).D0(binding.iconCircleImageView);
        } else {
            D0 = Glide.with(binding.iconCircleImageView.getContext()).q(avatar).q0(h.p0(new b(5, 5))).D0(binding.iconCircleImageView);
        }
        Intrinsics.checkNotNull(D0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<CellFansBinding> holder, @NotNull CellUIModel item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.CellFansBinding");
        CellFansBinding cellFansBinding = (CellFansBinding) dataBinding;
        if (item instanceof ILikeCellUIModel) {
            bindILike(cellFansBinding, (ILikeCellUIModel) item);
            return;
        }
        if (item instanceof LikeMeCellUIModel) {
            bindLikeMe(cellFansBinding, (LikeMeCellUIModel) item);
        } else if (item instanceof VisitorCellUIModel) {
            bindVisitor(cellFansBinding, (VisitorCellUIModel) item);
        } else if (item instanceof PraiseCellUIModel) {
            bindPraise(cellFansBinding, (PraiseCellUIModel) item);
        }
    }
}
