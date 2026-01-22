package com.qiahao.base_common.room.roomModel;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Entity(tableName = "download_file")
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J)\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\n\"\u0004\b\f\u0010\rR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/qiahao/base_common/room/roomModel/DownloadFile;", "", "url", "", "localPath", "type", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getUrl", "()Ljava/lang/String;", "getLocalPath", "setLocalPath", "(Ljava/lang/String;)V", "getType", "()I", "setType", "(I)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class DownloadFile {

    @ColumnInfo(name = "localPath")
    @Nullable
    private String localPath;

    @ColumnInfo(name = "type")
    private int type;

    @PrimaryKey
    @NotNull
    private final String url;

    public DownloadFile() {
        this(null, null, 0, 7, null);
    }

    public static /* synthetic */ DownloadFile copy$default(DownloadFile downloadFile, String str, String str2, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = downloadFile.url;
        }
        if ((i11 & 2) != 0) {
            str2 = downloadFile.localPath;
        }
        if ((i11 & 4) != 0) {
            i10 = downloadFile.type;
        }
        return downloadFile.copy(str, str2, i10);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getLocalPath() {
        return this.localPath;
    }

    /* renamed from: component3, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @NotNull
    public final DownloadFile copy(@NotNull String url, @Nullable String localPath, int type) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new DownloadFile(url, localPath, type);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DownloadFile)) {
            return false;
        }
        DownloadFile downloadFile = (DownloadFile) other;
        return Intrinsics.areEqual(this.url, downloadFile.url) && Intrinsics.areEqual(this.localPath, downloadFile.localPath) && this.type == downloadFile.type;
    }

    @Nullable
    public final String getLocalPath() {
        return this.localPath;
    }

    public final int getType() {
        return this.type;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int hashCode = this.url.hashCode() * 31;
        String str = this.localPath;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.type;
    }

    public final void setLocalPath(@Nullable String str) {
        this.localPath = str;
    }

    public final void setType(int i10) {
        this.type = i10;
    }

    @NotNull
    public String toString() {
        return "DownloadFile(url=" + this.url + ", localPath=" + this.localPath + ", type=" + this.type + ")";
    }

    public DownloadFile(@NotNull String url, @Nullable String str, int i10) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
        this.localPath = str;
        this.type = i10;
    }

    public /* synthetic */ DownloadFile(String str, String str2, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? 0 : i10);
    }
}
