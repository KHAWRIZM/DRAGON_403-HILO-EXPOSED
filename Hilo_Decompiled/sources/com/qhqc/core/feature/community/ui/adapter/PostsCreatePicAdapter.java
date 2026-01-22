package com.qhqc.core.feature.community.ui.adapter;

import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.qhqc.core.basic.ktx.CompatKtxKt;
import com.qhqc.core.basic.rvadapter.BasicVBAdapter;
import com.qhqc.core.basic.rvadapter.BasicViewBindingHolder;
import com.qhqc.core.basic.rvadapter.ItemTouchCallback;
import com.qhqc.core.feature.bean.community.PostsCreateMediaBean;
import com.qhqc.core.feature.community.R;
import com.qhqc.core.feature.community.databinding.FeatureCommunityItemPicPostsCreateBinding;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u001bB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0014J(\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0010H\u0016¨\u0006\u001c"}, d2 = {"Lcom/qhqc/core/feature/community/ui/adapter/PostsCreatePicAdapter;", "Lcom/qhqc/core/basic/rvadapter/BasicVBAdapter;", "Lcom/qhqc/core/feature/bean/community/PostsCreateMediaBean;", "Lcom/qhqc/core/feature/community/databinding/FeatureCommunityItemPicPostsCreateBinding;", "Lcom/qhqc/core/basic/rvadapter/ItemTouchCallback;", "<init>", "()V", "convert", "", "holder", "Lcom/qhqc/core/basic/rvadapter/BasicViewBindingHolder;", "item", "onCreateViewBinding", "parent", "Landroid/view/ViewGroup;", "viewType", "", "layoutInflater", "Landroid/view/LayoutInflater;", "attachToParent", "", "onItemDismiss", FirebaseAnalytics.Param.INDEX, NativeProtocol.WEB_DIALOG_ACTION, "onItemMove", "target", "onItemChange", "TouchCallback", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPostsCreatePicAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PostsCreatePicAdapter.kt\ncom/qhqc/core/feature/community/ui/adapter/PostsCreatePicAdapter\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,143:1\n256#2,2:144\n256#2,2:146\n*S KotlinDebug\n*F\n+ 1 PostsCreatePicAdapter.kt\ncom/qhqc/core/feature/community/ui/adapter/PostsCreatePicAdapter\n*L\n37#1:144,2\n40#1:146,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PostsCreatePicAdapter extends BasicVBAdapter<PostsCreateMediaBean, FeatureCommunityItemPicPostsCreateBinding> implements ItemTouchCallback {

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J@\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\rH\u0016J\u0018\u0010\u0018\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0007H\u0016J\b\u0010\u001a\u001a\u00020\rH\u0016J\b\u0010\u001b\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/qhqc/core/feature/community/ui/adapter/PostsCreatePicAdapter$TouchCallback;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "adapter", "Lcom/qhqc/core/feature/community/ui/adapter/PostsCreatePicAdapter;", "<init>", "(Lcom/qhqc/core/feature/community/ui/adapter/PostsCreatePicAdapter;)V", "getMovementFlags", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onMove", "", "target", "onChildDraw", "", "c", "Landroid/graphics/Canvas;", "dX", "", "dY", "actionState", "isCurrentlyActive", "onSwiped", "direction", "isItemViewSwipeEnabled", "isLongPressDragEnabled", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class TouchCallback extends ItemTouchHelper.Callback {

        @NotNull
        private final PostsCreatePicAdapter adapter;

        public TouchCallback(@NotNull PostsCreatePicAdapter adapter) {
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            this.adapter = adapter;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
            int i10;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            if (CollectionsKt.getLastIndex(this.adapter.getData()) == viewHolder.getBindingAdapterPosition() && this.adapter.getData().get(CollectionsKt.getLastIndex(this.adapter.getData())).isAddPic()) {
                i10 = 0;
            } else {
                i10 = 51;
            }
            return ItemTouchHelper.Callback.makeMovementFlags(i10, 0);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean isItemViewSwipeEnabled() {
            return false;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean isLongPressDragEnabled() {
            return true;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onChildDraw(@NotNull Canvas c10, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            Intrinsics.checkNotNullParameter(c10, "c");
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            if (this.adapter.getData().get(viewHolder.getBindingAdapterPosition()).isAddPic() && dX > DownloadProgress.UNKNOWN_PROGRESS) {
                super.onChildDraw(c10, recyclerView, viewHolder, DownloadProgress.UNKNOWN_PROGRESS, dY, actionState, isCurrentlyActive);
            } else {
                super.onChildDraw(c10, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            }
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean onMove(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder, @NotNull RecyclerView.ViewHolder target) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            Intrinsics.checkNotNullParameter(target, "target");
            if (this.adapter.getData().get(target.getBindingAdapterPosition()).isAddPic()) {
                return false;
            }
            this.adapter.onItemMove(viewHolder.getBindingAdapterPosition(), target.getBindingAdapterPosition());
            return true;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSwiped(@NotNull RecyclerView.ViewHolder viewHolder, int direction) {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        }
    }

    public PostsCreatePicAdapter() {
        addChildClickViewIds(R.id.mIvDel);
    }

    @Override // com.qhqc.core.basic.rvadapter.ItemTouchCallback
    public void onItemChange(int index) {
    }

    @Override // com.qhqc.core.basic.rvadapter.ItemTouchCallback
    public void onItemDismiss(int index, int action) {
    }

    @Override // com.qhqc.core.basic.rvadapter.ItemTouchCallback
    public void onItemMove(int index, int target) {
        if (index < getData().size() && target < getData().size()) {
            getData().add(target, getData().remove(index));
            notifyItemMoved(index, target);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BasicViewBindingHolder<FeatureCommunityItemPicPostsCreateBinding> holder, @NotNull PostsCreateMediaBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        FeatureCommunityItemPicPostsCreateBinding viewBinding = holder.getViewBinding();
        if (item.isAddPic()) {
            AppCompatImageView mIvDel = viewBinding.mIvDel;
            Intrinsics.checkNotNullExpressionValue(mIvDel, "mIvDel");
            mIvDel.setVisibility(8);
            viewBinding.mIvPic.setImageDrawable(CompatKtxKt.getDrawable(R.drawable.feature_community_ic_pic_add));
            return;
        }
        AppCompatImageView mIvDel2 = viewBinding.mIvDel;
        Intrinsics.checkNotNullExpressionValue(mIvDel2, "mIvDel");
        mIvDel2.setVisibility(0);
        Intrinsics.checkNotNull(Glide.with(viewBinding.mIvPic).q(item.getPath()).D0(viewBinding.mIvPic));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.qhqc.core.basic.rvadapter.BasicVBAdapter
    @NotNull
    public FeatureCommunityItemPicPostsCreateBinding onCreateViewBinding(@NotNull ViewGroup parent, int viewType, @NotNull LayoutInflater layoutInflater, boolean attachToParent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(layoutInflater, "layoutInflater");
        FeatureCommunityItemPicPostsCreateBinding inflate = FeatureCommunityItemPicPostsCreateBinding.inflate(layoutInflater, parent, attachToParent);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}
