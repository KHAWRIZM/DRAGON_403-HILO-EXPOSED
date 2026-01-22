package com.therouter.inject;

import android.content.Context;
import com.therouter.flow.Digraph;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J=\u0010\b\u001a\u0004\u0018\u0001H\t\"\u0004\b\u0000\u0010\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u0002H\t\u0018\u00010\u000b2\u0016\u0010\f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\r\"\u0004\u0018\u00010\u0001H&¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/therouter/inject/Interceptor;", "", "initFlowTask", "", "context", "Landroid/content/Context;", "digraph", "Lcom/therouter/flow/Digraph;", "interception", "T", "clazz", "Ljava/lang/Class;", "params", "", "(Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;", "router_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public interface Interceptor {
    void initFlowTask(@NotNull Context context, @NotNull Digraph digraph);

    @Nullable
    <T> T interception(@Nullable Class<T> clazz, @NotNull Object... params);
}
