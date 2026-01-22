package com.qiahao.nextvideo.data.model;

import com.qiahao.nextvideo.room.rank.CommonRoomActiveChildView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J?\u0010\u0015\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/qiahao/nextvideo/data/model/PowerTeamMemberBean;", "", "owers", "", "Lcom/qiahao/nextvideo/data/model/PowerUser;", "assistants", CommonRoomActiveChildView.LAST_WEEK, "Lcom/qiahao/nextvideo/data/model/WeekMedal;", CommonRoomActiveChildView.THIS_WEEK, "<init>", "(Ljava/util/List;Ljava/util/List;Lcom/qiahao/nextvideo/data/model/WeekMedal;Lcom/qiahao/nextvideo/data/model/WeekMedal;)V", "getOwers", "()Ljava/util/List;", "getAssistants", "getLastWeek", "()Lcom/qiahao/nextvideo/data/model/WeekMedal;", "getThisWeek", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class PowerTeamMemberBean {

    @Nullable
    private final List<PowerUser> assistants;

    @NotNull
    private final WeekMedal lastWeek;

    @NotNull
    private final List<PowerUser> owers;

    @NotNull
    private final WeekMedal thisWeek;

    public PowerTeamMemberBean(@NotNull List<PowerUser> list, @Nullable List<PowerUser> list2, @NotNull WeekMedal weekMedal, @NotNull WeekMedal weekMedal2) {
        Intrinsics.checkNotNullParameter(list, "owers");
        Intrinsics.checkNotNullParameter(weekMedal, CommonRoomActiveChildView.LAST_WEEK);
        Intrinsics.checkNotNullParameter(weekMedal2, CommonRoomActiveChildView.THIS_WEEK);
        this.owers = list;
        this.assistants = list2;
        this.lastWeek = weekMedal;
        this.thisWeek = weekMedal2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PowerTeamMemberBean copy$default(PowerTeamMemberBean powerTeamMemberBean, List list, List list2, WeekMedal weekMedal, WeekMedal weekMedal2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = powerTeamMemberBean.owers;
        }
        if ((i & 2) != 0) {
            list2 = powerTeamMemberBean.assistants;
        }
        if ((i & 4) != 0) {
            weekMedal = powerTeamMemberBean.lastWeek;
        }
        if ((i & 8) != 0) {
            weekMedal2 = powerTeamMemberBean.thisWeek;
        }
        return powerTeamMemberBean.copy(list, list2, weekMedal, weekMedal2);
    }

    @NotNull
    public final List<PowerUser> component1() {
        return this.owers;
    }

    @Nullable
    public final List<PowerUser> component2() {
        return this.assistants;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final WeekMedal getLastWeek() {
        return this.lastWeek;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final WeekMedal getThisWeek() {
        return this.thisWeek;
    }

    @NotNull
    public final PowerTeamMemberBean copy(@NotNull List<PowerUser> owers, @Nullable List<PowerUser> assistants, @NotNull WeekMedal lastWeek, @NotNull WeekMedal thisWeek) {
        Intrinsics.checkNotNullParameter(owers, "owers");
        Intrinsics.checkNotNullParameter(lastWeek, CommonRoomActiveChildView.LAST_WEEK);
        Intrinsics.checkNotNullParameter(thisWeek, CommonRoomActiveChildView.THIS_WEEK);
        return new PowerTeamMemberBean(owers, assistants, lastWeek, thisWeek);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PowerTeamMemberBean)) {
            return false;
        }
        PowerTeamMemberBean powerTeamMemberBean = (PowerTeamMemberBean) other;
        return Intrinsics.areEqual(this.owers, powerTeamMemberBean.owers) && Intrinsics.areEqual(this.assistants, powerTeamMemberBean.assistants) && Intrinsics.areEqual(this.lastWeek, powerTeamMemberBean.lastWeek) && Intrinsics.areEqual(this.thisWeek, powerTeamMemberBean.thisWeek);
    }

    @Nullable
    public final List<PowerUser> getAssistants() {
        return this.assistants;
    }

    @NotNull
    public final WeekMedal getLastWeek() {
        return this.lastWeek;
    }

    @NotNull
    public final List<PowerUser> getOwers() {
        return this.owers;
    }

    @NotNull
    public final WeekMedal getThisWeek() {
        return this.thisWeek;
    }

    public int hashCode() {
        int hashCode = this.owers.hashCode() * 31;
        List<PowerUser> list = this.assistants;
        return ((((hashCode + (list == null ? 0 : list.hashCode())) * 31) + this.lastWeek.hashCode()) * 31) + this.thisWeek.hashCode();
    }

    @NotNull
    public String toString() {
        return "PowerTeamMemberBean(owers=" + this.owers + ", assistants=" + this.assistants + ", lastWeek=" + this.lastWeek + ", thisWeek=" + this.thisWeek + ")";
    }
}
