package com.qiahao.nextvideo.ui.home.discover;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.diff.BrvahAsyncDifferConfig;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.GlobalBroadCastBean;
import com.qiahao.nextvideo.databinding.LayoutDiscoverBroadCastBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.room.StartRoomUtils;
import com.qiahao.nextvideo.ui.home.DiscoverBroadCastAdapter;
import com.qiahao.nextvideo.ui.home.DiscoverBroadCastDiffCallBack;
import com.qiahao.nextvideo.ui.home.GlobalBroadActivity;
import com.qiahao.nextvideo.utilities.FastClickOneUtils;
import com.qiahao.nextvideo.view.youtube.FadeViewHelper;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 )2\u00020\u0001:\u0001)B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010!\u001a\u00020\"H\u0002J\u0006\u0010#\u001a\u00020\"J\u0006\u0010$\u001a\u00020\"J\u000e\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u0018J\u0006\u0010'\u001a\u00020\"J\u0018\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012H\u0002R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0005R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001e¨\u0006*"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/discover/DiscoverBroadCastView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "mBinding", "Lcom/qiahao/nextvideo/databinding/LayoutDiscoverBroadCastBinding;", "mList", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/model/GlobalBroadCastBean;", "Lkotlin/collections/ArrayList;", "mCurrentList", "mCurrentSize", "", "mCurrentMax", "isPinned", "", "mHandler", "Lcom/qiahao/nextvideo/ui/home/discover/DiscoverBroadCastHandler;", "mAdapter", "Lcom/qiahao/nextvideo/ui/home/DiscoverBroadCastAdapter;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/home/DiscoverBroadCastAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "initView", "", "initDataAndView", "initData", "startOrStopAnimation", "start", "setData", "getCurrentData", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDiscoverBroadCastView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DiscoverBroadCastView.kt\ncom/qiahao/nextvideo/ui/home/discover/DiscoverBroadCastView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,196:1\n1#2:197\n61#3,9:198\n*S KotlinDebug\n*F\n+ 1 DiscoverBroadCastView.kt\ncom/qiahao/nextvideo/ui/home/discover/DiscoverBroadCastView\n*L\n89#1:198,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class DiscoverBroadCastView extends LinearLayout {
    private static final int HANDLE_TAG = 1;
    private boolean isPinned;

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter;
    private LayoutDiscoverBroadCastBinding mBinding;

    @NotNull
    private Context mContext;

    @NotNull
    private ArrayList<GlobalBroadCastBean> mCurrentList;
    private int mCurrentMax;
    private int mCurrentSize;
    private DiscoverBroadCastHandler mHandler;

    @NotNull
    private ArrayList<GlobalBroadCastBean> mList;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DiscoverBroadCastView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final ArrayList<GlobalBroadCastBean> getCurrentData() {
        if (this.mCurrentMax < 4) {
            this.mCurrentList.clear();
            this.mCurrentList.addAll(this.mList);
            this.mCurrentSize = 0;
        } else if (this.mCurrentList.size() == 3) {
            int i = this.mCurrentSize + 1;
            this.mCurrentSize = i;
            this.mCurrentSize = i % this.mCurrentMax;
            if (this.isPinned) {
                this.mCurrentList.remove(0);
                this.mCurrentList.add(1, this.mList.get(this.mCurrentSize));
            } else {
                this.mCurrentList.remove(0);
                this.mCurrentList.add(this.mList.get(this.mCurrentSize));
            }
        } else {
            this.mCurrentSize = 2;
            this.mCurrentList.clear();
            this.mCurrentList.add(this.mList.get(0));
            this.mCurrentList.add(this.mList.get(1));
            this.mCurrentList.add(this.mList.get(2));
        }
        ArrayList<GlobalBroadCastBean> arrayList = new ArrayList<>();
        arrayList.addAll(this.mCurrentList);
        return arrayList;
    }

    private final DiscoverBroadCastAdapter getMAdapter() {
        return (DiscoverBroadCastAdapter) this.mAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$7(DiscoverBroadCastView discoverBroadCastView, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        List list = (List) apiResponse.getData();
        if (list != null) {
            discoverBroadCastView.isPinned = false;
            DiscoverBroadCastHandler discoverBroadCastHandler = discoverBroadCastView.mHandler;
            DiscoverBroadCastHandler discoverBroadCastHandler2 = null;
            if (discoverBroadCastHandler == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHandler");
                discoverBroadCastHandler = null;
            }
            discoverBroadCastHandler.removeMessages(1);
            discoverBroadCastView.mCurrentList.clear();
            discoverBroadCastView.getMAdapter().setList((Collection) null);
            discoverBroadCastView.mList.clear();
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list);
            if (arrayList.size() > 3 && ((GlobalBroadCastBean) arrayList.get(0)).isPinned()) {
                Object obj = arrayList.get(0);
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                Object obj2 = arrayList.get(2);
                Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
                arrayList.set(0, (GlobalBroadCastBean) obj2);
                arrayList.set(2, (GlobalBroadCastBean) obj);
                discoverBroadCastView.isPinned = true;
            }
            discoverBroadCastView.mList.addAll(arrayList);
            discoverBroadCastView.mCurrentMax = discoverBroadCastView.mList.size();
            DiscoverBroadCastHandler discoverBroadCastHandler3 = discoverBroadCastView.mHandler;
            if (discoverBroadCastHandler3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHandler");
            } else {
                discoverBroadCastHandler2 = discoverBroadCastHandler3;
            }
            discoverBroadCastHandler2.sendEmptyMessage(1);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$8(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    private final void initView() {
        LayoutDiscoverBroadCastBinding inflate = LayoutDiscoverBroadCastBinding.inflate(LayoutInflater.from(this.mContext), this, true);
        this.mBinding = inflate;
        LayoutDiscoverBroadCastBinding layoutDiscoverBroadCastBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            inflate = null;
        }
        RecyclerView recyclerView = inflate.recyclerView;
        CustomLinearLayoutManager customLinearLayoutManager = new CustomLinearLayoutManager(recyclerView.getContext(), 1, true);
        customLinearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(customLinearLayoutManager);
        recyclerView.setAdapter(getMAdapter());
        getMAdapter().addChildClickViewIds(new int[]{2131361956, R.id.back_content});
        getMAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.c1
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                DiscoverBroadCastView.initView$lambda$4(DiscoverBroadCastView.this, baseQuickAdapter, view, i);
            }
        });
        LayoutDiscoverBroadCastBinding layoutDiscoverBroadCastBinding2 = this.mBinding;
        if (layoutDiscoverBroadCastBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            layoutDiscoverBroadCastBinding = layoutDiscoverBroadCastBinding2;
        }
        final FrameLayout frameLayout = layoutDiscoverBroadCastBinding.parentContent;
        final long j = 800;
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.DiscoverBroadCastView$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(frameLayout) > j || (frameLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(frameLayout, currentTimeMillis);
                    GlobalBroadActivity.Companion companion = GlobalBroadActivity.INSTANCE;
                    Context context = this.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    companion.start(context);
                }
            }
        });
        this.mHandler = new DiscoverBroadCastHandler(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(DiscoverBroadCastView discoverBroadCastView, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        int id2 = view.getId();
        if (id2 != 2131361956) {
            if (id2 == 2131362035) {
                GlobalBroadActivity.Companion companion = GlobalBroadActivity.INSTANCE;
                Context context = discoverBroadCastView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                companion.start(context);
                return;
            }
            return;
        }
        if (FastClickOneUtils.INSTANCE.isFastClick()) {
            Object item = baseQuickAdapter.getItem(i);
            Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.GlobalBroadCastBean");
            StartRoomUtils.startRoom$default(StartRoomUtils.INSTANCE, ((GlobalBroadCastBean) item).getGroupId(), null, null, null, null, null, null, null, 0, 0, null, 0, false, 8190, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DiscoverBroadCastAdapter mAdapter_delegate$lambda$1() {
        DiscoverBroadCastAdapter discoverBroadCastAdapter = new DiscoverBroadCastAdapter(R.layout.item_discover_broad_cast);
        discoverBroadCastAdapter.setDiffConfig(new BrvahAsyncDifferConfig.Builder(new DiscoverBroadCastDiffCallBack()).build());
        return discoverBroadCastAdapter;
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    public final void initData() {
        RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getGlobalBroadCast(0, 50), new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.d1
            public final Object invoke(Object obj) {
                Unit initData$lambda$7;
                initData$lambda$7 = DiscoverBroadCastView.initData$lambda$7(DiscoverBroadCastView.this, (ApiResponse) obj);
                return initData$lambda$7;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.e1
            public final Object invoke(Object obj) {
                Unit initData$lambda$8;
                initData$lambda$8 = DiscoverBroadCastView.initData$lambda$8((Throwable) obj);
                return initData$lambda$8;
            }
        }, (Function0) null, false, 12, (Object) null);
    }

    public final void initDataAndView() {
        initData();
    }

    public final void setData() {
        DiscoverBroadCastHandler discoverBroadCastHandler = null;
        BaseQuickAdapter.setDiffNewData$default(getMAdapter(), getCurrentData(), (Runnable) null, 2, (Object) null);
        if (this.mCurrentMax > 3) {
            DiscoverBroadCastHandler discoverBroadCastHandler2 = this.mHandler;
            if (discoverBroadCastHandler2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHandler");
            } else {
                discoverBroadCastHandler = discoverBroadCastHandler2;
            }
            discoverBroadCastHandler.sendEmptyMessageDelayed(1, FadeViewHelper.DEFAULT_FADE_OUT_DELAY);
        }
    }

    public final void setMContext(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.mContext = context;
    }

    public final void startOrStopAnimation(boolean start) {
        DiscoverBroadCastHandler discoverBroadCastHandler = null;
        if (start) {
            DiscoverBroadCastHandler discoverBroadCastHandler2 = this.mHandler;
            if (discoverBroadCastHandler2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHandler");
            } else {
                discoverBroadCastHandler = discoverBroadCastHandler2;
            }
            discoverBroadCastHandler.sendEmptyMessage(1);
            return;
        }
        DiscoverBroadCastHandler discoverBroadCastHandler3 = this.mHandler;
        if (discoverBroadCastHandler3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHandler");
        } else {
            discoverBroadCastHandler = discoverBroadCastHandler3;
        }
        discoverBroadCastHandler.removeMessages(1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiscoverBroadCastView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mList = new ArrayList<>();
        this.mCurrentList = new ArrayList<>();
        this.mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.discover.f1
            public final Object invoke() {
                DiscoverBroadCastAdapter mAdapter_delegate$lambda$1;
                mAdapter_delegate$lambda$1 = DiscoverBroadCastView.mAdapter_delegate$lambda$1();
                return mAdapter_delegate$lambda$1;
            }
        });
        this.mContext = context;
        initView();
    }
}
