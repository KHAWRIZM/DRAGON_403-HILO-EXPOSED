package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/qiahao/nextvideo/data/model/CelebrityOrCharmBean;", "Ljava/io/Serializable;", "num", "", "userBase", "Lcom/qiahao/nextvideo/data/model/CelebrityOrCharmUserBase;", "<init>", "(JLcom/qiahao/nextvideo/data/model/CelebrityOrCharmUserBase;)V", "getNum", "()J", "getUserBase", "()Lcom/qiahao/nextvideo/data/model/CelebrityOrCharmUserBase;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class CelebrityOrCharmBean implements Serializable {
    private final long num;

    @NotNull
    private final CelebrityOrCharmUserBase userBase;

    public CelebrityOrCharmBean(long j, @NotNull CelebrityOrCharmUserBase celebrityOrCharmUserBase) {
        Intrinsics.checkNotNullParameter(celebrityOrCharmUserBase, "userBase");
        this.num = j;
        this.userBase = celebrityOrCharmUserBase;
    }

    public static /* synthetic */ CelebrityOrCharmBean copy$default(CelebrityOrCharmBean celebrityOrCharmBean, long j, CelebrityOrCharmUserBase celebrityOrCharmUserBase, int i, Object obj) {
        if ((i & 1) != 0) {
            j = celebrityOrCharmBean.num;
        }
        if ((i & 2) != 0) {
            celebrityOrCharmUserBase = celebrityOrCharmBean.userBase;
        }
        return celebrityOrCharmBean.copy(j, celebrityOrCharmUserBase);
    }

    /* renamed from: component1, reason: from getter */
    public final long getNum() {
        return this.num;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final CelebrityOrCharmUserBase getUserBase() {
        return this.userBase;
    }

    @NotNull
    public final CelebrityOrCharmBean copy(long num, @NotNull CelebrityOrCharmUserBase userBase) {
        Intrinsics.checkNotNullParameter(userBase, "userBase");
        return new CelebrityOrCharmBean(num, userBase);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CelebrityOrCharmBean)) {
            return false;
        }
        CelebrityOrCharmBean celebrityOrCharmBean = (CelebrityOrCharmBean) other;
        return this.num == celebrityOrCharmBean.num && Intrinsics.areEqual(this.userBase, celebrityOrCharmBean.userBase);
    }

    public final long getNum() {
        return this.num;
    }

    @NotNull
    public final CelebrityOrCharmUserBase getUserBase() {
        return this.userBase;
    }

    public int hashCode() {
        return (c.a(this.num) * 31) + this.userBase.hashCode();
    }

    @NotNull
    public String toString() {
        return "CelebrityOrCharmBean(num=" + this.num + ", userBase=" + this.userBase + ")";
    }
}
