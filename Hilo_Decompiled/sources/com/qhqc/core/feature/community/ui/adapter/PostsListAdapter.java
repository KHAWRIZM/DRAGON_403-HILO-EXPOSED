package com.qhqc.core.feature.community.ui.adapter;

import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.qhqc.core.basic.ktx.CompatKtxKt;
import com.qhqc.core.basic.rvadapter.BasicLoadMoreMultipleItemAdapter;
import com.qhqc.core.feature.bean.community.PostsInfoBean;
import com.qhqc.core.feature.community.R;
import com.qhqc.core.feature.community.databinding.FeatureCommunityItemPostsListBinding;
import com.qhqc.core.feature.community.widget.PostsContentView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0002J.\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0002H\u0014J&\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0014J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H\u0014R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/qhqc/core/feature/community/ui/adapter/PostsListAdapter;", "Lcom/qhqc/core/basic/rvadapter/BasicLoadMoreMultipleItemAdapter;", "Lcom/qhqc/core/feature/bean/community/PostsInfoBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "<init>", "()V", "onViewClickListener", "Lcom/qhqc/core/feature/community/widget/PostsContentView$OnClickListener;", "getOnViewClickListener", "()Lcom/qhqc/core/feature/community/widget/PostsContentView$OnClickListener;", "setOnViewClickListener", "(Lcom/qhqc/core/feature/community/widget/PostsContentView$OnClickListener;)V", "convert", "", "holder", "binding", "Lcom/qhqc/core/feature/community/databinding/FeatureCommunityItemPostsListBinding;", "item", "convertPayload", "payloads", "", "", "onItemViewHolderCreated", "viewHolder", "viewType", "", "Companion", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPostsListAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PostsListAdapter.kt\ncom/qhqc/core/feature/community/ui/adapter/PostsListAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,123:1\n1863#2,2:124\n*S KotlinDebug\n*F\n+ 1 PostsListAdapter.kt\ncom/qhqc/core/feature/community/ui/adapter/PostsListAdapter\n*L\n59#1:124,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PostsListAdapter extends BasicLoadMoreMultipleItemAdapter<PostsInfoBean, BaseViewHolder> {
    public static final int STYLE_DEF = 0;
    public static final int STYLE_GRID_1 = 1;
    public static final int STYLE_GRID_2 = 2;
    public static final int STYLE_GRID_3 = 3;
    public static final int STYLE_GRID_4 = 4;

    @Nullable
    private PostsContentView.OnClickListener onViewClickListener;

    public PostsListAdapter() {
        super(null, 1, null);
        getStateHelper().setDefEmptyViewIcon(CompatKtxKt.getDrawable(R.drawable.icon_community_empty));
        getStateHelper().setDefEmptyViewContent(CompatKtxKt.getString(R.string.feature_community_posts_no_posts));
        int i10 = R.layout.feature_community_item_posts_list;
        addItemType(0, i10);
        addItemType(1, i10);
        addItemType(2, i10);
        addItemType(3, i10);
        addItemType(4, i10);
    }

    private final void convertPayload(BaseViewHolder holder, FeatureCommunityItemPostsListBinding binding, PostsInfoBean item, List<? extends Object> payloads) {
        if (payloads.isEmpty()) {
            return;
        }
        for (Object obj : payloads) {
            if (Intrinsics.areEqual(obj, (Object) 4098)) {
                binding.mViewPostContent.likeChanged(item, true);
            } else if (Intrinsics.areEqual(obj, (Object) 4097)) {
                binding.mViewPostContent.commentCountChanged(item);
            } else if (Intrinsics.areEqual(obj, (Object) 12289)) {
                binding.mViewPostContent.followUser(item);
            } else if (Intrinsics.areEqual(obj, (Object) 4100)) {
                binding.mViewPostContent.showMoreContent();
            }
        }
    }

    @Nullable
    public final PostsContentView.OnClickListener getOnViewClickListener() {
        return this.onViewClickListener;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    protected void onItemViewHolderCreated(@NotNull BaseViewHolder viewHolder, int viewType) {
        FeatureCommunityItemPostsListBinding featureCommunityItemPostsListBinding;
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if ((viewType == 0 || viewType == 1 || viewType == 2 || viewType == 3 || viewType == 4) && (featureCommunityItemPostsListBinding = (FeatureCommunityItemPostsListBinding) androidx.databinding.g.a(viewHolder.itemView)) != null) {
            featureCommunityItemPostsListBinding.mViewPostContent.setStyle(viewType);
        }
    }

    public final void setOnViewClickListener(@Nullable PostsContentView.OnClickListener onClickListener) {
        this.onViewClickListener = onClickListener;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder baseViewHolder, Object obj, List list) {
        convert(baseViewHolder, (PostsInfoBean) obj, (List<? extends Object>) list);
    }

    private final void convert(BaseViewHolder holder, FeatureCommunityItemPostsListBinding binding, PostsInfoBean item) {
        binding.mViewPostContent.setOnViewClickListener(this.onViewClickListener);
        binding.mViewPostContent.setData(item, holder.getBindingAdapterPosition() - getHeaderLayoutCount());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseViewHolder holder, @NotNull PostsInfoBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        FeatureCommunityItemPostsListBinding featureCommunityItemPostsListBinding = (FeatureCommunityItemPostsListBinding) androidx.databinding.g.f(holder.itemView);
        if (featureCommunityItemPostsListBinding != null) {
            convert(holder, featureCommunityItemPostsListBinding, item);
        }
    }

    protected void convert(@NotNull BaseViewHolder holder, @NotNull PostsInfoBean item, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        FeatureCommunityItemPostsListBinding featureCommunityItemPostsListBinding = (FeatureCommunityItemPostsListBinding) androidx.databinding.g.f(holder.itemView);
        if (featureCommunityItemPostsListBinding != null) {
            convertPayload(holder, featureCommunityItemPostsListBinding, item, payloads);
        }
    }
}
