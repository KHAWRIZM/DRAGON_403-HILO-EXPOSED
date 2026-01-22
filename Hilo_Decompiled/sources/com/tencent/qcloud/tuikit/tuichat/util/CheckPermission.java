package com.tencent.qcloud.tuikit.tuichat.util;

import android.hardware.Camera;
import android.media.AudioRecord;
import android.util.Log;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class CheckPermission {
    public static final int STATE_NO_PERMISSION = -2;
    public static final int STATE_RECORDING = -1;
    public static final int STATE_SUCCESS = 1;
    private static final String TAG = "CheckPermission";

    public static int getRecordState() {
        int minBufferSize = AudioRecord.getMinBufferSize(44100, 16, 2);
        AudioRecord audioRecord = new AudioRecord(0, 44100, 16, 2, minBufferSize * 100);
        short[] sArr = new short[minBufferSize];
        try {
            audioRecord.startRecording();
            if (audioRecord.getRecordingState() != 3) {
                audioRecord.stop();
                audioRecord.release();
                Log.i(TAG, ServiceInitializer.getAppContext().getString(R.string.record_occupied));
                return -1;
            }
            if (audioRecord.read(sArr, 0, minBufferSize) <= 0) {
                audioRecord.stop();
                audioRecord.release();
                Log.i(TAG, ServiceInitializer.getAppContext().getString(R.string.record_null));
                return -2;
            }
            audioRecord.stop();
            audioRecord.release();
            return 1;
        } catch (Exception unused) {
            audioRecord.release();
            return -2;
        }
    }

    public static synchronized boolean isCameraUseable(int i) {
        boolean z;
        synchronized (CheckPermission.class) {
            Camera camera = null;
            try {
                try {
                    camera = Camera.open(i);
                    camera.setParameters(camera.getParameters());
                    camera.release();
                    z = true;
                } catch (Exception e) {
                    e.printStackTrace();
                    z = false;
                }
            } finally {
                if (camera != null) {
                    camera.release();
                }
            }
        }
        return z;
    }
}
