package com.oudi.core.component;

import android.util.Log;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.facebook.internal.NativeProtocol;
import com.facebook.login.LoginLogger;
import com.oudi.core.component.IComponent;
import com.oudi.core.component.IVmComponent;
import com.oudi.core.component.bridge.ComponentAction;
import com.oudi.core.component.bridge.ComponentActionBridge;
import com.oudi.core.component.bridge.ComponentActionHandler;
import com.oudi.core.model.ResultLiveData;
import com.oudi.core.vm.viewmodel.SuperViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00020\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0016Jb\u0010\u000f\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\u00112#\b\u0002\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u0011H\u0010¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060\u00132#\b\u0002\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00060\u0013H\u0016¨\u0006\u001a"}, d2 = {"Lcom/oudi/core/component/IVmComponent;", "Lcom/oudi/core/component/IComponent;", "Lcom/oudi/core/component/bridge/ComponentActionHandler;", "getLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "onInitialize", "", "isAutoInitObserve", "", "addViewModel", "viewModel", "Lcom/oudi/core/vm/viewmodel/SuperViewModel;", "onAction", NativeProtocol.WEB_DIALOG_ACTION, "Lcom/oudi/core/component/bridge/ComponentAction;", "observe", "T", "Lcom/oudi/core/model/ResultLiveData;", "success", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", LoginLogger.EVENT_EXTRAS_FAILURE, "", "throwable", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface IVmComponent extends IComponent, ComponentActionHandler {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class DefaultImpls {
        public static void addViewModel(@NotNull final IVmComponent iVmComponent, @Nullable SuperViewModel superViewModel) {
            Unit unit;
            ComponentActionBridge componentActionBridge;
            LifecycleOwner lifecycleOwner = iVmComponent.getLifecycleOwner();
            if (lifecycleOwner != null) {
                if (superViewModel != null && (componentActionBridge = superViewModel.getComponentActionBridge()) != null) {
                    componentActionBridge.observe(lifecycleOwner, new Observer() { // from class: com.oudi.core.component.a
                        @Override // androidx.lifecycle.Observer
                        public final void onChanged(Object obj) {
                            IVmComponent.DefaultImpls.addViewModel$lambda$1$lambda$0(IVmComponent.this, (ComponentAction) obj);
                        }
                    });
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit != null) {
                    return;
                }
            }
            Log.e("IVmComponent", "warning/警告: lifecycleOwner is NULL");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void addViewModel$lambda$1$lambda$0(IVmComponent iVmComponent, ComponentAction it) {
            Intrinsics.checkNotNullParameter(it, "it");
            iVmComponent.onAction(it);
        }

        @Nullable
        public static Integer getThemeRes(@NotNull IVmComponent iVmComponent) {
            return IComponent.DefaultImpls.getThemeRes(iVmComponent);
        }

        public static boolean isAutoInitObserve(@NotNull IVmComponent iVmComponent) {
            return true;
        }

        public static <T> void observe(@NotNull IVmComponent iVmComponent, @NotNull ResultLiveData<T> receiver, @NotNull Function1<? super T, Unit> success, @NotNull Function1<? super Throwable, Unit> failure) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            Intrinsics.checkNotNullParameter(success, "success");
            Intrinsics.checkNotNullParameter(failure, "failure");
            LifecycleOwner lifecycleOwner = iVmComponent.getLifecycleOwner();
            if (lifecycleOwner == null || receiver.observe(lifecycleOwner, success, failure) == null) {
                Log.e("IVmComponent", "warning/警告: lifecycleOwner is NULL");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void observe$default(IVmComponent iVmComponent, ResultLiveData resultLiveData, Function1 function1, Function1 function12, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 1) != 0) {
                    function1 = new Function1() { // from class: com.oudi.core.component.b
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit observe$lambda$3;
                            observe$lambda$3 = IVmComponent.DefaultImpls.observe$lambda$3(obj2);
                            return observe$lambda$3;
                        }
                    };
                }
                if ((i10 & 2) != 0) {
                    function12 = new Function1() { // from class: com.oudi.core.component.c
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit observe$lambda$4;
                            observe$lambda$4 = IVmComponent.DefaultImpls.observe$lambda$4((Throwable) obj2);
                            return observe$lambda$4;
                        }
                    };
                }
                iVmComponent.observe(resultLiveData, function1, function12);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: observe");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Unit observe$lambda$3(Object obj) {
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Unit observe$lambda$4(Throwable it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Unit.INSTANCE;
        }

        public static void onAction(@NotNull IVmComponent iVmComponent, @NotNull ComponentAction action) {
            Intrinsics.checkNotNullParameter(action, "action");
        }

        public static void onInitialize(@NotNull IVmComponent iVmComponent) {
            IComponent.DefaultImpls.onInitialize(iVmComponent);
        }

        public static void onInitializeAfter(@NotNull IVmComponent iVmComponent) {
            IComponent.DefaultImpls.onInitializeAfter(iVmComponent);
        }

        public static void onInitializeBefore(@NotNull IVmComponent iVmComponent) {
            IComponent.DefaultImpls.onInitializeBefore(iVmComponent);
        }
    }

    void addViewModel(@Nullable SuperViewModel viewModel);

    @Nullable
    LifecycleOwner getLifecycleOwner();

    boolean isAutoInitObserve();

    <T> void observe(@NotNull ResultLiveData<T> resultLiveData, @NotNull Function1<? super T, Unit> function1, @NotNull Function1<? super Throwable, Unit> function12);

    @Override // com.oudi.core.component.bridge.ComponentActionHandler
    void onAction(@NotNull ComponentAction action);

    @Override // com.oudi.core.component.IComponent
    void onInitialize();
}
