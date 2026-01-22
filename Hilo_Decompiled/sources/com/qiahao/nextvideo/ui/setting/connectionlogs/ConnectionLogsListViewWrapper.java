package com.qiahao.nextvideo.ui.setting.connectionlogs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.model.ConnectLogItem;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.CellConnectionLogBinding;
import com.qiahao.nextvideo.ui.reusable.views.list.ItemListViewWrapper;
import com.qiahao.nextvideo.ui.reusable.views.list.ViewHolder;
import com.qiahao.nextvideo.ui.setting.connectionlogs.ConnectionLogsListViewWrapper;
import java.util.ArrayList;
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

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\fH\u0016J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\fH\u0016¨\u0006\u0015"}, d2 = {"Lcom/qiahao/nextvideo/ui/setting/connectionlogs/ConnectionLogsListViewWrapper;", "Lcom/qiahao/nextvideo/ui/reusable/views/list/ItemListViewWrapper;", "Lcom/qiahao/nextvideo/ui/setting/connectionlogs/ConnectionLogCellUIModel;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "doCreateItemViewHolder", "Lcom/qiahao/nextvideo/ui/setting/connectionlogs/ConnectionLogViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "doBindItemViewHolder", "", "holder", "Lcom/qiahao/nextvideo/ui/reusable/views/list/ViewHolder;", "item", "position", "doLoadNextPage", "page", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nConnectLogsListViewWrapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectLogsListViewWrapper.kt\ncom/qiahao/nextvideo/ui/setting/connectionlogs/ConnectionLogsListViewWrapper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,42:1\n1563#2:43\n1634#2,3:44\n*S KotlinDebug\n*F\n+ 1 ConnectLogsListViewWrapper.kt\ncom/qiahao/nextvideo/ui/setting/connectionlogs/ConnectionLogsListViewWrapper\n*L\n30#1:43\n30#1:44,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ConnectionLogsListViewWrapper extends ItemListViewWrapper<ConnectionLogCellUIModel> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConnectionLogsListViewWrapper(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit doLoadNextPage$lambda$2(ConnectionLogsListViewWrapper connectionLogsListViewWrapper, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        List list = (List) apiResponse.getData();
        if (list != null) {
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(ConnectionLogCellUIModel.INSTANCE.init((ConnectLogItem) it.next()));
            }
            connectionLogsListViewWrapper.setItems(arrayList, -1);
        }
        connectionLogsListViewWrapper.getSwipeToRefreshView().finishRefresh();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit doLoadNextPage$lambda$3(ConnectionLogsListViewWrapper connectionLogsListViewWrapper, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        connectionLogsListViewWrapper.onError(th);
        connectionLogsListViewWrapper.getSwipeToRefreshView().finishRefresh();
        return Unit.INSTANCE;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.views.list.ItemListViewWrapper
    public void doLoadNextPage(int page) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.fetchConnectLogs$default(UserService.INSTANCE.getShared(), false, 1, null), new Function1() { // from class: tb.a
            public final Object invoke(Object obj) {
                Unit doLoadNextPage$lambda$2;
                doLoadNextPage$lambda$2 = ConnectionLogsListViewWrapper.doLoadNextPage$lambda$2(ConnectionLogsListViewWrapper.this, (ApiResponse) obj);
                return doLoadNextPage$lambda$2;
            }
        }, new Function1() { // from class: tb.b
            public final Object invoke(Object obj) {
                Unit doLoadNextPage$lambda$3;
                doLoadNextPage$lambda$3 = ConnectionLogsListViewWrapper.doLoadNextPage$lambda$3(ConnectionLogsListViewWrapper.this, (Throwable) obj);
                return doLoadNextPage$lambda$3;
            }
        }, (Function0) null, false, 12, (Object) null), getCompositeDisposable());
    }

    @Override // com.qiahao.nextvideo.ui.reusable.views.list.ItemListViewWrapper
    public void doBindItemViewHolder(@NotNull ViewHolder holder, @NotNull ConnectionLogCellUIModel item, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ((ConnectionLogViewHolder) holder).bind(item);
    }

    @Override // com.qiahao.nextvideo.ui.reusable.views.list.ItemListViewWrapper
    @NotNull
    public ConnectionLogViewHolder doCreateItemViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        CellConnectionLogBinding inflate = CellConnectionLogBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ConnectionLogViewHolder(inflate);
    }
}
