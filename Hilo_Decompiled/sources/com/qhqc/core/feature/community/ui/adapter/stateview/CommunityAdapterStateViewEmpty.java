package com.qhqc.core.feature.community.ui.adapter.stateview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qhqc.core.basic.ktx.CompatKtxKt;
import com.qhqc.core.basic.rvadapter.IBasicAdapterStateViewEmpty;
import com.qhqc.core.feature.community.R;
import com.qhqc.core.feature.community.databinding.FeatureCommunityAdapterStateViewEmptyBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/qhqc/core/feature/community/ui/adapter/stateview/CommunityAdapterStateViewEmpty;", "Lcom/qhqc/core/basic/rvadapter/IBasicAdapterStateViewEmpty;", "<init>", "()V", "mBinding", "Lcom/qhqc/core/feature/community/databinding/FeatureCommunityAdapterStateViewEmptyBinding;", "onCreateView", "Landroid/view/View;", "context", "Landroid/content/Context;", "getIconView", "Landroid/widget/ImageView;", "getContentView", "Landroid/widget/TextView;", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class CommunityAdapterStateViewEmpty implements IBasicAdapterStateViewEmpty {

    @Nullable
    private FeatureCommunityAdapterStateViewEmptyBinding mBinding;

    @Override // com.qhqc.core.basic.rvadapter.IBasicAdapterStateViewEmpty
    @Nullable
    public TextView getContentView() {
        FeatureCommunityAdapterStateViewEmptyBinding featureCommunityAdapterStateViewEmptyBinding = this.mBinding;
        if (featureCommunityAdapterStateViewEmptyBinding != null) {
            return featureCommunityAdapterStateViewEmptyBinding.content;
        }
        return null;
    }

    @Override // com.qhqc.core.basic.rvadapter.IBasicAdapterStateViewEmpty
    @Nullable
    public ImageView getIconView() {
        FeatureCommunityAdapterStateViewEmptyBinding featureCommunityAdapterStateViewEmptyBinding = this.mBinding;
        if (featureCommunityAdapterStateViewEmptyBinding != null) {
            return featureCommunityAdapterStateViewEmptyBinding.image;
        }
        return null;
    }

    @Override // com.qhqc.core.basic.rvadapter.IBasicAdapterStateView
    @NotNull
    public View onCreateView(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        FeatureCommunityAdapterStateViewEmptyBinding inflate = FeatureCommunityAdapterStateViewEmptyBinding.inflate(LayoutInflater.from(context));
        this.mBinding = inflate;
        inflate.image.setImageDrawable(CompatKtxKt.getDrawable(R.drawable.icon_community_empty));
        ConstraintLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }
}
