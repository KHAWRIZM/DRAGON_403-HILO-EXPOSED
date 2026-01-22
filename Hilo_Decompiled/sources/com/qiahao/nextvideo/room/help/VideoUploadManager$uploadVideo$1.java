package com.qiahao.nextvideo.room.help;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import com.bumptech.glide.Glide;
import com.luck.picture.lib.entity.LocalMedia;
import com.qiahao.base_common.utils.PathHelper;
import com.qiahao.hilo_message.data.RoomMessageMulti;
import com.qiahao.hilo_message.utils.BuildMessageUtilsKt;
import com.qiahao.nextvideo.room.help.VideoUploadManager;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.utilities.userproxy.UserProxyUtility;
import com.tencent.qcloud.tuicore.TUIConstants;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import roomMessage.RoomMessage;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.room.help.VideoUploadManager$uploadVideo$1", f = "VideoUploadManager.kt", i = {0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 4}, l = {UserProxyUtility.hiloGameNewRound, RoomEvent.ROOM_IN, RoomEvent.ROOM_INVITE_USER_UP_MIC, 223, 237, 243}, m = "invokeSuspend", n = {"$this$launch", TUIConstants.TUIChat.METHOD_SEND_MESSAGE, "video", "savedPath", TUIConstants.TUIChat.METHOD_SEND_MESSAGE, "video", "videoResult", TUIConstants.TUIChat.METHOD_SEND_MESSAGE, "video", "thumbImageResult", TUIConstants.TUIChat.METHOD_SEND_MESSAGE, TUIConstants.TUIChat.METHOD_SEND_MESSAGE}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$0"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class VideoUploadManager$uploadVideo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ File $file;
    final /* synthetic */ VideoUploadManager.UploadCallback $listener;
    final /* synthetic */ LocalMedia $media;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoUploadManager$uploadVideo$1(File file, Context context, LocalMedia localMedia, VideoUploadManager.UploadCallback uploadCallback, Continuation<? super VideoUploadManager$uploadVideo$1> continuation) {
        super(2, continuation);
        this.$file = file;
        this.$context = context;
        this.$media = localMedia;
        this.$listener = uploadCallback;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        VideoUploadManager$uploadVideo$1 videoUploadManager$uploadVideo$1 = new VideoUploadManager$uploadVideo$1(this.$file, this.$context, this.$media, this.$listener, continuation);
        videoUploadManager$uploadVideo$1.L$0 = obj;
        return videoUploadManager$uploadVideo$1;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000b. Please report as an issue. */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x0043: MOVE (r4 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]) (LINE:68), block:B:100:0x0043 */
    /* JADX WARN: Removed duplicated region for block: B:20:0x01e3 A[Catch: Exception -> 0x0042, TryCatch #4 {Exception -> 0x0042, blocks: (B:16:0x003a, B:18:0x01d5, B:20:0x01e3, B:22:0x01ef, B:47:0x0242, B:54:0x0052, B:56:0x01c3, B:60:0x0069, B:62:0x0190, B:83:0x016d, B:85:0x0178), top: B:2:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x028c A[Catch: Exception -> 0x0025, TRY_LEAVE, TryCatch #3 {Exception -> 0x0025, blocks: (B:11:0x0020, B:48:0x027a, B:50:0x028c), top: B:2:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01d4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01c2 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        RoomMessage.GroupMessageSend groupMessageSend;
        RoomMessage.GroupMessageSend groupMessageSend2;
        RoomMessageMulti roomMessageMulti;
        VideoUploadManager.UploadCallback mListener;
        RoomMessage.GroupMessageSend.Builder builder;
        RoomMessage.GroupMessageSend.Builder status;
        CoroutineScope coroutineScope;
        RoomMessage.VideoElemContent.Builder newBuilder;
        int i;
        int i2;
        String saveBitmapToFile;
        RoomMessage.GroupMessageSend roomMessageVideo;
        String str;
        Deferred async$default;
        Object await;
        Pair pair;
        Object await2;
        Pair pair2;
        VideoUploadManager.UploadCallback mListener2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        RoomMessage.GroupMessageSend groupMessageSend3 = null;
        try {
            try {
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            e = e2;
            groupMessageSend3 = groupMessageSend;
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.L$0;
                try {
                    newBuilder = RoomMessage.VideoElemContent.newBuilder();
                } catch (Exception e3) {
                    e = e3;
                    groupMessageSend3 = null;
                    if (groupMessageSend3 == null && (builder = groupMessageSend3.m٦٣٠toBuilder()) != null && (status = builder.setStatus(2)) != null) {
                        groupMessageSend2 = status.m٦٣٥build();
                    } else {
                        groupMessageSend2 = null;
                    }
                    if (groupMessageSend2 == null) {
                        roomMessageMulti = BuildMessageUtilsKt.toMessageMulti(groupMessageSend2);
                    } else {
                        roomMessageMulti = null;
                    }
                    VideoUploadManager videoUploadManager = VideoUploadManager.INSTANCE;
                    videoUploadManager.smallChangeData(roomMessageMulti);
                    mListener = videoUploadManager.getMListener();
                    if (mListener != null) {
                        this.L$0 = null;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 6;
                        if (mListener.onUploadFailed(roomMessageMulti, e, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                }
                try {
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(this.$file.getAbsolutePath());
                    String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
                    if (extractMetadata != null) {
                        i = Integer.parseInt(extractMetadata);
                    } else {
                        i = 0;
                    }
                    String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                    if (extractMetadata2 != null) {
                        i2 = Integer.parseInt(extractMetadata2);
                    } else {
                        i2 = 0;
                    }
                    mediaMetadataRetriever.release();
                    float f = i;
                    float f2 = i2;
                    float min = Math.min(480 / f, 640 / f2);
                    Bitmap bitmap = (Bitmap) Glide.with(this.$context).b().H0(Uri.fromFile(new File(this.$file.getAbsolutePath()))).W((int) (f * min), (int) (f2 * min)).Q0().get();
                    if (bitmap == null) {
                        return Unit.INSTANCE;
                    }
                    int width = bitmap.getWidth();
                    int height = bitmap.getHeight();
                    VideoUploadManager videoUploadManager2 = VideoUploadManager.INSTANCE;
                    saveBitmapToFile = videoUploadManager2.saveBitmapToFile(bitmap, PathHelper.INSTANCE.getAppPrivateDownloadPath() + File.separator + System.currentTimeMillis() + ".png");
                    if (saveBitmapToFile == null) {
                        saveBitmapToFile = "";
                    }
                    newBuilder.setThumbHeight(height);
                    newBuilder.setThumbWidth(width);
                    newBuilder.setLocalThumbPath(saveBitmapToFile);
                    newBuilder.setThumbSize(bitmap.getByteCount());
                    newBuilder.setVideoSecond((int) (this.$media.getDuration() / 1000));
                    newBuilder.setVideoSize(this.$media.getSize());
                    newBuilder.setLocalPath(this.$file.getAbsolutePath());
                    String mGroupId = MeetingRoomManager.INSTANCE.getMGroupId();
                    RoomMessage.VideoElemContent videoElemContent = newBuilder.m٩٥٧build();
                    Intrinsics.checkNotNullExpressionValue(videoElemContent, "build(...)");
                    roomMessageVideo = BuildMessageUtilsKt.roomMessageVideo(mGroupId, videoElemContent);
                    videoUploadManager2.setMListener(this.$listener);
                    VideoUploadManager.UploadCallback mListener3 = videoUploadManager2.getMListener();
                    if (mListener3 != null) {
                        RoomMessageMulti messageMulti = BuildMessageUtilsKt.toMessageMulti(roomMessageVideo);
                        this.L$0 = coroutineScope;
                        this.L$1 = roomMessageVideo;
                        this.L$2 = newBuilder;
                        this.L$3 = saveBitmapToFile;
                        this.label = 1;
                        if (mListener3.addMessageLocal(messageMulti, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        str = saveBitmapToFile;
                        saveBitmapToFile = str;
                    }
                    CoroutineScope coroutineScope2 = coroutineScope;
                    Deferred async$default2 = BuildersKt.async$default(coroutineScope2, (CoroutineContext) null, (CoroutineStart) null, new VideoUploadManager$uploadVideo$1$imageResult$1(saveBitmapToFile, null), 3, (Object) null);
                    async$default = BuildersKt.async$default(coroutineScope2, (CoroutineContext) null, (CoroutineStart) null, new VideoUploadManager$uploadVideo$1$videoResult$1(this.$file, null), 3, (Object) null);
                    this.L$0 = roomMessageVideo;
                    this.L$1 = newBuilder;
                    this.L$2 = async$default;
                    this.L$3 = null;
                    this.label = 2;
                    await = async$default2.await(this);
                    if (await == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    pair = (Pair) await;
                    this.L$0 = roomMessageVideo;
                    this.L$1 = newBuilder;
                    this.L$2 = pair;
                    this.label = 3;
                    await2 = async$default.await(this);
                    if (await2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    pair2 = (Pair) await2;
                    if (!((Boolean) pair.getFirst()).booleanValue() && ((Boolean) pair2.getFirst()).booleanValue()) {
                        newBuilder.setThumbUrl((String) pair.getSecond());
                        newBuilder.setVideoUrl((String) pair2.getSecond());
                        RoomMessage.MsgBody.Builder builder2 = roomMessageVideo.getMsgBody(0).m٨١٤toBuilder();
                        builder2.setVideoContent(newBuilder.m٩٥٧build());
                        RoomMessage.GroupMessageSend groupMessageSend4 = roomMessageVideo.m٦٣٠toBuilder().clearMsgBody().addMsgBody(builder2.m٨١٩build()).m٦٣٥build();
                        try {
                            VideoUploadManager.UploadCallback mListener4 = VideoUploadManager.INSTANCE.getMListener();
                            if (mListener4 != null) {
                                Intrinsics.checkNotNull(groupMessageSend4);
                                this.L$0 = groupMessageSend4;
                                this.L$1 = null;
                                this.L$2 = null;
                                this.label = 4;
                                if (mListener4.onUploadSuccess(groupMessageSend4, false, (Continuation<? super Unit>) this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        } catch (Exception e4) {
                            e = e4;
                            groupMessageSend3 = groupMessageSend4;
                            if (groupMessageSend3 == null) {
                            }
                            groupMessageSend2 = null;
                            if (groupMessageSend2 == null) {
                            }
                            VideoUploadManager videoUploadManager3 = VideoUploadManager.INSTANCE;
                            videoUploadManager3.smallChangeData(roomMessageMulti);
                            mListener = videoUploadManager3.getMListener();
                            if (mListener != null) {
                            }
                            return Unit.INSTANCE;
                        }
                        return Unit.INSTANCE;
                    }
                    newBuilder.setThumbUrl((String) pair.getSecond());
                    newBuilder.setVideoUrl((String) pair2.getSecond());
                    RoomMessage.MsgBody.Builder builder3 = roomMessageVideo.getMsgBody(0).m٨١٤toBuilder();
                    builder3.setVideoContent(newBuilder.m٩٥٧build());
                    RoomMessage.GroupMessageSend.Builder builder4 = roomMessageVideo.m٦٣٠toBuilder();
                    builder4.setStatus(2);
                    groupMessageSend3 = builder4.clearMsgBody().addMsgBody(builder3.m٨١٩build()).m٦٣٥build();
                    Intrinsics.checkNotNull(groupMessageSend3);
                    RoomMessageMulti messageMulti2 = BuildMessageUtilsKt.toMessageMulti(groupMessageSend3);
                    VideoUploadManager videoUploadManager4 = VideoUploadManager.INSTANCE;
                    videoUploadManager4.smallChangeData(messageMulti2);
                    mListener2 = videoUploadManager4.getMListener();
                    if (mListener2 != null) {
                        Exception exc = new Exception("Upload failed");
                        this.L$0 = groupMessageSend3;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.label = 5;
                        if (mListener2.onUploadFailed(messageMulti2, exc, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return Unit.INSTANCE;
                }
            case 1:
                str = (String) this.L$3;
                newBuilder = (RoomMessage.VideoElemContent.Builder) this.L$2;
                roomMessageVideo = (RoomMessage.GroupMessageSend) this.L$1;
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                saveBitmapToFile = str;
                CoroutineScope coroutineScope22 = coroutineScope;
                Deferred async$default22 = BuildersKt.async$default(coroutineScope22, (CoroutineContext) null, (CoroutineStart) null, new VideoUploadManager$uploadVideo$1$imageResult$1(saveBitmapToFile, null), 3, (Object) null);
                async$default = BuildersKt.async$default(coroutineScope22, (CoroutineContext) null, (CoroutineStart) null, new VideoUploadManager$uploadVideo$1$videoResult$1(this.$file, null), 3, (Object) null);
                this.L$0 = roomMessageVideo;
                this.L$1 = newBuilder;
                this.L$2 = async$default;
                this.L$3 = null;
                this.label = 2;
                await = async$default22.await(this);
                if (await == coroutine_suspended) {
                }
                pair = (Pair) await;
                this.L$0 = roomMessageVideo;
                this.L$1 = newBuilder;
                this.L$2 = pair;
                this.label = 3;
                await2 = async$default.await(this);
                if (await2 == coroutine_suspended) {
                }
                pair2 = (Pair) await2;
                if (!((Boolean) pair.getFirst()).booleanValue()) {
                    break;
                }
                newBuilder.setThumbUrl((String) pair.getSecond());
                newBuilder.setVideoUrl((String) pair2.getSecond());
                RoomMessage.MsgBody.Builder builder32 = roomMessageVideo.getMsgBody(0).m٨١٤toBuilder();
                builder32.setVideoContent(newBuilder.m٩٥٧build());
                RoomMessage.GroupMessageSend.Builder builder42 = roomMessageVideo.m٦٣٠toBuilder();
                builder42.setStatus(2);
                groupMessageSend3 = builder42.clearMsgBody().addMsgBody(builder32.m٨١٩build()).m٦٣٥build();
                Intrinsics.checkNotNull(groupMessageSend3);
                RoomMessageMulti messageMulti22 = BuildMessageUtilsKt.toMessageMulti(groupMessageSend3);
                VideoUploadManager videoUploadManager42 = VideoUploadManager.INSTANCE;
                videoUploadManager42.smallChangeData(messageMulti22);
                mListener2 = videoUploadManager42.getMListener();
                if (mListener2 != null) {
                }
                return Unit.INSTANCE;
            case 2:
                async$default = (Deferred) this.L$2;
                newBuilder = (RoomMessage.VideoElemContent.Builder) this.L$1;
                roomMessageVideo = (RoomMessage.GroupMessageSend) this.L$0;
                ResultKt.throwOnFailure(obj);
                await = obj;
                pair = (Pair) await;
                this.L$0 = roomMessageVideo;
                this.L$1 = newBuilder;
                this.L$2 = pair;
                this.label = 3;
                await2 = async$default.await(this);
                if (await2 == coroutine_suspended) {
                }
                pair2 = (Pair) await2;
                if (!((Boolean) pair.getFirst()).booleanValue()) {
                }
                newBuilder.setThumbUrl((String) pair.getSecond());
                newBuilder.setVideoUrl((String) pair2.getSecond());
                RoomMessage.MsgBody.Builder builder322 = roomMessageVideo.getMsgBody(0).m٨١٤toBuilder();
                builder322.setVideoContent(newBuilder.m٩٥٧build());
                RoomMessage.GroupMessageSend.Builder builder422 = roomMessageVideo.m٦٣٠toBuilder();
                builder422.setStatus(2);
                groupMessageSend3 = builder422.clearMsgBody().addMsgBody(builder322.m٨١٩build()).m٦٣٥build();
                Intrinsics.checkNotNull(groupMessageSend3);
                RoomMessageMulti messageMulti222 = BuildMessageUtilsKt.toMessageMulti(groupMessageSend3);
                VideoUploadManager videoUploadManager422 = VideoUploadManager.INSTANCE;
                videoUploadManager422.smallChangeData(messageMulti222);
                mListener2 = videoUploadManager422.getMListener();
                if (mListener2 != null) {
                }
                return Unit.INSTANCE;
            case 3:
                Pair pair3 = (Pair) this.L$2;
                newBuilder = (RoomMessage.VideoElemContent.Builder) this.L$1;
                roomMessageVideo = (RoomMessage.GroupMessageSend) this.L$0;
                ResultKt.throwOnFailure(obj);
                pair = pair3;
                await2 = obj;
                pair2 = (Pair) await2;
                if (!((Boolean) pair.getFirst()).booleanValue()) {
                }
                newBuilder.setThumbUrl((String) pair.getSecond());
                newBuilder.setVideoUrl((String) pair2.getSecond());
                RoomMessage.MsgBody.Builder builder3222 = roomMessageVideo.getMsgBody(0).m٨١٤toBuilder();
                builder3222.setVideoContent(newBuilder.m٩٥٧build());
                RoomMessage.GroupMessageSend.Builder builder4222 = roomMessageVideo.m٦٣٠toBuilder();
                builder4222.setStatus(2);
                groupMessageSend3 = builder4222.clearMsgBody().addMsgBody(builder3222.m٨١٩build()).m٦٣٥build();
                Intrinsics.checkNotNull(groupMessageSend3);
                RoomMessageMulti messageMulti2222 = BuildMessageUtilsKt.toMessageMulti(groupMessageSend3);
                VideoUploadManager videoUploadManager4222 = VideoUploadManager.INSTANCE;
                videoUploadManager4222.smallChangeData(messageMulti2222);
                mListener2 = videoUploadManager4222.getMListener();
                if (mListener2 != null) {
                }
                return Unit.INSTANCE;
            case 4:
                groupMessageSend3 = (RoomMessage.GroupMessageSend) this.L$0;
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            case 5:
                groupMessageSend3 = (RoomMessage.GroupMessageSend) this.L$0;
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            case 6:
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
