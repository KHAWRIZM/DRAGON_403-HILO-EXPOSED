package androidx.datastore.preferences.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class u {

    /* renamed from: a, reason: collision with root package name */
    static final Charset f٣٥٠٨a = Charset.forName("US-ASCII");

    /* renamed from: b, reason: collision with root package name */
    static final Charset f٣٥٠٩b = Charset.forName("UTF-8");

    /* renamed from: c, reason: collision with root package name */
    static final Charset f٣٥١٠c = Charset.forName("ISO-8859-1");

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f٣٥١١d;

    /* renamed from: e, reason: collision with root package name */
    public static final ByteBuffer f٣٥١٢e;

    /* renamed from: f, reason: collision with root package name */
    public static final g f٣٥١٣f;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface a {
        boolean a(int i10);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface b extends List, RandomAccess {
        b a(int i10);

        void b();

        boolean c();
    }

    static {
        byte[] bArr = new byte[0];
        f٣٥١١d = bArr;
        f٣٥١٢e = ByteBuffer.wrap(bArr);
        f٣٥١٣f = g.i(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object a(Object obj) {
        obj.getClass();
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object b(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public static int c(boolean z10) {
        return z10 ? 1231 : 1237;
    }

    public static int d(byte[] bArr) {
        return e(bArr, 0, bArr.length);
    }

    static int e(byte[] bArr, int i10, int i11) {
        int g10 = g(i11, bArr, i10, i11);
        if (g10 == 0) {
            return 1;
        }
        return g10;
    }

    public static int f(long j10) {
        return (int) (j10 ^ (j10 >>> 32));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(int i10, byte[] bArr, int i11, int i12) {
        for (int i13 = i11; i13 < i11 + i12; i13++) {
            i10 = (i10 * 31) + bArr[i13];
        }
        return i10;
    }
}
