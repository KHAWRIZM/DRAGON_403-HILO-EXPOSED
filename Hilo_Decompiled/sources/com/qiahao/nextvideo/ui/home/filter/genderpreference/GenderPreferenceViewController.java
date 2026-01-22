package com.qiahao.nextvideo.ui.home.filter.genderpreference;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatTextView;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.MatchSetTypes;
import com.qiahao.nextvideo.data.model.PurchaseFeeDetailsX;
import com.qiahao.nextvideo.data.service.PurchaseService;
import com.qiahao.nextvideo.databinding.ViewControllerGenderPreferenceBinding;
import com.qiahao.nextvideo.ui.home.filter.genderpreference.GenderPreferenceViewController;
import com.qiahao.nextvideo.ui.home.filter.regoinpreference.RegionPreferenceCategory;
import com.qiahao.nextvideo.ui.home.filter.regoinpreference.RegionPreferenceViewController;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewController;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.presentation.PresentationStyle;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.presentation.PresentingAnimation;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0011H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/filter/genderpreference/GenderPreferenceViewController;", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "<init>", "()V", "binding", "Lcom/qiahao/nextvideo/databinding/ViewControllerGenderPreferenceBinding;", "currentGenderPreferenceCategory", "Lcom/qiahao/nextvideo/ui/home/filter/genderpreference/GenderPreferenceCategory;", "currentRegionPreferenceCategory", "Lcom/qiahao/nextvideo/ui/home/filter/regoinpreference/RegionPreferenceCategory;", "delegate", "Lcom/qiahao/nextvideo/ui/home/filter/genderpreference/GenderPreferenceViewControllerDelegate;", "getDelegate", "()Lcom/qiahao/nextvideo/ui/home/filter/genderpreference/GenderPreferenceViewControllerDelegate;", "setDelegate", "(Lcom/qiahao/nextvideo/ui/home/filter/genderpreference/GenderPreferenceViewControllerDelegate;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "viewDidLoad", "", "view", "confirmButtonPressed", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GenderPreferenceViewController extends BaseViewController {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String TAG = "genderpreference";

    @NotNull
    private static final String keyGenderPreferenceCategory = "keyGenderFilter";
    private ViewControllerGenderPreferenceBinding binding;
    private GenderPreferenceCategory currentGenderPreferenceCategory;
    private RegionPreferenceCategory currentRegionPreferenceCategory;

    @Nullable
    private GenderPreferenceViewControllerDelegate delegate;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/filter/genderpreference/GenderPreferenceViewController$Companion;", "", "<init>", "()V", "TAG", "", "keyGenderPreferenceCategory", "markPreferenceCategory", "", "genderPreferenceCategory", "Lcom/qiahao/nextvideo/ui/home/filter/genderpreference/GenderPreferenceCategory;", "hasPreferenceCategory", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final GenderPreferenceCategory hasPreferenceCategory() {
            return GenderPreferenceCategory.valueOf((String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, GenderPreferenceViewController.keyGenderPreferenceCategory, "Both", (String) null, 4, (Object) null));
        }

        public final void markPreferenceCategory(@NotNull GenderPreferenceCategory genderPreferenceCategory) {
            Intrinsics.checkNotNullParameter(genderPreferenceCategory, "genderPreferenceCategory");
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, GenderPreferenceViewController.keyGenderPreferenceCategory, genderPreferenceCategory.name(), (String) null, 4, (Object) null);
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GenderPreferenceCategory.values().length];
            try {
                iArr[GenderPreferenceCategory.Both.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GenderPreferenceCategory.Female.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GenderPreferenceCategory.Male.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public GenderPreferenceViewController() {
        PresentationStyle presentationStyle = getPresentationStyle();
        presentationStyle.setAnimation(PresentingAnimation.BOTTOM_FADE);
        presentationStyle.setFullscreen(false);
        presentationStyle.setGravity(17);
        presentationStyle.setDim(true);
        presentationStyle.setOverCurrentContext(true);
        setTag(TAG);
        presentationStyle.setAllowTapOutsideToDismiss(true);
        presentationStyle.setMinimumSideMargin(Dimens.INSTANCE.getMarginXXLarge());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void confirmButtonPressed() {
        double d;
        ViewControllerGenderPreferenceBinding viewControllerGenderPreferenceBinding = this.binding;
        GenderPreferenceCategory genderPreferenceCategory = null;
        if (viewControllerGenderPreferenceBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerGenderPreferenceBinding = null;
        }
        Object tag = viewControllerGenderPreferenceBinding.confirmButton.getTag();
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.qiahao.nextvideo.ui.home.filter.genderpreference.GenderPreferenceCategory");
        GenderPreferenceCategory genderPreferenceCategory2 = (GenderPreferenceCategory) tag;
        GenderPreferenceCategory genderPreferenceCategory3 = this.currentGenderPreferenceCategory;
        if (genderPreferenceCategory3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentGenderPreferenceCategory");
            genderPreferenceCategory3 = null;
        }
        if (genderPreferenceCategory2 == genderPreferenceCategory3) {
            GenderPreferenceViewControllerDelegate genderPreferenceViewControllerDelegate = this.delegate;
            if (genderPreferenceViewControllerDelegate != null) {
                genderPreferenceViewControllerDelegate.genderPreferenceViewControllerDelegateDidCancel();
                return;
            }
            return;
        }
        RegionPreferenceCategory regionPreferenceCategory = this.currentRegionPreferenceCategory;
        if (regionPreferenceCategory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentRegionPreferenceCategory");
            regionPreferenceCategory = null;
        }
        int price = regionPreferenceCategory.getPrice();
        GenderPreferenceCategory genderPreferenceCategory4 = this.currentGenderPreferenceCategory;
        if (genderPreferenceCategory4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentGenderPreferenceCategory");
            genderPreferenceCategory4 = null;
        }
        double price2 = price + genderPreferenceCategory4.getPrice();
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            d = user.getDiamondNum();
        } else {
            d = 0.0d;
        }
        if (price2 > d) {
            GenderPreferenceViewControllerDelegate genderPreferenceViewControllerDelegate2 = this.delegate;
            if (genderPreferenceViewControllerDelegate2 != null) {
                GenderPreferenceCategory genderPreferenceCategory5 = this.currentGenderPreferenceCategory;
                if (genderPreferenceCategory5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentGenderPreferenceCategory");
                } else {
                    genderPreferenceCategory = genderPreferenceCategory5;
                }
                genderPreferenceViewControllerDelegate2.genderPreferenceViewControllerDelegateNeededRecharge(genderPreferenceCategory.getPrice());
                return;
            }
            return;
        }
        GenderPreferenceViewControllerDelegate genderPreferenceViewControllerDelegate3 = this.delegate;
        if (genderPreferenceViewControllerDelegate3 != null) {
            GenderPreferenceCategory genderPreferenceCategory6 = this.currentGenderPreferenceCategory;
            if (genderPreferenceCategory6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentGenderPreferenceCategory");
            } else {
                genderPreferenceCategory = genderPreferenceCategory6;
            }
            genderPreferenceViewControllerDelegate3.genderPreferenceViewControllerDelegateDidConfirm(genderPreferenceCategory);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit viewDidLoad$lambda$3(int i, AppCompatRadioButton appCompatRadioButton) {
        Intrinsics.checkNotNullParameter(appCompatRadioButton, "radioButton");
        appCompatRadioButton.setChecked(false);
        appCompatRadioButton.setTag(GenderPreferenceCategory.values()[i]);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewDidLoad$lambda$5(GenderPreferenceViewController genderPreferenceViewController, RadioGroup radioGroup, int i) {
        GenderPreferenceCategory genderPreferenceCategory = (GenderPreferenceCategory) radioGroup.findViewById(i).getTag();
        if (genderPreferenceCategory != null) {
            genderPreferenceViewController.currentGenderPreferenceCategory = genderPreferenceCategory;
        }
    }

    @Nullable
    public final GenderPreferenceViewControllerDelegate getDelegate() {
        return this.delegate;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(container, "container");
        ViewControllerGenderPreferenceBinding inflate = ViewControllerGenderPreferenceBinding.inflate(inflater, container, false);
        this.binding = inflate;
        View root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public final void setDelegate(@Nullable GenderPreferenceViewControllerDelegate genderPreferenceViewControllerDelegate) {
        this.delegate = genderPreferenceViewControllerDelegate;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public void viewDidLoad(@NotNull View view) {
        int i;
        Integer num;
        int i2;
        MatchSetTypes matchSetTypes;
        MatchSetTypes matchSetTypes2;
        MatchSetTypes matchSetTypes3;
        MatchSetTypes matchSetTypes4;
        Intrinsics.checkNotNullParameter(view, "view");
        super.viewDidLoad(view);
        ViewControllerGenderPreferenceBinding viewControllerGenderPreferenceBinding = this.binding;
        ViewControllerGenderPreferenceBinding viewControllerGenderPreferenceBinding2 = null;
        if (viewControllerGenderPreferenceBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerGenderPreferenceBinding = null;
        }
        AppCompatTextView appCompatTextView = viewControllerGenderPreferenceBinding.femalePriceTextView;
        PurchaseService.Companion companion = PurchaseService.INSTANCE;
        PurchaseFeeDetailsX purchaseFeeDetail = companion.getShared().getPurchaseFeeDetail();
        int i3 = 0;
        if (purchaseFeeDetail != null && (matchSetTypes4 = purchaseFeeDetail.getMatchSetTypes()) != null) {
            i = matchSetTypes4.getUseFemaleMatchFee();
        } else {
            i = 0;
        }
        appCompatTextView.setText(String.valueOf(i));
        ViewControllerGenderPreferenceBinding viewControllerGenderPreferenceBinding3 = this.binding;
        if (viewControllerGenderPreferenceBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerGenderPreferenceBinding3 = null;
        }
        AppCompatTextView appCompatTextView2 = viewControllerGenderPreferenceBinding3.malePriceTextView;
        PurchaseFeeDetailsX purchaseFeeDetail2 = companion.getShared().getPurchaseFeeDetail();
        if (purchaseFeeDetail2 != null && (matchSetTypes3 = purchaseFeeDetail2.getMatchSetTypes()) != null) {
            num = Integer.valueOf(matchSetTypes3.getUseMaleMatchFee());
        } else {
            num = null;
        }
        appCompatTextView2.setText(String.valueOf(num));
        GenderPreferenceCategory genderPreferenceCategory = GenderPreferenceCategory.Female;
        PurchaseFeeDetailsX purchaseFeeDetail3 = companion.getShared().getPurchaseFeeDetail();
        if (purchaseFeeDetail3 != null && (matchSetTypes2 = purchaseFeeDetail3.getMatchSetTypes()) != null) {
            i2 = matchSetTypes2.getUseFemaleMatchFee();
        } else {
            i2 = 0;
        }
        genderPreferenceCategory.setPrice(i2);
        GenderPreferenceCategory genderPreferenceCategory2 = GenderPreferenceCategory.Male;
        PurchaseFeeDetailsX purchaseFeeDetail4 = companion.getShared().getPurchaseFeeDetail();
        if (purchaseFeeDetail4 != null && (matchSetTypes = purchaseFeeDetail4.getMatchSetTypes()) != null) {
            i3 = matchSetTypes.getUseMaleMatchFee();
        }
        genderPreferenceCategory2.setPrice(i3);
        this.currentGenderPreferenceCategory = INSTANCE.hasPreferenceCategory();
        String hasPreferenceCategory = RegionPreferenceViewController.INSTANCE.hasPreferenceCategory();
        RegionPreferenceCategory regionPreferenceCategory = RegionPreferenceCategory.GLOBAL;
        if (!Intrinsics.areEqual(hasPreferenceCategory, regionPreferenceCategory.getAliasName())) {
            regionPreferenceCategory = RegionPreferenceCategory.USER_OF_COUNTRY;
        }
        this.currentRegionPreferenceCategory = regionPreferenceCategory;
        ViewControllerGenderPreferenceBinding viewControllerGenderPreferenceBinding4 = this.binding;
        if (viewControllerGenderPreferenceBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerGenderPreferenceBinding4 = null;
        }
        AppCompatButton appCompatButton = viewControllerGenderPreferenceBinding4.confirmButton;
        GenderPreferenceCategory genderPreferenceCategory3 = this.currentGenderPreferenceCategory;
        if (genderPreferenceCategory3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentGenderPreferenceCategory");
            genderPreferenceCategory3 = null;
        }
        appCompatButton.setTag(genderPreferenceCategory3);
        ViewControllerGenderPreferenceBinding viewControllerGenderPreferenceBinding5 = this.binding;
        if (viewControllerGenderPreferenceBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerGenderPreferenceBinding5 = null;
        }
        viewControllerGenderPreferenceBinding5.confirmButton.setOnClickListener(new View.OnClickListener() { // from class: qb.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GenderPreferenceViewController.this.confirmButtonPressed();
            }
        });
        ViewControllerGenderPreferenceBinding viewControllerGenderPreferenceBinding6 = this.binding;
        if (viewControllerGenderPreferenceBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerGenderPreferenceBinding6 = null;
        }
        RadioGroup radioGroup = viewControllerGenderPreferenceBinding6.genderPreferenceRadioGroup;
        Intrinsics.checkNotNullExpressionValue(radioGroup, "genderPreferenceRadioGroup");
        ViewControllerGenderPreferenceBinding viewControllerGenderPreferenceBinding7 = this.binding;
        if (viewControllerGenderPreferenceBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerGenderPreferenceBinding7 = null;
        }
        RadioGroup radioGroup2 = viewControllerGenderPreferenceBinding7.genderPreferenceRadioGroup;
        Intrinsics.checkNotNullExpressionValue(radioGroup2, "genderPreferenceRadioGroup");
        ViewUtilitiesKt.eachViewGroup(radioGroup, radioGroup2, new Function2() { // from class: qb.b
            public final Object invoke(Object obj, Object obj2) {
                Unit viewDidLoad$lambda$3;
                viewDidLoad$lambda$3 = GenderPreferenceViewController.viewDidLoad$lambda$3(((Integer) obj).intValue(), (AppCompatRadioButton) obj2);
                return viewDidLoad$lambda$3;
            }
        });
        GenderPreferenceCategory genderPreferenceCategory4 = this.currentGenderPreferenceCategory;
        if (genderPreferenceCategory4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentGenderPreferenceCategory");
            genderPreferenceCategory4 = null;
        }
        int i4 = WhenMappings.$EnumSwitchMapping$0[genderPreferenceCategory4.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 == 3) {
                    ViewControllerGenderPreferenceBinding viewControllerGenderPreferenceBinding8 = this.binding;
                    if (viewControllerGenderPreferenceBinding8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        viewControllerGenderPreferenceBinding8 = null;
                    }
                    viewControllerGenderPreferenceBinding8.maleRadioButton.setChecked(true);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                ViewControllerGenderPreferenceBinding viewControllerGenderPreferenceBinding9 = this.binding;
                if (viewControllerGenderPreferenceBinding9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    viewControllerGenderPreferenceBinding9 = null;
                }
                viewControllerGenderPreferenceBinding9.femaleRadioButton.setChecked(true);
            }
        } else {
            ViewControllerGenderPreferenceBinding viewControllerGenderPreferenceBinding10 = this.binding;
            if (viewControllerGenderPreferenceBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                viewControllerGenderPreferenceBinding10 = null;
            }
            viewControllerGenderPreferenceBinding10.bothRadioButton.setChecked(true);
        }
        ViewControllerGenderPreferenceBinding viewControllerGenderPreferenceBinding11 = this.binding;
        if (viewControllerGenderPreferenceBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            viewControllerGenderPreferenceBinding2 = viewControllerGenderPreferenceBinding11;
        }
        viewControllerGenderPreferenceBinding2.genderPreferenceRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: qb.c
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup3, int i5) {
                GenderPreferenceViewController.viewDidLoad$lambda$5(GenderPreferenceViewController.this, radioGroup3, i5);
            }
        });
    }
}
