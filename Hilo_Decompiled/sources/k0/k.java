package k0;

import java.io.InputStream;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class k extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    public final InputStream f١٥٤٠٥a;

    /* renamed from: b, reason: collision with root package name */
    public long f١٥٤٠٦b;

    public k(InputStream inputStream, long j10) {
        this.f١٥٤٠٥a = inputStream;
        this.f١٥٤٠٦b = j10;
    }

    @Override // java.io.InputStream
    public final int read() {
        long j10 = this.f١٥٤٠٦b;
        if (j10 <= 0) {
            return -1;
        }
        this.f١٥٤٠٦b = j10 - 1;
        return this.f١٥٤٠٥a.read();
    }

    @Override // java.io.InputStream
    public final long skip(long j10) {
        long skip = this.f١٥٤٠٥a.skip(Math.min(this.f١٥٤٠٦b, j10));
        this.f١٥٤٠٦b -= skip;
        return skip;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i10, int i11) {
        if (i11 == 0) {
            return 0;
        }
        long j10 = this.f١٥٤٠٦b;
        if (j10 == 0) {
            return -1;
        }
        if (i11 > j10) {
            i11 = (int) j10;
        }
        int read = this.f١٥٤٠٥a.read(bArr, i10, i11);
        if (read >= 0) {
            this.f١٥٤٠٦b -= read;
        }
        return read;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
