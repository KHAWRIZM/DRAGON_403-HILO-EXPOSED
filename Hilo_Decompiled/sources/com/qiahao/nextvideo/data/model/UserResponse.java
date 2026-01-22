package com.qiahao.nextvideo.data.model;

import com.qiahao.base_common.model.common.User;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/qiahao/nextvideo/data/model/UserResponse;", "", "user", "Lcom/qiahao/base_common/model/common/User;", "token", "", "rongCloudToken", "<init>", "(Lcom/qiahao/base_common/model/common/User;Ljava/lang/String;Ljava/lang/String;)V", "getUser", "()Lcom/qiahao/base_common/model/common/User;", "getToken", "()Ljava/lang/String;", "getRongCloudToken", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class UserResponse {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    @c("tencentyunToken")
    private final String rongCloudToken;

    @NotNull
    @c("token")
    private final String token;

    @NotNull
    @c("user")
    private final User user;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/qiahao/nextvideo/data/model/UserResponse$Companion;", "", "<init>", "()V", "fake", "Lcom/qiahao/nextvideo/data/model/UserResponse;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final UserResponse fake() {
            return new UserResponse(User.Companion.fake(), "NA", "N/A");
        }

        private Companion() {
        }
    }

    public UserResponse(@NotNull User user, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(str, "token");
        Intrinsics.checkNotNullParameter(str2, "rongCloudToken");
        this.user = user;
        this.token = str;
        this.rongCloudToken = str2;
    }

    public static /* synthetic */ UserResponse copy$default(UserResponse userResponse, User user, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            user = userResponse.user;
        }
        if ((i & 2) != 0) {
            str = userResponse.token;
        }
        if ((i & 4) != 0) {
            str2 = userResponse.rongCloudToken;
        }
        return userResponse.copy(user, str, str2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getRongCloudToken() {
        return this.rongCloudToken;
    }

    @NotNull
    public final UserResponse copy(@NotNull User user, @NotNull String token, @NotNull String rongCloudToken) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(rongCloudToken, "rongCloudToken");
        return new UserResponse(user, token, rongCloudToken);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserResponse)) {
            return false;
        }
        UserResponse userResponse = (UserResponse) other;
        return Intrinsics.areEqual(this.user, userResponse.user) && Intrinsics.areEqual(this.token, userResponse.token) && Intrinsics.areEqual(this.rongCloudToken, userResponse.rongCloudToken);
    }

    @NotNull
    public final String getRongCloudToken() {
        return this.rongCloudToken;
    }

    @NotNull
    public final String getToken() {
        return this.token;
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        return (((this.user.hashCode() * 31) + this.token.hashCode()) * 31) + this.rongCloudToken.hashCode();
    }

    @NotNull
    public String toString() {
        return "UserResponse(user=" + this.user + ", token=" + this.token + ", rongCloudToken=" + this.rongCloudToken + ")";
    }
}
