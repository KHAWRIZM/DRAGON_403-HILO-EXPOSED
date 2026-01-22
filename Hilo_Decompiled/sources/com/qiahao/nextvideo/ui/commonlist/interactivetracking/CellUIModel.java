package com.qiahao.nextvideo.ui.commonlist.interactivetracking;

import com.qiahao.nextvideo.ui.matchinghistoric.ProfileDetailUIModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b&\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/CellUIModel;", "", "nextUIModel", "Lcom/qiahao/nextvideo/ui/matchinghistoric/ProfileDetailUIModel;", "itemId", "", "interactiveTrackingType", "Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/InteractiveTrackingType;", "hasRead", "", "heartPer", "", "<init>", "(Lcom/qiahao/nextvideo/ui/matchinghistoric/ProfileDetailUIModel;Ljava/lang/String;Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/InteractiveTrackingType;ZI)V", "getNextUIModel", "()Lcom/qiahao/nextvideo/ui/matchinghistoric/ProfileDetailUIModel;", "setNextUIModel", "(Lcom/qiahao/nextvideo/ui/matchinghistoric/ProfileDetailUIModel;)V", "getItemId", "()Ljava/lang/String;", "getInteractiveTrackingType", "()Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/InteractiveTrackingType;", "getHasRead", "()Z", "setHasRead", "(Z)V", "getHeartPer", "()I", "setHeartPer", "(I)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class CellUIModel {
    private boolean hasRead;
    private int heartPer;

    @NotNull
    private final InteractiveTrackingType interactiveTrackingType;

    @NotNull
    private final String itemId;

    @Nullable
    private ProfileDetailUIModel nextUIModel;

    public CellUIModel(@Nullable ProfileDetailUIModel profileDetailUIModel, @NotNull String str, @NotNull InteractiveTrackingType interactiveTrackingType, boolean z, int i) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(interactiveTrackingType, "interactiveTrackingType");
        this.nextUIModel = profileDetailUIModel;
        this.itemId = str;
        this.interactiveTrackingType = interactiveTrackingType;
        this.hasRead = z;
        this.heartPer = i;
    }

    public final boolean getHasRead() {
        return this.hasRead;
    }

    public final int getHeartPer() {
        return this.heartPer;
    }

    @NotNull
    public InteractiveTrackingType getInteractiveTrackingType() {
        return this.interactiveTrackingType;
    }

    @NotNull
    public String getItemId() {
        return this.itemId;
    }

    @Nullable
    public ProfileDetailUIModel getNextUIModel() {
        return this.nextUIModel;
    }

    public final void setHasRead(boolean z) {
        this.hasRead = z;
    }

    public final void setHeartPer(int i) {
        this.heartPer = i;
    }

    public void setNextUIModel(@Nullable ProfileDetailUIModel profileDetailUIModel) {
        this.nextUIModel = profileDetailUIModel;
    }

    public /* synthetic */ CellUIModel(ProfileDetailUIModel profileDetailUIModel, String str, InteractiveTrackingType interactiveTrackingType, boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : profileDetailUIModel, str, interactiveTrackingType, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? -1 : i);
    }
}
