package anet.channel.util;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    private InputStream f٥٠٧٠a;

    /* renamed from: b, reason: collision with root package name */
    private long f٥٠٧١b = 0;

    public a(InputStream inputStream) {
        this.f٥٠٧٠a = null;
        if (inputStream != null) {
            this.f٥٠٧٠a = inputStream;
            return;
        }
        throw new NullPointerException("input stream cannot be null");
    }

    public long a() {
        return this.f٥٠٧١b;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        this.f٥٠٧١b++;
        return this.f٥٠٧٠a.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int read = this.f٥٠٧٠a.read(bArr, i10, i11);
        if (read != -1) {
            this.f٥٠٧١b += read;
        }
        return read;
    }
}
