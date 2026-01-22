package org.android.spdy;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class SpdyErrorException extends RuntimeException {
    private static final long serialVersionUID = 4422888579699220045L;
    private int error;

    public SpdyErrorException(int i) {
        this.error = i;
    }

    public int SpdyErrorGetCode() {
        return this.error;
    }

    public SpdyErrorException(String str, int i) {
        super(str);
        this.error = i;
    }

    public SpdyErrorException(String str, Throwable th, int i) {
        super(str, th);
        this.error = i;
    }

    public SpdyErrorException(Throwable th, int i) {
        super(th);
        this.error = i;
    }
}
