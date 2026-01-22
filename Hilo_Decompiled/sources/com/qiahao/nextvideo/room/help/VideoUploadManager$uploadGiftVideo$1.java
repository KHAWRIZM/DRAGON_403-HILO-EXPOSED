package com.qiahao.nextvideo.room.help;

import com.qiahao.nextvideo.room.help.VideoUploadManager;
import com.taobao.accs.flowcontrol.FlowControl;
import java.io.File;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.room.help.VideoUploadManager$uploadGiftVideo$1", f = "VideoUploadManager.kt", i = {0, 1}, l = {417, 418, FlowControl.STATUS_FLOW_CTRL_BRUSH, 424, 427}, m = "invokeSuspend", n = {"videoResult", "thumbImageResult"}, s = {"L$0", "L$0"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class VideoUploadManager$uploadGiftVideo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $giftVideo;
    final /* synthetic */ String $savedPath;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoUploadManager$uploadGiftVideo$1(String str, File file, Continuation<? super VideoUploadManager$uploadGiftVideo$1> continuation) {
        super(2, continuation);
        this.$savedPath = str;
        this.$giftVideo = file;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        VideoUploadManager$uploadGiftVideo$1 videoUploadManager$uploadGiftVideo$1 = new VideoUploadManager$uploadGiftVideo$1(this.$savedPath, this.$giftVideo, continuation);
        videoUploadManager$uploadGiftVideo$1.L$0 = obj;
        return videoUploadManager$uploadGiftVideo$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00c4 A[Catch: Exception -> 0x002c, TRY_LEAVE, TryCatch #0 {Exception -> 0x002c, blocks: (B:15:0x0027, B:17:0x0033, B:19:0x0083, B:21:0x0091, B:23:0x009d, B:25:0x00a5, B:28:0x00bc, B:30:0x00c4, B:34:0x003e, B:36:0x0076, B:40:0x004b), top: B:2:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Deferred async$default;
        Object await;
        Pair pair;
        Object await2;
        VideoUploadManager.UploadCallback mListener;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (Exception e) {
            VideoUploadManager.UploadCallback mListener2 = VideoUploadManager.INSTANCE.getMListener();
            if (mListener2 != null) {
                this.L$0 = null;
                this.label = 5;
                if (mListener2.onUploadFailed(e, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3 && i != 4) {
                        if (i == 5) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
                Pair pair2 = (Pair) this.L$0;
                ResultKt.throwOnFailure(obj);
                pair = pair2;
                await2 = obj;
                Pair pair3 = (Pair) await2;
                if (!((Boolean) pair.getFirst()).booleanValue() && ((Boolean) pair3.getFirst()).booleanValue()) {
                    VideoUploadManager.UploadCallback mListener3 = VideoUploadManager.INSTANCE.getMListener();
                    if (mListener3 != null) {
                        String str = (String) pair.getSecond();
                        String str2 = (String) pair3.getSecond();
                        this.L$0 = null;
                        this.label = 3;
                        if (mListener3.onUploadSuccess(str, str2, (Continuation<? super Unit>) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    mListener = VideoUploadManager.INSTANCE.getMListener();
                    if (mListener != null) {
                        Exception exc = new Exception("Upload failed");
                        this.L$0 = null;
                        this.label = 4;
                        if (mListener.onUploadFailed(exc, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
                return Unit.INSTANCE;
            }
            async$default = (Deferred) this.L$0;
            ResultKt.throwOnFailure(obj);
            await = obj;
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Deferred async$default2 = BuildersKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new VideoUploadManager$uploadGiftVideo$1$imageResult$1(this.$savedPath, null), 3, (Object) null);
            async$default = BuildersKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new VideoUploadManager$uploadGiftVideo$1$videoResult$1(this.$giftVideo, null), 3, (Object) null);
            this.L$0 = async$default;
            this.label = 1;
            await = async$default2.await(this);
            if (await == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        pair = (Pair) await;
        this.L$0 = pair;
        this.label = 2;
        await2 = async$default.await(this);
        if (await2 == coroutine_suspended) {
            return coroutine_suspended;
        }
        Pair pair32 = (Pair) await2;
        if (!((Boolean) pair.getFirst()).booleanValue()) {
        }
        mListener = VideoUploadManager.INSTANCE.getMListener();
        if (mListener != null) {
        }
        return Unit.INSTANCE;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
