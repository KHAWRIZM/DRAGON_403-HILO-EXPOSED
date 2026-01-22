package com.qiahao.base_common.model.svip;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Parcelize
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b(\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\t\u0010*\u001a\u00020\bHÆ\u0003J\t\u0010+\u001a\u00020\nHÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010!J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\\\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010/J\u0006\u00100\u001a\u00020\nJ\u0013\u00101\u001a\u00020\u00062\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u00020\nHÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001J\u0016\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010\u0012¨\u0006;"}, d2 = {"Lcom/qiahao/base_common/model/svip/TaskPrivilegeBean;", "Landroid/os/Parcelable;", "collectionTime", "", "icon", "isManually", "", "num", "", "receiveStatus", "", "taskId", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZJILjava/lang/Long;Ljava/lang/String;)V", "getCollectionTime", "()Ljava/lang/String;", "setCollectionTime", "(Ljava/lang/String;)V", "getIcon", "setIcon", "()Z", "setManually", "(Z)V", "getNum", "()J", "setNum", "(J)V", "getReceiveStatus", "()I", "setReceiveStatus", "(I)V", "getTaskId", "()Ljava/lang/Long;", "setTaskId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;ZJILjava/lang/Long;Ljava/lang/String;)Lcom/qiahao/base_common/model/svip/TaskPrivilegeBean;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class TaskPrivilegeBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<TaskPrivilegeBean> CREATOR = new Creator();

    @Nullable
    private String collectionTime;

    @Nullable
    private String icon;
    private boolean isManually;
    private long num;
    private int receiveStatus;

    @Nullable
    private Long taskId;

    @Nullable
    private String title;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Creator implements Parcelable.Creator<TaskPrivilegeBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TaskPrivilegeBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TaskPrivilegeBean(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readLong(), parcel.readInt(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TaskPrivilegeBean[] newArray(int i10) {
            return new TaskPrivilegeBean[i10];
        }
    }

    public TaskPrivilegeBean(@Nullable String str, @Nullable String str2, boolean z10, long j10, int i10, @Nullable Long l10, @Nullable String str3) {
        this.collectionTime = str;
        this.icon = str2;
        this.isManually = z10;
        this.num = j10;
        this.receiveStatus = i10;
        this.taskId = l10;
        this.title = str3;
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getCollectionTime() {
        return this.collectionTime;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsManually() {
        return this.isManually;
    }

    /* renamed from: component4, reason: from getter */
    public final long getNum() {
        return this.num;
    }

    /* renamed from: component5, reason: from getter */
    public final int getReceiveStatus() {
        return this.receiveStatus;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Long getTaskId() {
        return this.taskId;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final TaskPrivilegeBean copy(@Nullable String collectionTime, @Nullable String icon, boolean isManually, long num, int receiveStatus, @Nullable Long taskId, @Nullable String title) {
        return new TaskPrivilegeBean(collectionTime, icon, isManually, num, receiveStatus, taskId, title);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskPrivilegeBean)) {
            return false;
        }
        TaskPrivilegeBean taskPrivilegeBean = (TaskPrivilegeBean) other;
        return Intrinsics.areEqual(this.collectionTime, taskPrivilegeBean.collectionTime) && Intrinsics.areEqual(this.icon, taskPrivilegeBean.icon) && this.isManually == taskPrivilegeBean.isManually && this.num == taskPrivilegeBean.num && this.receiveStatus == taskPrivilegeBean.receiveStatus && Intrinsics.areEqual(this.taskId, taskPrivilegeBean.taskId) && Intrinsics.areEqual(this.title, taskPrivilegeBean.title);
    }

    @Nullable
    public final String getCollectionTime() {
        return this.collectionTime;
    }

    @Nullable
    public final String getIcon() {
        return this.icon;
    }

    public final long getNum() {
        return this.num;
    }

    public final int getReceiveStatus() {
        return this.receiveStatus;
    }

    @Nullable
    public final Long getTaskId() {
        return this.taskId;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.collectionTime;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.icon;
        int hashCode2 = (((((((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + a.a(this.isManually)) * 31) + c.a(this.num)) * 31) + this.receiveStatus) * 31;
        Long l10 = this.taskId;
        int hashCode3 = (hashCode2 + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str3 = this.title;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public final boolean isManually() {
        return this.isManually;
    }

    public final void setCollectionTime(@Nullable String str) {
        this.collectionTime = str;
    }

    public final void setIcon(@Nullable String str) {
        this.icon = str;
    }

    public final void setManually(boolean z10) {
        this.isManually = z10;
    }

    public final void setNum(long j10) {
        this.num = j10;
    }

    public final void setReceiveStatus(int i10) {
        this.receiveStatus = i10;
    }

    public final void setTaskId(@Nullable Long l10) {
        this.taskId = l10;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    @NotNull
    public String toString() {
        return "TaskPrivilegeBean(collectionTime=" + this.collectionTime + ", icon=" + this.icon + ", isManually=" + this.isManually + ", num=" + this.num + ", receiveStatus=" + this.receiveStatus + ", taskId=" + this.taskId + ", title=" + this.title + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.collectionTime);
        dest.writeString(this.icon);
        dest.writeInt(this.isManually ? 1 : 0);
        dest.writeLong(this.num);
        dest.writeInt(this.receiveStatus);
        Long l10 = this.taskId;
        if (l10 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l10.longValue());
        }
        dest.writeString(this.title);
    }

    public /* synthetic */ TaskPrivilegeBean(String str, String str2, boolean z10, long j10, int i10, Long l10, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i11 & 4) != 0 ? false : z10, (i11 & 8) != 0 ? 0L : j10, (i11 & 16) != 0 ? 0 : i10, l10, str3);
    }
}
