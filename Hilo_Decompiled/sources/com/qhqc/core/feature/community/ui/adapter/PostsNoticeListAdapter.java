package com.qhqc.core.feature.community.ui.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bumptech.glide.Glide;
import com.qhqc.core.basic.aws.ImageResizeKtKt;
import com.qhqc.core.basic.ktx.CompatKtxKt;
import com.qhqc.core.basic.ktx.DisplayKtxKt;
import com.qhqc.core.basic.picture.glide.GlideConstant;
import com.qhqc.core.basic.rvadapter.BasicLoadMoreVBAdapter;
import com.qhqc.core.basic.rvadapter.BasicViewBindingHolder;
import com.qhqc.core.feature.bean.UserInfoBean;
import com.qhqc.core.feature.bean.community.PostsNoticeBean;
import com.qhqc.core.feature.community.CommunityManager;
import com.qhqc.core.feature.community.CommunityUtils;
import com.qhqc.core.feature.community.R;
import com.qhqc.core.feature.community.databinding.FeatureCommunityItemPostsNoticeBinding;
import com.ruffian.library.widget.RImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\n\u001a\u00020\u0002H\u0014J(\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0014"}, d2 = {"Lcom/qhqc/core/feature/community/ui/adapter/PostsNoticeListAdapter;", "Lcom/qhqc/core/basic/rvadapter/BasicLoadMoreVBAdapter;", "Lcom/qhqc/core/feature/bean/community/PostsNoticeBean;", "Lcom/qhqc/core/feature/community/databinding/FeatureCommunityItemPostsNoticeBinding;", "<init>", "()V", "convert", "", "holder", "Lcom/qhqc/core/basic/rvadapter/BasicViewBindingHolder;", "item", "onCreateViewBinding", "parent", "Landroid/view/ViewGroup;", "viewType", "", "layoutInflater", "Landroid/view/LayoutInflater;", "attachToParent", "", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPostsNoticeListAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PostsNoticeListAdapter.kt\ncom/qhqc/core/feature/community/ui/adapter/PostsNoticeListAdapter\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,96:1\n256#2,2:97\n256#2,2:99\n256#2,2:101\n256#2,2:103\n256#2,2:105\n256#2,2:107\n256#2,2:109\n*S KotlinDebug\n*F\n+ 1 PostsNoticeListAdapter.kt\ncom/qhqc/core/feature/community/ui/adapter/PostsNoticeListAdapter\n*L\n52#1:97,2\n55#1:99,2\n61#1:101,2\n64#1:103,2\n69#1:105,2\n73#1:107,2\n75#1:109,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PostsNoticeListAdapter extends BasicLoadMoreVBAdapter<PostsNoticeBean, FeatureCommunityItemPostsNoticeBinding> {
    public PostsNoticeListAdapter() {
        getStateHelper().setDefEmptyViewIcon(CompatKtxKt.getDrawable(R.drawable.icon_community_empty));
        addChildClickViewIds(R.id.mIvAvatar, R.id.mViewInfos);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BasicViewBindingHolder<FeatureCommunityItemPostsNoticeBinding> holder, @NotNull PostsNoticeBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        FeatureCommunityItemPostsNoticeBinding viewBinding = holder.getViewBinding();
        UserInfoBean user = item.getUser();
        if (user != null) {
            viewBinding.mIvAvatar.loadData(user);
            viewBinding.mTvName.setText(user.getNick());
            viewBinding.mViewGender.setData(user.getSex(), user.getAge(), user.isShowAge());
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
        }
        TextView mTvHistory = viewBinding.mTvHistory;
        Intrinsics.checkNotNullExpressionValue(mTvHistory, "mTvHistory");
        mTvHistory.setVisibility(item.isFirstHistory() ? 0 : 8);
        viewBinding.mTvContent.setText(item.getContentShow());
        viewBinding.mTvTime.setText(CommunityUtils.INSTANCE.getPostsTime(item.getCreatedAt()));
        String targetContent = item.getTargetContent();
        if (targetContent != null && targetContent.length() != 0) {
            RImageView mIvPostsPic = viewBinding.mIvPostsPic;
            Intrinsics.checkNotNullExpressionValue(mIvPostsPic, "mIvPostsPic");
            mIvPostsPic.setVisibility(0);
            com.bumptech.glide.i q10 = Glide.with(viewBinding.mIvPostsPic).q(ImageResizeKtKt.imageResizeWH(item.getTargetContent(), DisplayKtxKt.getDp(50), DisplayKtxKt.getDp(50)));
            GlideConstant glideConstant = GlideConstant.INSTANCE;
            Intrinsics.checkNotNull(((com.bumptech.glide.i) ((com.bumptech.glide.i) q10.X(glideConstant.getCOLOR_PRELOAD())).j(glideConstant.getCOLOR_PRELOAD())).D0(viewBinding.mIvPostsPic));
            return;
        }
        RImageView mIvPostsPic2 = viewBinding.mIvPostsPic;
        Intrinsics.checkNotNullExpressionValue(mIvPostsPic2, "mIvPostsPic");
        mIvPostsPic2.setVisibility(8);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.qhqc.core.basic.rvadapter.BasicLoadMoreVBAdapter
    @NotNull
    public FeatureCommunityItemPostsNoticeBinding onCreateViewBinding(@NotNull ViewGroup parent, int viewType, @NotNull LayoutInflater layoutInflater, boolean attachToParent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(layoutInflater, "layoutInflater");
        FeatureCommunityItemPostsNoticeBinding inflate = FeatureCommunityItemPostsNoticeBinding.inflate(layoutInflater, parent, attachToParent);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}
