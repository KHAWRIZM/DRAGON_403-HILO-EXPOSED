package n4;

import android.net.Uri;
import com.facebook.share.internal.ShareConstants;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class b {
    public static boolean a(Uri uri) {
        if (c(uri) && uri.getPathSegments().contains("picker")) {
            return true;
        }
        return false;
    }

    public static boolean b(Uri uri) {
        if (c(uri) && !f(uri)) {
            return true;
        }
        return false;
    }

    public static boolean c(Uri uri) {
        if (uri != null && "content".equals(uri.getScheme()) && ShareConstants.WEB_DIALOG_PARAM_MEDIA.equals(uri.getAuthority())) {
            return true;
        }
        return false;
    }

    public static boolean d(Uri uri) {
        if (c(uri) && f(uri)) {
            return true;
        }
        return false;
    }

    public static boolean e(int i10, int i11) {
        if (i10 != Integer.MIN_VALUE && i11 != Integer.MIN_VALUE && i10 <= 512 && i11 <= 384) {
            return true;
        }
        return false;
    }

    private static boolean f(Uri uri) {
        return uri.getPathSegments().contains("video");
    }
}
