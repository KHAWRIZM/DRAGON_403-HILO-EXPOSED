package com.amazonaws.mobileconnectors.s3.transfermanager.internal;

import com.amazonaws.event.ProgressListenerChain;
import com.amazonaws.mobileconnectors.s3.transfermanager.Transfer;
import com.amazonaws.mobileconnectors.s3.transfermanager.TransferProgress;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class MultipleFileTransfer<T extends Transfer> extends AbstractTransfer {
    private AtomicBoolean subTransferStarted;
    protected final Collection<? extends T> subTransfers;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amazonaws.mobileconnectors.s3.transfermanager.internal.MultipleFileTransfer$1, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$amazonaws$mobileconnectors$s3$transfermanager$Transfer$TransferState;

        static {
            int[] iArr = new int[Transfer.TransferState.values().length];
            $SwitchMap$com$amazonaws$mobileconnectors$s3$transfermanager$Transfer$TransferState = iArr;
            try {
                iArr[Transfer.TransferState.Waiting.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$amazonaws$mobileconnectors$s3$transfermanager$Transfer$TransferState[Transfer.TransferState.InProgress.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$amazonaws$mobileconnectors$s3$transfermanager$Transfer$TransferState[Transfer.TransferState.Completed.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$amazonaws$mobileconnectors$s3$transfermanager$Transfer$TransferState[Transfer.TransferState.Canceled.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$amazonaws$mobileconnectors$s3$transfermanager$Transfer$TransferState[Transfer.TransferState.Failed.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MultipleFileTransfer(String str, TransferProgress transferProgress, ProgressListenerChain progressListenerChain, Collection<? extends T> collection) {
        super(str, transferProgress, progressListenerChain);
        this.subTransferStarted = new AtomicBoolean(false);
        this.subTransfers = collection;
    }

    public void collateFinalState() {
        boolean z10 = false;
        for (T t10 : this.subTransfers) {
            Transfer.TransferState state = t10.getState();
            Transfer.TransferState transferState = Transfer.TransferState.Failed;
            if (state == transferState) {
                setState(transferState);
                return;
            } else if (t10.getState() == Transfer.TransferState.Canceled) {
                z10 = true;
            }
        }
        if (z10) {
            setState(Transfer.TransferState.Canceled);
        } else {
            setState(Transfer.TransferState.Completed);
        }
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.internal.AbstractTransfer
    public void setState(Transfer.TransferState transferState) {
        super.setState(transferState);
        int i10 = AnonymousClass1.$SwitchMap$com$amazonaws$mobileconnectors$s3$transfermanager$Transfer$TransferState[transferState.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 4) {
                        if (i10 == 5) {
                            fireProgressEvent(8);
                            return;
                        }
                        return;
                    }
                    fireProgressEvent(16);
                    return;
                }
                fireProgressEvent(4);
                return;
            }
            if (this.subTransferStarted.compareAndSet(false, true)) {
                fireProgressEvent(2);
                return;
            }
            return;
        }
        fireProgressEvent(1);
    }
}
