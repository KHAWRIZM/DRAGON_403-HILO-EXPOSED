package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/qiahao/nextvideo/data/model/SkinConfiguration;", "", "on", "", "resourceUrl", "", "<init>", "(ZLjava/lang/String;)V", "getOn", "()Z", "setOn", "(Z)V", "getResourceUrl", "()Ljava/lang/String;", "setResourceUrl", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class SkinConfiguration {
    private boolean on;

    @Nullable
    private String resourceUrl;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SkinConfiguration() {
        this(false, r0, 3, r0);
        String str = null;
    }

    public static /* synthetic */ SkinConfiguration copy$default(SkinConfiguration skinConfiguration, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = skinConfiguration.on;
        }
        if ((i & 2) != 0) {
            str = skinConfiguration.resourceUrl;
        }
        return skinConfiguration.copy(z, str);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getOn() {
        return this.on;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getResourceUrl() {
        return this.resourceUrl;
    }

    @NotNull
    public final SkinConfiguration copy(boolean on, @Nullable String resourceUrl) {
        return new SkinConfiguration(on, resourceUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SkinConfiguration)) {
            return false;
        }
        SkinConfiguration skinConfiguration = (SkinConfiguration) other;
        return this.on == skinConfiguration.on && Intrinsics.areEqual(this.resourceUrl, skinConfiguration.resourceUrl);
    }

    public final boolean getOn() {
        return this.on;
    }

    @Nullable
    public final String getResourceUrl() {
        return this.resourceUrl;
    }

    public int hashCode() {
        int a = a.a(this.on) * 31;
        String str = this.resourceUrl;
        return a + (str == null ? 0 : str.hashCode());
    }

    public final void setOn(boolean z) {
        this.on = z;
    }

    public final void setResourceUrl(@Nullable String str) {
        this.resourceUrl = str;
    }

    @NotNull
    public String toString() {
        return "SkinConfiguration(on=" + this.on + ", resourceUrl=" + this.resourceUrl + ")";
    }

    public SkinConfiguration(boolean z, @Nullable String str) {
        this.on = z;
        this.resourceUrl = str;
    }

    public /* synthetic */ SkinConfiguration(boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : str);
    }
}
