package com.therouter.flow;

import com.therouter.TheRouter;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u0006\u0010\u0002\u001a\u00020\u0001¨\u0006\u0003"}, d2 = {"runInitFlowTask", "", "splashInit", "router_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class VirtualFlowTaskKt {
    public static final void runInitFlowTask() {
        TheRouter.runTask("TheRouter_Initialization");
    }

    public static final void splashInit() {
        TheRouter.runTask("TheRouter_activity_splash");
    }
}
