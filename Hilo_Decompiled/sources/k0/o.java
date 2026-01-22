package k0;

import java.io.FilterInputStream;
import java.io.InputStream;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class o extends FilterInputStream {
    private long bytesRead;

    public o(InputStream inputStream) {
        super(inputStream);
    }

    public final void count(long j10) {
        if (j10 != -1) {
            this.bytesRead += j10;
        }
    }

    public long getBytesRead() {
        return this.bytesRead;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int read = ((FilterInputStream) this).in.read();
        if (read >= 0) {
            count(1L);
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) {
        if (i11 == 0) {
            return 0;
        }
        int read = ((FilterInputStream) this).in.read(bArr, i10, i11);
        if (read >= 0) {
            count(read);
        }
        return read;
    }
}
