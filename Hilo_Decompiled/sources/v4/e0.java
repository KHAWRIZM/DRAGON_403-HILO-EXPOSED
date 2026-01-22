package v4;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class e0 extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    private volatile byte[] f١٨٤٨٧a;

    /* renamed from: b, reason: collision with root package name */
    private int f١٨٤٨٨b;

    /* renamed from: c, reason: collision with root package name */
    private int f١٨٤٨٩c;

    /* renamed from: d, reason: collision with root package name */
    private int f١٨٤٩٠d;

    /* renamed from: e, reason: collision with root package name */
    private int f١٨٤٩١e;

    /* renamed from: f, reason: collision with root package name */
    private final p4.b f١٨٤٩٢f;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static class a extends IOException {
        private static final long serialVersionUID = -4338378848813561757L;

        a(String str) {
            super(str);
        }
    }

    public e0(InputStream inputStream, p4.b bVar) {
        this(inputStream, bVar, 65536);
    }

    private int a(InputStream inputStream, byte[] bArr) {
        int i10 = this.f١٨٤٩٠d;
        if (i10 != -1) {
            int i11 = this.f١٨٤٩١e - i10;
            int i12 = this.f١٨٤٨٩c;
            if (i11 < i12) {
                if (i10 == 0 && i12 > bArr.length && this.f١٨٤٨٨b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i12) {
                        i12 = length;
                    }
                    byte[] bArr2 = (byte[]) this.f١٨٤٩٢f.c(i12, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f١٨٤٨٧a = bArr2;
                    this.f١٨٤٩٢f.put(bArr);
                    bArr = bArr2;
                } else if (i10 > 0) {
                    System.arraycopy(bArr, i10, bArr, 0, bArr.length - i10);
                }
                int i13 = this.f١٨٤٩١e - this.f١٨٤٩٠d;
                this.f١٨٤٩١e = i13;
                this.f١٨٤٩٠d = 0;
                this.f١٨٤٨٨b = 0;
                int read = inputStream.read(bArr, i13, bArr.length - i13);
                int i14 = this.f١٨٤٩١e;
                if (read > 0) {
                    i14 += read;
                }
                this.f١٨٤٨٨b = i14;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.f١٨٤٩٠d = -1;
            this.f١٨٤٩١e = 0;
            this.f١٨٤٨٨b = read2;
        }
        return read2;
    }

    private static IOException c() {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f١٨٤٨٧a != null && inputStream != null) {
        } else {
            throw c();
        }
        return (this.f١٨٤٨٨b - this.f١٨٤٩١e) + inputStream.available();
    }

    public synchronized void b() {
        this.f١٨٤٨٩c = this.f١٨٤٨٧a.length;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f١٨٤٨٧a != null) {
            this.f١٨٤٩٢f.put(this.f١٨٤٨٧a);
            this.f١٨٤٨٧a = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i10) {
        this.f١٨٤٨٩c = Math.max(this.f١٨٤٨٩c, i10);
        this.f١٨٤٩٠d = this.f١٨٤٩١e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        byte[] bArr = this.f١٨٤٨٧a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr != null && inputStream != null) {
            if (this.f١٨٤٩١e >= this.f١٨٤٨٨b && a(inputStream, bArr) == -1) {
                return -1;
            }
            if (bArr != this.f١٨٤٨٧a && (bArr = this.f١٨٤٨٧a) == null) {
                throw c();
            }
            int i10 = this.f١٨٤٨٨b;
            int i11 = this.f١٨٤٩١e;
            if (i10 - i11 <= 0) {
                return -1;
            }
            this.f١٨٤٩١e = i11 + 1;
            return bArr[i11] & UByte.MAX_VALUE;
        }
        throw c();
    }

    public synchronized void release() {
        if (this.f١٨٤٨٧a != null) {
            this.f١٨٤٩٢f.put(this.f١٨٤٨٧a);
            this.f١٨٤٨٧a = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        if (this.f١٨٤٨٧a != null) {
            int i10 = this.f١٨٤٩٠d;
            if (-1 != i10) {
                this.f١٨٤٩١e = i10;
            } else {
                throw new a("Mark has been invalidated, pos: " + this.f١٨٤٩١e + " markLimit: " + this.f١٨٤٨٩c);
            }
        } else {
            throw new IOException("Stream is closed");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j10) {
        if (j10 < 1) {
            return 0L;
        }
        byte[] bArr = this.f١٨٤٨٧a;
        if (bArr != null) {
            InputStream inputStream = ((FilterInputStream) this).in;
            if (inputStream != null) {
                int i10 = this.f١٨٤٨٨b;
                int i11 = this.f١٨٤٩١e;
                if (i10 - i11 >= j10) {
                    this.f١٨٤٩١e = (int) (i11 + j10);
                    return j10;
                }
                long j11 = i10 - i11;
                this.f١٨٤٩١e = i10;
                if (this.f١٨٤٩٠d != -1 && j10 <= this.f١٨٤٨٩c) {
                    if (a(inputStream, bArr) == -1) {
                        return j11;
                    }
                    int i12 = this.f١٨٤٨٨b;
                    int i13 = this.f١٨٤٩١e;
                    if (i12 - i13 >= j10 - j11) {
                        this.f١٨٤٩١e = (int) ((i13 + j10) - j11);
                        return j10;
                    }
                    long j12 = (j11 + i12) - i13;
                    this.f١٨٤٩١e = i12;
                    return j12;
                }
                long skip = inputStream.skip(j10 - j11);
                if (skip > 0) {
                    this.f١٨٤٩٠d = -1;
                }
                return j11 + skip;
            }
            throw c();
        }
        throw c();
    }

    e0(InputStream inputStream, p4.b bVar, int i10) {
        super(inputStream);
        this.f١٨٤٩٠d = -1;
        this.f١٨٤٩٢f = bVar;
        this.f١٨٤٨٧a = (byte[]) bVar.c(i10, byte[].class);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i10, int i11) {
        int i12;
        int i13;
        byte[] bArr2 = this.f١٨٤٨٧a;
        if (bArr2 == null) {
            throw c();
        }
        if (i11 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            int i14 = this.f١٨٤٩١e;
            int i15 = this.f١٨٤٨٨b;
            if (i14 < i15) {
                int i16 = i15 - i14 >= i11 ? i11 : i15 - i14;
                System.arraycopy(bArr2, i14, bArr, i10, i16);
                this.f١٨٤٩١e += i16;
                if (i16 == i11 || inputStream.available() == 0) {
                    return i16;
                }
                i10 += i16;
                i12 = i11 - i16;
            } else {
                i12 = i11;
            }
            while (true) {
                if (this.f١٨٤٩٠d == -1 && i12 >= bArr2.length) {
                    i13 = inputStream.read(bArr, i10, i12);
                    if (i13 == -1) {
                        return i12 != i11 ? i11 - i12 : -1;
                    }
                } else {
                    if (a(inputStream, bArr2) == -1) {
                        return i12 != i11 ? i11 - i12 : -1;
                    }
                    if (bArr2 != this.f١٨٤٨٧a && (bArr2 = this.f١٨٤٨٧a) == null) {
                        throw c();
                    }
                    int i17 = this.f١٨٤٨٨b;
                    int i18 = this.f١٨٤٩١e;
                    i13 = i17 - i18 >= i12 ? i12 : i17 - i18;
                    System.arraycopy(bArr2, i18, bArr, i10, i13);
                    this.f١٨٤٩١e += i13;
                }
                i12 -= i13;
                if (i12 == 0) {
                    return i11;
                }
                if (inputStream.available() == 0) {
                    return i11 - i12;
                }
                i10 += i13;
            }
        } else {
            throw c();
        }
    }
}
