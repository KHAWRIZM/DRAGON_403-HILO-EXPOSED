package com.qiahao.nextvideo.data.tab;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001 B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J7\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/qiahao/nextvideo/data/tab/TaskTabData;", "", "selectColor", "", "defaultColor", "title", "unlock", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getSelectColor", "()Ljava/lang/String;", "setSelectColor", "(Ljava/lang/String;)V", "getDefaultColor", "setDefaultColor", "getTitle", "setTitle", "getUnlock", "()Z", "setUnlock", "(Z)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class TaskTabData {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private String defaultColor;

    @Nullable
    private String selectColor;

    @Nullable
    private String title;
    private boolean unlock;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/data/tab/TaskTabData$Companion;", "", "<init>", "()V", "initDefault", "Lcom/qiahao/nextvideo/data/tab/TaskTabData;", "title", "", "isLock", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final TaskTabData initDefault(@Nullable String title, boolean isLock) {
            return new TaskTabData("#ffffff", "#ffffff", title, isLock);
        }

        private Companion() {
        }
    }

    public TaskTabData() {
        this(null, null, null, false, 15, null);
    }

    public static /* synthetic */ TaskTabData copy$default(TaskTabData taskTabData, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = taskTabData.selectColor;
        }
        if ((i & 2) != 0) {
            str2 = taskTabData.defaultColor;
        }
        if ((i & 4) != 0) {
            str3 = taskTabData.title;
        }
        if ((i & 8) != 0) {
            z = taskTabData.unlock;
        }
        return taskTabData.copy(str, str2, str3, z);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getSelectColor() {
        return this.selectColor;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getDefaultColor() {
        return this.defaultColor;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getUnlock() {
        return this.unlock;
    }

    @NotNull
    public final TaskTabData copy(@Nullable String selectColor, @Nullable String defaultColor, @Nullable String title, boolean unlock) {
        return new TaskTabData(selectColor, defaultColor, title, unlock);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskTabData)) {
            return false;
        }
        TaskTabData taskTabData = (TaskTabData) other;
        return Intrinsics.areEqual(this.selectColor, taskTabData.selectColor) && Intrinsics.areEqual(this.defaultColor, taskTabData.defaultColor) && Intrinsics.areEqual(this.title, taskTabData.title) && this.unlock == taskTabData.unlock;
    }

    @Nullable
    public final String getDefaultColor() {
        return this.defaultColor;
    }

    @Nullable
    public final String getSelectColor() {
        return this.selectColor;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public final boolean getUnlock() {
        return this.unlock;
    }

    public int hashCode() {
        String str = this.selectColor;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.defaultColor;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.title;
        return ((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + a.a(this.unlock);
    }

    public final void setDefaultColor(@Nullable String str) {
        this.defaultColor = str;
    }

    public final void setSelectColor(@Nullable String str) {
        this.selectColor = str;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    public final void setUnlock(boolean z) {
        this.unlock = z;
    }

    @NotNull
    public String toString() {
        return "TaskTabData(selectColor=" + this.selectColor + ", defaultColor=" + this.defaultColor + ", title=" + this.title + ", unlock=" + this.unlock + ")";
    }

    public TaskTabData(@Nullable String str, @Nullable String str2, @Nullable String str3, boolean z) {
        this.selectColor = str;
        this.defaultColor = str2;
        this.title = str3;
        this.unlock = z;
    }

    public /* synthetic */ TaskTabData(String str, String str2, String str3, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? false : z);
    }
}
