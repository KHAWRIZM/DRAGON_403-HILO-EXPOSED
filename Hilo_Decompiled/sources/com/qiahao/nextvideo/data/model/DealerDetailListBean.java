package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import com.qiahao.nextvideo.ui.wallet.ExchangeDetailActivity;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/qiahao/nextvideo/data/model/DealerDetailListBean;", "", Constants.KEY_HTTP_CODE, "", ExchangeDetailActivity.TYPE_DIAMOND, "", "dollar", "", "timeStamp", "<init>", "(Ljava/lang/String;JIJ)V", "getCode", "()Ljava/lang/String;", "getDiamond", "()J", "getDollar", "()I", "getTimeStamp", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class DealerDetailListBean {

    @NotNull
    private final String code;
    private final long diamond;
    private final int dollar;
    private final long timeStamp;

    public DealerDetailListBean(@NotNull String str, long j, int i, long j2) {
        Intrinsics.checkNotNullParameter(str, Constants.KEY_HTTP_CODE);
        this.code = str;
        this.diamond = j;
        this.dollar = i;
        this.timeStamp = j2;
    }

    public static /* synthetic */ DealerDetailListBean copy$default(DealerDetailListBean dealerDetailListBean, String str, long j, int i, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = dealerDetailListBean.code;
        }
        if ((i2 & 2) != 0) {
            j = dealerDetailListBean.diamond;
        }
        long j3 = j;
        if ((i2 & 4) != 0) {
            i = dealerDetailListBean.dollar;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            j2 = dealerDetailListBean.timeStamp;
        }
        return dealerDetailListBean.copy(str, j3, i3, j2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final long getDiamond() {
        return this.diamond;
    }

    /* renamed from: component3, reason: from getter */
    public final int getDollar() {
        return this.dollar;
    }

    /* renamed from: component4, reason: from getter */
    public final long getTimeStamp() {
        return this.timeStamp;
    }

    @NotNull
    public final DealerDetailListBean copy(@NotNull String code, long diamond, int dollar, long timeStamp) {
        Intrinsics.checkNotNullParameter(code, Constants.KEY_HTTP_CODE);
        return new DealerDetailListBean(code, diamond, dollar, timeStamp);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DealerDetailListBean)) {
            return false;
        }
        DealerDetailListBean dealerDetailListBean = (DealerDetailListBean) other;
        return Intrinsics.areEqual(this.code, dealerDetailListBean.code) && this.diamond == dealerDetailListBean.diamond && this.dollar == dealerDetailListBean.dollar && this.timeStamp == dealerDetailListBean.timeStamp;
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    public final long getDiamond() {
        return this.diamond;
    }

    public final int getDollar() {
        return this.dollar;
    }

    public final long getTimeStamp() {
        return this.timeStamp;
    }

    public int hashCode() {
        return (((((this.code.hashCode() * 31) + c.a(this.diamond)) * 31) + this.dollar) * 31) + c.a(this.timeStamp);
    }

    @NotNull
    public String toString() {
        return "DealerDetailListBean(code=" + this.code + ", diamond=" + this.diamond + ", dollar=" + this.dollar + ", timeStamp=" + this.timeStamp + ")";
    }
}
