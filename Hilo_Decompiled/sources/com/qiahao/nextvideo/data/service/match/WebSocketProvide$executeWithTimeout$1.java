package com.qiahao.nextvideo.data.service.match;

import com.qiahao.nextvideo.room.manager.RoomEvent;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.apache.commons.sudcompress.archivers.zip.UnixStat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.data.service.match.WebSocketProvide", f = "WebSocketProvide.kt", i = {0, 0}, l = {UnixStat.DEFAULT_DIR_PERM, RoomEvent.ROOM_BLOCKED, RoomEvent.UPDATE_CUSTOM_THEME}, m = "executeWithTimeout", n = {"errorAction", "msgId"}, s = {"L$0", "L$1"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class WebSocketProvide$executeWithTimeout$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WebSocketProvide this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebSocketProvide$executeWithTimeout$1(WebSocketProvide webSocketProvide, Continuation<? super WebSocketProvide$executeWithTimeout$1> continuation) {
        super(continuation);
        this.this$0 = webSocketProvide;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.executeWithTimeout(null, null, null, this);
    }
}
