package v0;

import com.amazonaws.services.s3.internal.Constants;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract /* synthetic */ class b {
    public static /* synthetic */ String a(int i10) {
        switch (i10) {
            case 1:
                return "INFO_DIRTY";
            case 2:
                return "FILE_NOT_EXIST";
            case 3:
                return "OUTPUT_STREAM_NOT_SUPPORT";
            case 4:
                return "RESPONSE_ETAG_CHANGED";
            case 5:
                return "RESPONSE_PRECONDITION_FAILED";
            case 6:
                return "RESPONSE_CREATED_RANGE_NOT_FROM_0";
            case 7:
                return "RESPONSE_RESET_RANGE_NOT_FROM_0";
            case 8:
                return "CONTENT_LENGTH_CHANGED";
            default:
                return Constants.NULL_VERSION_ID;
        }
    }
}
