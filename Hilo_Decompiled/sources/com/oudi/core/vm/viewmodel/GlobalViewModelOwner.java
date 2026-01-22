package com.oudi.core.vm.viewmodel;

import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.oudi.core.component.ICleared;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0001\u000bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/oudi/core/vm/viewmodel/GlobalViewModelOwner;", "Landroidx/lifecycle/ViewModelStoreOwner;", "Lcom/oudi/core/component/ICleared;", "<init>", "()V", "onCleared", "", "viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "getViewModelStore", "()Landroidx/lifecycle/ViewModelStore;", "Companion", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class GlobalViewModelOwner implements ViewModelStoreOwner, ICleared {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Lazy<ViewModelStore> viewModelStore$delegate = LazyKt.lazy(new Function0() { // from class: com.oudi.core.vm.viewmodel.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ViewModelStore viewModelStore_delegate$lambda$0;
            viewModelStore_delegate$lambda$0 = GlobalViewModelOwner.viewModelStore_delegate$lambda$0();
            return viewModelStore_delegate$lambda$0;
        }
    });

    @NotNull
    private static final Lazy<GlobalViewModelOwner> instance$delegate = LazyKt.lazy(new Function0() { // from class: com.oudi.core.vm.viewmodel.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            GlobalViewModelOwner instance_delegate$lambda$1;
            instance_delegate$lambda$1 = GlobalViewModelOwner.instance_delegate$lambda$1();
            return instance_delegate$lambda$1;
        }
    });

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/oudi/core/vm/viewmodel/GlobalViewModelOwner$Companion;", "", "<init>", "()V", "viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "getViewModelStore", "()Landroidx/lifecycle/ViewModelStore;", "viewModelStore$delegate", "Lkotlin/Lazy;", "instance", "Lcom/oudi/core/vm/viewmodel/GlobalViewModelOwner;", "getInstance", "()Lcom/oudi/core/vm/viewmodel/GlobalViewModelOwner;", "instance$delegate", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ViewModelStore getViewModelStore() {
            return (ViewModelStore) GlobalViewModelOwner.viewModelStore$delegate.getValue();
        }

        @NotNull
        public final GlobalViewModelOwner getInstance() {
            return (GlobalViewModelOwner) GlobalViewModelOwner.instance$delegate.getValue();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GlobalViewModelOwner instance_delegate$lambda$1() {
        return new GlobalViewModelOwner();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelStore viewModelStore_delegate$lambda$0() {
        return new ViewModelStore();
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    @NotNull
    public ViewModelStore getViewModelStore() {
        return INSTANCE.getViewModelStore();
    }

    @Override // com.oudi.utils.ICleared
    public void onCleared() {
        ICleared.DefaultImpls.onCleared(this);
        getViewModelStore().clear();
    }
}
