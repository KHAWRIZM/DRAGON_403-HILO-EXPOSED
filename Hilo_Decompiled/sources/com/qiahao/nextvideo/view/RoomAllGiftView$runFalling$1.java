package com.qiahao.nextvideo.view;

import com.qiahao.nextvideo.utilities.userproxy.UserProxyUtility;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.view.RoomAllGiftView", f = "RoomAllGiftView.kt", i = {0}, l = {UserProxyUtility.cpInvite}, m = "runFalling", n = {"this"}, s = {"L$0"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomAllGiftView$runFalling$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RoomAllGiftView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomAllGiftView$runFalling$1(RoomAllGiftView roomAllGiftView, Continuation<? super RoomAllGiftView$runFalling$1> continuation) {
        super(continuation);
        this.this$0 = roomAllGiftView;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object runFalling;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        runFalling = this.this$0.runFalling(this);
        return runFalling;
    }
}
