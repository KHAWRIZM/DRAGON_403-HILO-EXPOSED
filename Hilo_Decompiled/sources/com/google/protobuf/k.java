package com.google.protobuf;

import com.google.protobuf.q2;
import io.agora.rtc.Constants;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.KotlinVersion;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class k extends g {

    /* renamed from: b, reason: collision with root package name */
    private static final Logger f١١١٧١b = Logger.getLogger(k.class.getName());

    /* renamed from: c, reason: collision with root package name */
    private static final boolean f١١١٧٢c = p2.J();

    /* renamed from: a, reason: collision with root package name */
    private boolean f١١١٧٣a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static abstract class b extends k {

        /* renamed from: d, reason: collision with root package name */
        final byte[] f١١١٧٤d;

        /* renamed from: e, reason: collision with root package name */
        final int f١١١٧٥e;

        /* renamed from: f, reason: collision with root package name */
        int f١١١٧٦f;

        /* renamed from: g, reason: collision with root package name */
        int f١١١٧٧g;

        b(int i10) {
            super();
            if (i10 >= 0) {
                byte[] bArr = new byte[Math.max(i10, 20)];
                this.f١١١٧٤d = bArr;
                this.f١١١٧٥e = bArr.length;
                return;
            }
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }

        final void W0(byte b10) {
            byte[] bArr = this.f١١١٧٤d;
            int i10 = this.f١١١٧٦f;
            this.f١١١٧٦f = i10 + 1;
            bArr[i10] = b10;
            this.f١١١٧٧g++;
        }

        final void X0(int i10) {
            byte[] bArr = this.f١١١٧٤d;
            int i11 = this.f١١١٧٦f;
            int i12 = i11 + 1;
            this.f١١١٧٦f = i12;
            bArr[i11] = (byte) (i10 & KotlinVersion.MAX_COMPONENT_VALUE);
            int i13 = i11 + 2;
            this.f١١١٧٦f = i13;
            bArr[i12] = (byte) ((i10 >> 8) & KotlinVersion.MAX_COMPONENT_VALUE);
            int i14 = i11 + 3;
            this.f١١١٧٦f = i14;
            bArr[i13] = (byte) ((i10 >> 16) & KotlinVersion.MAX_COMPONENT_VALUE);
            this.f١١١٧٦f = i11 + 4;
            bArr[i14] = (byte) ((i10 >> 24) & KotlinVersion.MAX_COMPONENT_VALUE);
            this.f١١١٧٧g += 4;
        }

        final void Y0(long j10) {
            byte[] bArr = this.f١١١٧٤d;
            int i10 = this.f١١١٧٦f;
            int i11 = i10 + 1;
            this.f١١١٧٦f = i11;
            bArr[i10] = (byte) (j10 & 255);
            int i12 = i10 + 2;
            this.f١١١٧٦f = i12;
            bArr[i11] = (byte) ((j10 >> 8) & 255);
            int i13 = i10 + 3;
            this.f١١١٧٦f = i13;
            bArr[i12] = (byte) ((j10 >> 16) & 255);
            int i14 = i10 + 4;
            this.f١١١٧٦f = i14;
            bArr[i13] = (byte) (255 & (j10 >> 24));
            int i15 = i10 + 5;
            this.f١١١٧٦f = i15;
            bArr[i14] = (byte) (((int) (j10 >> 32)) & KotlinVersion.MAX_COMPONENT_VALUE);
            int i16 = i10 + 6;
            this.f١١١٧٦f = i16;
            bArr[i15] = (byte) (((int) (j10 >> 40)) & KotlinVersion.MAX_COMPONENT_VALUE);
            int i17 = i10 + 7;
            this.f١١١٧٦f = i17;
            bArr[i16] = (byte) (((int) (j10 >> 48)) & KotlinVersion.MAX_COMPONENT_VALUE);
            this.f١١١٧٦f = i10 + 8;
            bArr[i17] = (byte) (((int) (j10 >> 56)) & KotlinVersion.MAX_COMPONENT_VALUE);
            this.f١١١٧٧g += 8;
        }

        final void Z0(int i10) {
            if (i10 >= 0) {
                b1(i10);
            } else {
                c1(i10);
            }
        }

        final void a1(int i10, int i11) {
            b1(r2.c(i10, i11));
        }

        final void b1(int i10) {
            if (k.f١١١٧٢c) {
                long j10 = this.f١١١٧٦f;
                while ((i10 & (-128)) != 0) {
                    byte[] bArr = this.f١١١٧٤d;
                    int i11 = this.f١١١٧٦f;
                    this.f١١١٧٦f = i11 + 1;
                    p2.Q(bArr, i11, (byte) ((i10 & Constants.ERR_WATERMARKR_INFO) | 128));
                    i10 >>>= 7;
                }
                byte[] bArr2 = this.f١١١٧٤d;
                int i12 = this.f١١١٧٦f;
                this.f١١١٧٦f = i12 + 1;
                p2.Q(bArr2, i12, (byte) i10);
                this.f١١١٧٧g += (int) (this.f١١١٧٦f - j10);
                return;
            }
            while ((i10 & (-128)) != 0) {
                byte[] bArr3 = this.f١١١٧٤d;
                int i13 = this.f١١١٧٦f;
                this.f١١١٧٦f = i13 + 1;
                bArr3[i13] = (byte) ((i10 & Constants.ERR_WATERMARKR_INFO) | 128);
                this.f١١١٧٧g++;
                i10 >>>= 7;
            }
            byte[] bArr4 = this.f١١١٧٤d;
            int i14 = this.f١١١٧٦f;
            this.f١١١٧٦f = i14 + 1;
            bArr4[i14] = (byte) i10;
            this.f١١١٧٧g++;
        }

        final void c1(long j10) {
            if (k.f١١١٧٢c) {
                long j11 = this.f١١١٧٦f;
                while ((j10 & (-128)) != 0) {
                    byte[] bArr = this.f١١١٧٤d;
                    int i10 = this.f١١١٧٦f;
                    this.f١١١٧٦f = i10 + 1;
                    p2.Q(bArr, i10, (byte) ((((int) j10) & Constants.ERR_WATERMARKR_INFO) | 128));
                    j10 >>>= 7;
                }
                byte[] bArr2 = this.f١١١٧٤d;
                int i11 = this.f١١١٧٦f;
                this.f١١١٧٦f = i11 + 1;
                p2.Q(bArr2, i11, (byte) j10);
                this.f١١١٧٧g += (int) (this.f١١١٧٦f - j11);
                return;
            }
            while ((j10 & (-128)) != 0) {
                byte[] bArr3 = this.f١١١٧٤d;
                int i12 = this.f١١١٧٦f;
                this.f١١١٧٦f = i12 + 1;
                bArr3[i12] = (byte) ((((int) j10) & Constants.ERR_WATERMARKR_INFO) | 128);
                this.f١١١٧٧g++;
                j10 >>>= 7;
            }
            byte[] bArr4 = this.f١١١٧٤d;
            int i13 = this.f١١١٧٦f;
            this.f١١١٧٦f = i13 + 1;
            bArr4[i13] = (byte) j10;
            this.f١١١٧٧g++;
        }

        @Override // com.google.protobuf.k
        public final int j0() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class c extends k {

        /* renamed from: d, reason: collision with root package name */
        private final byte[] f١١١٧٨d;

        /* renamed from: e, reason: collision with root package name */
        private final int f١١١٧٩e;

        /* renamed from: f, reason: collision with root package name */
        private final int f١١١٨٠f;

        /* renamed from: g, reason: collision with root package name */
        private int f١١١٨١g;

        c(byte[] bArr, int i10, int i11) {
            super();
            if (bArr != null) {
                int i12 = i10 + i11;
                if ((i10 | i11 | (bArr.length - i12)) >= 0) {
                    this.f١١١٧٨d = bArr;
                    this.f١١١٧٩e = i10;
                    this.f١١١٨١g = i10;
                    this.f١١١٨٠f = i12;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i10), Integer.valueOf(i11)));
            }
            throw new NullPointerException("buffer");
        }

        @Override // com.google.protobuf.k
        public final void D0(int i10, int i11) {
            R0(i10, 0);
            E0(i11);
        }

        @Override // com.google.protobuf.k
        public final void E0(int i10) {
            if (i10 >= 0) {
                T0(i10);
            } else {
                V0(i10);
            }
        }

        @Override // com.google.protobuf.k
        public final void H0(int i10, e1 e1Var) {
            R0(i10, 2);
            I0(e1Var);
        }

        @Override // com.google.protobuf.k
        public final void I0(e1 e1Var) {
            T0(e1Var.getSerializedSize());
            e1Var.writeTo(this);
        }

        @Override // com.google.protobuf.k
        public final void J0(int i10, e1 e1Var) {
            R0(1, 3);
            S0(2, i10);
            H0(3, e1Var);
            R0(1, 4);
        }

        @Override // com.google.protobuf.k
        public final void K0(int i10, h hVar) {
            R0(1, 3);
            S0(2, i10);
            p0(3, hVar);
            R0(1, 4);
        }

        @Override // com.google.protobuf.k
        public final void P0(int i10, String str) {
            R0(i10, 2);
            Q0(str);
        }

        @Override // com.google.protobuf.k
        public final void Q0(String str) {
            int i10 = this.f١١١٨١g;
            try {
                int Y = k.Y(str.length() * 3);
                int Y2 = k.Y(str.length());
                if (Y2 == Y) {
                    int i11 = i10 + Y2;
                    this.f١١١٨١g = i11;
                    int i12 = q2.i(str, this.f١١١٧٨d, i11, j0());
                    this.f١١١٨١g = i10;
                    T0((i12 - i10) - Y2);
                    this.f١١١٨١g = i12;
                } else {
                    T0(q2.j(str));
                    this.f١١١٨١g = q2.i(str, this.f١١١٧٨d, this.f١١١٨١g, j0());
                }
            } catch (q2.d e10) {
                this.f١١١٨١g = i10;
                e0(str, e10);
            } catch (IndexOutOfBoundsException e11) {
                throw new d(e11);
            }
        }

        @Override // com.google.protobuf.k
        public final void R0(int i10, int i11) {
            T0(r2.c(i10, i11));
        }

        @Override // com.google.protobuf.k
        public final void S0(int i10, int i11) {
            R0(i10, 0);
            T0(i11);
        }

        @Override // com.google.protobuf.k
        public final void T0(int i10) {
            while ((i10 & (-128)) != 0) {
                try {
                    byte[] bArr = this.f١١١٧٨d;
                    int i11 = this.f١١١٨١g;
                    this.f١١١٨١g = i11 + 1;
                    bArr[i11] = (byte) ((i10 & Constants.ERR_WATERMARKR_INFO) | 128);
                    i10 >>>= 7;
                } catch (IndexOutOfBoundsException e10) {
                    throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f١١١٨١g), Integer.valueOf(this.f١١١٨٠f), 1), e10);
                }
            }
            byte[] bArr2 = this.f١١١٧٨d;
            int i12 = this.f١١١٨١g;
            this.f١١١٨١g = i12 + 1;
            bArr2[i12] = (byte) i10;
        }

        @Override // com.google.protobuf.k
        public final void U0(int i10, long j10) {
            R0(i10, 0);
            V0(j10);
        }

        @Override // com.google.protobuf.k
        public final void V0(long j10) {
            if (k.f١١١٧٢c && j0() >= 10) {
                while ((j10 & (-128)) != 0) {
                    byte[] bArr = this.f١١١٧٨d;
                    int i10 = this.f١١١٨١g;
                    this.f١١١٨١g = i10 + 1;
                    p2.Q(bArr, i10, (byte) ((((int) j10) & Constants.ERR_WATERMARKR_INFO) | 128));
                    j10 >>>= 7;
                }
                byte[] bArr2 = this.f١١١٧٨d;
                int i11 = this.f١١١٨١g;
                this.f١١١٨١g = 1 + i11;
                p2.Q(bArr2, i11, (byte) j10);
                return;
            }
            while ((j10 & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f١١١٧٨d;
                    int i12 = this.f١١١٨١g;
                    this.f١١١٨١g = i12 + 1;
                    bArr3[i12] = (byte) ((((int) j10) & Constants.ERR_WATERMARKR_INFO) | 128);
                    j10 >>>= 7;
                } catch (IndexOutOfBoundsException e10) {
                    throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f١١١٨١g), Integer.valueOf(this.f١١١٨٠f), 1), e10);
                }
            }
            byte[] bArr4 = this.f١١١٧٨d;
            int i13 = this.f١١١٨١g;
            this.f١١١٨١g = i13 + 1;
            bArr4[i13] = (byte) j10;
        }

        public final void W0(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            try {
                byteBuffer.get(this.f١١١٧٨d, this.f١١١٨١g, remaining);
                this.f١١١٨١g += remaining;
            } catch (IndexOutOfBoundsException e10) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f١١١٨١g), Integer.valueOf(this.f١١١٨٠f), Integer.valueOf(remaining)), e10);
            }
        }

        public final void X0(byte[] bArr, int i10, int i11) {
            try {
                System.arraycopy(bArr, i10, this.f١١١٧٨d, this.f١١١٨١g, i11);
                this.f١١١٨١g += i11;
            } catch (IndexOutOfBoundsException e10) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f١١١٨١g), Integer.valueOf(this.f١١١٨٠f), Integer.valueOf(i11)), e10);
            }
        }

        @Override // com.google.protobuf.g
        public final void a(ByteBuffer byteBuffer) {
            W0(byteBuffer);
        }

        @Override // com.google.protobuf.k, com.google.protobuf.g
        public final void b(byte[] bArr, int i10, int i11) {
            X0(bArr, i10, i11);
        }

        @Override // com.google.protobuf.k
        public void d0() {
        }

        @Override // com.google.protobuf.k
        public final int j0() {
            return this.f١١١٨٠f - this.f١١١٨١g;
        }

        @Override // com.google.protobuf.k
        public final void k0(byte b10) {
            try {
                byte[] bArr = this.f١١١٧٨d;
                int i10 = this.f١١١٨١g;
                this.f١١١٨١g = i10 + 1;
                bArr[i10] = b10;
            } catch (IndexOutOfBoundsException e10) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f١١١٨١g), Integer.valueOf(this.f١١١٨٠f), 1), e10);
            }
        }

        @Override // com.google.protobuf.k
        public final void l0(int i10, boolean z10) {
            R0(i10, 0);
            k0(z10 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.k
        public final void o0(byte[] bArr, int i10, int i11) {
            T0(i11);
            X0(bArr, i10, i11);
        }

        @Override // com.google.protobuf.k
        public final void p0(int i10, h hVar) {
            R0(i10, 2);
            q0(hVar);
        }

        @Override // com.google.protobuf.k
        public final void q0(h hVar) {
            T0(hVar.size());
            hVar.J(this);
        }

        @Override // com.google.protobuf.k
        public final void v0(int i10, int i11) {
            R0(i10, 5);
            w0(i11);
        }

        @Override // com.google.protobuf.k
        public final void w0(int i10) {
            try {
                byte[] bArr = this.f١١١٧٨d;
                int i11 = this.f١١١٨١g;
                int i12 = i11 + 1;
                this.f١١١٨١g = i12;
                bArr[i11] = (byte) (i10 & KotlinVersion.MAX_COMPONENT_VALUE);
                int i13 = i11 + 2;
                this.f١١١٨١g = i13;
                bArr[i12] = (byte) ((i10 >> 8) & KotlinVersion.MAX_COMPONENT_VALUE);
                int i14 = i11 + 3;
                this.f١١١٨١g = i14;
                bArr[i13] = (byte) ((i10 >> 16) & KotlinVersion.MAX_COMPONENT_VALUE);
                this.f١١١٨١g = i11 + 4;
                bArr[i14] = (byte) ((i10 >> 24) & KotlinVersion.MAX_COMPONENT_VALUE);
            } catch (IndexOutOfBoundsException e10) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f١١١٨١g), Integer.valueOf(this.f١١١٨٠f), 1), e10);
            }
        }

        @Override // com.google.protobuf.k
        public final void x0(int i10, long j10) {
            R0(i10, 1);
            y0(j10);
        }

        @Override // com.google.protobuf.k
        public final void y0(long j10) {
            try {
                byte[] bArr = this.f١١١٧٨d;
                int i10 = this.f١١١٨١g;
                int i11 = i10 + 1;
                this.f١١١٨١g = i11;
                bArr[i10] = (byte) (((int) j10) & KotlinVersion.MAX_COMPONENT_VALUE);
                int i12 = i10 + 2;
                this.f١١١٨١g = i12;
                bArr[i11] = (byte) (((int) (j10 >> 8)) & KotlinVersion.MAX_COMPONENT_VALUE);
                int i13 = i10 + 3;
                this.f١١١٨١g = i13;
                bArr[i12] = (byte) (((int) (j10 >> 16)) & KotlinVersion.MAX_COMPONENT_VALUE);
                int i14 = i10 + 4;
                this.f١١١٨١g = i14;
                bArr[i13] = (byte) (((int) (j10 >> 24)) & KotlinVersion.MAX_COMPONENT_VALUE);
                int i15 = i10 + 5;
                this.f١١١٨١g = i15;
                bArr[i14] = (byte) (((int) (j10 >> 32)) & KotlinVersion.MAX_COMPONENT_VALUE);
                int i16 = i10 + 6;
                this.f١١١٨١g = i16;
                bArr[i15] = (byte) (((int) (j10 >> 40)) & KotlinVersion.MAX_COMPONENT_VALUE);
                int i17 = i10 + 7;
                this.f١١١٨١g = i17;
                bArr[i16] = (byte) (((int) (j10 >> 48)) & KotlinVersion.MAX_COMPONENT_VALUE);
                this.f١١١٨١g = i10 + 8;
                bArr[i17] = (byte) (((int) (j10 >> 56)) & KotlinVersion.MAX_COMPONENT_VALUE);
            } catch (IndexOutOfBoundsException e10) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f١١١٨١g), Integer.valueOf(this.f١١١٨٠f), 1), e10);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class d extends IOException {
        private static final long serialVersionUID = -6947486886997889499L;

        d(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        d(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class e extends b {

        /* renamed from: h, reason: collision with root package name */
        private final OutputStream f١١١٨٢h;

        e(OutputStream outputStream, int i10) {
            super(i10);
            if (outputStream != null) {
                this.f١١١٨٢h = outputStream;
                return;
            }
            throw new NullPointerException("out");
        }

        private void d1() {
            this.f١١١٨٢h.write(this.f١١١٧٤d, 0, this.f١١١٧٦f);
            this.f١١١٧٦f = 0;
        }

        private void e1(int i10) {
            if (this.f١١١٧٥e - this.f١١١٧٦f < i10) {
                d1();
            }
        }

        @Override // com.google.protobuf.k
        public void D0(int i10, int i11) {
            e1(20);
            a1(i10, 0);
            Z0(i11);
        }

        @Override // com.google.protobuf.k
        public void E0(int i10) {
            if (i10 >= 0) {
                T0(i10);
            } else {
                V0(i10);
            }
        }

        @Override // com.google.protobuf.k
        public void H0(int i10, e1 e1Var) {
            R0(i10, 2);
            I0(e1Var);
        }

        @Override // com.google.protobuf.k
        public void I0(e1 e1Var) {
            T0(e1Var.getSerializedSize());
            e1Var.writeTo(this);
        }

        @Override // com.google.protobuf.k
        public void J0(int i10, e1 e1Var) {
            R0(1, 3);
            S0(2, i10);
            H0(3, e1Var);
            R0(1, 4);
        }

        @Override // com.google.protobuf.k
        public void K0(int i10, h hVar) {
            R0(1, 3);
            S0(2, i10);
            p0(3, hVar);
            R0(1, 4);
        }

        @Override // com.google.protobuf.k
        public void P0(int i10, String str) {
            R0(i10, 2);
            Q0(str);
        }

        @Override // com.google.protobuf.k
        public void Q0(String str) {
            int j10;
            try {
                int length = str.length() * 3;
                int Y = k.Y(length);
                int i10 = Y + length;
                int i11 = this.f١١١٧٥e;
                if (i10 > i11) {
                    byte[] bArr = new byte[length];
                    int i12 = q2.i(str, bArr, 0, length);
                    T0(i12);
                    b(bArr, 0, i12);
                    return;
                }
                if (i10 > i11 - this.f١١١٧٦f) {
                    d1();
                }
                int Y2 = k.Y(str.length());
                int i13 = this.f١١١٧٦f;
                try {
                    if (Y2 == Y) {
                        int i14 = i13 + Y2;
                        this.f١١١٧٦f = i14;
                        int i15 = q2.i(str, this.f١١١٧٤d, i14, this.f١١١٧٥e - i14);
                        this.f١١١٧٦f = i13;
                        j10 = (i15 - i13) - Y2;
                        b1(j10);
                        this.f١١١٧٦f = i15;
                    } else {
                        j10 = q2.j(str);
                        b1(j10);
                        this.f١١١٧٦f = q2.i(str, this.f١١١٧٤d, this.f١١١٧٦f, j10);
                    }
                    this.f١١١٧٧g += j10;
                } catch (q2.d e10) {
                    this.f١١١٧٧g -= this.f١١١٧٦f - i13;
                    this.f١١١٧٦f = i13;
                    throw e10;
                } catch (ArrayIndexOutOfBoundsException e11) {
                    throw new d(e11);
                }
            } catch (q2.d e12) {
                e0(str, e12);
            }
        }

        @Override // com.google.protobuf.k
        public void R0(int i10, int i11) {
            T0(r2.c(i10, i11));
        }

        @Override // com.google.protobuf.k
        public void S0(int i10, int i11) {
            e1(20);
            a1(i10, 0);
            b1(i11);
        }

        @Override // com.google.protobuf.k
        public void T0(int i10) {
            e1(5);
            b1(i10);
        }

        @Override // com.google.protobuf.k
        public void U0(int i10, long j10) {
            e1(20);
            a1(i10, 0);
            c1(j10);
        }

        @Override // com.google.protobuf.k
        public void V0(long j10) {
            e1(10);
            c1(j10);
        }

        @Override // com.google.protobuf.g
        public void a(ByteBuffer byteBuffer) {
            f1(byteBuffer);
        }

        @Override // com.google.protobuf.k, com.google.protobuf.g
        public void b(byte[] bArr, int i10, int i11) {
            g1(bArr, i10, i11);
        }

        @Override // com.google.protobuf.k
        public void d0() {
            if (this.f١١١٧٦f > 0) {
                d1();
            }
        }

        public void f1(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            int i10 = this.f١١١٧٥e;
            int i11 = this.f١١١٧٦f;
            if (i10 - i11 >= remaining) {
                byteBuffer.get(this.f١١١٧٤d, i11, remaining);
                this.f١١١٧٦f += remaining;
                this.f١١١٧٧g += remaining;
                return;
            }
            int i12 = i10 - i11;
            byteBuffer.get(this.f١١١٧٤d, i11, i12);
            int i13 = remaining - i12;
            this.f١١١٧٦f = this.f١١١٧٥e;
            this.f١١١٧٧g += i12;
            d1();
            while (true) {
                int i14 = this.f١١١٧٥e;
                if (i13 > i14) {
                    byteBuffer.get(this.f١١١٧٤d, 0, i14);
                    this.f١١١٨٢h.write(this.f١١١٧٤d, 0, this.f١١١٧٥e);
                    int i15 = this.f١١١٧٥e;
                    i13 -= i15;
                    this.f١١١٧٧g += i15;
                } else {
                    byteBuffer.get(this.f١١١٧٤d, 0, i13);
                    this.f١١١٧٦f = i13;
                    this.f١١١٧٧g += i13;
                    return;
                }
            }
        }

        public void g1(byte[] bArr, int i10, int i11) {
            int i12 = this.f١١١٧٥e;
            int i13 = this.f١١١٧٦f;
            if (i12 - i13 >= i11) {
                System.arraycopy(bArr, i10, this.f١١١٧٤d, i13, i11);
                this.f١١١٧٦f += i11;
                this.f١١١٧٧g += i11;
                return;
            }
            int i14 = i12 - i13;
            System.arraycopy(bArr, i10, this.f١١١٧٤d, i13, i14);
            int i15 = i10 + i14;
            int i16 = i11 - i14;
            this.f١١١٧٦f = this.f١١١٧٥e;
            this.f١١١٧٧g += i14;
            d1();
            if (i16 <= this.f١١١٧٥e) {
                System.arraycopy(bArr, i15, this.f١١١٧٤d, 0, i16);
                this.f١١١٧٦f = i16;
            } else {
                this.f١١١٨٢h.write(bArr, i15, i16);
            }
            this.f١١١٧٧g += i16;
        }

        @Override // com.google.protobuf.k
        public void k0(byte b10) {
            if (this.f١١١٧٦f == this.f١١١٧٥e) {
                d1();
            }
            W0(b10);
        }

        @Override // com.google.protobuf.k
        public void l0(int i10, boolean z10) {
            e1(11);
            a1(i10, 0);
            W0(z10 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.k
        public void o0(byte[] bArr, int i10, int i11) {
            T0(i11);
            g1(bArr, i10, i11);
        }

        @Override // com.google.protobuf.k
        public void p0(int i10, h hVar) {
            R0(i10, 2);
            q0(hVar);
        }

        @Override // com.google.protobuf.k
        public void q0(h hVar) {
            T0(hVar.size());
            hVar.J(this);
        }

        @Override // com.google.protobuf.k
        public void v0(int i10, int i11) {
            e1(14);
            a1(i10, 5);
            X0(i11);
        }

        @Override // com.google.protobuf.k
        public void w0(int i10) {
            e1(4);
            X0(i10);
        }

        @Override // com.google.protobuf.k
        public void x0(int i10, long j10) {
            e1(18);
            a1(i10, 1);
            Y0(j10);
        }

        @Override // com.google.protobuf.k
        public void y0(long j10) {
            e1(8);
            Y0(j10);
        }
    }

    public static int A(long j10) {
        return a0(j10);
    }

    public static int B(int i10, n0 n0Var) {
        return (W(1) * 2) + X(2, i10) + C(3, n0Var);
    }

    public static int C(int i10, n0 n0Var) {
        return W(i10) + D(n0Var);
    }

    public static int D(n0 n0Var) {
        return E(n0Var.a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int E(int i10) {
        return Y(i10) + i10;
    }

    public static int F(int i10, e1 e1Var) {
        return (W(1) * 2) + X(2, i10) + G(3, e1Var);
    }

    public static int G(int i10, e1 e1Var) {
        return W(i10) + I(e1Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int H(int i10, e1 e1Var, y1 y1Var) {
        return W(i10) + J(e1Var, y1Var);
    }

    public static int I(e1 e1Var) {
        return E(e1Var.getSerializedSize());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int J(e1 e1Var, y1 y1Var) {
        return E(((com.google.protobuf.b) e1Var).getSerializedSize(y1Var));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int K(int i10) {
        if (i10 > 4096) {
            return 4096;
        }
        return i10;
    }

    public static int L(int i10, h hVar) {
        return (W(1) * 2) + X(2, i10) + h(3, hVar);
    }

    public static int M(int i10, int i11) {
        return W(i10) + N(i11);
    }

    public static int N(int i10) {
        return 4;
    }

    public static int O(int i10, long j10) {
        return W(i10) + P(j10);
    }

    public static int P(long j10) {
        return 8;
    }

    public static int Q(int i10, int i11) {
        return W(i10) + R(i11);
    }

    public static int R(int i10) {
        return Y(b0(i10));
    }

    public static int S(int i10, long j10) {
        return W(i10) + T(j10);
    }

    public static int T(long j10) {
        return a0(c0(j10));
    }

    public static int U(int i10, String str) {
        return W(i10) + V(str);
    }

    public static int V(String str) {
        int length;
        try {
            length = q2.j(str);
        } catch (q2.d unused) {
            length = str.getBytes(j0.f١١١٦٢b).length;
        }
        return E(length);
    }

    public static int W(int i10) {
        return Y(r2.c(i10, 0));
    }

    public static int X(int i10, int i11) {
        return W(i10) + Y(i11);
    }

    public static int Y(int i10) {
        if ((i10 & (-128)) == 0) {
            return 1;
        }
        if ((i10 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i10) == 0) {
            return 3;
        }
        return (i10 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int Z(int i10, long j10) {
        return W(i10) + a0(j10);
    }

    public static int a0(long j10) {
        int i10;
        if (((-128) & j10) == 0) {
            return 1;
        }
        if (j10 < 0) {
            return 10;
        }
        if (((-34359738368L) & j10) != 0) {
            j10 >>>= 28;
            i10 = 6;
        } else {
            i10 = 2;
        }
        if (((-2097152) & j10) != 0) {
            i10 += 2;
            j10 >>>= 14;
        }
        return (j10 & (-16384)) != 0 ? i10 + 1 : i10;
    }

    public static int b0(int i10) {
        return (i10 >> 31) ^ (i10 << 1);
    }

    public static long c0(long j10) {
        return (j10 >> 63) ^ (j10 << 1);
    }

    public static int e(int i10, boolean z10) {
        return W(i10) + f(z10);
    }

    public static int f(boolean z10) {
        return 1;
    }

    public static int g(byte[] bArr) {
        return E(bArr.length);
    }

    public static k g0(OutputStream outputStream, int i10) {
        return new e(outputStream, i10);
    }

    public static int h(int i10, h hVar) {
        return W(i10) + i(hVar);
    }

    public static k h0(byte[] bArr) {
        return i0(bArr, 0, bArr.length);
    }

    public static int i(h hVar) {
        return E(hVar.size());
    }

    public static k i0(byte[] bArr, int i10, int i11) {
        return new c(bArr, i10, i11);
    }

    public static int j(int i10, double d10) {
        return W(i10) + k(d10);
    }

    public static int k(double d10) {
        return 8;
    }

    public static int l(int i10, int i11) {
        return W(i10) + m(i11);
    }

    public static int m(int i10) {
        return y(i10);
    }

    public static int n(int i10, int i11) {
        return W(i10) + o(i11);
    }

    public static int o(int i10) {
        return 4;
    }

    public static int p(int i10, long j10) {
        return W(i10) + q(j10);
    }

    public static int q(long j10) {
        return 8;
    }

    public static int r(int i10, float f10) {
        return W(i10) + s(f10);
    }

    public static int s(float f10) {
        return 4;
    }

    public static int t(int i10, e1 e1Var) {
        return (W(i10) * 2) + e1Var.getSerializedSize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int u(int i10, e1 e1Var, y1 y1Var) {
        return (W(i10) * 2) + w(e1Var, y1Var);
    }

    public static int v(e1 e1Var) {
        return e1Var.getSerializedSize();
    }

    static int w(e1 e1Var, y1 y1Var) {
        return ((com.google.protobuf.b) e1Var).getSerializedSize(y1Var);
    }

    public static int x(int i10, int i11) {
        return W(i10) + y(i11);
    }

    public static int y(int i10) {
        if (i10 >= 0) {
            return Y(i10);
        }
        return 10;
    }

    public static int z(int i10, long j10) {
        return W(i10) + A(j10);
    }

    public final void A0(float f10) {
        w0(Float.floatToRawIntBits(f10));
    }

    public final void B0(int i10, e1 e1Var) {
        R0(i10, 3);
        C0(e1Var);
        R0(i10, 4);
    }

    public final void C0(e1 e1Var) {
        e1Var.writeTo(this);
    }

    public abstract void D0(int i10, int i11);

    public abstract void E0(int i10);

    public final void F0(int i10, long j10) {
        U0(i10, j10);
    }

    public final void G0(long j10) {
        V0(j10);
    }

    public abstract void H0(int i10, e1 e1Var);

    public abstract void I0(e1 e1Var);

    public abstract void J0(int i10, e1 e1Var);

    public abstract void K0(int i10, h hVar);

    public final void L0(int i10) {
        w0(i10);
    }

    public final void M0(long j10) {
        y0(j10);
    }

    public final void N0(int i10) {
        T0(b0(i10));
    }

    public final void O0(long j10) {
        V0(c0(j10));
    }

    public abstract void P0(int i10, String str);

    public abstract void Q0(String str);

    public abstract void R0(int i10, int i11);

    public abstract void S0(int i10, int i11);

    public abstract void T0(int i10);

    public abstract void U0(int i10, long j10);

    public abstract void V0(long j10);

    @Override // com.google.protobuf.g
    public abstract void b(byte[] bArr, int i10, int i11);

    public final void d() {
        if (j0() == 0) {
        } else {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void d0();

    final void e0(String str, q2.d dVar) {
        f١١١٧١b.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) dVar);
        byte[] bytes = str.getBytes(j0.f١١١٦٢b);
        try {
            T0(bytes.length);
            b(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e10) {
            throw new d(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f0() {
        return this.f١١١٧٣a;
    }

    public abstract int j0();

    public abstract void k0(byte b10);

    public abstract void l0(int i10, boolean z10);

    public final void m0(boolean z10) {
        k0(z10 ? (byte) 1 : (byte) 0);
    }

    public final void n0(byte[] bArr) {
        o0(bArr, 0, bArr.length);
    }

    abstract void o0(byte[] bArr, int i10, int i11);

    public abstract void p0(int i10, h hVar);

    public abstract void q0(h hVar);

    public final void r0(int i10, double d10) {
        x0(i10, Double.doubleToRawLongBits(d10));
    }

    public final void s0(double d10) {
        y0(Double.doubleToRawLongBits(d10));
    }

    public final void t0(int i10, int i11) {
        D0(i10, i11);
    }

    public final void u0(int i10) {
        E0(i10);
    }

    public abstract void v0(int i10, int i11);

    public abstract void w0(int i10);

    public abstract void x0(int i10, long j10);

    public abstract void y0(long j10);

    public final void z0(int i10, float f10) {
        v0(i10, Float.floatToRawIntBits(f10));
    }

    private k() {
    }
}
