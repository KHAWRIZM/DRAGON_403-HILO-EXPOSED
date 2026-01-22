package m0;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import n0.f;
import r0.g;
import z.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class a implements b, d {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f١٥٨٩٨a = Pattern.compile(".*\\d+ *- *(\\d+) */ *\\d+");

    @Override // m0.d
    public final long a(x.b bVar) {
        boolean z10;
        long j10 = bVar.f١٨٨١٦i;
        int i10 = bVar.f١٨٨٠٨a;
        if (j10 != -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        g0.b a10 = bVar.f١٨٨١١d.a();
        long j11 = 0;
        while (true) {
            try {
                if (bVar.f١٨٨١٥h == bVar.f١٨٨١٣f.size()) {
                    bVar.f١٨٨١٥h--;
                }
                long b10 = bVar.b();
                if (b10 == -1) {
                    break;
                }
                j11 += b10;
            } catch (Throwable th) {
                long j12 = bVar.f١٨٨١٨k;
                if (j12 != 0) {
                    bVar.f١٨٨٢٠m.f١٨٦٦٣a.c(bVar.f١٨٨٠٩b, bVar.f١٨٨٠٨a, j12);
                    bVar.f١٨٨١٨k = 0L;
                }
                if (!bVar.f١٨٨١١d.f١٨٨٥٢d) {
                    a10.h(i10);
                }
                throw th;
            }
        }
        long j13 = bVar.f١٨٨١٨k;
        if (j13 != 0) {
            bVar.f١٨٨٢٠m.f١٨٦٦٣a.c(bVar.f١٨٨٠٩b, bVar.f١٨٨٠٨a, j13);
            bVar.f١٨٨١٨k = 0L;
        }
        if (!bVar.f١٨٨١١d.f١٨٨٥٢d) {
            a10.h(i10);
        }
        if (z10) {
            r0.e eVar = (r0.e) a10.f١٤٣٤٩i.f١٧٢٨٨g.get(i10);
            if (eVar.f١٧٢٧٩c.get() == eVar.f١٧٢٧٨b) {
                if (j11 != j10) {
                    throw new IOException("Fetch-length isn't equal to the response content-length, " + j11 + "!= " + j10);
                }
            } else {
                throw new IOException("The current offset on block-info isn't update correct, " + eVar.f١٧٢٧٩c.get() + " != " + eVar.f١٧٢٧٨b + " on " + i10);
            }
        }
        return j11;
    }

    @Override // m0.b
    public final l1.a b(x.b bVar) {
        long j10;
        l1.a c10 = bVar.c();
        g gVar = bVar.f١٨٨١٠c;
        if (!bVar.f١٨٨١١d.c()) {
            boolean z10 = true;
            if (gVar.f١٧٢٨٨g.size() == 1 && !gVar.f١٧٢٩٠i) {
                l1.d dVar = (l1.d) c10;
                String a10 = dVar.a("Content-Range");
                long j11 = -1;
                if (!l0.d.d(a10)) {
                    Matcher matcher = f١٥٨٩٨a.matcher(a10);
                    if (matcher.find()) {
                        j10 = Long.parseLong(matcher.group(1));
                    } else {
                        j10 = -1;
                    }
                    if (j10 > 0) {
                        j11 = 1 + j10;
                    }
                }
                if (j11 < 0) {
                    String a11 = dVar.a("Content-Length");
                    if (!l0.d.d(a11)) {
                        j11 = Long.parseLong(a11);
                    }
                }
                long j12 = j11;
                long c11 = gVar.c();
                if (j12 > 0 && j12 != c11) {
                    r0.e eVar = (r0.e) gVar.f١٧٢٨٨g.get(0);
                    if (eVar.f١٧٢٧٩c.get() + eVar.f١٧٢٧٧a == 0) {
                        z10 = false;
                    }
                    r0.e eVar2 = new r0.e(0L, j12, 0L);
                    gVar.f١٧٢٨٨g.clear();
                    gVar.f١٧٢٨٨g.add(eVar2);
                    if (!z10) {
                        f.a().f١٦١٣٨b.f١٨٦٦٣a.g(bVar.f١٨٨٠٩b, gVar, 8);
                    } else {
                        throw new h();
                    }
                }
            }
            try {
                if (bVar.f١٨٨٢١n.c(gVar)) {
                    return c10;
                }
                throw new IOException("Update store failed!");
            } catch (Exception e10) {
                throw new IOException("Update store failed!", e10);
            }
        }
        throw z.d.f١٩٣٢٧a;
    }
}
