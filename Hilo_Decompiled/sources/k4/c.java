package k4;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class c implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    private final InputStream f١٥٥٣١a;

    /* renamed from: b, reason: collision with root package name */
    private final Charset f١٥٥٣٢b;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f١٥٥٣٣c;

    /* renamed from: d, reason: collision with root package name */
    private int f١٥٥٣٤d;

    /* renamed from: e, reason: collision with root package name */
    private int f١٥٥٣٥e;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a extends ByteArrayOutputStream {
        a(int i10) {
            super(i10);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i10 = ((ByteArrayOutputStream) this).count;
            if (i10 > 0 && ((ByteArrayOutputStream) this).buf[i10 - 1] == 13) {
                i10--;
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i10, c.this.f١٥٥٣٢b.name());
            } catch (UnsupportedEncodingException e10) {
                throw new AssertionError(e10);
            }
        }
    }

    public c(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void b() {
        InputStream inputStream = this.f١٥٥٣١a;
        byte[] bArr = this.f١٥٥٣٣c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f١٥٥٣٤d = 0;
            this.f١٥٥٣٥e = read;
            return;
        }
        throw new EOFException();
    }

    public boolean c() {
        if (this.f١٥٥٣٥e == -1) {
            return true;
        }
        return false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f١٥٥٣١a) {
            try {
                if (this.f١٥٥٣٣c != null) {
                    this.f١٥٥٣٣c = null;
                    this.f١٥٥٣١a.close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String g() {
        int i10;
        byte[] bArr;
        int i11;
        synchronized (this.f١٥٥٣١a) {
            try {
                if (this.f١٥٥٣٣c != null) {
                    if (this.f١٥٥٣٤d >= this.f١٥٥٣٥e) {
                        b();
                    }
                    for (int i12 = this.f١٥٥٣٤d; i12 != this.f١٥٥٣٥e; i12++) {
                        byte[] bArr2 = this.f١٥٥٣٣c;
                        if (bArr2[i12] == 10) {
                            int i13 = this.f١٥٥٣٤d;
                            if (i12 != i13) {
                                i11 = i12 - 1;
                                if (bArr2[i11] == 13) {
                                    String str = new String(bArr2, i13, i11 - i13, this.f١٥٥٣٢b.name());
                                    this.f١٥٥٣٤d = i12 + 1;
                                    return str;
                                }
                            }
                            i11 = i12;
                            String str2 = new String(bArr2, i13, i11 - i13, this.f١٥٥٣٢b.name());
                            this.f١٥٥٣٤d = i12 + 1;
                            return str2;
                        }
                    }
                    a aVar = new a((this.f١٥٥٣٥e - this.f١٥٥٣٤d) + 80);
                    loop1: while (true) {
                        byte[] bArr3 = this.f١٥٥٣٣c;
                        int i14 = this.f١٥٥٣٤d;
                        aVar.write(bArr3, i14, this.f١٥٥٣٥e - i14);
                        this.f١٥٥٣٥e = -1;
                        b();
                        i10 = this.f١٥٥٣٤d;
                        while (i10 != this.f١٥٥٣٥e) {
                            bArr = this.f١٥٥٣٣c;
                            if (bArr[i10] == 10) {
                                break loop1;
                            }
                            i10++;
                        }
                    }
                    int i15 = this.f١٥٥٣٤d;
                    if (i10 != i15) {
                        aVar.write(bArr, i15, i10 - i15);
                    }
                    this.f١٥٥٣٤d = i10 + 1;
                    return aVar.toString();
                }
                throw new IOException("LineReader is closed");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public c(InputStream inputStream, int i10, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i10 >= 0) {
            if (charset.equals(d.f١٥٥٣٧a)) {
                this.f١٥٥٣١a = inputStream;
                this.f١٥٥٣٢b = charset;
                this.f١٥٥٣٣c = new byte[i10];
                return;
            }
            throw new IllegalArgumentException("Unsupported encoding");
        }
        throw new IllegalArgumentException("capacity <= 0");
    }
}
