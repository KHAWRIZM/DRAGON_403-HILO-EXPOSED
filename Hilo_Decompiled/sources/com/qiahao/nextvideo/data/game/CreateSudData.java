package com.qiahao.nextvideo.data.game;

import android.os.Parcel;
import android.os.Parcelable;
import com.qiahao.nextvideo.sheep.GameMatchActivity;
import com.qiahao.nextvideo.ui.wallet.ExchangeDetailActivity;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b(\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B]\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010%Jd\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u00102J\u0006\u00103\u001a\u00020\u0003J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107HÖ\u0003J\t\u00108\u001a\u00020\u0003HÖ\u0001J\t\u00109\u001a\u00020\nHÖ\u0001J\u0016\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u0003R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006?"}, d2 = {"Lcom/qiahao/nextvideo/data/game/CreateSudData;", "Landroid/os/Parcelable;", "gameType", "", Constants.KEY_MODE, "piece", "onOff1", ExchangeDetailActivity.TYPE_DIAMOND, "autoMatch", "groupId", "", GameMatchActivity.GAME_ID, "", "<init>", "(Ljava/lang/Integer;IIIIILjava/lang/String;Ljava/lang/Long;)V", "getGameType", "()Ljava/lang/Integer;", "setGameType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMode", "()I", "setMode", "(I)V", "getPiece", "setPiece", "getOnOff1", "setOnOff1", "getDiamond", "setDiamond", "getAutoMatch", "setAutoMatch", "getGroupId", "()Ljava/lang/String;", "setGroupId", "(Ljava/lang/String;)V", "getGameId", "()Ljava/lang/Long;", "setGameId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Integer;IIIIILjava/lang/String;Ljava/lang/Long;)Lcom/qiahao/nextvideo/data/game/CreateSudData;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class CreateSudData implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<CreateSudData> CREATOR = new Creator();
    private int autoMatch;
    private int diamond;

    @Nullable
    private Long gameId;

    @Nullable
    private Integer gameType;

    @Nullable
    private String groupId;
    private int mode;
    private int onOff1;
    private int piece;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<CreateSudData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CreateSudData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CreateSudData(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CreateSudData[] newArray(int i) {
            return new CreateSudData[i];
        }
    }

    public CreateSudData() {
        this(null, 0, 0, 0, 0, 0, null, null, 255, null);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getGameType() {
        return this.gameType;
    }

    /* renamed from: component2, reason: from getter */
    public final int getMode() {
        return this.mode;
    }

    /* renamed from: component3, reason: from getter */
    public final int getPiece() {
        return this.piece;
    }

    /* renamed from: component4, reason: from getter */
    public final int getOnOff1() {
        return this.onOff1;
    }

    /* renamed from: component5, reason: from getter */
    public final int getDiamond() {
        return this.diamond;
    }

    /* renamed from: component6, reason: from getter */
    public final int getAutoMatch() {
        return this.autoMatch;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final Long getGameId() {
        return this.gameId;
    }

    @NotNull
    public final CreateSudData copy(@Nullable Integer gameType, int mode, int piece, int onOff1, int diamond, int autoMatch, @Nullable String groupId, @Nullable Long gameId) {
        return new CreateSudData(gameType, mode, piece, onOff1, diamond, autoMatch, groupId, gameId);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateSudData)) {
            return false;
        }
        CreateSudData createSudData = (CreateSudData) other;
        return Intrinsics.areEqual(this.gameType, createSudData.gameType) && this.mode == createSudData.mode && this.piece == createSudData.piece && this.onOff1 == createSudData.onOff1 && this.diamond == createSudData.diamond && this.autoMatch == createSudData.autoMatch && Intrinsics.areEqual(this.groupId, createSudData.groupId) && Intrinsics.areEqual(this.gameId, createSudData.gameId);
    }

    public final int getAutoMatch() {
        return this.autoMatch;
    }

    public final int getDiamond() {
        return this.diamond;
    }

    @Nullable
    public final Long getGameId() {
        return this.gameId;
    }

    @Nullable
    public final Integer getGameType() {
        return this.gameType;
    }

    @Nullable
    public final String getGroupId() {
        return this.groupId;
    }

    public final int getMode() {
        return this.mode;
    }

    public final int getOnOff1() {
        return this.onOff1;
    }

    public final int getPiece() {
        return this.piece;
    }

    public int hashCode() {
        Integer num = this.gameType;
        int hashCode = (((((((((((num == null ? 0 : num.hashCode()) * 31) + this.mode) * 31) + this.piece) * 31) + this.onOff1) * 31) + this.diamond) * 31) + this.autoMatch) * 31;
        String str = this.groupId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l = this.gameId;
        return hashCode2 + (l != null ? l.hashCode() : 0);
    }

    public final void setAutoMatch(int i) {
        this.autoMatch = i;
    }

    public final void setDiamond(int i) {
        this.diamond = i;
    }

    public final void setGameId(@Nullable Long l) {
        this.gameId = l;
    }

    public final void setGameType(@Nullable Integer num) {
        this.gameType = num;
    }

    public final void setGroupId(@Nullable String str) {
        this.groupId = str;
    }

    public final void setMode(int i) {
        this.mode = i;
    }

    public final void setOnOff1(int i) {
        this.onOff1 = i;
    }

    public final void setPiece(int i) {
        this.piece = i;
    }

    @NotNull
    public String toString() {
        return "CreateSudData(gameType=" + this.gameType + ", mode=" + this.mode + ", piece=" + this.piece + ", onOff1=" + this.onOff1 + ", diamond=" + this.diamond + ", autoMatch=" + this.autoMatch + ", groupId=" + this.groupId + ", gameId=" + this.gameId + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        Integer num = this.gameType;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        dest.writeInt(this.mode);
        dest.writeInt(this.piece);
        dest.writeInt(this.onOff1);
        dest.writeInt(this.diamond);
        dest.writeInt(this.autoMatch);
        dest.writeString(this.groupId);
        Long l = this.gameId;
        if (l == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l.longValue());
        }
    }

    public CreateSudData(@Nullable Integer num, int i, int i2, int i3, int i4, int i5, @Nullable String str, @Nullable Long l) {
        this.gameType = num;
        this.mode = i;
        this.piece = i2;
        this.onOff1 = i3;
        this.diamond = i4;
        this.autoMatch = i5;
        this.groupId = str;
        this.gameId = l;
    }

    public /* synthetic */ CreateSudData(Integer num, int i, int i2, int i3, int i4, int i5, String str, Long l, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? null : num, (i6 & 2) != 0 ? 0 : i, (i6 & 4) != 0 ? 2 : i2, (i6 & 8) != 0 ? 0 : i3, (i6 & 16) == 0 ? i4 : 0, (i6 & 32) != 0 ? 1 : i5, (i6 & 64) != 0 ? null : str, (i6 & 128) == 0 ? l : null);
    }
}
