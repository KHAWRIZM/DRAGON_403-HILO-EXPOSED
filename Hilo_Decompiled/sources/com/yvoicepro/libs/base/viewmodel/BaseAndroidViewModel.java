package com.yvoicepro.libs.base.viewmodel;

import android.annotation.SuppressLint;
import android.app.Application;
import com.qhqc.core.basic.uiframe.viewmodel.BaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/yvoicepro/libs/base/viewmodel/BaseAndroidViewModel;", "Lcom/qhqc/core/basic/uiframe/viewmodel/BaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "mApplication", "getMApplication", "()Landroid/app/Application;", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class BaseAndroidViewModel extends BaseViewModel {

    @SuppressLint({"StaticFieldLeak"})
    @NotNull
    private final Application mApplication;

    public BaseAndroidViewModel(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.mApplication = application;
    }

    @NotNull
    public final Application getMApplication() {
        return this.mApplication;
    }
}
