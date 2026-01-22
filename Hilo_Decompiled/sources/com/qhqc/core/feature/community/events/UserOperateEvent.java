package com.qhqc.core.feature.community.events;

import com.qhqc.core.feature.bean.UserInfoBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/qhqc/core/feature/community/events/UserOperateEvent;", "Lcom/qhqc/core/feature/community/events/BaseEvent;", "event", "", "user", "Lcom/qhqc/core/feature/bean/UserInfoBean;", "<init>", "(ILcom/qhqc/core/feature/bean/UserInfoBean;)V", "getEvent", "()I", "getUser", "()Lcom/qhqc/core/feature/bean/UserInfoBean;", "Companion", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class UserOperateEvent extends BaseEvent {
    public static final int EVENT_USER_FOLLOWED = 12289;
    private final int event;

    @NotNull
    private final UserInfoBean user;

    public UserOperateEvent(int i10, @NotNull UserInfoBean user) {
        Intrinsics.checkNotNullParameter(user, "user");
        this.event = i10;
        this.user = user;
    }

    public final int getEvent() {
        return this.event;
    }

    @NotNull
    public final UserInfoBean getUser() {
        return this.user;
    }
}
