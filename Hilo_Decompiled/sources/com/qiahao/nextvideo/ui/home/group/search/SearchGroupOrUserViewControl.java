package com.qiahao.nextvideo.ui.home.group.search;

import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;
import com.qiahao.base_common.interfaceing.ControllerListener;
import com.qiahao.nextvideo.HiloApplication;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.databinding.ViewSearchGroupUserBinding;
import com.qiahao.nextvideo.ui.commonlist.interactivetracking.TabEntity;
import com.qiahao.nextvideo.ui.home.group.GroupViewPagerAdapter;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewController;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewControllerKt;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 <2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001<B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u000e¢\u0006\u0004\b\u0015\u0010\u0005J'\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u0016H\u0016¢\u0006\u0004\b \u0010\u001eJ\u0017\u0010!\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b!\u0010\u001eJ\u0017\u0010\"\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\"\u0010\u001eR\"\u0010$\u001a\u00020#8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001b\u00106\u001a\u0002018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001b\u0010;\u001a\u0002078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b8\u00103\u001a\u0004\b9\u0010:¨\u0006="}, d2 = {"Lcom/qiahao/nextvideo/ui/home/group/search/SearchGroupOrUserViewControl;", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "Landroidx/viewpager/widget/ViewPager$j;", "Lo6/b;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroid/view/View;", "view", "", "viewDidLoad", "(Landroid/view/View;)V", "", "animated", "viewDidDisappear", "(Z)V", "hideoftKeyBoard", "", "position", "", "positionOffset", "positionOffsetPixels", "onPageScrolled", "(IFI)V", "onPageSelected", "(I)V", "state", "onPageScrollStateChanged", "onTabSelect", "onTabReselect", "Lcom/qiahao/nextvideo/databinding/ViewSearchGroupUserBinding;", "mDataBinding", "Lcom/qiahao/nextvideo/databinding/ViewSearchGroupUserBinding;", "getMDataBinding", "()Lcom/qiahao/nextvideo/databinding/ViewSearchGroupUserBinding;", "setMDataBinding", "(Lcom/qiahao/nextvideo/databinding/ViewSearchGroupUserBinding;)V", "Lcom/qiahao/base_common/interfaceing/ControllerListener;", "mListener", "Lcom/qiahao/base_common/interfaceing/ControllerListener;", "getMListener", "()Lcom/qiahao/base_common/interfaceing/ControllerListener;", "setMListener", "(Lcom/qiahao/base_common/interfaceing/ControllerListener;)V", "Lcom/qiahao/nextvideo/ui/home/group/search/SearchGroupViewWrapper;", "searchGroupView$delegate", "Lkotlin/Lazy;", "getSearchGroupView", "()Lcom/qiahao/nextvideo/ui/home/group/search/SearchGroupViewWrapper;", "searchGroupView", "Lcom/qiahao/nextvideo/ui/home/group/search/SearchUserViewWrapper;", "searchUserView$delegate", "getSearchUserView", "()Lcom/qiahao/nextvideo/ui/home/group/search/SearchUserViewWrapper;", "searchUserView", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSearchGroupOrUserViewControl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SearchGroupOrUserViewControl.kt\ncom/qiahao/nextvideo/ui/home/group/search/SearchGroupOrUserViewControl\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,134:1\n13472#2,2:135\n*S KotlinDebug\n*F\n+ 1 SearchGroupOrUserViewControl.kt\ncom/qiahao/nextvideo/ui/home/group/search/SearchGroupOrUserViewControl\n*L\n80#1:135,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SearchGroupOrUserViewControl extends BaseViewController implements ViewPager.j, o6.b {

    @NotNull
    public static final String TAG = "SearchGroupOrUserView";
    public ViewSearchGroupUserBinding mDataBinding;

    @Nullable
    private ControllerListener mListener;

    /* renamed from: searchGroupView$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy searchGroupView;

    /* renamed from: searchUserView$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy searchUserView;

    public SearchGroupOrUserViewControl() {
        setTag(TAG);
        this.searchGroupView = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.group.search.a
            public final Object invoke() {
                SearchGroupViewWrapper searchGroupView_delegate$lambda$0;
                searchGroupView_delegate$lambda$0 = SearchGroupOrUserViewControl.searchGroupView_delegate$lambda$0(SearchGroupOrUserViewControl.this);
                return searchGroupView_delegate$lambda$0;
            }
        });
        this.searchUserView = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.group.search.b
            public final Object invoke() {
                SearchUserViewWrapper searchUserView_delegate$lambda$1;
                searchUserView_delegate$lambda$1 = SearchGroupOrUserViewControl.searchUserView_delegate$lambda$1(SearchGroupOrUserViewControl.this);
                return searchUserView_delegate$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SearchGroupViewWrapper searchGroupView_delegate$lambda$0(SearchGroupOrUserViewControl searchGroupOrUserViewControl) {
        return new SearchGroupViewWrapper(searchGroupOrUserViewControl.getRequireContext(), searchGroupOrUserViewControl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SearchUserViewWrapper searchUserView_delegate$lambda$1(SearchGroupOrUserViewControl searchGroupOrUserViewControl) {
        return new SearchUserViewWrapper(searchGroupOrUserViewControl.getRequireContext(), searchGroupOrUserViewControl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean viewDidLoad$lambda$2(SearchGroupOrUserViewControl searchGroupOrUserViewControl, TextView textView, int i, KeyEvent keyEvent) {
        if (i == 3 || (keyEvent != null && 66 == keyEvent.getKeyCode() && keyEvent.getAction() == 0)) {
            Log.d(TAG, "viewDidLoad: 处理事件 " + ((Object) searchGroupOrUserViewControl.getMDataBinding().searchEditText.getText()));
            if (!TextUtils.isEmpty(searchGroupOrUserViewControl.getMDataBinding().searchEditText.getText())) {
                searchGroupOrUserViewControl.getSearchGroupView().getData(searchGroupOrUserViewControl.getMDataBinding().searchEditText.getText().toString());
                searchGroupOrUserViewControl.getSearchUserView().getData(searchGroupOrUserViewControl.getMDataBinding().searchEditText.getText().toString());
                return false;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewDidLoad$lambda$5(SearchGroupOrUserViewControl searchGroupOrUserViewControl, View view) {
        searchGroupOrUserViewControl.hideoftKeyBoard();
        ControllerListener controllerListener = searchGroupOrUserViewControl.mListener;
        if (controllerListener != null) {
            controllerListener.onBackPress();
        }
    }

    @NotNull
    public final ViewSearchGroupUserBinding getMDataBinding() {
        ViewSearchGroupUserBinding viewSearchGroupUserBinding = this.mDataBinding;
        if (viewSearchGroupUserBinding != null) {
            return viewSearchGroupUserBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mDataBinding");
        return null;
    }

    @Nullable
    public final ControllerListener getMListener() {
        return this.mListener;
    }

    @NotNull
    public final SearchGroupViewWrapper getSearchGroupView() {
        return (SearchGroupViewWrapper) this.searchGroupView.getValue();
    }

    @NotNull
    public final SearchUserViewWrapper getSearchUserView() {
        return (SearchUserViewWrapper) this.searchUserView.getValue();
    }

    public final void hideoftKeyBoard() {
        Object systemService = HiloApplication.INSTANCE.getCONTEXT().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(getMDataBinding().searchEditText.getWindowToken(), 0);
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(container, "container");
        setMDataBinding(ViewSearchGroupUserBinding.inflate(inflater, container, false));
        View root = getMDataBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onPageScrollStateChanged(int state) {
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    public void onPageSelected(int position) {
        getMDataBinding().commonTabLayout.setCurrentTab(position);
    }

    public void onTabReselect(int position) {
    }

    public void onTabSelect(int position) {
        getMDataBinding().viewPager.setCurrentItem(position);
    }

    public final void setMDataBinding(@NotNull ViewSearchGroupUserBinding viewSearchGroupUserBinding) {
        Intrinsics.checkNotNullParameter(viewSearchGroupUserBinding, "<set-?>");
        this.mDataBinding = viewSearchGroupUserBinding;
    }

    public final void setMListener(@Nullable ControllerListener controllerListener) {
        this.mListener = controllerListener;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public void viewDidDisappear(boolean animated) {
        super.viewDidDisappear(animated);
        getRequireActivity().setMCanShowGlobalDialog(true);
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public void viewDidLoad(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.viewDidLoad(view);
        getRequireActivity().setMCanShowGlobalDialog(false);
        if (!getRequireActivity().getMCanShowGlobalDialog()) {
            getRequireActivity().getMGlobalTipSvgaView().hideImmediate();
            getRequireActivity().getMGlobalEnvelopeView().hideImmediate();
        }
        HiloBaseActivity requireActivity = getRequireActivity();
        ConstraintLayout constraintLayout = getMDataBinding().baseRoot;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "baseRoot");
        requireActivity.setStatusBarTopOrBottom(constraintLayout, false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(getSearchGroupView());
        arrayList.add(getSearchUserView());
        getMDataBinding().viewPager.setAdapter(new GroupViewPagerAdapter(arrayList));
        getMDataBinding().viewPager.setOffscreenPageLimit(arrayList.size());
        getMDataBinding().viewPager.setCurrentItem(0);
        getMDataBinding().viewPager.addOnPageChangeListener(this);
        getMDataBinding().searchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.qiahao.nextvideo.ui.home.group.search.c
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean viewDidLoad$lambda$2;
                viewDidLoad$lambda$2 = SearchGroupOrUserViewControl.viewDidLoad$lambda$2(SearchGroupOrUserViewControl.this, textView, i, keyEvent);
                return viewDidLoad$lambda$2;
            }
        });
        String[] strArr = {BaseViewControllerKt.getString(this, 2131952939, new Object[0]), BaseViewControllerKt.getString(this, 2131953027, new Object[0])};
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < 2; i++) {
            arrayList2.add(new TabEntity(strArr[i], 0, 0));
        }
        getMDataBinding().commonTabLayout.setTabData(arrayList2);
        getMDataBinding().commonTabLayout.setCurrentTab(0);
        getMDataBinding().commonTabLayout.setOnTabSelectListener(this);
        getMDataBinding().cancel.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.group.search.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SearchGroupOrUserViewControl.viewDidLoad$lambda$5(SearchGroupOrUserViewControl.this, view2);
            }
        });
    }
}
