package com.qiahao.nextvideo.ui.matchinghistoric.adapter;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.CellHistoryUserInformationSummaryBinding;
import com.qiahao.nextvideo.ui.login.VerificationCodeFragment;
import com.qiahao.nextvideo.ui.matchinghistoric.ProfileDetailUIModel;
import com.qiahao.nextvideo.ui.reusable.views.CorneredImageView;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;
import com.qiahao.nextvideo.utilities.ResourceUtilsKt;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/qiahao/nextvideo/ui/matchinghistoric/adapter/UserInformationSummaryPagerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/qiahao/nextvideo/databinding/CellHistoryUserInformationSummaryBinding;", "<init>", "(Lcom/qiahao/nextvideo/databinding/CellHistoryUserInformationSummaryBinding;)V", "getBinding", "()Lcom/qiahao/nextvideo/databinding/CellHistoryUserInformationSummaryBinding;", VerificationCodeFragment.TYPE_BIND, "", "uiModelProfile", "Lcom/qiahao/nextvideo/ui/matchinghistoric/ProfileDetailUIModel;", "SimpleOnGestureListener", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class UserInformationSummaryPagerViewHolder extends RecyclerView.ViewHolder {

    @NotNull
    private final CellHistoryUserInformationSummaryBinding binding;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/qiahao/nextvideo/ui/matchinghistoric/adapter/UserInformationSummaryPagerViewHolder$SimpleOnGestureListener;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "<init>", "()V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static abstract class SimpleOnGestureListener extends GestureDetector.SimpleOnGestureListener {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserInformationSummaryPagerViewHolder(@NotNull CellHistoryUserInformationSummaryBinding cellHistoryUserInformationSummaryBinding) {
        super(cellHistoryUserInformationSummaryBinding.getRoot());
        Intrinsics.checkNotNullParameter(cellHistoryUserInformationSummaryBinding, "binding");
        this.binding = cellHistoryUserInformationSummaryBinding;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void bind(@NotNull ProfileDetailUIModel uiModelProfile) {
        int i;
        Intrinsics.checkNotNullParameter(uiModelProfile, "uiModelProfile");
        Resources resources = this.binding.getRoot().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        Drawable drawable = ResourceUtilsKt.getDrawable(resources, uiModelProfile.getSexIconResId(), 0);
        this.binding.likedImageButton.setSelected(uiModelProfile.isLike());
        CellHistoryUserInformationSummaryBinding cellHistoryUserInformationSummaryBinding = this.binding;
        AppCompatImageButton appCompatImageButton = cellHistoryUserInformationSummaryBinding.likedImageButton;
        Resources resources2 = cellHistoryUserInformationSummaryBinding.getRoot().getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "getResources(...)");
        if (uiModelProfile.isLikeMe() && uiModelProfile.isLike()) {
            i = R.drawable.ic_history_like_each;
        } else if (uiModelProfile.isLike()) {
            i = R.drawable.ic_history_liked;
        } else {
            i = R.drawable.ic_history_unlike;
        }
        appCompatImageButton.setImageDrawable(ResourceUtilsKt.getDrawable(resources2, i, 0));
        CorneredImageView corneredImageView = this.binding.userProfilePictureCorneredImageView;
        Intrinsics.checkNotNullExpressionValue(corneredImageView, "userProfilePictureCorneredImageView");
        ViewUtilitiesKt.bind$default(corneredImageView, uiModelProfile.getImageUIModel(), null, 2, null);
        this.binding.nicknameTextView.setText(uiModelProfile.getNickname());
        this.binding.countryProvinceTextView.setText(uiModelProfile.getCountryName());
        this.binding.matchingTimeTextView.setText(uiModelProfile.getPairedDate());
        AppCompatTextView appCompatTextView = this.binding.ageTextView;
        CharSequence age = uiModelProfile.getAge();
        if (age == null) {
            age = "";
        }
        appCompatTextView.setText(age);
        this.binding.ageTextView.setBackgroundResource(uiModelProfile.getSexBackgroundResID());
        GenderAgeTextView genderAgeTextView = this.binding.ageTextView;
        Intrinsics.checkNotNullExpressionValue(genderAgeTextView, "ageTextView");
        ViewUtilitiesKt.setDrawableLeft(genderAgeTextView, drawable);
    }

    @NotNull
    public final CellHistoryUserInformationSummaryBinding getBinding() {
        return this.binding;
    }
}
