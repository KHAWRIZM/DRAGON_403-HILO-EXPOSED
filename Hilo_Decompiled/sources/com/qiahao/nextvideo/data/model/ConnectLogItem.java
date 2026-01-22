package com.qiahao.nextvideo.data.model;

import com.qiahao.base_common.utils.DateTimeUtilityKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0001'B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003JE\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\tHÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0010\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018¨\u0006("}, d2 = {"Lcom/qiahao/nextvideo/data/model/ConnectLogItem;", "", "dateString", "", AgooConstants.MESSAGE_TIME, "", "connectCount", "connectTimeSum", "diamondIncome", "", "likeMeCount", "<init>", "(Ljava/lang/String;JJJII)V", "getDateString", "()Ljava/lang/String;", "getTime", "()J", "getConnectCount", "getConnectTimeSum", "setConnectTimeSum", "(J)V", "getDiamondIncome", "()I", "setDiamondIncome", "(I)V", "getLikeMeCount", "setLikeMeCount", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class ConnectLogItem {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @c("frequency")
    private final long connectCount;

    @c("duration")
    private long connectTimeSum;

    @NotNull
    @c("date")
    private final String dateString;

    @c("diamond_income")
    private int diamondIncome;

    @c("likeMeCount")
    private int likeMeCount;

    @c(AgooConstants.MESSAGE_TIME)
    private final long time;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/qiahao/nextvideo/data/model/ConnectLogItem$Companion;", "", "<init>", "()V", "fake", "Lcom/qiahao/nextvideo/data/model/ConnectLogItem;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ConnectLogItem fake() {
            long j = 1000;
            return new ConnectLogItem(DateTimeUtilityKt.getDateInSecs$default(System.currentTimeMillis() / j, (Locale) null, (String) null, 6, (Object) null), System.currentTimeMillis() / j, System.currentTimeMillis(), System.currentTimeMillis(), 0, 0, 48, null);
        }

        private Companion() {
        }
    }

    public ConnectLogItem(@NotNull String str, long j, long j2, long j3, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "dateString");
        this.dateString = str;
        this.time = j;
        this.connectCount = j2;
        this.connectTimeSum = j3;
        this.diamondIncome = i;
        this.likeMeCount = i2;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getDateString() {
        return this.dateString;
    }

    /* renamed from: component2, reason: from getter */
    public final long getTime() {
        return this.time;
    }

    /* renamed from: component3, reason: from getter */
    public final long getConnectCount() {
        return this.connectCount;
    }

    /* renamed from: component4, reason: from getter */
    public final long getConnectTimeSum() {
        return this.connectTimeSum;
    }

    /* renamed from: component5, reason: from getter */
    public final int getDiamondIncome() {
        return this.diamondIncome;
    }

    /* renamed from: component6, reason: from getter */
    public final int getLikeMeCount() {
        return this.likeMeCount;
    }

    @NotNull
    public final ConnectLogItem copy(@NotNull String dateString, long time, long connectCount, long connectTimeSum, int diamondIncome, int likeMeCount) {
        Intrinsics.checkNotNullParameter(dateString, "dateString");
        return new ConnectLogItem(dateString, time, connectCount, connectTimeSum, diamondIncome, likeMeCount);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConnectLogItem)) {
            return false;
        }
        ConnectLogItem connectLogItem = (ConnectLogItem) other;
        return Intrinsics.areEqual(this.dateString, connectLogItem.dateString) && this.time == connectLogItem.time && this.connectCount == connectLogItem.connectCount && this.connectTimeSum == connectLogItem.connectTimeSum && this.diamondIncome == connectLogItem.diamondIncome && this.likeMeCount == connectLogItem.likeMeCount;
    }

    public final long getConnectCount() {
        return this.connectCount;
    }

    public final long getConnectTimeSum() {
        return this.connectTimeSum;
    }

    @NotNull
    public final String getDateString() {
        return this.dateString;
    }

    public final int getDiamondIncome() {
        return this.diamondIncome;
    }

    public final int getLikeMeCount() {
        return this.likeMeCount;
    }

    public final long getTime() {
        return this.time;
    }

    public int hashCode() {
        return (((((((((this.dateString.hashCode() * 31) + androidx.collection.c.a(this.time)) * 31) + androidx.collection.c.a(this.connectCount)) * 31) + androidx.collection.c.a(this.connectTimeSum)) * 31) + this.diamondIncome) * 31) + this.likeMeCount;
    }

    public final void setConnectTimeSum(long j) {
        this.connectTimeSum = j;
    }

    public final void setDiamondIncome(int i) {
        this.diamondIncome = i;
    }

    public final void setLikeMeCount(int i) {
        this.likeMeCount = i;
    }

    @NotNull
    public String toString() {
        return "ConnectLogItem(dateString=" + this.dateString + ", time=" + this.time + ", connectCount=" + this.connectCount + ", connectTimeSum=" + this.connectTimeSum + ", diamondIncome=" + this.diamondIncome + ", likeMeCount=" + this.likeMeCount + ")";
    }

    public /* synthetic */ ConnectLogItem(String str, long j, long j2, long j3, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, j2, (i3 & 8) != 0 ? 0L : j3, (i3 & 16) != 0 ? 0 : i, (i3 & 32) != 0 ? 0 : i2);
    }
}
