package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J1\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/qiahao/nextvideo/data/model/AristocracyPermissionBean;", "", "hasPermissionResId", "", "unHasPermissionResId", "hasPermission", "", "permissionText", "", "<init>", "(IIZLjava/lang/String;)V", "getHasPermissionResId", "()I", "getUnHasPermissionResId", "getHasPermission", "()Z", "setHasPermission", "(Z)V", "getPermissionText", "()Ljava/lang/String;", "setPermissionText", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class AristocracyPermissionBean {
    private boolean hasPermission;
    private final int hasPermissionResId;

    @NotNull
    private String permissionText;
    private final int unHasPermissionResId;

    public AristocracyPermissionBean(int i, int i2, boolean z, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "permissionText");
        this.hasPermissionResId = i;
        this.unHasPermissionResId = i2;
        this.hasPermission = z;
        this.permissionText = str;
    }

    public static /* synthetic */ AristocracyPermissionBean copy$default(AristocracyPermissionBean aristocracyPermissionBean, int i, int i2, boolean z, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = aristocracyPermissionBean.hasPermissionResId;
        }
        if ((i3 & 2) != 0) {
            i2 = aristocracyPermissionBean.unHasPermissionResId;
        }
        if ((i3 & 4) != 0) {
            z = aristocracyPermissionBean.hasPermission;
        }
        if ((i3 & 8) != 0) {
            str = aristocracyPermissionBean.permissionText;
        }
        return aristocracyPermissionBean.copy(i, i2, z, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getHasPermissionResId() {
        return this.hasPermissionResId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getUnHasPermissionResId() {
        return this.unHasPermissionResId;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getHasPermission() {
        return this.hasPermission;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getPermissionText() {
        return this.permissionText;
    }

    @NotNull
    public final AristocracyPermissionBean copy(int hasPermissionResId, int unHasPermissionResId, boolean hasPermission, @NotNull String permissionText) {
        Intrinsics.checkNotNullParameter(permissionText, "permissionText");
        return new AristocracyPermissionBean(hasPermissionResId, unHasPermissionResId, hasPermission, permissionText);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AristocracyPermissionBean)) {
            return false;
        }
        AristocracyPermissionBean aristocracyPermissionBean = (AristocracyPermissionBean) other;
        return this.hasPermissionResId == aristocracyPermissionBean.hasPermissionResId && this.unHasPermissionResId == aristocracyPermissionBean.unHasPermissionResId && this.hasPermission == aristocracyPermissionBean.hasPermission && Intrinsics.areEqual(this.permissionText, aristocracyPermissionBean.permissionText);
    }

    public final boolean getHasPermission() {
        return this.hasPermission;
    }

    public final int getHasPermissionResId() {
        return this.hasPermissionResId;
    }

    @NotNull
    public final String getPermissionText() {
        return this.permissionText;
    }

    public final int getUnHasPermissionResId() {
        return this.unHasPermissionResId;
    }

    public int hashCode() {
        return (((((this.hasPermissionResId * 31) + this.unHasPermissionResId) * 31) + a.a(this.hasPermission)) * 31) + this.permissionText.hashCode();
    }

    public final void setHasPermission(boolean z) {
        this.hasPermission = z;
    }

    public final void setPermissionText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.permissionText = str;
    }

    @NotNull
    public String toString() {
        return "AristocracyPermissionBean(hasPermissionResId=" + this.hasPermissionResId + ", unHasPermissionResId=" + this.unHasPermissionResId + ", hasPermission=" + this.hasPermission + ", permissionText=" + this.permissionText + ")";
    }
}
