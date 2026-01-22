package v;

import java.io.IOException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class a extends IOException {
    public a(int i10, long j10) {
        super(j10 + " kb of memory would be needed; limit was " + i10 + " kb. If the file is not corrupt, consider increasing the memory limit.");
    }
}
