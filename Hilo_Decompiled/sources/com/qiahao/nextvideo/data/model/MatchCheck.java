package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;
import q2.a;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/qiahao/nextvideo/data/model/MatchCheck;", "", AgooConstants.MESSAGE_FLAG, "", "<init>", "(Z)V", "getFlag", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class MatchCheck {

    @c(AgooConstants.MESSAGE_FLAG)
    private final boolean flag;

    public MatchCheck(boolean z) {
        this.flag = z;
    }

    public static /* synthetic */ MatchCheck copy$default(MatchCheck matchCheck, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = matchCheck.flag;
        }
        return matchCheck.copy(z);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getFlag() {
        return this.flag;
    }

    @NotNull
    public final MatchCheck copy(boolean flag) {
        return new MatchCheck(flag);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MatchCheck) && this.flag == ((MatchCheck) other).flag;
    }

    public final boolean getFlag() {
        return this.flag;
    }

    public int hashCode() {
        return a.a(this.flag);
    }

    @NotNull
    public String toString() {
        return "MatchCheck(flag=" + this.flag + ")";
    }
}
