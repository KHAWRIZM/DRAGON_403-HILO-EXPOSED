package com.qiahao.nextvideo.data.model;

import com.qiahao.nextvideo.room.viewmodel.GroupSettingViewModel;
import com.tencent.qcloud.tuicore.TUIConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b;\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00108\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010#J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010;\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010<\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010=\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010>\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010#J\u009e\u0001\u0010?\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010@J\u0013\u0010A\u001a\u00020\b2\b\u0010B\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010C\u001a\u00020\nHÖ\u0001J\t\u0010D\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0014\"\u0004\b(\u0010\u0016R\u001e\u0010\f\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b)\u0010#\"\u0004\b*\u0010%R\u001e\u0010\r\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b+\u0010#\"\u0004\b,\u0010%R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b-\u0010#\"\u0004\b.\u0010%R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b/\u0010#\"\u0004\b0\u0010%R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b1\u0010#\"\u0004\b2\u0010%¨\u0006E"}, d2 = {"Lcom/qiahao/nextvideo/data/model/MeetingRoomCustomContent;", "", "name", "", "introduction", "notification", TUIConstants.TUIChat.FACE_URL, "micOn", "", "themeId", "", "themeUrl", "themeType", GroupSettingViewModel.TOURIST_MIC, GroupSettingViewModel.TOURIST_MSG, GroupSettingViewModel.TOURIST_PIC, "memberFee", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getIntroduction", "setIntroduction", "getNotification", "setNotification", "getFaceUrl", "setFaceUrl", "getMicOn", "()Ljava/lang/Boolean;", "setMicOn", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getThemeId", "()Ljava/lang/Integer;", "setThemeId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getThemeUrl", "setThemeUrl", "getThemeType", "setThemeType", "getTouristMic", "setTouristMic", "getTouristSendMsg", "setTouristSendMsg", "getTouristSendPic", "setTouristSendPic", "getMemberFee", "setMemberFee", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/qiahao/nextvideo/data/model/MeetingRoomCustomContent;", "equals", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class MeetingRoomCustomContent {

    @Nullable
    private String faceUrl;

    @Nullable
    private String introduction;

    @Nullable
    private Integer memberFee;

    @Nullable
    private Boolean micOn;

    @Nullable
    private String name;

    @Nullable
    private String notification;

    @Nullable
    private Integer themeId;

    @Nullable
    private Integer themeType;

    @Nullable
    private String themeUrl;

    @Nullable
    private Integer touristMic;

    @Nullable
    private Integer touristSendMsg;

    @Nullable
    private Integer touristSendPic;

    public MeetingRoomCustomContent(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Boolean bool, @Nullable Integer num, @Nullable String str5, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable Integer num5, @Nullable Integer num6) {
        this.name = str;
        this.introduction = str2;
        this.notification = str3;
        this.faceUrl = str4;
        this.micOn = bool;
        this.themeId = num;
        this.themeUrl = str5;
        this.themeType = num2;
        this.touristMic = num3;
        this.touristSendMsg = num4;
        this.touristSendPic = num5;
        this.memberFee = num6;
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final Integer getTouristSendMsg() {
        return this.touristSendMsg;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final Integer getTouristSendPic() {
        return this.touristSendPic;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final Integer getMemberFee() {
        return this.memberFee;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getIntroduction() {
        return this.introduction;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getNotification() {
        return this.notification;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getFaceUrl() {
        return this.faceUrl;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Boolean getMicOn() {
        return this.micOn;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Integer getThemeId() {
        return this.themeId;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getThemeUrl() {
        return this.themeUrl;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final Integer getThemeType() {
        return this.themeType;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final Integer getTouristMic() {
        return this.touristMic;
    }

    @NotNull
    public final MeetingRoomCustomContent copy(@Nullable String name, @Nullable String introduction, @Nullable String notification, @Nullable String faceUrl, @Nullable Boolean micOn, @Nullable Integer themeId, @Nullable String themeUrl, @Nullable Integer themeType, @Nullable Integer touristMic, @Nullable Integer touristSendMsg, @Nullable Integer touristSendPic, @Nullable Integer memberFee) {
        return new MeetingRoomCustomContent(name, introduction, notification, faceUrl, micOn, themeId, themeUrl, themeType, touristMic, touristSendMsg, touristSendPic, memberFee);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MeetingRoomCustomContent)) {
            return false;
        }
        MeetingRoomCustomContent meetingRoomCustomContent = (MeetingRoomCustomContent) other;
        return Intrinsics.areEqual(this.name, meetingRoomCustomContent.name) && Intrinsics.areEqual(this.introduction, meetingRoomCustomContent.introduction) && Intrinsics.areEqual(this.notification, meetingRoomCustomContent.notification) && Intrinsics.areEqual(this.faceUrl, meetingRoomCustomContent.faceUrl) && Intrinsics.areEqual(this.micOn, meetingRoomCustomContent.micOn) && Intrinsics.areEqual(this.themeId, meetingRoomCustomContent.themeId) && Intrinsics.areEqual(this.themeUrl, meetingRoomCustomContent.themeUrl) && Intrinsics.areEqual(this.themeType, meetingRoomCustomContent.themeType) && Intrinsics.areEqual(this.touristMic, meetingRoomCustomContent.touristMic) && Intrinsics.areEqual(this.touristSendMsg, meetingRoomCustomContent.touristSendMsg) && Intrinsics.areEqual(this.touristSendPic, meetingRoomCustomContent.touristSendPic) && Intrinsics.areEqual(this.memberFee, meetingRoomCustomContent.memberFee);
    }

    @Nullable
    public final String getFaceUrl() {
        return this.faceUrl;
    }

    @Nullable
    public final String getIntroduction() {
        return this.introduction;
    }

    @Nullable
    public final Integer getMemberFee() {
        return this.memberFee;
    }

    @Nullable
    public final Boolean getMicOn() {
        return this.micOn;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getNotification() {
        return this.notification;
    }

    @Nullable
    public final Integer getThemeId() {
        return this.themeId;
    }

    @Nullable
    public final Integer getThemeType() {
        return this.themeType;
    }

    @Nullable
    public final String getThemeUrl() {
        return this.themeUrl;
    }

    @Nullable
    public final Integer getTouristMic() {
        return this.touristMic;
    }

    @Nullable
    public final Integer getTouristSendMsg() {
        return this.touristSendMsg;
    }

    @Nullable
    public final Integer getTouristSendPic() {
        return this.touristSendPic;
    }

    public int hashCode() {
        String str = this.name;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.introduction;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.notification;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.faceUrl;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Boolean bool = this.micOn;
        int hashCode5 = (hashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num = this.themeId;
        int hashCode6 = (hashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        String str5 = this.themeUrl;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num2 = this.themeType;
        int hashCode8 = (hashCode7 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.touristMic;
        int hashCode9 = (hashCode8 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.touristSendMsg;
        int hashCode10 = (hashCode9 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.touristSendPic;
        int hashCode11 = (hashCode10 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.memberFee;
        return hashCode11 + (num6 != null ? num6.hashCode() : 0);
    }

    public final void setFaceUrl(@Nullable String str) {
        this.faceUrl = str;
    }

    public final void setIntroduction(@Nullable String str) {
        this.introduction = str;
    }

    public final void setMemberFee(@Nullable Integer num) {
        this.memberFee = num;
    }

    public final void setMicOn(@Nullable Boolean bool) {
        this.micOn = bool;
    }

    public final void setName(@Nullable String str) {
        this.name = str;
    }

    public final void setNotification(@Nullable String str) {
        this.notification = str;
    }

    public final void setThemeId(@Nullable Integer num) {
        this.themeId = num;
    }

    public final void setThemeType(@Nullable Integer num) {
        this.themeType = num;
    }

    public final void setThemeUrl(@Nullable String str) {
        this.themeUrl = str;
    }

    public final void setTouristMic(@Nullable Integer num) {
        this.touristMic = num;
    }

    public final void setTouristSendMsg(@Nullable Integer num) {
        this.touristSendMsg = num;
    }

    public final void setTouristSendPic(@Nullable Integer num) {
        this.touristSendPic = num;
    }

    @NotNull
    public String toString() {
        return "MeetingRoomCustomContent(name=" + this.name + ", introduction=" + this.introduction + ", notification=" + this.notification + ", faceUrl=" + this.faceUrl + ", micOn=" + this.micOn + ", themeId=" + this.themeId + ", themeUrl=" + this.themeUrl + ", themeType=" + this.themeType + ", touristMic=" + this.touristMic + ", touristSendMsg=" + this.touristSendMsg + ", touristSendPic=" + this.touristSendPic + ", memberFee=" + this.memberFee + ")";
    }

    public /* synthetic */ MeetingRoomCustomContent(String str, String str2, String str3, String str4, Boolean bool, Integer num, String str5, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, bool, num, str5, num2, (i & 256) != 0 ? null : num3, (i & 512) != 0 ? null : num4, (i & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0 ? null : num5, (i & 2048) != 0 ? null : num6);
    }
}
