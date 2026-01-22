package mc;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.ruffian.library.widget.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class c extends a {
    protected int A1;
    protected int B1;
    protected ColorStateList C1;
    protected int[][] D1;
    private String E1;
    private boolean F1;
    protected boolean G1;
    protected boolean H1;
    private Drawable I0;
    protected boolean I1;
    private Drawable J0;
    protected boolean J1;
    private Drawable K0;
    protected int K1;
    private Drawable L0;
    protected int L1;
    private Drawable M0;
    protected int M1;
    private Drawable N0;
    protected int N1;
    private int O0;
    private String O1;
    private int P0;
    private String P1;
    private int Q0;
    private int R0;
    private int S0;
    private int T0;
    private int U0;
    private int V0;
    private int W0;
    private int X0;
    private int Y0;
    private Drawable Z0;

    /* renamed from: a1, reason: collision with root package name */
    private Drawable f١٦٠٥٦a1;

    /* renamed from: b1, reason: collision with root package name */
    private Drawable f١٦٠٥٧b1;

    /* renamed from: c1, reason: collision with root package name */
    private Drawable f١٦٠٥٨c1;

    /* renamed from: d1, reason: collision with root package name */
    private Drawable f١٦٠٥٩d1;

    /* renamed from: e1, reason: collision with root package name */
    private Drawable f١٦٠٦٠e1;

    /* renamed from: f1, reason: collision with root package name */
    private Drawable f١٦٠٦١f1;

    /* renamed from: g1, reason: collision with root package name */
    private Drawable f١٦٠٦٢g1;

    /* renamed from: h1, reason: collision with root package name */
    private Drawable f١٦٠٦٣h1;

    /* renamed from: i1, reason: collision with root package name */
    private Drawable f١٦٠٦٤i1;

    /* renamed from: j1, reason: collision with root package name */
    private Drawable f١٦٠٦٥j1;

    /* renamed from: k1, reason: collision with root package name */
    private Drawable f١٦٠٦٦k1;

    /* renamed from: l1, reason: collision with root package name */
    private Drawable f١٦٠٦٧l1;

    /* renamed from: m1, reason: collision with root package name */
    private Drawable f١٦٠٦٨m1;

    /* renamed from: n1, reason: collision with root package name */
    private Drawable f١٦٠٦٩n1;

    /* renamed from: o1, reason: collision with root package name */
    private Drawable f١٦٠٧٠o1;

    /* renamed from: p1, reason: collision with root package name */
    private Drawable f١٦٠٧١p1;

    /* renamed from: q1, reason: collision with root package name */
    private Drawable f١٦٠٧٢q1;

    /* renamed from: r1, reason: collision with root package name */
    private Drawable f١٦٠٧٣r1;

    /* renamed from: s1, reason: collision with root package name */
    private Drawable f١٦٠٧٤s1;

    /* renamed from: t1, reason: collision with root package name */
    private Drawable f١٦٠٧٥t1;

    /* renamed from: u1, reason: collision with root package name */
    private Drawable f١٦٠٧٦u1;

    /* renamed from: v1, reason: collision with root package name */
    private Drawable f١٦٠٧٧v1;

    /* renamed from: w1, reason: collision with root package name */
    private Drawable f١٦٠٧٨w1;

    /* renamed from: x1, reason: collision with root package name */
    protected int f١٦٠٧٩x1;

    /* renamed from: y1, reason: collision with root package name */
    protected int f١٦٠٨٠y1;

    /* renamed from: z1, reason: collision with root package name */
    protected int f١٦٠٨١z1;

    public c(Context context, TextView textView, AttributeSet attributeSet) {
        super(context, textView, attributeSet);
        this.I0 = null;
        this.Z0 = null;
        this.f١٦٠٦١f1 = null;
        this.f١٦٠٦٧l1 = null;
        this.f١٦٠٧٣r1 = null;
        this.f١٦٠٧٩x1 = 0;
        this.f١٦٠٨٠y1 = 0;
        this.f١٦٠٨١z1 = 0;
        this.A1 = 0;
        this.B1 = 0;
        this.D1 = new int[6];
        this.F1 = false;
        this.G1 = false;
        this.H1 = false;
        this.I1 = false;
        this.J1 = false;
        h(context, attributeSet);
    }

    private void A(boolean z10) {
        boolean z11;
        boolean z12;
        boolean z13;
        if (z10) {
            boolean z14 = false;
            if (this.f١٦٠٨٠y1 != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            this.G1 = z11;
            if (this.f١٦٠٨١z1 != 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            this.H1 = z12;
            if (this.A1 != 0) {
                z13 = true;
            } else {
                z13 = false;
            }
            this.I1 = z13;
            if (this.B1 != 0) {
                z14 = true;
            }
            this.J1 = z14;
        }
        if (!this.G1) {
            this.f١٦٠٨٠y1 = this.f١٦٠٧٩x1;
        }
        if (!this.H1) {
            this.f١٦٠٨١z1 = this.f١٦٠٧٩x1;
        }
        if (!this.I1) {
            this.A1 = this.f١٦٠٧٩x1;
        }
        if (!this.J1) {
            this.B1 = this.f١٦٠٧٩x1;
        }
    }

    private Drawable H(Context context, TypedArray typedArray, int i10) {
        return typedArray.getDrawable(i10);
    }

    private void R(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            drawable.setBounds(0, 0, this.S0, this.R0);
        }
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, this.U0, this.T0);
        }
        if (drawable3 != null) {
            drawable3.setBounds(0, 0, this.W0, this.V0);
        }
        if (drawable4 != null) {
            drawable4.setBounds(0, 0, this.Y0, this.X0);
        }
        ((TextView) this.F0).setCompoundDrawables(drawable, drawable3, drawable2, drawable4);
    }

    private void T() {
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        Drawable drawable4;
        Drawable drawable5;
        if (this.R0 == 0 && this.S0 == 0 && (drawable5 = this.Z0) != null) {
            this.S0 = drawable5.getIntrinsicWidth();
            this.R0 = this.Z0.getIntrinsicHeight();
        }
        if (this.T0 == 0 && this.U0 == 0 && (drawable4 = this.f١٦٠٧٣r1) != null) {
            this.U0 = drawable4.getIntrinsicWidth();
            this.T0 = this.f١٦٠٧٣r1.getIntrinsicHeight();
        }
        if (this.V0 == 0 && this.W0 == 0 && (drawable3 = this.f١٦٠٦١f1) != null) {
            this.W0 = drawable3.getIntrinsicWidth();
            this.V0 = this.f١٦٠٦١f1.getIntrinsicHeight();
        }
        if (this.X0 == 0 && this.Y0 == 0 && (drawable2 = this.f١٦٠٦٧l1) != null) {
            this.Y0 = drawable2.getIntrinsicWidth();
            this.X0 = this.f١٦٠٦٧l1.getIntrinsicHeight();
        }
        if (this.O0 == 0 && this.P0 == 0 && (drawable = this.I0) != null) {
            this.P0 = drawable.getIntrinsicWidth();
            this.O0 = this.I0.getIntrinsicHeight();
        }
        if (O()) {
            b0(this.I0, this.P0, this.O0, this.Q0);
        } else {
            R(this.Z0, this.f١٦٠٧٣r1, this.f١٦٠٦١f1, this.f١٦٠٦٧l1);
        }
    }

    private void Z() {
        View view;
        int i10;
        int i11;
        if (this.F1 && (view = this.F0) != null && ((TextView) view).getWidth() != 0) {
            int compoundDrawablePadding = ((TextView) this.F0).getCompoundDrawablePadding();
            int i12 = 0;
            if (this.Z0 != null) {
                i10 = compoundDrawablePadding;
            } else {
                i10 = 0;
            }
            if (this.f١٦٠٧٣r1 != null) {
                i10 += compoundDrawablePadding;
            }
            if (this.f١٦٠٦١f1 != null) {
                i11 = compoundDrawablePadding;
            } else {
                i11 = 0;
            }
            if (this.f١٦٠٦٧l1 != null) {
                i11 += compoundDrawablePadding;
            }
            int i13 = i11;
            int i14 = this.S0 + this.U0;
            int i15 = this.V0 + this.X0;
            int width = ((int) ((((TextView) this.F0).getWidth() - (this.K1 + this.L1)) - ((pc.a.a().c((TextView) this.F0, i14, this.K1, this.L1, i10) + i14) + i10))) / 2;
            if (width < 0) {
                width = 0;
            }
            int height = ((int) ((((TextView) this.F0).getHeight() - (this.M1 + this.N1)) - ((pc.a.a().b((TextView) this.F0, i15, this.M1, this.N1, i13) + i15) + i13))) / 2;
            if (height >= 0) {
                i12 = height;
            }
            String str = "" + ((TextView) this.F0).getWidth() + ((TextView) this.F0).getHeight() + width + this.K1 + i12 + this.M1 + width + this.L1 + i12 + this.N1;
            if (!str.equals(this.P1)) {
                this.P1 = str;
                ((TextView) this.F0).setPadding(this.K1 + width, this.M1 + i12, width + this.L1, i12 + this.N1);
            }
        }
    }

    private void b0(Drawable drawable, int i10, int i11, int i12) {
        Drawable drawable2;
        Drawable drawable3;
        Drawable drawable4;
        if (drawable != null) {
            drawable.setBounds(0, 0, i10, i11);
        }
        TextView textView = (TextView) this.F0;
        if (i12 == 1) {
            drawable2 = drawable;
        } else {
            drawable2 = null;
        }
        if (i12 == 2) {
            drawable3 = drawable;
        } else {
            drawable3 = null;
        }
        if (i12 == 3) {
            drawable4 = drawable;
        } else {
            drawable4 = null;
        }
        if (i12 != 4) {
            drawable = null;
        }
        textView.setCompoundDrawables(drawable2, drawable3, drawable4, drawable);
    }

    private void c0() {
        View view;
        int i10;
        if (this.F1 && (view = this.F0) != null && ((TextView) view).getWidth() != 0) {
            int compoundDrawablePadding = ((TextView) this.F0).getCompoundDrawablePadding();
            int i11 = this.P0;
            int i12 = this.O0;
            int i13 = this.Q0;
            int i14 = 0;
            if (i13 != 1 && i13 != 3) {
                i10 = compoundDrawablePadding;
            } else {
                i12 = 0;
                i10 = 0;
            }
            if (i13 == 2 || i13 == 4) {
                compoundDrawablePadding = 0;
                i11 = 0;
            }
            int width = ((int) ((((TextView) this.F0).getWidth() - (this.K1 + this.L1)) - ((pc.a.a().c((TextView) this.F0, i11, this.K1, this.L1, compoundDrawablePadding) + i11) + compoundDrawablePadding))) / 2;
            if (width < 0) {
                width = 0;
            }
            int height = ((int) ((((TextView) this.F0).getHeight() - (this.M1 + this.N1)) - ((pc.a.a().b((TextView) this.F0, i12, this.M1, this.N1, i10) + i12) + i10))) / 2;
            if (height >= 0) {
                i14 = height;
            }
            String str = "" + ((TextView) this.F0).getWidth() + ((TextView) this.F0).getHeight() + width + this.K1 + i14 + this.M1 + width + this.L1 + i14 + this.N1;
            if (!str.equals(this.O1)) {
                this.O1 = str;
                ((TextView) this.F0).setPadding(this.K1 + width, this.M1 + i14, width + this.L1, i14 + this.N1);
            }
        }
    }

    private void e0() {
        if (!TextUtils.isEmpty(this.E1)) {
            ((TextView) this.F0).setTypeface(Typeface.createFromAsset(this.f١٦٠٣١o0.getAssets(), this.E1));
        }
    }

    private void h(Context context, AttributeSet attributeSet) {
        if (context != null && attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RTextView);
            this.f١٦٠٥٦a1 = H(context, obtainStyledAttributes, R.styleable.RTextView_icon_normal_left);
            this.f١٦٠٥٧b1 = H(context, obtainStyledAttributes, R.styleable.RTextView_icon_pressed_left);
            this.f١٦٠٥٨c1 = H(context, obtainStyledAttributes, R.styleable.RTextView_icon_unable_left);
            this.f١٦٠٥٩d1 = H(context, obtainStyledAttributes, R.styleable.RTextView_icon_selected_left);
            this.f١٦٠٦٠e1 = H(context, obtainStyledAttributes, R.styleable.RTextView_icon_checked_left);
            this.f١٦٠٧٤s1 = H(context, obtainStyledAttributes, R.styleable.RTextView_icon_normal_right);
            this.f١٦٠٧٥t1 = H(context, obtainStyledAttributes, R.styleable.RTextView_icon_pressed_right);
            this.f١٦٠٧٦u1 = H(context, obtainStyledAttributes, R.styleable.RTextView_icon_unable_right);
            this.f١٦٠٧٧v1 = H(context, obtainStyledAttributes, R.styleable.RTextView_icon_selected_right);
            this.f١٦٠٧٨w1 = H(context, obtainStyledAttributes, R.styleable.RTextView_icon_checked_right);
            this.f١٦٠٦٢g1 = H(context, obtainStyledAttributes, R.styleable.RTextView_icon_normal_top);
            this.f١٦٠٦٣h1 = H(context, obtainStyledAttributes, R.styleable.RTextView_icon_pressed_top);
            this.f١٦٠٦٤i1 = H(context, obtainStyledAttributes, R.styleable.RTextView_icon_unable_top);
            this.f١٦٠٦٥j1 = H(context, obtainStyledAttributes, R.styleable.RTextView_icon_selected_top);
            this.f١٦٠٦٦k1 = H(context, obtainStyledAttributes, R.styleable.RTextView_icon_checked_top);
            this.f١٦٠٦٨m1 = H(context, obtainStyledAttributes, R.styleable.RTextView_icon_normal_bottom);
            this.f١٦٠٦٩n1 = H(context, obtainStyledAttributes, R.styleable.RTextView_icon_pressed_bottom);
            this.f١٦٠٧٠o1 = H(context, obtainStyledAttributes, R.styleable.RTextView_icon_unable_bottom);
            this.f١٦٠٧١p1 = H(context, obtainStyledAttributes, R.styleable.RTextView_icon_selected_bottom);
            this.f١٦٠٧٢q1 = H(context, obtainStyledAttributes, R.styleable.RTextView_icon_checked_bottom);
            Drawable H = H(context, obtainStyledAttributes, R.styleable.RTextView_android_drawableLeft);
            Drawable H2 = H(context, obtainStyledAttributes, R.styleable.RTextView_android_drawableRight);
            Drawable H3 = H(context, obtainStyledAttributes, R.styleable.RTextView_android_drawableTop);
            Drawable H4 = H(context, obtainStyledAttributes, R.styleable.RTextView_android_drawableBottom);
            Drawable H5 = H(context, obtainStyledAttributes, R.styleable.RTextView_android_drawableStart);
            Drawable H6 = H(context, obtainStyledAttributes, R.styleable.RTextView_android_drawableEnd);
            this.J0 = H(context, obtainStyledAttributes, R.styleable.RTextView_icon_src_normal);
            this.K0 = H(context, obtainStyledAttributes, R.styleable.RTextView_icon_src_pressed);
            this.L0 = H(context, obtainStyledAttributes, R.styleable.RTextView_icon_src_unable);
            this.M0 = H(context, obtainStyledAttributes, R.styleable.RTextView_icon_src_selected);
            this.N0 = H(context, obtainStyledAttributes, R.styleable.RTextView_icon_src_checked);
            if (!pc.a.d()) {
                if (H5 != null) {
                    H = H5;
                }
                if (H6 != null) {
                    H2 = H6;
                }
            } else {
                if (H6 != null) {
                    H = H6;
                }
                if (H5 != null) {
                    H2 = H5;
                }
            }
            if (H != null) {
                this.f١٦٠٥٦a1 = H;
            }
            if (H2 != null) {
                this.f١٦٠٧٤s1 = H2;
            }
            if (H3 != null) {
                this.f١٦٠٦٢g1 = H3;
            }
            if (H4 != null) {
                this.f١٦٠٦٨m1 = H4;
            }
            this.S0 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RTextView_icon_width_left, 0);
            this.R0 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RTextView_icon_height_left, 0);
            this.U0 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RTextView_icon_width_right, 0);
            this.T0 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RTextView_icon_height_right, 0);
            this.Y0 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RTextView_icon_width_bottom, 0);
            this.X0 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RTextView_icon_height_bottom, 0);
            this.W0 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RTextView_icon_width_top, 0);
            this.V0 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RTextView_icon_height_top, 0);
            this.P0 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RTextView_icon_width, 0);
            this.O0 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RTextView_icon_height, 0);
            this.Q0 = obtainStyledAttributes.getInt(R.styleable.RTextView_icon_direction, 1);
            this.f١٦٠٧٩x1 = obtainStyledAttributes.getColor(R.styleable.RTextView_text_color_normal, ((TextView) this.F0).getCurrentTextColor());
            this.f١٦٠٨٠y1 = obtainStyledAttributes.getColor(R.styleable.RTextView_text_color_pressed, 0);
            this.f١٦٠٨١z1 = obtainStyledAttributes.getColor(R.styleable.RTextView_text_color_unable, 0);
            this.A1 = obtainStyledAttributes.getColor(R.styleable.RTextView_text_color_selected, 0);
            this.B1 = obtainStyledAttributes.getColor(R.styleable.RTextView_text_color_checked, 0);
            this.E1 = obtainStyledAttributes.getString(R.styleable.RTextView_text_typeface);
            this.F1 = obtainStyledAttributes.getBoolean(R.styleable.RTextView_icon_with_text, false);
            obtainStyledAttributes.recycle();
            z();
            return;
        }
        z();
    }

    private void z() {
        if (!((TextView) this.F0).isEnabled()) {
            this.I0 = this.L0;
            this.Z0 = this.f١٦٠٥٨c1;
            this.f١٦٠٧٣r1 = this.f١٦٠٧٦u1;
            this.f١٦٠٦١f1 = this.f١٦٠٦٤i1;
            this.f١٦٠٦٧l1 = this.f١٦٠٧٠o1;
        } else if (((TextView) this.F0).isSelected()) {
            this.I0 = this.M0;
            this.Z0 = this.f١٦٠٥٩d1;
            this.f١٦٠٧٣r1 = this.f١٦٠٧٧v1;
            this.f١٦٠٦١f1 = this.f١٦٠٦٥j1;
            this.f١٦٠٦٧l1 = this.f١٦٠٧١p1;
        } else if (N()) {
            this.I0 = this.N0;
            this.Z0 = this.f١٦٠٦٠e1;
            this.f١٦٠٧٣r1 = this.f١٦٠٧٨w1;
            this.f١٦٠٦١f1 = this.f١٦٠٦٦k1;
            this.f١٦٠٦٧l1 = this.f١٦٠٧٢q1;
        } else {
            this.I0 = this.J0;
            this.Z0 = this.f١٦٠٥٦a1;
            this.f١٦٠٧٣r1 = this.f١٦٠٧٤s1;
            this.f١٦٠٦١f1 = this.f١٦٠٦٢g1;
            this.f١٦٠٦٧l1 = this.f١٦٠٦٨m1;
        }
        int[][] iArr = this.D1;
        iArr[0] = new int[]{-16842910};
        iArr[1] = new int[]{android.R.attr.state_focused};
        iArr[2] = new int[]{android.R.attr.state_pressed};
        iArr[3] = new int[]{android.R.attr.state_checked};
        iArr[4] = new int[]{android.R.attr.state_selected};
        iArr[5] = new int[]{android.R.attr.state_enabled};
        A(true);
        d0();
        T();
        e0();
    }

    public void G() {
        if (O()) {
            c0();
        } else {
            Z();
        }
    }

    public Drawable I() {
        return this.J0;
    }

    public Drawable J() {
        return this.f١٦٠٦٨m1;
    }

    public Drawable K() {
        return this.f١٦٠٥٦a1;
    }

    public Drawable L() {
        return this.f١٦٠٧٤s1;
    }

    public Drawable M() {
        return this.f١٦٠٦٢g1;
    }

    protected boolean N() {
        return false;
    }

    protected boolean O() {
        if (this.J0 == null && this.K0 == null && this.L0 == null && this.M0 == null && this.N0 == null) {
            return false;
        }
        return true;
    }

    public void P(MotionEvent motionEvent) {
        if (!((TextView) this.F0).isEnabled() || N() || ((TextView) this.F0).isSelected()) {
            return;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return;
                    }
                } else {
                    if (j((int) motionEvent.getX(), (int) motionEvent.getY())) {
                        this.Z0 = this.f١٦٠٥٦a1;
                        this.f١٦٠٧٣r1 = this.f١٦٠٧٤s1;
                        this.f١٦٠٦١f1 = this.f١٦٠٦٢g1;
                        this.f١٦٠٦٧l1 = this.f١٦٠٦٨m1;
                        this.I0 = this.J0;
                        T();
                        return;
                    }
                    return;
                }
            }
            this.Z0 = this.f١٦٠٥٦a1;
            this.f١٦٠٧٣r1 = this.f١٦٠٧٤s1;
            this.f١٦٠٦١f1 = this.f١٦٠٦٢g1;
            this.f١٦٠٦٧l1 = this.f١٦٠٦٨m1;
            this.I0 = this.J0;
            T();
            return;
        }
        Drawable drawable = this.f١٦٠٥٧b1;
        if (drawable != null) {
            this.Z0 = drawable;
        }
        Drawable drawable2 = this.f١٦٠٧٥t1;
        if (drawable2 != null) {
            this.f١٦٠٧٣r1 = drawable2;
        }
        Drawable drawable3 = this.f١٦٠٦٣h1;
        if (drawable3 != null) {
            this.f١٦٠٦١f1 = drawable3;
        }
        Drawable drawable4 = this.f١٦٠٦٩n1;
        if (drawable4 != null) {
            this.f١٦٠٦٧l1 = drawable4;
        }
        Drawable drawable5 = this.K0;
        if (drawable5 != null) {
            this.I0 = drawable5;
        }
        T();
    }

    public void Q(boolean z10) {
        Drawable K;
        Drawable L;
        Drawable M;
        Drawable J;
        Drawable I;
        if (z10) {
            K = this.f١٦٠٦٠e1;
        } else {
            K = K();
        }
        W(K);
        if (z10) {
            L = this.f١٦٠٧٨w1;
        } else {
            L = L();
        }
        X(L);
        if (z10) {
            M = this.f١٦٠٦٦k1;
        } else {
            M = M();
        }
        Y(M);
        if (z10) {
            J = this.f١٦٠٧٢q1;
        } else {
            J = J();
        }
        V(J);
        if (z10) {
            I = this.N0;
        } else {
            I = I();
        }
        U(I);
    }

    public void S(boolean z10) {
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        Drawable drawable4;
        Drawable drawable5;
        if (z10 || (drawable = this.f١٦٠٥٨c1) == null) {
            drawable = this.f١٦٠٥٦a1;
        }
        this.Z0 = drawable;
        if (z10 || (drawable2 = this.f١٦٠٧٦u1) == null) {
            drawable2 = this.f١٦٠٧٤s1;
        }
        this.f١٦٠٧٣r1 = drawable2;
        if (z10 || (drawable3 = this.f١٦٠٦٤i1) == null) {
            drawable3 = this.f١٦٠٦٢g1;
        }
        this.f١٦٠٦١f1 = drawable3;
        if (z10 || (drawable4 = this.f١٦٠٧٠o1) == null) {
            drawable4 = this.f١٦٠٦٨m1;
        }
        this.f١٦٠٦٧l1 = drawable4;
        if (z10 || (drawable5 = this.L0) == null) {
            drawable5 = this.J0;
        }
        this.I0 = drawable5;
        T();
    }

    protected void U(Drawable drawable) {
        this.I0 = drawable;
        T();
    }

    protected void V(Drawable drawable) {
        this.f١٦٠٦٧l1 = drawable;
        T();
    }

    protected void W(Drawable drawable) {
        this.Z0 = drawable;
        T();
    }

    protected void X(Drawable drawable) {
        this.f١٦٠٧٣r1 = drawable;
        T();
    }

    protected void Y(Drawable drawable) {
        this.f١٦٠٦١f1 = drawable;
        T();
    }

    public void a0(boolean z10) {
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        Drawable drawable4;
        Drawable drawable5;
        if (!((TextView) this.F0).isEnabled()) {
            return;
        }
        if (!z10 || (drawable = this.f١٦٠٥٩d1) == null) {
            drawable = this.f١٦٠٥٦a1;
        }
        this.Z0 = drawable;
        if (!z10 || (drawable2 = this.f١٦٠٧٧v1) == null) {
            drawable2 = this.f١٦٠٧٤s1;
        }
        this.f١٦٠٧٣r1 = drawable2;
        if (!z10 || (drawable3 = this.f١٦٠٦٥j1) == null) {
            drawable3 = this.f١٦٠٦٢g1;
        }
        this.f١٦٠٦١f1 = drawable3;
        if (!z10 || (drawable4 = this.f١٦٠٧١p1) == null) {
            drawable4 = this.f١٦٠٦٨m1;
        }
        this.f١٦٠٦٧l1 = drawable4;
        if (!z10 || (drawable5 = this.M0) == null) {
            drawable5 = this.J0;
        }
        this.I0 = drawable5;
        T();
    }

    protected void d0() {
        int i10 = this.f١٦٠٨١z1;
        int i11 = this.f١٦٠٨٠y1;
        ColorStateList colorStateList = new ColorStateList(this.D1, new int[]{i10, i11, i11, this.B1, this.A1, this.f١٦٠٧٩x1});
        this.C1 = colorStateList;
        ((TextView) this.F0).setTextColor(colorStateList);
    }

    @Override // mc.a, android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        super.onGlobalLayout();
        this.K1 = ((TextView) this.F0).getPaddingLeft();
        this.L1 = ((TextView) this.F0).getPaddingRight();
        this.M1 = ((TextView) this.F0).getPaddingTop();
        this.N1 = ((TextView) this.F0).getPaddingBottom();
    }
}
