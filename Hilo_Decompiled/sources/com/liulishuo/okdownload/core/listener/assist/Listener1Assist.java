package com.liulishuo.okdownload.core.listener.assist;

import com.liulishuo.okdownload.DownloadTask;
import com.liulishuo.okdownload.core.breakpoint.BreakpointInfo;
import com.liulishuo.okdownload.core.cause.EndCause;
import com.liulishuo.okdownload.core.cause.ResumeFailedCause;
import com.liulishuo.okdownload.core.listener.assist.ListenerModelHandler;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class Listener1Assist implements ListenerAssist, ListenerModelHandler.ModelCreator<Listener1Model> {
    private Listener1Callback callback;
    private final ListenerModelHandler<Listener1Model> modelHandler;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface Listener1Callback {
        void connected(DownloadTask downloadTask, int i10, long j10, long j11);

        void progress(DownloadTask downloadTask, long j10, long j11);

        void retry(DownloadTask downloadTask, ResumeFailedCause resumeFailedCause);

        void taskEnd(DownloadTask downloadTask, EndCause endCause, Exception exc, Listener1Model listener1Model);

        void taskStart(DownloadTask downloadTask, Listener1Model listener1Model);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class Listener1Model implements ListenerModelHandler.ListenerModel {
        int blockCount;
        final AtomicLong currentOffset = new AtomicLong();
        final int id;
        volatile Boolean isFirstConnect;
        Boolean isFromResumed;
        Boolean isStarted;
        long totalLength;

        public Listener1Model(int i10) {
            this.id = i10;
        }

        @Override // com.liulishuo.okdownload.core.listener.assist.ListenerModelHandler.ListenerModel
        public int getId() {
            return this.id;
        }

        public long getTotalLength() {
            return this.totalLength;
        }

        @Override // com.liulishuo.okdownload.core.listener.assist.ListenerModelHandler.ListenerModel
        public void onInfoValid(BreakpointInfo breakpointInfo) {
            boolean z10;
            this.blockCount = breakpointInfo.getBlockCount();
            this.totalLength = breakpointInfo.getTotalLength();
            this.currentOffset.set(breakpointInfo.getTotalOffset());
            if (this.isStarted == null) {
                this.isStarted = Boolean.FALSE;
            }
            if (this.isFromResumed == null) {
                if (this.currentOffset.get() > 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                this.isFromResumed = Boolean.valueOf(z10);
            }
            if (this.isFirstConnect == null) {
                this.isFirstConnect = Boolean.TRUE;
            }
        }
    }

    public Listener1Assist() {
        this.modelHandler = new ListenerModelHandler<>(this);
    }

    public void connectEnd(DownloadTask downloadTask) {
        Listener1Model orRecoverModel = this.modelHandler.getOrRecoverModel(downloadTask, downloadTask.getInfo());
        if (orRecoverModel == null) {
            return;
        }
        Boolean bool = Boolean.TRUE;
        if (bool.equals(orRecoverModel.isFromResumed) && bool.equals(orRecoverModel.isFirstConnect)) {
            orRecoverModel.isFirstConnect = Boolean.FALSE;
        }
        Listener1Callback listener1Callback = this.callback;
        if (listener1Callback != null) {
            listener1Callback.connected(downloadTask, orRecoverModel.blockCount, orRecoverModel.currentOffset.get(), orRecoverModel.totalLength);
        }
    }

    public void downloadFromBeginning(DownloadTask downloadTask, BreakpointInfo breakpointInfo, ResumeFailedCause resumeFailedCause) {
        Listener1Callback listener1Callback;
        Listener1Model orRecoverModel = this.modelHandler.getOrRecoverModel(downloadTask, breakpointInfo);
        if (orRecoverModel == null) {
            return;
        }
        orRecoverModel.onInfoValid(breakpointInfo);
        if (orRecoverModel.isStarted.booleanValue() && (listener1Callback = this.callback) != null) {
            listener1Callback.retry(downloadTask, resumeFailedCause);
        }
        Boolean bool = Boolean.TRUE;
        orRecoverModel.isStarted = bool;
        orRecoverModel.isFromResumed = Boolean.FALSE;
        orRecoverModel.isFirstConnect = bool;
    }

    public void downloadFromBreakpoint(DownloadTask downloadTask, BreakpointInfo breakpointInfo) {
        Listener1Model orRecoverModel = this.modelHandler.getOrRecoverModel(downloadTask, breakpointInfo);
        if (orRecoverModel == null) {
            return;
        }
        orRecoverModel.onInfoValid(breakpointInfo);
        Boolean bool = Boolean.TRUE;
        orRecoverModel.isStarted = bool;
        orRecoverModel.isFromResumed = bool;
        orRecoverModel.isFirstConnect = bool;
    }

    public void fetchProgress(DownloadTask downloadTask, long j10) {
        Listener1Model orRecoverModel = this.modelHandler.getOrRecoverModel(downloadTask, downloadTask.getInfo());
        if (orRecoverModel == null) {
            return;
        }
        orRecoverModel.currentOffset.addAndGet(j10);
        Listener1Callback listener1Callback = this.callback;
        if (listener1Callback != null) {
            listener1Callback.progress(downloadTask, orRecoverModel.currentOffset.get(), orRecoverModel.totalLength);
        }
    }

    @Override // com.liulishuo.okdownload.core.listener.assist.ListenerAssist
    public boolean isAlwaysRecoverAssistModel() {
        return this.modelHandler.isAlwaysRecoverAssistModel();
    }

    @Override // com.liulishuo.okdownload.core.listener.assist.ListenerAssist
    public void setAlwaysRecoverAssistModel(boolean z10) {
        this.modelHandler.setAlwaysRecoverAssistModel(z10);
    }

    @Override // com.liulishuo.okdownload.core.listener.assist.ListenerAssist
    public void setAlwaysRecoverAssistModelIfNotSet(boolean z10) {
        this.modelHandler.setAlwaysRecoverAssistModelIfNotSet(z10);
    }

    public void setCallback(Listener1Callback listener1Callback) {
        this.callback = listener1Callback;
    }

    public void taskEnd(DownloadTask downloadTask, EndCause endCause, Exception exc) {
        Listener1Model removeOrCreate = this.modelHandler.removeOrCreate(downloadTask, downloadTask.getInfo());
        Listener1Callback listener1Callback = this.callback;
        if (listener1Callback != null) {
            listener1Callback.taskEnd(downloadTask, endCause, exc, removeOrCreate);
        }
    }

    public void taskStart(DownloadTask downloadTask) {
        Listener1Model addAndGetModel = this.modelHandler.addAndGetModel(downloadTask, null);
        Listener1Callback listener1Callback = this.callback;
        if (listener1Callback != null) {
            listener1Callback.taskStart(downloadTask, addAndGetModel);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.liulishuo.okdownload.core.listener.assist.ListenerModelHandler.ModelCreator
    public Listener1Model create(int i10) {
        return new Listener1Model(i10);
    }

    public Listener1Assist(ListenerModelHandler<Listener1Model> listenerModelHandler) {
        this.modelHandler = listenerModelHandler;
    }
}
