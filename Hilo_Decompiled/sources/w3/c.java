package w3;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class c implements Closeable {

    /* renamed from: g, reason: collision with root package name */
    private static final String[] f١٨٦٨٦g = new String[128];

    /* renamed from: a, reason: collision with root package name */
    int f١٨٦٨٧a;

    /* renamed from: b, reason: collision with root package name */
    int[] f١٨٦٨٨b = new int[32];

    /* renamed from: c, reason: collision with root package name */
    String[] f١٨٦٨٩c = new String[32];

    /* renamed from: d, reason: collision with root package name */
    int[] f١٨٦٩٠d = new int[32];

    /* renamed from: e, reason: collision with root package name */
    boolean f١٨٦٩١e;

    /* renamed from: f, reason: collision with root package name */
    boolean f١٨٦٩٢f;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        final String[] f١٨٦٩٣a;

        /* renamed from: b, reason: collision with root package name */
        final Options f١٨٦٩٤b;

        private a(String[] strArr, Options options) {
            this.f١٨٦٩٣a = strArr;
            this.f١٨٦٩٤b = options;
        }

        public static a a(String... strArr) {
            try {
                ByteString[] byteStringArr = new ByteString[strArr.length];
                Buffer buffer = new Buffer();
                for (int i10 = 0; i10 < strArr.length; i10++) {
                    c.C(buffer, strArr[i10]);
                    buffer.readByte();
                    byteStringArr[i10] = buffer.readByteString();
                }
                return new a((String[]) strArr.clone(), Options.of(byteStringArr));
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public enum b {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    static {
        for (int i10 = 0; i10 <= 31; i10++) {
            f١٨٦٨٦g[i10] = String.format("\\u%04x", Integer.valueOf(i10));
        }
        String[] strArr = f١٨٦٨٦g;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void C(BufferedSink bufferedSink, String str) {
        String str2;
        String[] strArr = f١٨٦٨٦g;
        bufferedSink.writeByte(34);
        int length = str.length();
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            char charAt = str.charAt(i11);
            if (charAt < 128) {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
                if (i10 < i11) {
                    bufferedSink.writeUtf8(str, i10, i11);
                }
                bufferedSink.writeUtf8(str2);
                i10 = i11 + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i10 < i11) {
                }
                bufferedSink.writeUtf8(str2);
                i10 = i11 + 1;
            }
        }
        if (i10 < length) {
            bufferedSink.writeUtf8(str, i10, length);
        }
        bufferedSink.writeByte(34);
    }

    public static c t(BufferedSource bufferedSource) {
        return new e(bufferedSource);
    }

    public abstract void A();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final w3.b D(String str) {
        throw new w3.b(str + " at path " + getPath());
    }

    public abstract void b();

    public abstract void c();

    public abstract void g();

    public final String getPath() {
        return d.a(this.f١٨٦٨٧a, this.f١٨٦٨٨b, this.f١٨٦٨٩c, this.f١٨٦٩٠d);
    }

    public abstract void h();

    public abstract boolean j();

    public abstract boolean k();

    public abstract double m();

    public abstract int o();

    public abstract String q();

    public abstract String s();

    public abstract b u();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void w(int i10) {
        int i11 = this.f١٨٦٨٧a;
        int[] iArr = this.f١٨٦٨٨b;
        if (i11 == iArr.length) {
            if (i11 != 256) {
                this.f١٨٦٨٨b = Arrays.copyOf(iArr, iArr.length * 2);
                String[] strArr = this.f١٨٦٨٩c;
                this.f١٨٦٨٩c = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                int[] iArr2 = this.f١٨٦٩٠d;
                this.f١٨٦٩٠d = Arrays.copyOf(iArr2, iArr2.length * 2);
            } else {
                throw new w3.a("Nesting too deep at " + getPath());
            }
        }
        int[] iArr3 = this.f١٨٦٨٨b;
        int i12 = this.f١٨٦٨٧a;
        this.f١٨٦٨٧a = i12 + 1;
        iArr3[i12] = i10;
    }

    public abstract int x(a aVar);

    public abstract void z();
}
