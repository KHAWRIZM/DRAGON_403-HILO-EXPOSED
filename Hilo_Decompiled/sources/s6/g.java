package s6;

import com.facebook.internal.security.CertificateUtil;
import java.io.Serializable;
import java.util.Calendar;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class g implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private int f١٧٩٠٣a;

    /* renamed from: b, reason: collision with root package name */
    private int f١٧٩٠٤b;

    /* renamed from: c, reason: collision with root package name */
    private int f١٧٩٠٥c;

    public static g d() {
        return i(Calendar.getInstance());
    }

    public static g h(int i10, int i11, int i12) {
        g gVar = new g();
        gVar.e(i10);
        gVar.f(i11);
        gVar.g(i12);
        return gVar;
    }

    public static g i(Calendar calendar) {
        return h(calendar.get(11), calendar.get(12), calendar.get(13));
    }

    public int a() {
        return this.f١٧٩٠٣a;
    }

    public int b() {
        return this.f١٧٩٠٤b;
    }

    public int c() {
        return this.f١٧٩٠٥c;
    }

    public void e(int i10) {
        this.f١٧٩٠٣a = i10;
    }

    public void f(int i10) {
        this.f١٧٩٠٤b = i10;
    }

    public void g(int i10) {
        this.f١٧٩٠٥c = i10;
    }

    public long j() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, this.f١٧٩٠٣a);
        calendar.set(12, this.f١٧٩٠٤b);
        calendar.set(13, this.f١٧٩٠٥c);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public String toString() {
        return this.f١٧٩٠٣a + CertificateUtil.DELIMITER + this.f١٧٩٠٤b + CertificateUtil.DELIMITER + this.f١٧٩٠٥c;
    }
}
