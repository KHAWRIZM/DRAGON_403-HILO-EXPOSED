package com.qiahao.nextvideo.room.help;

import android.text.TextUtils;
import com.luck.picture.lib.entity.LocalMedia;
import com.qhqc.core.basic.aws.Result;
import com.qiahao.hilo_message.data.RoomMessageMulti;
import com.qiahao.hilo_message.utils.BuildMessageUtilsKt;
import com.qiahao.nextvideo.room.help.VideoUploadManager;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import roomMessage.RoomMessage;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.room.help.VideoUploadManager$uploadImage$1", f = "VideoUploadManager.kt", i = {0, 1, 2, 3}, l = {66, 67, 75, 80, 86}, m = "invokeSuspend", n = {TUIConstants.TUIChat.METHOD_SEND_MESSAGE, TUIConstants.TUIChat.METHOD_SEND_MESSAGE, TUIConstants.TUIChat.METHOD_SEND_MESSAGE, TUIConstants.TUIChat.METHOD_SEND_MESSAGE}, s = {"L$0", "L$0", "L$0", "L$0"})
@SourceDebugExtension({"SMAP\nVideoUploadManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VideoUploadManager.kt\ncom/qiahao/nextvideo/room/help/VideoUploadManager$uploadImage$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,455:1\n1#2:456\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class VideoUploadManager$uploadImage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $file;
    final /* synthetic */ VideoUploadManager.UploadCallback $listener;
    final /* synthetic */ LocalMedia $media;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoUploadManager$uploadImage$1(VideoUploadManager.UploadCallback uploadCallback, LocalMedia localMedia, File file, Continuation<? super VideoUploadManager$uploadImage$1> continuation) {
        super(2, continuation);
        this.$listener = uploadCallback;
        this.$media = localMedia;
        this.$file = file;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoUploadManager$uploadImage$1(this.$listener, this.$media, this.$file, continuation);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:1|(1:2)|(1:(1:(4:(1:(1:(3:9|10|11)(2:13|14))(1:15))(1:17)|16|10|11)(9:18|19|20|21|(1:23)(1:88)|24|(6:26|(1:53)(3:30|(1:52)|34)|35|(3:(1:40)(1:50)|41|(2:43|(2:47|(1:49))))|51|(3:45|47|(0)))(5:54|(1:87)(2:58|59)|(2:85|86)(1:61)|62|(2:64|(1:66)))|10|11))(2:89|90))(6:100|101|102|104|105|(2:107|(1:109)(1:110))(4:112|92|93|(1:95)(7:96|21|(0)(0)|24|(0)(0)|10|11)))|91|92|93|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x014c, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x014d, code lost:
    
        r1 = r15;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a7 A[Catch: Exception -> 0x0031, TryCatch #4 {Exception -> 0x0031, blocks: (B:16:0x002c, B:19:0x003f, B:21:0x00a3, B:23:0x00a7, B:24:0x00ad, B:26:0x00b3, B:28:0x00ba, B:30:0x00c0, B:32:0x00cb, B:34:0x00d3, B:35:0x00dc, B:37:0x00e2, B:40:0x00ea, B:41:0x00f0, B:43:0x00f6, B:45:0x00ff, B:47:0x0107, B:54:0x0112, B:56:0x0118, B:58:0x011e, B:90:0x004a), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b3 A[Catch: Exception -> 0x0031, TryCatch #4 {Exception -> 0x0031, blocks: (B:16:0x002c, B:19:0x003f, B:21:0x00a3, B:23:0x00a7, B:24:0x00ad, B:26:0x00b3, B:28:0x00ba, B:30:0x00c0, B:32:0x00cb, B:34:0x00d3, B:35:0x00dc, B:37:0x00e2, B:40:0x00ea, B:41:0x00f0, B:43:0x00f6, B:45:0x00ff, B:47:0x0107, B:54:0x0112, B:56:0x0118, B:58:0x011e, B:90:0x004a), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0111 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0112 A[Catch: Exception -> 0x0031, TryCatch #4 {Exception -> 0x0031, blocks: (B:16:0x002c, B:19:0x003f, B:21:0x00a3, B:23:0x00a7, B:24:0x00ad, B:26:0x00b3, B:28:0x00ba, B:30:0x00c0, B:32:0x00cb, B:34:0x00d3, B:35:0x00dc, B:37:0x00e2, B:40:0x00ea, B:41:0x00f0, B:43:0x00f6, B:45:0x00ff, B:47:0x0107, B:54:0x0112, B:56:0x0118, B:58:0x011e, B:90:0x004a), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00a1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00a2  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        RoomMessage.GroupMessageSend groupMessageSend;
        RoomMessageMulti roomMessageMulti;
        VideoUploadManager.UploadCallback mListener;
        RoomMessage.GroupMessageSend.Builder builder;
        RoomMessage.GroupMessageSend.Builder status;
        RoomMessage.GroupMessageSend roomMessageImage$default;
        VideoUploadManager.UploadCallback mListener2;
        RoomMessage.GroupMessageSend groupMessageSend2;
        RoomMessage.GroupMessageSend groupMessageSend3;
        Object uploadImage$default;
        RoomMessage.GroupMessageSend groupMessageSend4;
        Result result;
        String str;
        RoomMessage.GroupMessageSend groupMessageSend5;
        RoomMessageMulti messageMulti;
        RoomMessage.GroupMessageSend.Builder status2;
        RoomMessage.MsgBody.Builder builder2;
        RoomMessage.GroupMessageSend groupMessageSend6;
        VideoUploadManager.UploadCallback mListener3;
        RoomMessage.GroupMessageSend.Builder clearMsgBody;
        RoomMessage.MsgBody msgBody;
        String str2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        RoomMessage.GroupMessageSend groupMessageSend7 = 1;
        try {
        } catch (Exception e) {
            e = e;
        }
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 5) {
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                groupMessageSend4 = (RoomMessage.GroupMessageSend) this.L$0;
                ResultKt.throwOnFailure(obj);
                uploadImage$default = obj;
                result = (Result) uploadImage$default;
                if (result == null) {
                    str = result.getRelativeUrl();
                } else {
                    str = null;
                }
                if (TextUtils.isEmpty(str)) {
                    RoomMessage.MsgBody msgBody2 = groupMessageSend4.getMsgBody(0);
                    if (msgBody2 != null && (builder2 = msgBody2.m٨١٤toBuilder()) != null) {
                        RoomMessage.ImageElemContent imageContent = builder2.getImageContent();
                        Intrinsics.checkNotNullExpressionValue(imageContent, "getImageContent(...)");
                        if (result == null || (str2 = result.getRelativeUrl()) == null) {
                            str2 = "";
                        }
                        builder2.setImageContent(BuildMessageUtilsKt.changeUrl(imageContent, str2));
                    } else {
                        builder2 = null;
                    }
                    RoomMessage.GroupMessageSend.Builder builder3 = groupMessageSend4.m٦٣٠toBuilder();
                    if (builder3 != null && (clearMsgBody = builder3.clearMsgBody()) != null) {
                        if (builder2 != null) {
                            msgBody = builder2.m٨١٩build();
                        } else {
                            msgBody = null;
                        }
                        RoomMessage.GroupMessageSend.Builder addMsgBody = clearMsgBody.addMsgBody(msgBody);
                        if (addMsgBody != null) {
                            groupMessageSend6 = addMsgBody.m٦٣٥build();
                            if (groupMessageSend6 != null && (mListener3 = VideoUploadManager.INSTANCE.getMListener()) != null) {
                                this.L$0 = groupMessageSend6;
                                this.label = 3;
                                if (mListener3.onUploadSuccess(groupMessageSend6, false, (Continuation<? super Unit>) this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        }
                    }
                    groupMessageSend6 = null;
                    if (groupMessageSend6 != null) {
                        this.L$0 = groupMessageSend6;
                        this.label = 3;
                        if (mListener3.onUploadSuccess(groupMessageSend6, false, (Continuation<? super Unit>) this) == coroutine_suspended) {
                        }
                    }
                } else {
                    RoomMessage.GroupMessageSend.Builder builder4 = groupMessageSend4.m٦٣٠toBuilder();
                    if (builder4 != null && (status2 = builder4.setStatus(2)) != null) {
                        groupMessageSend5 = status2.m٦٣٥build();
                    } else {
                        groupMessageSend5 = null;
                    }
                    if (groupMessageSend5 != null) {
                        try {
                            messageMulti = BuildMessageUtilsKt.toMessageMulti(groupMessageSend5);
                        } catch (Exception e2) {
                            e = e2;
                            groupMessageSend7 = groupMessageSend5;
                            if (groupMessageSend7 == 0 && (builder = groupMessageSend7.m٦٣٠toBuilder()) != null && (status = builder.setStatus(2)) != null) {
                                groupMessageSend = status.m٦٣٥build();
                            } else {
                                groupMessageSend = null;
                            }
                            if (groupMessageSend != null) {
                                roomMessageMulti = BuildMessageUtilsKt.toMessageMulti(groupMessageSend);
                            } else {
                                roomMessageMulti = null;
                            }
                            VideoUploadManager videoUploadManager = VideoUploadManager.INSTANCE;
                            videoUploadManager.smallChangeData(roomMessageMulti);
                            mListener = videoUploadManager.getMListener();
                            if (mListener != null) {
                                this.L$0 = null;
                                this.label = 5;
                                if (mListener.onUploadFailed(roomMessageMulti, e, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    } else {
                        messageMulti = null;
                    }
                    VideoUploadManager videoUploadManager2 = VideoUploadManager.INSTANCE;
                    videoUploadManager2.smallChangeData(messageMulti);
                    VideoUploadManager.UploadCallback mListener4 = videoUploadManager2.getMListener();
                    if (mListener4 != null) {
                        this.L$0 = groupMessageSend5;
                        this.label = 4;
                        if (VideoUploadManager.UploadCallback.DefaultImpls.onUploadFailed$default(mListener4, messageMulti, null, this, 2, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
                return Unit.INSTANCE;
            }
            groupMessageSend3 = (RoomMessage.GroupMessageSend) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            VideoUploadManager videoUploadManager3 = VideoUploadManager.INSTANCE;
            videoUploadManager3.setMListener(this.$listener);
            try {
                roomMessageImage$default = BuildMessageUtilsKt.roomMessageImage$default(MeetingRoomManager.INSTANCE.getMGroupId(), this.$media, this.$file, (String) null, 8, (Object) null);
            } catch (Exception e3) {
                e = e3;
                groupMessageSend7 = 0;
            }
            try {
                mListener2 = videoUploadManager3.getMListener();
            } catch (Exception e4) {
                e = e4;
                groupMessageSend7 = roomMessageImage$default;
                if (groupMessageSend7 == 0) {
                }
                groupMessageSend = null;
                if (groupMessageSend != null) {
                }
                VideoUploadManager videoUploadManager4 = VideoUploadManager.INSTANCE;
                videoUploadManager4.smallChangeData(roomMessageMulti);
                mListener = videoUploadManager4.getMListener();
                if (mListener != null) {
                }
                return Unit.INSTANCE;
            }
            if (mListener2 != null) {
                RoomMessageMulti messageMulti2 = BuildMessageUtilsKt.toMessageMulti(roomMessageImage$default);
                this.L$0 = roomMessageImage$default;
                this.label = 1;
                if (mListener2.addMessageLocal(messageMulti2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                groupMessageSend3 = roomMessageImage$default;
            } else {
                groupMessageSend2 = roomMessageImage$default;
                VideoUploadManager videoUploadManager5 = VideoUploadManager.INSTANCE;
                File file = this.$file;
                this.L$0 = groupMessageSend2;
                this.label = 2;
                uploadImage$default = VideoUploadManager.uploadImage$default(videoUploadManager5, file, true, null, this, 4, null);
                if (uploadImage$default != coroutine_suspended) {
                    return coroutine_suspended;
                }
                groupMessageSend4 = groupMessageSend2;
                result = (Result) uploadImage$default;
                if (result == null) {
                }
                if (TextUtils.isEmpty(str)) {
                }
                return Unit.INSTANCE;
            }
        }
        groupMessageSend2 = groupMessageSend3;
        VideoUploadManager videoUploadManager52 = VideoUploadManager.INSTANCE;
        File file2 = this.$file;
        this.L$0 = groupMessageSend2;
        this.label = 2;
        uploadImage$default = VideoUploadManager.uploadImage$default(videoUploadManager52, file2, true, null, this, 4, null);
        if (uploadImage$default != coroutine_suspended) {
        }
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
