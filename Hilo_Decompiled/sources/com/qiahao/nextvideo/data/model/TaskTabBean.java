package com.qiahao.nextvideo.data.model;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/qiahao/nextvideo/data/model/TaskTabBean;", "Ljava/io/Serializable;", "tab", "", "tasks", "", "Lcom/qiahao/nextvideo/data/model/TasksListBean;", "<init>", "(ILjava/util/List;)V", "getTab", "()I", "getTasks", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class TaskTabBean implements Serializable {
    private final int tab;

    @Nullable
    private final List<TasksListBean> tasks;

    public TaskTabBean(int i, @Nullable List<TasksListBean> list) {
        this.tab = i;
        this.tasks = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TaskTabBean copy$default(TaskTabBean taskTabBean, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = taskTabBean.tab;
        }
        if ((i2 & 2) != 0) {
            list = taskTabBean.tasks;
        }
        return taskTabBean.copy(i, list);
    }

    /* renamed from: component1, reason: from getter */
    public final int getTab() {
        return this.tab;
    }

    @Nullable
    public final List<TasksListBean> component2() {
        return this.tasks;
    }

    @NotNull
    public final TaskTabBean copy(int tab, @Nullable List<TasksListBean> tasks) {
        return new TaskTabBean(tab, tasks);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskTabBean)) {
            return false;
        }
        TaskTabBean taskTabBean = (TaskTabBean) other;
        return this.tab == taskTabBean.tab && Intrinsics.areEqual(this.tasks, taskTabBean.tasks);
    }

    public final int getTab() {
        return this.tab;
    }

    @Nullable
    public final List<TasksListBean> getTasks() {
        return this.tasks;
    }

    public int hashCode() {
        int i = this.tab * 31;
        List<TasksListBean> list = this.tasks;
        return i + (list == null ? 0 : list.hashCode());
    }

    @NotNull
    public String toString() {
        return "TaskTabBean(tab=" + this.tab + ", tasks=" + this.tasks + ")";
    }

    public /* synthetic */ TaskTabBean(int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : list);
    }
}
