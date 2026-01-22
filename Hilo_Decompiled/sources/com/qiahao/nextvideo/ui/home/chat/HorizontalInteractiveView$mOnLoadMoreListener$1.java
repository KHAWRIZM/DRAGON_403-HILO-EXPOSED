package com.qiahao.nextvideo.ui.home.chat;

import android.util.Log;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.model.MessageTopData;
import com.qiahao.nextvideo.data.model.PrivateRecordBean;
import com.qiahao.nextvideo.network.AppServer;
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

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/qiahao/nextvideo/ui/home/chat/HorizontalInteractiveView$mOnLoadMoreListener$1", "Lcom/qiahao/nextvideo/ui/home/chat/OnLoadMoreListener;", "loadMore", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHorizontalInteractiveViewWrapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HorizontalInteractiveViewWrapper.kt\ncom/qiahao/nextvideo/ui/home/chat/HorizontalInteractiveView$mOnLoadMoreListener$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,258:1\n1563#2:259\n1634#2,3:260\n*S KotlinDebug\n*F\n+ 1 HorizontalInteractiveViewWrapper.kt\ncom/qiahao/nextvideo/ui/home/chat/HorizontalInteractiveView$mOnLoadMoreListener$1\n*L\n69#1:259\n69#1:260,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class HorizontalInteractiveView$mOnLoadMoreListener$1 extends OnLoadMoreListener {
    final /* synthetic */ HorizontalInteractiveView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HorizontalInteractiveView$mOnLoadMoreListener$1(HorizontalInteractiveView horizontalInteractiveView) {
        this.this$0 = horizontalInteractiveView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit loadMore$lambda$2(HorizontalInteractiveView horizontalInteractiveView, HorizontalInteractiveView$mOnLoadMoreListener$1 horizontalInteractiveView$mOnLoadMoreListener$1, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        List list = (List) apiResponse.getData();
        if (list != null) {
            if (!list.isEmpty() && list.size() >= horizontalInteractiveView.getMPageSize()) {
                horizontalInteractiveView.setMIsCanLoadMore(true);
                horizontalInteractiveView$mOnLoadMoreListener$1.setLastItemCount(0);
            } else {
                horizontalInteractiveView.setMIsCanLoadMore(false);
            }
            horizontalInteractiveView.setMIndex(horizontalInteractiveView.getMIndex() + 1);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new MessageTopData(2, (PrivateRecordBean) it.next(), null, 4, null));
            }
            horizontalInteractiveView.getMAdapter().addData(arrayList);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit loadMore$lambda$3(HorizontalInteractiveView$mOnLoadMoreListener$1 horizontalInteractiveView$mOnLoadMoreListener$1, HorizontalInteractiveView horizontalInteractiveView, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        horizontalInteractiveView$mOnLoadMoreListener$1.setLastPosition(0);
        horizontalInteractiveView.setMIsCanLoadMore(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit loadMore$lambda$4(HorizontalInteractiveView horizontalInteractiveView) {
        horizontalInteractiveView.getMDataBinding().cellLoadingProgressBar.setVisibility(8);
        return Unit.INSTANCE;
    }

    @Override // com.qiahao.nextvideo.ui.home.chat.OnLoadMoreListener
    public void loadMore() {
        if (!this.this$0.getMIsCanLoadMore()) {
            return;
        }
        Log.d("HorizontalInteractiveVi", "loadMore: 加载新的数据");
        this.this$0.getMDataBinding().cellLoadingProgressBar.setVisibility(0);
        io.reactivex.rxjava3.core.i0<ApiResponse<List<PrivateRecordBean>>> privateRecordList = AppServer.INSTANCE.getApis().privateRecordList(this.this$0.getMPageSize(), this.this$0.getMIndex());
        final HorizontalInteractiveView horizontalInteractiveView = this.this$0;
        Function1 function1 = new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.s
            public final Object invoke(Object obj) {
                Unit loadMore$lambda$2;
                loadMore$lambda$2 = HorizontalInteractiveView$mOnLoadMoreListener$1.loadMore$lambda$2(HorizontalInteractiveView.this, this, (ApiResponse) obj);
                return loadMore$lambda$2;
            }
        };
        final HorizontalInteractiveView horizontalInteractiveView2 = this.this$0;
        Function1 function12 = new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.t
            public final Object invoke(Object obj) {
                Unit loadMore$lambda$3;
                loadMore$lambda$3 = HorizontalInteractiveView$mOnLoadMoreListener$1.loadMore$lambda$3(HorizontalInteractiveView$mOnLoadMoreListener$1.this, horizontalInteractiveView2, (Throwable) obj);
                return loadMore$lambda$3;
            }
        };
        final HorizontalInteractiveView horizontalInteractiveView3 = this.this$0;
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(privateRecordList, function1, function12, new Function0() { // from class: com.qiahao.nextvideo.ui.home.chat.u
            public final Object invoke() {
                Unit loadMore$lambda$4;
                loadMore$lambda$4 = HorizontalInteractiveView$mOnLoadMoreListener$1.loadMore$lambda$4(HorizontalInteractiveView.this);
                return loadMore$lambda$4;
            }
        }, false, 8, (Object) null), this.this$0.getMCompositeDisposable());
    }
}
