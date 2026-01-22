package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.LinearLayoutCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: l, reason: collision with root package name */
    private static final Interpolator f١٣٤٧l = new DecelerateInterpolator();

    /* renamed from: a, reason: collision with root package name */
    Runnable f١٣٤٨a;

    /* renamed from: b, reason: collision with root package name */
    private c f١٣٤٩b;

    /* renamed from: c, reason: collision with root package name */
    LinearLayoutCompat f١٣٥٠c;

    /* renamed from: d, reason: collision with root package name */
    private Spinner f١٣٥١d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f١٣٥٢e;

    /* renamed from: f, reason: collision with root package name */
    int f١٣٥٣f;

    /* renamed from: g, reason: collision with root package name */
    int f١٣٥٤g;

    /* renamed from: h, reason: collision with root package name */
    private int f١٣٥٥h;

    /* renamed from: i, reason: collision with root package name */
    private int f١٣٥٦i;

    /* renamed from: j, reason: collision with root package name */
    protected ViewPropertyAnimator f١٣٥٧j;

    /* renamed from: k, reason: collision with root package name */
    protected final d f١٣٥٨k;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class TabView extends LinearLayout {

        /* renamed from: a, reason: collision with root package name */
        private final int[] f١٣٥٩a;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public TabView(Context context, a.c cVar, boolean z10) {
            super(context, null, r3);
            int i10 = R.attr.actionBarTabStyle;
            int[] iArr = {android.R.attr.background};
            this.f١٣٥٩a = iArr;
            p0 v10 = p0.v(context, null, iArr, i10, 0);
            if (v10.s(0)) {
                setBackgroundDrawable(v10.g(0));
            }
            v10.x();
            if (z10) {
                setGravity(8388627);
            }
            b();
        }

        public void a(a.c cVar) {
            b();
        }

        public void b() {
            throw null;
        }

        public a.c getTab() {
            return null;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i10, int i11) {
            super.onMeasure(i10, i11);
            if (ScrollingTabContainerView.this.f١٣٥٣f > 0) {
                int measuredWidth = getMeasuredWidth();
                int i12 = ScrollingTabContainerView.this.f١٣٥٣f;
                if (measuredWidth > i12) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i12, 1073741824), i11);
                }
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z10) {
            boolean z11;
            if (isSelected() != z10) {
                z11 = true;
            } else {
                z11 = false;
            }
            super.setSelected(z10);
            if (z11 && z10) {
                sendAccessibilityEvent(4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f١٣٦١a;

        a(View view) {
            this.f١٣٦١a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ScrollingTabContainerView.this.smoothScrollTo(this.f١٣٦١a.getLeft() - ((ScrollingTabContainerView.this.getWidth() - this.f١٣٦١a.getWidth()) / 2), 0);
            ScrollingTabContainerView.this.f١٣٤٨a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class b extends BaseAdapter {
        b() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ScrollingTabContainerView.this.f١٣٥٠c.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i10) {
            ((TabView) ScrollingTabContainerView.this.f١٣٥٠c.getChildAt(i10)).getTab();
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            if (view == null) {
                ScrollingTabContainerView scrollingTabContainerView = ScrollingTabContainerView.this;
                androidx.appcompat.app.a0.a(getItem(i10));
                return scrollingTabContainerView.d(null, true);
            }
            androidx.appcompat.app.a0.a(getItem(i10));
            ((TabView) view).a(null);
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((TabView) view).getTab();
            throw null;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    protected class d extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private boolean f١٣٦٥a = false;

        /* renamed from: b, reason: collision with root package name */
        private int f١٣٦٦b;

        protected d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f١٣٦٥a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f١٣٦٥a) {
                return;
            }
            ScrollingTabContainerView scrollingTabContainerView = ScrollingTabContainerView.this;
            scrollingTabContainerView.f١٣٥٧j = null;
            scrollingTabContainerView.setVisibility(this.f١٣٦٦b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ScrollingTabContainerView.this.setVisibility(0);
            this.f١٣٦٥a = false;
        }
    }

    public ScrollingTabContainerView(Context context) {
        super(context);
        this.f١٣٥٨k = new d();
        setHorizontalScrollBarEnabled(false);
        androidx.appcompat.view.a b10 = androidx.appcompat.view.a.b(context);
        setContentHeight(b10.f());
        this.f١٣٥٤g = b10.e();
        LinearLayoutCompat c10 = c();
        this.f١٣٥٠c = c10;
        addView(c10, new ViewGroup.LayoutParams(-2, -1));
    }

    private Spinner b() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), null, R.attr.actionDropDownStyle);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.a(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    private LinearLayoutCompat c() {
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(getContext(), null, R.attr.actionBarTabBarStyle);
        linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams(new LinearLayoutCompat.a(-2, -1));
        return linearLayoutCompat;
    }

    private boolean e() {
        Spinner spinner = this.f١٣٥١d;
        if (spinner != null && spinner.getParent() == this) {
            return true;
        }
        return false;
    }

    private void f() {
        if (e()) {
            return;
        }
        if (this.f١٣٥١d == null) {
            this.f١٣٥١d = b();
        }
        removeView(this.f١٣٥٠c);
        addView(this.f١٣٥١d, new ViewGroup.LayoutParams(-2, -1));
        if (this.f١٣٥١d.getAdapter() == null) {
            this.f١٣٥١d.setAdapter((SpinnerAdapter) new b());
        }
        Runnable runnable = this.f١٣٤٨a;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.f١٣٤٨a = null;
        }
        this.f١٣٥١d.setSelection(this.f١٣٥٦i);
    }

    private boolean g() {
        if (!e()) {
            return false;
        }
        removeView(this.f١٣٥١d);
        addView(this.f١٣٥٠c, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f١٣٥١d.getSelectedItemPosition());
        return false;
    }

    public void a(int i10) {
        View childAt = this.f١٣٥٠c.getChildAt(i10);
        Runnable runnable = this.f١٣٤٨a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        a aVar = new a(childAt);
        this.f١٣٤٨a = aVar;
        post(aVar);
    }

    TabView d(a.c cVar, boolean z10) {
        TabView tabView = new TabView(getContext(), cVar, z10);
        if (z10) {
            tabView.setBackgroundDrawable(null);
            tabView.setLayoutParams(new AbsListView.LayoutParams(-1, this.f١٣٥٥h));
        } else {
            tabView.setFocusable(true);
            if (this.f١٣٤٩b == null) {
                this.f١٣٤٩b = new c();
            }
            tabView.setOnClickListener(this.f١٣٤٩b);
        }
        return tabView;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f١٣٤٨a;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        androidx.appcompat.view.a b10 = androidx.appcompat.view.a.b(getContext());
        setContentHeight(b10.f());
        this.f١٣٥٤g = b10.e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f١٣٤٨a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView adapterView, View view, int i10, long j10) {
        ((TabView) view).getTab();
        throw null;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        boolean z10;
        int mode = View.MeasureSpec.getMode(i10);
        if (mode == 1073741824) {
            z10 = true;
        } else {
            z10 = false;
        }
        setFillViewport(z10);
        int childCount = this.f١٣٥٠c.getChildCount();
        if (childCount > 1 && (mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            if (childCount > 2) {
                this.f١٣٥٣f = (int) (View.MeasureSpec.getSize(i10) * 0.4f);
            } else {
                this.f١٣٥٣f = View.MeasureSpec.getSize(i10) / 2;
            }
            this.f١٣٥٣f = Math.min(this.f١٣٥٣f, this.f١٣٥٤g);
        } else {
            this.f١٣٥٣f = -1;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f١٣٥٥h, 1073741824);
        if (!z10 && this.f١٣٥٢e) {
            this.f١٣٥٠c.measure(0, makeMeasureSpec);
            if (this.f١٣٥٠c.getMeasuredWidth() > View.MeasureSpec.getSize(i10)) {
                f();
            } else {
                g();
            }
        } else {
            g();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i10, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (z10 && measuredWidth != measuredWidth2) {
            setTabSelected(this.f١٣٥٦i);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView adapterView) {
    }

    public void setAllowCollapse(boolean z10) {
        this.f١٣٥٢e = z10;
    }

    public void setContentHeight(int i10) {
        this.f١٣٥٥h = i10;
        requestLayout();
    }

    public void setTabSelected(int i10) {
        boolean z10;
        this.f١٣٥٦i = i10;
        int childCount = this.f١٣٥٠c.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = this.f١٣٥٠c.getChildAt(i11);
            if (i11 == i10) {
                z10 = true;
            } else {
                z10 = false;
            }
            childAt.setSelected(z10);
            if (z10) {
                a(i10);
            }
        }
        Spinner spinner = this.f١٣٥١d;
        if (spinner != null && i10 >= 0) {
            spinner.setSelection(i10);
        }
    }
}
