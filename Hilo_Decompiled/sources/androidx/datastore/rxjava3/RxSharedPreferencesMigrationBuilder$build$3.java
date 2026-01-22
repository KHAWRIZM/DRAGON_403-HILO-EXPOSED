package androidx.datastore.rxjava3;

import io.reactivex.rxjava3.core.i0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.rx3.RxAwaitKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@"}, d2 = {"<anonymous>", "", "T", "curData"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.datastore.rxjava3.RxSharedPreferencesMigrationBuilder$build$3", f = "RxSharedPreferencesMigration.kt", i = {}, l = {125}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
final class RxSharedPreferencesMigrationBuilder$build$3<T> extends SuspendLambda implements Function2<T, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RxSharedPreferencesMigrationBuilder<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RxSharedPreferencesMigrationBuilder$build$3(RxSharedPreferencesMigrationBuilder<T> rxSharedPreferencesMigrationBuilder, Continuation<? super RxSharedPreferencesMigrationBuilder$build$3> continuation) {
        super(2, continuation);
        this.this$0 = rxSharedPreferencesMigrationBuilder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        RxSharedPreferencesMigrationBuilder$build$3 rxSharedPreferencesMigrationBuilder$build$3 = new RxSharedPreferencesMigrationBuilder$build$3(this.this$0, continuation);
        rxSharedPreferencesMigrationBuilder$build$3.L$0 = obj;
        return rxSharedPreferencesMigrationBuilder$build$3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Boolean> continuation) {
        return invoke2((RxSharedPreferencesMigrationBuilder$build$3<T>) obj, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        RxSharedPreferencesMigration rxSharedPreferencesMigration;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            Object obj2 = this.L$0;
            rxSharedPreferencesMigration = ((RxSharedPreferencesMigrationBuilder) this.this$0).rxSharedPreferencesMigration;
            i0<Boolean> shouldMigrate = rxSharedPreferencesMigration.shouldMigrate(obj2);
            this.label = 1;
            obj = RxAwaitKt.await(shouldMigrate, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(T t10, @Nullable Continuation<? super Boolean> continuation) {
        return ((RxSharedPreferencesMigrationBuilder$build$3) create(t10, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
