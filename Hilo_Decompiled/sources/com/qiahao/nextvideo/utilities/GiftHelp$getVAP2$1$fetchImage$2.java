package com.qiahao.nextvideo.utilities;

import android.content.Context;
import android.graphics.Bitmap;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.nextvideo.data.model.GiftDateItem;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.utilities.GiftHelp$getVAP2$1$fetchImage$2", f = "GiftHelp.kt", i = {}, l = {198}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
final class GiftHelp$getVAP2$1$fetchImage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ GiftDateItem $giftItem;
    final /* synthetic */ Function1<Bitmap, Unit> $result;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GiftHelp$getVAP2$1$fetchImage$2(GiftDateItem giftDateItem, Context context, Function1<? super Bitmap, Unit> function1, Continuation<? super GiftHelp$getVAP2$1$fetchImage$2> continuation) {
        super(2, continuation);
        this.$giftItem = giftDateItem;
        this.$context = context;
        this.$result = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GiftHelp$getVAP2$1$fetchImage$2(this.$giftItem, this.$context, this.$result, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Boolean bool;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            GiftHelp giftHelp = GiftHelp.INSTANCE;
            String giftReceiverAvatar = this.$giftItem.getGiftReceiverAvatar();
            SvipData receiveSvip = this.$giftItem.getReceiveSvip();
            if (receiveSvip != null) {
                bool = Boxing.boxBoolean(receiveSvip.isMystery());
            } else {
                bool = null;
            }
            String receiverAvatar = this.$giftItem.getReceiverAvatar();
            Context context = this.$context;
            this.label = 1;
            obj = giftHelp.fetchAvatar(giftReceiverAvatar, bool, receiverAvatar, context, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        this.$result.invoke((Bitmap) obj);
        return Unit.INSTANCE;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
