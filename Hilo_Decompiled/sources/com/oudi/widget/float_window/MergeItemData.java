package com.oudi.widget.float_window;

import com.oudi.widget.float_window.ItemData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001H&J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001H&¨\u0006\b"}, d2 = {"Lcom/oudi/widget/float_window/MergeItemData;", "Lcom/oudi/widget/float_window/ItemData;", "getCount", "", "canMerge", "", "data", "tryMerge", "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public interface MergeItemData extends ItemData {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class DefaultImpls {
        public static int getItemPriority(@NotNull MergeItemData mergeItemData) {
            return ItemData.DefaultImpls.getItemPriority(mergeItemData);
        }
    }

    boolean canMerge(@NotNull ItemData data);

    long getCount();

    boolean tryMerge(@NotNull ItemData data);
}
