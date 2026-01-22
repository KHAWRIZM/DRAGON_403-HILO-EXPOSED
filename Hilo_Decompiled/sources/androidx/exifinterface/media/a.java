package androidx.exifinterface.media;

import android.content.res.AssetManager;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.OsConstants;
import android.util.Log;
import android.util.Pair;
import androidx.exifinterface.media.b;
import com.amazonaws.services.s3.internal.Constants;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.facebook.internal.security.CertificateUtil;
import com.oudi.utils.date.DateFormat;
import com.qiahao.base_common.network.BaseServer;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import kotlin.KotlinVersion;
import kotlin.UByte;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a {
    private static SimpleDateFormat U;
    private static SimpleDateFormat V;
    private static final e[] Z;

    /* renamed from: a0, reason: collision with root package name */
    private static final e[] f٣٦٨٨a0;

    /* renamed from: b0, reason: collision with root package name */
    private static final e[] f٣٦٨٩b0;

    /* renamed from: c0, reason: collision with root package name */
    private static final e[] f٣٦٩٠c0;

    /* renamed from: d0, reason: collision with root package name */
    private static final e[] f٣٦٩١d0;

    /* renamed from: e0, reason: collision with root package name */
    private static final e f٣٦٩٢e0;

    /* renamed from: f0, reason: collision with root package name */
    private static final e[] f٣٦٩٣f0;

    /* renamed from: g0, reason: collision with root package name */
    private static final e[] f٣٦٩٤g0;

    /* renamed from: h0, reason: collision with root package name */
    private static final e[] f٣٦٩٥h0;

    /* renamed from: i0, reason: collision with root package name */
    private static final e[] f٣٦٩٦i0;

    /* renamed from: j0, reason: collision with root package name */
    static final e[][] f٣٦٩٧j0;

    /* renamed from: k0, reason: collision with root package name */
    private static final e[] f٣٦٩٨k0;

    /* renamed from: l0, reason: collision with root package name */
    private static final HashMap[] f٣٦٩٩l0;

    /* renamed from: m0, reason: collision with root package name */
    private static final HashMap[] f٣٧٠٠m0;

    /* renamed from: n0, reason: collision with root package name */
    private static final HashSet f٣٧٠١n0;

    /* renamed from: o0, reason: collision with root package name */
    private static final HashMap f٣٧٠٢o0;

    /* renamed from: p0, reason: collision with root package name */
    static final Charset f٣٧٠٣p0;

    /* renamed from: q0, reason: collision with root package name */
    static final byte[] f٣٧٠٤q0;

    /* renamed from: r0, reason: collision with root package name */
    private static final byte[] f٣٧٠٥r0;

    /* renamed from: s0, reason: collision with root package name */
    private static final Pattern f٣٧٠٦s0;

    /* renamed from: t0, reason: collision with root package name */
    private static final Pattern f٣٧٠٧t0;

    /* renamed from: u0, reason: collision with root package name */
    private static final Pattern f٣٧٠٨u0;

    /* renamed from: v0, reason: collision with root package name */
    private static final Pattern f٣٧١٠v0;

    /* renamed from: a, reason: collision with root package name */
    private String f٣٧١٥a;

    /* renamed from: b, reason: collision with root package name */
    private FileDescriptor f٣٧١٦b;

    /* renamed from: c, reason: collision with root package name */
    private AssetManager.AssetInputStream f٣٧١٧c;

    /* renamed from: d, reason: collision with root package name */
    private int f٣٧١٨d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f٣٧١٩e;

    /* renamed from: f, reason: collision with root package name */
    private final HashMap[] f٣٧٢٠f;

    /* renamed from: g, reason: collision with root package name */
    private Set f٣٧٢١g;

    /* renamed from: h, reason: collision with root package name */
    private ByteOrder f٣٧٢٢h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f٣٧٢٣i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f٣٧٢٤j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f٣٧٢٥k;

    /* renamed from: l, reason: collision with root package name */
    private int f٣٧٢٦l;

    /* renamed from: m, reason: collision with root package name */
    private int f٣٧٢٧m;

    /* renamed from: n, reason: collision with root package name */
    private byte[] f٣٧٢٨n;

    /* renamed from: o, reason: collision with root package name */
    private int f٣٧٢٩o;

    /* renamed from: p, reason: collision with root package name */
    private int f٣٧٣٠p;

    /* renamed from: q, reason: collision with root package name */
    private int f٣٧٣١q;

    /* renamed from: r, reason: collision with root package name */
    private int f٣٧٣٢r;

    /* renamed from: s, reason: collision with root package name */
    private int f٣٧٣٣s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f٣٧٣٤t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f٣٧٣٥u;

    /* renamed from: v, reason: collision with root package name */
    private static final boolean f٣٧٠٩v = Log.isLoggable("ExifInterface", 3);

    /* renamed from: w, reason: collision with root package name */
    private static final List f٣٧١١w = Arrays.asList(1, 6, 3, 8);

    /* renamed from: x, reason: collision with root package name */
    private static final List f٣٧١٢x = Arrays.asList(2, 7, 4, 5);

    /* renamed from: y, reason: collision with root package name */
    public static final int[] f٣٧١٣y = {8, 8, 8};

    /* renamed from: z, reason: collision with root package name */
    public static final int[] f٣٧١٤z = {4};
    public static final int[] A = {8};

    /* renamed from: B, reason: collision with root package name */
    static final byte[] f٣٦٨٧B = {-1, -40, -1};
    private static final byte[] C = {102, 116, 121, 112};
    private static final byte[] D = {109, 105, 102, 49};
    private static final byte[] E = {104, 101, 105, 99};
    private static final byte[] F = {79, 76, 89, 77, 80, 0};
    private static final byte[] G = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    private static final byte[] H = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final byte[] I = {101, 88, 73, 102};
    private static final byte[] J = {73, 72, 68, 82};
    private static final byte[] K = {73, 69, 78, 68};
    private static final byte[] L = {82, 73, 70, 70};
    private static final byte[] M = {87, 69, 66, 80};
    private static final byte[] N = {69, 88, 73, 70};
    private static final byte[] O = {-99, 1, 42};
    private static final byte[] P = "VP8X".getBytes(Charset.defaultCharset());
    private static final byte[] Q = "VP8L".getBytes(Charset.defaultCharset());
    private static final byte[] R = "VP8 ".getBytes(Charset.defaultCharset());
    private static final byte[] S = "ANIM".getBytes(Charset.defaultCharset());
    private static final byte[] T = "ANMF".getBytes(Charset.defaultCharset());
    static final String[] W = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    static final int[] X = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    static final byte[] Y = {65, 83, 67, 73, 73, 0, 0, 0};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.exifinterface.media.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class C٠٠٤٠a extends MediaDataSource {

        /* renamed from: a, reason: collision with root package name */
        long f٣٧٣٦a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ g f٣٧٣٧b;

        C٠٠٤٠a(g gVar) {
            this.f٣٧٣٧b = gVar;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        public long getSize() {
            return -1L;
        }

        public int readAt(long j10, byte[] bArr, int i10, int i11) {
            if (i11 == 0) {
                return 0;
            }
            if (j10 < 0) {
                return -1;
            }
            try {
                long j11 = this.f٣٧٣٦a;
                if (j11 != j10) {
                    if (j11 >= 0 && j10 >= j11 + this.f٣٧٣٧b.available()) {
                        return -1;
                    }
                    this.f٣٧٣٧b.h(j10);
                    this.f٣٧٣٦a = j10;
                }
                if (i11 > this.f٣٧٣٧b.available()) {
                    i11 = this.f٣٧٣٧b.available();
                }
                int read = this.f٣٧٣٧b.read(bArr, i10, i11);
                if (read >= 0) {
                    this.f٣٧٣٦a += read;
                    return read;
                }
            } catch (IOException unused) {
            }
            this.f٣٧٣٦a = -1L;
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class b extends InputStream implements DataInput {

        /* renamed from: e, reason: collision with root package name */
        private static final ByteOrder f٣٧٣٩e = ByteOrder.LITTLE_ENDIAN;

        /* renamed from: f, reason: collision with root package name */
        private static final ByteOrder f٣٧٤٠f = ByteOrder.BIG_ENDIAN;

        /* renamed from: a, reason: collision with root package name */
        final DataInputStream f٣٧٤١a;

        /* renamed from: b, reason: collision with root package name */
        private ByteOrder f٣٧٤٢b;

        /* renamed from: c, reason: collision with root package name */
        int f٣٧٤٣c;

        /* renamed from: d, reason: collision with root package name */
        private byte[] f٣٧٤٤d;

        b(byte[] bArr) {
            this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
        }

        public int a() {
            return this.f٣٧٤٣c;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f٣٧٤١a.available();
        }

        public long b() {
            return readInt() & 4294967295L;
        }

        public void c(ByteOrder byteOrder) {
            this.f٣٧٤٢b = byteOrder;
        }

        public void g(int i10) {
            int i11 = 0;
            while (i11 < i10) {
                int i12 = i10 - i11;
                int skip = (int) this.f٣٧٤١a.skip(i12);
                if (skip <= 0) {
                    if (this.f٣٧٤٤d == null) {
                        this.f٣٧٤٤d = new byte[8192];
                    }
                    skip = this.f٣٧٤١a.read(this.f٣٧٤٤d, 0, Math.min(8192, i12));
                    if (skip == -1) {
                        throw new EOFException("Reached EOF while skipping " + i10 + " bytes.");
                    }
                }
                i11 += skip;
            }
            this.f٣٧٤٣c += i11;
        }

        @Override // java.io.InputStream
        public void mark(int i10) {
            throw new UnsupportedOperationException("Mark is currently unsupported");
        }

        @Override // java.io.InputStream
        public int read() {
            this.f٣٧٤٣c++;
            return this.f٣٧٤١a.read();
        }

        @Override // java.io.DataInput
        public boolean readBoolean() {
            this.f٣٧٤٣c++;
            return this.f٣٧٤١a.readBoolean();
        }

        @Override // java.io.DataInput
        public byte readByte() {
            this.f٣٧٤٣c++;
            int read = this.f٣٧٤١a.read();
            if (read >= 0) {
                return (byte) read;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() {
            this.f٣٧٤٣c += 2;
            return this.f٣٧٤١a.readChar();
        }

        @Override // java.io.DataInput
        public double readDouble() {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public float readFloat() {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i10, int i11) {
            this.f٣٧٤٣c += i11;
            this.f٣٧٤١a.readFully(bArr, i10, i11);
        }

        @Override // java.io.DataInput
        public int readInt() {
            this.f٣٧٤٣c += 4;
            int read = this.f٣٧٤١a.read();
            int read2 = this.f٣٧٤١a.read();
            int read3 = this.f٣٧٤١a.read();
            int read4 = this.f٣٧٤١a.read();
            if ((read | read2 | read3 | read4) >= 0) {
                ByteOrder byteOrder = this.f٣٧٤٢b;
                if (byteOrder == f٣٧٣٩e) {
                    return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                }
                if (byteOrder == f٣٧٤٠f) {
                    return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                }
                throw new IOException("Invalid byte order: " + this.f٣٧٤٢b);
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public String readLine() {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public long readLong() {
            this.f٣٧٤٣c += 8;
            int read = this.f٣٧٤١a.read();
            int read2 = this.f٣٧٤١a.read();
            int read3 = this.f٣٧٤١a.read();
            int read4 = this.f٣٧٤١a.read();
            int read5 = this.f٣٧٤١a.read();
            int read6 = this.f٣٧٤١a.read();
            int read7 = this.f٣٧٤١a.read();
            int read8 = this.f٣٧٤١a.read();
            if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                ByteOrder byteOrder = this.f٣٧٤٢b;
                if (byteOrder == f٣٧٣٩e) {
                    return (read8 << 56) + (read7 << 48) + (read6 << 40) + (read5 << 32) + (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                }
                if (byteOrder == f٣٧٤٠f) {
                    return (read << 56) + (read2 << 48) + (read3 << 40) + (read4 << 32) + (read5 << 24) + (read6 << 16) + (read7 << 8) + read8;
                }
                throw new IOException("Invalid byte order: " + this.f٣٧٤٢b);
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public short readShort() {
            this.f٣٧٤٣c += 2;
            int read = this.f٣٧٤١a.read();
            int read2 = this.f٣٧٤١a.read();
            if ((read | read2) >= 0) {
                ByteOrder byteOrder = this.f٣٧٤٢b;
                if (byteOrder == f٣٧٣٩e) {
                    return (short) ((read2 << 8) + read);
                }
                if (byteOrder == f٣٧٤٠f) {
                    return (short) ((read << 8) + read2);
                }
                throw new IOException("Invalid byte order: " + this.f٣٧٤٢b);
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public String readUTF() {
            this.f٣٧٤٣c += 2;
            return this.f٣٧٤١a.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() {
            this.f٣٧٤٣c++;
            return this.f٣٧٤١a.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() {
            this.f٣٧٤٣c += 2;
            int read = this.f٣٧٤١a.read();
            int read2 = this.f٣٧٤١a.read();
            if ((read | read2) >= 0) {
                ByteOrder byteOrder = this.f٣٧٤٢b;
                if (byteOrder == f٣٧٣٩e) {
                    return (read2 << 8) + read;
                }
                if (byteOrder == f٣٧٤٠f) {
                    return (read << 8) + read2;
                }
                throw new IOException("Invalid byte order: " + this.f٣٧٤٢b);
            }
            throw new EOFException();
        }

        @Override // java.io.InputStream
        public void reset() {
            throw new UnsupportedOperationException("Reset is currently unsupported");
        }

        @Override // java.io.DataInput
        public int skipBytes(int i10) {
            throw new UnsupportedOperationException("skipBytes is currently unsupported");
        }

        b(InputStream inputStream) {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        b(InputStream inputStream, ByteOrder byteOrder) {
            this.f٣٧٤٢b = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.f٣٧٤١a = dataInputStream;
            dataInputStream.mark(0);
            this.f٣٧٤٣c = 0;
            this.f٣٧٤٢b = byteOrder;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) {
            int read = this.f٣٧٤١a.read(bArr, i10, i11);
            this.f٣٧٤٣c += read;
            return read;
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) {
            this.f٣٧٤٣c += bArr.length;
            this.f٣٧٤١a.readFully(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class c extends FilterOutputStream {

        /* renamed from: a, reason: collision with root package name */
        final OutputStream f٣٧٤٥a;

        /* renamed from: b, reason: collision with root package name */
        private ByteOrder f٣٧٤٦b;

        public c(OutputStream outputStream, ByteOrder byteOrder) {
            super(outputStream);
            this.f٣٧٤٥a = outputStream;
            this.f٣٧٤٦b = byteOrder;
        }

        public void a(ByteOrder byteOrder) {
            this.f٣٧٤٦b = byteOrder;
        }

        public void b(int i10) {
            this.f٣٧٤٥a.write(i10);
        }

        public void c(int i10) {
            ByteOrder byteOrder = this.f٣٧٤٦b;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.f٣٧٤٥a.write(i10 & KotlinVersion.MAX_COMPONENT_VALUE);
                this.f٣٧٤٥a.write((i10 >>> 8) & KotlinVersion.MAX_COMPONENT_VALUE);
                this.f٣٧٤٥a.write((i10 >>> 16) & KotlinVersion.MAX_COMPONENT_VALUE);
                this.f٣٧٤٥a.write((i10 >>> 24) & KotlinVersion.MAX_COMPONENT_VALUE);
                return;
            }
            if (byteOrder == ByteOrder.BIG_ENDIAN) {
                this.f٣٧٤٥a.write((i10 >>> 24) & KotlinVersion.MAX_COMPONENT_VALUE);
                this.f٣٧٤٥a.write((i10 >>> 16) & KotlinVersion.MAX_COMPONENT_VALUE);
                this.f٣٧٤٥a.write((i10 >>> 8) & KotlinVersion.MAX_COMPONENT_VALUE);
                this.f٣٧٤٥a.write(i10 & KotlinVersion.MAX_COMPONENT_VALUE);
            }
        }

        public void g(short s10) {
            ByteOrder byteOrder = this.f٣٧٤٦b;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.f٣٧٤٥a.write(s10 & 255);
                this.f٣٧٤٥a.write((s10 >>> 8) & KotlinVersion.MAX_COMPONENT_VALUE);
            } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
                this.f٣٧٤٥a.write((s10 >>> 8) & KotlinVersion.MAX_COMPONENT_VALUE);
                this.f٣٧٤٥a.write(s10 & 255);
            }
        }

        public void h(long j10) {
            c((int) j10);
        }

        public void j(int i10) {
            g((short) i10);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr) {
            this.f٣٧٤٥a.write(bArr);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) {
            this.f٣٧٤٥a.write(bArr, i10, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f٣٧٤٧a;

        /* renamed from: b, reason: collision with root package name */
        public final int f٣٧٤٨b;

        /* renamed from: c, reason: collision with root package name */
        public final long f٣٧٤٩c;

        /* renamed from: d, reason: collision with root package name */
        public final byte[] f٣٧٥٠d;

        d(int i10, int i11, byte[] bArr) {
            this(i10, i11, -1L, bArr);
        }

        public static d a(String str) {
            if (str.length() == 1 && str.charAt(0) >= '0' && str.charAt(0) <= '1') {
                return new d(1, 1, new byte[]{(byte) (str.charAt(0) - '0')});
            }
            byte[] bytes = str.getBytes(a.f٣٧٠٣p0);
            return new d(1, bytes.length, bytes);
        }

        public static d b(double[] dArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.X[12] * dArr.length]);
            wrap.order(byteOrder);
            for (double d10 : dArr) {
                wrap.putDouble(d10);
            }
            return new d(12, dArr.length, wrap.array());
        }

        public static d c(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.X[9] * iArr.length]);
            wrap.order(byteOrder);
            for (int i10 : iArr) {
                wrap.putInt(i10);
            }
            return new d(9, iArr.length, wrap.array());
        }

        public static d d(f[] fVarArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.X[10] * fVarArr.length]);
            wrap.order(byteOrder);
            for (f fVar : fVarArr) {
                wrap.putInt((int) fVar.f٣٧٥٥a);
                wrap.putInt((int) fVar.f٣٧٥٦b);
            }
            return new d(10, fVarArr.length, wrap.array());
        }

        public static d e(String str) {
            byte[] bytes = (str + (char) 0).getBytes(a.f٣٧٠٣p0);
            return new d(2, bytes.length, bytes);
        }

        public static d f(long j10, ByteOrder byteOrder) {
            return g(new long[]{j10}, byteOrder);
        }

        public static d g(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.X[4] * jArr.length]);
            wrap.order(byteOrder);
            for (long j10 : jArr) {
                wrap.putInt((int) j10);
            }
            return new d(4, jArr.length, wrap.array());
        }

        public static d h(f fVar, ByteOrder byteOrder) {
            return i(new f[]{fVar}, byteOrder);
        }

        public static d i(f[] fVarArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.X[5] * fVarArr.length]);
            wrap.order(byteOrder);
            for (f fVar : fVarArr) {
                wrap.putInt((int) fVar.f٣٧٥٥a);
                wrap.putInt((int) fVar.f٣٧٥٦b);
            }
            return new d(5, fVarArr.length, wrap.array());
        }

        public static d j(int i10, ByteOrder byteOrder) {
            return k(new int[]{i10}, byteOrder);
        }

        public static d k(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.X[3] * iArr.length]);
            wrap.order(byteOrder);
            for (int i10 : iArr) {
                wrap.putShort((short) i10);
            }
            return new d(3, iArr.length, wrap.array());
        }

        public double l(ByteOrder byteOrder) {
            Object o10 = o(byteOrder);
            if (o10 != null) {
                if (o10 instanceof String) {
                    return Double.parseDouble((String) o10);
                }
                if (o10 instanceof long[]) {
                    if (((long[]) o10).length == 1) {
                        return r5[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                }
                if (o10 instanceof int[]) {
                    if (((int[]) o10).length == 1) {
                        return r5[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                }
                if (o10 instanceof double[]) {
                    double[] dArr = (double[]) o10;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                }
                if (o10 instanceof f[]) {
                    f[] fVarArr = (f[]) o10;
                    if (fVarArr.length == 1) {
                        return fVarArr[0].a();
                    }
                    throw new NumberFormatException("There are more than one component");
                }
                throw new NumberFormatException("Couldn't find a double value");
            }
            throw new NumberFormatException("NULL can't be converted to a double value");
        }

        public int m(ByteOrder byteOrder) {
            Object o10 = o(byteOrder);
            if (o10 != null) {
                if (o10 instanceof String) {
                    return Integer.parseInt((String) o10);
                }
                if (o10 instanceof long[]) {
                    long[] jArr = (long[]) o10;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                }
                if (o10 instanceof int[]) {
                    int[] iArr = (int[]) o10;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                }
                throw new NumberFormatException("Couldn't find a integer value");
            }
            throw new NumberFormatException("NULL can't be converted to a integer value");
        }

        public String n(ByteOrder byteOrder) {
            Object o10 = o(byteOrder);
            if (o10 == null) {
                return null;
            }
            if (o10 instanceof String) {
                return (String) o10;
            }
            StringBuilder sb = new StringBuilder();
            int i10 = 0;
            if (o10 instanceof long[]) {
                long[] jArr = (long[]) o10;
                while (i10 < jArr.length) {
                    sb.append(jArr[i10]);
                    i10++;
                    if (i10 != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (o10 instanceof int[]) {
                int[] iArr = (int[]) o10;
                while (i10 < iArr.length) {
                    sb.append(iArr[i10]);
                    i10++;
                    if (i10 != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (o10 instanceof double[]) {
                double[] dArr = (double[]) o10;
                while (i10 < dArr.length) {
                    sb.append(dArr[i10]);
                    i10++;
                    if (i10 != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (!(o10 instanceof f[])) {
                return null;
            }
            f[] fVarArr = (f[]) o10;
            while (i10 < fVarArr.length) {
                sb.append(fVarArr[i10].f٣٧٥٥a);
                sb.append('/');
                sb.append(fVarArr[i10].f٣٧٥٦b);
                i10++;
                if (i10 != fVarArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }

        /* JADX WARN: Not initialized variable reg: 5, insn: 0x0030: MOVE (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]) (LINE:49), block:B:166:0x0030 */
        /* JADX WARN: Removed duplicated region for block: B:169:0x018f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        Object o(ByteOrder byteOrder) {
            b bVar;
            InputStream inputStream;
            byte b10;
            byte b11;
            int i10 = 0;
            InputStream inputStream2 = null;
            try {
                try {
                    bVar = new b(this.f٣٧٥٠d);
                    try {
                        bVar.c(byteOrder);
                        switch (this.f٣٧٤٧a) {
                            case 1:
                            case 6:
                                byte[] bArr = this.f٣٧٥٠d;
                                if (bArr.length == 1 && (b10 = bArr[0]) >= 0 && b10 <= 1) {
                                    String str = new String(new char[]{(char) (b10 + 48)});
                                    try {
                                        bVar.close();
                                    } catch (IOException e10) {
                                        Log.e("ExifInterface", "IOException occurred while closing InputStream", e10);
                                    }
                                    return str;
                                }
                                String str2 = new String(bArr, a.f٣٧٠٣p0);
                                try {
                                    bVar.close();
                                } catch (IOException e11) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e11);
                                }
                                return str2;
                            case 2:
                            case 7:
                                if (this.f٣٧٤٨b >= a.Y.length) {
                                    int i11 = 0;
                                    while (true) {
                                        byte[] bArr2 = a.Y;
                                        if (i11 < bArr2.length) {
                                            if (this.f٣٧٥٠d[i11] == bArr2[i11]) {
                                                i11++;
                                            }
                                        } else {
                                            i10 = bArr2.length;
                                        }
                                    }
                                }
                                StringBuilder sb = new StringBuilder();
                                while (i10 < this.f٣٧٤٨b && (b11 = this.f٣٧٥٠d[i10]) != 0) {
                                    if (b11 >= 32) {
                                        sb.append((char) b11);
                                    } else {
                                        sb.append('?');
                                    }
                                    i10++;
                                }
                                String sb2 = sb.toString();
                                try {
                                    bVar.close();
                                } catch (IOException e12) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e12);
                                }
                                return sb2;
                            case 3:
                                int[] iArr = new int[this.f٣٧٤٨b];
                                while (i10 < this.f٣٧٤٨b) {
                                    iArr[i10] = bVar.readUnsignedShort();
                                    i10++;
                                }
                                try {
                                    bVar.close();
                                } catch (IOException e13) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e13);
                                }
                                return iArr;
                            case 4:
                                long[] jArr = new long[this.f٣٧٤٨b];
                                while (i10 < this.f٣٧٤٨b) {
                                    jArr[i10] = bVar.b();
                                    i10++;
                                }
                                try {
                                    bVar.close();
                                } catch (IOException e14) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e14);
                                }
                                return jArr;
                            case 5:
                                f[] fVarArr = new f[this.f٣٧٤٨b];
                                while (i10 < this.f٣٧٤٨b) {
                                    fVarArr[i10] = new f(bVar.b(), bVar.b());
                                    i10++;
                                }
                                try {
                                    bVar.close();
                                } catch (IOException e15) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e15);
                                }
                                return fVarArr;
                            case 8:
                                int[] iArr2 = new int[this.f٣٧٤٨b];
                                while (i10 < this.f٣٧٤٨b) {
                                    iArr2[i10] = bVar.readShort();
                                    i10++;
                                }
                                try {
                                    bVar.close();
                                } catch (IOException e16) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e16);
                                }
                                return iArr2;
                            case 9:
                                int[] iArr3 = new int[this.f٣٧٤٨b];
                                while (i10 < this.f٣٧٤٨b) {
                                    iArr3[i10] = bVar.readInt();
                                    i10++;
                                }
                                try {
                                    bVar.close();
                                } catch (IOException e17) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e17);
                                }
                                return iArr3;
                            case 10:
                                f[] fVarArr2 = new f[this.f٣٧٤٨b];
                                while (i10 < this.f٣٧٤٨b) {
                                    fVarArr2[i10] = new f(bVar.readInt(), bVar.readInt());
                                    i10++;
                                }
                                try {
                                    bVar.close();
                                } catch (IOException e18) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e18);
                                }
                                return fVarArr2;
                            case 11:
                                double[] dArr = new double[this.f٣٧٤٨b];
                                while (i10 < this.f٣٧٤٨b) {
                                    dArr[i10] = bVar.readFloat();
                                    i10++;
                                }
                                try {
                                    bVar.close();
                                } catch (IOException e19) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e19);
                                }
                                return dArr;
                            case 12:
                                double[] dArr2 = new double[this.f٣٧٤٨b];
                                while (i10 < this.f٣٧٤٨b) {
                                    dArr2[i10] = bVar.readDouble();
                                    i10++;
                                }
                                try {
                                    bVar.close();
                                } catch (IOException e20) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e20);
                                }
                                return dArr2;
                            default:
                                try {
                                    bVar.close();
                                } catch (IOException e21) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e21);
                                }
                                return null;
                        }
                    } catch (IOException e22) {
                        e = e22;
                        Log.w("ExifInterface", "IOException occurred during reading a value", e);
                        if (bVar != null) {
                            try {
                                bVar.close();
                            } catch (IOException e23) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e23);
                            }
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e24) {
                            Log.e("ExifInterface", "IOException occurred while closing InputStream", e24);
                        }
                    }
                    throw th;
                }
            } catch (IOException e25) {
                e = e25;
                bVar = null;
            } catch (Throwable th2) {
                th = th2;
                if (inputStream2 != null) {
                }
                throw th;
            }
        }

        public int p() {
            return a.X[this.f٣٧٤٧a] * this.f٣٧٤٨b;
        }

        public String toString() {
            return "(" + a.W[this.f٣٧٤٧a] + ", data length:" + this.f٣٧٥٠d.length + ")";
        }

        d(int i10, int i11, long j10, byte[] bArr) {
            this.f٣٧٤٧a = i10;
            this.f٣٧٤٨b = i11;
            this.f٣٧٤٩c = j10;
            this.f٣٧٥٠d = bArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public final long f٣٧٥٥a;

        /* renamed from: b, reason: collision with root package name */
        public final long f٣٧٥٦b;

        f(double d10) {
            this((long) (d10 * 10000.0d), BaseServer.TIMEOUT_DEBUG);
        }

        public double a() {
            return this.f٣٧٥٥a / this.f٣٧٥٦b;
        }

        public String toString() {
            return this.f٣٧٥٥a + "/" + this.f٣٧٥٦b;
        }

        f(long j10, long j11) {
            if (j11 == 0) {
                this.f٣٧٥٥a = 0L;
                this.f٣٧٥٦b = 1L;
            } else {
                this.f٣٧٥٥a = j10;
                this.f٣٧٥٦b = j11;
            }
        }
    }

    static {
        e[] eVarArr = {new e("NewSubfileType", 254, 4), new e("SubfileType", KotlinVersion.MAX_COMPONENT_VALUE, 4), new e("ImageWidth", 256, 3, 4), new e("ImageLength", 257, 3, 4), new e("BitsPerSample", 258, 3), new e("Compression", 259, 3), new e("PhotometricInterpretation", 262, 3), new e("ImageDescription", SubsamplingScaleImageView.ORIENTATION_270, 2), new e("Make", 271, 2), new e("Model", 272, 2), new e("StripOffsets", 273, 3, 4), new e("Orientation", 274, 3), new e("SamplesPerPixel", 277, 3), new e("RowsPerStrip", 278, 3, 4), new e("StripByteCounts", 279, 3, 4), new e("XResolution", 282, 5), new e("YResolution", 283, 5), new e("PlanarConfiguration", 284, 3), new e("ResolutionUnit", 296, 3), new e("TransferFunction", Constants.BUCKET_REDIRECT_STATUS_CODE, 3), new e("Software", 305, 2), new e("DateTime", 306, 2), new e("Artist", 315, 2), new e("WhitePoint", 318, 5), new e("PrimaryChromaticities", 319, 5), new e("SubIFDPointer", 330, 4), new e("JPEGInterchangeFormat", 513, 4), new e("JPEGInterchangeFormatLength", 514, 4), new e("YCbCrCoefficients", 529, 5), new e("YCbCrSubSampling", 530, 3), new e("YCbCrPositioning", 531, 3), new e("ReferenceBlackWhite", 532, 5), new e("Copyright", 33432, 2), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("SensorTopBorder", 4, 4), new e("SensorLeftBorder", 5, 4), new e("SensorBottomBorder", 6, 4), new e("SensorRightBorder", 7, 4), new e("ISO", 23, 3), new e("JpgFromRaw", 46, 7), new e("Xmp", 700, 1)};
        Z = eVarArr;
        e[] eVarArr2 = {new e("ExposureTime", 33434, 5), new e("FNumber", 33437, 5), new e("ExposureProgram", 34850, 3), new e("SpectralSensitivity", 34852, 2), new e("PhotographicSensitivity", 34855, 3), new e("OECF", 34856, 7), new e("SensitivityType", 34864, 3), new e("StandardOutputSensitivity", 34865, 4), new e("RecommendedExposureIndex", 34866, 4), new e("ISOSpeed", 34867, 4), new e("ISOSpeedLatitudeyyy", 34868, 4), new e("ISOSpeedLatitudezzz", 34869, 4), new e("ExifVersion", 36864, 2), new e("DateTimeOriginal", 36867, 2), new e("DateTimeDigitized", 36868, 2), new e("OffsetTime", 36880, 2), new e("OffsetTimeOriginal", 36881, 2), new e("OffsetTimeDigitized", 36882, 2), new e("ComponentsConfiguration", 37121, 7), new e("CompressedBitsPerPixel", 37122, 5), new e("ShutterSpeedValue", 37377, 10), new e("ApertureValue", 37378, 5), new e("BrightnessValue", 37379, 10), new e("ExposureBiasValue", 37380, 10), new e("MaxApertureValue", 37381, 5), new e("SubjectDistance", 37382, 5), new e("MeteringMode", 37383, 3), new e("LightSource", 37384, 3), new e("Flash", 37385, 3), new e("FocalLength", 37386, 5), new e("SubjectArea", 37396, 3), new e("MakerNote", 37500, 7), new e("UserComment", 37510, 7), new e("SubSecTime", 37520, 2), new e("SubSecTimeOriginal", 37521, 2), new e("SubSecTimeDigitized", 37522, 2), new e("FlashpixVersion", 40960, 7), new e("ColorSpace", 40961, 3), new e("PixelXDimension", 40962, 3, 4), new e("PixelYDimension", 40963, 3, 4), new e("RelatedSoundFile", 40964, 2), new e("InteroperabilityIFDPointer", 40965, 4), new e("FlashEnergy", 41483, 5), new e("SpatialFrequencyResponse", 41484, 7), new e("FocalPlaneXResolution", 41486, 5), new e("FocalPlaneYResolution", 41487, 5), new e("FocalPlaneResolutionUnit", 41488, 3), new e("SubjectLocation", 41492, 3), new e("ExposureIndex", 41493, 5), new e("SensingMethod", 41495, 3), new e("FileSource", 41728, 7), new e("SceneType", 41729, 7), new e("CFAPattern", 41730, 7), new e("CustomRendered", 41985, 3), new e("ExposureMode", 41986, 3), new e("WhiteBalance", 41987, 3), new e("DigitalZoomRatio", 41988, 5), new e("FocalLengthIn35mmFilm", 41989, 3), new e("SceneCaptureType", 41990, 3), new e("GainControl", 41991, 3), new e("Contrast", 41992, 3), new e("Saturation", 41993, 3), new e("Sharpness", 41994, 3), new e("DeviceSettingDescription", 41995, 7), new e("SubjectDistanceRange", 41996, 3), new e("ImageUniqueID", 42016, 2), new e("CameraOwnerName", 42032, 2), new e("BodySerialNumber", 42033, 2), new e("LensSpecification", 42034, 5), new e("LensMake", 42035, 2), new e("LensModel", 42036, 2), new e("Gamma", 42240, 5), new e("DNGVersion", 50706, 1), new e("DefaultCropSize", 50720, 3, 4)};
        f٣٦٨٨a0 = eVarArr2;
        e[] eVarArr3 = {new e("GPSVersionID", 0, 1), new e("GPSLatitudeRef", 1, 2), new e("GPSLatitude", 2, 5, 10), new e("GPSLongitudeRef", 3, 2), new e("GPSLongitude", 4, 5, 10), new e("GPSAltitudeRef", 5, 1), new e("GPSAltitude", 6, 5), new e("GPSTimeStamp", 7, 5), new e("GPSSatellites", 8, 2), new e("GPSStatus", 9, 2), new e("GPSMeasureMode", 10, 2), new e("GPSDOP", 11, 5), new e("GPSSpeedRef", 12, 2), new e("GPSSpeed", 13, 5), new e("GPSTrackRef", 14, 2), new e("GPSTrack", 15, 5), new e("GPSImgDirectionRef", 16, 2), new e("GPSImgDirection", 17, 5), new e("GPSMapDatum", 18, 2), new e("GPSDestLatitudeRef", 19, 2), new e("GPSDestLatitude", 20, 5), new e("GPSDestLongitudeRef", 21, 2), new e("GPSDestLongitude", 22, 5), new e("GPSDestBearingRef", 23, 2), new e("GPSDestBearing", 24, 5), new e("GPSDestDistanceRef", 25, 2), new e("GPSDestDistance", 26, 5), new e("GPSProcessingMethod", 27, 7), new e("GPSAreaInformation", 28, 7), new e("GPSDateStamp", 29, 2), new e("GPSDifferential", 30, 3), new e("GPSHPositioningError", 31, 5)};
        f٣٦٨٩b0 = eVarArr3;
        e[] eVarArr4 = {new e("InteroperabilityIndex", 1, 2)};
        f٣٦٩٠c0 = eVarArr4;
        e[] eVarArr5 = {new e("NewSubfileType", 254, 4), new e("SubfileType", KotlinVersion.MAX_COMPONENT_VALUE, 4), new e("ThumbnailImageWidth", 256, 3, 4), new e("ThumbnailImageLength", 257, 3, 4), new e("BitsPerSample", 258, 3), new e("Compression", 259, 3), new e("PhotometricInterpretation", 262, 3), new e("ImageDescription", SubsamplingScaleImageView.ORIENTATION_270, 2), new e("Make", 271, 2), new e("Model", 272, 2), new e("StripOffsets", 273, 3, 4), new e("ThumbnailOrientation", 274, 3), new e("SamplesPerPixel", 277, 3), new e("RowsPerStrip", 278, 3, 4), new e("StripByteCounts", 279, 3, 4), new e("XResolution", 282, 5), new e("YResolution", 283, 5), new e("PlanarConfiguration", 284, 3), new e("ResolutionUnit", 296, 3), new e("TransferFunction", Constants.BUCKET_REDIRECT_STATUS_CODE, 3), new e("Software", 305, 2), new e("DateTime", 306, 2), new e("Artist", 315, 2), new e("WhitePoint", 318, 5), new e("PrimaryChromaticities", 319, 5), new e("SubIFDPointer", 330, 4), new e("JPEGInterchangeFormat", 513, 4), new e("JPEGInterchangeFormatLength", 514, 4), new e("YCbCrCoefficients", 529, 5), new e("YCbCrSubSampling", 530, 3), new e("YCbCrPositioning", 531, 3), new e("ReferenceBlackWhite", 532, 5), new e("Copyright", 33432, 2), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("DNGVersion", 50706, 1), new e("DefaultCropSize", 50720, 3, 4)};
        f٣٦٩١d0 = eVarArr5;
        f٣٦٩٢e0 = new e("StripOffsets", 273, 3);
        e[] eVarArr6 = {new e("ThumbnailImage", 256, 7), new e("CameraSettingsIFDPointer", 8224, 4), new e("ImageProcessingIFDPointer", 8256, 4)};
        f٣٦٩٣f0 = eVarArr6;
        e[] eVarArr7 = {new e("PreviewImageStart", 257, 4), new e("PreviewImageLength", 258, 4)};
        f٣٦٩٤g0 = eVarArr7;
        e[] eVarArr8 = {new e("AspectFrame", 4371, 3)};
        f٣٦٩٥h0 = eVarArr8;
        e[] eVarArr9 = {new e("ColorSpace", 55, 3)};
        f٣٦٩٦i0 = eVarArr9;
        e[][] eVarArr10 = {eVarArr, eVarArr2, eVarArr3, eVarArr4, eVarArr5, eVarArr, eVarArr6, eVarArr7, eVarArr8, eVarArr9};
        f٣٦٩٧j0 = eVarArr10;
        f٣٦٩٨k0 = new e[]{new e("SubIFDPointer", 330, 4), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("InteroperabilityIFDPointer", 40965, 4), new e("CameraSettingsIFDPointer", 8224, 1), new e("ImageProcessingIFDPointer", 8256, 1)};
        f٣٦٩٩l0 = new HashMap[eVarArr10.length];
        f٣٧٠٠m0 = new HashMap[eVarArr10.length];
        f٣٧٠١n0 = new HashSet(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        f٣٧٠٢o0 = new HashMap();
        Charset forName = Charset.forName("US-ASCII");
        f٣٧٠٣p0 = forName;
        f٣٧٠٤q0 = "Exif\u0000\u0000".getBytes(forName);
        f٣٧٠٥r0 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(forName);
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale);
        U = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(DateFormat.YMD_HMS, locale);
        V = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
        int i10 = 0;
        while (true) {
            e[][] eVarArr11 = f٣٦٩٧j0;
            if (i10 < eVarArr11.length) {
                f٣٦٩٩l0[i10] = new HashMap();
                f٣٧٠٠m0[i10] = new HashMap();
                for (e eVar : eVarArr11[i10]) {
                    f٣٦٩٩l0[i10].put(Integer.valueOf(eVar.f٣٧٥١a), eVar);
                    f٣٧٠٠m0[i10].put(eVar.f٣٧٥٢b, eVar);
                }
                i10++;
            } else {
                HashMap hashMap = f٣٧٠٢o0;
                e[] eVarArr12 = f٣٦٩٨k0;
                hashMap.put(Integer.valueOf(eVarArr12[0].f٣٧٥١a), 5);
                hashMap.put(Integer.valueOf(eVarArr12[1].f٣٧٥١a), 1);
                hashMap.put(Integer.valueOf(eVarArr12[2].f٣٧٥١a), 2);
                hashMap.put(Integer.valueOf(eVarArr12[3].f٣٧٥١a), 3);
                hashMap.put(Integer.valueOf(eVarArr12[4].f٣٧٥١a), 7);
                hashMap.put(Integer.valueOf(eVarArr12[5].f٣٧٥١a), 8);
                f٣٧٠٦s0 = Pattern.compile(".*[1-9].*");
                f٣٧٠٧t0 = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                f٣٧٠٨u0 = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                f٣٧١٠v0 = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
        }
    }

    public a(String str) {
        e[][] eVarArr = f٣٦٩٧j0;
        this.f٣٧٢٠f = new HashMap[eVarArr.length];
        this.f٣٧٢١g = new HashSet(eVarArr.length);
        this.f٣٧٢٢h = ByteOrder.BIG_ENDIAN;
        if (str != null) {
            v(str);
            return;
        }
        throw new NullPointerException("filename cannot be null");
    }

    private boolean A(byte[] bArr) {
        int i10 = 0;
        while (true) {
            byte[] bArr2 = H;
            if (i10 < bArr2.length) {
                if (bArr[i10] != bArr2[i10]) {
                    return false;
                }
                i10++;
            } else {
                return true;
            }
        }
    }

    private boolean B(byte[] bArr) {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i10 = 0; i10 < bytes.length; i10++) {
            if (bArr[i10] != bytes[i10]) {
                return false;
            }
        }
        return true;
    }

    private boolean C(byte[] bArr) {
        boolean z10 = false;
        b bVar = null;
        try {
            b bVar2 = new b(bArr);
            try {
                ByteOrder L2 = L(bVar2);
                this.f٣٧٢٢h = L2;
                bVar2.c(L2);
                if (bVar2.readShort() == 85) {
                    z10 = true;
                }
                bVar2.close();
                return z10;
            } catch (Exception unused) {
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                return false;
            } catch (Throwable th) {
                th = th;
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean D(FileDescriptor fileDescriptor) {
        try {
            b.a.c(fileDescriptor, 0L, OsConstants.SEEK_CUR);
            return true;
        } catch (Exception unused) {
            if (f٣٧٠٩v) {
                Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
                return false;
            }
            return false;
        }
    }

    private boolean E(HashMap hashMap) {
        d dVar;
        int m10;
        d dVar2 = (d) hashMap.get("BitsPerSample");
        if (dVar2 != null) {
            int[] iArr = (int[]) dVar2.o(this.f٣٧٢٢h);
            int[] iArr2 = f٣٧١٣y;
            if (Arrays.equals(iArr2, iArr)) {
                return true;
            }
            if (this.f٣٧١٨d == 3 && (dVar = (d) hashMap.get("PhotometricInterpretation")) != null && (((m10 = dVar.m(this.f٣٧٢٢h)) == 1 && Arrays.equals(iArr, A)) || (m10 == 6 && Arrays.equals(iArr, iArr2)))) {
                return true;
            }
        }
        if (f٣٧٠٩v) {
            Log.d("ExifInterface", "Unsupported data type value");
            return false;
        }
        return false;
    }

    private static boolean F(int i10) {
        return i10 == 4 || i10 == 13 || i10 == 14;
    }

    private boolean G(HashMap hashMap) {
        d dVar = (d) hashMap.get("ImageLength");
        d dVar2 = (d) hashMap.get("ImageWidth");
        if (dVar != null && dVar2 != null) {
            int m10 = dVar.m(this.f٣٧٢٢h);
            int m11 = dVar2.m(this.f٣٧٢٢h);
            if (m10 <= 512 && m11 <= 512) {
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean H(byte[] bArr) {
        int i10 = 0;
        while (true) {
            byte[] bArr2 = L;
            if (i10 < bArr2.length) {
                if (bArr[i10] != bArr2[i10]) {
                    return false;
                }
                i10++;
            } else {
                int i11 = 0;
                while (true) {
                    byte[] bArr3 = M;
                    if (i11 < bArr3.length) {
                        if (bArr[L.length + i11 + 4] != bArr3[i11]) {
                            return false;
                        }
                        i11++;
                    } else {
                        return true;
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x009f A[Catch: all -> 0x0015, TRY_LEAVE, TryCatch #0 {all -> 0x0015, blocks: (B:4:0x0004, B:6:0x0009, B:8:0x001e, B:10:0x0022, B:11:0x0030, B:13:0x0038, B:15:0x0041, B:16:0x0061, B:23:0x0045, B:25:0x004b, B:28:0x0052, B:31:0x005a, B:32:0x005e, B:33:0x006b, B:35:0x0075, B:38:0x007d, B:41:0x0085, B:44:0x008d, B:53:0x009b, B:55:0x009f), top: B:3:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void I(InputStream inputStream) {
        boolean z10;
        if (inputStream != null) {
            for (int i10 = 0; i10 < f٣٦٩٧j0.length; i10++) {
                try {
                    try {
                        this.f٣٧٢٠f[i10] = new HashMap();
                    } catch (Throwable th) {
                        a();
                        if (f٣٧٠٩v) {
                            K();
                        }
                        throw th;
                    }
                } catch (IOException e10) {
                    e = e10;
                    z10 = f٣٧٠٩v;
                    if (z10) {
                        Log.w("ExifInterface", "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e);
                    }
                    a();
                    if (!z10) {
                        return;
                    }
                    K();
                    return;
                } catch (UnsupportedOperationException e11) {
                    e = e11;
                    z10 = f٣٧٠٩v;
                    if (z10) {
                    }
                    a();
                    if (!z10) {
                    }
                    K();
                    return;
                }
            }
            if (!this.f٣٧١٩e) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
                this.f٣٧١٨d = i(bufferedInputStream);
                inputStream = bufferedInputStream;
            }
            if (X(this.f٣٧١٨d)) {
                g gVar = new g(inputStream);
                if (this.f٣٧١٩e) {
                    o(gVar);
                } else {
                    int i11 = this.f٣٧١٨d;
                    if (i11 == 12) {
                        g(gVar);
                    } else if (i11 == 7) {
                        j(gVar);
                    } else if (i11 == 10) {
                        n(gVar);
                    } else {
                        m(gVar);
                    }
                }
                gVar.h(this.f٣٧٣٠p);
                W(gVar);
            } else {
                b bVar = new b(inputStream);
                int i12 = this.f٣٧١٨d;
                if (i12 == 4) {
                    h(bVar, 0, 0);
                } else if (i12 == 13) {
                    k(bVar);
                } else if (i12 == 9) {
                    l(bVar);
                } else if (i12 == 14) {
                    r(bVar);
                }
            }
            a();
            if (!f٣٧٠٩v) {
                return;
            }
            K();
            return;
        }
        throw new NullPointerException("inputstream shouldn't be null");
    }

    private void J(b bVar) {
        ByteOrder L2 = L(bVar);
        this.f٣٧٢٢h = L2;
        bVar.c(L2);
        int readUnsignedShort = bVar.readUnsignedShort();
        int i10 = this.f٣٧١٨d;
        if (i10 != 7 && i10 != 10 && readUnsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
        }
        int readInt = bVar.readInt();
        if (readInt >= 8) {
            int i11 = readInt - 8;
            if (i11 > 0) {
                bVar.g(i11);
                return;
            }
            return;
        }
        throw new IOException("Invalid first Ifd offset: " + readInt);
    }

    private void K() {
        for (int i10 = 0; i10 < this.f٣٧٢٠f.length; i10++) {
            Log.d("ExifInterface", "The size of tag group[" + i10 + "]: " + this.f٣٧٢٠f[i10].size());
            for (Map.Entry entry : this.f٣٧٢٠f[i10].entrySet()) {
                d dVar = (d) entry.getValue();
                Log.d("ExifInterface", "tagName: " + ((String) entry.getKey()) + ", tagType: " + dVar.toString() + ", tagValue: '" + dVar.n(this.f٣٧٢٢h) + "'");
            }
        }
    }

    private ByteOrder L(b bVar) {
        short readShort = bVar.readShort();
        if (readShort != 18761) {
            if (readShort == 19789) {
                if (f٣٧٠٩v) {
                    Log.d("ExifInterface", "readExifSegment: Byte Align MM");
                }
                return ByteOrder.BIG_ENDIAN;
            }
            throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
        }
        if (f٣٧٠٩v) {
            Log.d("ExifInterface", "readExifSegment: Byte Align II");
        }
        return ByteOrder.LITTLE_ENDIAN;
    }

    private void M(byte[] bArr, int i10) {
        g gVar = new g(bArr);
        J(gVar);
        N(gVar, i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x023c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void N(g gVar, int i10) {
        short s10;
        short s11;
        long j10;
        boolean z10;
        long j11;
        String str;
        String str2;
        int readUnsignedShort;
        long j12;
        String str3;
        int i11 = i10;
        int i12 = 5;
        char c10 = 0;
        this.f٣٧٢١g.add(Integer.valueOf(gVar.f٣٧٤٣c));
        short readShort = gVar.readShort();
        String str4 = "ExifInterface";
        if (f٣٧٠٩v) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + ((int) readShort));
        }
        if (readShort <= 0) {
            return;
        }
        short s12 = 0;
        while (s12 < readShort) {
            int readUnsignedShort2 = gVar.readUnsignedShort();
            int readUnsignedShort3 = gVar.readUnsignedShort();
            int readInt = gVar.readInt();
            long a10 = gVar.a() + 4;
            e eVar = (e) f٣٦٩٩l0[i11].get(Integer.valueOf(readUnsignedShort2));
            boolean z11 = f٣٧٠٩v;
            if (z11) {
                Integer valueOf = Integer.valueOf(i10);
                Integer valueOf2 = Integer.valueOf(readUnsignedShort2);
                if (eVar != null) {
                    str3 = eVar.f٣٧٥٢b;
                } else {
                    str3 = null;
                }
                Integer valueOf3 = Integer.valueOf(readUnsignedShort3);
                Integer valueOf4 = Integer.valueOf(readInt);
                s10 = readShort;
                Object[] objArr = new Object[i12];
                objArr[c10] = valueOf;
                objArr[1] = valueOf2;
                objArr[2] = str3;
                objArr[3] = valueOf3;
                objArr[4] = valueOf4;
                Log.d(str4, String.format("ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d", objArr));
            } else {
                s10 = readShort;
            }
            if (eVar == null) {
                if (z11) {
                    Log.d(str4, "Skip the tag entry since tag number is not defined: " + readUnsignedShort2);
                }
            } else {
                if (readUnsignedShort3 > 0) {
                    if (readUnsignedShort3 < X.length) {
                        if (!eVar.a(readUnsignedShort3)) {
                            if (z11) {
                                Log.d(str4, "Skip the tag entry since data format (" + W[readUnsignedShort3] + ") is unexpected for tag: " + eVar.f٣٧٥٢b);
                            }
                        } else {
                            if (readUnsignedShort3 == 7) {
                                readUnsignedShort3 = eVar.f٣٧٥٣c;
                            }
                            s11 = s12;
                            j10 = readInt * r5[readUnsignedShort3];
                            if (j10 >= 0 && j10 <= 2147483647L) {
                                z10 = true;
                            } else {
                                if (z11) {
                                    Log.d(str4, "Skip the tag entry since the number of components is invalid: " + readInt);
                                }
                                z10 = false;
                            }
                            if (!z10) {
                                gVar.h(a10);
                                str2 = str4;
                            } else {
                                if (j10 > 4) {
                                    int readInt2 = gVar.readInt();
                                    if (z11) {
                                        StringBuilder sb = new StringBuilder();
                                        j11 = a10;
                                        sb.append("seek to data offset: ");
                                        sb.append(readInt2);
                                        Log.d(str4, sb.toString());
                                    } else {
                                        j11 = a10;
                                    }
                                    if (this.f٣٧١٨d == 7) {
                                        if ("MakerNote".equals(eVar.f٣٧٥٢b)) {
                                            this.f٣٧٣١q = readInt2;
                                        } else if (i11 == 6 && "ThumbnailImage".equals(eVar.f٣٧٥٢b)) {
                                            this.f٣٧٣٢r = readInt2;
                                            this.f٣٧٣٣s = readInt;
                                            d j13 = d.j(6, this.f٣٧٢٢h);
                                            str = str4;
                                            d f10 = d.f(this.f٣٧٣٢r, this.f٣٧٢٢h);
                                            d f11 = d.f(this.f٣٧٣٣s, this.f٣٧٢٢h);
                                            this.f٣٧٢٠f[4].put("Compression", j13);
                                            this.f٣٧٢٠f[4].put("JPEGInterchangeFormat", f10);
                                            this.f٣٧٢٠f[4].put("JPEGInterchangeFormatLength", f11);
                                            gVar.h(readInt2);
                                        }
                                    }
                                    str = str4;
                                    gVar.h(readInt2);
                                } else {
                                    j11 = a10;
                                    str = str4;
                                }
                                Integer num = (Integer) f٣٧٠٢o0.get(Integer.valueOf(readUnsignedShort2));
                                if (z11) {
                                    str2 = str;
                                    Log.d(str2, "nextIfdType: " + num + " byteCount: " + j10);
                                } else {
                                    str2 = str;
                                }
                                if (num != null) {
                                    if (readUnsignedShort3 != 3) {
                                        if (readUnsignedShort3 != 4) {
                                            if (readUnsignedShort3 != 8) {
                                                if (readUnsignedShort3 != 9 && readUnsignedShort3 != 13) {
                                                    j12 = -1;
                                                } else {
                                                    readUnsignedShort = gVar.readInt();
                                                }
                                            } else {
                                                readUnsignedShort = gVar.readShort();
                                            }
                                        } else {
                                            j12 = gVar.b();
                                        }
                                        if (!z11) {
                                            Log.d(str2, String.format("Offset: %d, tagName: %s", Long.valueOf(j12), eVar.f٣٧٥٢b));
                                        }
                                        if (j12 <= 0) {
                                            if (!this.f٣٧٢١g.contains(Integer.valueOf((int) j12))) {
                                                gVar.h(j12);
                                                N(gVar, num.intValue());
                                            } else if (z11) {
                                                Log.d(str2, "Skip jump into the IFD since it has already been read: IfdType " + num + " (at " + j12 + ")");
                                            }
                                        } else if (z11) {
                                            Log.d(str2, "Skip jump into the IFD since its offset is invalid: " + j12);
                                        }
                                        gVar.h(j11);
                                    } else {
                                        readUnsignedShort = gVar.readUnsignedShort();
                                    }
                                    j12 = readUnsignedShort;
                                    if (!z11) {
                                    }
                                    if (j12 <= 0) {
                                    }
                                    gVar.h(j11);
                                } else {
                                    long j14 = j11;
                                    int a11 = gVar.a() + this.f٣٧٣٠p;
                                    byte[] bArr = new byte[(int) j10];
                                    gVar.readFully(bArr);
                                    d dVar = new d(readUnsignedShort3, readInt, a11, bArr);
                                    this.f٣٧٢٠f[i10].put(eVar.f٣٧٥٢b, dVar);
                                    if ("DNGVersion".equals(eVar.f٣٧٥٢b)) {
                                        this.f٣٧١٨d = 3;
                                    }
                                    if ((("Make".equals(eVar.f٣٧٥٢b) || "Model".equals(eVar.f٣٧٥٢b)) && dVar.n(this.f٣٧٢٢h).contains("PENTAX")) || ("Compression".equals(eVar.f٣٧٥٢b) && dVar.m(this.f٣٧٢٢h) == 65535)) {
                                        this.f٣٧١٨d = 8;
                                    }
                                    if (gVar.a() != j14) {
                                        gVar.h(j14);
                                    }
                                    s12 = (short) (s11 + 1);
                                    i11 = i10;
                                    str4 = str2;
                                    readShort = s10;
                                    i12 = 5;
                                    c10 = 0;
                                }
                            }
                            s12 = (short) (s11 + 1);
                            i11 = i10;
                            str4 = str2;
                            readShort = s10;
                            i12 = 5;
                            c10 = 0;
                        }
                    }
                }
                s11 = s12;
                if (z11) {
                    Log.d(str4, "Skip the tag entry since data format is invalid: " + readUnsignedShort3);
                }
                z10 = false;
                j10 = 0;
                if (!z10) {
                }
                s12 = (short) (s11 + 1);
                i11 = i10;
                str4 = str2;
                readShort = s10;
                i12 = 5;
                c10 = 0;
            }
            s11 = s12;
            z10 = false;
            j10 = 0;
            if (!z10) {
            }
            s12 = (short) (s11 + 1);
            i11 = i10;
            str4 = str2;
            readShort = s10;
            i12 = 5;
            c10 = 0;
        }
        String str5 = str4;
        int readInt3 = gVar.readInt();
        boolean z12 = f٣٧٠٩v;
        if (z12) {
            Log.d(str5, String.format("nextIfdOffset: %d", Integer.valueOf(readInt3)));
        }
        long j15 = readInt3;
        if (j15 > 0) {
            if (!this.f٣٧٢١g.contains(Integer.valueOf(readInt3))) {
                gVar.h(j15);
                if (this.f٣٧٢٠f[4].isEmpty()) {
                    N(gVar, 4);
                    return;
                } else {
                    if (this.f٣٧٢٠f[5].isEmpty()) {
                        N(gVar, 5);
                        return;
                    }
                    return;
                }
            }
            if (z12) {
                Log.d(str5, "Stop reading file since re-reading an IFD may cause an infinite loop: " + readInt3);
                return;
            }
            return;
        }
        if (z12) {
            Log.d(str5, "Stop reading file since a wrong offset may cause an infinite loop: " + readInt3);
        }
    }

    private void O(String str) {
        for (int i10 = 0; i10 < f٣٦٩٧j0.length; i10++) {
            this.f٣٧٢٠f[i10].remove(str);
        }
    }

    private void P(int i10, String str, String str2) {
        if (!this.f٣٧٢٠f[i10].isEmpty() && this.f٣٧٢٠f[i10].get(str) != null) {
            HashMap hashMap = this.f٣٧٢٠f[i10];
            hashMap.put(str2, hashMap.get(str));
            this.f٣٧٢٠f[i10].remove(str);
        }
    }

    private void Q(g gVar, int i10) {
        d dVar = (d) this.f٣٧٢٠f[i10].get("ImageLength");
        d dVar2 = (d) this.f٣٧٢٠f[i10].get("ImageWidth");
        if (dVar == null || dVar2 == null) {
            d dVar3 = (d) this.f٣٧٢٠f[i10].get("JPEGInterchangeFormat");
            d dVar4 = (d) this.f٣٧٢٠f[i10].get("JPEGInterchangeFormatLength");
            if (dVar3 != null && dVar4 != null) {
                int m10 = dVar3.m(this.f٣٧٢٢h);
                int m11 = dVar3.m(this.f٣٧٢٢h);
                gVar.h(m10);
                byte[] bArr = new byte[m11];
                gVar.read(bArr);
                h(new b(bArr), m10, i10);
            }
        }
    }

    private void S(InputStream inputStream, OutputStream outputStream) {
        d dVar;
        if (f٣٧٠٩v) {
            Log.d("ExifInterface", "saveJpegAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")");
        }
        b bVar = new b(inputStream);
        c cVar = new c(outputStream, ByteOrder.BIG_ENDIAN);
        if (bVar.readByte() == -1) {
            cVar.b(-1);
            if (bVar.readByte() == -40) {
                cVar.b(-40);
                if (d("Xmp") != null && this.f٣٧٣٥u) {
                    dVar = (d) this.f٣٧٢٠f[0].remove("Xmp");
                } else {
                    dVar = null;
                }
                cVar.b(-1);
                cVar.b(-31);
                b0(cVar);
                if (dVar != null) {
                    this.f٣٧٢٠f[0].put("Xmp", dVar);
                }
                byte[] bArr = new byte[4096];
                while (bVar.readByte() == -1) {
                    byte readByte = bVar.readByte();
                    if (readByte != -39 && readByte != -38) {
                        if (readByte != -31) {
                            cVar.b(-1);
                            cVar.b(readByte);
                            int readUnsignedShort = bVar.readUnsignedShort();
                            cVar.j(readUnsignedShort);
                            int i10 = readUnsignedShort - 2;
                            if (i10 >= 0) {
                                while (i10 > 0) {
                                    int read = bVar.read(bArr, 0, Math.min(i10, 4096));
                                    if (read >= 0) {
                                        cVar.write(bArr, 0, read);
                                        i10 -= read;
                                    }
                                }
                            } else {
                                throw new IOException("Invalid length");
                            }
                        } else {
                            int readUnsignedShort2 = bVar.readUnsignedShort();
                            int i11 = readUnsignedShort2 - 2;
                            if (i11 >= 0) {
                                byte[] bArr2 = new byte[6];
                                if (i11 >= 6) {
                                    if (bVar.read(bArr2) == 6) {
                                        if (Arrays.equals(bArr2, f٣٧٠٤q0)) {
                                            bVar.g(readUnsignedShort2 - 8);
                                        }
                                    } else {
                                        throw new IOException("Invalid exif");
                                    }
                                }
                                cVar.b(-1);
                                cVar.b(readByte);
                                cVar.j(readUnsignedShort2);
                                if (i11 >= 6) {
                                    i11 = readUnsignedShort2 - 8;
                                    cVar.write(bArr2);
                                }
                                while (i11 > 0) {
                                    int read2 = bVar.read(bArr, 0, Math.min(i11, 4096));
                                    if (read2 >= 0) {
                                        cVar.write(bArr, 0, read2);
                                        i11 -= read2;
                                    }
                                }
                            } else {
                                throw new IOException("Invalid length");
                            }
                        }
                    } else {
                        cVar.b(-1);
                        cVar.b(readByte);
                        androidx.exifinterface.media.b.e(bVar, cVar);
                        return;
                    }
                }
                throw new IOException("Invalid marker");
            }
            throw new IOException("Invalid marker");
        }
        throw new IOException("Invalid marker");
    }

    private void T(InputStream inputStream, OutputStream outputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        if (f٣٧٠٩v) {
            Log.d("ExifInterface", "savePngAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")");
        }
        b bVar = new b(inputStream);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        c cVar = new c(outputStream, byteOrder);
        androidx.exifinterface.media.b.f(bVar, cVar, H.length);
        if (this.f٣٧٣٠p == 0) {
            int readInt = bVar.readInt();
            cVar.c(readInt);
            androidx.exifinterface.media.b.f(bVar, cVar, readInt + 8);
        } else {
            androidx.exifinterface.media.b.f(bVar, cVar, (r2 - r7.length) - 8);
            bVar.g(bVar.readInt() + 8);
        }
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th) {
            th = th;
        }
        try {
            c cVar2 = new c(byteArrayOutputStream, byteOrder);
            b0(cVar2);
            byte[] byteArray = ((ByteArrayOutputStream) cVar2.f٣٧٤٥a).toByteArray();
            cVar.write(byteArray);
            CRC32 crc32 = new CRC32();
            crc32.update(byteArray, 4, byteArray.length - 4);
            cVar.c((int) crc32.getValue());
            androidx.exifinterface.media.b.c(byteArrayOutputStream);
            androidx.exifinterface.media.b.e(bVar, cVar);
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream2 = byteArrayOutputStream;
            androidx.exifinterface.media.b.c(byteArrayOutputStream2);
            throw th;
        }
    }

    private void U(InputStream inputStream, OutputStream outputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        if (f٣٧٠٩v) {
            Log.d("ExifInterface", "saveWebpAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")");
        }
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        b bVar = new b(inputStream, byteOrder);
        c cVar = new c(outputStream, byteOrder);
        byte[] bArr = L;
        androidx.exifinterface.media.b.f(bVar, cVar, bArr.length);
        byte[] bArr2 = M;
        bVar.g(bArr2.length + 4);
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Exception e10) {
                e = e10;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            c cVar2 = new c(byteArrayOutputStream, byteOrder);
            int i15 = this.f٣٧٣٠p;
            if (i15 != 0) {
                androidx.exifinterface.media.b.f(bVar, cVar2, (i15 - ((bArr.length + 4) + bArr2.length)) - 8);
                bVar.g(4);
                int readInt = bVar.readInt();
                if (readInt % 2 != 0) {
                    readInt++;
                }
                bVar.g(readInt);
                b0(cVar2);
            } else {
                byte[] bArr3 = new byte[4];
                if (bVar.read(bArr3) == 4) {
                    byte[] bArr4 = P;
                    boolean z10 = false;
                    boolean z11 = true;
                    if (Arrays.equals(bArr3, bArr4)) {
                        int readInt2 = bVar.readInt();
                        if (readInt2 % 2 == 1) {
                            i14 = readInt2 + 1;
                        } else {
                            i14 = readInt2;
                        }
                        byte[] bArr5 = new byte[i14];
                        bVar.read(bArr5);
                        byte b10 = (byte) (8 | bArr5[0]);
                        bArr5[0] = b10;
                        if (((b10 >> 1) & 1) == 1) {
                            z10 = true;
                        }
                        cVar2.write(bArr4);
                        cVar2.c(readInt2);
                        cVar2.write(bArr5);
                        if (z10) {
                            b(bVar, cVar2, S, null);
                            while (true) {
                                byte[] bArr6 = new byte[4];
                                inputStream.read(bArr6);
                                if (!Arrays.equals(bArr6, T)) {
                                    break;
                                } else {
                                    c(bVar, cVar2, bArr6);
                                }
                            }
                            b0(cVar2);
                        } else {
                            b(bVar, cVar2, R, Q);
                            b0(cVar2);
                        }
                    } else {
                        byte[] bArr7 = R;
                        if (Arrays.equals(bArr3, bArr7) || Arrays.equals(bArr3, Q)) {
                            int readInt3 = bVar.readInt();
                            if (readInt3 % 2 == 1) {
                                i10 = readInt3 + 1;
                            } else {
                                i10 = readInt3;
                            }
                            byte[] bArr8 = new byte[3];
                            if (Arrays.equals(bArr3, bArr7)) {
                                bVar.read(bArr8);
                                byte[] bArr9 = new byte[3];
                                if (bVar.read(bArr9) == 3 && Arrays.equals(O, bArr9)) {
                                    i11 = bVar.readInt();
                                    i10 -= 10;
                                    i13 = (i11 << 2) >> 18;
                                    i12 = (i11 << 18) >> 18;
                                    z11 = false;
                                } else {
                                    throw new IOException("Encountered error while checking VP8 signature");
                                }
                            } else if (Arrays.equals(bArr3, Q)) {
                                if (bVar.readByte() == 47) {
                                    i11 = bVar.readInt();
                                    i12 = (i11 & 16383) + 1;
                                    i13 = ((i11 & 268419072) >>> 14) + 1;
                                    if ((i11 & 268435456) == 0) {
                                        z11 = false;
                                    }
                                    i10 -= 5;
                                } else {
                                    throw new IOException("Encountered error while checking VP8L signature");
                                }
                            } else {
                                i11 = 0;
                                z11 = false;
                                i12 = 0;
                                i13 = 0;
                            }
                            cVar2.write(bArr4);
                            cVar2.c(10);
                            byte[] bArr10 = new byte[10];
                            if (z11) {
                                bArr10[0] = (byte) (bArr10[0] | 16);
                            }
                            bArr10[0] = (byte) (bArr10[0] | 8);
                            int i16 = i12 - 1;
                            int i17 = i13 - 1;
                            bArr10[4] = (byte) i16;
                            bArr10[5] = (byte) (i16 >> 8);
                            bArr10[6] = (byte) (i16 >> 16);
                            bArr10[7] = (byte) i17;
                            bArr10[8] = (byte) (i17 >> 8);
                            bArr10[9] = (byte) (i17 >> 16);
                            cVar2.write(bArr10);
                            cVar2.write(bArr3);
                            cVar2.c(readInt3);
                            if (Arrays.equals(bArr3, bArr7)) {
                                cVar2.write(bArr8);
                                cVar2.write(O);
                                cVar2.c(i11);
                            } else if (Arrays.equals(bArr3, Q)) {
                                cVar2.write(47);
                                cVar2.c(i11);
                            }
                            androidx.exifinterface.media.b.f(bVar, cVar2, i10);
                            b0(cVar2);
                        }
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing WebP chunk type");
                }
            }
            androidx.exifinterface.media.b.e(bVar, cVar2);
            int size = byteArrayOutputStream.size();
            byte[] bArr11 = M;
            cVar.c(size + bArr11.length);
            cVar.write(bArr11);
            byteArrayOutputStream.writeTo(cVar);
            androidx.exifinterface.media.b.c(byteArrayOutputStream);
        } catch (Exception e11) {
            e = e11;
            byteArrayOutputStream2 = byteArrayOutputStream;
            throw new IOException("Failed to save WebP file", e);
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream2 = byteArrayOutputStream;
            androidx.exifinterface.media.b.c(byteArrayOutputStream2);
            throw th;
        }
    }

    private void W(b bVar) {
        HashMap hashMap = this.f٣٧٢٠f[4];
        d dVar = (d) hashMap.get("Compression");
        if (dVar != null) {
            int m10 = dVar.m(this.f٣٧٢٢h);
            this.f٣٧٢٩o = m10;
            if (m10 != 1) {
                if (m10 != 6) {
                    if (m10 != 7) {
                        return;
                    }
                } else {
                    t(bVar, hashMap);
                    return;
                }
            }
            if (E(hashMap)) {
                u(bVar, hashMap);
                return;
            }
            return;
        }
        this.f٣٧٢٩o = 6;
        t(bVar, hashMap);
    }

    private static boolean X(int i10) {
        return (i10 == 4 || i10 == 9 || i10 == 13 || i10 == 14) ? false : true;
    }

    private void Y(int i10, int i11) {
        if (!this.f٣٧٢٠f[i10].isEmpty() && !this.f٣٧٢٠f[i11].isEmpty()) {
            d dVar = (d) this.f٣٧٢٠f[i10].get("ImageLength");
            d dVar2 = (d) this.f٣٧٢٠f[i10].get("ImageWidth");
            d dVar3 = (d) this.f٣٧٢٠f[i11].get("ImageLength");
            d dVar4 = (d) this.f٣٧٢٠f[i11].get("ImageWidth");
            if (dVar != null && dVar2 != null) {
                if (dVar3 != null && dVar4 != null) {
                    int m10 = dVar.m(this.f٣٧٢٢h);
                    int m11 = dVar2.m(this.f٣٧٢٢h);
                    int m12 = dVar3.m(this.f٣٧٢٢h);
                    int m13 = dVar4.m(this.f٣٧٢٢h);
                    if (m10 < m12 && m11 < m13) {
                        HashMap[] hashMapArr = this.f٣٧٢٠f;
                        HashMap hashMap = hashMapArr[i10];
                        hashMapArr[i10] = hashMapArr[i11];
                        hashMapArr[i11] = hashMap;
                        return;
                    }
                    return;
                }
                if (f٣٧٠٩v) {
                    Log.d("ExifInterface", "Second image does not contain valid size information");
                    return;
                }
                return;
            }
            if (f٣٧٠٩v) {
                Log.d("ExifInterface", "First image does not contain valid size information");
                return;
            }
            return;
        }
        if (f٣٧٠٩v) {
            Log.d("ExifInterface", "Cannot perform swap since only one image data exists");
        }
    }

    private void Z(g gVar, int i10) {
        d j10;
        d j11;
        d dVar = (d) this.f٣٧٢٠f[i10].get("DefaultCropSize");
        d dVar2 = (d) this.f٣٧٢٠f[i10].get("SensorTopBorder");
        d dVar3 = (d) this.f٣٧٢٠f[i10].get("SensorLeftBorder");
        d dVar4 = (d) this.f٣٧٢٠f[i10].get("SensorBottomBorder");
        d dVar5 = (d) this.f٣٧٢٠f[i10].get("SensorRightBorder");
        if (dVar != null) {
            if (dVar.f٣٧٤٧a == 5) {
                f[] fVarArr = (f[]) dVar.o(this.f٣٧٢٢h);
                if (fVarArr != null && fVarArr.length == 2) {
                    j10 = d.h(fVarArr[0], this.f٣٧٢٢h);
                    j11 = d.h(fVarArr[1], this.f٣٧٢٢h);
                } else {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(fVarArr));
                    return;
                }
            } else {
                int[] iArr = (int[]) dVar.o(this.f٣٧٢٢h);
                if (iArr != null && iArr.length == 2) {
                    j10 = d.j(iArr[0], this.f٣٧٢٢h);
                    j11 = d.j(iArr[1], this.f٣٧٢٢h);
                } else {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                    return;
                }
            }
            this.f٣٧٢٠f[i10].put("ImageWidth", j10);
            this.f٣٧٢٠f[i10].put("ImageLength", j11);
            return;
        }
        if (dVar2 != null && dVar3 != null && dVar4 != null && dVar5 != null) {
            int m10 = dVar2.m(this.f٣٧٢٢h);
            int m11 = dVar4.m(this.f٣٧٢٢h);
            int m12 = dVar5.m(this.f٣٧٢٢h);
            int m13 = dVar3.m(this.f٣٧٢٢h);
            if (m11 > m10 && m12 > m13) {
                d j12 = d.j(m11 - m10, this.f٣٧٢٢h);
                d j13 = d.j(m12 - m13, this.f٣٧٢٢h);
                this.f٣٧٢٠f[i10].put("ImageLength", j12);
                this.f٣٧٢٠f[i10].put("ImageWidth", j13);
                return;
            }
            return;
        }
        Q(gVar, i10);
    }

    private void a() {
        String d10 = d("DateTimeOriginal");
        if (d10 != null && d("DateTime") == null) {
            this.f٣٧٢٠f[0].put("DateTime", d.e(d10));
        }
        if (d("ImageWidth") == null) {
            this.f٣٧٢٠f[0].put("ImageWidth", d.f(0L, this.f٣٧٢٢h));
        }
        if (d("ImageLength") == null) {
            this.f٣٧٢٠f[0].put("ImageLength", d.f(0L, this.f٣٧٢٢h));
        }
        if (d("Orientation") == null) {
            this.f٣٧٢٠f[0].put("Orientation", d.f(0L, this.f٣٧٢٢h));
        }
        if (d("LightSource") == null) {
            this.f٣٧٢٠f[1].put("LightSource", d.f(0L, this.f٣٧٢٢h));
        }
    }

    private void a0() {
        Y(0, 5);
        Y(0, 4);
        Y(5, 4);
        d dVar = (d) this.f٣٧٢٠f[1].get("PixelXDimension");
        d dVar2 = (d) this.f٣٧٢٠f[1].get("PixelYDimension");
        if (dVar != null && dVar2 != null) {
            this.f٣٧٢٠f[0].put("ImageWidth", dVar);
            this.f٣٧٢٠f[0].put("ImageLength", dVar2);
        }
        if (this.f٣٧٢٠f[4].isEmpty() && G(this.f٣٧٢٠f[5])) {
            HashMap[] hashMapArr = this.f٣٧٢٠f;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap();
        }
        if (!G(this.f٣٧٢٠f[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
        P(0, "ThumbnailOrientation", "Orientation");
        P(0, "ThumbnailImageLength", "ImageLength");
        P(0, "ThumbnailImageWidth", "ImageWidth");
        P(5, "ThumbnailOrientation", "Orientation");
        P(5, "ThumbnailImageLength", "ImageLength");
        P(5, "ThumbnailImageWidth", "ImageWidth");
        P(4, "Orientation", "ThumbnailOrientation");
        P(4, "ImageLength", "ThumbnailImageLength");
        P(4, "ImageWidth", "ThumbnailImageWidth");
    }

    private void b(b bVar, c cVar, byte[] bArr, byte[] bArr2) {
        String str;
        while (true) {
            byte[] bArr3 = new byte[4];
            if (bVar.read(bArr3) != 4) {
                StringBuilder sb = new StringBuilder();
                sb.append("Encountered invalid length while copying WebP chunks up tochunk type ");
                Charset charset = f٣٧٠٣p0;
                sb.append(new String(bArr, charset));
                if (bArr2 == null) {
                    str = "";
                } else {
                    str = " or " + new String(bArr2, charset);
                }
                sb.append(str);
                throw new IOException(sb.toString());
            }
            c(bVar, cVar, bArr3);
            if (!Arrays.equals(bArr3, bArr)) {
                if (bArr2 != null && Arrays.equals(bArr3, bArr2)) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private int b0(c cVar) {
        e[][] eVarArr = f٣٦٩٧j0;
        int[] iArr = new int[eVarArr.length];
        int[] iArr2 = new int[eVarArr.length];
        for (e eVar : f٣٦٩٨k0) {
            O(eVar.f٣٧٥٢b);
        }
        if (this.f٣٧٢٣i) {
            if (this.f٣٧٢٤j) {
                O("StripOffsets");
                O("StripByteCounts");
            } else {
                O("JPEGInterchangeFormat");
                O("JPEGInterchangeFormatLength");
            }
        }
        for (int i10 = 0; i10 < f٣٦٩٧j0.length; i10++) {
            for (Object obj : this.f٣٧٢٠f[i10].entrySet().toArray()) {
                Map.Entry entry = (Map.Entry) obj;
                if (entry.getValue() == null) {
                    this.f٣٧٢٠f[i10].remove(entry.getKey());
                }
            }
        }
        if (!this.f٣٧٢٠f[1].isEmpty()) {
            this.f٣٧٢٠f[0].put(f٣٦٩٨k0[1].f٣٧٥٢b, d.f(0L, this.f٣٧٢٢h));
        }
        if (!this.f٣٧٢٠f[2].isEmpty()) {
            this.f٣٧٢٠f[0].put(f٣٦٩٨k0[2].f٣٧٥٢b, d.f(0L, this.f٣٧٢٢h));
        }
        if (!this.f٣٧٢٠f[3].isEmpty()) {
            this.f٣٧٢٠f[1].put(f٣٦٩٨k0[3].f٣٧٥٢b, d.f(0L, this.f٣٧٢٢h));
        }
        if (this.f٣٧٢٣i) {
            if (this.f٣٧٢٤j) {
                this.f٣٧٢٠f[4].put("StripOffsets", d.j(0, this.f٣٧٢٢h));
                this.f٣٧٢٠f[4].put("StripByteCounts", d.j(this.f٣٧٢٧m, this.f٣٧٢٢h));
            } else {
                this.f٣٧٢٠f[4].put("JPEGInterchangeFormat", d.f(0L, this.f٣٧٢٢h));
                this.f٣٧٢٠f[4].put("JPEGInterchangeFormatLength", d.f(this.f٣٧٢٧m, this.f٣٧٢٢h));
            }
        }
        for (int i11 = 0; i11 < f٣٦٩٧j0.length; i11++) {
            Iterator it = this.f٣٧٢٠f[i11].entrySet().iterator();
            int i12 = 0;
            while (it.hasNext()) {
                int p10 = ((d) ((Map.Entry) it.next()).getValue()).p();
                if (p10 > 4) {
                    i12 += p10;
                }
            }
            iArr2[i11] = iArr2[i11] + i12;
        }
        int i13 = 8;
        for (int i14 = 0; i14 < f٣٦٩٧j0.length; i14++) {
            if (!this.f٣٧٢٠f[i14].isEmpty()) {
                iArr[i14] = i13;
                i13 += (this.f٣٧٢٠f[i14].size() * 12) + 6 + iArr2[i14];
            }
        }
        if (this.f٣٧٢٣i) {
            if (this.f٣٧٢٤j) {
                this.f٣٧٢٠f[4].put("StripOffsets", d.j(i13, this.f٣٧٢٢h));
            } else {
                this.f٣٧٢٠f[4].put("JPEGInterchangeFormat", d.f(i13, this.f٣٧٢٢h));
            }
            this.f٣٧٢٦l = i13;
            i13 += this.f٣٧٢٧m;
        }
        if (this.f٣٧١٨d == 4) {
            i13 += 8;
        }
        if (f٣٧٠٩v) {
            for (int i15 = 0; i15 < f٣٦٩٧j0.length; i15++) {
                Log.d("ExifInterface", String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", Integer.valueOf(i15), Integer.valueOf(iArr[i15]), Integer.valueOf(this.f٣٧٢٠f[i15].size()), Integer.valueOf(iArr2[i15]), Integer.valueOf(i13)));
            }
        }
        if (!this.f٣٧٢٠f[1].isEmpty()) {
            this.f٣٧٢٠f[0].put(f٣٦٩٨k0[1].f٣٧٥٢b, d.f(iArr[1], this.f٣٧٢٢h));
        }
        if (!this.f٣٧٢٠f[2].isEmpty()) {
            this.f٣٧٢٠f[0].put(f٣٦٩٨k0[2].f٣٧٥٢b, d.f(iArr[2], this.f٣٧٢٢h));
        }
        if (!this.f٣٧٢٠f[3].isEmpty()) {
            this.f٣٧٢٠f[1].put(f٣٦٩٨k0[3].f٣٧٥٢b, d.f(iArr[3], this.f٣٧٢٢h));
        }
        int i16 = this.f٣٧١٨d;
        if (i16 == 4) {
            cVar.j(i13);
            cVar.write(f٣٧٠٤q0);
        } else if (i16 == 13) {
            cVar.c(i13);
            cVar.write(I);
        } else if (i16 == 14) {
            cVar.write(N);
            cVar.c(i13);
        }
        cVar.g(this.f٣٧٢٢h == ByteOrder.BIG_ENDIAN ? (short) 19789 : (short) 18761);
        cVar.a(this.f٣٧٢٢h);
        cVar.j(42);
        cVar.h(8L);
        for (int i17 = 0; i17 < f٣٦٩٧j0.length; i17++) {
            if (!this.f٣٧٢٠f[i17].isEmpty()) {
                cVar.j(this.f٣٧٢٠f[i17].size());
                int size = iArr[i17] + 2 + (this.f٣٧٢٠f[i17].size() * 12) + 4;
                for (Map.Entry entry2 : this.f٣٧٢٠f[i17].entrySet()) {
                    int i18 = ((e) f٣٧٠٠m0[i17].get(entry2.getKey())).f٣٧٥١a;
                    d dVar = (d) entry2.getValue();
                    int p11 = dVar.p();
                    cVar.j(i18);
                    cVar.j(dVar.f٣٧٤٧a);
                    cVar.c(dVar.f٣٧٤٨b);
                    if (p11 > 4) {
                        cVar.h(size);
                        size += p11;
                    } else {
                        cVar.write(dVar.f٣٧٥٠d);
                        if (p11 < 4) {
                            while (p11 < 4) {
                                cVar.b(0);
                                p11++;
                            }
                        }
                    }
                }
                if (i17 == 0 && !this.f٣٧٢٠f[4].isEmpty()) {
                    cVar.h(iArr[4]);
                } else {
                    cVar.h(0L);
                }
                Iterator it2 = this.f٣٧٢٠f[i17].entrySet().iterator();
                while (it2.hasNext()) {
                    byte[] bArr = ((d) ((Map.Entry) it2.next()).getValue()).f٣٧٥٠d;
                    if (bArr.length > 4) {
                        cVar.write(bArr, 0, bArr.length);
                    }
                }
            }
        }
        if (this.f٣٧٢٣i) {
            cVar.write(q());
        }
        if (this.f٣٧١٨d == 14 && i13 % 2 == 1) {
            cVar.b(0);
        }
        cVar.a(ByteOrder.BIG_ENDIAN);
        return i13;
    }

    private void c(b bVar, c cVar, byte[] bArr) {
        int readInt = bVar.readInt();
        cVar.write(bArr);
        cVar.c(readInt);
        if (readInt % 2 == 1) {
            readInt++;
        }
        androidx.exifinterface.media.b.f(bVar, cVar, readInt);
    }

    private d f(String str) {
        if (str != null) {
            if ("ISOSpeedRatings".equals(str)) {
                if (f٣٧٠٩v) {
                    Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
                }
                str = "PhotographicSensitivity";
            }
            for (int i10 = 0; i10 < f٣٦٩٧j0.length; i10++) {
                d dVar = (d) this.f٣٧٢٠f[i10].get(str);
                if (dVar != null) {
                    return dVar;
                }
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    private void g(g gVar) {
        String str;
        String str2;
        String str3;
        int i10;
        if (Build.VERSION.SDK_INT >= 28) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                try {
                    b.C٠٠٤١b.a(mediaMetadataRetriever, new C٠٠٤٠a(gVar));
                    String extractMetadata = mediaMetadataRetriever.extractMetadata(33);
                    String extractMetadata2 = mediaMetadataRetriever.extractMetadata(34);
                    String extractMetadata3 = mediaMetadataRetriever.extractMetadata(26);
                    String extractMetadata4 = mediaMetadataRetriever.extractMetadata(17);
                    if ("yes".equals(extractMetadata3)) {
                        str = mediaMetadataRetriever.extractMetadata(29);
                        str2 = mediaMetadataRetriever.extractMetadata(30);
                        str3 = mediaMetadataRetriever.extractMetadata(31);
                    } else if ("yes".equals(extractMetadata4)) {
                        str = mediaMetadataRetriever.extractMetadata(18);
                        str2 = mediaMetadataRetriever.extractMetadata(19);
                        str3 = mediaMetadataRetriever.extractMetadata(24);
                    } else {
                        str = null;
                        str2 = null;
                        str3 = null;
                    }
                    if (str != null) {
                        this.f٣٧٢٠f[0].put("ImageWidth", d.j(Integer.parseInt(str), this.f٣٧٢٢h));
                    }
                    if (str2 != null) {
                        this.f٣٧٢٠f[0].put("ImageLength", d.j(Integer.parseInt(str2), this.f٣٧٢٢h));
                    }
                    if (str3 != null) {
                        int parseInt = Integer.parseInt(str3);
                        if (parseInt != 90) {
                            if (parseInt != 180) {
                                if (parseInt != 270) {
                                    i10 = 1;
                                } else {
                                    i10 = 8;
                                }
                            } else {
                                i10 = 3;
                            }
                        } else {
                            i10 = 6;
                        }
                        this.f٣٧٢٠f[0].put("Orientation", d.j(i10, this.f٣٧٢٢h));
                    }
                    if (extractMetadata != null && extractMetadata2 != null) {
                        int parseInt2 = Integer.parseInt(extractMetadata);
                        int parseInt3 = Integer.parseInt(extractMetadata2);
                        if (parseInt3 > 6) {
                            gVar.h(parseInt2);
                            byte[] bArr = new byte[6];
                            if (gVar.read(bArr) == 6) {
                                int i11 = parseInt2 + 6;
                                int i12 = parseInt3 - 6;
                                if (Arrays.equals(bArr, f٣٧٠٤q0)) {
                                    byte[] bArr2 = new byte[i12];
                                    if (gVar.read(bArr2) == i12) {
                                        this.f٣٧٣٠p = i11;
                                        M(bArr2, 0);
                                    } else {
                                        throw new IOException("Can't read exif");
                                    }
                                } else {
                                    throw new IOException("Invalid identifier");
                                }
                            } else {
                                throw new IOException("Can't read identifier");
                            }
                        } else {
                            throw new IOException("Invalid exif length");
                        }
                    }
                    if (f٣٧٠٩v) {
                        Log.d("ExifInterface", "Heif meta: " + str + "x" + str2 + ", rotation " + str3);
                    }
                    mediaMetadataRetriever.release();
                    return;
                } catch (RuntimeException unused) {
                    throw new UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
                }
            } catch (Throwable th) {
                mediaMetadataRetriever.release();
                throw th;
            }
        }
        throw new UnsupportedOperationException("Reading EXIF from HEIF files is supported from SDK 28 and above");
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x0191, code lost:
    
        r22.c(r21.f٣٧٢٢h);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0196, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x017b A[LOOP:0: B:9:0x0037->B:33:0x017b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0182 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void h(b bVar, int i10, int i11) {
        String str;
        String str2;
        String str3;
        if (f٣٧٠٩v) {
            Log.d("ExifInterface", "getJpegAttributes starting with: " + bVar);
        }
        bVar.c(ByteOrder.BIG_ENDIAN);
        byte readByte = bVar.readByte();
        byte b10 = -1;
        if (readByte == -1) {
            if (bVar.readByte() == -40) {
                int i12 = 2;
                while (true) {
                    byte readByte2 = bVar.readByte();
                    if (readByte2 == b10) {
                        byte readByte3 = bVar.readByte();
                        boolean z10 = f٣٧٠٩v;
                        if (z10) {
                            Log.d("ExifInterface", "Found JPEG segment indicator: " + Integer.toHexString(readByte3 & UByte.MAX_VALUE));
                        }
                        if (readByte3 != -39 && readByte3 != -38) {
                            int readUnsignedShort = bVar.readUnsignedShort();
                            int i13 = readUnsignedShort - 2;
                            int i14 = i12 + 4;
                            if (z10) {
                                Log.d("ExifInterface", "JPEG segment: " + Integer.toHexString(readByte3 & UByte.MAX_VALUE) + " (length: " + readUnsignedShort + ")");
                            }
                            if (i13 >= 0) {
                                if (readByte3 != -31) {
                                    if (readByte3 == -2) {
                                        byte[] bArr = new byte[i13];
                                        if (bVar.read(bArr) == i13) {
                                            if (d("UserComment") == null) {
                                                this.f٣٧٢٠f[1].put("UserComment", d.e(new String(bArr, f٣٧٠٣p0)));
                                            }
                                            str = "Invalid length";
                                        } else {
                                            throw new IOException("Invalid exif");
                                        }
                                    } else {
                                        switch (readByte3) {
                                            case -64:
                                            case -63:
                                            case -62:
                                            case -61:
                                                break;
                                            default:
                                                switch (readByte3) {
                                                    case -59:
                                                    case -58:
                                                    case -57:
                                                        break;
                                                    default:
                                                        switch (readByte3) {
                                                            case -55:
                                                            case -54:
                                                            case -53:
                                                                break;
                                                            default:
                                                                switch (readByte3) {
                                                                }
                                                                if (i13 >= 0) {
                                                                    bVar.g(i13);
                                                                    i12 = i14 + i13;
                                                                    b10 = -1;
                                                                } else {
                                                                    throw new IOException(str);
                                                                }
                                                                break;
                                                        }
                                                }
                                        }
                                        bVar.g(1);
                                        HashMap hashMap = this.f٣٧٢٠f[i11];
                                        if (i11 != 4) {
                                            str2 = "ImageLength";
                                        } else {
                                            str2 = "ThumbnailImageLength";
                                        }
                                        hashMap.put(str2, d.f(bVar.readUnsignedShort(), this.f٣٧٢٢h));
                                        HashMap hashMap2 = this.f٣٧٢٠f[i11];
                                        if (i11 != 4) {
                                            str3 = "ImageWidth";
                                        } else {
                                            str3 = "ThumbnailImageWidth";
                                        }
                                        hashMap2.put(str3, d.f(bVar.readUnsignedShort(), this.f٣٧٢٢h));
                                        i13 = readUnsignedShort - 7;
                                        str = "Invalid length";
                                        if (i13 >= 0) {
                                        }
                                    }
                                } else {
                                    byte[] bArr2 = new byte[i13];
                                    bVar.readFully(bArr2);
                                    int i15 = i14 + i13;
                                    byte[] bArr3 = f٣٧٠٤q0;
                                    if (androidx.exifinterface.media.b.g(bArr2, bArr3)) {
                                        byte[] copyOfRange = Arrays.copyOfRange(bArr2, bArr3.length, i13);
                                        this.f٣٧٣٠p = i10 + i14 + bArr3.length;
                                        M(copyOfRange, i11);
                                        W(new b(copyOfRange));
                                    } else {
                                        byte[] bArr4 = f٣٧٠٥r0;
                                        if (androidx.exifinterface.media.b.g(bArr2, bArr4)) {
                                            int length = i14 + bArr4.length;
                                            byte[] copyOfRange2 = Arrays.copyOfRange(bArr2, bArr4.length, i13);
                                            if (d("Xmp") == null) {
                                                str = "Invalid length";
                                                this.f٣٧٢٠f[0].put("Xmp", new d(1, copyOfRange2.length, length, copyOfRange2));
                                                this.f٣٧٣٥u = true;
                                                i14 = i15;
                                            }
                                        }
                                    }
                                    str = "Invalid length";
                                    i14 = i15;
                                }
                                i13 = 0;
                                if (i13 >= 0) {
                                }
                            } else {
                                throw new IOException("Invalid length");
                            }
                        }
                    } else {
                        throw new IOException("Invalid marker:" + Integer.toHexString(readByte2 & UByte.MAX_VALUE));
                    }
                }
            } else {
                throw new IOException("Invalid marker: " + Integer.toHexString(readByte & UByte.MAX_VALUE));
            }
        } else {
            throw new IOException("Invalid marker: " + Integer.toHexString(readByte & UByte.MAX_VALUE));
        }
    }

    private int i(BufferedInputStream bufferedInputStream) {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (y(bArr)) {
            return 4;
        }
        if (B(bArr)) {
            return 9;
        }
        if (x(bArr)) {
            return 12;
        }
        if (z(bArr)) {
            return 7;
        }
        if (C(bArr)) {
            return 10;
        }
        if (A(bArr)) {
            return 13;
        }
        if (H(bArr)) {
            return 14;
        }
        return 0;
    }

    private void j(g gVar) {
        int i10;
        int i11;
        m(gVar);
        d dVar = (d) this.f٣٧٢٠f[1].get("MakerNote");
        if (dVar != null) {
            g gVar2 = new g(dVar.f٣٧٥٠d);
            gVar2.c(this.f٣٧٢٢h);
            byte[] bArr = F;
            byte[] bArr2 = new byte[bArr.length];
            gVar2.readFully(bArr2);
            gVar2.h(0L);
            byte[] bArr3 = G;
            byte[] bArr4 = new byte[bArr3.length];
            gVar2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                gVar2.h(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                gVar2.h(12L);
            }
            N(gVar2, 6);
            d dVar2 = (d) this.f٣٧٢٠f[7].get("PreviewImageStart");
            d dVar3 = (d) this.f٣٧٢٠f[7].get("PreviewImageLength");
            if (dVar2 != null && dVar3 != null) {
                this.f٣٧٢٠f[5].put("JPEGInterchangeFormat", dVar2);
                this.f٣٧٢٠f[5].put("JPEGInterchangeFormatLength", dVar3);
            }
            d dVar4 = (d) this.f٣٧٢٠f[8].get("AspectFrame");
            if (dVar4 != null) {
                int[] iArr = (int[]) dVar4.o(this.f٣٧٢٢h);
                if (iArr != null && iArr.length == 4) {
                    int i12 = iArr[2];
                    int i13 = iArr[0];
                    if (i12 > i13 && (i10 = iArr[3]) > (i11 = iArr[1])) {
                        int i14 = (i12 - i13) + 1;
                        int i15 = (i10 - i11) + 1;
                        if (i14 < i15) {
                            int i16 = i14 + i15;
                            i15 = i16 - i15;
                            i14 = i16 - i15;
                        }
                        d j10 = d.j(i14, this.f٣٧٢٢h);
                        d j11 = d.j(i15, this.f٣٧٢٢h);
                        this.f٣٧٢٠f[0].put("ImageWidth", j10);
                        this.f٣٧٢٠f[0].put("ImageLength", j11);
                        return;
                    }
                    return;
                }
                Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
            }
        }
    }

    private void k(b bVar) {
        if (f٣٧٠٩v) {
            Log.d("ExifInterface", "getPngAttributes starting with: " + bVar);
        }
        bVar.c(ByteOrder.BIG_ENDIAN);
        byte[] bArr = H;
        bVar.g(bArr.length);
        int length = bArr.length;
        while (true) {
            try {
                int readInt = bVar.readInt();
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) == 4) {
                    int i10 = length + 8;
                    if (i10 == 16 && !Arrays.equals(bArr2, J)) {
                        throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                    }
                    if (!Arrays.equals(bArr2, K)) {
                        if (Arrays.equals(bArr2, I)) {
                            byte[] bArr3 = new byte[readInt];
                            if (bVar.read(bArr3) == readInt) {
                                int readInt2 = bVar.readInt();
                                CRC32 crc32 = new CRC32();
                                crc32.update(bArr2);
                                crc32.update(bArr3);
                                if (((int) crc32.getValue()) == readInt2) {
                                    this.f٣٧٣٠p = i10;
                                    M(bArr3, 0);
                                    a0();
                                    W(new b(bArr3));
                                    return;
                                }
                                throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + readInt2 + ", calculated CRC value: " + crc32.getValue());
                            }
                            throw new IOException("Failed to read given length for given PNG chunk type: " + androidx.exifinterface.media.b.a(bArr2));
                        }
                        int i11 = readInt + 4;
                        bVar.g(i11);
                        length = i10 + i11;
                    } else {
                        return;
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    private void l(b bVar) {
        boolean z10 = f٣٧٠٩v;
        if (z10) {
            Log.d("ExifInterface", "getRafAttributes starting with: " + bVar);
        }
        bVar.g(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        bVar.read(bArr);
        bVar.read(bArr2);
        bVar.read(bArr3);
        int i10 = ByteBuffer.wrap(bArr).getInt();
        int i11 = ByteBuffer.wrap(bArr2).getInt();
        int i12 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i11];
        bVar.g(i10 - bVar.a());
        bVar.read(bArr4);
        h(new b(bArr4), i10, 5);
        bVar.g(i12 - bVar.a());
        bVar.c(ByteOrder.BIG_ENDIAN);
        int readInt = bVar.readInt();
        if (z10) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + readInt);
        }
        for (int i13 = 0; i13 < readInt; i13++) {
            int readUnsignedShort = bVar.readUnsignedShort();
            int readUnsignedShort2 = bVar.readUnsignedShort();
            if (readUnsignedShort == f٣٦٩٢e0.f٣٧٥١a) {
                short readShort = bVar.readShort();
                short readShort2 = bVar.readShort();
                d j10 = d.j(readShort, this.f٣٧٢٢h);
                d j11 = d.j(readShort2, this.f٣٧٢٢h);
                this.f٣٧٢٠f[0].put("ImageLength", j10);
                this.f٣٧٢٠f[0].put("ImageWidth", j11);
                if (f٣٧٠٩v) {
                    Log.d("ExifInterface", "Updated to length: " + ((int) readShort) + ", width: " + ((int) readShort2));
                    return;
                }
                return;
            }
            bVar.g(readUnsignedShort2);
        }
    }

    private void m(g gVar) {
        d dVar;
        J(gVar);
        N(gVar, 0);
        Z(gVar, 0);
        Z(gVar, 5);
        Z(gVar, 4);
        a0();
        if (this.f٣٧١٨d == 8 && (dVar = (d) this.f٣٧٢٠f[1].get("MakerNote")) != null) {
            g gVar2 = new g(dVar.f٣٧٥٠d);
            gVar2.c(this.f٣٧٢٢h);
            gVar2.g(6);
            N(gVar2, 9);
            d dVar2 = (d) this.f٣٧٢٠f[9].get("ColorSpace");
            if (dVar2 != null) {
                this.f٣٧٢٠f[1].put("ColorSpace", dVar2);
            }
        }
    }

    private void n(g gVar) {
        if (f٣٧٠٩v) {
            Log.d("ExifInterface", "getRw2Attributes starting with: " + gVar);
        }
        m(gVar);
        d dVar = (d) this.f٣٧٢٠f[0].get("JpgFromRaw");
        if (dVar != null) {
            h(new b(dVar.f٣٧٥٠d), (int) dVar.f٣٧٤٩c, 5);
        }
        d dVar2 = (d) this.f٣٧٢٠f[0].get("ISO");
        d dVar3 = (d) this.f٣٧٢٠f[1].get("PhotographicSensitivity");
        if (dVar2 != null && dVar3 == null) {
            this.f٣٧٢٠f[1].put("PhotographicSensitivity", dVar2);
        }
    }

    private void o(g gVar) {
        byte[] bArr = f٣٧٠٤q0;
        gVar.g(bArr.length);
        byte[] bArr2 = new byte[gVar.available()];
        gVar.readFully(bArr2);
        this.f٣٧٣٠p = bArr.length;
        M(bArr2, 0);
    }

    private void r(b bVar) {
        if (f٣٧٠٩v) {
            Log.d("ExifInterface", "getWebpAttributes starting with: " + bVar);
        }
        bVar.c(ByteOrder.LITTLE_ENDIAN);
        bVar.g(L.length);
        int readInt = bVar.readInt() + 8;
        byte[] bArr = M;
        bVar.g(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) == 4) {
                    int readInt2 = bVar.readInt();
                    int i10 = length + 8;
                    if (Arrays.equals(N, bArr2)) {
                        byte[] bArr3 = new byte[readInt2];
                        if (bVar.read(bArr3) == readInt2) {
                            this.f٣٧٣٠p = i10;
                            M(bArr3, 0);
                            W(new b(bArr3));
                            return;
                        } else {
                            throw new IOException("Failed to read given length for given PNG chunk type: " + androidx.exifinterface.media.b.a(bArr2));
                        }
                    }
                    if (readInt2 % 2 == 1) {
                        readInt2++;
                    }
                    length = i10 + readInt2;
                    if (length == readInt) {
                        return;
                    }
                    if (length <= readInt) {
                        bVar.g(readInt2);
                    } else {
                        throw new IOException("Encountered WebP file with invalid chunk size");
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    private static Pair s(String str) {
        int intValue;
        int i10;
        if (str.contains(",")) {
            String[] split = str.split(",", -1);
            Pair s10 = s(split[0]);
            if (((Integer) s10.first).intValue() == 2) {
                return s10;
            }
            for (int i11 = 1; i11 < split.length; i11++) {
                Pair s11 = s(split[i11]);
                if (!((Integer) s11.first).equals(s10.first) && !((Integer) s11.second).equals(s10.first)) {
                    intValue = -1;
                } else {
                    intValue = ((Integer) s10.first).intValue();
                }
                if (((Integer) s10.second).intValue() != -1 && (((Integer) s11.first).equals(s10.second) || ((Integer) s11.second).equals(s10.second))) {
                    i10 = ((Integer) s10.second).intValue();
                } else {
                    i10 = -1;
                }
                if (intValue == -1 && i10 == -1) {
                    return new Pair(2, -1);
                }
                if (intValue == -1) {
                    s10 = new Pair(Integer.valueOf(i10), -1);
                } else if (i10 == -1) {
                    s10 = new Pair(Integer.valueOf(intValue), -1);
                }
            }
            return s10;
        }
        if (str.contains("/")) {
            String[] split2 = str.split("/", -1);
            if (split2.length == 2) {
                try {
                    long parseDouble = (long) Double.parseDouble(split2[0]);
                    long parseDouble2 = (long) Double.parseDouble(split2[1]);
                    if (parseDouble >= 0 && parseDouble2 >= 0) {
                        if (parseDouble <= 2147483647L && parseDouble2 <= 2147483647L) {
                            return new Pair(10, 5);
                        }
                        return new Pair(5, -1);
                    }
                    return new Pair(10, -1);
                } catch (NumberFormatException unused) {
                }
            }
            return new Pair(2, -1);
        }
        try {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong >= 0 && parseLong <= 65535) {
                    return new Pair(3, 4);
                }
                if (parseLong < 0) {
                    return new Pair(9, -1);
                }
                return new Pair(4, -1);
            } catch (NumberFormatException unused2) {
                return new Pair(2, -1);
            }
        } catch (NumberFormatException unused3) {
            Double.parseDouble(str);
            return new Pair(12, -1);
        }
    }

    private void t(b bVar, HashMap hashMap) {
        d dVar = (d) hashMap.get("JPEGInterchangeFormat");
        d dVar2 = (d) hashMap.get("JPEGInterchangeFormatLength");
        if (dVar != null && dVar2 != null) {
            int m10 = dVar.m(this.f٣٧٢٢h);
            int m11 = dVar2.m(this.f٣٧٢٢h);
            if (this.f٣٧١٨d == 7) {
                m10 += this.f٣٧٣١q;
            }
            if (m10 > 0 && m11 > 0) {
                this.f٣٧٢٣i = true;
                if (this.f٣٧١٥a == null && this.f٣٧١٧c == null && this.f٣٧١٦b == null) {
                    byte[] bArr = new byte[m11];
                    bVar.skip(m10);
                    bVar.read(bArr);
                    this.f٣٧٢٨n = bArr;
                }
                this.f٣٧٢٦l = m10;
                this.f٣٧٢٧m = m11;
            }
            if (f٣٧٠٩v) {
                Log.d("ExifInterface", "Setting thumbnail attributes with offset: " + m10 + ", length: " + m11);
            }
        }
    }

    private void u(b bVar, HashMap hashMap) {
        d dVar = (d) hashMap.get("StripOffsets");
        d dVar2 = (d) hashMap.get("StripByteCounts");
        if (dVar != null && dVar2 != null) {
            long[] d10 = androidx.exifinterface.media.b.d(dVar.o(this.f٣٧٢٢h));
            long[] d11 = androidx.exifinterface.media.b.d(dVar2.o(this.f٣٧٢٢h));
            if (d10 != null && d10.length != 0) {
                if (d11 != null && d11.length != 0) {
                    if (d10.length != d11.length) {
                        Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
                        return;
                    }
                    long j10 = 0;
                    for (long j11 : d11) {
                        j10 += j11;
                    }
                    int i10 = (int) j10;
                    byte[] bArr = new byte[i10];
                    int i11 = 1;
                    this.f٣٧٢٥k = true;
                    this.f٣٧٢٤j = true;
                    this.f٣٧٢٣i = true;
                    int i12 = 0;
                    int i13 = 0;
                    int i14 = 0;
                    while (i12 < d10.length) {
                        int i15 = (int) d10[i12];
                        int i16 = (int) d11[i12];
                        if (i12 < d10.length - i11 && i15 + i16 != d10[i12 + 1]) {
                            this.f٣٧٢٥k = false;
                        }
                        int i17 = i15 - i13;
                        if (i17 < 0) {
                            Log.d("ExifInterface", "Invalid strip offset value");
                            return;
                        }
                        long j12 = i17;
                        if (bVar.skip(j12) != j12) {
                            Log.d("ExifInterface", "Failed to skip " + i17 + " bytes.");
                            return;
                        }
                        int i18 = i13 + i17;
                        byte[] bArr2 = new byte[i16];
                        if (bVar.read(bArr2) != i16) {
                            Log.d("ExifInterface", "Failed to read " + i16 + " bytes.");
                            return;
                        }
                        i13 = i18 + i16;
                        System.arraycopy(bArr2, 0, bArr, i14, i16);
                        i14 += i16;
                        i12++;
                        i11 = 1;
                    }
                    this.f٣٧٢٨n = bArr;
                    if (this.f٣٧٢٥k) {
                        this.f٣٧٢٦l = (int) d10[0];
                        this.f٣٧٢٧m = i10;
                        return;
                    }
                    return;
                }
                Log.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
                return;
            }
            Log.w("ExifInterface", "stripOffsets should not be null or have zero length.");
        }
    }

    private void v(String str) {
        FileInputStream fileInputStream;
        if (str != null) {
            FileInputStream fileInputStream2 = null;
            this.f٣٧١٧c = null;
            this.f٣٧١٥a = str;
            try {
                fileInputStream = new FileInputStream(str);
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (D(fileInputStream.getFD())) {
                    this.f٣٧١٦b = fileInputStream.getFD();
                } else {
                    this.f٣٧١٦b = null;
                }
                I(fileInputStream);
                androidx.exifinterface.media.b.c(fileInputStream);
                return;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                androidx.exifinterface.media.b.c(fileInputStream2);
                throw th;
            }
        }
        throw new NullPointerException("filename cannot be null");
    }

    private static boolean w(BufferedInputStream bufferedInputStream) {
        byte[] bArr = f٣٧٠٤q0;
        bufferedInputStream.mark(bArr.length);
        byte[] bArr2 = new byte[bArr.length];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        int i10 = 0;
        while (true) {
            byte[] bArr3 = f٣٧٠٤q0;
            if (i10 < bArr3.length) {
                if (bArr2[i10] != bArr3[i10]) {
                    return false;
                }
                i10++;
            } else {
                return true;
            }
        }
    }

    private boolean x(byte[] bArr) {
        b bVar;
        long readInt;
        byte[] bArr2;
        long j10;
        b bVar2 = null;
        try {
            try {
                bVar = new b(bArr);
            } catch (Exception e10) {
                e = e10;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            readInt = bVar.readInt();
            bArr2 = new byte[4];
            bVar.read(bArr2);
        } catch (Exception e11) {
            e = e11;
            bVar2 = bVar;
            if (f٣٧٠٩v) {
                Log.d("ExifInterface", "Exception parsing HEIF file type box.", e);
            }
            if (bVar2 != null) {
                bVar2.close();
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            bVar2 = bVar;
            if (bVar2 != null) {
                bVar2.close();
            }
            throw th;
        }
        if (!Arrays.equals(bArr2, C)) {
            bVar.close();
            return false;
        }
        if (readInt == 1) {
            readInt = bVar.readLong();
            j10 = 16;
            if (readInt < 16) {
                bVar.close();
                return false;
            }
        } else {
            j10 = 8;
        }
        if (readInt > bArr.length) {
            readInt = bArr.length;
        }
        long j11 = readInt - j10;
        if (j11 < 8) {
            bVar.close();
            return false;
        }
        byte[] bArr3 = new byte[4];
        boolean z10 = false;
        boolean z11 = false;
        for (long j12 = 0; j12 < j11 / 4; j12++) {
            if (bVar.read(bArr3) != 4) {
                bVar.close();
                return false;
            }
            if (j12 != 1) {
                if (Arrays.equals(bArr3, D)) {
                    z10 = true;
                } else if (Arrays.equals(bArr3, E)) {
                    z11 = true;
                }
                if (z10 && z11) {
                    bVar.close();
                    return true;
                }
            }
        }
        bVar.close();
        return false;
    }

    private static boolean y(byte[] bArr) {
        int i10 = 0;
        while (true) {
            byte[] bArr2 = f٣٦٨٧B;
            if (i10 < bArr2.length) {
                if (bArr[i10] != bArr2[i10]) {
                    return false;
                }
                i10++;
            } else {
                return true;
            }
        }
    }

    private boolean z(byte[] bArr) {
        boolean z10 = false;
        b bVar = null;
        try {
            b bVar2 = new b(bArr);
            try {
                ByteOrder L2 = L(bVar2);
                this.f٣٧٢٢h = L2;
                bVar2.c(L2);
                short readShort = bVar2.readShort();
                if (readShort == 20306 || readShort == 21330) {
                    z10 = true;
                }
                bVar2.close();
                return z10;
            } catch (Exception unused) {
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                return false;
            } catch (Throwable th) {
                th = th;
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00f1 A[Catch: all -> 0x0101, Exception -> 0x0104, TryCatch #20 {Exception -> 0x0104, all -> 0x0101, blocks: (B:58:0x00ed, B:60:0x00f1, B:62:0x010e, B:66:0x0106), top: B:57:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0106 A[Catch: all -> 0x0101, Exception -> 0x0104, TryCatch #20 {Exception -> 0x0104, all -> 0x0101, blocks: (B:58:0x00ed, B:60:0x00f1, B:62:0x010e, B:66:0x0106), top: B:57:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0152  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void R() {
        FileOutputStream fileOutputStream;
        File createTempFile;
        FileInputStream fileInputStream;
        Closeable closeable;
        FileOutputStream fileOutputStream2;
        Exception exc;
        FileOutputStream fileOutputStream3;
        InputStream inputStream;
        Exception e10;
        FileOutputStream fileOutputStream4;
        FileInputStream fileInputStream2;
        if (F(this.f٣٧١٨d)) {
            if (this.f٣٧١٦b == null && this.f٣٧١٥a == null) {
                throw new IOException("ExifInterface does not support saving attributes for the current input.");
            }
            if (this.f٣٧٢٣i && this.f٣٧٢٤j && !this.f٣٧٢٥k) {
                throw new IOException("ExifInterface does not support saving attributes when the image file has non-consecutive thumbnail strips");
            }
            this.f٣٧٣٤t = true;
            this.f٣٧٢٨n = p();
            InputStream inputStream2 = null;
            try {
                createTempFile = File.createTempFile("temp", "tmp");
                if (this.f٣٧١٥a != null) {
                    fileInputStream = new FileInputStream(this.f٣٧١٥a);
                } else {
                    b.a.c(this.f٣٧١٦b, 0L, OsConstants.SEEK_SET);
                    fileInputStream = new FileInputStream(this.f٣٧١٦b);
                }
                try {
                    fileOutputStream = new FileOutputStream(createTempFile);
                } catch (Exception e11) {
                    e = e11;
                    fileOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = null;
                }
            } catch (Exception e12) {
                e = e12;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
            try {
                androidx.exifinterface.media.b.e(fileInputStream, fileOutputStream);
                androidx.exifinterface.media.b.c(fileInputStream);
                androidx.exifinterface.media.b.c(fileOutputStream);
                try {
                } catch (Throwable th3) {
                    th = th3;
                }
                try {
                    try {
                        fileInputStream2 = new FileInputStream(createTempFile);
                    } catch (Throwable th4) {
                        th = th4;
                        closeable = null;
                        androidx.exifinterface.media.b.c(inputStream2);
                        androidx.exifinterface.media.b.c(closeable);
                        if (0 == 0) {
                            createTempFile.delete();
                        }
                        throw th;
                    }
                    try {
                        if (this.f٣٧١٥a != null) {
                            fileOutputStream3 = new FileOutputStream(this.f٣٧١٥a);
                        } else {
                            b.a.c(this.f٣٧١٦b, 0L, OsConstants.SEEK_SET);
                            fileOutputStream3 = new FileOutputStream(this.f٣٧١٦b);
                        }
                        try {
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream2);
                            try {
                                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream3);
                                try {
                                    int i10 = this.f٣٧١٨d;
                                    if (i10 == 4) {
                                        S(bufferedInputStream, bufferedOutputStream);
                                    } else if (i10 == 13) {
                                        T(bufferedInputStream, bufferedOutputStream);
                                    } else if (i10 == 14) {
                                        U(bufferedInputStream, bufferedOutputStream);
                                    }
                                    androidx.exifinterface.media.b.c(bufferedInputStream);
                                    androidx.exifinterface.media.b.c(bufferedOutputStream);
                                    createTempFile.delete();
                                    this.f٣٧٢٨n = null;
                                } catch (Exception e13) {
                                    exc = e13;
                                    inputStream2 = fileInputStream2;
                                    try {
                                        inputStream = new FileInputStream(createTempFile);
                                        try {
                                            if (this.f٣٧١٥a != null) {
                                                b.a.c(this.f٣٧١٦b, 0L, OsConstants.SEEK_SET);
                                                fileOutputStream4 = new FileOutputStream(this.f٣٧١٦b);
                                            } else {
                                                fileOutputStream4 = new FileOutputStream(this.f٣٧١٥a);
                                            }
                                            fileOutputStream3 = fileOutputStream4;
                                            androidx.exifinterface.media.b.e(inputStream, fileOutputStream3);
                                            androidx.exifinterface.media.b.c(inputStream);
                                            androidx.exifinterface.media.b.c(fileOutputStream3);
                                            throw new IOException("Failed to save new file", exc);
                                        } catch (Exception e14) {
                                            e10 = e14;
                                            try {
                                                throw new IOException("Failed to save new file. Original file is stored in " + createTempFile.getAbsolutePath(), e10);
                                            } catch (Throwable th5) {
                                                th = th5;
                                                inputStream2 = inputStream;
                                                androidx.exifinterface.media.b.c(inputStream2);
                                                androidx.exifinterface.media.b.c(fileOutputStream3);
                                                throw th;
                                            }
                                        } catch (Throwable th6) {
                                            th = th6;
                                            inputStream2 = inputStream;
                                            androidx.exifinterface.media.b.c(inputStream2);
                                            androidx.exifinterface.media.b.c(fileOutputStream3);
                                            throw th;
                                        }
                                    } catch (Exception e15) {
                                        inputStream = inputStream2;
                                        e10 = e15;
                                    } catch (Throwable th7) {
                                        th = th7;
                                    }
                                }
                            } catch (Exception e16) {
                                inputStream2 = fileInputStream2;
                                exc = e16;
                            } catch (Throwable th8) {
                                th = th8;
                                closeable = null;
                                inputStream2 = bufferedInputStream;
                                androidx.exifinterface.media.b.c(inputStream2);
                                androidx.exifinterface.media.b.c(closeable);
                                if (0 == 0) {
                                }
                                throw th;
                            }
                        } catch (Exception e17) {
                            inputStream2 = fileInputStream2;
                            exc = e17;
                        }
                    } catch (Exception e18) {
                        e = e18;
                        fileOutputStream2 = null;
                        inputStream2 = fileInputStream2;
                        exc = e;
                        fileOutputStream3 = fileOutputStream2;
                        inputStream = new FileInputStream(createTempFile);
                        if (this.f٣٧١٥a != null) {
                        }
                        fileOutputStream3 = fileOutputStream4;
                        androidx.exifinterface.media.b.e(inputStream, fileOutputStream3);
                        androidx.exifinterface.media.b.c(inputStream);
                        androidx.exifinterface.media.b.c(fileOutputStream3);
                        throw new IOException("Failed to save new file", exc);
                    }
                } catch (Exception e19) {
                    e = e19;
                    fileOutputStream2 = null;
                }
            } catch (Exception e20) {
                e = e20;
                inputStream2 = fileInputStream;
                try {
                    throw new IOException("Failed to copy original file to temp file", e);
                } catch (Throwable th9) {
                    th = th9;
                    androidx.exifinterface.media.b.c(inputStream2);
                    androidx.exifinterface.media.b.c(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th10) {
                th = th10;
                inputStream2 = fileInputStream;
                androidx.exifinterface.media.b.c(inputStream2);
                androidx.exifinterface.media.b.c(fileOutputStream);
                throw th;
            }
        } else {
            throw new IOException("ExifInterface only supports saving attributes for JPEG, PNG, and WebP formats.");
        }
    }

    public void V(String str, String str2) {
        e eVar;
        int i10;
        String str3;
        String str4 = str;
        String str5 = str2;
        if (str4 != null) {
            if (("DateTime".equals(str4) || "DateTimeOriginal".equals(str4) || "DateTimeDigitized".equals(str4)) && str5 != null) {
                boolean find = f٣٧٠٨u0.matcher(str5).find();
                boolean find2 = f٣٧١٠v0.matcher(str5).find();
                if (str2.length() == 19 && (find || find2)) {
                    if (find2) {
                        str5 = str5.replaceAll("-", CertificateUtil.DELIMITER);
                    }
                } else {
                    Log.w("ExifInterface", "Invalid value for " + str4 + " : " + str5);
                    return;
                }
            }
            if ("ISOSpeedRatings".equals(str4)) {
                if (f٣٧٠٩v) {
                    Log.d("ExifInterface", "setAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
                }
                str4 = "PhotographicSensitivity";
            }
            int i11 = 2;
            int i12 = 1;
            if (str5 != null && f٣٧٠١n0.contains(str4)) {
                if (str4.equals("GPSTimeStamp")) {
                    Matcher matcher = f٣٧٠٧t0.matcher(str5);
                    if (!matcher.find()) {
                        Log.w("ExifInterface", "Invalid value for " + str4 + " : " + str5);
                        return;
                    }
                    str5 = Integer.parseInt(matcher.group(1)) + "/1," + Integer.parseInt(matcher.group(2)) + "/1," + Integer.parseInt(matcher.group(3)) + "/1";
                } else {
                    try {
                        str5 = new f(Double.parseDouble(str5)).toString();
                    } catch (NumberFormatException unused) {
                        Log.w("ExifInterface", "Invalid value for " + str4 + " : " + str5);
                        return;
                    }
                }
            }
            char c10 = 0;
            int i13 = 0;
            while (i13 < f٣٦٩٧j0.length) {
                if ((i13 != 4 || this.f٣٧٢٣i) && (eVar = (e) f٣٧٠٠m0[i13].get(str4)) != null) {
                    if (str5 == null) {
                        this.f٣٧٢٠f[i13].remove(str4);
                    } else {
                        Pair s10 = s(str5);
                        int i14 = -1;
                        if (eVar.f٣٧٥٣c != ((Integer) s10.first).intValue() && eVar.f٣٧٥٣c != ((Integer) s10.second).intValue()) {
                            int i15 = eVar.f٣٧٥٤d;
                            if (i15 != -1 && (i15 == ((Integer) s10.first).intValue() || eVar.f٣٧٥٤d == ((Integer) s10.second).intValue())) {
                                i10 = eVar.f٣٧٥٤d;
                            } else {
                                int i16 = eVar.f٣٧٥٣c;
                                if (i16 != i12 && i16 != 7 && i16 != i11) {
                                    if (f٣٧٠٩v) {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("Given tag (");
                                        sb.append(str4);
                                        sb.append(") value didn't match with one of expected formats: ");
                                        String[] strArr = W;
                                        sb.append(strArr[eVar.f٣٧٥٣c]);
                                        String str6 = "";
                                        if (eVar.f٣٧٥٤d == -1) {
                                            str3 = "";
                                        } else {
                                            str3 = ", " + strArr[eVar.f٣٧٥٤d];
                                        }
                                        sb.append(str3);
                                        sb.append(" (guess: ");
                                        sb.append(strArr[((Integer) s10.first).intValue()]);
                                        if (((Integer) s10.second).intValue() != -1) {
                                            str6 = ", " + strArr[((Integer) s10.second).intValue()];
                                        }
                                        sb.append(str6);
                                        sb.append(")");
                                        Log.d("ExifInterface", sb.toString());
                                    }
                                } else {
                                    i10 = i16;
                                }
                            }
                        } else {
                            i10 = eVar.f٣٧٥٣c;
                        }
                        switch (i10) {
                            case 1:
                                this.f٣٧٢٠f[i13].put(str4, d.a(str5));
                                continue;
                            case 2:
                            case 7:
                                this.f٣٧٢٠f[i13].put(str4, d.e(str5));
                                continue;
                            case 3:
                                String[] split = str5.split(",", -1);
                                int[] iArr = new int[split.length];
                                for (int i17 = 0; i17 < split.length; i17++) {
                                    iArr[i17] = Integer.parseInt(split[i17]);
                                }
                                this.f٣٧٢٠f[i13].put(str4, d.k(iArr, this.f٣٧٢٢h));
                                continue;
                            case 4:
                                String[] split2 = str5.split(",", -1);
                                long[] jArr = new long[split2.length];
                                for (int i18 = 0; i18 < split2.length; i18++) {
                                    jArr[i18] = Long.parseLong(split2[i18]);
                                }
                                this.f٣٧٢٠f[i13].put(str4, d.g(jArr, this.f٣٧٢٢h));
                                continue;
                            case 5:
                                String[] split3 = str5.split(",", -1);
                                f[] fVarArr = new f[split3.length];
                                int i19 = 0;
                                while (i19 < split3.length) {
                                    String[] split4 = split3[i19].split("/", i14);
                                    fVarArr[i19] = new f((long) Double.parseDouble(split4[0]), (long) Double.parseDouble(split4[1]));
                                    i19++;
                                    i14 = -1;
                                }
                                this.f٣٧٢٠f[i13].put(str4, d.i(fVarArr, this.f٣٧٢٢h));
                                continue;
                            case 6:
                            case 8:
                            case 11:
                            default:
                                if (f٣٧٠٩v) {
                                    Log.d("ExifInterface", "Data format isn't one of expected formats: " + i10);
                                    break;
                                }
                                break;
                            case 9:
                                String[] split5 = str5.split(",", -1);
                                int[] iArr2 = new int[split5.length];
                                for (int i20 = 0; i20 < split5.length; i20++) {
                                    iArr2[i20] = Integer.parseInt(split5[i20]);
                                }
                                this.f٣٧٢٠f[i13].put(str4, d.c(iArr2, this.f٣٧٢٢h));
                                break;
                            case 10:
                                String[] split6 = str5.split(",", -1);
                                f[] fVarArr2 = new f[split6.length];
                                int i21 = 0;
                                while (i21 < split6.length) {
                                    String[] split7 = split6[i21].split("/", -1);
                                    fVarArr2[i21] = new f((long) Double.parseDouble(split7[c10]), (long) Double.parseDouble(split7[i12]));
                                    i21++;
                                    split6 = split6;
                                    c10 = 0;
                                    i12 = 1;
                                }
                                this.f٣٧٢٠f[i13].put(str4, d.d(fVarArr2, this.f٣٧٢٢h));
                                break;
                            case 12:
                                String[] split8 = str5.split(",", -1);
                                double[] dArr = new double[split8.length];
                                for (int i22 = 0; i22 < split8.length; i22++) {
                                    dArr[i22] = Double.parseDouble(split8[i22]);
                                }
                                this.f٣٧٢٠f[i13].put(str4, d.b(dArr, this.f٣٧٢٢h));
                                break;
                        }
                    }
                }
                i13++;
                i11 = 2;
                c10 = 0;
                i12 = 1;
            }
            return;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    public String d(String str) {
        if (str != null) {
            d f10 = f(str);
            if (f10 != null) {
                if (!f٣٧٠١n0.contains(str)) {
                    return f10.n(this.f٣٧٢٢h);
                }
                if (str.equals("GPSTimeStamp")) {
                    int i10 = f10.f٣٧٤٧a;
                    if (i10 != 5 && i10 != 10) {
                        Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + f10.f٣٧٤٧a);
                        return null;
                    }
                    f[] fVarArr = (f[]) f10.o(this.f٣٧٢٢h);
                    if (fVarArr != null && fVarArr.length == 3) {
                        f fVar = fVarArr[0];
                        Integer valueOf = Integer.valueOf((int) (((float) fVar.f٣٧٥٥a) / ((float) fVar.f٣٧٥٦b)));
                        f fVar2 = fVarArr[1];
                        Integer valueOf2 = Integer.valueOf((int) (((float) fVar2.f٣٧٥٥a) / ((float) fVar2.f٣٧٥٦b)));
                        f fVar3 = fVarArr[2];
                        return String.format("%02d:%02d:%02d", valueOf, valueOf2, Integer.valueOf((int) (((float) fVar3.f٣٧٥٥a) / ((float) fVar3.f٣٧٥٦b))));
                    }
                    Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(fVarArr));
                    return null;
                }
                try {
                    return Double.toString(f10.l(this.f٣٧٢٢h));
                } catch (NumberFormatException unused) {
                }
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    public int e(String str, int i10) {
        if (str != null) {
            d f10 = f(str);
            if (f10 == null) {
                return i10;
            }
            try {
                return f10.m(this.f٣٧٢٢h);
            } catch (NumberFormatException unused) {
                return i10;
            }
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    public byte[] p() {
        int i10 = this.f٣٧٢٩o;
        if (i10 != 6 && i10 != 7) {
            return null;
        }
        return q();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006f A[Catch: all -> 0x0086, Exception -> 0x0088, TRY_ENTER, TryCatch #2 {all -> 0x0086, blocks: (B:17:0x0059, B:20:0x006f, B:22:0x007b, B:27:0x008a, B:28:0x008f, B:29:0x0090, B:30:0x0095, B:32:0x009d), top: B:6:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0090 A[Catch: all -> 0x0086, Exception -> 0x0088, TryCatch #2 {all -> 0x0086, blocks: (B:17:0x0059, B:20:0x006f, B:22:0x007b, B:27:0x008a, B:28:0x008f, B:29:0x0090, B:30:0x0095, B:32:0x009d), top: B:6:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b0  */
    /* JADX WARN: Type inference failed for: r1v1, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.content.res.AssetManager$AssetInputStream, java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.Closeable, java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] q() {
        FileDescriptor fileDescriptor;
        Exception e10;
        FileDescriptor fileDescriptor2;
        FileInputStream fileInputStream;
        Closeable closeable = null;
        if (!this.f٣٧٢٣i) {
            return null;
        }
        ?? r12 = this.f٣٧٢٨n;
        try {
            if (r12 != 0) {
                return r12;
            }
            try {
                r12 = this.f٣٧١٧c;
                try {
                    if (r12 != 0) {
                        try {
                            if (r12.markSupported()) {
                                r12.reset();
                                fileInputStream = r12;
                            } else {
                                Log.d("ExifInterface", "Cannot read thumbnail from inputstream without mark/reset support");
                                androidx.exifinterface.media.b.c(r12);
                                return null;
                            }
                        } catch (Exception e11) {
                            e10 = e11;
                            fileDescriptor2 = null;
                            Log.d("ExifInterface", "Encountered exception while getting thumbnail", e10);
                            androidx.exifinterface.media.b.c(r12);
                            if (fileDescriptor2 != null) {
                            }
                            return null;
                        } catch (Throwable th) {
                            th = th;
                            fileDescriptor = null;
                            closeable = r12;
                            androidx.exifinterface.media.b.c(closeable);
                            if (fileDescriptor != null) {
                            }
                            throw th;
                        }
                    } else if (this.f٣٧١٥a != null) {
                        fileInputStream = new FileInputStream(this.f٣٧١٥a);
                    } else {
                        FileDescriptor b10 = b.a.b(this.f٣٧١٦b);
                        try {
                            b.a.c(b10, 0L, OsConstants.SEEK_SET);
                            fileDescriptor2 = b10;
                            r12 = new FileInputStream(b10);
                            if (r12.skip(this.f٣٧٢٦l + this.f٣٧٣٠p) != this.f٣٧٢٦l + this.f٣٧٣٠p) {
                                byte[] bArr = new byte[this.f٣٧٢٧m];
                                if (r12.read(bArr) == this.f٣٧٢٧m) {
                                    this.f٣٧٢٨n = bArr;
                                    androidx.exifinterface.media.b.c(r12);
                                    if (fileDescriptor2 != null) {
                                        androidx.exifinterface.media.b.b(fileDescriptor2);
                                    }
                                    return bArr;
                                }
                                throw new IOException("Corrupted image");
                            }
                            throw new IOException("Corrupted image");
                        } catch (Exception e12) {
                            e10 = e12;
                            fileDescriptor2 = b10;
                            r12 = 0;
                            Log.d("ExifInterface", "Encountered exception while getting thumbnail", e10);
                            androidx.exifinterface.media.b.c(r12);
                            if (fileDescriptor2 != null) {
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            fileDescriptor = b10;
                            androidx.exifinterface.media.b.c(closeable);
                            if (fileDescriptor != null) {
                                androidx.exifinterface.media.b.b(fileDescriptor);
                            }
                            throw th;
                        }
                    }
                    if (r12.skip(this.f٣٧٢٦l + this.f٣٧٣٠p) != this.f٣٧٢٦l + this.f٣٧٣٠p) {
                    }
                } catch (Exception e13) {
                    e10 = e13;
                    Log.d("ExifInterface", "Encountered exception while getting thumbnail", e10);
                    androidx.exifinterface.media.b.c(r12);
                    if (fileDescriptor2 != null) {
                        androidx.exifinterface.media.b.b(fileDescriptor2);
                    }
                    return null;
                }
                fileDescriptor2 = null;
                r12 = fileInputStream;
            } catch (Exception e14) {
                r12 = 0;
                e10 = e14;
                fileDescriptor2 = null;
            } catch (Throwable th3) {
                th = th3;
                fileDescriptor = null;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class g extends b {
        g(byte[] bArr) {
            super(bArr);
            this.f٣٧٤١a.mark(Integer.MAX_VALUE);
        }

        public void h(long j10) {
            int i10 = this.f٣٧٤٣c;
            if (i10 > j10) {
                this.f٣٧٤٣c = 0;
                this.f٣٧٤١a.reset();
            } else {
                j10 -= i10;
            }
            g((int) j10);
        }

        g(InputStream inputStream) {
            super(inputStream);
            if (inputStream.markSupported()) {
                this.f٣٧٤١a.mark(Integer.MAX_VALUE);
                return;
            }
            throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public final int f٣٧٥١a;

        /* renamed from: b, reason: collision with root package name */
        public final String f٣٧٥٢b;

        /* renamed from: c, reason: collision with root package name */
        public final int f٣٧٥٣c;

        /* renamed from: d, reason: collision with root package name */
        public final int f٣٧٥٤d;

        e(String str, int i10, int i11) {
            this.f٣٧٥٢b = str;
            this.f٣٧٥١a = i10;
            this.f٣٧٥٣c = i11;
            this.f٣٧٥٤d = -1;
        }

        boolean a(int i10) {
            int i11;
            int i12 = this.f٣٧٥٣c;
            if (i12 == 7 || i10 == 7 || i12 == i10 || (i11 = this.f٣٧٥٤d) == i10) {
                return true;
            }
            if ((i12 == 4 || i11 == 4) && i10 == 3) {
                return true;
            }
            if ((i12 == 9 || i11 == 9) && i10 == 8) {
                return true;
            }
            if ((i12 == 12 || i11 == 12) && i10 == 11) {
                return true;
            }
            return false;
        }

        e(String str, int i10, int i11, int i12) {
            this.f٣٧٥٢b = str;
            this.f٣٧٥١a = i10;
            this.f٣٧٥٣c = i11;
            this.f٣٧٥٤d = i12;
        }
    }

    public a(FileDescriptor fileDescriptor) {
        boolean z10;
        FileInputStream fileInputStream;
        Throwable th;
        e[][] eVarArr = f٣٦٩٧j0;
        this.f٣٧٢٠f = new HashMap[eVarArr.length];
        this.f٣٧٢١g = new HashSet(eVarArr.length);
        this.f٣٧٢٢h = ByteOrder.BIG_ENDIAN;
        if (fileDescriptor != null) {
            this.f٣٧١٧c = null;
            this.f٣٧١٥a = null;
            if (D(fileDescriptor)) {
                this.f٣٧١٦b = fileDescriptor;
                try {
                    fileDescriptor = b.a.b(fileDescriptor);
                    z10 = true;
                } catch (Exception e10) {
                    throw new IOException("Failed to duplicate file descriptor", e10);
                }
            } else {
                this.f٣٧١٦b = null;
                z10 = false;
            }
            try {
                fileInputStream = new FileInputStream(fileDescriptor);
                try {
                    I(fileInputStream);
                    androidx.exifinterface.media.b.c(fileInputStream);
                    if (z10) {
                        androidx.exifinterface.media.b.b(fileDescriptor);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    androidx.exifinterface.media.b.c(fileInputStream);
                    if (z10) {
                        androidx.exifinterface.media.b.b(fileDescriptor);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                fileInputStream = null;
                th = th3;
            }
        } else {
            throw new NullPointerException("fileDescriptor cannot be null");
        }
    }

    public a(InputStream inputStream) {
        this(inputStream, 0);
    }

    public a(InputStream inputStream, int i10) {
        e[][] eVarArr = f٣٦٩٧j0;
        this.f٣٧٢٠f = new HashMap[eVarArr.length];
        this.f٣٧٢١g = new HashSet(eVarArr.length);
        this.f٣٧٢٢h = ByteOrder.BIG_ENDIAN;
        if (inputStream != null) {
            this.f٣٧١٥a = null;
            if (i10 == 1) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, f٣٧٠٤q0.length);
                if (!w(bufferedInputStream)) {
                    Log.w("ExifInterface", "Given data does not follow the structure of an Exif-only data.");
                    return;
                }
                this.f٣٧١٩e = true;
                this.f٣٧١٧c = null;
                this.f٣٧١٦b = null;
                inputStream = bufferedInputStream;
            } else if (inputStream instanceof AssetManager.AssetInputStream) {
                this.f٣٧١٧c = (AssetManager.AssetInputStream) inputStream;
                this.f٣٧١٦b = null;
            } else {
                if (inputStream instanceof FileInputStream) {
                    FileInputStream fileInputStream = (FileInputStream) inputStream;
                    if (D(fileInputStream.getFD())) {
                        this.f٣٧١٧c = null;
                        this.f٣٧١٦b = fileInputStream.getFD();
                    }
                }
                this.f٣٧١٧c = null;
                this.f٣٧١٦b = null;
            }
            I(inputStream);
            return;
        }
        throw new NullPointerException("inputStream cannot be null");
    }
}
