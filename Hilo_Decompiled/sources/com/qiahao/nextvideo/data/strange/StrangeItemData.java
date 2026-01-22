package com.qiahao.nextvideo.data.strange;

import androidx.collection.c;
import com.tencent.imsdk.v2.V2TIMConversation;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\rHÆ\u0003JW\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\u0003HÖ\u0001J\t\u00104\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u00065"}, d2 = {"Lcom/qiahao/nextvideo/data/strange/StrangeItemData;", "", "unRead", "", "groupId", "", "lastMessageTime", "", "lastMessageStr", "strangeData", "Lcom/qiahao/nextvideo/data/strange/StrangeUserData;", "userStatus", "conversation", "Lcom/tencent/imsdk/v2/V2TIMConversation;", "<init>", "(ILjava/lang/String;JLjava/lang/String;Lcom/qiahao/nextvideo/data/strange/StrangeUserData;ILcom/tencent/imsdk/v2/V2TIMConversation;)V", "getUnRead", "()I", "setUnRead", "(I)V", "getGroupId", "()Ljava/lang/String;", "setGroupId", "(Ljava/lang/String;)V", "getLastMessageTime", "()J", "setLastMessageTime", "(J)V", "getLastMessageStr", "setLastMessageStr", "getStrangeData", "()Lcom/qiahao/nextvideo/data/strange/StrangeUserData;", "setStrangeData", "(Lcom/qiahao/nextvideo/data/strange/StrangeUserData;)V", "getUserStatus", "setUserStatus", "getConversation", "()Lcom/tencent/imsdk/v2/V2TIMConversation;", "setConversation", "(Lcom/tencent/imsdk/v2/V2TIMConversation;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class StrangeItemData {

    @Nullable
    private V2TIMConversation conversation;

    @Nullable
    private String groupId;

    @Nullable
    private String lastMessageStr;
    private long lastMessageTime;

    @Nullable
    private StrangeUserData strangeData;
    private int unRead;
    private int userStatus;

    public StrangeItemData() {
        this(0, null, 0L, null, null, 0, null, 127, null);
    }

    /* renamed from: component1, reason: from getter */
    public final int getUnRead() {
        return this.unRead;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    /* renamed from: component3, reason: from getter */
    public final long getLastMessageTime() {
        return this.lastMessageTime;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getLastMessageStr() {
        return this.lastMessageStr;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final StrangeUserData getStrangeData() {
        return this.strangeData;
    }

    /* renamed from: component6, reason: from getter */
    public final int getUserStatus() {
        return this.userStatus;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final V2TIMConversation getConversation() {
        return this.conversation;
    }

    @NotNull
    public final StrangeItemData copy(int unRead, @Nullable String groupId, long lastMessageTime, @Nullable String lastMessageStr, @Nullable StrangeUserData strangeData, int userStatus, @Nullable V2TIMConversation conversation) {
        return new StrangeItemData(unRead, groupId, lastMessageTime, lastMessageStr, strangeData, userStatus, conversation);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StrangeItemData)) {
            return false;
        }
        StrangeItemData strangeItemData = (StrangeItemData) other;
        return this.unRead == strangeItemData.unRead && Intrinsics.areEqual(this.groupId, strangeItemData.groupId) && this.lastMessageTime == strangeItemData.lastMessageTime && Intrinsics.areEqual(this.lastMessageStr, strangeItemData.lastMessageStr) && Intrinsics.areEqual(this.strangeData, strangeItemData.strangeData) && this.userStatus == strangeItemData.userStatus && Intrinsics.areEqual(this.conversation, strangeItemData.conversation);
    }

    @Nullable
    public final V2TIMConversation getConversation() {
        return this.conversation;
    }

    @Nullable
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    public final String getLastMessageStr() {
        return this.lastMessageStr;
    }

    public final long getLastMessageTime() {
        return this.lastMessageTime;
    }

    @Nullable
    public final StrangeUserData getStrangeData() {
        return this.strangeData;
    }

    public final int getUnRead() {
        return this.unRead;
    }

    public final int getUserStatus() {
        return this.userStatus;
    }

    public int hashCode() {
        int i = this.unRead * 31;
        String str = this.groupId;
        int hashCode = (((i + (str == null ? 0 : str.hashCode())) * 31) + c.a(this.lastMessageTime)) * 31;
        String str2 = this.lastMessageStr;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        StrangeUserData strangeUserData = this.strangeData;
        int hashCode3 = (((hashCode2 + (strangeUserData == null ? 0 : strangeUserData.hashCode())) * 31) + this.userStatus) * 31;
        V2TIMConversation v2TIMConversation = this.conversation;
        return hashCode3 + (v2TIMConversation != null ? v2TIMConversation.hashCode() : 0);
    }

    public final void setConversation(@Nullable V2TIMConversation v2TIMConversation) {
        this.conversation = v2TIMConversation;
    }

    public final void setGroupId(@Nullable String str) {
        this.groupId = str;
    }

    public final void setLastMessageStr(@Nullable String str) {
        this.lastMessageStr = str;
    }

    public final void setLastMessageTime(long j) {
        this.lastMessageTime = j;
    }

    public final void setStrangeData(@Nullable StrangeUserData strangeUserData) {
        this.strangeData = strangeUserData;
    }

    public final void setUnRead(int i) {
        this.unRead = i;
    }

    public final void setUserStatus(int i) {
        this.userStatus = i;
    }

    @NotNull
    public String toString() {
        return "StrangeItemData(unRead=" + this.unRead + ", groupId=" + this.groupId + ", lastMessageTime=" + this.lastMessageTime + ", lastMessageStr=" + this.lastMessageStr + ", strangeData=" + this.strangeData + ", userStatus=" + this.userStatus + ", conversation=" + this.conversation + ")";
    }

    public StrangeItemData(int i, @Nullable String str, long j, @Nullable String str2, @Nullable StrangeUserData strangeUserData, int i2, @Nullable V2TIMConversation v2TIMConversation) {
        this.unRead = i;
        this.groupId = str;
        this.lastMessageTime = j;
        this.lastMessageStr = str2;
        this.strangeData = strangeUserData;
        this.userStatus = i2;
        this.conversation = v2TIMConversation;
    }

    public /* synthetic */ StrangeItemData(int i, String str, long j, String str2, StrangeUserData strangeUserData, int i2, V2TIMConversation v2TIMConversation, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? 0L : j, (i3 & 8) != 0 ? null : str2, (i3 & 16) != 0 ? null : strangeUserData, (i3 & 32) != 0 ? 2 : i2, (i3 & 64) == 0 ? v2TIMConversation : null);
    }
}
