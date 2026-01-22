package y;

import java.io.InputStream;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class a extends InputStream {
    private long bytesRead = 0;

    public void count(int i10) {
        count(i10);
    }

    public long getBytesRead() {
        return this.bytesRead;
    }

    @Deprecated
    public int getCount() {
        return (int) this.bytesRead;
    }

    public long getUncompressedCount() {
        return getBytesRead();
    }

    public void pushedBackBytes(long j10) {
        this.bytesRead -= j10;
    }

    public void count(long j10) {
        if (j10 != -1) {
            this.bytesRead += j10;
        }
    }
}
