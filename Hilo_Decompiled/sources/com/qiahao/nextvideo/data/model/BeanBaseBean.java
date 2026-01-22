package com.qiahao.nextvideo.data.model;

import com.google.firebase.sessions.a;
import com.qiahao.nextvideo.ui.wallet.ExchangeDiamondsActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/qiahao/nextvideo/data/model/BeanBaseBean;", "", ExchangeDiamondsActivity.BEAN_NUM, "", "diamondNum", "", "<init>", "(Ljava/lang/String;D)V", "getBeanNum", "()Ljava/lang/String;", "setBeanNum", "(Ljava/lang/String;)V", "getDiamondNum", "()D", "setDiamondNum", "(D)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class BeanBaseBean {

    @NotNull
    private String beanNum;
    private double diamondNum;

    public BeanBaseBean(@NotNull String str, double d) {
        Intrinsics.checkNotNullParameter(str, ExchangeDiamondsActivity.BEAN_NUM);
        this.beanNum = str;
        this.diamondNum = d;
    }

    public static /* synthetic */ BeanBaseBean copy$default(BeanBaseBean beanBaseBean, String str, double d, int i, Object obj) {
        if ((i & 1) != 0) {
            str = beanBaseBean.beanNum;
        }
        if ((i & 2) != 0) {
            d = beanBaseBean.diamondNum;
        }
        return beanBaseBean.copy(str, d);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getBeanNum() {
        return this.beanNum;
    }

    /* renamed from: component2, reason: from getter */
    public final double getDiamondNum() {
        return this.diamondNum;
    }

    @NotNull
    public final BeanBaseBean copy(@NotNull String beanNum, double diamondNum) {
        Intrinsics.checkNotNullParameter(beanNum, ExchangeDiamondsActivity.BEAN_NUM);
        return new BeanBaseBean(beanNum, diamondNum);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BeanBaseBean)) {
            return false;
        }
        BeanBaseBean beanBaseBean = (BeanBaseBean) other;
        return Intrinsics.areEqual(this.beanNum, beanBaseBean.beanNum) && Double.compare(this.diamondNum, beanBaseBean.diamondNum) == 0;
    }

    @NotNull
    public final String getBeanNum() {
        return this.beanNum;
    }

    public final double getDiamondNum() {
        return this.diamondNum;
    }

    public int hashCode() {
        return (this.beanNum.hashCode() * 31) + a.a(this.diamondNum);
    }

    public final void setBeanNum(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.beanNum = str;
    }

    public final void setDiamondNum(double d) {
        this.diamondNum = d;
    }

    @NotNull
    public String toString() {
        return "BeanBaseBean(beanNum=" + this.beanNum + ", diamondNum=" + this.diamondNum + ")";
    }
}
