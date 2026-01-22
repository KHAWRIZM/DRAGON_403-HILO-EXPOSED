package com.tencent.rtmp.video;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Binder;
import android.os.IBinder;
import com.alibaba.sdk.android.push.notification.f;
import com.google.android.gms.common.e;
import com.taobao.accs.common.Constants;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ScreenCaptureService extends Service {
    private static final String CHANNEL_ID = "notification_id";
    private static final int NOTIFICATION_ID = 13957237;
    private static final String TAG = "ScreenCaptureService";
    public static final /* synthetic */ int a = 0;

    private Notification createNotification() {
        if (BaseBridge.getSystemOSVersion() >= 26) {
            com.google.android.gms.common.b.a((NotificationManager) getSystemService("notification"), e.a(CHANNEL_ID, "notification_name", 2));
        }
        Notification.Builder defaults = new Notification.Builder(this).setDefaults(1);
        if (BaseBridge.getSystemOSVersion() >= 26) {
            f.a(defaults, CHANNEL_ID);
        }
        return defaults.build();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        BaseBridge.printLog(TAG, "Service on bind");
        return new Binder();
    }

    @Override // android.app.Service
    public void onDestroy() {
        stopForeground(true);
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        MediaProjectionManager mediaProjectionManager;
        MediaProjection mediaProjection;
        int intExtra = intent.getIntExtra(Constants.KEY_HTTP_CODE, -1);
        Intent intent2 = (Intent) intent.getParcelableExtra("data");
        BaseBridge.printLog(TAG, "On Start server command, code:" + intExtra + ", data:" + intent2);
        if (intent2 == null) {
            stopSelf();
            return 2;
        }
        try {
            if (BaseBridge.getSystemOSVersion() >= 29) {
                startForeground(NOTIFICATION_ID, createNotification(), 32);
            } else if (BaseBridge.getSystemOSVersion() >= 26) {
                startForeground(NOTIFICATION_ID, createNotification());
            }
        } catch (Throwable th) {
            BaseBridge.printLog(TAG, "start foreground failed.".concat(String.valueOf(th)));
        }
        if (BaseBridge.getSystemOSVersion() >= 21) {
            if (BaseBridge.getAppContext() != null) {
                mediaProjectionManager = (MediaProjectionManager) BaseBridge.getAppContext().getSystemService("media_projection");
            } else {
                mediaProjectionManager = (MediaProjectionManager) getSystemService("media_projection");
            }
            try {
                mediaProjection = mediaProjectionManager.getMediaProjection(intExtra, intent2);
            } catch (Throwable th2) {
                BaseBridge.printLog(TAG, "onStartCommand mediaProjectionManager getMediaProjection fail.".concat(String.valueOf(th2)));
                mediaProjection = null;
            }
            VirtualDisplayManagerProxy.getInstance().signalSessionRequestFinish(mediaProjection);
        }
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        BaseBridge.printLog(TAG, "Service on unbind");
        return super.onUnbind(intent);
    }
}
