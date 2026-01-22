package com.qiahao.nextvideo.ui.im;

import android.graphics.Bitmap;
import com.qiahao.nextvideo.data.model.GameMsg;
import com.qiahao.nextvideo.data.model.MsgForHiloOfficial;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010J\u001a\u00020\u00062\u0006\u0010K\u001a\u00020\u0000H\u0096\u0002J\u0016\u0010L\u001a\u00020\u00002\u0006\u0010M\u001a\u00020:2\u0006\u0010N\u001a\u00020\u000fJ\b\u0010O\u001a\u00020\u000fH\u0016J\u0013\u0010P\u001a\u00020$2\b\u0010K\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010Q\u001a\u00020\u0006H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010%\"\u0004\b)\u0010'R\u001a\u0010*\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u00106\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0011\"\u0004\b8\u0010\u0013R\u001c\u00109\u001a\u0004\u0018\u00010:X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0011\"\u0004\bA\u0010\u0013R\u001c\u0010B\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0011\"\u0004\bD\u0010\u0013R\u001a\u0010E\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\b\"\u0004\bG\u0010\nR\u001a\u0010H\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010%\"\u0004\bI\u0010'¨\u0006R"}, d2 = {"Lcom/qiahao/nextvideo/ui/im/MessageListInfo;", "Ljava/io/Serializable;", "", "<init>", "()V", "type", "", "getType", "()I", "setType", "(I)V", "unRead", "getUnRead", "setUnRead", TUIConstants.TUIConversation.CONVERSATION_ID, "", "getConversationId", "()Ljava/lang/String;", "setConversationId", "(Ljava/lang/String;)V", AgooConstants.MESSAGE_ID, "getId", "setId", "iconUrlList", "", "", "getIconUrlList", "()Ljava/util/List;", "setIconUrlList", "(Ljava/util/List;)V", "title", "getTitle", "setTitle", TUIConstants.TUIChat.INPUT_MORE_ICON, "Landroid/graphics/Bitmap;", "isGroup", "", "()Z", "setGroup", "(Z)V", TUIConstants.TUIConversation.IS_TOP, "setTop", "lastMessageTime", "", "getLastMessageTime", "()J", "setLastMessageTime", "(J)V", "lastMessage", "Lcom/tencent/imsdk/v2/V2TIMMessage;", "getLastMessage", "()Lcom/tencent/imsdk/v2/V2TIMMessage;", "setLastMessage", "(Lcom/tencent/imsdk/v2/V2TIMMessage;)V", "lastMessageStr", "getLastMessageStr", "setLastMessageStr", "systemMessage", "Lcom/qiahao/nextvideo/data/model/MsgForHiloOfficial;", "getSystemMessage", "()Lcom/qiahao/nextvideo/data/model/MsgForHiloOfficial;", "setSystemMessage", "(Lcom/qiahao/nextvideo/data/model/MsgForHiloOfficial;)V", "messageType", "getMessageType", "setMessageType", "atInfoText", "getAtInfoText", "setAtInfoText", "userStatus", "getUserStatus", "setUserStatus", "isHide", "setHide", "compareTo", "other", "createSystem", "system", "userIMType", "toString", "equals", "hashCode", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MessageListInfo implements Serializable, Comparable<MessageListInfo> {

    @Nullable
    private String atInfoText;

    @Nullable
    private String conversationId;

    @Nullable
    private final Bitmap icon;

    @Nullable
    private String id;
    private boolean isGroup;
    private boolean isHide;
    private boolean isTop;

    @Nullable
    private V2TIMMessage lastMessage;

    @Nullable
    private String lastMessageStr;
    private long lastMessageTime;

    @Nullable
    private MsgForHiloOfficial systemMessage;

    @Nullable
    private String title;
    private int type;
    private int unRead;

    @NotNull
    private List<? extends Object> iconUrlList = new ArrayList();

    @NotNull
    private String messageType = "HILO_Message";
    private int userStatus = 2;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0088, code lost:
    
        return r1;
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final MessageListInfo createSystem(@NotNull MsgForHiloOfficial system, @NotNull String userIMType) {
        int i;
        Integer msgNoRead;
        Intrinsics.checkNotNullParameter(system, "system");
        Intrinsics.checkNotNullParameter(userIMType, "userIMType");
        this.systemMessage = system;
        this.messageType = userIMType;
        switch (userIMType.hashCode()) {
            case -1979315295:
                if (userIMType.equals("Strange_list")) {
                    this.unRead = StrangerProvide.INSTANCE.getUnReadMessage();
                    break;
                }
                break;
            case -1675218269:
                if (userIMType.equals("Hilo_Assistant")) {
                    this.unRead = system.getUserMsgNoRead();
                    break;
                }
                break;
            case -1273866319:
                if (userIMType.equals("Hilo_Information")) {
                    this.unRead = system.getSysMsgNotRead();
                    break;
                }
                break;
            case -1136986362:
                if (userIMType.equals("Hilo_Notification")) {
                    this.unRead = system.getMomentMsgNoRead();
                    break;
                }
                break;
            case -933217857:
                if (userIMType.equals("Hilo_Family")) {
                    this.unRead = system.getFamilyMsgNoRead();
                    break;
                }
                break;
            case -271174614:
                if (userIMType.equals("Hilo_match")) {
                    GameMsg gameMsg = system.getGameMsg();
                    if (gameMsg != null && (msgNoRead = gameMsg.getMsgNoRead()) != null) {
                        i = msgNoRead.intValue();
                    } else {
                        i = 0;
                    }
                    this.unRead = i;
                    break;
                }
                break;
        }
    }

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        if (this == other) {
            return true;
        }
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(MessageListInfo.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.qiahao.nextvideo.ui.im.MessageListInfo");
        MessageListInfo messageListInfo = (MessageListInfo) other;
        if (this.type != messageListInfo.type || this.unRead != messageListInfo.unRead || !Intrinsics.areEqual(this.conversationId, messageListInfo.conversationId) || !Intrinsics.areEqual(this.id, messageListInfo.id) || !Intrinsics.areEqual(this.iconUrlList, messageListInfo.iconUrlList) || !Intrinsics.areEqual(this.title, messageListInfo.title) || !Intrinsics.areEqual(this.icon, messageListInfo.icon) || this.isGroup != messageListInfo.isGroup || this.isTop != messageListInfo.isTop || this.lastMessageTime != messageListInfo.lastMessageTime || !Intrinsics.areEqual(this.lastMessage, messageListInfo.lastMessage) || !Intrinsics.areEqual(this.lastMessageStr, messageListInfo.lastMessageStr) || !Intrinsics.areEqual(this.systemMessage, messageListInfo.systemMessage) || !Intrinsics.areEqual(this.messageType, messageListInfo.messageType)) {
            return false;
        }
        return Intrinsics.areEqual(this.atInfoText, messageListInfo.atInfoText);
    }

    @Nullable
    public final String getAtInfoText() {
        return this.atInfoText;
    }

    @Nullable
    public final String getConversationId() {
        return this.conversationId;
    }

    @NotNull
    public final List<Object> getIconUrlList() {
        return this.iconUrlList;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final V2TIMMessage getLastMessage() {
        return this.lastMessage;
    }

    @Nullable
    public final String getLastMessageStr() {
        return this.lastMessageStr;
    }

    public final long getLastMessageTime() {
        return this.lastMessageTime;
    }

    @NotNull
    public final String getMessageType() {
        return this.messageType;
    }

    @Nullable
    public final MsgForHiloOfficial getSystemMessage() {
        return this.systemMessage;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }

    public final int getUnRead() {
        return this.unRead;
    }

    public final int getUserStatus() {
        return this.userStatus;
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = ((this.type * 31) + this.unRead) * 31;
        String str = this.conversationId;
        int i9 = 0;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        int i10 = (i8 + i) * 31;
        String str2 = this.id;
        if (str2 != null) {
            i2 = str2.hashCode();
        } else {
            i2 = 0;
        }
        int hashCode = (((i10 + i2) * 31) + this.iconUrlList.hashCode()) * 31;
        String str3 = this.title;
        if (str3 != null) {
            i3 = str3.hashCode();
        } else {
            i3 = 0;
        }
        int i11 = (hashCode + i3) * 31;
        Bitmap bitmap = this.icon;
        if (bitmap != null) {
            i4 = bitmap.hashCode();
        } else {
            i4 = 0;
        }
        int a = (((((((i11 + i4) * 31) + q2.a.a(this.isGroup)) * 31) + q2.a.a(this.isTop)) * 31) + androidx.collection.c.a(this.lastMessageTime)) * 31;
        V2TIMMessage v2TIMMessage = this.lastMessage;
        if (v2TIMMessage != null) {
            i5 = v2TIMMessage.hashCode();
        } else {
            i5 = 0;
        }
        int i12 = (a + i5) * 31;
        String str4 = this.lastMessageStr;
        if (str4 != null) {
            i6 = str4.hashCode();
        } else {
            i6 = 0;
        }
        int i13 = (i12 + i6) * 31;
        MsgForHiloOfficial msgForHiloOfficial = this.systemMessage;
        if (msgForHiloOfficial != null) {
            i7 = msgForHiloOfficial.hashCode();
        } else {
            i7 = 0;
        }
        int hashCode2 = (((i13 + i7) * 31) + this.messageType.hashCode()) * 31;
        String str5 = this.atInfoText;
        if (str5 != null) {
            i9 = str5.hashCode();
        }
        return hashCode2 + i9;
    }

    /* renamed from: isGroup, reason: from getter */
    public final boolean getIsGroup() {
        return this.isGroup;
    }

    /* renamed from: isHide, reason: from getter */
    public final boolean getIsHide() {
        return this.isHide;
    }

    /* renamed from: isTop, reason: from getter */
    public final boolean getIsTop() {
        return this.isTop;
    }

    public final void setAtInfoText(@Nullable String str) {
        this.atInfoText = str;
    }

    public final void setConversationId(@Nullable String str) {
        this.conversationId = str;
    }

    public final void setGroup(boolean z) {
        this.isGroup = z;
    }

    public final void setHide(boolean z) {
        this.isHide = z;
    }

    public final void setIconUrlList(@NotNull List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.iconUrlList = list;
    }

    public final void setId(@Nullable String str) {
        this.id = str;
    }

    public final void setLastMessage(@Nullable V2TIMMessage v2TIMMessage) {
        this.lastMessage = v2TIMMessage;
    }

    public final void setLastMessageStr(@Nullable String str) {
        this.lastMessageStr = str;
    }

    public final void setLastMessageTime(long j) {
        this.lastMessageTime = j;
    }

    public final void setMessageType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.messageType = str;
    }

    public final void setSystemMessage(@Nullable MsgForHiloOfficial msgForHiloOfficial) {
        this.systemMessage = msgForHiloOfficial;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    public final void setTop(boolean z) {
        this.isTop = z;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final void setUnRead(int i) {
        this.unRead = i;
    }

    public final void setUserStatus(int i) {
        this.userStatus = i;
    }

    @NotNull
    public String toString() {
        return "MessageListInfo(type=" + this.type + ", unRead=" + this.unRead + ", conversationId=" + this.conversationId + ", id=" + this.id + ", iconUrlList=" + this.iconUrlList + ", title=" + this.title + ", icon=" + this.icon + ", isGroup=" + this.isGroup + ", isTop=" + this.isTop + ", lastMessageTime=" + this.lastMessageTime + ", lastMessage=" + this.lastMessage + ", systemMessage=" + this.systemMessage + ", atInfoText=" + this.atInfoText + ")";
    }

    @Override // java.lang.Comparable
    public int compareTo(@NotNull MessageListInfo other) {
        Intrinsics.checkNotNullParameter(other, "other");
        long j = this.lastMessageTime;
        long j2 = other.lastMessageTime;
        if (j > j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }
}
