package b7;

import android.util.Base64;
import b7.d;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class p {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static abstract class a {
        public abstract p a();

        public abstract a b(String str);

        public abstract a c(byte[] bArr);

        public abstract a d(z6.f fVar);
    }

    public static a a() {
        return new d.b().d(z6.f.DEFAULT);
    }

    public abstract String b();

    public abstract byte[] c();

    public abstract z6.f d();

    public boolean e() {
        if (c() != null) {
            return true;
        }
        return false;
    }

    public p f(z6.f fVar) {
        return a().b(b()).d(fVar).c(c()).a();
    }

    public final String toString() {
        String encodeToString;
        String b10 = b();
        z6.f d10 = d();
        if (c() == null) {
            encodeToString = "";
        } else {
            encodeToString = Base64.encodeToString(c(), 2);
        }
        return String.format("TransportContext(%s, %s, %s)", b10, d10, encodeToString);
    }
}
