package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\t\u0010'\u001a\u00020\rHÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\rHÆ\u0003Jq\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\rHÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\rHÖ\u0001J\t\u00100\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u0011\u0010\u000f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001c¨\u00061"}, d2 = {"Lcom/qiahao/nextvideo/data/model/TasksListBean;", "Ljava/io/Serializable;", "currentScore", "", TUIConstants.TUIChat.INPUT_MORE_ICON, "", AgooConstants.MESSAGE_ID, "name", "groupId", "scoreStage", "", "Lcom/qiahao/nextvideo/data/model/ScoreStageListBean;", "taskStatus", "", "totalScore", "type", "<init>", "(JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/util/List;IJI)V", "getCurrentScore", "()J", "getIcon", "()Ljava/lang/String;", "getId", "getName", "getGroupId", "getScoreStage", "()Ljava/util/List;", "getTaskStatus", "()I", "setTaskStatus", "(I)V", "getTotalScore", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class TasksListBean implements Serializable {
    private final long currentScore;

    @Nullable
    private final String groupId;

    @Nullable
    private final String icon;
    private final long id;

    @Nullable
    private final String name;

    @Nullable
    private final List<ScoreStageListBean> scoreStage;
    private int taskStatus;
    private final long totalScore;
    private final int type;

    public TasksListBean(long j, @Nullable String str, long j2, @Nullable String str2, @Nullable String str3, @Nullable List<ScoreStageListBean> list, int i, long j3, int i2) {
        this.currentScore = j;
        this.icon = str;
        this.id = j2;
        this.name = str2;
        this.groupId = str3;
        this.scoreStage = list;
        this.taskStatus = i;
        this.totalScore = j3;
        this.type = i2;
    }

    /* renamed from: component1, reason: from getter */
    public final long getCurrentScore() {
        return this.currentScore;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: component3, reason: from getter */
    public final long getId() {
        return this.id;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    public final List<ScoreStageListBean> component6() {
        return this.scoreStage;
    }

    /* renamed from: component7, reason: from getter */
    public final int getTaskStatus() {
        return this.taskStatus;
    }

    /* renamed from: component8, reason: from getter */
    public final long getTotalScore() {
        return this.totalScore;
    }

    /* renamed from: component9, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @NotNull
    public final TasksListBean copy(long currentScore, @Nullable String icon, long id2, @Nullable String name, @Nullable String groupId, @Nullable List<ScoreStageListBean> scoreStage, int taskStatus, long totalScore, int type) {
        return new TasksListBean(currentScore, icon, id2, name, groupId, scoreStage, taskStatus, totalScore, type);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TasksListBean)) {
            return false;
        }
        TasksListBean tasksListBean = (TasksListBean) other;
        return this.currentScore == tasksListBean.currentScore && Intrinsics.areEqual(this.icon, tasksListBean.icon) && this.id == tasksListBean.id && Intrinsics.areEqual(this.name, tasksListBean.name) && Intrinsics.areEqual(this.groupId, tasksListBean.groupId) && Intrinsics.areEqual(this.scoreStage, tasksListBean.scoreStage) && this.taskStatus == tasksListBean.taskStatus && this.totalScore == tasksListBean.totalScore && this.type == tasksListBean.type;
    }

    public final long getCurrentScore() {
        return this.currentScore;
    }

    @Nullable
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    public final String getIcon() {
        return this.icon;
    }

    public final long getId() {
        return this.id;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final List<ScoreStageListBean> getScoreStage() {
        return this.scoreStage;
    }

    public final int getTaskStatus() {
        return this.taskStatus;
    }

    public final long getTotalScore() {
        return this.totalScore;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int a = c.a(this.currentScore) * 31;
        String str = this.icon;
        int hashCode = (((a + (str == null ? 0 : str.hashCode())) * 31) + c.a(this.id)) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.groupId;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<ScoreStageListBean> list = this.scoreStage;
        return ((((((hashCode3 + (list != null ? list.hashCode() : 0)) * 31) + this.taskStatus) * 31) + c.a(this.totalScore)) * 31) + this.type;
    }

    public final void setTaskStatus(int i) {
        this.taskStatus = i;
    }

    @NotNull
    public String toString() {
        return "TasksListBean(currentScore=" + this.currentScore + ", icon=" + this.icon + ", id=" + this.id + ", name=" + this.name + ", groupId=" + this.groupId + ", scoreStage=" + this.scoreStage + ", taskStatus=" + this.taskStatus + ", totalScore=" + this.totalScore + ", type=" + this.type + ")";
    }

    public /* synthetic */ TasksListBean(long j, String str, long j2, String str2, String str3, List list, int i, long j3, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j, (i3 & 2) != 0 ? null : str, j2, (i3 & 8) != 0 ? null : str2, (i3 & 16) != 0 ? null : str3, (i3 & 32) != 0 ? null : list, i, (i3 & 128) != 0 ? 0L : j3, i2);
    }
}
