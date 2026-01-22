package com.qiahao.nextvideo.ui.fillpersonaldata.neighborhoodsnote;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.model.common.User;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.databinding.ViewControllerNeighborhoodsNoteBinding;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewController;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.presentation.PresentationStyle;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.presentation.PresentingAnimation;
import com.qiahao.nextvideo.ui.webview.DefaultWebActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rH\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/qiahao/nextvideo/ui/fillpersonaldata/neighborhoodsnote/NeighborhoodsNoteViewController;", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "<init>", "()V", "binding", "Lcom/qiahao/nextvideo/databinding/ViewControllerNeighborhoodsNoteBinding;", "delegate", "Lcom/qiahao/nextvideo/ui/fillpersonaldata/neighborhoodsnote/NeighborhoodsNoteViewControllerDelegate;", "getDelegate", "()Lcom/qiahao/nextvideo/ui/fillpersonaldata/neighborhoodsnote/NeighborhoodsNoteViewControllerDelegate;", "setDelegate", "(Lcom/qiahao/nextvideo/ui/fillpersonaldata/neighborhoodsnote/NeighborhoodsNoteViewControllerDelegate;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "viewDidLoad", "", "view", "disagreeAndLogOutButtonPressed", "agreeButtonPressed", "onBackPressed", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nNeighborhoodsNoteViewController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NeighborhoodsNoteViewController.kt\ncom/qiahao/nextvideo/ui/fillpersonaldata/neighborhoodsnote/NeighborhoodsNoteViewController\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,92:1\n61#2,9:93\n1#3:102\n*S KotlinDebug\n*F\n+ 1 NeighborhoodsNoteViewController.kt\ncom/qiahao/nextvideo/ui/fillpersonaldata/neighborhoodsnote/NeighborhoodsNoteViewController\n*L\n67#1:93,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class NeighborhoodsNoteViewController extends BaseViewController {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String TAG = "NeighborhoodsNote";
    private ViewControllerNeighborhoodsNoteBinding binding;

    @Nullable
    private NeighborhoodsNoteViewControllerDelegate delegate;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/ui/fillpersonaldata/neighborhoodsnote/NeighborhoodsNoteViewController$Companion;", "", "<init>", "()V", "TAG", "", "isAgreeNeighborhoodsNote", "", AgooConstants.MESSAGE_ID, "markAgreeNeighborhoodsNote", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isAgreeNeighborhoodsNote(@NotNull String id2) {
            Intrinsics.checkNotNullParameter(id2, AgooConstants.MESSAGE_ID);
            return ((Boolean) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, id2, Boolean.FALSE, (String) null, 4, (Object) null)).booleanValue();
        }

        public final boolean markAgreeNeighborhoodsNote(@NotNull String id2) {
            Intrinsics.checkNotNullParameter(id2, AgooConstants.MESSAGE_ID);
            return IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, id2, Boolean.TRUE, (String) null, 4, (Object) null);
        }

        private Companion() {
        }
    }

    public NeighborhoodsNoteViewController() {
        setTag(TAG);
        PresentationStyle presentationStyle = getPresentationStyle();
        presentationStyle.setAnimation(PresentingAnimation.BOTTOM_FADE);
        setPresentationStyle(presentationStyle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void agreeButtonPressed() {
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            INSTANCE.markAgreeNeighborhoodsNote(user.getExternalId());
        }
        NeighborhoodsNoteViewControllerDelegate neighborhoodsNoteViewControllerDelegate = this.delegate;
        if (neighborhoodsNoteViewControllerDelegate != null) {
            neighborhoodsNoteViewControllerDelegate.neighborhoodsNoteViewControllerDelegateDidAgree();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disagreeAndLogOutButtonPressed() {
        NeighborhoodsNoteViewControllerDelegate neighborhoodsNoteViewControllerDelegate = this.delegate;
        if (neighborhoodsNoteViewControllerDelegate != null) {
            neighborhoodsNoteViewControllerDelegate.neighborhoodsNoteViewControllerDelegateDidSignOut();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$6$lambda$3(NeighborhoodsNoteViewController neighborhoodsNoteViewController, ViewControllerNeighborhoodsNoteBinding viewControllerNeighborhoodsNoteBinding, View view) {
        DefaultWebActivity.Companion companion = DefaultWebActivity.INSTANCE;
        BaseActivity requireActivity = neighborhoodsNoteViewController.getRequireActivity();
        Intrinsics.checkNotNull(viewControllerNeighborhoodsNoteBinding);
        companion.start(requireActivity, ResourcesKtxKt.getStringById(viewControllerNeighborhoodsNoteBinding, 2131953717), ResourcesKtxKt.getStringById(viewControllerNeighborhoodsNoteBinding, 2131953715));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$6$lambda$4(NeighborhoodsNoteViewController neighborhoodsNoteViewController, ViewControllerNeighborhoodsNoteBinding viewControllerNeighborhoodsNoteBinding, View view) {
        DefaultWebActivity.Companion companion = DefaultWebActivity.INSTANCE;
        BaseActivity requireActivity = neighborhoodsNoteViewController.getRequireActivity();
        Intrinsics.checkNotNull(viewControllerNeighborhoodsNoteBinding);
        companion.start(requireActivity, ResourcesKtxKt.getStringById(viewControllerNeighborhoodsNoteBinding, 2131954239), ResourcesKtxKt.getStringById(viewControllerNeighborhoodsNoteBinding, 2131954238));
    }

    @Nullable
    public final NeighborhoodsNoteViewControllerDelegate getDelegate() {
        return this.delegate;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public boolean onBackPressed() {
        NeighborhoodsNoteViewControllerDelegate neighborhoodsNoteViewControllerDelegate = this.delegate;
        if (neighborhoodsNoteViewControllerDelegate != null) {
            neighborhoodsNoteViewControllerDelegate.neighborhoodsNoteViewControllerDelegateDidBack();
            return true;
        }
        return true;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @NotNull ViewGroup container) {
        ViewControllerNeighborhoodsNoteBinding viewControllerNeighborhoodsNoteBinding;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(container, "container");
        final ViewControllerNeighborhoodsNoteBinding inflate = ViewControllerNeighborhoodsNoteBinding.inflate(inflater, container, false);
        this.binding = inflate;
        ViewControllerNeighborhoodsNoteBinding viewControllerNeighborhoodsNoteBinding2 = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerNeighborhoodsNoteBinding = null;
        } else {
            viewControllerNeighborhoodsNoteBinding = inflate;
        }
        viewControllerNeighborhoodsNoteBinding.agreeButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.fillpersonaldata.neighborhoodsnote.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NeighborhoodsNoteViewController.this.agreeButtonPressed();
            }
        });
        ViewControllerNeighborhoodsNoteBinding viewControllerNeighborhoodsNoteBinding3 = this.binding;
        if (viewControllerNeighborhoodsNoteBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerNeighborhoodsNoteBinding3 = null;
        }
        viewControllerNeighborhoodsNoteBinding3.disagreeAndLogOutButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.fillpersonaldata.neighborhoodsnote.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NeighborhoodsNoteViewController.this.disagreeAndLogOutButtonPressed();
            }
        });
        ViewControllerNeighborhoodsNoteBinding viewControllerNeighborhoodsNoteBinding4 = this.binding;
        if (viewControllerNeighborhoodsNoteBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerNeighborhoodsNoteBinding4 = null;
        }
        viewControllerNeighborhoodsNoteBinding4.privacyPolicyTextView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.fillpersonaldata.neighborhoodsnote.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NeighborhoodsNoteViewController.onCreateView$lambda$6$lambda$3(NeighborhoodsNoteViewController.this, inflate, view);
            }
        });
        ViewControllerNeighborhoodsNoteBinding viewControllerNeighborhoodsNoteBinding5 = this.binding;
        if (viewControllerNeighborhoodsNoteBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerNeighborhoodsNoteBinding5 = null;
        }
        viewControllerNeighborhoodsNoteBinding5.termsOfServiceTextView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.fillpersonaldata.neighborhoodsnote.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NeighborhoodsNoteViewController.onCreateView$lambda$6$lambda$4(NeighborhoodsNoteViewController.this, inflate, view);
            }
        });
        ViewControllerNeighborhoodsNoteBinding viewControllerNeighborhoodsNoteBinding6 = this.binding;
        if (viewControllerNeighborhoodsNoteBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            viewControllerNeighborhoodsNoteBinding2 = viewControllerNeighborhoodsNoteBinding6;
        }
        final AppCompatTextView appCompatTextView = viewControllerNeighborhoodsNoteBinding2.childSafetyPolicy;
        final long j = 800;
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.fillpersonaldata.neighborhoodsnote.NeighborhoodsNoteViewController$onCreateView$lambda$6$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatTextView) > j || (appCompatTextView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatTextView, currentTimeMillis);
                    AppCompatTextView appCompatTextView2 = appCompatTextView;
                    DefaultWebActivity.Companion companion = DefaultWebActivity.INSTANCE;
                    BaseActivity requireActivity = this.getRequireActivity();
                    Intrinsics.checkNotNull(inflate);
                    String stringById = ResourcesKtxKt.getStringById(inflate, 2131952254);
                    Intrinsics.checkNotNull(inflate);
                    companion.start(requireActivity, stringById, ResourcesKtxKt.getStringById(inflate, 2131952253));
                }
            }
        });
        View root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public final void setDelegate(@Nullable NeighborhoodsNoteViewControllerDelegate neighborhoodsNoteViewControllerDelegate) {
        this.delegate = neighborhoodsNoteViewControllerDelegate;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public void viewDidLoad(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.viewDidLoad(view);
        HiloBaseActivity requireActivity = getRequireActivity();
        ViewControllerNeighborhoodsNoteBinding viewControllerNeighborhoodsNoteBinding = this.binding;
        if (viewControllerNeighborhoodsNoteBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerNeighborhoodsNoteBinding = null;
        }
        Toolbar toolbar = viewControllerNeighborhoodsNoteBinding.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        requireActivity.setStatusBarTopOrBottom(toolbar, false);
    }
}
