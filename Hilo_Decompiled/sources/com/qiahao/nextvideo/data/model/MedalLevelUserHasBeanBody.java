package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/qiahao/nextvideo/data/model/MedalLevelUserHasBeanBody;", "", "num", "", "medals", "", "Lcom/qiahao/nextvideo/data/model/MedalLevelUserHasBean;", "<init>", "(JLjava/util/List;)V", "getNum", "()J", "getMedals", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class MedalLevelUserHasBeanBody {

    @NotNull
    private final List<MedalLevelUserHasBean> medals;
    private final long num;

    public MedalLevelUserHasBeanBody(long j, @NotNull List<MedalLevelUserHasBean> list) {
        Intrinsics.checkNotNullParameter(list, "medals");
        this.num = j;
        this.medals = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MedalLevelUserHasBeanBody copy$default(MedalLevelUserHasBeanBody medalLevelUserHasBeanBody, long j, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            j = medalLevelUserHasBeanBody.num;
        }
        if ((i & 2) != 0) {
            list = medalLevelUserHasBeanBody.medals;
        }
        return medalLevelUserHasBeanBody.copy(j, list);
    }

    /* renamed from: component1, reason: from getter */
    public final long getNum() {
        return this.num;
    }

    @NotNull
    public final List<MedalLevelUserHasBean> component2() {
        return this.medals;
    }

    @NotNull
    public final MedalLevelUserHasBeanBody copy(long num, @NotNull List<MedalLevelUserHasBean> medals) {
        Intrinsics.checkNotNullParameter(medals, "medals");
        return new MedalLevelUserHasBeanBody(num, medals);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MedalLevelUserHasBeanBody)) {
            return false;
        }
        MedalLevelUserHasBeanBody medalLevelUserHasBeanBody = (MedalLevelUserHasBeanBody) other;
        return this.num == medalLevelUserHasBeanBody.num && Intrinsics.areEqual(this.medals, medalLevelUserHasBeanBody.medals);
    }

    @NotNull
    public final List<MedalLevelUserHasBean> getMedals() {
        return this.medals;
    }

    public final long getNum() {
        return this.num;
    }

    public int hashCode() {
        return (c.a(this.num) * 31) + this.medals.hashCode();
    }

    @NotNull
    public String toString() {
        return "MedalLevelUserHasBeanBody(num=" + this.num + ", medals=" + this.medals + ")";
    }
}
