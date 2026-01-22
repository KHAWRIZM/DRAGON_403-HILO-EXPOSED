package com.qiahao.nextvideo.data.task;

import com.taobao.accs.common.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b*\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010'\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010)\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010*\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010+\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010-\u001a\u0004\u0018\u00010\nHÆ\u0003Jj\u0010.\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u00020\b2\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u0004HÖ\u0001J\t\u00103\u001a\u00020\nHÖ\u0001R$\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b#\u0010\u001b\"\u0004\b$\u0010\u001dR\u001c\u0010\f\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"¨\u00064"}, d2 = {"Lcom/qiahao/nextvideo/data/task/TaskProcess;", "", "awards", "", "", "days", "level", Constants.KEY_SECURITY_SIGN, "", "title", "", "unlock", "unlockDesc", "<init>", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getAwards", "()Ljava/util/List;", "setAwards", "(Ljava/util/List;)V", "getDays", "()Ljava/lang/Integer;", "setDays", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getLevel", "setLevel", "getSign", "()Ljava/lang/Boolean;", "setSign", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getUnlock", "setUnlock", "getUnlockDesc", "setUnlockDesc", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/qiahao/nextvideo/data/task/TaskProcess;", "equals", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class TaskProcess {

    @Nullable
    private List<Integer> awards;

    @Nullable
    private Integer days;

    @Nullable
    private Integer level;

    @Nullable
    private Boolean sign;

    @Nullable
    private String title;

    @Nullable
    private Boolean unlock;

    @Nullable
    private String unlockDesc;

    public TaskProcess() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ TaskProcess copy$default(TaskProcess taskProcess, List list, Integer num, Integer num2, Boolean bool, String str, Boolean bool2, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = taskProcess.awards;
        }
        if ((i & 2) != 0) {
            num = taskProcess.days;
        }
        Integer num3 = num;
        if ((i & 4) != 0) {
            num2 = taskProcess.level;
        }
        Integer num4 = num2;
        if ((i & 8) != 0) {
            bool = taskProcess.sign;
        }
        Boolean bool3 = bool;
        if ((i & 16) != 0) {
            str = taskProcess.title;
        }
        String str3 = str;
        if ((i & 32) != 0) {
            bool2 = taskProcess.unlock;
        }
        Boolean bool4 = bool2;
        if ((i & 64) != 0) {
            str2 = taskProcess.unlockDesc;
        }
        return taskProcess.copy(list, num3, num4, bool3, str3, bool4, str2);
    }

    @Nullable
    public final List<Integer> component1() {
        return this.awards;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getDays() {
        return this.days;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Integer getLevel() {
        return this.level;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Boolean getSign() {
        return this.sign;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Boolean getUnlock() {
        return this.unlock;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getUnlockDesc() {
        return this.unlockDesc;
    }

    @NotNull
    public final TaskProcess copy(@Nullable List<Integer> awards, @Nullable Integer days, @Nullable Integer level, @Nullable Boolean sign, @Nullable String title, @Nullable Boolean unlock, @Nullable String unlockDesc) {
        return new TaskProcess(awards, days, level, sign, title, unlock, unlockDesc);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskProcess)) {
            return false;
        }
        TaskProcess taskProcess = (TaskProcess) other;
        return Intrinsics.areEqual(this.awards, taskProcess.awards) && Intrinsics.areEqual(this.days, taskProcess.days) && Intrinsics.areEqual(this.level, taskProcess.level) && Intrinsics.areEqual(this.sign, taskProcess.sign) && Intrinsics.areEqual(this.title, taskProcess.title) && Intrinsics.areEqual(this.unlock, taskProcess.unlock) && Intrinsics.areEqual(this.unlockDesc, taskProcess.unlockDesc);
    }

    @Nullable
    public final List<Integer> getAwards() {
        return this.awards;
    }

    @Nullable
    public final Integer getDays() {
        return this.days;
    }

    @Nullable
    public final Integer getLevel() {
        return this.level;
    }

    @Nullable
    public final Boolean getSign() {
        return this.sign;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final Boolean getUnlock() {
        return this.unlock;
    }

    @Nullable
    public final String getUnlockDesc() {
        return this.unlockDesc;
    }

    public int hashCode() {
        List<Integer> list = this.awards;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        Integer num = this.days;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.level;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool = this.sign;
        int hashCode4 = (hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str = this.title;
        int hashCode5 = (hashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool2 = this.unlock;
        int hashCode6 = (hashCode5 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str2 = this.unlockDesc;
        return hashCode6 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setAwards(@Nullable List<Integer> list) {
        this.awards = list;
    }

    public final void setDays(@Nullable Integer num) {
        this.days = num;
    }

    public final void setLevel(@Nullable Integer num) {
        this.level = num;
    }

    public final void setSign(@Nullable Boolean bool) {
        this.sign = bool;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    public final void setUnlock(@Nullable Boolean bool) {
        this.unlock = bool;
    }

    public final void setUnlockDesc(@Nullable String str) {
        this.unlockDesc = str;
    }

    @NotNull
    public String toString() {
        return "TaskProcess(awards=" + this.awards + ", days=" + this.days + ", level=" + this.level + ", sign=" + this.sign + ", title=" + this.title + ", unlock=" + this.unlock + ", unlockDesc=" + this.unlockDesc + ")";
    }

    public TaskProcess(@Nullable List<Integer> list, @Nullable Integer num, @Nullable Integer num2, @Nullable Boolean bool, @Nullable String str, @Nullable Boolean bool2, @Nullable String str2) {
        this.awards = list;
        this.days = num;
        this.level = num2;
        this.sign = bool;
        this.title = str;
        this.unlock = bool2;
        this.unlockDesc = str2;
    }

    public /* synthetic */ TaskProcess(List list, Integer num, Integer num2, Boolean bool, String str, Boolean bool2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : str, (i & 32) != 0 ? null : bool2, (i & 64) != 0 ? null : str2);
    }
}
