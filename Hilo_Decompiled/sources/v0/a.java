package v0;

import com.amazonaws.services.s3.internal.Constants;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ String a(int i10) {
        switch (i10) {
            case 1:
                return "COMPLETED";
            case 2:
                return "ERROR";
            case 3:
                return "CANCELED";
            case 4:
                return "FILE_BUSY";
            case 5:
                return "SAME_TASK_BUSY";
            case 6:
                return "PRE_ALLOCATE_FAILED";
            default:
                return Constants.NULL_VERSION_ID;
        }
    }
}
