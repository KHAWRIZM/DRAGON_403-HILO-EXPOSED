package com.qiahao.nextvideo.ui.profile;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import c5.g;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.zhpan.bannerview.e;
import com.zhpan.bannerview.f;
import java.io.File;
import kotlin.Metadata;
import o4.j;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ9\u0010\u0012\u001a\u00020\u00112\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/qiahao/nextvideo/ui/profile/PhotoViewPagerAdapter;", "Lcom/zhpan/bannerview/e;", "Lcom/qiahao/nextvideo/ui/profile/PhotoViewPagerBean;", "<init>", "()V", "", "isCanLoop", "()Z", "", "viewType", "getLayoutId", "(I)I", "Lcom/zhpan/bannerview/f;", "holder", "data", "position", "pageSize", "", "bindData", "(Lcom/zhpan/bannerview/f;Lcom/qiahao/nextvideo/ui/profile/PhotoViewPagerBean;II)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PhotoViewPagerAdapter extends e {
    @Override // com.zhpan.bannerview.e
    public int getLayoutId(int viewType) {
        return R.layout.item_user_detail_banner_picture;
    }

    @Override // com.zhpan.bannerview.e
    public boolean isCanLoop() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zhpan.bannerview.e
    public void bindData(@Nullable f holder, @Nullable PhotoViewPagerBean data, int position, int pageSize) {
        View view;
        ImageView findViewById = (holder == null || (view = ((RecyclerView.ViewHolder) holder).itemView) == null) ? null : view.findViewById(R.id.user_profile_picture_image_view);
        if (findViewById != null) {
            ImageKtxKt.loadImage$default(findViewById, data != null ? data.getUrl() : null, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232432, (g) null, 49150, (Object) null);
        }
    }
}
