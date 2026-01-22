package io.reactivex.rxjava3.core;

import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class o {

    /* renamed from: b, reason: collision with root package name */
    static final o f١٤٩٧٧b = new o(null);

    /* renamed from: a, reason: collision with root package name */
    final Object f١٤٩٧٨a;

    private o(Object obj) {
        this.f١٤٩٧٨a = obj;
    }

    public static o a() {
        return f١٤٩٧٧b;
    }

    public static o b(Throwable th) {
        Objects.requireNonNull(th, "error is null");
        return new o(fe.m.g(th));
    }

    public static o c(Object obj) {
        Objects.requireNonNull(obj, "value is null");
        return new o(obj);
    }

    public Throwable d() {
        Object obj = this.f١٤٩٧٨a;
        if (fe.m.k(obj)) {
            return fe.m.h(obj);
        }
        return null;
    }

    public Object e() {
        Object obj = this.f١٤٩٧٨a;
        if (obj != null && !fe.m.k(obj)) {
            return this.f١٤٩٧٨a;
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj instanceof o) {
            return Objects.equals(this.f١٤٩٧٨a, ((o) obj).f١٤٩٧٨a);
        }
        return false;
    }

    public boolean f() {
        if (this.f١٤٩٧٨a == null) {
            return true;
        }
        return false;
    }

    public boolean g() {
        return fe.m.k(this.f١٤٩٧٨a);
    }

    public boolean h() {
        Object obj = this.f١٤٩٧٨a;
        if (obj != null && !fe.m.k(obj)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        Object obj = this.f١٤٩٧٨a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public String toString() {
        Object obj = this.f١٤٩٧٨a;
        if (obj == null) {
            return "OnCompleteNotification";
        }
        if (fe.m.k(obj)) {
            return "OnErrorNotification[" + fe.m.h(obj) + "]";
        }
        return "OnNextNotification[" + this.f١٤٩٧٨a + "]";
    }
}
