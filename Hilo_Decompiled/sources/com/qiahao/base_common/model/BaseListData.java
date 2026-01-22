package com.qiahao.base_common.model;

import com.facebook.internal.AnalyticsEvents;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.base_common.interfaceing.OnLoadMoreListener;
import com.qiahao.base_common.interfaceing.OnRefreshListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;
import vc.e;
import vc.g;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 @2\u00020\u0001:\u0001@B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\u0003J\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0010\u001a\u00020\u0007\"\b\b\u0000\u0010\r*\u00020\f2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0010\u001a\u00020\u0007\"\b\b\u0000\u0010\r*\u00020\f2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012¢\u0006\u0004\b\u0010\u0010\u0013J'\u0010\u0010\u001a\u00020\u0007\"\b\b\u0000\u0010\r*\u00020\f2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0014¢\u0006\u0004\b\u0010\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0007¢\u0006\u0004\b\u0016\u0010\u0003J\r\u0010\u0017\u001a\u00020\t¢\u0006\u0004\b\u0017\u0010\u000bJ\r\u0010\u0018\u001a\u00020\u0007¢\u0006\u0004\b\u0018\u0010\u0003J%\u0010\u001d\u001a\u00020\u00072\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u0007¢\u0006\u0004\b\u001f\u0010\u0003J\u0015\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u0015\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020\u0007¢\u0006\u0004\b(\u0010\u0003R\"\u0010)\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010*R\u0016\u0010\u0017\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010/R\u0018\u00100\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00102\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010*R2\u00107\u001a\u0012\u0012\u0004\u0012\u00020 05j\b\u0012\u0004\u0012\u00020 `68\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R2\u0010=\u001a\u0012\u0012\u0004\u0012\u00020$05j\b\u0012\u0004\u0012\u00020$`68\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u00108\u001a\u0004\b>\u0010:\"\u0004\b?\u0010<¨\u0006A"}, d2 = {"Lcom/qiahao/base_common/model/BaseListData;", "Ljava/io/Serializable;", "<init>", "()V", "", "nextPage", "()I", "", "resetOnePage", "", "isOnePage", "()Z", "", "T", "", "list", "setList", "(Ljava/util/List;)V", "Lcom/qiahao/base_common/model/ApiListData;", "(Lcom/qiahao/base_common/model/ApiListData;)V", "Lcom/qiahao/base_common/model/ApiList;", "(Lcom/qiahao/base_common/model/ApiList;)V", "requestError", "hashNextPage", "resetPage", "Ltc/f;", "refresh", "Lcom/oudi/core/status/SuperStatusView;", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "registerStatusLayoutAndRefreshLayout", "(Ltc/f;Lcom/oudi/core/status/SuperStatusView;)V", "setListener", "Lcom/qiahao/base_common/interfaceing/OnRefreshListener;", "refreshListener", "addRefreshListener", "(Lcom/qiahao/base_common/interfaceing/OnRefreshListener;)V", "Lcom/qiahao/base_common/interfaceing/OnLoadMoreListener;", "loadMoreListener", "addLoadMoreListener", "(Lcom/qiahao/base_common/interfaceing/OnLoadMoreListener;)V", "destroy", "pageSize", "I", "getPageSize", "setPageSize", "(I)V", "pageIndex", "Z", "refreshLayout", "Ltc/f;", "statusLayout", "Lcom/oudi/core/status/SuperStatusView;", "servicePageIndex", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onRefreshListenerList", "Ljava/util/ArrayList;", "getOnRefreshListenerList", "()Ljava/util/ArrayList;", "setOnRefreshListenerList", "(Ljava/util/ArrayList;)V", "onLoadMoreListenerList", "getOnLoadMoreListenerList", "setOnLoadMoreListenerList", "Companion", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBaseListData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseListData.kt\ncom/qiahao/base_common/model/BaseListData\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,250:1\n1869#2,2:251\n1869#2,2:253\n*S KotlinDebug\n*F\n+ 1 BaseListData.kt\ncom/qiahao/base_common/model/BaseListData\n*L\n212#1:251,2\n217#1:253,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class BaseListData implements Serializable {
    public static final int DEFAULT_PAGE_SIZE = 10;
    private int pageIndex;

    @Nullable
    private f refreshLayout;

    @Nullable
    private SuperStatusView statusLayout;
    private int pageSize = 10;
    private boolean hashNextPage = true;
    private int servicePageIndex = -1;

    @NotNull
    private ArrayList<OnRefreshListener> onRefreshListenerList = new ArrayList<>();

    @NotNull
    private ArrayList<OnLoadMoreListener> onLoadMoreListenerList = new ArrayList<>();

    public static /* synthetic */ void registerStatusLayoutAndRefreshLayout$default(BaseListData baseListData, f fVar, SuperStatusView superStatusView, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            fVar = null;
        }
        if ((i10 & 2) != 0) {
            superStatusView = null;
        }
        baseListData.registerStatusLayoutAndRefreshLayout(fVar, superStatusView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setListener$lambda$6$lambda$3(BaseListData baseListData, f it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Iterator<T> it2 = baseListData.onRefreshListenerList.iterator();
        while (it2.hasNext()) {
            ((OnRefreshListener) it2.next()).onRefreshListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setListener$lambda$6$lambda$5(BaseListData baseListData, f it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Iterator<T> it2 = baseListData.onLoadMoreListenerList.iterator();
        while (it2.hasNext()) {
            ((OnLoadMoreListener) it2.next()).onLoadMoreListener();
        }
    }

    public final void addLoadMoreListener(@NotNull OnLoadMoreListener loadMoreListener) {
        Intrinsics.checkNotNullParameter(loadMoreListener, "loadMoreListener");
        this.onLoadMoreListenerList.add(loadMoreListener);
    }

    public final void addRefreshListener(@NotNull OnRefreshListener refreshListener) {
        Intrinsics.checkNotNullParameter(refreshListener, "refreshListener");
        this.onRefreshListenerList.add(refreshListener);
    }

    public final void destroy() {
        f fVar = this.refreshLayout;
        if (fVar != null) {
            fVar.setOnRefreshListener((g) null);
        }
        f fVar2 = this.refreshLayout;
        if (fVar2 != null) {
            fVar2.setOnLoadMoreListener((e) null);
        }
        this.refreshLayout = null;
        SuperStatusView superStatusView = this.statusLayout;
        if (superStatusView != null) {
            superStatusView.setOnRetryClickListener(null);
        }
        this.statusLayout = null;
        this.onRefreshListenerList.clear();
        this.onLoadMoreListenerList.clear();
    }

    @NotNull
    public final ArrayList<OnLoadMoreListener> getOnLoadMoreListenerList() {
        return this.onLoadMoreListenerList;
    }

    @NotNull
    public final ArrayList<OnRefreshListener> getOnRefreshListenerList() {
        return this.onRefreshListenerList;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    /* renamed from: hashNextPage, reason: from getter */
    public final boolean getHashNextPage() {
        return this.hashNextPage;
    }

    public final boolean isOnePage() {
        int i10 = this.pageIndex;
        if (i10 == 0 || i10 == 1) {
            return true;
        }
        return false;
    }

    public final int nextPage() {
        int i10 = this.servicePageIndex;
        if (i10 != -1) {
            this.pageIndex = i10;
        } else {
            if (this.pageIndex < 0) {
                this.pageIndex = 0;
            }
            this.pageIndex++;
        }
        return this.pageIndex;
    }

    public final void registerStatusLayoutAndRefreshLayout(@Nullable f refresh, @Nullable SuperStatusView status) {
        if (refresh != null) {
            this.refreshLayout = refresh;
        }
        if (status != null) {
            this.statusLayout = status;
        }
    }

    public final void requestError() {
        SuperStatusView superStatusView;
        f fVar = this.refreshLayout;
        if (fVar != null) {
            fVar.finishRefresh();
        }
        f fVar2 = this.refreshLayout;
        if (fVar2 != null) {
            fVar2.finishLoadMore();
        }
        if (isOnePage() && (superStatusView = this.statusLayout) != null) {
            superStatusView.showEmpty();
        }
        resetOnePage();
    }

    public final void resetOnePage() {
        this.pageIndex--;
    }

    public final void resetPage() {
        this.pageIndex = 0;
        this.servicePageIndex = -1;
        this.hashNextPage = true;
    }

    public final <T> void setList(@Nullable List<? extends T> list) {
        f fVar;
        if (list != null && !list.isEmpty()) {
            this.hashNextPage = list.size() >= this.pageSize;
            f fVar2 = this.refreshLayout;
            if (fVar2 != null) {
                fVar2.finishRefresh();
            }
            f fVar3 = this.refreshLayout;
            if (fVar3 != null) {
                fVar3.finishLoadMore();
            }
            if (!this.hashNextPage && (fVar = this.refreshLayout) != null) {
                fVar.setNoMoreData(true);
            }
            SuperStatusView superStatusView = this.statusLayout;
            if (superStatusView != null) {
                superStatusView.showContent();
                return;
            }
            return;
        }
        this.hashNextPage = false;
        if (isOnePage()) {
            f fVar4 = this.refreshLayout;
            if (fVar4 != null) {
                fVar4.finishRefresh();
            }
            f fVar5 = this.refreshLayout;
            if (fVar5 != null) {
                fVar5.finishLoadMore();
            }
            f fVar6 = this.refreshLayout;
            if (fVar6 != null) {
                fVar6.setNoMoreData(true);
            }
            SuperStatusView superStatusView2 = this.statusLayout;
            if (superStatusView2 != null) {
                superStatusView2.showEmpty();
            }
            this.pageIndex = 0;
            this.servicePageIndex = -1;
            return;
        }
        f fVar7 = this.refreshLayout;
        if (fVar7 != null) {
            fVar7.finishRefresh();
        }
        f fVar8 = this.refreshLayout;
        if (fVar8 != null) {
            fVar8.finishLoadMore();
        }
        f fVar9 = this.refreshLayout;
        if (fVar9 != null) {
            fVar9.setNoMoreData(true);
        }
        SuperStatusView superStatusView3 = this.statusLayout;
        if (superStatusView3 != null) {
            superStatusView3.showContent();
        }
    }

    public final void setListener() {
        f fVar = this.refreshLayout;
        if (fVar != null) {
            fVar.setOnRefreshListener(new g() { // from class: com.qiahao.base_common.model.a
                public final void onRefresh(f fVar2) {
                    BaseListData.setListener$lambda$6$lambda$3(BaseListData.this, fVar2);
                }
            });
            fVar.setOnLoadMoreListener(new e() { // from class: com.qiahao.base_common.model.b
                public final void onLoadMore(f fVar2) {
                    BaseListData.setListener$lambda$6$lambda$5(BaseListData.this, fVar2);
                }
            });
        }
        SuperStatusView superStatusView = this.statusLayout;
        if (superStatusView != null) {
            superStatusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.base_common.model.BaseListData$setListener$2
                @Override // com.oudi.core.status.IStatusView.OnRetryClickListener
                public void onRetry(IStatusView statusView, Status status) {
                    Intrinsics.checkNotNullParameter(statusView, "statusView");
                    Intrinsics.checkNotNullParameter(status, "status");
                    Iterator<T> it = BaseListData.this.getOnRefreshListenerList().iterator();
                    while (it.hasNext()) {
                        ((OnRefreshListener) it.next()).onRefreshListener();
                    }
                }
            });
        }
    }

    public final void setOnLoadMoreListenerList(@NotNull ArrayList<OnLoadMoreListener> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.onLoadMoreListenerList = arrayList;
    }

    public final void setOnRefreshListenerList(@NotNull ArrayList<OnRefreshListener> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.onRefreshListenerList = arrayList;
    }

    public final void setPageSize(int i10) {
        this.pageSize = i10;
    }

    public final <T> void setList(@Nullable ApiListData<T> list) {
        f fVar;
        List<T> data = list != null ? list.getData() : null;
        boolean z10 = false;
        if (data != null && !data.isEmpty()) {
            if (list != null && list.getHasNextPage()) {
                z10 = true;
            }
            this.hashNextPage = z10;
            f fVar2 = this.refreshLayout;
            if (fVar2 != null) {
                fVar2.finishRefresh();
            }
            f fVar3 = this.refreshLayout;
            if (fVar3 != null) {
                fVar3.finishLoadMore();
            }
            if (!this.hashNextPage && (fVar = this.refreshLayout) != null) {
                fVar.setNoMoreData(true);
            }
            SuperStatusView superStatusView = this.statusLayout;
            if (superStatusView != null) {
                superStatusView.showContent();
                return;
            }
            return;
        }
        this.hashNextPage = false;
        if (isOnePage()) {
            f fVar4 = this.refreshLayout;
            if (fVar4 != null) {
                fVar4.finishRefresh();
            }
            f fVar5 = this.refreshLayout;
            if (fVar5 != null) {
                fVar5.finishLoadMore();
            }
            f fVar6 = this.refreshLayout;
            if (fVar6 != null) {
                fVar6.setNoMoreData(true);
            }
            SuperStatusView superStatusView2 = this.statusLayout;
            if (superStatusView2 != null) {
                superStatusView2.showEmpty();
            }
            this.pageIndex = 0;
            this.servicePageIndex = -1;
            return;
        }
        f fVar7 = this.refreshLayout;
        if (fVar7 != null) {
            fVar7.finishRefresh();
        }
        f fVar8 = this.refreshLayout;
        if (fVar8 != null) {
            fVar8.finishLoadMore();
        }
        f fVar9 = this.refreshLayout;
        if (fVar9 != null) {
            fVar9.setNoMoreData(true);
        }
        SuperStatusView superStatusView3 = this.statusLayout;
        if (superStatusView3 != null) {
            superStatusView3.showContent();
        }
    }

    public final <T> void setList(@Nullable ApiList<T> list) {
        f fVar;
        Integer nextPageIndex;
        List<T> data = list != null ? list.getData() : null;
        int i10 = -1;
        boolean z10 = false;
        if (data != null && !data.isEmpty()) {
            if (list != null && list.getHasNextPage()) {
                z10 = true;
            }
            this.hashNextPage = z10;
            if (list != null && (nextPageIndex = list.getNextPageIndex()) != null) {
                i10 = nextPageIndex.intValue();
            }
            this.servicePageIndex = i10;
            f fVar2 = this.refreshLayout;
            if (fVar2 != null) {
                fVar2.finishRefresh();
            }
            f fVar3 = this.refreshLayout;
            if (fVar3 != null) {
                fVar3.finishLoadMore();
            }
            if (!this.hashNextPage && (fVar = this.refreshLayout) != null) {
                fVar.setNoMoreData(true);
            }
            SuperStatusView superStatusView = this.statusLayout;
            if (superStatusView != null) {
                superStatusView.showContent();
                return;
            }
            return;
        }
        this.hashNextPage = false;
        if (isOnePage()) {
            f fVar4 = this.refreshLayout;
            if (fVar4 != null) {
                fVar4.finishRefresh();
            }
            f fVar5 = this.refreshLayout;
            if (fVar5 != null) {
                fVar5.finishLoadMore();
            }
            f fVar6 = this.refreshLayout;
            if (fVar6 != null) {
                fVar6.setNoMoreData(true);
            }
            SuperStatusView superStatusView2 = this.statusLayout;
            if (superStatusView2 != null) {
                superStatusView2.showEmpty();
            }
            this.pageIndex = 0;
            this.servicePageIndex = -1;
            return;
        }
        f fVar7 = this.refreshLayout;
        if (fVar7 != null) {
            fVar7.finishRefresh();
        }
        f fVar8 = this.refreshLayout;
        if (fVar8 != null) {
            fVar8.finishLoadMore();
        }
        f fVar9 = this.refreshLayout;
        if (fVar9 != null) {
            fVar9.setNoMoreData(true);
        }
        SuperStatusView superStatusView3 = this.statusLayout;
        if (superStatusView3 != null) {
            superStatusView3.showContent();
        }
    }
}
