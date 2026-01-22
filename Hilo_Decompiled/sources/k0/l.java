package k0;

import java.io.Closeable;
import java.io.InputStream;
import java.nio.ByteOrder;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class l implements Closeable {
    private static final long[] MASKS = new long[64];
    private static final int MAXIMUM_CACHE_SIZE = 63;
    private long bitsCached = 0;
    private int bitsCachedSize = 0;
    private final ByteOrder byteOrder;
    private final o in;

    static {
        for (int i10 = 1; i10 <= 63; i10++) {
            long[] jArr = MASKS;
            jArr[i10] = (jArr[i10 - 1] << 1) + 1;
        }
    }

    public l(InputStream inputStream, ByteOrder byteOrder) {
        this.in = new o(inputStream);
        this.byteOrder = byteOrder;
    }

    public void alignWithByteBoundary() {
        int i10 = this.bitsCachedSize;
        int i11 = i10 % 8;
        if (i11 > 0) {
            if (this.byteOrder == ByteOrder.LITTLE_ENDIAN) {
                long j10 = this.bitsCached;
                long j11 = MASKS[i11];
                this.bitsCached = j10 >>> i11;
            } else {
                long j12 = MASKS[i11];
            }
            this.bitsCachedSize = i10 - i11;
        }
    }

    public long bitsAvailable() {
        return (this.in.available() * 8) + this.bitsCachedSize;
    }

    public int bitsCached() {
        return this.bitsCachedSize;
    }

    public void clearBitCache() {
        this.bitsCached = 0L;
        this.bitsCachedSize = 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.in.close();
    }

    public long getBytesRead() {
        return this.in.getBytesRead();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003b, code lost:
    
        if (r0 >= r12) goto L٢٩;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003d, code lost:
    
        r0 = r12 - r0;
        r3 = 8 - r0;
        r4 = r11.in.read();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004a, code lost:
    
        if (r4 >= 0) goto L٢٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004c, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0051, code lost:
    
        if (r11.byteOrder != java.nio.ByteOrder.LITTLE_ENDIAN) goto L٢٦;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0053, code lost:
    
        r1 = k0.l.MASKS;
        r11.bitsCached = ((r1[r0] & r4) << r11.bitsCachedSize) | r11.bitsCached;
        r4 = r4 >>> r0;
        r0 = r1[r3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0063, code lost:
    
        r0 = r0 & r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0078, code lost:
    
        r4 = r11.bitsCached & k0.l.MASKS[r12];
        r11.bitsCached = r0;
        r11.bitsCachedSize = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0083, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0065, code lost:
    
        r1 = r11.bitsCached << r0;
        r11.bitsCached = r1;
        r8 = k0.l.MASKS;
        r11.bitsCached = r1 | ((r4 >>> r3) & r8[r0]);
        r0 = r8[r3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0088, code lost:
    
        if (r11.byteOrder != java.nio.ByteOrder.LITTLE_ENDIAN) goto L٣٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x008a, code lost:
    
        r1 = r11.bitsCached;
        r3 = r1 & k0.l.MASKS[r12];
        r11.bitsCached = r1 >>> r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a1, code lost:
    
        r11.bitsCachedSize = r0 - r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a4, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0096, code lost:
    
        r3 = (r11.bitsCached >> (r0 - r12)) & k0.l.MASKS[r12];
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long readBits(int i10) {
        if (i10 < 0 || i10 > 63) {
            throw new IllegalArgumentException("count must not be negative or greater than 63");
        }
        while (true) {
            int i11 = this.bitsCachedSize;
            if (i11 >= i10 || i11 >= 57) {
                break;
            }
            long read = this.in.read();
            if (read < 0) {
                return -1L;
            }
            if (this.byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.bitsCached |= read << this.bitsCachedSize;
            } else {
                this.bitsCached = (this.bitsCached << 8) | read;
            }
            this.bitsCachedSize += 8;
        }
    }
}
