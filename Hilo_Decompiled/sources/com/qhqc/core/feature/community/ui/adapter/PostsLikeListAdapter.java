package com.qhqc.core.feature.community.ui.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.oudi.utils.date.DateFormat;
import com.qhqc.core.basic.aws.ImageResizeKtKt;
import com.qhqc.core.basic.picture.glide.GlideConstant;
import com.qhqc.core.basic.rvadapter.BasicLoadMoreVBAdapter;
import com.qhqc.core.basic.rvadapter.BasicViewBindingHolder;
import com.qhqc.core.basic.utils.TimeUtils;
import com.qhqc.core.feature.bean.UserInfoBean;
import com.qhqc.core.feature.bean.community.PostsLikeBean;
import com.qhqc.core.feature.community.CommunityManager;
import com.qhqc.core.feature.community.R;
import com.qhqc.core.feature.community.databinding.FeatureCommunityItemPostsLikeListBinding;
import com.ruffian.library.widget.RTextView;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\n\u001a\u00020\u0002H\u0014J,\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\n\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0014J(\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¨\u0006\u0017"}, d2 = {"Lcom/qhqc/core/feature/community/ui/adapter/PostsLikeListAdapter;", "Lcom/qhqc/core/basic/rvadapter/BasicLoadMoreVBAdapter;", "Lcom/qhqc/core/feature/bean/community/PostsLikeBean;", "Lcom/qhqc/core/feature/community/databinding/FeatureCommunityItemPostsLikeListBinding;", "<init>", "()V", "convert", "", "holder", "Lcom/qhqc/core/basic/rvadapter/BasicViewBindingHolder;", "item", "payloads", "", "", "onCreateViewBinding", "parent", "Landroid/view/ViewGroup;", "viewType", "", "layoutInflater", "Landroid/view/LayoutInflater;", "attachToParent", "", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPostsLikeListAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PostsLikeListAdapter.kt\ncom/qhqc/core/feature/community/ui/adapter/PostsLikeListAdapter\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,100:1\n256#2,2:101\n256#2,2:103\n256#2,2:105\n256#2,2:107\n256#2,2:109\n256#2,2:112\n1863#3:111\n1864#3:114\n*S KotlinDebug\n*F\n+ 1 PostsLikeListAdapter.kt\ncom/qhqc/core/feature/community/ui/adapter/PostsLikeListAdapter\n*L\n45#1:101,2\n48#1:103,2\n54#1:105,2\n57#1:107,2\n65#1:109,2\n82#1:112,2\n79#1:111\n79#1:114\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PostsLikeListAdapter extends BasicLoadMoreVBAdapter<PostsLikeBean, FeatureCommunityItemPostsLikeListBinding> {
    public PostsLikeListAdapter() {
        addChildClickViewIds(R.id.mBtnFollowUser, R.id.mIvAvatar);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder baseViewHolder, Object obj, List list) {
        convert((BasicViewBindingHolder<FeatureCommunityItemPostsLikeListBinding>) baseViewHolder, (PostsLikeBean) obj, (List<? extends Object>) list);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.qhqc.core.basic.rvadapter.BasicLoadMoreVBAdapter
    @NotNull
    public FeatureCommunityItemPostsLikeListBinding onCreateViewBinding(@NotNull ViewGroup parent, int viewType, @NotNull LayoutInflater layoutInflater, boolean attachToParent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(layoutInflater, "layoutInflater");
        FeatureCommunityItemPostsLikeListBinding inflate = FeatureCommunityItemPostsLikeListBinding.inflate(layoutInflater, parent, attachToParent);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BasicViewBindingHolder<FeatureCommunityItemPostsLikeListBinding> holder, @NotNull PostsLikeBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        FeatureCommunityItemPostsLikeListBinding viewBinding = holder.getViewBinding();
        UserInfoBean user = item.getUser();
        if (user != null) {
            com.bumptech.glide.i q10 = Glide.with(viewBinding.mIvAvatar).q(ImageResizeKtKt.imageResizeAvatar(user.getAvatar()));
            GlideConstant glideConstant = GlideConstant.INSTANCE;
            ((com.bumptech.glide.i) ((com.bumptech.glide.i) q10.X(glideConstant.getAVATAR_PRELOAD())).X(glideConstant.getAVATAR_PRELOAD())).D0(viewBinding.mIvAvatar);
            viewBinding.mTvName.setText(user.getNick());
            CommunityManager.Companion companion = CommunityManager.INSTANCE;
            Drawable sVipIcon = companion.getInstance().getSVipIcon(user.getSvipLevel());
            if (sVipIcon != null) {
                AppCompatImageView mIvSVip = viewBinding.mIvSVip;
                Intrinsics.checkNotNullExpressionValue(mIvSVip, "mIvSVip");
                mIvSVip.setVisibility(0);
                viewBinding.mIvSVip.setImageDrawable(sVipIcon);
            } else {
                AppCompatImageView mIvSVip2 = viewBinding.mIvSVip;
                Intrinsics.checkNotNullExpressionValue(mIvSVip2, "mIvSVip");
                mIvSVip2.setVisibility(8);
            }
            Drawable vipIcon = companion.getInstance().getVipIcon(user.getVipLevel());
            if (vipIcon != null) {
                AppCompatImageView mIvNoble = viewBinding.mIvNoble;
                Intrinsics.checkNotNullExpressionValue(mIvNoble, "mIvNoble");
                mIvNoble.setVisibility(0);
                viewBinding.mIvNoble.setImageDrawable(vipIcon);
            } else {
                AppCompatImageView mIvNoble2 = viewBinding.mIvNoble;
                Intrinsics.checkNotNullExpressionValue(mIvNoble2, "mIvNoble");
                mIvNoble2.setVisibility(8);
            }
            viewBinding.mViewGender.setData(user.getSex(), user.getAge(), user.isShowAge());
        }
        RTextView mBtnFollowUser = viewBinding.mBtnFollowUser;
        Intrinsics.checkNotNullExpressionValue(mBtnFollowUser, "mBtnFollowUser");
        mBtnFollowUser.setVisibility(item.isFollowUser() ? 8 : 0);
        viewBinding.mTvTime.setText(TimeUtils.dateFormat$default(TimeUtils.INSTANCE, item.getLikeCreatedAt() / 1000, DateFormat.YMD_HM, (Locale) null, 4, (Object) null));
    }

    protected void convert(@NotNull BasicViewBindingHolder<FeatureCommunityItemPostsLikeListBinding> holder, @NotNull PostsLikeBean item, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (payloads.isEmpty()) {
            return;
        }
        Iterator<T> it = payloads.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next(), (Object) 12289)) {
                RTextView mBtnFollowUser = holder.getViewBinding().mBtnFollowUser;
                Intrinsics.checkNotNullExpressionValue(mBtnFollowUser, "mBtnFollowUser");
                mBtnFollowUser.setVisibility(!item.isFollowUser() ? 0 : 8);
            }
        }
    }
}
