package com.qiahao.nextvideo.ui.home.onlinefeed;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.network.model.OnlineUserListResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.CellOnlineBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.network.ServerApi;
import com.qiahao.nextvideo.ui.home.onlinefeed.list.OnlineCellUIModel;
import com.qiahao.nextvideo.ui.reusable.views.list.ItemListViewWrapper;
import com.qiahao.nextvideo.ui.reusable.views.list.ItemListViewWrapperDelegate;
import com.qiahao.nextvideo.ui.reusable.views.list.ViewHolder;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00010B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\nH\u0017J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J \u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\nH\u0016J\u0010\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020\nH\u0016J\u0006\u0010*\u001a\u00020!J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020!2\u0006\u0010%\u001a\u00020\u001cH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u00061"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/onlinefeed/OnlineUsersItemListViewWrapper;", "Lcom/qiahao/nextvideo/ui/reusable/views/list/ItemListViewWrapper;", "Lcom/qiahao/nextvideo/ui/home/onlinefeed/list/OnlineCellUIModel;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", Constants.SP_KEY_VERSION, "", Constants.KEY_MODEL, "", "lastIndex", "nextPage", "pageSize", "getPageSize", "()I", "setPageSize", "(I)V", "firstIndex", "getFirstIndex", "setFirstIndex", "onlineUsersItemListViewWrapperDelegate", "Lcom/qiahao/nextvideo/ui/home/onlinefeed/OnlineUsersItemListViewWrapperDelegate;", "getOnlineUsersItemListViewWrapperDelegate", "()Lcom/qiahao/nextvideo/ui/home/onlinefeed/OnlineUsersItemListViewWrapperDelegate;", "setOnlineUsersItemListViewWrapperDelegate", "(Lcom/qiahao/nextvideo/ui/home/onlinefeed/OnlineUsersItemListViewWrapperDelegate;)V", "doCreateItemViewHolder", "Lcom/qiahao/nextvideo/ui/reusable/views/list/ViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "bindClickListenerForChildView", "", "onlineCellViewHolder", "Lcom/qiahao/nextvideo/ui/home/onlinefeed/OnlineCellViewHolder;", "doBindItemViewHolder", "holder", "item", "position", "doLoadNextPage", "pageIndex", "reset", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "onViewAttachedToWindow", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nOnlineUsersItemListViewWrapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OnlineUsersItemListViewWrapper.kt\ncom/qiahao/nextvideo/ui/home/onlinefeed/OnlineUsersItemListViewWrapper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,285:1\n1563#2:286\n1634#2,3:287\n*S KotlinDebug\n*F\n+ 1 OnlineUsersItemListViewWrapper.kt\ncom/qiahao/nextvideo/ui/home/onlinefeed/OnlineUsersItemListViewWrapper\n*L\n156#1:286\n156#1:287,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class OnlineUsersItemListViewWrapper extends ItemListViewWrapper<OnlineCellUIModel> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String TAG = "OnlineUsersItemListView";

    @NotNull
    private static final la.c relay;
    private int firstIndex;
    private int lastIndex;
    private int model;
    private int nextPage;

    @Nullable
    private OnlineUsersItemListViewWrapperDelegate onlineUsersItemListViewWrapperDelegate;
    private int pageSize;

    @Nullable
    private String version;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R%\u0010\u0007\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/onlinefeed/OnlineUsersItemListViewWrapper$Companion;", "", "<init>", "()V", "Lla/c;", "Lcom/qiahao/nextvideo/ui/home/onlinefeed/AnimationEvent;", "kotlin.jvm.PlatformType", "relay", "Lla/c;", "getRelay", "()Lla/c;", "", "TAG", "Ljava/lang/String;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final la.c getRelay() {
            return OnlineUsersItemListViewWrapper.relay;
        }

        private Companion() {
        }
    }

    static {
        la.c e = la.c.e();
        Intrinsics.checkNotNullExpressionValue(e, "create(...)");
        relay = e;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnlineUsersItemListViewWrapper(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.nextPage = 1;
        this.pageSize = 8;
        this.firstIndex = -1;
    }

    private final void bindClickListenerForChildView(OnlineCellViewHolder onlineCellViewHolder, View view) {
        Integer num;
        Object tag = ((RecyclerView.ViewHolder) onlineCellViewHolder).itemView.getTag(R.id.id_item_position);
        if (tag instanceof Integer) {
            num = (Integer) tag;
        } else {
            num = null;
        }
        if (num != null) {
            int intValue = num.intValue();
            List<OnlineCellUIModel> items = getItems();
            if (items == null) {
                return;
            }
            Object tag2 = view.getTag();
            Intrinsics.checkNotNull(tag2, "null cannot be cast to non-null type kotlin.String");
            String str = (String) tag2;
            ItemListViewWrapperDelegate<OnlineCellUIModel> delegate = getDelegate();
            if (delegate != null) {
                delegate.listViewControllerOnItemSelected(items.get(intValue), intValue, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doCreateItemViewHolder$lambda$2(OnlineUsersItemListViewWrapper onlineUsersItemListViewWrapper, OnlineCellViewHolder onlineCellViewHolder, View view) {
        Intrinsics.checkNotNull(view);
        onlineUsersItemListViewWrapper.bindClickListenerForChildView(onlineCellViewHolder, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doCreateItemViewHolder$lambda$3(OnlineUsersItemListViewWrapper onlineUsersItemListViewWrapper, OnlineCellViewHolder onlineCellViewHolder, View view) {
        Intrinsics.checkNotNull(view);
        onlineUsersItemListViewWrapper.bindClickListenerForChildView(onlineCellViewHolder, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doCreateItemViewHolder$lambda$4(OnlineUsersItemListViewWrapper onlineUsersItemListViewWrapper, OnlineCellViewHolder onlineCellViewHolder, View view) {
        Intrinsics.checkNotNull(view);
        onlineUsersItemListViewWrapper.bindClickListenerForChildView(onlineCellViewHolder, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit doLoadNextPage$lambda$7(OnlineUsersItemListViewWrapper onlineUsersItemListViewWrapper, int i, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        OnlineUserListResponse onlineUserListResponse = (OnlineUserListResponse) apiResponse.getData();
        if (onlineUserListResponse != null) {
            onlineUsersItemListViewWrapper.version = onlineUserListResponse.getVersion();
            onlineUsersItemListViewWrapper.lastIndex = onlineUserListResponse.getLastIndex();
            onlineUsersItemListViewWrapper.model = onlineUserListResponse.getModel();
            onlineUsersItemListViewWrapper.firstIndex = onlineUserListResponse.getFirstIndex();
            List list = onlineUserListResponse.getList();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(OnlineCellUIModel.INSTANCE.init((User) it.next()));
            }
            int i2 = onlineUsersItemListViewWrapper.nextPage + 1;
            onlineUsersItemListViewWrapper.nextPage = i2;
            if (onlineUsersItemListViewWrapper.lastIndex == -1) {
                onlineUsersItemListViewWrapper.nextPage = -1;
                i2 = -1;
            }
            onlineUsersItemListViewWrapper.fillInItemsByPageIndex(arrayList, i, i2);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit doLoadNextPage$lambda$8(OnlineUsersItemListViewWrapper onlineUsersItemListViewWrapper, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        onlineUsersItemListViewWrapper.onError(th);
        return Unit.INSTANCE;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.views.list.ItemListViewWrapper
    @SuppressLint({"ClickableViewAccessibility"})
    @NotNull
    public ViewHolder doCreateItemViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        CellOnlineBinding inflate = CellOnlineBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        final OnlineCellViewHolder onlineCellViewHolder = new OnlineCellViewHolder(inflate);
        final GestureDetector gestureDetector = new GestureDetector(onlineCellViewHolder.getBinding().getRoot().getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.qiahao.nextvideo.ui.home.onlinefeed.OnlineUsersItemListViewWrapper$doCreateItemViewHolder$onlineCellViewHolder$1$gestureDetector$1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent e) {
                Integer num;
                Intrinsics.checkNotNullParameter(e, "e");
                Object tag = ((RecyclerView.ViewHolder) OnlineCellViewHolder.this).itemView.getTag(R.id.id_item_position);
                OnlineCellUIModel onlineCellUIModel = null;
                if (tag instanceof Integer) {
                    num = (Integer) tag;
                } else {
                    num = null;
                }
                if (num != null) {
                    OnlineUsersItemListViewWrapper onlineUsersItemListViewWrapper = this;
                    int intValue = num.intValue();
                    OnlineUsersItemListViewWrapperDelegate onlineUsersItemListViewWrapperDelegate = onlineUsersItemListViewWrapper.getOnlineUsersItemListViewWrapperDelegate();
                    if (onlineUsersItemListViewWrapperDelegate != null) {
                        List<OnlineCellUIModel> items = onlineUsersItemListViewWrapper.getItems();
                        if (items != null) {
                            onlineCellUIModel = (OnlineCellUIModel) CollectionsKt.getOrNull(items, intValue);
                        }
                        onlineUsersItemListViewWrapperDelegate.onlineUsersItemListViewWrapperDelegateDidDoubleTab(onlineCellUIModel);
                    }
                }
                return super.onDoubleTap(e);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent e) {
                Intrinsics.checkNotNullParameter(e, "e");
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent e) {
                Integer num;
                Intrinsics.checkNotNullParameter(e, "e");
                Object tag = ((RecyclerView.ViewHolder) OnlineCellViewHolder.this).itemView.getTag(R.id.id_item_position);
                OnlineCellUIModel onlineCellUIModel = null;
                if (tag instanceof Integer) {
                    num = (Integer) tag;
                } else {
                    num = null;
                }
                if (num != null) {
                    OnlineUsersItemListViewWrapper onlineUsersItemListViewWrapper = this;
                    int intValue = num.intValue();
                    OnlineUsersItemListViewWrapperDelegate onlineUsersItemListViewWrapperDelegate = onlineUsersItemListViewWrapper.getOnlineUsersItemListViewWrapperDelegate();
                    if (onlineUsersItemListViewWrapperDelegate != null) {
                        List<OnlineCellUIModel> items = onlineUsersItemListViewWrapper.getItems();
                        if (items != null) {
                            onlineCellUIModel = (OnlineCellUIModel) CollectionsKt.getOrNull(items, intValue);
                        }
                        onlineUsersItemListViewWrapperDelegate.onlineUsersItemListViewWrapperDelegateDidSingleTab(onlineCellUIModel);
                    }
                }
                return super.onSingleTapConfirmed(e);
            }
        });
        onlineCellViewHolder.getBinding().backgroundCorneredImageView.setOnTouchListener(new View.OnTouchListener() { // from class: com.qiahao.nextvideo.ui.home.onlinefeed.r
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean onTouchEvent;
                onTouchEvent = gestureDetector.onTouchEvent(motionEvent);
                return onTouchEvent;
            }
        });
        onlineCellViewHolder.getBinding().chatImageView.setClearsAfterDetached(true);
        onlineCellViewHolder.getBinding().backgroundCorneredImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.onlinefeed.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OnlineUsersItemListViewWrapper.doCreateItemViewHolder$lambda$2(OnlineUsersItemListViewWrapper.this, onlineCellViewHolder, view);
            }
        });
        onlineCellViewHolder.getBinding().likeImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.onlinefeed.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OnlineUsersItemListViewWrapper.doCreateItemViewHolder$lambda$3(OnlineUsersItemListViewWrapper.this, onlineCellViewHolder, view);
            }
        });
        onlineCellViewHolder.getBinding().chatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.onlinefeed.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OnlineUsersItemListViewWrapper.doCreateItemViewHolder$lambda$4(OnlineUsersItemListViewWrapper.this, onlineCellViewHolder, view);
            }
        });
        return onlineCellViewHolder;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.views.list.ItemListViewWrapper
    public void doLoadNextPage(final int pageIndex) {
        int i;
        int i2 = -1;
        if (pageIndex == 1) {
            this.nextPage = 1;
            this.model = 0;
            this.lastIndex = 0;
            setPageSize(8);
            this.firstIndex = -1;
        }
        ServerApi apis = AppServer.INSTANCE.getApis();
        int pageSize = getPageSize();
        String str = this.version;
        if (pageIndex == 1) {
            i = 0;
        } else {
            i = this.lastIndex;
        }
        Integer valueOf = Integer.valueOf(this.model);
        if (pageIndex != 1) {
            i2 = this.firstIndex;
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(apis.fetchOnlineUsersNew(pageSize, str, i, valueOf, Integer.valueOf(i2)), new Function1() { // from class: com.qiahao.nextvideo.ui.home.onlinefeed.v
            public final Object invoke(Object obj) {
                Unit doLoadNextPage$lambda$7;
                doLoadNextPage$lambda$7 = OnlineUsersItemListViewWrapper.doLoadNextPage$lambda$7(OnlineUsersItemListViewWrapper.this, pageIndex, (ApiResponse) obj);
                return doLoadNextPage$lambda$7;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.onlinefeed.w
            public final Object invoke(Object obj) {
                Unit doLoadNextPage$lambda$8;
                doLoadNextPage$lambda$8 = OnlineUsersItemListViewWrapper.doLoadNextPage$lambda$8(OnlineUsersItemListViewWrapper.this, (Throwable) obj);
                return doLoadNextPage$lambda$8;
            }
        }, (Function0) null, false, 12, (Object) null), getCompositeDisposable());
    }

    public final int getFirstIndex() {
        return this.firstIndex;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.views.list.ItemListViewWrapper
    @NotNull
    public RecyclerView.LayoutManager getLayoutManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new GridLayoutManager(context, 2);
    }

    @Nullable
    public final OnlineUsersItemListViewWrapperDelegate getOnlineUsersItemListViewWrapperDelegate() {
        return this.onlineUsersItemListViewWrapperDelegate;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.views.list.ItemListViewWrapper
    public int getPageSize() {
        return this.pageSize;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.views.list.ItemListViewWrapper, com.qiahao.nextvideo.ui.reusable.views.list.ItemListCallback
    public void onViewAttachedToWindow(@NotNull ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof OnlineCellViewHolder) {
            ((OnlineCellViewHolder) holder).getBinding().chatImageView.startAnimation();
        }
    }

    public final void reset() {
        clearItems();
        getCompositeDisposable().d();
    }

    public final void setFirstIndex(int i) {
        this.firstIndex = i;
    }

    public final void setOnlineUsersItemListViewWrapperDelegate(@Nullable OnlineUsersItemListViewWrapperDelegate onlineUsersItemListViewWrapperDelegate) {
        this.onlineUsersItemListViewWrapperDelegate = onlineUsersItemListViewWrapperDelegate;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.views.list.ItemListViewWrapper
    public void setPageSize(int i) {
        this.pageSize = i;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.views.list.ItemListViewWrapper
    public void doBindItemViewHolder(@NotNull ViewHolder holder, @NotNull OnlineCellUIModel item, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ((RecyclerView.ViewHolder) holder).itemView.setTag(R.id.id_item_position, Integer.valueOf(position));
        ((OnlineCellViewHolder) holder).bind(item);
    }
}
