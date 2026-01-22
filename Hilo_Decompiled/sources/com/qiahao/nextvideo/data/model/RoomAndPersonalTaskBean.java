package com.qiahao.nextvideo.data.model;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J,\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/qiahao/nextvideo/data/model/RoomAndPersonalTaskBean;", "Ljava/io/Serializable;", "cd", "", "taskTab", "", "Lcom/qiahao/nextvideo/data/model/TaskTabBean;", "<init>", "(Ljava/lang/Long;Ljava/util/List;)V", "getCd", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTaskTab", "()Ljava/util/List;", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/util/List;)Lcom/qiahao/nextvideo/data/model/RoomAndPersonalTaskBean;", "equals", "", "other", "", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class RoomAndPersonalTaskBean implements Serializable {

    @Nullable
    private final Long cd;

    @Nullable
    private final List<TaskTabBean> taskTab;

    /* JADX WARN: Multi-variable type inference failed */
    public RoomAndPersonalTaskBean() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RoomAndPersonalTaskBean copy$default(RoomAndPersonalTaskBean roomAndPersonalTaskBean, Long l, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            l = roomAndPersonalTaskBean.cd;
        }
        if ((i & 2) != 0) {
            list = roomAndPersonalTaskBean.taskTab;
        }
        return roomAndPersonalTaskBean.copy(l, list);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Long getCd() {
        return this.cd;
    }

    @Nullable
    public final List<TaskTabBean> component2() {
        return this.taskTab;
    }

    @NotNull
    public final RoomAndPersonalTaskBean copy(@Nullable Long cd2, @Nullable List<TaskTabBean> taskTab) {
        return new RoomAndPersonalTaskBean(cd2, taskTab);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoomAndPersonalTaskBean)) {
            return false;
        }
        RoomAndPersonalTaskBean roomAndPersonalTaskBean = (RoomAndPersonalTaskBean) other;
        return Intrinsics.areEqual(this.cd, roomAndPersonalTaskBean.cd) && Intrinsics.areEqual(this.taskTab, roomAndPersonalTaskBean.taskTab);
    }

    @Nullable
    public final Long getCd() {
        return this.cd;
    }

    @Nullable
    public final List<TaskTabBean> getTaskTab() {
        return this.taskTab;
    }

    public int hashCode() {
        Long l = this.cd;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        List<TaskTabBean> list = this.taskTab;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "RoomAndPersonalTaskBean(cd=" + this.cd + ", taskTab=" + this.taskTab + ")";
    }

    public RoomAndPersonalTaskBean(@Nullable Long l, @Nullable List<TaskTabBean> list) {
        this.cd = l;
        this.taskTab = list;
    }

    public /* synthetic */ RoomAndPersonalTaskBean(Long l, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : list);
    }
}
