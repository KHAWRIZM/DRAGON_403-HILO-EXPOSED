package com.liulishuo.okdownload.core.breakpoint;

import com.liulishuo.okdownload.core.breakpoint.RemitSyncExecutor;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
class RemitSyncToDBHelper {
    long delayMillis;
    private final RemitSyncExecutor executor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RemitSyncToDBHelper(RemitSyncExecutor.RemitAgent remitAgent) {
        this(new RemitSyncExecutor(remitAgent));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void discard(int i10) {
        this.executor.removePostWithId(i10);
        this.executor.postRemoveInfo(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void endAndEnsureToDB(int i10) {
        this.executor.removePostWithId(i10);
        try {
            if (this.executor.isFreeToDatabase(i10)) {
                return;
            }
            this.executor.postSync(i10);
        } finally {
            this.executor.postRemoveFreeId(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isNotFreeToDatabase(int i10) {
        return !this.executor.isFreeToDatabase(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onTaskStart(int i10) {
        this.executor.removePostWithId(i10);
        this.executor.postSyncInfoDelay(i10, this.delayMillis);
    }

    void shutdown() {
        this.executor.shutdown();
    }

    RemitSyncToDBHelper(RemitSyncExecutor remitSyncExecutor) {
        this.executor = remitSyncExecutor;
        this.delayMillis = 1500L;
    }
}
