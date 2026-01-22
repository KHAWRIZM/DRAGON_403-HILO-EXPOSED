package com.qiahao.nextvideo.data.model;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/qiahao/nextvideo/data/model/JoinGroupBean;", "Ljava/io/Serializable;", "groups", "", "Lcom/qiahao/nextvideo/data/model/HotGroupBean;", "total", "", "<init>", "(Ljava/util/List;I)V", "getGroups", "()Ljava/util/List;", "getTotal", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class JoinGroupBean implements Serializable {

    @NotNull
    private final List<HotGroupBean> groups;
    private final int total;

    public JoinGroupBean(@NotNull List<HotGroupBean> list, int i) {
        Intrinsics.checkNotNullParameter(list, "groups");
        this.groups = list;
        this.total = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JoinGroupBean copy$default(JoinGroupBean joinGroupBean, List list, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = joinGroupBean.groups;
        }
        if ((i2 & 2) != 0) {
            i = joinGroupBean.total;
        }
        return joinGroupBean.copy(list, i);
    }

    @NotNull
    public final List<HotGroupBean> component1() {
        return this.groups;
    }

    /* renamed from: component2, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    @NotNull
    public final JoinGroupBean copy(@NotNull List<HotGroupBean> groups, int total) {
        Intrinsics.checkNotNullParameter(groups, "groups");
        return new JoinGroupBean(groups, total);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JoinGroupBean)) {
            return false;
        }
        JoinGroupBean joinGroupBean = (JoinGroupBean) other;
        return Intrinsics.areEqual(this.groups, joinGroupBean.groups) && this.total == joinGroupBean.total;
    }

    @NotNull
    public final List<HotGroupBean> getGroups() {
        return this.groups;
    }

    public final int getTotal() {
        return this.total;
    }

    public int hashCode() {
        return (this.groups.hashCode() * 31) + this.total;
    }

    @NotNull
    public String toString() {
        return "JoinGroupBean(groups=" + this.groups + ", total=" + this.total + ")";
    }
}
