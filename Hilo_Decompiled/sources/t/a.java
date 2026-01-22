package t;

import com.amazonaws.services.s3.internal.Constants;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ String a(int i10) {
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 4) {
                        return Constants.NULL_VERSION_ID;
                    }
                    return "HANG_UP";
                }
                return "PAUSE";
            }
            return "NORMAL";
        }
        return "UNDEFINED";
    }
}
