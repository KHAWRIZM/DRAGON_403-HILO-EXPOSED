package com.oudi.widget.float_window;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0017J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0005H\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0005H\u0016¨\u0006\u0014"}, d2 = {"Lcom/oudi/widget/float_window/ItemView;", "", "getView", "Landroid/view/View;", "onAttached", "", "window", "Lcom/oudi/widget/float_window/IFloatWindowLayout;", "data", "Lcom/oudi/widget/float_window/ItemData;", "onDetached", "getItemData", "tryMerge", "", "itemData", "Lcom/oudi/widget/float_window/MergeItemData;", "getItemViewType", "", "()Ljava/lang/Integer;", "onCleared", "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public interface ItemView {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class DefaultImpls {
        @Nullable
        public static Integer getItemViewType(@NotNull ItemView itemView) {
            ItemData itemData = itemView.getItemData();
            if (itemData != null) {
                return Integer.valueOf(itemData.getItemViewType());
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public static View getView(@NotNull ItemView itemView) {
            Intrinsics.checkNotNull(itemView, "null cannot be cast to non-null type android.view.View");
            return (View) itemView;
        }

        public static void onCleared(@NotNull ItemView itemView) {
        }

        public static void onDetached(@NotNull ItemView itemView) {
        }
    }

    @Nullable
    ItemData getItemData();

    @Nullable
    Integer getItemViewType();

    @NotNull
    View getView();

    void onAttached(@NotNull IFloatWindowLayout window, @NotNull ItemData data);

    void onCleared();

    void onDetached();

    boolean tryMerge(@NotNull MergeItemData itemData);
}
