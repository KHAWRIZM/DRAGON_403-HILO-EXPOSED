package com.google.protobuf;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import kotlin.UByte;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class h implements Iterable, Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final h f١١٠١١b = new j(j0.f١١١٦٤d);

    /* renamed from: c, reason: collision with root package name */
    private static final f f١١٠١٢c;

    /* renamed from: d, reason: collision with root package name */
    private static final Comparator f١١٠١٣d;

    /* renamed from: a, reason: collision with root package name */
    private int f١١٠١٤a = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a extends c {

        /* renamed from: a, reason: collision with root package name */
        private int f١١٠١٥a = 0;

        /* renamed from: b, reason: collision with root package name */
        private final int f١١٠١٦b;

        a() {
            this.f١١٠١٦b = h.this.size();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f١١٠١٥a < this.f١١٠١٦b) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.h.g
        public byte nextByte() {
            int i10 = this.f١١٠١٥a;
            if (i10 < this.f١١٠١٦b) {
                this.f١١٠١٥a = i10 + 1;
                return h.this.q(i10);
            }
            throw new NoSuchElementException();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class b implements Comparator {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(h hVar, h hVar2) {
            g s10 = hVar.s();
            g s11 = hVar2.s();
            while (s10.hasNext() && s11.hasNext()) {
                int compareTo = Integer.valueOf(h.z(s10.nextByte())).compareTo(Integer.valueOf(h.z(s11.nextByte())));
                if (compareTo != 0) {
                    return compareTo;
                }
            }
            return Integer.valueOf(hVar.size()).compareTo(Integer.valueOf(hVar2.size()));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static abstract class c implements g {
        c() {
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Byte next() {
            return Byte.valueOf(nextByte());
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class d implements f {
        private d() {
        }

        @Override // com.google.protobuf.h.f
        public byte[] a(byte[] bArr, int i10, int i11) {
            return Arrays.copyOfRange(bArr, i10, i11 + i10);
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class e extends j {
        private static final long serialVersionUID = 1;

        /* renamed from: f, reason: collision with root package name */
        private final int f١١٠١٨f;

        /* renamed from: g, reason: collision with root package name */
        private final int f١١٠١٩g;

        e(byte[] bArr, int i10, int i11) {
            super(bArr);
            h.i(i10, i10 + i11, bArr.length);
            this.f١١٠١٨f = i10;
            this.f١١٠١٩g = i11;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }

        @Override // com.google.protobuf.h.j
        protected int L() {
            return this.f١١٠١٨f;
        }

        @Override // com.google.protobuf.h.j, com.google.protobuf.h
        public byte f(int i10) {
            h.h(i10, size());
            return this.f١١٠٢٢e[this.f١١٠١٨f + i10];
        }

        @Override // com.google.protobuf.h.j, com.google.protobuf.h
        protected void p(byte[] bArr, int i10, int i11, int i12) {
            System.arraycopy(this.f١١٠٢٢e, L() + i10, bArr, i11, i12);
        }

        @Override // com.google.protobuf.h.j, com.google.protobuf.h
        byte q(int i10) {
            return this.f١١٠٢٢e[this.f١١٠١٨f + i10];
        }

        @Override // com.google.protobuf.h.j, com.google.protobuf.h
        public int size() {
            return this.f١١٠١٩g;
        }

        Object writeReplace() {
            return h.G(y());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface f {
        byte[] a(byte[] bArr, int i10, int i11);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface g extends Iterator {
        byte nextByte();
    }

    /* renamed from: com.google.protobuf.h$h, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static final class C٠١٣٥h {

        /* renamed from: a, reason: collision with root package name */
        private final com.google.protobuf.k f١١٠٢٠a;

        /* renamed from: b, reason: collision with root package name */
        private final byte[] f١١٠٢١b;

        /* synthetic */ C٠١٣٥h(int i10, a aVar) {
            this(i10);
        }

        public h a() {
            this.f١١٠٢٠a.d();
            return new j(this.f١١٠٢١b);
        }

        public com.google.protobuf.k b() {
            return this.f١١٠٢٠a;
        }

        private C٠١٣٥h(int i10) {
            byte[] bArr = new byte[i10];
            this.f١١٠٢١b = bArr;
            this.f١١٠٢٠a = com.google.protobuf.k.h0(bArr);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static abstract class i extends h {
        @Override // java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.s();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class j extends i {
        private static final long serialVersionUID = 1;

        /* renamed from: e, reason: collision with root package name */
        protected final byte[] f١١٠٢٢e;

        j(byte[] bArr) {
            bArr.getClass();
            this.f١١٠٢٢e = bArr;
        }

        @Override // com.google.protobuf.h
        protected final String B(Charset charset) {
            return new String(this.f١١٠٢٢e, L(), size(), charset);
        }

        @Override // com.google.protobuf.h
        final void J(com.google.protobuf.g gVar) {
            gVar.b(this.f١١٠٢٢e, L(), size());
        }

        final boolean K(h hVar, int i10, int i11) {
            if (i11 <= hVar.size()) {
                int i12 = i10 + i11;
                if (i12 <= hVar.size()) {
                    if (hVar instanceof j) {
                        j jVar = (j) hVar;
                        byte[] bArr = this.f١١٠٢٢e;
                        byte[] bArr2 = jVar.f١١٠٢٢e;
                        int L = L() + i11;
                        int L2 = L();
                        int L3 = jVar.L() + i10;
                        while (L2 < L) {
                            if (bArr[L2] != bArr2[L3]) {
                                return false;
                            }
                            L2++;
                            L3++;
                        }
                        return true;
                    }
                    return hVar.x(i10, i12).equals(x(0, i11));
                }
                throw new IllegalArgumentException("Ran off end of other: " + i10 + ", " + i11 + ", " + hVar.size());
            }
            throw new IllegalArgumentException("Length too large: " + i11 + size());
        }

        protected int L() {
            return 0;
        }

        @Override // com.google.protobuf.h
        public final ByteBuffer e() {
            return ByteBuffer.wrap(this.f١١٠٢٢e, L(), size()).asReadOnlyBuffer();
        }

        @Override // com.google.protobuf.h
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof h) || size() != ((h) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (obj instanceof j) {
                j jVar = (j) obj;
                int w10 = w();
                int w11 = jVar.w();
                if (w10 != 0 && w11 != 0 && w10 != w11) {
                    return false;
                }
                return K(jVar, 0, size());
            }
            return obj.equals(this);
        }

        @Override // com.google.protobuf.h
        public byte f(int i10) {
            return this.f١١٠٢٢e[i10];
        }

        @Override // com.google.protobuf.h
        protected void p(byte[] bArr, int i10, int i11, int i12) {
            System.arraycopy(this.f١١٠٢٢e, i10, bArr, i11, i12);
        }

        @Override // com.google.protobuf.h
        byte q(int i10) {
            return this.f١١٠٢٢e[i10];
        }

        @Override // com.google.protobuf.h
        public final boolean r() {
            int L = L();
            return q2.t(this.f١١٠٢٢e, L, size() + L);
        }

        @Override // com.google.protobuf.h
        public int size() {
            return this.f١١٠٢٢e.length;
        }

        @Override // com.google.protobuf.h
        public final com.google.protobuf.i u() {
            return com.google.protobuf.i.n(this.f١١٠٢٢e, L(), size(), true);
        }

        @Override // com.google.protobuf.h
        protected final int v(int i10, int i11, int i12) {
            return j0.j(i10, this.f١١٠٢٢e, L() + i11, i12);
        }

        @Override // com.google.protobuf.h
        public final h x(int i10, int i11) {
            int i12 = h.i(i10, i11, size());
            if (i12 == 0) {
                return h.f١١٠١١b;
            }
            return new e(this.f١١٠٢٢e, L() + i10, i12);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class k implements f {
        private k() {
        }

        @Override // com.google.protobuf.h.f
        public byte[] a(byte[] bArr, int i10, int i11) {
            byte[] bArr2 = new byte[i11];
            System.arraycopy(bArr, i10, bArr2, 0, i11);
            return bArr2;
        }

        /* synthetic */ k(a aVar) {
            this();
        }
    }

    static {
        f dVar;
        a aVar = null;
        if (com.google.protobuf.e.c()) {
            dVar = new k(aVar);
        } else {
            dVar = new d(aVar);
        }
        f١١٠١٢c = dVar;
        f١١٠١٣d = new b();
    }

    h() {
    }

    private String D() {
        if (size() <= 50) {
            return f2.a(this);
        }
        return f2.a(x(0, 47)) + "...";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h F(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return H(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
        }
        return new p1(byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h G(byte[] bArr) {
        return new j(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h H(byte[] bArr, int i10, int i11) {
        return new e(bArr, i10, i11);
    }

    static void h(int i10, int i11) {
        if (((i11 - (i10 + 1)) | i10) < 0) {
            if (i10 < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i10);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i10 + ", " + i11);
        }
    }

    static int i(int i10, int i11, int i12) {
        int i13 = i11 - i10;
        if ((i10 | i11 | i13 | (i12 - i11)) < 0) {
            if (i10 >= 0) {
                if (i11 < i10) {
                    throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i10 + ", " + i11);
                }
                throw new IndexOutOfBoundsException("End index: " + i11 + " >= " + i12);
            }
            throw new IndexOutOfBoundsException("Beginning index: " + i10 + " < 0");
        }
        return i13;
    }

    public static h k(ByteBuffer byteBuffer) {
        return l(byteBuffer, byteBuffer.remaining());
    }

    public static h l(ByteBuffer byteBuffer, int i10) {
        i(0, i10, byteBuffer.remaining());
        byte[] bArr = new byte[i10];
        byteBuffer.get(bArr);
        return new j(bArr);
    }

    public static h m(byte[] bArr) {
        return n(bArr, 0, bArr.length);
    }

    public static h n(byte[] bArr, int i10, int i11) {
        i(i10, i10 + i11, bArr.length);
        return new j(f١١٠١٢c.a(bArr, i10, i11));
    }

    public static h o(String str) {
        return new j(str.getBytes(j0.f١١١٦٢b));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static C٠١٣٥h t(int i10) {
        return new C٠١٣٥h(i10, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int z(byte b10) {
        return b10 & UByte.MAX_VALUE;
    }

    public final String A(Charset charset) {
        if (size() == 0) {
            return "";
        }
        return B(charset);
    }

    protected abstract String B(Charset charset);

    public final String C() {
        return A(j0.f١١١٦٢b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void J(com.google.protobuf.g gVar);

    public abstract ByteBuffer e();

    public abstract boolean equals(Object obj);

    public abstract byte f(int i10);

    public final int hashCode() {
        int i10 = this.f١١٠١٤a;
        if (i10 == 0) {
            int size = size();
            i10 = v(size, 0, size);
            if (i10 == 0) {
                i10 = 1;
            }
            this.f١١٠١٤a = i10;
        }
        return i10;
    }

    public final boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    protected abstract void p(byte[] bArr, int i10, int i11, int i12);

    abstract byte q(int i10);

    public abstract boolean r();

    public g s() {
        return new a();
    }

    public abstract int size();

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()), D());
    }

    public abstract com.google.protobuf.i u();

    protected abstract int v(int i10, int i11, int i12);

    protected final int w() {
        return this.f١١٠١٤a;
    }

    public abstract h x(int i10, int i11);

    public final byte[] y() {
        int size = size();
        if (size == 0) {
            return j0.f١١١٦٤d;
        }
        byte[] bArr = new byte[size];
        p(bArr, 0, 0, size);
        return bArr;
    }
}
