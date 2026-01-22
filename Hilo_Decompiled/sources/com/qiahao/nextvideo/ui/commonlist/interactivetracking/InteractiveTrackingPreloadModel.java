package com.qiahao.nextvideo.ui.commonlist.interactivetracking;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/InteractiveTrackingPreloadModel;", "", "selectedInteractiveTrackingType", "Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/InteractiveTrackingType;", "<init>", "(Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/InteractiveTrackingType;)V", "getSelectedInteractiveTrackingType", "()Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/InteractiveTrackingType;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class InteractiveTrackingPreloadModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final InteractiveTrackingType selectedInteractiveTrackingType;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/InteractiveTrackingPreloadModel$Companion;", "", "<init>", "()V", "init", "Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/InteractiveTrackingPreloadModel;", "type", "Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/InteractiveTrackingType;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ InteractiveTrackingPreloadModel init$default(Companion companion, InteractiveTrackingType interactiveTrackingType, int i, Object obj) {
            if ((i & 1) != 0) {
                interactiveTrackingType = InteractiveTrackingType.ILike;
            }
            return companion.init(interactiveTrackingType);
        }

        @NotNull
        public final InteractiveTrackingPreloadModel init(@NotNull InteractiveTrackingType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new InteractiveTrackingPreloadModel(type);
        }

        private Companion() {
        }
    }

    public InteractiveTrackingPreloadModel(@NotNull InteractiveTrackingType interactiveTrackingType) {
        Intrinsics.checkNotNullParameter(interactiveTrackingType, "selectedInteractiveTrackingType");
        this.selectedInteractiveTrackingType = interactiveTrackingType;
    }

    public static /* synthetic */ InteractiveTrackingPreloadModel copy$default(InteractiveTrackingPreloadModel interactiveTrackingPreloadModel, InteractiveTrackingType interactiveTrackingType, int i, Object obj) {
        if ((i & 1) != 0) {
            interactiveTrackingType = interactiveTrackingPreloadModel.selectedInteractiveTrackingType;
        }
        return interactiveTrackingPreloadModel.copy(interactiveTrackingType);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final InteractiveTrackingType getSelectedInteractiveTrackingType() {
        return this.selectedInteractiveTrackingType;
    }

    @NotNull
    public final InteractiveTrackingPreloadModel copy(@NotNull InteractiveTrackingType selectedInteractiveTrackingType) {
        Intrinsics.checkNotNullParameter(selectedInteractiveTrackingType, "selectedInteractiveTrackingType");
        return new InteractiveTrackingPreloadModel(selectedInteractiveTrackingType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof InteractiveTrackingPreloadModel) && this.selectedInteractiveTrackingType == ((InteractiveTrackingPreloadModel) other).selectedInteractiveTrackingType;
    }

    @NotNull
    public final InteractiveTrackingType getSelectedInteractiveTrackingType() {
        return this.selectedInteractiveTrackingType;
    }

    public int hashCode() {
        return this.selectedInteractiveTrackingType.hashCode();
    }

    @NotNull
    public String toString() {
        return "InteractiveTrackingPreloadModel(selectedInteractiveTrackingType=" + this.selectedInteractiveTrackingType + ")";
    }
}
