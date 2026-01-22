package com.qiahao.nextvideo.ui.debug.alertagoraconfigure;

import androidx.annotation.Keep;
import androidx.collection.c;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.DebugAgoraVideoCallConfig;
import com.qiahao.nextvideo.data.UserStore;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0001!B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006\""}, d2 = {"Lcom/qiahao/nextvideo/ui/debug/alertagoraconfigure/AlertAgoraConfigUIModel;", "", "duration", "", "fromUserID", "", "fromAgoraToken", "toUID", "toAgoraToken", "channelName", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDuration", "()J", "getFromUserID", "()Ljava/lang/String;", "getFromAgoraToken", "getToUID", "getToAgoraToken", "getChannelName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class AlertAgoraConfigUIModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final String channelName;
    private final long duration;

    @NotNull
    private final String fromAgoraToken;

    @NotNull
    private final String fromUserID;

    @NotNull
    private final String toAgoraToken;

    @NotNull
    private final String toUID;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/qiahao/nextvideo/ui/debug/alertagoraconfigure/AlertAgoraConfigUIModel$Companion;", "", "<init>", "()V", "fake", "Lcom/qiahao/nextvideo/ui/debug/alertagoraconfigure/AlertAgoraConfigUIModel;", "init", "debugAgoraVideoCallConfig", "Lcom/qiahao/base_common/network/model/DebugAgoraVideoCallConfig;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AlertAgoraConfigUIModel fake() {
            String str;
            User user = UserStore.INSTANCE.getShared().getUser();
            if (user == null || (str = user.getExternalId()) == null) {
                str = "";
            }
            return new AlertAgoraConfigUIModel(60L, str, "006IADFhvd/EJ9VEs9vMNOxdTFENRmAp7qKFMjEGUWntPt16mVkUAJ8YHBUIgDqossEXib7XgQAAQA21/leAgA21/leAwA21/leBAA21/le", String.valueOf(System.currentTimeMillis()), "006IADFhvd/EJ9VEs9vMNOxdTFENRmAp7qKFMjEGUWntPt16mVkUAJ8YHBUIgDqossEXib7XgQAAQA21/leAgA21/leAwA21/leBAA21/le", "test-agora-channel-1000");
        }

        @NotNull
        public final AlertAgoraConfigUIModel init(@NotNull DebugAgoraVideoCallConfig debugAgoraVideoCallConfig) {
            String str;
            Intrinsics.checkNotNullParameter(debugAgoraVideoCallConfig, "debugAgoraVideoCallConfig");
            User user = UserStore.INSTANCE.getShared().getUser();
            if (user == null || (str = user.getExternalId()) == null) {
                str = "";
            }
            return new AlertAgoraConfigUIModel(60L, str, debugAgoraVideoCallConfig.getFromToken(), debugAgoraVideoCallConfig.getToUID(), debugAgoraVideoCallConfig.getToToken(), debugAgoraVideoCallConfig.getAgoraChannelName());
        }

        private Companion() {
        }
    }

    public AlertAgoraConfigUIModel(long j, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "fromUserID");
        Intrinsics.checkNotNullParameter(str2, "fromAgoraToken");
        Intrinsics.checkNotNullParameter(str3, "toUID");
        Intrinsics.checkNotNullParameter(str4, "toAgoraToken");
        Intrinsics.checkNotNullParameter(str5, "channelName");
        this.duration = j;
        this.fromUserID = str;
        this.fromAgoraToken = str2;
        this.toUID = str3;
        this.toAgoraToken = str4;
        this.channelName = str5;
    }

    /* renamed from: component1, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getFromUserID() {
        return this.fromUserID;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getFromAgoraToken() {
        return this.fromAgoraToken;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getToUID() {
        return this.toUID;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getToAgoraToken() {
        return this.toAgoraToken;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getChannelName() {
        return this.channelName;
    }

    @NotNull
    public final AlertAgoraConfigUIModel copy(long duration, @NotNull String fromUserID, @NotNull String fromAgoraToken, @NotNull String toUID, @NotNull String toAgoraToken, @NotNull String channelName) {
        Intrinsics.checkNotNullParameter(fromUserID, "fromUserID");
        Intrinsics.checkNotNullParameter(fromAgoraToken, "fromAgoraToken");
        Intrinsics.checkNotNullParameter(toUID, "toUID");
        Intrinsics.checkNotNullParameter(toAgoraToken, "toAgoraToken");
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        return new AlertAgoraConfigUIModel(duration, fromUserID, fromAgoraToken, toUID, toAgoraToken, channelName);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AlertAgoraConfigUIModel)) {
            return false;
        }
        AlertAgoraConfigUIModel alertAgoraConfigUIModel = (AlertAgoraConfigUIModel) other;
        return this.duration == alertAgoraConfigUIModel.duration && Intrinsics.areEqual(this.fromUserID, alertAgoraConfigUIModel.fromUserID) && Intrinsics.areEqual(this.fromAgoraToken, alertAgoraConfigUIModel.fromAgoraToken) && Intrinsics.areEqual(this.toUID, alertAgoraConfigUIModel.toUID) && Intrinsics.areEqual(this.toAgoraToken, alertAgoraConfigUIModel.toAgoraToken) && Intrinsics.areEqual(this.channelName, alertAgoraConfigUIModel.channelName);
    }

    @NotNull
    public final String getChannelName() {
        return this.channelName;
    }

    public final long getDuration() {
        return this.duration;
    }

    @NotNull
    public final String getFromAgoraToken() {
        return this.fromAgoraToken;
    }

    @NotNull
    public final String getFromUserID() {
        return this.fromUserID;
    }

    @NotNull
    public final String getToAgoraToken() {
        return this.toAgoraToken;
    }

    @NotNull
    public final String getToUID() {
        return this.toUID;
    }

    public int hashCode() {
        return (((((((((c.a(this.duration) * 31) + this.fromUserID.hashCode()) * 31) + this.fromAgoraToken.hashCode()) * 31) + this.toUID.hashCode()) * 31) + this.toAgoraToken.hashCode()) * 31) + this.channelName.hashCode();
    }

    @NotNull
    public String toString() {
        return "AlertAgoraConfigUIModel(duration=" + this.duration + ", fromUserID=" + this.fromUserID + ", fromAgoraToken=" + this.fromAgoraToken + ", toUID=" + this.toUID + ", toAgoraToken=" + this.toAgoraToken + ", channelName=" + this.channelName + ")";
    }
}
