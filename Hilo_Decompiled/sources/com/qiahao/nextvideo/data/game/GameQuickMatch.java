package com.qiahao.nextvideo.data.game;

import android.os.Parcel;
import android.os.Parcelable;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\u0010\u001a\u00020\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0011R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/qiahao/nextvideo/data/game/GameQuickMatch;", "Landroid/os/Parcelable;", "groupId", "", "gameCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getGroupId", "()Ljava/lang/String;", "setGroupId", "(Ljava/lang/String;)V", "getGameCode", "setGameCode", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class GameQuickMatch implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<GameQuickMatch> CREATOR = new Creator();

    @Nullable
    private String gameCode;

    @Nullable
    private String groupId;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<GameQuickMatch> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GameQuickMatch createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GameQuickMatch(parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GameQuickMatch[] newArray(int i) {
            return new GameQuickMatch[i];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GameQuickMatch() {
        this(r0, r0, 3, r0);
        String str = null;
    }

    public static /* synthetic */ GameQuickMatch copy$default(GameQuickMatch gameQuickMatch, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gameQuickMatch.groupId;
        }
        if ((i & 2) != 0) {
            str2 = gameQuickMatch.gameCode;
        }
        return gameQuickMatch.copy(str, str2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getGameCode() {
        return this.gameCode;
    }

    @NotNull
    public final GameQuickMatch copy(@Nullable String groupId, @Nullable String gameCode) {
        return new GameQuickMatch(groupId, gameCode);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GameQuickMatch)) {
            return false;
        }
        GameQuickMatch gameQuickMatch = (GameQuickMatch) other;
        return Intrinsics.areEqual(this.groupId, gameQuickMatch.groupId) && Intrinsics.areEqual(this.gameCode, gameQuickMatch.gameCode);
    }

    @Nullable
    public final String getGameCode() {
        return this.gameCode;
    }

    @Nullable
    public final String getGroupId() {
        return this.groupId;
    }

    public int hashCode() {
        String str = this.groupId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.gameCode;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setGameCode(@Nullable String str) {
        this.gameCode = str;
    }

    public final void setGroupId(@Nullable String str) {
        this.groupId = str;
    }

    @NotNull
    public String toString() {
        return "GameQuickMatch(groupId=" + this.groupId + ", gameCode=" + this.gameCode + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.groupId);
        dest.writeString(this.gameCode);
    }

    public GameQuickMatch(@Nullable String str, @Nullable String str2) {
        this.groupId = str;
        this.gameCode = str2;
    }

    public /* synthetic */ GameQuickMatch(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }
}
