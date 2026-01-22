package com.qiahao.nextvideo.ui.vip;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J9\u0010\u000e\u001a\u00020\r2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/ui/vip/VipBannerPagerAdapter;", "Lcom/zhpan/bannerview/e;", "Lcom/qiahao/nextvideo/ui/vip/VipBannerBean;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lcom/zhpan/bannerview/f;", "holder", "data", "", "position", "pageSize", "", "bindData", "(Lcom/zhpan/bannerview/f;Lcom/qiahao/nextvideo/ui/vip/VipBannerBean;II)V", "viewType", "getLayoutId", "(I)I", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class VipBannerPagerAdapter extends com.zhpan.bannerview.e {

    @NotNull
    private final Context context;

    public VipBannerPagerAdapter(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @Override // com.zhpan.bannerview.e
    public int getLayoutId(int viewType) {
        return R.layout.holder_vip;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zhpan.bannerview.e
    public void bindData(@Nullable com.zhpan.bannerview.f holder, @Nullable VipBannerBean data, int position, int pageSize) {
        View view;
        View view2;
        View view3;
        TextView textView = null;
        ImageView imageView = (holder == null || (view3 = ((RecyclerView.ViewHolder) holder).itemView) == null) ? null : (ImageView) view3.findViewById(R.id.vip_icon);
        TextView textView2 = (holder == null || (view2 = ((RecyclerView.ViewHolder) holder).itemView) == null) ? null : (TextView) view2.findViewById(R.id.vip_title);
        if (holder != null && (view = ((RecyclerView.ViewHolder) holder).itemView) != null) {
            textView = (TextView) view.findViewById(R.id.vip_content);
        }
        if (data != null) {
            if (imageView != null) {
                imageView.setImageDrawable(this.context.getDrawable(data.getBannerIcon()));
            }
            if (textView2 != null) {
                textView2.setText(data.getTitle());
            }
            if (textView != null) {
                textView.setText(data.getContent());
            }
        }
    }
}
