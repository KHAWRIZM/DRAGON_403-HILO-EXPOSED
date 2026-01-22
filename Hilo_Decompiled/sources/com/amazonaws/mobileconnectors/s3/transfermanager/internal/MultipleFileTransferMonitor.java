package com.amazonaws.mobileconnectors.s3.transfermanager.internal;

import com.amazonaws.mobileconnectors.s3.transfermanager.Transfer;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class MultipleFileTransferMonitor implements TransferMonitor {
    private final Future<?> future = new Future<Object>() { // from class: com.amazonaws.mobileconnectors.s3.transfermanager.internal.MultipleFileTransferMonitor.1
        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z10) {
            return true;
        }

        @Override // java.util.concurrent.Future
        public Object get() throws InterruptedException, ExecutionException {
            Iterator it = MultipleFileTransferMonitor.this.subTransfers.iterator();
            Object obj = null;
            while (it.hasNext()) {
                obj = ((AbstractTransfer) it.next()).getMonitor().getFuture().get();
            }
            return obj;
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            if (MultipleFileTransferMonitor.this.transfer.getState() == Transfer.TransferState.Canceled) {
                return true;
            }
            return false;
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return MultipleFileTransferMonitor.this.isDone();
        }

        @Override // java.util.concurrent.Future
        public Object get(long j10, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            Iterator it = MultipleFileTransferMonitor.this.subTransfers.iterator();
            Object obj = null;
            while (it.hasNext()) {
                obj = ((AbstractTransfer) it.next()).getMonitor().getFuture().get(j10, timeUnit);
            }
            return obj;
        }
    };
    private final Collection<? extends AbstractTransfer> subTransfers;
    private final AbstractTransfer transfer;

    public MultipleFileTransferMonitor(AbstractTransfer abstractTransfer, Collection<? extends AbstractTransfer> collection) {
        this.subTransfers = collection;
        this.transfer = abstractTransfer;
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.internal.TransferMonitor
    public Future<?> getFuture() {
        return this.future;
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.internal.TransferMonitor
    public synchronized boolean isDone() {
        Iterator<? extends AbstractTransfer> it = this.subTransfers.iterator();
        while (it.hasNext()) {
            if (!it.next().isDone()) {
                return false;
            }
        }
        return true;
    }
}
