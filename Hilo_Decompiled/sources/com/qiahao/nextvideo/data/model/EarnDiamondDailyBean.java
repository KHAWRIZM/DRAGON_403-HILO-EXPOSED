package com.qiahao.nextvideo.data.model;

import com.qiahao.nextvideo.ui.wallet.ExchangeDetailActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\nHÆ\u0003JQ\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006'"}, d2 = {"Lcom/qiahao/nextvideo/data/model/EarnDiamondDailyBean;", "", ExchangeDetailActivity.TYPE_DIAMOND, "", "hasAward", "hasFinish", "taskConfigId", "type", "finishN", "taskText", "", "<init>", "(IIIIIILjava/lang/String;)V", "getDiamond", "()I", "getHasAward", "getHasFinish", "getTaskConfigId", "getType", "getFinishN", "setFinishN", "(I)V", "getTaskText", "()Ljava/lang/String;", "setTaskText", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class EarnDiamondDailyBean {
    private final int diamond;
    private int finishN;
    private final int hasAward;
    private final int hasFinish;
    private final int taskConfigId;

    @Nullable
    private String taskText;
    private final int type;

    public EarnDiamondDailyBean(int i, int i2, int i3, int i4, int i5, int i6, @Nullable String str) {
        this.diamond = i;
        this.hasAward = i2;
        this.hasFinish = i3;
        this.taskConfigId = i4;
        this.type = i5;
        this.finishN = i6;
        this.taskText = str;
    }

    public static /* synthetic */ EarnDiamondDailyBean copy$default(EarnDiamondDailyBean earnDiamondDailyBean, int i, int i2, int i3, int i4, int i5, int i6, String str, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i = earnDiamondDailyBean.diamond;
        }
        if ((i7 & 2) != 0) {
            i2 = earnDiamondDailyBean.hasAward;
        }
        int i8 = i2;
        if ((i7 & 4) != 0) {
            i3 = earnDiamondDailyBean.hasFinish;
        }
        int i9 = i3;
        if ((i7 & 8) != 0) {
            i4 = earnDiamondDailyBean.taskConfigId;
        }
        int i10 = i4;
        if ((i7 & 16) != 0) {
            i5 = earnDiamondDailyBean.type;
        }
        int i11 = i5;
        if ((i7 & 32) != 0) {
            i6 = earnDiamondDailyBean.finishN;
        }
        int i12 = i6;
        if ((i7 & 64) != 0) {
            str = earnDiamondDailyBean.taskText;
        }
        return earnDiamondDailyBean.copy(i, i8, i9, i10, i11, i12, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getDiamond() {
        return this.diamond;
    }

    /* renamed from: component2, reason: from getter */
    public final int getHasAward() {
        return this.hasAward;
    }

    /* renamed from: component3, reason: from getter */
    public final int getHasFinish() {
        return this.hasFinish;
    }

    /* renamed from: component4, reason: from getter */
    public final int getTaskConfigId() {
        return this.taskConfigId;
    }

    /* renamed from: component5, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: component6, reason: from getter */
    public final int getFinishN() {
        return this.finishN;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getTaskText() {
        return this.taskText;
    }

    @NotNull
    public final EarnDiamondDailyBean copy(int diamond, int hasAward, int hasFinish, int taskConfigId, int type, int finishN, @Nullable String taskText) {
        return new EarnDiamondDailyBean(diamond, hasAward, hasFinish, taskConfigId, type, finishN, taskText);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EarnDiamondDailyBean)) {
            return false;
        }
        EarnDiamondDailyBean earnDiamondDailyBean = (EarnDiamondDailyBean) other;
        return this.diamond == earnDiamondDailyBean.diamond && this.hasAward == earnDiamondDailyBean.hasAward && this.hasFinish == earnDiamondDailyBean.hasFinish && this.taskConfigId == earnDiamondDailyBean.taskConfigId && this.type == earnDiamondDailyBean.type && this.finishN == earnDiamondDailyBean.finishN && Intrinsics.areEqual(this.taskText, earnDiamondDailyBean.taskText);
    }

    public final int getDiamond() {
        return this.diamond;
    }

    public final int getFinishN() {
        return this.finishN;
    }

    public final int getHasAward() {
        return this.hasAward;
    }

    public final int getHasFinish() {
        return this.hasFinish;
    }

    public final int getTaskConfigId() {
        return this.taskConfigId;
    }

    @Nullable
    public final String getTaskText() {
        return this.taskText;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int i = ((((((((((this.diamond * 31) + this.hasAward) * 31) + this.hasFinish) * 31) + this.taskConfigId) * 31) + this.type) * 31) + this.finishN) * 31;
        String str = this.taskText;
        return i + (str == null ? 0 : str.hashCode());
    }

    public final void setFinishN(int i) {
        this.finishN = i;
    }

    public final void setTaskText(@Nullable String str) {
        this.taskText = str;
    }

    @NotNull
    public String toString() {
        return "EarnDiamondDailyBean(diamond=" + this.diamond + ", hasAward=" + this.hasAward + ", hasFinish=" + this.hasFinish + ", taskConfigId=" + this.taskConfigId + ", type=" + this.type + ", finishN=" + this.finishN + ", taskText=" + this.taskText + ")";
    }

    public /* synthetic */ EarnDiamondDailyBean(int i, int i2, int i3, int i4, int i5, int i6, String str, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, i4, i5, i6, (i7 & 64) != 0 ? null : str);
    }
}
