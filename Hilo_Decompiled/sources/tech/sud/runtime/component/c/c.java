package tech.sud.runtime.component.c;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Vibrator;
import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class c {
    public static void a(Activity activity, int i, int i2) {
    }

    public static String b(Context context) {
        ClipData primaryClip;
        if (context == null || (primaryClip = ((ClipboardManager) context.getSystemService("clipboard")).getPrimaryClip()) == null) {
            return "";
        }
        return primaryClip.getItemAt(0).getText().toString();
    }

    public static void a(Activity activity, String str) {
        if (activity == null) {
            return;
        }
        str.getClass();
    }

    public static void a(Activity activity, boolean z) {
        if (activity == null) {
            return;
        }
        if (z) {
            activity.getWindow().addFlags(128);
        } else {
            activity.getWindow().clearFlags(128);
        }
    }

    public static String a(Context context) {
        boolean z;
        if (context == null) {
            return "";
        }
        try {
            int intExtra = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("status", -1);
            if (intExtra != 2 && intExtra != 5) {
                z = false;
                int round = Math.round((r6.getIntExtra("level", -1) * 100) / r6.getIntExtra("scale", -1));
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("level", "" + round);
                jSONObject.put("isCharging", z);
                return jSONObject.toString();
            }
            z = true;
            int round2 = Math.round((r6.getIntExtra("level", -1) * 100) / r6.getIntExtra("scale", -1));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("level", "" + round2);
            jSONObject2.put("isCharging", z);
            return jSONObject2.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean a(Context context, String str) {
        if (context == null) {
            return false;
        }
        ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("sud clip data", str));
        return true;
    }

    public static void a(Activity activity, float f) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (f < 0.01f) {
            f = 0.01f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        attributes.screenBrightness = f;
        window.setAttributes(attributes);
    }

    public static float a(Activity activity) {
        float f = 0.0f;
        if (activity == null) {
            return 0.0f;
        }
        try {
            float f2 = activity.getWindow().getAttributes().screenBrightness;
            if (f2 >= 0.0f) {
                return f2;
            }
            try {
                return Settings.System.getInt(activity.getContentResolver(), "screen_brightness", 0) / 255.0f;
            } catch (Exception e) {
                e = e;
                f = f2;
                e.printStackTrace();
                return f;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static void a(Context context, int i) {
        if (context == null) {
            return;
        }
        ((Vibrator) context.getSystemService("vibrator")).vibrate(i);
    }
}
