package ke;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    final Object f١٥٥٦٩a;

    /* renamed from: b, reason: collision with root package name */
    final long f١٥٥٧٠b;

    /* renamed from: c, reason: collision with root package name */
    final TimeUnit f١٥٥٧١c;

    public b(Object obj, long j10, TimeUnit timeUnit) {
        Objects.requireNonNull(obj, "value is null");
        this.f١٥٥٦٩a = obj;
        this.f١٥٥٧٠b = j10;
        Objects.requireNonNull(timeUnit, "unit is null");
        this.f١٥٥٧١c = timeUnit;
    }

    public long a() {
        return this.f١٥٥٧٠b;
    }

    public Object b() {
        return this.f١٥٥٦٩a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!Objects.equals(this.f١٥٥٦٩a, bVar.f١٥٥٦٩a) || this.f١٥٥٧٠b != bVar.f١٥٥٧٠b || !Objects.equals(this.f١٥٥٧١c, bVar.f١٥٥٧١c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = this.f١٥٥٦٩a.hashCode() * 31;
        long j10 = this.f١٥٥٧٠b;
        return ((hashCode + ((int) (j10 ^ (j10 >>> 31)))) * 31) + this.f١٥٥٧١c.hashCode();
    }

    public String toString() {
        return "Timed[time=" + this.f١٥٥٧٠b + ", unit=" + this.f١٥٥٧١c + ", value=" + this.f١٥٥٦٩a + "]";
    }
}
