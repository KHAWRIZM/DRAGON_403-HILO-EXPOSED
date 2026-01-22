package com.google.android.material.tabs;

import a8.k;
import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Dimension;
import androidx.appcompat.widget.u0;
import androidx.core.util.Pools;
import androidx.core.view.d1;
import androidx.core.view.n0;
import androidx.core.widget.l;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.R;
import com.google.android.material.internal.h0;
import com.google.android.material.internal.k0;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import f8.i;
import f8.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import m2.g0;

@ViewPager.e
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class TabLayout extends HorizontalScrollView {
    private static final int ANIMATION_DURATION = 300;

    @Dimension(unit = 0)
    static final int DEFAULT_GAP_TEXT_ICON = 8;

    @Dimension(unit = 0)
    private static final int DEFAULT_HEIGHT = 48;

    @Dimension(unit = 0)
    private static final int DEFAULT_HEIGHT_WITH_TEXT_ICON = 72;

    @Dimension(unit = 0)
    static final int FIXED_WRAP_GUTTER_MIN = 16;
    public static final int GRAVITY_CENTER = 1;
    public static final int GRAVITY_FILL = 0;
    public static final int GRAVITY_START = 2;
    public static final int INDICATOR_ANIMATION_MODE_ELASTIC = 1;
    public static final int INDICATOR_ANIMATION_MODE_FADE = 2;
    public static final int INDICATOR_ANIMATION_MODE_LINEAR = 0;
    public static final int INDICATOR_GRAVITY_BOTTOM = 0;
    public static final int INDICATOR_GRAVITY_CENTER = 1;
    public static final int INDICATOR_GRAVITY_STRETCH = 3;
    public static final int INDICATOR_GRAVITY_TOP = 2;
    private static final int INVALID_WIDTH = -1;
    private static final String LOG_TAG = "TabLayout";
    public static final int MODE_AUTO = 2;
    public static final int MODE_FIXED = 1;
    public static final int MODE_SCROLLABLE = 0;
    private static final int SELECTED_INDICATOR_HEIGHT_DEFAULT = -1;
    public static final int TAB_LABEL_VISIBILITY_LABELED = 1;
    public static final int TAB_LABEL_VISIBILITY_UNLABELED = 0;

    @Dimension(unit = 0)
    private static final int TAB_MIN_WIDTH_MARGIN = 56;
    private b adapterChangeListener;
    private int contentInsetStart;
    private c currentVpSelectedListener;
    private final int defaultTabTextAppearance;
    int indicatorPosition;
    boolean inlineLabel;
    int mode;
    private g pageChangeListener;
    private androidx.viewpager.widget.a pagerAdapter;
    private DataSetObserver pagerAdapterObserver;
    private final int requestedTabMaxWidth;
    private final int requestedTabMinWidth;
    private ValueAnimator scrollAnimator;
    private final int scrollableTabMinWidth;
    private c selectedListener;
    private final ArrayList<c> selectedListeners;
    private f selectedTab;
    private int selectedTabTextAppearance;
    float selectedTabTextSize;
    private boolean setupViewPagerImplicitly;
    final SlidingTabIndicator slidingTabIndicator;
    final int tabBackgroundResId;
    int tabGravity;
    ColorStateList tabIconTint;
    PorterDuff.Mode tabIconTintMode;
    int tabIndicatorAnimationDuration;
    int tabIndicatorAnimationMode;
    boolean tabIndicatorFullWidth;
    int tabIndicatorGravity;
    int tabIndicatorHeight;
    private com.google.android.material.tabs.c tabIndicatorInterpolator;
    private final TimeInterpolator tabIndicatorTimeInterpolator;
    int tabMaxWidth;
    int tabPaddingBottom;
    int tabPaddingEnd;
    int tabPaddingStart;
    int tabPaddingTop;
    ColorStateList tabRippleColorStateList;
    Drawable tabSelectedIndicator;
    private int tabSelectedIndicatorColor;
    private final int tabTextAppearance;
    ColorStateList tabTextColors;
    float tabTextMultiLineSize;
    float tabTextSize;
    private final Pools.Pool<TabView> tabViewPool;
    private final ArrayList<f> tabs;
    boolean unboundedRipple;
    ViewPager viewPager;
    private int viewPagerScrollState;
    private static final int DEF_STYLE_RES = R.style.Widget_Design_TabLayout;
    private static final Pools.Pool<f> tabPool = new Pools.SynchronizedPool(16);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class SlidingTabIndicator extends LinearLayout {

        /* renamed from: a, reason: collision with root package name */
        ValueAnimator f١٠٠٢٢a;

        /* renamed from: b, reason: collision with root package name */
        private int f١٠٠٢٣b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ View f١٠٠٢٥a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ View f١٠٠٢٦b;

            a(View view, View view2) {
                this.f١٠٠٢٥a = view;
                this.f١٠٠٢٦b = view2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SlidingTabIndicator.this.j(this.f١٠٠٢٥a, this.f١٠٠٢٦b, valueAnimator.getAnimatedFraction());
            }
        }

        SlidingTabIndicator(Context context) {
            super(context);
            this.f١٠٠٢٣b = -1;
            setWillNotDraw(false);
        }

        private void e() {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.indicatorPosition == -1) {
                tabLayout.indicatorPosition = tabLayout.getSelectedTabPosition();
            }
            f(TabLayout.this.indicatorPosition);
        }

        private void f(int i10) {
            if (TabLayout.this.viewPagerScrollState != 0 && (TabLayout.this.getTabSelectedIndicator().getBounds().left != -1 || TabLayout.this.getTabSelectedIndicator().getBounds().right != -1)) {
                return;
            }
            View childAt = getChildAt(i10);
            com.google.android.material.tabs.c cVar = TabLayout.this.tabIndicatorInterpolator;
            TabLayout tabLayout = TabLayout.this;
            cVar.c(tabLayout, childAt, tabLayout.tabSelectedIndicator);
            TabLayout.this.indicatorPosition = i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g() {
            f(TabLayout.this.getSelectedTabPosition());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(View view, View view2, float f10) {
            if (view != null && view.getWidth() > 0) {
                com.google.android.material.tabs.c cVar = TabLayout.this.tabIndicatorInterpolator;
                TabLayout tabLayout = TabLayout.this;
                cVar.d(tabLayout, view, view2, f10, tabLayout.tabSelectedIndicator);
            } else {
                Drawable drawable = TabLayout.this.tabSelectedIndicator;
                drawable.setBounds(-1, drawable.getBounds().top, -1, TabLayout.this.tabSelectedIndicator.getBounds().bottom);
            }
            postInvalidateOnAnimation();
        }

        private void k(boolean z10, int i10, int i11) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.indicatorPosition == i10) {
                return;
            }
            View childAt = getChildAt(tabLayout.getSelectedTabPosition());
            View childAt2 = getChildAt(i10);
            if (childAt2 == null) {
                g();
                return;
            }
            TabLayout.this.indicatorPosition = i10;
            a aVar = new a(childAt, childAt2);
            if (z10) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.f١٠٠٢٢a = valueAnimator;
                valueAnimator.setInterpolator(TabLayout.this.tabIndicatorTimeInterpolator);
                valueAnimator.setDuration(i11);
                valueAnimator.setFloatValues(DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
                valueAnimator.addUpdateListener(aVar);
                valueAnimator.start();
                return;
            }
            this.f١٠٠٢٢a.removeAllUpdateListeners();
            this.f١٠٠٢٢a.addUpdateListener(aVar);
        }

        void c(int i10, int i11) {
            ValueAnimator valueAnimator = this.f١٠٠٢٢a;
            if (valueAnimator != null && valueAnimator.isRunning() && TabLayout.this.indicatorPosition != i10) {
                this.f١٠٠٢٢a.cancel();
            }
            k(true, i10, i11);
        }

        boolean d() {
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                if (getChildAt(i10).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            int height;
            int height2 = TabLayout.this.tabSelectedIndicator.getBounds().height();
            if (height2 < 0) {
                height2 = TabLayout.this.tabSelectedIndicator.getIntrinsicHeight();
            }
            int i10 = TabLayout.this.tabIndicatorGravity;
            if (i10 != 0) {
                if (i10 != 1) {
                    height = 0;
                    if (i10 != 2) {
                        if (i10 != 3) {
                            height2 = 0;
                        } else {
                            height2 = getHeight();
                        }
                    }
                } else {
                    height = (getHeight() - height2) / 2;
                    height2 = (getHeight() + height2) / 2;
                }
            } else {
                height = getHeight() - height2;
                height2 = getHeight();
            }
            if (TabLayout.this.tabSelectedIndicator.getBounds().width() > 0) {
                Rect bounds = TabLayout.this.tabSelectedIndicator.getBounds();
                TabLayout.this.tabSelectedIndicator.setBounds(bounds.left, height, bounds.right, height2);
                TabLayout.this.tabSelectedIndicator.draw(canvas);
            }
            super.draw(canvas);
        }

        void h(int i10, float f10) {
            TabLayout.this.indicatorPosition = Math.round(i10 + f10);
            ValueAnimator valueAnimator = this.f١٠٠٢٢a;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f١٠٠٢٢a.cancel();
            }
            j(getChildAt(i10), getChildAt(i10 + 1), f10);
        }

        void i(int i10) {
            Rect bounds = TabLayout.this.tabSelectedIndicator.getBounds();
            TabLayout.this.tabSelectedIndicator.setBounds(bounds.left, 0, bounds.right, i10);
            requestLayout();
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
            super.onLayout(z10, i10, i11, i12, i13);
            ValueAnimator valueAnimator = this.f١٠٠٢٢a;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                k(false, TabLayout.this.getSelectedTabPosition(), -1);
            } else {
                e();
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i10, int i11) {
            super.onMeasure(i10, i11);
            if (View.MeasureSpec.getMode(i10) != 1073741824) {
                return;
            }
            TabLayout tabLayout = TabLayout.this;
            boolean z10 = true;
            if (tabLayout.tabGravity == 1 || tabLayout.mode == 2) {
                int childCount = getChildCount();
                int i12 = 0;
                for (int i13 = 0; i13 < childCount; i13++) {
                    View childAt = getChildAt(i13);
                    if (childAt.getVisibility() == 0) {
                        i12 = Math.max(i12, childAt.getMeasuredWidth());
                    }
                }
                if (i12 <= 0) {
                    return;
                }
                if (i12 * childCount <= getMeasuredWidth() - (((int) k0.g(getContext(), 16)) * 2)) {
                    boolean z11 = false;
                    for (int i14 = 0; i14 < childCount; i14++) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i14).getLayoutParams();
                        if (layoutParams.width != i12 || layoutParams.weight != DownloadProgress.UNKNOWN_PROGRESS) {
                            layoutParams.width = i12;
                            layoutParams.weight = DownloadProgress.UNKNOWN_PROGRESS;
                            z11 = true;
                        }
                    }
                    z10 = z11;
                } else {
                    TabLayout tabLayout2 = TabLayout.this;
                    tabLayout2.tabGravity = 0;
                    tabLayout2.updateTabViews(false);
                }
                if (z10) {
                    super.onMeasure(i10, i11);
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i10) {
            super.onRtlPropertiesChanged(i10);
            if (Build.VERSION.SDK_INT < 23 && this.f١٠٠٢٣b != i10) {
                requestLayout();
                this.f١٠٠٢٣b = i10;
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public final class TabView extends LinearLayout {

        /* renamed from: a, reason: collision with root package name */
        private f f١٠٠٢٨a;

        /* renamed from: b, reason: collision with root package name */
        private TextView f١٠٠٢٩b;

        /* renamed from: c, reason: collision with root package name */
        private ImageView f١٠٠٣٠c;

        /* renamed from: d, reason: collision with root package name */
        private View f١٠٠٣١d;

        /* renamed from: e, reason: collision with root package name */
        private com.google.android.material.badge.a f١٠٠٣٢e;

        /* renamed from: f, reason: collision with root package name */
        private View f١٠٠٣٣f;

        /* renamed from: g, reason: collision with root package name */
        private TextView f١٠٠٣٤g;

        /* renamed from: h, reason: collision with root package name */
        private ImageView f١٠٠٣٥h;

        /* renamed from: i, reason: collision with root package name */
        private Drawable f١٠٠٣٦i;

        /* renamed from: j, reason: collision with root package name */
        private int f١٠٠٣٧j;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public class a implements View.OnLayoutChangeListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ View f١٠٠٣٩a;

            a(View view) {
                this.f١٠٠٣٩a = view;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                if (this.f١٠٠٣٩a.getVisibility() == 0) {
                    TabView.this.o(this.f١٠٠٣٩a);
                }
            }
        }

        public TabView(Context context) {
            super(context);
            this.f١٠٠٣٧j = 2;
            q(context);
            setPaddingRelative(TabLayout.this.tabPaddingStart, TabLayout.this.tabPaddingTop, TabLayout.this.tabPaddingEnd, TabLayout.this.tabPaddingBottom);
            setGravity(17);
            setOrientation(!TabLayout.this.inlineLabel ? 1 : 0);
            setClickable(true);
            d1.F0(this, n0.b(getContext(), 1002));
        }

        private void d(View view) {
            if (view == null) {
                return;
            }
            view.addOnLayoutChangeListener(new a(view));
        }

        private float e(Layout layout, int i10, float f10) {
            return layout.getLineWidth(i10) * (f10 / layout.getPaint().getTextSize());
        }

        private void f(boolean z10) {
            setClipChildren(z10);
            setClipToPadding(z10);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(z10);
                viewGroup.setClipToPadding(z10);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(Canvas canvas) {
            Drawable drawable = this.f١٠٠٣٦i;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.f١٠٠٣٦i.draw(canvas);
            }
        }

        private com.google.android.material.badge.a getBadge() {
            return this.f١٠٠٣٢e;
        }

        private com.google.android.material.badge.a getOrCreateBadge() {
            if (this.f١٠٠٣٢e == null) {
                this.f١٠٠٣٢e = com.google.android.material.badge.a.e(getContext());
            }
            n();
            com.google.android.material.badge.a aVar = this.f١٠٠٣٢e;
            if (aVar != null) {
                return aVar;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        private boolean h() {
            if (this.f١٠٠٣٢e != null) {
                return true;
            }
            return false;
        }

        private void i() {
            ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, (ViewGroup) this, false);
            this.f١٠٠٣٠c = imageView;
            addView(imageView, 0);
        }

        private void j() {
            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, (ViewGroup) this, false);
            this.f١٠٠٢٩b = textView;
            addView(textView);
        }

        private void l(View view) {
            if (h() && view != null) {
                f(false);
                com.google.android.material.badge.b.b(this.f١٠٠٣٢e, view, null);
                this.f١٠٠٣١d = view;
            }
        }

        private void m() {
            if (!h()) {
                return;
            }
            f(true);
            View view = this.f١٠٠٣١d;
            if (view != null) {
                com.google.android.material.badge.b.e(this.f١٠٠٣٢e, view);
                this.f١٠٠٣١d = null;
            }
        }

        private void n() {
            f fVar;
            f fVar2;
            if (!h()) {
                return;
            }
            if (this.f١٠٠٣٣f != null) {
                m();
                return;
            }
            if (this.f١٠٠٣٠c != null && (fVar2 = this.f١٠٠٢٨a) != null && fVar2.f() != null) {
                View view = this.f١٠٠٣١d;
                ImageView imageView = this.f١٠٠٣٠c;
                if (view != imageView) {
                    m();
                    l(this.f١٠٠٣٠c);
                    return;
                } else {
                    o(imageView);
                    return;
                }
            }
            if (this.f١٠٠٢٩b != null && (fVar = this.f١٠٠٢٨a) != null && fVar.h() == 1) {
                View view2 = this.f١٠٠٣١d;
                TextView textView = this.f١٠٠٢٩b;
                if (view2 != textView) {
                    m();
                    l(this.f١٠٠٢٩b);
                    return;
                } else {
                    o(textView);
                    return;
                }
            }
            m();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o(View view) {
            if (h() && view == this.f١٠٠٣١d) {
                com.google.android.material.badge.b.f(this.f١٠٠٣٢e, view, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0, types: [android.graphics.drawable.RippleDrawable] */
        /* JADX WARN: Type inference failed for: r5v0, types: [android.view.View, com.google.android.material.tabs.TabLayout$TabView] */
        public void q(Context context) {
            int i10 = TabLayout.this.tabBackgroundResId;
            GradientDrawable gradientDrawable = null;
            if (i10 != 0) {
                Drawable b10 = r1.a.b(context, i10);
                this.f١٠٠٣٦i = b10;
                if (b10 != null && b10.isStateful()) {
                    this.f١٠٠٣٦i.setState(getDrawableState());
                }
            } else {
                this.f١٠٠٣٦i = null;
            }
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(0);
            if (TabLayout.this.tabRippleColorStateList != null) {
                GradientDrawable gradientDrawable3 = new GradientDrawable();
                gradientDrawable3.setCornerRadius(1.0E-5f);
                gradientDrawable3.setColor(-1);
                ColorStateList a10 = d8.a.a(TabLayout.this.tabRippleColorStateList);
                boolean z10 = TabLayout.this.unboundedRipple;
                if (z10) {
                    gradientDrawable2 = null;
                }
                if (!z10) {
                    gradientDrawable = gradientDrawable3;
                }
                gradientDrawable2 = new RippleDrawable(a10, gradientDrawable2, gradientDrawable);
            }
            setBackground(gradientDrawable2);
            TabLayout.this.invalidate();
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x005d, code lost:
        
            if (r7.f١٠٠٢٨a.f١٠٠٥١g == 1) goto L٢٨;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void t(TextView textView, ImageView imageView, boolean z10) {
            Drawable drawable;
            CharSequence charSequence;
            boolean z11;
            int i10;
            CharSequence charSequence2;
            int i11;
            f fVar = this.f١٠٠٢٨a;
            CharSequence charSequence3 = null;
            if (fVar != null && fVar.f() != null) {
                drawable = h2.b.r(this.f١٠٠٢٨a.f()).mutate();
            } else {
                drawable = null;
            }
            if (drawable != null) {
                drawable.setTintList(TabLayout.this.tabIconTint);
                PorterDuff.Mode mode = TabLayout.this.tabIconTintMode;
                if (mode != null) {
                    drawable.setTintMode(mode);
                }
            }
            f fVar2 = this.f١٠٠٢٨a;
            if (fVar2 != null) {
                charSequence = fVar2.i();
            } else {
                charSequence = null;
            }
            if (imageView != null) {
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean isEmpty = TextUtils.isEmpty(charSequence);
            if (textView != null) {
                if (!isEmpty) {
                    z11 = true;
                }
                z11 = false;
                if (!isEmpty) {
                    charSequence2 = charSequence;
                } else {
                    charSequence2 = null;
                }
                textView.setText(charSequence2);
                if (z11) {
                    i11 = 0;
                } else {
                    i11 = 8;
                }
                textView.setVisibility(i11);
                if (!isEmpty) {
                    setVisibility(0);
                }
            } else {
                z11 = false;
            }
            if (z10 && imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                if (z11 && imageView.getVisibility() == 0) {
                    i10 = (int) k0.g(getContext(), 8);
                } else {
                    i10 = 0;
                }
                if (TabLayout.this.inlineLabel) {
                    if (i10 != marginLayoutParams.getMarginEnd()) {
                        marginLayoutParams.setMarginEnd(i10);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (i10 != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = i10;
                    marginLayoutParams.setMarginEnd(0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            f fVar3 = this.f١٠٠٢٨a;
            if (fVar3 != null) {
                charSequence3 = fVar3.f١٠٠٤٨d;
            }
            if (Build.VERSION.SDK_INT > 23) {
                if (isEmpty) {
                    charSequence = charSequence3;
                }
                u0.a(this, charSequence);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void drawableStateChanged() {
            boolean z10;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.f١٠٠٣٦i;
            if (drawable != null && drawable.isStateful()) {
                z10 = this.f١٠٠٣٦i.setState(drawableState);
            } else {
                z10 = false;
            }
            if (z10) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getContentHeight() {
            View[] viewArr = {this.f١٠٠٢٩b, this.f١٠٠٣٠c, this.f١٠٠٣٣f};
            int i10 = 0;
            int i11 = 0;
            boolean z10 = false;
            for (int i12 = 0; i12 < 3; i12++) {
                View view = viewArr[i12];
                if (view != null && view.getVisibility() == 0) {
                    if (z10) {
                        i11 = Math.min(i11, view.getTop());
                    } else {
                        i11 = view.getTop();
                    }
                    if (z10) {
                        i10 = Math.max(i10, view.getBottom());
                    } else {
                        i10 = view.getBottom();
                    }
                    z10 = true;
                }
            }
            return i10 - i11;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getContentWidth() {
            View[] viewArr = {this.f١٠٠٢٩b, this.f١٠٠٣٠c, this.f١٠٠٣٣f};
            int i10 = 0;
            int i11 = 0;
            boolean z10 = false;
            for (int i12 = 0; i12 < 3; i12++) {
                View view = viewArr[i12];
                if (view != null && view.getVisibility() == 0) {
                    if (z10) {
                        i11 = Math.min(i11, view.getLeft());
                    } else {
                        i11 = view.getLeft();
                    }
                    if (z10) {
                        i10 = Math.max(i10, view.getRight());
                    } else {
                        i10 = view.getRight();
                    }
                    z10 = true;
                }
            }
            return i10 - i11;
        }

        public f getTab() {
            return this.f١٠٠٢٨a;
        }

        void k() {
            setTab(null);
            setSelected(false);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            g0 V0 = g0.V0(accessibilityNodeInfo);
            com.google.android.material.badge.a aVar = this.f١٠٠٣٢e;
            if (aVar != null && aVar.isVisible()) {
                V0.s0(this.f١٠٠٣٢e.j());
            }
            V0.r0(g0.f.a(0, 1, this.f١٠٠٢٨a.g(), 1, false, isSelected()));
            if (isSelected()) {
                V0.p0(false);
                V0.f0(g0.a.f١٥٩٣٠i);
            }
            V0.J0(getResources().getString(R.string.item_view_role_description));
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i10, int i11) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i10);
            int mode = View.MeasureSpec.getMode(i10);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i10 = View.MeasureSpec.makeMeasureSpec(TabLayout.this.tabMaxWidth, Integer.MIN_VALUE);
            }
            super.onMeasure(i10, i11);
            if (this.f١٠٠٢٩b != null) {
                float f10 = TabLayout.this.tabTextSize;
                if (isSelected() && TabLayout.this.selectedTabTextAppearance != -1) {
                    f10 = TabLayout.this.selectedTabTextSize;
                }
                int i12 = this.f١٠٠٣٧j;
                ImageView imageView = this.f١٠٠٣٠c;
                if (imageView != null && imageView.getVisibility() == 0) {
                    i12 = 1;
                } else {
                    TextView textView = this.f١٠٠٢٩b;
                    if (textView != null && textView.getLineCount() > 1) {
                        f10 = TabLayout.this.tabTextMultiLineSize;
                    }
                }
                float textSize = this.f١٠٠٢٩b.getTextSize();
                int lineCount = this.f١٠٠٢٩b.getLineCount();
                int maxLines = this.f١٠٠٢٩b.getMaxLines();
                if (f10 != textSize || (maxLines >= 0 && i12 != maxLines)) {
                    if (TabLayout.this.mode != 1 || f10 <= textSize || lineCount != 1 || ((layout = this.f١٠٠٢٩b.getLayout()) != null && e(layout, 0, f10) <= (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        this.f١٠٠٢٩b.setTextSize(0, f10);
                        this.f١٠٠٢٩b.setMaxLines(i12);
                        super.onMeasure(i10, i11);
                    }
                }
            }
        }

        final void p() {
            boolean z10;
            s();
            f fVar = this.f١٠٠٢٨a;
            if (fVar != null && fVar.j()) {
                z10 = true;
            } else {
                z10 = false;
            }
            setSelected(z10);
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.f١٠٠٢٨a != null) {
                if (!performClick) {
                    playSoundEffect(0);
                }
                this.f١٠٠٢٨a.l();
                return true;
            }
            return performClick;
        }

        final void r() {
            setOrientation(!TabLayout.this.inlineLabel ? 1 : 0);
            TextView textView = this.f١٠٠٣٤g;
            if (textView == null && this.f١٠٠٣٥h == null) {
                t(this.f١٠٠٢٩b, this.f١٠٠٣٠c, true);
            } else {
                t(textView, this.f١٠٠٣٥h, false);
            }
        }

        final void s() {
            View view;
            ViewParent parent;
            f fVar = this.f١٠٠٢٨a;
            if (fVar != null) {
                view = fVar.e();
            } else {
                view = null;
            }
            if (view != null) {
                ViewParent parent2 = view.getParent();
                if (parent2 != this) {
                    if (parent2 != null) {
                        ((ViewGroup) parent2).removeView(view);
                    }
                    View view2 = this.f١٠٠٣٣f;
                    if (view2 != null && (parent = view2.getParent()) != null) {
                        ((ViewGroup) parent).removeView(this.f١٠٠٣٣f);
                    }
                    addView(view);
                }
                this.f١٠٠٣٣f = view;
                TextView textView = this.f١٠٠٢٩b;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f١٠٠٣٠c;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f١٠٠٣٠c.setImageDrawable(null);
                }
                TextView textView2 = (TextView) view.findViewById(android.R.id.text1);
                this.f١٠٠٣٤g = textView2;
                if (textView2 != null) {
                    this.f١٠٠٣٧j = textView2.getMaxLines();
                }
                this.f١٠٠٣٥h = (ImageView) view.findViewById(android.R.id.icon);
            } else {
                View view3 = this.f١٠٠٣٣f;
                if (view3 != null) {
                    removeView(view3);
                    this.f١٠٠٣٣f = null;
                }
                this.f١٠٠٣٤g = null;
                this.f١٠٠٣٥h = null;
            }
            if (this.f١٠٠٣٣f == null) {
                if (this.f١٠٠٣٠c == null) {
                    i();
                }
                if (this.f١٠٠٢٩b == null) {
                    j();
                    this.f١٠٠٣٧j = this.f١٠٠٢٩b.getMaxLines();
                }
                l.m(this.f١٠٠٢٩b, TabLayout.this.defaultTabTextAppearance);
                if (isSelected() && TabLayout.this.selectedTabTextAppearance != -1) {
                    l.m(this.f١٠٠٢٩b, TabLayout.this.selectedTabTextAppearance);
                } else {
                    l.m(this.f١٠٠٢٩b, TabLayout.this.tabTextAppearance);
                }
                ColorStateList colorStateList = TabLayout.this.tabTextColors;
                if (colorStateList != null) {
                    this.f١٠٠٢٩b.setTextColor(colorStateList);
                }
                t(this.f١٠٠٢٩b, this.f١٠٠٣٠c, true);
                n();
                d(this.f١٠٠٣٠c);
                d(this.f١٠٠٢٩b);
            } else {
                TextView textView3 = this.f١٠٠٣٤g;
                if (textView3 != null || this.f١٠٠٣٥h != null) {
                    t(textView3, this.f١٠٠٣٥h, false);
                }
            }
            if (fVar != null && !TextUtils.isEmpty(fVar.f١٠٠٤٨d)) {
                setContentDescription(fVar.f١٠٠٤٨d);
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z10) {
            isSelected();
            super.setSelected(z10);
            TextView textView = this.f١٠٠٢٩b;
            if (textView != null) {
                textView.setSelected(z10);
            }
            ImageView imageView = this.f١٠٠٣٠c;
            if (imageView != null) {
                imageView.setSelected(z10);
            }
            View view = this.f١٠٠٣٣f;
            if (view != null) {
                view.setSelected(z10);
            }
        }

        void setTab(f fVar) {
            if (fVar != this.f١٠٠٢٨a) {
                this.f١٠٠٢٨a = fVar;
                p();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class b implements ViewPager.i {

        /* renamed from: a, reason: collision with root package name */
        private boolean f١٠٠٤٢a;

        b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.viewPager == viewPager) {
                tabLayout.setPagerAdapter(aVar2, this.f١٠٠٤٢a);
            }
        }

        void b(boolean z10) {
            this.f١٠٠٤٢a = z10;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface c {
        void onTabReselected(f fVar);

        void onTabSelected(f fVar);

        void onTabUnselected(f fVar);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface d extends c {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class e extends DataSetObserver {
        e() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            TabLayout.this.populateFromPagerAdapter();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TabLayout.this.populateFromPagerAdapter();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        private Object f١٠٠٤٥a;

        /* renamed from: b, reason: collision with root package name */
        private Drawable f١٠٠٤٦b;

        /* renamed from: c, reason: collision with root package name */
        private CharSequence f١٠٠٤٧c;

        /* renamed from: d, reason: collision with root package name */
        private CharSequence f١٠٠٤٨d;

        /* renamed from: f, reason: collision with root package name */
        private View f١٠٠٥٠f;

        /* renamed from: h, reason: collision with root package name */
        public TabLayout f١٠٠٥٢h;

        /* renamed from: i, reason: collision with root package name */
        public TabView f١٠٠٥٣i;

        /* renamed from: e, reason: collision with root package name */
        private int f١٠٠٤٩e = -1;

        /* renamed from: g, reason: collision with root package name */
        private int f١٠٠٥١g = 1;

        /* renamed from: j, reason: collision with root package name */
        private int f١٠٠٥٤j = -1;

        public View e() {
            return this.f١٠٠٥٠f;
        }

        public Drawable f() {
            return this.f١٠٠٤٦b;
        }

        public int g() {
            return this.f١٠٠٤٩e;
        }

        public int h() {
            return this.f١٠٠٥١g;
        }

        public CharSequence i() {
            return this.f١٠٠٤٧c;
        }

        public boolean j() {
            TabLayout tabLayout = this.f١٠٠٥٢h;
            if (tabLayout != null) {
                int selectedTabPosition = tabLayout.getSelectedTabPosition();
                if (selectedTabPosition != -1 && selectedTabPosition == this.f١٠٠٤٩e) {
                    return true;
                }
                return false;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        void k() {
            this.f١٠٠٥٢h = null;
            this.f١٠٠٥٣i = null;
            this.f١٠٠٤٥a = null;
            this.f١٠٠٤٦b = null;
            this.f١٠٠٥٤j = -1;
            this.f١٠٠٤٧c = null;
            this.f١٠٠٤٨d = null;
            this.f١٠٠٤٩e = -1;
            this.f١٠٠٥٠f = null;
        }

        public void l() {
            TabLayout tabLayout = this.f١٠٠٥٢h;
            if (tabLayout != null) {
                tabLayout.selectTab(this);
                return;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public f m(CharSequence charSequence) {
            this.f١٠٠٤٨d = charSequence;
            s();
            return this;
        }

        public f n(int i10) {
            return o(LayoutInflater.from(this.f١٠٠٥٣i.getContext()).inflate(i10, (ViewGroup) this.f١٠٠٥٣i, false));
        }

        public f o(View view) {
            this.f١٠٠٥٠f = view;
            s();
            return this;
        }

        public f p(Drawable drawable) {
            this.f١٠٠٤٦b = drawable;
            TabLayout tabLayout = this.f١٠٠٥٢h;
            if (tabLayout.tabGravity == 1 || tabLayout.mode == 2) {
                tabLayout.updateTabViews(true);
            }
            s();
            return this;
        }

        void q(int i10) {
            this.f١٠٠٤٩e = i10;
        }

        public f r(CharSequence charSequence) {
            if (TextUtils.isEmpty(this.f١٠٠٤٨d) && !TextUtils.isEmpty(charSequence)) {
                this.f١٠٠٥٣i.setContentDescription(charSequence);
            }
            this.f١٠٠٤٧c = charSequence;
            s();
            return this;
        }

        void s() {
            TabView tabView = this.f١٠٠٥٣i;
            if (tabView != null) {
                tabView.p();
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class g implements ViewPager.j {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference f١٠٠٥٥a;

        /* renamed from: b, reason: collision with root package name */
        private int f١٠٠٥٦b;

        /* renamed from: c, reason: collision with root package name */
        private int f١٠٠٥٧c;

        public g(TabLayout tabLayout) {
            this.f١٠٠٥٥a = new WeakReference(tabLayout);
        }

        void a() {
            this.f١٠٠٥٧c = 0;
            this.f١٠٠٥٦b = 0;
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrollStateChanged(int i10) {
            this.f١٠٠٥٦b = this.f١٠٠٥٧c;
            this.f١٠٠٥٧c = i10;
            TabLayout tabLayout = (TabLayout) this.f١٠٠٥٥a.get();
            if (tabLayout != null) {
                tabLayout.updateViewPagerScrollState(this.f١٠٠٥٧c);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrolled(int i10, float f10, int i11) {
            boolean z10;
            boolean z11;
            TabLayout tabLayout = (TabLayout) this.f١٠٠٥٥a.get();
            if (tabLayout != null) {
                int i12 = this.f١٠٠٥٧c;
                if (i12 == 2 && this.f١٠٠٥٦b != 1) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (i12 == 2 && this.f١٠٠٥٦b == 0) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                tabLayout.setScrollPosition(i10, f10, z10, z11, false);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageSelected(int i10) {
            boolean z10;
            TabLayout tabLayout = (TabLayout) this.f١٠٠٥٥a.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i10 && i10 < tabLayout.getTabCount()) {
                int i11 = this.f١٠٠٥٧c;
                if (i11 != 0 && (i11 != 2 || this.f١٠٠٥٦b != 0)) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                tabLayout.selectTab(tabLayout.getTabAt(i10), z10);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class h implements d {

        /* renamed from: a, reason: collision with root package name */
        private final ViewPager f١٠٠٥٨a;

        public h(ViewPager viewPager) {
            this.f١٠٠٥٨a = viewPager;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabReselected(f fVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabSelected(f fVar) {
            this.f١٠٠٥٨a.setCurrentItem(fVar.g());
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabUnselected(f fVar) {
        }
    }

    public TabLayout(Context context) {
        this(context, null);
    }

    private void a(TabItem tabItem) {
        f newTab = newTab();
        CharSequence charSequence = tabItem.f١٠٠١٩a;
        if (charSequence != null) {
            newTab.r(charSequence);
        }
        Drawable drawable = tabItem.f١٠٠٢٠b;
        if (drawable != null) {
            newTab.p(drawable);
        }
        int i10 = tabItem.f١٠٠٢١c;
        if (i10 != 0) {
            newTab.n(i10);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            newTab.m(tabItem.getContentDescription());
        }
        addTab(newTab);
    }

    private void b(f fVar) {
        TabView tabView = fVar.f١٠٠٥٣i;
        tabView.setSelected(false);
        tabView.setActivated(false);
        this.slidingTabIndicator.addView(tabView, fVar.g(), j());
    }

    private void c(View view) {
        if (view instanceof TabItem) {
            a((TabItem) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void d(int i10) {
        if (i10 == -1) {
            return;
        }
        if (getWindowToken() != null && isLaidOut() && !this.slidingTabIndicator.d()) {
            int scrollX = getScrollX();
            int g10 = g(i10, DownloadProgress.UNKNOWN_PROGRESS);
            if (scrollX != g10) {
                o();
                this.scrollAnimator.setIntValues(scrollX, g10);
                this.scrollAnimator.start();
            }
            this.slidingTabIndicator.c(i10, this.tabIndicatorAnimationDuration);
            return;
        }
        setScrollPosition(i10, DownloadProgress.UNKNOWN_PROGRESS, true);
    }

    private void e(int i10) {
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    return;
                }
            } else {
                this.slidingTabIndicator.setGravity(1);
                return;
            }
        } else {
            Log.w(LOG_TAG, "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
        }
        this.slidingTabIndicator.setGravity(8388611);
    }

    private void f() {
        int max;
        int i10 = this.mode;
        if (i10 != 0 && i10 != 2) {
            max = 0;
        } else {
            max = Math.max(0, this.contentInsetStart - this.tabPaddingStart);
        }
        this.slidingTabIndicator.setPaddingRelative(max, 0, 0, 0);
        int i11 = this.mode;
        if (i11 != 0) {
            if (i11 == 1 || i11 == 2) {
                if (this.tabGravity == 2) {
                    Log.w(LOG_TAG, "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
                }
                this.slidingTabIndicator.setGravity(1);
            }
        } else {
            e(this.tabGravity);
        }
        updateTabViews(true);
    }

    private int g(int i10, float f10) {
        View childAt;
        View view;
        int i11 = this.mode;
        int i12 = 0;
        if ((i11 != 0 && i11 != 2) || (childAt = this.slidingTabIndicator.getChildAt(i10)) == null) {
            return 0;
        }
        int i13 = i10 + 1;
        if (i13 < this.slidingTabIndicator.getChildCount()) {
            view = this.slidingTabIndicator.getChildAt(i13);
        } else {
            view = null;
        }
        int width = childAt.getWidth();
        if (view != null) {
            i12 = view.getWidth();
        }
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i14 = (int) ((width + i12) * 0.5f * f10);
        if (getLayoutDirection() == 0) {
            return left + i14;
        }
        return left - i14;
    }

    @Dimension(unit = 0)
    private int getDefaultHeight() {
        int size = this.tabs.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                break;
            }
            f fVar = this.tabs.get(i10);
            if (fVar != null && fVar.f() != null && !TextUtils.isEmpty(fVar.i())) {
                if (!this.inlineLabel) {
                    return 72;
                }
            } else {
                i10++;
            }
        }
        return 48;
    }

    private int getTabMinWidth() {
        int i10 = this.requestedTabMinWidth;
        if (i10 != -1) {
            return i10;
        }
        int i11 = this.mode;
        if (i11 != 0 && i11 != 2) {
            return 0;
        }
        return this.scrollableTabMinWidth;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.slidingTabIndicator.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void h(f fVar, int i10) {
        fVar.q(i10);
        this.tabs.add(i10, fVar);
        int size = this.tabs.size();
        int i11 = -1;
        for (int i12 = i10 + 1; i12 < size; i12++) {
            if (this.tabs.get(i12).g() == this.indicatorPosition) {
                i11 = i12;
            }
            this.tabs.get(i12).q(i12);
        }
        this.indicatorPosition = i11;
    }

    private static ColorStateList i(int i10, int i11) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i11, i10});
    }

    private LinearLayout.LayoutParams j() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        t(layoutParams);
        return layoutParams;
    }

    private TabView k(f fVar) {
        TabView tabView;
        Pools.Pool<TabView> pool = this.tabViewPool;
        if (pool != null) {
            tabView = pool.acquire();
        } else {
            tabView = null;
        }
        if (tabView == null) {
            tabView = new TabView(getContext());
        }
        tabView.setTab(fVar);
        tabView.setFocusable(true);
        tabView.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(fVar.f١٠٠٤٨d)) {
            tabView.setContentDescription(fVar.f١٠٠٤٧c);
        } else {
            tabView.setContentDescription(fVar.f١٠٠٤٨d);
        }
        return tabView;
    }

    private void l(f fVar) {
        for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
            this.selectedListeners.get(size).onTabReselected(fVar);
        }
    }

    private void m(f fVar) {
        for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
            this.selectedListeners.get(size).onTabSelected(fVar);
        }
    }

    private void n(f fVar) {
        for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
            this.selectedListeners.get(size).onTabUnselected(fVar);
        }
    }

    private void o() {
        if (this.scrollAnimator == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.scrollAnimator = valueAnimator;
            valueAnimator.setInterpolator(this.tabIndicatorTimeInterpolator);
            this.scrollAnimator.setDuration(this.tabIndicatorAnimationDuration);
            this.scrollAnimator.addUpdateListener(new a());
        }
    }

    private boolean p() {
        if (getTabMode() != 0 && getTabMode() != 2) {
            return false;
        }
        return true;
    }

    private void q(int i10) {
        TabView tabView = (TabView) this.slidingTabIndicator.getChildAt(i10);
        this.slidingTabIndicator.removeViewAt(i10);
        if (tabView != null) {
            tabView.k();
            this.tabViewPool.release(tabView);
        }
        requestLayout();
    }

    private void r(ViewPager viewPager, boolean z10, boolean z11) {
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 != null) {
            g gVar = this.pageChangeListener;
            if (gVar != null) {
                viewPager2.removeOnPageChangeListener(gVar);
            }
            b bVar = this.adapterChangeListener;
            if (bVar != null) {
                this.viewPager.removeOnAdapterChangeListener(bVar);
            }
        }
        c cVar = this.currentVpSelectedListener;
        if (cVar != null) {
            removeOnTabSelectedListener(cVar);
            this.currentVpSelectedListener = null;
        }
        if (viewPager != null) {
            this.viewPager = viewPager;
            if (this.pageChangeListener == null) {
                this.pageChangeListener = new g(this);
            }
            this.pageChangeListener.a();
            viewPager.addOnPageChangeListener(this.pageChangeListener);
            h hVar = new h(viewPager);
            this.currentVpSelectedListener = hVar;
            addOnTabSelectedListener((c) hVar);
            androidx.viewpager.widget.a adapter = viewPager.getAdapter();
            if (adapter != null) {
                setPagerAdapter(adapter, z10);
            }
            if (this.adapterChangeListener == null) {
                this.adapterChangeListener = new b();
            }
            this.adapterChangeListener.b(z10);
            viewPager.addOnAdapterChangeListener(this.adapterChangeListener);
            setScrollPosition(viewPager.getCurrentItem(), DownloadProgress.UNKNOWN_PROGRESS, true);
        } else {
            this.viewPager = null;
            setPagerAdapter(null, false);
        }
        this.setupViewPagerImplicitly = z11;
    }

    private void s() {
        int size = this.tabs.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.tabs.get(i10).s();
        }
    }

    private void setSelectedTabView(int i10) {
        boolean z10;
        boolean z11;
        int childCount = this.slidingTabIndicator.getChildCount();
        if (i10 < childCount) {
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = this.slidingTabIndicator.getChildAt(i11);
                boolean z12 = true;
                if ((i11 == i10 && !childAt.isSelected()) || (i11 != i10 && childAt.isSelected())) {
                    if (i11 == i10) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    childAt.setSelected(z11);
                    if (i11 != i10) {
                        z12 = false;
                    }
                    childAt.setActivated(z12);
                    if (childAt instanceof TabView) {
                        ((TabView) childAt).s();
                    }
                } else {
                    if (i11 == i10) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    childAt.setSelected(z10);
                    if (i11 != i10) {
                        z12 = false;
                    }
                    childAt.setActivated(z12);
                }
            }
        }
    }

    private void t(LinearLayout.LayoutParams layoutParams) {
        if (this.mode == 1 && this.tabGravity == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = DownloadProgress.UNKNOWN_PROGRESS;
        }
    }

    public void addOnTabSelectedListener(d dVar) {
        addOnTabSelectedListener((c) dVar);
    }

    public void addTab(f fVar) {
        addTab(fVar, this.tabs.isEmpty());
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        c(view);
    }

    public void clearOnTabSelectedListeners() {
        this.selectedListeners.clear();
    }

    protected f createTabFromPool() {
        f acquire = tabPool.acquire();
        if (acquire == null) {
            return new f();
        }
        return acquire;
    }

    public int getSelectedTabPosition() {
        f fVar = this.selectedTab;
        if (fVar != null) {
            return fVar.g();
        }
        return -1;
    }

    public f getTabAt(int i10) {
        if (i10 >= 0 && i10 < getTabCount()) {
            return this.tabs.get(i10);
        }
        return null;
    }

    public int getTabCount() {
        return this.tabs.size();
    }

    public int getTabGravity() {
        return this.tabGravity;
    }

    public ColorStateList getTabIconTint() {
        return this.tabIconTint;
    }

    public int getTabIndicatorAnimationMode() {
        return this.tabIndicatorAnimationMode;
    }

    public int getTabIndicatorGravity() {
        return this.tabIndicatorGravity;
    }

    int getTabMaxWidth() {
        return this.tabMaxWidth;
    }

    public int getTabMode() {
        return this.mode;
    }

    public ColorStateList getTabRippleColor() {
        return this.tabRippleColorStateList;
    }

    public Drawable getTabSelectedIndicator() {
        return this.tabSelectedIndicator;
    }

    public ColorStateList getTabTextColors() {
        return this.tabTextColors;
    }

    public boolean hasUnboundedRipple() {
        return this.unboundedRipple;
    }

    public boolean isInlineLabel() {
        return this.inlineLabel;
    }

    public boolean isTabIndicatorFullWidth() {
        return this.tabIndicatorFullWidth;
    }

    public f newTab() {
        f createTabFromPool = createTabFromPool();
        createTabFromPool.f١٠٠٥٢h = this;
        createTabFromPool.f١٠٠٥٣i = k(createTabFromPool);
        if (createTabFromPool.f١٠٠٥٤j != -1) {
            createTabFromPool.f١٠٠٥٣i.setId(createTabFromPool.f١٠٠٥٤j);
        }
        return createTabFromPool;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        j.e(this);
        if (this.viewPager == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                r((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.setupViewPagerImplicitly) {
            setupWithViewPager(null);
            this.setupViewPagerImplicitly = false;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        for (int i10 = 0; i10 < this.slidingTabIndicator.getChildCount(); i10++) {
            View childAt = this.slidingTabIndicator.getChildAt(i10);
            if (childAt instanceof TabView) {
                ((TabView) childAt).g(canvas);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        g0.V0(accessibilityNodeInfo).q0(g0.e.b(1, getTabCount(), false, 1));
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (p() && super.onInterceptTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        int round = Math.round(k0.g(getContext(), getDefaultHeight()));
        int mode = View.MeasureSpec.getMode(i11);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                i11 = View.MeasureSpec.makeMeasureSpec(round + getPaddingTop() + getPaddingBottom(), 1073741824);
            }
        } else if (getChildCount() == 1 && View.MeasureSpec.getSize(i11) >= round) {
            getChildAt(0).setMinimumHeight(round);
        }
        int size = View.MeasureSpec.getSize(i10);
        if (View.MeasureSpec.getMode(i10) != 0) {
            int i12 = this.requestedTabMaxWidth;
            if (i12 <= 0) {
                i12 = (int) (size - k0.g(getContext(), 56));
            }
            this.tabMaxWidth = i12;
        }
        super.onMeasure(i10, i11);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            int i13 = this.mode;
            if (i13 != 0) {
                if (i13 != 1) {
                    if (i13 != 2) {
                        return;
                    }
                } else {
                    if (childAt.getMeasuredWidth() == getMeasuredWidth()) {
                        return;
                    }
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), ViewGroup.getChildMeasureSpec(i11, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
                }
            }
            if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                return;
            }
            childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), ViewGroup.getChildMeasureSpec(i11, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 8 && !p()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    void populateFromPagerAdapter() {
        int currentItem;
        removeAllTabs();
        androidx.viewpager.widget.a aVar = this.pagerAdapter;
        if (aVar != null) {
            int count = aVar.getCount();
            for (int i10 = 0; i10 < count; i10++) {
                addTab(newTab().r(this.pagerAdapter.getPageTitle(i10)), false);
            }
            ViewPager viewPager = this.viewPager;
            if (viewPager != null && count > 0 && (currentItem = viewPager.getCurrentItem()) != getSelectedTabPosition() && currentItem < getTabCount()) {
                selectTab(getTabAt(currentItem));
            }
        }
    }

    protected boolean releaseFromTabPool(f fVar) {
        return tabPool.release(fVar);
    }

    public void removeAllTabs() {
        for (int childCount = this.slidingTabIndicator.getChildCount() - 1; childCount >= 0; childCount--) {
            q(childCount);
        }
        Iterator<f> it = this.tabs.iterator();
        while (it.hasNext()) {
            f next = it.next();
            it.remove();
            next.k();
            releaseFromTabPool(next);
        }
        this.selectedTab = null;
    }

    public void removeOnTabSelectedListener(d dVar) {
        removeOnTabSelectedListener((c) dVar);
    }

    public void removeTab(f fVar) {
        if (fVar.f١٠٠٥٢h == this) {
            removeTabAt(fVar.g());
            return;
        }
        throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
    }

    public void removeTabAt(int i10) {
        int i11;
        f fVar;
        f fVar2 = this.selectedTab;
        if (fVar2 != null) {
            i11 = fVar2.g();
        } else {
            i11 = 0;
        }
        q(i10);
        f remove = this.tabs.remove(i10);
        if (remove != null) {
            remove.k();
            releaseFromTabPool(remove);
        }
        int size = this.tabs.size();
        int i12 = -1;
        for (int i13 = i10; i13 < size; i13++) {
            if (this.tabs.get(i13).g() == this.indicatorPosition) {
                i12 = i13;
            }
            this.tabs.get(i13).q(i13);
        }
        this.indicatorPosition = i12;
        if (i11 == i10) {
            if (this.tabs.isEmpty()) {
                fVar = null;
            } else {
                fVar = this.tabs.get(Math.max(0, i10 - 1));
            }
            selectTab(fVar);
        }
    }

    public void selectTab(f fVar) {
        selectTab(fVar, true);
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        j.d(this, f10);
    }

    public void setInlineLabel(boolean z10) {
        if (this.inlineLabel != z10) {
            this.inlineLabel = z10;
            for (int i10 = 0; i10 < this.slidingTabIndicator.getChildCount(); i10++) {
                View childAt = this.slidingTabIndicator.getChildAt(i10);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).r();
                }
            }
            f();
        }
    }

    public void setInlineLabelResource(int i10) {
        setInlineLabel(getResources().getBoolean(i10));
    }

    @Deprecated
    public void setOnTabSelectedListener(d dVar) {
        setOnTabSelectedListener((c) dVar);
    }

    void setPagerAdapter(androidx.viewpager.widget.a aVar, boolean z10) {
        DataSetObserver dataSetObserver;
        androidx.viewpager.widget.a aVar2 = this.pagerAdapter;
        if (aVar2 != null && (dataSetObserver = this.pagerAdapterObserver) != null) {
            aVar2.unregisterDataSetObserver(dataSetObserver);
        }
        this.pagerAdapter = aVar;
        if (z10 && aVar != null) {
            if (this.pagerAdapterObserver == null) {
                this.pagerAdapterObserver = new e();
            }
            aVar.registerDataSetObserver(this.pagerAdapterObserver);
        }
        populateFromPagerAdapter();
    }

    void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        o();
        this.scrollAnimator.addListener(animatorListener);
    }

    public void setScrollPosition(int i10, float f10, boolean z10) {
        setScrollPosition(i10, f10, z10, true);
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (drawable == null) {
            drawable = new GradientDrawable();
        }
        Drawable mutate = h2.b.r(drawable).mutate();
        this.tabSelectedIndicator = mutate;
        com.google.android.material.drawable.g.n(mutate, this.tabSelectedIndicatorColor);
        int i10 = this.tabIndicatorHeight;
        if (i10 == -1) {
            i10 = this.tabSelectedIndicator.getIntrinsicHeight();
        }
        this.slidingTabIndicator.i(i10);
    }

    public void setSelectedTabIndicatorColor(int i10) {
        this.tabSelectedIndicatorColor = i10;
        com.google.android.material.drawable.g.n(this.tabSelectedIndicator, i10);
        updateTabViews(false);
    }

    public void setSelectedTabIndicatorGravity(int i10) {
        if (this.tabIndicatorGravity != i10) {
            this.tabIndicatorGravity = i10;
            this.slidingTabIndicator.postInvalidateOnAnimation();
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i10) {
        this.tabIndicatorHeight = i10;
        this.slidingTabIndicator.i(i10);
    }

    public void setTabGravity(int i10) {
        if (this.tabGravity != i10) {
            this.tabGravity = i10;
            f();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.tabIconTint != colorStateList) {
            this.tabIconTint = colorStateList;
            s();
        }
    }

    public void setTabIconTintResource(int i10) {
        setTabIconTint(r1.a.a(getContext(), i10));
    }

    public void setTabIndicatorAnimationMode(int i10) {
        this.tabIndicatorAnimationMode = i10;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 2) {
                    this.tabIndicatorInterpolator = new com.google.android.material.tabs.b();
                    return;
                }
                throw new IllegalArgumentException(i10 + " is not a valid TabIndicatorAnimationMode");
            }
            this.tabIndicatorInterpolator = new com.google.android.material.tabs.a();
            return;
        }
        this.tabIndicatorInterpolator = new com.google.android.material.tabs.c();
    }

    public void setTabIndicatorFullWidth(boolean z10) {
        this.tabIndicatorFullWidth = z10;
        this.slidingTabIndicator.g();
        this.slidingTabIndicator.postInvalidateOnAnimation();
    }

    public void setTabMode(int i10) {
        if (i10 != this.mode) {
            this.mode = i10;
            f();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.tabRippleColorStateList != colorStateList) {
            this.tabRippleColorStateList = colorStateList;
            for (int i10 = 0; i10 < this.slidingTabIndicator.getChildCount(); i10++) {
                View childAt = this.slidingTabIndicator.getChildAt(i10);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).q(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(int i10) {
        setTabRippleColor(r1.a.a(getContext(), i10));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.tabTextColors != colorStateList) {
            this.tabTextColors = colorStateList;
            s();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(androidx.viewpager.widget.a aVar) {
        setPagerAdapter(aVar, false);
    }

    public void setUnboundedRipple(boolean z10) {
        if (this.unboundedRipple != z10) {
            this.unboundedRipple = z10;
            for (int i10 = 0; i10 < this.slidingTabIndicator.getChildCount(); i10++) {
                View childAt = this.slidingTabIndicator.getChildAt(i10);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).q(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(int i10) {
        setUnboundedRipple(getResources().getBoolean(i10));
    }

    public void setupWithViewPager(ViewPager viewPager) {
        setupWithViewPager(viewPager, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        if (getTabScrollRange() > 0) {
            return true;
        }
        return false;
    }

    void updateTabViews(boolean z10) {
        for (int i10 = 0; i10 < this.slidingTabIndicator.getChildCount(); i10++) {
            View childAt = this.slidingTabIndicator.getChildAt(i10);
            childAt.setMinimumWidth(getTabMinWidth());
            t((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z10) {
                childAt.requestLayout();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateViewPagerScrollState(int i10) {
        this.viewPagerScrollState = i10;
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.tabStyle);
    }

    @Deprecated
    public void addOnTabSelectedListener(c cVar) {
        if (this.selectedListeners.contains(cVar)) {
            return;
        }
        this.selectedListeners.add(cVar);
    }

    public void addTab(f fVar, int i10) {
        addTab(fVar, i10, this.tabs.isEmpty());
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i10) {
        c(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void removeOnTabSelectedListener(c cVar) {
        this.selectedListeners.remove(cVar);
    }

    public void selectTab(f fVar, boolean z10) {
        f fVar2 = this.selectedTab;
        if (fVar2 == fVar) {
            if (fVar2 != null) {
                l(fVar);
                d(fVar.g());
                return;
            }
            return;
        }
        int g10 = fVar != null ? fVar.g() : -1;
        if (z10) {
            if ((fVar2 == null || fVar2.g() == -1) && g10 != -1) {
                setScrollPosition(g10, DownloadProgress.UNKNOWN_PROGRESS, true);
            } else {
                d(g10);
            }
            if (g10 != -1) {
                setSelectedTabView(g10);
            }
        }
        this.selectedTab = fVar;
        if (fVar2 != null && fVar2.f١٠٠٥٢h != null) {
            n(fVar2);
        }
        if (fVar != null) {
            m(fVar);
        }
    }

    @Deprecated
    public void setOnTabSelectedListener(c cVar) {
        c cVar2 = this.selectedListener;
        if (cVar2 != null) {
            removeOnTabSelectedListener(cVar2);
        }
        this.selectedListener = cVar;
        if (cVar != null) {
            addOnTabSelectedListener(cVar);
        }
    }

    public void setScrollPosition(int i10, float f10, boolean z10, boolean z11) {
        setScrollPosition(i10, f10, z10, z11, true);
    }

    public void setupWithViewPager(ViewPager viewPager, boolean z10) {
        r(viewPager, z10, false);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TabLayout(Context context, AttributeSet attributeSet, int i10) {
        super(g8.a.d(context, attributeSet, i10, r4), attributeSet, i10);
        int i11 = DEF_STYLE_RES;
        this.indicatorPosition = -1;
        this.tabs = new ArrayList<>();
        this.selectedTabTextAppearance = -1;
        this.tabSelectedIndicatorColor = 0;
        this.tabMaxWidth = Integer.MAX_VALUE;
        this.tabIndicatorHeight = -1;
        this.selectedListeners = new ArrayList<>();
        this.tabViewPool = new Pools.SimplePool(12);
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        SlidingTabIndicator slidingTabIndicator = new SlidingTabIndicator(context2);
        this.slidingTabIndicator = slidingTabIndicator;
        super.addView(slidingTabIndicator, 0, new FrameLayout.LayoutParams(-2, -1));
        int[] iArr = R.styleable.TabLayout;
        int i12 = R.styleable.TabLayout_tabTextAppearance;
        TypedArray i13 = h0.i(context2, attributeSet, iArr, i10, i11, i12);
        ColorStateList g10 = com.google.android.material.drawable.g.g(getBackground());
        if (g10 != null) {
            i iVar = new i();
            iVar.h0(g10);
            iVar.V(context2);
            iVar.g0(getElevation());
            setBackground(iVar);
        }
        setSelectedTabIndicator(c8.c.e(context2, i13, R.styleable.TabLayout_tabIndicator));
        setSelectedTabIndicatorColor(i13.getColor(R.styleable.TabLayout_tabIndicatorColor, 0));
        slidingTabIndicator.i(i13.getDimensionPixelSize(R.styleable.TabLayout_tabIndicatorHeight, -1));
        setSelectedTabIndicatorGravity(i13.getInt(R.styleable.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorAnimationMode(i13.getInt(R.styleable.TabLayout_tabIndicatorAnimationMode, 0));
        setTabIndicatorFullWidth(i13.getBoolean(R.styleable.TabLayout_tabIndicatorFullWidth, true));
        int dimensionPixelSize = i13.getDimensionPixelSize(R.styleable.TabLayout_tabPadding, 0);
        this.tabPaddingBottom = dimensionPixelSize;
        this.tabPaddingEnd = dimensionPixelSize;
        this.tabPaddingTop = dimensionPixelSize;
        this.tabPaddingStart = dimensionPixelSize;
        this.tabPaddingStart = i13.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingStart, dimensionPixelSize);
        this.tabPaddingTop = i13.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingTop, this.tabPaddingTop);
        this.tabPaddingEnd = i13.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingEnd, this.tabPaddingEnd);
        this.tabPaddingBottom = i13.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingBottom, this.tabPaddingBottom);
        if (h0.g(context2)) {
            this.defaultTabTextAppearance = R.attr.textAppearanceTitleSmall;
        } else {
            this.defaultTabTextAppearance = R.attr.textAppearanceButton;
        }
        int resourceId = i13.getResourceId(i12, R.style.TextAppearance_Design_Tab);
        this.tabTextAppearance = resourceId;
        int[] iArr2 = androidx.appcompat.R.styleable.TextAppearance;
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(resourceId, iArr2);
        try {
            int i14 = androidx.appcompat.R.styleable.TextAppearance_android_textSize;
            this.tabTextSize = obtainStyledAttributes.getDimensionPixelSize(i14, 0);
            int i15 = androidx.appcompat.R.styleable.TextAppearance_android_textColor;
            this.tabTextColors = c8.c.a(context2, obtainStyledAttributes, i15);
            obtainStyledAttributes.recycle();
            int i16 = R.styleable.TabLayout_tabSelectedTextAppearance;
            if (i13.hasValue(i16)) {
                this.selectedTabTextAppearance = i13.getResourceId(i16, resourceId);
            }
            int i17 = this.selectedTabTextAppearance;
            if (i17 != -1) {
                obtainStyledAttributes = context2.obtainStyledAttributes(i17, iArr2);
                try {
                    this.selectedTabTextSize = obtainStyledAttributes.getDimensionPixelSize(i14, (int) this.tabTextSize);
                    ColorStateList a10 = c8.c.a(context2, obtainStyledAttributes, i15);
                    if (a10 != null) {
                        this.tabTextColors = i(this.tabTextColors.getDefaultColor(), a10.getColorForState(new int[]{android.R.attr.state_selected}, a10.getDefaultColor()));
                    }
                } finally {
                }
            }
            int i18 = R.styleable.TabLayout_tabTextColor;
            if (i13.hasValue(i18)) {
                this.tabTextColors = c8.c.a(context2, i13, i18);
            }
            int i19 = R.styleable.TabLayout_tabSelectedTextColor;
            if (i13.hasValue(i19)) {
                this.tabTextColors = i(this.tabTextColors.getDefaultColor(), i13.getColor(i19, 0));
            }
            this.tabIconTint = c8.c.a(context2, i13, R.styleable.TabLayout_tabIconTint);
            this.tabIconTintMode = k0.o(i13.getInt(R.styleable.TabLayout_tabIconTintMode, -1), null);
            this.tabRippleColorStateList = c8.c.a(context2, i13, R.styleable.TabLayout_tabRippleColor);
            this.tabIndicatorAnimationDuration = i13.getInt(R.styleable.TabLayout_tabIndicatorAnimationDuration, ANIMATION_DURATION);
            this.tabIndicatorTimeInterpolator = k.g(context2, R.attr.motionEasingEmphasizedInterpolator, p7.a.f١٦٩٤٨b);
            this.requestedTabMinWidth = i13.getDimensionPixelSize(R.styleable.TabLayout_tabMinWidth, -1);
            this.requestedTabMaxWidth = i13.getDimensionPixelSize(R.styleable.TabLayout_tabMaxWidth, -1);
            this.tabBackgroundResId = i13.getResourceId(R.styleable.TabLayout_tabBackground, 0);
            this.contentInsetStart = i13.getDimensionPixelSize(R.styleable.TabLayout_tabContentStart, 0);
            this.mode = i13.getInt(R.styleable.TabLayout_tabMode, 1);
            this.tabGravity = i13.getInt(R.styleable.TabLayout_tabGravity, 0);
            this.inlineLabel = i13.getBoolean(R.styleable.TabLayout_tabInlineLabel, false);
            this.unboundedRipple = i13.getBoolean(R.styleable.TabLayout_tabUnboundedRipple, false);
            i13.recycle();
            Resources resources = getResources();
            this.tabTextMultiLineSize = resources.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
            this.scrollableTabMinWidth = resources.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
            f();
        } finally {
        }
    }

    public void addTab(f fVar, boolean z10) {
        addTab(fVar, this.tabs.size(), z10);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        c(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setScrollPosition(int i10, float f10, boolean z10, boolean z11, boolean z12) {
        int round = Math.round(i10 + f10);
        if (round < 0 || round >= this.slidingTabIndicator.getChildCount()) {
            return;
        }
        if (z11) {
            this.slidingTabIndicator.h(i10, f10);
        }
        ValueAnimator valueAnimator = this.scrollAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.scrollAnimator.cancel();
        }
        int g10 = g(i10, f10);
        int scrollX = getScrollX();
        boolean z13 = (i10 < getSelectedTabPosition() && g10 >= scrollX) || (i10 > getSelectedTabPosition() && g10 <= scrollX) || i10 == getSelectedTabPosition();
        if (getLayoutDirection() == 1) {
            z13 = (i10 < getSelectedTabPosition() && g10 <= scrollX) || (i10 > getSelectedTabPosition() && g10 >= scrollX) || i10 == getSelectedTabPosition();
        }
        if (z13 || this.viewPagerScrollState == 1 || z12) {
            if (i10 < 0) {
                g10 = 0;
            }
            scrollTo(g10, 0);
        }
        if (z10) {
            setSelectedTabView(round);
        }
    }

    public void addTab(f fVar, int i10, boolean z10) {
        if (fVar.f١٠٠٥٢h == this) {
            h(fVar, i10);
            b(fVar);
            if (z10) {
                fVar.l();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        c(view);
    }

    public void setTabTextColors(int i10, int i11) {
        setTabTextColors(i(i10, i11));
    }

    public void setSelectedTabIndicator(int i10) {
        if (i10 != 0) {
            setSelectedTabIndicator(r1.a.b(getContext(), i10));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }
}
