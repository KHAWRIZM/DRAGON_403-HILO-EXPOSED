package com.qiahao.nextvideo.ui.transfer;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.DealerDiamondConfig;
import com.qiahao.nextvideo.databinding.FragmentTransferBinding;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\"\u001a\u00020\u0011H\u0014J\b\u0010#\u001a\u00020\u000bH\u0016J\u001e\u0010$\u001a\u00020\u000b2\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0016j\b\u0012\u0004\u0012\u00020\u0007`\u0017R7\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0016j\b\u0012\u0004\u0012\u00020\u0007`\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001f¨\u0006'"}, d2 = {"Lcom/qiahao/nextvideo/ui/transfer/TransferFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentTransferBinding;", "<init>", "()V", "mListener", "Lkotlin/Function1;", "Lcom/qiahao/nextvideo/data/model/DealerDiamondConfig;", "Lkotlin/ParameterName;", "name", "data", "", "getMListener", "()Lkotlin/jvm/functions/Function1;", "setMListener", "(Lkotlin/jvm/functions/Function1;)V", "mType", "", "getMType", "()I", "setMType", "(I)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getData", "()Ljava/util/ArrayList;", "setData", "(Ljava/util/ArrayList;)V", "mAdapter", "Lcom/qiahao/nextvideo/ui/transfer/TransferFragmentAdapter;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/transfer/TransferFragmentAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "getLayoutResId", "onInitialize", "setListData", "list", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class TransferFragment extends BaseBindingFragment<FragmentTransferBinding> {
    public static final int TRANSFER_DIAMOND = 0;
    public static final int TRANSFER_GEM = 1;

    @NotNull
    public static final String TRANSFER_TYPE = "transfer_type";

    @NotNull
    private ArrayList<DealerDiamondConfig> data = new ArrayList<>();

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.transfer.r1
        public final Object invoke() {
            TransferFragmentAdapter mAdapter_delegate$lambda$0;
            mAdapter_delegate$lambda$0 = TransferFragment.mAdapter_delegate$lambda$0();
            return mAdapter_delegate$lambda$0;
        }
    });

    @Nullable
    private Function1<? super DealerDiamondConfig, Unit> mListener;
    private int mType;

    private final TransferFragmentAdapter getMAdapter() {
        return (TransferFragmentAdapter) this.mAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TransferFragmentAdapter mAdapter_delegate$lambda$0() {
        return new TransferFragmentAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$1(TransferFragment transferFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        DealerDiamondConfig dealerDiamondConfig = (DealerDiamondConfig) transferFragment.getMAdapter().getData().get(i);
        transferFragment.getMAdapter().setMSelect(dealerDiamondConfig);
        Function1<? super DealerDiamondConfig, Unit> function1 = transferFragment.mListener;
        if (function1 != null) {
            function1.invoke(dealerDiamondConfig);
        }
        transferFragment.getMAdapter().notifyDataSetChanged();
    }

    @NotNull
    public final ArrayList<DealerDiamondConfig> getData() {
        return this.data;
    }

    protected int getLayoutResId() {
        return R.layout.fragment_transfer;
    }

    @Nullable
    public final Function1<DealerDiamondConfig, Unit> getMListener() {
        return this.mListener;
    }

    public final int getMType() {
        return this.mType;
    }

    public void onInitialize() {
        int i;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        Bundle arguments = getArguments();
        if (arguments != null) {
            i = arguments.getInt("transfer_type");
        } else {
            i = 0;
        }
        this.mType = i;
        getMAdapter().setMTransferType(this.mType);
        FragmentTransferBinding fragmentTransferBinding = (FragmentTransferBinding) getBinding();
        if (fragmentTransferBinding != null && (recyclerView2 = fragmentTransferBinding.recyclerView) != null) {
            recyclerView2.setAdapter(getMAdapter());
        }
        FragmentTransferBinding fragmentTransferBinding2 = (FragmentTransferBinding) getBinding();
        if (fragmentTransferBinding2 != null && (recyclerView = fragmentTransferBinding2.recyclerView) != null) {
            recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.qiahao.nextvideo.ui.transfer.TransferFragment$onInitialize$1
                public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                    Intrinsics.checkNotNullParameter(outRect, "outRect");
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(parent, "parent");
                    Intrinsics.checkNotNullParameter(state, "state");
                    super.getItemOffsets(outRect, view, parent, state);
                    outRect.top = UiKtxKt.toPX(11);
                    outRect.left = UiKtxKt.toPX(7);
                    outRect.right = UiKtxKt.toPX(7);
                }
            });
        }
        getMAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.transfer.s1
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                TransferFragment.onInitialize$lambda$1(TransferFragment.this, baseQuickAdapter, view, i2);
            }
        });
    }

    public final void setData(@NotNull ArrayList<DealerDiamondConfig> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.data = arrayList;
    }

    public final void setListData(@NotNull ArrayList<DealerDiamondConfig> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        if (list.size() > 0) {
            getMAdapter().setMSelect(list.get(0));
            Function1<? super DealerDiamondConfig, Unit> function1 = this.mListener;
            if (function1 != null) {
                DealerDiamondConfig dealerDiamondConfig = list.get(0);
                Intrinsics.checkNotNullExpressionValue(dealerDiamondConfig, "get(...)");
                function1.invoke(dealerDiamondConfig);
            }
        }
        this.data = list;
        getMAdapter().setList(this.data);
    }

    public final void setMListener(@Nullable Function1<? super DealerDiamondConfig, Unit> function1) {
        this.mListener = function1;
    }

    public final void setMType(int i) {
        this.mType = i;
    }
}
