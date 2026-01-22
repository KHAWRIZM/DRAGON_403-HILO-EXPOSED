package tech.sud.gip.core;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public interface ISudLogger {
    void log(int i, String str, String str2);

    void log(int i, String str, String str2, Throwable th);

    void setLogLevel(int i);
}
