package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import kotlin.UByte;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class f implements Iterable, Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final f f٣٢٨٥b = new i(u.f٣٥١١d);

    /* renamed from: c, reason: collision with root package name */
    private static final InterfaceC٠٠٣٥f f٣٢٨٦c;

    /* renamed from: d, reason: collision with root package name */
    private static final Comparator f٣٢٨٧d;
    private static final long serialVersionUID = 1;

    /* renamed from: a, reason: collision with root package name */
    private int f٣٢٨٨a = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class a extends c {

        /* renamed from: a, reason: collision with root package name */
        private int f٣٢٨٩a = 0;

        /* renamed from: b, reason: collision with root package name */
        private final int f٣٢٩٠b;

        a() {
            this.f٣٢٩٠b = f.this.size();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f٣٢٨٩a < this.f٣٢٩٠b) {
                return true;
            }
            return false;
        }

        @Override // androidx.datastore.preferences.protobuf.f.g
        public byte nextByte() {
            int i10 = this.f٣٢٨٩a;
            if (i10 < this.f٣٢٩٠b) {
                this.f٣٢٨٩a = i10 + 1;
                return f.this.n(i10);
            }
            throw new NoSuchElementException();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class b implements Comparator {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(f fVar, f fVar2) {
            g o10 = fVar.o();
            g o11 = fVar2.o();
            while (o10.hasNext() && o11.hasNext()) {
                int compareTo = Integer.valueOf(f.t(o10.nextByte())).compareTo(Integer.valueOf(f.t(o11.nextByte())));
                if (compareTo != 0) {
                    return compareTo;
                }
            }
            return Integer.valueOf(fVar.size()).compareTo(Integer.valueOf(fVar2.size()));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
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

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static final class d implements InterfaceC٠٠٣٥f {
        private d() {
        }

        @Override // androidx.datastore.preferences.protobuf.f.InterfaceC٠٠٣٥f
        public byte[] a(byte[] bArr, int i10, int i11) {
            return Arrays.copyOfRange(bArr, i10, i11 + i10);
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class e extends i {
        private static final long serialVersionUID = 1;

        /* renamed from: f, reason: collision with root package name */
        private final int f٣٢٩٢f;

        /* renamed from: g, reason: collision with root package name */
        private final int f٣٢٩٣g;

        e(byte[] bArr, int i10, int i11) {
            super(bArr);
            f.h(i10, i10 + i11, bArr.length);
            this.f٣٢٩٢f = i10;
            this.f٣٢٩٣g = i11;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }

        @Override // androidx.datastore.preferences.protobuf.f.i, androidx.datastore.preferences.protobuf.f
        public byte e(int i10) {
            f.f(i10, size());
            return this.f٣٢٩٤e[this.f٣٢٩٢f + i10];
        }

        @Override // androidx.datastore.preferences.protobuf.f.i, androidx.datastore.preferences.protobuf.f
        protected void m(byte[] bArr, int i10, int i11, int i12) {
            System.arraycopy(this.f٣٢٩٤e, z() + i10, bArr, i11, i12);
        }

        @Override // androidx.datastore.preferences.protobuf.f.i, androidx.datastore.preferences.protobuf.f
        byte n(int i10) {
            return this.f٣٢٩٤e[this.f٣٢٩٢f + i10];
        }

        @Override // androidx.datastore.preferences.protobuf.f.i, androidx.datastore.preferences.protobuf.f
        public int size() {
            return this.f٣٢٩٣g;
        }

        Object writeReplace() {
            return f.v(s());
        }

        @Override // androidx.datastore.preferences.protobuf.f.i
        protected int z() {
            return this.f٣٢٩٢f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.datastore.preferences.protobuf.f$f, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface InterfaceC٠٠٣٥f {
        byte[] a(byte[] bArr, int i10, int i11);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface g extends Iterator {
        byte nextByte();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static abstract class h extends f {
        private static final long serialVersionUID = 1;

        /* synthetic */ h(a aVar) {
            this();
        }

        @Override // java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.o();
        }

        private h() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class i extends h {
        private static final long serialVersionUID = 1;

        /* renamed from: e, reason: collision with root package name */
        protected final byte[] f٣٢٩٤e;

        i(byte[] bArr) {
            super(null);
            bArr.getClass();
            this.f٣٢٩٤e = bArr;
        }

        @Override // androidx.datastore.preferences.protobuf.f
        public byte e(int i10) {
            return this.f٣٢٩٤e[i10];
        }

        @Override // androidx.datastore.preferences.protobuf.f
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof f) || size() != ((f) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (obj instanceof i) {
                i iVar = (i) obj;
                int q10 = q();
                int q11 = iVar.q();
                if (q10 != 0 && q11 != 0 && q10 != q11) {
                    return false;
                }
                return y(iVar, 0, size());
            }
            return obj.equals(this);
        }

        @Override // androidx.datastore.preferences.protobuf.f
        protected void m(byte[] bArr, int i10, int i11, int i12) {
            System.arraycopy(this.f٣٢٩٤e, i10, bArr, i11, i12);
        }

        @Override // androidx.datastore.preferences.protobuf.f
        byte n(int i10) {
            return this.f٣٢٩٤e[i10];
        }

        @Override // androidx.datastore.preferences.protobuf.f
        protected final int p(int i10, int i11, int i12) {
            return u.g(i10, this.f٣٢٩٤e, z() + i11, i12);
        }

        @Override // androidx.datastore.preferences.protobuf.f
        public final f r(int i10, int i11) {
            int h10 = f.h(i10, i11, size());
            if (h10 == 0) {
                return f.f٣٢٨٥b;
            }
            return new e(this.f٣٢٩٤e, z() + i10, h10);
        }

        @Override // androidx.datastore.preferences.protobuf.f
        public int size() {
            return this.f٣٢٩٤e.length;
        }

        @Override // androidx.datastore.preferences.protobuf.f
        final void x(androidx.datastore.preferences.protobuf.e eVar) {
            eVar.a(this.f٣٢٩٤e, z(), size());
        }

        final boolean y(f fVar, int i10, int i11) {
            if (i11 <= fVar.size()) {
                int i12 = i10 + i11;
                if (i12 <= fVar.size()) {
                    if (fVar instanceof i) {
                        i iVar = (i) fVar;
                        byte[] bArr = this.f٣٢٩٤e;
                        byte[] bArr2 = iVar.f٣٢٩٤e;
                        int z10 = z() + i11;
                        int z11 = z();
                        int z12 = iVar.z() + i10;
                        while (z11 < z10) {
                            if (bArr[z11] != bArr2[z12]) {
                                return false;
                            }
                            z11++;
                            z12++;
                        }
                        return true;
                    }
                    return fVar.r(i10, i12).equals(r(0, i11));
                }
                throw new IllegalArgumentException("Ran off end of other: " + i10 + ", " + i11 + ", " + fVar.size());
            }
            throw new IllegalArgumentException("Length too large: " + i11 + size());
        }

        protected int z() {
            return 0;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static final class j implements InterfaceC٠٠٣٥f {
        private j() {
        }

        @Override // androidx.datastore.preferences.protobuf.f.InterfaceC٠٠٣٥f
        public byte[] a(byte[] bArr, int i10, int i11) {
            byte[] bArr2 = new byte[i11];
            System.arraycopy(bArr, i10, bArr2, 0, i11);
            return bArr2;
        }

        /* synthetic */ j(a aVar) {
            this();
        }
    }

    static {
        InterfaceC٠٠٣٥f dVar;
        a aVar = null;
        if (androidx.datastore.preferences.protobuf.d.c()) {
            dVar = new j(aVar);
        } else {
            dVar = new d(aVar);
        }
        f٣٢٨٦c = dVar;
        f٣٢٨٧d = new b();
    }

    f() {
    }

    static void f(int i10, int i11) {
        if (((i11 - (i10 + 1)) | i10) < 0) {
            if (i10 < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i10);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i10 + ", " + i11);
        }
    }

    static int h(int i10, int i11, int i12) {
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

    public static f i(byte[] bArr) {
        return k(bArr, 0, bArr.length);
    }

    public static f k(byte[] bArr, int i10, int i11) {
        h(i10, i10 + i11, bArr.length);
        return new i(f٣٢٨٦c.a(bArr, i10, i11));
    }

    public static f l(String str) {
        return new i(str.getBytes(u.f٣٥٠٩b));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int t(byte b10) {
        return b10 & UByte.MAX_VALUE;
    }

    private String u() {
        if (size() <= 50) {
            return c1.a(this);
        }
        return c1.a(r(0, 47)) + "...";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f v(byte[] bArr) {
        return new i(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f w(byte[] bArr, int i10, int i11) {
        return new e(bArr, i10, i11);
    }

    public abstract byte e(int i10);

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i10 = this.f٣٢٨٨a;
        if (i10 == 0) {
            int size = size();
            i10 = p(size, 0, size);
            if (i10 == 0) {
                i10 = 1;
            }
            this.f٣٢٨٨a = i10;
        }
        return i10;
    }

    protected abstract void m(byte[] bArr, int i10, int i11, int i12);

    abstract byte n(int i10);

    public g o() {
        return new a();
    }

    protected abstract int p(int i10, int i11, int i12);

    protected final int q() {
        return this.f٣٢٨٨a;
    }

    public abstract f r(int i10, int i11);

    public final byte[] s() {
        int size = size();
        if (size == 0) {
            return u.f٣٥١١d;
        }
        byte[] bArr = new byte[size];
        m(bArr, 0, 0, size);
        return bArr;
    }

    public abstract int size();

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()), u());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void x(androidx.datastore.preferences.protobuf.e eVar);
}
