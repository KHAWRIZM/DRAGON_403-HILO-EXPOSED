package com.qiahao.base_common.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.qiahao.base_common.R;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fR*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/qiahao/base_common/model/UserRoleType;", "", "<init>", "()V", "mRoomUserRoleList", "Ljava/util/ArrayList;", "Lcom/qiahao/base_common/model/RoomRuleBean;", "Lkotlin/collections/ArrayList;", "getMRoomUserRoleList", "()Ljava/util/ArrayList;", "setMRoomUserRoleList", "(Ljava/util/ArrayList;)V", "getRoomUserRole", "", "extraId", "", "Companion", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class UserRoleType {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int GROUP_ADMIN = 10;
    public static final int GROUP_MANAGER = 50;
    public static final int GROUP_MEMBER = 1;
    public static final int GROUP_NOT_MEMBER = 0;
    public static final int GROUP_OWNER = 100;

    @NotNull
    private static final String TAG = "MeetingUiKitDataManager";

    @Nullable
    private static UserRoleType instance;

    @NotNull
    private ArrayList<RoomRuleBean> mRoomUserRoleList = new ArrayList<>();

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/qiahao/base_common/model/UserRoleType$Companion;", "", "<init>", "()V", "TAG", "", "instance", "Lcom/qiahao/base_common/model/UserRoleType;", "getInstance", "()Lcom/qiahao/base_common/model/UserRoleType;", "get", "GROUP_NOT_MEMBER", "", "GROUP_MEMBER", "GROUP_ADMIN", "GROUP_MANAGER", "GROUP_OWNER", "getLevelRes", FirebaseAnalytics.Param.LEVEL, "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final UserRoleType getInstance() {
            if (UserRoleType.instance == null) {
                UserRoleType.instance = new UserRoleType();
            }
            return UserRoleType.instance;
        }

        @NotNull
        public final synchronized UserRoleType get() {
            UserRoleType companion;
            companion = getInstance();
            Intrinsics.checkNotNull(companion);
            return companion;
        }

        public final int getLevelRes(int level) {
            if (level != 10) {
                if (level != 50) {
                    if (level != 100) {
                        return 0;
                    }
                    return R.drawable.icon_micro_tap_creater;
                }
                return R.drawable.icon_micro_tap_manager;
            }
            return R.drawable.icon_micro_tap_administrator;
        }

        private Companion() {
        }
    }

    @NotNull
    public final ArrayList<RoomRuleBean> getMRoomUserRoleList() {
        return this.mRoomUserRoleList;
    }

    public final int getRoomUserRole(@Nullable String extraId) {
        if (extraId == null) {
            return 1;
        }
        Iterator<RoomRuleBean> it = this.mRoomUserRoleList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            RoomRuleBean next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            RoomRuleBean roomRuleBean = next;
            if (Intrinsics.areEqual(extraId, roomRuleBean.getExternalId())) {
                return roomRuleBean.getRole();
            }
        }
        return 1;
    }

    public final void setMRoomUserRoleList(@NotNull ArrayList<RoomRuleBean> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.mRoomUserRoleList = arrayList;
    }
}
