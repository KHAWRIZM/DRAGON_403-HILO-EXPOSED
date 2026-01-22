package org.android.spdy;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
class ProtectedPointer {
    private static final long CLOSED = 3;
    private static final long INIT = 1;
    private static final long WAIT_CLOSE = 2;
    private Object data2protected;
    protected ProtectedPointerOnClose how2close;
    private AtomicLong referAndstatus = new AtomicLong(1);

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    interface ProtectedPointerOnClose {
        void close(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtectedPointer(Object obj) {
        this.data2protected = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean enter() {
        long j;
        do {
            j = this.referAndstatus.get();
            if (j == 3) {
                return false;
            }
        } while (!this.referAndstatus.compareAndSet(j, 16 + j));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void exit() {
        this.referAndstatus.addAndGet(-16L);
        if (this.referAndstatus.compareAndSet(2L, 3L)) {
            ProtectedPointerOnClose protectedPointerOnClose = this.how2close;
            if (protectedPointerOnClose != null) {
                protectedPointerOnClose.close(this.data2protected);
            }
            this.data2protected = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object getData() {
        return this.data2protected;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release() {
        this.referAndstatus.incrementAndGet();
        if (this.referAndstatus.compareAndSet(2L, 3L)) {
            ProtectedPointerOnClose protectedPointerOnClose = this.how2close;
            if (protectedPointerOnClose != null) {
                protectedPointerOnClose.close(this.data2protected);
            }
            this.data2protected = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setHow2close(ProtectedPointerOnClose protectedPointerOnClose) {
        this.how2close = protectedPointerOnClose;
    }
}
