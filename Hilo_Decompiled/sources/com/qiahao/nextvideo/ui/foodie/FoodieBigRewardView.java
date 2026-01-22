package com.qiahao.nextvideo.ui.foodie;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.ViewFoodieBigRewardBinding;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\u000eJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/qiahao/nextvideo/ui/foodie/FoodieBigRewardView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "isShadow", "", "setPicture", "(Z)V", "Lcom/qiahao/nextvideo/ui/foodie/h;", "type", "configView", "(Lcom/qiahao/nextvideo/ui/foodie/h;)V", "setShadow", "()Z", "Lcom/qiahao/nextvideo/databinding/ViewFoodieBigRewardBinding;", "mBinding", "Lcom/qiahao/nextvideo/databinding/ViewFoodieBigRewardBinding;", "mType", "Lcom/qiahao/nextvideo/ui/foodie/h;", "mIsShadow", "Z", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FoodieBigRewardView extends FrameLayout {

    @NotNull
    private ViewFoodieBigRewardBinding mBinding;
    private boolean mIsShadow;

    @NotNull
    private h mType;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FoodieBigRewardView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void setPicture(boolean isShadow) {
        if (isShadow) {
            if (this.mType == h.VEGETABLE) {
                this.mBinding.ivImage.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.ic_foodie_vegetable_dark));
                return;
            } else {
                this.mBinding.ivImage.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.ic_foodie_meat_dark));
                return;
            }
        }
        if (this.mType == h.VEGETABLE) {
            this.mBinding.ivImage.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.ic_foodie_vegetable_light));
        } else {
            this.mBinding.ivImage.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.ic_foodie_meat_light));
        }
    }

    public final void configView(@NotNull h type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.mType = type;
        this.mIsShadow = false;
        this.mBinding.ivShadow.setVisibility(8);
        if (this.mType == h.VEGETABLE) {
            this.mBinding.tvRewardType.setText(ResourcesKtxKt.getStringById(this, 2131952763));
            this.mBinding.ivImage.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.ic_foodie_vegetable_light));
        } else {
            this.mBinding.tvRewardType.setText(ResourcesKtxKt.getStringById(this, 2131952762));
            this.mBinding.ivImage.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.ic_foodie_meat_light));
        }
    }

    /* renamed from: isShadow, reason: from getter */
    public final boolean getMIsShadow() {
        return this.mIsShadow;
    }

    public final void setShadow(boolean isShadow) {
        this.mIsShadow = isShadow;
        setPicture(isShadow);
        if (isShadow) {
            this.mBinding.ivShadow.setVisibility(0);
        } else {
            this.mBinding.ivShadow.setVisibility(8);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FoodieBigRewardView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ FoodieBigRewardView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FoodieBigRewardView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        ViewFoodieBigRewardBinding inflate = ViewFoodieBigRewardBinding.inflate(LayoutInflater.from(getContext()), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.mBinding = inflate;
        this.mType = h.VEGETABLE;
    }
}
