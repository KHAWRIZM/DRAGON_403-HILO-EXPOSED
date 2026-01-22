package com.qiahao.nextvideo.data.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/data/model/AgentMgrConnectionLogBean;", "", "records", "", "Lcom/qiahao/nextvideo/data/model/AgentMgrConnectionLogRecordBean;", "total", "", "<init>", "(Ljava/util/List;I)V", "getRecords", "()Ljava/util/List;", "getTotal", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class AgentMgrConnectionLogBean {

    @NotNull
    private final List<AgentMgrConnectionLogRecordBean> records;
    private final int total;

    public AgentMgrConnectionLogBean(@NotNull List<AgentMgrConnectionLogRecordBean> list, int i) {
        Intrinsics.checkNotNullParameter(list, "records");
        this.records = list;
        this.total = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AgentMgrConnectionLogBean copy$default(AgentMgrConnectionLogBean agentMgrConnectionLogBean, List list, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = agentMgrConnectionLogBean.records;
        }
        if ((i2 & 2) != 0) {
            i = agentMgrConnectionLogBean.total;
        }
        return agentMgrConnectionLogBean.copy(list, i);
    }

    @NotNull
    public final List<AgentMgrConnectionLogRecordBean> component1() {
        return this.records;
    }

    /* renamed from: component2, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    @NotNull
    public final AgentMgrConnectionLogBean copy(@NotNull List<AgentMgrConnectionLogRecordBean> records, int total) {
        Intrinsics.checkNotNullParameter(records, "records");
        return new AgentMgrConnectionLogBean(records, total);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgentMgrConnectionLogBean)) {
            return false;
        }
        AgentMgrConnectionLogBean agentMgrConnectionLogBean = (AgentMgrConnectionLogBean) other;
        return Intrinsics.areEqual(this.records, agentMgrConnectionLogBean.records) && this.total == agentMgrConnectionLogBean.total;
    }

    @NotNull
    public final List<AgentMgrConnectionLogRecordBean> getRecords() {
        return this.records;
    }

    public final int getTotal() {
        return this.total;
    }

    public int hashCode() {
        return (this.records.hashCode() * 31) + this.total;
    }

    @NotNull
    public String toString() {
        return "AgentMgrConnectionLogBean(records=" + this.records + ", total=" + this.total + ")";
    }
}
