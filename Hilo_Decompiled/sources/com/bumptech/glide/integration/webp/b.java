package com.bumptech.glide.integration.webp;

import f5.k;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.KotlinVersion;
import v4.e0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f٧٢٩٠a = f();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class a implements c {

        /* renamed from: a, reason: collision with root package name */
        private final byte[] f٧٢٩١a;

        /* renamed from: b, reason: collision with root package name */
        private final int f٧٢٩٢b;

        /* renamed from: c, reason: collision with root package name */
        private final int f٧٢٩٣c;

        /* renamed from: d, reason: collision with root package name */
        private int f٧٢٩٤d;

        a(byte[] bArr, int i10, int i11) {
            this.f٧٢٩١a = bArr;
            this.f٧٢٩٢b = i10;
            this.f٧٢٩٣c = i11;
            this.f٧٢٩٤d = i10;
        }

        @Override // com.bumptech.glide.integration.webp.b.c
        public int a() {
            int i10 = this.f٧٢٩٤d;
            if (i10 >= this.f٧٢٩٢b + this.f٧٢٩٣c) {
                return -1;
            }
            byte[] bArr = this.f٧٢٩١a;
            this.f٧٢٩٤d = i10 + 1;
            return bArr[i10];
        }

        @Override // com.bumptech.glide.integration.webp.b.c
        public int getUInt16() {
            return ((a() << 8) & 65280) | (a() & KotlinVersion.MAX_COMPONENT_VALUE);
        }

        @Override // com.bumptech.glide.integration.webp.b.c
        public long skip(long j10) {
            int min = (int) Math.min((this.f٧٢٩٢b + this.f٧٢٩٣c) - this.f٧٢٩٤d, j10);
            this.f٧٢٩٤d += min;
            return min;
        }
    }

    /* renamed from: com.bumptech.glide.integration.webp.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class C٠١٠٤b implements c {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f٧٢٩٥a;

        C٠١٠٤b(ByteBuffer byteBuffer) {
            this.f٧٢٩٥a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.bumptech.glide.integration.webp.b.c
        public int a() {
            if (this.f٧٢٩٥a.remaining() < 1) {
                return -1;
            }
            return this.f٧٢٩٥a.get();
        }

        @Override // com.bumptech.glide.integration.webp.b.c
        public int getUInt16() {
            return ((a() << 8) & 65280) | (a() & KotlinVersion.MAX_COMPONENT_VALUE);
        }

        @Override // com.bumptech.glide.integration.webp.b.c
        public long skip(long j10) {
            int min = (int) Math.min(this.f٧٢٩٥a.remaining(), j10);
            ByteBuffer byteBuffer = this.f٧٢٩٥a;
            byteBuffer.position(byteBuffer.position() + min);
            return min;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface c {
        int a();

        int getUInt16();

        long skip(long j10);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class d implements c {

        /* renamed from: a, reason: collision with root package name */
        private final InputStream f٧٢٩٦a;

        d(InputStream inputStream) {
            this.f٧٢٩٦a = inputStream;
        }

        @Override // com.bumptech.glide.integration.webp.b.c
        public int a() {
            return this.f٧٢٩٦a.read();
        }

        @Override // com.bumptech.glide.integration.webp.b.c
        public int getUInt16() {
            return ((this.f٧٢٩٦a.read() << 8) & 65280) | (this.f٧٢٩٦a.read() & KotlinVersion.MAX_COMPONENT_VALUE);
        }

        @Override // com.bumptech.glide.integration.webp.b.c
        public long skip(long j10) {
            if (j10 < 0) {
                return 0L;
            }
            long j11 = j10;
            while (j11 > 0) {
                long skip = this.f٧٢٩٦a.skip(j11);
                if (skip <= 0) {
                    if (this.f٧٢٩٦a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j11 -= skip;
            }
            return j10 - j11;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public enum e {
        WEBP_SIMPLE(false, false),
        WEBP_LOSSLESS(false, false),
        WEBP_LOSSLESS_WITH_ALPHA(true, false),
        WEBP_EXTENDED(false, false),
        WEBP_EXTENDED_WITH_ALPHA(true, false),
        WEBP_EXTENDED_ANIMATED(false, true),
        NONE_WEBP(false, false);


        /* renamed from: a, reason: collision with root package name */
        private final boolean f٧٣٠٥a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f٧٣٠٦b;

        e(boolean z10, boolean z11) {
            this.f٧٣٠٥a = z10;
            this.f٧٣٠٦b = z11;
        }
    }

    private static e a(c cVar) {
        if ((((cVar.getUInt16() << 16) & (-65536)) | (cVar.getUInt16() & 65535)) != 1380533830) {
            return e.NONE_WEBP;
        }
        cVar.skip(4L);
        if ((((cVar.getUInt16() << 16) & (-65536)) | (cVar.getUInt16() & 65535)) != 1464156752) {
            return e.NONE_WEBP;
        }
        int uInt16 = ((cVar.getUInt16() << 16) & (-65536)) | (cVar.getUInt16() & 65535);
        if (uInt16 == 1448097824) {
            return e.WEBP_SIMPLE;
        }
        if (uInt16 == 1448097868) {
            cVar.skip(4L);
            if ((cVar.a() & 8) != 0) {
                return e.WEBP_LOSSLESS_WITH_ALPHA;
            }
            return e.WEBP_LOSSLESS;
        }
        if (uInt16 == 1448097880) {
            cVar.skip(4L);
            int a10 = cVar.a();
            if ((a10 & 2) != 0) {
                return e.WEBP_EXTENDED_ANIMATED;
            }
            if ((a10 & 16) != 0) {
                return e.WEBP_EXTENDED_WITH_ALPHA;
            }
            return e.WEBP_EXTENDED;
        }
        return e.NONE_WEBP;
    }

    public static e b(InputStream inputStream, p4.b bVar) {
        if (inputStream == null) {
            return e.NONE_WEBP;
        }
        if (!inputStream.markSupported()) {
            inputStream = new e0(inputStream, bVar);
        }
        inputStream.mark(21);
        try {
            return a(new d((InputStream) k.d(inputStream)));
        } finally {
            inputStream.reset();
        }
    }

    public static e c(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return e.NONE_WEBP;
        }
        return a(new C٠١٠٤b((ByteBuffer) k.d(byteBuffer)));
    }

    public static e d(byte[] bArr, int i10, int i11) {
        return a(new a(bArr, i10, i11));
    }

    public static boolean e(e eVar) {
        if (eVar == e.WEBP_EXTENDED_ANIMATED) {
            return true;
        }
        return false;
    }

    public static boolean f() {
        return true;
    }

    public static boolean g(e eVar) {
        if (eVar != e.WEBP_SIMPLE && eVar != e.WEBP_LOSSLESS && eVar != e.WEBP_LOSSLESS_WITH_ALPHA && eVar != e.WEBP_EXTENDED && eVar != e.WEBP_EXTENDED_WITH_ALPHA) {
            return false;
        }
        return true;
    }
}
