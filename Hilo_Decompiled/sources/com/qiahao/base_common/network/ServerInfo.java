package com.qiahao.base_common.network;

import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u000bHÆ\u0003J\t\u0010*\u001a\u00020\u000bHÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003Jw\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0003HÆ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\u000bHÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0012\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0012¨\u00063"}, d2 = {"Lcom/qiahao/base_common/network/ServerInfo;", "", "name", "", "description", TransferTable.COLUMN_KEY, "baseUrl", "agoraAppID", "rongCloudAppKey", "matchWebSocketAddr", "tencentImAppKey", "", "tencentOfflineId", "levelH5", "h5Base", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getDescription", "setDescription", "(Ljava/lang/String;)V", "getKey", "getBaseUrl", "setBaseUrl", "getAgoraAppID", "getRongCloudAppKey", "getMatchWebSocketAddr", "setMatchWebSocketAddr", "getTencentImAppKey", "()I", "getTencentOfflineId", "getLevelH5", "getH5Base", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "hashCode", "toString", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class ServerInfo {

    @NotNull
    private final String agoraAppID;

    @NotNull
    private String baseUrl;

    @NotNull
    private String description;

    @NotNull
    private final String h5Base;

    @NotNull
    private final String key;

    @NotNull
    private final String levelH5;

    @NotNull
    private String matchWebSocketAddr;

    @NotNull
    private final String name;

    @NotNull
    private final String rongCloudAppKey;
    private final int tencentImAppKey;
    private final int tencentOfflineId;

    public ServerInfo(@NotNull String name, @NotNull String description, @NotNull String key, @NotNull String baseUrl, @NotNull String agoraAppID, @NotNull String rongCloudAppKey, @NotNull String matchWebSocketAddr, int i10, int i11, @NotNull String levelH5, @NotNull String h5Base) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(agoraAppID, "agoraAppID");
        Intrinsics.checkNotNullParameter(rongCloudAppKey, "rongCloudAppKey");
        Intrinsics.checkNotNullParameter(matchWebSocketAddr, "matchWebSocketAddr");
        Intrinsics.checkNotNullParameter(levelH5, "levelH5");
        Intrinsics.checkNotNullParameter(h5Base, "h5Base");
        this.name = name;
        this.description = description;
        this.key = key;
        this.baseUrl = baseUrl;
        this.agoraAppID = agoraAppID;
        this.rongCloudAppKey = rongCloudAppKey;
        this.matchWebSocketAddr = matchWebSocketAddr;
        this.tencentImAppKey = i10;
        this.tencentOfflineId = i11;
        this.levelH5 = levelH5;
        this.h5Base = h5Base;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* renamed from: component10, reason: from getter */
    public final String getLevelH5() {
        return this.levelH5;
    }

    @NotNull
    /* renamed from: component11, reason: from getter */
    public final String getH5Base() {
        return this.h5Base;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getAgoraAppID() {
        return this.agoraAppID;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getRongCloudAppKey() {
        return this.rongCloudAppKey;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final String getMatchWebSocketAddr() {
        return this.matchWebSocketAddr;
    }

    /* renamed from: component8, reason: from getter */
    public final int getTencentImAppKey() {
        return this.tencentImAppKey;
    }

    /* renamed from: component9, reason: from getter */
    public final int getTencentOfflineId() {
        return this.tencentOfflineId;
    }

    @NotNull
    public final ServerInfo copy(@NotNull String name, @NotNull String description, @NotNull String key, @NotNull String baseUrl, @NotNull String agoraAppID, @NotNull String rongCloudAppKey, @NotNull String matchWebSocketAddr, int tencentImAppKey, int tencentOfflineId, @NotNull String levelH5, @NotNull String h5Base) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(agoraAppID, "agoraAppID");
        Intrinsics.checkNotNullParameter(rongCloudAppKey, "rongCloudAppKey");
        Intrinsics.checkNotNullParameter(matchWebSocketAddr, "matchWebSocketAddr");
        Intrinsics.checkNotNullParameter(levelH5, "levelH5");
        Intrinsics.checkNotNullParameter(h5Base, "h5Base");
        return new ServerInfo(name, description, key, baseUrl, agoraAppID, rongCloudAppKey, matchWebSocketAddr, tencentImAppKey, tencentOfflineId, levelH5, h5Base);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServerInfo)) {
            return false;
        }
        ServerInfo serverInfo = (ServerInfo) other;
        return Intrinsics.areEqual(this.name, serverInfo.name) && Intrinsics.areEqual(this.description, serverInfo.description) && Intrinsics.areEqual(this.key, serverInfo.key) && Intrinsics.areEqual(this.baseUrl, serverInfo.baseUrl) && Intrinsics.areEqual(this.agoraAppID, serverInfo.agoraAppID) && Intrinsics.areEqual(this.rongCloudAppKey, serverInfo.rongCloudAppKey) && Intrinsics.areEqual(this.matchWebSocketAddr, serverInfo.matchWebSocketAddr) && this.tencentImAppKey == serverInfo.tencentImAppKey && this.tencentOfflineId == serverInfo.tencentOfflineId && Intrinsics.areEqual(this.levelH5, serverInfo.levelH5) && Intrinsics.areEqual(this.h5Base, serverInfo.h5Base);
    }

    @NotNull
    public final String getAgoraAppID() {
        return this.agoraAppID;
    }

    @NotNull
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getH5Base() {
        return this.h5Base;
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }

    @NotNull
    public final String getLevelH5() {
        return this.levelH5;
    }

    @NotNull
    public final String getMatchWebSocketAddr() {
        return this.matchWebSocketAddr;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getRongCloudAppKey() {
        return this.rongCloudAppKey;
    }

    public final int getTencentImAppKey() {
        return this.tencentImAppKey;
    }

    public final int getTencentOfflineId() {
        return this.tencentOfflineId;
    }

    public int hashCode() {
        return (((((((((((((((((((this.name.hashCode() * 31) + this.description.hashCode()) * 31) + this.key.hashCode()) * 31) + this.baseUrl.hashCode()) * 31) + this.agoraAppID.hashCode()) * 31) + this.rongCloudAppKey.hashCode()) * 31) + this.matchWebSocketAddr.hashCode()) * 31) + this.tencentImAppKey) * 31) + this.tencentOfflineId) * 31) + this.levelH5.hashCode()) * 31) + this.h5Base.hashCode();
    }

    public final void setBaseUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.baseUrl = str;
    }

    public final void setDescription(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.description = str;
    }

    public final void setMatchWebSocketAddr(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.matchWebSocketAddr = str;
    }

    @NotNull
    public String toString() {
        return "ServerInfo(name=" + this.name + ", description=" + this.description + ", key=" + this.key + ", baseUrl=" + this.baseUrl + ", agoraAppID=" + this.agoraAppID + ", rongCloudAppKey=" + this.rongCloudAppKey + ", matchWebSocketAddr=" + this.matchWebSocketAddr + ", tencentImAppKey=" + this.tencentImAppKey + ", tencentOfflineId=" + this.tencentOfflineId + ", levelH5=" + this.levelH5 + ", h5Base=" + this.h5Base + ")";
    }
}
