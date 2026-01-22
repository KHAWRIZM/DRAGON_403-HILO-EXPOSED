package com.zhpan.bannerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.zhpan.bannerview.e;
import com.zhpan.indicator.IndicatorView;
import com.zhpan.indicator.base.IIndicator;
import com.zhpan.indicator.option.IndicatorOptions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressLint({"NotifyDataSetChanged"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class BannerViewPager<T> extends RelativeLayout implements LifecycleObserver {
    private int a;
    private boolean b;
    private boolean c;
    private IIndicator d;
    private RelativeLayout e;
    private ViewPager2 f;
    private ad.b g;
    private final Handler h;
    private e i;
    private ViewPager2.OnPageChangeCallback j;
    private final Runnable k;
    private RectF l;
    private Path m;
    private int n;
    private int o;
    private Lifecycle p;
    private final ViewPager2.OnPageChangeCallback q;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    class a extends ViewPager2.OnPageChangeCallback {
        a() {
        }

        public void onPageScrollStateChanged(int i) {
            super.onPageScrollStateChanged(i);
            BannerViewPager.this.z(i);
        }

        public void onPageScrolled(int i, float f, int i2) {
            super.onPageScrolled(i, f, i2);
            BannerViewPager.this.A(i, f, i2);
        }

        public void onPageSelected(int i) {
            super.onPageSelected(i);
            BannerViewPager.this.B(i);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface b {
        void a(View view, int i);
    }

    public BannerViewPager(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(int i, float f, int i2) {
        int listSize = this.i.getListSize();
        this.g.b().r();
        int c = dd.a.c(i, listSize);
        if (listSize > 0) {
            ViewPager2.OnPageChangeCallback onPageChangeCallback = this.j;
            if (onPageChangeCallback != null) {
                onPageChangeCallback.onPageScrolled(c, f, i2);
            }
            IIndicator iIndicator = this.d;
            if (iIndicator != null) {
                iIndicator.onPageScrolled(c, f, i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(int i) {
        int listSize = this.i.getListSize();
        boolean r = this.g.b().r();
        int c = dd.a.c(i, listSize);
        this.a = c;
        if (listSize > 0 && r && (i == 0 || i == 999)) {
            F(c);
        }
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.j;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageSelected(this.a);
        }
        IIndicator iIndicator = this.d;
        if (iIndicator != null) {
            iIndicator.onPageSelected(this.a);
        }
    }

    private void D(List list) {
        setIndicatorValues(list);
        this.g.b().c().setCurrentPosition(dd.a.c(this.f.getCurrentItem(), list.size()));
        this.d.notifyDataChanged();
    }

    private void F(int i) {
        if (t()) {
            this.f.setCurrentItem(dd.a.b(this.i.getListSize()) + i, false);
        } else {
            this.f.setCurrentItem(i, false);
        }
    }

    private int getInterval() {
        return this.g.b().e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        e eVar = this.i;
        if (eVar != null && eVar.getListSize() > 1 && s()) {
            ViewPager2 viewPager2 = this.f;
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1, this.g.b().q());
            this.h.postDelayed(this.k, getInterval());
        }
    }

    private void j(Context context, AttributeSet attributeSet) {
        ad.b bVar = new ad.b();
        this.g = bVar;
        bVar.d(context, attributeSet);
        r();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void k() {
        List<? extends T> data = this.i.getData();
        if (data != null) {
            setIndicatorValues(data);
            setupViewPager(data);
            q();
        }
    }

    private void l(IndicatorOptions indicatorOptions, List list) {
        if (((View) this.d).getParent() == null) {
            this.e.removeAllViews();
            this.e.addView((View) this.d);
            n();
            m();
        }
        this.d.setIndicatorOptions(indicatorOptions);
        indicatorOptions.setPageSize(list.size());
        this.d.notifyDataChanged();
    }

    private void m() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ((View) this.d).getLayoutParams();
        int a2 = this.g.b().a();
        if (a2 != 0) {
            if (a2 != 2) {
                if (a2 == 4) {
                    layoutParams.addRule(11);
                    return;
                }
                return;
            }
            layoutParams.addRule(9);
            return;
        }
        layoutParams.addRule(14);
    }

    private void n() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ((View) this.d).getLayoutParams();
        this.g.b().b();
        int a2 = dd.a.a(10.0f);
        marginLayoutParams.setMargins(a2, a2, a2, a2);
    }

    private void o(int i) {
        float j = this.g.b().j();
        if (i == 4) {
            this.g.g(true, j);
        } else if (i == 8) {
            this.g.g(false, j);
        }
    }

    private void p(ad.c cVar) {
        int l = cVar.l();
        int f = cVar.f();
        if (f != -1000 || l != -1000) {
            RecyclerView childAt = this.f.getChildAt(0);
            int h = cVar.h();
            int i = cVar.i() + l;
            int i2 = cVar.i() + f;
            if (i2 < 0) {
                i2 = 0;
            }
            if (i < 0) {
                i = 0;
            }
            if (h == 0) {
                childAt.setPadding(i2, 0, i, 0);
            } else if (h == 1) {
                childAt.setPadding(0, i2, 0, i);
            }
            childAt.setClipToPadding(false);
        }
        this.g.a();
    }

    private void q() {
        int m = this.g.b().m();
        if (m > 0) {
            bd.c.a(this, m);
        }
    }

    private void r() {
        View.inflate(getContext(), R.layout.bvp_layout, this);
        this.f = findViewById(R.id.vp_main);
        this.e = (RelativeLayout) findViewById(R.id.bvp_layout_indicator);
        this.f.setPageTransformer(this.g.c());
    }

    private boolean s() {
        return this.g.b().p();
    }

    private void setIndicatorValues(List<? extends T> list) {
        ad.c b2 = this.g.b();
        this.e.setVisibility(b2.d());
        b2.u();
        if (this.b) {
            this.e.removeAllViews();
        } else if (this.d == null) {
            this.d = new IndicatorView(getContext());
        }
        l(b2.c(), list);
    }

    private void setupViewPager(List<T> list) {
        if (this.i != null) {
            ad.c b2 = this.g.b();
            if (b2.o() != 0) {
                bd.a.a(this.f, b2.o());
            }
            this.a = 0;
            this.i.setCanLoop(b2.r());
            this.f.setAdapter(this.i);
            if (t()) {
                this.f.setCurrentItem(dd.a.b(list.size()), false);
            }
            this.f.unregisterOnPageChangeCallback(this.q);
            this.f.registerOnPageChangeCallback(this.q);
            this.f.setOrientation(b2.h());
            this.f.setOffscreenPageLimit(b2.g());
            p(b2);
            o(b2.k());
            d0();
            return;
        }
        throw new NullPointerException("You must set adapter for BannerViewPager");
    }

    private boolean t() {
        e eVar;
        ad.b bVar = this.g;
        if (bVar != null && bVar.b() != null && this.g.b().r() && (eVar = this.i) != null && eVar.getListSize() > 1) {
            return true;
        }
        return false;
    }

    private boolean u() {
        return this.g.b().t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(List list) {
        if (isAttachedToWindow() && list != null && this.i != null) {
            e0();
            this.i.setData(list);
            this.i.notifyDataSetChanged();
            F(getCurrentItem());
            D(list);
            d0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(b bVar, boolean z, View view, int i, int i2) {
        bVar.a(view, i);
        if (z) {
            this.f.setCurrentItem(i2);
        }
    }

    private void x(int i, int i2, int i3) {
        boolean z = false;
        if (i2 > i3) {
            if (!this.g.b().r()) {
                if (this.a == 0 && i - this.n > 0) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                    return;
                }
                ViewParent parent = getParent();
                if (this.a != getData().size() - 1 || i - this.n >= 0) {
                    z = true;
                }
                parent.requestDisallowInterceptTouchEvent(z);
                return;
            }
            getParent().requestDisallowInterceptTouchEvent(true);
            return;
        }
        if (i3 > i2) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
    }

    private void y(int i, int i2, int i3) {
        boolean z = false;
        if (i3 > i2) {
            if (!this.g.b().r()) {
                if (this.a == 0 && i - this.o > 0) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                    return;
                }
                ViewParent parent = getParent();
                if (this.a != getData().size() - 1 || i - this.o >= 0) {
                    z = true;
                }
                parent.requestDisallowInterceptTouchEvent(z);
                return;
            }
            getParent().requestDisallowInterceptTouchEvent(true);
            return;
        }
        if (i2 > i3) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i) {
        IIndicator iIndicator = this.d;
        if (iIndicator != null) {
            iIndicator.onPageScrollStateChanged(i);
        }
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.j;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageScrollStateChanged(i);
        }
    }

    public void C(final List list) {
        post(new Runnable() { // from class: com.zhpan.bannerview.a
            @Override // java.lang.Runnable
            public final void run() {
                BannerViewPager.this.v(list);
            }
        });
    }

    public BannerViewPager E(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.j = onPageChangeCallback;
        return this;
    }

    public BannerViewPager G(e eVar) {
        this.i = eVar;
        return this;
    }

    public BannerViewPager H(boolean z) {
        this.g.b().v(z);
        if (s()) {
            this.g.b().w(true);
        }
        return this;
    }

    public BannerViewPager I(boolean z) {
        this.g.b().w(z);
        if (!z) {
            this.g.b().v(false);
        }
        return this;
    }

    public void J(int i, boolean z) {
        if (t()) {
            e0();
            int currentItem = this.f.getCurrentItem();
            this.f.setCurrentItem(currentItem + (i - dd.a.c(currentItem, this.i.getListSize())), z);
            d0();
            return;
        }
        this.f.setCurrentItem(i, z);
    }

    public BannerViewPager K(int i) {
        this.g.b().z(i);
        return this;
    }

    public BannerViewPager L(int i) {
        this.g.b().A(i);
        return this;
    }

    public BannerViewPager M(int i, int i2) {
        this.g.b().B(i, i2);
        return this;
    }

    public BannerViewPager N(int i) {
        this.g.b().x(i);
        return this;
    }

    public BannerViewPager O(int i, int i2) {
        this.g.b().C(i, i2);
        return this;
    }

    public BannerViewPager P(int i) {
        this.g.b().D(i);
        return this;
    }

    public BannerViewPager Q(IIndicator iIndicator) {
        if (iIndicator instanceof View) {
            this.b = true;
            this.d = iIndicator;
        }
        return this;
    }

    public BannerViewPager R(int i) {
        this.g.b().E(i);
        return this;
    }

    public BannerViewPager S(int i) {
        this.g.b().F(i);
        return this;
    }

    public BannerViewPager T(b bVar) {
        U(bVar, false);
        return this;
    }

    public BannerViewPager U(final b bVar, final boolean z) {
        e eVar = this.i;
        if (eVar != null) {
            eVar.setPageClickListener(new e.a() { // from class: com.zhpan.bannerview.c
                @Override // com.zhpan.bannerview.e.a
                public final void a(View view, int i, int i2) {
                    BannerViewPager.this.w(bVar, z, view, i, i2);
                }
            });
        }
        return this;
    }

    public BannerViewPager V(int i) {
        this.g.b().H(i);
        return this;
    }

    public BannerViewPager W(int i) {
        this.g.h(i);
        return this;
    }

    public BannerViewPager X(int i) {
        return Y(i, 0.85f);
    }

    public BannerViewPager Y(int i, float f) {
        this.g.b().K(i);
        this.g.b().J(f);
        return this;
    }

    public BannerViewPager Z(boolean z) {
        this.f.setLayoutDirection(z ? 1 : 0);
        this.g.b().N(z);
        return this;
    }

    public BannerViewPager a0(int i) {
        b0(i, i);
        return this;
    }

    public BannerViewPager b0(int i, int i2) {
        this.g.b().L(i2);
        this.g.b().G(i);
        return this;
    }

    public BannerViewPager c0(int i) {
        this.g.b().O(i);
        return this;
    }

    public void d0() {
        e eVar;
        if (!this.c && s() && (eVar = this.i) != null && eVar.getListSize() > 1 && isAttachedToWindow()) {
            Lifecycle lifecycle = this.p;
            if (lifecycle == null || lifecycle.getCurrentState() == Lifecycle.State.RESUMED || this.p.getCurrentState() == Lifecycle.State.CREATED) {
                this.h.postDelayed(this.k, getInterval());
                this.c = true;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        float[] n = this.g.b().n();
        RectF rectF = this.l;
        if (rectF != null && this.m != null && n != null) {
            rectF.right = getWidth();
            this.l.bottom = getHeight();
            this.m.addRoundRect(this.l, n, Path.Direction.CW);
            canvas.clipPath(this.m);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 3 || action == 4) {
                this.c = false;
                d0();
            }
        } else {
            this.c = true;
            e0();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void e0() {
        if (this.c) {
            this.h.removeCallbacks(this.k);
            this.c = false;
        }
    }

    public void g() {
        h(new ArrayList());
    }

    public e getAdapter() {
        return this.i;
    }

    public int getCurrentItem() {
        return this.a;
    }

    public List<T> getData() {
        e eVar = this.i;
        if (eVar != null) {
            return (List<T>) eVar.getData();
        }
        return Collections.emptyList();
    }

    public void h(List list) {
        e eVar = this.i;
        if (eVar != null) {
            eVar.setData(list);
            k();
            return;
        }
        throw new NullPointerException("You must set adapter for BannerViewPager");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.g != null && u()) {
            d0();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        e0();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.g != null && u()) {
            e0();
        }
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0024, code lost:
    
        if (r0 != 3) goto L٢٤;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        e eVar;
        if (this.f.isUserInputEnabled() && ((eVar = this.i) == null || eVar.getData().size() > 1)) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        int x = (int) motionEvent.getX();
                        int y = (int) motionEvent.getY();
                        int abs = Math.abs(x - this.n);
                        int abs2 = Math.abs(y - this.o);
                        int h = this.g.b().h();
                        if (h == 1) {
                            y(y, abs, abs2);
                        } else if (h == 0) {
                            x(x, abs, abs2);
                        }
                    }
                }
                getParent().requestDisallowInterceptTouchEvent(false);
            } else {
                this.n = (int) motionEvent.getX();
                this.o = (int) motionEvent.getY();
                getParent().requestDisallowInterceptTouchEvent(true ^ this.g.b().s());
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        e0();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("SUPER_STATE"));
        this.a = bundle.getInt("CURRENT_POSITION");
        this.b = bundle.getBoolean("IS_CUSTOM_INDICATOR");
        J(this.a, false);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        d0();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("SUPER_STATE", onSaveInstanceState);
        bundle.putInt("CURRENT_POSITION", this.a);
        bundle.putBoolean("IS_CUSTOM_INDICATOR", this.b);
        return bundle;
    }

    public void setCurrentItem(int i) {
        J(i, true);
    }

    public BannerViewPager(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BannerViewPager(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = new Handler(Looper.getMainLooper());
        this.k = new Runnable() { // from class: com.zhpan.bannerview.b
            @Override // java.lang.Runnable
            public final void run() {
                BannerViewPager.this.i();
            }
        };
        this.q = new a();
        j(context, attributeSet);
    }
}
