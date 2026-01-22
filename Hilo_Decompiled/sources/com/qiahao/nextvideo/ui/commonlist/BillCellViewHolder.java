package com.qiahao.nextvideo.ui.commonlist;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.a;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.core.support.ActivityLifecycleManager;
import com.qiahao.nextvideo.databinding.CellBillBinding;
import com.qiahao.nextvideo.ui.login.VerificationCodeFragment;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.ui.reusable.views.list.ViewHolder;
import com.qiahao.nextvideo.utilities.ResourceUtilsKt;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/ui/commonlist/BillCellViewHolder;", "Lcom/qiahao/nextvideo/ui/reusable/views/list/ViewHolder;", "binding", "Lcom/qiahao/nextvideo/databinding/CellBillBinding;", "<init>", "(Lcom/qiahao/nextvideo/databinding/CellBillBinding;)V", "getBinding", "()Lcom/qiahao/nextvideo/databinding/CellBillBinding;", VerificationCodeFragment.TYPE_BIND, "", "uiModel", "Lcom/qiahao/nextvideo/ui/commonlist/CommonListCellUIModel;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBillCellViewHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BillCellViewHolder.kt\ncom/qiahao/nextvideo/ui/commonlist/BillCellViewHolder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,98:1\n1#2:99\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class BillCellViewHolder extends ViewHolder {

    @NotNull
    private final CellBillBinding binding;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BillCellViewHolder(@NotNull CellBillBinding cellBillBinding) {
        super(r0);
        Intrinsics.checkNotNullParameter(cellBillBinding, "binding");
        View root = cellBillBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        this.binding = cellBillBinding;
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public final void bind(@NotNull CommonListCellUIModel uiModel) {
        Integer imageRes;
        Intrinsics.checkNotNullParameter(uiModel, "uiModel");
        ImageUIModel iconCircleDisplayImageUIModel = uiModel.getIconCircleDisplayImageUIModel();
        Drawable drawable = null;
        if (iconCircleDisplayImageUIModel != null) {
            AppCompatImageView appCompatImageView = this.binding.iconCircleImageView;
            appCompatImageView.setVisibility(0);
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "apply(...)");
            ViewUtilitiesKt.bind$default(appCompatImageView, iconCircleDisplayImageUIModel, null, 2, null);
        }
        String iconCircleR2TTagText = uiModel.getIconCircleR2TTagText();
        if (iconCircleR2TTagText != null) {
            AppCompatTextView appCompatTextView = this.binding.iconCircleR2TTextView;
            appCompatTextView.setVisibility(0);
            appCompatTextView.setText(iconCircleR2TTagText);
        }
        Integer titleDrawableStart = uiModel.getTitleDrawableStart();
        if (titleDrawableStart != null) {
            int intValue = titleDrawableStart.intValue();
            AppCompatTextView appCompatTextView2 = this.binding.titleTextView;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView2, "titleTextView");
            Resources resources = ((RecyclerView.ViewHolder) this).itemView.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            ViewUtilitiesKt.setDrawableLeft(appCompatTextView2, ResourceUtilsKt.getDrawable(resources, intValue, 0));
        }
        if (uiModel.getEndTopText() != null) {
            this.binding.endTopTextView.setVisibility(0);
            this.binding.endTopTextView.setText(uiModel.getEndTopText());
        }
        String title = uiModel.getTitle();
        if (title != null) {
            AppCompatTextView appCompatTextView3 = this.binding.titleTextView;
            appCompatTextView3.setVisibility(0);
            appCompatTextView3.setText(title);
        }
        this.binding.titleTextView.setTypeface(uiModel.getTitleTextStyle());
        CharSequence titleRightTagText = uiModel.getTitleRightTagText();
        if (titleRightTagText != null) {
            AppCompatTextView appCompatTextView4 = this.binding.titleRightTagTextView;
            appCompatTextView4.setVisibility(0);
            appCompatTextView4.setText(titleRightTagText);
        }
        Integer titleRightTagDrawable = uiModel.getTitleRightTagDrawable();
        if (titleRightTagDrawable != null) {
            int intValue2 = titleRightTagDrawable.intValue();
            AppCompatTextView appCompatTextView5 = this.binding.titleRightTagTextView;
            appCompatTextView5.setVisibility(0);
            appCompatTextView5.setCompoundDrawablesWithIntrinsicBounds(a.getDrawable(this.binding.getRoot().getContext(), intValue2), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        Integer titleRightTagBackgroundResID = uiModel.getTitleRightTagBackgroundResID();
        if (titleRightTagBackgroundResID != null) {
            int intValue3 = titleRightTagBackgroundResID.intValue();
            this.binding.titleRightTagTextView.setVisibility(0);
            this.binding.titleRightTagTextView.setBackgroundResource(intValue3);
        }
        Integer titleTextColor = uiModel.getTitleTextColor();
        if (titleTextColor != null) {
            this.binding.titleTextView.setTextColor(titleTextColor.intValue());
        }
        String subtitle = uiModel.getSubtitle();
        if (subtitle != null) {
            AppCompatTextView appCompatTextView6 = this.binding.subtitleTextView;
            appCompatTextView6.setVisibility(0);
            appCompatTextView6.setText(subtitle);
        }
        ImageUIModel subtitleLeftIconImageUIModel = uiModel.getSubtitleLeftIconImageUIModel();
        if (subtitleLeftIconImageUIModel != null) {
            AppCompatImageView appCompatImageView2 = this.binding.subtitleLeftIconImageView;
            appCompatImageView2.setVisibility(0);
            Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "apply(...)");
            ViewUtilitiesKt.bind$default(appCompatImageView2, subtitleLeftIconImageUIModel, null, 2, null);
        }
        Integer subtitleTextColor = uiModel.getSubtitleTextColor();
        if (subtitleTextColor != null) {
            this.binding.subtitleTextView.setTextColor(subtitleTextColor.intValue());
        }
        if (uiModel.getEndTextSize() != null) {
            this.binding.endTextView.setTextSize(r0.intValue());
        }
        Integer endTextColor = uiModel.getEndTextColor();
        if (endTextColor != null) {
            this.binding.endTextView.setTextColor(endTextColor.intValue());
        }
        ImageUIModel endIconDisplayImageUIModel = uiModel.getEndIconDisplayImageUIModel();
        if (endIconDisplayImageUIModel != null) {
            this.binding.endIconImageView.setVisibility(0);
            AppCompatImageView appCompatImageView3 = this.binding.endIconImageView;
            Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
            if (currentActivity != null && (imageRes = endIconDisplayImageUIModel.getImageRes()) != null) {
                drawable = a.getDrawable(currentActivity, imageRes.intValue());
            }
            appCompatImageView3.setImageDrawable(drawable);
        }
        String endIconClickTag = uiModel.getEndIconClickTag();
        if (endIconClickTag != null) {
            this.binding.endIconImageView.setTag(endIconClickTag);
        }
        String endText = uiModel.getEndText();
        if (endText != null) {
            AppCompatTextView appCompatTextView7 = this.binding.endTextView;
            appCompatTextView7.setVisibility(0);
            appCompatTextView7.setText(endText);
        }
    }

    @NotNull
    public final CellBillBinding getBinding() {
        return this.binding;
    }
}
