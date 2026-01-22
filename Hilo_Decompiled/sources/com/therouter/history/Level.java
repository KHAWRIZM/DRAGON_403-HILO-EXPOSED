package com.therouter.history;

import com.qiahao.nextvideo.data.service.agora.AgoraRtcService;
import com.taobao.accs.AccsState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0016\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0086\u0002J\u0011\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0086\u0002J\u0010\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0004H\u0002R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/therouter/history/Level;", "", "()V", "<set-?>", "", "v", "getV", "()I", "minus", "o", "plus", AccsState.SDK_VERSION, "value", "Companion", "router_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class Level {
    private int v;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Level NONE = new Level().sv(0);

    @NotNull
    private static final Level ACTIVITY = new Level().sv(1);

    @NotNull
    private static final Level FRAGMENT = new Level().sv(16);

    @NotNull
    private static final Level PAGE = new Level().sv(17);

    @NotNull
    private static final Level ACTION = new Level().sv(4096);

    @NotNull
    private static final Level SERVICE_PROVIDER = new Level().sv(65536);

    @NotNull
    private static final Level FLOW_TASK = new Level().sv(AgoraRtcService.CUSTOM_REMOTE_VIDEO_IDLE);

    @NotNull
    private static final Level ALL = new Level().sv(1118481);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/therouter/history/Level$Companion;", "", "()V", "ACTION", "Lcom/therouter/history/Level;", "getACTION", "()Lcom/therouter/history/Level;", "ACTIVITY", "getACTIVITY", "ALL", "getALL", "FLOW_TASK", "getFLOW_TASK", "FRAGMENT", "getFRAGMENT", "NONE", "getNONE", "PAGE", "getPAGE", "SERVICE_PROVIDER", "getSERVICE_PROVIDER", "router_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Level getACTION() {
            return Level.ACTION;
        }

        @NotNull
        public final Level getACTIVITY() {
            return Level.ACTIVITY;
        }

        @NotNull
        public final Level getALL() {
            return Level.ALL;
        }

        @NotNull
        public final Level getFLOW_TASK() {
            return Level.FLOW_TASK;
        }

        @NotNull
        public final Level getFRAGMENT() {
            return Level.FRAGMENT;
        }

        @NotNull
        public final Level getNONE() {
            return Level.NONE;
        }

        @NotNull
        public final Level getPAGE() {
            return Level.PAGE;
        }

        @NotNull
        public final Level getSERVICE_PROVIDER() {
            return Level.SERVICE_PROVIDER;
        }

        private Companion() {
        }
    }

    private final Level sv(int value) {
        this.v = value;
        return this;
    }

    public final int getV() {
        return this.v;
    }

    @NotNull
    public final Level minus(@NotNull Level o) {
        Intrinsics.checkNotNullParameter(o, "o");
        return new Level().sv(o.v ^ this.v);
    }

    @NotNull
    public final Level plus(@NotNull Level o) {
        Intrinsics.checkNotNullParameter(o, "o");
        return new Level().sv(o.v | this.v);
    }
}
