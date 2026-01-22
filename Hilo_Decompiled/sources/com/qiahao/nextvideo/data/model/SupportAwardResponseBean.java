package com.qiahao.nextvideo.data.model;

import com.taobao.agoo.a.a.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\t\u001a\u00020\u0001HÆ\u0003J\t\u0010\n\u001a\u00020\u0001HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/qiahao/nextvideo/data/model/SupportAwardResponseBean;", "", "failed", b.JSON_SUCCESS, "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getFailed", "()Ljava/lang/Object;", "getSuccess", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class SupportAwardResponseBean {

    @NotNull
    private final Object failed;

    @NotNull
    private final Object success;

    public SupportAwardResponseBean(@NotNull Object obj, @NotNull Object obj2) {
        Intrinsics.checkNotNullParameter(obj, "failed");
        Intrinsics.checkNotNullParameter(obj2, b.JSON_SUCCESS);
        this.failed = obj;
        this.success = obj2;
    }

    public static /* synthetic */ SupportAwardResponseBean copy$default(SupportAwardResponseBean supportAwardResponseBean, Object obj, Object obj2, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = supportAwardResponseBean.failed;
        }
        if ((i & 2) != 0) {
            obj2 = supportAwardResponseBean.success;
        }
        return supportAwardResponseBean.copy(obj, obj2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final Object getFailed() {
        return this.failed;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final Object getSuccess() {
        return this.success;
    }

    @NotNull
    public final SupportAwardResponseBean copy(@NotNull Object failed, @NotNull Object success) {
        Intrinsics.checkNotNullParameter(failed, "failed");
        Intrinsics.checkNotNullParameter(success, b.JSON_SUCCESS);
        return new SupportAwardResponseBean(failed, success);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SupportAwardResponseBean)) {
            return false;
        }
        SupportAwardResponseBean supportAwardResponseBean = (SupportAwardResponseBean) other;
        return Intrinsics.areEqual(this.failed, supportAwardResponseBean.failed) && Intrinsics.areEqual(this.success, supportAwardResponseBean.success);
    }

    @NotNull
    public final Object getFailed() {
        return this.failed;
    }

    @NotNull
    public final Object getSuccess() {
        return this.success;
    }

    public int hashCode() {
        return (this.failed.hashCode() * 31) + this.success.hashCode();
    }

    @NotNull
    public String toString() {
        return "SupportAwardResponseBean(failed=" + this.failed + ", success=" + this.success + ")";
    }
}
