package com.therouter.history;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/therouter/history/ActionNavigatorHistory;", "Lcom/therouter/history/a;", "", "event", "<init>", "(Ljava/lang/String;)V", "Ljava/lang/String;", "getEvent", "()Ljava/lang/String;", "router_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class ActionNavigatorHistory implements a {

    @NotNull
    private final String event;

    public ActionNavigatorHistory(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "event");
        this.event = str;
    }

    @NotNull
    public final String getEvent() {
        return this.event;
    }
}
