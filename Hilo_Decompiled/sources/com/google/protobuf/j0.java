package com.google.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class j0 {

    /* renamed from: a, reason: collision with root package name */
    static final Charset f١١١٦١a = Charset.forName("US-ASCII");

    /* renamed from: b, reason: collision with root package name */
    static final Charset f١١١٦٢b = Charset.forName("UTF-8");

    /* renamed from: c, reason: collision with root package name */
    static final Charset f١١١٦٣c = Charset.forName("ISO-8859-1");

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f١١١٦٤d;

    /* renamed from: e, reason: collision with root package name */
    public static final ByteBuffer f١١١٦٥e;

    /* renamed from: f, reason: collision with root package name */
    public static final com.google.protobuf.i f١١١٦٦f;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface a extends i {
        @Override // com.google.protobuf.j0.i, com.google.protobuf.j0.f
        a a(int i10);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface b extends i {
        @Override // com.google.protobuf.j0.i, com.google.protobuf.j0.f
        b a(int i10);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface c {
        int getNumber();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface d {
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface e {
        boolean a(int i10);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface f extends i {
        f a(int i10);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface g extends i {
        void E(int i10);

        @Override // com.google.protobuf.j0.i, com.google.protobuf.j0.f
        g a(int i10);

        int getInt(int i10);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface h extends i {
        void I(long j10);

        long O(int i10, long j10);

        @Override // com.google.protobuf.j0.i, com.google.protobuf.j0.f
        h a(int i10);

        long getLong(int i10);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface i extends List, RandomAccess {
        i a(int i10);

        void b();

        boolean c();
    }

    static {
        byte[] bArr = new byte[0];
        f١١١٦٤d = bArr;
        f١١١٦٥e = ByteBuffer.wrap(bArr);
        f١١١٦٦f = com.google.protobuf.i.l(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object a(Object obj) {
        obj.getClass();
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object b(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public static int c(boolean z10) {
        return z10 ? 1231 : 1237;
    }

    public static int d(byte[] bArr) {
        return e(bArr, 0, bArr.length);
    }

    static int e(byte[] bArr, int i10, int i11) {
        int j10 = j(i11, bArr, i10, i11);
        if (j10 == 0) {
            return 1;
        }
        return j10;
    }

    public static int f(c cVar) {
        return cVar.getNumber();
    }

    public static int g(List list) {
        Iterator it = list.iterator();
        int i10 = 1;
        while (it.hasNext()) {
            i10 = (i10 * 31) + f((c) it.next());
        }
        return i10;
    }

    public static int h(long j10) {
        return (int) (j10 ^ (j10 >>> 32));
    }

    public static boolean i(byte[] bArr) {
        return q2.s(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(int i10, byte[] bArr, int i11, int i12) {
        for (int i13 = i11; i13 < i11 + i12; i13++) {
            i10 = (i10 * 31) + bArr[i13];
        }
        return i10;
    }

    public static String k(byte[] bArr) {
        return new String(bArr, f١١١٦٢b);
    }
}
