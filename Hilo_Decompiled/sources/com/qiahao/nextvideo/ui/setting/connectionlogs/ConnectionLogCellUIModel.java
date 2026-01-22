package com.qiahao.nextvideo.ui.setting.connectionlogs;

import androidx.annotation.Keep;
import com.qiahao.nextvideo.data.model.ConnectLogItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/qiahao/nextvideo/ui/setting/connectionlogs/ConnectionLogCellUIModel;", "", "date", "", "frequency", "duration", "diamondIncome", "likeMeCount", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDate", "()Ljava/lang/String;", "getFrequency", "getDuration", "getDiamondIncome", "getLikeMeCount", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class ConnectionLogCellUIModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final String date;

    @NotNull
    private final String diamondIncome;

    @NotNull
    private final String duration;

    @NotNull
    private final String frequency;

    @NotNull
    private final String likeMeCount;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/qiahao/nextvideo/ui/setting/connectionlogs/ConnectionLogCellUIModel$Companion;", "", "<init>", "()V", "init", "Lcom/qiahao/nextvideo/ui/setting/connectionlogs/ConnectionLogCellUIModel;", "connectLogItem", "Lcom/qiahao/nextvideo/data/model/ConnectLogItem;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ConnectionLogCellUIModel init(@NotNull ConnectLogItem connectLogItem) {
            Intrinsics.checkNotNullParameter(connectLogItem, "connectLogItem");
            return new ConnectionLogCellUIModel(connectLogItem.getDateString(), String.valueOf(connectLogItem.getConnectCount()), String.valueOf(connectLogItem.getConnectTimeSum()), String.valueOf(connectLogItem.getDiamondIncome()), String.valueOf(connectLogItem.getLikeMeCount()));
        }

        private Companion() {
        }
    }

    public ConnectionLogCellUIModel(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "date");
        Intrinsics.checkNotNullParameter(str2, "frequency");
        Intrinsics.checkNotNullParameter(str3, "duration");
        Intrinsics.checkNotNullParameter(str4, "diamondIncome");
        Intrinsics.checkNotNullParameter(str5, "likeMeCount");
        this.date = str;
        this.frequency = str2;
        this.duration = str3;
        this.diamondIncome = str4;
        this.likeMeCount = str5;
    }

    public static /* synthetic */ ConnectionLogCellUIModel copy$default(ConnectionLogCellUIModel connectionLogCellUIModel, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = connectionLogCellUIModel.date;
        }
        if ((i & 2) != 0) {
            str2 = connectionLogCellUIModel.frequency;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = connectionLogCellUIModel.duration;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = connectionLogCellUIModel.diamondIncome;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = connectionLogCellUIModel.likeMeCount;
        }
        return connectionLogCellUIModel.copy(str, str6, str7, str8, str5);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getFrequency() {
        return this.frequency;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getDuration() {
        return this.duration;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getDiamondIncome() {
        return this.diamondIncome;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getLikeMeCount() {
        return this.likeMeCount;
    }

    @NotNull
    public final ConnectionLogCellUIModel copy(@NotNull String date, @NotNull String frequency, @NotNull String duration, @NotNull String diamondIncome, @NotNull String likeMeCount) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(frequency, "frequency");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(diamondIncome, "diamondIncome");
        Intrinsics.checkNotNullParameter(likeMeCount, "likeMeCount");
        return new ConnectionLogCellUIModel(date, frequency, duration, diamondIncome, likeMeCount);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConnectionLogCellUIModel)) {
            return false;
        }
        ConnectionLogCellUIModel connectionLogCellUIModel = (ConnectionLogCellUIModel) other;
        return Intrinsics.areEqual(this.date, connectionLogCellUIModel.date) && Intrinsics.areEqual(this.frequency, connectionLogCellUIModel.frequency) && Intrinsics.areEqual(this.duration, connectionLogCellUIModel.duration) && Intrinsics.areEqual(this.diamondIncome, connectionLogCellUIModel.diamondIncome) && Intrinsics.areEqual(this.likeMeCount, connectionLogCellUIModel.likeMeCount);
    }

    @NotNull
    public final String getDate() {
        return this.date;
    }

    @NotNull
    public final String getDiamondIncome() {
        return this.diamondIncome;
    }

    @NotNull
    public final String getDuration() {
        return this.duration;
    }

    @NotNull
    public final String getFrequency() {
        return this.frequency;
    }

    @NotNull
    public final String getLikeMeCount() {
        return this.likeMeCount;
    }

    public int hashCode() {
        return (((((((this.date.hashCode() * 31) + this.frequency.hashCode()) * 31) + this.duration.hashCode()) * 31) + this.diamondIncome.hashCode()) * 31) + this.likeMeCount.hashCode();
    }

    @NotNull
    public String toString() {
        return "ConnectionLogCellUIModel(date=" + this.date + ", frequency=" + this.frequency + ", duration=" + this.duration + ", diamondIncome=" + this.diamondIncome + ", likeMeCount=" + this.likeMeCount + ")";
    }
}
