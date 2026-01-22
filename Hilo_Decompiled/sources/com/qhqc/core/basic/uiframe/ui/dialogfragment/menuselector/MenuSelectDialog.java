package com.qhqc.core.basic.uiframe.ui.dialogfragment.menuselector;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.qhqc.core.basic.databinding.BasicDialogMenuSelectBinding;
import com.qhqc.core.basic.uiframe.ui.dialogfragment.BasicDialogFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J+\u0010\u0018\u001a\u00020\u00002\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u001a\"\u00020\u00072\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/qhqc/core/basic/uiframe/ui/dialogfragment/menuselector/MenuSelectDialog;", "Lcom/qhqc/core/basic/uiframe/ui/dialogfragment/BasicDialogFragment;", "()V", "mBinding", "Lcom/qhqc/core/basic/databinding/BasicDialogMenuSelectBinding;", "mList", "", "Lcom/qhqc/core/basic/uiframe/ui/dialogfragment/menuselector/Menu;", "mPayload", "", "onListener", "Lcom/qhqc/core/basic/uiframe/ui/dialogfragment/menuselector/MenuSelectDialog$OnMenuSelectedListener;", "onCreateDefView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "setMenus", FirebaseAnalytics.Param.ITEMS, "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "([Lcom/qhqc/core/basic/uiframe/ui/dialogfragment/menuselector/Menu;Lcom/qhqc/core/basic/uiframe/ui/dialogfragment/menuselector/MenuSelectDialog$OnMenuSelectedListener;)Lcom/qhqc/core/basic/uiframe/ui/dialogfragment/menuselector/MenuSelectDialog;", "setPayload", "payload", "OnMenuSelectedListener", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class MenuSelectDialog extends BasicDialogFragment {

    @Nullable
    private BasicDialogMenuSelectBinding mBinding;

    @NotNull
    private List<Menu> mList = new ArrayList();

    @Nullable
    private Object mPayload;

    @Nullable
    private OnMenuSelectedListener onListener;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0016¨\u0006\u0007"}, d2 = {"Lcom/qhqc/core/basic/uiframe/ui/dialogfragment/menuselector/MenuSelectDialog$OnMenuSelectedListener;", "", "onMenuSelected", "", "menu", "Lcom/qhqc/core/basic/uiframe/ui/dialogfragment/menuselector/Menu;", "payload", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface OnMenuSelectedListener {

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        public static final class DefaultImpls {
            public static void onMenuSelected(@NotNull OnMenuSelectedListener onMenuSelectedListener, @NotNull Menu menu) {
                Intrinsics.checkNotNullParameter(menu, "menu");
            }

            public static void onMenuSelected(@NotNull OnMenuSelectedListener onMenuSelectedListener, @NotNull Menu menu, @Nullable Object obj) {
                Intrinsics.checkNotNullParameter(menu, "menu");
            }
        }

        void onMenuSelected(@NotNull Menu menu);

        void onMenuSelected(@NotNull Menu menu, @Nullable Object payload);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3$lambda$0(MenuSelectDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3$lambda$2$lambda$1(MenuSelectDialog this$0, MenuListAdapter adapter, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "$adapter");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        OnMenuSelectedListener onMenuSelectedListener = this$0.onListener;
        if (onMenuSelectedListener != null) {
            onMenuSelectedListener.onMenuSelected(adapter.getItem(i10));
        }
        OnMenuSelectedListener onMenuSelectedListener2 = this$0.onListener;
        if (onMenuSelectedListener2 != null) {
            onMenuSelectedListener2.onMenuSelected(adapter.getItem(i10), this$0.mPayload);
        }
        this$0.dismiss();
    }

    public static /* synthetic */ MenuSelectDialog setMenus$default(MenuSelectDialog menuSelectDialog, Menu[] menuArr, OnMenuSelectedListener onMenuSelectedListener, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            onMenuSelectedListener = null;
        }
        return menuSelectDialog.setMenus(menuArr, onMenuSelectedListener);
    }

    @Override // com.qhqc.core.basic.uiframe.ui.dialogfragment.BasicDialogFragment
    @NotNull
    public View onCreateDefView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        BasicDialogMenuSelectBinding inflate = BasicDialogMenuSelectBinding.inflate(inflater, container, false);
        this.mBinding = inflate;
        Intrinsics.checkNotNull(inflate);
        LinearLayoutCompat root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mBinding = null;
        this.onListener = null;
        this.mPayload = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        BasicDialogMenuSelectBinding basicDialogMenuSelectBinding = this.mBinding;
        if (basicDialogMenuSelectBinding != null) {
            basicDialogMenuSelectBinding.mTvCancel.setOnClickListener(new View.OnClickListener() { // from class: com.qhqc.core.basic.uiframe.ui.dialogfragment.menuselector.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    MenuSelectDialog.onViewCreated$lambda$3$lambda$0(MenuSelectDialog.this, view2);
                }
            });
            basicDialogMenuSelectBinding.mRV.setLayoutManager(new LinearLayoutManager(requireContext()));
            RecyclerView recyclerView = basicDialogMenuSelectBinding.mRV;
            final MenuListAdapter menuListAdapter = new MenuListAdapter();
            menuListAdapter.setList(this.mList);
            menuListAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.qhqc.core.basic.uiframe.ui.dialogfragment.menuselector.b
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i10) {
                    MenuSelectDialog.onViewCreated$lambda$3$lambda$2$lambda$1(MenuSelectDialog.this, menuListAdapter, baseQuickAdapter, view2, i10);
                }
            });
            recyclerView.setAdapter(menuListAdapter);
        }
    }

    @NotNull
    public final MenuSelectDialog setMenus(@NotNull Menu[] items, @Nullable OnMenuSelectedListener listener) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.mList.clear();
        CollectionsKt.addAll(this.mList, items);
        this.onListener = listener;
        return this;
    }

    @NotNull
    public final MenuSelectDialog setPayload(@Nullable Object payload) {
        this.mPayload = payload;
        return this;
    }
}
