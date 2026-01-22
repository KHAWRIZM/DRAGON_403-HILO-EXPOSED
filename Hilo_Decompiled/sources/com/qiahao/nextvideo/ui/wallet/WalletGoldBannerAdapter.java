package com.qiahao.nextvideo.ui.wallet;

import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.GoldBanner;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ9\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/ui/wallet/WalletGoldBannerAdapter;", "Lcom/zhpan/bannerview/e;", "Lcom/qiahao/nextvideo/data/model/GoldBanner;", "<init>", "()V", "", "viewType", "getLayoutId", "(I)I", "Lcom/zhpan/bannerview/f;", "holder", "data", "position", "pageSize", "", "bindData", "(Lcom/zhpan/bannerview/f;Lcom/qiahao/nextvideo/data/model/GoldBanner;II)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class WalletGoldBannerAdapter extends com.zhpan.bannerview.e {
    @Override // com.zhpan.bannerview.e
    public int getLayoutId(int viewType) {
        return R.layout.item_wallet_banner;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zhpan.bannerview.e
    public void bindData(@Nullable com.zhpan.bannerview.f holder, @Nullable GoldBanner data, int position, int pageSize) {
        String str;
        QMUIRadiusImageView a = holder != null ? holder.a(2131363211) : null;
        if (a != null) {
            if (data == null || (str = data.getPicUrl()) == null) {
                str = "";
            }
            ImageKtxKt.loadImage$default(a, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231930, (c5.g) null, 49150, (Object) null);
        }
    }
}
