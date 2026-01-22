package com.qiahao.hilo_message.utils;

import com.facebook.share.internal.ShareConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B=\u0012\u001c\b\u0002\u0010\u0003\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00028\u0000¢\u0006\u0002\u0010\u0015J\u0014\u0010\u0016\u001a\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\u001c\u0010\u0019\u001a\u00020\u00062\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0082@¢\u0006\u0002\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u0006R%\u0010\u0003\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/qiahao/hilo_message/utils/MessageProcessor;", "T", "", "mProcessMessages", "Lkotlin/Function1;", "", "", "checkContain", "", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getMProcessMessages", "()Lkotlin/jvm/functions/Function1;", "getCheckContain", "messageChannel", "Lkotlinx/coroutines/channels/Channel;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "isProcessing", "addMessage", ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "(Ljava/lang/Object;)V", "addMessageList", "messageList", "startProcessing", "processMessages", "messages", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "destroy", "hilo_message_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class MessageProcessor<T> {

    @Nullable
    private final Function1<T, Boolean> checkContain;
    private boolean isProcessing;

    @Nullable
    private final Function1<List<? extends T>, Unit> mProcessMessages;

    @NotNull
    private final Channel<T> messageChannel;

    @NotNull
    private final CoroutineScope scope;

    /* JADX WARN: Multi-variable type inference failed */
    public MessageProcessor() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object processMessages(List<? extends T> list, Continuation<? super Unit> continuation) {
        return BuildersKt.withContext(Dispatchers.getMain(), new MessageProcessor$processMessages$2(this, list, null), continuation);
    }

    private final void startProcessing() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new MessageProcessor$startProcessing$1(this, null), 3, null);
    }

    public final void addMessage(T message) {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new MessageProcessor$addMessage$1(this, message, null), 3, null);
    }

    public final void addMessageList(@NotNull List<? extends T> messageList) {
        Intrinsics.checkNotNullParameter(messageList, "messageList");
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new MessageProcessor$addMessageList$1(messageList, this, null), 3, null);
    }

    public final void destroy() {
        this.isProcessing = false;
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
        SendChannel.DefaultImpls.close$default(this.messageChannel, null, 1, null);
    }

    @Nullable
    public final Function1<T, Boolean> getCheckContain() {
        return this.checkContain;
    }

    @Nullable
    public final Function1<List<? extends T>, Unit> getMProcessMessages() {
        return this.mProcessMessages;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MessageProcessor(@Nullable Function1<? super List<? extends T>, Unit> function1, @Nullable Function1<? super T, Boolean> function12) {
        this.mProcessMessages = function1;
        this.checkContain = function12;
        this.messageChannel = ChannelKt.Channel$default(1000, null, null, 6, null);
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.isProcessing = true;
        startProcessing();
    }

    public /* synthetic */ MessageProcessor(Function1 function1, Function1 function12, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : function1, (i10 & 2) != 0 ? null : function12);
    }
}
