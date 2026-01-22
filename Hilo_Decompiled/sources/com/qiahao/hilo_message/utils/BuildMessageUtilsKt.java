package com.qiahao.hilo_message.utils;

import android.text.TextUtils;
import anet.channel.entity.EventType;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareConstants;
import com.luck.picture.lib.entity.LocalMedia;
import com.oudi.utils.log.LogUtil;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.model.common.FamilyInfo;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.support.BaseControlUtils;
import com.qiahao.hilo_message.data.CloudCustomData;
import com.qiahao.hilo_message.data.CustomElemContent;
import com.qiahao.hilo_message.data.GMSvipDetail;
import com.qiahao.hilo_message.data.GroupMessageNew;
import com.qiahao.hilo_message.data.HiloMessageType;
import com.qiahao.hilo_message.data.ImageElemContent;
import com.qiahao.hilo_message.data.ImageInfo;
import com.qiahao.hilo_message.data.MsgBody;
import com.qiahao.hilo_message.data.RoomMessageMulti;
import com.qiahao.hilo_message.data.TextElemContent;
import com.qiahao.hilo_message.data.TextElemContentAt;
import com.qiahao.hilo_message.data.VideoElemContent;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import roomMessage.RoomMessage;

@Metadata(d1 = {"\u0000Â\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u001a(\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0003\u001a\u0016\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010\u001a\u0016\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013\u001a\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013\u001a\n\u0010\u0016\u001a\u00020\u0017*\u00020\u0001\u001a\u0014\u0010\u0018\u001a\u00020\u0019*\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u001a\n\u0010\u0016\u001a\u00020\u0017*\u00020\u001d\u001a\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001f\u001a\u00020\u0003\u001a\f\u0010 \u001a\u0004\u0018\u00010!*\u00020\u0015\u001a\f\u0010\"\u001a\u0004\u0018\u00010#*\u00020\u0015\u001a%\u0010$\u001a\u0004\u0018\u0001H%\"\u0004\b\u0000\u0010%*\u00020\u00152\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H%0'¢\u0006\u0002\u0010(\u001a\u0012\u0010)\u001a\u00020**\u00020*2\u0006\u0010\r\u001a\u00020\u0003\u001a\n\u0010+\u001a\u00020\u0015*\u00020\u001d\u001a\n\u0010,\u001a\u00020-*\u00020.\u001a\n\u0010\u0018\u001a\u00020\u0019*\u00020/\u001a\n\u00100\u001a\u000201*\u000202\u001a\n\u00103\u001a\u000204*\u000205\u001a\f\u00106\u001a\u0004\u0018\u000104*\u00020\u0015\u001a\n\u00107\u001a\u000208*\u000209\u001a\n\u0010:\u001a\u00020;*\u00020\u0007\u001a\n\u0010<\u001a\u00020=*\u00020*\u001a\n\u0010>\u001a\u00020!*\u00020?\u001a\n\u0010@\u001a\u00020#*\u00020\u0010\u001a4\u0010A\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010D\u001a\u00020E\u001a\n\u0010F\u001a\u00020\u0001*\u00020\u0017¨\u0006G"}, d2 = {"roomMessageText", "LroomMessage/RoomMessage$GroupMessageSend;", "groupId", "", ViewHierarchyConstants.TEXT_KEY, "atList", "", "LroomMessage/RoomMessage$TextElemContentAt;", "roomMessageImage", ShareConstants.WEB_DIALOG_PARAM_MEDIA, "Lcom/luck/picture/lib/entity/LocalMedia;", "file", "Ljava/io/File;", "url", "roomMessageVideo", "video", "LroomMessage/RoomMessage$VideoElemContent;", "roomMessageCustomSend", "customData", "", "roomMessageCustom", "Lcom/qiahao/hilo_message/data/GroupMessageNew;", "toMessageMulti", "Lcom/qiahao/hilo_message/data/RoomMessageMulti;", "toCloudCustomData", "Lcom/qiahao/hilo_message/data/CloudCustomData;", "Lcom/qiahao/base_common/model/common/User;", "isWelcome", "", "LroomMessage/RoomMessage$GroupMessageNew;", "checkRoomMessageType", "dataBody", "imageInfo", "Lcom/qiahao/hilo_message/data/ImageInfo;", "videoInfo", "Lcom/qiahao/hilo_message/data/VideoElemContent;", "customInfo", "T", "dataType", "Ljava/lang/Class;", "(Lcom/qiahao/hilo_message/data/GroupMessageNew;Ljava/lang/Class;)Ljava/lang/Object;", "changeUrl", "LroomMessage/RoomMessage$ImageElemContent;", "toGroupMessageNew", "toMsgBody", "Lcom/qiahao/hilo_message/data/MsgBody;", "LroomMessage/RoomMessage$MsgBody;", "LroomMessage/RoomMessage$CloudCustomData;", "toGMSvipDetail", "Lcom/qiahao/hilo_message/data/GMSvipDetail;", "LroomMessage/RoomMessage$GMSvipDetail;", "toCustomElemContent", "Lcom/qiahao/hilo_message/data/CustomElemContent;", "LroomMessage/RoomMessage$CustomElemContent;", "getCustomElemContent", "toTextElemContent", "Lcom/qiahao/hilo_message/data/TextElemContent;", "LroomMessage/RoomMessage$TextElemContent;", "toTextElemContentAt", "Lcom/qiahao/hilo_message/data/TextElemContentAt;", "toImageElemContent", "Lcom/qiahao/hilo_message/data/ImageElemContent;", "toImageInfo", "LroomMessage/RoomMessage$ImageInfo;", "toVideoElemContent", "createCustomMessage", "messageType", "owner", "msgTab", "", "toGroupMessageSend", "hilo_message_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBuildMessageUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BuildMessageUtils.kt\ncom/qiahao/hilo_message/utils/BuildMessageUtilsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,529:1\n1563#2:530\n1634#2,3:531\n1869#2,2:535\n1563#2:539\n1634#2,3:540\n1563#2:543\n1634#2,3:544\n1563#2:547\n1634#2,3:548\n1563#2:551\n1634#2,3:552\n1869#2:555\n1869#2,2:556\n1869#2,2:558\n1870#2:560\n1#3:534\n216#4,2:537\n*S KotlinDebug\n*F\n+ 1 BuildMessageUtils.kt\ncom/qiahao/hilo_message/utils/BuildMessageUtilsKt\n*L\n162#1:530\n162#1:531,3\n197#1:535,2\n285#1:539\n285#1:540,3\n302#1:543\n302#1:544,3\n373#1:547\n373#1:548,3\n386#1:551\n386#1:552,3\n461#1:555\n471#1:556,2\n484#1:558,2\n461#1:560\n243#1:537,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class BuildMessageUtilsKt {
    @NotNull
    public static final RoomMessage.ImageElemContent changeUrl(@NotNull RoomMessage.ImageElemContent imageElemContent, @NotNull String url) {
        Intrinsics.checkNotNullParameter(imageElemContent, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        List imageInfoArrayList = imageElemContent.getImageInfoArrayList();
        Intrinsics.checkNotNullExpressionValue(imageInfoArrayList, "getImageInfoArrayList(...)");
        if (!imageInfoArrayList.isEmpty()) {
            RoomMessage.ImageElemContent.Builder newBuilder = RoomMessage.ImageElemContent.newBuilder();
            List imageInfoArrayList2 = imageElemContent.getImageInfoArrayList();
            Intrinsics.checkNotNullExpressionValue(imageInfoArrayList2, "getImageInfoArrayList(...)");
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(imageInfoArrayList2, 10));
            Iterator it = imageInfoArrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(((RoomMessage.ImageInfo) it.next()).toBuilder().setUrl(url).build());
            }
            newBuilder.addAllImageInfoArray(arrayList);
            RoomMessage.ImageElemContent build = newBuilder.build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            return build;
        }
        return imageElemContent;
    }

    @Nullable
    public static final String checkRoomMessageType(@NotNull String dataBody) {
        Intrinsics.checkNotNullParameter(dataBody, "dataBody");
        for (Map.Entry<String, Class<?>> entry : HiloMessageType.INSTANCE.getCustomMessageMap().entrySet()) {
            if (!StringsKt.contains$default((CharSequence) dataBody, (CharSequence) ("\"type\":" + ((Object) entry.getKey()) + ","), false, 2, (Object) null)) {
                if (StringsKt.contains$default((CharSequence) dataBody, (CharSequence) ("\"type\":\"" + ((Object) entry.getKey()) + "\""), false, 2, (Object) null)) {
                }
            }
            return entry.getKey();
        }
        return null;
    }

    @NotNull
    public static final RoomMessageMulti createCustomMessage(@NotNull String groupId, @NotNull String messageType, @NotNull Object customData, @Nullable User user, int i10) {
        long j10;
        User user2;
        String str;
        String str2;
        String str3;
        String str4;
        String externalId;
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(messageType, "messageType");
        Intrinsics.checkNotNullParameter(customData, "customData");
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            j10 = service.getServerTime();
        } else {
            j10 = 0;
        }
        boolean z10 = false;
        long random = (j10 * 1000) + RangesKt.random(new IntRange(0, 1000), Random.INSTANCE);
        if (Intrinsics.areEqual(messageType, "106")) {
            user2 = user;
        } else {
            user2 = BaseControlUtils.INSTANCE.getUser();
        }
        CloudCustomData cloudCustomData = null;
        CustomElemContent customElemContent = new CustomElemContent(null, null, 3, null);
        customElemContent.setData(BaseApplication.INSTANCE.getGSON().s(customData));
        customElemContent.setDataType(customData);
        MsgBody msgBody = new MsgBody(null, null, null, null, null, 31, null);
        msgBody.setCustomContent(customElemContent);
        ArrayList arrayList = new ArrayList();
        arrayList.add(msgBody);
        GroupMessageNew groupMessageNew = new GroupMessageNew(null, null, null, null, null, null, null, null, null, null, null, null, EventType.ALL, null);
        if (user2 != null) {
            str = user2.getExternalId();
        } else {
            str = null;
        }
        groupMessageNew.setMsgId(str + "_" + random);
        String str5 = "";
        if (user2 == null || (str2 = user2.getExternalId()) == null) {
            str2 = "";
        }
        groupMessageNew.setFromAccount(str2);
        if (user2 != null && (externalId = user2.getExternalId()) != null) {
            str5 = externalId;
        }
        groupMessageNew.setOperatorAccount(str5);
        groupMessageNew.setGroupId(groupId);
        groupMessageNew.setEventTime(Long.valueOf(random));
        groupMessageNew.setStatus(1);
        if (user2 != null) {
            str3 = user2.getNick();
        } else {
            str3 = null;
        }
        groupMessageNew.setSenderNick(str3);
        if (user2 != null) {
            str4 = user2.getAvatar();
        } else {
            str4 = null;
        }
        groupMessageNew.setSenderAvatar(str4);
        if (user2 != null) {
            if (user != null) {
                z10 = true;
            }
            cloudCustomData = toCloudCustomData(user2, z10);
        }
        groupMessageNew.setCloudCustomData(cloudCustomData);
        groupMessageNew.setMsgBody(arrayList);
        groupMessageNew.setMsgTab(Integer.valueOf(i10));
        return new RoomMessageMulti(groupMessageNew, RoomMessageMulti.INSTANCE.getMessageType(messageType));
    }

    public static /* synthetic */ RoomMessageMulti createCustomMessage$default(String str, String str2, Object obj, User user, int i10, int i11, Object obj2) {
        if ((i11 & 8) != 0) {
            user = null;
        }
        if ((i11 & 16) != 0) {
            i10 = 0;
        }
        return createCustomMessage(str, str2, obj, user, i10);
    }

    @Nullable
    public static final <T> T customInfo(@NotNull GroupMessageNew groupMessageNew, @NotNull Class<T> dataType) {
        Object obj;
        MsgBody msgBody;
        CustomElemContent customContent;
        Intrinsics.checkNotNullParameter(groupMessageNew, "<this>");
        Intrinsics.checkNotNullParameter(dataType, "dataType");
        List<MsgBody> msgBody2 = groupMessageNew.getMsgBody();
        if (msgBody2 != null && (msgBody = (MsgBody) CollectionsKt.getOrNull(msgBody2, 0)) != null && (customContent = msgBody.getCustomContent()) != null) {
            obj = customContent.getDataType();
        } else {
            obj = null;
        }
        if (obj == null || !dataType.isInstance(obj)) {
            return null;
        }
        return dataType.cast(obj);
    }

    @Nullable
    public static final CustomElemContent getCustomElemContent(@NotNull GroupMessageNew groupMessageNew) {
        MsgBody msgBody;
        Intrinsics.checkNotNullParameter(groupMessageNew, "<this>");
        List<MsgBody> msgBody2 = groupMessageNew.getMsgBody();
        if (msgBody2 != null && (msgBody = (MsgBody) CollectionsKt.getOrNull(msgBody2, 0)) != null) {
            return msgBody.getCustomContent();
        }
        return null;
    }

    @Nullable
    public static final ImageInfo imageInfo(@NotNull GroupMessageNew groupMessageNew) {
        MsgBody msgBody;
        ImageElemContent imageContent;
        List<ImageInfo> imageInfoArray;
        Intrinsics.checkNotNullParameter(groupMessageNew, "<this>");
        List<MsgBody> msgBody2 = groupMessageNew.getMsgBody();
        if (msgBody2 != null && (msgBody = (MsgBody) CollectionsKt.getOrNull(msgBody2, 0)) != null && (imageContent = msgBody.getImageContent()) != null && (imageInfoArray = imageContent.getImageInfoArray()) != null) {
            return (ImageInfo) CollectionsKt.getOrNull(imageInfoArray, 0);
        }
        return null;
    }

    @NotNull
    public static final GroupMessageNew roomMessageCustom(@NotNull String groupId, @NotNull Object customData) {
        long j10;
        String str;
        String externalId;
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(customData, "customData");
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            j10 = service.getServerTime();
        } else {
            j10 = 0;
        }
        long random = (j10 * 1000) + RangesKt.random(new IntRange(0, 1000), Random.INSTANCE);
        User user = BaseControlUtils.INSTANCE.getUser();
        String str2 = null;
        GroupMessageNew groupMessageNew = new GroupMessageNew(null, null, null, null, null, null, null, null, null, null, null, null, EventType.ALL, null);
        CustomElemContent customElemContent = new CustomElemContent(null, null, 3, null);
        customElemContent.setData(BaseApplication.INSTANCE.getGSON().s(customData));
        MsgBody msgBody = new MsgBody(null, null, null, null, null, 31, null);
        msgBody.setMsgType(HiloMessageType.ROOM_MESSAGE_CUSTOM);
        msgBody.setCustomContent(customElemContent);
        groupMessageNew.setMsgBody(CollectionsKt.listOf(msgBody));
        if (user != null) {
            str2 = user.getExternalId();
        }
        groupMessageNew.setMsgId(str2 + "_" + random);
        String str3 = "";
        if (user == null || (str = user.getExternalId()) == null) {
            str = "";
        }
        groupMessageNew.setFromAccount(str);
        if (user != null && (externalId = user.getExternalId()) != null) {
            str3 = externalId;
        }
        groupMessageNew.setOperatorAccount(str3);
        groupMessageNew.setGroupId(groupId);
        groupMessageNew.setEventTime(Long.valueOf(random));
        groupMessageNew.setStatus(1);
        groupMessageNew.setMsgTab(0);
        return groupMessageNew;
    }

    @NotNull
    public static final RoomMessage.GroupMessageSend roomMessageCustomSend(@NotNull String groupId, @NotNull Object customData) {
        long j10;
        String str;
        String str2;
        String externalId;
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(customData, "customData");
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            j10 = service.getServerTime();
        } else {
            j10 = 0;
        }
        long random = (j10 * 1000) + RangesKt.random(new IntRange(0, 1000), Random.INSTANCE);
        User user = BaseControlUtils.INSTANCE.getUser();
        RoomMessage.GroupMessageSend.Builder newBuilder = RoomMessage.GroupMessageSend.newBuilder();
        RoomMessage.CustomElemContent.Builder newBuilder2 = RoomMessage.CustomElemContent.newBuilder();
        newBuilder2.setData(BaseApplication.INSTANCE.getGSON().s(customData));
        RoomMessage.CustomElemContent build = newBuilder2.build();
        RoomMessage.MsgBody.Builder newBuilder3 = RoomMessage.MsgBody.newBuilder();
        newBuilder3.setMsgType(HiloMessageType.ROOM_MESSAGE_CUSTOM);
        newBuilder3.setCustomContent(build);
        newBuilder.addMsgBody(newBuilder3.build());
        if (user != null) {
            str = user.getExternalId();
        } else {
            str = null;
        }
        newBuilder.setMsgId(str + "_" + random);
        String str3 = "";
        if (user == null || (str2 = user.getExternalId()) == null) {
            str2 = "";
        }
        newBuilder.setFromAccount(str2);
        if (user != null && (externalId = user.getExternalId()) != null) {
            str3 = externalId;
        }
        newBuilder.setOperatorAccount(str3);
        newBuilder.setGroupId(groupId);
        newBuilder.setEventTime(random);
        newBuilder.setStatus(0);
        newBuilder.setMsgTab(0);
        RoomMessage.GroupMessageSend build2 = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build2, "build(...)");
        return build2;
    }

    @NotNull
    public static final RoomMessage.GroupMessageSend roomMessageImage(@NotNull String groupId, @NotNull LocalMedia media, @NotNull File file, @NotNull String url) {
        long j10;
        String str;
        String str2;
        String externalId;
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(media, "media");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(url, "url");
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            j10 = service.getServerTime();
        } else {
            j10 = 0;
        }
        long random = (j10 * 1000) + RangesKt.random(new IntRange(0, 1000), Random.INSTANCE);
        User user = BaseControlUtils.INSTANCE.getUser();
        RoomMessage.GroupMessageSend.Builder newBuilder = RoomMessage.GroupMessageSend.newBuilder();
        RoomMessage.MsgBody.Builder newBuilder2 = RoomMessage.MsgBody.newBuilder();
        RoomMessage.ImageElemContent.Builder newBuilder3 = RoomMessage.ImageElemContent.newBuilder();
        ArrayList arrayList = new ArrayList();
        RoomMessage.ImageInfo.Builder newBuilder4 = RoomMessage.ImageInfo.newBuilder();
        newBuilder4.setSize(media.getSize());
        newBuilder4.setWidth(media.getWidth());
        newBuilder4.setHeight(media.getHeight());
        newBuilder4.setLocalPath(file.getAbsolutePath());
        newBuilder4.setUrl(url);
        RoomMessage.ImageInfo build = newBuilder4.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        arrayList.add(build);
        newBuilder3.addAllImageInfoArray(arrayList);
        newBuilder2.setMsgType(HiloMessageType.ROOM_MESSAGE_IMAGE);
        newBuilder2.setImageContent(newBuilder3.build());
        newBuilder.addMsgBody(newBuilder2.build());
        if (user != null) {
            str = user.getExternalId();
        } else {
            str = null;
        }
        newBuilder.setMsgId(str + "_" + random);
        String str3 = "";
        if (user == null || (str2 = user.getExternalId()) == null) {
            str2 = "";
        }
        newBuilder.setFromAccount(str2);
        if (user != null && (externalId = user.getExternalId()) != null) {
            str3 = externalId;
        }
        newBuilder.setOperatorAccount(str3);
        newBuilder.setGroupId(groupId);
        newBuilder.setEventTime(random);
        newBuilder.setStatus(0);
        newBuilder.setMsgTab(1);
        RoomMessage.GroupMessageSend build2 = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build2, "build(...)");
        return build2;
    }

    public static /* synthetic */ RoomMessage.GroupMessageSend roomMessageImage$default(String str, LocalMedia localMedia, File file, String str2, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            str2 = "";
        }
        return roomMessageImage(str, localMedia, file, str2);
    }

    @NotNull
    public static final RoomMessage.GroupMessageSend roomMessageText(@NotNull String groupId, @NotNull String text, @Nullable List<RoomMessage.TextElemContentAt> list) {
        long j10;
        String str;
        String str2;
        String externalId;
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(text, "text");
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            j10 = service.getServerTime();
        } else {
            j10 = 0;
        }
        long random = (j10 * 1000) + RangesKt.random(new IntRange(0, 1000), Random.INSTANCE);
        User user = BaseControlUtils.INSTANCE.getUser();
        RoomMessage.GroupMessageSend.Builder newBuilder = RoomMessage.GroupMessageSend.newBuilder();
        RoomMessage.MsgBody.Builder newBuilder2 = RoomMessage.MsgBody.newBuilder();
        RoomMessage.TextElemContent.Builder newBuilder3 = RoomMessage.TextElemContent.newBuilder();
        newBuilder3.setText(text);
        if (list != null) {
            newBuilder3.addAllAtAccount(list);
        }
        newBuilder2.setMsgType(HiloMessageType.ROOM_MESSAGE_TEXT);
        newBuilder2.setTextContent(newBuilder3.build());
        newBuilder.addMsgBody(newBuilder2.build());
        if (user != null) {
            str = user.getExternalId();
        } else {
            str = null;
        }
        newBuilder.setMsgId(str + "_" + random);
        String str3 = "";
        if (user == null || (str2 = user.getExternalId()) == null) {
            str2 = "";
        }
        newBuilder.setFromAccount(str2);
        if (user != null && (externalId = user.getExternalId()) != null) {
            str3 = externalId;
        }
        newBuilder.setOperatorAccount(str3);
        newBuilder.setGroupId(groupId);
        newBuilder.setEventTime(random);
        newBuilder.setStatus(0);
        newBuilder.setMsgTab(1);
        RoomMessage.GroupMessageSend build = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    public static /* synthetic */ RoomMessage.GroupMessageSend roomMessageText$default(String str, String str2, List list, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            list = null;
        }
        return roomMessageText(str, str2, list);
    }

    @NotNull
    public static final RoomMessage.GroupMessageSend roomMessageVideo(@NotNull String groupId, @NotNull RoomMessage.VideoElemContent video) {
        long j10;
        String str;
        String str2;
        String externalId;
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(video, "video");
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            j10 = service.getServerTime();
        } else {
            j10 = 0;
        }
        long random = (j10 * 1000) + RangesKt.random(new IntRange(0, 1000), Random.INSTANCE);
        User user = BaseControlUtils.INSTANCE.getUser();
        RoomMessage.GroupMessageSend.Builder newBuilder = RoomMessage.GroupMessageSend.newBuilder();
        RoomMessage.MsgBody.Builder newBuilder2 = RoomMessage.MsgBody.newBuilder();
        newBuilder2.setMsgType(HiloMessageType.ROOM_MESSAGE_VIDEO);
        newBuilder2.setVideoContent(video);
        newBuilder.addMsgBody(newBuilder2.build());
        if (user != null) {
            str = user.getExternalId();
        } else {
            str = null;
        }
        newBuilder.setMsgId(str + "_" + random);
        String str3 = "";
        if (user == null || (str2 = user.getExternalId()) == null) {
            str2 = "";
        }
        newBuilder.setFromAccount(str2);
        if (user != null && (externalId = user.getExternalId()) != null) {
            str3 = externalId;
        }
        newBuilder.setOperatorAccount(str3);
        newBuilder.setGroupId(groupId);
        newBuilder.setEventTime(random);
        newBuilder.setStatus(0);
        newBuilder.setMsgTab(1);
        RoomMessage.GroupMessageSend build = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    @NotNull
    public static final CloudCustomData toCloudCustomData(@NotNull User user, boolean z10) {
        SvipData svip;
        Integer grade;
        Integer level;
        Intrinsics.checkNotNullParameter(user, "<this>");
        CloudCustomData cloudCustomData = new CloudCustomData(null, null, null, null, null, null, null, null, null, null, null, 0, EventType.ALL, null);
        cloudCustomData.setWealthGrade(Long.valueOf(user.getWealthUserGrade()));
        cloudCustomData.setCharmGrade(Long.valueOf(user.getCharmUserGrade()));
        cloudCustomData.setVip(Boolean.valueOf(user.isVip()));
        Boolean isPrettyCode = user.isPrettyCode();
        if (isPrettyCode == null) {
            isPrettyCode = Boolean.FALSE;
        }
        cloudCustomData.setPretty(isPrettyCode);
        ArrayList arrayList = new ArrayList();
        List<Integer> medals = user.getMedals();
        if (medals != null) {
            Iterator<T> it = medals.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((Number) it.next()).intValue()));
            }
        }
        cloudCustomData.setMedals(arrayList);
        FamilyInfo groupPower = user.getGroupPower();
        String str = null;
        cloudCustomData.setPowerName(groupPower != null ? groupPower.getName() : null);
        NobleInfo noble = user.getNoble();
        cloudCustomData.setNobleLevel((noble == null || (level = noble.getLevel()) == null) ? 0L : Long.valueOf(level.intValue()));
        cloudCustomData.setSvipLevel(user.getSvip() != null ? Long.valueOf(r2.getSvipLevel()) : 0L);
        FamilyInfo groupPower2 = user.getGroupPower();
        cloudCustomData.setPowerNameplate(groupPower2 != null ? groupPower2.getNameplate() : null);
        FamilyInfo groupPower3 = user.getGroupPower();
        cloudCustomData.setPowerGrade((groupPower3 == null || (grade = groupPower3.getGrade()) == null) ? 0L : Long.valueOf(grade.intValue()));
        Long valueOf = Long.valueOf(user.getSvip() != null ? r6.getSvipLevel() : 0L);
        if (!z10 && (svip = user.getSvip()) != null) {
            str = svip.mysteryNumber();
        }
        cloudCustomData.setSvip(new GMSvipDetail(valueOf, str));
        cloudCustomData.setCornerMark(user.getCornerMark());
        return cloudCustomData;
    }

    public static /* synthetic */ CloudCustomData toCloudCustomData$default(User user, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return toCloudCustomData(user, z10);
    }

    @NotNull
    public static final CustomElemContent toCustomElemContent(@NotNull RoomMessage.CustomElemContent customElemContent) {
        Intrinsics.checkNotNullParameter(customElemContent, "<this>");
        String data = customElemContent.getData();
        if (data.length() == 0) {
            data = null;
        }
        CustomElemContent customElemContent2 = new CustomElemContent(data, null, 2, null);
        String data2 = customElemContent2.getData();
        if (data2 == null) {
            data2 = "";
        }
        String checkRoomMessageType = checkRoomMessageType(data2);
        if (!TextUtils.isEmpty(checkRoomMessageType)) {
            try {
                customElemContent2.setDataType(BaseApplication.INSTANCE.getGSON().j(customElemContent2.getData(), HiloMessageType.INSTANCE.getCustomMessageMap().get(checkRoomMessageType)));
            } catch (Exception e10) {
                LogUtil logUtil = LogUtil.INSTANCE;
                e10.printStackTrace();
                LogUtil.e$default(logUtil, "eTag", "解析公屏自定义消息失败：" + Unit.INSTANCE, false, 4, (Object) null);
            }
        }
        return customElemContent2;
    }

    @NotNull
    public static final GMSvipDetail toGMSvipDetail(@NotNull RoomMessage.GMSvipDetail gMSvipDetail) {
        Intrinsics.checkNotNullParameter(gMSvipDetail, "<this>");
        Long valueOf = Long.valueOf(gMSvipDetail.getSvipLevel());
        String mysteryCode = gMSvipDetail.getMysteryCode();
        if (mysteryCode.length() == 0) {
            mysteryCode = null;
        }
        return new GMSvipDetail(valueOf, mysteryCode);
    }

    @NotNull
    public static final GroupMessageNew toGroupMessageNew(@NotNull RoomMessage.GroupMessageNew groupMessageNew) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        ArrayList arrayList;
        CloudCustomData cloudCustomData;
        Long l10;
        Long l11;
        Intrinsics.checkNotNullParameter(groupMessageNew, "<this>");
        String msgId = groupMessageNew.getMsgId();
        Integer num = null;
        if (msgId.length() == 0) {
            str = null;
        } else {
            str = msgId;
        }
        String fromAccount = groupMessageNew.getFromAccount();
        if (fromAccount.length() == 0) {
            str2 = null;
        } else {
            str2 = fromAccount;
        }
        String senderNick = groupMessageNew.getSenderNick();
        if (senderNick.length() == 0) {
            str3 = null;
        } else {
            str3 = senderNick;
        }
        String senderAvatar = groupMessageNew.getSenderAvatar();
        if (senderAvatar.length() == 0) {
            str4 = null;
        } else {
            str4 = senderAvatar;
        }
        String operatorAccount = groupMessageNew.getOperatorAccount();
        if (operatorAccount.length() == 0) {
            str5 = null;
        } else {
            str5 = operatorAccount;
        }
        String groupId = groupMessageNew.getGroupId();
        if (groupId.length() == 0) {
            str6 = null;
        } else {
            str6 = groupId;
        }
        List<RoomMessage.MsgBody> msgBodyList = groupMessageNew.getMsgBodyList();
        Intrinsics.checkNotNullExpressionValue(msgBodyList, "getMsgBodyList(...)");
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(msgBodyList, 10));
        for (RoomMessage.MsgBody msgBody : msgBodyList) {
            Intrinsics.checkNotNull(msgBody);
            arrayList2.add(toMsgBody(msgBody));
        }
        if (arrayList2.isEmpty()) {
            arrayList = null;
        } else {
            arrayList = arrayList2;
        }
        RoomMessage.CloudCustomData cloudCustomData2 = groupMessageNew.getCloudCustomData();
        if (cloudCustomData2 != null) {
            cloudCustomData = toCloudCustomData(cloudCustomData2);
        } else {
            cloudCustomData = null;
        }
        if (groupMessageNew.hasEventTime()) {
            l10 = Long.valueOf(groupMessageNew.getEventTime());
        } else {
            l10 = null;
        }
        if (groupMessageNew.hasUserId()) {
            l11 = Long.valueOf(groupMessageNew.getUserId());
        } else {
            l11 = null;
        }
        if (groupMessageNew.hasStatus()) {
            num = Integer.valueOf(groupMessageNew.getStatus());
        }
        return new GroupMessageNew(str, str2, str3, str4, str5, str6, arrayList, cloudCustomData, l10, l11, num, Integer.valueOf(groupMessageNew.getMsgTab()));
    }

    @NotNull
    public static final RoomMessage.GroupMessageSend toGroupMessageSend(@NotNull RoomMessageMulti roomMessageMulti) {
        long j10;
        int i10;
        int i11;
        int i12;
        long j11;
        int i13;
        long j12;
        int i14;
        int i15;
        long j13;
        int i16;
        Intrinsics.checkNotNullParameter(roomMessageMulti, "<this>");
        RoomMessage.GroupMessageSend.Builder newBuilder = RoomMessage.GroupMessageSend.newBuilder();
        GroupMessageNew data = roomMessageMulti.getData();
        if (data != null) {
            String msgId = data.getMsgId();
            if (msgId == null) {
                msgId = "";
            }
            newBuilder.setMsgId(msgId);
            String fromAccount = data.getFromAccount();
            if (fromAccount == null) {
                fromAccount = "";
            }
            newBuilder.setFromAccount(fromAccount);
            String operatorAccount = data.getOperatorAccount();
            if (operatorAccount == null) {
                operatorAccount = "";
            }
            newBuilder.setOperatorAccount(operatorAccount);
            String groupId = data.getGroupId();
            if (groupId == null) {
                groupId = "";
            }
            newBuilder.setGroupId(groupId);
            Long eventTime = data.getEventTime();
            if (eventTime != null) {
                j10 = eventTime.longValue();
            } else {
                j10 = 0;
            }
            newBuilder.setEventTime(j10);
            Integer status = data.getStatus();
            if (status != null) {
                i10 = status.intValue();
            } else {
                i10 = 0;
            }
            newBuilder.setStatus(i10);
            List<MsgBody> msgBody = data.getMsgBody();
            if (msgBody != null) {
                for (MsgBody msgBody2 : msgBody) {
                    RoomMessage.MsgBody.Builder newBuilder2 = RoomMessage.MsgBody.newBuilder();
                    String msgType = msgBody2.getMsgType();
                    if (msgType == null) {
                        msgType = "";
                    }
                    newBuilder2.setMsgType(msgType);
                    String msgType2 = msgBody2.getMsgType();
                    if (msgType2 != null) {
                        int hashCode = msgType2.hashCode();
                        int i17 = 1;
                        if (hashCode != -2030267602) {
                            if (hashCode != -1196694030) {
                                if (hashCode != -460155148) {
                                    if (hashCode == 1442075960 && msgType2.equals(HiloMessageType.ROOM_MESSAGE_CUSTOM)) {
                                        Integer msgTab = data.getMsgTab();
                                        if (msgTab != null) {
                                            i16 = msgTab.intValue();
                                        } else {
                                            i16 = 0;
                                        }
                                        newBuilder.setMsgTab(i16);
                                        CustomElemContent customContent = msgBody2.getCustomContent();
                                        if (customContent != null) {
                                            RoomMessage.CustomElemContent.Builder newBuilder3 = RoomMessage.CustomElemContent.newBuilder();
                                            String data2 = customContent.getData();
                                            if (data2 == null) {
                                                data2 = "";
                                            }
                                            newBuilder3.setData(data2);
                                            newBuilder2.setCustomContent(newBuilder3.build());
                                        }
                                    }
                                } else if (msgType2.equals(HiloMessageType.ROOM_MESSAGE_TEXT)) {
                                    Integer msgTab2 = data.getMsgTab();
                                    if (msgTab2 != null) {
                                        i17 = msgTab2.intValue();
                                    }
                                    newBuilder.setMsgTab(i17);
                                    TextElemContent textContent = msgBody2.getTextContent();
                                    if (textContent != null) {
                                        RoomMessage.TextElemContent.Builder newBuilder4 = RoomMessage.TextElemContent.newBuilder();
                                        String text = textContent.getText();
                                        if (text == null) {
                                            text = "";
                                        }
                                        newBuilder4.setText(text);
                                        List<TextElemContentAt> atAccount = textContent.getAtAccount();
                                        if (atAccount != null) {
                                            for (TextElemContentAt textElemContentAt : atAccount) {
                                                RoomMessage.TextElemContentAt.Builder newBuilder5 = RoomMessage.TextElemContentAt.newBuilder();
                                                String atAccount2 = textElemContentAt.getAtAccount();
                                                if (atAccount2 == null) {
                                                    atAccount2 = "";
                                                }
                                                newBuilder5.setAtAccount(atAccount2);
                                                String atNick = textElemContentAt.getAtNick();
                                                if (atNick == null) {
                                                    atNick = "";
                                                }
                                                newBuilder5.setAtNick(atNick);
                                                newBuilder4.addAtAccount(newBuilder5.build());
                                            }
                                        }
                                        newBuilder2.setTextContent(newBuilder4.build());
                                    }
                                }
                            } else if (msgType2.equals(HiloMessageType.ROOM_MESSAGE_IMAGE)) {
                                Integer msgTab3 = data.getMsgTab();
                                if (msgTab3 != null) {
                                    i17 = msgTab3.intValue();
                                }
                                newBuilder.setMsgTab(i17);
                                ImageElemContent imageContent = msgBody2.getImageContent();
                                if (imageContent != null) {
                                    RoomMessage.ImageElemContent.Builder newBuilder6 = RoomMessage.ImageElemContent.newBuilder();
                                    List<ImageInfo> imageInfoArray = imageContent.getImageInfoArray();
                                    if (imageInfoArray != null) {
                                        for (ImageInfo imageInfo : imageInfoArray) {
                                            RoomMessage.ImageInfo.Builder newBuilder7 = RoomMessage.ImageInfo.newBuilder();
                                            Integer width = imageInfo.getWidth();
                                            if (width != null) {
                                                i14 = width.intValue();
                                            } else {
                                                i14 = 0;
                                            }
                                            newBuilder7.setWidth(i14);
                                            Integer height = imageInfo.getHeight();
                                            if (height != null) {
                                                i15 = height.intValue();
                                            } else {
                                                i15 = 0;
                                            }
                                            newBuilder7.setHeight(i15);
                                            Long size = imageInfo.getSize();
                                            if (size != null) {
                                                j13 = size.longValue();
                                            } else {
                                                j13 = 0;
                                            }
                                            newBuilder7.setSize(j13);
                                            String url = imageInfo.getUrl();
                                            if (url == null) {
                                                url = "";
                                            }
                                            newBuilder7.setUrl(url);
                                            String localPath = imageInfo.getLocalPath();
                                            if (localPath == null) {
                                                localPath = "";
                                            }
                                            newBuilder7.setLocalPath(localPath);
                                            newBuilder6.addImageInfoArray(newBuilder7.build());
                                        }
                                    }
                                    newBuilder2.setImageContent(newBuilder6.build());
                                }
                            }
                        } else if (msgType2.equals(HiloMessageType.ROOM_MESSAGE_VIDEO)) {
                            Integer msgTab4 = data.getMsgTab();
                            if (msgTab4 != null) {
                                i17 = msgTab4.intValue();
                            }
                            newBuilder.setMsgTab(i17);
                            VideoElemContent videoContent = msgBody2.getVideoContent();
                            if (videoContent != null) {
                                RoomMessage.VideoElemContent.Builder newBuilder8 = RoomMessage.VideoElemContent.newBuilder();
                                Integer thumbWidth = videoContent.getThumbWidth();
                                if (thumbWidth != null) {
                                    i11 = thumbWidth.intValue();
                                } else {
                                    i11 = 0;
                                }
                                newBuilder8.setThumbWidth(i11);
                                Integer thumbHeight = videoContent.getThumbHeight();
                                if (thumbHeight != null) {
                                    i12 = thumbHeight.intValue();
                                } else {
                                    i12 = 0;
                                }
                                newBuilder8.setThumbHeight(i12);
                                Long thumbSize = videoContent.getThumbSize();
                                if (thumbSize != null) {
                                    j11 = thumbSize.longValue();
                                } else {
                                    j11 = 0;
                                }
                                newBuilder8.setThumbSize(j11);
                                String thumbUrl = videoContent.getThumbUrl();
                                if (thumbUrl == null) {
                                    thumbUrl = "";
                                }
                                newBuilder8.setThumbUrl(thumbUrl);
                                Integer videoSecond = videoContent.getVideoSecond();
                                if (videoSecond != null) {
                                    i13 = videoSecond.intValue();
                                } else {
                                    i13 = 0;
                                }
                                newBuilder8.setVideoSecond(i13);
                                Long videoSize = videoContent.getVideoSize();
                                if (videoSize != null) {
                                    j12 = videoSize.longValue();
                                } else {
                                    j12 = 0;
                                }
                                newBuilder8.setVideoSize(j12);
                                String videoUrl = videoContent.getVideoUrl();
                                if (videoUrl == null) {
                                    videoUrl = "";
                                }
                                newBuilder8.setVideoUrl(videoUrl);
                                String localPath2 = videoContent.getLocalPath();
                                if (localPath2 == null) {
                                    localPath2 = "";
                                }
                                newBuilder8.setLocalPath(localPath2);
                                String localThumbPath = videoContent.getLocalThumbPath();
                                if (localThumbPath == null) {
                                    localThumbPath = "";
                                }
                                newBuilder8.setLocalThumbPath(localThumbPath);
                                newBuilder2.setVideoContent(newBuilder8.build());
                            }
                        }
                    }
                    newBuilder.addMsgBody(newBuilder2.build());
                }
            }
        }
        RoomMessage.GroupMessageSend build = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    @NotNull
    public static final ImageElemContent toImageElemContent(@NotNull RoomMessage.ImageElemContent imageElemContent) {
        Intrinsics.checkNotNullParameter(imageElemContent, "<this>");
        List<RoomMessage.ImageInfo> imageInfoArrayList = imageElemContent.getImageInfoArrayList();
        Intrinsics.checkNotNullExpressionValue(imageInfoArrayList, "getImageInfoArrayList(...)");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(imageInfoArrayList, 10));
        for (RoomMessage.ImageInfo imageInfo : imageInfoArrayList) {
            Intrinsics.checkNotNull(imageInfo);
            arrayList.add(toImageInfo(imageInfo));
        }
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return new ImageElemContent(arrayList);
    }

    @NotNull
    public static final ImageInfo toImageInfo(@NotNull RoomMessage.ImageInfo imageInfo) {
        String str;
        Intrinsics.checkNotNullParameter(imageInfo, "<this>");
        Integer valueOf = Integer.valueOf(imageInfo.getWidth());
        Integer valueOf2 = Integer.valueOf(imageInfo.getHeight());
        Long valueOf3 = Long.valueOf(imageInfo.getSize());
        String url = imageInfo.getUrl();
        if (url.length() == 0) {
            url = null;
        }
        String localPath = imageInfo.getLocalPath();
        if (localPath.length() == 0) {
            str = null;
        } else {
            str = localPath;
        }
        return new ImageInfo(valueOf, valueOf2, valueOf3, url, str);
    }

    @NotNull
    public static final RoomMessageMulti toMessageMulti(@NotNull RoomMessage.GroupMessageSend groupMessageSend) {
        Intrinsics.checkNotNullParameter(groupMessageSend, "<this>");
        if (groupMessageSend.getMsgBodyList().isEmpty()) {
            return new RoomMessageMulti(null, 0, 1, null);
        }
        User user = BaseControlUtils.INSTANCE.getUser();
        GroupMessageNew groupMessageNew = new GroupMessageNew(null, null, null, null, null, null, null, null, null, null, null, null, EventType.ALL, null);
        groupMessageNew.setMsgId(groupMessageSend.getMsgId());
        groupMessageNew.setFromAccount(groupMessageSend.getFromAccount());
        groupMessageNew.setSenderNick(user != null ? user.getNick() : null);
        groupMessageNew.setSenderAvatar(user != null ? user.getAvatar() : null);
        List<RoomMessage.MsgBody> msgBodyList = groupMessageSend.getMsgBodyList();
        Intrinsics.checkNotNullExpressionValue(msgBodyList, "getMsgBodyList(...)");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(msgBodyList, 10));
        for (RoomMessage.MsgBody msgBody : msgBodyList) {
            Intrinsics.checkNotNull(msgBody);
            arrayList.add(toMsgBody(msgBody));
        }
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        groupMessageNew.setMsgBody(arrayList);
        groupMessageNew.setOperatorAccount(groupMessageSend.getOperatorAccount());
        groupMessageNew.setStatus(Integer.valueOf(groupMessageSend.getStatus()));
        groupMessageNew.setEventTime(Long.valueOf(groupMessageSend.getEventTime()));
        groupMessageNew.setGroupId(groupMessageSend.getGroupId());
        groupMessageNew.setCloudCustomData(user != null ? toCloudCustomData$default(user, false, 1, null) : null);
        groupMessageNew.setMsgTab(Integer.valueOf(groupMessageSend.getMsgTab()));
        String msgType = ((RoomMessage.MsgBody) groupMessageSend.getMsgBodyList().get(0)).getMsgType();
        if (msgType != null) {
            int hashCode = msgType.hashCode();
            if (hashCode != -2030267602) {
                if (hashCode != -1196694030) {
                    if (hashCode != -460155148) {
                        if (hashCode == 1442075960 && msgType.equals(HiloMessageType.ROOM_MESSAGE_CUSTOM)) {
                            String data = ((RoomMessage.MsgBody) groupMessageSend.getMsgBodyList().get(0)).getCustomContent().getData();
                            Intrinsics.checkNotNullExpressionValue(data, "getData(...)");
                            String checkRoomMessageType = checkRoomMessageType(data);
                            if (checkRoomMessageType == null) {
                                checkRoomMessageType = "";
                            }
                            if (!TextUtils.isEmpty(checkRoomMessageType)) {
                                return new RoomMessageMulti(groupMessageNew, RoomMessageMulti.INSTANCE.getMessageType(checkRoomMessageType));
                            }
                        }
                    } else if (msgType.equals(HiloMessageType.ROOM_MESSAGE_TEXT)) {
                        return new RoomMessageMulti(groupMessageNew, 1);
                    }
                } else if (msgType.equals(HiloMessageType.ROOM_MESSAGE_IMAGE)) {
                    return new RoomMessageMulti(groupMessageNew, 2);
                }
            } else if (msgType.equals(HiloMessageType.ROOM_MESSAGE_VIDEO)) {
                return new RoomMessageMulti(groupMessageNew, 3);
            }
        }
        return new RoomMessageMulti(groupMessageNew, 0);
    }

    @NotNull
    public static final MsgBody toMsgBody(@NotNull RoomMessage.MsgBody msgBody) {
        String str;
        CustomElemContent customElemContent;
        TextElemContent textElemContent;
        VideoElemContent videoElemContent;
        Intrinsics.checkNotNullParameter(msgBody, "<this>");
        String msgType = msgBody.getMsgType();
        ImageElemContent imageElemContent = null;
        if (msgType.length() == 0) {
            str = null;
        } else {
            str = msgType;
        }
        if (msgBody.hasCustomContent()) {
            RoomMessage.CustomElemContent customContent = msgBody.getCustomContent();
            Intrinsics.checkNotNullExpressionValue(customContent, "getCustomContent(...)");
            customElemContent = toCustomElemContent(customContent);
        } else {
            customElemContent = null;
        }
        if (msgBody.hasTextContent()) {
            RoomMessage.TextElemContent textContent = msgBody.getTextContent();
            Intrinsics.checkNotNullExpressionValue(textContent, "getTextContent(...)");
            textElemContent = toTextElemContent(textContent);
        } else {
            textElemContent = null;
        }
        if (msgBody.hasVideoContent()) {
            RoomMessage.VideoElemContent videoContent = msgBody.getVideoContent();
            Intrinsics.checkNotNullExpressionValue(videoContent, "getVideoContent(...)");
            videoElemContent = toVideoElemContent(videoContent);
        } else {
            videoElemContent = null;
        }
        if (msgBody.hasImageContent()) {
            RoomMessage.ImageElemContent imageContent = msgBody.getImageContent();
            Intrinsics.checkNotNullExpressionValue(imageContent, "getImageContent(...)");
            imageElemContent = toImageElemContent(imageContent);
        }
        return new MsgBody(str, customElemContent, textElemContent, videoElemContent, imageElemContent);
    }

    @NotNull
    public static final TextElemContent toTextElemContent(@NotNull RoomMessage.TextElemContent textElemContent) {
        Intrinsics.checkNotNullParameter(textElemContent, "<this>");
        String text = textElemContent.getText();
        ArrayList arrayList = null;
        if (text.length() == 0) {
            text = null;
        }
        List<RoomMessage.TextElemContentAt> atAccountList = textElemContent.getAtAccountList();
        Intrinsics.checkNotNullExpressionValue(atAccountList, "getAtAccountList(...)");
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(atAccountList, 10));
        for (RoomMessage.TextElemContentAt textElemContentAt : atAccountList) {
            Intrinsics.checkNotNull(textElemContentAt);
            arrayList2.add(toTextElemContentAt(textElemContentAt));
        }
        if (!arrayList2.isEmpty()) {
            arrayList = arrayList2;
        }
        return new TextElemContent(text, arrayList);
    }

    @NotNull
    public static final TextElemContentAt toTextElemContentAt(@NotNull RoomMessage.TextElemContentAt textElemContentAt) {
        Intrinsics.checkNotNullParameter(textElemContentAt, "<this>");
        String atAccount = textElemContentAt.getAtAccount();
        String str = null;
        if (atAccount.length() == 0) {
            atAccount = null;
        }
        String atNick = textElemContentAt.getAtNick();
        if (atNick.length() != 0) {
            str = atNick;
        }
        return new TextElemContentAt(atAccount, str);
    }

    @NotNull
    public static final VideoElemContent toVideoElemContent(@NotNull RoomMessage.VideoElemContent videoElemContent) {
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(videoElemContent, "<this>");
        Integer valueOf = Integer.valueOf(videoElemContent.getThumbWidth());
        Integer valueOf2 = Integer.valueOf(videoElemContent.getThumbHeight());
        Long valueOf3 = Long.valueOf(videoElemContent.getThumbSize());
        String thumbUrl = videoElemContent.getThumbUrl();
        if (thumbUrl.length() == 0) {
            thumbUrl = null;
        }
        Integer valueOf4 = Integer.valueOf(videoElemContent.getVideoSecond());
        Long valueOf5 = Long.valueOf(videoElemContent.getVideoSize());
        String videoUrl = videoElemContent.getVideoUrl();
        if (videoUrl.length() == 0) {
            str = null;
        } else {
            str = videoUrl;
        }
        String localPath = videoElemContent.getLocalPath();
        if (localPath.length() == 0) {
            str2 = null;
        } else {
            str2 = localPath;
        }
        String localThumbPath = videoElemContent.getLocalThumbPath();
        if (localThumbPath.length() == 0) {
            str3 = null;
        } else {
            str3 = localThumbPath;
        }
        return new VideoElemContent(valueOf, valueOf2, valueOf3, thumbUrl, valueOf4, valueOf5, str, str2, str3);
    }

    @Nullable
    public static final VideoElemContent videoInfo(@NotNull GroupMessageNew groupMessageNew) {
        MsgBody msgBody;
        Intrinsics.checkNotNullParameter(groupMessageNew, "<this>");
        List<MsgBody> msgBody2 = groupMessageNew.getMsgBody();
        if (msgBody2 != null && (msgBody = (MsgBody) CollectionsKt.getOrNull(msgBody2, 0)) != null) {
            return msgBody.getVideoContent();
        }
        return null;
    }

    @NotNull
    public static final CloudCustomData toCloudCustomData(@NotNull RoomMessage.CloudCustomData cloudCustomData) {
        GMSvipDetail gMSvipDetail;
        Intrinsics.checkNotNullParameter(cloudCustomData, "<this>");
        Long valueOf = Long.valueOf(cloudCustomData.getWealthGrade());
        Long valueOf2 = Long.valueOf(cloudCustomData.getCharmGrade());
        Boolean valueOf3 = Boolean.valueOf(cloudCustomData.getIsVip());
        Boolean valueOf4 = Boolean.valueOf(cloudCustomData.getIsPretty());
        List medalsList = cloudCustomData.getMedalsList();
        List list = medalsList.isEmpty() ? null : medalsList;
        String powerName = cloudCustomData.getPowerName();
        String str = powerName.length() == 0 ? null : powerName;
        Long valueOf5 = Long.valueOf(cloudCustomData.getNobleLevel());
        Long valueOf6 = Long.valueOf(cloudCustomData.getSvipLevel());
        String powerNameplate = cloudCustomData.getPowerNameplate();
        String str2 = powerNameplate.length() == 0 ? null : powerNameplate;
        Long valueOf7 = Long.valueOf(cloudCustomData.getPowerGrade());
        if (cloudCustomData.hasSvip()) {
            RoomMessage.GMSvipDetail svip = cloudCustomData.getSvip();
            Intrinsics.checkNotNullExpressionValue(svip, "getSvip(...)");
            gMSvipDetail = toGMSvipDetail(svip);
        } else {
            gMSvipDetail = null;
        }
        return new CloudCustomData(valueOf, valueOf2, valueOf3, valueOf4, list, str, valueOf5, valueOf6, str2, valueOf7, gMSvipDetail, cloudCustomData.getCornerMark());
    }

    @NotNull
    public static final RoomMessageMulti toMessageMulti(@NotNull RoomMessage.GroupMessageNew groupMessageNew) {
        Intrinsics.checkNotNullParameter(groupMessageNew, "<this>");
        if (groupMessageNew.getMsgBodyList().isEmpty()) {
            return new RoomMessageMulti(null, 0, 1, null);
        }
        String msgType = ((RoomMessage.MsgBody) groupMessageNew.getMsgBodyList().get(0)).getMsgType();
        if (msgType != null) {
            int hashCode = msgType.hashCode();
            if (hashCode != -2030267602) {
                if (hashCode != -1196694030) {
                    if (hashCode != -460155148) {
                        if (hashCode == 1442075960 && msgType.equals(HiloMessageType.ROOM_MESSAGE_CUSTOM)) {
                            String data = ((RoomMessage.MsgBody) groupMessageNew.getMsgBodyList().get(0)).getCustomContent().getData();
                            Intrinsics.checkNotNullExpressionValue(data, "getData(...)");
                            String checkRoomMessageType = checkRoomMessageType(data);
                            if (checkRoomMessageType == null) {
                                checkRoomMessageType = "";
                            }
                            if (!TextUtils.isEmpty(checkRoomMessageType)) {
                                return new RoomMessageMulti(toGroupMessageNew(groupMessageNew), RoomMessageMulti.INSTANCE.getMessageType(checkRoomMessageType));
                            }
                        }
                    } else if (msgType.equals(HiloMessageType.ROOM_MESSAGE_TEXT)) {
                        return new RoomMessageMulti(toGroupMessageNew(groupMessageNew), 1);
                    }
                } else if (msgType.equals(HiloMessageType.ROOM_MESSAGE_IMAGE)) {
                    return new RoomMessageMulti(toGroupMessageNew(groupMessageNew), 2);
                }
            } else if (msgType.equals(HiloMessageType.ROOM_MESSAGE_VIDEO)) {
                return new RoomMessageMulti(toGroupMessageNew(groupMessageNew), 3);
            }
        }
        return new RoomMessageMulti(toGroupMessageNew(groupMessageNew), 0);
    }
}
