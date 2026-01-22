package com.qiahao.nextvideo.room.luckybox;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.ScrollBean;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J9\u0010\f\u001a\u00020\u000b2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0014¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/room/luckybox/NewsAdapter;", "Lcom/zhpan/bannerview/e;", "Lcom/qiahao/nextvideo/data/model/ScrollBean;", "<init>", "()V", "Lcom/zhpan/bannerview/f;", "holder", "data", "", "position", "pageSize", "", "bindData", "(Lcom/zhpan/bannerview/f;Lcom/qiahao/nextvideo/data/model/ScrollBean;II)V", "viewType", "getLayoutId", "(I)I", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class NewsAdapter extends com.zhpan.bannerview.e {
    @Override // com.zhpan.bannerview.e
    public int getLayoutId(int viewType) {
        return R.layout.item_lucky_box_news;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zhpan.bannerview.e
    public void bindData(@Nullable com.zhpan.bannerview.f holder, @Nullable ScrollBean data, int position, int pageSize) {
        View view;
        View view2;
        int i = 0;
        CircleImageView circleImageView = (holder == null || (view2 = ((RecyclerView.ViewHolder) holder).itemView) == null) ? null : (CircleImageView) view2.findViewById(2131362013);
        if (circleImageView != null) {
            ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
            String avatar = data != null ? data.getAvatar() : null;
            ResizeMode.FILL fill = ResizeMode.FILL.INSTANCE;
            Dimens dimens = Dimens.INSTANCE;
            fill.setWidth(dimens.dpToPx(18));
            fill.setHeight(dimens.dpToPx(18));
            Unit unit = Unit.INSTANCE;
            ViewUtilitiesKt.bind$default(circleImageView, companion.displayImage(avatar, fill), null, 2, null);
        }
        TextView textView = (holder == null || (view = ((RecyclerView.ViewHolder) holder).itemView) == null) ? null : (TextView) view.findViewById(R.id.text_diamond);
        if ((data != null ? data.getNick() : null) == null || data.getDiamond().length() <= 0) {
            return;
        }
        String format = String.format(ResourcesKtxKt.getStringById(this, 2131952358), Arrays.copyOf(new Object[]{data.getNick(), data.getDiamond()}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        int i2 = 0;
        int i3 = 0;
        while (StringsKt.indexOf$default(format, data.getDiamond(), i3, false, 4, (Object) null) != -1) {
            i = StringsKt.indexOf$default(format, data.getDiamond(), i3, false, 4, (Object) null);
            i3 = i + data.getDiamond().length();
            i2 = i3;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#fffc37")), i, i2, 17);
        if (textView != null) {
            textView.setText(spannableStringBuilder);
        }
    }
}
