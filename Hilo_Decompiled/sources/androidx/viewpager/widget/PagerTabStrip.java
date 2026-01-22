package androidx.viewpager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import kotlin.KotlinVersion;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class PagerTabStrip extends PagerTitleStrip {
    private boolean A;

    /* renamed from: B, reason: collision with root package name */
    private int f٤٤٩٠B;
    private boolean C;
    private float D;
    private float E;
    private int F;

    /* renamed from: q, reason: collision with root package name */
    private int f٤٤٩١q;

    /* renamed from: r, reason: collision with root package name */
    private int f٤٤٩٢r;

    /* renamed from: s, reason: collision with root package name */
    private int f٤٤٩٣s;

    /* renamed from: t, reason: collision with root package name */
    private int f٤٤٩٤t;

    /* renamed from: u, reason: collision with root package name */
    private int f٤٤٩٥u;

    /* renamed from: v, reason: collision with root package name */
    private int f٤٤٩٦v;

    /* renamed from: w, reason: collision with root package name */
    private final Paint f٤٤٩٧w;

    /* renamed from: x, reason: collision with root package name */
    private final Rect f٤٤٩٨x;

    /* renamed from: y, reason: collision with root package name */
    private int f٤٤٩٩y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f٤٥٠٠z;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PagerTabStrip.this.f٤٥٠٥a.setCurrentItem(r2.getCurrentItem() - 1);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewPager viewPager = PagerTabStrip.this.f٤٥٠٥a;
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        }
    }

    public PagerTabStrip(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void d(int i10, float f10, boolean z10) {
        Rect rect = this.f٤٤٩٨x;
        int height = getHeight();
        int left = this.f٤٥٠٧c.getLeft() - this.f٤٤٩٦v;
        int right = this.f٤٥٠٧c.getRight() + this.f٤٤٩٦v;
        int i11 = height - this.f٤٤٩٢r;
        rect.set(left, i11, right, height);
        super.d(i10, f10, z10);
        this.f٤٤٩٩y = (int) (Math.abs(f10 - 0.5f) * 2.0f * 255.0f);
        rect.union(this.f٤٥٠٧c.getLeft() - this.f٤٤٩٦v, i11, this.f٤٥٠٧c.getRight() + this.f٤٤٩٦v, height);
        invalidate(rect);
    }

    public boolean getDrawFullUnderline() {
        return this.f٤٥٠٠z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.viewpager.widget.PagerTitleStrip
    public int getMinHeight() {
        return Math.max(super.getMinHeight(), this.f٤٤٩٥u);
    }

    public int getTabIndicatorColor() {
        return this.f٤٤٩١q;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.f٤٥٠٧c.getLeft() - this.f٤٤٩٦v;
        int right = this.f٤٥٠٧c.getRight() + this.f٤٤٩٦v;
        int i10 = height - this.f٤٤٩٢r;
        this.f٤٤٩٧w.setColor((this.f٤٤٩٩y << 24) | (this.f٤٤٩١q & 16777215));
        float f10 = height;
        canvas.drawRect(left, i10, right, f10, this.f٤٤٩٧w);
        if (this.f٤٥٠٠z) {
            this.f٤٤٩٧w.setColor((this.f٤٤٩١q & 16777215) | (-16777216));
            canvas.drawRect(getPaddingLeft(), height - this.f٤٤٩٠B, getWidth() - getPaddingRight(), f10, this.f٤٤٩٧w);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.C) {
            return false;
        }
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        if (action != 0) {
            if (action != 1) {
                if (action == 2 && (Math.abs(x10 - this.D) > this.F || Math.abs(y10 - this.E) > this.F)) {
                    this.C = true;
                }
            } else if (x10 < this.f٤٥٠٧c.getLeft() - this.f٤٤٩٦v) {
                ViewPager viewPager = this.f٤٥٠٥a;
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
            } else if (x10 > this.f٤٥٠٧c.getRight() + this.f٤٤٩٦v) {
                ViewPager viewPager2 = this.f٤٥٠٥a;
                viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
            }
        } else {
            this.D = x10;
            this.E = y10;
            this.C = false;
        }
        return true;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        boolean z10;
        super.setBackgroundColor(i10);
        if (!this.A) {
            if ((i10 & (-16777216)) == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f٤٥٠٠z = z10;
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        boolean z10;
        super.setBackgroundDrawable(drawable);
        if (!this.A) {
            if (drawable == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f٤٥٠٠z = z10;
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        boolean z10;
        super.setBackgroundResource(i10);
        if (!this.A) {
            if (i10 == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f٤٥٠٠z = z10;
        }
    }

    public void setDrawFullUnderline(boolean z10) {
        this.f٤٥٠٠z = z10;
        this.A = true;
        invalidate();
    }

    @Override // android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
        int i14 = this.f٤٤٩٣s;
        if (i13 < i14) {
            i13 = i14;
        }
        super.setPadding(i10, i11, i12, i13);
    }

    public void setTabIndicatorColor(int i10) {
        this.f٤٤٩١q = i10;
        this.f٤٤٩٧w.setColor(i10);
        invalidate();
    }

    public void setTabIndicatorColorResource(int i10) {
        setTabIndicatorColor(androidx.core.content.a.getColor(getContext(), i10));
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void setTextSpacing(int i10) {
        int i11 = this.f٤٤٩٤t;
        if (i10 < i11) {
            i10 = i11;
        }
        super.setTextSpacing(i10);
    }

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.f٤٤٩٧w = paint;
        this.f٤٤٩٨x = new Rect();
        this.f٤٤٩٩y = KotlinVersion.MAX_COMPONENT_VALUE;
        this.f٤٥٠٠z = false;
        this.A = false;
        int i10 = this.f٤٥١٨n;
        this.f٤٤٩١q = i10;
        paint.setColor(i10);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.f٤٤٩٢r = (int) ((3.0f * f10) + 0.5f);
        this.f٤٤٩٣s = (int) ((6.0f * f10) + 0.5f);
        this.f٤٤٩٤t = (int) (64.0f * f10);
        this.f٤٤٩٦v = (int) ((16.0f * f10) + 0.5f);
        this.f٤٤٩٠B = (int) ((1.0f * f10) + 0.5f);
        this.f٤٤٩٥u = (int) ((f10 * 32.0f) + 0.5f);
        this.F = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.f٤٥٠٦b.setFocusable(true);
        this.f٤٥٠٦b.setOnClickListener(new a());
        this.f٤٥٠٨d.setFocusable(true);
        this.f٤٥٠٨d.setOnClickListener(new b());
        if (getBackground() == null) {
            this.f٤٥٠٠z = true;
        }
    }
}
