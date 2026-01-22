package com.qiahao.nextvideo.ui.home.discover;

import java.io.File;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.ui.home.discover.CreateActivitiesActivity$uploadPicture$1$1$1", f = "CreateActivitiesActivity.kt", i = {}, l = {282, 285}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CreateActivitiesActivity$uploadPicture$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Pair<Boolean, String> $data;
    final /* synthetic */ File $it;
    int label;
    final /* synthetic */ CreateActivitiesActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.qiahao.nextvideo.ui.home.discover.CreateActivitiesActivity$uploadPicture$1$1$1$1", f = "CreateActivitiesActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.qiahao.nextvideo.ui.home.discover.CreateActivitiesActivity$uploadPicture$1$1$1$1, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Pair<Boolean, String> $data;
        final /* synthetic */ String $result;
        int label;
        final /* synthetic */ CreateActivitiesActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CreateActivitiesActivity createActivitiesActivity, Pair<Boolean, String> pair, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = createActivitiesActivity;
            this.$data = pair;
            this.$result = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$data, this.$result, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.getCreateActivityData().setBanner((String) this.$data.getSecond());
                this.this$0.getCreateActivityData().setMd5(this.$result);
                this.this$0.createActivity();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateActivitiesActivity$uploadPicture$1$1$1(File file, CreateActivitiesActivity createActivitiesActivity, Pair<Boolean, String> pair, Continuation<? super CreateActivitiesActivity$uploadPicture$1$1$1> continuation) {
        super(2, continuation);
        this.$it = file;
        this.this$0 = createActivitiesActivity;
        this.$data = pair;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CreateActivitiesActivity$uploadPicture$1$1$1(this.$it, this.this$0, this.$data, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher io = Dispatchers.getIO();
            CreateActivitiesActivity$uploadPicture$1$1$1$result$1 createActivitiesActivity$uploadPicture$1$1$1$result$1 = new CreateActivitiesActivity$uploadPicture$1$1$1$result$1(this.$it, null);
            this.label = 1;
            obj = BuildersKt.withContext(io, createActivitiesActivity$uploadPicture$1$1$1$result$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        MainCoroutineDispatcher main = Dispatchers.getMain();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$data, (String) obj, null);
        this.label = 2;
        if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
