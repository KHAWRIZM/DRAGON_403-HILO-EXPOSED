package q8;

import com.google.gson.r;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;
import r8.o;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class m {
    public static com.google.gson.i a(JsonReader jsonReader) {
        boolean z10;
        try {
            try {
                jsonReader.peek();
                z10 = false;
                try {
                    return (com.google.gson.i) o.V.read(jsonReader);
                } catch (EOFException e10) {
                    e = e10;
                    if (z10) {
                        return com.google.gson.k.f١٠٨٤٦a;
                    }
                    throw new r(e);
                }
            } catch (EOFException e11) {
                e = e11;
                z10 = true;
            }
        } catch (MalformedJsonException e12) {
            throw new r(e12);
        } catch (IOException e13) {
            throw new com.google.gson.j(e13);
        } catch (NumberFormatException e14) {
            throw new r(e14);
        }
    }

    public static void b(com.google.gson.i iVar, JsonWriter jsonWriter) {
        o.V.write(jsonWriter, iVar);
    }

    public static Writer c(Appendable appendable) {
        if (appendable instanceof Writer) {
            return (Writer) appendable;
        }
        return new b(appendable);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class b extends Writer {

        /* renamed from: a, reason: collision with root package name */
        private final Appendable f١٧٢٤٠a;

        /* renamed from: b, reason: collision with root package name */
        private final a f١٧٢٤١b = new a();

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        private static class a implements CharSequence {

            /* renamed from: a, reason: collision with root package name */
            private char[] f١٧٢٤٢a;

            /* renamed from: b, reason: collision with root package name */
            private String f١٧٢٤٣b;

            private a() {
            }

            void a(char[] cArr) {
                this.f١٧٢٤٢a = cArr;
                this.f١٧٢٤٣b = null;
            }

            @Override // java.lang.CharSequence
            public char charAt(int i10) {
                return this.f١٧٢٤٢a[i10];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f١٧٢٤٢a.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i10, int i11) {
                return new String(this.f١٧٢٤٢a, i10, i11 - i10);
            }

            @Override // java.lang.CharSequence
            public String toString() {
                if (this.f١٧٢٤٣b == null) {
                    this.f١٧٢٤٣b = new String(this.f١٧٢٤٢a);
                }
                return this.f١٧٢٤٣b;
            }
        }

        b(Appendable appendable) {
            this.f١٧٢٤٠a = appendable;
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i10, int i11) {
            this.f١٧٢٤١b.a(cArr);
            this.f١٧٢٤٠a.append(this.f١٧٢٤١b, i10, i11 + i10);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence) {
            this.f١٧٢٤٠a.append(charSequence);
            return this;
        }

        @Override // java.io.Writer
        public void write(int i10) {
            this.f١٧٢٤٠a.append((char) i10);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence, int i10, int i11) {
            this.f١٧٢٤٠a.append(charSequence, i10, i11);
            return this;
        }

        @Override // java.io.Writer
        public void write(String str, int i10, int i11) {
            Objects.requireNonNull(str);
            this.f١٧٢٤٠a.append(str, i10, i11 + i10);
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }
    }
}
