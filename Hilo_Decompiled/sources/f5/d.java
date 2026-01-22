package f5;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class d extends InputStream {

    /* renamed from: c, reason: collision with root package name */
    private static final Queue f١٤٠٦١c = l.g(0);

    /* renamed from: a, reason: collision with root package name */
    private InputStream f١٤٠٦٢a;

    /* renamed from: b, reason: collision with root package name */
    private IOException f١٤٠٦٣b;

    d() {
    }

    public static d b(InputStream inputStream) {
        d dVar;
        Queue queue = f١٤٠٦١c;
        synchronized (queue) {
            dVar = (d) queue.poll();
        }
        if (dVar == null) {
            dVar = new d();
        }
        dVar.c(inputStream);
        return dVar;
    }

    public IOException a() {
        return this.f١٤٠٦٣b;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f١٤٠٦٢a.available();
    }

    void c(InputStream inputStream) {
        this.f١٤٠٦٢a = inputStream;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f١٤٠٦٢a.close();
    }

    @Override // java.io.InputStream
    public void mark(int i10) {
        this.f١٤٠٦٢a.mark(i10);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f١٤٠٦٢a.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.f١٤٠٦٢a.read();
        } catch (IOException e10) {
            this.f١٤٠٦٣b = e10;
            throw e10;
        }
    }

    public void release() {
        this.f١٤٠٦٣b = null;
        this.f١٤٠٦٢a = null;
        Queue queue = f١٤٠٦١c;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.f١٤٠٦٢a.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j10) {
        try {
            return this.f١٤٠٦٢a.skip(j10);
        } catch (IOException e10) {
            this.f١٤٠٦٣b = e10;
            throw e10;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.f١٤٠٦٢a.read(bArr);
        } catch (IOException e10) {
            this.f١٤٠٦٣b = e10;
            throw e10;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) {
        try {
            return this.f١٤٠٦٢a.read(bArr, i10, i11);
        } catch (IOException e10) {
            this.f١٤٠٦٣b = e10;
            throw e10;
        }
    }
}
