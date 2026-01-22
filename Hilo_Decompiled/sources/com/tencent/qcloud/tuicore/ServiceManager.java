package com.tencent.qcloud.tuicore;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.qcloud.tuicore.interfaces.ITUIService;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
class ServiceManager {
    private static final String TAG = "ServiceManager";
    private final Map<String, ITUIService> serviceMap;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    private static class ServiceManagerHolder {
        private static final ServiceManager serviceManager = new ServiceManager();

        private ServiceManagerHolder() {
        }
    }

    public static ServiceManager getInstance() {
        return ServiceManagerHolder.serviceManager;
    }

    public Object callService(String str, String str2, Map<String, Object> map) {
        String str3 = TAG;
        Log.i(str3, "callService : " + str + " method : " + str2);
        ITUIService iTUIService = this.serviceMap.get(str);
        if (iTUIService != null) {
            return iTUIService.onCall(str2, map);
        }
        Log.w(str3, "can't find service : " + str);
        return null;
    }

    public ITUIService getService(String str) {
        Log.i(TAG, "getService : " + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.serviceMap.get(str);
    }

    public void registerService(String str, ITUIService iTUIService) {
        Log.i(TAG, "registerService : " + str + "  " + iTUIService);
        if (!TextUtils.isEmpty(str) && iTUIService != null) {
            this.serviceMap.put(str, iTUIService);
        }
    }

    public void unregisterService(String str) {
        Log.i(TAG, "unregisterService : " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.serviceMap.remove(str);
    }

    private ServiceManager() {
        this.serviceMap = new ConcurrentHashMap();
    }
}
