package com.liulishuo.okdownload;

import android.util.SparseArray;
import com.liulishuo.okdownload.core.breakpoint.BreakpointInfo;
import com.liulishuo.okdownload.core.cause.EndCause;
import com.liulishuo.okdownload.core.cause.ResumeFailedCause;
import com.liulishuo.okdownload.core.listener.assist.ListenerAssist;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class UnifiedListenerManager {
    final List<Integer> autoRemoveListenerIdList = new ArrayList();
    final DownloadListener hostListener = new DownloadListener() { // from class: com.liulishuo.okdownload.UnifiedListenerManager.1
        @Override // com.liulishuo.okdownload.DownloadListener
        public void connectEnd(DownloadTask downloadTask, int i10, int i11, Map<String, List<String>> map) {
            DownloadListener[] threadSafeArray = UnifiedListenerManager.getThreadSafeArray(downloadTask, UnifiedListenerManager.this.realListenerMap);
            if (threadSafeArray == null) {
                return;
            }
            for (DownloadListener downloadListener : threadSafeArray) {
                if (downloadListener != null) {
                    downloadListener.connectEnd(downloadTask, i10, i11, map);
                }
            }
        }

        @Override // com.liulishuo.okdownload.DownloadListener
        public void connectStart(DownloadTask downloadTask, int i10, Map<String, List<String>> map) {
            DownloadListener[] threadSafeArray = UnifiedListenerManager.getThreadSafeArray(downloadTask, UnifiedListenerManager.this.realListenerMap);
            if (threadSafeArray == null) {
                return;
            }
            for (DownloadListener downloadListener : threadSafeArray) {
                if (downloadListener != null) {
                    downloadListener.connectStart(downloadTask, i10, map);
                }
            }
        }

        @Override // com.liulishuo.okdownload.DownloadListener
        public void connectTrialEnd(DownloadTask downloadTask, int i10, Map<String, List<String>> map) {
            DownloadListener[] threadSafeArray = UnifiedListenerManager.getThreadSafeArray(downloadTask, UnifiedListenerManager.this.realListenerMap);
            if (threadSafeArray == null) {
                return;
            }
            for (DownloadListener downloadListener : threadSafeArray) {
                if (downloadListener != null) {
                    downloadListener.connectTrialEnd(downloadTask, i10, map);
                }
            }
        }

        @Override // com.liulishuo.okdownload.DownloadListener
        public void connectTrialStart(DownloadTask downloadTask, Map<String, List<String>> map) {
            DownloadListener[] threadSafeArray = UnifiedListenerManager.getThreadSafeArray(downloadTask, UnifiedListenerManager.this.realListenerMap);
            if (threadSafeArray == null) {
                return;
            }
            for (DownloadListener downloadListener : threadSafeArray) {
                if (downloadListener != null) {
                    downloadListener.connectTrialStart(downloadTask, map);
                }
            }
        }

        @Override // com.liulishuo.okdownload.DownloadListener
        public void downloadFromBeginning(DownloadTask downloadTask, BreakpointInfo breakpointInfo, ResumeFailedCause resumeFailedCause) {
            DownloadListener[] threadSafeArray = UnifiedListenerManager.getThreadSafeArray(downloadTask, UnifiedListenerManager.this.realListenerMap);
            if (threadSafeArray == null) {
                return;
            }
            for (DownloadListener downloadListener : threadSafeArray) {
                if (downloadListener != null) {
                    downloadListener.downloadFromBeginning(downloadTask, breakpointInfo, resumeFailedCause);
                }
            }
        }

        @Override // com.liulishuo.okdownload.DownloadListener
        public void downloadFromBreakpoint(DownloadTask downloadTask, BreakpointInfo breakpointInfo) {
            DownloadListener[] threadSafeArray = UnifiedListenerManager.getThreadSafeArray(downloadTask, UnifiedListenerManager.this.realListenerMap);
            if (threadSafeArray == null) {
                return;
            }
            for (DownloadListener downloadListener : threadSafeArray) {
                if (downloadListener != null) {
                    downloadListener.downloadFromBreakpoint(downloadTask, breakpointInfo);
                }
            }
        }

        @Override // com.liulishuo.okdownload.DownloadListener
        public void fetchEnd(DownloadTask downloadTask, int i10, long j10) {
            DownloadListener[] threadSafeArray = UnifiedListenerManager.getThreadSafeArray(downloadTask, UnifiedListenerManager.this.realListenerMap);
            if (threadSafeArray == null) {
                return;
            }
            for (DownloadListener downloadListener : threadSafeArray) {
                if (downloadListener != null) {
                    downloadListener.fetchEnd(downloadTask, i10, j10);
                }
            }
        }

        @Override // com.liulishuo.okdownload.DownloadListener
        public void fetchProgress(DownloadTask downloadTask, int i10, long j10) {
            DownloadListener[] threadSafeArray = UnifiedListenerManager.getThreadSafeArray(downloadTask, UnifiedListenerManager.this.realListenerMap);
            if (threadSafeArray == null) {
                return;
            }
            for (DownloadListener downloadListener : threadSafeArray) {
                if (downloadListener != null) {
                    downloadListener.fetchProgress(downloadTask, i10, j10);
                }
            }
        }

        @Override // com.liulishuo.okdownload.DownloadListener
        public void fetchStart(DownloadTask downloadTask, int i10, long j10) {
            DownloadListener[] threadSafeArray = UnifiedListenerManager.getThreadSafeArray(downloadTask, UnifiedListenerManager.this.realListenerMap);
            if (threadSafeArray == null) {
                return;
            }
            for (DownloadListener downloadListener : threadSafeArray) {
                if (downloadListener != null) {
                    downloadListener.fetchStart(downloadTask, i10, j10);
                }
            }
        }

        @Override // com.liulishuo.okdownload.DownloadListener
        public void taskEnd(DownloadTask downloadTask, EndCause endCause, Exception exc) {
            DownloadListener[] threadSafeArray = UnifiedListenerManager.getThreadSafeArray(downloadTask, UnifiedListenerManager.this.realListenerMap);
            if (threadSafeArray == null) {
                return;
            }
            for (DownloadListener downloadListener : threadSafeArray) {
                if (downloadListener != null) {
                    downloadListener.taskEnd(downloadTask, endCause, exc);
                }
            }
            if (UnifiedListenerManager.this.autoRemoveListenerIdList.contains(Integer.valueOf(downloadTask.getId()))) {
                UnifiedListenerManager.this.detachListener(downloadTask.getId());
            }
        }

        @Override // com.liulishuo.okdownload.DownloadListener
        public void taskStart(DownloadTask downloadTask) {
            DownloadListener[] threadSafeArray = UnifiedListenerManager.getThreadSafeArray(downloadTask, UnifiedListenerManager.this.realListenerMap);
            if (threadSafeArray == null) {
                return;
            }
            for (DownloadListener downloadListener : threadSafeArray) {
                if (downloadListener != null) {
                    downloadListener.taskStart(downloadTask);
                }
            }
        }
    };
    final SparseArray<ArrayList<DownloadListener>> realListenerMap = new SparseArray<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static DownloadListener[] getThreadSafeArray(DownloadTask downloadTask, SparseArray<ArrayList<DownloadListener>> sparseArray) {
        ArrayList<DownloadListener> arrayList = sparseArray.get(downloadTask.getId());
        if (arrayList != null && arrayList.size() > 0) {
            DownloadListener[] downloadListenerArr = new DownloadListener[arrayList.size()];
            arrayList.toArray(downloadListenerArr);
            return downloadListenerArr;
        }
        return null;
    }

    public synchronized void addAutoRemoveListenersWhenTaskEnd(int i10) {
        if (this.autoRemoveListenerIdList.contains(Integer.valueOf(i10))) {
            return;
        }
        this.autoRemoveListenerIdList.add(Integer.valueOf(i10));
    }

    public synchronized void attachAndEnqueueIfNotRun(DownloadTask downloadTask, DownloadListener downloadListener) {
        attachListener(downloadTask, downloadListener);
        if (!isTaskPendingOrRunning(downloadTask)) {
            downloadTask.enqueue(this.hostListener);
        }
    }

    public synchronized void attachListener(DownloadTask downloadTask, DownloadListener downloadListener) {
        try {
            int id = downloadTask.getId();
            ArrayList<DownloadListener> arrayList = this.realListenerMap.get(id);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.realListenerMap.put(id, arrayList);
            }
            if (!arrayList.contains(downloadListener)) {
                arrayList.add(downloadListener);
                if (downloadListener instanceof ListenerAssist) {
                    ((ListenerAssist) downloadListener).setAlwaysRecoverAssistModelIfNotSet(true);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void detachListener(int i10) {
        this.realListenerMap.remove(i10);
    }

    public synchronized void enqueueTaskWithUnifiedListener(DownloadTask downloadTask, DownloadListener downloadListener) {
        attachListener(downloadTask, downloadListener);
        downloadTask.enqueue(this.hostListener);
    }

    public synchronized void executeTaskWithUnifiedListener(DownloadTask downloadTask, DownloadListener downloadListener) {
        attachListener(downloadTask, downloadListener);
        downloadTask.execute(this.hostListener);
    }

    public DownloadListener getHostListener() {
        return this.hostListener;
    }

    public boolean isTaskPendingOrRunning(DownloadTask downloadTask) {
        return StatusUtil.isSameTaskPendingOrRunning(downloadTask);
    }

    public synchronized void removeAutoRemoveListenersWhenTaskEnd(int i10) {
        this.autoRemoveListenerIdList.remove(Integer.valueOf(i10));
    }

    public synchronized void detachListener(DownloadListener downloadListener) {
        try {
            int size = this.realListenerMap.size();
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < size; i10++) {
                ArrayList<DownloadListener> valueAt = this.realListenerMap.valueAt(i10);
                if (valueAt != null) {
                    valueAt.remove(downloadListener);
                    if (valueAt.isEmpty()) {
                        arrayList.add(Integer.valueOf(this.realListenerMap.keyAt(i10)));
                    }
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.realListenerMap.remove(((Integer) it.next()).intValue());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean detachListener(DownloadTask downloadTask, DownloadListener downloadListener) {
        int id = downloadTask.getId();
        ArrayList<DownloadListener> arrayList = this.realListenerMap.get(id);
        if (arrayList == null) {
            return false;
        }
        boolean remove = arrayList.remove(downloadListener);
        if (arrayList.isEmpty()) {
            this.realListenerMap.remove(id);
        }
        return remove;
    }
}
