package com.qiahao.nextvideo.ui.fillpersonaldata;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatTextView;
import cf.m;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.EditEvent;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.AppUtilitiesKt;
import com.qiahao.base_common.utils.DateTimeUtilityKt;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.UserObjectEventType;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.medal.Sex;
import com.qiahao.nextvideo.data.model.EditCountryData;
import com.qiahao.nextvideo.data.model.FillUserDataUIModel;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ViewControllerFillUserDataBinding;
import com.qiahao.nextvideo.ui.fillpersonaldata.neighborhoodsnote.NeighborhoodsNoteViewController;
import com.qiahao.nextvideo.ui.fillpersonaldata.neighborhoodsnote.NeighborhoodsNoteViewControllerDelegate;
import com.qiahao.nextvideo.ui.profile.activity.SelectCountryActivity;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewController;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewControllerKt;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController;
import com.qiahao.nextvideo.utilities.ColorUtility;
import com.qiahao.nextvideo.utilities.ResourceUtilsKt;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.therouter.TheRouter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000*\u0001\n\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rH\u0017J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\b\u0010\u0018\u001a\u00020\u0013H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0002J\b\u0010\u001a\u001a\u00020\u0013H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0016J \u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u001c2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010#H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006$"}, d2 = {"Lcom/qiahao/nextvideo/ui/fillpersonaldata/FillUserDataViewController;", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "Lcom/qiahao/nextvideo/ui/fillpersonaldata/neighborhoodsnote/NeighborhoodsNoteViewControllerDelegate;", "uiModel", "Lcom/qiahao/nextvideo/data/model/FillUserDataUIModel;", "<init>", "(Lcom/qiahao/nextvideo/data/model/FillUserDataUIModel;)V", "binding", "Lcom/qiahao/nextvideo/databinding/ViewControllerFillUserDataBinding;", "textWatcher", "com/qiahao/nextvideo/ui/fillpersonaldata/FillUserDataViewController$textWatcher$1", "Lcom/qiahao/nextvideo/ui/fillpersonaldata/FillUserDataViewController$textWatcher$1;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "viewDidLoad", "", "view", "onVideoEvent", "event", "Lcom/qiahao/base_common/model/eventBus/EditEvent;", "birthdayButtonPressed", "nextButtonPressed", "enabledCommitUserInformationButton", "onBackPressed", "", "neighborhoodsNoteViewControllerDelegateDidAgree", "neighborhoodsNoteViewControllerDelegateDidSignOut", "neighborhoodsNoteViewControllerDelegateDidBack", "dismiss", "animated", "completion", "Lkotlin/Function0;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFillUserDataViewController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FillUserDataViewController.kt\ncom/qiahao/nextvideo/ui/fillpersonaldata/FillUserDataViewController\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,247:1\n1#2:248\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FillUserDataViewController extends BaseViewController implements NeighborhoodsNoteViewControllerDelegate {
    private ViewControllerFillUserDataBinding binding;

    @NotNull
    private final FillUserDataViewController$textWatcher$1 textWatcher;

    @NotNull
    private final FillUserDataUIModel uiModel;

    /* JADX WARN: Type inference failed for: r2v1, types: [com.qiahao.nextvideo.ui.fillpersonaldata.FillUserDataViewController$textWatcher$1] */
    public FillUserDataViewController(@NotNull FillUserDataUIModel fillUserDataUIModel) {
        Intrinsics.checkNotNullParameter(fillUserDataUIModel, "uiModel");
        this.uiModel = fillUserDataUIModel;
        this.textWatcher = new TextWatcher() { // from class: com.qiahao.nextvideo.ui.fillpersonaldata.FillUserDataViewController$textWatcher$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                FillUserDataUIModel fillUserDataUIModel2;
                ViewControllerFillUserDataBinding viewControllerFillUserDataBinding;
                String str;
                fillUserDataUIModel2 = FillUserDataViewController.this.uiModel;
                viewControllerFillUserDataBinding = FillUserDataViewController.this.binding;
                if (viewControllerFillUserDataBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    viewControllerFillUserDataBinding = null;
                }
                Editable text = viewControllerFillUserDataBinding.nameEditText.getText();
                if (text == null || (str = text.toString()) == null) {
                    str = "";
                }
                fillUserDataUIModel2.setName(str);
                FillUserDataViewController.this.enabledCommitUserInformationButton();
            }
        };
        setTag("FillPersonalData");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void birthdayButtonPressed() {
        AppUtilitiesKt.dismissKeyboard(getRequireView());
        Calendar calendar = Calendar.getInstance();
        calendar.set(1970, 0, 1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(1, calendar2.get(1) - 18);
        f4.a d = new f4.a(getRequireContext(), new h4.e() { // from class: com.qiahao.nextvideo.ui.fillpersonaldata.b
            public final void a(Date date, View view) {
                FillUserDataViewController.birthdayButtonPressed$lambda$8(FillUserDataViewController.this, date, view);
            }
        }).h("", "", "", "", "", "").k(calendar, calendar2).m(BaseViewControllerKt.getString(this, 2131954168, new Object[0])).f(calendar2).d(BaseViewControllerKt.getString(this, 2131952171, new Object[0]));
        ViewControllerFillUserDataBinding viewControllerFillUserDataBinding = this.binding;
        if (viewControllerFillUserDataBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerFillUserDataBinding = null;
        }
        f4.a l = d.g(viewControllerFillUserDataBinding.container).l(ColorUtility.INSTANCE.getPrimaryColor());
        Resources resources = getRequireContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        l.c(ResourceUtilsKt.getColor(resources, 2131101170)).e(18).a().v(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void birthdayButtonPressed$lambda$8(FillUserDataViewController fillUserDataViewController, Date date, View view) {
        fillUserDataViewController.uiModel.setBirthday(Long.valueOf(date.getTime() / 1000));
        ViewControllerFillUserDataBinding viewControllerFillUserDataBinding = fillUserDataViewController.binding;
        if (viewControllerFillUserDataBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerFillUserDataBinding = null;
        }
        viewControllerFillUserDataBinding.birthdayEditButton.setText(DateTimeUtilityKt.getDate$default(date.getTime(), (Locale) null, (String) null, 6, (Object) null));
        fillUserDataViewController.enabledCommitUserInformationButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enabledCommitUserInformationButton() {
        long j;
        int i;
        ViewControllerFillUserDataBinding viewControllerFillUserDataBinding = this.binding;
        if (viewControllerFillUserDataBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerFillUserDataBinding = null;
        }
        AppCompatButton appCompatButton = viewControllerFillUserDataBinding.nextButton;
        String name = this.uiModel.getName();
        boolean z = false;
        if (name != null && !StringsKt.isBlank(name)) {
            Long birthday = this.uiModel.getBirthday();
            if (birthday != null) {
                j = birthday.longValue();
            } else {
                j = 0;
            }
            if (j > 0) {
                Integer sex = this.uiModel.getSex();
                if (sex != null) {
                    i = sex.intValue();
                } else {
                    i = 0;
                }
                if (i > 0) {
                    z = true;
                }
            }
        }
        appCompatButton.setSelected(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit neighborhoodsNoteViewControllerDelegateDidSignOut$lambda$16(FillUserDataViewController fillUserDataViewController) {
        fillUserDataViewController.onBackPressed();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void nextButtonPressed() {
        long j;
        String obj;
        String name = this.uiModel.getName();
        if (name != null && !StringsKt.isBlank(name)) {
            Long birthday = this.uiModel.getBirthday();
            if (birthday != null) {
                j = birthday.longValue();
            } else {
                j = 0;
            }
            if (j == 0) {
                Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, getContext(), BaseViewControllerKt.getString(this, 2131953685, new Object[0]), false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                    return;
                }
                return;
            }
            Object sex = this.uiModel.getSex();
            if (sex == null) {
                sex = 0L;
            }
            if (Intrinsics.areEqual(sex, 0)) {
                Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, getContext(), BaseViewControllerKt.getString(this, 2131953687, new Object[0]), false, 4, (Object) null);
                if (normal$default2 != null) {
                    normal$default2.show();
                    return;
                }
                return;
            }
            String country = this.uiModel.getCountry();
            if (country != null && country.length() != 0) {
                String str = "";
                showProgressDialog("");
                FillUserDataUIModel fillUserDataUIModel = this.uiModel;
                ViewControllerFillUserDataBinding viewControllerFillUserDataBinding = this.binding;
                if (viewControllerFillUserDataBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    viewControllerFillUserDataBinding = null;
                }
                Editable text = viewControllerFillUserDataBinding.nameEditText.getText();
                if (text != null && (obj = text.toString()) != null) {
                    str = obj;
                }
                fillUserDataUIModel.setName(str);
                RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().commitUserBasicInfo(this.uiModel.getName(), this.uiModel.getBirthday(), this.uiModel.getSex(), this.uiModel.getCountry()), new Function1() { // from class: com.qiahao.nextvideo.ui.fillpersonaldata.d
                    public final Object invoke(Object obj2) {
                        Unit nextButtonPressed$lambda$10;
                        nextButtonPressed$lambda$10 = FillUserDataViewController.nextButtonPressed$lambda$10(FillUserDataViewController.this, (ApiResponse) obj2);
                        return nextButtonPressed$lambda$10;
                    }
                }, new Function1() { // from class: com.qiahao.nextvideo.ui.fillpersonaldata.e
                    public final Object invoke(Object obj2) {
                        Unit nextButtonPressed$lambda$11;
                        nextButtonPressed$lambda$11 = FillUserDataViewController.nextButtonPressed$lambda$11(FillUserDataViewController.this, (Throwable) obj2);
                        return nextButtonPressed$lambda$11;
                    }
                }, new Function0() { // from class: com.qiahao.nextvideo.ui.fillpersonaldata.f
                    public final Object invoke() {
                        Unit nextButtonPressed$lambda$12;
                        nextButtonPressed$lambda$12 = FillUserDataViewController.nextButtonPressed$lambda$12(FillUserDataViewController.this);
                        return nextButtonPressed$lambda$12;
                    }
                }, false, 8, (Object) null), getCompositeDisposable());
                return;
            }
            Toast normal$default3 = HiloToasty.Companion.normal$default(HiloToasty.Companion, getContext(), BaseViewControllerKt.getString(this, 2131953686, new Object[0]), false, 4, (Object) null);
            if (normal$default3 != null) {
                normal$default3.show();
                return;
            }
            return;
        }
        Toast normal$default4 = HiloToasty.Companion.normal$default(HiloToasty.Companion, getContext(), BaseViewControllerKt.getString(this, 2131953677, new Object[0]), false, 4, (Object) null);
        if (normal$default4 != null) {
            normal$default4.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit nextButtonPressed$lambda$10(FillUserDataViewController fillUserDataViewController, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        UserStore.refreshUserInfo$default(UserStore.INSTANCE.getShared(), (User) apiResponse.getData(), null, UserObjectEventType.REFRESH, true, 2, null);
        NeighborhoodsNoteViewController neighborhoodsNoteViewController = new NeighborhoodsNoteViewController();
        neighborhoodsNoteViewController.setDelegate(fillUserDataViewController);
        ViewController.present$default(fillUserDataViewController, neighborhoodsNoteViewController, true, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit nextButtonPressed$lambda$11(FillUserDataViewController fillUserDataViewController, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = fillUserDataViewController.getContext();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            str = BaseViewControllerKt.getString(fillUserDataViewController, 2131952667, new Object[0]);
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
    public static final Unit nextButtonPressed$lambda$12(FillUserDataViewController fillUserDataViewController) {
        fillUserDataViewController.dismissProgressDialog();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBackPressed$lambda$14() {
        UserStore.INSTANCE.getShared().logout();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewDidLoad$lambda$4(FillUserDataViewController fillUserDataViewController, RadioGroup radioGroup, int i) {
        Sex sex;
        boolean z;
        ViewControllerFillUserDataBinding viewControllerFillUserDataBinding = fillUserDataViewController.binding;
        ViewControllerFillUserDataBinding viewControllerFillUserDataBinding2 = null;
        if (viewControllerFillUserDataBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerFillUserDataBinding = null;
        }
        RadioGroup radioGroup2 = viewControllerFillUserDataBinding.sexRadioGroup;
        Intrinsics.checkNotNullExpressionValue(radioGroup2, "sexRadioGroup");
        ViewControllerFillUserDataBinding viewControllerFillUserDataBinding3 = fillUserDataViewController.binding;
        if (viewControllerFillUserDataBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerFillUserDataBinding3 = null;
        }
        RadioGroup radioGroup3 = viewControllerFillUserDataBinding3.sexRadioGroup;
        Intrinsics.checkNotNullExpressionValue(radioGroup3, "sexRadioGroup");
        ViewUtilitiesKt.eachViewGroup(radioGroup2, radioGroup3, new Function2() { // from class: com.qiahao.nextvideo.ui.fillpersonaldata.g
            public final Object invoke(Object obj, Object obj2) {
                Unit viewDidLoad$lambda$4$lambda$3;
                viewDidLoad$lambda$4$lambda$3 = FillUserDataViewController.viewDidLoad$lambda$4$lambda$3(((Integer) obj).intValue(), (View) obj2);
                return viewDidLoad$lambda$4$lambda$3;
            }
        });
        AppCompatRadioButton findViewById = radioGroup.findViewById(i);
        boolean z2 = true;
        findViewById.setChecked(true);
        FillUserDataUIModel fillUserDataUIModel = fillUserDataViewController.uiModel;
        ViewControllerFillUserDataBinding viewControllerFillUserDataBinding4 = fillUserDataViewController.binding;
        if (viewControllerFillUserDataBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerFillUserDataBinding4 = null;
        }
        if (viewControllerFillUserDataBinding4.sexRadioGroup.getCheckedRadioButtonId() == 2131362175) {
            sex = Sex.BOY;
        } else {
            sex = Sex.GIRL;
        }
        fillUserDataUIModel.setSex(Integer.valueOf(sex.getCode()));
        ViewControllerFillUserDataBinding viewControllerFillUserDataBinding5 = fillUserDataViewController.binding;
        if (viewControllerFillUserDataBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerFillUserDataBinding5 = null;
        }
        AppCompatTextView appCompatTextView = viewControllerFillUserDataBinding5.maleTextView;
        ViewControllerFillUserDataBinding viewControllerFillUserDataBinding6 = fillUserDataViewController.binding;
        if (viewControllerFillUserDataBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerFillUserDataBinding6 = null;
        }
        if (viewControllerFillUserDataBinding6.sexRadioGroup.getCheckedRadioButtonId() == 2131362175) {
            z = true;
        } else {
            z = false;
        }
        appCompatTextView.setSelected(z);
        ViewControllerFillUserDataBinding viewControllerFillUserDataBinding7 = fillUserDataViewController.binding;
        if (viewControllerFillUserDataBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerFillUserDataBinding7 = null;
        }
        AppCompatTextView appCompatTextView2 = viewControllerFillUserDataBinding7.femaleTextView;
        ViewControllerFillUserDataBinding viewControllerFillUserDataBinding8 = fillUserDataViewController.binding;
        if (viewControllerFillUserDataBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            viewControllerFillUserDataBinding2 = viewControllerFillUserDataBinding8;
        }
        if (viewControllerFillUserDataBinding2.sexRadioGroup.getCheckedRadioButtonId() != 2131363048) {
            z2 = false;
        }
        appCompatTextView2.setSelected(z2);
        fillUserDataViewController.enabledCommitUserInformationButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit viewDidLoad$lambda$4$lambda$3(int i, View view) {
        Intrinsics.checkNotNullParameter(view, "childView");
        ((AppCompatRadioButton) view).setChecked(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewDidLoad$lambda$5(FillUserDataViewController fillUserDataViewController, View view) {
        SelectCountryActivity.INSTANCE.start(fillUserDataViewController.getRequireActivity(), Boolean.TRUE);
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public void dismiss(boolean animated, @Nullable Function0<Unit> completion) {
        super.dismiss(animated, completion);
        cf.c.c().r(this);
    }

    @Override // com.qiahao.nextvideo.ui.fillpersonaldata.neighborhoodsnote.NeighborhoodsNoteViewControllerDelegate
    public void neighborhoodsNoteViewControllerDelegateDidAgree() {
        UserStore.Companion companion = UserStore.INSTANCE;
        User user = companion.getShared().getUser();
        if (user != null) {
            UserStore.refreshUserInfo$default(companion.getShared(), user, companion.getShared().getAuthenticationToken(), UserObjectEventType.FILLUESRINFO, false, 8, null);
        }
        getRequireActivity().finish();
    }

    @Override // com.qiahao.nextvideo.ui.fillpersonaldata.neighborhoodsnote.NeighborhoodsNoteViewControllerDelegate
    public void neighborhoodsNoteViewControllerDelegateDidBack() {
        ViewController.dismiss$default(this, true, null, 2, null);
    }

    @Override // com.qiahao.nextvideo.ui.fillpersonaldata.neighborhoodsnote.NeighborhoodsNoteViewControllerDelegate
    public void neighborhoodsNoteViewControllerDelegateDidSignOut() {
        dismiss(true, new Function0() { // from class: com.qiahao.nextvideo.ui.fillpersonaldata.a
            public final Object invoke() {
                Unit neighborhoodsNoteViewControllerDelegateDidSignOut$lambda$16;
                neighborhoodsNoteViewControllerDelegateDidSignOut$lambda$16 = FillUserDataViewController.neighborhoodsNoteViewControllerDelegateDidSignOut$lambda$16(FillUserDataViewController.this);
                return neighborhoodsNoteViewControllerDelegateDidSignOut$lambda$16;
            }
        });
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public boolean onBackPressed() {
        dismiss(true, new Function0() { // from class: com.qiahao.nextvideo.ui.fillpersonaldata.c
            public final Object invoke() {
                Unit onBackPressed$lambda$14;
                onBackPressed$lambda$14 = FillUserDataViewController.onBackPressed$lambda$14();
                return onBackPressed$lambda$14;
            }
        });
        return true;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(container, "container");
        ViewControllerFillUserDataBinding inflate = ViewControllerFillUserDataBinding.inflate(inflater, container, false);
        this.binding = inflate;
        View root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @m(threadMode = ThreadMode.MAIN)
    public final void onVideoEvent(@NotNull EditEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event.getType(), "country")) {
            Object data = event.getData();
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.EditCountryData");
            EditCountryData editCountryData = (EditCountryData) data;
            this.uiModel.setCountry(editCountryData.getName());
            ViewControllerFillUserDataBinding viewControllerFillUserDataBinding = this.binding;
            if (viewControllerFillUserDataBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                viewControllerFillUserDataBinding = null;
            }
            viewControllerFillUserDataBinding.selectCountry.setText(editCountryData.getName());
        }
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    @SuppressLint({"ClickableViewAccessibility"})
    public void viewDidLoad(@NotNull View view) {
        Integer sex;
        Intrinsics.checkNotNullParameter(view, "view");
        super.viewDidLoad(view);
        TheRouter.inject(this);
        cf.c.c().p(this);
        ViewControllerFillUserDataBinding viewControllerFillUserDataBinding = null;
        if (this.uiModel.getBirthday() != null) {
            ViewControllerFillUserDataBinding viewControllerFillUserDataBinding2 = this.binding;
            if (viewControllerFillUserDataBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                viewControllerFillUserDataBinding2 = null;
            }
            viewControllerFillUserDataBinding2.birthdayEditButton.setVisibility(8);
            ViewControllerFillUserDataBinding viewControllerFillUserDataBinding3 = this.binding;
            if (viewControllerFillUserDataBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                viewControllerFillUserDataBinding3 = null;
            }
            viewControllerFillUserDataBinding3.birthdayEditButtonDivideView.setAlpha(0.0f);
        }
        String name = this.uiModel.getName();
        if (name != null && !StringsKt.isBlank(name)) {
            ViewControllerFillUserDataBinding viewControllerFillUserDataBinding4 = this.binding;
            if (viewControllerFillUserDataBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                viewControllerFillUserDataBinding4 = null;
            }
            viewControllerFillUserDataBinding4.nameEditText.setVisibility(8);
            ViewControllerFillUserDataBinding viewControllerFillUserDataBinding5 = this.binding;
            if (viewControllerFillUserDataBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                viewControllerFillUserDataBinding5 = null;
            }
            viewControllerFillUserDataBinding5.nameEditTextDivideView.setAlpha(0.0f);
        }
        if (this.uiModel.getCountry() != null) {
            ViewControllerFillUserDataBinding viewControllerFillUserDataBinding6 = this.binding;
            if (viewControllerFillUserDataBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                viewControllerFillUserDataBinding6 = null;
            }
            viewControllerFillUserDataBinding6.selectCountry.setVisibility(8);
            ViewControllerFillUserDataBinding viewControllerFillUserDataBinding7 = this.binding;
            if (viewControllerFillUserDataBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                viewControllerFillUserDataBinding7 = null;
            }
            viewControllerFillUserDataBinding7.countryEditButtonDivideView.setAlpha(0.0f);
        }
        Integer sex2 = this.uiModel.getSex();
        if ((sex2 != null && sex2.intValue() == 1) || ((sex = this.uiModel.getSex()) != null && sex.intValue() == 2)) {
            ViewControllerFillUserDataBinding viewControllerFillUserDataBinding8 = this.binding;
            if (viewControllerFillUserDataBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                viewControllerFillUserDataBinding8 = null;
            }
            viewControllerFillUserDataBinding8.sexRadioGroup.setVisibility(8);
            ViewControllerFillUserDataBinding viewControllerFillUserDataBinding9 = this.binding;
            if (viewControllerFillUserDataBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                viewControllerFillUserDataBinding9 = null;
            }
            viewControllerFillUserDataBinding9.genderTitleContainer.setVisibility(8);
        }
        ViewControllerFillUserDataBinding viewControllerFillUserDataBinding10 = this.binding;
        if (viewControllerFillUserDataBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerFillUserDataBinding10 = null;
        }
        AppCompatTextView appCompatTextView = viewControllerFillUserDataBinding10.registerTipsTextView;
        ViewControllerFillUserDataBinding viewControllerFillUserDataBinding11 = this.binding;
        if (viewControllerFillUserDataBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerFillUserDataBinding11 = null;
        }
        appCompatTextView.setText("*" + ((Object) viewControllerFillUserDataBinding11.registerTipsTextView.getText()));
        ViewControllerFillUserDataBinding viewControllerFillUserDataBinding12 = this.binding;
        if (viewControllerFillUserDataBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerFillUserDataBinding12 = null;
        }
        viewControllerFillUserDataBinding12.nameEditText.setText(this.uiModel.getName());
        ViewControllerFillUserDataBinding viewControllerFillUserDataBinding13 = this.binding;
        if (viewControllerFillUserDataBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerFillUserDataBinding13 = null;
        }
        viewControllerFillUserDataBinding13.birthdayEditButton.addTextChangedListener(this.textWatcher);
        ViewControllerFillUserDataBinding viewControllerFillUserDataBinding14 = this.binding;
        if (viewControllerFillUserDataBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerFillUserDataBinding14 = null;
        }
        viewControllerFillUserDataBinding14.nameEditText.addTextChangedListener(this.textWatcher);
        ViewControllerFillUserDataBinding viewControllerFillUserDataBinding15 = this.binding;
        if (viewControllerFillUserDataBinding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerFillUserDataBinding15 = null;
        }
        viewControllerFillUserDataBinding15.birthdayEditButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.fillpersonaldata.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FillUserDataViewController.this.birthdayButtonPressed();
            }
        });
        ViewControllerFillUserDataBinding viewControllerFillUserDataBinding16 = this.binding;
        if (viewControllerFillUserDataBinding16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerFillUserDataBinding16 = null;
        }
        viewControllerFillUserDataBinding16.nextButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.fillpersonaldata.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FillUserDataViewController.this.nextButtonPressed();
            }
        });
        ViewControllerFillUserDataBinding viewControllerFillUserDataBinding17 = this.binding;
        if (viewControllerFillUserDataBinding17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerFillUserDataBinding17 = null;
        }
        viewControllerFillUserDataBinding17.sexRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.qiahao.nextvideo.ui.fillpersonaldata.j
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                FillUserDataViewController.viewDidLoad$lambda$4(FillUserDataViewController.this, radioGroup, i);
            }
        });
        ViewControllerFillUserDataBinding viewControllerFillUserDataBinding18 = this.binding;
        if (viewControllerFillUserDataBinding18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            viewControllerFillUserDataBinding = viewControllerFillUserDataBinding18;
        }
        viewControllerFillUserDataBinding.selectCountry.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.fillpersonaldata.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FillUserDataViewController.viewDidLoad$lambda$5(FillUserDataViewController.this, view2);
            }
        });
    }
}
