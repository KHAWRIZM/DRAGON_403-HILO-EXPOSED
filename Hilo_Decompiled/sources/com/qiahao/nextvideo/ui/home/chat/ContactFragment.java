package com.qiahao.nextvideo.ui.home.chat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.data.UserObjectEvent;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.cache.MMKVToLocalCache;
import com.qiahao.nextvideo.data.model.ContactsLikeEachItem;
import com.qiahao.nextvideo.data.service.FeedbackService;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.FragmentContactBinding;
import com.qiahao.nextvideo.ui.commonlist.interactivetracking.InteractiveTrackingType;
import com.qiahao.nextvideo.ui.commonlist.interactivetracking.activity.FriendStatusListActivity;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
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

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001*B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\u0006J\u000f\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\u0006J\u000f\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0006J\u0017\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u0006R\u0017\u0010\u0018\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/chat/ContactFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentContactBinding;", "Lvc/e;", "Lvc/g;", "<init>", "()V", "", "getNetDataAndInitView", "initOnClike", "initObserver", "initRecycle", "getData", "", "getLayoutResId", "()I", "onInitialize", "Ltc/f;", "refreshLayout", "onLoadMore", "(Ltc/f;)V", "onRefresh", "onDestroy", "Lnd/a;", "compositeDisposable", "Lnd/a;", "getCompositeDisposable", "()Lnd/a;", "mPageIndex", "I", "getMPageIndex", "setMPageIndex", "(I)V", "", "hasNextData", "Z", "Lcom/qiahao/nextvideo/ui/home/chat/ContactsLikeEachOtherAdapter;", "mContactsLikeEachOtherAdapter$delegate", "Lkotlin/Lazy;", "getMContactsLikeEachOtherAdapter", "()Lcom/qiahao/nextvideo/ui/home/chat/ContactsLikeEachOtherAdapter;", "mContactsLikeEachOtherAdapter", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nContactFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContactFragment.kt\ncom/qiahao/nextvideo/ui/home/chat/ContactFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,199:1\n1#2:200\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ContactFragment extends BaseBindingFragment<FragmentContactBinding> implements vc.e, vc.g {
    public static final int PAGE_SIZE = 20;
    private boolean hasNextData;

    @NotNull
    private final nd.a compositeDisposable = new nd.a();
    private int mPageIndex = 1;

    /* renamed from: mContactsLikeEachOtherAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mContactsLikeEachOtherAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.chat.i
        public final Object invoke() {
            ContactsLikeEachOtherAdapter mContactsLikeEachOtherAdapter_delegate$lambda$0;
            mContactsLikeEachOtherAdapter_delegate$lambda$0 = ContactFragment.mContactsLikeEachOtherAdapter_delegate$lambda$0();
            return mContactsLikeEachOtherAdapter_delegate$lambda$0;
        }
    });

    private final void getData() {
        this.mPageIndex = 1;
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().getLikeEachOtherContacts(this.mPageIndex, 20), new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.a
            public final Object invoke(Object obj) {
                Unit data$lambda$16;
                data$lambda$16 = ContactFragment.getData$lambda$16(ContactFragment.this, (ApiResponse) obj);
                return data$lambda$16;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.b
            public final Object invoke(Object obj) {
                Unit data$lambda$17;
                data$lambda$17 = ContactFragment.getData$lambda$17(ContactFragment.this, (Throwable) obj);
                return data$lambda$17;
            }
        }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$16(ContactFragment contactFragment, ApiResponse apiResponse) {
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        FragmentContactBinding fragmentContactBinding = (FragmentContactBinding) contactFragment.getBinding();
        if (fragmentContactBinding != null && (smartRefreshLayout2 = fragmentContactBinding.commonIdSwipeRefreshLayout) != null) {
            smartRefreshLayout2.finishRefresh();
        }
        boolean z = true;
        contactFragment.mPageIndex++;
        if (((List) apiResponse.getData()) != null && (!r0.isEmpty())) {
            List<ContactsLikeEachItem> list = (List) apiResponse.getData();
            if (list != null) {
                MMKVToLocalCache.INSTANCE.saveChatContactsCache(list);
                if (list.size() != 20) {
                    z = false;
                }
                contactFragment.hasNextData = z;
                contactFragment.getMContactsLikeEachOtherAdapter().setList(list);
            }
        } else {
            contactFragment.hasNextData = false;
        }
        FragmentContactBinding fragmentContactBinding2 = (FragmentContactBinding) contactFragment.getBinding();
        if (fragmentContactBinding2 != null && (smartRefreshLayout = fragmentContactBinding2.commonIdSwipeRefreshLayout) != null) {
            smartRefreshLayout.setEnableLoadMore(contactFragment.hasNextData);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$17(ContactFragment contactFragment, Throwable th) {
        String str;
        SmartRefreshLayout smartRefreshLayout;
        Intrinsics.checkNotNullParameter(th, "it");
        FragmentContactBinding fragmentContactBinding = (FragmentContactBinding) contactFragment.getBinding();
        if (fragmentContactBinding != null && (smartRefreshLayout = fragmentContactBinding.commonIdSwipeRefreshLayout) != null) {
            smartRefreshLayout.finishRefresh();
        }
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = contactFragment.getContext();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            str = ResourcesKtxKt.getStringById(contactFragment, 2131952667);
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
    public final ContactsLikeEachOtherAdapter getMContactsLikeEachOtherAdapter() {
        return (ContactsLikeEachOtherAdapter) this.mContactsLikeEachOtherAdapter.getValue();
    }

    private final void getNetDataAndInitView() {
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        CollapsingToolbarLayout collapsingToolbarLayout;
        AppBarLayout appBarLayout;
        FragmentContactBinding fragmentContactBinding = (FragmentContactBinding) getBinding();
        if (fragmentContactBinding != null && (appBarLayout = fragmentContactBinding.toolbar) != null) {
            appBarLayout.setOutlineProvider(null);
        }
        FragmentContactBinding fragmentContactBinding2 = (FragmentContactBinding) getBinding();
        if (fragmentContactBinding2 != null && (collapsingToolbarLayout = fragmentContactBinding2.collapsingToolbarLayout) != null) {
            collapsingToolbarLayout.setOutlineProvider(ViewOutlineProvider.BOUNDS);
        }
        FragmentContactBinding fragmentContactBinding3 = (FragmentContactBinding) getBinding();
        if (fragmentContactBinding3 != null && (smartRefreshLayout2 = fragmentContactBinding3.commonIdSwipeRefreshLayout) != null) {
            smartRefreshLayout2.setOnLoadMoreListener(this);
        }
        FragmentContactBinding fragmentContactBinding4 = (FragmentContactBinding) getBinding();
        if (fragmentContactBinding4 != null && (smartRefreshLayout = fragmentContactBinding4.commonIdSwipeRefreshLayout) != null) {
            smartRefreshLayout.setOnRefreshListener(this);
        }
        initOnClike();
        initRecycle();
        initObserver();
    }

    @SuppressLint({"SetTextI18n"})
    private final void initObserver() {
        nd.c subscribe = UserStore.INSTANCE.getShared().getUserObjectRelay().map(new pd.o() { // from class: com.qiahao.nextvideo.ui.home.chat.ContactFragment$initObserver$1
            public final UserObjectEvent apply(UserObjectEvent userObjectEvent) {
                return userObjectEvent;
            }
        }).observeOn(RxUtilsKt.getMainThread()).subscribeOn(RxUtilsKt.getMainThread()).filter(new pd.q() { // from class: com.qiahao.nextvideo.ui.home.chat.ContactFragment$initObserver$2
            public final boolean test(UserObjectEvent userObjectEvent) {
                return userObjectEvent.isAuthenticated();
            }
        }).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.ui.home.chat.ContactFragment$initObserver$3
            public final void accept(UserObjectEvent userObjectEvent) {
                TextView textView;
                TextView textView2;
                TextView textView3;
                User user = userObjectEvent.getUser();
                if (user != null) {
                    ContactFragment contactFragment = ContactFragment.this;
                    FragmentContactBinding fragmentContactBinding = (FragmentContactBinding) contactFragment.getBinding();
                    if (fragmentContactBinding != null && (textView3 = fragmentContactBinding.iLike) != null) {
                        textView3.setText(ResourcesKtxKt.getStringById(contactFragment, 2131953096) + "(" + user.getILikeCount() + ")");
                    }
                    FragmentContactBinding fragmentContactBinding2 = (FragmentContactBinding) contactFragment.getBinding();
                    if (fragmentContactBinding2 != null && (textView2 = fragmentContactBinding2.likeMe) != null) {
                        textView2.setText(ResourcesKtxKt.getStringById(contactFragment, 2131952761) + "(" + user.getLikeCount() + ")");
                    }
                    FragmentContactBinding fragmentContactBinding3 = (FragmentContactBinding) contactFragment.getBinding();
                    if (fragmentContactBinding3 == null || (textView = fragmentContactBinding3.visitor) == null) {
                        return;
                    }
                    textView.setText(ResourcesKtxKt.getStringById(contactFragment, 2131954460) + "(" + user.getVisitCount() + ")");
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        RxUtilsKt.addTo(subscribe, this.compositeDisposable);
        nd.c subscribe2 = FeedbackService.INSTANCE.getShared().getReportEventRelay().observeOn(RxUtilsKt.getMainThread()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.ui.home.chat.ContactFragment$initObserver$4
            public final void accept(String str) {
                ContactsLikeEachOtherAdapter mContactsLikeEachOtherAdapter;
                ContactsLikeEachOtherAdapter mContactsLikeEachOtherAdapter2;
                ContactsLikeEachOtherAdapter mContactsLikeEachOtherAdapter3;
                ContactsLikeEachOtherAdapter mContactsLikeEachOtherAdapter4;
                try {
                    mContactsLikeEachOtherAdapter = ContactFragment.this.getMContactsLikeEachOtherAdapter();
                    if (mContactsLikeEachOtherAdapter.getData().isEmpty()) {
                        return;
                    }
                    mContactsLikeEachOtherAdapter2 = ContactFragment.this.getMContactsLikeEachOtherAdapter();
                    int size = mContactsLikeEachOtherAdapter2.getData().size();
                    int i = -1;
                    for (int i2 = 0; i2 < size; i2++) {
                        mContactsLikeEachOtherAdapter4 = ContactFragment.this.getMContactsLikeEachOtherAdapter();
                        if (Intrinsics.areEqual(((ContactsLikeEachItem) mContactsLikeEachOtherAdapter4.getData().get(i2)).getUserBase().getExternalId(), str)) {
                            i = i2;
                        }
                    }
                    mContactsLikeEachOtherAdapter3 = ContactFragment.this.getMContactsLikeEachOtherAdapter();
                    mContactsLikeEachOtherAdapter3.removeAt(i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe2, "subscribe(...)");
        RxUtilsKt.addTo(subscribe2, this.compositeDisposable);
    }

    private final void initOnClike() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        FragmentContactBinding fragmentContactBinding = (FragmentContactBinding) getBinding();
        if (fragmentContactBinding != null && (linearLayout3 = fragmentContactBinding.llILike) != null) {
            linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ContactFragment.initOnClike$lambda$2(ContactFragment.this, view);
                }
            });
        }
        FragmentContactBinding fragmentContactBinding2 = (FragmentContactBinding) getBinding();
        if (fragmentContactBinding2 != null && (linearLayout2 = fragmentContactBinding2.llLikeMe) != null) {
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ContactFragment.initOnClike$lambda$4(ContactFragment.this, view);
                }
            });
        }
        FragmentContactBinding fragmentContactBinding3 = (FragmentContactBinding) getBinding();
        if (fragmentContactBinding3 != null && (linearLayout = fragmentContactBinding3.llVisit) != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ContactFragment.initOnClike$lambda$6(ContactFragment.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initOnClike$lambda$2(ContactFragment contactFragment, View view) {
        Context context = contactFragment.getContext();
        if (context != null) {
            FriendStatusListActivity.INSTANCE.start(context, InteractiveTrackingType.ILike);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initOnClike$lambda$4(ContactFragment contactFragment, View view) {
        Context context = contactFragment.getContext();
        if (context != null) {
            FriendStatusListActivity.INSTANCE.start(context, InteractiveTrackingType.Follow);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initOnClike$lambda$6(ContactFragment contactFragment, View view) {
        Context context = contactFragment.getContext();
        if (context != null) {
            FriendStatusListActivity.INSTANCE.start(context, InteractiveTrackingType.Visitor);
        }
    }

    private final void initRecycle() {
        RecyclerView recyclerView;
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        Context context = getContext();
        if (context != null) {
            FootLoading footLoading = new FootLoading(context);
            FragmentContactBinding fragmentContactBinding = (FragmentContactBinding) getBinding();
            if (fragmentContactBinding != null && (smartRefreshLayout2 = fragmentContactBinding.commonIdSwipeRefreshLayout) != null) {
                smartRefreshLayout2.setRefreshFooter(footLoading);
            }
        }
        FragmentContactBinding fragmentContactBinding2 = (FragmentContactBinding) getBinding();
        if (fragmentContactBinding2 != null && (smartRefreshLayout = fragmentContactBinding2.commonIdSwipeRefreshLayout) != null) {
            smartRefreshLayout.setEnableLoadMore(false);
        }
        FragmentContactBinding fragmentContactBinding3 = (FragmentContactBinding) getBinding();
        if (fragmentContactBinding3 != null && (recyclerView = fragmentContactBinding3.commonIdRecyclerView) != null) {
            recyclerView.setLayoutManager(new CustomLinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter(getMContactsLikeEachOtherAdapter());
        }
        getMContactsLikeEachOtherAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.c
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ContactFragment.initRecycle$lambda$10(ContactFragment.this, baseQuickAdapter, view, i);
            }
        });
        List<ContactsLikeEachItem> chatContactsCache = MMKVToLocalCache.INSTANCE.getChatContactsCache();
        if (chatContactsCache != null) {
            getMContactsLikeEachOtherAdapter().setList(chatContactsCache);
        }
        getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecycle$lambda$10(ContactFragment contactFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        ContactsLikeEachItem contactsLikeEachItem = (ContactsLikeEachItem) contactFragment.getMContactsLikeEachOtherAdapter().getItem(i);
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            service.openPersonPage(contactsLikeEachItem.getUserBase().getExternalId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContactsLikeEachOtherAdapter mContactsLikeEachOtherAdapter_delegate$lambda$0() {
        return new ContactsLikeEachOtherAdapter(R.layout.item_contact_like_each_other, false, false, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onLoadMore$lambda$13(ContactFragment contactFragment, ApiResponse apiResponse) {
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        boolean z = true;
        contactFragment.mPageIndex++;
        if (((List) apiResponse.getData()) != null && (!r0.isEmpty())) {
            List list = (List) apiResponse.getData();
            if (list == null || list.size() != 20) {
                z = false;
            }
            contactFragment.hasNextData = z;
            List list2 = (List) apiResponse.getData();
            if (list2 != null) {
                contactFragment.getMContactsLikeEachOtherAdapter().addData(list2);
            }
        } else {
            contactFragment.hasNextData = false;
        }
        FragmentContactBinding fragmentContactBinding = (FragmentContactBinding) contactFragment.getBinding();
        if (fragmentContactBinding != null && (smartRefreshLayout2 = fragmentContactBinding.commonIdSwipeRefreshLayout) != null) {
            smartRefreshLayout2.setEnableLoadMore(contactFragment.hasNextData);
        }
        FragmentContactBinding fragmentContactBinding2 = (FragmentContactBinding) contactFragment.getBinding();
        if (fragmentContactBinding2 != null && (smartRefreshLayout = fragmentContactBinding2.commonIdSwipeRefreshLayout) != null) {
            smartRefreshLayout.finishLoadMore();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onLoadMore$lambda$14(ContactFragment contactFragment, Throwable th) {
        SmartRefreshLayout smartRefreshLayout;
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = contactFragment.getContext();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = ResourcesKtxKt.getStringById(contactFragment, 2131952667);
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, localizedMessage, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        FragmentContactBinding fragmentContactBinding = (FragmentContactBinding) contactFragment.getBinding();
        if (fragmentContactBinding != null && (smartRefreshLayout = fragmentContactBinding.commonIdSwipeRefreshLayout) != null) {
            smartRefreshLayout.finishLoadMore();
        }
        return Unit.INSTANCE;
    }

    @NotNull
    public final nd.a getCompositeDisposable() {
        return this.compositeDisposable;
    }

    protected int getLayoutResId() {
        return R.layout.fragment_contact;
    }

    public final int getMPageIndex() {
        return this.mPageIndex;
    }

    public void onDestroy() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onDestroy();
        this.compositeDisposable.d();
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        getNetDataAndInitView();
    }

    @Override // vc.e
    public void onLoadMore(@NotNull tc.f refreshLayout) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().getLikeEachOtherContacts(this.mPageIndex, 20), new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.d
            public final Object invoke(Object obj) {
                Unit onLoadMore$lambda$13;
                onLoadMore$lambda$13 = ContactFragment.onLoadMore$lambda$13(ContactFragment.this, (ApiResponse) obj);
                return onLoadMore$lambda$13;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.e
            public final Object invoke(Object obj) {
                Unit onLoadMore$lambda$14;
                onLoadMore$lambda$14 = ContactFragment.onLoadMore$lambda$14(ContactFragment.this, (Throwable) obj);
                return onLoadMore$lambda$14;
            }
        }, (Function0) null, false, 12, (Object) null);
    }

    @Override // vc.g
    public void onRefresh(@NotNull tc.f refreshLayout) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        getData();
    }

    public final void setMPageIndex(int i) {
        this.mPageIndex = i;
    }
}
