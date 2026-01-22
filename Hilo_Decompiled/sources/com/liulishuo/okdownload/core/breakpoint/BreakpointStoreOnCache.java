package com.liulishuo.okdownload.core.breakpoint;

import android.util.SparseArray;
import com.liulishuo.okdownload.DownloadTask;
import com.liulishuo.okdownload.core.IdentifiedTask;
import com.liulishuo.okdownload.core.cause.EndCause;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class BreakpointStoreOnCache implements DownloadStore {
    public static final int FIRST_ID = 1;
    private final List<Integer> fileDirtyList;
    private final KeyToIdMap keyToIdMap;
    private final HashMap<String, String> responseFilenameMap;
    private final List<Integer> sortedOccupiedIds;
    private final SparseArray<BreakpointInfo> storedInfos;
    private final SparseArray<IdentifiedTask> unStoredTasks;

    public BreakpointStoreOnCache() {
        this(new SparseArray(), new ArrayList(), new HashMap());
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
    
        r1 = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized int allocateId() {
        int i10;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            try {
                i10 = 1;
                if (i12 >= this.sortedOccupiedIds.size()) {
                    break;
                }
                Integer num = this.sortedOccupiedIds.get(i12);
                if (num == null) {
                    i11 = i13 + 1;
                    break;
                }
                int intValue = num.intValue();
                if (i13 == 0) {
                    if (intValue != 1) {
                        i11 = 1;
                        break;
                    }
                } else {
                    int i14 = i13 + 1;
                    if (intValue != i14) {
                        i11 = i14;
                        break;
                    }
                }
                i12++;
                i13 = intValue;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (i11 == 0) {
            if (!this.sortedOccupiedIds.isEmpty()) {
                List<Integer> list = this.sortedOccupiedIds;
                i10 = 1 + list.get(list.size() - 1).intValue();
                i12 = this.sortedOccupiedIds.size();
            }
        } else {
            i10 = i11;
        }
        this.sortedOccupiedIds.add(i12, Integer.valueOf(i10));
        return i10;
    }

    @Override // com.liulishuo.okdownload.core.breakpoint.BreakpointStore
    public BreakpointInfo createAndInsert(DownloadTask downloadTask) {
        int id = downloadTask.getId();
        BreakpointInfo breakpointInfo = new BreakpointInfo(id, downloadTask.getUrl(), downloadTask.getParentFile(), downloadTask.getFilename());
        synchronized (this) {
            this.storedInfos.put(id, breakpointInfo);
            this.unStoredTasks.remove(id);
        }
        return breakpointInfo;
    }

    @Override // com.liulishuo.okdownload.core.breakpoint.BreakpointStore
    public BreakpointInfo findAnotherInfoFromCompare(DownloadTask downloadTask, BreakpointInfo breakpointInfo) {
        SparseArray<BreakpointInfo> clone;
        synchronized (this) {
            clone = this.storedInfos.clone();
        }
        int size = clone.size();
        for (int i10 = 0; i10 < size; i10++) {
            BreakpointInfo valueAt = clone.valueAt(i10);
            if (valueAt != breakpointInfo && valueAt.isSameFrom(downloadTask)) {
                return valueAt;
            }
        }
        return null;
    }

    @Override // com.liulishuo.okdownload.core.breakpoint.BreakpointStore
    public synchronized int findOrCreateId(DownloadTask downloadTask) {
        Integer num = this.keyToIdMap.get(downloadTask);
        if (num != null) {
            return num.intValue();
        }
        int size = this.storedInfos.size();
        for (int i10 = 0; i10 < size; i10++) {
            BreakpointInfo valueAt = this.storedInfos.valueAt(i10);
            if (valueAt != null && valueAt.isSameFrom(downloadTask)) {
                return valueAt.id;
            }
        }
        int size2 = this.unStoredTasks.size();
        for (int i11 = 0; i11 < size2; i11++) {
            IdentifiedTask valueAt2 = this.unStoredTasks.valueAt(i11);
            if (valueAt2 != null && valueAt2.compareIgnoreId(downloadTask)) {
                return valueAt2.getId();
            }
        }
        int allocateId = allocateId();
        this.unStoredTasks.put(allocateId, downloadTask.mock(allocateId));
        this.keyToIdMap.add(downloadTask, allocateId);
        return allocateId;
    }

    @Override // com.liulishuo.okdownload.core.breakpoint.BreakpointStore
    public BreakpointInfo get(int i10) {
        return this.storedInfos.get(i10);
    }

    @Override // com.liulishuo.okdownload.core.breakpoint.DownloadStore
    public BreakpointInfo getAfterCompleted(int i10) {
        return null;
    }

    @Override // com.liulishuo.okdownload.core.breakpoint.BreakpointStore
    public String getResponseFilename(String str) {
        return this.responseFilenameMap.get(str);
    }

    @Override // com.liulishuo.okdownload.core.breakpoint.BreakpointStore
    public boolean isFileDirty(int i10) {
        return this.fileDirtyList.contains(Integer.valueOf(i10));
    }

    @Override // com.liulishuo.okdownload.core.breakpoint.BreakpointStore
    public boolean isOnlyMemoryCache() {
        return true;
    }

    @Override // com.liulishuo.okdownload.core.breakpoint.DownloadStore
    public boolean markFileClear(int i10) {
        boolean remove;
        synchronized (this.fileDirtyList) {
            remove = this.fileDirtyList.remove(Integer.valueOf(i10));
        }
        return remove;
    }

    @Override // com.liulishuo.okdownload.core.breakpoint.DownloadStore
    public boolean markFileDirty(int i10) {
        if (!this.fileDirtyList.contains(Integer.valueOf(i10))) {
            synchronized (this.fileDirtyList) {
                try {
                    if (!this.fileDirtyList.contains(Integer.valueOf(i10))) {
                        this.fileDirtyList.add(Integer.valueOf(i10));
                        return true;
                    }
                    return false;
                } finally {
                }
            }
        }
        return false;
    }

    @Override // com.liulishuo.okdownload.core.breakpoint.DownloadStore
    public void onSyncToFilesystemSuccess(BreakpointInfo breakpointInfo, int i10, long j10) {
        BreakpointInfo breakpointInfo2 = this.storedInfos.get(breakpointInfo.id);
        if (breakpointInfo == breakpointInfo2) {
            breakpointInfo2.getBlock(i10).increaseCurrentOffset(j10);
            return;
        }
        throw new IOException("Info not on store!");
    }

    @Override // com.liulishuo.okdownload.core.breakpoint.DownloadStore
    public void onTaskEnd(int i10, EndCause endCause, Exception exc) {
        if (endCause == EndCause.COMPLETED) {
            remove(i10);
        }
    }

    @Override // com.liulishuo.okdownload.core.breakpoint.DownloadStore
    public void onTaskStart(int i10) {
    }

    @Override // com.liulishuo.okdownload.core.breakpoint.BreakpointStore
    public synchronized void remove(int i10) {
        try {
            this.storedInfos.remove(i10);
            if (this.unStoredTasks.get(i10) == null) {
                this.sortedOccupiedIds.remove(Integer.valueOf(i10));
            }
            this.keyToIdMap.remove(i10);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.liulishuo.okdownload.core.breakpoint.BreakpointStore
    public boolean update(BreakpointInfo breakpointInfo) {
        String filename = breakpointInfo.getFilename();
        if (breakpointInfo.isTaskOnlyProvidedParentPath() && filename != null) {
            this.responseFilenameMap.put(breakpointInfo.getUrl(), filename);
        }
        BreakpointInfo breakpointInfo2 = this.storedInfos.get(breakpointInfo.id);
        if (breakpointInfo2 != null) {
            if (breakpointInfo2 == breakpointInfo) {
                return true;
            }
            synchronized (this) {
                this.storedInfos.put(breakpointInfo.id, breakpointInfo.copy());
            }
            return true;
        }
        return false;
    }

    public BreakpointStoreOnCache(SparseArray<BreakpointInfo> sparseArray, List<Integer> list, HashMap<String, String> hashMap, SparseArray<IdentifiedTask> sparseArray2, List<Integer> list2, KeyToIdMap keyToIdMap) {
        this.unStoredTasks = sparseArray2;
        this.fileDirtyList = list;
        this.storedInfos = sparseArray;
        this.responseFilenameMap = hashMap;
        this.sortedOccupiedIds = list2;
        this.keyToIdMap = keyToIdMap;
    }

    public BreakpointStoreOnCache(SparseArray<BreakpointInfo> sparseArray, List<Integer> list, HashMap<String, String> hashMap) {
        this.unStoredTasks = new SparseArray<>();
        this.storedInfos = sparseArray;
        this.fileDirtyList = list;
        this.responseFilenameMap = hashMap;
        this.keyToIdMap = new KeyToIdMap();
        int size = sparseArray.size();
        this.sortedOccupiedIds = new ArrayList(size);
        for (int i10 = 0; i10 < size; i10++) {
            this.sortedOccupiedIds.add(Integer.valueOf(sparseArray.valueAt(i10).id));
        }
        Collections.sort(this.sortedOccupiedIds);
    }
}
