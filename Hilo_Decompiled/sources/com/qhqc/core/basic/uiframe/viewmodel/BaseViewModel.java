package com.qhqc.core.basic.uiframe.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.qhqc.core.basic.net.exception.ApiErrorException;
import com.qhqc.core.basic.router.provider.BasicModuleApp;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import ma.b;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000b\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0013\u0010\u0003R\u001a\u0010\u0015\u001a\u00020\u00148\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u001a\u001a\u0004\b\u0011\u0010\u001b\"\u0004\b\u001c\u0010\u001dR6\u0010 \u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001e0\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\u001b\"\u0004\b\"\u0010\u001dR6\u0010#\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001e0\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001a\u001a\u0004\b$\u0010\u001b\"\u0004\b%\u0010\u001dR!\u0010)\u001a\b\u0012\u0004\u0012\u00020\t0\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u001b¨\u0006*"}, d2 = {"Lcom/qhqc/core/basic/uiframe/viewmodel/BaseViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "Lcom/qhqc/core/basic/net/exception/ApiErrorException;", "throwable", "", "onError", "(Lcom/qhqc/core/basic/net/exception/ApiErrorException;)V", "", "tips", "showToast", "(Ljava/lang/String;)V", "", "tipsRes", "(I)V", "", "isLoading", "(Z)V", "onCleared", "Lkotlinx/coroutines/CoroutineScope;", "handleScope", "Lkotlinx/coroutines/CoroutineScope;", "getHandleScope", "()Lkotlinx/coroutines/CoroutineScope;", "Lma/b;", "Lma/b;", "()Lma/b;", "setLoading", "(Lma/b;)V", "Lkotlin/Pair;", "", "onSuccessLD", "getOnSuccessLD", "setOnSuccessLD", "onErrorLD", "getOnErrorLD", "setOnErrorLD", "onErrorAction$delegate", "Lkotlin/Lazy;", "getOnErrorAction", "onErrorAction", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class BaseViewModel extends ViewModel {

    @NotNull
    private final CoroutineScope handleScope = CoroutineScopeKt.plus(ViewModelKt.getViewModelScope(this), new CoroutineExceptionHandlerImpl());

    @NotNull
    private b isLoading = new b();

    @NotNull
    private b onSuccessLD = new b();

    @NotNull
    private b onErrorLD = new b();

    /* renamed from: onErrorAction$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy onErrorAction = LazyKt.lazy(new Function0<b>() { // from class: com.qhqc.core.basic.uiframe.viewmodel.BaseViewModel$onErrorAction$2
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final b invoke() {
            return new b();
        }
    });

    @NotNull
    protected final CoroutineScope getHandleScope() {
        return this.handleScope;
    }

    @NotNull
    public final b getOnErrorAction() {
        return (b) this.onErrorAction.getValue();
    }

    @NotNull
    public final b getOnErrorLD() {
        return this.onErrorLD;
    }

    @NotNull
    public final b getOnSuccessLD() {
        return this.onSuccessLD;
    }

    @NotNull
    /* renamed from: isLoading, reason: from getter */
    public final b getIsLoading() {
        return this.isLoading;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
    }

    public final void onError(@NotNull ApiErrorException throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        getOnErrorAction().postValue(throwable.getMsg());
    }

    public final void setLoading(@NotNull b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.isLoading = bVar;
    }

    public final void setOnErrorLD(@NotNull b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.onErrorLD = bVar;
    }

    public final void setOnSuccessLD(@NotNull b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.onSuccessLD = bVar;
    }

    public final void showToast(@NotNull String tips) {
        Intrinsics.checkNotNullParameter(tips, "tips");
        getOnErrorAction().postValue(tips);
    }

    public final void isLoading(boolean isLoading) {
        this.isLoading.postValue(Boolean.valueOf(isLoading));
    }

    public final void showToast(int tipsRes) {
        if (tipsRes != 0) {
            String string = BasicModuleApp.application().getString(tipsRes);
            Intrinsics.checkNotNull(string);
            showToast(string);
        }
    }
}
