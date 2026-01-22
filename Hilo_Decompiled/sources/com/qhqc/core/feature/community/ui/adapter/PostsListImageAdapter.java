package com.qhqc.core.feature.community.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.Glide;
import com.facebook.internal.security.CertificateUtil;
import com.qhqc.core.basic.aws.ImageResizeKtKt;
import com.qhqc.core.basic.picture.glide.GlideConstant;
import com.qhqc.core.basic.rvadapter.BasicVBAdapter;
import com.qhqc.core.basic.rvadapter.BasicViewBindingHolder;
import com.qhqc.core.feature.bean.community.PostsInfoMediaBean;
import com.qhqc.core.feature.community.databinding.FeatureCommunityItemPostsMediaListBinding;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005J\u001e\u0010\u0012\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0014J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005H\u0014J(\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0016\u0010\u001f\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/qhqc/core/feature/community/ui/adapter/PostsListImageAdapter;", "Lcom/qhqc/core/basic/rvadapter/BasicVBAdapter;", "Lcom/qhqc/core/feature/bean/community/PostsInfoMediaBean;", "Lcom/qhqc/core/feature/community/databinding/FeatureCommunityItemPostsMediaListBinding;", "style", "", "<init>", "(I)V", "mResizeW", "mResizeH", "mResizeImageW", "mResizeImageH", "mRatio", "", "resizeImageSize", "", "resizeW", "resizeH", "convert", "holder", "Lcom/qhqc/core/basic/rvadapter/BasicViewBindingHolder;", "item", "onCreateDefViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onCreateViewBinding", "layoutInflater", "Landroid/view/LayoutInflater;", "attachToParent", "", "onViewRecycled", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PostsListImageAdapter extends BasicVBAdapter<PostsInfoMediaBean, FeatureCommunityItemPostsMediaListBinding> {
    private float mRatio;
    private int mResizeH;
    private int mResizeImageH;
    private int mResizeImageW;
    private int mResizeW;
    private final int style;

    public PostsListImageAdapter(int i10) {
        this.style = i10;
    }

    public final void resizeImageSize(int resizeW, int resizeH) {
        if (resizeW > 0 && resizeH > 0) {
            this.mResizeW = resizeW;
            this.mResizeH = resizeH;
            this.mResizeImageW = resizeW;
            this.mResizeImageH = resizeH;
            this.mRatio = resizeW / resizeH;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BasicViewBindingHolder<FeatureCommunityItemPostsMediaListBinding> holder, @NotNull PostsInfoMediaBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        FeatureCommunityItemPostsMediaListBinding viewBinding = holder.getViewBinding();
        ViewGroup.LayoutParams layoutParams = viewBinding.mViewContainer.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = this.mResizeW;
            viewBinding.mViewContainer.setLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = viewBinding.mIv.getLayoutParams();
        ConstraintLayout.b bVar = layoutParams2 instanceof ConstraintLayout.b ? (ConstraintLayout.b) layoutParams2 : null;
        if (bVar != null) {
            bVar.I = "H," + this.mResizeW + CertificateUtil.DELIMITER + this.mResizeH;
            viewBinding.mIv.setLayoutParams(bVar);
        }
        if (this.style == 1 && ((this.mResizeImageW > item.getWidth() || this.mResizeImageH > item.getHeight()) && this.mRatio != DownloadProgress.UNKNOWN_PROGRESS && item.getWidth() > 0 && item.getHeight() > 0)) {
            if (this.mResizeImageW > item.getWidth()) {
                int width = item.getWidth();
                this.mResizeImageW = width;
                this.mResizeImageH = (int) ((width / this.mRatio) + 0.5f);
            } else {
                int height = item.getHeight();
                this.mResizeImageH = height;
                this.mResizeImageW = (int) ((height * this.mRatio) + 0.5f);
            }
        }
        com.bumptech.glide.i q10 = Glide.with(viewBinding.mIv).q(ImageResizeKtKt.imageResizeWH(item.getUrl(), this.mResizeImageW, this.mResizeImageH));
        GlideConstant glideConstant = GlideConstant.INSTANCE;
        ((com.bumptech.glide.i) ((com.bumptech.glide.i) q10.X(glideConstant.getCOLOR_PRELOAD())).j(glideConstant.getCOLOR_PRELOAD())).D0(viewBinding.mIv);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qhqc.core.basic.rvadapter.BasicVBAdapter, com.chad.library.adapter.base.BaseQuickAdapter
    @NotNull
    public BasicViewBindingHolder<FeatureCommunityItemPostsMediaListBinding> onCreateDefViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        BasicViewBindingHolder<FeatureCommunityItemPostsMediaListBinding> onCreateDefViewHolder = super.onCreateDefViewHolder(parent, viewType);
        if (this.style == 1) {
            onCreateDefViewHolder.getViewBinding().mIv.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        return onCreateDefViewHolder;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.qhqc.core.basic.rvadapter.BasicVBAdapter
    @NotNull
    public FeatureCommunityItemPostsMediaListBinding onCreateViewBinding(@NotNull ViewGroup parent, int viewType, @NotNull LayoutInflater layoutInflater, boolean attachToParent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(layoutInflater, "layoutInflater");
        FeatureCommunityItemPostsMediaListBinding inflate = FeatureCommunityItemPostsMediaListBinding.inflate(layoutInflater, parent, attachToParent);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NotNull BasicViewBindingHolder<FeatureCommunityItemPostsMediaListBinding> holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewRecycled((PostsListImageAdapter) holder);
        FeatureCommunityItemPostsMediaListBinding viewBinding = holder.getViewBinding();
        Glide.with(viewBinding.mIv).e(viewBinding.mIv);
    }
}
