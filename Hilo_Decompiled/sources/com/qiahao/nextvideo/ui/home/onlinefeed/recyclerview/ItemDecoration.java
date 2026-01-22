package com.qiahao.nextvideo.ui.home.onlinefeed.recyclerview;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/onlinefeed/recyclerview/ItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "()V", "spacing", "", "getSpacing", "()I", "setSpacing", "(I)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ItemDecoration extends RecyclerView.ItemDecoration {
    private int spacing = Dimens.INSTANCE.dpToPx(14);

    public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        if (parent.getChildAdapterPosition(view) % 2 == 0) {
            if (ViewUtilitiesKt.getRightToLeftDirection()) {
                int i = this.spacing;
                outRect.left = i / 2;
                outRect.right = i;
            } else {
                int i2 = this.spacing;
                outRect.left = i2;
                outRect.right = i2 / 2;
            }
        } else if (ViewUtilitiesKt.getRightToLeftDirection()) {
            int i3 = this.spacing;
            outRect.left = i3;
            outRect.right = i3 / 2;
        } else {
            int i4 = this.spacing;
            outRect.left = i4 / 2;
            outRect.right = i4;
        }
        int i5 = this.spacing;
        outRect.top = i5 / 2;
        outRect.bottom = i5 / 2;
    }

    public final int getSpacing() {
        return this.spacing;
    }

    public final void setSpacing(int i) {
        this.spacing = i;
    }
}
