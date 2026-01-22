package com.qiahao.nextvideo.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\bF\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B§\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\t\u0010<\u001a\u00020\u0007HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0007HÆ\u0003J\t\u0010B\u001a\u00020\u0007HÆ\u0003J\t\u0010C\u001a\u00020\u0007HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0005HÆ\u0003J\t\u0010G\u001a\u00020\u0007HÆ\u0003J\t\u0010H\u001a\u00020\u0005HÆ\u0003J\t\u0010I\u001a\u00020\u0007HÆ\u0003J«\u0001\u0010J\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u0007HÆ\u0001J\u0006\u0010K\u001a\u00020\u0007J\u0013\u0010L\u001a\u00020\u00052\b\u0010M\u001a\u0004\u0018\u00010NHÖ\u0003J\t\u0010O\u001a\u00020\u0007HÖ\u0001J\t\u0010P\u001a\u00020\u0003HÖ\u0001J\u0016\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0018\"\u0004\b%\u0010\u001aR\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0018\"\u0004\b'\u0010\u001aR\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0018\"\u0004\b)\u0010\u001aR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001f\"\u0004\b+\u0010!R\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001f\"\u0004\b-\u0010!R\u001a\u0010\u000e\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001f\"\u0004\b/\u0010!R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0018\"\u0004\b1\u0010\u001aR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0018\"\u0004\b3\u0010\u001aR\u001a\u0010\u0011\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u001b\"\u0004\b4\u0010\u001dR\u001a\u0010\u0012\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001f\"\u0004\b6\u0010!R\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u001b\"\u0004\b7\u0010\u001dR\u001a\u0010\u0014\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001f\"\u0004\b9\u0010!¨\u0006V"}, d2 = {"Lcom/qiahao/nextvideo/data/model/EnterRoomData;", "Landroid/os/Parcelable;", "groupId", "", "isForSmallRoom", "", "sceneType", "", "sceneUid", "password", "agoraChannel", "agoraToken", "agoraId", "microType", "gameType", "gameCode", "groupPk", "isPasswordRoom", "provider", "is1V1", "gameMode", "<init>", "(Ljava/lang/String;ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;ZIZI)V", "getGroupId", "()Ljava/lang/String;", "setGroupId", "(Ljava/lang/String;)V", "()Z", "setForSmallRoom", "(Z)V", "getSceneType", "()I", "setSceneType", "(I)V", "getSceneUid", "setSceneUid", "getPassword", "setPassword", "getAgoraChannel", "setAgoraChannel", "getAgoraToken", "setAgoraToken", "getAgoraId", "setAgoraId", "getMicroType", "setMicroType", "getGameType", "setGameType", "getGameCode", "setGameCode", "getGroupPk", "setGroupPk", "setPasswordRoom", "getProvider", "setProvider", "set1V1", "getGameMode", "setGameMode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class EnterRoomData implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<EnterRoomData> CREATOR = new Creator();

    @NotNull
    private String agoraChannel;
    private int agoraId;

    @NotNull
    private String agoraToken;

    @NotNull
    private String gameCode;
    private int gameMode;
    private int gameType;

    @NotNull
    private String groupId;

    @Nullable
    private String groupPk;
    private boolean is1V1;
    private boolean isForSmallRoom;
    private boolean isPasswordRoom;
    private int microType;

    @NotNull
    private String password;
    private int provider;
    private int sceneType;

    @NotNull
    private String sceneUid;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<EnterRoomData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final EnterRoomData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new EnterRoomData(parcel.readString(), parcel.readInt() != 0, parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt(), parcel.readInt() != 0, parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final EnterRoomData[] newArray(int i) {
            return new EnterRoomData[i];
        }
    }

    public EnterRoomData(@NotNull String str, boolean z, int i, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, int i2, int i3, int i4, @NotNull String str6, @Nullable String str7, boolean z2, int i5, boolean z3, int i6) {
        Intrinsics.checkNotNullParameter(str, "groupId");
        Intrinsics.checkNotNullParameter(str2, "sceneUid");
        Intrinsics.checkNotNullParameter(str3, "password");
        Intrinsics.checkNotNullParameter(str4, "agoraChannel");
        Intrinsics.checkNotNullParameter(str5, "agoraToken");
        Intrinsics.checkNotNullParameter(str6, "gameCode");
        this.groupId = str;
        this.isForSmallRoom = z;
        this.sceneType = i;
        this.sceneUid = str2;
        this.password = str3;
        this.agoraChannel = str4;
        this.agoraToken = str5;
        this.agoraId = i2;
        this.microType = i3;
        this.gameType = i4;
        this.gameCode = str6;
        this.groupPk = str7;
        this.isPasswordRoom = z2;
        this.provider = i5;
        this.is1V1 = z3;
        this.gameMode = i6;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    /* renamed from: component10, reason: from getter */
    public final int getGameType() {
        return this.gameType;
    }

    @NotNull
    /* renamed from: component11, reason: from getter */
    public final String getGameCode() {
        return this.gameCode;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final String getGroupPk() {
        return this.groupPk;
    }

    /* renamed from: component13, reason: from getter */
    public final boolean getIsPasswordRoom() {
        return this.isPasswordRoom;
    }

    /* renamed from: component14, reason: from getter */
    public final int getProvider() {
        return this.provider;
    }

    /* renamed from: component15, reason: from getter */
    public final boolean getIs1V1() {
        return this.is1V1;
    }

    /* renamed from: component16, reason: from getter */
    public final int getGameMode() {
        return this.gameMode;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsForSmallRoom() {
        return this.isForSmallRoom;
    }

    /* renamed from: component3, reason: from getter */
    public final int getSceneType() {
        return this.sceneType;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getSceneUid() {
        return this.sceneUid;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getPassword() {
        return this.password;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getAgoraChannel() {
        return this.agoraChannel;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final String getAgoraToken() {
        return this.agoraToken;
    }

    /* renamed from: component8, reason: from getter */
    public final int getAgoraId() {
        return this.agoraId;
    }

    /* renamed from: component9, reason: from getter */
    public final int getMicroType() {
        return this.microType;
    }

    @NotNull
    public final EnterRoomData copy(@NotNull String groupId, boolean isForSmallRoom, int sceneType, @NotNull String sceneUid, @NotNull String password, @NotNull String agoraChannel, @NotNull String agoraToken, int agoraId, int microType, int gameType, @NotNull String gameCode, @Nullable String groupPk, boolean isPasswordRoom, int provider, boolean is1V1, int gameMode) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(sceneUid, "sceneUid");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(agoraChannel, "agoraChannel");
        Intrinsics.checkNotNullParameter(agoraToken, "agoraToken");
        Intrinsics.checkNotNullParameter(gameCode, "gameCode");
        return new EnterRoomData(groupId, isForSmallRoom, sceneType, sceneUid, password, agoraChannel, agoraToken, agoraId, microType, gameType, gameCode, groupPk, isPasswordRoom, provider, is1V1, gameMode);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EnterRoomData)) {
            return false;
        }
        EnterRoomData enterRoomData = (EnterRoomData) other;
        return Intrinsics.areEqual(this.groupId, enterRoomData.groupId) && this.isForSmallRoom == enterRoomData.isForSmallRoom && this.sceneType == enterRoomData.sceneType && Intrinsics.areEqual(this.sceneUid, enterRoomData.sceneUid) && Intrinsics.areEqual(this.password, enterRoomData.password) && Intrinsics.areEqual(this.agoraChannel, enterRoomData.agoraChannel) && Intrinsics.areEqual(this.agoraToken, enterRoomData.agoraToken) && this.agoraId == enterRoomData.agoraId && this.microType == enterRoomData.microType && this.gameType == enterRoomData.gameType && Intrinsics.areEqual(this.gameCode, enterRoomData.gameCode) && Intrinsics.areEqual(this.groupPk, enterRoomData.groupPk) && this.isPasswordRoom == enterRoomData.isPasswordRoom && this.provider == enterRoomData.provider && this.is1V1 == enterRoomData.is1V1 && this.gameMode == enterRoomData.gameMode;
    }

    @NotNull
    public final String getAgoraChannel() {
        return this.agoraChannel;
    }

    public final int getAgoraId() {
        return this.agoraId;
    }

    @NotNull
    public final String getAgoraToken() {
        return this.agoraToken;
    }

    @NotNull
    public final String getGameCode() {
        return this.gameCode;
    }

    public final int getGameMode() {
        return this.gameMode;
    }

    public final int getGameType() {
        return this.gameType;
    }

    @NotNull
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    public final String getGroupPk() {
        return this.groupPk;
    }

    public final int getMicroType() {
        return this.microType;
    }

    @NotNull
    public final String getPassword() {
        return this.password;
    }

    public final int getProvider() {
        return this.provider;
    }

    public final int getSceneType() {
        return this.sceneType;
    }

    @NotNull
    public final String getSceneUid() {
        return this.sceneUid;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((this.groupId.hashCode() * 31) + a.a(this.isForSmallRoom)) * 31) + this.sceneType) * 31) + this.sceneUid.hashCode()) * 31) + this.password.hashCode()) * 31) + this.agoraChannel.hashCode()) * 31) + this.agoraToken.hashCode()) * 31) + this.agoraId) * 31) + this.microType) * 31) + this.gameType) * 31) + this.gameCode.hashCode()) * 31;
        String str = this.groupPk;
        return ((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + a.a(this.isPasswordRoom)) * 31) + this.provider) * 31) + a.a(this.is1V1)) * 31) + this.gameMode;
    }

    public final boolean is1V1() {
        return this.is1V1;
    }

    public final boolean isForSmallRoom() {
        return this.isForSmallRoom;
    }

    public final boolean isPasswordRoom() {
        return this.isPasswordRoom;
    }

    public final void set1V1(boolean z) {
        this.is1V1 = z;
    }

    public final void setAgoraChannel(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.agoraChannel = str;
    }

    public final void setAgoraId(int i) {
        this.agoraId = i;
    }

    public final void setAgoraToken(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.agoraToken = str;
    }

    public final void setForSmallRoom(boolean z) {
        this.isForSmallRoom = z;
    }

    public final void setGameCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.gameCode = str;
    }

    public final void setGameMode(int i) {
        this.gameMode = i;
    }

    public final void setGameType(int i) {
        this.gameType = i;
    }

    public final void setGroupId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.groupId = str;
    }

    public final void setGroupPk(@Nullable String str) {
        this.groupPk = str;
    }

    public final void setMicroType(int i) {
        this.microType = i;
    }

    public final void setPassword(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.password = str;
    }

    public final void setPasswordRoom(boolean z) {
        this.isPasswordRoom = z;
    }

    public final void setProvider(int i) {
        this.provider = i;
    }

    public final void setSceneType(int i) {
        this.sceneType = i;
    }

    public final void setSceneUid(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sceneUid = str;
    }

    @NotNull
    public String toString() {
        return "EnterRoomData(groupId=" + this.groupId + ", isForSmallRoom=" + this.isForSmallRoom + ", sceneType=" + this.sceneType + ", sceneUid=" + this.sceneUid + ", password=" + this.password + ", agoraChannel=" + this.agoraChannel + ", agoraToken=" + this.agoraToken + ", agoraId=" + this.agoraId + ", microType=" + this.microType + ", gameType=" + this.gameType + ", gameCode=" + this.gameCode + ", groupPk=" + this.groupPk + ", isPasswordRoom=" + this.isPasswordRoom + ", provider=" + this.provider + ", is1V1=" + this.is1V1 + ", gameMode=" + this.gameMode + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.groupId);
        dest.writeInt(this.isForSmallRoom ? 1 : 0);
        dest.writeInt(this.sceneType);
        dest.writeString(this.sceneUid);
        dest.writeString(this.password);
        dest.writeString(this.agoraChannel);
        dest.writeString(this.agoraToken);
        dest.writeInt(this.agoraId);
        dest.writeInt(this.microType);
        dest.writeInt(this.gameType);
        dest.writeString(this.gameCode);
        dest.writeString(this.groupPk);
        dest.writeInt(this.isPasswordRoom ? 1 : 0);
        dest.writeInt(this.provider);
        dest.writeInt(this.is1V1 ? 1 : 0);
        dest.writeInt(this.gameMode);
    }

    public /* synthetic */ EnterRoomData(String str, boolean z, int i, String str2, String str3, String str4, String str5, int i2, int i3, int i4, String str6, String str7, boolean z2, int i5, boolean z3, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i7 & 2) != 0 ? false : z, (i7 & 4) != 0 ? 0 : i, (i7 & 8) != 0 ? "" : str2, (i7 & 16) != 0 ? "" : str3, (i7 & 32) != 0 ? "" : str4, (i7 & 64) != 0 ? "" : str5, (i7 & 128) != 0 ? 0 : i2, (i7 & 256) != 0 ? 0 : i3, (i7 & 512) != 0 ? 0 : i4, (i7 & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) == 0 ? str6 : "", (i7 & 2048) != 0 ? null : str7, (i7 & 4096) != 0 ? false : z2, (i7 & 8192) != 0 ? -1 : i5, (i7 & 16384) != 0 ? false : z3, (i7 & 32768) == 0 ? i6 : 0);
    }
}
