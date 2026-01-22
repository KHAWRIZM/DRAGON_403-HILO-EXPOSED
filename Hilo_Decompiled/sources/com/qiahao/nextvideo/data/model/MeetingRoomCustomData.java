package com.qiahao.nextvideo.data.model;

import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J>\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\r¨\u0006\""}, d2 = {"Lcom/qiahao/nextvideo/data/model/MeetingRoomCustomData;", "", "content", "", "msgId", "", "source", Constants.KEY_TARGET, "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getMsgId", "()Ljava/lang/Integer;", "setMsgId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSource", "setSource", "getTarget", "setTarget", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/qiahao/nextvideo/data/model/MeetingRoomCustomData;", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class MeetingRoomCustomData {

    @Nullable
    private String content;

    @Nullable
    private Integer msgId;

    @Nullable
    private String source;

    @Nullable
    private String target;

    public MeetingRoomCustomData() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ MeetingRoomCustomData copy$default(MeetingRoomCustomData meetingRoomCustomData, String str, Integer num, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = meetingRoomCustomData.content;
        }
        if ((i & 2) != 0) {
            num = meetingRoomCustomData.msgId;
        }
        if ((i & 4) != 0) {
            str2 = meetingRoomCustomData.source;
        }
        if ((i & 8) != 0) {
            str3 = meetingRoomCustomData.target;
        }
        return meetingRoomCustomData.copy(str, num, str2, str3);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getMsgId() {
        return this.msgId;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getSource() {
        return this.source;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getTarget() {
        return this.target;
    }

    @NotNull
    public final MeetingRoomCustomData copy(@Nullable String content, @Nullable Integer msgId, @Nullable String source, @Nullable String target) {
        return new MeetingRoomCustomData(content, msgId, source, target);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MeetingRoomCustomData)) {
            return false;
        }
        MeetingRoomCustomData meetingRoomCustomData = (MeetingRoomCustomData) other;
        return Intrinsics.areEqual(this.content, meetingRoomCustomData.content) && Intrinsics.areEqual(this.msgId, meetingRoomCustomData.msgId) && Intrinsics.areEqual(this.source, meetingRoomCustomData.source) && Intrinsics.areEqual(this.target, meetingRoomCustomData.target);
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final Integer getMsgId() {
        return this.msgId;
    }

    @Nullable
    public final String getSource() {
        return this.source;
    }

    @Nullable
    public final String getTarget() {
        return this.target;
    }

    public int hashCode() {
        String str = this.content;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.msgId;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.source;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.target;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setContent(@Nullable String str) {
        this.content = str;
    }

    public final void setMsgId(@Nullable Integer num) {
        this.msgId = num;
    }

    public final void setSource(@Nullable String str) {
        this.source = str;
    }

    public final void setTarget(@Nullable String str) {
        this.target = str;
    }

    @NotNull
    public String toString() {
        return "MeetingRoomCustomData(content=" + this.content + ", msgId=" + this.msgId + ", source=" + this.source + ", target=" + this.target + ")";
    }

    public MeetingRoomCustomData(@Nullable String str, @Nullable Integer num, @Nullable String str2, @Nullable String str3) {
        this.content = str;
        this.msgId = num;
        this.source = str2;
        this.target = str3;
    }

    public /* synthetic */ MeetingRoomCustomData(String str, Integer num, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? 0 : num, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
    }
}
