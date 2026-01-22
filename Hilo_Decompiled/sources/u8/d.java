package u8;

import com.google.gson.x;
import java.sql.Date;
import java.sql.Timestamp;
import r8.d;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f١٨٢٧٠a;

    /* renamed from: b, reason: collision with root package name */
    public static final d.b f١٨٢٧١b;

    /* renamed from: c, reason: collision with root package name */
    public static final d.b f١٨٢٧٢c;

    /* renamed from: d, reason: collision with root package name */
    public static final x f١٨٢٧٣d;

    /* renamed from: e, reason: collision with root package name */
    public static final x f١٨٢٧٤e;

    /* renamed from: f, reason: collision with root package name */
    public static final x f١٨٢٧٥f;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a extends d.b {
        a(Class cls) {
            super(cls);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // r8.d.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Date d(java.util.Date date) {
            return new Date(date.getTime());
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class b extends d.b {
        b(Class cls) {
            super(cls);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // r8.d.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Timestamp d(java.util.Date date) {
            return new Timestamp(date.getTime());
        }
    }

    static {
        boolean z10;
        try {
            Class.forName("java.sql.Date");
            z10 = true;
        } catch (ClassNotFoundException unused) {
            z10 = false;
        }
        f١٨٢٧٠a = z10;
        if (z10) {
            f١٨٢٧١b = new a(Date.class);
            f١٨٢٧٢c = new b(Timestamp.class);
            f١٨٢٧٣d = u8.a.f١٨٢٦٤b;
            f١٨٢٧٤e = u8.b.f١٨٢٦٦b;
            f١٨٢٧٥f = c.f١٨٢٦٨b;
            return;
        }
        f١٨٢٧١b = null;
        f١٨٢٧٢c = null;
        f١٨٢٧٣d = null;
        f١٨٢٧٤e = null;
        f١٨٢٧٥f = null;
    }
}
