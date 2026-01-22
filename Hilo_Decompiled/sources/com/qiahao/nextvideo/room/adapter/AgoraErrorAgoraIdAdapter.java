package com.qiahao.nextvideo.room.adapter;

import android.util.Log;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.ItemAgoraErrorAgoraIdBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/room/adapter/AgoraErrorAgoraIdAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemAgoraErrorAgoraIdBinding;", "<init>", "()V", "convert", "", "holder", "item", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AgoraErrorAgoraIdAdapter extends BaseQuickAdapter<Integer, BaseDataBindingHolder<ItemAgoraErrorAgoraIdBinding>> {

    @NotNull
    private static final String TAG = "GroupMemberOnlineAdapte";

    public AgoraErrorAgoraIdAdapter() {
        super(R.layout.item_agora_error_agora_id, (List) null, 2, (DefaultConstructorMarker) null);
    }

    public /* bridge */ /* synthetic */ void convert(BaseViewHolder baseViewHolder, Object obj) {
        convert((BaseDataBindingHolder<ItemAgoraErrorAgoraIdBinding>) baseViewHolder, ((Number) obj).intValue());
    }

    protected void convert(@NotNull BaseDataBindingHolder<ItemAgoraErrorAgoraIdBinding> holder, int item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemAgoraErrorAgoraIdBinding");
        Log.d(TAG, "bind: ----");
        ((ItemAgoraErrorAgoraIdBinding) dataBinding).agoraId.setText(String.valueOf(item));
    }
}
