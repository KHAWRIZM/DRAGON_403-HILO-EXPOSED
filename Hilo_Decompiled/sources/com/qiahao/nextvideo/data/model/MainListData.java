package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/qiahao/nextvideo/data/model/MainListData;", "", "moduleData", "", "moduleType", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getModuleData", "()Ljava/lang/String;", "setModuleData", "(Ljava/lang/String;)V", "getModuleType", "setModuleType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class MainListData {

    @NotNull
    public static final String ACT_CHARGE_FIRST = "act_charge_first";

    @NotNull
    public static final String DAILY_DIAMOND = "daily_diamond";

    @NotNull
    public static final String OPERATION_WINDOW = "operation_window";

    @NotNull
    public static final String POPUP_CHARGE_ACT = "popup_charge_act";

    @Nullable
    private String moduleData;

    @Nullable
    private String moduleType;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MainListData() {
        this(r0, r0, 3, r0);
        String str = null;
    }

    public static /* synthetic */ MainListData copy$default(MainListData mainListData, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mainListData.moduleData;
        }
        if ((i & 2) != 0) {
            str2 = mainListData.moduleType;
        }
        return mainListData.copy(str, str2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getModuleData() {
        return this.moduleData;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getModuleType() {
        return this.moduleType;
    }

    @NotNull
    public final MainListData copy(@Nullable String moduleData, @Nullable String moduleType) {
        return new MainListData(moduleData, moduleType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MainListData)) {
            return false;
        }
        MainListData mainListData = (MainListData) other;
        return Intrinsics.areEqual(this.moduleData, mainListData.moduleData) && Intrinsics.areEqual(this.moduleType, mainListData.moduleType);
    }

    @Nullable
    public final String getModuleData() {
        return this.moduleData;
    }

    @Nullable
    public final String getModuleType() {
        return this.moduleType;
    }

    public int hashCode() {
        String str = this.moduleData;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.moduleType;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setModuleData(@Nullable String str) {
        this.moduleData = str;
    }

    public final void setModuleType(@Nullable String str) {
        this.moduleType = str;
    }

    @NotNull
    public String toString() {
        return "MainListData(moduleData=" + this.moduleData + ", moduleType=" + this.moduleType + ")";
    }

    public MainListData(@Nullable String str, @Nullable String str2) {
        this.moduleData = str;
        this.moduleType = str2;
    }

    public /* synthetic */ MainListData(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }
}
