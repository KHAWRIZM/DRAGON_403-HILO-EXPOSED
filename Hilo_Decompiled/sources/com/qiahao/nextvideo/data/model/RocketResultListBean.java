package com.qiahao.nextvideo.data.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/qiahao/nextvideo/data/model/RocketResultListBean;", "", "rockets", "", "Lcom/qiahao/nextvideo/data/model/RocketResultBean;", "<init>", "(Ljava/util/List;)V", "getRockets", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class RocketResultListBean {

    @Nullable
    private final List<RocketResultBean> rockets;

    public RocketResultListBean(@Nullable List<RocketResultBean> list) {
        this.rockets = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RocketResultListBean copy$default(RocketResultListBean rocketResultListBean, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = rocketResultListBean.rockets;
        }
        return rocketResultListBean.copy(list);
    }

    @Nullable
    public final List<RocketResultBean> component1() {
        return this.rockets;
    }

    @NotNull
    public final RocketResultListBean copy(@Nullable List<RocketResultBean> rockets) {
        return new RocketResultListBean(rockets);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof RocketResultListBean) && Intrinsics.areEqual(this.rockets, ((RocketResultListBean) other).rockets);
    }

    @Nullable
    public final List<RocketResultBean> getRockets() {
        return this.rockets;
    }

    public int hashCode() {
        List<RocketResultBean> list = this.rockets;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    @NotNull
    public String toString() {
        return "RocketResultListBean(rockets=" + this.rockets + ")";
    }
}
