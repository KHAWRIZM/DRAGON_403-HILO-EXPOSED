package com.qiahao.nextvideo.ui.reusable.views.recyclerview;

import android.view.View;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\u0010\u001a\u00020\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u000e\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0011R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/recyclerview/PagerGridSnapHelper;", "Landroidx/recyclerview/widget/SnapHelper;", "<init>", "()V", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "attachToRecyclerView", "", "recyclerView", "calculateDistanceToFinalSnap", "", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "targetView", "Landroid/view/View;", "findSnapView", "findTargetSnapPosition", "", "velocityX", "velocityY", "onFling", "", "snapFromFling", "createSnapScroller", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "setFlingThreshold", "threshold", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PagerGridSnapHelper extends SnapHelper {

    @Nullable
    private RecyclerView mRecyclerView;

    private final boolean snapFromFling(RecyclerView.LayoutManager layoutManager, int velocityX, int velocityY) {
        LinearSmoothScroller createSnapScroller;
        int findTargetSnapPosition;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (createSnapScroller = createSnapScroller(layoutManager)) == null || (findTargetSnapPosition = findTargetSnapPosition(layoutManager, velocityX, velocityY)) == -1) {
            return false;
        }
        createSnapScroller.setTargetPosition(findTargetSnapPosition);
        layoutManager.startSmoothScroll(createSnapScroller);
        return true;
    }

    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) throws IllegalStateException {
        super.attachToRecyclerView(recyclerView);
        this.mRecyclerView = recyclerView;
    }

    @Nullable
    public int[] calculateDistanceToFinalSnap(@NotNull RecyclerView.LayoutManager layoutManager, @NotNull View targetView) {
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        int position = layoutManager.getPosition(targetView);
        int[] iArr = new int[2];
        if (layoutManager instanceof PagerGridLayoutManager) {
            return ((PagerGridLayoutManager) layoutManager).getSnapOffset$app_googleRelease(position);
        }
        return iArr;
    }

    @Nullable
    protected LinearSmoothScroller createSnapScroller(@NotNull RecyclerView.LayoutManager layoutManager) {
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider)) {
            return null;
        }
        RecyclerView recyclerView = this.mRecyclerView;
        Intrinsics.checkNotNull(recyclerView);
        return new PagerGridSmoothScroller(recyclerView);
    }

    @Nullable
    public View findSnapView(@NotNull RecyclerView.LayoutManager layoutManager) {
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        if (layoutManager instanceof PagerGridLayoutManager) {
            return ((PagerGridLayoutManager) layoutManager).findSnapView();
        }
        return null;
    }

    public int findTargetSnapPosition(@Nullable RecyclerView.LayoutManager layoutManager, int velocityX, int velocityY) {
        if (layoutManager != null && (layoutManager instanceof PagerGridLayoutManager)) {
            PagerGridLayoutManager pagerGridLayoutManager = (PagerGridLayoutManager) layoutManager;
            if (pagerGridLayoutManager.canScrollHorizontally()) {
                PagerConfig pagerConfig = PagerConfig.INSTANCE;
                if (velocityX > pagerConfig.getFlingThreshold()) {
                    return pagerGridLayoutManager.findNextPageFirstPos$app_googleRelease();
                }
                if (velocityX < (-pagerConfig.getFlingThreshold())) {
                    return pagerGridLayoutManager.findPrePageFirstPos$app_googleRelease();
                }
            } else if (pagerGridLayoutManager.canScrollVertically()) {
                PagerConfig pagerConfig2 = PagerConfig.INSTANCE;
                if (velocityY > pagerConfig2.getFlingThreshold()) {
                    return pagerGridLayoutManager.findNextPageFirstPos$app_googleRelease();
                }
                if (velocityY < (-pagerConfig2.getFlingThreshold())) {
                    return pagerGridLayoutManager.findPrePageFirstPos$app_googleRelease();
                }
            }
        }
        return -1;
    }

    public boolean onFling(int velocityX, int velocityY) {
        RecyclerView recyclerView = this.mRecyclerView;
        Intrinsics.checkNotNull(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
            return false;
        }
        RecyclerView recyclerView2 = this.mRecyclerView;
        Intrinsics.checkNotNull(recyclerView2);
        if (recyclerView2.getAdapter() == null) {
            return false;
        }
        int flingThreshold = PagerConfig.INSTANCE.getFlingThreshold();
        if ((Math.abs(velocityY) <= flingThreshold && Math.abs(velocityX) <= flingThreshold) || !snapFromFling(layoutManager, velocityX, velocityY)) {
            return false;
        }
        return true;
    }

    public final void setFlingThreshold(int threshold) {
        PagerConfig.INSTANCE.setFlingThreshold(threshold);
    }
}
