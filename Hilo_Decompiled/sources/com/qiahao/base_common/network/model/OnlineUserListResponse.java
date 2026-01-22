package com.qiahao.base_common.network.model;

import androidx.annotation.Keep;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.ServerProtocol;
import com.qiahao.base_common.model.common.User;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;

@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0001 B7\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003JC\u0010\u001a\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\bHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\n\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006!"}, d2 = {"Lcom/qiahao/base_common/network/model/OnlineUserListResponse;", "", "list", "", "Lcom/qiahao/base_common/model/common/User;", ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, "", "lastIndex", "", DeviceRequestsHelper.DEVICE_INFO_MODEL, "firstIndex", "<init>", "(Ljava/util/List;Ljava/lang/String;III)V", "getList", "()Ljava/util/List;", "getVersion", "()Ljava/lang/String;", "getLastIndex", "()I", "getModel", "getFirstIndex", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class OnlineUserListResponse {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @c("firstIndex")
    private final int firstIndex;

    @c("lastIndex")
    private final int lastIndex;

    @NotNull
    @c("userDetail")
    private final List<User> list;

    @c(DeviceRequestsHelper.DEVICE_INFO_MODEL)
    private final int model;

    @Nullable
    @c(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION)
    private final String version;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Lcom/qiahao/base_common/network/model/OnlineUserListResponse$Companion;", "", "<init>", "()V", "fake", "Lcom/qiahao/base_common/network/model/OnlineUserListResponse;", DeviceRequestsHelper.DEVICE_INFO_MODEL, "", "pageSize", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nListResponse.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListResponse.kt\ncom/qiahao/base_common/network/model/OnlineUserListResponse$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,60:1\n1563#2:61\n1634#2,3:62\n*S KotlinDebug\n*F\n+ 1 ListResponse.kt\ncom/qiahao/base_common/network/model/OnlineUserListResponse$Companion\n*L\n27#1:61\n27#1:62,3\n*E\n"})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final OnlineUserListResponse fake(int model, int pageSize) {
            IntRange until = RangesKt.until(0, pageSize);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
            Iterator<Integer> it = until.iterator();
            while (it.hasNext()) {
                ((IntIterator) it).nextInt();
                arrayList.add(User.INSTANCE.fake());
            }
            return new OnlineUserListResponse(arrayList, null, 0, model, 0);
        }

        private Companion() {
        }
    }

    public OnlineUserListResponse(@NotNull List<User> list, @Nullable String str, int i10, int i11, int i12) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.list = list;
        this.version = str;
        this.lastIndex = i10;
        this.model = i11;
        this.firstIndex = i12;
    }

    public static /* synthetic */ OnlineUserListResponse copy$default(OnlineUserListResponse onlineUserListResponse, List list, String str, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            list = onlineUserListResponse.list;
        }
        if ((i13 & 2) != 0) {
            str = onlineUserListResponse.version;
        }
        String str2 = str;
        if ((i13 & 4) != 0) {
            i10 = onlineUserListResponse.lastIndex;
        }
        int i14 = i10;
        if ((i13 & 8) != 0) {
            i11 = onlineUserListResponse.model;
        }
        int i15 = i11;
        if ((i13 & 16) != 0) {
            i12 = onlineUserListResponse.firstIndex;
        }
        return onlineUserListResponse.copy(list, str2, i14, i15, i12);
    }

    @NotNull
    public final List<User> component1() {
        return this.list;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* renamed from: component3, reason: from getter */
    public final int getLastIndex() {
        return this.lastIndex;
    }

    /* renamed from: component4, reason: from getter */
    public final int getModel() {
        return this.model;
    }

    /* renamed from: component5, reason: from getter */
    public final int getFirstIndex() {
        return this.firstIndex;
    }

    @NotNull
    public final OnlineUserListResponse copy(@NotNull List<User> list, @Nullable String version, int lastIndex, int model, int firstIndex) {
        Intrinsics.checkNotNullParameter(list, "list");
        return new OnlineUserListResponse(list, version, lastIndex, model, firstIndex);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OnlineUserListResponse)) {
            return false;
        }
        OnlineUserListResponse onlineUserListResponse = (OnlineUserListResponse) other;
        return Intrinsics.areEqual(this.list, onlineUserListResponse.list) && Intrinsics.areEqual(this.version, onlineUserListResponse.version) && this.lastIndex == onlineUserListResponse.lastIndex && this.model == onlineUserListResponse.model && this.firstIndex == onlineUserListResponse.firstIndex;
    }

    public final int getFirstIndex() {
        return this.firstIndex;
    }

    public final int getLastIndex() {
        return this.lastIndex;
    }

    @NotNull
    public final List<User> getList() {
        return this.list;
    }

    public final int getModel() {
        return this.model;
    }

    @Nullable
    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        int hashCode = this.list.hashCode() * 31;
        String str = this.version;
        return ((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.lastIndex) * 31) + this.model) * 31) + this.firstIndex;
    }

    @NotNull
    public String toString() {
        return "OnlineUserListResponse(list=" + this.list + ", version=" + this.version + ", lastIndex=" + this.lastIndex + ", model=" + this.model + ", firstIndex=" + this.firstIndex + ")";
    }
}
