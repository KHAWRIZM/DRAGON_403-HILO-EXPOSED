package com.qiahao.nextvideo.ui.hiloassistant;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import com.oudi.core.callback.SuperCallBack;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.navigation.NavigationHelper;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.support.BaseControlUtils;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.databinding.ViewControllerHiloAssistantBinding;
import com.qiahao.nextvideo.ui.family.FamilyApplicationActivity;
import com.qiahao.nextvideo.ui.family.FamilyCenterActivity;
import com.qiahao.nextvideo.ui.im.MessageProvide;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewController;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController;
import com.qiahao.nextvideo.ui.reusable.views.list.ItemListViewWrapperDelegate;
import com.qiahao.nextvideo.ui.store.MyBagVieController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 .2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001.B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012H\u0016J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u001cH\u0016J\b\u0010!\u001a\u00020\u0018H\u0016J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010$\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020'H\u0016J\"\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006/"}, d2 = {"Lcom/qiahao/nextvideo/ui/hiloassistant/HiloAssistantViewController;", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "Lcom/qiahao/nextvideo/ui/reusable/views/list/ItemListViewWrapperDelegate;", "Lcom/qiahao/nextvideo/ui/hiloassistant/HiloAssistantCellUIModel;", "Lcom/qiahao/nextvideo/ui/hiloassistant/ClickListener;", "<init>", "()V", "binding", "Lcom/qiahao/nextvideo/databinding/ViewControllerHiloAssistantBinding;", "itemListViewWrapper", "Lcom/qiahao/nextvideo/ui/hiloassistant/HiloAssistantItemListViewWrapper;", "mHiloAssistantViewControllerDelegate", "Lcom/qiahao/nextvideo/ui/hiloassistant/HiloAssistantViewControllerDelegate;", "getMHiloAssistantViewControllerDelegate", "()Lcom/qiahao/nextvideo/ui/hiloassistant/HiloAssistantViewControllerDelegate;", "setMHiloAssistantViewControllerDelegate", "(Lcom/qiahao/nextvideo/ui/hiloassistant/HiloAssistantViewControllerDelegate;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "viewDidLoad", "", "view", "urlActionClick", "url", "", "hiloDiamondClick", "hiloCarClick", "openGroup", "groupId", "openMyBag", "openFamilyCenter", "openFamilyApplication", "openNavigation", "noData", "isNot", "", "onBackPressed", "listViewControllerOnItemSelected", "item", "position", "", "clickTag", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class HiloAssistantViewController extends BaseViewController implements ItemListViewWrapperDelegate<HiloAssistantCellUIModel>, ClickListener {

    @NotNull
    public static final String TAG = "HiloAssistant";

    @NotNull
    public static final String keyPreloadModel = "keyPreloadModel";
    private ViewControllerHiloAssistantBinding binding;
    private HiloAssistantItemListViewWrapper itemListViewWrapper;

    @Nullable
    private HiloAssistantViewControllerDelegate mHiloAssistantViewControllerDelegate;

    public HiloAssistantViewController() {
        setTag(TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit viewDidLoad$lambda$1(HiloAssistantViewController hiloAssistantViewController, int i, int i2) {
        ViewControllerHiloAssistantBinding viewControllerHiloAssistantBinding = hiloAssistantViewController.binding;
        if (viewControllerHiloAssistantBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerHiloAssistantBinding = null;
        }
        ViewKtxKt.setMargin(viewControllerHiloAssistantBinding.toolbar, 0, Integer.valueOf(i), 0, 0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewDidLoad$lambda$2(HiloAssistantViewController hiloAssistantViewController, View view) {
        HiloAssistantViewControllerDelegate hiloAssistantViewControllerDelegate = hiloAssistantViewController.mHiloAssistantViewControllerDelegate;
        if (hiloAssistantViewControllerDelegate != null) {
            hiloAssistantViewControllerDelegate.needFinishActivity();
        }
        ViewController.dismiss$default(hiloAssistantViewController, true, null, 2, null);
    }

    @Nullable
    public final HiloAssistantViewControllerDelegate getMHiloAssistantViewControllerDelegate() {
        return this.mHiloAssistantViewControllerDelegate;
    }

    @Override // com.qiahao.nextvideo.ui.hiloassistant.ClickListener
    public void hiloCarClick(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (url.length() != 0) {
            NavigationHelper.jump$default(NavigationHelper.INSTANCE, url, (SuperCallBack) null, 2, (Object) null);
        }
    }

    @Override // com.qiahao.nextvideo.ui.hiloassistant.ClickListener
    public void hiloDiamondClick(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (url.length() != 0) {
            NavigationHelper.jump$default(NavigationHelper.INSTANCE, url, (SuperCallBack) null, 2, (Object) null);
        }
    }

    @Override // com.qiahao.nextvideo.ui.hiloassistant.ClickListener
    public void noData(boolean isNot) {
        ViewControllerHiloAssistantBinding viewControllerHiloAssistantBinding = this.binding;
        ViewControllerHiloAssistantBinding viewControllerHiloAssistantBinding2 = null;
        if (viewControllerHiloAssistantBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerHiloAssistantBinding = null;
        }
        viewControllerHiloAssistantBinding.commonIdSwipeRefreshLayout.finishRefresh();
        ViewControllerHiloAssistantBinding viewControllerHiloAssistantBinding3 = this.binding;
        if (viewControllerHiloAssistantBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerHiloAssistantBinding3 = null;
        }
        viewControllerHiloAssistantBinding3.commonIdSwipeRefreshLayout.finishLoadMore();
        if (isNot) {
            ViewControllerHiloAssistantBinding viewControllerHiloAssistantBinding4 = this.binding;
            if (viewControllerHiloAssistantBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                viewControllerHiloAssistantBinding2 = viewControllerHiloAssistantBinding4;
            }
            viewControllerHiloAssistantBinding2.emptyTipTextView.setAlpha(1.0f);
            return;
        }
        ViewControllerHiloAssistantBinding viewControllerHiloAssistantBinding5 = this.binding;
        if (viewControllerHiloAssistantBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            viewControllerHiloAssistantBinding2 = viewControllerHiloAssistantBinding5;
        }
        viewControllerHiloAssistantBinding2.emptyTipTextView.setAlpha(0.0f);
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public boolean onBackPressed() {
        return super.onBackPressed();
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(container, "container");
        ViewControllerHiloAssistantBinding inflate = ViewControllerHiloAssistantBinding.inflate(inflater, container, false);
        this.binding = inflate;
        View root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // com.qiahao.nextvideo.ui.hiloassistant.ClickListener
    public void openFamilyApplication(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        FamilyApplicationActivity.INSTANCE.startActivity(getRequireActivity());
    }

    @Override // com.qiahao.nextvideo.ui.hiloassistant.ClickListener
    public void openFamilyCenter(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (url.length() != 0) {
            FamilyCenterActivity.INSTANCE.startActivity(getRequireActivity(), Long.parseLong(url));
        }
    }

    @Override // com.qiahao.nextvideo.ui.hiloassistant.ClickListener
    public void openGroup(@NotNull String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Log.d(TAG, "openGroup: -------");
    }

    @Override // com.qiahao.nextvideo.ui.hiloassistant.ClickListener
    public void openMyBag() {
        Log.d(TAG, "openMyBag:  -------");
        ViewController.present$default(this, new MyBagVieController(), true, null, 4, null);
    }

    @Override // com.qiahao.nextvideo.ui.hiloassistant.ClickListener
    public void openNavigation(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        BaseControlUtils.INSTANCE.openCommonLink(url);
    }

    public final void setMHiloAssistantViewControllerDelegate(@Nullable HiloAssistantViewControllerDelegate hiloAssistantViewControllerDelegate) {
        this.mHiloAssistantViewControllerDelegate = hiloAssistantViewControllerDelegate;
    }

    @Override // com.qiahao.nextvideo.ui.hiloassistant.ClickListener
    public void urlActionClick(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (url.length() != 0) {
            NavigationHelper.jump$default(NavigationHelper.INSTANCE, url, (SuperCallBack) null, 2, (Object) null);
        }
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public void viewDidLoad(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.viewDidLoad(view);
        HiloBaseActivity requireActivity = getRequireActivity();
        ViewControllerHiloAssistantBinding viewControllerHiloAssistantBinding = this.binding;
        HiloAssistantItemListViewWrapper hiloAssistantItemListViewWrapper = null;
        if (viewControllerHiloAssistantBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerHiloAssistantBinding = null;
        }
        Toolbar toolbar = viewControllerHiloAssistantBinding.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        requireActivity.getStatusBarTopOrBottom(toolbar, new Function2() { // from class: com.qiahao.nextvideo.ui.hiloassistant.g
            public final Object invoke(Object obj, Object obj2) {
                Unit viewDidLoad$lambda$1;
                viewDidLoad$lambda$1 = HiloAssistantViewController.viewDidLoad$lambda$1(HiloAssistantViewController.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return viewDidLoad$lambda$1;
            }
        });
        ViewControllerHiloAssistantBinding viewControllerHiloAssistantBinding2 = this.binding;
        if (viewControllerHiloAssistantBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerHiloAssistantBinding2 = null;
        }
        viewControllerHiloAssistantBinding2.backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.hiloassistant.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HiloAssistantViewController.viewDidLoad$lambda$2(HiloAssistantViewController.this, view2);
            }
        });
        HiloAssistantItemListViewWrapper hiloAssistantItemListViewWrapper2 = new HiloAssistantItemListViewWrapper(view);
        this.itemListViewWrapper = hiloAssistantItemListViewWrapper2;
        hiloAssistantItemListViewWrapper2.setDelegate(this);
        HiloAssistantItemListViewWrapper hiloAssistantItemListViewWrapper3 = this.itemListViewWrapper;
        if (hiloAssistantItemListViewWrapper3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemListViewWrapper");
            hiloAssistantItemListViewWrapper3 = null;
        }
        hiloAssistantItemListViewWrapper3.getRecyclerView().setHasFixedSize(true);
        HiloAssistantItemListViewWrapper hiloAssistantItemListViewWrapper4 = this.itemListViewWrapper;
        if (hiloAssistantItemListViewWrapper4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemListViewWrapper");
        } else {
            hiloAssistantItemListViewWrapper = hiloAssistantItemListViewWrapper4;
        }
        hiloAssistantItemListViewWrapper.setClickListener(this);
        MessageProvide.INSTANCE.clearUnreadMessageCount("Hilo_Assistant");
    }

    @Override // com.qiahao.nextvideo.ui.reusable.views.list.ItemListViewWrapperDelegate
    public void listViewControllerOnItemSelected(@NotNull HiloAssistantCellUIModel item, int position, @Nullable String clickTag) {
        String str;
        Intrinsics.checkNotNullParameter(item, "item");
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            User user = item.getUser();
            if (user == null || (str = user.getExternalId()) == null) {
                str = "";
            }
            service.openPersonPage(str);
        }
    }
}
