package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/qiahao/nextvideo/data/model/DeleteAccountConditionBean;", "", "banCondition", "", "beanCondition", "cpCondition", "diamondCondition", "nobleCondition", "<init>", "(ZZZZZ)V", "getBanCondition", "()Z", "getBeanCondition", "getCpCondition", "getDiamondCondition", "getNobleCondition", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class DeleteAccountConditionBean {
    private final boolean banCondition;
    private final boolean beanCondition;
    private final boolean cpCondition;
    private final boolean diamondCondition;
    private final boolean nobleCondition;

    public DeleteAccountConditionBean(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.banCondition = z;
        this.beanCondition = z2;
        this.cpCondition = z3;
        this.diamondCondition = z4;
        this.nobleCondition = z5;
    }

    public static /* synthetic */ DeleteAccountConditionBean copy$default(DeleteAccountConditionBean deleteAccountConditionBean, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i, Object obj) {
        if ((i & 1) != 0) {
            z = deleteAccountConditionBean.banCondition;
        }
        if ((i & 2) != 0) {
            z2 = deleteAccountConditionBean.beanCondition;
        }
        boolean z6 = z2;
        if ((i & 4) != 0) {
            z3 = deleteAccountConditionBean.cpCondition;
        }
        boolean z7 = z3;
        if ((i & 8) != 0) {
            z4 = deleteAccountConditionBean.diamondCondition;
        }
        boolean z8 = z4;
        if ((i & 16) != 0) {
            z5 = deleteAccountConditionBean.nobleCondition;
        }
        return deleteAccountConditionBean.copy(z, z6, z7, z8, z5);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getBanCondition() {
        return this.banCondition;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getBeanCondition() {
        return this.beanCondition;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getCpCondition() {
        return this.cpCondition;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getDiamondCondition() {
        return this.diamondCondition;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getNobleCondition() {
        return this.nobleCondition;
    }

    @NotNull
    public final DeleteAccountConditionBean copy(boolean banCondition, boolean beanCondition, boolean cpCondition, boolean diamondCondition, boolean nobleCondition) {
        return new DeleteAccountConditionBean(banCondition, beanCondition, cpCondition, diamondCondition, nobleCondition);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeleteAccountConditionBean)) {
            return false;
        }
        DeleteAccountConditionBean deleteAccountConditionBean = (DeleteAccountConditionBean) other;
        return this.banCondition == deleteAccountConditionBean.banCondition && this.beanCondition == deleteAccountConditionBean.beanCondition && this.cpCondition == deleteAccountConditionBean.cpCondition && this.diamondCondition == deleteAccountConditionBean.diamondCondition && this.nobleCondition == deleteAccountConditionBean.nobleCondition;
    }

    public final boolean getBanCondition() {
        return this.banCondition;
    }

    public final boolean getBeanCondition() {
        return this.beanCondition;
    }

    public final boolean getCpCondition() {
        return this.cpCondition;
    }

    public final boolean getDiamondCondition() {
        return this.diamondCondition;
    }

    public final boolean getNobleCondition() {
        return this.nobleCondition;
    }

    public int hashCode() {
        return (((((((a.a(this.banCondition) * 31) + a.a(this.beanCondition)) * 31) + a.a(this.cpCondition)) * 31) + a.a(this.diamondCondition)) * 31) + a.a(this.nobleCondition);
    }

    @NotNull
    public String toString() {
        return "DeleteAccountConditionBean(banCondition=" + this.banCondition + ", beanCondition=" + this.beanCondition + ", cpCondition=" + this.cpCondition + ", diamondCondition=" + this.diamondCondition + ", nobleCondition=" + this.nobleCondition + ")";
    }
}
