package com.qiahao.nextvideo.room.adapter;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import c5.g;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.MicroBean;
import com.qiahao.nextvideo.data.model.MicroUserBean;
import com.qiahao.nextvideo.databinding.ItemPk1v1Binding;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o4.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0018\u001a\u00020\u0002H\u0014R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/qiahao/nextvideo/room/adapter/Pk1v1Adapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/MicroBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemPk1v1Binding;", "<init>", "()V", "selectModel", "", "getSelectModel", "()I", "setSelectModel", "(I)V", "blueSelectUser", "getBlueSelectUser", "()Lcom/qiahao/nextvideo/data/model/MicroBean;", "setBlueSelectUser", "(Lcom/qiahao/nextvideo/data/model/MicroBean;)V", "redSelectUser", "getRedSelectUser", "setRedSelectUser", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class Pk1v1Adapter extends BaseQuickAdapter<MicroBean, BaseDataBindingHolder<ItemPk1v1Binding>> {

    @Nullable
    private MicroBean blueSelectUser;

    @Nullable
    private MicroBean redSelectUser;
    private int selectModel;

    public Pk1v1Adapter() {
        super(R.layout.item_pk1v1, (List) null, 2, (DefaultConstructorMarker) null);
    }

    @Nullable
    public final MicroBean getBlueSelectUser() {
        return this.blueSelectUser;
    }

    @Nullable
    public final MicroBean getRedSelectUser() {
        return this.redSelectUser;
    }

    public final int getSelectModel() {
        return this.selectModel;
    }

    public final void setBlueSelectUser(@Nullable MicroBean microBean) {
        this.blueSelectUser = microBean;
    }

    public final void setRedSelectUser(@Nullable MicroBean microBean) {
        this.redSelectUser = microBean;
    }

    public final void setSelectModel(int i) {
        this.selectModel = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemPk1v1Binding> holder, @NotNull MicroBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemPk1v1Binding");
        ItemPk1v1Binding itemPk1v1Binding = (ItemPk1v1Binding) dataBinding;
        QMUIRadiusImageView qMUIRadiusImageView = itemPk1v1Binding.avatar;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "avatar");
        MicroUserBean user = item.getUser();
        ImageKtxKt.loadImage$default(qMUIRadiusImageView, ImageSizeKt.image200(user != null ? user.getAvatar() : null), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (g) null, 49150, (Object) null);
        TextView textView = itemPk1v1Binding.nick;
        MicroUserBean user2 = item.getUser();
        textView.setText(user2 != null ? user2.getNick() : null);
        int i = this.selectModel;
        if (i == 0) {
            MicroUserBean user3 = item.getUser();
            String externalId = user3 != null ? user3.getExternalId() : null;
            MicroBean microBean = this.blueSelectUser;
            if (Intrinsics.areEqual(externalId, microBean != null ? microBean.getExternalId() : null)) {
                itemPk1v1Binding.constraint.setAlpha(1.0f);
                itemPk1v1Binding.avatar.setBorderColor(Color.parseColor("#3496FF"));
                itemPk1v1Binding.nick.setTextColor(Color.parseColor("#3496FF"));
                return;
            }
            MicroBean microBean2 = this.redSelectUser;
            if (Intrinsics.areEqual(externalId, microBean2 != null ? microBean2.getExternalId() : null)) {
                itemPk1v1Binding.constraint.setAlpha(0.5f);
                itemPk1v1Binding.avatar.setBorderColor(Color.parseColor("#FF7C8B"));
                itemPk1v1Binding.nick.setTextColor(Color.parseColor("#FF344C"));
                return;
            } else {
                itemPk1v1Binding.constraint.setAlpha(1.0f);
                itemPk1v1Binding.avatar.setBorderColor(Color.parseColor("#00000000"));
                itemPk1v1Binding.nick.setTextColor(Color.parseColor("#ffffff"));
                return;
            }
        }
        if (i == 1) {
            MicroUserBean user4 = item.getUser();
            String externalId2 = user4 != null ? user4.getExternalId() : null;
            MicroBean microBean3 = this.blueSelectUser;
            if (Intrinsics.areEqual(externalId2, microBean3 != null ? microBean3.getExternalId() : null)) {
                itemPk1v1Binding.constraint.setAlpha(0.5f);
                itemPk1v1Binding.avatar.setBorderColor(Color.parseColor("#3496FF"));
                itemPk1v1Binding.nick.setTextColor(Color.parseColor("#3496FF"));
                return;
            }
            MicroBean microBean4 = this.redSelectUser;
            if (Intrinsics.areEqual(externalId2, microBean4 != null ? microBean4.getExternalId() : null)) {
                itemPk1v1Binding.constraint.setAlpha(1.0f);
                itemPk1v1Binding.avatar.setBorderColor(Color.parseColor("#FF7C8B"));
                itemPk1v1Binding.nick.setTextColor(Color.parseColor("#FF344C"));
            } else {
                itemPk1v1Binding.constraint.setAlpha(1.0f);
                itemPk1v1Binding.avatar.setBorderColor(Color.parseColor("#00000000"));
                itemPk1v1Binding.nick.setTextColor(Color.parseColor("#ffffff"));
            }
        }
    }
}
