package com.qiahao.nextvideo.ui.home;

import androidx.recyclerview.widget.DiffUtil;
import com.qiahao.nextvideo.data.model.GlobalBroadCastBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/DiscoverBroadCastDiffCallBack;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/qiahao/nextvideo/data/model/GlobalBroadCastBean;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class DiscoverBroadCastDiffCallBack extends DiffUtil.ItemCallback<GlobalBroadCastBean> {
    public boolean areContentsTheSame(@NotNull GlobalBroadCastBean oldItem, @NotNull GlobalBroadCastBean newItem) {
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return oldItem.getUserGlobalBroadcastId() == newItem.getUserGlobalBroadcastId();
    }

    public boolean areItemsTheSame(@NotNull GlobalBroadCastBean oldItem, @NotNull GlobalBroadCastBean newItem) {
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return oldItem.getUserGlobalBroadcastId() == newItem.getUserGlobalBroadcastId();
    }
}
