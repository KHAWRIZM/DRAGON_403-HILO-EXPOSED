package com.qiahao.nextvideo.ui.commonlist.billdetails.rechargedetails;

import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.PurchaseItem;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.ui.commonlist.CommonListCellUIModel;
import com.qiahao.nextvideo.ui.commonlist.CommonListViewController;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewControllerKt;
import io.reactivex.rxjava3.core.i0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pd.o;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00100\u000f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/ui/commonlist/billdetails/rechargedetails/RechargeDetailsViewController;", "Lcom/qiahao/nextvideo/ui/commonlist/CommonListViewController;", "<init>", "()V", "Lcom/qiahao/nextvideo/ui/commonlist/CommonListCellUIModel;", "item", "", "position", "", "clickTag", "", "listViewControllerOnItemSelected", "(Lcom/qiahao/nextvideo/ui/commonlist/CommonListCellUIModel;ILjava/lang/String;)V", "pageIndex", "pageSize", "Lio/reactivex/rxjava3/core/i0;", "", "doLoadNextPage", "(II)Lio/reactivex/rxjava3/core/i0;", "getPageTitle", "()Ljava/lang/String;", "pageTitle", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RechargeDetailsViewController extends CommonListViewController {
    public RechargeDetailsViewController() {
        setTag("rechargedetails");
    }

    @Override // com.qiahao.nextvideo.ui.commonlist.DoLoadNextPageDelegate
    @NotNull
    public i0<List<CommonListCellUIModel>> doLoadNextPage(int pageIndex, int pageSize) {
        i0<List<CommonListCellUIModel>> j = UserService.INSTANCE.getShared().fetchUserPaymentsDetail(pageIndex, pageSize).j(new o() { // from class: com.qiahao.nextvideo.ui.commonlist.billdetails.rechargedetails.RechargeDetailsViewController$doLoadNextPage$1
            public final List<CommonListCellUIModel> apply(ApiResponse<List<PurchaseItem>> apiResponse) {
                ArrayList arrayList;
                Intrinsics.checkNotNullParameter(apiResponse, "it");
                List list = (List) apiResponse.getData();
                if (list != null) {
                    RechargeDetailsViewController rechargeDetailsViewController = RechargeDetailsViewController.this;
                    arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(RechargeDetailsViewControllerKt.init(CommonListCellUIModel.INSTANCE, rechargeDetailsViewController.getRequireContext(), (PurchaseItem) it.next()));
                    }
                } else {
                    arrayList = null;
                }
                Intrinsics.checkNotNull(arrayList);
                return arrayList;
            }
        });
        Intrinsics.checkNotNullExpressionValue(j, "map(...)");
        return j;
    }

    @Override // com.qiahao.nextvideo.ui.commonlist.CommonListViewController
    @NotNull
    public String getPageTitle() {
        String str;
        String string = BaseViewControllerKt.getString(this, 2131953857, new Object[0]);
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            str = user.getCode();
        } else {
            str = null;
        }
        return string + "(" + str + ")";
    }

    @Override // com.qiahao.nextvideo.ui.reusable.views.list.ItemListViewWrapperDelegate
    public void listViewControllerOnItemSelected(@NotNull CommonListCellUIModel item, int position, @Nullable String clickTag) {
        Intrinsics.checkNotNullParameter(item, "item");
    }
}
