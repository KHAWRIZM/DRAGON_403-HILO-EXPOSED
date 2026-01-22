package com.qiahao.nextvideo.ui.gameLevel;

import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.gameLevel.GameLevelPrivilege;
import com.qiahao.nextvideo.databinding.ItemGameLevelPrivilegesBinding;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/ui/gameLevel/GameLevelPrivilegesAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/gameLevel/GameLevelPrivilege;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemGameLevelPrivilegesBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GameLevelPrivilegesAdapter extends BaseQuickAdapter<GameLevelPrivilege, BaseDataBindingHolder<ItemGameLevelPrivilegesBinding>> {
    public GameLevelPrivilegesAdapter() {
        super(R.layout.item_game_level_privileges, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemGameLevelPrivilegesBinding> holder, @NotNull GameLevelPrivilege item) {
        ImageView imageView;
        ConstraintLayout constraintLayout;
        TextView textView;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemGameLevelPrivilegesBinding itemGameLevelPrivilegesBinding = (ItemGameLevelPrivilegesBinding) holder.getDataBinding();
        if (itemGameLevelPrivilegesBinding != null && (textView = itemGameLevelPrivilegesBinding.name) != null) {
            textView.setText(item.getTitle());
        }
        if (itemGameLevelPrivilegesBinding != null && (constraintLayout = itemGameLevelPrivilegesBinding.constraint) != null) {
            constraintLayout.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#212128", "#212128", 8, (GradientDrawable.Orientation) null, 8, (Object) null));
        }
        if (itemGameLevelPrivilegesBinding == null || (imageView = itemGameLevelPrivilegesBinding.img) == null) {
            return;
        }
        ImageKtxKt.loadImage$default(imageView, item.getIconUrl(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
    }
}
