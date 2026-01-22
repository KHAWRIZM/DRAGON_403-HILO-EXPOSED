package q4;

import java.io.File;
import q4.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class d implements a.InterfaceC٠٢١٠a {

    /* renamed from: a, reason: collision with root package name */
    private final long f١٧١٣٠a;

    /* renamed from: b, reason: collision with root package name */
    private final a f١٧١٣١b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface a {
        File a();
    }

    public d(a aVar, long j10) {
        this.f١٧١٣٠a = j10;
        this.f١٧١٣١b = aVar;
    }

    @Override // q4.a.InterfaceC٠٢١٠a
    public q4.a build() {
        File a10 = this.f١٧١٣١b.a();
        if (a10 == null) {
            return null;
        }
        if (!a10.isDirectory() && !a10.mkdirs()) {
            return null;
        }
        return e.c(a10, this.f١٧١٣٠a);
    }
}
