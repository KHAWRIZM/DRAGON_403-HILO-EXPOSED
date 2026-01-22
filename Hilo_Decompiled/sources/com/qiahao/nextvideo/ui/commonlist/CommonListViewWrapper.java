package com.qiahao.nextvideo.ui.commonlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.CellCommonBinding;
import com.qiahao.nextvideo.ui.commonlist.CommonListViewWrapper;
import com.qiahao.nextvideo.ui.reusable.views.list.ItemListViewWrapper;
import com.qiahao.nextvideo.ui.reusable.views.list.ItemListViewWrapperDelegate;
import com.qiahao.nextvideo.ui.reusable.views.list.ViewHolder;
import io.reactivex.rxjava3.core.i0;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nd.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J \u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\u0016J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u0012H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/qiahao/nextvideo/ui/commonlist/CommonListViewWrapper;", "Lcom/qiahao/nextvideo/ui/reusable/views/list/ItemListViewWrapper;", "Lcom/qiahao/nextvideo/ui/commonlist/CommonListCellUIModel;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "doLoadNextPageDelegate", "Lcom/qiahao/nextvideo/ui/commonlist/DoLoadNextPageDelegate;", "getDoLoadNextPageDelegate", "()Lcom/qiahao/nextvideo/ui/commonlist/DoLoadNextPageDelegate;", "setDoLoadNextPageDelegate", "(Lcom/qiahao/nextvideo/ui/commonlist/DoLoadNextPageDelegate;)V", "doCreateItemViewHolder", "Lcom/qiahao/nextvideo/ui/commonlist/CommonCellViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "bindClickListenerForChildView", "", "onlineCellViewHolder", "doBindItemViewHolder", "holder", "Lcom/qiahao/nextvideo/ui/reusable/views/list/ViewHolder;", "uiModel", "position", "doLoadNextPage", "page", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CommonListViewWrapper extends ItemListViewWrapper<CommonListCellUIModel> {

    @Nullable
    private DoLoadNextPageDelegate doLoadNextPageDelegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonListViewWrapper(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
    }

    private final void bindClickListenerForChildView(CommonCellViewHolder onlineCellViewHolder, View view) {
        Integer num;
        ItemListViewWrapperDelegate<CommonListCellUIModel> delegate;
        Object tag = ((RecyclerView.ViewHolder) onlineCellViewHolder).itemView.getTag(R.id.id_item_position);
        String str = null;
        if (tag instanceof Integer) {
            num = (Integer) tag;
        } else {
            num = null;
        }
        if (num != null) {
            int intValue = num.intValue();
            List<CommonListCellUIModel> items = getItems();
            if (items == null) {
                return;
            }
            Object tag2 = view.getTag();
            if (tag2 instanceof String) {
                str = (String) tag2;
            }
            if (!items.isEmpty() && items.size() > intValue && (delegate = getDelegate()) != null) {
                delegate.listViewControllerOnItemSelected(items.get(intValue), intValue, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doCreateItemViewHolder$lambda$2$lambda$1$lambda$0(CommonListViewWrapper commonListViewWrapper, CommonCellViewHolder commonCellViewHolder, View view) {
        Intrinsics.checkNotNull(view);
        commonListViewWrapper.bindClickListenerForChildView(commonCellViewHolder, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit doLoadNextPage$lambda$3(int i, CommonListViewWrapper commonListViewWrapper, List list) {
        Intrinsics.checkNotNullParameter(list, "it");
        int i2 = i + 1;
        if (list.size() < commonListViewWrapper.getPageSize()) {
            i2 = -1;
        }
        commonListViewWrapper.fillInItemsByPageIndex(list, i, i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit doLoadNextPage$lambda$4(CommonListViewWrapper commonListViewWrapper, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        commonListViewWrapper.onError(th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit doLoadNextPage$lambda$5(CommonListViewWrapper commonListViewWrapper) {
        commonListViewWrapper.getSwipeToRefreshView().finishRefresh();
        return Unit.INSTANCE;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.views.list.ItemListViewWrapper
    public void doLoadNextPage(final int page) {
        i0<List<CommonListCellUIModel>> doLoadNextPage;
        c observeOnMainThread$default;
        DoLoadNextPageDelegate doLoadNextPageDelegate = this.doLoadNextPageDelegate;
        if (doLoadNextPageDelegate != null && (doLoadNextPage = doLoadNextPageDelegate.doLoadNextPage(page, getPageSize())) != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(doLoadNextPage, new Function1() { // from class: mb.f
            public final Object invoke(Object obj) {
                Unit doLoadNextPage$lambda$3;
                doLoadNextPage$lambda$3 = CommonListViewWrapper.doLoadNextPage$lambda$3(page, this, (List) obj);
                return doLoadNextPage$lambda$3;
            }
        }, new Function1() { // from class: mb.g
            public final Object invoke(Object obj) {
                Unit doLoadNextPage$lambda$4;
                doLoadNextPage$lambda$4 = CommonListViewWrapper.doLoadNextPage$lambda$4(CommonListViewWrapper.this, (Throwable) obj);
                return doLoadNextPage$lambda$4;
            }
        }, new Function0() { // from class: mb.h
            public final Object invoke() {
                Unit doLoadNextPage$lambda$5;
                doLoadNextPage$lambda$5 = CommonListViewWrapper.doLoadNextPage$lambda$5(CommonListViewWrapper.this);
                return doLoadNextPage$lambda$5;
            }
        }, false, 8, (Object) null)) != null) {
            RxUtilsKt.addTo(observeOnMainThread$default, getCompositeDisposable());
        }
    }

    @Nullable
    public final DoLoadNextPageDelegate getDoLoadNextPageDelegate() {
        return this.doLoadNextPageDelegate;
    }

    public final void setDoLoadNextPageDelegate(@Nullable DoLoadNextPageDelegate doLoadNextPageDelegate) {
        this.doLoadNextPageDelegate = doLoadNextPageDelegate;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.views.list.ItemListViewWrapper
    public void doBindItemViewHolder(@NotNull ViewHolder holder, @NotNull CommonListCellUIModel uiModel, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(uiModel, "uiModel");
        ((CommonCellViewHolder) holder).bind(uiModel);
    }

    @Override // com.qiahao.nextvideo.ui.reusable.views.list.ItemListViewWrapper
    @NotNull
    public CommonCellViewHolder doCreateItemViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        CellCommonBinding inflate = CellCommonBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNull(inflate);
        final CommonCellViewHolder commonCellViewHolder = new CommonCellViewHolder(inflate);
        commonCellViewHolder.getBinding().endIconImageView.setOnClickListener(new View.OnClickListener() { // from class: mb.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommonListViewWrapper.doCreateItemViewHolder$lambda$2$lambda$1$lambda$0(CommonListViewWrapper.this, commonCellViewHolder, view);
            }
        });
        return commonCellViewHolder;
    }
}
