package com.tencent.qcloud.tuicore.interfaces;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class TUILoginConfig {
    public static final int TUI_LOG_DEBUG = 3;
    public static final int TUI_LOG_ERROR = 6;
    public static final int TUI_LOG_INFO = 4;
    public static final int TUI_LOG_NONE = 0;
    public static final int TUI_LOG_WARN = 5;
    private int logLevel = 4;
    private TUILogListener tuiLogListener;

    public int getLogLevel() {
        return this.logLevel;
    }

    public TUILogListener getLogListener() {
        return this.tuiLogListener;
    }

    public void setLogLevel(int i) {
        this.logLevel = i;
    }

    public void setLogListener(TUILogListener tUILogListener) {
        this.tuiLogListener = tUILogListener;
    }
}
