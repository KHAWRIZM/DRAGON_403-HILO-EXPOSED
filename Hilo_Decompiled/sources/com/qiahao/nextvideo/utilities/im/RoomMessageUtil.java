package com.qiahao.nextvideo.utilities.im;

import android.text.TextUtils;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.GroupGiftDetail;
import com.qiahao.base_common.model.common.FamilyInfo;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.im.GroupRoomImCustomBean;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.hilo_message.data.RoomTip;
import com.qiahao.hilo_message.message.RoomMessageView;
import com.qiahao.hilo_message.utils.BuildMessageUtilsKt;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.service.match.WebSocketProvide;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.taobao.accs.common.Constants;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMMessageManager;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.presenter.GroupChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import roomMessage.RoomMessage;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005J$\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fJ@\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\n2\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\"\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0010\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d¨\u0006\u001e"}, d2 = {"Lcom/qiahao/nextvideo/utilities/im/RoomMessageUtil;", "", "<init>", "()V", "clearMessage", "Lcom/qiahao/hilo_message/data/RoomTip;", "roomTaskTip", "ownWelcome", "Lcom/qiahao/base_common/model/im/GroupRoomImCustomBean;", "welcomeText", "", "own", "Lcom/qiahao/base_common/model/common/User;", "user", TUIConstants.TUIChat.METHOD_SEND_MESSAGE, "", Constants.SHARED_MESSAGE_ID_FILE, "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "groupId", SupportGiftRankActivity.EXTERNAL_ID, "listener", "Lcom/tencent/imsdk/v2/V2TIMValueCallback;", "Lcom/tencent/imsdk/v2/V2TIMMessage;", "presenter", "Lcom/tencent/qcloud/tuikit/tuichat/presenter/GroupChatPresenter;", "mChatLayout", "Lcom/qiahao/hilo_message/message/RoomMessageView;", "LroomMessage/RoomMessage$GroupMessageSend;", "addMessage", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomMessageUtil {

    @NotNull
    public static final RoomMessageUtil INSTANCE = new RoomMessageUtil();

    private RoomMessageUtil() {
    }

    public static /* synthetic */ void sendMessage$default(RoomMessageUtil roomMessageUtil, TUIMessageBean tUIMessageBean, String str, String str2, V2TIMValueCallback v2TIMValueCallback, GroupChatPresenter groupChatPresenter, int i, Object obj) {
        User user;
        if ((i & 4) != 0 && ((user = UserStore.INSTANCE.getShared().getUser()) == null || (str2 = user.getExternalId()) == null)) {
            str2 = "";
        }
        roomMessageUtil.sendMessage(tUIMessageBean, str, str2, (i & 8) != 0 ? null : v2TIMValueCallback, (i & 16) != 0 ? null : groupChatPresenter);
    }

    @NotNull
    public final RoomTip clearMessage() {
        return new RoomTip("108", 3, ResourcesKtxKt.getStringById(this, 2131953943));
    }

    @Nullable
    public final GroupRoomImCustomBean ownWelcome(@NotNull String welcomeText, @Nullable User own, @Nullable User user) {
        String str;
        String nick;
        String str2;
        String str3;
        int i;
        boolean z;
        String str4;
        String str5;
        Integer level;
        String str6;
        int i2 = 0;
        Intrinsics.checkNotNullParameter(welcomeText, "welcomeText");
        Integer num = null;
        if (own == null || user == null) {
            return null;
        }
        String avatar = user.getAvatar();
        if (avatar == null) {
            str = "";
        } else {
            str = avatar;
        }
        String externalId = user.getExternalId();
        SvipData svip = user.getSvip();
        if (svip != null && svip.isMystery()) {
            String stringById = ResourcesKtxKt.getStringById(this, 2131953504);
            SvipData svip2 = user.getSvip();
            if (svip2 != null) {
                str6 = svip2.mysteryNumber();
            } else {
                str6 = null;
            }
            nick = String.format(stringById, Arrays.copyOf(new Object[]{str6}, 1));
            Intrinsics.checkNotNullExpressionValue(nick, "format(...)");
        } else {
            nick = user.getNick();
            if (nick == null) {
                nick = "";
            }
        }
        String str7 = "@" + nick;
        String avatar2 = own.getAvatar();
        if (avatar2 == null) {
            str2 = "";
        } else {
            str2 = avatar2;
        }
        String externalId2 = own.getExternalId();
        String nick2 = own.getNick();
        if (nick2 == null) {
            str3 = "";
        } else {
            str3 = nick2;
        }
        Boolean valueOf = Boolean.valueOf(own.isVip());
        NobleInfo noble = own.getNoble();
        if (noble != null && (level = noble.getLevel()) != null) {
            i = level.intValue();
        } else {
            i = 0;
        }
        Integer valueOf2 = Integer.valueOf(i);
        Long valueOf3 = Long.valueOf(own.getWealthUserGrade());
        Long valueOf4 = Long.valueOf(own.getCharmUserGrade());
        Boolean isPrettyCode = own.isPrettyCode();
        if (isPrettyCode != null) {
            z = isPrettyCode.booleanValue();
        } else {
            z = false;
        }
        Boolean valueOf5 = Boolean.valueOf(z);
        String myGroupPowerName = own.getMyGroupPowerName();
        if (myGroupPowerName == null) {
            str4 = "";
        } else {
            str4 = myGroupPowerName;
        }
        FamilyInfo groupPower = own.getGroupPower();
        if (groupPower != null) {
            str5 = groupPower.getNameplate();
        } else {
            str5 = null;
        }
        FamilyInfo groupPower2 = own.getGroupPower();
        if (groupPower2 != null) {
            num = groupPower2.getGrade();
        }
        List medals = own.getMedals();
        SvipData svip3 = own.getSvip();
        if (svip3 != null) {
            i2 = svip3.getSvipLevel();
        }
        return new GroupRoomImCustomBean(str, externalId, str7, str2, externalId2, str3, "106", 1, 0L, 0L, valueOf, (ArrayList) null, "", "", "", "", "", "", 0, 0, 0, welcomeText, (Long) null, valueOf2, valueOf3, valueOf4, valueOf5, str4, str5, num, medals, (String) null, (GroupGiftDetail) null, (String) null, Integer.valueOf(i2), (SvipData) null, (SvipData) null, 0, -2143289344, 59, (DefaultConstructorMarker) null);
    }

    @NotNull
    public final RoomTip roomTaskTip() {
        return new RoomTip("132", 3, (String) null);
    }

    public final void sendMessage(@Nullable TUIMessageBean message, @NotNull String groupId, @NotNull String externalId, @Nullable V2TIMValueCallback<V2TIMMessage> listener, @Nullable final GroupChatPresenter presenter) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        if (message != null) {
            try {
                if (!TextUtils.isEmpty(groupId) && !TextUtils.isEmpty(externalId)) {
                    message.setStatus(2);
                    message.setCommonAttribute(message.getV2TIMMessage());
                    V2TIMMessageManager messageManager = V2TIMManager.getMessageManager();
                    V2TIMMessage v2TIMMessage = message.getV2TIMMessage();
                    if (listener == null) {
                        listener = new V2TIMValueCallback<V2TIMMessage>() { // from class: com.qiahao.nextvideo.utilities.im.RoomMessageUtil$sendMessage$1
                            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                            public void onError(int p0, String p1) {
                            }

                            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                            public void onSuccess(V2TIMMessage msg) {
                                GroupChatPresenter groupChatPresenter;
                                TUIMessageBean parseMessage = ChatMessageParser.parseMessage(msg);
                                parseMessage.setStatus(2);
                                GroupChatPresenter groupChatPresenter2 = GroupChatPresenter.this;
                                if (groupChatPresenter2 != null) {
                                    groupChatPresenter2.addMessageInfo(parseMessage);
                                }
                                if (!HiloUtils.INSTANCE.notFastClick() || (groupChatPresenter = GroupChatPresenter.this) == null) {
                                    return;
                                }
                                groupChatPresenter.scrollToNewestMessage();
                            }
                        };
                    }
                    messageManager.insertGroupMessageToLocalStorage(v2TIMMessage, groupId, externalId, listener);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static /* synthetic */ void sendMessage$default(RoomMessageUtil roomMessageUtil, RoomMessageView roomMessageView, RoomMessage.GroupMessageSend groupMessageSend, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        roomMessageUtil.sendMessage(roomMessageView, groupMessageSend, z);
    }

    public final void sendMessage(@Nullable RoomMessageView mChatLayout, @NotNull RoomMessage.GroupMessageSend message, boolean addMessage) {
        Intrinsics.checkNotNullParameter(message, Constants.SHARED_MESSAGE_ID_FILE);
        if (addMessage && mChatLayout != null) {
            mChatLayout.addData(BuildMessageUtilsKt.toMessageMulti(message), true);
        }
        WebSocketProvide.INSTANCE.roomMessage(message, new RoomMessageUtil$sendMessage$2(mChatLayout, null));
    }
}
