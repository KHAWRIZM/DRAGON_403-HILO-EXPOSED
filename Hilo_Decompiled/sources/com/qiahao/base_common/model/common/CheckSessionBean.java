package com.qiahao.base_common.model.common;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/qiahao/base_common/model/common/CheckSessionBean;", "", "canTalk", "", "isSession", "", "<init>", "(IZ)V", "getCanTalk", "()I", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class CheckSessionBean {
    public static final int BLOCK_ME = 5;
    public static final int BLOCK_YOU = 4;
    public static final int CAN_TALK = 1;
    public static final int I_UNLIKE_IT = 2;
    public static final int USER_UNLIKE_ME = 3;
    private final int canTalk;
    private final boolean isSession;

    public CheckSessionBean(int i10, boolean z10) {
        this.canTalk = i10;
        this.isSession = z10;
    }

    public static /* synthetic */ CheckSessionBean copy$default(CheckSessionBean checkSessionBean, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = checkSessionBean.canTalk;
        }
        if ((i11 & 2) != 0) {
            z10 = checkSessionBean.isSession;
        }
        return checkSessionBean.copy(i10, z10);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCanTalk() {
        return this.canTalk;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsSession() {
        return this.isSession;
    }

    @NotNull
    public final CheckSessionBean copy(int canTalk, boolean isSession) {
        return new CheckSessionBean(canTalk, isSession);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CheckSessionBean)) {
            return false;
        }
        CheckSessionBean checkSessionBean = (CheckSessionBean) other;
        return this.canTalk == checkSessionBean.canTalk && this.isSession == checkSessionBean.isSession;
    }

    public final int getCanTalk() {
        return this.canTalk;
    }

    public int hashCode() {
        return (this.canTalk * 31) + a.a(this.isSession);
    }

    public final boolean isSession() {
        return this.isSession;
    }

    @NotNull
    public String toString() {
        return "CheckSessionBean(canTalk=" + this.canTalk + ", isSession=" + this.isSession + ")";
    }
}
