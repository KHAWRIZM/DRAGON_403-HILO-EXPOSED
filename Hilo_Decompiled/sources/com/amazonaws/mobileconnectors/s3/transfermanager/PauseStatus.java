package com.amazonaws.mobileconnectors.s3.transfermanager;

@Deprecated
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public enum PauseStatus {
    SUCCESS,
    NOT_STARTED,
    CANCELLED_BEFORE_START,
    NO_EFFECT,
    CANCELLED;

    public boolean isCancelled() {
        if (this != CANCELLED && this != CANCELLED_BEFORE_START) {
            return false;
        }
        return true;
    }

    public boolean isPaused() {
        if (this == SUCCESS) {
            return true;
        }
        return false;
    }

    public boolean unchanged() {
        if (this != NOT_STARTED && this != NO_EFFECT) {
            return false;
        }
        return true;
    }
}
