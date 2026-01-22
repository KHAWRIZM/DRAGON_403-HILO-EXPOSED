package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import androidx.appcompat.R;
import androidx.core.view.d1;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class d {

    /* renamed from: a, reason: collision with root package name */
    private final CheckedTextView f١٤٨١a;

    /* renamed from: b, reason: collision with root package name */
    private ColorStateList f١٤٨٢b = null;

    /* renamed from: c, reason: collision with root package name */
    private PorterDuff.Mode f١٤٨٣c = null;

    /* renamed from: d, reason: collision with root package name */
    private boolean f١٤٨٤d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f١٤٨٥e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f١٤٨٦f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(CheckedTextView checkedTextView) {
        this.f١٤٨١a = checkedTextView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        Drawable a10 = androidx.core.widget.b.a(this.f١٤٨١a);
        if (a10 != null) {
            if (this.f١٤٨٤d || this.f١٤٨٥e) {
                Drawable mutate = h2.b.r(a10).mutate();
                if (this.f١٤٨٤d) {
                    h2.b.o(mutate, this.f١٤٨٢b);
                }
                if (this.f١٤٨٥e) {
                    h2.b.p(mutate, this.f١٤٨٣c);
                }
                if (mutate.isStateful()) {
                    mutate.setState(this.f١٤٨١a.getDrawableState());
                }
                this.f١٤٨١a.setCheckMarkDrawable(mutate);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList b() {
        return this.f١٤٨٢b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode c() {
        return this.f١٤٨٣c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x005e A[Catch: all -> 0x0039, TryCatch #1 {all -> 0x0039, blocks: (B:3:0x001d, B:5:0x0025, B:8:0x002b, B:9:0x0056, B:11:0x005e, B:12:0x0067, B:14:0x006f, B:21:0x003b, B:23:0x0043, B:25:0x0049), top: B:2:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006f A[Catch: all -> 0x0039, TRY_LEAVE, TryCatch #1 {all -> 0x0039, blocks: (B:3:0x001d, B:5:0x0025, B:8:0x002b, B:9:0x0056, B:11:0x005e, B:12:0x0067, B:14:0x006f, B:21:0x003b, B:23:0x0043, B:25:0x0049), top: B:2:0x001d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(AttributeSet attributeSet, int i10) {
        int n10;
        int i11;
        int i12;
        int n11;
        Context context = this.f١٤٨١a.getContext();
        int[] iArr = R.styleable.CheckedTextView;
        p0 v10 = p0.v(context, attributeSet, iArr, i10, 0);
        CheckedTextView checkedTextView = this.f١٤٨١a;
        d1.o0(checkedTextView, checkedTextView.getContext(), iArr, attributeSet, v10.r(), i10, 0);
        try {
            int i13 = R.styleable.CheckedTextView_checkMarkCompat;
            if (v10.s(i13) && (n11 = v10.n(i13, 0)) != 0) {
                try {
                    CheckedTextView checkedTextView2 = this.f١٤٨١a;
                    checkedTextView2.setCheckMarkDrawable(r1.a.b(checkedTextView2.getContext(), n11));
                } catch (Resources.NotFoundException unused) {
                }
                i11 = R.styleable.CheckedTextView_checkMarkTint;
                if (v10.s(i11)) {
                    androidx.core.widget.b.b(this.f١٤٨١a, v10.c(i11));
                }
                i12 = R.styleable.CheckedTextView_checkMarkTintMode;
                if (v10.s(i12)) {
                    androidx.core.widget.b.c(this.f١٤٨١a, c0.e(v10.k(i12, -1), null));
                }
            }
            int i14 = R.styleable.CheckedTextView_android_checkMark;
            if (v10.s(i14) && (n10 = v10.n(i14, 0)) != 0) {
                CheckedTextView checkedTextView3 = this.f١٤٨١a;
                checkedTextView3.setCheckMarkDrawable(r1.a.b(checkedTextView3.getContext(), n10));
            }
            i11 = R.styleable.CheckedTextView_checkMarkTint;
            if (v10.s(i11)) {
            }
            i12 = R.styleable.CheckedTextView_checkMarkTintMode;
            if (v10.s(i12)) {
            }
        } finally {
            v10.x();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (this.f١٤٨٦f) {
            this.f١٤٨٦f = false;
        } else {
            this.f١٤٨٦f = true;
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ColorStateList colorStateList) {
        this.f١٤٨٢b = colorStateList;
        this.f١٤٨٤d = true;
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(PorterDuff.Mode mode) {
        this.f١٤٨٣c = mode;
        this.f١٤٨٥e = true;
        a();
    }
}
