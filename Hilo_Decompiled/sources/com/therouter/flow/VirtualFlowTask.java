package com.therouter.flow;

import com.therouter.TheRouter;
import com.therouter.TheRouterKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0006\u0010\t\u001a\u00020\nJ\r\u0010\u000b\u001a\u00020\nH\u0011¢\u0006\u0002\b\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/therouter/flow/VirtualFlowTask;", "Lcom/therouter/flow/Task;", "taskName", "", "dependsOn", "(Ljava/lang/String;Ljava/lang/String;)V", "ready", "", "allReady", "dependTaskStatusChanged", "", "run", "run$router_release", "router_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nVirtualFlowTask.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VirtualFlowTask.kt\ncom/therouter/flow/VirtualFlowTask\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,60:1\n1855#2,2:61\n*S KotlinDebug\n*F\n+ 1 VirtualFlowTask.kt\ncom/therouter/flow/VirtualFlowTask\n*L\n32#1:61,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class VirtualFlowTask extends Task {
    private volatile boolean ready;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VirtualFlowTask(@NotNull String str, @NotNull String str2) {
        super(true, str, str2, null);
        Intrinsics.checkNotNullParameter(str, "taskName");
        Intrinsics.checkNotNullParameter(str2, "dependsOn");
    }

    private final boolean allReady() {
        while (true) {
            boolean z = true;
            for (String str : getDependencies()) {
                if (!z || !TheRouter.INSTANCE.getDigraph().getVirtualTask(str).isDone$router_release()) {
                    z = false;
                }
            }
            return z;
        }
    }

    public final void dependTaskStatusChanged() {
        if (this.ready) {
            run$router_release();
        }
    }

    @Override // com.therouter.flow.Task
    public void run$router_release() {
        this.ready = true;
        if (getState() != 2 && allReady()) {
            TheRouterKt.debug$default("FlowTask", "Virtual Flow Task " + getTaskName() + " done", null, 4, null);
            setState(2);
            TheRouter theRouter = TheRouter.INSTANCE;
            theRouter.getDigraph().schedule();
            theRouter.getDigraph().onVirtualTaskDoneListener(getTaskName());
        }
    }

    public /* synthetic */ VirtualFlowTask(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "" : str2);
    }
}
