package com.qiahao.nextvideo.ui.cp;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.cp.CpLevel;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.utils.RelationTypeUtils;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.cp.CpListData;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ItemCpBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0010\u001a\u00020\u0002H\u0015J\u0016\u0010\u0011\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u0016\u0010\u0012\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/qiahao/nextvideo/ui/cp/CpRankAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/cp/CpListData;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemCpBinding;", "<init>", "()V", "mRelationType", "", "getMRelationType", "()Ljava/lang/String;", "setMRelationType", "(Ljava/lang/String;)V", "convert", "", "holder", "item", "onViewAttachedToWindow", "onViewRecycled", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCpRankAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CpRankAdapter.kt\ncom/qiahao/nextvideo/ui/cp/CpRankAdapter\n+ 2 Color.kt\nandroidx/core/graphics/ColorKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,57:1\n439#2:58\n439#2:59\n1#3:60\n*S KotlinDebug\n*F\n+ 1 CpRankAdapter.kt\ncom/qiahao/nextvideo/ui/cp/CpRankAdapter\n*L\n32#1:58\n35#1:59\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CpRankAdapter extends BaseQuickAdapter<CpListData, BaseDataBindingHolder<ItemCpBinding>> {

    @NotNull
    private String mRelationType;

    public CpRankAdapter() {
        super(R.layout.item_cp, (List) null, 2, (DefaultConstructorMarker) null);
        this.mRelationType = CpFragment.FRAGMENT_CP;
    }

    @NotNull
    public final String getMRelationType() {
        return this.mRelationType;
    }

    public final void setMRelationType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mRelationType = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"SetTextI18n"})
    public void convert(@NotNull BaseDataBindingHolder<ItemCpBinding> holder, @NotNull CpListData item) {
        NobleInfo noble;
        Integer level;
        SvipData svip;
        SvipData svip2;
        NobleInfo noble2;
        Integer level2;
        SvipData svip3;
        SvipData svip4;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemCpBinding");
        ItemCpBinding itemCpBinding = (ItemCpBinding) dataBinding;
        HiloImageView hiloImageView = itemCpBinding.avatar1;
        User user1 = item.getUser1();
        HiloImageView.loadImage$default(hiloImageView, ImageSizeKt.image100(user1 != null ? user1.getAvatar() : null), 2131231655, 0, 4, (Object) null);
        HiloImageView hiloImageView2 = itemCpBinding.avatar2;
        User user2 = item.getUser2();
        HiloImageView.loadImage$default(hiloImageView2, ImageSizeKt.image100(user2 != null ? user2.getAvatar() : null), 2131231655, 0, 4, (Object) null);
        NickTextView nickTextView = itemCpBinding.nickName1;
        UserService.Companion companion = UserService.INSTANCE;
        User user12 = item.getUser1();
        int i = 0;
        nickTextView.setTextColor(companion.getNobleColor((user12 == null || (svip4 = user12.getSvip()) == null) ? 0 : svip4.getSvipLevel(), Color.parseColor("#333333")));
        NickTextView nickTextView2 = itemCpBinding.nickName1;
        User user13 = item.getUser1();
        String nick = user13 != null ? user13.getNick() : null;
        User user14 = item.getUser1();
        int svipLevel = (user14 == null || (svip3 = user14.getSvip()) == null) ? 0 : svip3.getSvipLevel();
        User user15 = item.getUser1();
        nickTextView2.setSVipAndNoble(nick, svipLevel, (user15 == null || (noble2 = user15.getNoble()) == null || (level2 = noble2.getLevel()) == null) ? 0 : level2.intValue());
        NickTextView nickTextView3 = itemCpBinding.nickName2;
        User user22 = item.getUser2();
        nickTextView3.setTextColor(companion.getNobleColor((user22 == null || (svip2 = user22.getSvip()) == null) ? 0 : svip2.getSvipLevel(), Color.parseColor("#333333")));
        NickTextView nickTextView4 = itemCpBinding.nickName2;
        User user23 = item.getUser2();
        String nick2 = user23 != null ? user23.getNick() : null;
        User user24 = item.getUser2();
        int svipLevel2 = (user24 == null || (svip = user24.getSvip()) == null) ? 0 : svip.getSvipLevel();
        User user25 = item.getUser2();
        if (user25 != null && (noble = user25.getNoble()) != null && (level = noble.getLevel()) != null) {
            i = level.intValue();
        }
        nickTextView4.setSVipAndNoble(nick2, svipLevel2, i);
        itemCpBinding.position.setText(String.valueOf(holder.getAdapterPosition() + 4));
        ImageView imageView = itemCpBinding.medal;
        RelationTypeUtils relationTypeUtils = RelationTypeUtils.INSTANCE;
        CpLevel cpLevel = item.getCpLevel();
        Integer level3 = cpLevel != null ? cpLevel.getLevel() : null;
        Integer type = item.getType();
        Integer relationMedal = relationTypeUtils.getRelationMedal(level3, true, type != null ? type.intValue() : 1);
        imageView.setImageDrawable(relationMedal != null ? androidx.core.content.a.getDrawable(getContext(), relationMedal.intValue()) : null);
    }

    public void onViewRecycled(@NotNull BaseDataBindingHolder<ItemCpBinding> holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewRecycled(holder);
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemCpBinding");
        ItemCpBinding itemCpBinding = (ItemCpBinding) dataBinding;
        itemCpBinding.nickName1.startOrStopAnim(false);
        itemCpBinding.nickName2.startOrStopAnim(false);
    }

    public void onViewAttachedToWindow(@NotNull BaseDataBindingHolder<ItemCpBinding> holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemCpBinding");
        ItemCpBinding itemCpBinding = (ItemCpBinding) dataBinding;
        itemCpBinding.nickName1.startOrStopAnim(true);
        itemCpBinding.nickName2.startOrStopAnim(true);
    }
}
