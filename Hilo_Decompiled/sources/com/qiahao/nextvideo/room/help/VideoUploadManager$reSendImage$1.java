package com.qiahao.nextvideo.room.help;

import android.text.TextUtils;
import com.qhqc.core.basic.aws.Result;
import com.qiahao.hilo_message.data.GroupMessageNew;
import com.qiahao.hilo_message.data.ImageElemContent;
import com.qiahao.hilo_message.data.ImageInfo;
import com.qiahao.hilo_message.data.MsgBody;
import com.qiahao.hilo_message.data.RoomMessageMulti;
import com.qiahao.hilo_message.utils.BuildMessageUtilsKt;
import com.qiahao.nextvideo.room.help.VideoUploadManager;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import roomMessage.RoomMessage;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.room.help.VideoUploadManager$reSendImage$1", f = "VideoUploadManager.kt", i = {1}, l = {100, 103, 109, 112, 119}, m = "invokeSuspend", n = {"imageInfo"}, s = {"L$0"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class VideoUploadManager$reSendImage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ VideoUploadManager.UploadCallback $listener;
    final /* synthetic */ RoomMessageMulti $message;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoUploadManager$reSendImage$1(VideoUploadManager.UploadCallback uploadCallback, RoomMessageMulti roomMessageMulti, Continuation<? super VideoUploadManager$reSendImage$1> continuation) {
        super(2, continuation);
        this.$listener = uploadCallback;
        this.$message = roomMessageMulti;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoUploadManager$reSendImage$1(this.$listener, this.$message, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00bb A[Catch: Exception -> 0x002d, TryCatch #0 {Exception -> 0x002d, blocks: (B:16:0x0028, B:17:0x0167, B:18:0x0030, B:20:0x0039, B:21:0x00b7, B:23:0x00bb, B:24:0x00c1, B:28:0x00cb, B:29:0x00d1, B:31:0x00dc, B:33:0x00e2, B:35:0x00ea, B:37:0x00f0, B:39:0x00f6, B:41:0x00fe, B:42:0x0104, B:44:0x010c, B:46:0x0112, B:48:0x011a, B:50:0x0120, B:51:0x0123, B:53:0x012b, B:58:0x013c, B:60:0x0144, B:61:0x014b, B:63:0x0153, B:67:0x0040, B:68:0x006e, B:70:0x0076, B:71:0x007c, B:74:0x0082, B:76:0x0089, B:78:0x0092, B:80:0x0098, B:84:0x00a0, B:90:0x004e, B:92:0x0056, B:93:0x005d, B:95:0x0063), top: B:2:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0144 A[Catch: Exception -> 0x002d, TryCatch #0 {Exception -> 0x002d, blocks: (B:16:0x0028, B:17:0x0167, B:18:0x0030, B:20:0x0039, B:21:0x00b7, B:23:0x00bb, B:24:0x00c1, B:28:0x00cb, B:29:0x00d1, B:31:0x00dc, B:33:0x00e2, B:35:0x00ea, B:37:0x00f0, B:39:0x00f6, B:41:0x00fe, B:42:0x0104, B:44:0x010c, B:46:0x0112, B:48:0x011a, B:50:0x0120, B:51:0x0123, B:53:0x012b, B:58:0x013c, B:60:0x0144, B:61:0x014b, B:63:0x0153, B:67:0x0040, B:68:0x006e, B:70:0x0076, B:71:0x007c, B:74:0x0082, B:76:0x0089, B:78:0x0092, B:80:0x0098, B:84:0x00a0, B:90:0x004e, B:92:0x0056, B:93:0x005d, B:95:0x0063), top: B:2:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0153 A[Catch: Exception -> 0x002d, TryCatch #0 {Exception -> 0x002d, blocks: (B:16:0x0028, B:17:0x0167, B:18:0x0030, B:20:0x0039, B:21:0x00b7, B:23:0x00bb, B:24:0x00c1, B:28:0x00cb, B:29:0x00d1, B:31:0x00dc, B:33:0x00e2, B:35:0x00ea, B:37:0x00f0, B:39:0x00f6, B:41:0x00fe, B:42:0x0104, B:44:0x010c, B:46:0x0112, B:48:0x011a, B:50:0x0120, B:51:0x0123, B:53:0x012b, B:58:0x013c, B:60:0x0144, B:61:0x014b, B:63:0x0153, B:67:0x0040, B:68:0x006e, B:70:0x0076, B:71:0x007c, B:74:0x0082, B:76:0x0089, B:78:0x0092, B:80:0x0098, B:84:0x00a0, B:90:0x004e, B:92:0x0056, B:93:0x005d, B:95:0x0063), top: B:2:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ImageInfo imageInfo;
        String str;
        Object uploadImage$default;
        String localPath;
        Result result;
        String str2;
        GroupMessageNew data;
        VideoUploadManager.UploadCallback mListener;
        String str3;
        List list;
        List msgBody;
        MsgBody msgBody2;
        ImageElemContent imageContent;
        List msgBody3;
        MsgBody msgBody4;
        ImageElemContent imageContent2;
        List imageInfoArray;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (Exception e) {
            GroupMessageNew data2 = this.$message.getData();
            if (data2 != null) {
                data2.setStatus(Boxing.boxInt(2));
            }
            VideoUploadManager.UploadCallback mListener2 = VideoUploadManager.INSTANCE.getMListener();
            if (mListener2 != null) {
                RoomMessageMulti roomMessageMulti = this.$message;
                this.L$0 = null;
                this.label = 5;
                if (mListener2.onUploadFailed(roomMessageMulti, e, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 5) {
                                ResultKt.throwOnFailure(obj);
                                VideoUploadManager.INSTANCE.smallChangeData(this.$message);
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        VideoUploadManager.INSTANCE.smallChangeData(this.$message);
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                imageInfo = (ImageInfo) this.L$0;
                ResultKt.throwOnFailure(obj);
                uploadImage$default = obj;
                result = (Result) uploadImage$default;
                if (result == null) {
                    str2 = result.getRelativeUrl();
                } else {
                    str2 = null;
                }
                if (TextUtils.isEmpty(str2) && imageInfo != null) {
                    if (result != null) {
                        str3 = result.getRelativeUrl();
                    } else {
                        str3 = null;
                    }
                    imageInfo.setLocalPath(str3);
                    GroupMessageNew data3 = this.$message.getData();
                    if (data3 != null && (msgBody3 = data3.getMsgBody()) != null && (msgBody4 = (MsgBody) msgBody3.get(0)) != null && (imageContent2 = msgBody4.getImageContent()) != null && (imageInfoArray = imageContent2.getImageInfoArray()) != null) {
                        list = CollectionsKt.toMutableList(imageInfoArray);
                    } else {
                        list = null;
                    }
                    if (list != null) {
                    }
                    GroupMessageNew data4 = this.$message.getData();
                    if (data4 != null && (msgBody = data4.getMsgBody()) != null && (msgBody2 = (MsgBody) msgBody.get(0)) != null && (imageContent = msgBody2.getImageContent()) != null) {
                        imageContent.setImageInfoArray(list);
                    }
                    VideoUploadManager.UploadCallback mListener3 = VideoUploadManager.INSTANCE.getMListener();
                    if (mListener3 != null) {
                        RoomMessage.GroupMessageSend groupMessageSend = BuildMessageUtilsKt.toGroupMessageSend(this.$message);
                        this.L$0 = null;
                        this.label = 3;
                        if (mListener3.onUploadSuccess(groupMessageSend, false, (Continuation<? super Unit>) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                }
                data = this.$message.getData();
                if (data != null) {
                    data.setStatus(Boxing.boxInt(2));
                }
                mListener = VideoUploadManager.INSTANCE.getMListener();
                if (mListener != null) {
                    RoomMessageMulti roomMessageMulti2 = this.$message;
                    Exception exc = new Exception("Upload failed");
                    this.L$0 = null;
                    this.label = 4;
                    if (mListener.onUploadFailed(roomMessageMulti2, exc, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                VideoUploadManager.INSTANCE.smallChangeData(this.$message);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            VideoUploadManager videoUploadManager = VideoUploadManager.INSTANCE;
            videoUploadManager.setMListener(this.$listener);
            GroupMessageNew data5 = this.$message.getData();
            if (data5 != null) {
                data5.setStatus(Boxing.boxInt(0));
            }
            VideoUploadManager.UploadCallback mListener4 = videoUploadManager.getMListener();
            if (mListener4 != null) {
                RoomMessageMulti roomMessageMulti3 = this.$message;
                this.label = 1;
                if (mListener4.refreshLocalMessage(roomMessageMulti3, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        GroupMessageNew data6 = this.$message.getData();
        if (data6 != null) {
            imageInfo = BuildMessageUtilsKt.imageInfo(data6);
        } else {
            imageInfo = null;
        }
        String str4 = "";
        if (imageInfo == null || (str = imageInfo.getLocalPath()) == null) {
            str = "";
        }
        if (new File(str).exists()) {
            VideoUploadManager videoUploadManager2 = VideoUploadManager.INSTANCE;
            if (imageInfo != null && (localPath = imageInfo.getLocalPath()) != null) {
                str4 = localPath;
            }
            File file = new File(str4);
            this.L$0 = imageInfo;
            this.label = 2;
            uploadImage$default = VideoUploadManager.uploadImage$default(videoUploadManager2, file, true, null, this, 4, null);
            if (uploadImage$default == coroutine_suspended) {
                return coroutine_suspended;
            }
            result = (Result) uploadImage$default;
            if (result == null) {
            }
            if (TextUtils.isEmpty(str2)) {
            }
            data = this.$message.getData();
            if (data != null) {
            }
            mListener = VideoUploadManager.INSTANCE.getMListener();
            if (mListener != null) {
            }
            VideoUploadManager.INSTANCE.smallChangeData(this.$message);
        }
        return Unit.INSTANCE;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
