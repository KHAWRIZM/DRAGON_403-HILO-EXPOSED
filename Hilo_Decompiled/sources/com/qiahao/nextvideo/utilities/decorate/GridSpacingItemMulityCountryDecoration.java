package com.qiahao.nextvideo.utilities.decorate;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.tencent.qcloud.tuicore.component.activities.ImageSelectActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/qiahao/nextvideo/utilities/decorate/GridSpacingItemMulityCountryDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", ImageSelectActivity.SPAN_COUNT, "", "spacing", "includeEdge", "", "<init>", "(IIZ)V", "getSpanCount", "()I", "getSpacing", "getIncludeEdge", "()Z", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GridSpacingItemMulityCountryDecoration extends RecyclerView.ItemDecoration {
    private final boolean includeEdge;
    private final int spacing;
    private final int spanCount;

    public /* synthetic */ GridSpacingItemMulityCountryDecoration(int i, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? false : z);
    }

    public final boolean getIncludeEdge() {
        return this.includeEdge;
    }

    public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        int i = childAdapterPosition % this.spanCount;
        if (this.includeEdge) {
            if (ViewUtilitiesKt.getRightToLeftDirection()) {
                int i2 = this.spacing;
                int i3 = this.spanCount;
                outRect.left = ((i + 1) * i2) / i3;
                outRect.right = i2 - ((i * i2) / i3);
            } else {
                int i4 = this.spacing;
                int i5 = this.spanCount;
                outRect.left = i4 - ((i * i4) / i5);
                outRect.right = ((i + 1) * i4) / i5;
            }
            if (childAdapterPosition < this.spanCount) {
                outRect.top = this.spacing;
            }
            outRect.bottom = this.spacing;
            return;
        }
        if (ViewUtilitiesKt.getRightToLeftDirection()) {
            int i6 = this.spacing;
            int i7 = this.spanCount;
            outRect.left = i6 - (((i + 1) * i6) / i7);
            outRect.right = (i * i6) / i7;
        } else {
            int i8 = this.spacing;
            int i9 = this.spanCount;
            outRect.left = (i * i8) / i9;
            outRect.right = i8 - (((i + 1) * i8) / i9);
        }
        if (childAdapterPosition < this.spanCount) {
            outRect.top = this.spacing;
        }
        outRect.bottom = this.spacing;
    }

    public final int getSpacing() {
        return this.spacing;
    }

    public final int getSpanCount() {
        return this.spanCount;
    }

    public GridSpacingItemMulityCountryDecoration(int i, int i2, boolean z) {
        this.spanCount = i;
        this.spacing = i2;
        this.includeEdge = z;
    }
}
