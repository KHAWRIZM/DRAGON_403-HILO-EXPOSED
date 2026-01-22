package mc;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import com.alibaba.sdk.android.push.notification.CustomNotificationBuilder;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import lc.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class a implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: B, reason: collision with root package name */
    private int[] f١٦٠٠١B;
    private int[] C;
    private int[] D;
    private int[] E;
    private int[] F;
    protected View F0;
    private GradientDrawable G;
    private GradientDrawable H;
    private GradientDrawable I;
    private GradientDrawable J;
    private GradientDrawable K;
    private Drawable L;
    private Drawable M;
    private Drawable N;
    private Drawable O;
    private Drawable P;
    private float R;
    private float S;
    private float T;
    private oc.a V;
    private int W;
    private int X;
    private int Y;
    private int Z;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f١٦٠٠٥b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f١٦٠٠٧c0;

    /* renamed from: d0, reason: collision with root package name */
    private Drawable f١٦٠٠٩d0;

    /* renamed from: e0, reason: collision with root package name */
    private int f١٦٠١١e0;

    /* renamed from: f, reason: collision with root package name */
    private float f١٦٠١٢f;

    /* renamed from: g, reason: collision with root package name */
    private float f١٦٠١٤g;

    /* renamed from: h, reason: collision with root package name */
    private float f١٦٠١٦h;

    /* renamed from: i, reason: collision with root package name */
    private float f١٦٠١٨i;

    /* renamed from: i0, reason: collision with root package name */
    private Drawable f١٦٠١٩i0;

    /* renamed from: j, reason: collision with root package name */
    private float f١٦٠٢٠j;

    /* renamed from: j0, reason: collision with root package name */
    private Drawable f١٦٠٢١j0;

    /* renamed from: l0, reason: collision with root package name */
    private StateListDrawable f١٦٠٢٥l0;

    /* renamed from: n0, reason: collision with root package name */
    private int f١٦٠٢٩n0;

    /* renamed from: o0, reason: collision with root package name */
    protected Context f١٦٠٣١o0;

    /* renamed from: a, reason: collision with root package name */
    protected final int f١٦٠٠٢a = 0;

    /* renamed from: b, reason: collision with root package name */
    protected final int f١٦٠٠٤b = -1;

    /* renamed from: c, reason: collision with root package name */
    protected int f١٦٠٠٦c = 1;

    /* renamed from: d, reason: collision with root package name */
    protected int f١٦٠٠٨d = 2;

    /* renamed from: e, reason: collision with root package name */
    protected int f١٦٠١٠e = 3;

    /* renamed from: k, reason: collision with root package name */
    private float f١٦٠٢٢k = -1.0f;

    /* renamed from: l, reason: collision with root package name */
    private float f١٦٠٢٤l = -1.0f;

    /* renamed from: m, reason: collision with root package name */
    private int f١٦٠٢٦m = -1;

    /* renamed from: n, reason: collision with root package name */
    private int f١٦٠٢٨n = -1;

    /* renamed from: o, reason: collision with root package name */
    private int f١٦٠٣٠o = -1;

    /* renamed from: p, reason: collision with root package name */
    private int f١٦٠٣٢p = -1;

    /* renamed from: q, reason: collision with root package name */
    private int f١٦٠٣٤q = -1;

    /* renamed from: r, reason: collision with root package name */
    private int f١٦٠٣٦r = 0;

    /* renamed from: s, reason: collision with root package name */
    private int f١٦٠٣٨s = 0;

    /* renamed from: t, reason: collision with root package name */
    private int f١٦٠٤٠t = 0;

    /* renamed from: u, reason: collision with root package name */
    private int f١٦٠٤٢u = 0;

    /* renamed from: v, reason: collision with root package name */
    private int f١٦٠٤٤v = 0;

    /* renamed from: w, reason: collision with root package name */
    private int f١٦٠٤٦w = 0;

    /* renamed from: x, reason: collision with root package name */
    private int f١٦٠٤٨x = 0;

    /* renamed from: y, reason: collision with root package name */
    private int f١٦٠٥٠y = 0;

    /* renamed from: z, reason: collision with root package name */
    private int f١٦٠٥٢z = 0;
    private int A = 0;
    private int Q = 0;
    private GradientDrawable.Orientation U = GradientDrawable.Orientation.TOP_BOTTOM;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f١٦٠٠٣a0 = true;

    /* renamed from: f0, reason: collision with root package name */
    private final int f١٦٠١٣f0 = 1;

    /* renamed from: g0, reason: collision with root package name */
    private final int f١٦٠١٥g0 = 2;

    /* renamed from: h0, reason: collision with root package name */
    private final int f١٦٠١٧h0 = 3;

    /* renamed from: k0, reason: collision with root package name */
    private int[][] f١٦٠٢٣k0 = new int[6];

    /* renamed from: m0, reason: collision with root package name */
    private float[] f١٦٠٢٧m0 = new float[8];

    /* renamed from: p0, reason: collision with root package name */
    private boolean f١٦٠٣٣p0 = false;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f١٦٠٣٥q0 = false;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f١٦٠٣٧r0 = false;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f١٦٠٣٩s0 = false;

    /* renamed from: t0, reason: collision with root package name */
    private boolean f١٦٠٤١t0 = false;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f١٦٠٤٣u0 = false;

    /* renamed from: v0, reason: collision with root package name */
    private boolean f١٦٠٤٥v0 = false;

    /* renamed from: w0, reason: collision with root package name */
    private boolean f١٦٠٤٧w0 = false;

    /* renamed from: x0, reason: collision with root package name */
    private boolean f١٦٠٤٩x0 = false;

    /* renamed from: y0, reason: collision with root package name */
    private boolean f١٦٠٥١y0 = false;

    /* renamed from: z0, reason: collision with root package name */
    private boolean f١٦٠٥٣z0 = false;
    private boolean A0 = false;
    private boolean B0 = false;
    private boolean C0 = false;
    private boolean D0 = false;
    private boolean E0 = false;
    protected lc.a G0 = new lc.a();
    private boolean H0 = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: mc.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class ViewOnAttachStateChangeListenerC٠١٩٠a implements View.OnAttachStateChangeListener {
        ViewOnAttachStateChangeListenerC٠١٩٠a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(a.this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            view.getViewTreeObserver().removeGlobalOnLayoutListener(a.this);
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class b implements b.a {
        b() {
        }

        @Override // lc.b.a
        public Path a(int i10, int i11) {
            Path path = new Path();
            path.addRoundRect(new RectF(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, i10, i11), a.this.f١٦٠٢٧m0, Path.Direction.CCW);
            return path;
        }
    }

    public a(Context context, View view, AttributeSet attributeSet) {
        this.F0 = view;
        this.f١٦٠٣١o0 = context;
        this.f١٦٠٢٩n0 = ViewConfiguration.get(context).getScaledTouchSlop();
        h(context, attributeSet);
        b();
    }

    private void A(boolean z10) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z20;
        boolean z21;
        boolean z22;
        boolean z23;
        boolean z24;
        boolean z25;
        if (z10) {
            boolean z26 = true;
            if (this.f١٦٠٤٨x == 0 && this.C == null) {
                z11 = false;
            } else {
                z11 = true;
            }
            this.f١٦٠٣٣p0 = z11;
            if (this.f١٦٠٥٠y == 0 && this.D == null) {
                z12 = false;
            } else {
                z12 = true;
            }
            this.f١٦٠٣٧r0 = z12;
            if (this.f١٦٠٥٢z == 0 && this.E == null) {
                z13 = false;
            } else {
                z13 = true;
            }
            this.f١٦٠٤١t0 = z13;
            if (this.A == 0 && this.F == null) {
                z14 = false;
            } else {
                z14 = true;
            }
            this.f١٦٠٤٣u0 = z14;
            if (this.M != null) {
                z15 = true;
            } else {
                z15 = false;
            }
            this.f١٦٠٣٥q0 = z15;
            if (this.N != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f١٦٠٣٩s0 = z16;
            if (this.O != null) {
                z17 = true;
            } else {
                z17 = false;
            }
            this.f١٦٠٤٥v0 = z17;
            if (this.P != null) {
                z18 = true;
            } else {
                z18 = false;
            }
            this.f١٦٠٤٧w0 = z18;
            if (this.f١٦٠٣٨s != 0) {
                z19 = true;
            } else {
                z19 = false;
            }
            this.f١٦٠٤٩x0 = z19;
            if (this.f١٦٠٤٠t != 0) {
                z20 = true;
            } else {
                z20 = false;
            }
            this.f١٦٠٥١y0 = z20;
            if (this.f١٦٠٤٢u != 0) {
                z21 = true;
            } else {
                z21 = false;
            }
            this.f١٦٠٥٣z0 = z21;
            if (this.f١٦٠٤٤v != 0) {
                z22 = true;
            } else {
                z22 = false;
            }
            this.A0 = z22;
            if (this.f١٦٠٢٨n != -1) {
                z23 = true;
            } else {
                z23 = false;
            }
            this.B0 = z23;
            if (this.f١٦٠٣٠o != -1) {
                z24 = true;
            } else {
                z24 = false;
            }
            this.C0 = z24;
            if (this.f١٦٠٣٢p != -1) {
                z25 = true;
            } else {
                z25 = false;
            }
            this.D0 = z25;
            if (this.f١٦٠٣٤q == -1) {
                z26 = false;
            }
            this.E0 = z26;
        }
        if (!this.f١٦٠٣٣p0) {
            this.f١٦٠٤٨x = this.f١٦٠٤٦w;
            this.C = this.f١٦٠٠١B;
        }
        if (!this.f١٦٠٣٥q0) {
            this.M = this.L;
        }
        if (!this.f١٦٠٣٧r0) {
            this.f١٦٠٥٠y = this.f١٦٠٤٦w;
            this.D = this.f١٦٠٠١B;
        }
        if (!this.f١٦٠٣٩s0) {
            this.N = this.L;
        }
        if (!this.f١٦٠٤١t0) {
            this.f١٦٠٥٢z = this.f١٦٠٤٦w;
            this.E = this.f١٦٠٠١B;
        }
        if (!this.f١٦٠٤٣u0) {
            this.A = this.f١٦٠٤٦w;
            this.F = this.f١٦٠٠١B;
        }
        if (!this.f١٦٠٤٥v0) {
            this.O = this.L;
        }
        if (!this.f١٦٠٤٧w0) {
            this.P = this.L;
        }
        int[] iArr = this.f١٦٠٠١B;
        if (iArr != null && iArr.length > 0) {
            this.G = t(this.G, iArr);
        } else {
            this.G.setColor(this.f١٦٠٤٦w);
        }
        int[] iArr2 = this.C;
        if (iArr2 != null && iArr2.length > 0) {
            this.H = t(this.H, iArr2);
        } else {
            this.H.setColor(this.f١٦٠٤٨x);
        }
        int[] iArr3 = this.D;
        if (iArr3 != null && iArr3.length > 0) {
            this.I = t(this.I, iArr3);
        } else {
            this.I.setColor(this.f١٦٠٥٠y);
        }
        int[] iArr4 = this.E;
        if (iArr4 != null && iArr4.length > 0) {
            this.J = t(this.J, iArr4);
        } else {
            this.J.setColor(this.f١٦٠٥٢z);
        }
        int[] iArr5 = this.F;
        if (iArr5 != null && iArr5.length > 0) {
            this.K = t(this.K, iArr5);
        } else {
            this.K.setColor(this.A);
        }
        if (!this.B0) {
            this.f١٦٠٢٨n = this.f١٦٠٢٦m;
        }
        if (!this.C0) {
            this.f١٦٠٣٠o = this.f١٦٠٢٦m;
        }
        if (!this.D0) {
            this.f١٦٠٣٢p = this.f١٦٠٢٦m;
        }
        if (!this.E0) {
            this.f١٦٠٣٤q = this.f١٦٠٢٦m;
        }
        if (!this.f١٦٠٤٩x0) {
            this.f١٦٠٣٨s = this.f١٦٠٣٦r;
        }
        if (!this.f١٦٠٥١y0) {
            this.f١٦٠٤٠t = this.f١٦٠٣٦r;
        }
        if (!this.f١٦٠٥٣z0) {
            this.f١٦٠٤٢u = this.f١٦٠٣٦r;
        }
        if (!this.A0) {
            this.f١٦٠٤٤v = this.f١٦٠٣٦r;
        }
    }

    private void B() {
        A(false);
        y();
        p();
    }

    private void C() {
        A(false);
        q();
        p();
    }

    private void D() {
        x();
        p();
    }

    private void b() {
        View view = this.F0;
        if (view == null) {
            return;
        }
        view.addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC٠١٩٠a());
    }

    private Drawable d(boolean z10, int i10) {
        if (!k()) {
            return this.f١٦٠٢٥l0;
        }
        Object[] g10 = g(z10, i10);
        RippleDrawable rippleDrawable = (RippleDrawable) g10[0];
        if (((Boolean) g10[1]).booleanValue()) {
            return rippleDrawable;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        int[][] iArr = {new int[]{-16842910}, new int[]{R.attr.state_checked}, new int[]{R.attr.state_selected}, new int[]{R.attr.state_enabled}};
        int[] iArr2 = iArr[0];
        Drawable drawable = this.N;
        if (drawable == null) {
            drawable = this.I;
        }
        stateListDrawable.addState(iArr2, drawable);
        int[] iArr3 = iArr[1];
        Drawable drawable2 = this.O;
        if (drawable2 == null) {
            drawable2 = this.J;
        }
        stateListDrawable.addState(iArr3, drawable2);
        int[] iArr4 = iArr[2];
        Drawable drawable3 = this.P;
        if (drawable3 == null) {
            drawable3 = this.K;
        }
        stateListDrawable.addState(iArr4, drawable3);
        stateListDrawable.addState(iArr[3], rippleDrawable);
        return stateListDrawable;
    }

    private Object[] e(TypedArray typedArray, int i10) {
        Drawable drawable;
        int color;
        int[] iArr;
        int i11 = this.f١٦٠٠٦c;
        int resourceId = typedArray.getResourceId(i10, 0);
        int[] iArr2 = null;
        if (resourceId == 0) {
            String string = typedArray.getString(i10);
            if (!TextUtils.isEmpty(string)) {
                String[] split = string.replaceAll(" ", "").split(",");
                ArrayList arrayList = new ArrayList();
                int length = split.length;
                for (int i12 = 0; i12 < length; i12++) {
                    String str = split[i12];
                    if (str.length() >= 3) {
                        if (!str.startsWith("#")) {
                            str = "#" + str;
                        }
                        if (str.length() == 6 || str.length() == 8) {
                            str = "#0" + str.substring(1);
                        }
                        arrayList.add(Integer.valueOf(Color.parseColor(str)));
                    }
                }
                if (arrayList.size() <= 1) {
                    i11 = this.f١٦٠٠٦c;
                    if (arrayList.isEmpty()) {
                        color = 0;
                    } else {
                        color = ((Integer) arrayList.get(0)).intValue();
                    }
                    iArr = null;
                    drawable = null;
                    iArr2 = iArr;
                } else {
                    i11 = this.f١٦٠٠٨d;
                    int size = arrayList.size();
                    iArr = new int[size];
                    for (int i13 = 0; i13 < size; i13++) {
                        iArr[i13] = ((Integer) arrayList.get(i13)).intValue();
                    }
                }
            } else {
                iArr = null;
            }
            color = 0;
            drawable = null;
            iArr2 = iArr;
        } else {
            String resourceTypeName = this.f١٦٠٣١o0.getResources().getResourceTypeName(resourceId);
            if ("array".equals(resourceTypeName)) {
                i11 = this.f١٦٠٠٨d;
                String[] stringArray = this.f١٦٠٣١o0.getResources().getStringArray(resourceId);
                int[] intArray = this.f١٦٠٣١o0.getResources().getIntArray(resourceId);
                int min = Math.min(intArray.length, stringArray.length);
                int[] iArr3 = new int[min];
                for (int i14 = 0; i14 < min; i14++) {
                    String str2 = stringArray[i14];
                    int i15 = intArray[i14];
                    if (!TextUtils.isEmpty(str2)) {
                        i15 = Color.parseColor(str2);
                    }
                    iArr3[i14] = i15;
                }
                drawable = null;
                iArr2 = iArr3;
            } else if ("color".equals(resourceTypeName)) {
                color = typedArray.getColor(i10, 0);
                i11 = this.f١٦٠٠٦c;
                drawable = null;
            } else if (!"mipmap".equals(resourceTypeName) && !CustomNotificationBuilder.NOTIFICATION_ICON_RES_TYPE.equals(resourceTypeName)) {
                drawable = null;
            } else {
                i11 = this.f١٦٠١٠e;
                drawable = typedArray.getDrawable(i10);
            }
            color = 0;
        }
        return new Object[]{Integer.valueOf(i11), Integer.valueOf(color), iArr2, drawable};
    }

    private GradientDrawable.Orientation f(TypedArray typedArray) {
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.BL_TR;
        switch (typedArray.getInt(com.ruffian.library.widget.R.styleable.RBaseView_gradient_orientation, 6)) {
            case 0:
                return GradientDrawable.Orientation.TOP_BOTTOM;
            case 1:
                return GradientDrawable.Orientation.TR_BL;
            case 2:
                return GradientDrawable.Orientation.RIGHT_LEFT;
            case 3:
                return GradientDrawable.Orientation.BR_TL;
            case 4:
                return GradientDrawable.Orientation.BOTTOM_TOP;
            case 5:
            default:
                return orientation;
            case 6:
                return GradientDrawable.Orientation.LEFT_RIGHT;
            case 7:
                return GradientDrawable.Orientation.TL_BR;
        }
    }

    private Object[] g(boolean z10, int i10) {
        Drawable drawable;
        boolean z11;
        Drawable drawable2 = null;
        if (z10) {
            drawable = this.L;
            if (drawable == null) {
                drawable = this.G;
            }
        } else {
            drawable = null;
        }
        int i11 = this.f١٦٠١١e0;
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 == 3) {
                    drawable2 = this.f١٦٠٠٩d0;
                }
            } else if (z10) {
                Drawable drawable3 = this.L;
                drawable2 = drawable3 != null ? drawable3 : new ShapeDrawable(new RoundRectShape(this.f١٦٠٢٧m0, null, null));
            } else {
                drawable2 = new ShapeDrawable(new RectShape());
            }
        }
        RippleDrawable rippleDrawable = new RippleDrawable(new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[]{R.attr.state_focused}, new int[]{R.attr.state_activated}, new int[0]}, new int[]{i10, i10, i10, i10}), drawable, drawable2);
        if (drawable == null && drawable2 == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        return new Object[]{rippleDrawable, Boolean.valueOf(z11)};
    }

    private void h(Context context, AttributeSet attributeSet) {
        if (context != null && attributeSet != null) {
            TypedArray obtainStyledAttributes = this.F0.getContext().obtainStyledAttributes(attributeSet, com.ruffian.library.widget.R.styleable.RBaseView);
            this.f١٦٠١٢f = obtainStyledAttributes.getDimensionPixelSize(com.ruffian.library.widget.R.styleable.RBaseView_corner_radius, -1);
            this.f١٦٠١٤g = obtainStyledAttributes.getDimensionPixelSize(com.ruffian.library.widget.R.styleable.RBaseView_corner_radius_top_left, 0);
            this.f١٦٠١٦h = obtainStyledAttributes.getDimensionPixelSize(com.ruffian.library.widget.R.styleable.RBaseView_corner_radius_top_right, 0);
            this.f١٦٠١٨i = obtainStyledAttributes.getDimensionPixelSize(com.ruffian.library.widget.R.styleable.RBaseView_corner_radius_bottom_left, 0);
            this.f١٦٠٢٠j = obtainStyledAttributes.getDimensionPixelSize(com.ruffian.library.widget.R.styleable.RBaseView_corner_radius_bottom_right, 0);
            this.f١٦٠٢٢k = obtainStyledAttributes.getDimensionPixelSize(com.ruffian.library.widget.R.styleable.RBaseView_border_dash_width, -1);
            this.f١٦٠٢٤l = obtainStyledAttributes.getDimensionPixelSize(com.ruffian.library.widget.R.styleable.RBaseView_border_dash_gap, -1);
            this.f١٦٠٢٦m = obtainStyledAttributes.getDimensionPixelSize(com.ruffian.library.widget.R.styleable.RBaseView_border_width_normal, -1);
            this.f١٦٠٢٨n = obtainStyledAttributes.getDimensionPixelSize(com.ruffian.library.widget.R.styleable.RBaseView_border_width_pressed, -1);
            this.f١٦٠٣٠o = obtainStyledAttributes.getDimensionPixelSize(com.ruffian.library.widget.R.styleable.RBaseView_border_width_unable, -1);
            this.f١٦٠٣٢p = obtainStyledAttributes.getDimensionPixelSize(com.ruffian.library.widget.R.styleable.RBaseView_border_width_checked, -1);
            this.f١٦٠٣٤q = obtainStyledAttributes.getDimensionPixelSize(com.ruffian.library.widget.R.styleable.RBaseView_border_width_selected, -1);
            this.f١٦٠٣٦r = obtainStyledAttributes.getColor(com.ruffian.library.widget.R.styleable.RBaseView_border_color_normal, 0);
            this.f١٦٠٣٨s = obtainStyledAttributes.getColor(com.ruffian.library.widget.R.styleable.RBaseView_border_color_pressed, 0);
            this.f١٦٠٤٠t = obtainStyledAttributes.getColor(com.ruffian.library.widget.R.styleable.RBaseView_border_color_unable, 0);
            this.f١٦٠٤٢u = obtainStyledAttributes.getColor(com.ruffian.library.widget.R.styleable.RBaseView_border_color_checked, 0);
            this.f١٦٠٤٤v = obtainStyledAttributes.getColor(com.ruffian.library.widget.R.styleable.RBaseView_border_color_selected, 0);
            Object[] e10 = e(obtainStyledAttributes, com.ruffian.library.widget.R.styleable.RBaseView_background_normal);
            this.f١٦٠٤٦w = ((Integer) e10[1]).intValue();
            this.f١٦٠٠١B = (int[]) e10[2];
            this.L = (Drawable) e10[3];
            Object[] e11 = e(obtainStyledAttributes, com.ruffian.library.widget.R.styleable.RBaseView_background_pressed);
            this.f١٦٠٤٨x = ((Integer) e11[1]).intValue();
            this.C = (int[]) e11[2];
            this.M = (Drawable) e11[3];
            Object[] e12 = e(obtainStyledAttributes, com.ruffian.library.widget.R.styleable.RBaseView_background_unable);
            this.f١٦٠٥٠y = ((Integer) e12[1]).intValue();
            this.D = (int[]) e12[2];
            this.N = (Drawable) e12[3];
            Object[] e13 = e(obtainStyledAttributes, com.ruffian.library.widget.R.styleable.RBaseView_background_checked);
            this.f١٦٠٥٢z = ((Integer) e13[1]).intValue();
            this.E = (int[]) e13[2];
            this.O = (Drawable) e13[3];
            Object[] e14 = e(obtainStyledAttributes, com.ruffian.library.widget.R.styleable.RBaseView_background_selected);
            this.A = ((Integer) e14[1]).intValue();
            this.F = (int[]) e14[2];
            this.P = (Drawable) e14[3];
            this.Q = obtainStyledAttributes.getInt(com.ruffian.library.widget.R.styleable.RBaseView_gradient_type, 0);
            this.U = f(obtainStyledAttributes);
            this.R = obtainStyledAttributes.getDimensionPixelSize(com.ruffian.library.widget.R.styleable.RBaseView_gradient_radius, -1);
            this.S = obtainStyledAttributes.getFloat(com.ruffian.library.widget.R.styleable.RBaseView_gradient_centerX, 0.5f);
            this.T = obtainStyledAttributes.getFloat(com.ruffian.library.widget.R.styleable.RBaseView_gradient_centerY, 0.5f);
            this.f١٦٠٠٣a0 = obtainStyledAttributes.getBoolean(com.ruffian.library.widget.R.styleable.RBaseView_enabled, true);
            this.f١٦٠٠٥b0 = obtainStyledAttributes.getBoolean(com.ruffian.library.widget.R.styleable.RBaseView_ripple, false);
            this.f١٦٠٠٧c0 = obtainStyledAttributes.getColor(com.ruffian.library.widget.R.styleable.RBaseView_ripple_color, -65536);
            this.f١٦٠٠٩d0 = obtainStyledAttributes.getDrawable(com.ruffian.library.widget.R.styleable.RBaseView_ripple_mask);
            this.f١٦٠١١e0 = obtainStyledAttributes.getInt(com.ruffian.library.widget.R.styleable.RBaseView_ripple_mask_style, 2);
            this.W = obtainStyledAttributes.getDimensionPixelSize(com.ruffian.library.widget.R.styleable.RBaseView_shadow_dx, 0);
            this.X = obtainStyledAttributes.getDimensionPixelSize(com.ruffian.library.widget.R.styleable.RBaseView_shadow_dy, 0);
            this.Y = obtainStyledAttributes.getColor(com.ruffian.library.widget.R.styleable.RBaseView_shadow_color, -7829368);
            this.Z = obtainStyledAttributes.getDimensionPixelSize(com.ruffian.library.widget.R.styleable.RBaseView_shadow_radius, -1);
            this.H0 = obtainStyledAttributes.getBoolean(com.ruffian.library.widget.R.styleable.RBaseView_clip_layout, false);
            obtainStyledAttributes.recycle();
            z();
            return;
        }
        z();
    }

    private void i() {
        this.G0.e(this.F0, this.H0, new b());
    }

    private boolean k() {
        return this.f١٦٠٠٥b0;
    }

    private void p() {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        if (this.f١٦٠٤٦w == 0 && this.f١٦٠٥٠y == 0 && this.f١٦٠٤٨x == 0 && this.f١٦٠٥٢z == 0 && this.A == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.f١٦٠٠١B == null && this.D == null && this.C == null && this.E == null && this.F == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (this.L == null && this.M == null && this.N == null && this.O == null && this.P == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z10 && z11 && z12) {
            z13 = false;
        } else {
            z13 = true;
        }
        if (this.f١٦٠٢٢k == -1.0f && this.f١٦٠٢٤l == -1.0f && this.f١٦٠٢٦m == -1 && this.f١٦٠٢٨n == -1 && this.f١٦٠٣٠o == -1 && this.f١٦٠٣٢p == -1 && this.f١٦٠٣٤q == -1 && this.f١٦٠٣٦r == 0 && this.f١٦٠٣٨s == 0 && this.f١٦٠٤٠t == 0 && this.f١٦٠٤٢u == 0 && this.f١٦٠٤٤v == 0) {
            z14 = false;
        } else {
            z14 = true;
        }
        if (this.f١٦٠١٢f == -1.0f && this.f١٦٠١٤g == DownloadProgress.UNKNOWN_PROGRESS && this.f١٦٠١٦h == DownloadProgress.UNKNOWN_PROGRESS && this.f١٦٠١٨i == DownloadProgress.UNKNOWN_PROGRESS && this.f١٦٠٢٠j == DownloadProgress.UNKNOWN_PROGRESS) {
            z15 = false;
        } else {
            z15 = true;
        }
        if (!z13 && !z15 && !z14) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && !F() && !E()) {
            this.f١٦٠٢١j0 = this.f١٦٠١٩i0;
        } else {
            this.f١٦٠٢١j0 = d(z16, this.f١٦٠٠٧c0);
            if (F()) {
                this.F0.setLayerType(1, null);
                if (this.V == null) {
                    this.V = new oc.a();
                }
                this.V.c(this.Y, this.Z, this.W, this.X, this.f١٦٠٢٧m0);
                int a10 = (int) this.V.a();
                int abs = a10 + Math.abs(this.W);
                int abs2 = a10 + Math.abs(this.W);
                int abs3 = a10 + Math.abs(this.X);
                int abs4 = a10 + Math.abs(this.X);
                LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.V, this.f١٦٠٢١j0});
                layerDrawable.setLayerInset(1, abs, abs3, abs2, abs4);
                this.f١٦٠٢١j0 = layerDrawable;
            }
        }
        this.F0.setBackground(this.f١٦٠٢١j0);
    }

    private void q() {
        this.G.setStroke(this.f١٦٠٢٦m, this.f١٦٠٣٦r, this.f١٦٠٢٢k, this.f١٦٠٢٤l);
        this.H.setStroke(this.f١٦٠٢٨n, this.f١٦٠٣٨s, this.f١٦٠٢٢k, this.f١٦٠٢٤l);
        this.I.setStroke(this.f١٦٠٣٠o, this.f١٦٠٤٠t, this.f١٦٠٢٢k, this.f١٦٠٢٤l);
        this.J.setStroke(this.f١٦٠٣٢p, this.f١٦٠٤٢u, this.f١٦٠٢٢k, this.f١٦٠٢٤l);
        this.K.setStroke(this.f١٦٠٣٤q, this.f١٦٠٤٤v, this.f١٦٠٢٢k, this.f١٦٠٢٤l);
    }

    private GradientDrawable t(GradientDrawable gradientDrawable, int[] iArr) {
        if (gradientDrawable == null) {
            gradientDrawable = new GradientDrawable();
        }
        gradientDrawable.setOrientation(this.U);
        gradientDrawable.setColors(iArr);
        return gradientDrawable;
    }

    private void v() {
        this.G.setGradientType(this.Q);
        this.G.setGradientRadius(this.R);
        this.G.setGradientCenter(this.S, this.T);
        this.H.setGradientType(this.Q);
        this.H.setGradientRadius(this.R);
        this.H.setGradientCenter(this.S, this.T);
        this.I.setGradientType(this.Q);
        this.I.setGradientRadius(this.R);
        this.I.setGradientCenter(this.S, this.T);
        this.J.setGradientType(this.Q);
        this.J.setGradientRadius(this.R);
        this.J.setGradientCenter(this.S, this.T);
        this.K.setGradientType(this.Q);
        this.K.setGradientRadius(this.R);
        this.K.setGradientCenter(this.S, this.T);
    }

    private void x() {
        float f10 = this.f١٦٠١٢f;
        if (f10 >= DownloadProgress.UNKNOWN_PROGRESS) {
            float[] fArr = this.f١٦٠٢٧m0;
            fArr[0] = f10;
            fArr[1] = f10;
            fArr[2] = f10;
            fArr[3] = f10;
            fArr[4] = f10;
            fArr[5] = f10;
            fArr[6] = f10;
            fArr[7] = f10;
        } else {
            float[] fArr2 = this.f١٦٠٢٧m0;
            float f11 = this.f١٦٠١٤g;
            fArr2[0] = f11;
            fArr2[1] = f11;
            float f12 = this.f١٦٠١٦h;
            fArr2[2] = f12;
            fArr2[3] = f12;
            float f13 = this.f١٦٠٢٠j;
            fArr2[4] = f13;
            fArr2[5] = f13;
            float f14 = this.f١٦٠١٨i;
            fArr2[6] = f14;
            fArr2[7] = f14;
        }
        this.G.setCornerRadii(this.f١٦٠٢٧m0);
        this.H.setCornerRadii(this.f١٦٠٢٧m0);
        this.I.setCornerRadii(this.f١٦٠٢٧m0);
        this.J.setCornerRadii(this.f١٦٠٢٧m0);
        this.K.setCornerRadii(this.f١٦٠٢٧m0);
    }

    private void y() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.f١٦٠٢٥l0 = stateListDrawable;
        int[] iArr = this.f١٦٠٢٣k0[0];
        Drawable drawable = this.N;
        if (drawable == null) {
            drawable = this.I;
        }
        stateListDrawable.addState(iArr, drawable);
        StateListDrawable stateListDrawable2 = this.f١٦٠٢٥l0;
        int[] iArr2 = this.f١٦٠٢٣k0[1];
        Drawable drawable2 = this.M;
        if (drawable2 == null) {
            drawable2 = this.H;
        }
        stateListDrawable2.addState(iArr2, drawable2);
        StateListDrawable stateListDrawable3 = this.f١٦٠٢٥l0;
        int[] iArr3 = this.f١٦٠٢٣k0[2];
        Drawable drawable3 = this.M;
        if (drawable3 == null) {
            drawable3 = this.H;
        }
        stateListDrawable3.addState(iArr3, drawable3);
        StateListDrawable stateListDrawable4 = this.f١٦٠٢٥l0;
        int[] iArr4 = this.f١٦٠٢٣k0[3];
        Drawable drawable4 = this.O;
        if (drawable4 == null) {
            drawable4 = this.J;
        }
        stateListDrawable4.addState(iArr4, drawable4);
        StateListDrawable stateListDrawable5 = this.f١٦٠٢٥l0;
        int[] iArr5 = this.f١٦٠٢٣k0[4];
        Drawable drawable5 = this.P;
        if (drawable5 == null) {
            drawable5 = this.K;
        }
        stateListDrawable5.addState(iArr5, drawable5);
        StateListDrawable stateListDrawable6 = this.f١٦٠٢٥l0;
        int[] iArr6 = this.f١٦٠٢٣k0[5];
        Drawable drawable6 = this.L;
        if (drawable6 == null) {
            drawable6 = this.G;
        }
        stateListDrawable6.addState(iArr6, drawable6);
    }

    private void z() {
        if (this.F0.isEnabled()) {
            this.F0.setEnabled(this.f١٦٠٠٣a0);
        }
        this.G = new GradientDrawable();
        this.H = new GradientDrawable();
        this.I = new GradientDrawable();
        this.J = new GradientDrawable();
        this.K = new GradientDrawable();
        this.f١٦٠١٩i0 = this.F0.getBackground();
        this.f١٦٠٢٥l0 = new StateListDrawable();
        if (F()) {
            this.V = new oc.a();
        }
        int[][] iArr = this.f١٦٠٢٣k0;
        iArr[0] = new int[]{-16842910};
        iArr[1] = new int[]{R.attr.state_focused};
        iArr[2] = new int[]{R.attr.state_pressed};
        iArr[3] = new int[]{R.attr.state_checked};
        iArr[4] = new int[]{R.attr.state_selected};
        iArr[5] = new int[]{R.attr.state_enabled};
        A(true);
        v();
        y();
        q();
        x();
        p();
    }

    public boolean E() {
        return this.f١٦٠٠٥b0;
    }

    public boolean F() {
        return false;
    }

    public void c(Canvas canvas) {
        this.G0.c(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean j(int i10, int i11) {
        if (i10 >= 0 - this.f١٦٠٢٩n0) {
            int width = this.F0.getWidth();
            int i12 = this.f١٦٠٢٩n0;
            if (i10 < width + i12 && i11 >= 0 - i12 && i11 < this.F0.getHeight() + this.f١٦٠٢٩n0) {
                return false;
            }
        }
        return true;
    }

    public void l(boolean z10, int i10, int i11, int i12, int i13) {
        this.G0.f(z10, i10, i11, i12, i13);
    }

    public a m(int i10) {
        this.f١٦٠٤٦w = i10;
        this.f١٦٠٠١B = null;
        this.L = null;
        B();
        return this;
    }

    public a n(int[] iArr) {
        this.f١٦٠٠١B = iArr;
        this.f١٦٠٤٦w = 0;
        this.L = null;
        B();
        return this;
    }

    public a o(int i10) {
        this.f١٦٠٥٠y = i10;
        this.D = null;
        this.N = null;
        this.f١٦٠٣٧r0 = true;
        this.f١٦٠٣٩s0 = false;
        B();
        return this;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.F0.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        if (this.R <= DownloadProgress.UNKNOWN_PROGRESS) {
            w(Math.min(this.F0.getWidth(), this.F0.getHeight()) / 2.0f);
        }
        i();
    }

    public a r(int i10) {
        this.f١٦٠٣٦r = i10;
        C();
        return this;
    }

    public a s(int i10) {
        this.f١٦٠٢٦m = i10;
        C();
        return this;
    }

    public void u(float f10) {
        this.f١٦٠١٢f = f10;
        D();
    }

    public a w(float f10) {
        this.R = f10;
        v();
        p();
        return this;
    }
}
