package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/qiahao/nextvideo/data/model/RocketBean;", "", "string", "", "<init>", "(Ljava/lang/String;)V", "getString", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class RocketBean {

    @NotNull
    private final String string;

    public RocketBean(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "string");
        this.string = str;
    }

    public static /* synthetic */ RocketBean copy$default(RocketBean rocketBean, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rocketBean.string;
        }
        return rocketBean.copy(str);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getString() {
        return this.string;
    }

    @NotNull
    public final RocketBean copy(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        return new RocketBean(string);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof RocketBean) && Intrinsics.areEqual(this.string, ((RocketBean) other).string);
    }

    @NotNull
    public final String getString() {
        return this.string;
    }

    public int hashCode() {
        return this.string.hashCode();
    }

    @NotNull
    public String toString() {
        return "RocketBean(string=" + this.string + ")";
    }
}
