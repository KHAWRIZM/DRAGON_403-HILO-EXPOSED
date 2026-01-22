package com.qiahao.nextvideo.utilities.animation;

import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import com.qiahao.nextvideo.utilities.userproxy.UserProxyUtility;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.utilities.animation.AnimationQueueManager$animateViewOut$1$1", f = "AnimationQueueManager.kt", i = {0, 1}, l = {200, UserProxyUtility.rocketBanner}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
@SourceDebugExtension({"SMAP\nAnimationQueueManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnimationQueueManager.kt\ncom/qiahao/nextvideo/utilities/animation/AnimationQueueManager$animateViewOut$1$1\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,195:1\n116#2,7:196\n124#2,2:204\n1#3:203\n*S KotlinDebug\n*F\n+ 1 AnimationQueueManager.kt\ncom/qiahao/nextvideo/utilities/animation/AnimationQueueManager$animateViewOut$1$1\n*L\n172#1:196,7\n172#1:204,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AnimationQueueManager$animateViewOut$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $dataId;
    final /* synthetic */ ViewDataBinding $view;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ AnimationQueueManager<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnimationQueueManager$animateViewOut$1$1(AnimationQueueManager<T> animationQueueManager, ViewDataBinding viewDataBinding, String str, Continuation<? super AnimationQueueManager$animateViewOut$1$1> continuation) {
        super(2, continuation);
        this.this$0 = animationQueueManager;
        this.$view = viewDataBinding;
        this.$dataId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnimationQueueManager$animateViewOut$1$1(this.this$0, this.$view, this.$dataId, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Mutex mutex;
        AnimationQueueManager animationQueueManager;
        ViewDataBinding viewDataBinding;
        String str;
        Mutex mutex2;
        Throwable th;
        LinkedList linkedList;
        ViewGroup viewGroup;
        Map map;
        Map map2;
        Object tryShowNextView;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        mutex2 = (Mutex) this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            Unit unit = Unit.INSTANCE;
                            mutex2.unlock(null);
                            return Unit.INSTANCE;
                        } catch (Throwable th2) {
                            th = th2;
                            mutex2.unlock(null);
                            throw th;
                        }
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str = (String) this.L$3;
                viewDataBinding = (ViewDataBinding) this.L$2;
                animationQueueManager = (AnimationQueueManager) this.L$1;
                Mutex mutex3 = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
                mutex = mutex3;
            } else {
                ResultKt.throwOnFailure(obj);
                mutex = ((AnimationQueueManager) this.this$0).mutex;
                animationQueueManager = this.this$0;
                ViewDataBinding viewDataBinding2 = this.$view;
                String str2 = this.$dataId;
                this.L$0 = mutex;
                this.L$1 = animationQueueManager;
                this.L$2 = viewDataBinding2;
                this.L$3 = str2;
                this.label = 1;
                if (mutex.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                viewDataBinding = viewDataBinding2;
                str = str2;
            }
            linkedList = animationQueueManager.activeQueue;
            Boolean boxBoolean = Boxing.boxBoolean(linkedList.remove(viewDataBinding));
            if (!boxBoolean.booleanValue()) {
                boxBoolean = null;
            }
            if (boxBoolean != null) {
                viewGroup = animationQueueManager.container;
                if (viewGroup != null) {
                    viewGroup.removeView(viewDataBinding.getRoot());
                }
                map = animationQueueManager.viewDataMap;
                map.remove(str);
                map2 = animationQueueManager.animationJobs;
                map2.remove(str);
                this.L$0 = mutex;
                this.L$1 = null;
                this.L$2 = null;
                this.L$3 = null;
                this.label = 2;
                tryShowNextView = animationQueueManager.tryShowNextView(this);
                if (tryShowNextView == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            mutex2 = mutex;
            Unit unit2 = Unit.INSTANCE;
            mutex2.unlock(null);
            return Unit.INSTANCE;
        } catch (Throwable th3) {
            mutex2 = mutex;
            th = th3;
            mutex2.unlock(null);
            throw th;
        }
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
