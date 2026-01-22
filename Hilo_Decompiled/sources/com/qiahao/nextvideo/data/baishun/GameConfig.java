package com.qiahao.nextvideo.data.baishun;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/qiahao/nextvideo/data/baishun/GameConfig;", "", "sceneMode", "", "currencyIcon", "", "<init>", "(ILjava/lang/String;)V", "getSceneMode", "()I", "setSceneMode", "(I)V", "getCurrencyIcon", "()Ljava/lang/String;", "setCurrencyIcon", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class GameConfig {

    @NotNull
    private String currencyIcon;
    private int sceneMode;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GameConfig() {
        this(0, r0, 3, r0);
        String str = null;
    }

    public static /* synthetic */ GameConfig copy$default(GameConfig gameConfig, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = gameConfig.sceneMode;
        }
        if ((i2 & 2) != 0) {
            str = gameConfig.currencyIcon;
        }
        return gameConfig.copy(i, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getSceneMode() {
        return this.sceneMode;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getCurrencyIcon() {
        return this.currencyIcon;
    }

    @NotNull
    public final GameConfig copy(int sceneMode, @NotNull String currencyIcon) {
        Intrinsics.checkNotNullParameter(currencyIcon, "currencyIcon");
        return new GameConfig(sceneMode, currencyIcon);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GameConfig)) {
            return false;
        }
        GameConfig gameConfig = (GameConfig) other;
        return this.sceneMode == gameConfig.sceneMode && Intrinsics.areEqual(this.currencyIcon, gameConfig.currencyIcon);
    }

    @NotNull
    public final String getCurrencyIcon() {
        return this.currencyIcon;
    }

    public final int getSceneMode() {
        return this.sceneMode;
    }

    public int hashCode() {
        return (this.sceneMode * 31) + this.currencyIcon.hashCode();
    }

    public final void setCurrencyIcon(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.currencyIcon = str;
    }

    public final void setSceneMode(int i) {
        this.sceneMode = i;
    }

    @NotNull
    public String toString() {
        return "GameConfig(sceneMode=" + this.sceneMode + ", currencyIcon=" + this.currencyIcon + ")";
    }

    public GameConfig(int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "currencyIcon");
        this.sceneMode = i;
        this.currencyIcon = str;
    }

    public /* synthetic */ GameConfig(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str);
    }
}
