package com.oudi.utils.ktx;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.oudi.utils.ktx.ToastKtxKt$toastHandler$1", f = "ToastKtx.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ToastKtxKt$toastHandler$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $con;
    final /* synthetic */ int $duration;
    final /* synthetic */ CharSequence $message;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToastKtxKt$toastHandler$1(Context context, CharSequence charSequence, int i10, Continuation<? super ToastKtxKt$toastHandler$1> continuation) {
        super(2, continuation);
        this.$con = context;
        this.$message = charSequence;
        this.$duration = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ToastKtxKt$toastHandler$1(this.$con, this.$message, this.$duration, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                Toast.makeText(this.$con, this.$message, this.$duration).show();
            } catch (Exception e10) {
                Log.e("ToastKtx", "toastHandler()2 thread:" + Thread.currentThread().getName() + " ,e:" + e10);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ToastKtxKt$toastHandler$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
