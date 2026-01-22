package androidx.datastore.rxjava3;

import androidx.datastore.migrations.SharedPreferencesView;
import io.reactivex.rxjava3.core.i0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.rx3.RxAwaitKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0001H\u008a@"}, d2 = {"<anonymous>", "T", "spView", "Landroidx/datastore/migrations/SharedPreferencesView;", "curData"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.datastore.rxjava3.RxSharedPreferencesMigrationBuilder$build$2", f = "RxSharedPreferencesMigration.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
final class RxSharedPreferencesMigrationBuilder$build$2<T> extends SuspendLambda implements Function3<SharedPreferencesView, T, Continuation<? super T>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ RxSharedPreferencesMigrationBuilder<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RxSharedPreferencesMigrationBuilder$build$2(RxSharedPreferencesMigrationBuilder<T> rxSharedPreferencesMigrationBuilder, Continuation<? super RxSharedPreferencesMigrationBuilder$build$2> continuation) {
        super(3, continuation);
        this.this$0 = rxSharedPreferencesMigrationBuilder;
    }

    @Nullable
    public final Object invoke(@NotNull SharedPreferencesView sharedPreferencesView, T t10, @Nullable Continuation<? super T> continuation) {
        RxSharedPreferencesMigrationBuilder$build$2 rxSharedPreferencesMigrationBuilder$build$2 = new RxSharedPreferencesMigrationBuilder$build$2(this.this$0, continuation);
        rxSharedPreferencesMigrationBuilder$build$2.L$0 = sharedPreferencesView;
        rxSharedPreferencesMigrationBuilder$build$2.L$1 = t10;
        return rxSharedPreferencesMigrationBuilder$build$2.invokeSuspend(Unit.INSTANCE);
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
            SharedPreferencesView sharedPreferencesView = (SharedPreferencesView) this.L$0;
            Object obj2 = this.L$1;
            rxSharedPreferencesMigration = ((RxSharedPreferencesMigrationBuilder) this.this$0).rxSharedPreferencesMigration;
            i0 migrate = rxSharedPreferencesMigration.migrate(sharedPreferencesView, obj2);
            this.L$0 = null;
            this.label = 1;
            obj = RxAwaitKt.await(migrate, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(SharedPreferencesView sharedPreferencesView, Object obj, Object obj2) {
        return invoke(sharedPreferencesView, (SharedPreferencesView) obj, (Continuation<? super SharedPreferencesView>) obj2);
    }
}
