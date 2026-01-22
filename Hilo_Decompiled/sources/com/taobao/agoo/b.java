package com.taobao.agoo;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import java.util.ArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class b {
    public static final String TAG = "LocalStorage";

    public static void a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && context != null) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            SharedPreferences.Editor edit = defaultSharedPreferences.edit();
            if (TextUtils.isEmpty(str2)) {
                edit.remove(b(str));
                String string = defaultSharedPreferences.getString("alicloud-third-push-alias-list", "");
                String a = a(str);
                if (string.contains(a)) {
                    edit.putString("alicloud-third-push-alias-list", string.replace(a, ""));
                }
            } else {
                edit.putString(b(str), str2);
                String string2 = defaultSharedPreferences.getString("alicloud-third-push-alias-list", "");
                String a2 = a(str);
                if (!string2.contains(a2)) {
                    edit.putString("alicloud-third-push-alias-list", string2 + a2);
                }
            }
            edit.apply();
            return;
        }
        ALog.d(TAG, "saveAliasToken input invalid", new Object[0]);
    }

    private static String b(String str) {
        return "alicloud-third-push-pat-" + str;
    }

    private static String a(String str) {
        if (str != null && !str.isEmpty()) {
            return "#&#" + str + "#&#";
        }
        return "";
    }

    public static String a(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            return PreferenceManager.getDefaultSharedPreferences(context).getString(b(str), null);
        }
        ALog.d(TAG, "getAliasToken input invalid", new Object[0]);
        return null;
    }

    public static ArrayList<String> a(Context context) {
        String[] split = PreferenceManager.getDefaultSharedPreferences(context).getString("alicloud-third-push-alias-list", "").split("#&#");
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            String str = split[i];
            if (str != null && !str.isEmpty()) {
                arrayList.add(split[i]);
            }
        }
        return arrayList;
    }
}
