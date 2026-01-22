package com.qhqc.core.basic.uiframe.ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "VM", "Lcom/qhqc/core/basic/uiframe/viewmodel/BaseViewModel;", "isLoading", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
final class BasicVMActivity$onCreate$2 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ BasicVMActivity<VM> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasicVMActivity$onCreate$2(BasicVMActivity<VM> basicVMActivity) {
        super(1);
        this.this$0 = basicVMActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(Boolean bool, BasicVMActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(bool);
        if (bool.booleanValue()) {
            this$0.showLoading(this$0.getDefaultLoadingTip());
        } else {
            this$0.dismissLoading();
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke2(bool);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final Boolean bool) {
        final BasicVMActivity<VM> basicVMActivity = this.this$0;
        basicVMActivity.runOnUiThread(new Runnable() { // from class: com.qhqc.core.basic.uiframe.ui.a
            @Override // java.lang.Runnable
            public final void run() {
                BasicVMActivity$onCreate$2.invoke$lambda$0(bool, basicVMActivity);
            }
        });
    }
}
