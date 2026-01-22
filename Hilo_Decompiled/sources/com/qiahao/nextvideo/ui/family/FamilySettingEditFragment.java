package com.qiahao.nextvideo.ui.family;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import com.oudi.utils.ktx.EditTextKtxKt;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.model.common.FamilyInfo;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.FragmentFamilySettingEditBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0018\u001a\u00020\u0012H\u0014J\b\u0010\u0019\u001a\u00020\u001aH\u0017J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/qiahao/nextvideo/ui/family/FamilySettingEditFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentFamilySettingEditBinding;", "<init>", "()V", "mActivity", "Lcom/qiahao/nextvideo/ui/family/FamilySettingActivity;", "getMActivity", "()Lcom/qiahao/nextvideo/ui/family/FamilySettingActivity;", "setMActivity", "(Lcom/qiahao/nextvideo/ui/family/FamilySettingActivity;)V", "mType", "", "getMType", "()Ljava/lang/String;", "setMType", "(Ljava/lang/String;)V", "mNumber", "", "getMNumber", "()Ljava/lang/Integer;", "setMNumber", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getLayoutResId", "onInitialize", "", "onResume", "onPause", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFamilySettingEditFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FamilySettingEditFragment.kt\ncom/qiahao/nextvideo/ui/family/FamilySettingEditFragment\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,125:1\n61#2,9:126\n61#2,9:135\n*S KotlinDebug\n*F\n+ 1 FamilySettingEditFragment.kt\ncom/qiahao/nextvideo/ui/family/FamilySettingEditFragment\n*L\n40#1:126,9\n87#1:135,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FamilySettingEditFragment extends BaseBindingFragment<FragmentFamilySettingEditBinding> {

    @Nullable
    private FamilySettingActivity mActivity;

    @Nullable
    private Integer mNumber = 0;

    @Nullable
    private String mType;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onResume$lambda$3(FamilySettingEditFragment familySettingEditFragment, FamilyInfo familyInfo) {
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, familySettingEditFragment.mActivity, ResourcesKtxKt.getStringById(familySettingEditFragment, 2131954177), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        familySettingEditFragment.getParentFragmentManager().popBackStack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onResume$lambda$4(FamilySettingEditFragment familySettingEditFragment, Throwable th) {
        String str;
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            BaseActivity baseActivity = familySettingEditFragment.mActivity;
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                str = ResourcesKtxKt.getStringById(familySettingEditFragment, 2131952667);
            } else {
                str = errorMessage;
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, baseActivity, str, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    protected int getLayoutResId() {
        return R.layout.fragment_family_setting_edit;
    }

    @Nullable
    public final FamilySettingActivity getMActivity() {
        return this.mActivity;
    }

    @Nullable
    public final Integer getMNumber() {
        return this.mNumber;
    }

    @Nullable
    public final String getMType() {
        return this.mType;
    }

    @SuppressLint({"SetTextI18n"})
    public void onInitialize() {
        Toolbar toolbar;
        String str;
        Integer num;
        EditText editText;
        FamilySettingViewModel viewModel;
        ma.b familyInfo;
        FamilyInfo familyInfo2;
        String declaration;
        TextView textView;
        EditText editText2;
        FamilySettingViewModel viewModel2;
        ma.b familyInfo3;
        FamilyInfo familyInfo4;
        String nameplate;
        TextView textView2;
        final TextView textView3;
        EditText editText3;
        TextView textView4;
        EditText editText4;
        Editable text;
        EditText editText5;
        EditText editText6;
        FamilySettingViewModel viewModel3;
        ma.b familyInfo5;
        FamilyInfo familyInfo6;
        String name;
        TextView textView5;
        final AppCompatImageView appCompatImageView;
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        FragmentFamilySettingEditBinding fragmentFamilySettingEditBinding = (FragmentFamilySettingEditBinding) getBinding();
        Integer num2 = null;
        if (fragmentFamilySettingEditBinding != null) {
            toolbar = fragmentFamilySettingEditBinding.toolbar;
        } else {
            toolbar = null;
        }
        int i = 0;
        setStatusBarTopOrBottom(toolbar, false);
        BaseActivity activity = HiloUtils.INSTANCE.getActivity(getContext());
        if (activity != null && (activity instanceof FamilySettingActivity)) {
            this.mActivity = (FamilySettingActivity) activity;
        }
        FragmentFamilySettingEditBinding fragmentFamilySettingEditBinding2 = (FragmentFamilySettingEditBinding) getBinding();
        final long j = 800;
        if (fragmentFamilySettingEditBinding2 != null && (appCompatImageView = fragmentFamilySettingEditBinding2.backImageView) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilySettingEditFragment$onInitialize$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView) > j || (appCompatImageView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(appCompatImageView, currentTimeMillis);
                        AppCompatImageView appCompatImageView2 = appCompatImageView;
                        this.getParentFragmentManager().popBackStack();
                    }
                }
            });
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString("type", "type");
        } else {
            str = null;
        }
        this.mType = str;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            num = Integer.valueOf(arguments2.getInt(FamilySettingFragment.FAMILY_NUMBER, 0));
        } else {
            num = null;
        }
        this.mNumber = num;
        String str2 = this.mType;
        String str3 = "";
        if (Intrinsics.areEqual(str2, FamilySettingFragment.FAMILY_NAME)) {
            FragmentFamilySettingEditBinding fragmentFamilySettingEditBinding3 = (FragmentFamilySettingEditBinding) getBinding();
            if (fragmentFamilySettingEditBinding3 != null && (textView5 = fragmentFamilySettingEditBinding3.title) != null) {
                textView5.setText(ResourcesKtxKt.getStringById(this, 2131952680));
            }
            FragmentFamilySettingEditBinding fragmentFamilySettingEditBinding4 = (FragmentFamilySettingEditBinding) getBinding();
            if (fragmentFamilySettingEditBinding4 != null && (editText6 = fragmentFamilySettingEditBinding4.editText) != null) {
                FamilySettingActivity familySettingActivity = this.mActivity;
                if (familySettingActivity != null && (viewModel3 = familySettingActivity.getViewModel()) != null && (familyInfo5 = viewModel3.getFamilyInfo()) != null && (familyInfo6 = (FamilyInfo) familyInfo5.getValue()) != null && (name = familyInfo6.getName()) != null) {
                    str3 = name;
                }
                editText6.setText(str3);
            }
        } else if (Intrinsics.areEqual(str2, FamilySettingFragment.FAMILY_NAME_PLATE)) {
            FragmentFamilySettingEditBinding fragmentFamilySettingEditBinding5 = (FragmentFamilySettingEditBinding) getBinding();
            if (fragmentFamilySettingEditBinding5 != null && (textView2 = fragmentFamilySettingEditBinding5.title) != null) {
                textView2.setText(ResourcesKtxKt.getStringById(this, 2131952681));
            }
            FragmentFamilySettingEditBinding fragmentFamilySettingEditBinding6 = (FragmentFamilySettingEditBinding) getBinding();
            if (fragmentFamilySettingEditBinding6 != null && (editText2 = fragmentFamilySettingEditBinding6.editText) != null) {
                FamilySettingActivity familySettingActivity2 = this.mActivity;
                if (familySettingActivity2 != null && (viewModel2 = familySettingActivity2.getViewModel()) != null && (familyInfo3 = viewModel2.getFamilyInfo()) != null && (familyInfo4 = (FamilyInfo) familyInfo3.getValue()) != null && (nameplate = familyInfo4.getNameplate()) != null) {
                    str3 = nameplate;
                }
                editText2.setText(str3);
            }
        } else {
            FragmentFamilySettingEditBinding fragmentFamilySettingEditBinding7 = (FragmentFamilySettingEditBinding) getBinding();
            if (fragmentFamilySettingEditBinding7 != null && (textView = fragmentFamilySettingEditBinding7.title) != null) {
                textView.setText(ResourcesKtxKt.getStringById(this, 2131952673));
            }
            FragmentFamilySettingEditBinding fragmentFamilySettingEditBinding8 = (FragmentFamilySettingEditBinding) getBinding();
            if (fragmentFamilySettingEditBinding8 != null && (editText = fragmentFamilySettingEditBinding8.editText) != null) {
                FamilySettingActivity familySettingActivity3 = this.mActivity;
                if (familySettingActivity3 != null && (viewModel = familySettingActivity3.getViewModel()) != null && (familyInfo = viewModel.getFamilyInfo()) != null && (familyInfo2 = (FamilyInfo) familyInfo.getValue()) != null && (declaration = familyInfo2.getDeclaration()) != null) {
                    str3 = declaration;
                }
                editText.setText(str3);
            }
        }
        FragmentFamilySettingEditBinding fragmentFamilySettingEditBinding9 = (FragmentFamilySettingEditBinding) getBinding();
        if (fragmentFamilySettingEditBinding9 != null && (editText5 = fragmentFamilySettingEditBinding9.editText) != null) {
            Integer num3 = this.mNumber;
            if (num3 != null) {
                i = num3.intValue();
            }
            EditTextKtxKt.setMaxLengthFilter(editText5, i);
        }
        FragmentFamilySettingEditBinding fragmentFamilySettingEditBinding10 = (FragmentFamilySettingEditBinding) getBinding();
        if (fragmentFamilySettingEditBinding10 != null && (textView4 = fragmentFamilySettingEditBinding10.textNumber) != null) {
            FragmentFamilySettingEditBinding fragmentFamilySettingEditBinding11 = (FragmentFamilySettingEditBinding) getBinding();
            if (fragmentFamilySettingEditBinding11 != null && (editText4 = fragmentFamilySettingEditBinding11.editText) != null && (text = editText4.getText()) != null) {
                num2 = Integer.valueOf(text.length());
            }
            textView4.setText(num2 + "/" + this.mNumber);
        }
        FragmentFamilySettingEditBinding fragmentFamilySettingEditBinding12 = (FragmentFamilySettingEditBinding) getBinding();
        if (fragmentFamilySettingEditBinding12 != null && (editText3 = fragmentFamilySettingEditBinding12.editText) != null) {
            editText3.addTextChangedListener(new TextWatcher() { // from class: com.qiahao.nextvideo.ui.family.FamilySettingEditFragment$onInitialize$3
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                    TextView textView6;
                    FragmentFamilySettingEditBinding fragmentFamilySettingEditBinding13;
                    TextView textView7;
                    int i2;
                    BaseActivity mActivity = FamilySettingEditFragment.this.getMActivity();
                    if (mActivity != null && (fragmentFamilySettingEditBinding13 = (FragmentFamilySettingEditBinding) FamilySettingEditFragment.this.getBinding()) != null && (textView7 = fragmentFamilySettingEditBinding13.save) != null) {
                        if (s != null && s.length() == 0) {
                            i2 = 2131099905;
                        } else {
                            i2 = 2131099914;
                        }
                        textView7.setTextColor(androidx.core.content.a.getColor(mActivity, i2));
                    }
                    FragmentFamilySettingEditBinding fragmentFamilySettingEditBinding14 = (FragmentFamilySettingEditBinding) FamilySettingEditFragment.this.getBinding();
                    if (fragmentFamilySettingEditBinding14 != null && (textView6 = fragmentFamilySettingEditBinding14.textNumber) != null) {
                        textView6.setText(String.valueOf(s).length() + "/" + FamilySettingEditFragment.this.getMNumber());
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }
            });
        }
        FragmentFamilySettingEditBinding fragmentFamilySettingEditBinding13 = (FragmentFamilySettingEditBinding) getBinding();
        if (fragmentFamilySettingEditBinding13 != null && (textView3 = fragmentFamilySettingEditBinding13.save) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilySettingEditFragment$onInitialize$$inlined$singleClick$default$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Editable editable;
                    String mType;
                    FamilySettingActivity mActivity;
                    FamilySettingViewModel viewModel4;
                    FamilySettingActivity mActivity2;
                    FamilySettingViewModel viewModel5;
                    FamilySettingActivity mActivity3;
                    FamilySettingViewModel viewModel6;
                    EditText editText7;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView3) > j || (textView3 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(textView3, currentTimeMillis);
                        FragmentFamilySettingEditBinding fragmentFamilySettingEditBinding14 = (FragmentFamilySettingEditBinding) this.getBinding();
                        if (fragmentFamilySettingEditBinding14 != null && (editText7 = fragmentFamilySettingEditBinding14.editText) != null) {
                            editable = editText7.getText();
                        } else {
                            editable = null;
                        }
                        String valueOf = String.valueOf(editable);
                        if (!TextUtils.isEmpty(valueOf) && (mType = this.getMType()) != null) {
                            int hashCode = mType.hashCode();
                            if (hashCode != -1035558001) {
                                if (hashCode != -998549882) {
                                    if (hashCode == 2054010928 && mType.equals(FamilySettingFragment.FAMILY_NAME_PLATE) && (mActivity3 = this.getMActivity()) != null && (viewModel6 = mActivity3.getViewModel()) != null) {
                                        FamilySettingViewModel.familySetting$default(viewModel6, null, null, valueOf, null, null, 27, null);
                                        return;
                                    }
                                    return;
                                }
                                if (mType.equals(FamilySettingFragment.FAMILY_NAME) && (mActivity2 = this.getMActivity()) != null && (viewModel5 = mActivity2.getViewModel()) != null) {
                                    FamilySettingViewModel.familySetting$default(viewModel5, null, valueOf, null, null, null, 29, null);
                                    return;
                                }
                                return;
                            }
                            if (mType.equals(FamilySettingFragment.FAMILY_DECLARE) && (mActivity = this.getMActivity()) != null && (viewModel4 = mActivity.getViewModel()) != null) {
                                FamilySettingViewModel.familySetting$default(viewModel4, null, null, null, valueOf, null, 23, null);
                            }
                        }
                    }
                }
            });
        }
    }

    public void onPause() {
        FamilySettingViewModel viewModel;
        ma.b error;
        FamilySettingViewModel viewModel2;
        ma.b familyInfo;
        super/*com.qiahao.base_common.common.BaseFragment*/.onPause();
        FamilySettingActivity familySettingActivity = this.mActivity;
        if (familySettingActivity != null && (viewModel2 = familySettingActivity.getViewModel()) != null && (familyInfo = viewModel2.getFamilyInfo()) != null) {
            familyInfo.removeObservers(this);
        }
        FamilySettingActivity familySettingActivity2 = this.mActivity;
        if (familySettingActivity2 != null && (viewModel = familySettingActivity2.getViewModel()) != null && (error = viewModel.getError()) != null) {
            error.removeObservers(this);
        }
    }

    public void onResume() {
        FamilySettingViewModel viewModel;
        ma.b error;
        FamilySettingViewModel viewModel2;
        ma.b familyInfo;
        super/*com.qiahao.base_common.common.BaseFragment*/.onResume();
        FamilySettingActivity familySettingActivity = this.mActivity;
        if (familySettingActivity != null && (viewModel2 = familySettingActivity.getViewModel()) != null && (familyInfo = viewModel2.getFamilyInfo()) != null) {
            familyInfo.observe(this, new FamilySettingEditFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.family.g3
                public final Object invoke(Object obj) {
                    Unit onResume$lambda$3;
                    onResume$lambda$3 = FamilySettingEditFragment.onResume$lambda$3(FamilySettingEditFragment.this, (FamilyInfo) obj);
                    return onResume$lambda$3;
                }
            }));
        }
        FamilySettingActivity familySettingActivity2 = this.mActivity;
        if (familySettingActivity2 != null && (viewModel = familySettingActivity2.getViewModel()) != null && (error = viewModel.getError()) != null) {
            error.observe(this, new FamilySettingEditFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.family.h3
                public final Object invoke(Object obj) {
                    Unit onResume$lambda$4;
                    onResume$lambda$4 = FamilySettingEditFragment.onResume$lambda$4(FamilySettingEditFragment.this, (Throwable) obj);
                    return onResume$lambda$4;
                }
            }));
        }
    }

    public final void setMActivity(@Nullable FamilySettingActivity familySettingActivity) {
        this.mActivity = familySettingActivity;
    }

    public final void setMNumber(@Nullable Integer num) {
        this.mNumber = num;
    }

    public final void setMType(@Nullable String str) {
        this.mType = str;
    }
}
