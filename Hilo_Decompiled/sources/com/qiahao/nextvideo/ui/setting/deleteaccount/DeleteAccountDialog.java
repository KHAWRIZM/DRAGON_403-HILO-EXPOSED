package com.qiahao.nextvideo.ui.setting.deleteaccount;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.DateTimeUtilityKt;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.Login;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.DialogDeleteAccountBinding;
import io.reactivex.rxjava3.core.i0;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0014R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\n\u001a\u0004\u0018\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0018R\u0017\u0010\u001a\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR*\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/qiahao/nextvideo/ui/setting/deleteaccount/DeleteAccountDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogDeleteAccountBinding;", "Landroid/content/Context;", "context", "", "mLogoutFinishTime", "", "mUserCode", "Lcom/qiahao/nextvideo/data/model/Login;", "mLogin", "<init>", "(Landroid/content/Context;JLjava/lang/String;Lcom/qiahao/nextvideo/data/model/Login;)V", "", "getLayoutResId", "()I", "", "onInitialize", "()V", "dismiss", "J", "Ljava/lang/String;", "getMUserCode", "()Ljava/lang/String;", "Lcom/qiahao/nextvideo/data/model/Login;", "Lnd/a;", "compositeDisposable", "Lnd/a;", "getCompositeDisposable", "()Lnd/a;", "Lkotlin/Function0;", "listener", "Lkotlin/jvm/functions/Function0;", "getListener", "()Lkotlin/jvm/functions/Function0;", "setListener", "(Lkotlin/jvm/functions/Function0;)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDeleteAccountDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeleteAccountDialog.kt\ncom/qiahao/nextvideo/ui/setting/deleteaccount/DeleteAccountDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,73:1\n61#2,9:74\n61#2,9:83\n*S KotlinDebug\n*F\n+ 1 DeleteAccountDialog.kt\ncom/qiahao/nextvideo/ui/setting/deleteaccount/DeleteAccountDialog\n*L\n41#1:74,9\n62#1:83,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class DeleteAccountDialog extends BaseBindingDialog<DialogDeleteAccountBinding> {

    @NotNull
    private final nd.a compositeDisposable;

    @Nullable
    private Function0<Unit> listener;

    @Nullable
    private final Login mLogin;
    private final long mLogoutFinishTime;

    @Nullable
    private final String mUserCode;

    public /* synthetic */ DeleteAccountDialog(Context context, long j, String str, Login login, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? 0L : j, str, (i & 8) != 0 ? null : login);
    }

    public void dismiss() {
        super.dismiss();
        this.compositeDisposable.d();
    }

    @NotNull
    public final nd.a getCompositeDisposable() {
        return this.compositeDisposable;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_delete_account;
    }

    @Nullable
    public final Function0<Unit> getListener() {
        return this.listener;
    }

    @Nullable
    public final String getMUserCode() {
        return this.mUserCode;
    }

    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        AppCompatTextView appCompatTextView = ((DialogDeleteAccountBinding) getBinding()).descriptionText;
        String format = String.format(ResourcesKtxKt.getStringById(this, 2131952544), Arrays.copyOf(new Object[]{this.mUserCode, String.valueOf(DateTimeUtilityKt.getDateFormatWithLocale(this.mLogoutFinishTime * 1000, "yyyy-MM-dd HH:mm"))}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        appCompatTextView.setText(format);
        final AppCompatButton appCompatButton = ((DialogDeleteAccountBinding) getBinding()).giveUpDelete;
        final long j = 800;
        appCompatButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.deleteaccount.DeleteAccountDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Login login;
                Login login2;
                Login login3;
                Login login4;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatButton) > j || (appCompatButton instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatButton, currentTimeMillis);
                    AppCompatButton appCompatButton2 = appCompatButton;
                    login = this.mLogin;
                    if (login != null) {
                        UserService shared = UserService.Companion.getShared();
                        login2 = this.mLogin;
                        String userId = login2.getUserId();
                        String str = "";
                        if (userId == null) {
                            userId = "";
                        }
                        login3 = this.mLogin;
                        int type = login3.getType();
                        login4 = this.mLogin;
                        String token = login4.getToken();
                        if (token != null) {
                            str = token;
                        }
                        i0<ApiResponse<Object>> cancelDeleteAccount = shared.cancelDeleteAccount(userId, type, str);
                        final DeleteAccountDialog deleteAccountDialog = this;
                        Function1<ApiResponse<Object>, Unit> function1 = new Function1<ApiResponse<Object>, Unit>() { // from class: com.qiahao.nextvideo.ui.setting.deleteaccount.DeleteAccountDialog$onInitialize$1$1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ApiResponse<Object>) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ApiResponse<Object> apiResponse) {
                                Intrinsics.checkNotNullParameter(apiResponse, "it");
                                if (apiResponse.isOk()) {
                                    Function0<Unit> listener = DeleteAccountDialog.this.getListener();
                                    if (listener != null) {
                                        listener.invoke();
                                    }
                                    DeleteAccountDialog.this.dismiss();
                                }
                            }
                        };
                        final DeleteAccountDialog deleteAccountDialog2 = this;
                        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(cancelDeleteAccount, function1, new Function1<Throwable, Unit>() { // from class: com.qiahao.nextvideo.ui.setting.deleteaccount.DeleteAccountDialog$onInitialize$1$2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Throwable) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Throwable th) {
                                Intrinsics.checkNotNullParameter(th, "it");
                                HiloToasty.Companion companion = HiloToasty.Companion;
                                Context context = DeleteAccountDialog.this.getContext();
                                String localizedMessage = th.getLocalizedMessage();
                                if (localizedMessage == null) {
                                    localizedMessage = ResourcesKtxKt.getStringById(DeleteAccountDialog.this, 2131952667);
                                }
                                Toast normal$default = HiloToasty.Companion.normal$default(companion, context, localizedMessage, false, 4, (Object) null);
                                if (normal$default != null) {
                                    normal$default.show();
                                }
                            }
                        }, (Function0) null, false, 12, (Object) null), this.getCompositeDisposable());
                        return;
                    }
                    Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, this.getContext(), ResourcesKtxKt.getStringById(this, 2131952667), false, 4, (Object) null);
                    if (normal$default != null) {
                        normal$default.show();
                    }
                }
            }
        });
        final AppCompatButton appCompatButton2 = ((DialogDeleteAccountBinding) getBinding()).switchAccounts;
        appCompatButton2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.deleteaccount.DeleteAccountDialog$onInitialize$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatButton2) > j || (appCompatButton2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatButton2, currentTimeMillis);
                    AppCompatButton appCompatButton3 = appCompatButton2;
                    this.dismiss();
                }
            }
        });
    }

    public final void setListener(@Nullable Function0<Unit> function0) {
        this.listener = function0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeleteAccountDialog(@NotNull Context context, long j, @Nullable String str, @Nullable Login login) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mLogoutFinishTime = j;
        this.mUserCode = str;
        this.mLogin = login;
        this.compositeDisposable = new nd.a();
    }
}
