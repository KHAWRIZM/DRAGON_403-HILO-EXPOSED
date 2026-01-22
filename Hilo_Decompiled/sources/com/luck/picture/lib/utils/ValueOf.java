package com.luck.picture.lib.utils;

import anetwork.channel.util.RequestConstant;
import com.amazonaws.services.s3.model.InstructionFileId;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class ValueOf {
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T to(Object obj, T t10) {
        return obj == 0 ? t10 : obj;
    }

    public static boolean toBoolean(Object obj) {
        return toBoolean(obj, false);
    }

    public static double toDouble(Object obj) {
        return toDouble(obj, 0);
    }

    public static float toFloat(Object obj, long j10) {
        if (obj == null) {
            return (float) j10;
        }
        try {
            return Float.parseFloat(obj.toString().trim());
        } catch (Exception unused) {
            return (float) j10;
        }
    }

    public static int toInt(Object obj, int i10) {
        int parseInt;
        if (obj == null) {
            return i10;
        }
        try {
            String trim = obj.toString().trim();
            if (trim.contains(InstructionFileId.DOT)) {
                parseInt = Integer.parseInt(trim.substring(0, trim.lastIndexOf(InstructionFileId.DOT)));
            } else {
                parseInt = Integer.parseInt(trim);
            }
            return parseInt;
        } catch (Exception unused) {
            return i10;
        }
    }

    public static long toLong(Object obj, long j10) {
        long parseLong;
        if (obj == null) {
            return j10;
        }
        try {
            String trim = obj.toString().trim();
            if (trim.contains(InstructionFileId.DOT)) {
                parseLong = Long.parseLong(trim.substring(0, trim.lastIndexOf(InstructionFileId.DOT)));
            } else {
                parseLong = Long.parseLong(trim);
            }
            return parseLong;
        } catch (Exception unused) {
            return j10;
        }
    }

    public static String toString(Object obj) {
        try {
            return obj.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean toBoolean(Object obj, boolean z10) {
        if (obj == null) {
            return false;
        }
        try {
            return !RequestConstant.FALSE.equals(obj.toString().trim().trim());
        } catch (Exception unused) {
            return z10;
        }
    }

    public static double toDouble(Object obj, int i10) {
        if (obj == null) {
            return i10;
        }
        try {
            return Double.parseDouble(obj.toString().trim());
        } catch (Exception unused) {
            return i10;
        }
    }

    public static float toFloat(Object obj) {
        return toFloat(obj, 0L);
    }

    public static int toInt(Object obj) {
        return toInt(obj, 0);
    }

    public static long toLong(Object obj) {
        return toLong(obj, 0L);
    }
}
