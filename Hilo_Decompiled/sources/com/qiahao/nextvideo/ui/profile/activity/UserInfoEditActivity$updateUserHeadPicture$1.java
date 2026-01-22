package com.qiahao.nextvideo.ui.profile.activity;

import android.widget.Toast;
import com.oudi.core.loading.ILoading;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.ui.profile.activity.UserInfoEditActivity$updateUserHeadPicture$1;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.ui.profile.activity.UserInfoEditActivity$updateUserHeadPicture$1", f = "UserInfoEditActivity.kt", i = {}, l = {401, 404}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class UserInfoEditActivity$updateUserHeadPicture$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ArrayList<String> $a;
    final /* synthetic */ File $file;
    int label;
    final /* synthetic */ UserInfoEditActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.qiahao.nextvideo.ui.profile.activity.UserInfoEditActivity$updateUserHeadPicture$1$1", f = "UserInfoEditActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.qiahao.nextvideo.ui.profile.activity.UserInfoEditActivity$updateUserHeadPicture$1$1, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ArrayList<String> $a;
        final /* synthetic */ String $result;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ UserInfoEditActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ArrayList<String> arrayList, String str, UserInfoEditActivity userInfoEditActivity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$a = arrayList;
            this.$result = str;
            this.this$0 = userInfoEditActivity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(UserInfoEditActivity userInfoEditActivity, ApiResponse apiResponse) {
            userInfoEditActivity.getPhotoData(true);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final Unit invokeSuspend$lambda$1(UserInfoEditActivity userInfoEditActivity, CoroutineScope coroutineScope, Throwable th) {
            String str;
            if (th instanceof HiloException) {
                HiloToasty.Companion companion = HiloToasty.Companion;
                String localizedMessage = ((HiloException) th).getLocalizedMessage();
                if (localizedMessage == null) {
                    str = ResourcesKtxKt.getStringById(coroutineScope, 2131952667);
                } else {
                    str = localizedMessage;
                }
                Toast normal$default = HiloToasty.Companion.normal$default(companion, userInfoEditActivity, str, false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                }
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$2(UserInfoEditActivity userInfoEditActivity) {
            ILoading.DefaultImpls.dismissLoading$default(userInfoEditActivity, (Integer) null, 1, (Object) null);
            return Unit.INSTANCE;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$a, this.$result, this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                io.reactivex.rxjava3.core.i0<ApiResponse<Object>> fetchSetUserPhotos = UserService.INSTANCE.getShared().fetchSetUserPhotos(DataExternalKt.arrayListToString(this.$a), this.$result);
                final UserInfoEditActivity userInfoEditActivity = this.this$0;
                Function1 function1 = new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.x2
                    public final Object invoke(Object obj2) {
                        Unit invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = UserInfoEditActivity$updateUserHeadPicture$1.AnonymousClass1.invokeSuspend$lambda$0(UserInfoEditActivity.this, (ApiResponse) obj2);
                        return invokeSuspend$lambda$0;
                    }
                };
                final UserInfoEditActivity userInfoEditActivity2 = this.this$0;
                Function1 function12 = new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.y2
                    public final Object invoke(Object obj2) {
                        Unit invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = UserInfoEditActivity$updateUserHeadPicture$1.AnonymousClass1.invokeSuspend$lambda$1(UserInfoEditActivity.this, coroutineScope, (Throwable) obj2);
                        return invokeSuspend$lambda$1;
                    }
                };
                final UserInfoEditActivity userInfoEditActivity3 = this.this$0;
                RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(fetchSetUserPhotos, function1, function12, new Function0() { // from class: com.qiahao.nextvideo.ui.profile.activity.z2
                    public final Object invoke() {
                        Unit invokeSuspend$lambda$2;
                        invokeSuspend$lambda$2 = UserInfoEditActivity$updateUserHeadPicture$1.AnonymousClass1.invokeSuspend$lambda$2(UserInfoEditActivity.this);
                        return invokeSuspend$lambda$2;
                    }
                }, false, 8, (Object) null), this.this$0.getCompositeDisposable());
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
    public UserInfoEditActivity$updateUserHeadPicture$1(File file, ArrayList<String> arrayList, UserInfoEditActivity userInfoEditActivity, Continuation<? super UserInfoEditActivity$updateUserHeadPicture$1> continuation) {
        super(2, continuation);
        this.$file = file;
        this.$a = arrayList;
        this.this$0 = userInfoEditActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UserInfoEditActivity$updateUserHeadPicture$1(this.$file, this.$a, this.this$0, continuation);
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
            UserInfoEditActivity$updateUserHeadPicture$1$result$1 userInfoEditActivity$updateUserHeadPicture$1$result$1 = new UserInfoEditActivity$updateUserHeadPicture$1$result$1(this.$file, null);
            this.label = 1;
            obj = BuildersKt.withContext(io, userInfoEditActivity$updateUserHeadPicture$1$result$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        MainCoroutineDispatcher main = Dispatchers.getMain();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$a, (String) obj, this.this$0, null);
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
