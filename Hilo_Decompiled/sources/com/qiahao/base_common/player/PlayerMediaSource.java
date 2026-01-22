package com.qiahao.base_common.player;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.oudi.core.component.ICleared;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, d2 = {"Lcom/qiahao/base_common/player/PlayerMediaSource;", "Lcom/oudi/core/component/ICleared;", "setTag", "", ViewHierarchyConstants.TAG_KEY, "", "getTag", "onCleared", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public interface PlayerMediaSource extends ICleared {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class DefaultImpls {
        public static void onCleared(@NotNull PlayerMediaSource playerMediaSource) {
            ICleared.DefaultImpls.onCleared(playerMediaSource);
        }
    }

    @Nullable
    Object getTag();

    @Override // com.oudi.utils.ICleared
    void onCleared();

    void setTag(@Nullable Object tag);
}
