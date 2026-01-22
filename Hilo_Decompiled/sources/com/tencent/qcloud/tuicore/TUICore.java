package com.tencent.qcloud.tuicore;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.qcloud.tuicore.TUIRouter;
import com.tencent.qcloud.tuicore.interfaces.ITUIExtension;
import com.tencent.qcloud.tuicore.interfaces.ITUINotification;
import com.tencent.qcloud.tuicore.interfaces.ITUIService;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class TUICore {
    private static final String TAG = "TUICore";
    public static final /* synthetic */ int a = 0;

    public static Object callService(String str, String str2, Map<String, Object> map) {
        return ServiceManager.getInstance().callService(str, str2, map);
    }

    public static Map<String, Object> getExtensionInfo(String str, Map<String, Object> map) {
        return ExtensionManager.getInstance().getExtensionInfo(str, map);
    }

    public static ITUIService getService(String str) {
        return ServiceManager.getInstance().getService(str);
    }

    public static void notifyEvent(String str, String str2, Map<String, Object> map) {
        EventManager.getInstance().notifyEvent(str, str2, map);
    }

    public static void registerEvent(String str, String str2, ITUINotification iTUINotification) {
        EventManager.getInstance().registerEvent(str, str2, iTUINotification);
    }

    public static void registerExtension(String str, ITUIExtension iTUIExtension) {
        ExtensionManager.getInstance().registerExtension(str, iTUIExtension);
    }

    public static void registerService(String str, ITUIService iTUIService) {
        ServiceManager.getInstance().registerService(str, iTUIService);
    }

    public static void startActivity(String str, Bundle bundle) {
        startActivity(null, str, bundle, -1);
    }

    public static void unRegisterEvent(String str, String str2, ITUINotification iTUINotification) {
        EventManager.getInstance().unRegisterEvent(str, str2, iTUINotification);
    }

    public static void unRegisterExtension(String str, ITUIExtension iTUIExtension) {
        ExtensionManager.getInstance().unRegisterExtension(str, iTUIExtension);
    }

    public static void unregisterService(String str) {
        ServiceManager.getInstance().unregisterService(str);
    }

    public static void startActivity(Object obj, String str, Bundle bundle) {
        startActivity(obj, str, bundle, -1);
    }

    public static void unRegisterEvent(ITUINotification iTUINotification) {
        EventManager.getInstance().unRegisterEvent(iTUINotification);
    }

    public static void startActivity(Object obj, String str, Bundle bundle, int i) {
        TUIRouter.Navigation putExtras = TUIRouter.getInstance().setDestination(str).putExtras(bundle);
        if (obj instanceof Fragment) {
            putExtras.navigate((Fragment) obj, i);
        } else if (obj instanceof Context) {
            putExtras.navigate((Context) obj, i);
        } else {
            putExtras.navigate((Context) null, i);
        }
    }
}
