package i5;

import anet.channel.util.HttpConstant;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class a {
    public static String a(int i10) {
        switch (i10) {
            case -1:
                return "SUCCESS_CACHE";
            case 0:
                return HttpConstant.SUCCESS;
            case 1:
                return "CONNECTED";
            case 2:
                return "CONNECTING";
            case 3:
                return "CONNECT_FAILED";
            case 4:
                return "DISCONNECT";
            case 5:
                return "SUCCESS_UNBIND";
            case 6:
                return "CANCELED";
            case 7:
                return "INTERNAL_ERROR";
            case 8:
                return "TASK_NULL";
            case 9:
                return "INTERRUPTED";
            case 10:
                return "TIMEOUT";
            case 11:
                return "API_NOT_CONNECTED";
            case 12:
                return "CLIENT_UNKNOWN";
            case 13:
                return "SERVICE_ABNORMAL_EXIT";
            case 14:
                return "RECONNECTING";
            default:
                switch (i10) {
                    case 1001:
                        return "AUTHENTICATE_SUCCESS";
                    case 1002:
                        return "AUTHENTICATE_FAIL";
                    case 1003:
                        return "TIME_EXPIRED";
                    case 1004:
                        return "AUTHCODE_EXPECTED";
                    case 1005:
                        return "VERSION_INCOMPATIBLE";
                    case 1006:
                        return "AUTHCODE_RECYCLE";
                    case 1007:
                        return "AUTHCODE_INVALID";
                    case 1008:
                        return "CAPABILITY_EXCEPTION";
                    default:
                        StringBuilder sb = new StringBuilder(32);
                        sb.append("unknown status code: ");
                        sb.append(i10);
                        return sb.toString();
                }
        }
    }
}
