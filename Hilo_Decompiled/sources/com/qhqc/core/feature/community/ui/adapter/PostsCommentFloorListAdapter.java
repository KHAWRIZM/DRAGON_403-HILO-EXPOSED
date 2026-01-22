package com.qhqc.core.feature.community.ui.adapter;

import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;
import com.qhqc.core.basic.aws.ImageResizeKtKt;
import com.qhqc.core.basic.rvadapter.BasicLoadMoreVBAdapter;
import com.qhqc.core.basic.rvadapter.BasicViewBindingHolder;
import com.qhqc.core.feature.bean.UserInfoBean;
import com.qhqc.core.feature.bean.community.PostsCommentFloorBean;
import com.qhqc.core.feature.community.CommunityManager;
import com.qhqc.core.feature.community.CommunityUtils;
import com.qhqc.core.feature.community.IUserEvents;
import com.qhqc.core.feature.community.R;
import com.qhqc.core.feature.community.databinding.FeatureCommunityItemPostsCommentFloorListBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\n\u001a\u00020\u0002H\u0014J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J(\u0010\u0010\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¨\u0006\u0016"}, d2 = {"Lcom/qhqc/core/feature/community/ui/adapter/PostsCommentFloorListAdapter;", "Lcom/qhqc/core/basic/rvadapter/BasicLoadMoreVBAdapter;", "Lcom/qhqc/core/feature/bean/community/PostsCommentFloorBean;", "Lcom/qhqc/core/feature/community/databinding/FeatureCommunityItemPostsCommentFloorListBinding;", "<init>", "()V", "convert", "", "holder", "Lcom/qhqc/core/basic/rvadapter/BasicViewBindingHolder;", "item", "onCreateDefViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onCreateViewBinding", "layoutInflater", "Landroid/view/LayoutInflater;", "attachToParent", "", "UserClickableSpan", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPostsCommentFloorListAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PostsCommentFloorListAdapter.kt\ncom/qhqc/core/feature/community/ui/adapter/PostsCommentFloorListAdapter\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,123:1\n256#2,2:124\n256#2,2:126\n256#2,2:128\n256#2,2:130\n*S KotlinDebug\n*F\n+ 1 PostsCommentFloorListAdapter.kt\ncom/qhqc/core/feature/community/ui/adapter/PostsCommentFloorListAdapter\n*L\n49#1:124,2\n52#1:126,2\n58#1:128,2\n61#1:130,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PostsCommentFloorListAdapter extends BasicLoadMoreVBAdapter<PostsCommentFloorBean, FeatureCommunityItemPostsCommentFloorListBinding> {

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/qhqc/core/feature/community/ui/adapter/PostsCommentFloorListAdapter$UserClickableSpan;", "Landroid/text/style/ClickableSpan;", "user", "Lcom/qhqc/core/feature/bean/UserInfoBean;", "color", "", "<init>", "(Lcom/qhqc/core/feature/bean/UserInfoBean;I)V", "getUser", "()Lcom/qhqc/core/feature/bean/UserInfoBean;", "getColor", "()I", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class UserClickableSpan extends ClickableSpan {
        private final int color;

        @NotNull
        private final UserInfoBean user;

        public UserClickableSpan(@NotNull UserInfoBean user, int i10) {
            Intrinsics.checkNotNullParameter(user, "user");
            this.user = user;
            this.color = i10;
        }

        public final int getColor() {
            return this.color;
        }

        @NotNull
        public final UserInfoBean getUser() {
            return this.user;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            IUserEvents mUserEventsImpl = CommunityManager.INSTANCE.getInstance().getMUserEventsImpl();
            if (mUserEventsImpl != null) {
                mUserEventsImpl.onUserClick(this.user, widget);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds) {
            Intrinsics.checkNotNullParameter(ds, "ds");
            ds.setUnderlineText(false);
            ds.setColor(this.color);
        }
    }

    public PostsCommentFloorListAdapter() {
        addChildClickViewIds(R.id.mIvAvatar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean convert$lambda$5$lambda$3(PostsCommentFloorListAdapter postsCommentFloorListAdapter, FeatureCommunityItemPostsCommentFloorListBinding featureCommunityItemPostsCommentFloorListBinding, BasicViewBindingHolder basicViewBindingHolder, View view) {
        OnItemLongClickListener mOnItemLongClickListener = postsCommentFloorListAdapter.getMOnItemLongClickListener();
        if (mOnItemLongClickListener != null) {
            mOnItemLongClickListener.onItemLongClick(postsCommentFloorListAdapter, featureCommunityItemPostsCommentFloorListBinding.mTvContent, basicViewBindingHolder.getBindingAdapterPosition() - postsCommentFloorListAdapter.getHeaderLayoutCount());
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$5$lambda$4(PostsCommentFloorListAdapter postsCommentFloorListAdapter, FeatureCommunityItemPostsCommentFloorListBinding featureCommunityItemPostsCommentFloorListBinding, BasicViewBindingHolder basicViewBindingHolder, View view) {
        OnItemClickListener mOnItemClickListener = postsCommentFloorListAdapter.getMOnItemClickListener();
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(postsCommentFloorListAdapter, featureCommunityItemPostsCommentFloorListBinding.mTvContent, basicViewBindingHolder.getBindingAdapterPosition() - postsCommentFloorListAdapter.getHeaderLayoutCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull final BasicViewBindingHolder<FeatureCommunityItemPostsCommentFloorListBinding> holder, @NotNull PostsCommentFloorBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        final FeatureCommunityItemPostsCommentFloorListBinding viewBinding = holder.getViewBinding();
        UserInfoBean fromUser = item.getFromUser();
        if (fromUser != null) {
            com.bumptech.glide.i q10 = Glide.with(viewBinding.mIvAvatar).q(ImageResizeKtKt.imageResizeAvatar(fromUser.getAvatar()));
            int i10 = R.drawable.default_user_icon;
            ((com.bumptech.glide.i) ((com.bumptech.glide.i) q10.X(i10)).j(i10)).D0(viewBinding.mIvAvatar);
            viewBinding.mTvName.setText(fromUser.getNick());
            CommunityManager.Companion companion = CommunityManager.INSTANCE;
            Drawable sVipIcon = companion.getInstance().getSVipIcon(fromUser.getSvipLevel());
            if (sVipIcon != null) {
                AppCompatImageView mIvSvip = viewBinding.mIvSvip;
                Intrinsics.checkNotNullExpressionValue(mIvSvip, "mIvSvip");
                mIvSvip.setVisibility(0);
                viewBinding.mIvSvip.setImageDrawable(sVipIcon);
            } else {
                AppCompatImageView mIvSvip2 = viewBinding.mIvSvip;
                Intrinsics.checkNotNullExpressionValue(mIvSvip2, "mIvSvip");
                mIvSvip2.setVisibility(8);
            }
            Drawable vipIcon = companion.getInstance().getVipIcon(fromUser.getVipLevel());
            if (vipIcon != null) {
                AppCompatImageView mIvVip = viewBinding.mIvVip;
                Intrinsics.checkNotNullExpressionValue(mIvVip, "mIvVip");
                mIvVip.setVisibility(0);
                viewBinding.mIvVip.setImageDrawable(vipIcon);
            } else {
                AppCompatImageView mIvVip2 = viewBinding.mIvVip;
                Intrinsics.checkNotNullExpressionValue(mIvVip2, "mIvVip");
                mIvVip2.setVisibility(8);
            }
        }
        viewBinding.mTvContent.setText(item.getStrBuilder());
        viewBinding.mTvContent.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.qhqc.core.feature.community.ui.adapter.b
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean convert$lambda$5$lambda$3;
                convert$lambda$5$lambda$3 = PostsCommentFloorListAdapter.convert$lambda$5$lambda$3(PostsCommentFloorListAdapter.this, viewBinding, holder, view);
                return convert$lambda$5$lambda$3;
            }
        });
        viewBinding.mTvContent.setOnClickListener(new View.OnClickListener() { // from class: com.qhqc.core.feature.community.ui.adapter.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostsCommentFloorListAdapter.convert$lambda$5$lambda$4(PostsCommentFloorListAdapter.this, viewBinding, holder, view);
            }
        });
        viewBinding.mTvTime.setText(CommunityUtils.INSTANCE.getPostsTime(item.getCreatedAt()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qhqc.core.basic.rvadapter.BasicLoadMoreVBAdapter, com.chad.library.adapter.base.BaseQuickAdapter
    @NotNull
    public BasicViewBindingHolder<FeatureCommunityItemPostsCommentFloorListBinding> onCreateDefViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        BasicViewBindingHolder<FeatureCommunityItemPostsCommentFloorListBinding> onCreateDefViewHolder = super.onCreateDefViewHolder(parent, viewType);
        onCreateDefViewHolder.getViewBinding().mTvContent.setMovementMethod(LinkMovementMethod.getInstance());
        return onCreateDefViewHolder;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.qhqc.core.basic.rvadapter.BasicLoadMoreVBAdapter
    @NotNull
    public FeatureCommunityItemPostsCommentFloorListBinding onCreateViewBinding(@NotNull ViewGroup parent, int viewType, @NotNull LayoutInflater layoutInflater, boolean attachToParent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(layoutInflater, "layoutInflater");
        FeatureCommunityItemPostsCommentFloorListBinding inflate = FeatureCommunityItemPostsCommentFloorListBinding.inflate(layoutInflater, parent, attachToParent);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}
