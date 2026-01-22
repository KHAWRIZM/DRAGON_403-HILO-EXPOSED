package com.tencent.qcloud.tuicore.util;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.qcloud.tuicore.R;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import java.lang.reflect.Method;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class TUIUtil {
    private static String currentProcessName = "";

    public static int getDefaultGroupIconResIDByGroupType(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (TextUtils.equals(str, "Work")) {
                return TUIThemeManager.getAttrResId(context, R.attr.core_default_group_icon_work);
            }
            if (TextUtils.equals(str, "Meeting")) {
                return TUIThemeManager.getAttrResId(context, R.attr.core_default_group_icon_meeting);
            }
            if (TextUtils.equals(str, "Public")) {
                return TUIThemeManager.getAttrResId(context, R.attr.core_default_group_icon_public);
            }
            if (TextUtils.equals(str, "Community")) {
                return TUIThemeManager.getAttrResId(context, R.attr.core_default_group_icon_community);
            }
            return R.drawable.core_default_group_icon_community;
        }
        return R.drawable.core_default_group_icon_community;
    }

    public static String getProcessName() {
        if (!TextUtils.isEmpty(currentProcessName)) {
            return currentProcessName;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            String a = z3.a.a();
            currentProcessName = a;
            return a;
        }
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", null);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, null);
            if (invoke instanceof String) {
                currentProcessName = (String) invoke;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return currentProcessName;
    }
}
