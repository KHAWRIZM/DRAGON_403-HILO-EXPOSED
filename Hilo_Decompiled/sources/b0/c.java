package b0;

import e0.m;
import java.io.EOFException;
import java.io.InputStream;
import k0.l;
import kotlin.UByte;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class c extends y.a {

    /* renamed from: a, reason: collision with root package name */
    public InputStream f٥٣١٠a;

    /* renamed from: b, reason: collision with root package name */
    public b f٥٣١١b;

    /* renamed from: c, reason: collision with root package name */
    public long f٥٣١٢c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f٥٣١٣d;

    public c(InputStream inputStream) {
        b bVar = new b(inputStream);
        this.f٥٣١٣d = new byte[1];
        this.f٥٣١١b = bVar;
        this.f٥٣١٠a = inputStream;
    }

    @Override // java.io.InputStream
    public final int available() {
        b bVar = this.f٥٣١١b;
        if (bVar != null) {
            return bVar.f٥٣٠٦b.a();
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            k0.a.c(this.f٥٣١١b);
            this.f٥٣١١b = null;
        } finally {
            InputStream inputStream = this.f٥٣١٠a;
            if (inputStream != null) {
                inputStream.close();
                this.f٥٣١٠a = null;
            }
        }
    }

    @Override // java.io.InputStream
    public final int read() {
        int read;
        do {
            read = read(this.f٥٣١٣d);
            if (read == -1) {
                return -1;
            }
        } while (read == 0);
        if (read == 1) {
            return this.f٥٣١٣d[0] & UByte.MAX_VALUE;
        }
        throw new IllegalStateException(m.a(read, "Invalid return value from read: "));
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x017c, code lost:
    
        r24.f٥٣١٢c = r24.f٥٣١١b.f٥٣٠٧c.getBytesRead();
        count(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x018a, code lost:
    
        if (r13 != (-1)) goto L٧٧;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x018c, code lost:
    
        k0.a.c(r24.f٥٣١١b);
        r24.f٥٣١١b = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0194, code lost:
    
        return r13;
     */
    @Override // java.io.InputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int read(byte[] bArr, int i10, int i11) {
        int b10;
        long readBits;
        int i12 = 2;
        char c10 = 0;
        if (i11 == 0) {
            return 0;
        }
        b bVar = this.f٥٣١١b;
        if (bVar == null) {
            return -1;
        }
        while (true) {
            if (bVar.f٥٣٠٥a && !bVar.f٥٣٠٦b.d()) {
                b10 = -1;
                break;
            }
            if (bVar.f٥٣٠٦b.c() == 1) {
                bVar.f٥٣٠٥a = b.b(bVar.f٥٣٠٧c, 1) == 1;
                int b11 = (int) b.b(bVar.f٥٣٠٧c, i12);
                int i13 = 16;
                if (b11 == 0) {
                    bVar.f٥٣٠٧c.alignWithByteBoundary();
                    long b12 = b.b(bVar.f٥٣٠٧c, 16);
                    if ((65535 & (b12 ^ 65535)) == b.b(bVar.f٥٣٠٧c, 16)) {
                        bVar.f٥٣٠٦b = new a(bVar, b12);
                    } else {
                        throw new IllegalStateException("Illegal LEN / NLEN values");
                    }
                } else if (b11 == 1) {
                    bVar.f٥٣٠٦b = new g(bVar, 4, b.f٥٣٠٣i, b.f٥٣٠٤j);
                } else if (b11 == i12) {
                    int[] iArr = new int[(int) (b.b(bVar.f٥٣٠٧c, 5) + 257)];
                    int[] iArr2 = new int[(int) (b.b(bVar.f٥٣٠٧c, 5) + 1)];
                    int[][] iArr3 = new int[i12];
                    iArr3[c10] = iArr;
                    iArr3[1] = iArr2;
                    l lVar = bVar.f٥٣٠٧c;
                    int[] iArr4 = iArr3[c10];
                    int[] iArr5 = iArr3[1];
                    int b13 = (int) (b.b(lVar, 4) + 4);
                    int[] iArr6 = new int[19];
                    for (int i14 = 0; i14 < b13; i14++) {
                        int i15 = b.f٥٣٠٢h[i14];
                        long readBits2 = lVar.readBits(3);
                        if (readBits2 != -1) {
                            iArr6[i15] = (int) readBits2;
                        } else {
                            throw new EOFException("Truncated Deflate64 Stream");
                        }
                    }
                    e c11 = b.c(iArr6);
                    int length = iArr4.length + iArr5.length;
                    int[] iArr7 = new int[length];
                    int i16 = 0;
                    int i17 = 0;
                    int i18 = -1;
                    while (i16 < length) {
                        if (i17 > 0) {
                            iArr7[i16] = i18;
                            i17--;
                            i16++;
                        } else {
                            int a10 = b.a(lVar, c11);
                            if (a10 < i13) {
                                iArr7[i16] = a10;
                                i16++;
                                i18 = a10;
                            } else {
                                if (a10 == i13) {
                                    readBits = lVar.readBits(2);
                                    if (readBits == -1) {
                                        throw new EOFException("Truncated Deflate64 Stream");
                                    }
                                } else if (a10 == 17) {
                                    readBits = lVar.readBits(3);
                                    if (readBits == -1) {
                                        throw new EOFException("Truncated Deflate64 Stream");
                                    }
                                    i18 = 0;
                                } else if (a10 == 18) {
                                    long readBits3 = lVar.readBits(7);
                                    if (readBits3 == -1) {
                                        throw new EOFException("Truncated Deflate64 Stream");
                                    }
                                    i17 = (int) (readBits3 + 11);
                                    i13 = 16;
                                    i18 = 0;
                                } else {
                                    i13 = 16;
                                }
                                i17 = (int) (readBits + 3);
                                i13 = 16;
                            }
                        }
                    }
                    System.arraycopy(iArr7, 0, iArr4, 0, iArr4.length);
                    System.arraycopy(iArr7, iArr4.length, iArr5, 0, iArr5.length);
                    bVar.f٥٣٠٦b = new g(bVar, 3, iArr3[0], iArr3[1]);
                } else {
                    throw new IllegalStateException(m.a(b11, "Unsupported compression: "));
                }
            } else {
                b10 = bVar.f٥٣٠٦b.b(bArr, i10, i11);
                if (b10 != 0) {
                    break;
                }
            }
            i12 = 2;
            c10 = 0;
        }
    }
}
