package com.liulishuo.okdownload.core.listener.assist;

import android.util.SparseArray;
import com.liulishuo.okdownload.DownloadTask;
import com.liulishuo.okdownload.SpeedCalculator;
import com.liulishuo.okdownload.core.breakpoint.BlockInfo;
import com.liulishuo.okdownload.core.breakpoint.BreakpointInfo;
import com.liulishuo.okdownload.core.cause.EndCause;
import com.liulishuo.okdownload.core.listener.assist.Listener4Assist;
import com.liulishuo.okdownload.core.listener.assist.ListenerModelHandler;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class Listener4SpeedAssistExtend implements Listener4Assist.AssistExtend, ListenerModelHandler.ModelCreator<Listener4SpeedModel> {
    private Listener4SpeedCallback callback;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface Listener4SpeedCallback {
        void blockEnd(DownloadTask downloadTask, int i10, BlockInfo blockInfo, SpeedCalculator speedCalculator);

        void infoReady(DownloadTask downloadTask, BreakpointInfo breakpointInfo, boolean z10, Listener4SpeedModel listener4SpeedModel);

        void progress(DownloadTask downloadTask, long j10, SpeedCalculator speedCalculator);

        void progressBlock(DownloadTask downloadTask, int i10, long j10, SpeedCalculator speedCalculator);

        void taskEnd(DownloadTask downloadTask, EndCause endCause, Exception exc, SpeedCalculator speedCalculator);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class Listener4SpeedModel extends Listener4Assist.Listener4Model {
        SparseArray<SpeedCalculator> blockSpeeds;
        SpeedCalculator taskSpeed;

        public Listener4SpeedModel(int i10) {
            super(i10);
        }

        public SpeedCalculator getBlockSpeed(int i10) {
            return this.blockSpeeds.get(i10);
        }

        public SpeedCalculator getTaskSpeed() {
            return this.taskSpeed;
        }

        @Override // com.liulishuo.okdownload.core.listener.assist.Listener4Assist.Listener4Model, com.liulishuo.okdownload.core.listener.assist.ListenerModelHandler.ListenerModel
        public void onInfoValid(BreakpointInfo breakpointInfo) {
            super.onInfoValid(breakpointInfo);
            this.taskSpeed = new SpeedCalculator();
            this.blockSpeeds = new SparseArray<>();
            int blockCount = breakpointInfo.getBlockCount();
            for (int i10 = 0; i10 < blockCount; i10++) {
                this.blockSpeeds.put(i10, new SpeedCalculator());
            }
        }
    }

    @Override // com.liulishuo.okdownload.core.listener.assist.Listener4Assist.AssistExtend
    public boolean dispatchBlockEnd(DownloadTask downloadTask, int i10, Listener4Assist.Listener4Model listener4Model) {
        Listener4SpeedModel listener4SpeedModel = (Listener4SpeedModel) listener4Model;
        listener4SpeedModel.blockSpeeds.get(i10).endTask();
        Listener4SpeedCallback listener4SpeedCallback = this.callback;
        if (listener4SpeedCallback != null) {
            listener4SpeedCallback.blockEnd(downloadTask, i10, listener4Model.info.getBlock(i10), listener4SpeedModel.getBlockSpeed(i10));
            return true;
        }
        return true;
    }

    @Override // com.liulishuo.okdownload.core.listener.assist.Listener4Assist.AssistExtend
    public boolean dispatchFetchProgress(DownloadTask downloadTask, int i10, long j10, Listener4Assist.Listener4Model listener4Model) {
        Listener4SpeedModel listener4SpeedModel = (Listener4SpeedModel) listener4Model;
        listener4SpeedModel.blockSpeeds.get(i10).downloading(j10);
        listener4SpeedModel.taskSpeed.downloading(j10);
        Listener4SpeedCallback listener4SpeedCallback = this.callback;
        if (listener4SpeedCallback != null) {
            listener4SpeedCallback.progressBlock(downloadTask, i10, listener4Model.blockCurrentOffsetMap.get(i10).longValue(), listener4SpeedModel.getBlockSpeed(i10));
            this.callback.progress(downloadTask, listener4Model.currentOffset, listener4SpeedModel.taskSpeed);
            return true;
        }
        return true;
    }

    @Override // com.liulishuo.okdownload.core.listener.assist.Listener4Assist.AssistExtend
    public boolean dispatchInfoReady(DownloadTask downloadTask, BreakpointInfo breakpointInfo, boolean z10, Listener4Assist.Listener4Model listener4Model) {
        Listener4SpeedCallback listener4SpeedCallback = this.callback;
        if (listener4SpeedCallback != null) {
            listener4SpeedCallback.infoReady(downloadTask, breakpointInfo, z10, (Listener4SpeedModel) listener4Model);
            return true;
        }
        return true;
    }

    @Override // com.liulishuo.okdownload.core.listener.assist.Listener4Assist.AssistExtend
    public boolean dispatchTaskEnd(DownloadTask downloadTask, EndCause endCause, Exception exc, Listener4Assist.Listener4Model listener4Model) {
        SpeedCalculator speedCalculator = ((Listener4SpeedModel) listener4Model).taskSpeed;
        if (speedCalculator != null) {
            speedCalculator.endTask();
        } else {
            speedCalculator = new SpeedCalculator();
        }
        Listener4SpeedCallback listener4SpeedCallback = this.callback;
        if (listener4SpeedCallback != null) {
            listener4SpeedCallback.taskEnd(downloadTask, endCause, exc, speedCalculator);
            return true;
        }
        return true;
    }

    public void setCallback(Listener4SpeedCallback listener4SpeedCallback) {
        this.callback = listener4SpeedCallback;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.liulishuo.okdownload.core.listener.assist.ListenerModelHandler.ModelCreator
    public Listener4SpeedModel create(int i10) {
        return new Listener4SpeedModel(i10);
    }
}
