package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.annotation.FloatRange;
import androidx.core.widget.l;
import androidx.viewpager.widget.ViewPager;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.lang.ref.WeakReference;
import java.util.Locale;
import kotlin.KotlinVersion;

@ViewPager.e
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class PagerTitleStrip extends ViewGroup {

    /* renamed from: o, reason: collision with root package name */
    private static final int[] f٤٥٠٣o = {R.attr.textAppearance, R.attr.textSize, R.attr.textColor, R.attr.gravity};

    /* renamed from: p, reason: collision with root package name */
    private static final int[] f٤٥٠٤p = {R.attr.textAllCaps};

    /* renamed from: a, reason: collision with root package name */
    ViewPager f٤٥٠٥a;

    /* renamed from: b, reason: collision with root package name */
    TextView f٤٥٠٦b;

    /* renamed from: c, reason: collision with root package name */
    TextView f٤٥٠٧c;

    /* renamed from: d, reason: collision with root package name */
    TextView f٤٥٠٨d;

    /* renamed from: e, reason: collision with root package name */
    private int f٤٥٠٩e;

    /* renamed from: f, reason: collision with root package name */
    float f٤٥١٠f;

    /* renamed from: g, reason: collision with root package name */
    private int f٤٥١١g;

    /* renamed from: h, reason: collision with root package name */
    private int f٤٥١٢h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f٤٥١٣i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f٤٥١٤j;

    /* renamed from: k, reason: collision with root package name */
    private final a f٤٥١٥k;

    /* renamed from: l, reason: collision with root package name */
    private WeakReference f٤٥١٦l;

    /* renamed from: m, reason: collision with root package name */
    private int f٤٥١٧m;

    /* renamed from: n, reason: collision with root package name */
    int f٤٥١٨n;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class a extends DataSetObserver implements ViewPager.j, ViewPager.i {

        /* renamed from: a, reason: collision with root package name */
        private int f٤٥١٩a;

        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2) {
            PagerTitleStrip.this.b(aVar, aVar2);
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
            pagerTitleStrip.c(pagerTitleStrip.f٤٥٠٥a.getCurrentItem(), PagerTitleStrip.this.f٤٥٠٥a.getAdapter());
            PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
            float f10 = pagerTitleStrip2.f٤٥١٠f;
            if (f10 < DownloadProgress.UNKNOWN_PROGRESS) {
                f10 = DownloadProgress.UNKNOWN_PROGRESS;
            }
            pagerTitleStrip2.d(pagerTitleStrip2.f٤٥٠٥a.getCurrentItem(), f10, true);
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrollStateChanged(int i10) {
            this.f٤٥١٩a = i10;
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrolled(int i10, float f10, int i11) {
            if (f10 > 0.5f) {
                i10++;
            }
            PagerTitleStrip.this.d(i10, f10, false);
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageSelected(int i10) {
            if (this.f٤٥١٩a == 0) {
                PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
                pagerTitleStrip.c(pagerTitleStrip.f٤٥٠٥a.getCurrentItem(), PagerTitleStrip.this.f٤٥٠٥a.getAdapter());
                PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
                float f10 = pagerTitleStrip2.f٤٥١٠f;
                if (f10 < DownloadProgress.UNKNOWN_PROGRESS) {
                    f10 = DownloadProgress.UNKNOWN_PROGRESS;
                }
                pagerTitleStrip2.d(pagerTitleStrip2.f٤٥٠٥a.getCurrentItem(), f10, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class b extends SingleLineTransformationMethod {

        /* renamed from: a, reason: collision with root package name */
        private Locale f٤٥٢١a;

        b(Context context) {
            this.f٤٥٢١a = context.getResources().getConfiguration().locale;
        }

        @Override // android.text.method.ReplacementTransformationMethod, android.text.method.TransformationMethod
        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.f٤٥٢١a);
            }
            return null;
        }
    }

    public PagerTitleStrip(Context context) {
        this(context, null);
    }

    private static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new b(textView.getContext()));
    }

    public void a(int i10, float f10) {
        this.f٤٥٠٦b.setTextSize(i10, f10);
        this.f٤٥٠٧c.setTextSize(i10, f10);
        this.f٤٥٠٨d.setTextSize(i10, f10);
    }

    void b(androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2) {
        if (aVar != null) {
            aVar.unregisterDataSetObserver(this.f٤٥١٥k);
            this.f٤٥١٦l = null;
        }
        if (aVar2 != null) {
            aVar2.registerDataSetObserver(this.f٤٥١٥k);
            this.f٤٥١٦l = new WeakReference(aVar2);
        }
        ViewPager viewPager = this.f٤٥٠٥a;
        if (viewPager != null) {
            this.f٤٥٠٩e = -1;
            this.f٤٥١٠f = -1.0f;
            c(viewPager.getCurrentItem(), aVar2);
            requestLayout();
        }
    }

    void c(int i10, androidx.viewpager.widget.a aVar) {
        int i11;
        CharSequence charSequence;
        CharSequence charSequence2;
        if (aVar != null) {
            i11 = aVar.getCount();
        } else {
            i11 = 0;
        }
        this.f٤٥١٣i = true;
        CharSequence charSequence3 = null;
        if (i10 >= 1 && aVar != null) {
            charSequence = aVar.getPageTitle(i10 - 1);
        } else {
            charSequence = null;
        }
        this.f٤٥٠٦b.setText(charSequence);
        TextView textView = this.f٤٥٠٧c;
        if (aVar != null && i10 < i11) {
            charSequence2 = aVar.getPageTitle(i10);
        } else {
            charSequence2 = null;
        }
        textView.setText(charSequence2);
        int i12 = i10 + 1;
        if (i12 < i11 && aVar != null) {
            charSequence3 = aVar.getPageTitle(i12);
        }
        this.f٤٥٠٨d.setText(charSequence3);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.8f)), Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.f٤٥٠٦b.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f٤٥٠٧c.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f٤٥٠٨d.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f٤٥٠٩e = i10;
        if (!this.f٤٥١٤j) {
            d(i10, this.f٤٥١٠f, false);
        }
        this.f٤٥١٣i = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i10, float f10, boolean z10) {
        int i11;
        int i12;
        int i13;
        int i14;
        if (i10 != this.f٤٥٠٩e) {
            c(i10, this.f٤٥٠٥a.getAdapter());
        } else if (!z10 && f10 == this.f٤٥١٠f) {
            return;
        }
        this.f٤٥١٤j = true;
        int measuredWidth = this.f٤٥٠٦b.getMeasuredWidth();
        int measuredWidth2 = this.f٤٥٠٧c.getMeasuredWidth();
        int measuredWidth3 = this.f٤٥٠٨d.getMeasuredWidth();
        int i15 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i16 = paddingRight + i15;
        int i17 = (width - (paddingLeft + i15)) - i16;
        float f11 = 0.5f + f10;
        if (f11 > 1.0f) {
            f11 -= 1.0f;
        }
        int i18 = ((width - i16) - ((int) (i17 * f11))) - i15;
        int i19 = measuredWidth2 + i18;
        int baseline = this.f٤٥٠٦b.getBaseline();
        int baseline2 = this.f٤٥٠٧c.getBaseline();
        int baseline3 = this.f٤٥٠٨d.getBaseline();
        int max = Math.max(Math.max(baseline, baseline2), baseline3);
        int i20 = max - baseline;
        int i21 = max - baseline2;
        int i22 = max - baseline3;
        int max2 = Math.max(Math.max(this.f٤٥٠٦b.getMeasuredHeight() + i20, this.f٤٥٠٧c.getMeasuredHeight() + i21), this.f٤٥٠٨d.getMeasuredHeight() + i22);
        int i23 = this.f٤٥١٢h & 112;
        if (i23 != 16) {
            if (i23 != 80) {
                i12 = i20 + paddingTop;
                i13 = i21 + paddingTop;
                i14 = paddingTop + i22;
                TextView textView = this.f٤٥٠٧c;
                textView.layout(i18, i13, i19, textView.getMeasuredHeight() + i13);
                int min = Math.min(paddingLeft, (i18 - this.f٤٥١١g) - measuredWidth);
                TextView textView2 = this.f٤٥٠٦b;
                textView2.layout(min, i12, measuredWidth + min, textView2.getMeasuredHeight() + i12);
                int max3 = Math.max((width - paddingRight) - measuredWidth3, i19 + this.f٤٥١١g);
                TextView textView3 = this.f٤٥٠٨d;
                textView3.layout(max3, i14, max3 + measuredWidth3, textView3.getMeasuredHeight() + i14);
                this.f٤٥١٠f = f10;
                this.f٤٥١٤j = false;
            }
            i11 = (height - paddingBottom) - max2;
        } else {
            i11 = (((height - paddingTop) - paddingBottom) - max2) / 2;
        }
        i12 = i20 + i11;
        i13 = i21 + i11;
        i14 = i11 + i22;
        TextView textView4 = this.f٤٥٠٧c;
        textView4.layout(i18, i13, i19, textView4.getMeasuredHeight() + i13);
        int min2 = Math.min(paddingLeft, (i18 - this.f٤٥١١g) - measuredWidth);
        TextView textView22 = this.f٤٥٠٦b;
        textView22.layout(min2, i12, measuredWidth + min2, textView22.getMeasuredHeight() + i12);
        int max32 = Math.max((width - paddingRight) - measuredWidth3, i19 + this.f٤٥١١g);
        TextView textView32 = this.f٤٥٠٨d;
        textView32.layout(max32, i14, max32 + measuredWidth3, textView32.getMeasuredHeight() + i14);
        this.f٤٥١٠f = f10;
        this.f٤٥١٤j = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    public int getTextSpacing() {
        return this.f٤٥١١g;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        androidx.viewpager.widget.a aVar;
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) parent;
            androidx.viewpager.widget.a adapter = viewPager.getAdapter();
            viewPager.setInternalPageChangeListener(this.f٤٥١٥k);
            viewPager.addOnAdapterChangeListener(this.f٤٥١٥k);
            this.f٤٥٠٥a = viewPager;
            WeakReference weakReference = this.f٤٥١٦l;
            if (weakReference != null) {
                aVar = (androidx.viewpager.widget.a) weakReference.get();
            } else {
                aVar = null;
            }
            b(aVar, adapter);
            return;
        }
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.f٤٥٠٥a;
        if (viewPager != null) {
            b(viewPager.getAdapter(), null);
            this.f٤٥٠٥a.setInternalPageChangeListener(null);
            this.f٤٥٠٥a.removeOnAdapterChangeListener(this.f٤٥١٥k);
            this.f٤٥٠٥a = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (this.f٤٥٠٥a != null) {
            float f10 = this.f٤٥١٠f;
            if (f10 < DownloadProgress.UNKNOWN_PROGRESS) {
                f10 = DownloadProgress.UNKNOWN_PROGRESS;
            }
            d(this.f٤٥٠٩e, f10, true);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        int max;
        if (View.MeasureSpec.getMode(i10) == 1073741824) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i11, paddingTop, -2);
            int size = View.MeasureSpec.getSize(i10);
            int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i10, (int) (size * 0.2f), -2);
            this.f٤٥٠٦b.measure(childMeasureSpec2, childMeasureSpec);
            this.f٤٥٠٧c.measure(childMeasureSpec2, childMeasureSpec);
            this.f٤٥٠٨d.measure(childMeasureSpec2, childMeasureSpec);
            if (View.MeasureSpec.getMode(i11) == 1073741824) {
                max = View.MeasureSpec.getSize(i11);
            } else {
                max = Math.max(getMinHeight(), this.f٤٥٠٧c.getMeasuredHeight() + paddingTop);
            }
            setMeasuredDimension(size, View.resolveSizeAndState(max, i11, this.f٤٥٠٧c.getMeasuredState() << 16));
            return;
        }
        throw new IllegalStateException("Must measure with an exact width");
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.f٤٥١٣i) {
            super.requestLayout();
        }
    }

    public void setGravity(int i10) {
        this.f٤٥١٢h = i10;
        requestLayout();
    }

    public void setNonPrimaryAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        int i10 = ((int) (f10 * 255.0f)) & KotlinVersion.MAX_COMPONENT_VALUE;
        this.f٤٥١٧m = i10;
        int i11 = (i10 << 24) | (this.f٤٥١٨n & 16777215);
        this.f٤٥٠٦b.setTextColor(i11);
        this.f٤٥٠٨d.setTextColor(i11);
    }

    public void setTextColor(int i10) {
        this.f٤٥١٨n = i10;
        this.f٤٥٠٧c.setTextColor(i10);
        int i11 = (this.f٤٥١٧m << 24) | (this.f٤٥١٨n & 16777215);
        this.f٤٥٠٦b.setTextColor(i11);
        this.f٤٥٠٨d.setTextColor(i11);
    }

    public void setTextSpacing(int i10) {
        this.f٤٥١١g = i10;
        requestLayout();
    }

    public PagerTitleStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f٤٥٠٩e = -1;
        this.f٤٥١٠f = -1.0f;
        this.f٤٥١٥k = new a();
        TextView textView = new TextView(context);
        this.f٤٥٠٦b = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.f٤٥٠٧c = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.f٤٥٠٨d = textView3;
        addView(textView3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f٤٥٠٣o);
        boolean z10 = false;
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            l.m(this.f٤٥٠٦b, resourceId);
            l.m(this.f٤٥٠٧c, resourceId);
            l.m(this.f٤٥٠٨d, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            a(0, dimensionPixelSize);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            int color = obtainStyledAttributes.getColor(2, 0);
            this.f٤٥٠٦b.setTextColor(color);
            this.f٤٥٠٧c.setTextColor(color);
            this.f٤٥٠٨d.setTextColor(color);
        }
        this.f٤٥١٢h = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.f٤٥١٨n = this.f٤٥٠٧c.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        TextView textView4 = this.f٤٥٠٦b;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView4.setEllipsize(truncateAt);
        this.f٤٥٠٧c.setEllipsize(truncateAt);
        this.f٤٥٠٨d.setEllipsize(truncateAt);
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, f٤٥٠٤p);
            z10 = obtainStyledAttributes2.getBoolean(0, false);
            obtainStyledAttributes2.recycle();
        }
        if (z10) {
            setSingleLineAllCaps(this.f٤٥٠٦b);
            setSingleLineAllCaps(this.f٤٥٠٧c);
            setSingleLineAllCaps(this.f٤٥٠٨d);
        } else {
            this.f٤٥٠٦b.setSingleLine();
            this.f٤٥٠٧c.setSingleLine();
            this.f٤٥٠٨d.setSingleLine();
        }
        this.f٤٥١١g = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }
}
