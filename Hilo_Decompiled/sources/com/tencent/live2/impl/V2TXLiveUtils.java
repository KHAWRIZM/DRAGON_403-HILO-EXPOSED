package com.tencent.live2.impl;

import android.text.TextUtils;
import android.util.Base64;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.utilities.userproxy.UserProxyUtility;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.live2.V2TXLiveDef;
import com.tencent.trtc.hardwareearmonitor.honor.HonorResultCode;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class V2TXLiveUtils {
    private static final String TAG = "V2TXLiveUtils";
    public static final String TRTC_ADDRESS1 = new String(Base64.decode("cm9vbTovL2Nsb3VkLnRlbmNlbnQuY29tL3J0Yw==", 0));
    public static final String TRTC_ADDRESS2 = new String(Base64.decode("cm9vbTovL3J0Yy50ZW5jZW50LmNvbQ==", 0));

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.live2.impl.V2TXLiveUtils$1, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[V2TXLiveDef.V2TXLiveVideoResolution.values().length];
            a = iArr;
            try {
                iArr[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution160x160.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution270x270.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution480x480.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution320x240.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution480x360.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution640x480.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution320x180.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution480x270.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution640x360.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution960x540.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution1280x720.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution1920x1080.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class a {
        public int a;
        public int b;

        public a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static a getBitrateByResolution(V2TXLiveDef.V2TXLiveVideoResolution v2TXLiveVideoResolution) {
        int i;
        int i2 = 600;
        switch (AnonymousClass1.a[v2TXLiveVideoResolution.ordinal()]) {
            case 1:
                i2 = 100;
                i = UserProxyUtility.cpUpgrades;
                break;
            case 2:
                i2 = 200;
                i = 300;
                break;
            case 3:
                i = 525;
                i2 = 350;
                break;
            case 4:
                i = 375;
                i2 = RoomEvent.ROOM_CURRENT_USER_ONLINE;
                break;
            case 5:
                i = 600;
                i2 = 400;
                break;
            case 6:
                i = RoomEvent.ROOM_LUCKY_WHEEL_EVENT;
                break;
            case 7:
                i = 400;
                i2 = RoomEvent.ROOM_CURRENT_USER_ONLINE;
                break;
            case 8:
                i = 550;
                i2 = 350;
                break;
            case 9:
                i2 = 500;
                i = RoomEvent.ROOM_LUCKY_WHEEL_EVENT;
                break;
            case 10:
            default:
                i = RoomEvent.ROOM_ACTIVITY_DETAIL;
                i2 = RoomEvent.ROOM_MIC_EMOJI;
                break;
            case 11:
                i2 = 1000;
                i = 1800;
                break;
            case 12:
                i2 = 2500;
                i = HonorResultCode.AUDIO_PLAY_SERVICE_SUCCESS;
                break;
        }
        return new a(i2, i);
    }

    public static V2TXLiveDef.V2TXLiveMode parseLiveMode(String str) {
        if (!str.startsWith("trtc://") && !str.startsWith(TRTC_ADDRESS1) && !str.startsWith(TRTC_ADDRESS2)) {
            TXCLog.i(TAG, "parseLiveMode: rtmp.");
            return V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTMP;
        }
        TXCLog.i(TAG, "parseLiveMode: rtc.");
        return V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTC;
    }

    public static String removeURLSensitiveInfo(String str) {
        int indexOf;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            String[] strArr = {"roomsig", "privatemapkey", "usersig"};
            for (int i = 0; i < 3; i++) {
                if (str.contains(strArr[i]) && (indexOf = str.indexOf(strArr[i])) != -1) {
                    int indexOf2 = str.indexOf("&", indexOf);
                    if (indexOf2 == -1) {
                        str = str.substring(0, indexOf);
                    } else {
                        str = str.substring(0, indexOf) + str.substring(indexOf2);
                    }
                }
            }
        } catch (Exception e) {
            TXCLog.e(TAG, "remove url sensitive info failed.", e);
        }
        return str;
    }
}
