package com.qiahao.nextvideo.data.model;

import com.tencent.qcloud.tuicore.TUIConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001 B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J=\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/qiahao/nextvideo/data/model/FeedbackElem;", "", "image", "", AgooConstants.MESSAGE_ID, "", TUIConstants.TUILive.USER_ID, "createdAt", "detail", "<init>", "(Ljava/lang/String;JJJLjava/lang/String;)V", "getImage", "()Ljava/lang/String;", "getId", "()J", "getUserId", "getCreatedAt", "getDetail", "setDetail", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class FeedbackElem {

    @c("created_at")
    private final long createdAt;

    @NotNull
    @c("detail")
    private String detail;

    @c(AgooConstants.MESSAGE_ID)
    private final long id;

    @Nullable
    @c("image")
    private final String image;

    @c("user_id")
    private final long userId;

    public FeedbackElem(@Nullable String str, long j, long j2, long j3, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str2, "detail");
        this.image = str;
        this.id = j;
        this.userId = j2;
        this.createdAt = j3;
        this.detail = str2;
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    /* renamed from: component2, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component3, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    /* renamed from: component4, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getDetail() {
        return this.detail;
    }

    @NotNull
    public final FeedbackElem copy(@Nullable String image, long id2, long userId, long createdAt, @NotNull String detail) {
        Intrinsics.checkNotNullParameter(detail, "detail");
        return new FeedbackElem(image, id2, userId, createdAt, detail);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeedbackElem)) {
            return false;
        }
        FeedbackElem feedbackElem = (FeedbackElem) other;
        return Intrinsics.areEqual(this.image, feedbackElem.image) && this.id == feedbackElem.id && this.userId == feedbackElem.userId && this.createdAt == feedbackElem.createdAt && Intrinsics.areEqual(this.detail, feedbackElem.detail);
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    @NotNull
    public final String getDetail() {
        return this.detail;
    }

    public final long getId() {
        return this.id;
    }

    @Nullable
    public final String getImage() {
        return this.image;
    }

    public final long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        String str = this.image;
        return ((((((((str == null ? 0 : str.hashCode()) * 31) + androidx.collection.c.a(this.id)) * 31) + androidx.collection.c.a(this.userId)) * 31) + androidx.collection.c.a(this.createdAt)) * 31) + this.detail.hashCode();
    }

    public final void setDetail(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.detail = str;
    }

    @NotNull
    public String toString() {
        return "FeedbackElem(image=" + this.image + ", id=" + this.id + ", userId=" + this.userId + ", createdAt=" + this.createdAt + ", detail=" + this.detail + ")";
    }

    public /* synthetic */ FeedbackElem(String str, long j, long j2, long j3, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, j, j2, j3, (i & 16) != 0 ? "" : str2);
    }
}
