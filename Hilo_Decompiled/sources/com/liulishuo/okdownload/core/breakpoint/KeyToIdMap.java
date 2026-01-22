package com.liulishuo.okdownload.core.breakpoint;

import android.util.SparseArray;
import com.liulishuo.okdownload.DownloadTask;
import java.util.HashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class KeyToIdMap {
    private final SparseArray<String> idToKeyMap;
    private final HashMap<String, Integer> keyToIdMap;

    public KeyToIdMap() {
        this(new HashMap(), new SparseArray());
    }

    public void add(DownloadTask downloadTask, int i10) {
        String generateKey = generateKey(downloadTask);
        this.keyToIdMap.put(generateKey, Integer.valueOf(i10));
        this.idToKeyMap.put(i10, generateKey);
    }

    public String generateKey(DownloadTask downloadTask) {
        return downloadTask.getUrl() + downloadTask.getUri() + downloadTask.getFilename();
    }

    public Integer get(DownloadTask downloadTask) {
        Integer num = this.keyToIdMap.get(generateKey(downloadTask));
        if (num != null) {
            return num;
        }
        return null;
    }

    public void remove(int i10) {
        String str = this.idToKeyMap.get(i10);
        if (str != null) {
            this.keyToIdMap.remove(str);
            this.idToKeyMap.remove(i10);
        }
    }

    public KeyToIdMap(HashMap<String, Integer> hashMap, SparseArray<String> sparseArray) {
        this.keyToIdMap = hashMap;
        this.idToKeyMap = sparseArray;
    }
}
