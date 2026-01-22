package com.qmuiteam.qmui.widget.section;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.a0;
import androidx.recyclerview.widget.RecyclerView;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;
import com.qmuiteam.qmui.widget.section.a;
import com.qmuiteam.qmui.widget.section.b;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIStickySectionLayout extends QMUIFrameLayout {

    /* renamed from: c, reason: collision with root package name */
    private RecyclerView f١٣٢٨٣c;

    /* renamed from: d, reason: collision with root package name */
    private QMUIFrameLayout f١٣٢٨٤d;

    /* renamed from: e, reason: collision with root package name */
    private com.qmuiteam.qmui.widget.section.b f١٣٢٨٥e;

    /* renamed from: f, reason: collision with root package name */
    private int f١٣٢٨٦f;

    /* renamed from: g, reason: collision with root package name */
    private List f١٣٢٨٧g;

    /* renamed from: h, reason: collision with root package name */
    private Runnable f١٣٢٨٨h;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class a implements View.OnLayoutChangeListener {
        a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            QMUIStickySectionLayout.this.f١٣٢٨٦f = i13 - i11;
            if (QMUIStickySectionLayout.this.f١٣٢٨٦f > 0 && QMUIStickySectionLayout.this.f١٣٢٨٨h != null) {
                QMUIStickySectionLayout.this.f١٣٢٨٨h.run();
                QMUIStickySectionLayout.this.f١٣٢٨٨h = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class b implements b.InterfaceC٠١٤٩b {
        b(com.qmuiteam.qmui.widget.section.a aVar) {
        }

        @Override // com.qmuiteam.qmui.widget.section.b.InterfaceC٠١٤٩b
        public void a() {
            QMUIStickySectionLayout.this.f١٣٢٨٣c.invalidate();
        }

        @Override // com.qmuiteam.qmui.widget.section.b.InterfaceC٠١٤٩b
        public a.C٠١٤٨a b(ViewGroup viewGroup, int i10) {
            throw null;
        }

        @Override // com.qmuiteam.qmui.widget.section.b.InterfaceC٠١٤٩b
        public void c(RecyclerView.AdapterDataObserver adapterDataObserver) {
            throw null;
        }

        @Override // com.qmuiteam.qmui.widget.section.b.InterfaceC٠١٤٩b
        public int d(int i10) {
            throw null;
        }

        @Override // com.qmuiteam.qmui.widget.section.b.InterfaceC٠١٤٩b
        public void e(boolean z10) {
        }

        @Override // com.qmuiteam.qmui.widget.section.b.InterfaceC٠١٤٩b
        public boolean f(int i10) {
            throw null;
        }

        @Override // com.qmuiteam.qmui.widget.section.b.InterfaceC٠١٤٩b
        public void g(a.C٠١٤٨a r12, int i10) {
            throw null;
        }

        @Override // com.qmuiteam.qmui.widget.section.b.InterfaceC٠١٤٩b
        public int getItemViewType(int i10) {
            throw null;
        }
    }

    public QMUIStickySectionLayout(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qmuiteam.qmui.layout.QMUIFrameLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        List list = this.f١٣٢٨٧g;
        if (list != null) {
            Iterator it = list.iterator();
            if (it.hasNext()) {
                a0.a(it.next());
                throw null;
            }
        }
        super.dispatchDraw(canvas);
        List list2 = this.f١٣٢٨٧g;
        if (list2 != null) {
            Iterator it2 = list2.iterator();
            if (it2.hasNext()) {
                a0.a(it2.next());
                throw null;
            }
        }
    }

    public RecyclerView getRecyclerView() {
        return this.f١٣٢٨٣c;
    }

    public int getStickyHeaderPosition() {
        com.qmuiteam.qmui.widget.section.b bVar = this.f١٣٢٨٥e;
        if (bVar == null) {
            return -1;
        }
        return bVar.h();
    }

    public View getStickySectionView() {
        if (this.f١٣٢٨٤d.getVisibility() == 0 && this.f١٣٢٨٤d.getChildCount() != 0) {
            return this.f١٣٢٨٤d.getChildAt(0);
        }
        return null;
    }

    public QMUIFrameLayout getStickySectionWrapView() {
        return this.f١٣٢٨٤d;
    }

    public void m(com.qmuiteam.qmui.widget.section.a aVar, boolean z10) {
        if (z10) {
            com.qmuiteam.qmui.widget.section.b bVar = new com.qmuiteam.qmui.widget.section.b(this.f١٣٢٨٤d, new b(aVar));
            this.f١٣٢٨٥e = bVar;
            this.f١٣٢٨٣c.addItemDecoration(bVar);
        }
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onDescendantInvalidated(View view, View view2) {
        List list;
        super.onDescendantInvalidated(view, view2);
        if (view2 == this.f١٣٢٨٣c && (list = this.f١٣٢٨٧g) != null && !list.isEmpty()) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (this.f١٣٢٨٥e != null) {
            QMUIFrameLayout qMUIFrameLayout = this.f١٣٢٨٤d;
            qMUIFrameLayout.layout(qMUIFrameLayout.getLeft(), this.f١٣٢٨٥e.i(), this.f١٣٢٨٤d.getRight(), this.f١٣٢٨٥e.i() + this.f١٣٢٨٤d.getHeight());
        }
    }

    public <H, T, VH extends a.C٠١٤٨a> void setAdapter(com.qmuiteam.qmui.widget.section.a aVar) {
        m(aVar, true);
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.f١٣٢٨٣c.setLayoutManager(layoutManager);
    }

    public QMUIStickySectionLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QMUIStickySectionLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٣٢٨٦f = -1;
        this.f١٣٢٨٨h = null;
        this.f١٣٢٨٤d = new QMUIFrameLayout(context);
        RecyclerView recyclerView = new RecyclerView(context);
        this.f١٣٢٨٣c = recyclerView;
        addView(recyclerView, new FrameLayout.LayoutParams(-1, -1));
        addView(this.f١٣٢٨٤d, new FrameLayout.LayoutParams(-1, -2));
        this.f١٣٢٨٤d.addOnLayoutChangeListener(new a());
    }
}
