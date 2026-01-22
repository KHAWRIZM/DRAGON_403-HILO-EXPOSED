package com.qiahao.nextvideo.ui.reusable.views.recyclerview;

import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/recyclerview/PagerGridSmoothScroller;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "onTargetFound", "", "targetView", "Landroid/view/View;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "action", "Landroidx/recyclerview/widget/RecyclerView$SmoothScroller$Action;", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PagerGridSmoothScroller extends LinearSmoothScroller {

    @NotNull
    private final RecyclerView mRecyclerView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerGridSmoothScroller(@NotNull RecyclerView recyclerView) {
        super(recyclerView.getContext());
        Intrinsics.checkNotNullParameter(recyclerView, "mRecyclerView");
        this.mRecyclerView = recyclerView;
    }

    protected float calculateSpeedPerPixel(@NotNull DisplayMetrics displayMetrics) {
        Intrinsics.checkNotNullParameter(displayMetrics, "displayMetrics");
        return PagerConfig.INSTANCE.getMillisecondsPreInch() / displayMetrics.densityDpi;
    }

    protected void onTargetFound(@NotNull View targetView, @NotNull RecyclerView.State state, @NotNull RecyclerView.SmoothScroller.Action action) {
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        if (layoutManager != null && (layoutManager instanceof PagerGridLayoutManager)) {
            int[] snapOffset$app_googleRelease = ((PagerGridLayoutManager) layoutManager).getSnapOffset$app_googleRelease(this.mRecyclerView.getChildAdapterPosition(targetView));
            int i = snapOffset$app_googleRelease[0];
            int i2 = snapOffset$app_googleRelease[1];
            int calculateTimeForScrolling = calculateTimeForScrolling(Math.max(Math.abs(i), Math.abs(i2)));
            if (calculateTimeForScrolling > 0) {
                action.update(i, i2, calculateTimeForScrolling, ((LinearSmoothScroller) this).mDecelerateInterpolator);
            }
        }
    }
}
