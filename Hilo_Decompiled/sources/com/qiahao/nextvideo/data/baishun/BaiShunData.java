package com.qiahao.nextvideo.data.baishun;

import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003JJ\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0006HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000e¨\u0006&"}, d2 = {"Lcom/qiahao/nextvideo/data/baishun/BaiShunData;", "", Constants.KEY_HTTP_CODE, "", "gameMode", "gsp", "", "sceneMode", "currencyIcon", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "setCode", "(Ljava/lang/String;)V", "getGameMode", "setGameMode", "getGsp", "()Ljava/lang/Integer;", "setGsp", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSceneMode", "setSceneMode", "getCurrencyIcon", "setCurrencyIcon", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/qiahao/nextvideo/data/baishun/BaiShunData;", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class BaiShunData {

    @Nullable
    private String code;

    @Nullable
    private String currencyIcon;

    @Nullable
    private String gameMode;

    @Nullable
    private Integer gsp;

    @Nullable
    private Integer sceneMode;

    public BaiShunData() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ BaiShunData copy$default(BaiShunData baiShunData, String str, String str2, Integer num, Integer num2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = baiShunData.code;
        }
        if ((i & 2) != 0) {
            str2 = baiShunData.gameMode;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            num = baiShunData.gsp;
        }
        Integer num3 = num;
        if ((i & 8) != 0) {
            num2 = baiShunData.sceneMode;
        }
        Integer num4 = num2;
        if ((i & 16) != 0) {
            str3 = baiShunData.currencyIcon;
        }
        return baiShunData.copy(str, str4, num3, num4, str3);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getGameMode() {
        return this.gameMode;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Integer getGsp() {
        return this.gsp;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Integer getSceneMode() {
        return this.sceneMode;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getCurrencyIcon() {
        return this.currencyIcon;
    }

    @NotNull
    public final BaiShunData copy(@Nullable String code, @Nullable String gameMode, @Nullable Integer gsp, @Nullable Integer sceneMode, @Nullable String currencyIcon) {
        return new BaiShunData(code, gameMode, gsp, sceneMode, currencyIcon);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BaiShunData)) {
            return false;
        }
        BaiShunData baiShunData = (BaiShunData) other;
        return Intrinsics.areEqual(this.code, baiShunData.code) && Intrinsics.areEqual(this.gameMode, baiShunData.gameMode) && Intrinsics.areEqual(this.gsp, baiShunData.gsp) && Intrinsics.areEqual(this.sceneMode, baiShunData.sceneMode) && Intrinsics.areEqual(this.currencyIcon, baiShunData.currencyIcon);
    }

    @Nullable
    public final String getCode() {
        return this.code;
    }

    @Nullable
    public final String getCurrencyIcon() {
        return this.currencyIcon;
    }

    @Nullable
    public final String getGameMode() {
        return this.gameMode;
    }

    @Nullable
    public final Integer getGsp() {
        return this.gsp;
    }

    @Nullable
    public final Integer getSceneMode() {
        return this.sceneMode;
    }

    public int hashCode() {
        String str = this.code;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.gameMode;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.gsp;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.sceneMode;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str3 = this.currencyIcon;
        return hashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setCode(@Nullable String str) {
        this.code = str;
    }

    public final void setCurrencyIcon(@Nullable String str) {
        this.currencyIcon = str;
    }

    public final void setGameMode(@Nullable String str) {
        this.gameMode = str;
    }

    public final void setGsp(@Nullable Integer num) {
        this.gsp = num;
    }

    public final void setSceneMode(@Nullable Integer num) {
        this.sceneMode = num;
    }

    @NotNull
    public String toString() {
        return "BaiShunData(code=" + this.code + ", gameMode=" + this.gameMode + ", gsp=" + this.gsp + ", sceneMode=" + this.sceneMode + ", currencyIcon=" + this.currencyIcon + ")";
    }

    public BaiShunData(@Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable Integer num2, @Nullable String str3) {
        this.code = str;
        this.gameMode = str2;
        this.gsp = num;
        this.sceneMode = num2;
        this.currencyIcon = str3;
    }

    public /* synthetic */ BaiShunData(String str, String str2, Integer num, Integer num2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : str3);
    }
}
