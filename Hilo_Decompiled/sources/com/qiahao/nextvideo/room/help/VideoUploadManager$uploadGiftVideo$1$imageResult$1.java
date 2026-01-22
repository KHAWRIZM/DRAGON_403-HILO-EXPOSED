package com.qiahao.nextvideo.room.help;

import com.qhqc.core.basic.aws.Result;
import com.qiahao.nextvideo.data.service.AliCloudService;
import java.io.File;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.room.help.VideoUploadManager$uploadGiftVideo$1$imageResult$1", f = "VideoUploadManager.kt", i = {}, l = {398}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class VideoUploadManager$uploadGiftVideo$1$imageResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends Boolean, ? extends String>>, Object> {
    final /* synthetic */ String $savedPath;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoUploadManager$uploadGiftVideo$1$imageResult$1(String str, Continuation<? super VideoUploadManager$uploadGiftVideo$1$imageResult$1> continuation) {
        super(2, continuation);
        this.$savedPath = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoUploadManager$uploadGiftVideo$1$imageResult$1(this.$savedPath, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                if (this.$savedPath.length() > 0) {
                    VideoUploadManager videoUploadManager = VideoUploadManager.INSTANCE;
                    File file = new File(this.$savedPath);
                    this.label = 1;
                    obj = videoUploadManager.uploadImage(file, true, AliCloudService.OSS_GIFT, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    return new Pair(Boxing.boxBoolean(false), "");
                }
            }
            Result result = (Result) obj;
            Boolean boxBoolean = Boxing.boxBoolean(true);
            if (result == null || (str = result.getRelativeUrl()) == null) {
                str = "";
            }
            return new Pair(boxBoolean, str);
        } catch (Exception unused) {
            return new Pair(Boxing.boxBoolean(false), "");
        }
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<Boolean, String>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
