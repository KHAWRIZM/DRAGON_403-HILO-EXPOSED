package com.google.protobuf;

import com.google.protobuf.h;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class p1 extends h.i {

    /* renamed from: e, reason: collision with root package name */
    private final ByteBuffer f١١٨٦٤e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p1(ByteBuffer byteBuffer) {
        j0.b(byteBuffer, "buffer");
        this.f١١٨٦٤e = byteBuffer.slice().order(ByteOrder.nativeOrder());
    }

    private ByteBuffer K(int i10, int i11) {
        if (i10 >= this.f١١٨٦٤e.position() && i11 <= this.f١١٨٦٤e.limit() && i10 <= i11) {
            ByteBuffer slice = this.f١١٨٦٤e.slice();
            slice.position(i10 - this.f١١٨٦٤e.position());
            slice.limit(i11 - this.f١١٨٦٤e.position());
            return slice;
        }
        throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", Integer.valueOf(i10), Integer.valueOf(i11)));
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("NioByteString instances are not to be serialized directly");
    }

    private Object writeReplace() {
        return h.k(this.f١١٨٦٤e.slice());
    }

    @Override // com.google.protobuf.h
    protected String B(Charset charset) {
        byte[] y10;
        int length;
        int i10;
        if (this.f١١٨٦٤e.hasArray()) {
            y10 = this.f١١٨٦٤e.array();
            i10 = this.f١١٨٦٤e.arrayOffset() + this.f١١٨٦٤e.position();
            length = this.f١١٨٦٤e.remaining();
        } else {
            y10 = y();
            length = y10.length;
            i10 = 0;
        }
        return new String(y10, i10, length, charset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.h
    public void J(g gVar) {
        gVar.a(this.f١١٨٦٤e.slice());
    }

    @Override // com.google.protobuf.h
    public ByteBuffer e() {
        return this.f١١٨٦٤e.asReadOnlyBuffer();
    }

    @Override // com.google.protobuf.h
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (size() != hVar.size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof p1) {
            return this.f١١٨٦٤e.equals(((p1) obj).f١١٨٦٤e);
        }
        return this.f١١٨٦٤e.equals(hVar.e());
    }

    @Override // com.google.protobuf.h
    public byte f(int i10) {
        try {
            return this.f١١٨٦٤e.get(i10);
        } catch (ArrayIndexOutOfBoundsException e10) {
            throw e10;
        } catch (IndexOutOfBoundsException e11) {
            throw new ArrayIndexOutOfBoundsException(e11.getMessage());
        }
    }

    @Override // com.google.protobuf.h
    protected void p(byte[] bArr, int i10, int i11, int i12) {
        ByteBuffer slice = this.f١١٨٦٤e.slice();
        slice.position(i10);
        slice.get(bArr, i11, i12);
    }

    @Override // com.google.protobuf.h
    public byte q(int i10) {
        return f(i10);
    }

    @Override // com.google.protobuf.h
    public boolean r() {
        return q2.r(this.f١١٨٦٤e);
    }

    @Override // com.google.protobuf.h
    public int size() {
        return this.f١١٨٦٤e.remaining();
    }

    @Override // com.google.protobuf.h
    public i u() {
        return i.k(this.f١١٨٦٤e, true);
    }

    @Override // com.google.protobuf.h
    protected int v(int i10, int i11, int i12) {
        for (int i13 = i11; i13 < i11 + i12; i13++) {
            i10 = (i10 * 31) + this.f١١٨٦٤e.get(i13);
        }
        return i10;
    }

    @Override // com.google.protobuf.h
    public h x(int i10, int i11) {
        try {
            return new p1(K(i10, i11));
        } catch (ArrayIndexOutOfBoundsException e10) {
            throw e10;
        } catch (IndexOutOfBoundsException e11) {
            throw new ArrayIndexOutOfBoundsException(e11.getMessage());
        }
    }
}
