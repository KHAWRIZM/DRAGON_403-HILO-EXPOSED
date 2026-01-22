package com.scwang.smart.refresh.footer;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.scwang.smart.refresh.classics.ClassicsAbstract;
import com.scwang.smart.refresh.footer.classics.R;
import tc.c;
import tc.f;
import uc.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ClassicsFooter extends ClassicsAbstract<ClassicsFooter> implements c {
    public static String A;
    public static String B;
    public static String C;
    public static String D;
    public static String E;
    public static String y;
    public static String z;
    protected String q;
    protected String r;
    protected String s;
    protected String t;
    protected String u;
    protected String v;
    protected String w;
    protected boolean x;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.PullUpToLoad.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.Loading.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.LoadReleased.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[b.ReleaseToLoad.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[b.Refreshing.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public ClassicsFooter(Context context) {
        this(context, null);
    }

    @Override // com.scwang.smart.refresh.classics.ClassicsAbstract, com.scwang.smart.refresh.layout.simple.SimpleComponent, tc.a
    public int onFinish(f fVar, boolean z2) {
        String str;
        super.onFinish(fVar, z2);
        if (!this.x) {
            TextView textView = this.a;
            if (z2) {
                str = this.u;
            } else {
                str = this.v;
            }
            textView.setText(str);
            return this.j;
        }
        return 0;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0010. Please report as an issue. */
    @Override // com.scwang.smart.refresh.layout.simple.SimpleComponent, vc.i
    public void onStateChanged(f fVar, b bVar, b bVar2) {
        ImageView imageView = this.b;
        if (!this.x) {
            switch (a.a[bVar2.ordinal()]) {
                case 1:
                    imageView.setVisibility(0);
                case 2:
                    this.a.setText(this.q);
                    imageView.animate().rotation(180.0f);
                    return;
                case 3:
                case 4:
                    imageView.setVisibility(8);
                    this.a.setText(this.s);
                    return;
                case 5:
                    this.a.setText(this.r);
                    imageView.animate().rotation(0.0f);
                    return;
                case 6:
                    this.a.setText(this.t);
                    imageView.setVisibility(8);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.scwang.smart.refresh.layout.simple.SimpleComponent, tc.c
    public boolean setNoMoreData(boolean z2) {
        if (this.x != z2) {
            this.x = z2;
            ImageView imageView = this.b;
            if (z2) {
                this.a.setText(this.w);
                imageView.setVisibility(8);
                return true;
            }
            this.a.setText(this.q);
            imageView.setVisibility(0);
            return true;
        }
        return true;
    }

    @Override // com.scwang.smart.refresh.classics.ClassicsAbstract, com.scwang.smart.refresh.layout.simple.SimpleComponent, tc.a
    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (this.mSpinnerStyle == uc.c.f) {
            super.setPrimaryColors(iArr);
        }
    }

    public ClassicsFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.x = false;
        View.inflate(context, R.layout.srl_classics_footer, this);
        ImageView imageView = (ImageView) findViewById(R.id.srl_classics_arrow);
        this.b = imageView;
        ImageView imageView2 = (ImageView) findViewById(R.id.srl_classics_progress);
        this.c = imageView2;
        this.a = (TextView) findViewById(R.id.srl_classics_title);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClassicsFooter);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClassicsFooter_srlDrawableMarginRight, wc.c.c(20.0f));
        layoutParams2.rightMargin = dimensionPixelSize;
        layoutParams.rightMargin = dimensionPixelSize;
        int i = R.styleable.ClassicsFooter_srlDrawableArrowSize;
        layoutParams.width = obtainStyledAttributes.getLayoutDimension(i, layoutParams.width);
        layoutParams.height = obtainStyledAttributes.getLayoutDimension(i, layoutParams.height);
        int i2 = R.styleable.ClassicsFooter_srlDrawableProgressSize;
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(i2, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(i2, layoutParams2.height);
        int i3 = R.styleable.ClassicsFooter_srlDrawableSize;
        layoutParams.width = obtainStyledAttributes.getLayoutDimension(i3, layoutParams.width);
        layoutParams.height = obtainStyledAttributes.getLayoutDimension(i3, layoutParams.height);
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(i3, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(i3, layoutParams2.height);
        this.j = obtainStyledAttributes.getInt(R.styleable.ClassicsFooter_srlFinishDuration, this.j);
        this.mSpinnerStyle = uc.c.i[obtainStyledAttributes.getInt(R.styleable.ClassicsFooter_srlClassicsSpinnerStyle, this.mSpinnerStyle.a)];
        int i4 = R.styleable.ClassicsFooter_srlDrawableArrow;
        if (obtainStyledAttributes.hasValue(i4)) {
            this.b.setImageDrawable(obtainStyledAttributes.getDrawable(i4));
        } else if (this.b.getDrawable() == null) {
            rc.a aVar = new rc.a();
            this.e = aVar;
            aVar.a(-10066330);
            this.b.setImageDrawable(this.e);
        }
        int i5 = R.styleable.ClassicsFooter_srlDrawableProgress;
        if (obtainStyledAttributes.hasValue(i5)) {
            this.c.setImageDrawable(obtainStyledAttributes.getDrawable(i5));
        } else if (this.c.getDrawable() == null) {
            qc.b bVar = new qc.b();
            this.f = bVar;
            bVar.a(-10066330);
            this.c.setImageDrawable(this.f);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlTextSizeTitle)) {
            this.a.setTextSize(0, obtainStyledAttributes.getDimensionPixelSize(r3, wc.c.c(16.0f)));
        }
        int i6 = R.styleable.ClassicsFooter_srlPrimaryColor;
        if (obtainStyledAttributes.hasValue(i6)) {
            super.c(obtainStyledAttributes.getColor(i6, 0));
        }
        int i7 = R.styleable.ClassicsFooter_srlAccentColor;
        if (obtainStyledAttributes.hasValue(i7)) {
            super.b(obtainStyledAttributes.getColor(i7, 0));
        }
        int i8 = R.styleable.ClassicsFooter_srlTextPulling;
        if (obtainStyledAttributes.hasValue(i8)) {
            this.q = obtainStyledAttributes.getString(i8);
        } else {
            String str = y;
            if (str != null) {
                this.q = str;
            } else {
                this.q = context.getString(R.string.srl_footer_pulling);
            }
        }
        int i9 = R.styleable.ClassicsFooter_srlTextRelease;
        if (obtainStyledAttributes.hasValue(i9)) {
            this.r = obtainStyledAttributes.getString(i9);
        } else {
            String str2 = z;
            if (str2 != null) {
                this.r = str2;
            } else {
                this.r = context.getString(R.string.srl_footer_release);
            }
        }
        int i10 = R.styleable.ClassicsFooter_srlTextLoading;
        if (obtainStyledAttributes.hasValue(i10)) {
            this.s = obtainStyledAttributes.getString(i10);
        } else {
            String str3 = A;
            if (str3 != null) {
                this.s = str3;
            } else {
                this.s = context.getString(R.string.srl_footer_loading);
            }
        }
        int i11 = R.styleable.ClassicsFooter_srlTextRefreshing;
        if (obtainStyledAttributes.hasValue(i11)) {
            this.t = obtainStyledAttributes.getString(i11);
        } else {
            String str4 = B;
            if (str4 != null) {
                this.t = str4;
            } else {
                this.t = context.getString(R.string.srl_footer_refreshing);
            }
        }
        int i12 = R.styleable.ClassicsFooter_srlTextFinish;
        if (obtainStyledAttributes.hasValue(i12)) {
            this.u = obtainStyledAttributes.getString(i12);
        } else {
            String str5 = C;
            if (str5 != null) {
                this.u = str5;
            } else {
                this.u = context.getString(R.string.srl_footer_finish);
            }
        }
        int i13 = R.styleable.ClassicsFooter_srlTextFailed;
        if (obtainStyledAttributes.hasValue(i13)) {
            this.v = obtainStyledAttributes.getString(i13);
        } else {
            String str6 = D;
            if (str6 != null) {
                this.v = str6;
            } else {
                this.v = context.getString(R.string.srl_footer_failed);
            }
        }
        int i14 = R.styleable.ClassicsFooter_srlTextNothing;
        if (obtainStyledAttributes.hasValue(i14)) {
            this.w = obtainStyledAttributes.getString(i14);
        } else {
            String str7 = E;
            if (str7 != null) {
                this.w = str7;
            } else {
                this.w = context.getString(R.string.srl_footer_nothing);
            }
        }
        obtainStyledAttributes.recycle();
        imageView2.animate().setInterpolator(null);
        this.a.setText(isInEditMode() ? this.s : this.q);
        if (isInEditMode()) {
            imageView.setVisibility(8);
        } else {
            imageView2.setVisibility(8);
        }
    }
}
