package com.qhqc.core.feature.community.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.qhqc.core.basic.ktx.CompatKtxKt;
import com.qhqc.core.feature.community.R;
import com.qhqc.core.feature.community.databinding.FeatureCommunityWidgetGenderAgeBinding;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/qhqc/core/feature/community/widget/GenderAgeView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defAttrStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBgColorsMale", "", "mBgColorsFemale", "mBgColorsUnKnow", "binding", "Lcom/qhqc/core/feature/community/databinding/FeatureCommunityWidgetGenderAgeBinding;", "setData", "", "gender", "age", "isShowAge", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGenderAgeView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GenderAgeView.kt\ncom/qhqc/core/feature/community/widget/GenderAgeView\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,66:1\n256#2,2:67\n256#2,2:69\n256#2,2:71\n*S KotlinDebug\n*F\n+ 1 GenderAgeView.kt\ncom/qhqc/core/feature/community/widget/GenderAgeView\n*L\n38#1:67,2\n41#1:69,2\n44#1:71,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class GenderAgeView extends FrameLayout {

    @NotNull
    private final FeatureCommunityWidgetGenderAgeBinding binding;

    @NotNull
    private final int[] mBgColorsFemale;

    @NotNull
    private final int[] mBgColorsMale;

    @NotNull
    private final int[] mBgColorsUnKnow;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GenderAgeView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @SuppressLint({"SetTextI18n"})
    public final void setData(int gender, int age, int isShowAge) {
        FeatureCommunityWidgetGenderAgeBinding featureCommunityWidgetGenderAgeBinding = this.binding;
        if (age <= 0) {
            TextView mTvAge = featureCommunityWidgetGenderAgeBinding.mTvAge;
            Intrinsics.checkNotNullExpressionValue(mTvAge, "mTvAge");
            mTvAge.setVisibility(8);
        } else if (isShowAge == 1) {
            TextView mTvAge2 = featureCommunityWidgetGenderAgeBinding.mTvAge;
            Intrinsics.checkNotNullExpressionValue(mTvAge2, "mTvAge");
            mTvAge2.setVisibility(0);
            featureCommunityWidgetGenderAgeBinding.mTvAge.setText(String.valueOf(age));
        } else {
            TextView mTvAge3 = featureCommunityWidgetGenderAgeBinding.mTvAge;
            Intrinsics.checkNotNullExpressionValue(mTvAge3, "mTvAge");
            mTvAge3.setVisibility(8);
        }
        if (gender != 1) {
            if (gender != 2) {
                featureCommunityWidgetGenderAgeBinding.mIvGender.setImageDrawable(CompatKtxKt.getDrawable(R.drawable.feature_community_ic_gender_unknow));
                featureCommunityWidgetGenderAgeBinding.mViewContent.getHelper().n(this.mBgColorsUnKnow);
                return;
            } else {
                featureCommunityWidgetGenderAgeBinding.mIvGender.setImageDrawable(CompatKtxKt.getDrawable(R.drawable.feature_community_ic_gender_female));
                featureCommunityWidgetGenderAgeBinding.mViewContent.getHelper().n(this.mBgColorsFemale);
                return;
            }
        }
        featureCommunityWidgetGenderAgeBinding.mIvGender.setImageDrawable(CompatKtxKt.getDrawable(R.drawable.feature_community_ic_gender_male));
        featureCommunityWidgetGenderAgeBinding.mViewContent.getHelper().n(this.mBgColorsMale);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GenderAgeView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GenderAgeView(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GenderAgeView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mBgColorsMale = new int[]{Color.parseColor("#5FC6FB"), Color.parseColor("#5FC6FB")};
        this.mBgColorsFemale = new int[]{Color.parseColor("#FF71B3"), Color.parseColor("#FF71B3")};
        this.mBgColorsUnKnow = new int[]{Color.parseColor("#5DF2A0"), Color.parseColor("#04C199")};
        FeatureCommunityWidgetGenderAgeBinding inflate = FeatureCommunityWidgetGenderAgeBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
    }
}
