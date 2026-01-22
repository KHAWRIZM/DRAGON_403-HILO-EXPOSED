package fa;

import androidx.collection.LruCache;
import com.hjq.permissions.permission.base.IPermission;
import com.hjq.permissions.permission.dangerous.BodySensorsBackgroundPermission;
import com.hjq.permissions.permission.dangerous.BodySensorsPermission;
import com.hjq.permissions.permission.dangerous.ReadExternalStoragePermission;
import com.hjq.permissions.permission.dangerous.ReadMediaAudioPermission;
import com.hjq.permissions.permission.dangerous.ReadMediaImagesPermission;
import com.hjq.permissions.permission.dangerous.ReadMediaVideoPermission;
import com.hjq.permissions.permission.dangerous.ReadMediaVisualUserSelectedPermission;
import com.hjq.permissions.permission.dangerous.StandardDangerousPermission;
import com.hjq.permissions.permission.dangerous.WriteExternalStoragePermission;
import com.hjq.permissions.permission.special.ManageExternalStoragePermission;
import com.hjq.permissions.permission.special.NotificationServicePermission;
import com.luck.picture.lib.permissions.PermissionConfig;
import io.agora.rtc.Constants;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static final LruCache f١٤٢٩١a = new LruCache(Constants.ERR_PUBLISH_STREAM_CDN_ERROR);

    public static IPermission a() {
        IPermission e10 = e("android.permission.ACCESS_COARSE_LOCATION");
        if (e10 != null) {
            return e10;
        }
        return q(new StandardDangerousPermission("android.permission.ACCESS_COARSE_LOCATION", "location_group", 23));
    }

    public static IPermission b() {
        IPermission e10 = e("android.permission.ACCESS_FINE_LOCATION");
        if (e10 != null) {
            return e10;
        }
        return q(new StandardDangerousPermission("android.permission.ACCESS_FINE_LOCATION", "location_group", 23));
    }

    public static IPermission c() {
        IPermission e10 = e("android.permission.BODY_SENSORS_BACKGROUND");
        if (e10 != null) {
            return e10;
        }
        return q(new BodySensorsBackgroundPermission());
    }

    public static IPermission d() {
        IPermission e10 = e("android.permission.BODY_SENSORS");
        if (e10 != null) {
            return e10;
        }
        return q(new BodySensorsPermission());
    }

    private static IPermission e(String str) {
        return (IPermission) f١٤٢٩١a.get(str);
    }

    public static IPermission f() {
        IPermission e10 = e("android.permission.CAMERA");
        if (e10 != null) {
            return e10;
        }
        return q(new StandardDangerousPermission("android.permission.CAMERA", 23));
    }

    public static IPermission g() {
        IPermission e10 = e("android.permission.MANAGE_EXTERNAL_STORAGE");
        if (e10 != null) {
            return e10;
        }
        return q(new ManageExternalStoragePermission());
    }

    public static IPermission h() {
        IPermission e10 = e("android.permission.NOTIFICATION_SERVICE");
        if (e10 != null) {
            return e10;
        }
        return q(new NotificationServicePermission());
    }

    public static IPermission i() {
        IPermission e10 = e(PermissionConfig.READ_EXTERNAL_STORAGE);
        if (e10 != null) {
            return e10;
        }
        return q(new ReadExternalStoragePermission());
    }

    public static IPermission j() {
        IPermission e10 = e(PermissionConfig.READ_MEDIA_AUDIO);
        if (e10 != null) {
            return e10;
        }
        return q(new ReadMediaAudioPermission());
    }

    public static IPermission k() {
        IPermission e10 = e(PermissionConfig.READ_MEDIA_IMAGES);
        if (e10 != null) {
            return e10;
        }
        return q(new ReadMediaImagesPermission());
    }

    public static IPermission l() {
        IPermission e10 = e(PermissionConfig.READ_MEDIA_VIDEO);
        if (e10 != null) {
            return e10;
        }
        return q(new ReadMediaVideoPermission());
    }

    public static IPermission m() {
        IPermission e10 = e(PermissionConfig.READ_MEDIA_VISUAL_USER_SELECTED);
        if (e10 != null) {
            return e10;
        }
        return q(new ReadMediaVisualUserSelectedPermission());
    }

    public static IPermission n() {
        IPermission e10 = e("android.permission.READ_PHONE_STATE");
        if (e10 != null) {
            return e10;
        }
        return q(new StandardDangerousPermission("android.permission.READ_PHONE_STATE", "phone_group", 23));
    }

    public static IPermission o() {
        IPermission e10 = e("android.permission.RECORD_AUDIO");
        if (e10 != null) {
            return e10;
        }
        return q(new StandardDangerousPermission("android.permission.RECORD_AUDIO", 23));
    }

    public static IPermission p() {
        IPermission e10 = e(PermissionConfig.WRITE_EXTERNAL_STORAGE);
        if (e10 != null) {
            return e10;
        }
        return q(new WriteExternalStoragePermission());
    }

    private static IPermission q(IPermission iPermission) {
        f١٤٢٩١a.put(iPermission.x(), iPermission);
        return iPermission;
    }
}
