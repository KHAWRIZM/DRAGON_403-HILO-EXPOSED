package u;

import android.text.TextUtils;
import java.net.URLEncoder;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class g {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            if (charAt > ' ' && charAt < 127) {
                sb.append(charAt);
            } else {
                sb.append(URLEncoder.encode(charAt + ""));
            }
        }
        return sb.toString();
    }
}
