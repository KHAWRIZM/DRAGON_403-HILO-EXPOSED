package com.qiahao.nextvideo.room.viewmodel;

import com.qiahao.base_common.viewmodel.BaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R(\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR(\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0007\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\"\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/room/viewmodel/GroupThemesViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "<init>", "()V", "Lma/b;", "", "mThemeId", "Lma/b;", "getMThemeId", "()Lma/b;", "setMThemeId", "(Lma/b;)V", "", "mGroupId", "getMGroupId", "setMGroupId", "mThemeType", "I", "getMThemeType", "()I", "setMThemeType", "(I)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GroupThemesViewModel extends BaseViewModel {
    private int mThemeType;

    @NotNull
    private ma.b mThemeId = new ma.b();

    @NotNull
    private ma.b mGroupId = new ma.b();

    @NotNull
    public final ma.b getMGroupId() {
        return this.mGroupId;
    }

    @NotNull
    public final ma.b getMThemeId() {
        return this.mThemeId;
    }

    public final int getMThemeType() {
        return this.mThemeType;
    }

    public final void setMGroupId(@NotNull ma.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.mGroupId = bVar;
    }

    public final void setMThemeId(@NotNull ma.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.mThemeId = bVar;
    }

    public final void setMThemeType(int i) {
        this.mThemeType = i;
    }
}
