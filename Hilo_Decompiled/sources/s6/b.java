package s6;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class b implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private int f١٧٨٨٦a;

    /* renamed from: b, reason: collision with root package name */
    private int f١٧٨٨٧b;

    /* renamed from: c, reason: collision with root package name */
    private int f١٧٨٨٨c;

    public static b g(int i10, int i11, int i12) {
        b bVar = new b();
        bVar.f(i10);
        bVar.e(i11);
        bVar.d(i12);
        return bVar;
    }

    public static b h(Calendar calendar) {
        return g(calendar.get(1), calendar.get(2) + 1, calendar.get(5));
    }

    public static b j() {
        return h(Calendar.getInstance());
    }

    public static b k(int i10) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(1, i10);
        return h(calendar);
    }

    public int a() {
        return this.f١٧٨٨٨c;
    }

    public int b() {
        return this.f١٧٨٨٧b;
    }

    public int c() {
        return this.f١٧٨٨٦a;
    }

    public void d(int i10) {
        this.f١٧٨٨٨c = i10;
    }

    public void e(int i10) {
        this.f١٧٨٨٧b = i10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f١٧٨٨٦a == bVar.f١٧٨٨٦a && this.f١٧٨٨٧b == bVar.f١٧٨٨٧b && this.f١٧٨٨٨c == bVar.f١٧٨٨٨c) {
            return true;
        }
        return false;
    }

    public void f(int i10) {
        this.f١٧٨٨٦a = i10;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f١٧٨٨٦a), Integer.valueOf(this.f١٧٨٨٧b), Integer.valueOf(this.f١٧٨٨٨c));
    }

    public long i() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, this.f١٧٨٨٦a);
        calendar.set(2, this.f١٧٨٨٧b - 1);
        calendar.set(5, this.f١٧٨٨٨c);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public String toString() {
        return this.f١٧٨٨٦a + "-" + this.f١٧٨٨٧b + "-" + this.f١٧٨٨٨c;
    }
}
