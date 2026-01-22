package com.qiahao.nextvideo.ui.family;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.databinding.IncludeFamilyNamePlateBinding;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.FamilyInfo;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.AppUtilitiesKt;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.base_common.utils.picture.PictureSelector;
import com.qiahao.base_common.utils.picture.PictureSelectorConfigures;
import com.qiahao.base_common.wedgit.polygon.PolygonImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.databinding.FragmentFamilySettingBinding;
import java.io.File;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0011H\u0016J\u0006\u0010\u0019\u001a\u00020\u0011J\b\u0010\u001a\u001a\u00020\u0011H\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR7\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001c"}, d2 = {"Lcom/qiahao/nextvideo/ui/family/FamilySettingFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentFamilySettingBinding;", "<init>", "()V", "mActivity", "Lcom/qiahao/nextvideo/ui/family/FamilySettingActivity;", "getMActivity", "()Lcom/qiahao/nextvideo/ui/family/FamilySettingActivity;", "setMActivity", "(Lcom/qiahao/nextvideo/ui/family/FamilySettingActivity;)V", "listener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "type", "", "getListener", "()Lkotlin/jvm/functions/Function1;", "setListener", "(Lkotlin/jvm/functions/Function1;)V", "getLayoutResId", "", "onInitialize", "refreshData", "choosePicture", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFamilySettingFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FamilySettingFragment.kt\ncom/qiahao/nextvideo/ui/family/FamilySettingFragment\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,189:1\n61#2,9:190\n61#2,9:199\n61#2,9:208\n61#2,9:217\n61#2,9:226\n61#2,9:235\n*S KotlinDebug\n*F\n+ 1 FamilySettingFragment.kt\ncom/qiahao/nextvideo/ui/family/FamilySettingFragment\n*L\n62#1:190,9\n65#1:199,9\n68#1:208,9\n71#1:217,9\n74#1:226,9\n81#1:235,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FamilySettingFragment extends BaseBindingFragment<FragmentFamilySettingBinding> {

    @NotNull
    public static final String FAMILY_DECLARE = "family_declare";

    @NotNull
    public static final String FAMILY_NAME = "family_name";

    @NotNull
    public static final String FAMILY_NAME_PLATE = "family_namePlate";

    @NotNull
    public static final String FAMILY_NUMBER = "number";

    @NotNull
    public static final String FAMILY_TYPE = "type";

    @Nullable
    private Function1<? super String, Unit> listener;

    @Nullable
    private FamilySettingActivity mActivity;

    /* JADX INFO: Access modifiers changed from: private */
    public final void choosePicture() {
        PictureSelector.INSTANCE.selectorPicture(new PictureSelectorConfigures.Companion.Builder().isEnablePreviewImage(true).setWithCamera(true).isMEnableCrop(false).build(), new FamilySettingFragment$choosePicture$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$10(final FamilySettingFragment familySettingFragment, Pair pair) {
        if (Intrinsics.areEqual(pair.getFirst(), FamilySettingViewModel.CHECK_DELETE_FAMILY)) {
            Context context = familySettingFragment.getContext();
            if (context != null) {
                new TipDialog(context).setTipContent(ResourcesKtxKt.getStringById(familySettingFragment, 2131952336)).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.family.FamilySettingFragment$onInitialize$10$1$1
                    public void cancel() {
                        OnCommonDialogListener.DefaultImpls.cancel(this);
                    }

                    public void confirm() {
                        FamilySettingViewModel viewModel;
                        FamilySettingActivity mActivity = FamilySettingFragment.this.getMActivity();
                        if (mActivity != null && (viewModel = mActivity.getViewModel()) != null) {
                            viewModel.deleteFamily();
                        }
                    }
                }).show();
            }
        } else if (Intrinsics.areEqual(pair.getFirst(), FamilySettingViewModel.DELETE_FAMILY)) {
            UserStore.fetchUserDetailInfo$default(UserStore.INSTANCE.getShared(), false, 1, null);
            cf.c.c().l(new EventBusKey("disband_family", (Object) null, 2, (DefaultConstructorMarker) null));
            BaseActivity baseActivity = familySettingFragment.mActivity;
            if (baseActivity != null) {
                baseActivity.finish();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$11(FamilySettingFragment familySettingFragment, Pair pair) {
        String str;
        if (pair.getSecond() instanceof HiloException) {
            Object second = pair.getSecond();
            Intrinsics.checkNotNull(second, "null cannot be cast to non-null type com.qiahao.base_common.network.interceptors.HiloException");
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = familySettingFragment.getContext();
            String errorMessage = ((HiloException) second).getErrorMessage();
            if (errorMessage == null) {
                str = ResourcesKtxKt.getStringById(familySettingFragment, 2131952667);
            } else {
                str = errorMessage;
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$7(FamilySettingFragment familySettingFragment, FamilyInfo familyInfo) {
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, familySettingFragment.getContext(), ResourcesKtxKt.getStringById(familySettingFragment, 2131954177), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        familySettingFragment.refreshData();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$8(FamilySettingFragment familySettingFragment, Throwable th) {
        String stringById;
        String localizedMessage;
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = familySettingFragment.getContext();
        if (th != null && (localizedMessage = th.getLocalizedMessage()) != null) {
            stringById = localizedMessage;
        } else {
            stringById = ResourcesKtxKt.getStringById(familySettingFragment, 2131952667);
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, stringById, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    protected int getLayoutResId() {
        return R.layout.fragment_family_setting;
    }

    @Nullable
    public final Function1<String, Unit> getListener() {
        return this.listener;
    }

    @Nullable
    public final FamilySettingActivity getMActivity() {
        return this.mActivity;
    }

    public void onInitialize() {
        Toolbar toolbar;
        FamilySettingViewModel viewModel;
        ma.b mException;
        FamilySettingViewModel viewModel2;
        ma.b mSuccess;
        FamilySettingViewModel viewModel3;
        ma.b error;
        FamilySettingViewModel viewModel4;
        ma.b familyInfo;
        final ConstraintLayout constraintLayout;
        final ConstraintLayout constraintLayout2;
        final ConstraintLayout constraintLayout3;
        final TextView textView;
        final FrameLayout frameLayout;
        final AppCompatImageView appCompatImageView;
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        FragmentFamilySettingBinding fragmentFamilySettingBinding = (FragmentFamilySettingBinding) getBinding();
        if (fragmentFamilySettingBinding != null) {
            toolbar = fragmentFamilySettingBinding.toolbar;
        } else {
            toolbar = null;
        }
        setStatusBarTopOrBottom(toolbar, false);
        BaseActivity activity = HiloUtils.INSTANCE.getActivity(getContext());
        if (activity != null && (activity instanceof FamilySettingActivity)) {
            this.mActivity = (FamilySettingActivity) activity;
        }
        FragmentFamilySettingBinding fragmentFamilySettingBinding2 = (FragmentFamilySettingBinding) getBinding();
        final long j = 800;
        if (fragmentFamilySettingBinding2 != null && (appCompatImageView = fragmentFamilySettingBinding2.backImageView) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilySettingFragment$onInitialize$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView) > j || (appCompatImageView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(appCompatImageView, currentTimeMillis);
                        AppCompatImageView appCompatImageView2 = appCompatImageView;
                        BaseActivity mActivity = this.getMActivity();
                        if (mActivity != null) {
                            mActivity.finish();
                        }
                    }
                }
            });
        }
        FragmentFamilySettingBinding fragmentFamilySettingBinding3 = (FragmentFamilySettingBinding) getBinding();
        if (fragmentFamilySettingBinding3 != null && (frameLayout = fragmentFamilySettingBinding3.profileLayout) != null) {
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilySettingFragment$onInitialize$$inlined$singleClick$default$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(frameLayout) > j || (frameLayout instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(frameLayout, currentTimeMillis);
                        this.choosePicture();
                    }
                }
            });
        }
        FragmentFamilySettingBinding fragmentFamilySettingBinding4 = (FragmentFamilySettingBinding) getBinding();
        if (fragmentFamilySettingBinding4 != null && (textView = fragmentFamilySettingBinding4.delete) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilySettingFragment$onInitialize$$inlined$singleClick$default$3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FamilySettingViewModel viewModel5;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                        FamilySettingActivity mActivity = this.getMActivity();
                        if (mActivity != null && (viewModel5 = mActivity.getViewModel()) != null) {
                            viewModel5.checkDeleteFamily();
                        }
                    }
                }
            });
        }
        FragmentFamilySettingBinding fragmentFamilySettingBinding5 = (FragmentFamilySettingBinding) getBinding();
        if (fragmentFamilySettingBinding5 != null && (constraintLayout3 = fragmentFamilySettingBinding5.familyNameLayout) != null) {
            constraintLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilySettingFragment$onInitialize$$inlined$singleClick$default$4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout3) > j || (constraintLayout3 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(constraintLayout3, currentTimeMillis);
                        ConstraintLayout constraintLayout4 = constraintLayout3;
                        Function1<String, Unit> listener = this.getListener();
                        if (listener != null) {
                            listener.invoke(FamilySettingFragment.FAMILY_NAME);
                        }
                    }
                }
            });
        }
        FragmentFamilySettingBinding fragmentFamilySettingBinding6 = (FragmentFamilySettingBinding) getBinding();
        if (fragmentFamilySettingBinding6 != null && (constraintLayout2 = fragmentFamilySettingBinding6.namePlateLayout) != null) {
            constraintLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilySettingFragment$onInitialize$$inlined$singleClick$default$5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i;
                    FamilySettingViewModel viewModel5;
                    ma.b familyInfo2;
                    FamilyInfo familyInfo3;
                    Integer grade;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout2) > j || (constraintLayout2 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(constraintLayout2, currentTimeMillis);
                        ConstraintLayout constraintLayout4 = constraintLayout2;
                        FamilySettingActivity mActivity = this.getMActivity();
                        if (mActivity != null && (viewModel5 = mActivity.getViewModel()) != null && (familyInfo2 = viewModel5.getFamilyInfo()) != null && (familyInfo3 = (FamilyInfo) familyInfo2.getValue()) != null && (grade = familyInfo3.getGrade()) != null) {
                            i = grade.intValue();
                        } else {
                            i = 0;
                        }
                        if (i < 1) {
                            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, this.getMActivity(), ResourcesKtxKt.getStringById(this, 2131953508), false, 4, (Object) null);
                            if (normal$default != null) {
                                normal$default.show();
                                return;
                            }
                            return;
                        }
                        Function1<String, Unit> listener = this.getListener();
                        if (listener != null) {
                            listener.invoke(FamilySettingFragment.FAMILY_NAME_PLATE);
                        }
                    }
                }
            });
        }
        FragmentFamilySettingBinding fragmentFamilySettingBinding7 = (FragmentFamilySettingBinding) getBinding();
        if (fragmentFamilySettingBinding7 != null && (constraintLayout = fragmentFamilySettingBinding7.declareLayout) != null) {
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilySettingFragment$onInitialize$$inlined$singleClick$default$6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout) > j || (constraintLayout instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(constraintLayout, currentTimeMillis);
                        ConstraintLayout constraintLayout4 = constraintLayout;
                        Function1<String, Unit> listener = this.getListener();
                        if (listener != null) {
                            listener.invoke(FamilySettingFragment.FAMILY_DECLARE);
                        }
                    }
                }
            });
        }
        refreshData();
        FamilySettingActivity familySettingActivity = this.mActivity;
        if (familySettingActivity != null && (viewModel4 = familySettingActivity.getViewModel()) != null && (familyInfo = viewModel4.getFamilyInfo()) != null) {
            familyInfo.observe(this, new FamilySettingFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.family.i3
                public final Object invoke(Object obj) {
                    Unit onInitialize$lambda$7;
                    onInitialize$lambda$7 = FamilySettingFragment.onInitialize$lambda$7(FamilySettingFragment.this, (FamilyInfo) obj);
                    return onInitialize$lambda$7;
                }
            }));
        }
        FamilySettingActivity familySettingActivity2 = this.mActivity;
        if (familySettingActivity2 != null && (viewModel3 = familySettingActivity2.getViewModel()) != null && (error = viewModel3.getError()) != null) {
            error.observe(this, new FamilySettingFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.family.j3
                public final Object invoke(Object obj) {
                    Unit onInitialize$lambda$8;
                    onInitialize$lambda$8 = FamilySettingFragment.onInitialize$lambda$8(FamilySettingFragment.this, (Throwable) obj);
                    return onInitialize$lambda$8;
                }
            }));
        }
        FamilySettingActivity familySettingActivity3 = this.mActivity;
        if (familySettingActivity3 != null && (viewModel2 = familySettingActivity3.getViewModel()) != null && (mSuccess = viewModel2.getMSuccess()) != null) {
            mSuccess.observe(this, new FamilySettingFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.family.k3
                public final Object invoke(Object obj) {
                    Unit onInitialize$lambda$10;
                    onInitialize$lambda$10 = FamilySettingFragment.onInitialize$lambda$10(FamilySettingFragment.this, (Pair) obj);
                    return onInitialize$lambda$10;
                }
            }));
        }
        FamilySettingActivity familySettingActivity4 = this.mActivity;
        if (familySettingActivity4 != null && (viewModel = familySettingActivity4.getViewModel()) != null && (mException = viewModel.getMException()) != null) {
            mException.observe(this, new FamilySettingFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.family.l3
                public final Object invoke(Object obj) {
                    Unit onInitialize$lambda$11;
                    onInitialize$lambda$11 = FamilySettingFragment.onInitialize$lambda$11(FamilySettingFragment.this, (Pair) obj);
                    return onInitialize$lambda$11;
                }
            }));
        }
    }

    public final void refreshData() {
        FamilySettingViewModel viewModel;
        ma.b familyInfo;
        FamilyInfo familyInfo2;
        TextView textView;
        IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding;
        int i;
        String str;
        TextView textView2;
        PolygonImageView polygonImageView;
        FamilySettingActivity familySettingActivity = this.mActivity;
        if (familySettingActivity != null && (viewModel = familySettingActivity.getViewModel()) != null && (familyInfo = viewModel.getFamilyInfo()) != null && (familyInfo2 = (FamilyInfo) familyInfo.getValue()) != null) {
            FragmentFamilySettingBinding fragmentFamilySettingBinding = (FragmentFamilySettingBinding) getBinding();
            if (fragmentFamilySettingBinding != null && (polygonImageView = fragmentFamilySettingBinding.avatar) != null) {
                ImageKtxKt.loadImage$default(polygonImageView, ImageSizeKt.image100(familyInfo2.getIcon()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232548, (c5.g) null, 49150, (Object) null);
            }
            FragmentFamilySettingBinding fragmentFamilySettingBinding2 = (FragmentFamilySettingBinding) getBinding();
            String str2 = "";
            if (fragmentFamilySettingBinding2 != null && (textView2 = fragmentFamilySettingBinding2.familyName) != null) {
                String name = familyInfo2.getName();
                if (name == null) {
                    name = "";
                }
                textView2.setText(name);
            }
            FragmentFamilySettingBinding fragmentFamilySettingBinding3 = (FragmentFamilySettingBinding) getBinding();
            if (fragmentFamilySettingBinding3 != null && (includeFamilyNamePlateBinding = fragmentFamilySettingBinding3.familyNamePlate) != null) {
                Integer grade = familyInfo2.getGrade();
                if (grade != null) {
                    i = grade.intValue();
                } else {
                    i = -1;
                }
                String nameplate = familyInfo2.getNameplate();
                if (nameplate == null) {
                    str = "";
                } else {
                    str = nameplate;
                }
                AppUtilitiesKt.familyNamePlate$default(includeFamilyNamePlateBinding, i, str, 0, 4, (Object) null);
            }
            FragmentFamilySettingBinding fragmentFamilySettingBinding4 = (FragmentFamilySettingBinding) getBinding();
            if (fragmentFamilySettingBinding4 != null && (textView = fragmentFamilySettingBinding4.declare) != null) {
                String declaration = familyInfo2.getDeclaration();
                if (declaration != null) {
                    str2 = declaration;
                }
                textView.setText(str2);
            }
        }
    }

    public final void setListener(@Nullable Function1<? super String, Unit> function1) {
        this.listener = function1;
    }

    public final void setMActivity(@Nullable FamilySettingActivity familySettingActivity) {
        this.mActivity = familySettingActivity;
    }
}
