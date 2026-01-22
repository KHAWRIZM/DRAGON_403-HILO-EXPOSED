package com.therouter.router;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/therouter/router/PendingNavigator;", "", "navigator", "Lcom/therouter/router/Navigator;", "action", "Lkotlin/Function0;", "", "(Lcom/therouter/router/Navigator;Lkotlin/jvm/functions/Function0;)V", "getAction", "()Lkotlin/jvm/functions/Function0;", "getNavigator", "()Lcom/therouter/router/Navigator;", "equals", "", "other", "hashCode", "", "router_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class PendingNavigator {

    @NotNull
    private final Function0<Unit> action;

    @NotNull
    private final Navigator navigator;

    public PendingNavigator(@NotNull Navigator navigator, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(function0, "action");
        this.navigator = navigator;
        this.action = function0;
    }

    public boolean equals(@Nullable Object other) {
        if (other instanceof PendingNavigator) {
            return Intrinsics.areEqual(((PendingNavigator) other).navigator, this.navigator);
        }
        return super.equals(other);
    }

    @NotNull
    public final Function0<Unit> getAction() {
        return this.action;
    }

    @NotNull
    public final Navigator getNavigator() {
        return this.navigator;
    }

    public int hashCode() {
        return this.navigator.hashCode() + 1;
    }
}
