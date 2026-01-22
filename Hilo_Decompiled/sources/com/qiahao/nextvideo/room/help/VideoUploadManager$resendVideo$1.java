package com.qiahao.nextvideo.room.help;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.Glide;
import com.qiahao.base_common.utils.PathHelper;
import com.qiahao.hilo_message.data.GroupMessageNew;
import com.qiahao.hilo_message.data.MsgBody;
import com.qiahao.hilo_message.data.RoomMessageMulti;
import com.qiahao.hilo_message.data.VideoElemContent;
import com.qiahao.hilo_message.utils.BuildMessageUtilsKt;
import com.qiahao.nextvideo.room.help.VideoUploadManager;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.apache.commons.sudcompress.archivers.zip.UnixStat;
import roomMessage.RoomMessage;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.room.help.VideoUploadManager$resendVideo$1", f = "VideoUploadManager.kt", i = {0, 1, 1, 2, 2}, l = {256, 322, 323, 330, 333, 340}, m = "invokeSuspend", n = {"$this$launch", "video", "videoResult", "video", "thumbImageResult"}, s = {"L$0", "L$0", "L$2", "L$0", "L$2"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class VideoUploadManager$resendVideo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ RoomMessageMulti $message;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoUploadManager$resendVideo$1(RoomMessageMulti roomMessageMulti, Context context, Continuation<? super VideoUploadManager$resendVideo$1> continuation) {
        super(2, continuation);
        this.$message = roomMessageMulti;
        this.$context = context;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        VideoUploadManager$resendVideo$1 videoUploadManager$resendVideo$1 = new VideoUploadManager$resendVideo$1(this.$message, this.$context, continuation);
        videoUploadManager$resendVideo$1.L$0 = obj;
        return videoUploadManager$resendVideo$1;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000b. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:21:0x01c2 A[Catch: Exception -> 0x0024, TryCatch #1 {Exception -> 0x0024, blocks: (B:12:0x001f, B:14:0x0247, B:15:0x0027, B:17:0x0038, B:19:0x01b4, B:21:0x01c2, B:23:0x01ce, B:25:0x01e6, B:27:0x01ec, B:29:0x01f5, B:30:0x01f8, B:32:0x0203, B:35:0x0219, B:37:0x021f, B:38:0x0227, B:40:0x022f, B:45:0x004c, B:47:0x01a2, B:51:0x0087, B:53:0x00a9, B:55:0x00af, B:58:0x00bf, B:61:0x00c8, B:69:0x0102, B:71:0x0105, B:74:0x013c, B:81:0x00f9, B:64:0x00d1, B:67:0x00e2), top: B:2:0x000b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x021f A[Catch: Exception -> 0x0024, TryCatch #1 {Exception -> 0x0024, blocks: (B:12:0x001f, B:14:0x0247, B:15:0x0027, B:17:0x0038, B:19:0x01b4, B:21:0x01c2, B:23:0x01ce, B:25:0x01e6, B:27:0x01ec, B:29:0x01f5, B:30:0x01f8, B:32:0x0203, B:35:0x0219, B:37:0x021f, B:38:0x0227, B:40:0x022f, B:45:0x004c, B:47:0x01a2, B:51:0x0087, B:53:0x00a9, B:55:0x00af, B:58:0x00bf, B:61:0x00c8, B:69:0x0102, B:71:0x0105, B:74:0x013c, B:81:0x00f9, B:64:0x00d1, B:67:0x00e2), top: B:2:0x000b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x022f A[Catch: Exception -> 0x0024, TryCatch #1 {Exception -> 0x0024, blocks: (B:12:0x001f, B:14:0x0247, B:15:0x0027, B:17:0x0038, B:19:0x01b4, B:21:0x01c2, B:23:0x01ce, B:25:0x01e6, B:27:0x01ec, B:29:0x01f5, B:30:0x01f8, B:32:0x0203, B:35:0x0219, B:37:0x021f, B:38:0x0227, B:40:0x022f, B:45:0x004c, B:47:0x01a2, B:51:0x0087, B:53:0x00a9, B:55:0x00af, B:58:0x00bf, B:61:0x00c8, B:69:0x0102, B:71:0x0105, B:74:0x013c, B:81:0x00f9, B:64:0x00d1, B:67:0x00e2), top: B:2:0x000b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01b3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00bf A[Catch: Exception -> 0x0024, TRY_ENTER, TryCatch #1 {Exception -> 0x0024, blocks: (B:12:0x001f, B:14:0x0247, B:15:0x0027, B:17:0x0038, B:19:0x01b4, B:21:0x01c2, B:23:0x01ce, B:25:0x01e6, B:27:0x01ec, B:29:0x01f5, B:30:0x01f8, B:32:0x0203, B:35:0x0219, B:37:0x021f, B:38:0x0227, B:40:0x022f, B:45:0x004c, B:47:0x01a2, B:51:0x0087, B:53:0x00a9, B:55:0x00af, B:58:0x00bf, B:61:0x00c8, B:69:0x0102, B:71:0x0105, B:74:0x013c, B:81:0x00f9, B:64:0x00d1, B:67:0x00e2), top: B:2:0x000b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0102 A[Catch: Exception -> 0x0024, TryCatch #1 {Exception -> 0x0024, blocks: (B:12:0x001f, B:14:0x0247, B:15:0x0027, B:17:0x0038, B:19:0x01b4, B:21:0x01c2, B:23:0x01ce, B:25:0x01e6, B:27:0x01ec, B:29:0x01f5, B:30:0x01f8, B:32:0x0203, B:35:0x0219, B:37:0x021f, B:38:0x0227, B:40:0x022f, B:45:0x004c, B:47:0x01a2, B:51:0x0087, B:53:0x00a9, B:55:0x00af, B:58:0x00bf, B:61:0x00c8, B:69:0x0102, B:71:0x0105, B:74:0x013c, B:81:0x00f9, B:64:0x00d1, B:67:0x00e2), top: B:2:0x000b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0105 A[Catch: Exception -> 0x0024, TryCatch #1 {Exception -> 0x0024, blocks: (B:12:0x001f, B:14:0x0247, B:15:0x0027, B:17:0x0038, B:19:0x01b4, B:21:0x01c2, B:23:0x01ce, B:25:0x01e6, B:27:0x01ec, B:29:0x01f5, B:30:0x01f8, B:32:0x0203, B:35:0x0219, B:37:0x021f, B:38:0x0227, B:40:0x022f, B:45:0x004c, B:47:0x01a2, B:51:0x0087, B:53:0x00a9, B:55:0x00af, B:58:0x00bf, B:61:0x00c8, B:69:0x0102, B:71:0x0105, B:74:0x013c, B:81:0x00f9, B:64:0x00d1, B:67:0x00e2), top: B:2:0x000b, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        GroupMessageNew data;
        VideoElemContent videoInfo;
        Bitmap bitmap;
        Deferred async$default;
        Object await;
        VideoElemContent videoElemContent;
        RoomMessageMulti roomMessageMulti;
        Pair pair;
        Object await2;
        GroupMessageNew data2;
        VideoUploadManager.UploadCallback mListener;
        RoomMessageMulti roomMessageMulti2;
        List msgBody;
        MsgBody msgBody2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (Exception e) {
            e.printStackTrace();
            GroupMessageNew data3 = this.$message.getData();
            if (data3 != null) {
                data3.setStatus(Boxing.boxInt(2));
            }
            VideoUploadManager.UploadCallback mListener2 = VideoUploadManager.INSTANCE.getMListener();
            if (mListener2 != null) {
                RoomMessageMulti roomMessageMulti3 = this.$message;
                Exception exc = new Exception("Upload failed");
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 6;
                if (mListener2.onUploadFailed(roomMessageMulti3, exc, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.L$0;
                GroupMessageNew data4 = this.$message.getData();
                if (data4 != null) {
                    data4.setStatus(Boxing.boxInt(0));
                }
                VideoUploadManager.UploadCallback mListener3 = VideoUploadManager.INSTANCE.getMListener();
                if (mListener3 != null) {
                    RoomMessageMulti roomMessageMulti4 = this.$message;
                    this.L$0 = coroutineScope;
                    this.label = 1;
                    if (mListener3.refreshLocalMessage(roomMessageMulti4, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                VideoElemContent videoElemContent2 = new VideoElemContent((Integer) null, (Integer) null, (Long) null, (String) null, (Integer) null, (Long) null, (String) null, (String) null, (String) null, UnixStat.DEFAULT_LINK_PERM, (DefaultConstructorMarker) null);
                data = this.$message.getData();
                if (data != null && (videoInfo = BuildMessageUtilsKt.videoInfo(data)) != null) {
                    Context context = this.$context;
                    RoomMessageMulti roomMessageMulti5 = this.$message;
                    String str = "";
                    if (TextUtils.isEmpty(videoInfo.getThumbUrl())) {
                        String localThumbPath = videoInfo.getLocalThumbPath();
                        if (localThumbPath == null) {
                            localThumbPath = "";
                        }
                        if (!new File(localThumbPath).exists()) {
                            try {
                                com.bumptech.glide.i b = Glide.with(context).b();
                                String localThumbPath2 = videoInfo.getLocalThumbPath();
                                if (localThumbPath2 == null) {
                                    localThumbPath2 = "";
                                }
                                bitmap = (Bitmap) b.H0(Uri.fromFile(new File(localThumbPath2))).Q0().get();
                                if (bitmap == null) {
                                    return Unit.INSTANCE;
                                }
                                int width = bitmap.getWidth();
                                int height = bitmap.getHeight();
                                String saveBitmapToFile = VideoUploadManager.INSTANCE.saveBitmapToFile(bitmap, PathHelper.INSTANCE.getAppPrivateDownloadPath() + File.separator + System.currentTimeMillis() + ".png");
                                if (saveBitmapToFile != null) {
                                    str = saveBitmapToFile;
                                }
                                videoElemContent2.setThumbHeight(Boxing.boxInt(height));
                                videoElemContent2.setThumbWidth(Boxing.boxInt(width));
                                videoElemContent2.setThumbSize(Boxing.boxLong(bitmap.getByteCount() / LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY));
                                videoElemContent2.setLocalThumbPath(str);
                                videoElemContent2.setVideoSecond(videoInfo.getVideoSecond());
                                videoElemContent2.setVideoSize(videoInfo.getVideoSize());
                                videoElemContent2.setLocalPath(videoInfo.getLocalPath());
                                Deferred async$default2 = BuildersKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new VideoUploadManager$resendVideo$1$1$imageResult$1(videoInfo, str, null), 3, (Object) null);
                                async$default = BuildersKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new VideoUploadManager$resendVideo$1$1$videoResult$1(videoInfo, null), 3, (Object) null);
                                this.L$0 = videoElemContent2;
                                this.L$1 = roomMessageMulti5;
                                this.L$2 = async$default;
                                this.label = 2;
                                await = async$default2.await(this);
                                if (await == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                videoElemContent = videoElemContent2;
                                roomMessageMulti = roomMessageMulti5;
                                pair = (Pair) await;
                                this.L$0 = videoElemContent;
                                this.L$1 = roomMessageMulti;
                                this.L$2 = pair;
                                this.label = 3;
                                await2 = async$default.await(this);
                                if (await2 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                Pair pair2 = (Pair) await2;
                                if (!((Boolean) pair.getFirst()).booleanValue() && ((Boolean) pair2.getFirst()).booleanValue()) {
                                    videoElemContent.setThumbUrl((String) pair.getSecond());
                                    videoElemContent.setVideoUrl((String) pair2.getSecond());
                                    GroupMessageNew data5 = roomMessageMulti.getData();
                                    if (data5 != null && (msgBody = data5.getMsgBody()) != null && (msgBody2 = (MsgBody) msgBody.get(0)) != null) {
                                        msgBody2.setVideoContent(videoElemContent);
                                    }
                                    VideoUploadManager videoUploadManager = VideoUploadManager.INSTANCE;
                                    videoUploadManager.smallChangeData(roomMessageMulti);
                                    VideoUploadManager.UploadCallback mListener4 = videoUploadManager.getMListener();
                                    if (mListener4 != null) {
                                        RoomMessage.GroupMessageSend groupMessageSend = BuildMessageUtilsKt.toGroupMessageSend(roomMessageMulti);
                                        this.L$0 = null;
                                        this.L$1 = null;
                                        this.L$2 = null;
                                        this.label = 4;
                                        if (mListener4.onUploadSuccess(groupMessageSend, false, (Continuation<? super Unit>) this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    }
                                } else {
                                    data2 = roomMessageMulti.getData();
                                    if (data2 != null) {
                                        data2.setStatus(Boxing.boxInt(2));
                                    }
                                    mListener = VideoUploadManager.INSTANCE.getMListener();
                                    if (mListener != null) {
                                        Exception exc2 = new Exception("Upload failed");
                                        this.L$0 = roomMessageMulti;
                                        this.L$1 = null;
                                        this.L$2 = null;
                                        this.label = 5;
                                        if (mListener.onUploadFailed(roomMessageMulti, exc2, this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        roomMessageMulti2 = roomMessageMulti;
                                        roomMessageMulti = roomMessageMulti2;
                                    }
                                    VideoUploadManager.INSTANCE.smallChangeData(roomMessageMulti);
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                return Unit.INSTANCE;
                            }
                        }
                    }
                    bitmap = null;
                    if (bitmap == null) {
                    }
                }
                return Unit.INSTANCE;
            case 1:
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                VideoElemContent videoElemContent22 = new VideoElemContent((Integer) null, (Integer) null, (Long) null, (String) null, (Integer) null, (Long) null, (String) null, (String) null, (String) null, UnixStat.DEFAULT_LINK_PERM, (DefaultConstructorMarker) null);
                data = this.$message.getData();
                if (data != null) {
                    Context context2 = this.$context;
                    RoomMessageMulti roomMessageMulti52 = this.$message;
                    String str2 = "";
                    if (TextUtils.isEmpty(videoInfo.getThumbUrl())) {
                    }
                    bitmap = null;
                    if (bitmap == null) {
                    }
                    break;
                }
                return Unit.INSTANCE;
            case 2:
                async$default = (Deferred) this.L$2;
                roomMessageMulti = (RoomMessageMulti) this.L$1;
                videoElemContent = (VideoElemContent) this.L$0;
                ResultKt.throwOnFailure(obj);
                await = obj;
                pair = (Pair) await;
                this.L$0 = videoElemContent;
                this.L$1 = roomMessageMulti;
                this.L$2 = pair;
                this.label = 3;
                await2 = async$default.await(this);
                if (await2 == coroutine_suspended) {
                }
                Pair pair22 = (Pair) await2;
                if (!((Boolean) pair.getFirst()).booleanValue()) {
                    break;
                }
                data2 = roomMessageMulti.getData();
                if (data2 != null) {
                }
                mListener = VideoUploadManager.INSTANCE.getMListener();
                if (mListener != null) {
                }
                VideoUploadManager.INSTANCE.smallChangeData(roomMessageMulti);
                return Unit.INSTANCE;
            case 3:
                Pair pair3 = (Pair) this.L$2;
                roomMessageMulti = (RoomMessageMulti) this.L$1;
                videoElemContent = (VideoElemContent) this.L$0;
                ResultKt.throwOnFailure(obj);
                pair = pair3;
                await2 = obj;
                Pair pair222 = (Pair) await2;
                if (!((Boolean) pair.getFirst()).booleanValue()) {
                }
                data2 = roomMessageMulti.getData();
                if (data2 != null) {
                }
                mListener = VideoUploadManager.INSTANCE.getMListener();
                if (mListener != null) {
                }
                VideoUploadManager.INSTANCE.smallChangeData(roomMessageMulti);
                return Unit.INSTANCE;
            case 4:
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            case 5:
                roomMessageMulti2 = (RoomMessageMulti) this.L$0;
                ResultKt.throwOnFailure(obj);
                roomMessageMulti = roomMessageMulti2;
                VideoUploadManager.INSTANCE.smallChangeData(roomMessageMulti);
                return Unit.INSTANCE;
            case 6:
                ResultKt.throwOnFailure(obj);
                VideoUploadManager.INSTANCE.smallChangeData(this.$message);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
