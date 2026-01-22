package com.qiahao.nextvideo.data.service.match;

import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.im.RelationMessageData;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import userProxy.UserProxy;
import userProxy.UserProxy1;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.data.service.match.WebSocketKtKt$handleSpecialRelationInvite$2", f = "WebSocketKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
final class WebSocketKtKt$handleSpecialRelationInvite$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UserProxy1.SpecialRelationInvite $relationInvite;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebSocketKtKt$handleSpecialRelationInvite$2(UserProxy1.SpecialRelationInvite specialRelationInvite, Continuation<? super WebSocketKtKt$handleSpecialRelationInvite$2> continuation) {
        super(2, continuation);
        this.$relationInvite = specialRelationInvite;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebSocketKtKt$handleSpecialRelationInvite$2(this.$relationInvite, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            RelationMessageData relationMessageData = new RelationMessageData((String) null, this.$relationInvite.getMsg(), (String) null, (User) null, (User) null, (Integer) null, (Integer) null, (Integer) null, Boxing.boxInt(this.$relationInvite.getType()), 253, (DefaultConstructorMarker) null);
            AppService service = AppController.INSTANCE.getService();
            if (service != null) {
                UserProxy.User user = this.$relationInvite.getUser();
                Intrinsics.checkNotNullExpressionValue(user, "getUser(...)");
                service.openRelationDialog(DataExternalKt.toUser(user), relationMessageData);
                return Unit.INSTANCE;
            }
            return null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
