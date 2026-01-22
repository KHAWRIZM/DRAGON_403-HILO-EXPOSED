package com.qmuiteam.qmui.widget.section;

import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.d1;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qmuiteam.qmui.widget.section.a;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class b extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    private InterfaceC٠١٤٩b f١٣٢٩١a;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference f١٣٢٩٣c;

    /* renamed from: b, reason: collision with root package name */
    private int f١٣٢٩٢b = -1;

    /* renamed from: d, reason: collision with root package name */
    private int f١٣٢٩٤d = 0;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class a extends RecyclerView.AdapterDataObserver {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            b.this.f١٣٢٩٢b = -1;
            b.this.f١٣٢٩١a.a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i10, int i11) {
            super.onItemRangeChanged(i10, i11);
            if (b.this.f١٣٢٩٢b >= i10 && b.this.f١٣٢٩٢b < i10 + i11) {
                b.b(b.this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i10, int i11) {
            super.onItemRangeInserted(i10, i11);
            if (i10 <= b.this.f١٣٢٩٢b) {
                b.this.f١٣٢٩٢b = -1;
                b.this.f١٣٢٩١a.a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i10, int i11, int i12) {
            super.onItemRangeMoved(i10, i11, i12);
            if (i10 == b.this.f١٣٢٩٢b || i11 == b.this.f١٣٢٩٢b) {
                b.this.f١٣٢٩٢b = -1;
                b.this.f١٣٢٩١a.a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i10, int i11) {
            super.onItemRangeRemoved(i10, i11);
            if (b.this.f١٣٢٩٢b >= i10 && b.this.f١٣٢٩٢b < i10 + i11) {
                b.this.f١٣٢٩٢b = -1;
                b.this.j(false);
            }
        }
    }

    /* renamed from: com.qmuiteam.qmui.widget.section.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface InterfaceC٠١٤٩b {
        void a();

        a.C٠١٤٨a b(ViewGroup viewGroup, int i10);

        void c(RecyclerView.AdapterDataObserver adapterDataObserver);

        int d(int i10);

        void e(boolean z10);

        boolean f(int i10);

        void g(a.C٠١٤٨a r12, int i10);

        int getItemViewType(int i10);
    }

    public b(ViewGroup viewGroup, InterfaceC٠١٤٩b r32) {
        this.f١٣٢٩١a = r32;
        this.f١٣٢٩٣c = new WeakReference(viewGroup);
        this.f١٣٢٩١a.c(new a());
    }

    static /* bridge */ /* synthetic */ a.C٠١٤٨a b(b bVar) {
        bVar.getClass();
        return null;
    }

    private void f(ViewGroup viewGroup, a.C٠١٤٨a r32, int i10) {
        this.f١٣٢٩١a.g(r32, i10);
        viewGroup.removeAllViews();
        throw null;
    }

    private a.C٠١٤٨a g(RecyclerView recyclerView, int i10, int i11) {
        this.f١٣٢٩١a.b(recyclerView, i11);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(boolean z10) {
        int i10;
        ViewGroup viewGroup = (ViewGroup) this.f١٣٢٩٣c.get();
        if (viewGroup == null) {
            return;
        }
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        viewGroup.setVisibility(i10);
        this.f١٣٢٩١a.e(z10);
    }

    public int h() {
        return this.f١٣٢٩٢b;
    }

    public int i() {
        return this.f١٣٢٩٤d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        ViewGroup viewGroup = (ViewGroup) this.f١٣٢٩٣c.get();
        if (viewGroup == null) {
            return;
        }
        if (recyclerView.getChildCount() == 0) {
            j(false);
        }
        if (recyclerView.getAdapter() == null) {
            j(false);
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            j(false);
            return;
        }
        int findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        if (findFirstVisibleItemPosition == -1) {
            j(false);
            return;
        }
        int d10 = this.f١٣٢٩١a.d(findFirstVisibleItemPosition);
        if (d10 == -1) {
            j(false);
            return;
        }
        int itemViewType = this.f١٣٢٩١a.getItemViewType(d10);
        if (itemViewType == -1) {
            j(false);
            return;
        }
        g(recyclerView, d10, itemViewType);
        if (this.f١٣٢٩٢b != d10) {
            this.f١٣٢٩٢b = d10;
            f(viewGroup, null, d10);
        }
        j(true);
        View findChildViewUnder = recyclerView.findChildViewUnder(recyclerView.getWidth() / 2, viewGroup.getHeight() - 1);
        if (findChildViewUnder == null) {
            int top = recyclerView.getTop();
            this.f١٣٢٩٤d = top;
            d1.b0(viewGroup, top - viewGroup.getTop());
        } else if (this.f١٣٢٩١a.f(recyclerView.getChildAdapterPosition(findChildViewUnder))) {
            int top2 = (findChildViewUnder.getTop() + recyclerView.getTop()) - viewGroup.getHeight();
            this.f١٣٢٩٤d = top2;
            d1.b0(viewGroup, top2 - viewGroup.getTop());
        } else {
            int top3 = recyclerView.getTop();
            this.f١٣٢٩٤d = top3;
            d1.b0(viewGroup, top3 - viewGroup.getTop());
        }
    }
}
