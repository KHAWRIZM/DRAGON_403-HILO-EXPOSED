package com.qmuiteam.qmui.nestedScroll;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.appcompat.app.a0;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior;
import com.qmuiteam.qmui.nestedScroll.QMUIDraggableScrollBar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIContinuousNestedScrollLayout extends CoordinatorLayout implements QMUIContinuousNestedTopAreaBehavior.a, QMUIDraggableScrollBar.b {
    private com.qmuiteam.qmui.nestedScroll.a A;

    /* renamed from: B, reason: collision with root package name */
    private QMUIContinuousNestedTopAreaBehavior f١٢٧٨٠B;
    private QMUIContinuousNestedBottomAreaBehavior C;
    private List D;
    private Runnable E;
    private boolean F;
    private QMUIDraggableScrollBar G;
    private boolean H;
    private boolean I;
    private int J;
    private boolean K;
    private float L;
    private int M;

    /* renamed from: z, reason: collision with root package name */
    private c f١٢٧٨١z;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            QMUIContinuousNestedScrollLayout.this.e0();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface b {
    }

    public QMUIContinuousNestedScrollLayout(Context context) {
        this(context, null);
    }

    private void g0(int i10, int i11, int i12, int i13, int i14, int i15) {
        if (this.I) {
            i0();
            this.G.setPercent(getCurrentScrollPercent());
            this.G.a();
        }
        Iterator it = this.D.iterator();
        if (!it.hasNext()) {
            return;
        }
        a0.a(it.next());
        throw null;
    }

    private void h0(int i10, boolean z10) {
        Iterator it = this.D.iterator();
        if (!it.hasNext()) {
            this.J = i10;
        } else {
            a0.a(it.next());
            throw null;
        }
    }

    private void i0() {
        if (this.G == null) {
            QMUIDraggableScrollBar f02 = f0(getContext());
            this.G = f02;
            f02.setEnableFadeInAndOut(this.H);
            this.G.setCallback(this);
            CoordinatorLayout.f fVar = new CoordinatorLayout.f(-2, -1);
            fVar.f٢٥٦٢c = 5;
            addView(this.G, fVar);
        }
    }

    public void addOnScrollListener(b bVar) {
        if (!this.D.contains(bVar)) {
            this.D.add(bVar);
        }
    }

    @Override // com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior.a
    public void c() {
        h0(1, true);
    }

    @Override // com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior.a
    public void d() {
        h0(0, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.J != 0) {
                l0();
                this.K = true;
                this.L = motionEvent.getY();
                if (this.M < 0) {
                    this.M = ViewConfiguration.get(getContext()).getScaledTouchSlop();
                }
                return true;
            }
        } else if (motionEvent.getAction() == 2 && this.K) {
            if (Math.abs(motionEvent.getY() - this.L) <= this.M) {
                return true;
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setAction(0);
            obtain.offsetLocation(DownloadProgress.UNKNOWN_PROGRESS, this.L - motionEvent.getY());
            super.dispatchTouchEvent(obtain);
            obtain.recycle();
        }
        this.K = false;
        return super.dispatchTouchEvent(motionEvent);
    }

    public void e0() {
        c cVar = this.f١٢٧٨١z;
        if (cVar != null && this.A != null) {
            int currentScroll = cVar.getCurrentScroll();
            int scrollOffsetRange = this.f١٢٧٨١z.getScrollOffsetRange();
            int i10 = -this.f١٢٧٨٠B.L();
            int offsetRange = getOffsetRange();
            if (offsetRange <= 0) {
                return;
            }
            if (i10 < offsetRange && (i10 <= 0 || !this.F)) {
                if (this.A.getCurrentScroll() > 0) {
                    this.A.a(Integer.MIN_VALUE);
                }
                if (currentScroll < scrollOffsetRange && i10 > 0) {
                    int i11 = scrollOffsetRange - currentScroll;
                    if (i10 >= i11) {
                        this.f١٢٧٨١z.a(Integer.MAX_VALUE);
                        this.f١٢٧٨٠B.N(i11 - i10);
                        return;
                    } else {
                        this.f١٢٧٨١z.a(i10);
                        this.f١٢٧٨٠B.N(0);
                        return;
                    }
                }
                return;
            }
            this.f١٢٧٨١z.a(Integer.MAX_VALUE);
            if (this.A.getCurrentScroll() > 0) {
                this.f١٢٧٨٠B.N(-offsetRange);
            }
        }
    }

    @Override // com.qmuiteam.qmui.nestedScroll.QMUIDraggableScrollBar.b
    public void f() {
    }

    protected QMUIDraggableScrollBar f0(Context context) {
        return new QMUIDraggableScrollBar(context);
    }

    @Override // com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior.a
    public void g() {
        h0(2, true);
    }

    public QMUIContinuousNestedBottomAreaBehavior getBottomAreaBehavior() {
        return this.C;
    }

    public com.qmuiteam.qmui.nestedScroll.a getBottomView() {
        return this.A;
    }

    public int getCurrentScroll() {
        int i10;
        c cVar = this.f١٢٧٨١z;
        if (cVar != null) {
            i10 = cVar.getCurrentScroll();
        } else {
            i10 = 0;
        }
        int offsetCurrent = i10 + getOffsetCurrent();
        com.qmuiteam.qmui.nestedScroll.a aVar = this.A;
        if (aVar != null) {
            return offsetCurrent + aVar.getCurrentScroll();
        }
        return offsetCurrent;
    }

    public float getCurrentScrollPercent() {
        int scrollRange = getScrollRange();
        if (scrollRange == 0) {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        return (getCurrentScroll() * 1.0f) / scrollRange;
    }

    public int getOffsetCurrent() {
        QMUIContinuousNestedTopAreaBehavior qMUIContinuousNestedTopAreaBehavior = this.f١٢٧٨٠B;
        if (qMUIContinuousNestedTopAreaBehavior == null) {
            return 0;
        }
        return -qMUIContinuousNestedTopAreaBehavior.L();
    }

    public int getOffsetRange() {
        Object obj = this.f١٢٧٨١z;
        if (obj == null && this.A == null) {
            return 0;
        }
        com.qmuiteam.qmui.nestedScroll.a aVar = this.A;
        if (aVar == null) {
            return Math.max(0, ((View) obj).getHeight() - getHeight());
        }
        if (obj == null) {
            return 0;
        }
        int contentHeight = aVar.getContentHeight();
        if (contentHeight != -1) {
            return Math.max(0, (((View) this.f١٢٧٨١z).getHeight() + contentHeight) - getHeight());
        }
        return Math.max(0, (((View) this.f١٢٧٨١z).getHeight() + ((View) this.A).getHeight()) - getHeight());
    }

    public int getScrollRange() {
        int i10;
        c cVar = this.f١٢٧٨١z;
        if (cVar != null) {
            i10 = cVar.getScrollOffsetRange();
        } else {
            i10 = 0;
        }
        int offsetRange = i10 + getOffsetRange();
        com.qmuiteam.qmui.nestedScroll.a aVar = this.A;
        if (aVar != null) {
            return offsetRange + aVar.getScrollOffsetRange();
        }
        return offsetRange;
    }

    public QMUIContinuousNestedTopAreaBehavior getTopAreaBehavior() {
        return this.f١٢٧٨٠B;
    }

    public c getTopView() {
        return this.f١٢٧٨١z;
    }

    @Override // com.qmuiteam.qmui.nestedScroll.QMUIDraggableScrollBar.b
    public void h() {
        l0();
    }

    @Override // com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior.a
    public void i() {
        h0(0, true);
    }

    @Override // com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior.a
    public void j(int i10) {
        int currentScroll;
        int scrollOffsetRange;
        int currentScroll2;
        int scrollOffsetRange2;
        c cVar = this.f١٢٧٨١z;
        if (cVar == null) {
            currentScroll = 0;
        } else {
            currentScroll = cVar.getCurrentScroll();
        }
        c cVar2 = this.f١٢٧٨١z;
        if (cVar2 == null) {
            scrollOffsetRange = 0;
        } else {
            scrollOffsetRange = cVar2.getScrollOffsetRange();
        }
        com.qmuiteam.qmui.nestedScroll.a aVar = this.A;
        if (aVar == null) {
            currentScroll2 = 0;
        } else {
            currentScroll2 = aVar.getCurrentScroll();
        }
        com.qmuiteam.qmui.nestedScroll.a aVar2 = this.A;
        if (aVar2 == null) {
            scrollOffsetRange2 = 0;
        } else {
            scrollOffsetRange2 = aVar2.getScrollOffsetRange();
        }
        g0(currentScroll, scrollOffsetRange, -i10, getOffsetRange(), currentScroll2, scrollOffsetRange2);
    }

    public void j0() {
        removeCallbacks(this.E);
        post(this.E);
    }

    @Override // com.qmuiteam.qmui.nestedScroll.QMUIDraggableScrollBar.b
    public void k(float f10) {
        k0(((int) (getScrollRange() * f10)) - getCurrentScroll());
    }

    public void k0(int i10) {
        QMUIContinuousNestedTopAreaBehavior qMUIContinuousNestedTopAreaBehavior;
        com.qmuiteam.qmui.nestedScroll.a aVar;
        if ((i10 > 0 || this.A == null) && (qMUIContinuousNestedTopAreaBehavior = this.f١٢٧٨٠B) != null) {
            qMUIContinuousNestedTopAreaBehavior.T(this, (View) this.f١٢٧٨١z, i10);
        } else if (i10 != 0 && (aVar = this.A) != null) {
            aVar.a(i10);
        }
    }

    public void l0() {
        com.qmuiteam.qmui.nestedScroll.a aVar = this.A;
        if (aVar != null) {
            aVar.stopScroll();
        }
        QMUIContinuousNestedTopAreaBehavior qMUIContinuousNestedTopAreaBehavior = this.f١٢٧٨٠B;
        if (qMUIContinuousNestedTopAreaBehavior != null) {
            qMUIContinuousNestedTopAreaBehavior.U();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        j0();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, androidx.core.view.f0
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14) {
        super.onNestedScroll(view, i10, i11, i12, i13, i14);
        if (i13 > 0 && getCurrentScroll() >= getScrollRange()) {
            l0();
        }
    }

    public void removeOnScrollListener(b bVar) {
        this.D.remove(bVar);
    }

    public void setDraggableScrollBarEnabled(boolean z10) {
        int i10;
        if (this.I != z10) {
            this.I = z10;
            if (z10 && !this.H) {
                i0();
                this.G.setPercent(getCurrentScrollPercent());
                this.G.a();
            }
            QMUIDraggableScrollBar qMUIDraggableScrollBar = this.G;
            if (qMUIDraggableScrollBar != null) {
                if (z10) {
                    i10 = 0;
                } else {
                    i10 = 8;
                }
                qMUIDraggableScrollBar.setVisibility(i10);
            }
        }
    }

    public void setEnableScrollBarFadeInOut(boolean z10) {
        if (this.H != z10) {
            this.H = z10;
            if (this.I && !z10) {
                i0();
                this.G.setPercent(getCurrentScrollPercent());
                this.G.a();
            }
            QMUIDraggableScrollBar qMUIDraggableScrollBar = this.G;
            if (qMUIDraggableScrollBar != null) {
                qMUIDraggableScrollBar.setEnableFadeInAndOut(z10);
                this.G.invalidate();
            }
        }
    }

    public void setKeepBottomAreaStableWhenCheckLayout(boolean z10) {
        this.F = z10;
    }

    public QMUIContinuousNestedScrollLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QMUIContinuousNestedScrollLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.D = new ArrayList();
        this.E = new a();
        this.F = false;
        this.H = true;
        this.I = false;
        this.J = 0;
        this.K = false;
        this.L = DownloadProgress.UNKNOWN_PROGRESS;
        this.M = -1;
    }
}
