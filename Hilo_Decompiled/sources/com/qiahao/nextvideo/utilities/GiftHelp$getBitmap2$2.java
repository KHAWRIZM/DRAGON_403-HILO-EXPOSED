package com.qiahao.nextvideo.utilities;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.utilities.GiftHelp$getBitmap2$2", f = "GiftHelp.kt", i = {}, l = {380}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nGiftHelp.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GiftHelp.kt\ncom/qiahao/nextvideo/utilities/GiftHelp$getBitmap2$2\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,379:1\n318#2,11:380\n*S KotlinDebug\n*F\n+ 1 GiftHelp.kt\ncom/qiahao/nextvideo/utilities/GiftHelp$getBitmap2$2\n*L\n288#1:380,11\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
final class GiftHelp$getBitmap2$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $url;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GiftHelp$getBitmap2$2(Context context, String str, Continuation<? super GiftHelp$getBitmap2$2> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$url = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GiftHelp$getBitmap2$2(this.$context, this.$url, continuation);
    }

    public final Object invokeSuspend(Object obj) {
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
            com.bumptech.glide.j jVar = this.$context;
            String str = this.$url;
            this.L$0 = jVar;
            this.L$1 = str;
            this.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
            cancellableContinuationImpl.initCancellability();
            c5.c R0 = Glide.with(jVar).b().K0(ImageSizeKt.imageCircle(str, UiKtxKt.toPX(100))).c().R0(100, 100);
            Intrinsics.checkNotNullExpressionValue(R0, "submit(...)");
            Object obj2 = null;
            try {
                try {
                    obj2 = Result.constructor-impl((Bitmap) R0.get());
                } catch (Exception e) {
                    e.printStackTrace();
                    obj2 = Result.constructor-impl((Object) null);
                }
                cancellableContinuationImpl.resumeWith(obj2);
                jVar = Glide.with(jVar);
                jVar.f(R0);
                obj = cancellableContinuationImpl.getResult();
                if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(this);
                }
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (Throwable th) {
                cancellableContinuationImpl.resumeWith(Result.constructor-impl(obj2));
                Glide.with(jVar).f(R0);
                throw th;
            }
        }
        return obj;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
