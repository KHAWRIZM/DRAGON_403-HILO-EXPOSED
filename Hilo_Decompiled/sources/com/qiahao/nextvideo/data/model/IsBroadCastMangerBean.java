package com.qiahao.nextvideo.data.model;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 /2\u00020\u0001:\u0001/BY\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0006J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\u001d\u0010'\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\nHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\fHÆ\u0003J[\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010*\u001a\u00020\u00032\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0006HÖ\u0001J\t\u0010-\u001a\u00020.HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u000f\"\u0004\b\u0012\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R.\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u00060"}, d2 = {"Lcom/qiahao/nextvideo/data/model/IsBroadCastMangerBean;", "", "isManager", "", "isPinned", "dayUnLockTimes", "", "monthUnLockTimes", "items", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "svipCheck", "Lcom/qiahao/nextvideo/data/model/SvipCheckData;", "<init>", "(ZZIILjava/util/ArrayList;Lcom/qiahao/nextvideo/data/model/SvipCheckData;)V", "()Z", "setManager", "(Z)V", "setPinned", "getDayUnLockTimes", "()I", "setDayUnLockTimes", "(I)V", "getMonthUnLockTimes", "setMonthUnLockTimes", "getItems", "()Ljava/util/ArrayList;", "setItems", "(Ljava/util/ArrayList;)V", "getSvipCheck", "()Lcom/qiahao/nextvideo/data/model/SvipCheckData;", "setSvipCheck", "(Lcom/qiahao/nextvideo/data/model/SvipCheckData;)V", "checkPermission", "permission", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nIsBroadCastMangerBean.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IsBroadCastMangerBean.kt\ncom/qiahao/nextvideo/data/model/IsBroadCastMangerBean\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,33:1\n1869#2,2:34\n*S KotlinDebug\n*F\n+ 1 IsBroadCastMangerBean.kt\ncom/qiahao/nextvideo/data/model/IsBroadCastMangerBean\n*L\n28#1:34,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class IsBroadCastMangerBean {
    public static final int TYPE_1 = 1;
    public static final int TYPE_2 = 2;
    public static final int TYPE_3 = 3;
    public static final int TYPE_4 = 4;
    public static final int TYPE_5 = 5;
    private int dayUnLockTimes;
    private boolean isManager;
    private boolean isPinned;

    @Nullable
    private ArrayList<Integer> items;
    private int monthUnLockTimes;

    @Nullable
    private SvipCheckData svipCheck;

    public IsBroadCastMangerBean() {
        this(false, false, 0, 0, null, null, 63, null);
    }

    public static /* synthetic */ IsBroadCastMangerBean copy$default(IsBroadCastMangerBean isBroadCastMangerBean, boolean z, boolean z2, int i, int i2, ArrayList arrayList, SvipCheckData svipCheckData, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = isBroadCastMangerBean.isManager;
        }
        if ((i3 & 2) != 0) {
            z2 = isBroadCastMangerBean.isPinned;
        }
        boolean z3 = z2;
        if ((i3 & 4) != 0) {
            i = isBroadCastMangerBean.dayUnLockTimes;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = isBroadCastMangerBean.monthUnLockTimes;
        }
        int i5 = i2;
        if ((i3 & 16) != 0) {
            arrayList = isBroadCastMangerBean.items;
        }
        ArrayList arrayList2 = arrayList;
        if ((i3 & 32) != 0) {
            svipCheckData = isBroadCastMangerBean.svipCheck;
        }
        return isBroadCastMangerBean.copy(z, z3, i4, i5, arrayList2, svipCheckData);
    }

    public final boolean checkPermission(int permission) {
        ArrayList<Integer> arrayList = this.items;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                if (((Number) it.next()).intValue() == permission) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsManager() {
        return this.isManager;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsPinned() {
        return this.isPinned;
    }

    /* renamed from: component3, reason: from getter */
    public final int getDayUnLockTimes() {
        return this.dayUnLockTimes;
    }

    /* renamed from: component4, reason: from getter */
    public final int getMonthUnLockTimes() {
        return this.monthUnLockTimes;
    }

    @Nullable
    public final ArrayList<Integer> component5() {
        return this.items;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final SvipCheckData getSvipCheck() {
        return this.svipCheck;
    }

    @NotNull
    public final IsBroadCastMangerBean copy(boolean isManager, boolean isPinned, int dayUnLockTimes, int monthUnLockTimes, @Nullable ArrayList<Integer> items, @Nullable SvipCheckData svipCheck) {
        return new IsBroadCastMangerBean(isManager, isPinned, dayUnLockTimes, monthUnLockTimes, items, svipCheck);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IsBroadCastMangerBean)) {
            return false;
        }
        IsBroadCastMangerBean isBroadCastMangerBean = (IsBroadCastMangerBean) other;
        return this.isManager == isBroadCastMangerBean.isManager && this.isPinned == isBroadCastMangerBean.isPinned && this.dayUnLockTimes == isBroadCastMangerBean.dayUnLockTimes && this.monthUnLockTimes == isBroadCastMangerBean.monthUnLockTimes && Intrinsics.areEqual(this.items, isBroadCastMangerBean.items) && Intrinsics.areEqual(this.svipCheck, isBroadCastMangerBean.svipCheck);
    }

    public final int getDayUnLockTimes() {
        return this.dayUnLockTimes;
    }

    @Nullable
    public final ArrayList<Integer> getItems() {
        return this.items;
    }

    public final int getMonthUnLockTimes() {
        return this.monthUnLockTimes;
    }

    @Nullable
    public final SvipCheckData getSvipCheck() {
        return this.svipCheck;
    }

    public int hashCode() {
        int a = ((((((a.a(this.isManager) * 31) + a.a(this.isPinned)) * 31) + this.dayUnLockTimes) * 31) + this.monthUnLockTimes) * 31;
        ArrayList<Integer> arrayList = this.items;
        int hashCode = (a + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        SvipCheckData svipCheckData = this.svipCheck;
        return hashCode + (svipCheckData != null ? svipCheckData.hashCode() : 0);
    }

    public final boolean isManager() {
        return this.isManager;
    }

    public final boolean isPinned() {
        return this.isPinned;
    }

    public final void setDayUnLockTimes(int i) {
        this.dayUnLockTimes = i;
    }

    public final void setItems(@Nullable ArrayList<Integer> arrayList) {
        this.items = arrayList;
    }

    public final void setManager(boolean z) {
        this.isManager = z;
    }

    public final void setMonthUnLockTimes(int i) {
        this.monthUnLockTimes = i;
    }

    public final void setPinned(boolean z) {
        this.isPinned = z;
    }

    public final void setSvipCheck(@Nullable SvipCheckData svipCheckData) {
        this.svipCheck = svipCheckData;
    }

    @NotNull
    public String toString() {
        return "IsBroadCastMangerBean(isManager=" + this.isManager + ", isPinned=" + this.isPinned + ", dayUnLockTimes=" + this.dayUnLockTimes + ", monthUnLockTimes=" + this.monthUnLockTimes + ", items=" + this.items + ", svipCheck=" + this.svipCheck + ")";
    }

    public IsBroadCastMangerBean(boolean z, boolean z2, int i, int i2, @Nullable ArrayList<Integer> arrayList, @Nullable SvipCheckData svipCheckData) {
        this.isManager = z;
        this.isPinned = z2;
        this.dayUnLockTimes = i;
        this.monthUnLockTimes = i2;
        this.items = arrayList;
        this.svipCheck = svipCheckData;
    }

    public /* synthetic */ IsBroadCastMangerBean(boolean z, boolean z2, int i, int i2, ArrayList arrayList, SvipCheckData svipCheckData, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z, (i3 & 2) != 0 ? false : z2, (i3 & 4) != 0 ? 0 : i, (i3 & 8) == 0 ? i2 : 0, (i3 & 16) != 0 ? null : arrayList, (i3 & 32) != 0 ? null : svipCheckData);
    }
}
