package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import com.qiahao.nextvideo.ui.wallet.ExchangeDetailActivity;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/data/model/GlobalBroadCastConfig;", "", ExchangeDetailActivity.TYPE_DIAMOND, "", "<init>", "(J)V", "getDiamond", "()J", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class GlobalBroadCastConfig {
    private final long diamond;

    public GlobalBroadCastConfig(long j) {
        this.diamond = j;
    }

    public static /* synthetic */ GlobalBroadCastConfig copy$default(GlobalBroadCastConfig globalBroadCastConfig, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = globalBroadCastConfig.diamond;
        }
        return globalBroadCastConfig.copy(j);
    }

    /* renamed from: component1, reason: from getter */
    public final long getDiamond() {
        return this.diamond;
    }

    @NotNull
    public final GlobalBroadCastConfig copy(long diamond) {
        return new GlobalBroadCastConfig(diamond);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof GlobalBroadCastConfig) && this.diamond == ((GlobalBroadCastConfig) other).diamond;
    }

    public final long getDiamond() {
        return this.diamond;
    }

    public int hashCode() {
        return c.a(this.diamond);
    }

    @NotNull
    public String toString() {
        return "GlobalBroadCastConfig(diamond=" + this.diamond + ")";
    }
}
