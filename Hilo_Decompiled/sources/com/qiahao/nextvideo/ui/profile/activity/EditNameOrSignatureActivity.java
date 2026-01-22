package com.qiahao.nextvideo.ui.profile.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Checkable;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.eventBus.EditEvent;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.AppUtilitiesKt;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.EditUserTextDataUIModel;
import com.qiahao.nextvideo.data.model.UserSummaryInfo;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ActivityEditNicknameBinding;
import com.tencent.qcloud.tuicore.TUIConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0005*\u0001\u001a\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000b\u0010\u0004R\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/qiahao/nextvideo/ui/profile/activity/EditNameOrSignatureActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityEditNicknameBinding;", "<init>", "()V", "", "confirmToChange", "", "getLayoutResId", "()I", "onInitialize", "onDestroy", "Lnd/a;", "compositeDisposable", "Lnd/a;", "getCompositeDisposable", "()Lnd/a;", "setCompositeDisposable", "(Lnd/a;)V", "Lcom/qiahao/nextvideo/data/model/EditUserTextDataUIModel;", "editData", "Lcom/qiahao/nextvideo/data/model/EditUserTextDataUIModel;", "getEditData", "()Lcom/qiahao/nextvideo/data/model/EditUserTextDataUIModel;", "setEditData", "(Lcom/qiahao/nextvideo/data/model/EditUserTextDataUIModel;)V", "com/qiahao/nextvideo/ui/profile/activity/EditNameOrSignatureActivity$inputBoxEditTextWatcher$1", "inputBoxEditTextWatcher", "Lcom/qiahao/nextvideo/ui/profile/activity/EditNameOrSignatureActivity$inputBoxEditTextWatcher$1;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nEditNameOrSignatureActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EditNameOrSignatureActivity.kt\ncom/qiahao/nextvideo/ui/profile/activity/EditNameOrSignatureActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,117:1\n61#2,9:118\n1#3:127\n*S KotlinDebug\n*F\n+ 1 EditNameOrSignatureActivity.kt\ncom/qiahao/nextvideo/ui/profile/activity/EditNameOrSignatureActivity\n*L\n71#1:118,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class EditNameOrSignatureActivity extends HiloBaseBindingActivity<ActivityEditNicknameBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String EDIT_DATA = "edit_data";

    @Nullable
    private EditUserTextDataUIModel editData;

    @NotNull
    private nd.a compositeDisposable = new nd.a();

    @NotNull
    private final EditNameOrSignatureActivity$inputBoxEditTextWatcher$1 inputBoxEditTextWatcher = new TextWatcher() { // from class: com.qiahao.nextvideo.ui.profile.activity.EditNameOrSignatureActivity$inputBoxEditTextWatcher$1
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            ActivityEditNicknameBinding binding;
            ActivityEditNicknameBinding binding2;
            int i;
            Integer num;
            ActivityEditNicknameBinding binding3;
            ActivityEditNicknameBinding binding4;
            int i2;
            String obj;
            binding = EditNameOrSignatureActivity.this.getBinding();
            AppCompatTextView appCompatTextView = binding.contentLengthTipsTextview;
            binding2 = EditNameOrSignatureActivity.this.getBinding();
            Editable text = binding2.inputBoxEditText.getText();
            boolean z = false;
            if (text != null) {
                i = text.length();
            } else {
                i = 0;
            }
            EditUserTextDataUIModel editData = EditNameOrSignatureActivity.this.getEditData();
            if (editData != null) {
                num = Integer.valueOf(editData.getEditInputBoxTextLimit());
            } else {
                num = null;
            }
            appCompatTextView.setText(i + "/" + num);
            binding3 = EditNameOrSignatureActivity.this.getBinding();
            AppCompatTextView appCompatTextView2 = binding3.saveTextView;
            binding4 = EditNameOrSignatureActivity.this.getBinding();
            Editable text2 = binding4.inputBoxEditText.getText();
            if (text2 != null && (obj = text2.toString()) != null) {
                i2 = obj.length();
            } else {
                i2 = 0;
            }
            if (i2 > 0) {
                z = true;
            }
            appCompatTextView2.setEnabled(z);
        }
    };

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/ui/profile/activity/EditNameOrSignatureActivity$Companion;", "", "<init>", "()V", "EDIT_DATA", "", "start", "", "context", "Landroid/content/Context;", "editData", "Lcom/qiahao/nextvideo/data/model/EditUserTextDataUIModel;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@NotNull Context context, @Nullable EditUserTextDataUIModel editData) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) EditNameOrSignatureActivity.class);
            intent.putExtra(EditNameOrSignatureActivity.EDIT_DATA, editData);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void confirmToChange() {
        CharSequence charSequence;
        String str;
        Integer num;
        nd.c observeOnMainThread$default;
        Editable text = ((ActivityEditNicknameBinding) getBinding()).inputBoxEditText.getText();
        io.reactivex.rxjava3.core.i0 i0Var = null;
        if (text != null) {
            charSequence = StringsKt.trim(text);
        } else {
            charSequence = null;
        }
        final String valueOf = String.valueOf(charSequence);
        EditUserTextDataUIModel editUserTextDataUIModel = this.editData;
        if (editUserTextDataUIModel != null) {
            str = editUserTextDataUIModel.getEditInputBoxText();
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual(valueOf, str) && !TextUtils.isEmpty(valueOf)) {
            EditUserTextDataUIModel editUserTextDataUIModel2 = this.editData;
            if (editUserTextDataUIModel2 != null) {
                num = Integer.valueOf(editUserTextDataUIModel2.getEditType());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == 1) {
                i0Var = UserService.updateUserInformation$default(UserService.INSTANCE.getShared(), null, valueOf, null, null, null, null, 61, null);
            } else if (num != null && num.intValue() == 2) {
                i0Var = UserService.updateUserInformation$default(UserService.INSTANCE.getShared(), null, null, null, valueOf, null, null, 55, null);
            }
            io.reactivex.rxjava3.core.i0 i0Var2 = i0Var;
            if (i0Var2 != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(i0Var2, new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.p
                public final Object invoke(Object obj) {
                    Unit confirmToChange$lambda$3;
                    confirmToChange$lambda$3 = EditNameOrSignatureActivity.confirmToChange$lambda$3(EditNameOrSignatureActivity.this, valueOf, (ApiResponse) obj);
                    return confirmToChange$lambda$3;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.q
                public final Object invoke(Object obj) {
                    Unit confirmToChange$lambda$4;
                    confirmToChange$lambda$4 = EditNameOrSignatureActivity.confirmToChange$lambda$4(EditNameOrSignatureActivity.this, (Throwable) obj);
                    return confirmToChange$lambda$4;
                }
            }, (Function0) null, false, 12, (Object) null)) != null) {
                RxUtilsKt.addTo(observeOnMainThread$default, this.compositeDisposable);
                return;
            }
            return;
        }
        HiloToasty.Companion companion = HiloToasty.Companion;
        String string = getString(2131952608);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Toast normal$default = HiloToasty.Companion.normal$default(companion, this, string, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit confirmToChange$lambda$3(EditNameOrSignatureActivity editNameOrSignatureActivity, String str, ApiResponse apiResponse) {
        String str2;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        UserSummaryInfo userSummaryInfo = (UserSummaryInfo) apiResponse.getData();
        if (userSummaryInfo != null) {
            UserStore.INSTANCE.getShared().refreshUserInfo(userSummaryInfo);
        }
        EditUserTextDataUIModel editUserTextDataUIModel = editNameOrSignatureActivity.editData;
        if (editUserTextDataUIModel != null) {
            editUserTextDataUIModel.setEditInputBoxText(str);
        }
        cf.c c = cf.c.c();
        EditUserTextDataUIModel editUserTextDataUIModel2 = editNameOrSignatureActivity.editData;
        if (editUserTextDataUIModel2 != null && editUserTextDataUIModel2.getEditType() == 1) {
            str2 = "name";
        } else {
            str2 = TUIConstants.TUICalling.PARAM_NAME_AUDIO_SIGNATURE;
        }
        c.l(new EditEvent(str2, editNameOrSignatureActivity.editData));
        editNameOrSignatureActivity.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit confirmToChange$lambda$4(EditNameOrSignatureActivity editNameOrSignatureActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = ResourcesKtxKt.getStringById(editNameOrSignatureActivity, 2131952667);
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, editNameOrSignatureActivity, localizedMessage, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    @NotNull
    public final nd.a getCompositeDisposable() {
        return this.compositeDisposable;
    }

    @Nullable
    public final EditUserTextDataUIModel getEditData() {
        return this.editData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_edit_nickname;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseBindingActivity, com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onDestroy() {
        super.onDestroy();
        AppCompatEditText appCompatEditText = getBinding().inputBoxEditText;
        Intrinsics.checkNotNullExpressionValue(appCompatEditText, "inputBoxEditText");
        AppUtilitiesKt.dismissKeyboard(appCompatEditText);
        this.compositeDisposable.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    @SuppressLint({"SetTextI18n"})
    public void onInitialize() {
        String str;
        String str2;
        CharSequence charSequence;
        int i;
        String str3;
        Integer num;
        String editInputBoxText;
        super.onInitialize();
        EditUserTextDataUIModel editUserTextDataUIModel = (EditUserTextDataUIModel) getIntent().getParcelableExtra(EDIT_DATA);
        this.editData = editUserTextDataUIModel;
        if (editUserTextDataUIModel == null) {
            finish();
        }
        Toolbar toolbar = ((ActivityEditNicknameBinding) getBinding()).toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        setStatusBarTopOrBottom(toolbar, false);
        final AppCompatImageView appCompatImageView = ((ActivityEditNicknameBinding) getBinding()).backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.activity.EditNameOrSignatureActivity$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView) > j || (appCompatImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView, currentTimeMillis);
                    AppCompatImageView appCompatImageView2 = appCompatImageView;
                    this.finish();
                }
            }
        });
        AppCompatTextView appCompatTextView = ((ActivityEditNicknameBinding) getBinding()).titleTextView;
        EditUserTextDataUIModel editUserTextDataUIModel2 = this.editData;
        Integer num2 = null;
        if (editUserTextDataUIModel2 != null) {
            str = editUserTextDataUIModel2.getTitle();
        } else {
            str = null;
        }
        appCompatTextView.setText(str);
        AppCompatTextView appCompatTextView2 = ((ActivityEditNicknameBinding) getBinding()).saveTextView;
        EditUserTextDataUIModel editUserTextDataUIModel3 = this.editData;
        if (editUserTextDataUIModel3 != null) {
            str2 = editUserTextDataUIModel3.getEditInputBoxText();
        } else {
            str2 = null;
        }
        Editable text = ((ActivityEditNicknameBinding) getBinding()).inputBoxEditText.getText();
        if (text != null) {
            charSequence = StringsKt.trim(text);
        } else {
            charSequence = null;
        }
        appCompatTextView2.setEnabled(Intrinsics.areEqual(str2, String.valueOf(charSequence)));
        AppCompatEditText appCompatEditText = ((ActivityEditNicknameBinding) getBinding()).inputBoxEditText;
        EditUserTextDataUIModel editUserTextDataUIModel4 = this.editData;
        if (editUserTextDataUIModel4 != null) {
            i = editUserTextDataUIModel4.getEditInputBoxTextLimit();
        } else {
            i = 0;
        }
        appCompatEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        AppCompatEditText appCompatEditText2 = ((ActivityEditNicknameBinding) getBinding()).inputBoxEditText;
        EditUserTextDataUIModel editUserTextDataUIModel5 = this.editData;
        if (editUserTextDataUIModel5 != null) {
            str3 = editUserTextDataUIModel5.getEditInputBoxText();
        } else {
            str3 = null;
        }
        appCompatEditText2.setText(str3);
        ((ActivityEditNicknameBinding) getBinding()).inputBoxEditText.addTextChangedListener(this.inputBoxEditTextWatcher);
        AppCompatTextView appCompatTextView3 = ((ActivityEditNicknameBinding) getBinding()).contentLengthTipsTextview;
        EditUserTextDataUIModel editUserTextDataUIModel6 = this.editData;
        if (editUserTextDataUIModel6 != null && (editInputBoxText = editUserTextDataUIModel6.getEditInputBoxText()) != null) {
            num = Integer.valueOf(editInputBoxText.length());
        } else {
            num = null;
        }
        EditUserTextDataUIModel editUserTextDataUIModel7 = this.editData;
        if (editUserTextDataUIModel7 != null) {
            num2 = Integer.valueOf(editUserTextDataUIModel7.getEditInputBoxTextLimit());
        }
        appCompatTextView3.setText(num + "/" + num2);
        ((ActivityEditNicknameBinding) getBinding()).saveTextView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.activity.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditNameOrSignatureActivity.this.confirmToChange();
            }
        });
        AppCompatEditText appCompatEditText3 = ((ActivityEditNicknameBinding) getBinding()).inputBoxEditText;
        Intrinsics.checkNotNullExpressionValue(appCompatEditText3, "inputBoxEditText");
        AppUtilitiesKt.showKeyboard(appCompatEditText3);
    }

    public final void setCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.compositeDisposable = aVar;
    }

    public final void setEditData(@Nullable EditUserTextDataUIModel editUserTextDataUIModel) {
        this.editData = editUserTextDataUIModel;
    }
}
