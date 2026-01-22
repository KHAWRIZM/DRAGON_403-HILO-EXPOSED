package v4;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import kotlin.KotlinVersion;
import kotlin.UByte;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class n implements ImageHeaderParser {

    /* renamed from: a, reason: collision with root package name */
    static final byte[] f١٨٥٢٩a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f١٨٥٣٠b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class a implements c {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f١٨٥٣١a;

        a(ByteBuffer byteBuffer) {
            this.f١٨٥٣١a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // v4.n.c
        public int getUInt16() {
            return (getUInt8() << 8) | getUInt8();
        }

        @Override // v4.n.c
        public short getUInt8() {
            if (this.f١٨٥٣١a.remaining() >= 1) {
                return (short) (this.f١٨٥٣١a.get() & UByte.MAX_VALUE);
            }
            throw new c.a();
        }

        @Override // v4.n.c
        public int read(byte[] bArr, int i10) {
            int min = Math.min(i10, this.f١٨٥٣١a.remaining());
            if (min == 0) {
                return -1;
            }
            this.f١٨٥٣١a.get(bArr, 0, min);
            return min;
        }

        @Override // v4.n.c
        public long skip(long j10) {
            int min = (int) Math.min(this.f١٨٥٣١a.remaining(), j10);
            ByteBuffer byteBuffer = this.f١٨٥٣١a;
            byteBuffer.position(byteBuffer.position() + min);
            return min;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f١٨٥٣٢a;

        b(byte[] bArr, int i10) {
            this.f١٨٥٣٢a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i10);
        }

        private boolean c(int i10, int i11) {
            if (this.f١٨٥٣٢a.remaining() - i10 >= i11) {
                return true;
            }
            return false;
        }

        short a(int i10) {
            if (c(i10, 2)) {
                return this.f١٨٥٣٢a.getShort(i10);
            }
            return (short) -1;
        }

        int b(int i10) {
            if (c(i10, 4)) {
                return this.f١٨٥٣٢a.getInt(i10);
            }
            return -1;
        }

        int d() {
            return this.f١٨٥٣٢a.remaining();
        }

        void e(ByteOrder byteOrder) {
            this.f١٨٥٣٢a.order(byteOrder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface c {

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static final class a extends IOException {
            private static final long serialVersionUID = 1;

            a() {
                super("Unexpectedly reached end of a file");
            }
        }

        int getUInt16();

        short getUInt8();

        int read(byte[] bArr, int i10);

        long skip(long j10);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class d implements c {

        /* renamed from: a, reason: collision with root package name */
        private final InputStream f١٨٥٣٣a;

        d(InputStream inputStream) {
            this.f١٨٥٣٣a = inputStream;
        }

        @Override // v4.n.c
        public int getUInt16() {
            return (getUInt8() << 8) | getUInt8();
        }

        @Override // v4.n.c
        public short getUInt8() {
            int read = this.f١٨٥٣٣a.read();
            if (read != -1) {
                return (short) read;
            }
            throw new c.a();
        }

        @Override // v4.n.c
        public int read(byte[] bArr, int i10) {
            int i11 = 0;
            int i12 = 0;
            while (i11 < i10 && (i12 = this.f١٨٥٣٣a.read(bArr, i11, i10 - i11)) != -1) {
                i11 += i12;
            }
            if (i11 == 0 && i12 == -1) {
                throw new c.a();
            }
            return i11;
        }

        @Override // v4.n.c
        public long skip(long j10) {
            if (j10 < 0) {
                return 0L;
            }
            long j11 = j10;
            while (j11 > 0) {
                long skip = this.f١٨٥٣٣a.skip(j11);
                if (skip <= 0) {
                    if (this.f١٨٥٣٣a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j11 -= skip;
            }
            return j10 - j11;
        }
    }

    private static int e(int i10, int i11) {
        return i10 + 2 + (i11 * 12);
    }

    private int f(c cVar, p4.b bVar) {
        try {
            int uInt16 = cVar.getUInt16();
            if (!h(uInt16)) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + uInt16);
                }
                return -1;
            }
            int j10 = j(cVar);
            if (j10 == -1) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
                }
                return -1;
            }
            byte[] bArr = (byte[]) bVar.c(j10, byte[].class);
            try {
                return l(cVar, bArr, j10);
            } finally {
                bVar.put(bArr);
            }
        } catch (c.a unused) {
            return -1;
        }
    }

    private ImageHeaderParser.ImageType g(c cVar) {
        try {
            int uInt16 = cVar.getUInt16();
            if (uInt16 == 65496) {
                return ImageHeaderParser.ImageType.JPEG;
            }
            int uInt8 = (uInt16 << 8) | cVar.getUInt8();
            if (uInt8 == 4671814) {
                return ImageHeaderParser.ImageType.GIF;
            }
            int uInt82 = (uInt8 << 8) | cVar.getUInt8();
            if (uInt82 == -1991225785) {
                cVar.skip(21L);
                try {
                    if (cVar.getUInt8() >= 3) {
                        return ImageHeaderParser.ImageType.PNG_A;
                    }
                    return ImageHeaderParser.ImageType.PNG;
                } catch (c.a unused) {
                    return ImageHeaderParser.ImageType.PNG;
                }
            }
            if (uInt82 != 1380533830) {
                return m(cVar, uInt82);
            }
            cVar.skip(4L);
            if (((cVar.getUInt16() << 16) | cVar.getUInt16()) != 1464156752) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int uInt162 = (cVar.getUInt16() << 16) | cVar.getUInt16();
            if ((uInt162 & (-256)) != 1448097792) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int i10 = uInt162 & KotlinVersion.MAX_COMPONENT_VALUE;
            if (i10 == 88) {
                cVar.skip(4L);
                short uInt83 = cVar.getUInt8();
                if ((uInt83 & 2) != 0) {
                    return ImageHeaderParser.ImageType.ANIMATED_WEBP;
                }
                if ((uInt83 & 16) != 0) {
                    return ImageHeaderParser.ImageType.WEBP_A;
                }
                return ImageHeaderParser.ImageType.WEBP;
            }
            if (i10 == 76) {
                cVar.skip(4L);
                if ((cVar.getUInt8() & 8) != 0) {
                    return ImageHeaderParser.ImageType.WEBP_A;
                }
                return ImageHeaderParser.ImageType.WEBP;
            }
            return ImageHeaderParser.ImageType.WEBP;
        } catch (c.a unused2) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
    }

    private static boolean h(int i10) {
        if ((i10 & 65496) != 65496 && i10 != 19789 && i10 != 18761) {
            return false;
        }
        return true;
    }

    private boolean i(byte[] bArr, int i10) {
        boolean z10;
        if (bArr != null && i10 > f١٨٥٢٩a.length) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            int i11 = 0;
            while (true) {
                byte[] bArr2 = f١٨٥٢٩a;
                if (i11 >= bArr2.length) {
                    break;
                }
                if (bArr[i11] != bArr2[i11]) {
                    return false;
                }
                i11++;
            }
        }
        return z10;
    }

    private int j(c cVar) {
        short uInt8;
        int uInt16;
        long j10;
        long skip;
        do {
            short uInt82 = cVar.getUInt8();
            if (uInt82 != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown segmentId=" + ((int) uInt82));
                }
                return -1;
            }
            uInt8 = cVar.getUInt8();
            if (uInt8 == 218) {
                return -1;
            }
            if (uInt8 == 217) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            uInt16 = cVar.getUInt16() - 2;
            if (uInt8 != 225) {
                j10 = uInt16;
                skip = cVar.skip(j10);
            } else {
                return uInt16;
            }
        } while (skip == j10);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to skip enough data, type: " + ((int) uInt8) + ", wanted to skip: " + uInt16 + ", but actually skipped: " + skip);
        }
        return -1;
    }

    private static int k(b bVar) {
        ByteOrder byteOrder;
        short a10 = bVar.a(6);
        if (a10 != 18761) {
            if (a10 != 19789) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown endianness = " + ((int) a10));
                }
                byteOrder = ByteOrder.BIG_ENDIAN;
            } else {
                byteOrder = ByteOrder.BIG_ENDIAN;
            }
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        bVar.e(byteOrder);
        int b10 = bVar.b(10) + 6;
        short a11 = bVar.a(b10);
        for (int i10 = 0; i10 < a11; i10++) {
            int e10 = e(b10, i10);
            short a12 = bVar.a(e10);
            if (a12 == 274) {
                short a13 = bVar.a(e10 + 2);
                if (a13 >= 1 && a13 <= 12) {
                    int b11 = bVar.b(e10 + 4);
                    if (b11 < 0) {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Negative tiff component count");
                        }
                    } else {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got tagIndex=" + i10 + " tagType=" + ((int) a12) + " formatCode=" + ((int) a13) + " componentCount=" + b11);
                        }
                        int i11 = b11 + f١٨٥٣٠b[a13];
                        if (i11 > 4) {
                            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Log.d("DfltImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) a13));
                            }
                        } else {
                            int i12 = e10 + 8;
                            if (i12 >= 0 && i12 <= bVar.d()) {
                                if (i11 >= 0 && i11 + i12 <= bVar.d()) {
                                    return bVar.a(i12);
                                }
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) a12));
                                }
                            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Log.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + i12 + " tagType=" + ((int) a12));
                            }
                        }
                    }
                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Got invalid format code = " + ((int) a13));
                }
            }
        }
        return -1;
    }

    private int l(c cVar, byte[] bArr, int i10) {
        int read = cVar.read(bArr, i10);
        if (read != i10) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i10 + ", actually read: " + read);
            }
            return -1;
        }
        if (i(bArr, i10)) {
            return k(new b(bArr, i10));
        }
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
        }
        return -1;
    }

    private ImageHeaderParser.ImageType m(c cVar, int i10) {
        boolean z10;
        if (((cVar.getUInt16() << 16) | cVar.getUInt16()) != 1718909296) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        int uInt16 = (cVar.getUInt16() << 16) | cVar.getUInt16();
        if (uInt16 == 1635150195) {
            return ImageHeaderParser.ImageType.ANIMATED_AVIF;
        }
        int i11 = 0;
        if (uInt16 == 1635150182) {
            z10 = true;
        } else {
            z10 = false;
        }
        cVar.skip(4L);
        int i12 = i10 - 16;
        if (i12 % 4 == 0) {
            while (i11 < 5 && i12 > 0) {
                int uInt162 = (cVar.getUInt16() << 16) | cVar.getUInt16();
                if (uInt162 == 1635150195) {
                    return ImageHeaderParser.ImageType.ANIMATED_AVIF;
                }
                if (uInt162 == 1635150182) {
                    z10 = true;
                }
                i11++;
                i12 -= 4;
            }
        }
        if (z10) {
            return ImageHeaderParser.ImageType.AVIF;
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int a(InputStream inputStream, p4.b bVar) {
        return f(new d((InputStream) f5.k.d(inputStream)), (p4.b) f5.k.d(bVar));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int b(ByteBuffer byteBuffer, p4.b bVar) {
        return f(new a((ByteBuffer) f5.k.d(byteBuffer)), (p4.b) f5.k.d(bVar));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType c(ByteBuffer byteBuffer) {
        return g(new a((ByteBuffer) f5.k.d(byteBuffer)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType d(InputStream inputStream) {
        return g(new d((InputStream) f5.k.d(inputStream)));
    }
}
