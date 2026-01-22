package m0;

import android.os.SystemClock;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicLong;
import n0.f;
import w.o;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class c implements d {

    /* renamed from: a, reason: collision with root package name */
    public final InputStream f١٥٨٩٩a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f١٥٩٠٠b;

    /* renamed from: c, reason: collision with root package name */
    public final g0.b f١٥٩٠١c;

    /* renamed from: d, reason: collision with root package name */
    public final int f١٥٩٠٢d;

    /* renamed from: e, reason: collision with root package name */
    public final n0.e f١٥٩٠٣e;

    /* renamed from: f, reason: collision with root package name */
    public final o f١٥٩٠٤f = f.a().f١٦١٣٨b;

    public c(int i10, InputStream inputStream, g0.b bVar, n0.e eVar) {
        this.f١٥٩٠٢d = i10;
        this.f١٥٨٩٩a = inputStream;
        this.f١٥٩٠٠b = new byte[eVar.f١٦١١٩h];
        this.f١٥٩٠١c = bVar;
        this.f١٥٩٠٣e = eVar;
    }

    @Override // m0.d
    public final long a(x.b bVar) {
        if (!bVar.f١٨٨١١d.c()) {
            f.a().f١٦١٤٣g.c(bVar.f١٨٨٠٩b);
            int read = this.f١٥٨٩٩a.read(this.f١٥٩٠٠b);
            if (read == -1) {
                return read;
            }
            g0.b bVar2 = this.f١٥٩٠١c;
            int i10 = this.f١٥٩٠٢d;
            byte[] bArr = this.f١٥٩٠٠b;
            synchronized (bVar2) {
                if (!bVar2.f١٤٣٤٥e) {
                    ((g0.e) bVar2.e(i10)).f١٤٣٦٨c.write(bArr, 0, read);
                    long j10 = read;
                    bVar2.f١٤٣٤٣c.addAndGet(j10);
                    ((AtomicLong) bVar2.f١٤٣٤٢b.get(i10)).addAndGet(j10);
                    bVar2.g();
                }
            }
            long j11 = read;
            bVar.f١٨٨١٨k += j11;
            o oVar = this.f١٥٩٠٤f;
            n0.e eVar = this.f١٥٩٠٣e;
            oVar.getClass();
            long j12 = eVar.f١٦١٢٦o;
            long uptimeMillis = SystemClock.uptimeMillis();
            if (j12 <= 0 || uptimeMillis - eVar.f١٦١٢٨q.get() >= j12) {
                long j13 = bVar.f١٨٨١٨k;
                if (j13 != 0) {
                    bVar.f١٨٨٢٠m.f١٨٦٦٣a.c(bVar.f١٨٨٠٩b, bVar.f١٨٨٠٨a, j13);
                    bVar.f١٨٨١٨k = 0L;
                    return j11;
                }
            }
            return j11;
        }
        throw z.d.f١٩٣٢٧a;
    }
}
