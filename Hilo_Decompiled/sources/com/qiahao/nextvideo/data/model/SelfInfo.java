package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/qiahao/nextvideo/data/model/SelfInfo;", "", "joinTime", "", "lastSendMsgTime", "<init>", "(JJ)V", "getJoinTime", "()J", "getLastSendMsgTime", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class SelfInfo {

    @c("join_time")
    private final long joinTime;

    @c("lastSendMsgTime")
    private final long lastSendMsgTime;

    public SelfInfo(long j, long j2) {
        this.joinTime = j;
        this.lastSendMsgTime = j2;
    }

    public static /* synthetic */ SelfInfo copy$default(SelfInfo selfInfo, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = selfInfo.joinTime;
        }
        if ((i & 2) != 0) {
            j2 = selfInfo.lastSendMsgTime;
        }
        return selfInfo.copy(j, j2);
    }

    /* renamed from: component1, reason: from getter */
    public final long getJoinTime() {
        return this.joinTime;
    }

    /* renamed from: component2, reason: from getter */
    public final long getLastSendMsgTime() {
        return this.lastSendMsgTime;
    }

    @NotNull
    public final SelfInfo copy(long joinTime, long lastSendMsgTime) {
        return new SelfInfo(joinTime, lastSendMsgTime);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SelfInfo)) {
            return false;
        }
        SelfInfo selfInfo = (SelfInfo) other;
        return this.joinTime == selfInfo.joinTime && this.lastSendMsgTime == selfInfo.lastSendMsgTime;
    }

    public final long getJoinTime() {
        return this.joinTime;
    }

    public final long getLastSendMsgTime() {
        return this.lastSendMsgTime;
    }

    public int hashCode() {
        return (androidx.collection.c.a(this.joinTime) * 31) + androidx.collection.c.a(this.lastSendMsgTime);
    }

    @NotNull
    public String toString() {
        return "SelfInfo(joinTime=" + this.joinTime + ", lastSendMsgTime=" + this.lastSendMsgTime + ")";
    }
}
