package com.qiahao.nextvideo.data.game;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.c;
import com.qiahao.nextvideo.sheep.GameMatchActivity;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.qiahao.nextvideo.ui.wallet.ExchangeDetailActivity;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u001c\b\u0002\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0013\u0010\u0014J\t\u00106\u001a\u00020\u0003HÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001aJ\t\u00108\u001a\u00020\u0005HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\t\u0010:\u001a\u00020\u0005HÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\t\u0010=\u001a\u00020\u0005HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\rHÆ\u0003J\u001d\u0010?\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0011HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0096\u0001\u0010A\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u001c\b\u0002\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010BJ\u0006\u0010C\u001a\u00020\u0005J\u0013\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010GHÖ\u0003J\t\u0010H\u001a\u00020\u0005HÖ\u0001J\t\u0010I\u001a\u00020\rHÖ\u0001J\u0016\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010!R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!R\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001f\"\u0004\b)\u0010!R\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001f\"\u0004\b+\u0010!R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R.\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010-\"\u0004\b5\u0010/¨\u0006O"}, d2 = {"Lcom/qiahao/nextvideo/data/game/SUDGameData;", "Landroid/os/Parcelable;", GameMatchActivity.GAME_ID, "", "gameType", "", Constants.KEY_MODE, "piece", "onOff1", ExchangeDetailActivity.TYPE_DIAMOND, "autoMatch", "status", SupportGiftRankActivity.EXTERNAL_ID, "", "players", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/game/SUDPlayerData;", "Lkotlin/collections/ArrayList;", "skin", "<init>", "(JLjava/lang/Integer;IIIIIILjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)V", "getGameId", "()J", "setGameId", "(J)V", "getGameType", "()Ljava/lang/Integer;", "setGameType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMode", "()I", "setMode", "(I)V", "getPiece", "setPiece", "getOnOff1", "setOnOff1", "getDiamond", "setDiamond", "getAutoMatch", "setAutoMatch", "getStatus", "setStatus", "getExternalId", "()Ljava/lang/String;", "setExternalId", "(Ljava/lang/String;)V", "getPlayers", "()Ljava/util/ArrayList;", "setPlayers", "(Ljava/util/ArrayList;)V", "getSkin", "setSkin", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(JLjava/lang/Integer;IIIIIILjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)Lcom/qiahao/nextvideo/data/game/SUDGameData;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class SUDGameData implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<SUDGameData> CREATOR = new Creator();
    private int autoMatch;
    private int diamond;

    @Nullable
    private String externalId;
    private long gameId;

    @Nullable
    private Integer gameType;
    private int mode;
    private int onOff1;
    private int piece;

    @Nullable
    private ArrayList<SUDPlayerData> players;

    @Nullable
    private String skin;
    private int status;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<SUDGameData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SUDGameData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            long readLong = parcel.readLong();
            ArrayList arrayList = null;
            Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            int readInt4 = parcel.readInt();
            int readInt5 = parcel.readInt();
            int readInt6 = parcel.readInt();
            String readString = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt7 = parcel.readInt();
                arrayList = new ArrayList(readInt7);
                for (int i = 0; i != readInt7; i++) {
                    arrayList.add(SUDPlayerData.CREATOR.createFromParcel(parcel));
                }
            }
            return new SUDGameData(readLong, valueOf, readInt, readInt2, readInt3, readInt4, readInt5, readInt6, readString, arrayList, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SUDGameData[] newArray(int i) {
            return new SUDGameData[i];
        }
    }

    public SUDGameData() {
        this(0L, null, 0, 0, 0, 0, 0, 0, null, null, null, 2047, null);
    }

    /* renamed from: component1, reason: from getter */
    public final long getGameId() {
        return this.gameId;
    }

    @Nullable
    public final ArrayList<SUDPlayerData> component10() {
        return this.players;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final String getSkin() {
        return this.skin;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getGameType() {
        return this.gameType;
    }

    /* renamed from: component3, reason: from getter */
    public final int getMode() {
        return this.mode;
    }

    /* renamed from: component4, reason: from getter */
    public final int getPiece() {
        return this.piece;
    }

    /* renamed from: component5, reason: from getter */
    public final int getOnOff1() {
        return this.onOff1;
    }

    /* renamed from: component6, reason: from getter */
    public final int getDiamond() {
        return this.diamond;
    }

    /* renamed from: component7, reason: from getter */
    public final int getAutoMatch() {
        return this.autoMatch;
    }

    /* renamed from: component8, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final String getExternalId() {
        return this.externalId;
    }

    @NotNull
    public final SUDGameData copy(long gameId, @Nullable Integer gameType, int mode, int piece, int onOff1, int diamond, int autoMatch, int status, @Nullable String externalId, @Nullable ArrayList<SUDPlayerData> players, @Nullable String skin) {
        return new SUDGameData(gameId, gameType, mode, piece, onOff1, diamond, autoMatch, status, externalId, players, skin);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SUDGameData)) {
            return false;
        }
        SUDGameData sUDGameData = (SUDGameData) other;
        return this.gameId == sUDGameData.gameId && Intrinsics.areEqual(this.gameType, sUDGameData.gameType) && this.mode == sUDGameData.mode && this.piece == sUDGameData.piece && this.onOff1 == sUDGameData.onOff1 && this.diamond == sUDGameData.diamond && this.autoMatch == sUDGameData.autoMatch && this.status == sUDGameData.status && Intrinsics.areEqual(this.externalId, sUDGameData.externalId) && Intrinsics.areEqual(this.players, sUDGameData.players) && Intrinsics.areEqual(this.skin, sUDGameData.skin);
    }

    public final int getAutoMatch() {
        return this.autoMatch;
    }

    public final int getDiamond() {
        return this.diamond;
    }

    @Nullable
    public final String getExternalId() {
        return this.externalId;
    }

    public final long getGameId() {
        return this.gameId;
    }

    @Nullable
    public final Integer getGameType() {
        return this.gameType;
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

    @Nullable
    public final ArrayList<SUDPlayerData> getPlayers() {
        return this.players;
    }

    @Nullable
    public final String getSkin() {
        return this.skin;
    }

    public final int getStatus() {
        return this.status;
    }

    public int hashCode() {
        int a = c.a(this.gameId) * 31;
        Integer num = this.gameType;
        int hashCode = (((((((((((((a + (num == null ? 0 : num.hashCode())) * 31) + this.mode) * 31) + this.piece) * 31) + this.onOff1) * 31) + this.diamond) * 31) + this.autoMatch) * 31) + this.status) * 31;
        String str = this.externalId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        ArrayList<SUDPlayerData> arrayList = this.players;
        int hashCode3 = (hashCode2 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        String str2 = this.skin;
        return hashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setAutoMatch(int i) {
        this.autoMatch = i;
    }

    public final void setDiamond(int i) {
        this.diamond = i;
    }

    public final void setExternalId(@Nullable String str) {
        this.externalId = str;
    }

    public final void setGameId(long j) {
        this.gameId = j;
    }

    public final void setGameType(@Nullable Integer num) {
        this.gameType = num;
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

    public final void setPlayers(@Nullable ArrayList<SUDPlayerData> arrayList) {
        this.players = arrayList;
    }

    public final void setSkin(@Nullable String str) {
        this.skin = str;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    @NotNull
    public String toString() {
        return "SUDGameData(gameId=" + this.gameId + ", gameType=" + this.gameType + ", mode=" + this.mode + ", piece=" + this.piece + ", onOff1=" + this.onOff1 + ", diamond=" + this.diamond + ", autoMatch=" + this.autoMatch + ", status=" + this.status + ", externalId=" + this.externalId + ", players=" + this.players + ", skin=" + this.skin + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeLong(this.gameId);
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
        dest.writeInt(this.status);
        dest.writeString(this.externalId);
        ArrayList<SUDPlayerData> arrayList = this.players;
        if (arrayList == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(arrayList.size());
            Iterator<SUDPlayerData> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(dest, flags);
            }
        }
        dest.writeString(this.skin);
    }

    public SUDGameData(long j, @Nullable Integer num, int i, int i2, int i3, int i4, int i5, int i6, @Nullable String str, @Nullable ArrayList<SUDPlayerData> arrayList, @Nullable String str2) {
        this.gameId = j;
        this.gameType = num;
        this.mode = i;
        this.piece = i2;
        this.onOff1 = i3;
        this.diamond = i4;
        this.autoMatch = i5;
        this.status = i6;
        this.externalId = str;
        this.players = arrayList;
        this.skin = str2;
    }

    public /* synthetic */ SUDGameData(long j, Integer num, int i, int i2, int i3, int i4, int i5, int i6, String str, ArrayList arrayList, String str2, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this((i7 & 1) != 0 ? 0L : j, (i7 & 2) != 0 ? null : num, (i7 & 4) != 0 ? 0 : i, (i7 & 8) != 0 ? 2 : i2, (i7 & 16) != 0 ? 0 : i3, (i7 & 32) != 0 ? 0 : i4, (i7 & 64) != 0 ? 1 : i5, (i7 & 128) == 0 ? i6 : 0, (i7 & 256) != 0 ? null : str, (i7 & 512) != 0 ? null : arrayList, (i7 & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) == 0 ? str2 : null);
    }
}
