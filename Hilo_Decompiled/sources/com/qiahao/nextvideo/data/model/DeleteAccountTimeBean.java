package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/qiahao/nextvideo/data/model/DeleteAccountTimeBean;", "", "logoutFinishTime", "", "userCode", "", "<init>", "(JLjava/lang/String;)V", "getLogoutFinishTime", "()J", "getUserCode", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class DeleteAccountTimeBean {
    private final long logoutFinishTime;

    @NotNull
    private final String userCode;

    public DeleteAccountTimeBean(long j, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "userCode");
        this.logoutFinishTime = j;
        this.userCode = str;
    }

    public static /* synthetic */ DeleteAccountTimeBean copy$default(DeleteAccountTimeBean deleteAccountTimeBean, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = deleteAccountTimeBean.logoutFinishTime;
        }
        if ((i & 2) != 0) {
            str = deleteAccountTimeBean.userCode;
        }
        return deleteAccountTimeBean.copy(j, str);
    }

    /* renamed from: component1, reason: from getter */
    public final long getLogoutFinishTime() {
        return this.logoutFinishTime;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getUserCode() {
        return this.userCode;
    }

    @NotNull
    public final DeleteAccountTimeBean copy(long logoutFinishTime, @NotNull String userCode) {
        Intrinsics.checkNotNullParameter(userCode, "userCode");
        return new DeleteAccountTimeBean(logoutFinishTime, userCode);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeleteAccountTimeBean)) {
            return false;
        }
        DeleteAccountTimeBean deleteAccountTimeBean = (DeleteAccountTimeBean) other;
        return this.logoutFinishTime == deleteAccountTimeBean.logoutFinishTime && Intrinsics.areEqual(this.userCode, deleteAccountTimeBean.userCode);
    }

    public final long getLogoutFinishTime() {
        return this.logoutFinishTime;
    }

    @NotNull
    public final String getUserCode() {
        return this.userCode;
    }

    public int hashCode() {
        return (c.a(this.logoutFinishTime) * 31) + this.userCode.hashCode();
    }

    @NotNull
    public String toString() {
        return "DeleteAccountTimeBean(logoutFinishTime=" + this.logoutFinishTime + ", userCode=" + this.userCode + ")";
    }
}
