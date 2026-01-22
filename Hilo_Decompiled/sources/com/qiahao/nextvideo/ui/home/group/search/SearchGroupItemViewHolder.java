package com.qiahao.nextvideo.ui.home.group.search;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.makeramen.roundedimageview.RoundedImageView;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.data.model.SearchGroupBean;
import com.qiahao.nextvideo.databinding.ItemSearchGroupViewBinding;
import com.qiahao.nextvideo.ui.login.VerificationCodeFragment;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.ui.reusable.views.list.ViewHolder;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/group/search/SearchGroupItemViewHolder;", "Lcom/qiahao/nextvideo/ui/reusable/views/list/ViewHolder;", "binding", "Lcom/qiahao/nextvideo/databinding/ItemSearchGroupViewBinding;", "<init>", "(Lcom/qiahao/nextvideo/databinding/ItemSearchGroupViewBinding;)V", "getBinding", "()Lcom/qiahao/nextvideo/databinding/ItemSearchGroupViewBinding;", VerificationCodeFragment.TYPE_BIND, "", "bean", "Lcom/qiahao/nextvideo/data/model/SearchGroupBean;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SearchGroupItemViewHolder extends ViewHolder {

    @NotNull
    private static final String TAG = "PopularViewItemListWrap";

    @NotNull
    private final ItemSearchGroupViewBinding binding;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SearchGroupItemViewHolder(@NotNull ItemSearchGroupViewBinding itemSearchGroupViewBinding) {
        super(r0);
        Intrinsics.checkNotNullParameter(itemSearchGroupViewBinding, "binding");
        View root = itemSearchGroupViewBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        this.binding = itemSearchGroupViewBinding;
    }

    public final void bind(@NotNull SearchGroupBean bean) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        Log.d(TAG, "bind: ----");
        if (!TextUtils.isEmpty(bean.getName())) {
            this.binding.groupName.setText(bean.getName());
        }
        if (!TextUtils.isEmpty(bean.getIntroduction())) {
            this.binding.groupAnnounce.setText(bean.getNotification());
        }
        this.binding.personNumber.setText(String.valueOf(bean.getMemberNum()));
        RoundedImageView roundedImageView = this.binding.userAvatar;
        Intrinsics.checkNotNullExpressionValue(roundedImageView, "userAvatar");
        ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
        String faceUrl = bean.getFaceUrl();
        ResizeMode.LFIT lfit = ResizeMode.LFIT.INSTANCE;
        Dimens dimens = Dimens.INSTANCE;
        lfit.setWidth(dimens.dpToPx(58));
        lfit.setHeight(dimens.dpToPx(58));
        Unit unit = Unit.INSTANCE;
        ViewUtilitiesKt.bind(roundedImageView, companion.displayUserAvatarImage(faceUrl, lfit));
        ImageView imageView = this.binding.countryImage;
        Intrinsics.checkNotNullExpressionValue(imageView, "countryImage");
        ViewUtilitiesKt.bind(imageView, new ImageUIModel(bean.getCountryIcon(), null, null, null, 0, 0, null, 126, null));
    }

    @NotNull
    public final ItemSearchGroupViewBinding getBinding() {
        return this.binding;
    }
}
