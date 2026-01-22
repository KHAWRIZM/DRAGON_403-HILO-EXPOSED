package com.qiahao.nextvideo.room.help;

import android.content.Context;
import android.graphics.Bitmap;
import com.luck.picture.lib.entity.LocalMedia;
import com.qhqc.core.basic.aws.AwsS3Repository;
import com.qhqc.core.basic.aws.RequestListener;
import com.qhqc.core.basic.aws.Result;
import com.qhqc.core.basic.aws.S3Configs;
import com.qhqc.core.basic.aws.S3UploadRequest;
import com.qiahao.hilo_message.data.GroupMessageNew;
import com.qiahao.hilo_message.data.RoomMessageMulti;
import com.qiahao.nextvideo.data.service.AliCloudService;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.BaseMonitor;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import roomMessage.RoomMessage;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001)B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007J\u001a\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007J*\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007J\"\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001bJ*\u0010\f\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u001bH\u0082@¢\u0006\u0002\u0010#J&\u0010$\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u001b2\b\u0010&\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007J\u0010\u0010'\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0006\u0010(\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006*"}, d2 = {"Lcom/qiahao/nextvideo/room/help/VideoUploadManager;", "", "<init>", "()V", "globalScope", "Lkotlinx/coroutines/CoroutineScope;", "mListener", "Lcom/qiahao/nextvideo/room/help/VideoUploadManager$UploadCallback;", "getMListener", "()Lcom/qiahao/nextvideo/room/help/VideoUploadManager$UploadCallback;", "setMListener", "(Lcom/qiahao/nextvideo/room/help/VideoUploadManager$UploadCallback;)V", "uploadImage", "", "media", "Lcom/luck/picture/lib/entity/LocalMedia;", "file", "Ljava/io/File;", "listener", "reSendImage", Constants.SHARED_MESSAGE_ID_FILE, "Lcom/qiahao/hilo_message/data/RoomMessageMulti;", "uploadVideo", "context", "Landroid/content/Context;", "resendVideo", "saveBitmapToFile", "", "bitmap", "Landroid/graphics/Bitmap;", "filePath", "Lcom/qhqc/core/basic/aws/Result;", "isImage", "", "parentPath", "(Ljava/io/File;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadGiftVideo", "savedPath", "giftVideo", "smallChangeData", TUIConstants.TUIBeauty.METHOD_DESTROY_XMAGIC, "UploadCallback", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nVideoUploadManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VideoUploadManager.kt\ncom/qiahao/nextvideo/room/help/VideoUploadManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,455:1\n1878#2,3:456\n*S KotlinDebug\n*F\n+ 1 VideoUploadManager.kt\ncom/qiahao/nextvideo/room/help/VideoUploadManager\n*L\n437#1:456,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class VideoUploadManager {

    @NotNull
    public static final VideoUploadManager INSTANCE = new VideoUploadManager();

    @NotNull
    private static final CoroutineScope globalScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));

    @Nullable
    private static UploadCallback mListener;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u0006J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001e\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J*\u0010\u0012\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0013\u001a\n\u0018\u00010\u0014j\u0004\u0018\u0001`\u0015H\u0096@¢\u0006\u0002\u0010\u0016J\u001e\u0010\r\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u0019J \u0010\u0012\u001a\u00020\u00032\u0010\b\u0002\u0010\u0013\u001a\n\u0018\u00010\u0014j\u0004\u0018\u0001`\u0015H\u0096@¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/qiahao/nextvideo/room/help/VideoUploadManager$UploadCallback;", "", "addMessageLocal", "", Constants.SHARED_MESSAGE_ID_FILE, "Lcom/qiahao/hilo_message/data/RoomMessageMulti;", "(Lcom/qiahao/hilo_message/data/RoomMessageMulti;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshLocalMessage", "onUploadProgress", "messageId", "", "progress", "", "onUploadSuccess", "LroomMessage/RoomMessage$GroupMessageSend;", "addMessage", "", "(LroomMessage/RoomMessage$GroupMessageSend;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onUploadFailed", BaseMonitor.COUNT_ERROR, "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Lcom/qiahao/hilo_message/data/RoomMessageMulti;Ljava/lang/Exception;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "imageUrl", "videoUrl", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/lang/Exception;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public interface UploadCallback {

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
        public static final class DefaultImpls {
            @Nullable
            public static Object addMessageLocal(@NotNull UploadCallback uploadCallback, @NotNull RoomMessageMulti roomMessageMulti, @NotNull Continuation<? super Unit> continuation) {
                return Unit.INSTANCE;
            }

            @Nullable
            public static Object onUploadFailed(@NotNull UploadCallback uploadCallback, @Nullable RoomMessageMulti roomMessageMulti, @Nullable Exception exc, @NotNull Continuation<? super Unit> continuation) {
                return Unit.INSTANCE;
            }

            public static /* synthetic */ Object onUploadFailed$default(UploadCallback uploadCallback, RoomMessageMulti roomMessageMulti, Exception exc, Continuation continuation, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onUploadFailed");
                }
                if ((i & 2) != 0) {
                    exc = null;
                }
                return uploadCallback.onUploadFailed(roomMessageMulti, exc, continuation);
            }

            public static void onUploadProgress(@NotNull UploadCallback uploadCallback, @NotNull String str, int i) {
                Intrinsics.checkNotNullParameter(str, "messageId");
            }

            @Nullable
            public static Object onUploadSuccess(@NotNull UploadCallback uploadCallback, @NotNull RoomMessage.GroupMessageSend groupMessageSend, boolean z, @NotNull Continuation<? super Unit> continuation) {
                return Unit.INSTANCE;
            }

            @Nullable
            public static Object refreshLocalMessage(@NotNull UploadCallback uploadCallback, @NotNull RoomMessageMulti roomMessageMulti, @NotNull Continuation<? super Unit> continuation) {
                return Unit.INSTANCE;
            }

            @Nullable
            public static Object onUploadFailed(@NotNull UploadCallback uploadCallback, @Nullable Exception exc, @NotNull Continuation<? super Unit> continuation) {
                return Unit.INSTANCE;
            }

            public static /* synthetic */ Object onUploadFailed$default(UploadCallback uploadCallback, Exception exc, Continuation continuation, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onUploadFailed");
                }
                if ((i & 1) != 0) {
                    exc = null;
                }
                return uploadCallback.onUploadFailed(exc, continuation);
            }

            @Nullable
            public static Object onUploadSuccess(@NotNull UploadCallback uploadCallback, @NotNull String str, @NotNull String str2, @NotNull Continuation<? super Unit> continuation) {
                return Unit.INSTANCE;
            }
        }

        @Nullable
        Object addMessageLocal(@NotNull RoomMessageMulti roomMessageMulti, @NotNull Continuation<? super Unit> continuation);

        @Nullable
        Object onUploadFailed(@Nullable RoomMessageMulti roomMessageMulti, @Nullable Exception exc, @NotNull Continuation<? super Unit> continuation);

        @Nullable
        Object onUploadFailed(@Nullable Exception exc, @NotNull Continuation<? super Unit> continuation);

        void onUploadProgress(@NotNull String messageId, int progress);

        @Nullable
        Object onUploadSuccess(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super Unit> continuation);

        @Nullable
        Object onUploadSuccess(@NotNull RoomMessage.GroupMessageSend groupMessageSend, boolean z, @NotNull Continuation<? super Unit> continuation);

        @Nullable
        Object refreshLocalMessage(@NotNull RoomMessageMulti roomMessageMulti, @NotNull Continuation<? super Unit> continuation);
    }

    private VideoUploadManager() {
    }

    public static /* synthetic */ void reSendImage$default(VideoUploadManager videoUploadManager, RoomMessageMulti roomMessageMulti, UploadCallback uploadCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            uploadCallback = null;
        }
        videoUploadManager.reSendImage(roomMessageMulti, uploadCallback);
    }

    public static /* synthetic */ void resendVideo$default(VideoUploadManager videoUploadManager, RoomMessageMulti roomMessageMulti, Context context, UploadCallback uploadCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            uploadCallback = null;
        }
        videoUploadManager.resendVideo(roomMessageMulti, context, uploadCallback);
    }

    public static /* synthetic */ void uploadGiftVideo$default(VideoUploadManager videoUploadManager, String str, File file, UploadCallback uploadCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            uploadCallback = null;
        }
        videoUploadManager.uploadGiftVideo(str, file, uploadCallback);
    }

    public static /* synthetic */ void uploadImage$default(VideoUploadManager videoUploadManager, LocalMedia localMedia, File file, UploadCallback uploadCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            uploadCallback = null;
        }
        videoUploadManager.uploadImage(localMedia, file, uploadCallback);
    }

    public static /* synthetic */ void uploadVideo$default(VideoUploadManager videoUploadManager, LocalMedia localMedia, File file, Context context, UploadCallback uploadCallback, int i, Object obj) {
        if ((i & 8) != 0) {
            uploadCallback = null;
        }
        videoUploadManager.uploadVideo(localMedia, file, context, uploadCallback);
    }

    public final void destroy() {
        mListener = null;
        AwsS3Repository.Companion.getInstance().clear(this);
        JobKt.cancelChildren$default(globalScope.getCoroutineContext(), (CancellationException) null, 1, (Object) null);
    }

    @Nullable
    public final UploadCallback getMListener() {
        return mListener;
    }

    public final void reSendImage(@NotNull RoomMessageMulti message, @Nullable UploadCallback listener) {
        Intrinsics.checkNotNullParameter(message, Constants.SHARED_MESSAGE_ID_FILE);
        BuildersKt.launch$default(globalScope, (CoroutineContext) null, (CoroutineStart) null, new VideoUploadManager$reSendImage$1(listener, message, null), 3, (Object) null);
    }

    public final void resendVideo(@NotNull RoomMessageMulti message, @NotNull Context context, @Nullable UploadCallback listener) {
        Intrinsics.checkNotNullParameter(message, Constants.SHARED_MESSAGE_ID_FILE);
        Intrinsics.checkNotNullParameter(context, "context");
        mListener = listener;
        BuildersKt.launch$default(globalScope, (CoroutineContext) null, (CoroutineStart) null, new VideoUploadManager$resendVideo$1(message, context, null), 3, (Object) null);
    }

    @Nullable
    public final String saveBitmapToFile(@NotNull Bitmap bitmap, @NotNull String filePath) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath));
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return filePath;
        } catch (Exception unused) {
            return null;
        }
    }

    public final void setMListener(@Nullable UploadCallback uploadCallback) {
        mListener = uploadCallback;
    }

    public final void smallChangeData(@Nullable RoomMessageMulti message) {
        String str;
        GroupMessageNew data;
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        if (meetingRoomManager.isRoomSmall()) {
            int i = 0;
            for (Object obj : meetingRoomManager.getMRoomMessageData()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                GroupMessageNew data2 = ((RoomMessageMulti) obj).getData();
                String str2 = null;
                if (data2 != null) {
                    str = data2.getMsgId();
                } else {
                    str = null;
                }
                if (message != null && (data = message.getData()) != null) {
                    str2 = data.getMsgId();
                }
                if (Intrinsics.areEqual(str, str2)) {
                    MeetingRoomManager.INSTANCE.getMRoomMessageData().set(i, message);
                }
                i = i2;
            }
        }
    }

    public final void uploadGiftVideo(@Nullable String savedPath, @Nullable File giftVideo, @Nullable UploadCallback listener) {
        if (savedPath != null && savedPath.length() != 0 && giftVideo != null) {
            mListener = listener;
            BuildersKt.launch$default(globalScope, (CoroutineContext) null, (CoroutineStart) null, new VideoUploadManager$uploadGiftVideo$1(savedPath, giftVideo, null), 3, (Object) null);
        }
    }

    public final void uploadImage(@NotNull LocalMedia media, @NotNull File file, @Nullable UploadCallback listener) {
        Intrinsics.checkNotNullParameter(media, "media");
        Intrinsics.checkNotNullParameter(file, "file");
        BuildersKt.launch$default(globalScope, (CoroutineContext) null, (CoroutineStart) null, new VideoUploadManager$uploadImage$1(listener, media, file, null), 3, (Object) null);
    }

    public final void uploadVideo(@NotNull LocalMedia media, @NotNull File file, @NotNull Context context, @Nullable UploadCallback listener) {
        Intrinsics.checkNotNullParameter(media, "media");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(context, "context");
        BuildersKt.launch$default(globalScope, (CoroutineContext) null, (CoroutineStart) null, new VideoUploadManager$uploadVideo$1(file, context, media, listener, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object uploadImage(File file, boolean z, String str, Continuation<? super Result> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        S3UploadRequest.Builder uploadPath = new S3UploadRequest.Builder().setUploadPath(str);
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        uploadPath.setAvailablePath(absolutePath).setS3Config(new S3Configs.Builder().build(z ? S3Configs.Type.IMAGE : S3Configs.Type.VIDEO)).setUploadListener(new RequestListener() { // from class: com.qiahao.nextvideo.room.help.VideoUploadManager$uploadImage$3$1
            public void onComplete(Result result) {
                Intrinsics.checkNotNullParameter(result, "result");
                RequestListener.DefaultImpls.onComplete(this, result);
                safeContinuation.resumeWith(kotlin.Result.constructor-impl(result));
            }

            public void onFailed(Result result) {
                Intrinsics.checkNotNullParameter(result, "result");
                RequestListener.DefaultImpls.onFailed(this, result);
                safeContinuation.resumeWith(kotlin.Result.constructor-impl(result));
            }

            public void onProgress(Result result) {
                RequestListener.DefaultImpls.onProgress(this, result);
            }
        }).build(INSTANCE).start(globalScope);
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object uploadImage$default(VideoUploadManager videoUploadManager, File file, boolean z, String str, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            str = AliCloudService.OSS_MESSAGES;
        }
        return videoUploadManager.uploadImage(file, z, str, continuation);
    }
}
