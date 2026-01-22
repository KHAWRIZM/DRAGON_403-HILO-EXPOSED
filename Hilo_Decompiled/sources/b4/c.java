package b4;

import android.R;
import android.app.Notification;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.media.RingtoneManager;
import android.os.Build;
import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import java.util.Random;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class c extends d {

    /* renamed from: f, reason: collision with root package name */
    private static Random f٥٤٠٣f;

    private Bitmap l(Drawable drawable) {
        Bitmap.Config config;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (drawable.getOpacity() != -1) {
            config = Bitmap.Config.ARGB_8888;
        } else {
            config = Bitmap.Config.RGB_565;
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    private static String m(String str) {
        try {
            Class<?>[] clsArr = {String.class};
            Object[] objArr = {str};
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", clsArr).invoke(cls, objArr);
        } catch (Throwable unused) {
            return "";
        }
    }

    private static boolean n() {
        try {
            String m10 = m("ro.vivo.os.build.display.id");
            if (!Build.MANUFACTURER.equalsIgnoreCase("vivo") && !m10.startsWith("Funtouch")) {
                String m11 = m("ro.iqoo.os.build.display.id");
                if (m11 != null) {
                    if (TextUtils.isEmpty(m11.trim())) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // b4.d
    public Notification a(Context context) {
        int i10;
        try {
            i10 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.icon;
        } catch (PackageManager.NameNotFoundException e10) {
            ALog.e("BasicNotificationBuilder", "Get system icon error, package name not found, ", e10, new Object[0]);
            i10 = R.drawable.stat_notify_chat;
        }
        Bitmap l10 = l(context.getResources().getDrawable(i10));
        int i11 = Build.VERSION.SDK_INT;
        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentTitle(b()).setContentText(e()).setSmallIcon(i10).setVibrate(new long[]{100, 250, 100, 250, 100, 250}).setSound(RingtoneManager.getDefaultUri(2)).setPriority(g()).setAutoCancel(true).setLargeIcon(l10).setWhen(System.currentTimeMillis()).setTicker("");
        if (!TextUtils.isEmpty(k())) {
            builder.setGroup(k());
        }
        builder.setShowWhen(true);
        if (i11 >= 26 && !TextUtils.isEmpty(i())) {
            builder.setChannelId(i());
        }
        if (n()) {
            builder.setGroupSummary(true);
            if (f٥٤٠٣f == null) {
                f٥٤٠٣f = new Random(System.currentTimeMillis());
            }
            builder.setGroup("group" + f٥٤٠٣f.nextInt());
        } else {
            builder.setGroupSummary(false);
            builder.setGroup("group");
        }
        return builder.build();
    }
}
