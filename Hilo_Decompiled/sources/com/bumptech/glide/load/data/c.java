package com.bumptech.glide.load.data;

import java.io.OutputStream;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class c extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    private final OutputStream f٧٤٣٣a;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f٧٤٣٤b;

    /* renamed from: c, reason: collision with root package name */
    private p4.b f٧٤٣٥c;

    /* renamed from: d, reason: collision with root package name */
    private int f٧٤٣٦d;

    public c(OutputStream outputStream, p4.b bVar) {
        this(outputStream, bVar, 65536);
    }

    private void a() {
        int i10 = this.f٧٤٣٦d;
        if (i10 > 0) {
            this.f٧٤٣٣a.write(this.f٧٤٣٤b, 0, i10);
            this.f٧٤٣٦d = 0;
        }
    }

    private void b() {
        if (this.f٧٤٣٦d == this.f٧٤٣٤b.length) {
            a();
        }
    }

    private void release() {
        byte[] bArr = this.f٧٤٣٤b;
        if (bArr != null) {
            this.f٧٤٣٥c.put(bArr);
            this.f٧٤٣٤b = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            flush();
            this.f٧٤٣٣a.close();
            release();
        } catch (Throwable th) {
            this.f٧٤٣٣a.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        a();
        this.f٧٤٣٣a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i10) {
        byte[] bArr = this.f٧٤٣٤b;
        int i11 = this.f٧٤٣٦d;
        this.f٧٤٣٦d = i11 + 1;
        bArr[i11] = (byte) i10;
        b();
    }

    c(OutputStream outputStream, p4.b bVar, int i10) {
        this.f٧٤٣٣a = outputStream;
        this.f٧٤٣٥c = bVar;
        this.f٧٤٣٤b = (byte[]) bVar.c(i10, byte[].class);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) {
        int i12 = 0;
        do {
            int i13 = i11 - i12;
            int i14 = i10 + i12;
            int i15 = this.f٧٤٣٦d;
            if (i15 == 0 && i13 >= this.f٧٤٣٤b.length) {
                this.f٧٤٣٣a.write(bArr, i14, i13);
                return;
            }
            int min = Math.min(i13, this.f٧٤٣٤b.length - i15);
            System.arraycopy(bArr, i14, this.f٧٤٣٤b, this.f٧٤٣٦d, min);
            this.f٧٤٣٦d += min;
            i12 += min;
            b();
        } while (i12 < i11);
    }
}
