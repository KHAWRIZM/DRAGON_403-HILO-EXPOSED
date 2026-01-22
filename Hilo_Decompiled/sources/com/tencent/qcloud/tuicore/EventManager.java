package com.tencent.qcloud.tuicore;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.tencent.qcloud.tuicore.interfaces.ITUINotification;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
class EventManager {
    private static final String TAG = "EventManager";
    private final Map<Pair<String, String>, List<ITUINotification>> eventMap;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    private static class EventManagerHolder {
        private static final EventManager eventManager = new EventManager();

        private EventManagerHolder() {
        }
    }

    public static EventManager getInstance() {
        return EventManagerHolder.eventManager;
    }

    public void notifyEvent(String str, String str2, Map<String, Object> map) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            List<ITUINotification> list = this.eventMap.get(new Pair(str, str2));
            if (list != null) {
                Iterator<ITUINotification> it = list.iterator();
                while (it.hasNext()) {
                    it.next().onNotifyEvent(str, str2, map);
                }
            }
        }
    }

    public void registerEvent(String str, String str2, ITUINotification iTUINotification) {
        Log.i(TAG, "registerEvent : key : " + str + ", subKey : " + str2 + ", notification : " + iTUINotification);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && iTUINotification != null) {
            Pair<String, String> pair = new Pair<>(str, str2);
            List<ITUINotification> list = this.eventMap.get(pair);
            if (list == null) {
                list = new CopyOnWriteArrayList<>();
                this.eventMap.put(pair, list);
            }
            if (!list.contains(iTUINotification)) {
                list.add(iTUINotification);
            }
        }
    }

    public void unRegisterEvent(String str, String str2, ITUINotification iTUINotification) {
        Log.i(TAG, "removeEvent : key : " + str + ", subKey : " + str2 + " notification : " + iTUINotification);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || iTUINotification == null) {
            return;
        }
        List<ITUINotification> list = this.eventMap.get(new Pair(str, str2));
        if (list == null) {
            return;
        }
        list.remove(iTUINotification);
    }

    private EventManager() {
        this.eventMap = new ConcurrentHashMap();
    }

    public void unRegisterEvent(ITUINotification iTUINotification) {
        Log.i(TAG, "removeEvent : notification : " + iTUINotification);
        if (iTUINotification == null) {
            return;
        }
        Iterator<Pair<String, String>> it = this.eventMap.keySet().iterator();
        while (it.hasNext()) {
            List<ITUINotification> list = this.eventMap.get(it.next());
            if (list != null) {
                Iterator<ITUINotification> it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    ITUINotification next = it2.next();
                    if (next == iTUINotification) {
                        list.remove(next);
                        break;
                    }
                }
            }
        }
    }
}
