package com.qiahao.nextvideo.ui.rank;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.MyCpBean;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ItemCpMyRankBinding;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014¨\u0006\r"}, d2 = {"Lcom/qiahao/nextvideo/ui/rank/CpMyRankAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/MyCpBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemCpMyRankBinding;", "layout", "", "<init>", "(I)V", "convert", "", "holder", "cpBean", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CpMyRankAdapter extends BaseQuickAdapter<MyCpBean, BaseDataBindingHolder<ItemCpMyRankBinding>> {
    public CpMyRankAdapter(int i) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c8, code lost:
    
        if (r1.isVip() == true) goto L٤٩;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void convert(@NotNull BaseDataBindingHolder<ItemCpMyRankBinding> holder, @NotNull MyCpBean cpBean) {
        String nick;
        String name;
        Integer level;
        Integer level2;
        Integer level3;
        Integer level4;
        NobleInfo noble;
        Integer level5;
        NobleInfo noble2;
        Integer level6;
        String nick2;
        String nick3;
        NobleInfo noble3;
        Integer level7;
        NobleInfo noble4;
        Integer level8;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(cpBean, "cpBean");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemCpMyRankBinding");
        ItemCpMyRankBinding itemCpMyRankBinding = (ItemCpMyRankBinding) dataBinding;
        User user = UserStore.INSTANCE.getShared().getUser();
        int i = 0;
        if (((user == null || (noble4 = user.getNoble()) == null || (level8 = noble4.getLevel()) == null) ? 0 : level8.intValue()) > 0) {
            itemCpMyRankBinding.user1Name.setTextColor(UserService.INSTANCE.getNobleColor((user == null || (noble3 = user.getNoble()) == null || (level7 = noble3.getLevel()) == null) ? 0 : level7.intValue(), Color.parseColor("#333333")));
        } else {
            itemCpMyRankBinding.user1Name.setTextColor(Color.parseColor("#333333"));
        }
        TextView textView = itemCpMyRankBinding.user1Name;
        if (((user == null || (nick3 = user.getNick()) == null) ? 0 : nick3.length()) > 20) {
            nick = ((Object) ((user == null || (nick2 = user.getNick()) == null) ? null : nick2.subSequence(0, 19))) + "...";
        } else {
            nick = user != null ? user.getNick() : null;
        }
        textView.setText(nick);
        HiloImageView.loadImage$default(itemCpMyRankBinding.user1AvatarCimageView, ImageSizeKt.image100(user != null ? user.getAvatar() : null), 0, 0, 6, (Object) null);
        boolean z = user != null;
        if (z) {
            itemCpMyRankBinding.iconVip1.setVisibility(0);
        } else {
            itemCpMyRankBinding.iconVip1.setVisibility(8);
        }
        if (((user == null || (noble2 = user.getNoble()) == null || (level6 = noble2.getLevel()) == null) ? 0 : level6.intValue()) > 0) {
            itemCpMyRankBinding.iconVip1.setVisibility(8);
            itemCpMyRankBinding.iconNoble1.setVisibility(0);
            itemCpMyRankBinding.iconNoble1.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), UserService.INSTANCE.getNobleDrawableRes((user == null || (noble = user.getNoble()) == null || (level5 = noble.getLevel()) == null) ? 0 : level5.intValue())));
        } else {
            itemCpMyRankBinding.iconNoble1.setVisibility(8);
        }
        HiloImageView.loadImage$default(itemCpMyRankBinding.user2AvatarCimageView, ImageSizeKt.image100(cpBean.getUser().getAvatar()), 0, 0, 6, (Object) null);
        NobleInfo noble5 = cpBean.getUser().getNoble();
        if (((noble5 == null || (level4 = noble5.getLevel()) == null) ? 0 : level4.intValue()) > 0) {
            TextView textView2 = itemCpMyRankBinding.user2Name;
            UserService.Companion companion = UserService.INSTANCE;
            NobleInfo noble6 = cpBean.getUser().getNoble();
            textView2.setTextColor(companion.getNobleColor((noble6 == null || (level3 = noble6.getLevel()) == null) ? 0 : level3.intValue(), Color.parseColor("#333333")));
        } else {
            itemCpMyRankBinding.user2Name.setTextColor(Color.parseColor("#333333"));
        }
        TextView textView3 = itemCpMyRankBinding.user2Name;
        String name2 = cpBean.getUser().getName();
        if ((name2 != null ? name2.length() : 0) > 20) {
            String name3 = cpBean.getUser().getName();
            name = ((Object) (name3 != null ? name3.subSequence(0, 19) : null)) + "...";
        } else {
            name = cpBean.getUser().getName();
        }
        textView3.setText(name);
        itemCpMyRankBinding.cpValue.setText(NumberUtilsKt.rankNumberFormat(cpBean.getScore()));
        if (Intrinsics.areEqual(cpBean.getUser().isVip(), Boolean.TRUE)) {
            itemCpMyRankBinding.iconVip2.setVisibility(0);
        } else {
            itemCpMyRankBinding.iconVip2.setVisibility(8);
        }
        NobleInfo noble7 = cpBean.getUser().getNoble();
        if (((noble7 == null || (level2 = noble7.getLevel()) == null) ? 0 : level2.intValue()) > 0) {
            itemCpMyRankBinding.iconVip2.setVisibility(8);
            itemCpMyRankBinding.iconNoble2.setVisibility(0);
            ImageView imageView = itemCpMyRankBinding.iconNoble2;
            Context context = getContext();
            UserService.Companion companion2 = UserService.INSTANCE;
            NobleInfo noble8 = cpBean.getUser().getNoble();
            if (noble8 != null && (level = noble8.getLevel()) != null) {
                i = level.intValue();
            }
            imageView.setImageDrawable(androidx.core.content.a.getDrawable(context, companion2.getNobleDrawableRes(i)));
            return;
        }
        itemCpMyRankBinding.iconNoble2.setVisibility(8);
    }
}
