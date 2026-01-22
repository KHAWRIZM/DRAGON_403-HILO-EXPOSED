package com.google.android.material.badge;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import c8.c;
import c8.e;
import com.google.android.material.R;
import com.google.android.material.drawable.g;
import com.google.android.material.internal.h0;
import java.util.Locale;
import kotlin.KotlinVersion;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class BadgeState {

    /* renamed from: a, reason: collision with root package name */
    private final State f٨٢٤٠a;

    /* renamed from: b, reason: collision with root package name */
    private final State f٨٢٤١b;

    /* renamed from: c, reason: collision with root package name */
    final float f٨٢٤٢c;

    /* renamed from: d, reason: collision with root package name */
    final float f٨٢٤٣d;

    /* renamed from: e, reason: collision with root package name */
    final float f٨٢٤٤e;

    /* renamed from: f, reason: collision with root package name */
    final float f٨٢٤٥f;

    /* renamed from: g, reason: collision with root package name */
    final float f٨٢٤٦g;

    /* renamed from: h, reason: collision with root package name */
    final float f٨٢٤٧h;

    /* renamed from: i, reason: collision with root package name */
    final int f٨٢٤٨i;

    /* renamed from: j, reason: collision with root package name */
    final int f٨٢٤٩j;

    /* renamed from: k, reason: collision with root package name */
    int f٨٢٥٠k;

    /* renamed from: l, reason: collision with root package name */
    int f٨٢٥١l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BadgeState(Context context, int i10, int i11, int i12, State state) {
        CharSequence charSequence;
        int i13;
        int i14;
        int i15;
        int i16;
        int intValue;
        int intValue2;
        int intValue3;
        int intValue4;
        int intValue5;
        int intValue6;
        int intValue7;
        int intValue8;
        int intValue9;
        int intValue10;
        int intValue11;
        int intValue12;
        int intValue13;
        int intValue14;
        boolean booleanValue;
        Locale locale;
        Locale.Category category;
        State state2 = new State();
        this.f٨٢٤١b = state2;
        state = state == null ? new State() : state;
        if (i10 != 0) {
            state.f٨٢٥٣a = i10;
        }
        TypedArray a10 = a(context, state.f٨٢٥٣a, i11, i12);
        Resources resources = context.getResources();
        this.f٨٢٤٢c = a10.getDimensionPixelSize(R.styleable.Badge_badgeRadius, -1);
        this.f٨٢٤٨i = context.getResources().getDimensionPixelSize(R.dimen.mtrl_badge_horizontal_edge_offset);
        this.f٨٢٤٩j = context.getResources().getDimensionPixelSize(R.dimen.mtrl_badge_text_horizontal_edge_offset);
        this.f٨٢٤٣d = a10.getDimensionPixelSize(R.styleable.Badge_badgeWithTextRadius, -1);
        int i17 = R.styleable.Badge_badgeWidth;
        int i18 = R.dimen.m3_badge_size;
        this.f٨٢٤٤e = a10.getDimension(i17, resources.getDimension(i18));
        int i19 = R.styleable.Badge_badgeWithTextWidth;
        int i20 = R.dimen.m3_badge_with_text_size;
        this.f٨٢٤٦g = a10.getDimension(i19, resources.getDimension(i20));
        this.f٨٢٤٥f = a10.getDimension(R.styleable.Badge_badgeHeight, resources.getDimension(i18));
        this.f٨٢٤٧h = a10.getDimension(R.styleable.Badge_badgeWithTextHeight, resources.getDimension(i20));
        boolean z10 = true;
        this.f٨٢٥٠k = a10.getInt(R.styleable.Badge_offsetAlignmentMode, 1);
        this.f٨٢٥١l = a10.getInt(R.styleable.Badge_badgeFixedEdge, 0);
        state2.f٨٢٦١i = state.f٨٢٦١i == -2 ? KotlinVersion.MAX_COMPONENT_VALUE : state.f٨٢٦١i;
        if (state.f٨٢٦٣k != -2) {
            state2.f٨٢٦٣k = state.f٨٢٦٣k;
        } else {
            int i21 = R.styleable.Badge_number;
            if (a10.hasValue(i21)) {
                state2.f٨٢٦٣k = a10.getInt(i21, 0);
            } else {
                state2.f٨٢٦٣k = -1;
            }
        }
        if (state.f٨٢٦٢j != null) {
            state2.f٨٢٦٢j = state.f٨٢٦٢j;
        } else {
            int i22 = R.styleable.Badge_badgeText;
            if (a10.hasValue(i22)) {
                state2.f٨٢٦٢j = a10.getString(i22);
            }
        }
        state2.f٨٢٦٧o = state.f٨٢٦٧o;
        if (state.f٨٢٦٨p != null) {
            charSequence = state.f٨٢٦٨p;
        } else {
            charSequence = context.getString(R.string.mtrl_badge_numberless_content_description);
        }
        state2.f٨٢٦٨p = charSequence;
        if (state.f٨٢٦٩q != 0) {
            i13 = state.f٨٢٦٩q;
        } else {
            i13 = R.plurals.mtrl_badge_content_description;
        }
        state2.f٨٢٦٩q = i13;
        if (state.f٨٢٧٠r != 0) {
            i14 = state.f٨٢٧٠r;
        } else {
            i14 = R.string.mtrl_exceed_max_badge_number_content_description;
        }
        state2.f٨٢٧٠r = i14;
        if (state.f٨٢٧٢t != null && !state.f٨٢٧٢t.booleanValue()) {
            z10 = false;
        }
        state2.f٨٢٧٢t = Boolean.valueOf(z10);
        if (state.f٨٢٦٤l != -2) {
            i15 = state.f٨٢٦٤l;
        } else {
            i15 = a10.getInt(R.styleable.Badge_maxCharacterCount, -2);
        }
        state2.f٨٢٦٤l = i15;
        if (state.f٨٢٦٥m != -2) {
            i16 = state.f٨٢٦٥m;
        } else {
            i16 = a10.getInt(R.styleable.Badge_maxNumber, -2);
        }
        state2.f٨٢٦٥m = i16;
        if (state.f٨٢٥٧e != null) {
            intValue = state.f٨٢٥٧e.intValue();
        } else {
            intValue = a10.getResourceId(R.styleable.Badge_badgeShapeAppearance, R.style.ShapeAppearance_M3_Sys_Shape_Corner_Full);
        }
        state2.f٨٢٥٧e = Integer.valueOf(intValue);
        if (state.f٨٢٥٨f != null) {
            intValue2 = state.f٨٢٥٨f.intValue();
        } else {
            intValue2 = a10.getResourceId(R.styleable.Badge_badgeShapeAppearanceOverlay, 0);
        }
        state2.f٨٢٥٨f = Integer.valueOf(intValue2);
        if (state.f٨٢٥٩g != null) {
            intValue3 = state.f٨٢٥٩g.intValue();
        } else {
            intValue3 = a10.getResourceId(R.styleable.Badge_badgeWithTextShapeAppearance, R.style.ShapeAppearance_M3_Sys_Shape_Corner_Full);
        }
        state2.f٨٢٥٩g = Integer.valueOf(intValue3);
        if (state.f٨٢٦٠h != null) {
            intValue4 = state.f٨٢٦٠h.intValue();
        } else {
            intValue4 = a10.getResourceId(R.styleable.Badge_badgeWithTextShapeAppearanceOverlay, 0);
        }
        state2.f٨٢٦٠h = Integer.valueOf(intValue4);
        if (state.f٨٢٥٤b != null) {
            intValue5 = state.f٨٢٥٤b.intValue();
        } else {
            intValue5 = H(context, a10, R.styleable.Badge_backgroundColor);
        }
        state2.f٨٢٥٤b = Integer.valueOf(intValue5);
        if (state.f٨٢٥٦d != null) {
            intValue6 = state.f٨٢٥٦d.intValue();
        } else {
            intValue6 = a10.getResourceId(R.styleable.Badge_badgeTextAppearance, R.style.TextAppearance_MaterialComponents_Badge);
        }
        state2.f٨٢٥٦d = Integer.valueOf(intValue6);
        if (state.f٨٢٥٥c != null) {
            state2.f٨٢٥٥c = state.f٨٢٥٥c;
        } else {
            int i23 = R.styleable.Badge_badgeTextColor;
            if (a10.hasValue(i23)) {
                state2.f٨٢٥٥c = Integer.valueOf(H(context, a10, i23));
            } else {
                state2.f٨٢٥٥c = Integer.valueOf(new e(context, state2.f٨٢٥٦d.intValue()).j().getDefaultColor());
            }
        }
        if (state.f٨٢٧١s != null) {
            intValue7 = state.f٨٢٧١s.intValue();
        } else {
            intValue7 = a10.getInt(R.styleable.Badge_badgeGravity, 8388661);
        }
        state2.f٨٢٧١s = Integer.valueOf(intValue7);
        if (state.f٨٢٧٣u != null) {
            intValue8 = state.f٨٢٧٣u.intValue();
        } else {
            intValue8 = a10.getDimensionPixelSize(R.styleable.Badge_badgeWidePadding, resources.getDimensionPixelSize(R.dimen.mtrl_badge_long_text_horizontal_padding));
        }
        state2.f٨٢٧٣u = Integer.valueOf(intValue8);
        if (state.f٨٢٧٤v != null) {
            intValue9 = state.f٨٢٧٤v.intValue();
        } else {
            intValue9 = a10.getDimensionPixelSize(R.styleable.Badge_badgeVerticalPadding, resources.getDimensionPixelSize(R.dimen.m3_badge_with_text_vertical_padding));
        }
        state2.f٨٢٧٤v = Integer.valueOf(intValue9);
        if (state.f٨٢٧٥w != null) {
            intValue10 = state.f٨٢٧٥w.intValue();
        } else {
            intValue10 = a10.getDimensionPixelOffset(R.styleable.Badge_horizontalOffset, 0);
        }
        state2.f٨٢٧٥w = Integer.valueOf(intValue10);
        if (state.f٨٢٧٦x != null) {
            intValue11 = state.f٨٢٧٦x.intValue();
        } else {
            intValue11 = a10.getDimensionPixelOffset(R.styleable.Badge_verticalOffset, 0);
        }
        state2.f٨٢٧٦x = Integer.valueOf(intValue11);
        if (state.f٨٢٧٧y != null) {
            intValue12 = state.f٨٢٧٧y.intValue();
        } else {
            intValue12 = a10.getDimensionPixelOffset(R.styleable.Badge_horizontalOffsetWithText, state2.f٨٢٧٥w.intValue());
        }
        state2.f٨٢٧٧y = Integer.valueOf(intValue12);
        if (state.f٨٢٧٨z != null) {
            intValue13 = state.f٨٢٧٨z.intValue();
        } else {
            intValue13 = a10.getDimensionPixelOffset(R.styleable.Badge_verticalOffsetWithText, state2.f٨٢٧٦x.intValue());
        }
        state2.f٨٢٧٨z = Integer.valueOf(intValue13);
        if (state.C != null) {
            intValue14 = state.C.intValue();
        } else {
            intValue14 = a10.getDimensionPixelOffset(R.styleable.Badge_largeFontVerticalOffsetAdjustment, 0);
        }
        state2.C = Integer.valueOf(intValue14);
        state2.A = Integer.valueOf(state.A == null ? 0 : state.A.intValue());
        state2.f٨٢٥٢B = Integer.valueOf(state.f٨٢٥٢B == null ? 0 : state.f٨٢٥٢B.intValue());
        if (state.D != null) {
            booleanValue = state.D.booleanValue();
        } else {
            booleanValue = a10.getBoolean(R.styleable.Badge_autoAdjustToWithinGrandparentBounds, false);
        }
        state2.D = Boolean.valueOf(booleanValue);
        a10.recycle();
        if (state.f٨٢٦٦n != null) {
            state2.f٨٢٦٦n = state.f٨٢٦٦n;
        } else {
            if (Build.VERSION.SDK_INT >= 24) {
                category = Locale.Category.FORMAT;
                locale = Locale.getDefault(category);
            } else {
                locale = Locale.getDefault();
            }
            state2.f٨٢٦٦n = locale;
        }
        this.f٨٢٤٠a = state;
    }

    private static int H(Context context, TypedArray typedArray, int i10) {
        return c.a(context, typedArray, i10).getDefaultColor();
    }

    private TypedArray a(Context context, int i10, int i11, int i12) {
        AttributeSet attributeSet;
        int i13;
        int i14;
        if (i10 != 0) {
            AttributeSet k10 = g.k(context, i10, "badge");
            i13 = k10.getStyleAttribute();
            attributeSet = k10;
        } else {
            attributeSet = null;
            i13 = 0;
        }
        if (i13 == 0) {
            i14 = i12;
        } else {
            i14 = i13;
        }
        return h0.i(context, attributeSet, R.styleable.Badge, i11, i14, new int[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int A() {
        return this.f٨٢٤١b.f٨٢٥٦d.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int B() {
        return this.f٨٢٤١b.f٨٢٧٨z.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int C() {
        return this.f٨٢٤١b.f٨٢٧٦x.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean D() {
        if (this.f٨٢٤١b.f٨٢٦٣k != -1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean E() {
        if (this.f٨٢٤١b.f٨٢٦٢j != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean F() {
        return this.f٨٢٤١b.D.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean G() {
        return this.f٨٢٤١b.f٨٢٧٢t.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(int i10) {
        this.f٨٢٤٠a.f٨٢٦١i = i10;
        this.f٨٢٤١b.f٨٢٦١i = i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f٨٢٤١b.A.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f٨٢٤١b.f٨٢٥٢B.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f٨٢٤١b.f٨٢٦١i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f٨٢٤١b.f٨٢٥٤b.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f٨٢٤١b.f٨٢٧١s.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f٨٢٤١b.f٨٢٧٣u.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return this.f٨٢٤١b.f٨٢٥٨f.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return this.f٨٢٤١b.f٨٢٥٧e.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return this.f٨٢٤١b.f٨٢٥٥c.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        return this.f٨٢٤١b.f٨٢٧٤v.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int l() {
        return this.f٨٢٤١b.f٨٢٦٠h.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m() {
        return this.f٨٢٤١b.f٨٢٥٩g.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int n() {
        return this.f٨٢٤١b.f٨٢٧٠r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence o() {
        return this.f٨٢٤١b.f٨٢٦٧o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence p() {
        return this.f٨٢٤١b.f٨٢٦٨p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int q() {
        return this.f٨٢٤١b.f٨٢٦٩q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int r() {
        return this.f٨٢٤١b.f٨٢٧٧y.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int s() {
        return this.f٨٢٤١b.f٨٢٧٥w.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int t() {
        return this.f٨٢٤١b.C.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int u() {
        return this.f٨٢٤١b.f٨٢٦٤l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int v() {
        return this.f٨٢٤١b.f٨٢٦٥m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int w() {
        return this.f٨٢٤١b.f٨٢٦٣k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Locale x() {
        return this.f٨٢٤١b.f٨٢٦٦n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public State y() {
        return this.f٨٢٤٠a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String z() {
        return this.f٨٢٤١b.f٨٢٦٢j;
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class State implements Parcelable {
        public static final Parcelable.Creator<State> CREATOR = new a();
        private Integer A;

        /* renamed from: B, reason: collision with root package name */
        private Integer f٨٢٥٢B;
        private Integer C;
        private Boolean D;
        private Integer E;

        /* renamed from: a, reason: collision with root package name */
        private int f٨٢٥٣a;

        /* renamed from: b, reason: collision with root package name */
        private Integer f٨٢٥٤b;

        /* renamed from: c, reason: collision with root package name */
        private Integer f٨٢٥٥c;

        /* renamed from: d, reason: collision with root package name */
        private Integer f٨٢٥٦d;

        /* renamed from: e, reason: collision with root package name */
        private Integer f٨٢٥٧e;

        /* renamed from: f, reason: collision with root package name */
        private Integer f٨٢٥٨f;

        /* renamed from: g, reason: collision with root package name */
        private Integer f٨٢٥٩g;

        /* renamed from: h, reason: collision with root package name */
        private Integer f٨٢٦٠h;

        /* renamed from: i, reason: collision with root package name */
        private int f٨٢٦١i;

        /* renamed from: j, reason: collision with root package name */
        private String f٨٢٦٢j;

        /* renamed from: k, reason: collision with root package name */
        private int f٨٢٦٣k;

        /* renamed from: l, reason: collision with root package name */
        private int f٨٢٦٤l;

        /* renamed from: m, reason: collision with root package name */
        private int f٨٢٦٥m;

        /* renamed from: n, reason: collision with root package name */
        private Locale f٨٢٦٦n;

        /* renamed from: o, reason: collision with root package name */
        private CharSequence f٨٢٦٧o;

        /* renamed from: p, reason: collision with root package name */
        private CharSequence f٨٢٦٨p;

        /* renamed from: q, reason: collision with root package name */
        private int f٨٢٦٩q;

        /* renamed from: r, reason: collision with root package name */
        private int f٨٢٧٠r;

        /* renamed from: s, reason: collision with root package name */
        private Integer f٨٢٧١s;

        /* renamed from: t, reason: collision with root package name */
        private Boolean f٨٢٧٢t;

        /* renamed from: u, reason: collision with root package name */
        private Integer f٨٢٧٣u;

        /* renamed from: v, reason: collision with root package name */
        private Integer f٨٢٧٤v;

        /* renamed from: w, reason: collision with root package name */
        private Integer f٨٢٧٥w;

        /* renamed from: x, reason: collision with root package name */
        private Integer f٨٢٧٦x;

        /* renamed from: y, reason: collision with root package name */
        private Integer f٨٢٧٧y;

        /* renamed from: z, reason: collision with root package name */
        private Integer f٨٢٧٨z;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public State createFromParcel(Parcel parcel) {
                return new State(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public State[] newArray(int i10) {
                return new State[i10];
            }
        }

        public State() {
            this.f٨٢٦١i = KotlinVersion.MAX_COMPONENT_VALUE;
            this.f٨٢٦٣k = -2;
            this.f٨٢٦٤l = -2;
            this.f٨٢٦٥m = -2;
            this.f٨٢٧٢t = Boolean.TRUE;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            String str;
            parcel.writeInt(this.f٨٢٥٣a);
            parcel.writeSerializable(this.f٨٢٥٤b);
            parcel.writeSerializable(this.f٨٢٥٥c);
            parcel.writeSerializable(this.f٨٢٥٦d);
            parcel.writeSerializable(this.f٨٢٥٧e);
            parcel.writeSerializable(this.f٨٢٥٨f);
            parcel.writeSerializable(this.f٨٢٥٩g);
            parcel.writeSerializable(this.f٨٢٦٠h);
            parcel.writeInt(this.f٨٢٦١i);
            parcel.writeString(this.f٨٢٦٢j);
            parcel.writeInt(this.f٨٢٦٣k);
            parcel.writeInt(this.f٨٢٦٤l);
            parcel.writeInt(this.f٨٢٦٥m);
            CharSequence charSequence = this.f٨٢٦٧o;
            String str2 = null;
            if (charSequence != null) {
                str = charSequence.toString();
            } else {
                str = null;
            }
            parcel.writeString(str);
            CharSequence charSequence2 = this.f٨٢٦٨p;
            if (charSequence2 != null) {
                str2 = charSequence2.toString();
            }
            parcel.writeString(str2);
            parcel.writeInt(this.f٨٢٦٩q);
            parcel.writeSerializable(this.f٨٢٧١s);
            parcel.writeSerializable(this.f٨٢٧٣u);
            parcel.writeSerializable(this.f٨٢٧٤v);
            parcel.writeSerializable(this.f٨٢٧٥w);
            parcel.writeSerializable(this.f٨٢٧٦x);
            parcel.writeSerializable(this.f٨٢٧٧y);
            parcel.writeSerializable(this.f٨٢٧٨z);
            parcel.writeSerializable(this.C);
            parcel.writeSerializable(this.A);
            parcel.writeSerializable(this.f٨٢٥٢B);
            parcel.writeSerializable(this.f٨٢٧٢t);
            parcel.writeSerializable(this.f٨٢٦٦n);
            parcel.writeSerializable(this.D);
            parcel.writeSerializable(this.E);
        }

        State(Parcel parcel) {
            this.f٨٢٦١i = KotlinVersion.MAX_COMPONENT_VALUE;
            this.f٨٢٦٣k = -2;
            this.f٨٢٦٤l = -2;
            this.f٨٢٦٥m = -2;
            this.f٨٢٧٢t = Boolean.TRUE;
            this.f٨٢٥٣a = parcel.readInt();
            this.f٨٢٥٤b = (Integer) parcel.readSerializable();
            this.f٨٢٥٥c = (Integer) parcel.readSerializable();
            this.f٨٢٥٦d = (Integer) parcel.readSerializable();
            this.f٨٢٥٧e = (Integer) parcel.readSerializable();
            this.f٨٢٥٨f = (Integer) parcel.readSerializable();
            this.f٨٢٥٩g = (Integer) parcel.readSerializable();
            this.f٨٢٦٠h = (Integer) parcel.readSerializable();
            this.f٨٢٦١i = parcel.readInt();
            this.f٨٢٦٢j = parcel.readString();
            this.f٨٢٦٣k = parcel.readInt();
            this.f٨٢٦٤l = parcel.readInt();
            this.f٨٢٦٥m = parcel.readInt();
            this.f٨٢٦٧o = parcel.readString();
            this.f٨٢٦٨p = parcel.readString();
            this.f٨٢٦٩q = parcel.readInt();
            this.f٨٢٧١s = (Integer) parcel.readSerializable();
            this.f٨٢٧٣u = (Integer) parcel.readSerializable();
            this.f٨٢٧٤v = (Integer) parcel.readSerializable();
            this.f٨٢٧٥w = (Integer) parcel.readSerializable();
            this.f٨٢٧٦x = (Integer) parcel.readSerializable();
            this.f٨٢٧٧y = (Integer) parcel.readSerializable();
            this.f٨٢٧٨z = (Integer) parcel.readSerializable();
            this.C = (Integer) parcel.readSerializable();
            this.A = (Integer) parcel.readSerializable();
            this.f٨٢٥٢B = (Integer) parcel.readSerializable();
            this.f٨٢٧٢t = (Boolean) parcel.readSerializable();
            this.f٨٢٦٦n = (Locale) parcel.readSerializable();
            this.D = (Boolean) parcel.readSerializable();
            this.E = (Integer) parcel.readSerializable();
        }
    }
}
