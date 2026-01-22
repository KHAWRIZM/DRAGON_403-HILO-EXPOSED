package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class TransferStatusUpdater {
    private static TransferDBUtil dbUtil;
    private static TransferStatusUpdater transferStatusUpdater;
    private final Handler mainHandler;
    private final Map<Integer, TransferRecord> transfers;
    private static final Log LOGGER = LogFactory.getLog(TransferStatusUpdater.class);
    private static final HashSet<TransferState> STATES_NOT_TO_NOTIFY = new HashSet<>(Arrays.asList(TransferState.PART_COMPLETED, TransferState.PENDING_CANCEL, TransferState.PENDING_PAUSE, TransferState.PENDING_NETWORK_DISCONNECT));
    static final Map<Integer, List<TransferListener>> LISTENERS = new ConcurrentHashMap<Integer, List<TransferListener>>() { // from class: com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater.1
    };

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private class TransferProgressListener implements ProgressListener {
        private long bytesTransferredSoFar;
        private final TransferRecord transfer;

        public TransferProgressListener(TransferRecord transferRecord) {
            this.transfer = transferRecord;
        }

        @Override // com.amazonaws.event.ProgressListener
        public synchronized void progressChanged(ProgressEvent progressEvent) {
            try {
                if (32 == progressEvent.getEventCode()) {
                    TransferStatusUpdater.LOGGER.info("Reset Event triggered. Resetting the bytesCurrent to 0.");
                    this.bytesTransferredSoFar = 0L;
                } else {
                    long bytesTransferred = this.bytesTransferredSoFar + progressEvent.getBytesTransferred();
                    this.bytesTransferredSoFar = bytesTransferred;
                    TransferRecord transferRecord = this.transfer;
                    if (bytesTransferred > transferRecord.bytesCurrent) {
                        transferRecord.bytesCurrent = bytesTransferred;
                        TransferStatusUpdater.this.updateProgress(transferRecord.id, bytesTransferred, transferRecord.bytesTotal, true);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    TransferStatusUpdater(TransferDBUtil transferDBUtil) {
        dbUtil = transferDBUtil;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.transfers = new ConcurrentHashMap();
    }

    public static synchronized TransferStatusUpdater getInstance(Context context) {
        TransferStatusUpdater transferStatusUpdater2;
        synchronized (TransferStatusUpdater.class) {
            try {
                if (transferStatusUpdater == null) {
                    TransferDBUtil transferDBUtil = new TransferDBUtil(context);
                    dbUtil = transferDBUtil;
                    transferStatusUpdater = new TransferStatusUpdater(transferDBUtil);
                }
                transferStatusUpdater2 = transferStatusUpdater;
            } catch (Throwable th) {
                throw th;
            }
        }
        return transferStatusUpdater2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void registerListener(int i10, TransferListener transferListener) {
        if (transferListener != null) {
            Map<Integer, List<TransferListener>> map = LISTENERS;
            synchronized (map) {
                try {
                    List<TransferListener> list = map.get(Integer.valueOf(i10));
                    if (list == null) {
                        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                        copyOnWriteArrayList.add(transferListener);
                        map.put(Integer.valueOf(i10), copyOnWriteArrayList);
                    } else if (!list.contains(transferListener)) {
                        list.add(transferListener);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        throw new IllegalArgumentException("Listener can't be null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void unregisterListener(int i10, TransferListener transferListener) {
        if (transferListener != null) {
            Map<Integer, List<TransferListener>> map = LISTENERS;
            synchronized (map) {
                try {
                    List<TransferListener> list = map.get(Integer.valueOf(i10));
                    if (list != null && !list.isEmpty()) {
                        list.remove(transferListener);
                        return;
                    }
                    return;
                } finally {
                }
            }
        }
        throw new IllegalArgumentException("Listener can't be null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void addTransfer(TransferRecord transferRecord) {
        this.transfers.put(Integer.valueOf(transferRecord.id), transferRecord);
    }

    synchronized void clear() {
        Map<Integer, List<TransferListener>> map = LISTENERS;
        synchronized (map) {
            map.clear();
        }
        this.transfers.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized TransferRecord getTransfer(int i10) {
        return this.transfers.get(Integer.valueOf(i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Map<Integer, TransferRecord> getTransfers() {
        return Collections.unmodifiableMap(this.transfers);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized ProgressListener newProgressListener(int i10) {
        TransferRecord transfer;
        transfer = getTransfer(i10);
        if (transfer != null) {
            LOGGER.info("Creating a new progress listener for transfer: " + i10);
        } else {
            LOGGER.info("TransferStatusUpdater doesn't track the transfer: " + i10);
            throw new IllegalArgumentException("transfer " + i10 + " doesn't exist");
        }
        return new TransferProgressListener(transfer);
    }

    synchronized void removeTransfer(int i10) {
        Map<Integer, List<TransferListener>> map = LISTENERS;
        synchronized (map) {
            map.remove(Integer.valueOf(i10));
        }
        this.transfers.remove(Integer.valueOf(i10));
    }

    synchronized void removeTransferRecordFromDB(int i10) {
        S3ClientReference.remove(Integer.valueOf(i10));
        dbUtil.deleteTransferRecords(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void throwError(final int i10, final Exception exc) {
        Map<Integer, List<TransferListener>> map = LISTENERS;
        synchronized (map) {
            try {
                List<TransferListener> list = map.get(Integer.valueOf(i10));
                if (list != null && !list.isEmpty()) {
                    for (final TransferListener transferListener : list) {
                        this.mainHandler.post(new Runnable() { // from class: com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater.4
                            @Override // java.lang.Runnable
                            public void run() {
                                transferListener.onError(i10, exc);
                            }
                        });
                    }
                }
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void updateProgress(final int i10, final long j10, final long j11, boolean z10) {
        try {
            TransferRecord transferRecord = this.transfers.get(Integer.valueOf(i10));
            if (transferRecord != null) {
                transferRecord.bytesCurrent = j10;
                transferRecord.bytesTotal = j11;
            }
            dbUtil.updateBytesTransferred(i10, j10);
            if (!z10) {
                return;
            }
            Map<Integer, List<TransferListener>> map = LISTENERS;
            synchronized (map) {
                try {
                    List<TransferListener> list = map.get(Integer.valueOf(i10));
                    if (list != null && !list.isEmpty()) {
                        for (Iterator<TransferListener> it = list.iterator(); it.hasNext(); it = it) {
                            final TransferListener next = it.next();
                            this.mainHandler.post(new Runnable() { // from class: com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    next.onProgressChanged(i10, j10, j11);
                                }
                            });
                        }
                    }
                } finally {
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void updateState(final int i10, final TransferState transferState) {
        try {
            boolean contains = STATES_NOT_TO_NOTIFY.contains(transferState);
            TransferRecord transferRecord = this.transfers.get(Integer.valueOf(i10));
            if (transferRecord == null) {
                if (dbUtil.updateState(i10, transferState) == 0) {
                    LOGGER.warn("Failed to update the status of transfer " + i10);
                }
            } else {
                contains |= transferState.equals(transferRecord.state);
                transferRecord.state = transferState;
                if (dbUtil.updateTransferRecord(transferRecord) == 0) {
                    LOGGER.warn("Failed to update the status of transfer " + i10);
                }
            }
            if (contains) {
                return;
            }
            if (TransferState.COMPLETED.equals(transferState)) {
                removeTransferRecordFromDB(i10);
            }
            Map<Integer, List<TransferListener>> map = LISTENERS;
            synchronized (map) {
                try {
                    List<TransferListener> list = map.get(Integer.valueOf(i10));
                    if (list != null && !list.isEmpty()) {
                        for (final TransferListener transferListener : list) {
                            this.mainHandler.post(new Runnable() { // from class: com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    transferListener.onStateChanged(i10, transferState);
                                }
                            });
                        }
                        if (TransferState.COMPLETED.equals(transferState) || TransferState.FAILED.equals(transferState) || TransferState.CANCELED.equals(transferState)) {
                            list.clear();
                        }
                    }
                } finally {
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
