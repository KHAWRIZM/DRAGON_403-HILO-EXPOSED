package com.qiahao.nextvideo.data.noble;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/data/noble/NobleUse;", "", "img", "", "msg", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getImg", "()Ljava/lang/String;", "setImg", "(Ljava/lang/String;)V", "getMsg", "setMsg", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class NobleUse {

    @Nullable
    private String img;

    @Nullable
    private String msg;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public NobleUse() {
        this(r0, r0, 3, r0);
        String str = null;
    }

    public static /* synthetic */ NobleUse copy$default(NobleUse nobleUse, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = nobleUse.img;
        }
        if ((i & 2) != 0) {
            str2 = nobleUse.msg;
        }
        return nobleUse.copy(str, str2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getImg() {
        return this.img;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    @NotNull
    public final NobleUse copy(@Nullable String img, @Nullable String msg) {
        return new NobleUse(img, msg);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NobleUse)) {
            return false;
        }
        NobleUse nobleUse = (NobleUse) other;
        return Intrinsics.areEqual(this.img, nobleUse.img) && Intrinsics.areEqual(this.msg, nobleUse.msg);
    }

    @Nullable
    public final String getImg() {
        return this.img;
    }

    @Nullable
    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        String str = this.img;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.msg;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setImg(@Nullable String str) {
        this.img = str;
    }

    public final void setMsg(@Nullable String str) {
        this.msg = str;
    }

    @NotNull
    public String toString() {
        return "NobleUse(img=" + this.img + ", msg=" + this.msg + ")";
    }

    public NobleUse(@Nullable String str, @Nullable String str2) {
        this.img = str;
        this.msg = str2;
    }

    public /* synthetic */ NobleUse(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }
}
