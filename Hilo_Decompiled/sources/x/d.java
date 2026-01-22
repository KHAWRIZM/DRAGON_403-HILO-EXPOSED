package x;

import android.net.Uri;
import java.io.File;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public boolean f١٨٨٢٥a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f١٨٨٢٦b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f١٨٨٢٧c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f١٨٨٢٨d;

    /* renamed from: e, reason: collision with root package name */
    public final n0.e f١٨٨٢٩e;

    /* renamed from: f, reason: collision with root package name */
    public final r0.g f١٨٨٣٠f;

    /* renamed from: g, reason: collision with root package name */
    public final long f١٨٨٣١g;

    public d(n0.e eVar, r0.g gVar, long j10) {
        this.f١٨٨٢٩e = eVar;
        this.f١٨٨٣٠f = gVar;
        this.f١٨٨٣١g = j10;
    }

    public final void a() {
        File h10;
        boolean z10;
        boolean z11;
        Uri uri = this.f١٨٨٢٩e.f١٦١١٥d;
        boolean z12 = false;
        if (!uri.getScheme().equals("content") ? !((h10 = this.f١٨٨٢٩e.h()) == null || !h10.exists()) : l0.d.a(uri) > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f١٨٨٢٦b = z10;
        int size = this.f١٨٨٣٠f.f١٧٢٨٨g.size();
        if (size > 0) {
            r0.g gVar = this.f١٨٨٣٠f;
            if (!gVar.f١٧٢٩٠i && gVar.d() != null) {
                if (this.f١٨٨٣٠f.d().equals(this.f١٨٨٢٩e.h()) && this.f١٨٨٣٠f.d().length() <= this.f١٨٨٣٠f.c() && (this.f١٨٨٣١g <= 0 || this.f١٨٨٣٠f.c() == this.f١٨٨٣١g)) {
                    for (int i10 = 0; i10 < size; i10++) {
                        if (((r0.e) this.f١٨٨٣٠f.f١٧٢٨٨g.get(i10)).f١٧٢٧٨b > 0) {
                        }
                    }
                    z11 = true;
                    this.f١٨٨٢٧c = z11;
                    g0.f fVar = n0.f.a().f١٦١٤١e;
                    this.f١٨٨٢٨d = true;
                    if (this.f١٨٨٢٧c || !this.f١٨٨٢٦b) {
                        z12 = true;
                    }
                    this.f١٨٨٢٥a = z12;
                }
            }
        }
        z11 = false;
        this.f١٨٨٢٧c = z11;
        g0.f fVar2 = n0.f.a().f١٦١٤١e;
        this.f١٨٨٢٨d = true;
        if (this.f١٨٨٢٧c) {
        }
        z12 = true;
        this.f١٨٨٢٥a = z12;
    }

    public final String toString() {
        return "fileExist[" + this.f١٨٨٢٦b + "] infoRight[" + this.f١٨٨٢٧c + "] outputStreamSupport[" + this.f١٨٨٢٨d + "] " + super.toString();
    }
}
