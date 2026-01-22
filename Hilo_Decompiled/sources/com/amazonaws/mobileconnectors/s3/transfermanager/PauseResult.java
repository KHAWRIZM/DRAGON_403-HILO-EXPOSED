package com.amazonaws.mobileconnectors.s3.transfermanager;

@Deprecated
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class PauseResult<T> {
    private final T infoToResume;
    private final PauseStatus pauseStatus;

    public PauseResult(PauseStatus pauseStatus, T t10) {
        if (pauseStatus != null) {
            this.pauseStatus = pauseStatus;
            this.infoToResume = t10;
            return;
        }
        throw new IllegalArgumentException();
    }

    public T getInfoToResume() {
        return this.infoToResume;
    }

    public PauseStatus getPauseStatus() {
        return this.pauseStatus;
    }

    public PauseResult(PauseStatus pauseStatus) {
        this(pauseStatus, null);
    }
}
