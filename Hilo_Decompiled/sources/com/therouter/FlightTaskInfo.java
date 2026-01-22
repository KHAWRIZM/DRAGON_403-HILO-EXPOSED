package com.therouter;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/therouter/FlightTaskInfo;", "", AgooConstants.MESSAGE_TRACE, "", "(Ljava/lang/String;)V", "createTime", "", "getCreateTime", "()J", "setCreateTime", "(J)V", "getTrace", "()Ljava/lang/String;", "router_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class FlightTaskInfo {
    private long createTime;

    @NotNull
    private final String trace;

    public FlightTaskInfo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, AgooConstants.MESSAGE_TRACE);
        this.trace = str;
        this.createTime = System.currentTimeMillis();
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    @NotNull
    public final String getTrace() {
        return this.trace;
    }

    public final void setCreateTime(long j) {
        this.createTime = j;
    }
}
