package com.qiahao.nextvideo.data;

import com.qiahao.base_common.model.common.User;
import com.qiahao.nextvideo.ui.fillpersonaldata.neighborhoodsnote.NeighborhoodsNoteViewController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J)\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/qiahao/nextvideo/data/UserObjectEvent;", "", "user", "Lcom/qiahao/base_common/model/common/User;", "timestamp", "", "type", "Lcom/qiahao/nextvideo/data/UserObjectEventType;", "<init>", "(Lcom/qiahao/base_common/model/common/User;JLcom/qiahao/nextvideo/data/UserObjectEventType;)V", "getUser", "()Lcom/qiahao/base_common/model/common/User;", "getTimestamp", "()J", "getType", "()Lcom/qiahao/nextvideo/data/UserObjectEventType;", "isAuthenticated", "", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class UserObjectEvent {
    private final long timestamp;

    @NotNull
    private final UserObjectEventType type;

    @Nullable
    private final User user;

    public UserObjectEvent(@Nullable User user, long j, @NotNull UserObjectEventType userObjectEventType) {
        Intrinsics.checkNotNullParameter(userObjectEventType, "type");
        this.user = user;
        this.timestamp = j;
        this.type = userObjectEventType;
    }

    public static /* synthetic */ UserObjectEvent copy$default(UserObjectEvent userObjectEvent, User user, long j, UserObjectEventType userObjectEventType, int i, Object obj) {
        if ((i & 1) != 0) {
            user = userObjectEvent.user;
        }
        if ((i & 2) != 0) {
            j = userObjectEvent.timestamp;
        }
        if ((i & 4) != 0) {
            userObjectEventType = userObjectEvent.type;
        }
        return userObjectEvent.copy(user, j, userObjectEventType);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* renamed from: component2, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final UserObjectEventType getType() {
        return this.type;
    }

    @NotNull
    public final UserObjectEvent copy(@Nullable User user, long timestamp, @NotNull UserObjectEventType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new UserObjectEvent(user, timestamp, type);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserObjectEvent)) {
            return false;
        }
        UserObjectEvent userObjectEvent = (UserObjectEvent) other;
        return Intrinsics.areEqual(this.user, userObjectEvent.user) && this.timestamp == userObjectEvent.timestamp && this.type == userObjectEvent.type;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    @NotNull
    public final UserObjectEventType getType() {
        return this.type;
    }

    @Nullable
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        User user = this.user;
        return ((((user == null ? 0 : user.hashCode()) * 31) + androidx.collection.c.a(this.timestamp)) * 31) + this.type.hashCode();
    }

    public final boolean isAuthenticated() {
        User user = this.user;
        if (user != null && user.isCompleteMaterial() && NeighborhoodsNoteViewController.INSTANCE.isAgreeNeighborhoodsNote(this.user.getExternalId())) {
            return true;
        }
        return false;
    }

    @NotNull
    public String toString() {
        return "UserObjectEvent(user=" + this.user + ", timestamp=" + this.timestamp + ", type=" + this.type + ")";
    }
}
