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
import com.qiahao.nextvideo.data.model.GroupThemesBean;
import com.qiahao.nextvideo.databinding.FragmentGroupThemeBinding;
import com.qiahao.nextvideo.room.activity.GroupThemesActivity;
import com.qiahao.nextvideo.room.adapter.GroupThemeAdapter;
import com.qiahao.nextvideo.ui.home.onlinefeed.recyclerview.ItemDecoration;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\u0016\u0010\f\u001a\u00020\u00152\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0019H\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/qiahao/nextvideo/room/fragment/GroupThemeFragment;", "Lcom/qiahao/nextvideo/app/base/BaseMVVMFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentGroupThemeBinding;", "Lcom/qiahao/nextvideo/room/fragment/GroupThemeViewModel;", "<init>", "()V", "viewRes", "", "getViewRes", "()I", "setViewRes", "(I)V", "commonTextDialog", "Lcom/qiahao/nextvideo/app/base/CommonTextDialog;", "mGroupThemeAdapter", "Lcom/qiahao/nextvideo/room/adapter/GroupThemeAdapter;", "getMGroupThemeAdapter", "()Lcom/qiahao/nextvideo/room/adapter/GroupThemeAdapter;", "mGroupThemeAdapter$delegate", "Lkotlin/Lazy;", "initiate", "", "initViewModelObserver", "initRecyclerView", "confirm", "Lkotlin/Function0;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GroupThemeFragment extends BaseMVVMFragment<FragmentGroupThemeBinding, GroupThemeViewModel> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private CommonTextDialog commonTextDialog;
    private int viewRes = R.layout.fragment_group_theme;

    /* renamed from: mGroupThemeAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mGroupThemeAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.fragment.r
        public final Object invoke() {
            GroupThemeAdapter mGroupThemeAdapter_delegate$lambda$0;
            mGroupThemeAdapter_delegate$lambda$0 = GroupThemeFragment.mGroupThemeAdapter_delegate$lambda$0();
            return mGroupThemeAdapter_delegate$lambda$0;
        }
    });

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/qiahao/nextvideo/room/fragment/GroupThemeFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/qiahao/nextvideo/room/fragment/GroupThemeFragment;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final GroupThemeFragment newInstance() {
            return new GroupThemeFragment();
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
        commonTextDialog2.setContentText(ResourcesKtxKt.getStringById((Object) commonTextDialog2, 2131952197), true, new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.fragment.GroupThemeFragment$commonTextDialog$1$1
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
        RecyclerView recyclerView = getMBinding().recyclerManager;
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 2));
        recyclerView.setAdapter(getMGroupThemeAdapter());
        recyclerView.addItemDecoration(new ItemDecoration());
        GroupThemeAdapter mGroupThemeAdapter = getMGroupThemeAdapter();
        if (getMViewModel().getMActivityViewModel().getMThemeType() == 2) {
            intValue = -1;
        } else {
            Object value = getMViewModel().getMActivityViewModel().getMThemeId().getValue();
            Intrinsics.checkNotNull(value);
            intValue = ((Number) value).intValue();
        }
        mGroupThemeAdapter.setSelectThemeId(intValue);
        getMGroupThemeAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.room.fragment.u
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                GroupThemeFragment.initRecyclerView$lambda$6(GroupThemeFragment.this, baseQuickAdapter, view, i);
            }
        });
        getMViewModel().getAllCommonThemeData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecyclerView$lambda$6(final GroupThemeFragment groupThemeFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.GroupThemesBean");
        final GroupThemesBean groupThemesBean = (GroupThemesBean) item;
        if (groupThemeFragment.getMGroupThemeAdapter().getSelectThemeId() == groupThemesBean.getId()) {
            return;
        }
        groupThemeFragment.commonTextDialog(new Function0() { // from class: com.qiahao.nextvideo.room.fragment.q
            public final Object invoke() {
                Unit initRecyclerView$lambda$6$lambda$5;
                initRecyclerView$lambda$6$lambda$5 = GroupThemeFragment.initRecyclerView$lambda$6$lambda$5(GroupThemeFragment.this, groupThemesBean);
                return initRecyclerView$lambda$6$lambda$5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initRecyclerView$lambda$6$lambda$5(GroupThemeFragment groupThemeFragment, GroupThemesBean groupThemesBean) {
        GroupThemeViewModel mViewModel = groupThemeFragment.getMViewModel();
        Object value = groupThemeFragment.getMViewModel().getMActivityViewModel().getMGroupId().getValue();
        Intrinsics.checkNotNull(value);
        mViewModel.updateCommonThemes((String) value, groupThemesBean.getId(), groupThemesBean.getThemeUrl());
        return Unit.INSTANCE;
    }

    private final void initViewModelObserver() {
        getMViewModel().getMActivityViewModel().getMThemeId().observe(this, new GroupThemeFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.fragment.s
            public final Object invoke(Object obj) {
                Unit initViewModelObserver$lambda$2;
                initViewModelObserver$lambda$2 = GroupThemeFragment.initViewModelObserver$lambda$2(GroupThemeFragment.this, (Integer) obj);
                return initViewModelObserver$lambda$2;
            }
        }));
        getMViewModel().getMGroupThemeListUnPeekLiveData().observe(this, new GroupThemeFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.fragment.t
            public final Object invoke(Object obj) {
                Unit initViewModelObserver$lambda$3;
                initViewModelObserver$lambda$3 = GroupThemeFragment.initViewModelObserver$lambda$3(GroupThemeFragment.this, (ArrayList) obj);
                return initViewModelObserver$lambda$3;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initViewModelObserver$lambda$2(GroupThemeFragment groupThemeFragment, Integer num) {
        if (groupThemeFragment.getMViewModel().getMActivityViewModel().getMThemeType() == 2) {
            groupThemeFragment.getMGroupThemeAdapter().setSelectThemeId(-1);
        } else {
            groupThemeFragment.getMGroupThemeAdapter().setSelectThemeId(num.intValue());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initViewModelObserver$lambda$3(GroupThemeFragment groupThemeFragment, ArrayList arrayList) {
        groupThemeFragment.getMGroupThemeAdapter().setList(arrayList);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GroupThemeAdapter mGroupThemeAdapter_delegate$lambda$0() {
        return new GroupThemeAdapter(R.layout.item_group_theme);
    }

    @NotNull
    public final GroupThemeAdapter getMGroupThemeAdapter() {
        return (GroupThemeAdapter) this.mGroupThemeAdapter.getValue();
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

    @Override // com.qiahao.nextvideo.app.base.BaseMVVMFragment
    public void setViewRes(int i) {
        this.viewRes = i;
    }
}
