package com.luck.picture.lib.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.core.app.o;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.utils.SdkVersionUtils;
import na.e;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class ForegroundService extends Service {
    private static final String CHANNEL_NAME = "com.luck.picture.lib";
    private static final int NOTIFICATION_ID = 1;
    private static final String CHANNEL_ID = "com.luck.picture.lib." + ForegroundService.class.getName();
    private static boolean isForegroundServiceIng = false;

    private Notification createForegroundNotification() {
        int i10;
        int i11;
        if (SdkVersionUtils.isMaxN()) {
            i10 = 4;
        } else {
            i10 = 0;
        }
        if (SdkVersionUtils.isO()) {
            e.a();
            NotificationChannel a10 = com.google.android.gms.common.e.a(CHANNEL_ID, "com.luck.picture.lib", i10);
            a10.setLightColor(-16776961);
            a10.canBypassDnd();
            a10.setBypassDnd(true);
            a10.setLockscreenVisibility(0);
            ((NotificationManager) getSystemService(TransferService.INTENT_KEY_NOTIFICATION)).createNotificationChannel(a10);
        }
        if (SelectorProviders.getInstance().getSelectorConfig().chooseMode == SelectMimeType.ofAudio()) {
            i11 = R.string.ps_use_sound;
        } else {
            i11 = R.string.ps_use_camera;
        }
        return new o.e(this, CHANNEL_ID).v(R.drawable.ps_ic_trans_1px).j(getAppName()).i(getString(i11)).s(true).b();
    }

    private String getAppName() {
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 0).applicationInfo.loadLabel(getPackageManager()).toString();
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static void startForegroundService(Context context, boolean z10) {
        try {
            if (!isForegroundServiceIng && z10) {
                Intent intent = new Intent(context, (Class<?>) ForegroundService.class);
                if (SdkVersionUtils.isO()) {
                    context.startForegroundService(intent);
                } else {
                    context.startService(intent);
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void stopService(Context context) {
        try {
            if (isForegroundServiceIng) {
                context.stopService(new Intent(context, (Class<?>) ForegroundService.class));
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        startForeground(1, createForegroundNotification());
    }

    @Override // android.app.Service
    public void onDestroy() {
        isForegroundServiceIng = false;
        stopForeground(true);
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        isForegroundServiceIng = true;
        return super.onStartCommand(intent, i10, i11);
    }
}
