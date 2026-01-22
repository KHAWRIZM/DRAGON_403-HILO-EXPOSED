package com.liulishuo.okdownload.core.dispatcher;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.liulishuo.okdownload.DownloadListener;
import com.liulishuo.okdownload.DownloadMonitor;
import com.liulishuo.okdownload.DownloadTask;
import com.liulishuo.okdownload.OkDownload;
import com.liulishuo.okdownload.core.Util;
import com.liulishuo.okdownload.core.breakpoint.BreakpointInfo;
import com.liulishuo.okdownload.core.cause.EndCause;
import com.liulishuo.okdownload.core.cause.ResumeFailedCause;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class CallbackDispatcher {
    private static final String TAG = "CallbackDispatcher";
    private final DownloadListener transmit;
    private final Handler uiHandler;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class DefaultTransmitListener implements DownloadListener {
        private final Handler uiHandler;

        public DefaultTransmitListener(Handler handler) {
            this.uiHandler = handler;
        }

        @Override // com.liulishuo.okdownload.DownloadListener
        public void connectEnd(final DownloadTask downloadTask, final int i10, final int i11, final Map<String, List<String>> map) {
            Util.d(CallbackDispatcher.TAG, "<----- finish connection task(" + downloadTask.getId() + ") block(" + i10 + ") code[" + i11 + "]" + map);
            if (downloadTask.isAutoCallbackToUIThread()) {
                this.uiHandler.post(new Runnable() { // from class: com.liulishuo.okdownload.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.7
                    @Override // java.lang.Runnable
                    public void run() {
                        downloadTask.getListener().connectEnd(downloadTask, i10, i11, map);
                    }
                });
            } else {
                downloadTask.getListener().connectEnd(downloadTask, i10, i11, map);
            }
        }

        @Override // com.liulishuo.okdownload.DownloadListener
        public void connectStart(final DownloadTask downloadTask, final int i10, final Map<String, List<String>> map) {
            Util.d(CallbackDispatcher.TAG, "-----> start connection task(" + downloadTask.getId() + ") block(" + i10 + ") " + map);
            if (downloadTask.isAutoCallbackToUIThread()) {
                this.uiHandler.post(new Runnable() { // from class: com.liulishuo.okdownload.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.6
                    @Override // java.lang.Runnable
                    public void run() {
                        downloadTask.getListener().connectStart(downloadTask, i10, map);
                    }
                });
            } else {
                downloadTask.getListener().connectStart(downloadTask, i10, map);
            }
        }

        @Override // com.liulishuo.okdownload.DownloadListener
        public void connectTrialEnd(final DownloadTask downloadTask, final int i10, final Map<String, List<String>> map) {
            Util.d(CallbackDispatcher.TAG, "<----- finish trial task(" + downloadTask.getId() + ") code[" + i10 + "]" + map);
            if (downloadTask.isAutoCallbackToUIThread()) {
                this.uiHandler.post(new Runnable() { // from class: com.liulishuo.okdownload.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.3
                    @Override // java.lang.Runnable
                    public void run() {
                        downloadTask.getListener().connectTrialEnd(downloadTask, i10, map);
                    }
                });
            } else {
                downloadTask.getListener().connectTrialEnd(downloadTask, i10, map);
            }
        }

        @Override // com.liulishuo.okdownload.DownloadListener
        public void connectTrialStart(final DownloadTask downloadTask, final Map<String, List<String>> map) {
            Util.d(CallbackDispatcher.TAG, "-----> start trial task(" + downloadTask.getId() + ") " + map);
            if (downloadTask.isAutoCallbackToUIThread()) {
                this.uiHandler.post(new Runnable() { // from class: com.liulishuo.okdownload.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.2
                    @Override // java.lang.Runnable
                    public void run() {
                        downloadTask.getListener().connectTrialStart(downloadTask, map);
                    }
                });
            } else {
                downloadTask.getListener().connectTrialStart(downloadTask, map);
            }
        }

        @Override // com.liulishuo.okdownload.DownloadListener
        public void downloadFromBeginning(final DownloadTask downloadTask, final BreakpointInfo breakpointInfo, final ResumeFailedCause resumeFailedCause) {
            Util.d(CallbackDispatcher.TAG, "downloadFromBeginning: " + downloadTask.getId());
            inspectDownloadFromBeginning(downloadTask, breakpointInfo, resumeFailedCause);
            if (downloadTask.isAutoCallbackToUIThread()) {
                this.uiHandler.post(new Runnable() { // from class: com.liulishuo.okdownload.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.4
                    @Override // java.lang.Runnable
                    public void run() {
                        downloadTask.getListener().downloadFromBeginning(downloadTask, breakpointInfo, resumeFailedCause);
                    }
                });
            } else {
                downloadTask.getListener().downloadFromBeginning(downloadTask, breakpointInfo, resumeFailedCause);
            }
        }

        @Override // com.liulishuo.okdownload.DownloadListener
        public void downloadFromBreakpoint(final DownloadTask downloadTask, final BreakpointInfo breakpointInfo) {
            Util.d(CallbackDispatcher.TAG, "downloadFromBreakpoint: " + downloadTask.getId());
            inspectDownloadFromBreakpoint(downloadTask, breakpointInfo);
            if (downloadTask.isAutoCallbackToUIThread()) {
                this.uiHandler.post(new Runnable() { // from class: com.liulishuo.okdownload.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.5
                    @Override // java.lang.Runnable
                    public void run() {
                        downloadTask.getListener().downloadFromBreakpoint(downloadTask, breakpointInfo);
                    }
                });
            } else {
                downloadTask.getListener().downloadFromBreakpoint(downloadTask, breakpointInfo);
            }
        }

        @Override // com.liulishuo.okdownload.DownloadListener
        public void fetchEnd(final DownloadTask downloadTask, final int i10, final long j10) {
            Util.d(CallbackDispatcher.TAG, "fetchEnd: " + downloadTask.getId());
            if (downloadTask.isAutoCallbackToUIThread()) {
                this.uiHandler.post(new Runnable() { // from class: com.liulishuo.okdownload.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.10
                    @Override // java.lang.Runnable
                    public void run() {
                        downloadTask.getListener().fetchEnd(downloadTask, i10, j10);
                    }
                });
            } else {
                downloadTask.getListener().fetchEnd(downloadTask, i10, j10);
            }
        }

        @Override // com.liulishuo.okdownload.DownloadListener
        public void fetchProgress(final DownloadTask downloadTask, final int i10, final long j10) {
            if (downloadTask.getMinIntervalMillisCallbackProcess() > 0) {
                DownloadTask.TaskHideWrapper.setLastCallbackProcessTs(downloadTask, SystemClock.uptimeMillis());
            }
            if (downloadTask.isAutoCallbackToUIThread()) {
                this.uiHandler.post(new Runnable() { // from class: com.liulishuo.okdownload.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.9
                    @Override // java.lang.Runnable
                    public void run() {
                        downloadTask.getListener().fetchProgress(downloadTask, i10, j10);
                    }
                });
            } else {
                downloadTask.getListener().fetchProgress(downloadTask, i10, j10);
            }
        }

        @Override // com.liulishuo.okdownload.DownloadListener
        public void fetchStart(final DownloadTask downloadTask, final int i10, final long j10) {
            Util.d(CallbackDispatcher.TAG, "fetchStart: " + downloadTask.getId());
            if (downloadTask.isAutoCallbackToUIThread()) {
                this.uiHandler.post(new Runnable() { // from class: com.liulishuo.okdownload.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.8
                    @Override // java.lang.Runnable
                    public void run() {
                        downloadTask.getListener().fetchStart(downloadTask, i10, j10);
                    }
                });
            } else {
                downloadTask.getListener().fetchStart(downloadTask, i10, j10);
            }
        }

        public void inspectDownloadFromBeginning(DownloadTask downloadTask, BreakpointInfo breakpointInfo, ResumeFailedCause resumeFailedCause) {
            DownloadMonitor monitor = OkDownload.with().getMonitor();
            if (monitor != null) {
                monitor.taskDownloadFromBeginning(downloadTask, breakpointInfo, resumeFailedCause);
            }
        }

        public void inspectDownloadFromBreakpoint(DownloadTask downloadTask, BreakpointInfo breakpointInfo) {
            DownloadMonitor monitor = OkDownload.with().getMonitor();
            if (monitor != null) {
                monitor.taskDownloadFromBreakpoint(downloadTask, breakpointInfo);
            }
        }

        public void inspectTaskEnd(DownloadTask downloadTask, EndCause endCause, Exception exc) {
            DownloadMonitor monitor = OkDownload.with().getMonitor();
            if (monitor != null) {
                monitor.taskEnd(downloadTask, endCause, exc);
            }
        }

        public void inspectTaskStart(DownloadTask downloadTask) {
            DownloadMonitor monitor = OkDownload.with().getMonitor();
            if (monitor != null) {
                monitor.taskStart(downloadTask);
            }
        }

        @Override // com.liulishuo.okdownload.DownloadListener
        public void taskEnd(final DownloadTask downloadTask, final EndCause endCause, final Exception exc) {
            if (endCause == EndCause.ERROR) {
                Util.d(CallbackDispatcher.TAG, "taskEnd: " + downloadTask.getId() + " " + endCause + " " + exc);
            }
            inspectTaskEnd(downloadTask, endCause, exc);
            if (downloadTask.isAutoCallbackToUIThread()) {
                this.uiHandler.post(new Runnable() { // from class: com.liulishuo.okdownload.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.11
                    @Override // java.lang.Runnable
                    public void run() {
                        downloadTask.getListener().taskEnd(downloadTask, endCause, exc);
                    }
                });
            } else {
                downloadTask.getListener().taskEnd(downloadTask, endCause, exc);
            }
        }

        @Override // com.liulishuo.okdownload.DownloadListener
        public void taskStart(final DownloadTask downloadTask) {
            Util.d(CallbackDispatcher.TAG, "taskStart: " + downloadTask.getId());
            inspectTaskStart(downloadTask);
            if (downloadTask.isAutoCallbackToUIThread()) {
                this.uiHandler.post(new Runnable() { // from class: com.liulishuo.okdownload.core.dispatcher.CallbackDispatcher.DefaultTransmitListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        downloadTask.getListener().taskStart(downloadTask);
                    }
                });
            } else {
                downloadTask.getListener().taskStart(downloadTask);
            }
        }
    }

    public CallbackDispatcher(Handler handler, DownloadListener downloadListener) {
        this.uiHandler = handler;
        this.transmit = downloadListener;
    }

    public DownloadListener dispatch() {
        return this.transmit;
    }

    public void endTasks(final Collection<DownloadTask> collection, final Collection<DownloadTask> collection2, final Collection<DownloadTask> collection3) {
        if (collection.size() == 0 && collection2.size() == 0 && collection3.size() == 0) {
            return;
        }
        Util.d(TAG, "endTasks completed[" + collection.size() + "] sameTask[" + collection2.size() + "] fileBusy[" + collection3.size() + "]");
        if (collection.size() > 0) {
            Iterator<DownloadTask> it = collection.iterator();
            while (it.hasNext()) {
                DownloadTask next = it.next();
                if (!next.isAutoCallbackToUIThread()) {
                    next.getListener().taskEnd(next, EndCause.COMPLETED, null);
                    it.remove();
                }
            }
        }
        if (collection2.size() > 0) {
            Iterator<DownloadTask> it2 = collection2.iterator();
            while (it2.hasNext()) {
                DownloadTask next2 = it2.next();
                if (!next2.isAutoCallbackToUIThread()) {
                    next2.getListener().taskEnd(next2, EndCause.SAME_TASK_BUSY, null);
                    it2.remove();
                }
            }
        }
        if (collection3.size() > 0) {
            Iterator<DownloadTask> it3 = collection3.iterator();
            while (it3.hasNext()) {
                DownloadTask next3 = it3.next();
                if (!next3.isAutoCallbackToUIThread()) {
                    next3.getListener().taskEnd(next3, EndCause.FILE_BUSY, null);
                    it3.remove();
                }
            }
        }
        if (collection.size() == 0 && collection2.size() == 0 && collection3.size() == 0) {
            return;
        }
        this.uiHandler.post(new Runnable() { // from class: com.liulishuo.okdownload.core.dispatcher.CallbackDispatcher.2
            @Override // java.lang.Runnable
            public void run() {
                for (DownloadTask downloadTask : collection) {
                    downloadTask.getListener().taskEnd(downloadTask, EndCause.COMPLETED, null);
                }
                for (DownloadTask downloadTask2 : collection2) {
                    downloadTask2.getListener().taskEnd(downloadTask2, EndCause.SAME_TASK_BUSY, null);
                }
                for (DownloadTask downloadTask3 : collection3) {
                    downloadTask3.getListener().taskEnd(downloadTask3, EndCause.FILE_BUSY, null);
                }
            }
        });
    }

    public void endTasksWithCanceled(final Collection<DownloadTask> collection) {
        if (collection.size() <= 0) {
            return;
        }
        Util.d(TAG, "endTasksWithCanceled canceled[" + collection.size() + "]");
        Iterator<DownloadTask> it = collection.iterator();
        while (it.hasNext()) {
            DownloadTask next = it.next();
            if (!next.isAutoCallbackToUIThread()) {
                next.getListener().taskEnd(next, EndCause.CANCELED, null);
                it.remove();
            }
        }
        this.uiHandler.post(new Runnable() { // from class: com.liulishuo.okdownload.core.dispatcher.CallbackDispatcher.3
            @Override // java.lang.Runnable
            public void run() {
                for (DownloadTask downloadTask : collection) {
                    downloadTask.getListener().taskEnd(downloadTask, EndCause.CANCELED, null);
                }
            }
        });
    }

    public void endTasksWithError(final Collection<DownloadTask> collection, final Exception exc) {
        if (collection.size() <= 0) {
            return;
        }
        Util.d(TAG, "endTasksWithError error[" + collection.size() + "] realCause: " + exc);
        Iterator<DownloadTask> it = collection.iterator();
        while (it.hasNext()) {
            DownloadTask next = it.next();
            if (!next.isAutoCallbackToUIThread()) {
                next.getListener().taskEnd(next, EndCause.ERROR, exc);
                it.remove();
            }
        }
        this.uiHandler.post(new Runnable() { // from class: com.liulishuo.okdownload.core.dispatcher.CallbackDispatcher.1
            @Override // java.lang.Runnable
            public void run() {
                for (DownloadTask downloadTask : collection) {
                    downloadTask.getListener().taskEnd(downloadTask, EndCause.ERROR, exc);
                }
            }
        });
    }

    public boolean isFetchProcessMoment(DownloadTask downloadTask) {
        long minIntervalMillisCallbackProcess = downloadTask.getMinIntervalMillisCallbackProcess();
        long uptimeMillis = SystemClock.uptimeMillis();
        if (minIntervalMillisCallbackProcess > 0 && uptimeMillis - DownloadTask.TaskHideWrapper.getLastCallbackProcessTs(downloadTask) < minIntervalMillisCallbackProcess) {
            return false;
        }
        return true;
    }

    public CallbackDispatcher() {
        Handler handler = new Handler(Looper.getMainLooper());
        this.uiHandler = handler;
        this.transmit = new DefaultTransmitListener(handler);
    }
}
