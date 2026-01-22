package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/qiahao/nextvideo/data/model/VideoCallEndModel;", "", "from_user_id", "", "rong_room_name", "", "to_user_id", "<init>", "(JLjava/lang/String;J)V", "getFrom_user_id", "()J", "getRong_room_name", "()Ljava/lang/String;", "getTo_user_id", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class VideoCallEndModel {

    @c("from_user_id")
    private final long from_user_id;

    @NotNull
    @c("rong_room_name")
    private final String rong_room_name;

    @c("to_user_id")
    private final long to_user_id;

    public VideoCallEndModel(long j, @NotNull String str, long j2) {
        Intrinsics.checkNotNullParameter(str, "rong_room_name");
        this.from_user_id = j;
        this.rong_room_name = str;
        this.to_user_id = j2;
    }

    public static /* synthetic */ VideoCallEndModel copy$default(VideoCallEndModel videoCallEndModel, long j, String str, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = videoCallEndModel.from_user_id;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            str = videoCallEndModel.rong_room_name;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            j2 = videoCallEndModel.to_user_id;
        }
        return videoCallEndModel.copy(j3, str2, j2);
    }

    /* renamed from: component1, reason: from getter */
    public final long getFrom_user_id() {
        return this.from_user_id;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getRong_room_name() {
        return this.rong_room_name;
    }

    /* renamed from: component3, reason: from getter */
    public final long getTo_user_id() {
        return this.to_user_id;
    }

    @NotNull
    public final VideoCallEndModel copy(long from_user_id, @NotNull String rong_room_name, long to_user_id) {
        Intrinsics.checkNotNullParameter(rong_room_name, "rong_room_name");
        return new VideoCallEndModel(from_user_id, rong_room_name, to_user_id);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoCallEndModel)) {
            return false;
        }
        VideoCallEndModel videoCallEndModel = (VideoCallEndModel) other;
        return this.from_user_id == videoCallEndModel.from_user_id && Intrinsics.areEqual(this.rong_room_name, videoCallEndModel.rong_room_name) && this.to_user_id == videoCallEndModel.to_user_id;
    }

    public final long getFrom_user_id() {
        return this.from_user_id;
    }

    @NotNull
    public final String getRong_room_name() {
        return this.rong_room_name;
    }

    public final long getTo_user_id() {
        return this.to_user_id;
    }

    public int hashCode() {
        return (((androidx.collection.c.a(this.from_user_id) * 31) + this.rong_room_name.hashCode()) * 31) + androidx.collection.c.a(this.to_user_id);
    }

    @NotNull
    public String toString() {
        return "VideoCallEndModel(from_user_id=" + this.from_user_id + ", rong_room_name=" + this.rong_room_name + ", to_user_id=" + this.to_user_id + ")";
    }
}
