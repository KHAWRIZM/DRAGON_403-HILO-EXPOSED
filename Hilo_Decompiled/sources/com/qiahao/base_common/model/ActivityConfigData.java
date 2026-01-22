package com.qiahao.base_common.model;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J'\u0010\f\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001R.\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/qiahao/base_common/model/ActivityConfigData;", "", "recommendBanners", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/util/ArrayList;)V", "getRecommendBanners", "()Ljava/util/ArrayList;", "setRecommendBanners", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class ActivityConfigData {

    @Nullable
    private ArrayList<String> recommendBanners;

    /* JADX WARN: Multi-variable type inference failed */
    public ActivityConfigData() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ActivityConfigData copy$default(ActivityConfigData activityConfigData, ArrayList arrayList, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            arrayList = activityConfigData.recommendBanners;
        }
        return activityConfigData.copy(arrayList);
    }

    @Nullable
    public final ArrayList<String> component1() {
        return this.recommendBanners;
    }

    @NotNull
    public final ActivityConfigData copy(@Nullable ArrayList<String> recommendBanners) {
        return new ActivityConfigData(recommendBanners);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ActivityConfigData) && Intrinsics.areEqual(this.recommendBanners, ((ActivityConfigData) other).recommendBanners);
    }

    @Nullable
    public final ArrayList<String> getRecommendBanners() {
        return this.recommendBanners;
    }

    public int hashCode() {
        ArrayList<String> arrayList = this.recommendBanners;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.hashCode();
    }

    public final void setRecommendBanners(@Nullable ArrayList<String> arrayList) {
        this.recommendBanners = arrayList;
    }

    @NotNull
    public String toString() {
        return "ActivityConfigData(recommendBanners=" + this.recommendBanners + ")";
    }

    public ActivityConfigData(@Nullable ArrayList<String> arrayList) {
        this.recommendBanners = arrayList;
    }

    public /* synthetic */ ActivityConfigData(ArrayList arrayList, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : arrayList);
    }
}
