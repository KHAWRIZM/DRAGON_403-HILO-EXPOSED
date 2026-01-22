package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/data/model/FlagBean;", "", AgooConstants.MESSAGE_FLAG, "", "<init>", "(Z)V", "getFlag", "()Z", "setFlag", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class FlagBean {
    private boolean flag;

    public FlagBean(boolean z) {
        this.flag = z;
    }

    public static /* synthetic */ FlagBean copy$default(FlagBean flagBean, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = flagBean.flag;
        }
        return flagBean.copy(z);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getFlag() {
        return this.flag;
    }

    @NotNull
    public final FlagBean copy(boolean flag) {
        return new FlagBean(flag);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FlagBean) && this.flag == ((FlagBean) other).flag;
    }

    public final boolean getFlag() {
        return this.flag;
    }

    public int hashCode() {
        return a.a(this.flag);
    }

    public final void setFlag(boolean z) {
        this.flag = z;
    }

    @NotNull
    public String toString() {
        return "FlagBean(flag=" + this.flag + ")";
    }
}
