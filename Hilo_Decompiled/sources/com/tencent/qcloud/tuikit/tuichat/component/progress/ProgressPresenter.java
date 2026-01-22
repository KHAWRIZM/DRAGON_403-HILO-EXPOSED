package com.tencent.qcloud.tuikit.tuichat.component.progress;

import android.text.TextUtils;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ProgressPresenter {
    private static final String TAG = "ProgressPresenter";
    private final Map<String, List<WeakReference<ProgressListener>>> progressListenerMap;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface ProgressListener {
        void onProgress(int i);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    private static final class ProgressPresenterHolder {
        private static final ProgressPresenter instance = new ProgressPresenter();

        private ProgressPresenterHolder() {
        }
    }

    public static ProgressPresenter getInstance() {
        return ProgressPresenterHolder.instance;
    }

    public void registerProgressListener(String str, ProgressListener progressListener) {
        Log.i(TAG, "registerProgressListener id : " + str + ", listener : " + progressListener);
        if (!TextUtils.isEmpty(str) && progressListener != null) {
            List<WeakReference<ProgressListener>> list = this.progressListenerMap.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList<>();
                this.progressListenerMap.put(str, list);
            }
            list.add(new WeakReference<>(progressListener));
        }
    }

    public void unregisterProgressListener(String str, ProgressListener progressListener) {
        List<WeakReference<ProgressListener>> list;
        WeakReference<ProgressListener> weakReference;
        Log.i(TAG, "unregisterProgressListener id : " + str + ", listener : " + progressListener);
        if (TextUtils.isEmpty(str) || progressListener == null || (list = this.progressListenerMap.get(str)) != null) {
            return;
        }
        Iterator<WeakReference<ProgressListener>> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                weakReference = it.next();
                if (weakReference.get() == progressListener) {
                    break;
                }
            } else {
                weakReference = null;
                break;
            }
        }
        list.remove(weakReference);
    }

    public void updateProgress(String str, int i) {
        List<WeakReference<ProgressListener>> list = this.progressListenerMap.get(str);
        if (list != null && !list.isEmpty()) {
            ListIterator<WeakReference<ProgressListener>> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                ProgressListener progressListener = listIterator.next().get();
                if (progressListener != null) {
                    progressListener.onProgress(i);
                }
            }
            return;
        }
        this.progressListenerMap.remove(str);
    }

    private ProgressPresenter() {
        this.progressListenerMap = new ConcurrentHashMap();
    }
}
