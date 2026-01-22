package tech.sud.runtime.component.c;

import android.os.Build;
import org.android.agoo.common.AgooConstants;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class b {
    private static a a;
    private static boolean b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public enum a {
        huawei,
        xiaomi,
        vivo,
        oppo,
        samsung,
        smartisan,
        unknown
    }

    public static a a() {
        a aVar = a;
        if (aVar != null) {
            return aVar;
        }
        a = a.unknown;
        String lowerCase = Build.MANUFACTURER.toLowerCase();
        if (lowerCase.contains(AgooConstants.MESSAGE_SYSTEM_SOURCE_HUAWEI)) {
            a = a.huawei;
        } else if (lowerCase.contains(AgooConstants.MESSAGE_SYSTEM_SOURCE_XIAOMI)) {
            a = a.xiaomi;
        } else if (lowerCase.contains(AgooConstants.MESSAGE_SYSTEM_SOURCE_VIVO)) {
            b = true;
            a = a.vivo;
        } else if (lowerCase.contains(AgooConstants.MESSAGE_SYSTEM_SOURCE_OPPO)) {
            b = true;
            a = a.oppo;
        } else if (lowerCase.contains("samsung")) {
            a = a.samsung;
        } else if (lowerCase.contains("smartisan")) {
            a = a.smartisan;
        }
        return a;
    }

    public static boolean b() {
        if (a == a.smartisan) {
            return true;
        }
        return false;
    }
}
