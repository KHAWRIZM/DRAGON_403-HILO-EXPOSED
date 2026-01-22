package com.qiahao.nextvideo.room.fragment;

import android.view.View;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.BaseMVVMFragment;
import com.qiahao.nextvideo.app.base.CommonTextDialog;
import com.qiahao.nextvideo.data.model.CustomThemeBean;
import com.qiahao.nextvideo.databinding.FragmentGroupThemeBinding;
import com.qiahao.nextvideo.room.activity.GroupThemesActivity;
import com.qiahao.nextvideo.room.adapter.GroupMyThemeAdapter;
import com.qiahao.nextvideo.ui.home.onlinefeed.recyclerview.ItemDecoration;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\u0016\u0010\f\u001a\u00020\u00192\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u0019H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/qiahao/nextvideo/room/fragment/GroupMyThemeFragment;", "Lcom/qiahao/nextvideo/app/base/BaseMVVMFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentGroupThemeBinding;", "Lcom/qiahao/nextvideo/room/fragment/GroupThemeViewModel;", "<init>", "()V", "viewRes", "", "getViewRes", "()I", "setViewRes", "(I)V", "commonTextDialog", "Lcom/qiahao/nextvideo/app/base/CommonTextDialog;", "fragmentScope", "Lkotlinx/coroutines/CoroutineScope;", "getFragmentScope", "()Lkotlinx/coroutines/CoroutineScope;", "mGroupMyThemeAdapter", "Lcom/qiahao/nextvideo/room/adapter/GroupMyThemeAdapter;", "getMGroupMyThemeAdapter", "()Lcom/qiahao/nextvideo/room/adapter/GroupMyThemeAdapter;", "mGroupMyThemeAdapter$delegate", "Lkotlin/Lazy;", "initiate", "", "initViewModelObserver", "initRecyclerView", "confirm", "Lkotlin/Function0;", "onDestroy", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GroupMyThemeFragment extends BaseMVVMFragment<FragmentGroupThemeBinding, GroupThemeViewModel> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private CommonTextDialog commonTextDialog;
    private int viewRes = R.layout.fragment_group_theme;

    @NotNull
    private final CoroutineScope fragmentScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));

    /* renamed from: mGroupMyThemeAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mGroupMyThemeAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.fragment.l
        public final Object invoke() {
            GroupMyThemeAdapter mGroupMyThemeAdapter_delegate$lambda$0;
            mGroupMyThemeAdapter_delegate$lambda$0 = GroupMyThemeFragment.mGroupMyThemeAdapter_delegate$lambda$0();
            return mGroupMyThemeAdapter_delegate$lambda$0;
        }
    });

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/qiahao/nextvideo/room/fragment/GroupMyThemeFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/qiahao/nextvideo/room/fragment/GroupMyThemeFragment;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final GroupMyThemeFragment newInstance() {
            return new GroupMyThemeFragment();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, android.app.Dialog, com.qiahao.nextvideo.app.base.CommonTextDialog] */
    private final void commonTextDialog(final Function0<Unit> confirm) {
        CommonTextDialog commonTextDialog;
        AppCompatDialog appCompatDialog = this.commonTextDialog;
        if (appCompatDialog != null && appCompatDialog != null && appCompatDialog.isShowing() && (commonTextDialog = this.commonTextDialog) != null) {
            commonTextDialog.dismiss();
        }
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        ?? commonTextDialog2 = new CommonTextDialog(requireActivity, 0.0f, 2, null);
        commonTextDialog2.setContentText(ResourcesKtxKt.getStringById((Object) commonTextDialog2, 2131952197), true, new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.fragment.GroupMyThemeFragment$commonTextDialog$1$1
            public void cancel() {
            }

            public void confirm() {
                confirm.invoke();
            }
        });
        this.commonTextDialog = commonTextDialog2;
        commonTextDialog2.show();
    }

    private final void initRecyclerView() {
        int intValue;
        getMBinding().emptyTipTextView.setVisibility(0);
        RecyclerView recyclerView = getMBinding().recyclerManager;
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 2));
        recyclerView.setAdapter(getMGroupMyThemeAdapter());
        recyclerView.addItemDecoration(new ItemDecoration());
        GroupMyThemeAdapter mGroupMyThemeAdapter = getMGroupMyThemeAdapter();
        if (getMViewModel().getMActivityViewModel().getMThemeType() == 1) {
            intValue = -1;
        } else {
            Object value = getMViewModel().getMActivityViewModel().getMThemeId().getValue();
            Intrinsics.checkNotNull(value);
            intValue = ((Number) value).intValue();
        }
        mGroupMyThemeAdapter.setSelectThemeId(intValue);
        getMGroupMyThemeAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.room.fragment.n
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                GroupMyThemeFragment.initRecyclerView$lambda$6(GroupMyThemeFragment.this, baseQuickAdapter, view, i);
            }
        });
        GroupThemeViewModel mViewModel = getMViewModel();
        Object value2 = getMViewModel().getMActivityViewModel().getMGroupId().getValue();
        Intrinsics.checkNotNull(value2);
        mViewModel.getAllCustomThemeData((String) value2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecyclerView$lambda$6(final GroupMyThemeFragment groupMyThemeFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.CustomThemeBean");
        final CustomThemeBean customThemeBean = (CustomThemeBean) item;
        if (groupMyThemeFragment.getMGroupMyThemeAdapter().getSelectThemeId() == customThemeBean.getId()) {
            return;
        }
        groupMyThemeFragment.commonTextDialog(new Function0() { // from class: com.qiahao.nextvideo.room.fragment.m
            public final Object invoke() {
                Unit initRecyclerView$lambda$6$lambda$5;
                initRecyclerView$lambda$6$lambda$5 = GroupMyThemeFragment.initRecyclerView$lambda$6$lambda$5(GroupMyThemeFragment.this, customThemeBean);
                return initRecyclerView$lambda$6$lambda$5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initRecyclerView$lambda$6$lambda$5(GroupMyThemeFragment groupMyThemeFragment, CustomThemeBean customThemeBean) {
        GroupThemeViewModel mViewModel = groupMyThemeFragment.getMViewModel();
        Object value = groupMyThemeFragment.getMViewModel().getMActivityViewModel().getMGroupId().getValue();
        Intrinsics.checkNotNull(value);
        mViewModel.usingCustomThemes((String) value, customThemeBean.getId(), customThemeBean.getPicUrl());
        return Unit.INSTANCE;
    }

    private final void initViewModelObserver() {
        getMViewModel().getMActivityViewModel().getMThemeId().observe(this, new GroupMyThemeFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.fragment.o
            public final Object invoke(Object obj) {
                Unit initViewModelObserver$lambda$2;
                initViewModelObserver$lambda$2 = GroupMyThemeFragment.initViewModelObserver$lambda$2(GroupMyThemeFragment.this, (Integer) obj);
                return initViewModelObserver$lambda$2;
            }
        }));
        getMViewModel().getMCustomThemeListUnPeekLiveData().observe(this, new GroupMyThemeFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.fragment.p
            public final Object invoke(Object obj) {
                Unit initViewModelObserver$lambda$3;
                initViewModelObserver$lambda$3 = GroupMyThemeFragment.initViewModelObserver$lambda$3(GroupMyThemeFragment.this, (ArrayList) obj);
                return initViewModelObserver$lambda$3;
            }
        }));
        BuildersKt.launch$default(this.fragmentScope, Dispatchers.getMain(), (CoroutineStart) null, new GroupMyThemeFragment$initViewModelObserver$3(this, null), 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initViewModelObserver$lambda$2(GroupMyThemeFragment groupMyThemeFragment, Integer num) {
        if (groupMyThemeFragment.getMViewModel().getMActivityViewModel().getMThemeType() == 1) {
            groupMyThemeFragment.getMGroupMyThemeAdapter().setSelectThemeId(-1);
        } else {
            groupMyThemeFragment.getMGroupMyThemeAdapter().setSelectThemeId(num.intValue());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initViewModelObserver$lambda$3(GroupMyThemeFragment groupMyThemeFragment, ArrayList arrayList) {
        if (arrayList.isEmpty()) {
            groupMyThemeFragment.getMBinding().emptyTipTextView.setVisibility(0);
        } else {
            groupMyThemeFragment.getMBinding().emptyTipTextView.setVisibility(8);
        }
        groupMyThemeFragment.getMGroupMyThemeAdapter().setList(arrayList);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GroupMyThemeAdapter mGroupMyThemeAdapter_delegate$lambda$0() {
        return new GroupMyThemeAdapter(R.layout.item_group_my_theme);
    }

    @NotNull
    public final CoroutineScope getFragmentScope() {
        return this.fragmentScope;
    }

    @NotNull
    public final GroupMyThemeAdapter getMGroupMyThemeAdapter() {
        return (GroupMyThemeAdapter) this.mGroupMyThemeAdapter.getValue();
    }

    @Override // com.qiahao.nextvideo.app.base.BaseMVVMFragment
    public int getViewRes() {
        return this.viewRes;
    }

    @Override // com.qiahao.nextvideo.app.base.BaseMVVMFragment
    public void initiate() {
        GroupThemesActivity requireActivity = requireActivity();
        Intrinsics.checkNotNull(requireActivity, "null cannot be cast to non-null type com.qiahao.nextvideo.room.activity.GroupThemesActivity");
        getMViewModel().setActivityViewModel(requireActivity.getMViewModel());
        initRecyclerView();
        initViewModelObserver();
    }

    @Override // com.qiahao.nextvideo.app.base.BaseMVVMFragment, com.qiahao.nextvideo.app.base.BaseFragment
    public void onDestroy() {
        super.onDestroy();
        CoroutineScopeKt.cancel$default(this.fragmentScope, (CancellationException) null, 1, (Object) null);
    }

    @Override // com.qiahao.nextvideo.app.base.BaseMVVMFragment
    public void setViewRes(int i) {
        this.viewRes = i;
    }
}
