package com.qiahao.nextvideo.ui.home.group.my;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;
import com.google.android.material.appbar.AppBarLayout;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.data.cache.MMKVToLocalCache;
import com.qiahao.nextvideo.data.model.CreateGroupBean;
import com.qiahao.nextvideo.data.model.HotGroupBean;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.databinding.FragmentMyRoomBinding;
import com.qiahao.nextvideo.room.StartRoomUtils;
import com.qiahao.nextvideo.room.manager.GroupEvent;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import com.qiahao.nextvideo.utilities.FastClickOneUtils;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import io.reactivex.rxjava3.core.i0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 W2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001WB\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\bJ\u0017\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0011\u0010\bJ\u000f\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0012\u0010\bJ\u000f\u0010\u0013\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0013\u0010\bJ\u000f\u0010\u0014\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0014\u0010\bJ\u000f\u0010\u0015\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0015\u0010\bJ\u000f\u0010\u0017\u001a\u00020\u0016H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0019\u0010\bJ\r\u0010\u001a\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010\bJ\u0017\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b#\u0010\"J/\u0010(\u001a\u00020\t2\u000e\u0010%\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030$2\u0006\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u0016H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\tH\u0016¢\u0006\u0004\b*\u0010\bR\u0016\u0010+\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\"\u0010/\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010.\u001a\u0004\b0\u0010\u0018\"\u0004\b1\u00102R\u0016\u00103\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u0010.R\u0016\u00104\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010,R\u0016\u00105\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010,R\u0016\u00106\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010.R\u0016\u00107\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u0010,R\"\u00109\u001a\u0002088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010@\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001b\u0010K\u001a\u00020F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u001b\u0010P\u001a\u00020L8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010H\u001a\u0004\bN\u0010OR\u001b\u0010S\u001a\u00020L8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010H\u001a\u0004\bR\u0010OR\u001b\u0010V\u001a\u00020L8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bT\u0010H\u001a\u0004\bU\u0010O¨\u0006X"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/group/my/MyRoomFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentMyRoomBinding;", "Landroid/view/View$OnClickListener;", "Lvc/g;", "Lvc/e;", "Lcom/chad/library/adapter/base/listener/OnItemClickListener;", "<init>", "()V", "", "getCache", "addObserver", "initRecyclerView", "", "isJoined", "changeSelect", "(Z)V", "createMyGroup", "getNetDataForOne", "getMyData", "recommendedGroup", "loadMoreData", "", "getLayoutResId", "()I", "onInitialize", "initView", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "Ltc/f;", "refreshLayout", "onRefresh", "(Ltc/f;)V", "onLoadMore", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "adapter", "view", "position", "onItemClick", "(Lcom/chad/library/adapter/base/BaseQuickAdapter;Landroid/view/View;I)V", "onDestroyView", "isSelectJoin", "Z", "mScrollY", "I", "pageSize", "getPageSize", "setPageSize", "(I)V", "joinedNextIndex", "joinedHasNext", "firstGetJoinData", "recentNextIndex", "recentHasNext", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "getMCompositeDisposable", "()Lnd/a;", "setMCompositeDisposable", "(Lnd/a;)V", "Lcom/google/android/material/appbar/AppBarLayout$h;", "mOffsetChangedListener", "Lcom/google/android/material/appbar/AppBarLayout$h;", "getMOffsetChangedListener", "()Lcom/google/android/material/appbar/AppBarLayout$h;", "setMOffsetChangedListener", "(Lcom/google/android/material/appbar/AppBarLayout$h;)V", "Lcom/qiahao/nextvideo/ui/home/group/my/MyGroupRelationAdapter;", "mMyGroupRelationAdapter$delegate", "Lkotlin/Lazy;", "getMMyGroupRelationAdapter", "()Lcom/qiahao/nextvideo/ui/home/group/my/MyGroupRelationAdapter;", "mMyGroupRelationAdapter", "Lcom/qiahao/nextvideo/ui/home/group/my/MyAndJoinGroupRelationAdapter;", "mJoinGroupRelationAdapter$delegate", "getMJoinGroupRelationAdapter", "()Lcom/qiahao/nextvideo/ui/home/group/my/MyAndJoinGroupRelationAdapter;", "mJoinGroupRelationAdapter", "mRecentlyGroupAdapter$delegate", "getMRecentlyGroupAdapter", "mRecentlyGroupAdapter", "mRecommendGroupAdapter$delegate", "getMRecommendGroupAdapter", "mRecommendGroupAdapter", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMyRoomFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MyRoomFragment.kt\ncom/qiahao/nextvideo/ui/home/group/my/MyRoomFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,531:1\n1#2:532\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MyRoomFragment extends BaseBindingFragment<FragmentMyRoomBinding> implements View.OnClickListener, vc.g, vc.e, OnItemClickListener {

    @NotNull
    private static final String TAG = "MyAllGroupViewWrapper";
    private boolean firstGetJoinData;
    private boolean isSelectJoin;
    private boolean joinedHasNext;
    private int mScrollY;
    private boolean recentHasNext;
    private int pageSize = 20;
    private int joinedNextIndex = 1;
    private int recentNextIndex = 1;

    @NotNull
    private nd.a mCompositeDisposable = new nd.a();

    @Nullable
    private AppBarLayout.h mOffsetChangedListener = new AppBarLayout.h() { // from class: com.qiahao.nextvideo.ui.home.group.my.c
        public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            MyRoomFragment.mOffsetChangedListener$lambda$0(MyRoomFragment.this, appBarLayout, i);
        }
    };

    /* renamed from: mMyGroupRelationAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mMyGroupRelationAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.group.my.d
        public final Object invoke() {
            MyGroupRelationAdapter mMyGroupRelationAdapter_delegate$lambda$1;
            mMyGroupRelationAdapter_delegate$lambda$1 = MyRoomFragment.mMyGroupRelationAdapter_delegate$lambda$1();
            return mMyGroupRelationAdapter_delegate$lambda$1;
        }
    });

    /* renamed from: mJoinGroupRelationAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mJoinGroupRelationAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.group.my.e
        public final Object invoke() {
            MyAndJoinGroupRelationAdapter mJoinGroupRelationAdapter_delegate$lambda$2;
            mJoinGroupRelationAdapter_delegate$lambda$2 = MyRoomFragment.mJoinGroupRelationAdapter_delegate$lambda$2();
            return mJoinGroupRelationAdapter_delegate$lambda$2;
        }
    });

    /* renamed from: mRecentlyGroupAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mRecentlyGroupAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.group.my.f
        public final Object invoke() {
            MyAndJoinGroupRelationAdapter mRecentlyGroupAdapter_delegate$lambda$3;
            mRecentlyGroupAdapter_delegate$lambda$3 = MyRoomFragment.mRecentlyGroupAdapter_delegate$lambda$3();
            return mRecentlyGroupAdapter_delegate$lambda$3;
        }
    });

    /* renamed from: mRecommendGroupAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mRecommendGroupAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.group.my.g
        public final Object invoke() {
            MyAndJoinGroupRelationAdapter mRecommendGroupAdapter_delegate$lambda$4;
            mRecommendGroupAdapter_delegate$lambda$4 = MyRoomFragment.mRecommendGroupAdapter_delegate$lambda$4();
            return mRecommendGroupAdapter_delegate$lambda$4;
        }
    });

    private final void addObserver() {
        nd.c m = GroupService.INSTANCE.getMGroupEventProcessorObservable().m(new pd.g() { // from class: com.qiahao.nextvideo.ui.home.group.my.MyRoomFragment$addObserver$1
            public final void accept(GroupEvent groupEvent) {
                MyAndJoinGroupRelationAdapter mJoinGroupRelationAdapter;
                MyAndJoinGroupRelationAdapter mJoinGroupRelationAdapter2;
                MyAndJoinGroupRelationAdapter mRecentlyGroupAdapter;
                MyAndJoinGroupRelationAdapter mRecentlyGroupAdapter2;
                MyAndJoinGroupRelationAdapter mJoinGroupRelationAdapter3;
                MyAndJoinGroupRelationAdapter mRecentlyGroupAdapter3;
                MyAndJoinGroupRelationAdapter mRecentlyGroupAdapter4;
                MyAndJoinGroupRelationAdapter mRecentlyGroupAdapter5;
                MyAndJoinGroupRelationAdapter mRecentlyGroupAdapter6;
                MyAndJoinGroupRelationAdapter mJoinGroupRelationAdapter4;
                MyAndJoinGroupRelationAdapter mJoinGroupRelationAdapter5;
                MyAndJoinGroupRelationAdapter mJoinGroupRelationAdapter6;
                Intrinsics.checkNotNullParameter(groupEvent, "it");
                try {
                    int mEventId = groupEvent.getMEventId();
                    Object obj = null;
                    if (mEventId == 3) {
                        Log.d("MyAllGroupViewWrapper", "addObserver: a ----离开群组");
                        String mGroupId = groupEvent.getMGroupId();
                        mJoinGroupRelationAdapter = MyRoomFragment.this.getMJoinGroupRelationAdapter();
                        List data = mJoinGroupRelationAdapter.getData();
                        Intrinsics.checkNotNull(data, "null cannot be cast to non-null type java.util.ArrayList<com.qiahao.nextvideo.data.model.HotGroupBean>");
                        ArrayList arrayList = (ArrayList) data;
                        if (arrayList.isEmpty()) {
                            return;
                        }
                        Log.d("MyAllGroupViewWrapper", "addObserver: a ----joinGroupList.isNotEmpty()");
                        Iterator<T> it = arrayList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            Object next = it.next();
                            if (Intrinsics.areEqual(((HotGroupBean) next).getGroupId(), mGroupId)) {
                                obj = next;
                                break;
                            }
                        }
                        HotGroupBean hotGroupBean = (HotGroupBean) obj;
                        if (hotGroupBean != null) {
                            arrayList.remove(hotGroupBean);
                            mJoinGroupRelationAdapter2 = MyRoomFragment.this.getMJoinGroupRelationAdapter();
                            mJoinGroupRelationAdapter2.setList(arrayList);
                            Log.d("MyAllGroupViewWrapper", "addObserver: a ----groupHotBean != null");
                            return;
                        }
                        return;
                    }
                    if (mEventId == 13) {
                        Log.d("MyAllGroupViewWrapper", "addObserver:  ----进入房间");
                        String mGroupId2 = groupEvent.getMGroupId();
                        mRecentlyGroupAdapter = MyRoomFragment.this.getMRecentlyGroupAdapter();
                        List data2 = mRecentlyGroupAdapter.getData();
                        Intrinsics.checkNotNull(data2, "null cannot be cast to non-null type java.util.ArrayList<com.qiahao.nextvideo.data.model.HotGroupBean>");
                        ArrayList arrayList2 = (ArrayList) data2;
                        if (!arrayList2.isEmpty()) {
                            Log.d("MyAllGroupViewWrapper", "addObserver: a ----recentlyList.isNotEmpty()");
                            Iterator<T> it2 = arrayList2.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                Object next2 = it2.next();
                                if (Intrinsics.areEqual(((HotGroupBean) next2).getGroupId(), mGroupId2)) {
                                    obj = next2;
                                    break;
                                }
                            }
                            HotGroupBean hotGroupBean2 = (HotGroupBean) obj;
                            if (hotGroupBean2 != null) {
                                Log.d("MyAllGroupViewWrapper", "addObserver: a ----groupHotBean != null");
                                arrayList2.remove(hotGroupBean2);
                                arrayList2.add(0, hotGroupBean2);
                                mRecentlyGroupAdapter2 = MyRoomFragment.this.getMRecentlyGroupAdapter();
                                mRecentlyGroupAdapter2.setList(arrayList2);
                                return;
                            }
                            return;
                        }
                        Log.d("MyAllGroupViewWrapper", "addObserver: a ----refreshRecentlyGroupList");
                        return;
                    }
                    if (mEventId != 14) {
                        return;
                    }
                    mJoinGroupRelationAdapter3 = MyRoomFragment.this.getMJoinGroupRelationAdapter();
                    if (!mJoinGroupRelationAdapter3.getData().isEmpty()) {
                        mJoinGroupRelationAdapter4 = MyRoomFragment.this.getMJoinGroupRelationAdapter();
                        int size = mJoinGroupRelationAdapter4.getData().size();
                        for (int i = 0; i < size; i++) {
                            mJoinGroupRelationAdapter5 = MyRoomFragment.this.getMJoinGroupRelationAdapter();
                            if (Intrinsics.areEqual(((HotGroupBean) mJoinGroupRelationAdapter5.getData().get(i)).getGroupId(), groupEvent.getMGroupId())) {
                                mJoinGroupRelationAdapter6 = MyRoomFragment.this.getMJoinGroupRelationAdapter();
                                mJoinGroupRelationAdapter6.removeAt(i);
                                return;
                            }
                        }
                    }
                    mRecentlyGroupAdapter3 = MyRoomFragment.this.getMRecentlyGroupAdapter();
                    if (mRecentlyGroupAdapter3.getData().isEmpty()) {
                        return;
                    }
                    mRecentlyGroupAdapter4 = MyRoomFragment.this.getMRecentlyGroupAdapter();
                    int size2 = mRecentlyGroupAdapter4.getData().size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        mRecentlyGroupAdapter5 = MyRoomFragment.this.getMRecentlyGroupAdapter();
                        if (Intrinsics.areEqual(((HotGroupBean) mRecentlyGroupAdapter5.getData().get(i2)).getGroupId(), groupEvent.getMGroupId())) {
                            mRecentlyGroupAdapter6 = MyRoomFragment.this.getMRecentlyGroupAdapter();
                            mRecentlyGroupAdapter6.removeAt(i2);
                            return;
                        }
                    }
                } catch (Exception e) {
                    Log.d("MyAllGroupViewWrapper", "initObserve:im回调逻辑信息报错！！！！！ " + e.getLocalizedMessage());
                }
            }
        }, new pd.g() { // from class: com.qiahao.nextvideo.ui.home.group.my.MyRoomFragment$addObserver$2
            public final void accept(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "it");
            }
        });
        Intrinsics.checkNotNullExpressionValue(m, "subscribe(...)");
        RxUtilsKt.addTo(m, this.mCompositeDisposable);
    }

    private final void changeSelect(boolean isJoined) {
        TextView textView;
        TextView textView2;
        SmartRefreshLayout smartRefreshLayout;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        TextView textView3;
        AppCompatTextView appCompatTextView;
        TextView textView4;
        AppCompatTextView appCompatTextView2;
        TextView textView5;
        RecyclerView recyclerView3;
        RecyclerView recyclerView4;
        TextView textView6;
        AppCompatTextView appCompatTextView3;
        TextView textView7;
        AppCompatTextView appCompatTextView4;
        this.isSelectJoin = isJoined;
        String str = "#999999";
        String str2 = "#8829FE";
        if (isJoined) {
            FragmentMyRoomBinding fragmentMyRoomBinding = (FragmentMyRoomBinding) getBinding();
            if (fragmentMyRoomBinding != null && (appCompatTextView4 = fragmentMyRoomBinding.joinedText) != null) {
                appCompatTextView4.setSelected(true);
            }
            FragmentMyRoomBinding fragmentMyRoomBinding2 = (FragmentMyRoomBinding) getBinding();
            if (fragmentMyRoomBinding2 != null && (textView7 = fragmentMyRoomBinding2.recentlyText) != null) {
                textView7.setSelected(false);
            }
            FragmentMyRoomBinding fragmentMyRoomBinding3 = (FragmentMyRoomBinding) getBinding();
            if (fragmentMyRoomBinding3 != null && (appCompatTextView3 = fragmentMyRoomBinding3.joinedText) != null) {
                if (this.mScrollY > 100) {
                    str2 = "#ffffff";
                }
                appCompatTextView3.setTextColor(Color.parseColor(str2));
            }
            FragmentMyRoomBinding fragmentMyRoomBinding4 = (FragmentMyRoomBinding) getBinding();
            if (fragmentMyRoomBinding4 != null && (textView6 = fragmentMyRoomBinding4.recentlyText) != null) {
                if (this.mScrollY > 100) {
                    str = "#7fffffff";
                }
                textView6.setTextColor(Color.parseColor(str));
            }
            FragmentMyRoomBinding fragmentMyRoomBinding5 = (FragmentMyRoomBinding) getBinding();
            if (fragmentMyRoomBinding5 != null && (recyclerView4 = fragmentMyRoomBinding5.recyclerJoinGroup) != null) {
                recyclerView4.setVisibility(0);
            }
            FragmentMyRoomBinding fragmentMyRoomBinding6 = (FragmentMyRoomBinding) getBinding();
            if (fragmentMyRoomBinding6 != null && (recyclerView3 = fragmentMyRoomBinding6.recyclerRecentlyGroup) != null) {
                recyclerView3.setVisibility(8);
            }
            FragmentMyRoomBinding fragmentMyRoomBinding7 = (FragmentMyRoomBinding) getBinding();
            if (fragmentMyRoomBinding7 != null && (textView5 = fragmentMyRoomBinding7.emptyRecentlyOrJoined) != null) {
                textView5.setVisibility(8);
                return;
            }
            return;
        }
        FragmentMyRoomBinding fragmentMyRoomBinding8 = (FragmentMyRoomBinding) getBinding();
        if (fragmentMyRoomBinding8 != null && (appCompatTextView2 = fragmentMyRoomBinding8.joinedText) != null) {
            appCompatTextView2.setSelected(false);
        }
        FragmentMyRoomBinding fragmentMyRoomBinding9 = (FragmentMyRoomBinding) getBinding();
        if (fragmentMyRoomBinding9 != null && (textView4 = fragmentMyRoomBinding9.recentlyText) != null) {
            textView4.setSelected(true);
        }
        FragmentMyRoomBinding fragmentMyRoomBinding10 = (FragmentMyRoomBinding) getBinding();
        if (fragmentMyRoomBinding10 != null && (appCompatTextView = fragmentMyRoomBinding10.joinedText) != null) {
            if (this.mScrollY > 100) {
                str = "#7fffffff";
            }
            appCompatTextView.setTextColor(Color.parseColor(str));
        }
        FragmentMyRoomBinding fragmentMyRoomBinding11 = (FragmentMyRoomBinding) getBinding();
        if (fragmentMyRoomBinding11 != null && (textView3 = fragmentMyRoomBinding11.recentlyText) != null) {
            if (this.mScrollY > 100) {
                str2 = "#ffffff";
            }
            textView3.setTextColor(Color.parseColor(str2));
        }
        FragmentMyRoomBinding fragmentMyRoomBinding12 = (FragmentMyRoomBinding) getBinding();
        if (fragmentMyRoomBinding12 != null && (recyclerView2 = fragmentMyRoomBinding12.recyclerRecentlyGroup) != null) {
            recyclerView2.setVisibility(0);
        }
        FragmentMyRoomBinding fragmentMyRoomBinding13 = (FragmentMyRoomBinding) getBinding();
        if (fragmentMyRoomBinding13 != null && (recyclerView = fragmentMyRoomBinding13.recyclerJoinGroup) != null) {
            recyclerView.setVisibility(8);
        }
        FragmentMyRoomBinding fragmentMyRoomBinding14 = (FragmentMyRoomBinding) getBinding();
        if (fragmentMyRoomBinding14 != null && (smartRefreshLayout = fragmentMyRoomBinding14.smartRefreshLayout) != null) {
            smartRefreshLayout.setEnableLoadMore(false);
        }
        if (getMRecentlyGroupAdapter().getData().isEmpty()) {
            FragmentMyRoomBinding fragmentMyRoomBinding15 = (FragmentMyRoomBinding) getBinding();
            if (fragmentMyRoomBinding15 != null && (textView2 = fragmentMyRoomBinding15.emptyRecentlyOrJoined) != null) {
                textView2.setVisibility(0);
                return;
            }
            return;
        }
        FragmentMyRoomBinding fragmentMyRoomBinding16 = (FragmentMyRoomBinding) getBinding();
        if (fragmentMyRoomBinding16 != null && (textView = fragmentMyRoomBinding16.emptyRecentlyOrJoined) != null) {
            textView.setVisibility(8);
        }
    }

    private final void createMyGroup() {
        if (FastClickOneUtils.INSTANCE.isFastClick()) {
            RxUtilsKt.observeOnMainThread$default(GroupService.INSTANCE.getInstance().createGroup(), new Function1() { // from class: com.qiahao.nextvideo.ui.home.group.my.t
                public final Object invoke(Object obj) {
                    Unit createMyGroup$lambda$19;
                    createMyGroup$lambda$19 = MyRoomFragment.createMyGroup$lambda$19(MyRoomFragment.this, (ApiResponse) obj);
                    return createMyGroup$lambda$19;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.group.my.u
                public final Object invoke(Object obj) {
                    Unit createMyGroup$lambda$20;
                    createMyGroup$lambda$20 = MyRoomFragment.createMyGroup$lambda$20(MyRoomFragment.this, (Throwable) obj);
                    return createMyGroup$lambda$20;
                }
            }, (Function0) null, false, 12, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createMyGroup$lambda$19(MyRoomFragment myRoomFragment, ApiResponse apiResponse) {
        String str;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        myRoomFragment.getMyData();
        StartRoomUtils startRoomUtils = StartRoomUtils.INSTANCE;
        CreateGroupBean createGroupBean = (CreateGroupBean) apiResponse.getData();
        if (createGroupBean == null || (str = createGroupBean.getImGroupId()) == null) {
            str = "";
        }
        StartRoomUtils.startRoom$default(startRoomUtils, str, null, null, null, null, null, null, null, 0, 0, null, 0, false, 8190, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createMyGroup$lambda$20(MyRoomFragment myRoomFragment, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = myRoomFragment.getContext();
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                str = ResourcesKtxKt.getStringById(myRoomFragment, 2131952667);
            } else {
                str = errorMessage;
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    private final void getCache() {
        TextView textView;
        RecyclerView recyclerView;
        CardView cardView;
        RecyclerView recyclerView2;
        MMKVToLocalCache.Companion companion = MMKVToLocalCache.INSTANCE;
        List<HotGroupBean> myGroupCache = companion.getMyGroupCache();
        if (myGroupCache != null) {
            FragmentMyRoomBinding fragmentMyRoomBinding = (FragmentMyRoomBinding) getBinding();
            if (fragmentMyRoomBinding != null && (recyclerView2 = fragmentMyRoomBinding.recyclerMy) != null) {
                recyclerView2.setVisibility(0);
            }
            FragmentMyRoomBinding fragmentMyRoomBinding2 = (FragmentMyRoomBinding) getBinding();
            if (fragmentMyRoomBinding2 != null && (cardView = fragmentMyRoomBinding2.createMyGroup) != null) {
                cardView.setVisibility(8);
            }
            getMMyGroupRelationAdapter().setList(myGroupCache);
        }
        List<HotGroupBean> recentlyGroupCache = companion.getRecentlyGroupCache();
        if (recentlyGroupCache != null) {
            FragmentMyRoomBinding fragmentMyRoomBinding3 = (FragmentMyRoomBinding) getBinding();
            if (fragmentMyRoomBinding3 != null && (recyclerView = fragmentMyRoomBinding3.recyclerRecentlyGroup) != null) {
                recyclerView.setVisibility(0);
            }
            getMRecentlyGroupAdapter().setList(recentlyGroupCache);
            FragmentMyRoomBinding fragmentMyRoomBinding4 = (FragmentMyRoomBinding) getBinding();
            if (fragmentMyRoomBinding4 != null && (textView = fragmentMyRoomBinding4.emptyRecentlyOrJoined) != null) {
                textView.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MyAndJoinGroupRelationAdapter getMJoinGroupRelationAdapter() {
        return (MyAndJoinGroupRelationAdapter) this.mJoinGroupRelationAdapter.getValue();
    }

    private final MyGroupRelationAdapter getMMyGroupRelationAdapter() {
        return (MyGroupRelationAdapter) this.mMyGroupRelationAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MyAndJoinGroupRelationAdapter getMRecentlyGroupAdapter() {
        return (MyAndJoinGroupRelationAdapter) this.mRecentlyGroupAdapter.getValue();
    }

    private final MyAndJoinGroupRelationAdapter getMRecommendGroupAdapter() {
        return (MyAndJoinGroupRelationAdapter) this.mRecommendGroupAdapter.getValue();
    }

    private final void getMyData() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(GroupService.INSTANCE.getInstance().getOwnGroup(), new Function1() { // from class: com.qiahao.nextvideo.ui.home.group.my.r
            public final Object invoke(Object obj) {
                Unit myData$lambda$25;
                myData$lambda$25 = MyRoomFragment.getMyData$lambda$25(MyRoomFragment.this, (ApiResponse) obj);
                return myData$lambda$25;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.group.my.s
            public final Object invoke(Object obj) {
                Unit myData$lambda$26;
                myData$lambda$26 = MyRoomFragment.getMyData$lambda$26((Throwable) obj);
                return myData$lambda$26;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMyData$lambda$25(MyRoomFragment myRoomFragment, ApiResponse apiResponse) {
        CardView cardView;
        RecyclerView recyclerView;
        CardView cardView2;
        RecyclerView recyclerView2;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        List<HotGroupBean> list = (List) apiResponse.getData();
        if (list != null) {
            if (list.isEmpty()) {
                FragmentMyRoomBinding fragmentMyRoomBinding = (FragmentMyRoomBinding) myRoomFragment.getBinding();
                if (fragmentMyRoomBinding != null && (recyclerView2 = fragmentMyRoomBinding.recyclerMy) != null) {
                    recyclerView2.setVisibility(8);
                }
                FragmentMyRoomBinding fragmentMyRoomBinding2 = (FragmentMyRoomBinding) myRoomFragment.getBinding();
                if (fragmentMyRoomBinding2 != null && (cardView2 = fragmentMyRoomBinding2.createMyGroup) != null) {
                    cardView2.setVisibility(0);
                }
            } else {
                FragmentMyRoomBinding fragmentMyRoomBinding3 = (FragmentMyRoomBinding) myRoomFragment.getBinding();
                if (fragmentMyRoomBinding3 != null && (recyclerView = fragmentMyRoomBinding3.recyclerMy) != null) {
                    recyclerView.setVisibility(0);
                }
                FragmentMyRoomBinding fragmentMyRoomBinding4 = (FragmentMyRoomBinding) myRoomFragment.getBinding();
                if (fragmentMyRoomBinding4 != null && (cardView = fragmentMyRoomBinding4.createMyGroup) != null) {
                    cardView.setVisibility(8);
                }
                MMKVToLocalCache.INSTANCE.saveMyGroupCache(list);
                myRoomFragment.getMMyGroupRelationAdapter().setList(list);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMyData$lambda$26(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    private final void getNetDataForOne() {
        i0<ApiResponse<List<HotGroupBean>>> myRecentGroup;
        getMyData();
        if (this.isSelectJoin) {
            this.joinedNextIndex = 1;
            myRecentGroup = GroupService.INSTANCE.getInstance().getMyPermanentGroup(this.joinedNextIndex, this.pageSize);
        } else {
            this.recentNextIndex = 1;
            myRecentGroup = GroupService.INSTANCE.getInstance().getMyRecentGroup();
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(myRecentGroup, new Function1() { // from class: com.qiahao.nextvideo.ui.home.group.my.a
            public final Object invoke(Object obj) {
                Unit netDataForOne$lambda$21;
                netDataForOne$lambda$21 = MyRoomFragment.getNetDataForOne$lambda$21(MyRoomFragment.this, (ApiResponse) obj);
                return netDataForOne$lambda$21;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.group.my.l
            public final Object invoke(Object obj) {
                Unit netDataForOne$lambda$22;
                netDataForOne$lambda$22 = MyRoomFragment.getNetDataForOne$lambda$22(MyRoomFragment.this, (Throwable) obj);
                return netDataForOne$lambda$22;
            }
        }, new Function0() { // from class: com.qiahao.nextvideo.ui.home.group.my.n
            public final Object invoke() {
                Unit netDataForOne$lambda$23;
                netDataForOne$lambda$23 = MyRoomFragment.getNetDataForOne$lambda$23(MyRoomFragment.this);
                return netDataForOne$lambda$23;
            }
        }, false, 8, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getNetDataForOne$lambda$21(MyRoomFragment myRoomFragment, ApiResponse apiResponse) {
        int i;
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        TextView textView;
        LinearLayout linearLayout;
        TextView textView2;
        SmartRefreshLayout smartRefreshLayout3;
        LinearLayout linearLayout2;
        TextView textView3;
        SmartRefreshLayout smartRefreshLayout4;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        List list = (List) apiResponse.getData();
        if (list != null) {
            i = list.size();
        } else {
            i = 0;
        }
        if (i < myRoomFragment.pageSize) {
            FragmentMyRoomBinding fragmentMyRoomBinding = (FragmentMyRoomBinding) myRoomFragment.getBinding();
            if (fragmentMyRoomBinding != null && (smartRefreshLayout4 = fragmentMyRoomBinding.smartRefreshLayout) != null) {
                smartRefreshLayout4.setEnableLoadMore(false);
            }
            if (myRoomFragment.isSelectJoin) {
                myRoomFragment.joinedHasNext = false;
            } else {
                myRoomFragment.recentHasNext = false;
            }
        } else if (myRoomFragment.isSelectJoin) {
            FragmentMyRoomBinding fragmentMyRoomBinding2 = (FragmentMyRoomBinding) myRoomFragment.getBinding();
            if (fragmentMyRoomBinding2 != null && (smartRefreshLayout2 = fragmentMyRoomBinding2.smartRefreshLayout) != null) {
                smartRefreshLayout2.setEnableLoadMore(true);
            }
            myRoomFragment.joinedHasNext = true;
        } else {
            FragmentMyRoomBinding fragmentMyRoomBinding3 = (FragmentMyRoomBinding) myRoomFragment.getBinding();
            if (fragmentMyRoomBinding3 != null && (smartRefreshLayout = fragmentMyRoomBinding3.smartRefreshLayout) != null) {
                smartRefreshLayout.setEnableLoadMore(false);
            }
            myRoomFragment.recentHasNext = false;
        }
        Collection collection = (Collection) apiResponse.getData();
        List list2 = null;
        if (collection != null && !collection.isEmpty()) {
            FragmentMyRoomBinding fragmentMyRoomBinding4 = (FragmentMyRoomBinding) myRoomFragment.getBinding();
            if (fragmentMyRoomBinding4 != null && (textView3 = fragmentMyRoomBinding4.emptyRecentlyOrJoined) != null) {
                textView3.setVisibility(8);
            }
            List list3 = (List) apiResponse.getData();
            if (list3 != null) {
                list2 = CollectionsKt.toMutableList(list3);
            }
            Intrinsics.checkNotNull(list2, "null cannot be cast to non-null type java.util.ArrayList<com.qiahao.nextvideo.data.model.HotGroupBean>");
            ArrayList arrayList = (ArrayList) list2;
            ArrayList<String> blockRoomIdList = GroupService.INSTANCE.getInstance().getBlockRoomIdList();
            if (blockRoomIdList != null) {
                Iterator it = arrayList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    if (blockRoomIdList.contains(((HotGroupBean) it.next()).getGroupId())) {
                        it.remove();
                    }
                }
            }
            if (myRoomFragment.isSelectJoin) {
                myRoomFragment.getMJoinGroupRelationAdapter().setList(arrayList);
                MMKVToLocalCache.INSTANCE.saveJoinGroupCache(arrayList);
            } else {
                myRoomFragment.getMRecentlyGroupAdapter().setList(arrayList);
                MMKVToLocalCache.INSTANCE.saveRecentlyGroupCache(arrayList);
                FragmentMyRoomBinding fragmentMyRoomBinding5 = (FragmentMyRoomBinding) myRoomFragment.getBinding();
                if (fragmentMyRoomBinding5 != null && (linearLayout2 = fragmentMyRoomBinding5.llRecommendGroup) != null) {
                    linearLayout2.setVisibility(8);
                }
            }
        } else if (myRoomFragment.isSelectJoin) {
            myRoomFragment.getMJoinGroupRelationAdapter().setList((Collection) null);
            FragmentMyRoomBinding fragmentMyRoomBinding6 = (FragmentMyRoomBinding) myRoomFragment.getBinding();
            if (fragmentMyRoomBinding6 != null && (textView2 = fragmentMyRoomBinding6.emptyRecentlyOrJoined) != null) {
                textView2.setVisibility(8);
            }
        } else {
            myRoomFragment.getMRecentlyGroupAdapter().setList((Collection) null);
            FragmentMyRoomBinding fragmentMyRoomBinding7 = (FragmentMyRoomBinding) myRoomFragment.getBinding();
            if (fragmentMyRoomBinding7 != null && (linearLayout = fragmentMyRoomBinding7.llRecommendGroup) != null) {
                linearLayout.setVisibility(0);
            }
            FragmentMyRoomBinding fragmentMyRoomBinding8 = (FragmentMyRoomBinding) myRoomFragment.getBinding();
            if (fragmentMyRoomBinding8 != null && (textView = fragmentMyRoomBinding8.emptyRecentlyOrJoined) != null) {
                textView.setVisibility(0);
            }
            myRoomFragment.recommendedGroup();
        }
        if (myRoomFragment.isSelectJoin) {
            myRoomFragment.joinedNextIndex++;
        } else {
            myRoomFragment.recentNextIndex++;
        }
        FragmentMyRoomBinding fragmentMyRoomBinding9 = (FragmentMyRoomBinding) myRoomFragment.getBinding();
        if (fragmentMyRoomBinding9 != null && (smartRefreshLayout3 = fragmentMyRoomBinding9.smartRefreshLayout) != null) {
            smartRefreshLayout3.finishRefresh();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getNetDataForOne$lambda$22(MyRoomFragment myRoomFragment, Throwable th) {
        String str;
        SmartRefreshLayout smartRefreshLayout;
        Intrinsics.checkNotNullParameter(th, "it");
        FragmentMyRoomBinding fragmentMyRoomBinding = (FragmentMyRoomBinding) myRoomFragment.getBinding();
        if (fragmentMyRoomBinding != null && (smartRefreshLayout = fragmentMyRoomBinding.smartRefreshLayout) != null) {
            smartRefreshLayout.finishRefresh();
        }
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = myRoomFragment.getContext();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            str = ResourcesKtxKt.getStringById(myRoomFragment, 2131952667);
        } else {
            str = localizedMessage;
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getNetDataForOne$lambda$23(MyRoomFragment myRoomFragment) {
        SmartRefreshLayout smartRefreshLayout;
        FragmentMyRoomBinding fragmentMyRoomBinding = (FragmentMyRoomBinding) myRoomFragment.getBinding();
        if (fragmentMyRoomBinding != null && (smartRefreshLayout = fragmentMyRoomBinding.smartRefreshLayout) != null) {
            smartRefreshLayout.finishRefresh();
        }
        return Unit.INSTANCE;
    }

    private final void initRecyclerView() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        RecyclerView recyclerView4;
        FragmentMyRoomBinding fragmentMyRoomBinding = (FragmentMyRoomBinding) getBinding();
        if (fragmentMyRoomBinding != null && (recyclerView4 = fragmentMyRoomBinding.recyclerJoinGroup) != null) {
            recyclerView4.setLayoutManager(new CustomLinearLayoutManager(recyclerView4.getContext()));
            recyclerView4.setAdapter(getMJoinGroupRelationAdapter());
        }
        FragmentMyRoomBinding fragmentMyRoomBinding2 = (FragmentMyRoomBinding) getBinding();
        if (fragmentMyRoomBinding2 != null && (recyclerView3 = fragmentMyRoomBinding2.recyclerRecentlyGroup) != null) {
            recyclerView3.setLayoutManager(new CustomLinearLayoutManager(recyclerView3.getContext()));
            recyclerView3.setAdapter(getMRecentlyGroupAdapter());
        }
        FragmentMyRoomBinding fragmentMyRoomBinding3 = (FragmentMyRoomBinding) getBinding();
        if (fragmentMyRoomBinding3 != null && (recyclerView2 = fragmentMyRoomBinding3.recyclerMy) != null) {
            recyclerView2.setLayoutManager(new CustomLinearLayoutManager(recyclerView2.getContext()));
            recyclerView2.setAdapter(getMMyGroupRelationAdapter());
        }
        getMJoinGroupRelationAdapter().setOnItemClickListener(this);
        getMRecentlyGroupAdapter().setOnItemClickListener(this);
        getMMyGroupRelationAdapter().setOnItemClickListener(this);
        getMRecentlyGroupAdapter().setOnItemLongClickListener(new OnItemLongClickListener() { // from class: com.qiahao.nextvideo.ui.home.group.my.o
            public final boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                boolean initRecyclerView$lambda$14;
                initRecyclerView$lambda$14 = MyRoomFragment.initRecyclerView$lambda$14(MyRoomFragment.this, baseQuickAdapter, view, i);
                return initRecyclerView$lambda$14;
            }
        });
        getMJoinGroupRelationAdapter().setOnItemLongClickListener(new OnItemLongClickListener() { // from class: com.qiahao.nextvideo.ui.home.group.my.p
            public final boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                boolean initRecyclerView$lambda$15;
                initRecyclerView$lambda$15 = MyRoomFragment.initRecyclerView$lambda$15(MyRoomFragment.this, baseQuickAdapter, view, i);
                return initRecyclerView$lambda$15;
            }
        });
        FragmentMyRoomBinding fragmentMyRoomBinding4 = (FragmentMyRoomBinding) getBinding();
        if (fragmentMyRoomBinding4 != null && (recyclerView = fragmentMyRoomBinding4.recyclerRecommend) != null) {
            recyclerView.setLayoutManager(new CustomLinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter(getMRecommendGroupAdapter());
        }
        getMRecommendGroupAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.home.group.my.q
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                MyRoomFragment.initRecyclerView$lambda$17(MyRoomFragment.this, baseQuickAdapter, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initRecyclerView$lambda$14(MyRoomFragment myRoomFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        AppRequestUtils.roomReportOrBlack$default(AppRequestUtils.INSTANCE, ((HotGroupBean) myRoomFragment.getMRecentlyGroupAdapter().getData().get(i)).getGroupId(), null, null, 6, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initRecyclerView$lambda$15(MyRoomFragment myRoomFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        AppRequestUtils.roomReportOrBlack$default(AppRequestUtils.INSTANCE, ((HotGroupBean) myRoomFragment.getMJoinGroupRelationAdapter().getData().get(i)).getGroupId(), null, null, 6, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecyclerView$lambda$17(MyRoomFragment myRoomFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        HotGroupBean hotGroupBean = (HotGroupBean) myRoomFragment.getMRecommendGroupAdapter().getItem(i);
        if (FastClickOneUtils.INSTANCE.isFastClick()) {
            StartRoomUtils.startRoom$default(StartRoomUtils.INSTANCE, hotGroupBean.getGroupId(), hotGroupBean.getCode(), hotGroupBean.getFaceUrl(), hotGroupBean.getName(), Boolean.valueOf(hotGroupBean.getHasPassWord()), hotGroupBean.getCountryIcon(), hotGroupBean.getIntroduction(), hotGroupBean.getNotification(), 0, 0, null, 0, false, 7936, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$10(MyRoomFragment myRoomFragment) {
        myRoomFragment.initRecyclerView();
        myRoomFragment.getCache();
        myRoomFragment.addObserver();
    }

    private final void loadMoreData() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(GroupService.INSTANCE.getInstance().getMyPermanentGroup(this.joinedNextIndex, this.pageSize), new Function1() { // from class: com.qiahao.nextvideo.ui.home.group.my.h
            public final Object invoke(Object obj) {
                Unit loadMoreData$lambda$29;
                loadMoreData$lambda$29 = MyRoomFragment.loadMoreData$lambda$29(MyRoomFragment.this, (ApiResponse) obj);
                return loadMoreData$lambda$29;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.group.my.i
            public final Object invoke(Object obj) {
                Unit loadMoreData$lambda$30;
                loadMoreData$lambda$30 = MyRoomFragment.loadMoreData$lambda$30(MyRoomFragment.this, (Throwable) obj);
                return loadMoreData$lambda$30;
            }
        }, new Function0() { // from class: com.qiahao.nextvideo.ui.home.group.my.j
            public final Object invoke() {
                Unit loadMoreData$lambda$31;
                loadMoreData$lambda$31 = MyRoomFragment.loadMoreData$lambda$31(MyRoomFragment.this);
                return loadMoreData$lambda$31;
            }
        }, false, 8, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit loadMoreData$lambda$29(MyRoomFragment myRoomFragment, ApiResponse apiResponse) {
        int i;
        SmartRefreshLayout smartRefreshLayout;
        List list;
        SmartRefreshLayout smartRefreshLayout2;
        SmartRefreshLayout smartRefreshLayout3;
        SmartRefreshLayout smartRefreshLayout4;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        List list2 = (List) apiResponse.getData();
        if (list2 != null) {
            i = list2.size();
        } else {
            i = 0;
        }
        if (i < myRoomFragment.pageSize) {
            FragmentMyRoomBinding fragmentMyRoomBinding = (FragmentMyRoomBinding) myRoomFragment.getBinding();
            if (fragmentMyRoomBinding != null && (smartRefreshLayout4 = fragmentMyRoomBinding.smartRefreshLayout) != null) {
                smartRefreshLayout4.setEnableLoadMore(false);
            }
        } else {
            FragmentMyRoomBinding fragmentMyRoomBinding2 = (FragmentMyRoomBinding) myRoomFragment.getBinding();
            if (fragmentMyRoomBinding2 != null && (smartRefreshLayout = fragmentMyRoomBinding2.smartRefreshLayout) != null) {
                smartRefreshLayout.setEnableLoadMore(true);
            }
        }
        FragmentMyRoomBinding fragmentMyRoomBinding3 = (FragmentMyRoomBinding) myRoomFragment.getBinding();
        if (fragmentMyRoomBinding3 != null && (smartRefreshLayout3 = fragmentMyRoomBinding3.smartRefreshLayout) != null) {
            smartRefreshLayout3.finishRefresh();
        }
        List list3 = (List) apiResponse.getData();
        if (list3 != null) {
            list = CollectionsKt.toMutableList(list3);
        } else {
            list = null;
        }
        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type java.util.ArrayList<com.qiahao.nextvideo.data.model.HotGroupBean>");
        ArrayList arrayList = (ArrayList) list;
        ArrayList<String> blockRoomIdList = GroupService.INSTANCE.getInstance().getBlockRoomIdList();
        if (blockRoomIdList != null) {
            Iterator it = arrayList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                if (blockRoomIdList.contains(((HotGroupBean) it.next()).getGroupId())) {
                    it.remove();
                }
            }
        }
        if (!arrayList.isEmpty()) {
            myRoomFragment.getMJoinGroupRelationAdapter().addData(arrayList);
        }
        myRoomFragment.joinedNextIndex++;
        FragmentMyRoomBinding fragmentMyRoomBinding4 = (FragmentMyRoomBinding) myRoomFragment.getBinding();
        if (fragmentMyRoomBinding4 != null && (smartRefreshLayout2 = fragmentMyRoomBinding4.smartRefreshLayout) != null) {
            smartRefreshLayout2.finishRefresh();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit loadMoreData$lambda$30(MyRoomFragment myRoomFragment, Throwable th) {
        SmartRefreshLayout smartRefreshLayout;
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = myRoomFragment.getContext();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = ResourcesKtxKt.getStringById(myRoomFragment, 2131952667);
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, localizedMessage, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        FragmentMyRoomBinding fragmentMyRoomBinding = (FragmentMyRoomBinding) myRoomFragment.getBinding();
        if (fragmentMyRoomBinding != null && (smartRefreshLayout = fragmentMyRoomBinding.smartRefreshLayout) != null) {
            smartRefreshLayout.finishRefresh();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit loadMoreData$lambda$31(MyRoomFragment myRoomFragment) {
        SmartRefreshLayout smartRefreshLayout;
        FragmentMyRoomBinding fragmentMyRoomBinding = (FragmentMyRoomBinding) myRoomFragment.getBinding();
        if (fragmentMyRoomBinding != null && (smartRefreshLayout = fragmentMyRoomBinding.smartRefreshLayout) != null) {
            smartRefreshLayout.finishLoadMore();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MyAndJoinGroupRelationAdapter mJoinGroupRelationAdapter_delegate$lambda$2() {
        return new MyAndJoinGroupRelationAdapter(R.layout.item_my_or_join_group);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MyGroupRelationAdapter mMyGroupRelationAdapter_delegate$lambda$1() {
        return new MyGroupRelationAdapter(R.layout.item_my_group);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mOffsetChangedListener$lambda$0(MyRoomFragment myRoomFragment, AppBarLayout appBarLayout, int i) {
        myRoomFragment.mScrollY = Math.abs(i);
        myRoomFragment.changeSelect(myRoomFragment.isSelectJoin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MyAndJoinGroupRelationAdapter mRecentlyGroupAdapter_delegate$lambda$3() {
        return new MyAndJoinGroupRelationAdapter(R.layout.item_my_or_join_group);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MyAndJoinGroupRelationAdapter mRecommendGroupAdapter_delegate$lambda$4() {
        return new MyAndJoinGroupRelationAdapter(R.layout.item_my_or_join_group);
    }

    private final void recommendedGroup() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(GroupService.INSTANCE.getInstance().getNewRecommendGroupList(), new Function1() { // from class: com.qiahao.nextvideo.ui.home.group.my.k
            public final Object invoke(Object obj) {
                Unit recommendedGroup$lambda$27;
                recommendedGroup$lambda$27 = MyRoomFragment.recommendedGroup$lambda$27(MyRoomFragment.this, (ApiResponse) obj);
                return recommendedGroup$lambda$27;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.group.my.m
            public final Object invoke(Object obj) {
                Unit recommendedGroup$lambda$28;
                recommendedGroup$lambda$28 = MyRoomFragment.recommendedGroup$lambda$28(MyRoomFragment.this, (Throwable) obj);
                return recommendedGroup$lambda$28;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit recommendedGroup$lambda$27(MyRoomFragment myRoomFragment, ApiResponse apiResponse) {
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        myRoomFragment.getMRecommendGroupAdapter().setList((Collection) apiResponse.getData());
        FragmentMyRoomBinding fragmentMyRoomBinding = (FragmentMyRoomBinding) myRoomFragment.getBinding();
        if (fragmentMyRoomBinding != null && (linearLayout = fragmentMyRoomBinding.llRecommendGroup) != null) {
            linearLayout.setVisibility(0);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit recommendedGroup$lambda$28(MyRoomFragment myRoomFragment, Throwable th) {
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(th, "it");
        FragmentMyRoomBinding fragmentMyRoomBinding = (FragmentMyRoomBinding) myRoomFragment.getBinding();
        if (fragmentMyRoomBinding != null && (linearLayout = fragmentMyRoomBinding.llRecommendGroup) != null) {
            linearLayout.setVisibility(8);
        }
        return Unit.INSTANCE;
    }

    protected int getLayoutResId() {
        return R.layout.fragment_my_room;
    }

    @NotNull
    public final nd.a getMCompositeDisposable() {
        return this.mCompositeDisposable;
    }

    @Nullable
    public final AppBarLayout.h getMOffsetChangedListener() {
        return this.mOffsetChangedListener;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public final void initView() {
        FootLoading footLoading;
        AppBarLayout appBarLayout;
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        FragmentMyRoomBinding fragmentMyRoomBinding;
        SmartRefreshLayout smartRefreshLayout3;
        SmartRefreshLayout smartRefreshLayout4;
        SmartRefreshLayout smartRefreshLayout5;
        FragmentMyRoomBinding fragmentMyRoomBinding2 = (FragmentMyRoomBinding) getBinding();
        if (fragmentMyRoomBinding2 != null) {
            fragmentMyRoomBinding2.setClick(this);
        }
        changeSelect(false);
        FragmentMyRoomBinding fragmentMyRoomBinding3 = (FragmentMyRoomBinding) getBinding();
        if (fragmentMyRoomBinding3 != null && (smartRefreshLayout5 = fragmentMyRoomBinding3.smartRefreshLayout) != null) {
            smartRefreshLayout5.setOnRefreshListener(this);
        }
        FragmentMyRoomBinding fragmentMyRoomBinding4 = (FragmentMyRoomBinding) getBinding();
        if (fragmentMyRoomBinding4 != null && (smartRefreshLayout4 = fragmentMyRoomBinding4.smartRefreshLayout) != null) {
            smartRefreshLayout4.setOnLoadMoreListener(this);
        }
        Context context = getContext();
        if (context != null) {
            footLoading = new FootLoading(context);
            footLoading.setBackground(androidx.core.content.a.getDrawable(footLoading.getContext(), 2131101214));
        } else {
            footLoading = null;
        }
        if (footLoading != null && (fragmentMyRoomBinding = (FragmentMyRoomBinding) getBinding()) != null && (smartRefreshLayout3 = fragmentMyRoomBinding.smartRefreshLayout) != null) {
            smartRefreshLayout3.setRefreshFooter(footLoading);
        }
        FragmentMyRoomBinding fragmentMyRoomBinding5 = (FragmentMyRoomBinding) getBinding();
        if (fragmentMyRoomBinding5 != null && (smartRefreshLayout2 = fragmentMyRoomBinding5.smartRefreshLayout) != null) {
            smartRefreshLayout2.setEnableLoadMore(false);
        }
        FragmentMyRoomBinding fragmentMyRoomBinding6 = (FragmentMyRoomBinding) getBinding();
        if (fragmentMyRoomBinding6 != null && (smartRefreshLayout = fragmentMyRoomBinding6.smartRefreshLayout) != null) {
            smartRefreshLayout.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.home.group.my.b
                @Override // java.lang.Runnable
                public final void run() {
                    MyRoomFragment.initView$lambda$10(MyRoomFragment.this);
                }
            });
        }
        FragmentMyRoomBinding fragmentMyRoomBinding7 = (FragmentMyRoomBinding) getBinding();
        if (fragmentMyRoomBinding7 != null && (appBarLayout = fragmentMyRoomBinding7.toolbar) != null) {
            appBarLayout.addOnOffsetChangedListener(this.mOffsetChangedListener);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        RecyclerView recyclerView;
        AppCompatTextView appCompatTextView;
        TextView textView;
        Intrinsics.checkNotNullParameter(v, "v");
        int id2 = v.getId();
        if (id2 != 2131362563) {
            if (id2 != 2131363399) {
                if (id2 == 2131364489) {
                    FragmentMyRoomBinding fragmentMyRoomBinding = (FragmentMyRoomBinding) getBinding();
                    if (fragmentMyRoomBinding != null && (textView = fragmentMyRoomBinding.recentlyText) != null && textView.isSelected()) {
                        return;
                    }
                    changeSelect(false);
                    return;
                }
                return;
            }
            FragmentMyRoomBinding fragmentMyRoomBinding2 = (FragmentMyRoomBinding) getBinding();
            if (fragmentMyRoomBinding2 != null && (appCompatTextView = fragmentMyRoomBinding2.joinedText) != null && appCompatTextView.isSelected()) {
                return;
            }
            changeSelect(true);
            if (!this.firstGetJoinData) {
                this.firstGetJoinData = true;
                List<HotGroupBean> joinGroupCache = MMKVToLocalCache.INSTANCE.getJoinGroupCache();
                if (joinGroupCache != null) {
                    Log.d(TAG, "getCache: getJoinGroupCache() " + joinGroupCache.size() + " ");
                    FragmentMyRoomBinding fragmentMyRoomBinding3 = (FragmentMyRoomBinding) getBinding();
                    if (fragmentMyRoomBinding3 != null && (recyclerView = fragmentMyRoomBinding3.recyclerJoinGroup) != null) {
                        recyclerView.setVisibility(0);
                    }
                    getMJoinGroupRelationAdapter().setList(joinGroupCache);
                }
            }
            getNetDataForOne();
            return;
        }
        createMyGroup();
    }

    public void onDestroyView() {
        AppBarLayout appBarLayout;
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        FragmentMyRoomBinding fragmentMyRoomBinding = (FragmentMyRoomBinding) getBinding();
        if (fragmentMyRoomBinding != null && (smartRefreshLayout2 = fragmentMyRoomBinding.smartRefreshLayout) != null) {
            smartRefreshLayout2.setOnRefreshListener(null);
        }
        FragmentMyRoomBinding fragmentMyRoomBinding2 = (FragmentMyRoomBinding) getBinding();
        if (fragmentMyRoomBinding2 != null && (smartRefreshLayout = fragmentMyRoomBinding2.smartRefreshLayout) != null) {
            smartRefreshLayout.setOnLoadMoreListener(null);
        }
        FragmentMyRoomBinding fragmentMyRoomBinding3 = (FragmentMyRoomBinding) getBinding();
        if (fragmentMyRoomBinding3 != null && (appBarLayout = fragmentMyRoomBinding3.toolbar) != null) {
            appBarLayout.removeOnOffsetChangedListener(this.mOffsetChangedListener);
        }
        this.mOffsetChangedListener = null;
        this.mCompositeDisposable.d();
        getMMyGroupRelationAdapter().setOnItemClickListener((OnItemClickListener) null);
        getMJoinGroupRelationAdapter().setOnItemClickListener((OnItemClickListener) null);
        getMRecentlyGroupAdapter().setOnItemClickListener((OnItemClickListener) null);
        getMRecentlyGroupAdapter().setOnItemLongClickListener((OnItemLongClickListener) null);
        getMJoinGroupRelationAdapter().setOnItemLongClickListener((OnItemLongClickListener) null);
        getMRecommendGroupAdapter().setOnItemClickListener((OnItemClickListener) null);
        super.onDestroyView();
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        initView();
        getNetDataForOne();
    }

    public void onItemClick(@NotNull BaseQuickAdapter<?, ?> adapter, @NotNull View view, int position) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        if (FastClickOneUtils.INSTANCE.isFastClick()) {
            Object item = adapter.getItem(position);
            Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.HotGroupBean");
            HotGroupBean hotGroupBean = (HotGroupBean) item;
            StartRoomUtils.startRoom$default(StartRoomUtils.INSTANCE, hotGroupBean.getGroupId(), hotGroupBean.getCode(), hotGroupBean.getFaceUrl(), hotGroupBean.getName(), Boolean.valueOf(hotGroupBean.getHasPassWord()), hotGroupBean.getCountryIcon(), hotGroupBean.getIntroduction(), hotGroupBean.getNotification(), 0, 0, null, 0, false, 7936, null);
        }
    }

    @Override // vc.e
    public void onLoadMore(@NotNull tc.f refreshLayout) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        loadMoreData();
    }

    @Override // vc.g
    public void onRefresh(@NotNull tc.f refreshLayout) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        getNetDataForOne();
    }

    public final void setMCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mCompositeDisposable = aVar;
    }

    public final void setMOffsetChangedListener(@Nullable AppBarLayout.h hVar) {
        this.mOffsetChangedListener = hVar;
    }

    public final void setPageSize(int i) {
        this.pageSize = i;
    }
}
