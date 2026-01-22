package com.qiahao.nextvideo.ui.home.filter.regoinpreference;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.model.common.Country;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.MatchSetTypes;
import com.qiahao.nextvideo.data.model.PurchaseFeeDetailsX;
import com.qiahao.nextvideo.data.service.PurchaseService;
import com.qiahao.nextvideo.databinding.ViewControllerRegionPreferenceBinding;
import com.qiahao.nextvideo.ui.home.filter.genderpreference.GenderPreferenceCategory;
import com.qiahao.nextvideo.ui.home.filter.genderpreference.GenderPreferenceViewController;
import com.qiahao.nextvideo.ui.home.filter.regoinpreference.RegionPreferenceViewController;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewController;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.presentation.PresentationStyle;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.presentation.PresentingAnimation;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0011H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\b\u0010\u001b\u001a\u00020\u0017H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/filter/regoinpreference/RegionPreferenceViewController;", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "<init>", "()V", "delegate", "Lcom/qiahao/nextvideo/ui/home/filter/regoinpreference/RegionPreferenceViewControllerDelegate;", "getDelegate", "()Lcom/qiahao/nextvideo/ui/home/filter/regoinpreference/RegionPreferenceViewControllerDelegate;", "setDelegate", "(Lcom/qiahao/nextvideo/ui/home/filter/regoinpreference/RegionPreferenceViewControllerDelegate;)V", "binding", "Lcom/qiahao/nextvideo/databinding/ViewControllerRegionPreferenceBinding;", "currentRegionPreferenceCategory", "Lcom/qiahao/nextvideo/ui/home/filter/regoinpreference/RegionPreferenceCategory;", "currentGenderPreferenceCategory", "Lcom/qiahao/nextvideo/ui/home/filter/genderpreference/GenderPreferenceCategory;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "viewDidLoad", "", "view", "selectedGlobal", "selectedCurrentCountry", "confirmButtonPressed", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RegionPreferenceViewController extends BaseViewController {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String TAG = "regionPreference";

    @NotNull
    private static final String keyRegionFilter = "keyRegionFilter";
    private ViewControllerRegionPreferenceBinding binding;
    private GenderPreferenceCategory currentGenderPreferenceCategory;
    private RegionPreferenceCategory currentRegionPreferenceCategory;

    @Nullable
    private RegionPreferenceViewControllerDelegate delegate;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/filter/regoinpreference/RegionPreferenceViewController$Companion;", "", "<init>", "()V", "TAG", "", RegionPreferenceViewController.keyRegionFilter, "markPerferenceCategory", "", "region", "hasPreferenceCategory", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String hasPreferenceCategory() {
            Country countryInfo;
            String name;
            MMKVStore mMKVStore = MMKVStore.INSTANCE;
            RegionPreferenceCategory regionPreferenceCategory = RegionPreferenceCategory.GLOBAL;
            if (Intrinsics.areEqual((String) IStore.DefaultImpls.getValue$default(mMKVStore, RegionPreferenceViewController.keyRegionFilter, regionPreferenceCategory.getAliasName(), (String) null, 4, (Object) null), regionPreferenceCategory.getAliasName())) {
                return regionPreferenceCategory.getAliasName();
            }
            User user = UserStore.INSTANCE.getShared().getUser();
            if (user == null || (countryInfo = user.getCountryInfo()) == null || (name = countryInfo.getName()) == null) {
                return "";
            }
            return name;
        }

        public final void markPerferenceCategory(@NotNull String region) {
            Intrinsics.checkNotNullParameter(region, "region");
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, RegionPreferenceViewController.keyRegionFilter, region, (String) null, 4, (Object) null);
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RegionPreferenceCategory.values().length];
            try {
                iArr[RegionPreferenceCategory.GLOBAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RegionPreferenceCategory.USER_OF_COUNTRY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public RegionPreferenceViewController() {
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
        ViewControllerRegionPreferenceBinding viewControllerRegionPreferenceBinding = this.binding;
        RegionPreferenceCategory regionPreferenceCategory = null;
        if (viewControllerRegionPreferenceBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerRegionPreferenceBinding = null;
        }
        Object tag = viewControllerRegionPreferenceBinding.confirmButton.getTag();
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.qiahao.nextvideo.ui.home.filter.regoinpreference.RegionPreferenceCategory");
        RegionPreferenceCategory regionPreferenceCategory2 = (RegionPreferenceCategory) tag;
        RegionPreferenceCategory regionPreferenceCategory3 = this.currentRegionPreferenceCategory;
        if (regionPreferenceCategory3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentRegionPreferenceCategory");
            regionPreferenceCategory3 = null;
        }
        if (regionPreferenceCategory2 == regionPreferenceCategory3) {
            RegionPreferenceViewControllerDelegate regionPreferenceViewControllerDelegate = this.delegate;
            if (regionPreferenceViewControllerDelegate != null) {
                regionPreferenceViewControllerDelegate.regionPreferenceViewControllerDelegateDidCancel();
                return;
            }
            return;
        }
        GenderPreferenceCategory genderPreferenceCategory = this.currentGenderPreferenceCategory;
        if (genderPreferenceCategory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentGenderPreferenceCategory");
            genderPreferenceCategory = null;
        }
        int price = genderPreferenceCategory.getPrice();
        RegionPreferenceCategory regionPreferenceCategory4 = this.currentRegionPreferenceCategory;
        if (regionPreferenceCategory4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentRegionPreferenceCategory");
            regionPreferenceCategory4 = null;
        }
        double price2 = price + regionPreferenceCategory4.getPrice();
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            d = user.getDiamondNum();
        } else {
            d = 0.0d;
        }
        if (price2 > d) {
            RegionPreferenceViewControllerDelegate regionPreferenceViewControllerDelegate2 = this.delegate;
            if (regionPreferenceViewControllerDelegate2 != null) {
                RegionPreferenceCategory regionPreferenceCategory5 = this.currentRegionPreferenceCategory;
                if (regionPreferenceCategory5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentRegionPreferenceCategory");
                } else {
                    regionPreferenceCategory = regionPreferenceCategory5;
                }
                regionPreferenceViewControllerDelegate2.regionPreferenceViewControllerDelegateTipsRecharge(regionPreferenceCategory.getPrice());
                return;
            }
            return;
        }
        RegionPreferenceViewControllerDelegate regionPreferenceViewControllerDelegate3 = this.delegate;
        if (regionPreferenceViewControllerDelegate3 != null) {
            RegionPreferenceCategory regionPreferenceCategory6 = this.currentRegionPreferenceCategory;
            if (regionPreferenceCategory6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentRegionPreferenceCategory");
            } else {
                regionPreferenceCategory = regionPreferenceCategory6;
            }
            regionPreferenceViewControllerDelegate3.regionPreferenceViewControllerDelegateDidConfirm(regionPreferenceCategory);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void selectedCurrentCountry() {
        ViewControllerRegionPreferenceBinding viewControllerRegionPreferenceBinding = this.binding;
        ViewControllerRegionPreferenceBinding viewControllerRegionPreferenceBinding2 = null;
        if (viewControllerRegionPreferenceBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerRegionPreferenceBinding = null;
        }
        viewControllerRegionPreferenceBinding.globalCheckBox.setChecked(false);
        ViewControllerRegionPreferenceBinding viewControllerRegionPreferenceBinding3 = this.binding;
        if (viewControllerRegionPreferenceBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            viewControllerRegionPreferenceBinding2 = viewControllerRegionPreferenceBinding3;
        }
        viewControllerRegionPreferenceBinding2.currentCountryCheckBox.setChecked(true);
        this.currentRegionPreferenceCategory = RegionPreferenceCategory.USER_OF_COUNTRY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void selectedGlobal() {
        ViewControllerRegionPreferenceBinding viewControllerRegionPreferenceBinding = this.binding;
        ViewControllerRegionPreferenceBinding viewControllerRegionPreferenceBinding2 = null;
        if (viewControllerRegionPreferenceBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerRegionPreferenceBinding = null;
        }
        viewControllerRegionPreferenceBinding.currentCountryCheckBox.setChecked(false);
        ViewControllerRegionPreferenceBinding viewControllerRegionPreferenceBinding3 = this.binding;
        if (viewControllerRegionPreferenceBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            viewControllerRegionPreferenceBinding2 = viewControllerRegionPreferenceBinding3;
        }
        viewControllerRegionPreferenceBinding2.globalCheckBox.setChecked(true);
        this.currentRegionPreferenceCategory = RegionPreferenceCategory.GLOBAL;
    }

    @Nullable
    public final RegionPreferenceViewControllerDelegate getDelegate() {
        return this.delegate;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(container, "container");
        ViewControllerRegionPreferenceBinding inflate = ViewControllerRegionPreferenceBinding.inflate(inflater, container, false);
        this.binding = inflate;
        View root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public final void setDelegate(@Nullable RegionPreferenceViewControllerDelegate regionPreferenceViewControllerDelegate) {
        this.delegate = regionPreferenceViewControllerDelegate;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public void viewDidLoad(@NotNull View view) {
        int i;
        String str;
        String str2;
        String str3;
        Country countryInfo;
        Country countryInfo2;
        Country countryInfo3;
        MatchSetTypes matchSetTypes;
        MatchSetTypes matchSetTypes2;
        Intrinsics.checkNotNullParameter(view, "view");
        super.viewDidLoad(view);
        RegionPreferenceCategory regionPreferenceCategory = RegionPreferenceCategory.USER_OF_COUNTRY;
        PurchaseService.Companion companion = PurchaseService.INSTANCE;
        PurchaseFeeDetailsX purchaseFeeDetail = companion.getShared().getPurchaseFeeDetail();
        int i2 = 0;
        if (purchaseFeeDetail != null && (matchSetTypes2 = purchaseFeeDetail.getMatchSetTypes()) != null) {
            i = matchSetTypes2.getUserCountryFee();
        } else {
            i = 0;
        }
        regionPreferenceCategory.setPrice(i);
        ViewControllerRegionPreferenceBinding viewControllerRegionPreferenceBinding = this.binding;
        ViewControllerRegionPreferenceBinding viewControllerRegionPreferenceBinding2 = null;
        if (viewControllerRegionPreferenceBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerRegionPreferenceBinding = null;
        }
        AppCompatTextView appCompatTextView = viewControllerRegionPreferenceBinding.regionPreferenceFeeTextView;
        PurchaseFeeDetailsX purchaseFeeDetail2 = companion.getShared().getPurchaseFeeDetail();
        if (purchaseFeeDetail2 != null && (matchSetTypes = purchaseFeeDetail2.getMatchSetTypes()) != null) {
            i2 = matchSetTypes.getUserCountryFee();
        }
        appCompatTextView.setText(String.valueOf(i2));
        ViewControllerRegionPreferenceBinding viewControllerRegionPreferenceBinding3 = this.binding;
        if (viewControllerRegionPreferenceBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerRegionPreferenceBinding3 = null;
        }
        AppCompatTextView appCompatTextView2 = viewControllerRegionPreferenceBinding3.userOfCurrentTextView;
        UserStore.Companion companion2 = UserStore.INSTANCE;
        User user = companion2.getShared().getUser();
        if (user != null && (countryInfo3 = user.getCountryInfo()) != null) {
            str = countryInfo3.getName();
        } else {
            str = null;
        }
        appCompatTextView2.setText(String.valueOf(str));
        this.currentGenderPreferenceCategory = GenderPreferenceViewController.INSTANCE.hasPreferenceCategory();
        String hasPreferenceCategory = INSTANCE.hasPreferenceCategory();
        RegionPreferenceCategory regionPreferenceCategory2 = RegionPreferenceCategory.GLOBAL;
        if (Intrinsics.areEqual(hasPreferenceCategory, regionPreferenceCategory2.getAliasName())) {
            regionPreferenceCategory = regionPreferenceCategory2;
        }
        this.currentRegionPreferenceCategory = regionPreferenceCategory;
        ViewControllerRegionPreferenceBinding viewControllerRegionPreferenceBinding4 = this.binding;
        if (viewControllerRegionPreferenceBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerRegionPreferenceBinding4 = null;
        }
        AppCompatButton appCompatButton = viewControllerRegionPreferenceBinding4.confirmButton;
        RegionPreferenceCategory regionPreferenceCategory3 = this.currentRegionPreferenceCategory;
        if (regionPreferenceCategory3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentRegionPreferenceCategory");
            regionPreferenceCategory3 = null;
        }
        appCompatButton.setTag(regionPreferenceCategory3);
        RegionPreferenceCategory regionPreferenceCategory4 = this.currentRegionPreferenceCategory;
        if (regionPreferenceCategory4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentRegionPreferenceCategory");
            regionPreferenceCategory4 = null;
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[regionPreferenceCategory4.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                selectedCurrentCountry();
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            selectedGlobal();
        }
        ViewControllerRegionPreferenceBinding viewControllerRegionPreferenceBinding5 = this.binding;
        if (viewControllerRegionPreferenceBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerRegionPreferenceBinding5 = null;
        }
        AppCompatImageView appCompatImageView = viewControllerRegionPreferenceBinding5.currentCountryImageView;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "currentCountryImageView");
        ImageUIModel.Companion companion3 = ImageUIModel.INSTANCE;
        User user2 = companion2.getShared().getUser();
        if (user2 != null && (countryInfo2 = user2.getCountryInfo()) != null) {
            str2 = countryInfo2.getIcon();
        } else {
            str2 = null;
        }
        ViewUtilitiesKt.bind$default(appCompatImageView, companion3.full(str2), null, 2, null);
        ViewControllerRegionPreferenceBinding viewControllerRegionPreferenceBinding6 = this.binding;
        if (viewControllerRegionPreferenceBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerRegionPreferenceBinding6 = null;
        }
        AppCompatTextView appCompatTextView3 = viewControllerRegionPreferenceBinding6.userOfCurrentTextView;
        User user3 = companion2.getShared().getUser();
        if (user3 != null && (countryInfo = user3.getCountryInfo()) != null) {
            str3 = countryInfo.getName();
        } else {
            str3 = null;
        }
        appCompatTextView3.setText(str3);
        ViewControllerRegionPreferenceBinding viewControllerRegionPreferenceBinding7 = this.binding;
        if (viewControllerRegionPreferenceBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerRegionPreferenceBinding7 = null;
        }
        viewControllerRegionPreferenceBinding7.confirmButton.setOnClickListener(new View.OnClickListener() { // from class: rb.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RegionPreferenceViewController.this.confirmButtonPressed();
            }
        });
        ViewControllerRegionPreferenceBinding viewControllerRegionPreferenceBinding8 = this.binding;
        if (viewControllerRegionPreferenceBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerRegionPreferenceBinding8 = null;
        }
        viewControllerRegionPreferenceBinding8.currentCountryLinearLayout.setOnClickListener(new View.OnClickListener() { // from class: rb.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RegionPreferenceViewController.this.selectedCurrentCountry();
            }
        });
        ViewControllerRegionPreferenceBinding viewControllerRegionPreferenceBinding9 = this.binding;
        if (viewControllerRegionPreferenceBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerRegionPreferenceBinding9 = null;
        }
        viewControllerRegionPreferenceBinding9.globalLinearLayout.setOnClickListener(new View.OnClickListener() { // from class: rb.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RegionPreferenceViewController.this.selectedGlobal();
            }
        });
        ViewControllerRegionPreferenceBinding viewControllerRegionPreferenceBinding10 = this.binding;
        if (viewControllerRegionPreferenceBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerRegionPreferenceBinding10 = null;
        }
        viewControllerRegionPreferenceBinding10.globalCheckBox.setOnClickListener(new View.OnClickListener() { // from class: rb.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RegionPreferenceViewController.this.selectedGlobal();
            }
        });
        ViewControllerRegionPreferenceBinding viewControllerRegionPreferenceBinding11 = this.binding;
        if (viewControllerRegionPreferenceBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            viewControllerRegionPreferenceBinding2 = viewControllerRegionPreferenceBinding11;
        }
        viewControllerRegionPreferenceBinding2.currentCountryCheckBox.setOnClickListener(new View.OnClickListener() { // from class: rb.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RegionPreferenceViewController.this.selectedCurrentCountry();
            }
        });
    }
}
