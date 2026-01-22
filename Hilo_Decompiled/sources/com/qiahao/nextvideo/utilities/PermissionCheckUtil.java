package com.qiahao.nextvideo.utilities;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.media.AudioRecord;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.android.agoo.common.AgooConstants;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class PermissionCheckUtil {
    private static final String TAG = "PermissionCheckUtil";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public class a implements DialogInterface.OnClickListener {
        final /* synthetic */ Context a;

        a(Context context) {
            this.a = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (-1 == i) {
                this.a.startActivity(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + this.a.getPackageName())));
            }
        }
    }

    @TargetApi(19)
    public static boolean canDrawOverlays(Context context) {
        return canDrawOverlays(context, true);
    }

    public static boolean checkPermissions(Context context, String[] strArr) {
        if (strArr.length == 0) {
            return true;
        }
        for (String str : strArr) {
            if ((isFlyme() || Build.VERSION.SDK_INT < 23) && str.equals("android.permission.RECORD_AUDIO")) {
                if (Build.BRAND.equalsIgnoreCase(AgooConstants.MESSAGE_SYSTEM_SOURCE_MEIZU) && Build.MODEL.equals("M1852")) {
                    return hasPermission(context, str);
                }
                if (!hasRecordPermision(context)) {
                    return false;
                }
            } else if (!hasPermission(context, str)) {
                return false;
            }
        }
        return true;
    }

    private static String getNotGrantedPermissionMsg(Context context, List<String> list) {
        if (list != null && list.size() != 0) {
            HashSet hashSet = new HashSet();
            try {
                for (String str : list) {
                    hashSet.add(context.getString(context.getResources().getIdentifier("rc_" + str, "string", context.getPackageName()), 0));
                }
                StringBuilder sb2 = new StringBuilder("(");
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    sb2.append((String) it.next());
                    sb2.append(" ");
                }
                return new StringBuilder(sb2.toString().trim() + ")").toString();
            } catch (Resources.NotFoundException unused) {
            }
        }
        return "";
    }

    private static boolean hasPermission(Context context, String str) {
        if (androidx.core.app.f.c(str) == null) {
            return true;
        }
        if (context != null && context.checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean hasRecordPermision(Context context) {
        AudioRecord audioRecord;
        int minBufferSize = AudioRecord.getMinBufferSize(44100, 12, 2);
        boolean z = false;
        if (minBufferSize < 0) {
            return false;
        }
        AudioRecord audioRecord2 = null;
        try {
            audioRecord = new AudioRecord(1, 44100, 12, 2, minBufferSize);
            try {
                audioRecord.startRecording();
            } catch (Exception unused) {
                audioRecord2 = audioRecord;
                audioRecord = audioRecord2;
                if (audioRecord != null) {
                }
            }
        } catch (Exception unused2) {
        }
        if (audioRecord != null) {
            return false;
        }
        if (audioRecord.getRecordingState() == 3) {
            audioRecord.stop();
            z = true;
        }
        audioRecord.release();
        return z;
    }

    private static boolean isFlyme() {
        String str = "";
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str = (String) cls.getMethod("get", String.class, String.class).invoke(cls, "ro.build.display.id", "");
        } catch (Exception unused) {
        }
        if (str != null && str.toLowerCase().contains("flyme")) {
            return true;
        }
        return false;
    }

    @TargetApi(23)
    public static boolean requestPermissions(Activity activity, String[] strArr, int i) {
        if (Build.VERSION.SDK_INT < 23 || strArr.length == 0) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (!hasPermission(activity, str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() > 0) {
            activity.requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), i);
            return false;
        }
        return true;
    }

    @TargetApi(11)
    private static void showPermissionAlert(Context context, String str, DialogInterface.OnClickListener onClickListener) {
        new AlertDialog.Builder(context).setMessage(str).setPositiveButton(2131952331, onClickListener).setNegativeButton(2131952171, onClickListener).setCancelable(false).create().show();
    }

    @TargetApi(19)
    public static boolean canDrawOverlays(Context context, boolean z) {
        boolean z2 = false;
        Method method = null;
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                boolean booleanValue = ((Boolean) Settings.class.getDeclaredMethod("canDrawOverlays", Context.class).invoke(null, context)).booleanValue();
                if (!booleanValue && z) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                    showPermissionAlert(context, context.getString(2131953621) + getNotGrantedPermissionMsg(context, arrayList), new a(context));
                }
                return booleanValue;
            } catch (Exception unused) {
                return true;
            }
        }
        Object systemService = context.getSystemService("appops");
        try {
            Class<?> cls = Class.forName("android.app.AppOpsManager");
            Class<?> cls2 = Integer.TYPE;
            method = cls.getMethod("checkOp", cls2, cls2, String.class);
        } catch (ClassNotFoundException | NoSuchMethodException unused2) {
        }
        if (method == null) {
            return true;
        }
        try {
            Integer num = (Integer) method.invoke(systemService, 24, Integer.valueOf(context.getApplicationInfo().uid), context.getPackageName());
            if (num != null) {
                if (num.intValue() == 0) {
                    z2 = true;
                }
            }
            return z2;
        } catch (Exception unused3) {
            return true;
        }
    }
}
