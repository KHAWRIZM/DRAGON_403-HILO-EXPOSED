package r0;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final long f١٧٢٧٧a;

    /* renamed from: b, reason: collision with root package name */
    public final long f١٧٢٧٨b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicLong f١٧٢٧٩c;

    public e(long j10, long j11, long j12) {
        if (j10 >= 0 && ((j11 >= 0 || j11 == -1) && j12 >= 0)) {
            this.f١٧٢٧٧a = j10;
            this.f١٧٢٧٨b = j11;
            this.f١٧٢٧٩c = new AtomicLong(j12);
            return;
        }
        throw new IllegalArgumentException();
    }

    public final String toString() {
        return "[" + this.f١٧٢٧٧a + ", " + ((this.f١٧٢٧٧a + this.f١٧٢٧٨b) - 1) + ")-current:" + this.f١٧٢٧٩c;
    }
}
