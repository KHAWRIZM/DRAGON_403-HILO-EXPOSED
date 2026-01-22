package com.qiahao.nextvideo.data.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/qiahao/nextvideo/data/model/UserInfoWithGifts;", "", "user", "Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;", "receivedGifts", "", "Lcom/qiahao/nextvideo/data/model/ReceivedGift;", "<init>", "(Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;Ljava/util/List;)V", "getUser", "()Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;", "getReceivedGifts", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class UserInfoWithGifts {

    @NotNull
    @c("gifts")
    private final List<ReceivedGift> receivedGifts;

    @NotNull
    @c("user")
    private final UserSummaryInfo user;

    public UserInfoWithGifts(@NotNull UserSummaryInfo userSummaryInfo, @NotNull List<ReceivedGift> list) {
        Intrinsics.checkNotNullParameter(userSummaryInfo, "user");
        Intrinsics.checkNotNullParameter(list, "receivedGifts");
        this.user = userSummaryInfo;
        this.receivedGifts = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UserInfoWithGifts copy$default(UserInfoWithGifts userInfoWithGifts, UserSummaryInfo userSummaryInfo, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            userSummaryInfo = userInfoWithGifts.user;
        }
        if ((i & 2) != 0) {
            list = userInfoWithGifts.receivedGifts;
        }
        return userInfoWithGifts.copy(userSummaryInfo, list);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final UserSummaryInfo getUser() {
        return this.user;
    }

    @NotNull
    public final List<ReceivedGift> component2() {
        return this.receivedGifts;
    }

    @NotNull
    public final UserInfoWithGifts copy(@NotNull UserSummaryInfo user, @NotNull List<ReceivedGift> receivedGifts) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(receivedGifts, "receivedGifts");
        return new UserInfoWithGifts(user, receivedGifts);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserInfoWithGifts)) {
            return false;
        }
        UserInfoWithGifts userInfoWithGifts = (UserInfoWithGifts) other;
        return Intrinsics.areEqual(this.user, userInfoWithGifts.user) && Intrinsics.areEqual(this.receivedGifts, userInfoWithGifts.receivedGifts);
    }

    @NotNull
    public final List<ReceivedGift> getReceivedGifts() {
        return this.receivedGifts;
    }

    @NotNull
    public final UserSummaryInfo getUser() {
        return this.user;
    }

    public int hashCode() {
        return (this.user.hashCode() * 31) + this.receivedGifts.hashCode();
    }

    @NotNull
    public String toString() {
        return "UserInfoWithGifts(user=" + this.user + ", receivedGifts=" + this.receivedGifts + ")";
    }
}
