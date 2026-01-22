package com.google.protobuf;

import com.google.protobuf.e1;
import com.google.protobuf.h;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class b implements e1 {
    protected int memoizedHashCode = 0;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static abstract class a implements e1.a {
        private static void a(Iterable iterable, List list) {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size = list.size();
            for (Object obj : iterable) {
                if (obj == null) {
                    String str = "Element at index " + (list.size() - size) + " is null.";
                    for (int size2 = list.size() - 1; size2 >= size; size2--) {
                        list.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                list.add(obj);
            }
        }

        @Deprecated
        protected static <T> void addAll(Iterable<T> iterable, Collection<? super T> collection) {
            addAll((Iterable) iterable, (List) collection);
        }

        private String b(String str) {
            return "Reading " + getClass().getName() + " from a " + str + " threw an IOException (should never happen).";
        }

        protected static i2 newUninitializedMessageException(e1 e1Var) {
            return new i2(e1Var);
        }

        protected abstract a internalMergeFrom(b bVar);

        public boolean mergeDelimitedFrom(InputStream inputStream, v vVar) throws IOException {
            int read = inputStream.read();
            if (read == -1) {
                return false;
            }
            m٤٥٤mergeFrom(new C٠١٣٣a(inputStream, i.D(read, inputStream)), vVar);
            return true;
        }

        /* renamed from: mergeFrom */
        public abstract a m٤٥٢mergeFrom(i iVar);

        @Override // com.google.protobuf.e1.a
        public abstract a mergeFrom(i iVar, v vVar);

        protected static <T> void addAll(Iterable<T> iterable, List<? super T> list) {
            j0.a(iterable);
            if (iterable instanceof p0) {
                List underlyingElements = ((p0) iterable).getUnderlyingElements();
                p0 p0Var = (p0) list;
                int size = list.size();
                for (Object obj : underlyingElements) {
                    if (obj == null) {
                        String str = "Element at index " + (p0Var.size() - size) + " is null.";
                        for (int size2 = p0Var.size() - 1; size2 >= size; size2--) {
                            p0Var.remove(size2);
                        }
                        throw new NullPointerException(str);
                    }
                    if (obj instanceof h) {
                        p0Var.j((h) obj);
                    } else {
                        p0Var.add((String) obj);
                    }
                }
                return;
            }
            if (iterable instanceof s1) {
                list.addAll((Collection) iterable);
            } else {
                a(iterable, list);
            }
        }

        /* renamed from: mergeFrom */
        public a m٤٥٠mergeFrom(h hVar) {
            try {
                i u10 = hVar.u();
                m٤٥٢mergeFrom(u10);
                u10.a(0);
                return this;
            } catch (k0 e10) {
                throw e10;
            } catch (IOException e11) {
                throw new RuntimeException(b("ByteString"), e11);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.google.protobuf.b$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static final class C٠١٣٣a extends FilterInputStream {

            /* renamed from: a, reason: collision with root package name */
            private int f١٠٨٨٣a;

            /* JADX INFO: Access modifiers changed from: package-private */
            public C٠١٣٣a(InputStream inputStream, int i10) {
                super(inputStream);
                this.f١٠٨٨٣a = i10;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() {
                return Math.min(super.available(), this.f١٠٨٨٣a);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() {
                if (this.f١٠٨٨٣a <= 0) {
                    return -1;
                }
                int read = super.read();
                if (read >= 0) {
                    this.f١٠٨٨٣a--;
                }
                return read;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long j10) {
                int skip = (int) super.skip(Math.min(j10, this.f١٠٨٨٣a));
                if (skip >= 0) {
                    this.f١٠٨٨٣a -= skip;
                }
                return skip;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i10, int i11) {
                int i12 = this.f١٠٨٨٣a;
                if (i12 <= 0) {
                    return -1;
                }
                int read = super.read(bArr, i10, Math.min(i11, i12));
                if (read >= 0) {
                    this.f١٠٨٨٣a -= read;
                }
                return read;
            }
        }

        public boolean mergeDelimitedFrom(InputStream inputStream) throws IOException {
            return mergeDelimitedFrom(inputStream, v.b());
        }

        /* renamed from: mergeFrom */
        public a m٤٥١mergeFrom(h hVar, v vVar) {
            try {
                i u10 = hVar.u();
                mergeFrom(u10, vVar);
                u10.a(0);
                return this;
            } catch (k0 e10) {
                throw e10;
            } catch (IOException e11) {
                throw new RuntimeException(b("ByteString"), e11);
            }
        }

        @Override // com.google.protobuf.e1.a
        public a mergeFrom(byte[] bArr) {
            return m٤٥٥mergeFrom(bArr, 0, bArr.length);
        }

        /* renamed from: mergeFrom */
        public a m٤٥٥mergeFrom(byte[] bArr, int i10, int i11) {
            try {
                i m10 = i.m(bArr, i10, i11);
                m٤٥٢mergeFrom(m10);
                m10.a(0);
                return this;
            } catch (k0 e10) {
                throw e10;
            } catch (IOException e11) {
                throw new RuntimeException(b("byte array"), e11);
            }
        }

        /* renamed from: mergeFrom */
        public a m٤٥٧mergeFrom(byte[] bArr, v vVar) {
            return m٤٥٦mergeFrom(bArr, 0, bArr.length, vVar);
        }

        /* renamed from: mergeFrom */
        public a m٤٥٦mergeFrom(byte[] bArr, int i10, int i11, v vVar) {
            try {
                i m10 = i.m(bArr, i10, i11);
                mergeFrom(m10, vVar);
                m10.a(0);
                return this;
            } catch (k0 e10) {
                throw e10;
            } catch (IOException e11) {
                throw new RuntimeException(b("byte array"), e11);
            }
        }

        /* renamed from: mergeFrom */
        public a m٤٥٣mergeFrom(InputStream inputStream) {
            i h10 = i.h(inputStream);
            m٤٥٢mergeFrom(h10);
            h10.a(0);
            return this;
        }

        /* renamed from: mergeFrom */
        public a m٤٥٤mergeFrom(InputStream inputStream, v vVar) {
            i h10 = i.h(inputStream);
            mergeFrom(h10, vVar);
            h10.a(0);
            return this;
        }

        /* renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public a m٤٥٨mergeFrom(e1 e1Var) {
            if (getDefaultInstanceForType().getClass().isInstance(e1Var)) {
                return internalMergeFrom((b) e1Var);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
    }

    private String a(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    @Deprecated
    protected static <T> void addAll(Iterable<T> iterable, Collection<? super T> collection) {
        a.addAll((Iterable) iterable, (List) collection);
    }

    protected static void checkByteStringIsUtf8(h hVar) throws IllegalArgumentException {
        if (hVar.r()) {
        } else {
            throw new IllegalArgumentException("Byte string is not UTF-8.");
        }
    }

    abstract int getMemoizedSerializedSize();

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSerializedSize(y1 y1Var) {
        int memoizedSerializedSize = getMemoizedSerializedSize();
        if (memoizedSerializedSize == -1) {
            int c10 = y1Var.c(this);
            setMemoizedSerializedSize(c10);
            return c10;
        }
        return memoizedSerializedSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract i2 newUninitializedMessageException();

    abstract void setMemoizedSerializedSize(int i10);

    @Override // com.google.protobuf.e1
    public byte[] toByteArray() {
        try {
            byte[] bArr = new byte[getSerializedSize()];
            k h02 = k.h0(bArr);
            writeTo(h02);
            h02.d();
            return bArr;
        } catch (IOException e10) {
            throw new RuntimeException(a("byte array"), e10);
        }
    }

    public h toByteString() {
        try {
            h.C٠١٣٥h t10 = h.t(getSerializedSize());
            writeTo(t10.b());
            return t10.a();
        } catch (IOException e10) {
            throw new RuntimeException(a("ByteString"), e10);
        }
    }

    public void writeDelimitedTo(OutputStream outputStream) throws IOException {
        int serializedSize = getSerializedSize();
        k g02 = k.g0(outputStream, k.K(k.Y(serializedSize) + serializedSize));
        g02.T0(serializedSize);
        writeTo(g02);
        g02.d0();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        k g02 = k.g0(outputStream, k.K(getSerializedSize()));
        writeTo(g02);
        g02.d0();
    }

    protected static <T> void addAll(Iterable<T> iterable, List<? super T> list) {
        a.addAll((Iterable) iterable, (List) list);
    }
}
