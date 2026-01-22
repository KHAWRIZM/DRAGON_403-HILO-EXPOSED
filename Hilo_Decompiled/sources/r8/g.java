package r8;

import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class g extends JsonWriter {

    /* renamed from: d, reason: collision with root package name */
    private static final Writer f١٧٣٨٦d = new a();

    /* renamed from: e, reason: collision with root package name */
    private static final com.google.gson.o f١٧٣٨٧e = new com.google.gson.o("closed");

    /* renamed from: a, reason: collision with root package name */
    private final List f١٧٣٨٨a;

    /* renamed from: b, reason: collision with root package name */
    private String f١٧٣٨٩b;

    /* renamed from: c, reason: collision with root package name */
    private com.google.gson.i f١٧٣٩٠c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a extends Writer {
        a() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i10, int i11) {
            throw new AssertionError();
        }
    }

    public g() {
        super(f١٧٣٨٦d);
        this.f١٧٣٨٨a = new ArrayList();
        this.f١٧٣٩٠c = com.google.gson.k.f١٠٨٤٦a;
    }

    private com.google.gson.i b() {
        return (com.google.gson.i) this.f١٧٣٨٨a.get(r0.size() - 1);
    }

    private void c(com.google.gson.i iVar) {
        if (this.f١٧٣٨٩b != null) {
            if (!iVar.k() || getSerializeNulls()) {
                ((com.google.gson.l) b()).n(this.f١٧٣٨٩b, iVar);
            }
            this.f١٧٣٨٩b = null;
            return;
        }
        if (this.f١٧٣٨٨a.isEmpty()) {
            this.f١٧٣٩٠c = iVar;
            return;
        }
        com.google.gson.i b10 = b();
        if (b10 instanceof com.google.gson.f) {
            ((com.google.gson.f) b10).n(iVar);
            return;
        }
        throw new IllegalStateException();
    }

    public com.google.gson.i a() {
        if (this.f١٧٣٨٨a.isEmpty()) {
            return this.f١٧٣٩٠c;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f١٧٣٨٨a);
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter beginArray() {
        com.google.gson.f fVar = new com.google.gson.f();
        c(fVar);
        this.f١٧٣٨٨a.add(fVar);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter beginObject() {
        com.google.gson.l lVar = new com.google.gson.l();
        c(lVar);
        this.f١٧٣٨٨a.add(lVar);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f١٧٣٨٨a.isEmpty()) {
            this.f١٧٣٨٨a.add(f١٧٣٨٧e);
            return;
        }
        throw new IOException("Incomplete document");
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter endArray() {
        if (!this.f١٧٣٨٨a.isEmpty() && this.f١٧٣٨٩b == null) {
            if (b() instanceof com.google.gson.f) {
                this.f١٧٣٨٨a.remove(r0.size() - 1);
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter endObject() {
        if (!this.f١٧٣٨٨a.isEmpty() && this.f١٧٣٨٩b == null) {
            if (b() instanceof com.google.gson.l) {
                this.f١٧٣٨٨a.remove(r0.size() - 1);
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter jsonValue(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter name(String str) {
        Objects.requireNonNull(str, "name == null");
        if (!this.f١٧٣٨٨a.isEmpty() && this.f١٧٣٨٩b == null) {
            if (b() instanceof com.google.gson.l) {
                this.f١٧٣٨٩b = str;
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter nullValue() {
        c(com.google.gson.k.f١٠٨٤٦a);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(String str) {
        if (str == null) {
            return nullValue();
        }
        c(new com.google.gson.o(str));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(boolean z10) {
        c(new com.google.gson.o(Boolean.valueOf(z10)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(Boolean bool) {
        if (bool == null) {
            return nullValue();
        }
        c(new com.google.gson.o(bool));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(float f10) {
        if (!isLenient() && (Float.isNaN(f10) || Float.isInfinite(f10))) {
            throw new IllegalArgumentException("JSON forbids NaN and infinities: " + f10);
        }
        c(new com.google.gson.o(Float.valueOf(f10)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(double d10) {
        if (!isLenient() && (Double.isNaN(d10) || Double.isInfinite(d10))) {
            throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d10);
        }
        c(new com.google.gson.o(Double.valueOf(d10)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(long j10) {
        c(new com.google.gson.o(Long.valueOf(j10)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(Number number) {
        if (number == null) {
            return nullValue();
        }
        if (!isLenient()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        c(new com.google.gson.o(number));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter, java.io.Flushable
    public void flush() {
    }
}
