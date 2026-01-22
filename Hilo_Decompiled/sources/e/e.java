package e;

import android.app.Application;
import android.text.TextUtils;
import java.nio.charset.StandardCharsets;
import kotlin.KotlinVersion;
import tech.sud.base.utils.Utils;
import u.l;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class e {
    public static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            byte[] b10 = i.a.b(str);
            if (b10 != null && b10.length != 0) {
                byte[] bArr = new byte[b10.length];
                for (int i10 = 0; i10 < b10.length; i10++) {
                    bArr[i10] = (byte) (b10[i10] ^ (i10 & KotlinVersion.MAX_COMPONENT_VALUE));
                }
                b10 = bArr;
            }
            if (b10 != null && b10.length != 0) {
                return new String(b10, StandardCharsets.UTF_8);
            }
            return str;
        }
        return str;
    }

    public static String b(String str) {
        StringBuilder sb = new StringBuilder("https://mgp.sud.tech/");
        String str2 = d.f١٣٧٢٤g;
        if (str2 != null) {
            sb.append(str2);
        }
        sb.append("?platform=2");
        Application app = Utils.getApp();
        if (app != null) {
            sb.append("&netType=");
            sb.append(l.a(app));
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append("&requestId=");
            sb.append(str);
        }
        return sb.toString();
    }
}
