package com.qhqc.core.feature.community.ui.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.qhqc.core.basic.aws.ImageResizeKtKt;
import com.qhqc.core.basic.ktx.CompatKtxKt;
import com.qhqc.core.basic.rvadapter.BasicLoadMoreVBAdapter;
import com.qhqc.core.basic.rvadapter.BasicViewBindingHolder;
import com.qhqc.core.feature.bean.UserInfoBean;
import com.qhqc.core.feature.bean.community.PostsCommentBean;
import com.qhqc.core.feature.bean.community.PostsCommentFloorBean;
import com.qhqc.core.feature.community.CommunityManager;
import com.qhqc.core.feature.community.CommunityUtils;
import com.qhqc.core.feature.community.R;
import com.qhqc.core.feature.community.databinding.FeatureCommunityItemPostsCommentListBinding;
import com.qhqc.core.feature.community.events.CommentEvent;
import com.ruffian.library.widget.RLinearLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0014J,\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0014J\u001e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH\u0002J\u001e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH\u0002J(\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006 "}, d2 = {"Lcom/qhqc/core/feature/community/ui/adapter/PostsCommentListAdapter;", "Lcom/qhqc/core/basic/rvadapter/BasicLoadMoreVBAdapter;", "Lcom/qhqc/core/feature/bean/community/PostsCommentBean;", "Lcom/qhqc/core/feature/community/databinding/FeatureCommunityItemPostsCommentListBinding;", "<init>", "()V", "onClickListener", "Lcom/qhqc/core/feature/community/ui/adapter/PostsCommentListAdapter$OnClickListener;", "getOnClickListener", "()Lcom/qhqc/core/feature/community/ui/adapter/PostsCommentListAdapter$OnClickListener;", "setOnClickListener", "(Lcom/qhqc/core/feature/community/ui/adapter/PostsCommentListAdapter$OnClickListener;)V", "convert", "", "holder", "Lcom/qhqc/core/basic/rvadapter/BasicViewBindingHolder;", "item", "payloads", "", "", "setCommentLike", "setCommentFloorList", "onCreateViewBinding", "parent", "Landroid/view/ViewGroup;", "viewType", "", "layoutInflater", "Landroid/view/LayoutInflater;", "attachToParent", "", "OnClickListener", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPostsCommentListAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PostsCommentListAdapter.kt\ncom/qhqc/core/feature/community/ui/adapter/PostsCommentListAdapter\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,261:1\n256#2,2:262\n256#2,2:264\n256#2,2:266\n256#2,2:268\n256#2,2:270\n256#2,2:272\n256#2,2:276\n256#2,2:278\n256#2,2:280\n1863#3,2:274\n*S KotlinDebug\n*F\n+ 1 PostsCommentListAdapter.kt\ncom/qhqc/core/feature/community/ui/adapter/PostsCommentListAdapter\n*L\n86#1:262,2\n89#1:264,2\n95#1:266,2\n98#1:268,2\n106#1:270,2\n108#1:272,2\n161#1:276,2\n163#1:278,2\n206#1:280,2\n124#1:274,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PostsCommentListAdapter extends BasicLoadMoreVBAdapter<PostsCommentBean, FeatureCommunityItemPostsCommentListBinding> {

    @Nullable
    private OnClickListener onClickListener;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J8\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH&J(\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J8\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0016¨\u0006\u0015"}, d2 = {"Lcom/qhqc/core/feature/community/ui/adapter/PostsCommentListAdapter$OnClickListener;", "", "onCommentClick", "", "adapter", "Lcom/qhqc/core/feature/community/ui/adapter/PostsCommentListAdapter;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "item", "Lcom/qhqc/core/feature/bean/community/PostsCommentBean;", "position", "", "onCommentFloorClick", "Lcom/qhqc/core/feature/community/ui/adapter/PostsCommentFloorListAdapter;", "itemComment", "positionComment", "itemCommentFloor", "Lcom/qhqc/core/feature/bean/community/PostsCommentFloorBean;", "positionCommentFloor", "onCommentLongClick", "onCommentFloorLongClick", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface OnClickListener {

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        public static final class DefaultImpls {
            public static void onCommentFloorLongClick(@NotNull OnClickListener onClickListener, @NotNull PostsCommentFloorListAdapter adapter, @NotNull View view, @NotNull PostsCommentBean itemComment, int i10, @NotNull PostsCommentFloorBean itemCommentFloor, int i11) {
                Intrinsics.checkNotNullParameter(adapter, "adapter");
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(itemComment, "itemComment");
                Intrinsics.checkNotNullParameter(itemCommentFloor, "itemCommentFloor");
            }

            public static void onCommentLongClick(@NotNull OnClickListener onClickListener, @NotNull PostsCommentListAdapter adapter, @NotNull View view, @NotNull PostsCommentBean item, int i10) {
                Intrinsics.checkNotNullParameter(adapter, "adapter");
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(item, "item");
            }
        }

        void onCommentClick(@NotNull PostsCommentListAdapter adapter, @NotNull View view, @NotNull PostsCommentBean item, int position);

        void onCommentFloorClick(@NotNull PostsCommentFloorListAdapter adapter, @NotNull View view, @NotNull PostsCommentBean itemComment, int positionComment, @NotNull PostsCommentFloorBean itemCommentFloor, int positionCommentFloor);

        void onCommentFloorLongClick(@NotNull PostsCommentFloorListAdapter adapter, @NotNull View view, @NotNull PostsCommentBean itemComment, int positionComment, @NotNull PostsCommentFloorBean itemCommentFloor, int positionCommentFloor);

        void onCommentLongClick(@NotNull PostsCommentListAdapter adapter, @NotNull View view, @NotNull PostsCommentBean item, int position);
    }

    public PostsCommentListAdapter() {
        getStateHelper().setDefEmptyViewIcon(null);
        getStateHelper().setDefEmptyViewContent(CompatKtxKt.getString(R.string.feature_community_posts_no_comments));
        addChildClickViewIds(R.id.mViewMoreCom, R.id.mIvAvatar);
        setOnItemClickListener(new OnItemClickListener() { // from class: com.qhqc.core.feature.community.ui.adapter.d
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
                PostsCommentListAdapter._init_$lambda$0(PostsCommentListAdapter.this, baseQuickAdapter, view, i10);
            }
        });
        setOnItemLongClickListener(new OnItemLongClickListener() { // from class: com.qhqc.core.feature.community.ui.adapter.e
            @Override // com.chad.library.adapter.base.listener.OnItemLongClickListener
            public final boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
                boolean _init_$lambda$1;
                _init_$lambda$1 = PostsCommentListAdapter._init_$lambda$1(PostsCommentListAdapter.this, baseQuickAdapter, view, i10);
                return _init_$lambda$1;
            }
        });
        setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qhqc.core.feature.community.ui.adapter.f
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
                PostsCommentListAdapter._init_$lambda$2(PostsCommentListAdapter.this, baseQuickAdapter, view, i10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(PostsCommentListAdapter postsCommentListAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "view");
        OnClickListener onClickListener = postsCommentListAdapter.onClickListener;
        if (onClickListener != null) {
            onClickListener.onCommentClick(postsCommentListAdapter, view, postsCommentListAdapter.getItem(i10), i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$1(PostsCommentListAdapter postsCommentListAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "view");
        OnClickListener onClickListener = postsCommentListAdapter.onClickListener;
        if (onClickListener != null) {
            onClickListener.onCommentLongClick(postsCommentListAdapter, view, postsCommentListAdapter.getItem(i10), i10);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(PostsCommentListAdapter postsCommentListAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "view");
        OnClickListener onClickListener = postsCommentListAdapter.onClickListener;
        if (onClickListener != null) {
            onClickListener.onCommentClick(postsCommentListAdapter, view, postsCommentListAdapter.getItem(i10), i10);
        }
    }

    private final void setCommentFloorList(final PostsCommentBean item, final BasicViewBindingHolder<FeatureCommunityItemPostsCommentListBinding> holder) {
        final PostsCommentFloorListAdapter postsCommentFloorListAdapter;
        int i10;
        boolean z10;
        FeatureCommunityItemPostsCommentListBinding viewBinding = holder.getViewBinding();
        List<PostsCommentFloorBean> subComments = item.getSubComments();
        int i11 = 8;
        if (subComments != null && !subComments.isEmpty()) {
            RLinearLayout mViewCommentFloor = viewBinding.mViewCommentFloor;
            Intrinsics.checkNotNullExpressionValue(mViewCommentFloor, "mViewCommentFloor");
            mViewCommentFloor.setVisibility(0);
            if (!(viewBinding.mRVFloor.getAdapter() instanceof PostsCommentFloorListAdapter)) {
                viewBinding.mRVFloor.setNestedScrollingEnabled(false);
                viewBinding.mRVFloor.setLayoutManager(new LinearLayoutManager(getContext()));
                viewBinding.mRVFloor.setAdapter(new PostsCommentFloorListAdapter());
            }
        } else {
            RLinearLayout mViewCommentFloor2 = viewBinding.mViewCommentFloor;
            Intrinsics.checkNotNullExpressionValue(mViewCommentFloor2, "mViewCommentFloor");
            mViewCommentFloor2.setVisibility(8);
        }
        RecyclerView.Adapter adapter = viewBinding.mRVFloor.getAdapter();
        if (adapter instanceof PostsCommentFloorListAdapter) {
            postsCommentFloorListAdapter = (PostsCommentFloorListAdapter) adapter;
        } else {
            postsCommentFloorListAdapter = null;
        }
        if (postsCommentFloorListAdapter != null) {
            postsCommentFloorListAdapter.setList(item.getSubComments());
            postsCommentFloorListAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.qhqc.core.feature.community.ui.adapter.g
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i12) {
                    PostsCommentListAdapter.setCommentFloorList$lambda$12$lambda$11$lambda$8(PostsCommentListAdapter.this, postsCommentFloorListAdapter, item, holder, baseQuickAdapter, view, i12);
                }
            });
            postsCommentFloorListAdapter.setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qhqc.core.feature.community.ui.adapter.h
                @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
                public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i12) {
                    PostsCommentListAdapter.setCommentFloorList$lambda$12$lambda$11$lambda$9(PostsCommentListAdapter.this, postsCommentFloorListAdapter, item, holder, baseQuickAdapter, view, i12);
                }
            });
            postsCommentFloorListAdapter.setOnItemLongClickListener(new OnItemLongClickListener() { // from class: com.qhqc.core.feature.community.ui.adapter.i
                @Override // com.chad.library.adapter.base.listener.OnItemLongClickListener
                public final boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i12) {
                    boolean commentFloorList$lambda$12$lambda$11$lambda$10;
                    commentFloorList$lambda$12$lambda$11$lambda$10 = PostsCommentListAdapter.setCommentFloorList$lambda$12$lambda$11$lambda$10(PostsCommentListAdapter.this, postsCommentFloorListAdapter, item, holder, baseQuickAdapter, view, i12);
                    return commentFloorList$lambda$12$lambda$11$lambda$10;
                }
            });
            AppCompatTextView mViewMoreCom = viewBinding.mViewMoreCom;
            Intrinsics.checkNotNullExpressionValue(mViewMoreCom, "mViewMoreCom");
            int subCommentCnt = item.getSubCommentCnt();
            List<PostsCommentFloorBean> subComments2 = item.getSubComments();
            if (subComments2 != null) {
                i10 = subComments2.size();
            } else {
                i10 = 0;
            }
            if (subCommentCnt > i10) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                i11 = 0;
            }
            mViewMoreCom.setVisibility(i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setCommentFloorList$lambda$12$lambda$11$lambda$10(PostsCommentListAdapter postsCommentListAdapter, PostsCommentFloorListAdapter postsCommentFloorListAdapter, PostsCommentBean postsCommentBean, BasicViewBindingHolder basicViewBindingHolder, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "view");
        OnClickListener onClickListener = postsCommentListAdapter.onClickListener;
        if (onClickListener != null) {
            onClickListener.onCommentFloorLongClick(postsCommentFloorListAdapter, view, postsCommentBean, basicViewBindingHolder.getBindingAdapterPosition() - postsCommentListAdapter.getHeaderLayoutCount(), postsCommentFloorListAdapter.getItem(i10), i10);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setCommentFloorList$lambda$12$lambda$11$lambda$8(PostsCommentListAdapter postsCommentListAdapter, PostsCommentFloorListAdapter postsCommentFloorListAdapter, PostsCommentBean postsCommentBean, BasicViewBindingHolder basicViewBindingHolder, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "view");
        OnClickListener onClickListener = postsCommentListAdapter.onClickListener;
        if (onClickListener != null) {
            onClickListener.onCommentFloorClick(postsCommentFloorListAdapter, view, postsCommentBean, basicViewBindingHolder.getBindingAdapterPosition() - postsCommentListAdapter.getHeaderLayoutCount(), postsCommentFloorListAdapter.getItem(i10), i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setCommentFloorList$lambda$12$lambda$11$lambda$9(PostsCommentListAdapter postsCommentListAdapter, PostsCommentFloorListAdapter postsCommentFloorListAdapter, PostsCommentBean postsCommentBean, BasicViewBindingHolder basicViewBindingHolder, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "view");
        OnClickListener onClickListener = postsCommentListAdapter.onClickListener;
        if (onClickListener != null) {
            onClickListener.onCommentFloorClick(postsCommentFloorListAdapter, view, postsCommentBean, basicViewBindingHolder.getBindingAdapterPosition() - postsCommentListAdapter.getHeaderLayoutCount(), postsCommentFloorListAdapter.getItem(i10), i10);
        }
    }

    private final void setCommentLike(PostsCommentBean item, BasicViewBindingHolder<FeatureCommunityItemPostsCommentListBinding> holder) {
    }

    @Nullable
    public final OnClickListener getOnClickListener() {
        return this.onClickListener;
    }

    public final void setOnClickListener(@Nullable OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder baseViewHolder, Object obj, List list) {
        convert((BasicViewBindingHolder<FeatureCommunityItemPostsCommentListBinding>) baseViewHolder, (PostsCommentBean) obj, (List<? extends Object>) list);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.qhqc.core.basic.rvadapter.BasicLoadMoreVBAdapter
    @NotNull
    public FeatureCommunityItemPostsCommentListBinding onCreateViewBinding(@NotNull ViewGroup parent, int viewType, @NotNull LayoutInflater layoutInflater, boolean attachToParent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(layoutInflater, "layoutInflater");
        FeatureCommunityItemPostsCommentListBinding inflate = FeatureCommunityItemPostsCommentListBinding.inflate(layoutInflater, parent, attachToParent);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BasicViewBindingHolder<FeatureCommunityItemPostsCommentListBinding> holder, @NotNull PostsCommentBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        FeatureCommunityItemPostsCommentListBinding viewBinding = holder.getViewBinding();
        UserInfoBean user = item.getUser();
        if (user != null) {
            com.bumptech.glide.i q10 = Glide.with(viewBinding.mIvAvatar).q(ImageResizeKtKt.imageResizeAvatar(user.getAvatar()));
            int i10 = R.drawable.default_user_icon;
            ((com.bumptech.glide.i) ((com.bumptech.glide.i) q10.X(i10)).j(i10)).D0(viewBinding.mIvAvatar);
            viewBinding.mTvName.setText(user.getNick());
            CommunityManager.Companion companion = CommunityManager.INSTANCE;
            Drawable sVipIcon = companion.getInstance().getSVipIcon(user.getSvipLevel());
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
            Drawable vipIcon = companion.getInstance().getVipIcon(user.getVipLevel());
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
        viewBinding.mTvTime.setText(CommunityUtils.INSTANCE.getPostsTime(item.getCreatedAt()));
        String content = item.getContent();
        if (content != null && content.length() != 0) {
            TextView mTvContent = viewBinding.mTvContent;
            Intrinsics.checkNotNullExpressionValue(mTvContent, "mTvContent");
            mTvContent.setVisibility(0);
            viewBinding.mTvContent.setText(item.getContent());
        } else {
            TextView mTvContent2 = viewBinding.mTvContent;
            Intrinsics.checkNotNullExpressionValue(mTvContent2, "mTvContent");
            mTvContent2.setVisibility(8);
        }
        setCommentFloorList(item, holder);
        setCommentLike(item, holder);
    }

    protected void convert(@NotNull BasicViewBindingHolder<FeatureCommunityItemPostsCommentListBinding> holder, @NotNull PostsCommentBean item, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (payloads.isEmpty()) {
            return;
        }
        for (Object obj : payloads) {
            if (Intrinsics.areEqual(obj, Integer.valueOf(CommentEvent.EVENT_LIKE))) {
                setCommentLike(item, holder);
            } else if (!Intrinsics.areEqual(obj, Integer.valueOf(CommentEvent.EVENT_REPLY)) && !Intrinsics.areEqual(obj, Integer.valueOf(CommentEvent.EVENT_REPLY_FLOOR))) {
                if (Intrinsics.areEqual(obj, (Object) 8197)) {
                    setCommentFloorList(item, holder);
                } else if (Intrinsics.areEqual(obj, Integer.valueOf(CommentEvent.EVENT_COMMENT_FLOOR_DELETED))) {
                    setCommentFloorList(item, holder);
                }
            } else {
                setCommentFloorList(item, holder);
            }
        }
    }
}
