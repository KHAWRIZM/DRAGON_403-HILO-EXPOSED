package com.qiahao.base_common.wedgit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.g;
import androidx.viewpager2.widget.ViewPager2;
import com.oudi.utils.UiUtils;
import com.qiahao.base_common.R;
import com.qiahao.base_common.databinding.ViewTabLayoutTitleBinding;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import com.qiahao.base_common.model.TabConfig;
import com.qiahao.base_common.utils.HiloUtils;
import java.util.ArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class BackgroundTabLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private ViewPager2 f١٢٥٨٨a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f١٢٥٨٩b;

    /* renamed from: c, reason: collision with root package name */
    private Paint f١٢٥٩٠c;

    /* renamed from: d, reason: collision with root package name */
    private int f١٢٥٩١d;

    /* renamed from: e, reason: collision with root package name */
    private int f١٢٥٩٢e;

    /* renamed from: f, reason: collision with root package name */
    private int f١٢٥٩٣f;

    /* renamed from: g, reason: collision with root package name */
    private int f١٢٥٩٤g;

    /* renamed from: h, reason: collision with root package name */
    private int f١٢٥٩٥h;

    /* renamed from: i, reason: collision with root package name */
    private b f١٢٥٩٦i;

    /* renamed from: j, reason: collision with root package name */
    private ArrayList f١٢٥٩٧j;

    /* renamed from: k, reason: collision with root package name */
    private int f١٢٥٩٨k;

    /* renamed from: l, reason: collision with root package name */
    private int f١٢٥٩٩l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f١٢٦٠٠m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f١٢٦٠١n;

    /* renamed from: o, reason: collision with root package name */
    private int f١٢٦٠٢o;

    /* renamed from: p, reason: collision with root package name */
    private int f١٢٦٠٣p;

    /* renamed from: q, reason: collision with root package name */
    private int f١٢٦٠٤q;

    /* renamed from: r, reason: collision with root package name */
    private int f١٢٦٠٥r;

    /* renamed from: s, reason: collision with root package name */
    private int f١٢٦٠٦s;

    /* renamed from: t, reason: collision with root package name */
    private int f١٢٦٠٧t;

    /* renamed from: u, reason: collision with root package name */
    private Drawable f١٢٦٠٨u;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class a extends ViewPager2.OnPageChangeCallback {
        a() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i10) {
            super.onPageScrollStateChanged(i10);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i10, float f10, int i11) {
            int measuredWidth;
            super.onPageScrolled(i10, f10, i11);
            if (f10 > 1.0f) {
                BackgroundTabLayout.this.f١٢٥٩٥h = 0;
                return;
            }
            if (f10 == DownloadProgress.UNKNOWN_PROGRESS) {
                BackgroundTabLayout backgroundTabLayout = BackgroundTabLayout.this;
                if (i10 <= backgroundTabLayout.f١٢٥٩٤g - 1) {
                    backgroundTabLayout.f١٢٥٩٥h = 0;
                    backgroundTabLayout.scrollTo(0, 0);
                }
                BackgroundTabLayout backgroundTabLayout2 = BackgroundTabLayout.this;
                int i12 = backgroundTabLayout2.f١٢٥٩٤g;
                if (i12 == backgroundTabLayout2.f١٢٥٩١d && i12 - 1 == i10) {
                    backgroundTabLayout2.f١٢٥٩٥h = 0;
                    backgroundTabLayout2.scrollTo(0, 0);
                }
            }
            if (UiUtils.INSTANCE.isRtl()) {
                float f11 = 1.0f - f10;
                int measuredWidth2 = BackgroundTabLayout.this.getMeasuredWidth();
                int i13 = BackgroundTabLayout.this.f١٢٥٩٤g;
                measuredWidth = (int) ((f11 * (measuredWidth2 / i13)) + ((((i13 - 2) - i10) * r1.getMeasuredWidth()) / BackgroundTabLayout.this.f١٢٥٩٤g));
            } else {
                int measuredWidth3 = BackgroundTabLayout.this.getMeasuredWidth();
                BackgroundTabLayout backgroundTabLayout3 = BackgroundTabLayout.this;
                measuredWidth = (int) ((f10 * (measuredWidth3 / backgroundTabLayout3.f١٢٥٩٤g)) + ((backgroundTabLayout3.getMeasuredWidth() * i10) / BackgroundTabLayout.this.f١٢٥٩٤g));
            }
            BackgroundTabLayout backgroundTabLayout4 = BackgroundTabLayout.this;
            int i14 = backgroundTabLayout4.f١٢٥٩٣f;
            if (measuredWidth != i14) {
                if (i10 < backgroundTabLayout4.f١٢٥٩٤g - 1) {
                    backgroundTabLayout4.f١٢٥٩٥h = 0;
                } else {
                    int i15 = backgroundTabLayout4.f١٢٥٩٥h + (measuredWidth - i14);
                    backgroundTabLayout4.f١٢٥٩٥h = i15;
                    backgroundTabLayout4.scrollTo(i15, 0);
                }
                BackgroundTabLayout backgroundTabLayout5 = BackgroundTabLayout.this;
                backgroundTabLayout5.f١٢٥٩٣f = measuredWidth;
                backgroundTabLayout5.invalidate();
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i10) {
            int defaultColor;
            float defaultSize;
            Typeface defaultFromStyle;
            super.onPageSelected(i10);
            BackgroundTabLayout backgroundTabLayout = BackgroundTabLayout.this;
            backgroundTabLayout.f١٢٥٩٢e = i10;
            b bVar = backgroundTabLayout.f١٢٥٩٦i;
            if (bVar != null) {
                bVar.onPageSelected(i10);
            }
            int i11 = 0;
            while (true) {
                BackgroundTabLayout backgroundTabLayout2 = BackgroundTabLayout.this;
                if (i11 < backgroundTabLayout2.f١٢٥٩١d) {
                    View childAt = backgroundTabLayout2.getChildAt(i11);
                    TextView textView = (TextView) childAt.findViewById(R.id.content);
                    TextView textView2 = (TextView) childAt.findViewById(R.id.redPoint);
                    ConstraintLayout constraintLayout = (ConstraintLayout) childAt.findViewById(R.id.root);
                    if (textView != null && textView2 != null) {
                        childAt.setLeft(childAt.getLeft() + BackgroundTabLayout.this.f١٢٥٩٥h);
                        TabConfig tabConfig = (TabConfig) BackgroundTabLayout.this.f١٢٥٩٧j.get(i11);
                        Context context = BackgroundTabLayout.this.getContext();
                        if (BackgroundTabLayout.this.f١٢٥٩٢e == i11) {
                            defaultColor = tabConfig.getSelectColor();
                        } else {
                            defaultColor = tabConfig.getDefaultColor();
                        }
                        textView.setTextColor(androidx.core.content.a.getColor(context, defaultColor));
                        if (BackgroundTabLayout.this.f١٢٥٩٢e == i11) {
                            defaultSize = tabConfig.getSelectSize();
                        } else {
                            defaultSize = tabConfig.getDefaultSize();
                        }
                        textView.setTextSize(defaultSize);
                        if (BackgroundTabLayout.this.f١٢٥٩٢e == i11) {
                            defaultFromStyle = Typeface.defaultFromStyle(1);
                        } else {
                            defaultFromStyle = Typeface.defaultFromStyle(0);
                        }
                        textView.setTypeface(defaultFromStyle);
                        if (textView2.getVisibility() == 0) {
                            textView2.setVisibility(8);
                            BackgroundTabLayout backgroundTabLayout3 = BackgroundTabLayout.this;
                            int i12 = backgroundTabLayout3.f١٢٦٠٧t - 1;
                            backgroundTabLayout3.f١٢٦٠٧t = i12;
                            b bVar2 = backgroundTabLayout3.f١٢٥٩٦i;
                            if (bVar2 != null && i12 <= 0) {
                                bVar2.notRedPoint();
                            }
                        }
                        BackgroundTabLayout backgroundTabLayout4 = BackgroundTabLayout.this;
                        Drawable drawable = backgroundTabLayout4.f١٢٦٠٨u;
                        if (drawable != null) {
                            if (backgroundTabLayout4.f١٢٥٩٢e != i11) {
                                drawable = null;
                            }
                            constraintLayout.setBackground(drawable);
                        }
                    }
                    i11++;
                } else {
                    return;
                }
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface b {
        void notRedPoint();

        void onPageSelected(int i10);
    }

    public BackgroundTabLayout(Context context) {
        super(context);
        this.f١٢٥٩٣f = 0;
        this.f١٢٥٩٤g = 2;
        this.f١٢٥٩٥h = 0;
        this.f١٢٥٩٧j = new ArrayList();
        UiUtils uiUtils = UiUtils.INSTANCE;
        this.f١٢٥٩٨k = uiUtils.dip2px(3.0f);
        this.f١٢٥٩٩l = uiUtils.dip2px(3.0f);
        this.f١٢٦٠٠m = false;
        this.f١٢٦٠١n = false;
        this.f١٢٦٠٢o = 0;
        this.f١٢٦٠٣p = 0;
        this.f١٢٦٠٤q = 0;
        this.f١٢٦٠٥r = 0;
        this.f١٢٦٠٦s = 0;
        this.f١٢٦٠٧t = 0;
        this.f١٢٦٠٨u = null;
    }

    private void o() {
        int defaultColor;
        Typeface defaultFromStyle;
        float defaultSize;
        setWillNotDraw(false);
        if (getChildCount() != 0) {
            return;
        }
        this.f١٢٥٩٠c = new Paint();
        this.f١٢٥٨٩b = new Paint();
        for (final int i10 = 0; i10 < this.f١٢٥٩١d; i10++) {
            Drawable drawable = null;
            ViewTabLayoutTitleBinding viewTabLayoutTitleBinding = (ViewTabLayoutTitleBinding) g.h(LayoutInflater.from(getContext()), R.layout.view_tab_layout_title, null, false);
            TabConfig tabConfig = (TabConfig) this.f١٢٥٩٧j.get(i10);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getMeasuredWidth() / this.f١٢٥٩٤g, -1);
            viewTabLayoutTitleBinding.content.setText(tabConfig.getTextContent());
            TextView textView = viewTabLayoutTitleBinding.content;
            Context context = getContext();
            if (this.f١٢٥٩٢e == i10) {
                defaultColor = tabConfig.getSelectColor();
            } else {
                defaultColor = tabConfig.getDefaultColor();
            }
            textView.setTextColor(androidx.core.content.a.getColor(context, defaultColor));
            TextView textView2 = viewTabLayoutTitleBinding.content;
            if (this.f١٢٥٩٢e == i10) {
                defaultFromStyle = Typeface.defaultFromStyle(1);
            } else {
                defaultFromStyle = Typeface.defaultFromStyle(0);
            }
            textView2.setTypeface(defaultFromStyle);
            TextView textView3 = viewTabLayoutTitleBinding.content;
            if (this.f١٢٥٩٢e == i10) {
                defaultSize = tabConfig.getSelectSize();
            } else {
                defaultSize = tabConfig.getDefaultSize();
            }
            textView3.setTextSize(defaultSize);
            Drawable drawable2 = this.f١٢٦٠٨u;
            if (drawable2 != null) {
                ConstraintLayout constraintLayout = viewTabLayoutTitleBinding.root;
                if (this.f١٢٥٩٢e == i10) {
                    drawable = drawable2;
                }
                constraintLayout.setBackground(drawable);
            }
            viewTabLayoutTitleBinding.root.setLayoutParams(layoutParams);
            viewTabLayoutTitleBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.base_common.wedgit.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BackgroundTabLayout.this.p(i10, view);
                }
            });
            addView(viewTabLayoutTitleBinding.getRoot());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(int i10, View view) {
        if (HiloUtils.INSTANCE.notFastClick()) {
            this.f١٢٥٩٢e = i10;
            this.f١٢٥٨٨a.setCurrentItem(i10);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i10 = this.f١٢٥٩٩l;
        int measuredWidth = (this.f١٢٥٩٣f + (getMeasuredWidth() / this.f١٢٥٩٤g)) - this.f١٢٥٩٨k;
        int measuredHeight = getMeasuredHeight() - this.f١٢٥٩٩l;
        if (this.f١٢٦٠٠m) {
            this.f١٢٥٨٩b.setColor(this.f١٢٦٠٢o);
            RectF rectF = new RectF(this.f١٢٥٩٣f + this.f١٢٥٩٨k, i10, measuredWidth, measuredHeight);
            this.f١٢٥٨٩b.setAntiAlias(true);
            this.f١٢٥٨٩b.setStyle(Paint.Style.FILL);
            float f10 = (measuredHeight - i10) / 2;
            canvas.drawRoundRect(rectF, f10, f10, this.f١٢٥٨٩b);
        }
        if (this.f١٢٦٠١n) {
            int measuredWidth2 = measuredWidth - (((getMeasuredWidth() / this.f١٢٥٩٤g) - this.f١٢٦٠٥r) / 2);
            this.f١٢٥٩٠c.setShader(new LinearGradient(this.f١٢٥٩٣f + r0, getMeasuredHeight() - this.f١٢٦٠٦s, this.f١٢٥٩٨k + measuredWidth2, getMeasuredHeight() - this.f١٢٦٠٦s, this.f١٢٦٠٣p, this.f١٢٦٠٤q, Shader.TileMode.REPEAT));
            this.f١٢٥٩٠c.setStrokeWidth(this.f١٢٦٠٦s);
            canvas.drawLine(this.f١٢٥٩٣f + r0, getMeasuredHeight() - this.f١٢٦٠٦s, measuredWidth2 + this.f١٢٥٩٨k, getMeasuredHeight() - this.f١٢٦٠٦s, this.f١٢٥٩٠c);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        o();
    }

    public void q(int i10, boolean z10, int i11) {
        TextView textView;
        int i12;
        if (i10 >= 0 && i10 <= getChildCount() - 1 && (textView = (TextView) getChildAt(i10).findViewById(R.id.redPoint)) != null) {
            if (z10) {
                i12 = 0;
            } else {
                i12 = 8;
            }
            textView.setVisibility(i12);
            textView.setText(String.valueOf(i11));
        }
    }

    public void r(ViewPager2 viewPager2, ArrayList arrayList) {
        if (viewPager2.getAdapter().getItemCount() != arrayList.size()) {
            return;
        }
        this.f١٢٥٨٨a = viewPager2;
        this.f١٢٥٩١d = viewPager2.getAdapter().getItemCount();
        this.f١٢٥٩٢e = viewPager2.getCurrentItem();
        this.f١٢٥٩٧j = arrayList;
        viewPager2.registerOnPageChangeCallback(new a());
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        this.f١٢٦٠٢o = i10;
    }

    public void setDrawable(Drawable drawable) {
        this.f١٢٦٠٨u = drawable;
    }

    public void setMaxLineNum(int i10) {
        this.f١٢٥٩٤g = i10;
    }

    public void setShowBackground(boolean z10) {
        this.f١٢٦٠٠m = z10;
    }

    public void setShowButton(boolean z10) {
        this.f١٢٦٠١n = z10;
    }

    public void setonTabSelectListener(b bVar) {
        this.f١٢٥٩٦i = bVar;
    }

    public BackgroundTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f١٢٥٩٣f = 0;
        this.f١٢٥٩٤g = 2;
        this.f١٢٥٩٥h = 0;
        this.f١٢٥٩٧j = new ArrayList();
        UiUtils uiUtils = UiUtils.INSTANCE;
        this.f١٢٥٩٨k = uiUtils.dip2px(3.0f);
        this.f١٢٥٩٩l = uiUtils.dip2px(3.0f);
        this.f١٢٦٠٠m = false;
        this.f١٢٦٠١n = false;
        this.f١٢٦٠٢o = 0;
        this.f١٢٦٠٣p = 0;
        this.f١٢٦٠٤q = 0;
        this.f١٢٦٠٥r = 0;
        this.f١٢٦٠٦s = 0;
        this.f١٢٦٠٧t = 0;
        this.f١٢٦٠٨u = null;
    }

    public BackgroundTabLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٢٥٩٣f = 0;
        this.f١٢٥٩٤g = 2;
        this.f١٢٥٩٥h = 0;
        this.f١٢٥٩٧j = new ArrayList();
        UiUtils uiUtils = UiUtils.INSTANCE;
        this.f١٢٥٩٨k = uiUtils.dip2px(3.0f);
        this.f١٢٥٩٩l = uiUtils.dip2px(3.0f);
        this.f١٢٦٠٠m = false;
        this.f١٢٦٠١n = false;
        this.f١٢٦٠٢o = 0;
        this.f١٢٦٠٣p = 0;
        this.f١٢٦٠٤q = 0;
        this.f١٢٦٠٥r = 0;
        this.f١٢٦٠٦s = 0;
        this.f١٢٦٠٧t = 0;
        this.f١٢٦٠٨u = null;
    }
}
