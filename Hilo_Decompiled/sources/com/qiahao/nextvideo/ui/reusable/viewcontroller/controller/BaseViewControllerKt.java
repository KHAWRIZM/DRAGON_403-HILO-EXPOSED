package com.qiahao.nextvideo.ui.reusable.viewcontroller.controller;

import android.content.Context;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a1\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u00042\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u0006\"\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"getString", "", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "stringRes", "", "args", "", "", "(Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;I[Ljava/lang/Object;)Ljava/lang/String;", "app_googleRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class BaseViewControllerKt {
    @NotNull
    public static final String getString(@NotNull BaseViewController baseViewController, int i, @NotNull Object... objArr) {
        String string;
        Intrinsics.checkNotNullParameter(baseViewController, "<this>");
        Intrinsics.checkNotNullParameter(objArr, "args");
        Context context = baseViewController.getContext();
        if (context == null || (string = context.getString(i, Arrays.copyOf(objArr, objArr.length))) == null) {
            return "";
        }
        return string;
    }
}
