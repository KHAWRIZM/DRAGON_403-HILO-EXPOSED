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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003Ji\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010(\u001a\u00020)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020)HÖ\u0001J\t\u0010/\u001a\u000200HÖ\u0001J\u0016\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020)R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u0010¨\u00066"}, d2 = {"Lcom/qiahao/nextvideo/data/game/GameConfig;", "Landroid/os/Parcelable;", GameLobby.TAB_LUDO, "Lcom/qiahao/nextvideo/data/game/GameConfigLudo;", GameLobby.TAB_UNO, GameLobby.TAB_DOMINO, "crush", "baloot", "carrom", "jackaroo", "backgammon", "<init>", "(Lcom/qiahao/nextvideo/data/game/GameConfigLudo;Lcom/qiahao/nextvideo/data/game/GameConfigLudo;Lcom/qiahao/nextvideo/data/game/GameConfigLudo;Lcom/qiahao/nextvideo/data/game/GameConfigLudo;Lcom/qiahao/nextvideo/data/game/GameConfigLudo;Lcom/qiahao/nextvideo/data/game/GameConfigLudo;Lcom/qiahao/nextvideo/data/game/GameConfigLudo;Lcom/qiahao/nextvideo/data/game/GameConfigLudo;)V", "getLudo", "()Lcom/qiahao/nextvideo/data/game/GameConfigLudo;", "setLudo", "(Lcom/qiahao/nextvideo/data/game/GameConfigLudo;)V", "getUno", "setUno", "getDomino", "setDomino", "getCrush", "setCrush", "getBaloot", "setBaloot", "getCarrom", "setCarrom", "getJackaroo", "setJackaroo", "getBackgammon", "setBackgammon", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class GameConfig implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<GameConfig> CREATOR = new Creator();

    @Nullable
    private GameConfigLudo backgammon;

    @Nullable
    private GameConfigLudo baloot;

    @Nullable
    private GameConfigLudo carrom;

    @Nullable
    private GameConfigLudo crush;

    @Nullable
    private GameConfigLudo domino;

    @Nullable
    private GameConfigLudo jackaroo;

    @Nullable
    private GameConfigLudo ludo;

    @Nullable
    private GameConfigLudo uno;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<GameConfig> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GameConfig createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GameConfig((GameConfigLudo) parcel.readParcelable(GameConfig.class.getClassLoader()), (GameConfigLudo) parcel.readParcelable(GameConfig.class.getClassLoader()), (GameConfigLudo) parcel.readParcelable(GameConfig.class.getClassLoader()), (GameConfigLudo) parcel.readParcelable(GameConfig.class.getClassLoader()), (GameConfigLudo) parcel.readParcelable(GameConfig.class.getClassLoader()), (GameConfigLudo) parcel.readParcelable(GameConfig.class.getClassLoader()), (GameConfigLudo) parcel.readParcelable(GameConfig.class.getClassLoader()), (GameConfigLudo) parcel.readParcelable(GameConfig.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GameConfig[] newArray(int i) {
            return new GameConfig[i];
        }
    }

    public GameConfig() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final GameConfigLudo getLudo() {
        return this.ludo;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final GameConfigLudo getUno() {
        return this.uno;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final GameConfigLudo getDomino() {
        return this.domino;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final GameConfigLudo getCrush() {
        return this.crush;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final GameConfigLudo getBaloot() {
        return this.baloot;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final GameConfigLudo getCarrom() {
        return this.carrom;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final GameConfigLudo getJackaroo() {
        return this.jackaroo;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final GameConfigLudo getBackgammon() {
        return this.backgammon;
    }

    @NotNull
    public final GameConfig copy(@Nullable GameConfigLudo ludo, @Nullable GameConfigLudo uno, @Nullable GameConfigLudo domino, @Nullable GameConfigLudo crush, @Nullable GameConfigLudo baloot, @Nullable GameConfigLudo carrom, @Nullable GameConfigLudo jackaroo, @Nullable GameConfigLudo backgammon) {
        return new GameConfig(ludo, uno, domino, crush, baloot, carrom, jackaroo, backgammon);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GameConfig)) {
            return false;
        }
        GameConfig gameConfig = (GameConfig) other;
        return Intrinsics.areEqual(this.ludo, gameConfig.ludo) && Intrinsics.areEqual(this.uno, gameConfig.uno) && Intrinsics.areEqual(this.domino, gameConfig.domino) && Intrinsics.areEqual(this.crush, gameConfig.crush) && Intrinsics.areEqual(this.baloot, gameConfig.baloot) && Intrinsics.areEqual(this.carrom, gameConfig.carrom) && Intrinsics.areEqual(this.jackaroo, gameConfig.jackaroo) && Intrinsics.areEqual(this.backgammon, gameConfig.backgammon);
    }

    @Nullable
    public final GameConfigLudo getBackgammon() {
        return this.backgammon;
    }

    @Nullable
    public final GameConfigLudo getBaloot() {
        return this.baloot;
    }

    @Nullable
    public final GameConfigLudo getCarrom() {
        return this.carrom;
    }

    @Nullable
    public final GameConfigLudo getCrush() {
        return this.crush;
    }

    @Nullable
    public final GameConfigLudo getDomino() {
        return this.domino;
    }

    @Nullable
    public final GameConfigLudo getJackaroo() {
        return this.jackaroo;
    }

    @Nullable
    public final GameConfigLudo getLudo() {
        return this.ludo;
    }

    @Nullable
    public final GameConfigLudo getUno() {
        return this.uno;
    }

    public int hashCode() {
        GameConfigLudo gameConfigLudo = this.ludo;
        int hashCode = (gameConfigLudo == null ? 0 : gameConfigLudo.hashCode()) * 31;
        GameConfigLudo gameConfigLudo2 = this.uno;
        int hashCode2 = (hashCode + (gameConfigLudo2 == null ? 0 : gameConfigLudo2.hashCode())) * 31;
        GameConfigLudo gameConfigLudo3 = this.domino;
        int hashCode3 = (hashCode2 + (gameConfigLudo3 == null ? 0 : gameConfigLudo3.hashCode())) * 31;
        GameConfigLudo gameConfigLudo4 = this.crush;
        int hashCode4 = (hashCode3 + (gameConfigLudo4 == null ? 0 : gameConfigLudo4.hashCode())) * 31;
        GameConfigLudo gameConfigLudo5 = this.baloot;
        int hashCode5 = (hashCode4 + (gameConfigLudo5 == null ? 0 : gameConfigLudo5.hashCode())) * 31;
        GameConfigLudo gameConfigLudo6 = this.carrom;
        int hashCode6 = (hashCode5 + (gameConfigLudo6 == null ? 0 : gameConfigLudo6.hashCode())) * 31;
        GameConfigLudo gameConfigLudo7 = this.jackaroo;
        int hashCode7 = (hashCode6 + (gameConfigLudo7 == null ? 0 : gameConfigLudo7.hashCode())) * 31;
        GameConfigLudo gameConfigLudo8 = this.backgammon;
        return hashCode7 + (gameConfigLudo8 != null ? gameConfigLudo8.hashCode() : 0);
    }

    public final void setBackgammon(@Nullable GameConfigLudo gameConfigLudo) {
        this.backgammon = gameConfigLudo;
    }

    public final void setBaloot(@Nullable GameConfigLudo gameConfigLudo) {
        this.baloot = gameConfigLudo;
    }

    public final void setCarrom(@Nullable GameConfigLudo gameConfigLudo) {
        this.carrom = gameConfigLudo;
    }

    public final void setCrush(@Nullable GameConfigLudo gameConfigLudo) {
        this.crush = gameConfigLudo;
    }

    public final void setDomino(@Nullable GameConfigLudo gameConfigLudo) {
        this.domino = gameConfigLudo;
    }

    public final void setJackaroo(@Nullable GameConfigLudo gameConfigLudo) {
        this.jackaroo = gameConfigLudo;
    }

    public final void setLudo(@Nullable GameConfigLudo gameConfigLudo) {
        this.ludo = gameConfigLudo;
    }

    public final void setUno(@Nullable GameConfigLudo gameConfigLudo) {
        this.uno = gameConfigLudo;
    }

    @NotNull
    public String toString() {
        return "GameConfig(ludo=" + this.ludo + ", uno=" + this.uno + ", domino=" + this.domino + ", crush=" + this.crush + ", baloot=" + this.baloot + ", carrom=" + this.carrom + ", jackaroo=" + this.jackaroo + ", backgammon=" + this.backgammon + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeParcelable(this.ludo, flags);
        dest.writeParcelable(this.uno, flags);
        dest.writeParcelable(this.domino, flags);
        dest.writeParcelable(this.crush, flags);
        dest.writeParcelable(this.baloot, flags);
        dest.writeParcelable(this.carrom, flags);
        dest.writeParcelable(this.jackaroo, flags);
        dest.writeParcelable(this.backgammon, flags);
    }

    public GameConfig(@Nullable GameConfigLudo gameConfigLudo, @Nullable GameConfigLudo gameConfigLudo2, @Nullable GameConfigLudo gameConfigLudo3, @Nullable GameConfigLudo gameConfigLudo4, @Nullable GameConfigLudo gameConfigLudo5, @Nullable GameConfigLudo gameConfigLudo6, @Nullable GameConfigLudo gameConfigLudo7, @Nullable GameConfigLudo gameConfigLudo8) {
        this.ludo = gameConfigLudo;
        this.uno = gameConfigLudo2;
        this.domino = gameConfigLudo3;
        this.crush = gameConfigLudo4;
        this.baloot = gameConfigLudo5;
        this.carrom = gameConfigLudo6;
        this.jackaroo = gameConfigLudo7;
        this.backgammon = gameConfigLudo8;
    }

    public /* synthetic */ GameConfig(GameConfigLudo gameConfigLudo, GameConfigLudo gameConfigLudo2, GameConfigLudo gameConfigLudo3, GameConfigLudo gameConfigLudo4, GameConfigLudo gameConfigLudo5, GameConfigLudo gameConfigLudo6, GameConfigLudo gameConfigLudo7, GameConfigLudo gameConfigLudo8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : gameConfigLudo, (i & 2) != 0 ? null : gameConfigLudo2, (i & 4) != 0 ? null : gameConfigLudo3, (i & 8) != 0 ? null : gameConfigLudo4, (i & 16) != 0 ? null : gameConfigLudo5, (i & 32) != 0 ? null : gameConfigLudo6, (i & 64) != 0 ? null : gameConfigLudo7, (i & 128) == 0 ? gameConfigLudo8 : null);
    }
}
