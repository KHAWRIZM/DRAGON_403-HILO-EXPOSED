package c8;

import android.graphics.Typeface;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class a extends g {

    /* renamed from: a, reason: collision with root package name */
    private final Typeface f٥٩٥٨a;

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC٠٠٧٢a f٥٩٥٩b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f٥٩٦٠c;

    /* renamed from: c8.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface InterfaceC٠٠٧٢a {
        void a(Typeface typeface);
    }

    public a(InterfaceC٠٠٧٢a r12, Typeface typeface) {
        this.f٥٩٥٨a = typeface;
        this.f٥٩٥٩b = r12;
    }

    private void d(Typeface typeface) {
        if (!this.f٥٩٦٠c) {
            this.f٥٩٥٩b.a(typeface);
        }
    }

    @Override // c8.g
    public void a(int i10) {
        d(this.f٥٩٥٨a);
    }

    @Override // c8.g
    public void b(Typeface typeface, boolean z10) {
        d(typeface);
    }

    public void c() {
        this.f٥٩٦٠c = true;
    }
}
