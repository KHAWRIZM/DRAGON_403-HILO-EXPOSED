package org.android.spdy;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public enum SpdyVersion {
    SPDY2(2),
    SPDY3(3),
    SPDY3DOT1(4);

    private int version;

    SpdyVersion(int i) {
        this.version = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getInt() {
        return this.version;
    }
}
