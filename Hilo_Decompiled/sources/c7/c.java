package c7;

import android.content.Context;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class c extends h {

    /* renamed from: a, reason: collision with root package name */
    private final Context f٥٩٣٦a;

    /* renamed from: b, reason: collision with root package name */
    private final l7.a f٥٩٣٧b;

    /* renamed from: c, reason: collision with root package name */
    private final l7.a f٥٩٣٨c;

    /* renamed from: d, reason: collision with root package name */
    private final String f٥٩٣٩d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, l7.a aVar, l7.a aVar2, String str) {
        if (context != null) {
            this.f٥٩٣٦a = context;
            if (aVar != null) {
                this.f٥٩٣٧b = aVar;
                if (aVar2 != null) {
                    this.f٥٩٣٨c = aVar2;
                    if (str != null) {
                        this.f٥٩٣٩d = str;
                        return;
                    }
                    throw new NullPointerException("Null backendName");
                }
                throw new NullPointerException("Null monotonicClock");
            }
            throw new NullPointerException("Null wallClock");
        }
        throw new NullPointerException("Null applicationContext");
    }

    @Override // c7.h
    public Context b() {
        return this.f٥٩٣٦a;
    }

    @Override // c7.h
    public String c() {
        return this.f٥٩٣٩d;
    }

    @Override // c7.h
    public l7.a d() {
        return this.f٥٩٣٨c;
    }

    @Override // c7.h
    public l7.a e() {
        return this.f٥٩٣٧b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f٥٩٣٦a.equals(hVar.b()) && this.f٥٩٣٧b.equals(hVar.e()) && this.f٥٩٣٨c.equals(hVar.d()) && this.f٥٩٣٩d.equals(hVar.c())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.f٥٩٣٦a.hashCode() ^ 1000003) * 1000003) ^ this.f٥٩٣٧b.hashCode()) * 1000003) ^ this.f٥٩٣٨c.hashCode()) * 1000003) ^ this.f٥٩٣٩d.hashCode();
    }

    public String toString() {
        return "CreationContext{applicationContext=" + this.f٥٩٣٦a + ", wallClock=" + this.f٥٩٣٧b + ", monotonicClock=" + this.f٥٩٣٨c + ", backendName=" + this.f٥٩٣٩d + "}";
    }
}
