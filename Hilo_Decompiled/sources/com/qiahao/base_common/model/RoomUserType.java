package com.qiahao.base_common.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/qiahao/base_common/model/RoomUserType;", "", "<init>", "()V", "GROUP_NOT_MEMBER", "", "GROUP_MEMBER", "GROUP_ADMIN", "GROUP_MANAGER", "GROUP_OWNER", "GROUP_SUPPER_MAN", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class RoomUserType {
    public static final int GROUP_ADMIN = 10;
    public static final int GROUP_MANAGER = 50;
    public static final int GROUP_MEMBER = 1;
    public static final int GROUP_NOT_MEMBER = 0;
    public static final int GROUP_OWNER = 100;
    public static final int GROUP_SUPPER_MAN = 1000;

    @NotNull
    public static final RoomUserType INSTANCE = new RoomUserType();

    private RoomUserType() {
    }
}
