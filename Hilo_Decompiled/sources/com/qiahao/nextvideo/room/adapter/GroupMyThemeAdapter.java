package com.qiahao.nextvideo.room.adapter;

import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import c5.g;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.utils.DateTimeUtilityKt;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.CustomThemeBean;
import com.qiahao.nextvideo.databinding.ItemGroupMyThemeBinding;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o4.j;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0011\u001a\u00020\u0002H\u0014R$\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/qiahao/nextvideo/room/adapter/GroupMyThemeAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/CustomThemeBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemGroupMyThemeBinding;", "layout", "", "<init>", "(I)V", "value", "selectThemeId", "getSelectThemeId", "()I", "setSelectThemeId", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GroupMyThemeAdapter extends BaseQuickAdapter<CustomThemeBean, BaseDataBindingHolder<ItemGroupMyThemeBinding>> {
    private int selectThemeId;

    public GroupMyThemeAdapter(int i) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
        this.selectThemeId = -1;
    }

    public final int getSelectThemeId() {
        return this.selectThemeId;
    }

    public final void setSelectThemeId(int i) {
        this.selectThemeId = i;
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemGroupMyThemeBinding> holder, @NotNull CustomThemeBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemGroupMyThemeBinding");
        ItemGroupMyThemeBinding itemGroupMyThemeBinding = (ItemGroupMyThemeBinding) dataBinding;
        Dimens dimens = Dimens.INSTANCE;
        int screenWidth = (dimens.getScreenWidth() - dimens.dpToPx(36)) / 2;
        itemGroupMyThemeBinding.backgroundFitRatioFrameLayout.setWeight(screenWidth, (int) (screenWidth * 1.5471698f));
        if (Intrinsics.areEqual(item.getPicUrl(), "")) {
            QMUIRadiusImageView qMUIRadiusImageView = itemGroupMyThemeBinding.backgroundCorneredImageView;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "backgroundCorneredImageView");
            ImageKtxKt.loadImage$default(qMUIRadiusImageView, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.bg_meeting_room1), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
        } else {
            QMUIRadiusImageView qMUIRadiusImageView2 = itemGroupMyThemeBinding.backgroundCorneredImageView;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView2, "backgroundCorneredImageView");
            ImageKtxKt.loadImage$default(qMUIRadiusImageView2, item.getPicUrl(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231654, (g) null, 49150, (Object) null);
        }
        if (this.selectThemeId == item.getId()) {
            itemGroupMyThemeBinding.selectTheme.setVisibility(0);
        } else {
            itemGroupMyThemeBinding.selectTheme.setVisibility(8);
        }
        itemGroupMyThemeBinding.textTime.setText(DateTimeUtilityKt.timeQuantumFormat(item.getRemainSecond()));
    }
}
