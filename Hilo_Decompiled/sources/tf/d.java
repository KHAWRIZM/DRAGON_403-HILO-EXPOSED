package tf;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class d extends FilterInputStream {
    private volatile byte[] a;
    private int b;
    private int c;
    private int d;
    private int e;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    static class a extends IOException {
        private static final long serialVersionUID = -4338378848813561759L;

        a(String str) {
            super(str);
        }
    }

    public d(InputStream inputStream) {
        this(inputStream, 65536);
    }

    private int a(InputStream inputStream, byte[] bArr) {
        int i = this.d;
        if (i != -1) {
            int i2 = this.e - i;
            int i3 = this.c;
            if (i2 < i3) {
                if (i == 0 && i3 > bArr.length && this.b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i3) {
                        i3 = length;
                    }
                    byte[] c = b.d().c(i3);
                    System.arraycopy(bArr, 0, c, 0, bArr.length);
                    this.a = c;
                    b.d().g(bArr);
                    bArr = c;
                } else if (i > 0) {
                    System.arraycopy(bArr, i, bArr, 0, bArr.length - i);
                }
                int i4 = this.e - this.d;
                this.e = i4;
                this.d = 0;
                this.b = 0;
                int read = inputStream.read(bArr, i4, bArr.length - i4);
                int i5 = this.e;
                if (read > 0) {
                    i5 += read;
                }
                this.b = i5;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.d = -1;
            this.e = 0;
            this.b = read2;
        }
        return read2;
    }

    private static IOException b() {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        InputStream inputStream = ((FilterInputStream) this).in;
        if (this.a != null && inputStream != null) {
            return (this.b - this.e) + inputStream.available();
        }
        return 0;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.a != null) {
            b.d().g(this.a);
            this.a = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        this.c = Math.max(this.c, i);
        this.d = this.e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        byte[] bArr = this.a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr != null && inputStream != null) {
            if (this.e >= this.b && a(inputStream, bArr) == -1) {
                return -1;
            }
            if (bArr != this.a && (bArr = this.a) == null) {
                throw b();
            }
            int i = this.b;
            int i2 = this.e;
            if (i - i2 <= 0) {
                return -1;
            }
            this.e = i2 + 1;
            return bArr[i2] & 255;
        }
        throw b();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        if (this.a != null) {
            int i = this.d;
            if (-1 != i) {
                this.e = i;
            } else {
                throw new a("Mark has been invalidated, pos: " + this.e + " markLimit: " + this.c);
            }
        } else {
            throw new IOException("Stream is closed");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) {
        if (j < 1) {
            return 0L;
        }
        byte[] bArr = this.a;
        if (bArr != null) {
            InputStream inputStream = ((FilterInputStream) this).in;
            if (inputStream != null) {
                int i = this.b;
                int i2 = this.e;
                if (i - i2 >= j) {
                    this.e = (int) (i2 + j);
                    return j;
                }
                long j2 = i - i2;
                this.e = i;
                if (this.d != -1 && j <= this.c) {
                    if (a(inputStream, bArr) == -1) {
                        return j2;
                    }
                    int i3 = this.b;
                    int i4 = this.e;
                    if (i3 - i4 >= j - j2) {
                        this.e = (int) ((i4 + j) - j2);
                        return j;
                    }
                    long j3 = (j2 + i3) - i4;
                    this.e = i3;
                    return j3;
                }
                return j2 + inputStream.skip(j - j2);
            }
            throw b();
        }
        throw b();
    }

    d(InputStream inputStream, int i) {
        super(inputStream);
        this.d = -1;
        this.a = b.d().c(i);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) {
        int i3;
        int min;
        byte[] bArr2 = this.a;
        if (bArr2 == null) {
            throw b();
        }
        if (i2 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            int i4 = this.e;
            int i5 = this.b;
            if (i4 < i5) {
                int min2 = Math.min(i5 - i4, i2);
                System.arraycopy(bArr2, this.e, bArr, i, min2);
                this.e += min2;
                if (min2 == i2 || inputStream.available() == 0) {
                    return min2;
                }
                i += min2;
                i3 = i2 - min2;
            } else {
                i3 = i2;
            }
            while (true) {
                if (this.d == -1 && i3 >= bArr2.length) {
                    min = inputStream.read(bArr, i, i3);
                    if (min == -1) {
                        return i3 != i2 ? i2 - i3 : -1;
                    }
                } else {
                    if (a(inputStream, bArr2) == -1) {
                        return i3 != i2 ? i2 - i3 : -1;
                    }
                    if (bArr2 != this.a && (bArr2 = this.a) == null) {
                        throw b();
                    }
                    min = Math.min(this.b - this.e, i3);
                    System.arraycopy(bArr2, this.e, bArr, i, min);
                    this.e += min;
                }
                i3 -= min;
                if (i3 == 0) {
                    return i2;
                }
                if (inputStream.available() == 0) {
                    return i2 - i3;
                }
                i += min;
            }
        } else {
            throw b();
        }
    }
}
