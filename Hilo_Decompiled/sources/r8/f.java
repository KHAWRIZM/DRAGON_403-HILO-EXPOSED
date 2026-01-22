package r8;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.Typography;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class f extends JsonReader {

    /* renamed from: e, reason: collision with root package name */
    private static final Reader f١٧٣٧٩e = new a();

    /* renamed from: f, reason: collision with root package name */
    private static final Object f١٧٣٨٠f = new Object();

    /* renamed from: a, reason: collision with root package name */
    private Object[] f١٧٣٨١a;

    /* renamed from: b, reason: collision with root package name */
    private int f١٧٣٨٢b;

    /* renamed from: c, reason: collision with root package name */
    private String[] f١٧٣٨٣c;

    /* renamed from: d, reason: collision with root package name */
    private int[] f١٧٣٨٤d;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a extends Reader {
        a() {
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i10, int i11) {
            throw new AssertionError();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f١٧٣٨٥a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f١٧٣٨٥a = iArr;
            try {
                iArr[JsonToken.NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f١٧٣٨٥a[JsonToken.END_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f١٧٣٨٥a[JsonToken.END_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f١٧٣٨٥a[JsonToken.END_DOCUMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public f(com.google.gson.i iVar) {
        super(f١٧٣٧٩e);
        this.f١٧٣٨١a = new Object[32];
        this.f١٧٣٨٢b = 0;
        this.f١٧٣٨٣c = new String[32];
        this.f١٧٣٨٤d = new int[32];
        k(iVar);
    }

    private void a(JsonToken jsonToken) {
        if (peek() == jsonToken) {
            return;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + peek() + locationString());
    }

    private String c(boolean z10) {
        String str;
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) g()).next();
        String str2 = (String) entry.getKey();
        String[] strArr = this.f١٧٣٨٣c;
        int i10 = this.f١٧٣٨٢b - 1;
        if (z10) {
            str = "<skipped>";
        } else {
            str = str2;
        }
        strArr[i10] = str;
        k(entry.getValue());
        return str2;
    }

    private Object g() {
        return this.f١٧٣٨١a[this.f١٧٣٨٢b - 1];
    }

    private String getPath(boolean z10) {
        StringBuilder sb = new StringBuilder();
        sb.append(Typography.dollar);
        int i10 = 0;
        while (true) {
            int i11 = this.f١٧٣٨٢b;
            if (i10 < i11) {
                Object[] objArr = this.f١٧٣٨١a;
                Object obj = objArr[i10];
                if (obj instanceof com.google.gson.f) {
                    i10++;
                    if (i10 < i11 && (objArr[i10] instanceof Iterator)) {
                        int i12 = this.f١٧٣٨٤d[i10];
                        if (z10 && i12 > 0 && (i10 == i11 - 1 || i10 == i11 - 2)) {
                            i12--;
                        }
                        sb.append('[');
                        sb.append(i12);
                        sb.append(']');
                    }
                } else if ((obj instanceof com.google.gson.l) && (i10 = i10 + 1) < i11 && (objArr[i10] instanceof Iterator)) {
                    sb.append('.');
                    String str = this.f١٧٣٨٣c[i10];
                    if (str != null) {
                        sb.append(str);
                    }
                }
                i10++;
            } else {
                return sb.toString();
            }
        }
    }

    private Object h() {
        Object[] objArr = this.f١٧٣٨١a;
        int i10 = this.f١٧٣٨٢b - 1;
        this.f١٧٣٨٢b = i10;
        Object obj = objArr[i10];
        objArr[i10] = null;
        return obj;
    }

    private void k(Object obj) {
        int i10 = this.f١٧٣٨٢b;
        Object[] objArr = this.f١٧٣٨١a;
        if (i10 == objArr.length) {
            int i11 = i10 * 2;
            this.f١٧٣٨١a = Arrays.copyOf(objArr, i11);
            this.f١٧٣٨٤d = Arrays.copyOf(this.f١٧٣٨٤d, i11);
            this.f١٧٣٨٣c = (String[]) Arrays.copyOf(this.f١٧٣٨٣c, i11);
        }
        Object[] objArr2 = this.f١٧٣٨١a;
        int i12 = this.f١٧٣٨٢b;
        this.f١٧٣٨٢b = i12 + 1;
        objArr2[i12] = obj;
    }

    private String locationString() {
        return " at path " + getPath();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.gson.i b() {
        JsonToken peek = peek();
        if (peek != JsonToken.NAME && peek != JsonToken.END_ARRAY && peek != JsonToken.END_OBJECT && peek != JsonToken.END_DOCUMENT) {
            com.google.gson.i iVar = (com.google.gson.i) g();
            skipValue();
            return iVar;
        }
        throw new IllegalStateException("Unexpected " + peek + " when reading a JsonElement.");
    }

    @Override // com.google.gson.stream.JsonReader
    public void beginArray() {
        a(JsonToken.BEGIN_ARRAY);
        k(((com.google.gson.f) g()).iterator());
        this.f١٧٣٨٤d[this.f١٧٣٨٢b - 1] = 0;
    }

    @Override // com.google.gson.stream.JsonReader
    public void beginObject() {
        a(JsonToken.BEGIN_OBJECT);
        k(((com.google.gson.l) g()).o().iterator());
    }

    @Override // com.google.gson.stream.JsonReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f١٧٣٨١a = new Object[]{f١٧٣٨٠f};
        this.f١٧٣٨٢b = 1;
    }

    @Override // com.google.gson.stream.JsonReader
    public void endArray() {
        a(JsonToken.END_ARRAY);
        h();
        h();
        int i10 = this.f١٧٣٨٢b;
        if (i10 > 0) {
            int[] iArr = this.f١٧٣٨٤d;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public void endObject() {
        a(JsonToken.END_OBJECT);
        this.f١٧٣٨٣c[this.f١٧٣٨٢b - 1] = null;
        h();
        h();
        int i10 = this.f١٧٣٨٢b;
        if (i10 > 0) {
            int[] iArr = this.f١٧٣٨٤d;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public String getPreviousPath() {
        return getPath(true);
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean hasNext() {
        JsonToken peek = peek();
        if (peek != JsonToken.END_OBJECT && peek != JsonToken.END_ARRAY && peek != JsonToken.END_DOCUMENT) {
            return true;
        }
        return false;
    }

    public void j() {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) g()).next();
        k(entry.getValue());
        k(new com.google.gson.o((String) entry.getKey()));
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean nextBoolean() {
        a(JsonToken.BOOLEAN);
        boolean n10 = ((com.google.gson.o) h()).n();
        int i10 = this.f١٧٣٨٢b;
        if (i10 > 0) {
            int[] iArr = this.f١٧٣٨٤d;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return n10;
    }

    @Override // com.google.gson.stream.JsonReader
    public double nextDouble() {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (peek != jsonToken && peek != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + peek + locationString());
        }
        double o10 = ((com.google.gson.o) g()).o();
        if (!isLenient() && (Double.isNaN(o10) || Double.isInfinite(o10))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + o10);
        }
        h();
        int i10 = this.f١٧٣٨٢b;
        if (i10 > 0) {
            int[] iArr = this.f١٧٣٨٤d;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return o10;
    }

    @Override // com.google.gson.stream.JsonReader
    public int nextInt() {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (peek != jsonToken && peek != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + peek + locationString());
        }
        int p10 = ((com.google.gson.o) g()).p();
        h();
        int i10 = this.f١٧٣٨٢b;
        if (i10 > 0) {
            int[] iArr = this.f١٧٣٨٤d;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return p10;
    }

    @Override // com.google.gson.stream.JsonReader
    public long nextLong() {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (peek != jsonToken && peek != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + peek + locationString());
        }
        long q10 = ((com.google.gson.o) g()).q();
        h();
        int i10 = this.f١٧٣٨٢b;
        if (i10 > 0) {
            int[] iArr = this.f١٧٣٨٤d;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return q10;
    }

    @Override // com.google.gson.stream.JsonReader
    public String nextName() {
        return c(false);
    }

    @Override // com.google.gson.stream.JsonReader
    public void nextNull() {
        a(JsonToken.NULL);
        h();
        int i10 = this.f١٧٣٨٢b;
        if (i10 > 0) {
            int[] iArr = this.f١٧٣٨٤d;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public String nextString() {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.STRING;
        if (peek != jsonToken && peek != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + peek + locationString());
        }
        String h10 = ((com.google.gson.o) h()).h();
        int i10 = this.f١٧٣٨٢b;
        if (i10 > 0) {
            int[] iArr = this.f١٧٣٨٤d;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return h10;
    }

    @Override // com.google.gson.stream.JsonReader
    public JsonToken peek() {
        if (this.f١٧٣٨٢b == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object g10 = g();
        if (g10 instanceof Iterator) {
            boolean z10 = this.f١٧٣٨١a[this.f١٧٣٨٢b - 2] instanceof com.google.gson.l;
            Iterator it = (Iterator) g10;
            if (it.hasNext()) {
                if (z10) {
                    return JsonToken.NAME;
                }
                k(it.next());
                return peek();
            }
            if (z10) {
                return JsonToken.END_OBJECT;
            }
            return JsonToken.END_ARRAY;
        }
        if (g10 instanceof com.google.gson.l) {
            return JsonToken.BEGIN_OBJECT;
        }
        if (g10 instanceof com.google.gson.f) {
            return JsonToken.BEGIN_ARRAY;
        }
        if (g10 instanceof com.google.gson.o) {
            com.google.gson.o oVar = (com.google.gson.o) g10;
            if (oVar.v()) {
                return JsonToken.STRING;
            }
            if (oVar.s()) {
                return JsonToken.BOOLEAN;
            }
            if (oVar.u()) {
                return JsonToken.NUMBER;
            }
            throw new AssertionError();
        }
        if (g10 instanceof com.google.gson.k) {
            return JsonToken.NULL;
        }
        if (g10 == f١٧٣٨٠f) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw new MalformedJsonException("Custom JsonElement subclass " + g10.getClass().getName() + " is not supported");
    }

    @Override // com.google.gson.stream.JsonReader
    public void skipValue() {
        int i10 = b.f١٧٣٨٥a[peek().ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 4) {
                        h();
                        int i11 = this.f١٧٣٨٢b;
                        if (i11 > 0) {
                            int[] iArr = this.f١٧٣٨٤d;
                            int i12 = i11 - 1;
                            iArr[i12] = iArr[i12] + 1;
                            return;
                        }
                        return;
                    }
                    return;
                }
                endObject();
                return;
            }
            endArray();
            return;
        }
        c(true);
    }

    @Override // com.google.gson.stream.JsonReader
    public String toString() {
        return f.class.getSimpleName() + locationString();
    }

    @Override // com.google.gson.stream.JsonReader
    public String getPath() {
        return getPath(false);
    }
}
