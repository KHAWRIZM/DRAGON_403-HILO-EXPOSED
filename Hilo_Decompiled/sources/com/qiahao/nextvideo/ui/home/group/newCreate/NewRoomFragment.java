package com.qiahao.nextvideo.ui.home.group.newCreate;

import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.databinding.BaseStatusEmptyBinding;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.NewRoomBean;
import com.qiahao.nextvideo.databinding.FragmentNewRoomBinding;
import com.qiahao.nextvideo.databinding.FragmentNewRoomHeadBinding;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u00020\u001aH\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/group/newCreate/NewRoomFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentNewRoomBinding;", "<init>", "()V", "mViewModel", "Lcom/qiahao/nextvideo/ui/home/group/newCreate/NewRoomViewModel;", "getMViewModel", "()Lcom/qiahao/nextvideo/ui/home/group/newCreate/NewRoomViewModel;", "mViewModel$delegate", "Lkotlin/Lazy;", "headBinding", "Lcom/qiahao/nextvideo/databinding/FragmentNewRoomHeadBinding;", "newUserAdapter", "Lcom/qiahao/nextvideo/ui/home/group/newCreate/NewUserAdapter;", "getNewUserAdapter", "()Lcom/qiahao/nextvideo/ui/home/group/newCreate/NewUserAdapter;", "newUserAdapter$delegate", "newRoomAdapter", "Lcom/qiahao/nextvideo/ui/home/group/newCreate/NewRoomAdapter;", "getNewRoomAdapter", "()Lcom/qiahao/nextvideo/ui/home/group/newCreate/NewRoomAdapter;", "newRoomAdapter$delegate", "getLayoutResId", "", "onInitialize", "", "initData", "initView", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nNewRoomFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NewRoomFragment.kt\ncom/qiahao/nextvideo/ui/home/group/newCreate/NewRoomFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,116:1\n1#2:117\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class NewRoomFragment extends BaseBindingFragment<FragmentNewRoomBinding> {

    @Nullable
    private FragmentNewRoomHeadBinding headBinding;

    /* renamed from: mViewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mViewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.group.newCreate.a
        public final Object invoke() {
            NewRoomViewModel mViewModel_delegate$lambda$0;
            mViewModel_delegate$lambda$0 = NewRoomFragment.mViewModel_delegate$lambda$0();
            return mViewModel_delegate$lambda$0;
        }
    });

    /* renamed from: newUserAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy newUserAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.group.newCreate.b
        public final Object invoke() {
            NewUserAdapter newUserAdapter_delegate$lambda$1;
            newUserAdapter_delegate$lambda$1 = NewRoomFragment.newUserAdapter_delegate$lambda$1();
            return newUserAdapter_delegate$lambda$1;
        }
    });

    /* renamed from: newRoomAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy newRoomAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.group.newCreate.c
        public final Object invoke() {
            NewRoomAdapter newRoomAdapter_delegate$lambda$2;
            newRoomAdapter_delegate$lambda$2 = NewRoomFragment.newRoomAdapter_delegate$lambda$2();
            return newRoomAdapter_delegate$lambda$2;
        }
    });

    private final NewRoomViewModel getMViewModel() {
        return (NewRoomViewModel) this.mViewModel.getValue();
    }

    private final NewRoomAdapter getNewRoomAdapter() {
        return (NewRoomAdapter) this.newRoomAdapter.getValue();
    }

    private final NewUserAdapter getNewUserAdapter() {
        return (NewUserAdapter) this.newUserAdapter.getValue();
    }

    private final void initData() {
        getMViewModel().getNewUser().observe(this, new NewRoomFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.group.newCreate.h
            public final Object invoke(Object obj) {
                Unit initData$lambda$3;
                initData$lambda$3 = NewRoomFragment.initData$lambda$3(NewRoomFragment.this, (List) obj);
                return initData$lambda$3;
            }
        }));
        getMViewModel().getNewRoom().observe(this, new NewRoomFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.group.newCreate.i
            public final Object invoke(Object obj) {
                Unit initData$lambda$4;
                initData$lambda$4 = NewRoomFragment.initData$lambda$4(NewRoomFragment.this, (List) obj);
                return initData$lambda$4;
            }
        }));
        getMViewModel().getMException().observe(this, new NewRoomFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.group.newCreate.j
            public final Object invoke(Object obj) {
                Unit initData$lambda$5;
                initData$lambda$5 = NewRoomFragment.initData$lambda$5(NewRoomFragment.this, (Pair) obj);
                return initData$lambda$5;
            }
        }));
        getMViewModel().getNewUserList();
        getMViewModel().getNewRoomList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$3(NewRoomFragment newRoomFragment, List list) {
        RecyclerView recyclerView;
        TextView textView;
        RecyclerView recyclerView2;
        TextView textView2;
        newRoomFragment.getNewUserAdapter().setList(list);
        if (list != null && !list.isEmpty()) {
            FragmentNewRoomHeadBinding fragmentNewRoomHeadBinding = newRoomFragment.headBinding;
            if (fragmentNewRoomHeadBinding != null && (textView2 = fragmentNewRoomHeadBinding.newUser) != null) {
                textView2.setVisibility(0);
            }
            FragmentNewRoomHeadBinding fragmentNewRoomHeadBinding2 = newRoomFragment.headBinding;
            if (fragmentNewRoomHeadBinding2 != null && (recyclerView2 = fragmentNewRoomHeadBinding2.newUserRecyclerView) != null) {
                recyclerView2.setVisibility(0);
            }
        } else {
            FragmentNewRoomHeadBinding fragmentNewRoomHeadBinding3 = newRoomFragment.headBinding;
            if (fragmentNewRoomHeadBinding3 != null && (textView = fragmentNewRoomHeadBinding3.newUser) != null) {
                textView.setVisibility(8);
            }
            FragmentNewRoomHeadBinding fragmentNewRoomHeadBinding4 = newRoomFragment.headBinding;
            if (fragmentNewRoomHeadBinding4 != null && (recyclerView = fragmentNewRoomHeadBinding4.newUserRecyclerView) != null) {
                recyclerView.setVisibility(8);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$4(NewRoomFragment newRoomFragment, List list) {
        BaseStatusEmptyBinding baseStatusEmptyBinding;
        ConstraintLayout root;
        TextView textView;
        BaseStatusEmptyBinding baseStatusEmptyBinding2;
        ConstraintLayout root2;
        TextView textView2;
        SmartRefreshLayout smartRefreshLayout;
        FragmentNewRoomBinding fragmentNewRoomBinding = (FragmentNewRoomBinding) newRoomFragment.getBinding();
        if (fragmentNewRoomBinding != null && (smartRefreshLayout = fragmentNewRoomBinding.refreshLayout) != null) {
            smartRefreshLayout.finishRefresh();
        }
        newRoomFragment.getNewRoomAdapter().setList(list);
        if (list != null && !list.isEmpty()) {
            FragmentNewRoomHeadBinding fragmentNewRoomHeadBinding = newRoomFragment.headBinding;
            if (fragmentNewRoomHeadBinding != null && (textView2 = fragmentNewRoomHeadBinding.newRoom) != null) {
                textView2.setVisibility(0);
            }
            FragmentNewRoomHeadBinding fragmentNewRoomHeadBinding2 = newRoomFragment.headBinding;
            if (fragmentNewRoomHeadBinding2 != null && (baseStatusEmptyBinding2 = fragmentNewRoomHeadBinding2.empty) != null && (root2 = baseStatusEmptyBinding2.getRoot()) != null) {
                root2.setVisibility(8);
            }
        } else {
            FragmentNewRoomHeadBinding fragmentNewRoomHeadBinding3 = newRoomFragment.headBinding;
            if (fragmentNewRoomHeadBinding3 != null && (textView = fragmentNewRoomHeadBinding3.newRoom) != null) {
                textView.setVisibility(8);
            }
            FragmentNewRoomHeadBinding fragmentNewRoomHeadBinding4 = newRoomFragment.headBinding;
            if (fragmentNewRoomHeadBinding4 != null && (baseStatusEmptyBinding = fragmentNewRoomHeadBinding4.empty) != null && (root = baseStatusEmptyBinding.getRoot()) != null) {
                root.setVisibility(0);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$5(NewRoomFragment newRoomFragment, Pair pair) {
        SmartRefreshLayout smartRefreshLayout;
        BaseStatusEmptyBinding baseStatusEmptyBinding;
        ConstraintLayout root;
        TextView textView;
        RecyclerView recyclerView;
        TextView textView2;
        if (Intrinsics.areEqual(pair.getFirst(), NewRoomViewModel.NEW_USER)) {
            FragmentNewRoomHeadBinding fragmentNewRoomHeadBinding = newRoomFragment.headBinding;
            if (fragmentNewRoomHeadBinding != null && (textView2 = fragmentNewRoomHeadBinding.newUser) != null) {
                textView2.setVisibility(8);
            }
            FragmentNewRoomHeadBinding fragmentNewRoomHeadBinding2 = newRoomFragment.headBinding;
            if (fragmentNewRoomHeadBinding2 != null && (recyclerView = fragmentNewRoomHeadBinding2.newUserRecyclerView) != null) {
                recyclerView.setVisibility(8);
            }
        } else if (Intrinsics.areEqual(pair.getFirst(), NewRoomViewModel.NEW_ROOM)) {
            FragmentNewRoomHeadBinding fragmentNewRoomHeadBinding3 = newRoomFragment.headBinding;
            if (fragmentNewRoomHeadBinding3 != null && (textView = fragmentNewRoomHeadBinding3.newRoom) != null) {
                textView.setVisibility(8);
            }
            FragmentNewRoomHeadBinding fragmentNewRoomHeadBinding4 = newRoomFragment.headBinding;
            if (fragmentNewRoomHeadBinding4 != null && (baseStatusEmptyBinding = fragmentNewRoomHeadBinding4.empty) != null && (root = baseStatusEmptyBinding.getRoot()) != null) {
                root.setVisibility(0);
            }
            FragmentNewRoomBinding fragmentNewRoomBinding = (FragmentNewRoomBinding) newRoomFragment.getBinding();
            if (fragmentNewRoomBinding != null && (smartRefreshLayout = fragmentNewRoomBinding.refreshLayout) != null) {
                smartRefreshLayout.finishRefresh();
            }
        }
        return Unit.INSTANCE;
    }

    private final void initView() {
        BaseStatusEmptyBinding baseStatusEmptyBinding;
        ConstraintLayout root;
        SmartRefreshLayout smartRefreshLayout;
        View root2;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        View view;
        FragmentNewRoomBinding fragmentNewRoomBinding = (FragmentNewRoomBinding) getBinding();
        if (fragmentNewRoomBinding != null && (view = fragmentNewRoomBinding.topBg) != null) {
            view.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#ffffff", "#F5F5F7", 0, 0, 0, 0, GradientDrawable.Orientation.TOP_BOTTOM, 60, (Object) null));
        }
        FragmentNewRoomHeadBinding fragmentNewRoomHeadBinding = (FragmentNewRoomHeadBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.fragment_new_room_head, (ViewGroup) null, false);
        this.headBinding = fragmentNewRoomHeadBinding;
        if (fragmentNewRoomHeadBinding != null && (recyclerView2 = fragmentNewRoomHeadBinding.newUserRecyclerView) != null) {
            recyclerView2.setAdapter(getNewUserAdapter());
        }
        FragmentNewRoomBinding fragmentNewRoomBinding2 = (FragmentNewRoomBinding) getBinding();
        if (fragmentNewRoomBinding2 != null && (recyclerView = fragmentNewRoomBinding2.recyclerView) != null) {
            recyclerView.setAdapter(getNewRoomAdapter());
        }
        FragmentNewRoomHeadBinding fragmentNewRoomHeadBinding2 = this.headBinding;
        if (fragmentNewRoomHeadBinding2 != null && (root2 = fragmentNewRoomHeadBinding2.getRoot()) != null) {
            BaseQuickAdapter.setHeaderView$default(getNewRoomAdapter(), root2, 0, 0, 6, (Object) null);
        }
        getNewUserAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.home.group.newCreate.d
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                NewRoomFragment.initView$lambda$7(NewRoomFragment.this, baseQuickAdapter, view2, i);
            }
        });
        getNewRoomAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.home.group.newCreate.e
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                NewRoomFragment.initView$lambda$8(NewRoomFragment.this, baseQuickAdapter, view2, i);
            }
        });
        FragmentNewRoomBinding fragmentNewRoomBinding3 = (FragmentNewRoomBinding) getBinding();
        if (fragmentNewRoomBinding3 != null && (smartRefreshLayout = fragmentNewRoomBinding3.refreshLayout) != null) {
            smartRefreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.home.group.newCreate.f
                @Override // vc.g
                public final void onRefresh(tc.f fVar) {
                    NewRoomFragment.initView$lambda$9(NewRoomFragment.this, fVar);
                }
            });
        }
        FragmentNewRoomHeadBinding fragmentNewRoomHeadBinding3 = this.headBinding;
        if (fragmentNewRoomHeadBinding3 != null && (baseStatusEmptyBinding = fragmentNewRoomHeadBinding3.empty) != null && (root = baseStatusEmptyBinding.getRoot()) != null) {
            root.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.group.newCreate.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    NewRoomFragment.initView$lambda$10(NewRoomFragment.this, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$10(NewRoomFragment newRoomFragment, View view) {
        SmartRefreshLayout smartRefreshLayout;
        FragmentNewRoomBinding fragmentNewRoomBinding = (FragmentNewRoomBinding) newRoomFragment.getBinding();
        if (fragmentNewRoomBinding != null && (smartRefreshLayout = fragmentNewRoomBinding.refreshLayout) != null) {
            smartRefreshLayout.autoRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7(NewRoomFragment newRoomFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        User user = (User) newRoomFragment.getNewUserAdapter().getData().get(i);
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            String groupId = user.getGroupId();
            if (groupId == null) {
                groupId = "";
            }
            service.joinLive(groupId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8(NewRoomFragment newRoomFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        NewRoomBean newRoomBean = (NewRoomBean) newRoomFragment.getNewRoomAdapter().getData().get(i);
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            String groupId = newRoomBean.getGroupId();
            if (groupId == null) {
                groupId = "";
            }
            service.joinLive(groupId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$9(NewRoomFragment newRoomFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        newRoomFragment.getMViewModel().getNewUserList();
        newRoomFragment.getMViewModel().getNewRoomList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NewRoomViewModel mViewModel_delegate$lambda$0() {
        return new NewRoomViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NewRoomAdapter newRoomAdapter_delegate$lambda$2() {
        return new NewRoomAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NewUserAdapter newUserAdapter_delegate$lambda$1() {
        return new NewUserAdapter();
    }

    protected int getLayoutResId() {
        return R.layout.fragment_new_room;
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        initView();
        initData();
    }
}
