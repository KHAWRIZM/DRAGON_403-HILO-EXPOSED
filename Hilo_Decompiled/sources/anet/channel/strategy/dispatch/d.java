package anet.channel.strategy.dispatch;

import android.os.Build;
import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class d {
    public static final String TAG = "amdc.DispatchParamBuilder";

    d() {
    }

    public static Map a(Map<String, Object> map) {
        IAmdcSign sign = AmdcRuntimeInfo.getSign();
        if (sign == null || TextUtils.isEmpty(sign.getAppkey())) {
            ALog.e(TAG, "amdc sign is null or appkey is empty", null, new Object[0]);
            return null;
        }
        NetworkStatusHelper.NetworkStatus status = NetworkStatusHelper.getStatus();
        if (!NetworkStatusHelper.isConnected()) {
            ALog.e(TAG, "no network, don't send amdc request", null, new Object[0]);
            return null;
        }
        map.put("appkey", sign.getAppkey());
        map.put("v", DispatchConstants.VER_CODE);
        map.put("platform", "android");
        map.put("platformVersion", Build.VERSION.RELEASE);
        if (!TextUtils.isEmpty(GlobalAppRuntimeInfo.getUserId())) {
            map.put(DispatchConstants.SID, GlobalAppRuntimeInfo.getUserId());
        }
        map.put(DispatchConstants.NET_TYPE, status.toString());
        map.put("carrier", NetworkStatusHelper.getCarrier());
        map.put(DispatchConstants.MNC, NetworkStatusHelper.getSimOp());
        if (AmdcRuntimeInfo.latitude != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            map.put(DispatchConstants.LATITUDE, String.valueOf(AmdcRuntimeInfo.latitude));
        }
        if (AmdcRuntimeInfo.longitude != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            map.put(DispatchConstants.LONGTITUDE, String.valueOf(AmdcRuntimeInfo.longitude));
        }
        map.putAll(AmdcRuntimeInfo.getParams());
        map.put("channel", AmdcRuntimeInfo.appChannel);
        map.put(DispatchConstants.APP_NAME, AmdcRuntimeInfo.appName);
        map.put("appVersion", AmdcRuntimeInfo.appVersion);
        map.put(DispatchConstants.STACK_TYPE, Integer.toString(a()));
        map.put("domain", b(map));
        map.put(DispatchConstants.SIGNTYPE, sign.useSecurityGuard() ? "sec" : "noSec");
        map.put("t", String.valueOf(System.currentTimeMillis()));
        String a10 = a(sign, map);
        if (TextUtils.isEmpty(a10)) {
            return null;
        }
        map.put(DispatchConstants.SIGN, a10);
        return map;
    }

    private static String b(Map map) {
        Set set = (Set) map.remove(DispatchConstants.HOSTS);
        StringBuilder sb = new StringBuilder();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private static int a() {
        int c10 = anet.channel.util.c.c();
        if (c10 != 2) {
            return c10 != 3 ? 4 : 1;
        }
        return 2;
    }

    static String a(IAmdcSign iAmdcSign, Map<String, String> map) {
        StringBuilder sb = new StringBuilder(128);
        sb.append(anet.channel.strategy.utils.c.d(map.get("appkey")));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.c.d(map.get("domain")));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.c.d(map.get(DispatchConstants.APP_NAME)));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.c.d(map.get("appVersion")));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.c.d(map.get(DispatchConstants.BSSID)));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.c.d(map.get("channel")));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.c.d(map.get(DispatchConstants.DEVICEID)));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.c.d(map.get(DispatchConstants.LATITUDE)));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.c.d(map.get(DispatchConstants.LONGTITUDE)));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.c.d(map.get(DispatchConstants.MACHINE)));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.c.d(map.get(DispatchConstants.NET_TYPE)));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.c.d(map.get("other")));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.c.d(map.get("platform")));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.c.d(map.get("platformVersion")));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.c.d(map.get(DispatchConstants.PRE_IP)));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.c.d(map.get(DispatchConstants.SID)));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.c.d(map.get("t")));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.c.d(map.get("v")));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.c.d(map.get(DispatchConstants.SIGNTYPE)));
        try {
            return iAmdcSign.sign(sb.toString());
        } catch (Exception e10) {
            ALog.e(TAG, "get sign failed", null, e10, new Object[0]);
            return null;
        }
    }
}
