package com.google.protobuf;

import com.google.protobuf.b;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class c implements r1 {
    private static final v EMPTY_REGISTRY = v.b();

    private e1 a(e1 e1Var) {
        if (e1Var != null && !e1Var.isInitialized()) {
            throw b(e1Var).a().j(e1Var);
        }
        return e1Var;
    }

    private i2 b(e1 e1Var) {
        if (e1Var instanceof b) {
            return ((b) e1Var).newUninitializedMessageException();
        }
        return new i2(e1Var);
    }

    @Override // com.google.protobuf.r1
    public e1 parseDelimitedFrom(InputStream inputStream, v vVar) throws k0 {
        return a(m٤٦٢parsePartialDelimitedFrom(inputStream, vVar));
    }

    /* renamed from: parsePartialDelimitedFrom, reason: merged with bridge method [inline-methods] */
    public e1 m٤٦٢parsePartialDelimitedFrom(InputStream inputStream, v vVar) throws k0 {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            return m٤٦٧parsePartialFrom((InputStream) new b.a.C٠١٣٣a(inputStream, i.D(read, inputStream)), vVar);
        } catch (IOException e10) {
            throw new k0(e10);
        }
    }

    @Override // com.google.protobuf.r1
    public e1 parseDelimitedFrom(InputStream inputStream) throws k0 {
        return parseDelimitedFrom(inputStream, EMPTY_REGISTRY);
    }

    /* renamed from: parsePartialDelimitedFrom, reason: merged with bridge method [inline-methods] */
    public e1 m٤٦١parsePartialDelimitedFrom(InputStream inputStream) throws k0 {
        return m٤٦٢parsePartialDelimitedFrom(inputStream, EMPTY_REGISTRY);
    }

    /* renamed from: parsePartialFrom, reason: merged with bridge method [inline-methods] */
    public e1 m٤٦٥parsePartialFrom(i iVar) throws k0 {
        return (e1) parsePartialFrom(iVar, EMPTY_REGISTRY);
    }

    /* renamed from: parsePartialFrom, reason: merged with bridge method [inline-methods] */
    public e1 m٤٦٤parsePartialFrom(h hVar, v vVar) throws k0 {
        i u10 = hVar.u();
        e1 e1Var = (e1) parsePartialFrom(u10, vVar);
        try {
            u10.a(0);
            return e1Var;
        } catch (k0 e10) {
            throw e10.j(e1Var);
        }
    }

    @Override // com.google.protobuf.r1
    public e1 parseFrom(i iVar, v vVar) throws k0 {
        return a((e1) parsePartialFrom(iVar, vVar));
    }

    @Override // com.google.protobuf.r1
    public e1 parseFrom(i iVar) throws k0 {
        return parseFrom(iVar, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.r1
    public e1 parseFrom(h hVar, v vVar) throws k0 {
        return a(m٤٦٤parsePartialFrom(hVar, vVar));
    }

    /* renamed from: parsePartialFrom, reason: merged with bridge method [inline-methods] */
    public e1 m٤٦٣parsePartialFrom(h hVar) throws k0 {
        return m٤٦٤parsePartialFrom(hVar, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.r1
    public e1 parseFrom(h hVar) throws k0 {
        return parseFrom(hVar, EMPTY_REGISTRY);
    }

    /* renamed from: parsePartialFrom, reason: merged with bridge method [inline-methods] */
    public e1 m٤٧٠parsePartialFrom(byte[] bArr, int i10, int i11, v vVar) throws k0 {
        i m10 = i.m(bArr, i10, i11);
        e1 e1Var = (e1) parsePartialFrom(m10, vVar);
        try {
            m10.a(0);
            return e1Var;
        } catch (k0 e10) {
            throw e10.j(e1Var);
        }
    }

    @Override // com.google.protobuf.r1
    public e1 parseFrom(ByteBuffer byteBuffer, v vVar) throws k0 {
        i j10 = i.j(byteBuffer);
        e1 e1Var = (e1) parsePartialFrom(j10, vVar);
        try {
            j10.a(0);
            return a(e1Var);
        } catch (k0 e10) {
            throw e10.j(e1Var);
        }
    }

    /* renamed from: parsePartialFrom, reason: merged with bridge method [inline-methods] */
    public e1 m٤٦٩parsePartialFrom(byte[] bArr, int i10, int i11) throws k0 {
        return m٤٧٠parsePartialFrom(bArr, i10, i11, EMPTY_REGISTRY);
    }

    /* renamed from: parsePartialFrom, reason: merged with bridge method [inline-methods] */
    public e1 m٤٧١parsePartialFrom(byte[] bArr, v vVar) throws k0 {
        return m٤٧٠parsePartialFrom(bArr, 0, bArr.length, vVar);
    }

    @Override // com.google.protobuf.r1
    public e1 parseFrom(ByteBuffer byteBuffer) throws k0 {
        return parseFrom(byteBuffer, EMPTY_REGISTRY);
    }

    /* renamed from: parsePartialFrom, reason: merged with bridge method [inline-methods] */
    public e1 m٤٦٨parsePartialFrom(byte[] bArr) throws k0 {
        return m٤٧٠parsePartialFrom(bArr, 0, bArr.length, EMPTY_REGISTRY);
    }

    /* renamed from: parseFrom, reason: merged with bridge method [inline-methods] */
    public e1 m٤٦٠parseFrom(byte[] bArr, int i10, int i11, v vVar) throws k0 {
        return a(m٤٧٠parsePartialFrom(bArr, i10, i11, vVar));
    }

    /* renamed from: parsePartialFrom, reason: merged with bridge method [inline-methods] */
    public e1 m٤٦٧parsePartialFrom(InputStream inputStream, v vVar) throws k0 {
        i h10 = i.h(inputStream);
        e1 e1Var = (e1) parsePartialFrom(h10, vVar);
        try {
            h10.a(0);
            return e1Var;
        } catch (k0 e10) {
            throw e10.j(e1Var);
        }
    }

    /* renamed from: parseFrom, reason: merged with bridge method [inline-methods] */
    public e1 m٤٥٩parseFrom(byte[] bArr, int i10, int i11) throws k0 {
        return m٤٦٠parseFrom(bArr, i10, i11, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.r1
    public e1 parseFrom(byte[] bArr, v vVar) throws k0 {
        return m٤٦٠parseFrom(bArr, 0, bArr.length, vVar);
    }

    @Override // com.google.protobuf.r1
    public e1 parseFrom(byte[] bArr) throws k0 {
        return parseFrom(bArr, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.r1
    public e1 parseFrom(InputStream inputStream, v vVar) throws k0 {
        return a(m٤٦٧parsePartialFrom(inputStream, vVar));
    }

    /* renamed from: parsePartialFrom, reason: merged with bridge method [inline-methods] */
    public e1 m٤٦٦parsePartialFrom(InputStream inputStream) throws k0 {
        return m٤٦٧parsePartialFrom(inputStream, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.r1
    public e1 parseFrom(InputStream inputStream) throws k0 {
        return parseFrom(inputStream, EMPTY_REGISTRY);
    }
}
