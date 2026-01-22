package com.tencent.qcloud.tuicore.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class SPUtils {
    public static final String DEFAULT_DATABASE = "tuikit";
    private static final Map<String, SPUtils> SP_UTILS_MAP = new HashMap();
    private final SharedPreferences mSharedPreferences;

    private SPUtils(String str, int i) {
        this.mSharedPreferences = getApplicationContext().getSharedPreferences(str, i);
    }

    private Context getApplicationContext() {
        return ServiceInitializer.getAppContext();
    }

    public static SPUtils getInstance() {
        return getInstance(DEFAULT_DATABASE, 0);
    }

    private static boolean isSpace(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public void clear() {
        clear(false);
    }

    public boolean contains(String str) {
        return this.mSharedPreferences.contains(str);
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public float getFloat(String str) {
        return getFloat(str, -1.0f);
    }

    public int getInt(String str) {
        return getInt(str, -1);
    }

    public long getLong(String str) {
        return getLong(str, -1L);
    }

    public String getString(String str) {
        return getString(str, "");
    }

    public void put(String str, String str2) {
        put(str, str2, false);
    }

    public void remove(String str) {
        remove(str, false);
    }

    public static SPUtils getInstance(int i) {
        return getInstance(DEFAULT_DATABASE, i);
    }

    public void clear(boolean z) {
        if (z) {
            this.mSharedPreferences.edit().clear().commit();
        } else {
            this.mSharedPreferences.edit().clear().apply();
        }
    }

    public boolean getBoolean(String str, boolean z) {
        return this.mSharedPreferences.getBoolean(str, z);
    }

    public float getFloat(String str, float f) {
        return this.mSharedPreferences.getFloat(str, f);
    }

    public int getInt(String str, int i) {
        return this.mSharedPreferences.getInt(str, i);
    }

    public long getLong(String str, long j) {
        return this.mSharedPreferences.getLong(str, j);
    }

    public String getString(String str, String str2) {
        return this.mSharedPreferences.getString(str, str2);
    }

    public void put(String str, String str2, boolean z) {
        if (z) {
            this.mSharedPreferences.edit().putString(str, str2).commit();
        } else {
            this.mSharedPreferences.edit().putString(str, str2).apply();
        }
    }

    public void remove(String str, boolean z) {
        if (z) {
            this.mSharedPreferences.edit().remove(str).commit();
        } else {
            this.mSharedPreferences.edit().remove(str).apply();
        }
    }

    public static SPUtils getInstance(String str) {
        return getInstance(str, 0);
    }

    public static SPUtils getInstance(String str, int i) {
        if (isSpace(str)) {
            str = DEFAULT_DATABASE;
        }
        Map<String, SPUtils> map = SP_UTILS_MAP;
        SPUtils sPUtils = map.get(str);
        if (sPUtils == null) {
            synchronized (SPUtils.class) {
                try {
                    sPUtils = map.get(str);
                    if (sPUtils == null) {
                        sPUtils = new SPUtils(str, i);
                        map.put(str, sPUtils);
                    }
                } finally {
                }
            }
        }
        return sPUtils;
    }

    public void put(String str, boolean z) {
        put(str, z, false);
    }

    public void put(String str, boolean z, boolean z2) {
        if (z2) {
            this.mSharedPreferences.edit().putBoolean(str, z).commit();
        } else {
            this.mSharedPreferences.edit().putBoolean(str, z).apply();
        }
    }

    public void put(String str, int i) {
        put(str, i, false);
    }

    public void put(String str, int i, boolean z) {
        if (z) {
            this.mSharedPreferences.edit().putInt(str, i).commit();
        } else {
            this.mSharedPreferences.edit().putInt(str, i).apply();
        }
    }

    public void put(String str, float f) {
        put(str, f, false);
    }

    public void put(String str, float f, boolean z) {
        if (z) {
            this.mSharedPreferences.edit().putFloat(str, f).commit();
        } else {
            this.mSharedPreferences.edit().putFloat(str, f).apply();
        }
    }

    public void put(String str, long j) {
        put(str, j, false);
    }

    public void put(String str, long j, boolean z) {
        if (z) {
            this.mSharedPreferences.edit().putLong(str, j).commit();
        } else {
            this.mSharedPreferences.edit().putLong(str, j).apply();
        }
    }
}
