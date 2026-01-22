package com.qiahao.nextvideo.ui.home.matching.advertising;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import c5.g;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.VideoBaseData;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.zhpan.bannerview.e;
import com.zhpan.bannerview.f;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import o4.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ5\u0010\u000f\u001a\u00020\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000f\u0010\u0010R0\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/matching/advertising/PopularViewAdapter;", "Lcom/zhpan/bannerview/e;", "Lcom/qiahao/nextvideo/data/model/VideoBaseData;", "<init>", "()V", "", "viewType", "getLayoutId", "(I)I", "Lcom/zhpan/bannerview/f;", "holder", "data", "position", "pageSize", "", "bindData", "(Lcom/zhpan/bannerview/f;Lcom/qiahao/nextvideo/data/model/VideoBaseData;II)V", "Lkotlin/Function1;", "listener", "Lkotlin/jvm/functions/Function1;", "getListener", "()Lkotlin/jvm/functions/Function1;", "setListener", "(Lkotlin/jvm/functions/Function1;)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPopularAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PopularAdapter.kt\ncom/qiahao/nextvideo/ui/home/matching/advertising/PopularViewAdapter\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,34:1\n61#2,9:35\n*S KotlinDebug\n*F\n+ 1 PopularAdapter.kt\ncom/qiahao/nextvideo/ui/home/matching/advertising/PopularViewAdapter\n*L\n29#1:35,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PopularViewAdapter extends e {

    @Nullable
    private Function1<? super VideoBaseData, Unit> listener;

    @Override // com.zhpan.bannerview.e
    public int getLayoutId(int viewType) {
        return R.layout.item_popular;
    }

    @Nullable
    public final Function1<VideoBaseData, Unit> getListener() {
        return this.listener;
    }

    public final void setListener(@Nullable Function1<? super VideoBaseData, Unit> function1) {
        this.listener = function1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zhpan.bannerview.e
    public void bindData(@NotNull f holder, @NotNull final VideoBaseData data, int position, int pageSize) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(data, "data");
        QMUIRadiusImageView findViewById = ((RecyclerView.ViewHolder) holder).itemView.findViewById(2131363211);
        if (findViewById != null) {
            ImageKtxKt.loadImage$default(findViewById, ImageSizeKt.image100(data.getAvatar()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, ImageView.ScaleType.FIT_XY, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, 2131232429, 2131232429, (g) null, 40926, (Object) null);
        }
        final View view = ((RecyclerView.ViewHolder) holder).itemView;
        final long j = 800;
        view.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.matching.advertising.PopularViewAdapter$bindData$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(view) > j || (view instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(view, currentTimeMillis);
                    Function1<VideoBaseData, Unit> listener = this.getListener();
                    if (listener != null) {
                        listener.invoke(data);
                    }
                }
            }
        });
    }
}
