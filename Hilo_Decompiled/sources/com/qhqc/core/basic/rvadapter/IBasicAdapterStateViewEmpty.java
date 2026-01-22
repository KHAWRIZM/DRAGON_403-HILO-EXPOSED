package com.qhqc.core.basic.rvadapter;

import android.widget.ImageView;
import android.widget.TextView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/qhqc/core/basic/rvadapter/IBasicAdapterStateViewEmpty;", "Lcom/qhqc/core/basic/rvadapter/IBasicAdapterStateView;", "getContentView", "Landroid/widget/TextView;", "getIconView", "Landroid/widget/ImageView;", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public interface IBasicAdapterStateViewEmpty extends IBasicAdapterStateView {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class DefaultImpls {
        @Nullable
        public static TextView getContentView(@NotNull IBasicAdapterStateViewEmpty iBasicAdapterStateViewEmpty) {
            return null;
        }

        @Nullable
        public static ImageView getIconView(@NotNull IBasicAdapterStateViewEmpty iBasicAdapterStateViewEmpty) {
            return null;
        }
    }

    @Nullable
    TextView getContentView();

    @Nullable
    ImageView getIconView();
}
