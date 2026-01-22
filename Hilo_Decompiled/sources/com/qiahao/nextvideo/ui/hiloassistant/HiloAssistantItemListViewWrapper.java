package com.qiahao.nextvideo.ui.hiloassistant;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.model.HiloAssistantItem;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.CellHiloAssistantBeansHolderType1Binding;
import com.qiahao.nextvideo.databinding.CellHiloAssistantBinding;
import com.qiahao.nextvideo.databinding.CellHiloAssistantEnterCarBinding;
import com.qiahao.nextvideo.databinding.CellHiloAssistantHolderType1Binding;
import com.qiahao.nextvideo.databinding.CellHiloAssistantPraiseBinding;
import com.qiahao.nextvideo.ui.reusable.views.list.ItemListViewWrapper;
import com.qiahao.nextvideo.ui.reusable.views.list.ViewHolder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\u0018\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0013H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/qiahao/nextvideo/ui/hiloassistant/HiloAssistantItemListViewWrapper;", "Lcom/qiahao/nextvideo/ui/reusable/views/list/ItemListViewWrapper;", "Lcom/qiahao/nextvideo/ui/hiloassistant/HiloAssistantCellUIModel;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "clickListener", "Lcom/qiahao/nextvideo/ui/hiloassistant/ClickListener;", "getClickListener", "()Lcom/qiahao/nextvideo/ui/hiloassistant/ClickListener;", "setClickListener", "(Lcom/qiahao/nextvideo/ui/hiloassistant/ClickListener;)V", "doBindItemViewHolder", "", "holder", "Lcom/qiahao/nextvideo/ui/reusable/views/list/ViewHolder;", "item", "position", "", "doCreateItemViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "doGetViewType", "doLoadNextPage", "page", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHiloAssistantItemListViewWrapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HiloAssistantItemListViewWrapper.kt\ncom/qiahao/nextvideo/ui/hiloassistant/HiloAssistantItemListViewWrapper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,177:1\n1563#2:178\n1634#2,3:179\n*S KotlinDebug\n*F\n+ 1 HiloAssistantItemListViewWrapper.kt\ncom/qiahao/nextvideo/ui/hiloassistant/HiloAssistantItemListViewWrapper\n*L\n155#1:178\n155#1:179,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class HiloAssistantItemListViewWrapper extends ItemListViewWrapper<HiloAssistantCellUIModel> {
    public static final int ACTIVITY_GET_CAR = 16;
    public static final int ACTIVITY_GET_DIAMOND = 15;
    public static final int ACTIVITY_GROUP_SUPPORT_DIAMOND = 17;
    public static final int ACTIVITY_MANAGER_SEND_DIAMOND = 14;
    public static final int ACTIVITY_MANAGER_SEND_PROPS = 19;
    public static final int ACTIVITY_MISS_MR_CAR_TIME = 12;
    public static final int ACTIVITY_MISS_MR_DIOMAND = 11;
    public static final int PAGE_SIZE = 20;
    public static final int PRAISE = 66;
    public static final int RECEVIER_GIFT_BEANS = 13;
    public static final int RECEVIER_GIFT_DIOMAND = 9;
    public static final int SEND_PROPS = 20;

    @Nullable
    private ClickListener clickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HiloAssistantItemListViewWrapper(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit doLoadNextPage$lambda$2(HiloAssistantItemListViewWrapper hiloAssistantItemListViewWrapper, int i, ApiResponse apiResponse) {
        Collection collection;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        List list = (List) apiResponse.getData();
        if (list != null) {
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(HiloAssistantCellUIModel.INSTANCE.init((HiloAssistantItem) it.next()));
            }
            int i2 = i + 1;
            if (arrayList.size() < 20) {
                i2 = -1;
            }
            hiloAssistantItemListViewWrapper.fillInItemsByPageIndex(arrayList, i, i2);
        }
        ClickListener clickListener = hiloAssistantItemListViewWrapper.clickListener;
        if (clickListener != null) {
            boolean z = true;
            if (i != 1 || ((collection = (Collection) apiResponse.getData()) != null && !collection.isEmpty())) {
                z = false;
            }
            clickListener.noData(z);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit doLoadNextPage$lambda$3(HiloAssistantItemListViewWrapper hiloAssistantItemListViewWrapper, int i, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        hiloAssistantItemListViewWrapper.onError(th);
        ClickListener clickListener = hiloAssistantItemListViewWrapper.clickListener;
        if (clickListener != null) {
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            clickListener.noData(z);
        }
        return Unit.INSTANCE;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.views.list.ItemListViewWrapper
    @NotNull
    public ViewHolder doCreateItemViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 9) {
            if (viewType != 66) {
                if (viewType != 19 && viewType != 20) {
                    switch (viewType) {
                        case 11:
                        case 14:
                        case 15:
                        case 17:
                            break;
                        case 12:
                        case 16:
                            break;
                        case 13:
                            CellHiloAssistantBeansHolderType1Binding inflate = CellHiloAssistantBeansHolderType1Binding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
                            return new HiloAssistantBeansTypeViewHolder(inflate);
                        default:
                            CellHiloAssistantBinding inflate2 = CellHiloAssistantBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                            Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(...)");
                            return new HiloAssistantViewHolder(inflate2);
                    }
                }
                CellHiloAssistantEnterCarBinding inflate3 = CellHiloAssistantEnterCarBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                Intrinsics.checkNotNullExpressionValue(inflate3, "inflate(...)");
                return new HiloAssistantCarTypeViewHolder(inflate3);
            }
            CellHiloAssistantPraiseBinding inflate4 = CellHiloAssistantPraiseBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate4, "inflate(...)");
            return new HiloAssistantPraiseViewHolder(inflate4);
        }
        CellHiloAssistantHolderType1Binding inflate5 = CellHiloAssistantHolderType1Binding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate5, "inflate(...)");
        return new HiloAssistantDiamondTypeViewHolder(inflate5);
    }

    @Override // com.qiahao.nextvideo.ui.reusable.views.list.ItemListViewWrapper
    public void doLoadNextPage(final int page) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().fetchHiloAssistants(page, 20), new Function1() { // from class: com.qiahao.nextvideo.ui.hiloassistant.d
            public final Object invoke(Object obj) {
                Unit doLoadNextPage$lambda$2;
                doLoadNextPage$lambda$2 = HiloAssistantItemListViewWrapper.doLoadNextPage$lambda$2(HiloAssistantItemListViewWrapper.this, page, (ApiResponse) obj);
                return doLoadNextPage$lambda$2;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.hiloassistant.e
            public final Object invoke(Object obj) {
                Unit doLoadNextPage$lambda$3;
                doLoadNextPage$lambda$3 = HiloAssistantItemListViewWrapper.doLoadNextPage$lambda$3(HiloAssistantItemListViewWrapper.this, page, (Throwable) obj);
                return doLoadNextPage$lambda$3;
            }
        }, (Function0) null, false, 12, (Object) null), getCompositeDisposable());
    }

    @Nullable
    public final ClickListener getClickListener() {
        return this.clickListener;
    }

    public final void setClickListener(@Nullable ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.views.list.ItemListViewWrapper
    public void doBindItemViewHolder(@NotNull ViewHolder holder, @NotNull HiloAssistantCellUIModel item, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        int type = item.getType();
        if (type != 9) {
            if (type != 66) {
                if (type != 19 && type != 20) {
                    switch (type) {
                        case 11:
                        case 14:
                        case 15:
                        case 17:
                            break;
                        case 12:
                        case 16:
                            break;
                        case 13:
                            ((HiloAssistantBeansTypeViewHolder) holder).bind(item, this.clickListener);
                            return;
                        default:
                            ((HiloAssistantViewHolder) holder).bind(item, this.clickListener);
                            return;
                    }
                }
                ((HiloAssistantCarTypeViewHolder) holder).bind(item, this.clickListener);
                return;
            }
            ((HiloAssistantPraiseViewHolder) holder).bind(item, this.clickListener);
            return;
        }
        ((HiloAssistantDiamondTypeViewHolder) holder).bind(item, this.clickListener);
    }

    @Override // com.qiahao.nextvideo.ui.reusable.views.list.ItemListViewWrapper
    public int doGetViewType(@NotNull HiloAssistantCellUIModel item, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item.getType();
    }
}
