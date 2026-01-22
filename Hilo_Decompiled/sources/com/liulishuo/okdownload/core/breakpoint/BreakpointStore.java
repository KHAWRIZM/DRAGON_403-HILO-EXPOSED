package com.liulishuo.okdownload.core.breakpoint;

import com.liulishuo.okdownload.DownloadTask;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface BreakpointStore {
    BreakpointInfo createAndInsert(DownloadTask downloadTask);

    BreakpointInfo findAnotherInfoFromCompare(DownloadTask downloadTask, BreakpointInfo breakpointInfo);

    int findOrCreateId(DownloadTask downloadTask);

    BreakpointInfo get(int i10);

    String getResponseFilename(String str);

    boolean isFileDirty(int i10);

    boolean isOnlyMemoryCache();

    void remove(int i10);

    boolean update(BreakpointInfo breakpointInfo);
}
