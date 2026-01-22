package z;

import java.io.IOException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class b extends IOException {
    public b(int i10, long j10) {
        super("Response code can't handled on internal " + i10 + " with current offset " + j10);
    }
}
