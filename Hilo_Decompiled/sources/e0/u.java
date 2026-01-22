package e0;

import android.widget.ImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class u {

    /* renamed from: a, reason: collision with root package name */
    public final b f١٣٨٢٧a;

    /* renamed from: b, reason: collision with root package name */
    public final e0 f١٣٨٢٨b;

    /* renamed from: c, reason: collision with root package name */
    public final l f١٣٨٢٩c;

    /* renamed from: d, reason: collision with root package name */
    public final int f١٣٨٣٠d;

    /* renamed from: e, reason: collision with root package name */
    public final String f١٣٨٣١e;

    /* renamed from: f, reason: collision with root package name */
    public final u f١٣٨٣٢f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f١٣٨٣٣g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f١٣٨٣٤h;

    public u(b bVar, ImageView imageView, e0 e0Var, int i10, String str) {
        l lVar;
        this.f١٣٨٢٧a = bVar;
        this.f١٣٨٢٨b = e0Var;
        if (imageView == null) {
            lVar = null;
        } else {
            lVar = new l(this, imageView, bVar.f١٣٧٤٢h);
        }
        this.f١٣٨٢٩c = lVar;
        this.f١٣٨٣٠d = i10;
        this.f١٣٨٣١e = str;
        this.f١٣٨٣٢f = this;
    }

    public abstract void a();

    public final Object b() {
        l lVar = this.f١٣٨٢٩c;
        if (lVar == null) {
            return null;
        }
        return lVar.get();
    }
}
