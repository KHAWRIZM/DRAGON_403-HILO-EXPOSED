package com.qiahao.nextvideo.data.model;

import com.qiahao.base_common.model.common.User;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/qiahao/nextvideo/data/model/ConversationItem;", "", "user", "Lcom/qiahao/base_common/model/common/User;", "heartValue", "", "imOnlineStatus", "heartValueMax", "<init>", "(Lcom/qiahao/base_common/model/common/User;III)V", "getUser", "()Lcom/qiahao/base_common/model/common/User;", "getHeartValue", "()I", "getImOnlineStatus", "getHeartValueMax", "heartPer", "getHeartPer", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class ConversationItem {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @c("heartValue")
    private final int heartValue;

    @c("heartValueMax")
    private final int heartValueMax;

    @c("imOnlineStatus")
    private final int imOnlineStatus;

    @Nullable
    @c("userBase")
    private final User user;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/qiahao/nextvideo/data/model/ConversationItem$Companion;", "", "<init>", "()V", "fakeForList", "", "Lcom/qiahao/nextvideo/data/model/ConversationItem;", "pageSize", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nConversationListResponse.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConversationListResponse.kt\ncom/qiahao/nextvideo/data/model/ConversationItem$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,42:1\n1563#2:43\n1634#2,3:44\n*S KotlinDebug\n*F\n+ 1 ConversationListResponse.kt\ncom/qiahao/nextvideo/data/model/ConversationItem$Companion\n*L\n23#1:43\n23#1:44,3\n*E\n"})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final List<ConversationItem> fakeForList(int pageSize) {
            IntRange intRange = new IntRange(0, pageSize);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
            IntIterator it = intRange.iterator();
            while (it.hasNext()) {
                it.nextInt();
                arrayList.add(new ConversationItem(User.Companion.fake(), 0, 0, 0, 14, null));
            }
            return arrayList;
        }

        private Companion() {
        }
    }

    public ConversationItem() {
        this(null, 0, 0, 0, 15, null);
    }

    public static /* synthetic */ ConversationItem copy$default(ConversationItem conversationItem, User user, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            user = conversationItem.user;
        }
        if ((i4 & 2) != 0) {
            i = conversationItem.heartValue;
        }
        if ((i4 & 4) != 0) {
            i2 = conversationItem.imOnlineStatus;
        }
        if ((i4 & 8) != 0) {
            i3 = conversationItem.heartValueMax;
        }
        return conversationItem.copy(user, i, i2, i3);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* renamed from: component2, reason: from getter */
    public final int getHeartValue() {
        return this.heartValue;
    }

    /* renamed from: component3, reason: from getter */
    public final int getImOnlineStatus() {
        return this.imOnlineStatus;
    }

    /* renamed from: component4, reason: from getter */
    public final int getHeartValueMax() {
        return this.heartValueMax;
    }

    @NotNull
    public final ConversationItem copy(@Nullable User user, int heartValue, int imOnlineStatus, int heartValueMax) {
        return new ConversationItem(user, heartValue, imOnlineStatus, heartValueMax);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConversationItem)) {
            return false;
        }
        ConversationItem conversationItem = (ConversationItem) other;
        return Intrinsics.areEqual(this.user, conversationItem.user) && this.heartValue == conversationItem.heartValue && this.imOnlineStatus == conversationItem.imOnlineStatus && this.heartValueMax == conversationItem.heartValueMax;
    }

    public final int getHeartPer() {
        int i = this.heartValueMax;
        if (i > 0) {
            return (int) ((this.heartValue / i) * 100.0f);
        }
        return -1;
    }

    public final int getHeartValue() {
        return this.heartValue;
    }

    public final int getHeartValueMax() {
        return this.heartValueMax;
    }

    public final int getImOnlineStatus() {
        return this.imOnlineStatus;
    }

    @Nullable
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        User user = this.user;
        return ((((((user == null ? 0 : user.hashCode()) * 31) + this.heartValue) * 31) + this.imOnlineStatus) * 31) + this.heartValueMax;
    }

    @NotNull
    public String toString() {
        return "ConversationItem(user=" + this.user + ", heartValue=" + this.heartValue + ", imOnlineStatus=" + this.imOnlineStatus + ", heartValueMax=" + this.heartValueMax + ")";
    }

    public ConversationItem(@Nullable User user, int i, int i2, int i3) {
        this.user = user;
        this.heartValue = i;
        this.imOnlineStatus = i2;
        this.heartValueMax = i3;
    }

    public /* synthetic */ ConversationItem(User user, int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : user, (i4 & 2) != 0 ? 0 : i, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? 1 : i3);
    }
}
