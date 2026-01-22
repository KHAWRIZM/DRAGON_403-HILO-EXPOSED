package com.qmuiteam.qmui.widget.tab;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import com.qmuiteam.qmui.R;
import ic.i;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class c {
    private int A;
    private int C;

    /* renamed from: b, reason: collision with root package name */
    private Drawable f١٣٣٩٧b;

    /* renamed from: d, reason: collision with root package name */
    private Drawable f١٣٣٩٩d;

    /* renamed from: i, reason: collision with root package name */
    private int f١٣٤٠٤i;

    /* renamed from: j, reason: collision with root package name */
    private int f١٣٤٠٥j;

    /* renamed from: q, reason: collision with root package name */
    private CharSequence f١٣٤١٢q;

    /* renamed from: r, reason: collision with root package name */
    private Typeface f١٣٤١٣r;

    /* renamed from: s, reason: collision with root package name */
    private Typeface f١٣٤١٤s;

    /* renamed from: z, reason: collision with root package name */
    private int f١٣٤٢١z;

    /* renamed from: a, reason: collision with root package name */
    private int f١٣٣٩٦a = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f١٣٣٩٨c = 0;

    /* renamed from: e, reason: collision with root package name */
    private boolean f١٣٤٠٠e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f١٣٤٠١f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f١٣٤٠٢g = true;

    /* renamed from: h, reason: collision with root package name */
    private boolean f١٣٤٠٣h = true;

    /* renamed from: k, reason: collision with root package name */
    private int f١٣٤٠٦k = R.attr.qmui_skin_support_tab_normal_color;

    /* renamed from: l, reason: collision with root package name */
    private int f١٣٤٠٧l = R.attr.qmui_skin_support_tab_selected_color;

    /* renamed from: m, reason: collision with root package name */
    private int f١٣٤٠٨m = 0;

    /* renamed from: n, reason: collision with root package name */
    private int f١٣٤٠٩n = 0;

    /* renamed from: o, reason: collision with root package name */
    private int f١٣٤١٠o = 1;

    /* renamed from: p, reason: collision with root package name */
    private int f١٣٤١١p = 17;

    /* renamed from: t, reason: collision with root package name */
    private int f١٣٤١٥t = -1;

    /* renamed from: u, reason: collision with root package name */
    int f١٣٤١٦u = -1;

    /* renamed from: v, reason: collision with root package name */
    float f١٣٤١٧v = 1.0f;

    /* renamed from: w, reason: collision with root package name */
    float f١٣٤١٨w = 0.25f;

    /* renamed from: x, reason: collision with root package name */
    private int f١٣٤١٩x = 0;

    /* renamed from: y, reason: collision with root package name */
    private int f١٣٤٢٠y = 2;

    /* renamed from: B, reason: collision with root package name */
    private int f١٣٣٩٥B = 0;
    private boolean D = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.C = ic.e.a(context, 2);
        int a10 = ic.e.a(context, 12);
        this.f١٣٤٠٥j = a10;
        this.f١٣٤٠٤i = a10;
        int a11 = ic.e.a(context, 3);
        this.f١٣٤٢١z = a11;
        this.A = a11;
    }

    public a a(Context context) {
        int i10;
        int i11;
        a aVar = new a(this.f١٣٤١٢q);
        if (!this.f١٣٤٠١f) {
            if (!this.f١٣٤٠٢g && (i11 = this.f١٣٣٩٦a) != 0) {
                this.f١٣٣٩٧b = i.f(context, i11);
            }
            if (!this.f١٣٤٠٣h && (i10 = this.f١٣٣٩٨c) != 0) {
                this.f١٣٣٩٩d = i.f(context, i10);
            }
        }
        aVar.f١٣٣٨٣p = this.f١٣٤٠١f;
        aVar.f١٣٣٨٤q = this.f١٣٤٠٢g;
        aVar.f١٣٣٨٥r = this.f١٣٤٠٣h;
        if (this.f١٣٣٩٧b != null) {
            if (!this.f١٣٤٠٠e && this.f١٣٣٩٩d != null) {
                aVar.f١٣٣٨٢o = new d(this.f١٣٣٩٧b, this.f١٣٣٩٩d, false);
            } else {
                aVar.f١٣٣٨٢o = new d(this.f١٣٣٩٧b, null, true);
                aVar.f١٣٣٨٥r = aVar.f١٣٣٨٤q;
            }
            aVar.f١٣٣٨٢o.setBounds(0, 0, this.f١٣٤١٥t, this.f١٣٤١٦u);
        }
        aVar.f١٣٣٨٦s = this.f١٣٣٩٦a;
        aVar.f١٣٣٨٧t = this.f١٣٣٩٨c;
        aVar.f١٣٣٧٩l = this.f١٣٤١٥t;
        aVar.f١٣٣٨٠m = this.f١٣٤١٦u;
        aVar.f١٣٣٨١n = this.f١٣٤١٧v;
        aVar.f١٣٣٩١x = this.f١٣٤١١p;
        aVar.f١٣٣٩٠w = this.f١٣٤١٠o;
        aVar.f١٣٣٧٠c = this.f١٣٤٠٤i;
        aVar.f١٣٣٧١d = this.f١٣٤٠٥j;
        aVar.f١٣٣٧٢e = this.f١٣٤١٣r;
        aVar.f١٣٣٧٣f = this.f١٣٤١٤s;
        aVar.f١٣٣٧٧j = this.f١٣٤٠٦k;
        aVar.f١٣٣٧٨k = this.f١٣٤٠٧l;
        aVar.f١٣٣٧٥h = this.f١٣٤٠٨m;
        aVar.f١٣٣٧٦i = this.f١٣٤٠٩n;
        aVar.D = this.f١٣٤١٩x;
        aVar.f١٣٣٩٣z = this.f١٣٤٢٠y;
        aVar.A = this.f١٣٤٢١z;
        aVar.C = this.f١٣٣٩٥B;
        aVar.f١٣٣٦٧B = this.A;
        aVar.f١٣٣٦٩b = this.C;
        aVar.f١٣٣٧٤g = this.f١٣٤١٨w;
        return aVar;
    }

    public c b(int i10) {
        this.f١٣٤١١p = i10;
        return this;
    }

    public c c(int i10) {
        this.f١٣٤١٠o = i10;
        return this;
    }

    public c d(CharSequence charSequence) {
        this.f١٣٤١٢q = charSequence;
        return this;
    }

    public c e(int i10, int i11) {
        this.f١٣٤٠٤i = i10;
        this.f١٣٤٠٥j = i11;
        return this;
    }
}
