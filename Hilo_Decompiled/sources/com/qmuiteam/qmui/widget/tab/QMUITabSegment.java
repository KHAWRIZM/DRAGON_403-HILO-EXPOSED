package com.qmuiteam.qmui.widget.tab;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import androidx.viewpager.widget.ViewPager;
import com.qmuiteam.qmui.widget.tab.QMUIBasicTabSegment;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUITabSegment extends QMUIBasicTabSegment {

    /* renamed from: p, reason: collision with root package name */
    private int f١٣٣٢٣p;

    /* renamed from: q, reason: collision with root package name */
    private ViewPager f١٣٣٢٤q;

    /* renamed from: r, reason: collision with root package name */
    private androidx.viewpager.widget.a f١٣٣٢٥r;

    /* renamed from: s, reason: collision with root package name */
    private DataSetObserver f١٣٣٢٦s;

    /* renamed from: t, reason: collision with root package name */
    private ViewPager.j f١٣٣٢٧t;

    /* renamed from: u, reason: collision with root package name */
    private b f١٣٣٢٨u;

    /* renamed from: v, reason: collision with root package name */
    private a f١٣٣٢٩v;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class a implements ViewPager.i {

        /* renamed from: a, reason: collision with root package name */
        private boolean f١٣٣٣٠a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f١٣٣٣١b;

        a(boolean z10) {
            this.f١٣٣٣١b = z10;
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2) {
            if (QMUITabSegment.this.f١٣٣٢٤q == viewPager) {
                QMUITabSegment.this.K(aVar2, this.f١٣٣٣١b, this.f١٣٣٣٠a);
            }
        }

        void b(boolean z10) {
            this.f١٣٣٣٠a = z10;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface b extends QMUIBasicTabSegment.d {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class c extends DataSetObserver {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f١٣٣٣٣a;

        c(boolean z10) {
            this.f١٣٣٣٣a = z10;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            QMUITabSegment.this.J(this.f١٣٣٣٣a);
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            QMUITabSegment.this.J(this.f١٣٣٣٣a);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class d implements ViewPager.j {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference f١٣٣٣٥a;

        public d(QMUITabSegment qMUITabSegment) {
            this.f١٣٣٣٥a = new WeakReference(qMUITabSegment);
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrollStateChanged(int i10) {
            QMUITabSegment qMUITabSegment = (QMUITabSegment) this.f١٣٣٣٥a.get();
            if (qMUITabSegment != null) {
                qMUITabSegment.setViewPagerScrollState(i10);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrolled(int i10, float f10, int i11) {
            QMUITabSegment qMUITabSegment = (QMUITabSegment) this.f١٣٣٣٥a.get();
            if (qMUITabSegment != null) {
                qMUITabSegment.G(i10, f10);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageSelected(int i10) {
            QMUITabSegment qMUITabSegment = (QMUITabSegment) this.f١٣٣٣٥a.get();
            if (qMUITabSegment != null && qMUITabSegment.f١٣٣٠٠d != -1) {
                qMUITabSegment.f١٣٣٠٠d = i10;
            } else if (qMUITabSegment != null && qMUITabSegment.getSelectedIndex() != i10 && i10 < qMUITabSegment.getTabCount()) {
                qMUITabSegment.F(i10, true, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class e implements b {

        /* renamed from: a, reason: collision with root package name */
        private final ViewPager f١٣٣٣٦a;

        public e(ViewPager viewPager) {
            this.f١٣٣٣٦a = viewPager;
        }

        @Override // com.qmuiteam.qmui.widget.tab.QMUIBasicTabSegment.d
        public void a(int i10) {
        }

        @Override // com.qmuiteam.qmui.widget.tab.QMUIBasicTabSegment.d
        public void b(int i10) {
            this.f١٣٣٣٦a.setCurrentItem(i10, false);
        }

        @Override // com.qmuiteam.qmui.widget.tab.QMUIBasicTabSegment.d
        public void c(int i10) {
        }

        @Override // com.qmuiteam.qmui.widget.tab.QMUIBasicTabSegment.d
        public void d(int i10) {
        }
    }

    public QMUITabSegment(Context context) {
        super(context);
        this.f١٣٣٢٣p = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewPagerScrollState(int i10) {
        int i11;
        this.f١٣٣٢٣p = i10;
        if (i10 == 0 && (i11 = this.f١٣٣٠٠d) != -1 && this.f١٣٣٠٨l == null) {
            F(i11, true, false);
            this.f١٣٣٠٠d = -1;
        }
    }

    void J(boolean z10) {
        androidx.viewpager.widget.a aVar = this.f١٣٣٢٥r;
        if (aVar == null) {
            if (z10) {
                C();
                return;
            }
            return;
        }
        int count = aVar.getCount();
        if (z10) {
            C();
            for (int i10 = 0; i10 < count; i10++) {
                o(this.f١٣٣٠٦j.d(this.f١٣٣٢٥r.getPageTitle(i10)).a(getContext()));
            }
            super.z();
        }
        ViewPager viewPager = this.f١٣٣٢٤q;
        if (viewPager != null && count > 0) {
            F(viewPager.getCurrentItem(), true, false);
        }
    }

    void K(androidx.viewpager.widget.a aVar, boolean z10, boolean z11) {
        DataSetObserver dataSetObserver;
        androidx.viewpager.widget.a aVar2 = this.f١٣٣٢٥r;
        if (aVar2 != null && (dataSetObserver = this.f١٣٣٢٦s) != null) {
            aVar2.unregisterDataSetObserver(dataSetObserver);
        }
        this.f١٣٣٢٥r = aVar;
        if (z11 && aVar != null) {
            if (this.f١٣٣٢٦s == null) {
                this.f١٣٣٢٦s = new c(z10);
            }
            aVar.registerDataSetObserver(this.f١٣٣٢٦s);
        }
        J(z10);
    }

    public void L(ViewPager viewPager, boolean z10) {
        M(viewPager, z10, true);
    }

    public void M(ViewPager viewPager, boolean z10, boolean z11) {
        ViewPager viewPager2 = this.f١٣٣٢٤q;
        if (viewPager2 != null) {
            ViewPager.j jVar = this.f١٣٣٢٧t;
            if (jVar != null) {
                viewPager2.removeOnPageChangeListener(jVar);
            }
            a aVar = this.f١٣٣٢٩v;
            if (aVar != null) {
                this.f١٣٣٢٤q.removeOnAdapterChangeListener(aVar);
            }
        }
        QMUIBasicTabSegment.d dVar = this.f١٣٣٢٨u;
        if (dVar != null) {
            removeOnTabSelectedListener(dVar);
            this.f١٣٣٢٨u = null;
        }
        if (viewPager != null) {
            this.f١٣٣٢٤q = viewPager;
            if (this.f١٣٣٢٧t == null) {
                this.f١٣٣٢٧t = new d(this);
            }
            viewPager.addOnPageChangeListener(this.f١٣٣٢٧t);
            e eVar = new e(viewPager);
            this.f١٣٣٢٨u = eVar;
            addOnTabSelectedListener(eVar);
            androidx.viewpager.widget.a adapter = viewPager.getAdapter();
            if (adapter != null) {
                K(adapter, z10, z11);
            }
            if (this.f١٣٣٢٩v == null) {
                this.f١٣٣٢٩v = new a(z10);
            }
            this.f١٣٣٢٩v.b(z11);
            viewPager.addOnAdapterChangeListener(this.f١٣٣٢٩v);
            return;
        }
        this.f١٣٣٢٤q = null;
        K(null, false, false);
    }

    public void setupWithViewPager(ViewPager viewPager) {
        L(viewPager, true);
    }

    @Override // com.qmuiteam.qmui.widget.tab.QMUIBasicTabSegment
    protected boolean y() {
        if (this.f١٣٣٢٣p != 0) {
            return true;
        }
        return false;
    }

    public QMUITabSegment(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f١٣٣٢٣p = 0;
    }

    public QMUITabSegment(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٣٣٢٣p = 0;
    }
}
