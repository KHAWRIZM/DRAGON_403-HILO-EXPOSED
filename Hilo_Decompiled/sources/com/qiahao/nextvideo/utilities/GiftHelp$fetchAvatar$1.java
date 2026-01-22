package com.qiahao.nextvideo.utilities;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.utilities.GiftHelp", f = "GiftHelp.kt", i = {}, l = {242, 247}, m = "fetchAvatar", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GiftHelp$fetchAvatar$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GiftHelp this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GiftHelp$fetchAvatar$1(GiftHelp giftHelp, Continuation<? super GiftHelp$fetchAvatar$1> continuation) {
        super(continuation);
        this.this$0 = giftHelp;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object fetchAvatar;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fetchAvatar = this.this$0.fetchAvatar(null, null, null, null, this);
        return fetchAvatar;
    }
}
