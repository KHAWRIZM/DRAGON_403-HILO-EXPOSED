package com.liulishuo.okdownload.core.listener.assist;

import android.util.SparseArray;
import com.liulishuo.okdownload.DownloadTask;
import com.liulishuo.okdownload.core.breakpoint.BreakpointInfo;
import com.liulishuo.okdownload.core.listener.assist.ListenerModelHandler.ListenerModel;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class ListenerModelHandler<T extends ListenerModel> implements ListenerAssist {
    private Boolean alwaysRecoverModel;
    private final ModelCreator<T> creator;
    final SparseArray<T> modelList = new SparseArray<>();
    volatile T singleTaskModel;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface ListenerModel {
        int getId();

        void onInfoValid(BreakpointInfo breakpointInfo);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface ModelCreator<T extends ListenerModel> {
        T create(int i10);
    }

    public ListenerModelHandler(ModelCreator<T> modelCreator) {
        this.creator = modelCreator;
    }

    public T addAndGetModel(DownloadTask downloadTask, BreakpointInfo breakpointInfo) {
        T create = this.creator.create(downloadTask.getId());
        synchronized (this) {
            try {
                if (this.singleTaskModel == null) {
                    this.singleTaskModel = create;
                } else {
                    this.modelList.put(downloadTask.getId(), create);
                }
                if (breakpointInfo != null) {
                    create.onInfoValid(breakpointInfo);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return create;
    }

    public T getOrRecoverModel(DownloadTask downloadTask, BreakpointInfo breakpointInfo) {
        T t10;
        int id = downloadTask.getId();
        synchronized (this) {
            try {
                if (this.singleTaskModel != null && this.singleTaskModel.getId() == id) {
                    t10 = this.singleTaskModel;
                } else {
                    t10 = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (t10 == null) {
            t10 = this.modelList.get(id);
        }
        if (t10 == null && isAlwaysRecoverAssistModel()) {
            return addAndGetModel(downloadTask, breakpointInfo);
        }
        return t10;
    }

    @Override // com.liulishuo.okdownload.core.listener.assist.ListenerAssist
    public boolean isAlwaysRecoverAssistModel() {
        Boolean bool = this.alwaysRecoverModel;
        if (bool != null && bool.booleanValue()) {
            return true;
        }
        return false;
    }

    public T removeOrCreate(DownloadTask downloadTask, BreakpointInfo breakpointInfo) {
        T t10;
        int id = downloadTask.getId();
        synchronized (this) {
            try {
                if (this.singleTaskModel != null && this.singleTaskModel.getId() == id) {
                    t10 = this.singleTaskModel;
                    this.singleTaskModel = null;
                } else {
                    t10 = this.modelList.get(id);
                    this.modelList.remove(id);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (t10 == null) {
            t10 = this.creator.create(id);
            if (breakpointInfo != null) {
                t10.onInfoValid(breakpointInfo);
            }
        }
        return t10;
    }

    @Override // com.liulishuo.okdownload.core.listener.assist.ListenerAssist
    public void setAlwaysRecoverAssistModel(boolean z10) {
        this.alwaysRecoverModel = Boolean.valueOf(z10);
    }

    @Override // com.liulishuo.okdownload.core.listener.assist.ListenerAssist
    public void setAlwaysRecoverAssistModelIfNotSet(boolean z10) {
        if (this.alwaysRecoverModel == null) {
            this.alwaysRecoverModel = Boolean.valueOf(z10);
        }
    }
}
