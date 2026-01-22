package com.oudi.adapter.refresh;

import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0019\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\bJ\n\u0010\n\u001a\u0004\u0018\u00010\u000bH&J-\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\u0010J-\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\u0010J\u001e\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0001H&J\u001e\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0001H&J\u001e\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0001H&J8\u0010\u0017\u001a\u00020\r2\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r\u0018\u00010\u00192\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r\u0018\u00010\u0019H&J\u001c\u0010\u001b\u001a\u00020\r2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0\u0019H&J\u001c\u0010\u001c\u001a\u00020\r2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0\u0019H&J\u001c\u0010\u001d\u001a\u00020\r2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0\u0019H&J\u001c\u0010\u001e\u001a\u00020\r2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0\u0019H&¨\u0006\u001f"}, d2 = {"Lcom/oudi/adapter/refresh/IRefreshLayout;", "", "isRefreshing", "", "isLoading", "autoRefresh", "delayed", "", "(Ljava/lang/Integer;)Z", "autoLoadMore", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "finishRefresh", "", "success", "noMoreData", "(ZZLjava/lang/Integer;)V", "finishLoadMore", "setNoMoreData", ViewHierarchyConstants.TAG_KEY, "setEnableRefresh", "enabled", "setEnableLoadMore", "setOnRefreshLoadMoreListener", "onRefresh", "Lkotlin/Function1;", "onLoadMore", "addOnRefreshListener", "addOnLoadMoreListener", "removeOnRefreshListener", "removeOnLoadMoreListener", "lib_adapter_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface IRefreshLayout {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ boolean autoLoadMore$default(IRefreshLayout iRefreshLayout, Integer num, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 1) != 0) {
                    num = null;
                }
                return iRefreshLayout.autoLoadMore(num);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: autoLoadMore");
        }

        public static /* synthetic */ boolean autoRefresh$default(IRefreshLayout iRefreshLayout, Integer num, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 1) != 0) {
                    num = null;
                }
                return iRefreshLayout.autoRefresh(num);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: autoRefresh");
        }

        public static /* synthetic */ void finishLoadMore$default(IRefreshLayout iRefreshLayout, boolean z10, boolean z11, Integer num, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 1) != 0) {
                    z10 = true;
                }
                if ((i10 & 2) != 0) {
                    z11 = false;
                }
                if ((i10 & 4) != 0) {
                    num = null;
                }
                iRefreshLayout.finishLoadMore(z10, z11, num);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: finishLoadMore");
        }

        public static /* synthetic */ void finishRefresh$default(IRefreshLayout iRefreshLayout, boolean z10, boolean z11, Integer num, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 1) != 0) {
                    z10 = true;
                }
                if ((i10 & 2) != 0) {
                    z11 = false;
                }
                if ((i10 & 4) != 0) {
                    num = null;
                }
                iRefreshLayout.finishRefresh(z10, z11, num);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: finishRefresh");
        }

        public static /* synthetic */ void setEnableLoadMore$default(IRefreshLayout iRefreshLayout, boolean z10, Object obj, int i10, Object obj2) {
            if (obj2 == null) {
                if ((i10 & 1) != 0) {
                    z10 = true;
                }
                if ((i10 & 2) != 0) {
                    obj = null;
                }
                iRefreshLayout.setEnableLoadMore(z10, obj);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setEnableLoadMore");
        }

        public static /* synthetic */ void setEnableRefresh$default(IRefreshLayout iRefreshLayout, boolean z10, Object obj, int i10, Object obj2) {
            if (obj2 == null) {
                if ((i10 & 1) != 0) {
                    z10 = true;
                }
                if ((i10 & 2) != 0) {
                    obj = null;
                }
                iRefreshLayout.setEnableRefresh(z10, obj);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setEnableRefresh");
        }

        public static /* synthetic */ void setNoMoreData$default(IRefreshLayout iRefreshLayout, boolean z10, Object obj, int i10, Object obj2) {
            if (obj2 == null) {
                if ((i10 & 1) != 0) {
                    z10 = true;
                }
                if ((i10 & 2) != 0) {
                    obj = null;
                }
                iRefreshLayout.setNoMoreData(z10, obj);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setNoMoreData");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void setOnRefreshLoadMoreListener$default(IRefreshLayout iRefreshLayout, Function1 function1, Function1 function12, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 1) != 0) {
                    function1 = null;
                }
                if ((i10 & 2) != 0) {
                    function12 = null;
                }
                iRefreshLayout.setOnRefreshLoadMoreListener(function1, function12);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOnRefreshLoadMoreListener");
        }
    }

    void addOnLoadMoreListener(Function1<? super IRefreshLayout, Unit> onLoadMore);

    void addOnRefreshListener(Function1<? super IRefreshLayout, Unit> onRefresh);

    boolean autoLoadMore(Integer delayed);

    boolean autoRefresh(Integer delayed);

    void finishLoadMore(boolean success, boolean noMoreData, Integer delayed);

    void finishRefresh(boolean success, boolean noMoreData, Integer delayed);

    RecyclerView getRecyclerView();

    boolean isLoading();

    boolean isRefreshing();

    void removeOnLoadMoreListener(Function1<? super IRefreshLayout, Unit> onLoadMore);

    void removeOnRefreshListener(Function1<? super IRefreshLayout, Unit> onRefresh);

    void setEnableLoadMore(boolean enabled, Object tag);

    void setEnableRefresh(boolean enabled, Object tag);

    void setNoMoreData(boolean noMoreData, Object tag);

    void setOnRefreshLoadMoreListener(Function1<? super IRefreshLayout, Unit> onRefresh, Function1<? super IRefreshLayout, Unit> onLoadMore);
}
