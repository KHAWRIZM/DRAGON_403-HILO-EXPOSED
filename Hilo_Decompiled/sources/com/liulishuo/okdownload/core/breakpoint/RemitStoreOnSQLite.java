package com.liulishuo.okdownload.core.breakpoint;

import android.database.sqlite.SQLiteDatabase;
import com.liulishuo.okdownload.DownloadTask;
import com.liulishuo.okdownload.OkDownload;
import com.liulishuo.okdownload.core.breakpoint.RemitSyncExecutor;
import com.liulishuo.okdownload.core.cause.EndCause;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class RemitStoreOnSQLite implements RemitSyncExecutor.RemitAgent, DownloadStore {
    private static final String TAG = "RemitStoreOnSQLite";
    private final BreakpointStoreOnSQLite onSQLiteWrapper;
    private final RemitSyncToDBHelper remitHelper;
    private final BreakpointSQLiteHelper sqLiteHelper;
    private final DownloadStore sqliteCache;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RemitStoreOnSQLite(BreakpointStoreOnSQLite breakpointStoreOnSQLite) {
        this.remitHelper = new RemitSyncToDBHelper(this);
        this.onSQLiteWrapper = breakpointStoreOnSQLite;
        this.sqliteCache = breakpointStoreOnSQLite.onCache;
        this.sqLiteHelper = breakpointStoreOnSQLite.helper;
    }

    public static void setRemitToDBDelayMillis(int i10) {
        BreakpointStore breakpointStore = OkDownload.with().breakpointStore();
        if (breakpointStore instanceof RemitStoreOnSQLite) {
            ((RemitStoreOnSQLite) breakpointStore).remitHelper.delayMillis = Math.max(0, i10);
        } else {
            throw new IllegalStateException("The current store is " + breakpointStore + " not RemitStoreOnSQLite!");
        }
    }

    @Override // com.liulishuo.okdownload.core.breakpoint.BreakpointStore
    public BreakpointInfo createAndInsert(DownloadTask downloadTask) throws IOException {
        if (this.remitHelper.isNotFreeToDatabase(downloadTask.getId())) {
            return this.sqliteCache.createAndInsert(downloadTask);
        }
        return this.onSQLiteWrapper.createAndInsert(downloadTask);
    }

    @Override // com.liulishuo.okdownload.core.breakpoint.BreakpointStore
    public BreakpointInfo findAnotherInfoFromCompare(DownloadTask downloadTask, BreakpointInfo breakpointInfo) {
        return this.onSQLiteWrapper.findAnotherInfoFromCompare(downloadTask, breakpointInfo);
    }

    @Override // com.liulishuo.okdownload.core.breakpoint.BreakpointStore
    public int findOrCreateId(DownloadTask downloadTask) {
        return this.onSQLiteWrapper.findOrCreateId(downloadTask);
    }

    @Override // com.liulishuo.okdownload.core.breakpoint.BreakpointStore
    public BreakpointInfo get(int i10) {
        return this.onSQLiteWrapper.get(i10);
    }

    @Override // com.liulishuo.okdownload.core.breakpoint.DownloadStore
    public BreakpointInfo getAfterCompleted(int i10) {
        return null;
    }

    @Override // com.liulishuo.okdownload.core.breakpoint.BreakpointStore
    public String getResponseFilename(String str) {
        return this.onSQLiteWrapper.getResponseFilename(str);
    }

    @Override // com.liulishuo.okdownload.core.breakpoint.BreakpointStore
    public boolean isFileDirty(int i10) {
        return this.onSQLiteWrapper.isFileDirty(i10);
    }

    @Override // com.liulishuo.okdownload.core.breakpoint.BreakpointStore
    public boolean isOnlyMemoryCache() {
        return false;
    }

    @Override // com.liulishuo.okdownload.core.breakpoint.DownloadStore
    public boolean markFileClear(int i10) {
        return this.onSQLiteWrapper.markFileClear(i10);
    }

    @Override // com.liulishuo.okdownload.core.breakpoint.DownloadStore
    public boolean markFileDirty(int i10) {
        return this.onSQLiteWrapper.markFileDirty(i10);
    }

    @Override // com.liulishuo.okdownload.core.breakpoint.DownloadStore
    public void onSyncToFilesystemSuccess(BreakpointInfo breakpointInfo, int i10, long j10) throws IOException {
        if (this.remitHelper.isNotFreeToDatabase(breakpointInfo.getId())) {
            this.sqliteCache.onSyncToFilesystemSuccess(breakpointInfo, i10, j10);
        } else {
            this.onSQLiteWrapper.onSyncToFilesystemSuccess(breakpointInfo, i10, j10);
        }
    }

    @Override // com.liulishuo.okdownload.core.breakpoint.DownloadStore
    public void onTaskEnd(int i10, EndCause endCause, Exception exc) {
        this.sqliteCache.onTaskEnd(i10, endCause, exc);
        if (endCause == EndCause.COMPLETED) {
            this.remitHelper.discard(i10);
        } else {
            this.remitHelper.endAndEnsureToDB(i10);
        }
    }

    @Override // com.liulishuo.okdownload.core.breakpoint.DownloadStore
    public void onTaskStart(int i10) {
        this.onSQLiteWrapper.onTaskStart(i10);
        this.remitHelper.onTaskStart(i10);
    }

    @Override // com.liulishuo.okdownload.core.breakpoint.BreakpointStore
    public void remove(int i10) {
        this.sqliteCache.remove(i10);
        this.remitHelper.discard(i10);
    }

    @Override // com.liulishuo.okdownload.core.breakpoint.RemitSyncExecutor.RemitAgent
    public void removeInfo(int i10) {
        this.sqLiteHelper.removeInfo(i10);
    }

    @Override // com.liulishuo.okdownload.core.breakpoint.RemitSyncExecutor.RemitAgent
    public void syncCacheToDB(List<Integer> list) throws IOException {
        SQLiteDatabase writableDatabase = this.sqLiteHelper.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                syncCacheToDB(it.next().intValue());
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (Throwable th) {
            writableDatabase.endTransaction();
            throw th;
        }
    }

    @Override // com.liulishuo.okdownload.core.breakpoint.BreakpointStore
    public boolean update(BreakpointInfo breakpointInfo) throws IOException {
        if (this.remitHelper.isNotFreeToDatabase(breakpointInfo.getId())) {
            return this.sqliteCache.update(breakpointInfo);
        }
        return this.onSQLiteWrapper.update(breakpointInfo);
    }

    RemitStoreOnSQLite(RemitSyncToDBHelper remitSyncToDBHelper, BreakpointStoreOnSQLite breakpointStoreOnSQLite, DownloadStore downloadStore, BreakpointSQLiteHelper breakpointSQLiteHelper) {
        this.remitHelper = remitSyncToDBHelper;
        this.onSQLiteWrapper = breakpointStoreOnSQLite;
        this.sqliteCache = downloadStore;
        this.sqLiteHelper = breakpointSQLiteHelper;
    }

    @Override // com.liulishuo.okdownload.core.breakpoint.RemitSyncExecutor.RemitAgent
    public void syncCacheToDB(int i10) throws IOException {
        this.sqLiteHelper.removeInfo(i10);
        BreakpointInfo breakpointInfo = this.sqliteCache.get(i10);
        if (breakpointInfo == null || breakpointInfo.getFilename() == null || breakpointInfo.getTotalOffset() <= 0) {
            return;
        }
        this.sqLiteHelper.insert(breakpointInfo);
    }
}
