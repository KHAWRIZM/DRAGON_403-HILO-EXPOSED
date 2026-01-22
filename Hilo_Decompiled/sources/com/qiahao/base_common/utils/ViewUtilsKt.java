package com.qiahao.base_common.utils;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcelable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.oudi.utils.ktx.UiKtxKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u001a(\u0010\u0006\u001a\u0004\u0018\u0001H\u0007\"\n\b\u0000\u0010\u0007\u0018\u0001*\u00020\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086\b¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"addItemDecoration", "", "Landroidx/recyclerview/widget/RecyclerView;", "padding", "", "itemPadding", "getParcelableExtraCompat", "T", "Landroid/os/Parcelable;", "Landroid/content/Intent;", TransferTable.COLUMN_KEY, "", "(Landroid/content/Intent;Ljava/lang/String;)Landroid/os/Parcelable;", "base_common_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ViewUtilsKt {
    public static final void addItemDecoration(@NotNull RecyclerView recyclerView, final float f10, final float f11) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.qiahao.base_common.utils.ViewUtilsKt$addItemDecoration$1
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                Intrinsics.checkNotNullParameter(outRect, "outRect");
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(state, "state");
                super.getItemOffsets(outRect, view, parent, state);
                int childLayoutPosition = parent.getChildLayoutPosition(view);
                int itemCount = state.getItemCount() - 1;
                if (childLayoutPosition == 0) {
                    if (HiloUtils.INSTANCE.getRightToLeftDirection()) {
                        outRect.right = UiKtxKt.toPX(f10);
                        return;
                    } else {
                        outRect.left = UiKtxKt.toPX(f10);
                        return;
                    }
                }
                if (childLayoutPosition == itemCount) {
                    if (HiloUtils.INSTANCE.getRightToLeftDirection()) {
                        outRect.right = UiKtxKt.toPX(f11);
                        outRect.left = UiKtxKt.toPX(f10);
                        return;
                    } else {
                        outRect.left = UiKtxKt.toPX(f11);
                        outRect.right = UiKtxKt.toPX(f10);
                        return;
                    }
                }
                if (HiloUtils.INSTANCE.getRightToLeftDirection()) {
                    outRect.right = UiKtxKt.toPX(f11);
                } else {
                    outRect.left = UiKtxKt.toPX(f11);
                }
            }
        });
    }

    public static final /* synthetic */ <T extends Parcelable> T getParcelableExtraCompat(Intent intent, String key) {
        Object parcelableExtra;
        Intrinsics.checkNotNullParameter(intent, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (Build.VERSION.SDK_INT >= 33) {
            Intrinsics.reifiedOperationMarker(4, "T");
            parcelableExtra = intent.getParcelableExtra(key, Parcelable.class);
            return (T) parcelableExtra;
        }
        T t10 = (T) intent.getParcelableExtra(key);
        Intrinsics.reifiedOperationMarker(2, "T");
        return t10;
    }
}
