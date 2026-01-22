package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import com.google.android.material.circularreveal.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface c extends b.a {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class b implements TypeEvaluator {

        /* renamed from: b, reason: collision with root package name */
        public static final TypeEvaluator f٨٧٩٦b = new b();

        /* renamed from: a, reason: collision with root package name */
        private final e f٨٧٩٧a = new e();

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e evaluate(float f10, e eVar, e eVar2) {
            this.f٨٧٩٧a.b(z7.a.f(eVar.f٨٨٠٠a, eVar2.f٨٨٠٠a, f10), z7.a.f(eVar.f٨٨٠١b, eVar2.f٨٨٠١b, f10), z7.a.f(eVar.f٨٨٠٢c, eVar2.f٨٨٠٢c, f10));
            return this.f٨٧٩٧a;
        }
    }

    /* renamed from: com.google.android.material.circularreveal.c$c, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class C٠١١١c extends Property {

        /* renamed from: a, reason: collision with root package name */
        public static final Property f٨٧٩٨a = new C٠١١١c("circularReveal");

        private C٠١١١c(String str) {
            super(e.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e get(c cVar) {
            return cVar.getRevealInfo();
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(c cVar, e eVar) {
            cVar.setRevealInfo(eVar);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class d extends Property {

        /* renamed from: a, reason: collision with root package name */
        public static final Property f٨٧٩٩a = new d("circularRevealScrimColor");

        private d(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(c cVar) {
            return Integer.valueOf(cVar.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(c cVar, Integer num) {
            cVar.setCircularRevealScrimColor(num.intValue());
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public float f٨٨٠٠a;

        /* renamed from: b, reason: collision with root package name */
        public float f٨٨٠١b;

        /* renamed from: c, reason: collision with root package name */
        public float f٨٨٠٢c;

        public boolean a() {
            if (this.f٨٨٠٢c == Float.MAX_VALUE) {
                return true;
            }
            return false;
        }

        public void b(float f10, float f11, float f12) {
            this.f٨٨٠٠a = f10;
            this.f٨٨٠١b = f11;
            this.f٨٨٠٢c = f12;
        }

        public void c(e eVar) {
            b(eVar.f٨٨٠٠a, eVar.f٨٨٠١b, eVar.f٨٨٠٢c);
        }

        private e() {
        }

        public e(float f10, float f11, float f12) {
            this.f٨٨٠٠a = f10;
            this.f٨٨٠١b = f11;
            this.f٨٨٠٢c = f12;
        }

        public e(e eVar) {
            this(eVar.f٨٨٠٠a, eVar.f٨٨٠١b, eVar.f٨٨٠٢c);
        }
    }

    void a();

    void b();

    int getCircularRevealScrimColor();

    e getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i10);

    void setRevealInfo(e eVar);
}
