package com.qhqc.core.feature.community.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import com.qhqc.core.basic.aws.ImageResizeKtKt;
import com.qhqc.core.basic.picture.glide.GlideConstant;
import com.qhqc.core.basic.rvadapter.BasicVBAdapter;
import com.qhqc.core.basic.rvadapter.BasicViewBindingHolder;
import com.qhqc.core.feature.bean.UserInfoBean;
import com.qhqc.core.feature.community.databinding.FeatureCommunityItemPostsListLikeUserAvatarBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\n\u001a\u00020\u0002H\u0014J(\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0014"}, d2 = {"Lcom/qhqc/core/feature/community/ui/adapter/PostsListLikeUserAvatarAdapter;", "Lcom/qhqc/core/basic/rvadapter/BasicVBAdapter;", "Lcom/qhqc/core/feature/bean/UserInfoBean;", "Lcom/qhqc/core/feature/community/databinding/FeatureCommunityItemPostsListLikeUserAvatarBinding;", "<init>", "()V", "convert", "", "holder", "Lcom/qhqc/core/basic/rvadapter/BasicViewBindingHolder;", "item", "onCreateViewBinding", "parent", "Landroid/view/ViewGroup;", "viewType", "", "layoutInflater", "Landroid/view/LayoutInflater;", "attachToParent", "", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PostsListLikeUserAvatarAdapter extends BasicVBAdapter<UserInfoBean, FeatureCommunityItemPostsListLikeUserAvatarBinding> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BasicViewBindingHolder<FeatureCommunityItemPostsListLikeUserAvatarBinding> holder, @NotNull UserInfoBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        FeatureCommunityItemPostsListLikeUserAvatarBinding viewBinding = holder.getViewBinding();
        com.bumptech.glide.i q10 = Glide.with(viewBinding.mIvAvatar).q(ImageResizeKtKt.imageResizeAvatar(item.getAvatar()));
        GlideConstant glideConstant = GlideConstant.INSTANCE;
        ((com.bumptech.glide.i) ((com.bumptech.glide.i) q10.X(glideConstant.getCOLOR_PRELOAD())).X(glideConstant.getCOLOR_PRELOAD())).D0(viewBinding.mIvAvatar);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.qhqc.core.basic.rvadapter.BasicVBAdapter
    @NotNull
    public FeatureCommunityItemPostsListLikeUserAvatarBinding onCreateViewBinding(@NotNull ViewGroup parent, int viewType, @NotNull LayoutInflater layoutInflater, boolean attachToParent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(layoutInflater, "layoutInflater");
        FeatureCommunityItemPostsListLikeUserAvatarBinding inflate = FeatureCommunityItemPostsListLikeUserAvatarBinding.inflate(layoutInflater, parent, attachToParent);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}
