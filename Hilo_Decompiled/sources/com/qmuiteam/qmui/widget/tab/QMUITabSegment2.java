package com.qmuiteam.qmui.widget.tab;

import android.content.Context;
import android.util.AttributeSet;
import androidx.viewpager2.widget.ViewPager2;
import com.qmuiteam.qmui.widget.tab.QMUIBasicTabSegment;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUITabSegment2 extends QMUIBasicTabSegment {

    /* renamed from: p, reason: collision with root package name */
    private int f١٣٣٣٧p;

    /* renamed from: q, reason: collision with root package name */
    private ViewPager2 f١٣٣٣٨q;

    /* renamed from: r, reason: collision with root package name */
    private ViewPager2.OnPageChangeCallback f١٣٣٣٩r;

    /* renamed from: s, reason: collision with root package name */
    private QMUIBasicTabSegment.d f١٣٣٤٠s;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class a extends ViewPager2.OnPageChangeCallback {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference f١٣٣٤١a;

        public a(QMUITabSegment2 qMUITabSegment2) {
            this.f١٣٣٤١a = new WeakReference(qMUITabSegment2);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i10) {
            QMUITabSegment2 qMUITabSegment2 = (QMUITabSegment2) this.f١٣٣٤١a.get();
            if (qMUITabSegment2 != null) {
                qMUITabSegment2.setViewPagerScrollState(i10);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i10, float f10, int i11) {
            QMUITabSegment2 qMUITabSegment2 = (QMUITabSegment2) this.f١٣٣٤١a.get();
            if (qMUITabSegment2 != null) {
                qMUITabSegment2.G(i10, f10);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i10) {
            QMUITabSegment2 qMUITabSegment2 = (QMUITabSegment2) this.f١٣٣٤١a.get();
            if (qMUITabSegment2 != null && qMUITabSegment2.f١٣٣٠٠d != -1) {
                qMUITabSegment2.f١٣٣٠٠d = i10;
            } else if (qMUITabSegment2 != null && qMUITabSegment2.getSelectedIndex() != i10 && i10 < qMUITabSegment2.getTabCount()) {
                qMUITabSegment2.F(i10, true, false);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    private static class b implements QMUIBasicTabSegment.d {

        /* renamed from: a, reason: collision with root package name */
        private final ViewPager2 f١٣٣٤٢a;

        public b(ViewPager2 viewPager2) {
            this.f١٣٣٤٢a = viewPager2;
        }

        @Override // com.qmuiteam.qmui.widget.tab.QMUIBasicTabSegment.d
        public void a(int i10) {
        }

        @Override // com.qmuiteam.qmui.widget.tab.QMUIBasicTabSegment.d
        public void b(int i10) {
            this.f١٣٣٤٢a.setCurrentItem(i10, false);
        }

        @Override // com.qmuiteam.qmui.widget.tab.QMUIBasicTabSegment.d
        public void c(int i10) {
        }

        @Override // com.qmuiteam.qmui.widget.tab.QMUIBasicTabSegment.d
        public void d(int i10) {
        }
    }

    public QMUITabSegment2(Context context) {
        super(context);
        this.f١٣٣٣٧p = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewPagerScrollState(int i10) {
        int i11;
        this.f١٣٣٣٧p = i10;
        if (i10 == 0 && (i11 = this.f١٣٣٠٠d) != -1 && this.f١٣٣٠٨l == null) {
            F(i11, true, false);
            this.f١٣٣٠٠d = -1;
        }
    }

    public void setupWithViewPager(ViewPager2 viewPager2) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback;
        ViewPager2 viewPager22 = this.f١٣٣٣٨q;
        if (viewPager22 != null && (onPageChangeCallback = this.f١٣٣٣٩r) != null) {
            viewPager22.unregisterOnPageChangeCallback(onPageChangeCallback);
        }
        QMUIBasicTabSegment.d dVar = this.f١٣٣٤٠s;
        if (dVar != null) {
            removeOnTabSelectedListener(dVar);
            this.f١٣٣٤٠s = null;
        }
        if (viewPager2 != null) {
            this.f١٣٣٣٨q = viewPager2;
            if (this.f١٣٣٣٩r == null) {
                this.f١٣٣٣٩r = new a(this);
            }
            viewPager2.registerOnPageChangeCallback(this.f١٣٣٣٩r);
            b bVar = new b(viewPager2);
            this.f١٣٣٤٠s = bVar;
            addOnTabSelectedListener(bVar);
            F(this.f١٣٣٣٨q.getCurrentItem(), true, false);
            return;
        }
        this.f١٣٣٣٨q = null;
    }

    @Override // com.qmuiteam.qmui.widget.tab.QMUIBasicTabSegment
    protected boolean y() {
        if (this.f١٣٣٣٧p != 0) {
            return true;
        }
        return false;
    }

    public QMUITabSegment2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f١٣٣٣٧p = 0;
    }

    public QMUITabSegment2(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٣٣٣٧p = 0;
    }
}
