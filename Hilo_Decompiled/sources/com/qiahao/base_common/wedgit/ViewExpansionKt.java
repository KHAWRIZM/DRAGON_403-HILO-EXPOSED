package com.qiahao.base_common.wedgit;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001aW\u0010\u0000\u001a\u00020\u0001*\u00020\u00022K\u0010\u0003\u001aG\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00010\u0004¨\u0006\f"}, d2 = {"addScrollDistanceListener", "", "Landroidx/recyclerview/widget/RecyclerView;", "onScroll", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "isScrolling", "", "scrolledDistance", "totalDistance", "base_common_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ViewExpansionKt {
    public static final void addScrollDistanceListener(@NotNull RecyclerView recyclerView, @NotNull final Function3<? super Boolean, ? super Integer, ? super Integer, Unit> onScroll) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        Intrinsics.checkNotNullParameter(onScroll, "onScroll");
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final Ref.IntRef intRef = new Ref.IntRef();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.qiahao.base_common.wedgit.ViewExpansionKt$addScrollDistanceListener$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView2, int newState) {
                boolean z10;
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                super.onScrollStateChanged(recyclerView2, newState);
                Ref.BooleanRef booleanRef2 = Ref.BooleanRef.this;
                if (newState != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                booleanRef2.element = z10;
                onScroll.invoke(Boolean.valueOf(z10), 0, Integer.valueOf(intRef.element));
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView2, int dx, int dy) {
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                super.onScrolled(recyclerView2, dx, dy);
                intRef.element += dy;
                if (Ref.BooleanRef.this.element) {
                    onScroll.invoke(Boolean.TRUE, Integer.valueOf(dy), Integer.valueOf(intRef.element));
                }
            }
        });
    }
}
