package com.tencent.qcloud.tuicore;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.qcloud.tuicore.interfaces.ITUIExtension;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
class ExtensionManager {
    private static final String TAG = "ExtensionManager";
    private final Map<String, List<ITUIExtension>> extensionHashMap;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    private static class ExtensionManagerHolder {
        private static final ExtensionManager extensionManager = new ExtensionManager();

        private ExtensionManagerHolder() {
        }
    }

    public static ExtensionManager getInstance() {
        return ExtensionManagerHolder.extensionManager;
    }

    public Map<String, Object> getExtensionInfo(String str, Map<String, Object> map) {
        List<ITUIExtension> list;
        Log.i(TAG, "getExtensionInfo key : " + str);
        if (TextUtils.isEmpty(str) || (list = this.extensionHashMap.get(str)) == null) {
            return null;
        }
        Iterator<ITUIExtension> it = list.iterator();
        if (!it.hasNext()) {
            return null;
        }
        return it.next().onGetExtensionInfo(str, map);
    }

    public void registerExtension(String str, ITUIExtension iTUIExtension) {
        Log.i(TAG, "registerExtension key : " + str + ", extension : " + iTUIExtension);
        if (!TextUtils.isEmpty(str) && iTUIExtension != null) {
            List<ITUIExtension> list = this.extensionHashMap.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList<>();
                this.extensionHashMap.put(str, list);
            }
            if (!list.contains(iTUIExtension)) {
                list.add(iTUIExtension);
            }
        }
    }

    public void unRegisterExtension(String str, ITUIExtension iTUIExtension) {
        List<ITUIExtension> list;
        Log.i(TAG, "removeExtension key : " + str + ", extension : " + iTUIExtension);
        if (TextUtils.isEmpty(str) || iTUIExtension == null || (list = this.extensionHashMap.get(str)) == null) {
            return;
        }
        list.remove(iTUIExtension);
    }

    private ExtensionManager() {
        this.extensionHashMap = new ConcurrentHashMap();
    }
}
