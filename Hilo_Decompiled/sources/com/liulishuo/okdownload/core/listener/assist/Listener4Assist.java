package com.liulishuo.okdownload.core.listener.assist;

import android.util.SparseArray;
import com.liulishuo.okdownload.DownloadTask;
import com.liulishuo.okdownload.core.breakpoint.BlockInfo;
import com.liulishuo.okdownload.core.breakpoint.BreakpointInfo;
import com.liulishuo.okdownload.core.cause.EndCause;
import com.liulishuo.okdownload.core.listener.assist.Listener4Assist.Listener4Model;
import com.liulishuo.okdownload.core.listener.assist.ListenerModelHandler;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class Listener4Assist<T extends Listener4Model> implements ListenerAssist {
    private AssistExtend assistExtend;
    Listener4Callback callback;
    private final ListenerModelHandler<T> modelHandler;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface AssistExtend {
        boolean dispatchBlockEnd(DownloadTask downloadTask, int i10, Listener4Model listener4Model);

        boolean dispatchFetchProgress(DownloadTask downloadTask, int i10, long j10, Listener4Model listener4Model);

        boolean dispatchInfoReady(DownloadTask downloadTask, BreakpointInfo breakpointInfo, boolean z10, Listener4Model listener4Model);

        boolean dispatchTaskEnd(DownloadTask downloadTask, EndCause endCause, Exception exc, Listener4Model listener4Model);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface Listener4Callback {
        void blockEnd(DownloadTask downloadTask, int i10, BlockInfo blockInfo);

        void infoReady(DownloadTask downloadTask, BreakpointInfo breakpointInfo, boolean z10, Listener4Model listener4Model);

        void progress(DownloadTask downloadTask, long j10);

        void progressBlock(DownloadTask downloadTask, int i10, long j10);

        void taskEnd(DownloadTask downloadTask, EndCause endCause, Exception exc, Listener4Model listener4Model);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class Listener4Model implements ListenerModelHandler.ListenerModel {
        SparseArray<Long> blockCurrentOffsetMap;
        long currentOffset;
        private final int id;
        BreakpointInfo info;

        public Listener4Model(int i10) {
            this.id = i10;
        }

        public SparseArray<Long> cloneBlockCurrentOffsetMap() {
            return this.blockCurrentOffsetMap.clone();
        }

        public long getBlockCurrentOffset(int i10) {
            return this.blockCurrentOffsetMap.get(i10).longValue();
        }

        public SparseArray<Long> getBlockCurrentOffsetMap() {
            return this.blockCurrentOffsetMap;
        }

        public long getCurrentOffset() {
            return this.currentOffset;
        }

        @Override // com.liulishuo.okdownload.core.listener.assist.ListenerModelHandler.ListenerModel
        public int getId() {
            return this.id;
        }

        public BreakpointInfo getInfo() {
            return this.info;
        }

        @Override // com.liulishuo.okdownload.core.listener.assist.ListenerModelHandler.ListenerModel
        public void onInfoValid(BreakpointInfo breakpointInfo) {
            this.info = breakpointInfo;
            this.currentOffset = breakpointInfo.getTotalOffset();
            SparseArray<Long> sparseArray = new SparseArray<>();
            int blockCount = breakpointInfo.getBlockCount();
            for (int i10 = 0; i10 < blockCount; i10++) {
                sparseArray.put(i10, Long.valueOf(breakpointInfo.getBlock(i10).getCurrentOffset()));
            }
            this.blockCurrentOffsetMap = sparseArray;
        }
    }

    public Listener4Assist(ListenerModelHandler<T> listenerModelHandler) {
        this.modelHandler = listenerModelHandler;
    }

    public void fetchEnd(DownloadTask downloadTask, int i10) {
        Listener4Callback listener4Callback;
        T orRecoverModel = this.modelHandler.getOrRecoverModel(downloadTask, downloadTask.getInfo());
        if (orRecoverModel == null) {
            return;
        }
        AssistExtend assistExtend = this.assistExtend;
        if ((assistExtend == null || !assistExtend.dispatchBlockEnd(downloadTask, i10, orRecoverModel)) && (listener4Callback = this.callback) != null) {
            listener4Callback.blockEnd(downloadTask, i10, orRecoverModel.info.getBlock(i10));
        }
    }

    public void fetchProgress(DownloadTask downloadTask, int i10, long j10) {
        Listener4Callback listener4Callback;
        T orRecoverModel = this.modelHandler.getOrRecoverModel(downloadTask, downloadTask.getInfo());
        if (orRecoverModel == null) {
            return;
        }
        long longValue = orRecoverModel.blockCurrentOffsetMap.get(i10).longValue() + j10;
        orRecoverModel.blockCurrentOffsetMap.put(i10, Long.valueOf(longValue));
        orRecoverModel.currentOffset += j10;
        AssistExtend assistExtend = this.assistExtend;
        if ((assistExtend == null || !assistExtend.dispatchFetchProgress(downloadTask, i10, j10, orRecoverModel)) && (listener4Callback = this.callback) != null) {
            listener4Callback.progressBlock(downloadTask, i10, longValue);
            this.callback.progress(downloadTask, orRecoverModel.currentOffset);
        }
    }

    public AssistExtend getAssistExtend() {
        return this.assistExtend;
    }

    public void infoReady(DownloadTask downloadTask, BreakpointInfo breakpointInfo, boolean z10) {
        Listener4Callback listener4Callback;
        T addAndGetModel = this.modelHandler.addAndGetModel(downloadTask, breakpointInfo);
        AssistExtend assistExtend = this.assistExtend;
        if ((assistExtend == null || !assistExtend.dispatchInfoReady(downloadTask, breakpointInfo, z10, addAndGetModel)) && (listener4Callback = this.callback) != null) {
            listener4Callback.infoReady(downloadTask, breakpointInfo, z10, addAndGetModel);
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

    public void setAssistExtend(AssistExtend assistExtend) {
        this.assistExtend = assistExtend;
    }

    public void setCallback(Listener4Callback listener4Callback) {
        this.callback = listener4Callback;
    }

    public synchronized void taskEnd(DownloadTask downloadTask, EndCause endCause, Exception exc) {
        T removeOrCreate = this.modelHandler.removeOrCreate(downloadTask, downloadTask.getInfo());
        AssistExtend assistExtend = this.assistExtend;
        if (assistExtend != null && assistExtend.dispatchTaskEnd(downloadTask, endCause, exc, removeOrCreate)) {
            return;
        }
        Listener4Callback listener4Callback = this.callback;
        if (listener4Callback != null) {
            listener4Callback.taskEnd(downloadTask, endCause, exc, removeOrCreate);
        }
    }

    public Listener4Assist(ListenerModelHandler.ModelCreator<T> modelCreator) {
        this.modelHandler = new ListenerModelHandler<>(modelCreator);
    }
}
