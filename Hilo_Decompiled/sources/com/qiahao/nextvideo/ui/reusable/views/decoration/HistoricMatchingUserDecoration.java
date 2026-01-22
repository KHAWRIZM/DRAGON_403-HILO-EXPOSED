package com.qiahao.nextvideo.ui.reusable.views.decoration;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/decoration/HistoricMatchingUserDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "()V", "spacing", "", "getSpacing", "()I", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class HistoricMatchingUserDecoration extends RecyclerView.ItemDecoration {
    private final int spacing = Dimens.INSTANCE.getMarginMedium();

    public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        int i = 0;
        if (ViewUtilitiesKt.getRightToLeftDirection()) {
            outRect.left = this.spacing;
            if (parent.getChildAdapterPosition(view) == 0) {
                Dimens dimens = Dimens.INSTANCE;
                outRect.right = (dimens.getScreenWidth() / 2) - (dimens.dpToPx(42) / 2);
                return;
            }
            RecyclerView.Adapter adapter = parent.getAdapter();
            if (adapter != null) {
                i = adapter.getItemCount();
            }
            if (i - 1 == parent.getChildAdapterPosition(view)) {
                outRect.left = Dimens.INSTANCE.dpToPx(80);
                return;
            } else {
                outRect.right = this.spacing;
                return;
            }
        }
        outRect.right = this.spacing;
        if (parent.getChildAdapterPosition(view) == 0) {
            Dimens dimens2 = Dimens.INSTANCE;
            outRect.left = (dimens2.getScreenWidth() / 2) - (dimens2.dpToPx(42) / 2);
            return;
        }
        RecyclerView.Adapter adapter2 = parent.getAdapter();
        if (adapter2 != null) {
            i = adapter2.getItemCount();
        }
        if (i - 1 == parent.getChildAdapterPosition(view)) {
            outRect.right = Dimens.INSTANCE.dpToPx(80);
        } else {
            outRect.left = this.spacing;
        }
    }

    public final int getSpacing() {
        return this.spacing;
    }
}
