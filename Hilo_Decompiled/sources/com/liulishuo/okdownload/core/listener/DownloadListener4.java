package com.liulishuo.okdownload.core.listener;

import com.liulishuo.okdownload.DownloadListener;
import com.liulishuo.okdownload.DownloadTask;
import com.liulishuo.okdownload.core.breakpoint.BreakpointInfo;
import com.liulishuo.okdownload.core.cause.EndCause;
import com.liulishuo.okdownload.core.cause.ResumeFailedCause;
import com.liulishuo.okdownload.core.listener.assist.Listener4Assist;
import com.liulishuo.okdownload.core.listener.assist.ListenerAssist;
import com.liulishuo.okdownload.core.listener.assist.ListenerModelHandler;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class DownloadListener4 implements DownloadListener, Listener4Assist.Listener4Callback, ListenerAssist {
    final Listener4Assist assist;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class Listener4ModelCreator implements ListenerModelHandler.ModelCreator<Listener4Assist.Listener4Model> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.liulishuo.okdownload.core.listener.assist.ListenerModelHandler.ModelCreator
        public Listener4Assist.Listener4Model create(int i10) {
            return new Listener4Assist.Listener4Model(i10);
        }
    }

    public DownloadListener4(Listener4Assist listener4Assist) {
        this.assist = listener4Assist;
        listener4Assist.setCallback(this);
    }

    @Override // com.liulishuo.okdownload.DownloadListener
    public void connectTrialEnd(DownloadTask downloadTask, int i10, Map<String, List<String>> map) {
    }

    @Override // com.liulishuo.okdownload.DownloadListener
    public void connectTrialStart(DownloadTask downloadTask, Map<String, List<String>> map) {
    }

    @Override // com.liulishuo.okdownload.DownloadListener
    public final void downloadFromBeginning(DownloadTask downloadTask, BreakpointInfo breakpointInfo, ResumeFailedCause resumeFailedCause) {
        this.assist.infoReady(downloadTask, breakpointInfo, false);
    }

    @Override // com.liulishuo.okdownload.DownloadListener
    public final void downloadFromBreakpoint(DownloadTask downloadTask, BreakpointInfo breakpointInfo) {
        this.assist.infoReady(downloadTask, breakpointInfo, true);
    }

    @Override // com.liulishuo.okdownload.DownloadListener
    public void fetchEnd(DownloadTask downloadTask, int i10, long j10) {
        this.assist.fetchEnd(downloadTask, i10);
    }

    @Override // com.liulishuo.okdownload.DownloadListener
    public final void fetchProgress(DownloadTask downloadTask, int i10, long j10) {
        this.assist.fetchProgress(downloadTask, i10, j10);
    }

    @Override // com.liulishuo.okdownload.DownloadListener
    public void fetchStart(DownloadTask downloadTask, int i10, long j10) {
    }

    @Override // com.liulishuo.okdownload.core.listener.assist.ListenerAssist
    public boolean isAlwaysRecoverAssistModel() {
        return this.assist.isAlwaysRecoverAssistModel();
    }

    @Override // com.liulishuo.okdownload.core.listener.assist.ListenerAssist
    public void setAlwaysRecoverAssistModel(boolean z10) {
        this.assist.setAlwaysRecoverAssistModel(z10);
    }

    @Override // com.liulishuo.okdownload.core.listener.assist.ListenerAssist
    public void setAlwaysRecoverAssistModelIfNotSet(boolean z10) {
        this.assist.setAlwaysRecoverAssistModelIfNotSet(z10);
    }

    public void setAssistExtend(Listener4Assist.AssistExtend assistExtend) {
        this.assist.setAssistExtend(assistExtend);
    }

    @Override // com.liulishuo.okdownload.DownloadListener
    public final void taskEnd(DownloadTask downloadTask, EndCause endCause, Exception exc) {
        this.assist.taskEnd(downloadTask, endCause, exc);
    }

    public DownloadListener4() {
        this(new Listener4Assist(new Listener4ModelCreator()));
    }
}
