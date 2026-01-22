package com.qiahao.nextvideo.data.mainActivity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jh\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017¨\u00063"}, d2 = {"Lcom/qiahao/nextvideo/data/mainActivity/MainActivityData;", "", "activityPopupId", "", "backgroundUrl", "", "deadlineTimestamp", "floatPicUrl", "list", "", "Lcom/qiahao/nextvideo/data/mainActivity/MainActivityItem;", "activityTipText1", "activityTipText2", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getActivityPopupId", "()Ljava/lang/Long;", "setActivityPopupId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getBackgroundUrl", "()Ljava/lang/String;", "setBackgroundUrl", "(Ljava/lang/String;)V", "getDeadlineTimestamp", "setDeadlineTimestamp", "getFloatPicUrl", "setFloatPicUrl", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "getActivityTipText1", "setActivityTipText1", "getActivityTipText2", "setActivityTipText2", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lcom/qiahao/nextvideo/data/mainActivity/MainActivityData;", "equals", "", "other", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class MainActivityData {

    @Nullable
    private Long activityPopupId;

    @Nullable
    private String activityTipText1;

    @Nullable
    private String activityTipText2;

    @Nullable
    private String backgroundUrl;

    @Nullable
    private Long deadlineTimestamp;

    @Nullable
    private String floatPicUrl;

    @Nullable
    private List<MainActivityItem> list;

    public MainActivityData() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ MainActivityData copy$default(MainActivityData mainActivityData, Long l, String str, Long l2, String str2, List list, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            l = mainActivityData.activityPopupId;
        }
        if ((i & 2) != 0) {
            str = mainActivityData.backgroundUrl;
        }
        String str5 = str;
        if ((i & 4) != 0) {
            l2 = mainActivityData.deadlineTimestamp;
        }
        Long l3 = l2;
        if ((i & 8) != 0) {
            str2 = mainActivityData.floatPicUrl;
        }
        String str6 = str2;
        if ((i & 16) != 0) {
            list = mainActivityData.list;
        }
        List list2 = list;
        if ((i & 32) != 0) {
            str3 = mainActivityData.activityTipText1;
        }
        String str7 = str3;
        if ((i & 64) != 0) {
            str4 = mainActivityData.activityTipText2;
        }
        return mainActivityData.copy(l, str5, l3, str6, list2, str7, str4);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Long getActivityPopupId() {
        return this.activityPopupId;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getBackgroundUrl() {
        return this.backgroundUrl;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Long getDeadlineTimestamp() {
        return this.deadlineTimestamp;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getFloatPicUrl() {
        return this.floatPicUrl;
    }

    @Nullable
    public final List<MainActivityItem> component5() {
        return this.list;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getActivityTipText1() {
        return this.activityTipText1;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getActivityTipText2() {
        return this.activityTipText2;
    }

    @NotNull
    public final MainActivityData copy(@Nullable Long activityPopupId, @Nullable String backgroundUrl, @Nullable Long deadlineTimestamp, @Nullable String floatPicUrl, @Nullable List<MainActivityItem> list, @Nullable String activityTipText1, @Nullable String activityTipText2) {
        return new MainActivityData(activityPopupId, backgroundUrl, deadlineTimestamp, floatPicUrl, list, activityTipText1, activityTipText2);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MainActivityData)) {
            return false;
        }
        MainActivityData mainActivityData = (MainActivityData) other;
        return Intrinsics.areEqual(this.activityPopupId, mainActivityData.activityPopupId) && Intrinsics.areEqual(this.backgroundUrl, mainActivityData.backgroundUrl) && Intrinsics.areEqual(this.deadlineTimestamp, mainActivityData.deadlineTimestamp) && Intrinsics.areEqual(this.floatPicUrl, mainActivityData.floatPicUrl) && Intrinsics.areEqual(this.list, mainActivityData.list) && Intrinsics.areEqual(this.activityTipText1, mainActivityData.activityTipText1) && Intrinsics.areEqual(this.activityTipText2, mainActivityData.activityTipText2);
    }

    @Nullable
    public final Long getActivityPopupId() {
        return this.activityPopupId;
    }

    @Nullable
    public final String getActivityTipText1() {
        return this.activityTipText1;
    }

    @Nullable
    public final String getActivityTipText2() {
        return this.activityTipText2;
    }

    @Nullable
    public final String getBackgroundUrl() {
        return this.backgroundUrl;
    }

    @Nullable
    public final Long getDeadlineTimestamp() {
        return this.deadlineTimestamp;
    }

    @Nullable
    public final String getFloatPicUrl() {
        return this.floatPicUrl;
    }

    @Nullable
    public final List<MainActivityItem> getList() {
        return this.list;
    }

    public int hashCode() {
        Long l = this.activityPopupId;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        String str = this.backgroundUrl;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l2 = this.deadlineTimestamp;
        int hashCode3 = (hashCode2 + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str2 = this.floatPicUrl;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<MainActivityItem> list = this.list;
        int hashCode5 = (hashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        String str3 = this.activityTipText1;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.activityTipText2;
        return hashCode6 + (str4 != null ? str4.hashCode() : 0);
    }

    public final void setActivityPopupId(@Nullable Long l) {
        this.activityPopupId = l;
    }

    public final void setActivityTipText1(@Nullable String str) {
        this.activityTipText1 = str;
    }

    public final void setActivityTipText2(@Nullable String str) {
        this.activityTipText2 = str;
    }

    public final void setBackgroundUrl(@Nullable String str) {
        this.backgroundUrl = str;
    }

    public final void setDeadlineTimestamp(@Nullable Long l) {
        this.deadlineTimestamp = l;
    }

    public final void setFloatPicUrl(@Nullable String str) {
        this.floatPicUrl = str;
    }

    public final void setList(@Nullable List<MainActivityItem> list) {
        this.list = list;
    }

    @NotNull
    public String toString() {
        return "MainActivityData(activityPopupId=" + this.activityPopupId + ", backgroundUrl=" + this.backgroundUrl + ", deadlineTimestamp=" + this.deadlineTimestamp + ", floatPicUrl=" + this.floatPicUrl + ", list=" + this.list + ", activityTipText1=" + this.activityTipText1 + ", activityTipText2=" + this.activityTipText2 + ")";
    }

    public MainActivityData(@Nullable Long l, @Nullable String str, @Nullable Long l2, @Nullable String str2, @Nullable List<MainActivityItem> list, @Nullable String str3, @Nullable String str4) {
        this.activityPopupId = l;
        this.backgroundUrl = str;
        this.deadlineTimestamp = l2;
        this.floatPicUrl = str2;
        this.list = list;
        this.activityTipText1 = str3;
        this.activityTipText2 = str4;
    }

    public /* synthetic */ MainActivityData(Long l, String str, Long l2, String str2, List list, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : l2, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : list, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : str4);
    }
}
