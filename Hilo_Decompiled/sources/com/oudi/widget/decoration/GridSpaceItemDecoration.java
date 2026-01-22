package com.oudi.widget.decoration;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/oudi/widget/decoration/GridSpaceItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "space", "", "includeEdge", "", "<init>", "(IZ)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class GridSpaceItemDecoration extends RecyclerView.ItemDecoration {
    private final boolean includeEdge;
    private final int space;

    public /* synthetic */ GridSpaceItemDecoration(int i10, boolean z10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10, (i11 & 2) != 0 ? false : z10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        int i10;
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        if (parent.getLayoutManager() instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) parent.getLayoutManager();
            Intrinsics.checkNotNull(gridLayoutManager);
            i10 = gridLayoutManager.getSpanCount();
        } else if (parent.getLayoutManager() instanceof StaggeredGridLayoutManager) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) parent.getLayoutManager();
            Intrinsics.checkNotNull(staggeredGridLayoutManager);
            i10 = staggeredGridLayoutManager.getSpanCount();
        } else {
            i10 = 0;
        }
        if (i10 == 0) {
            return;
        }
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        int i11 = childAdapterPosition % i10;
        if (this.includeEdge) {
            int i12 = this.space;
            outRect.left = i12 - ((i11 * i12) / i10);
            outRect.right = ((i11 + 1) * i12) / i10;
            if (childAdapterPosition < i10) {
                outRect.top = i12;
            }
            outRect.bottom = i12;
            return;
        }
        int i13 = this.space;
        outRect.left = (i11 * i13) / i10;
        outRect.right = i13 - (((i11 + 1) * i13) / i10);
        if (childAdapterPosition >= i10) {
            outRect.top = i13;
        }
    }

    public GridSpaceItemDecoration(int i10, boolean z10) {
        this.space = i10;
        this.includeEdge = z10;
    }
}
