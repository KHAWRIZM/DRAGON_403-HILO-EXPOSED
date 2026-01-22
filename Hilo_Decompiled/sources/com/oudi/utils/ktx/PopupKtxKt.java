package com.oudi.utils.ktx;

import android.app.Application;
import android.view.View;
import android.widget.PopupWindow;
import com.oudi.utils.AppUtils;
import com.oudi.utils.UiUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u001ag\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"showAsAutoLocation", "", "Landroid/widget/PopupWindow;", "root", "Landroid/view/View;", "anchorX", "", "anchorY", "popupWindowW", "popupWindowH", "leftTopAnim", "leftBottomAnim", "rightTopAnim", "rightBottomAnim", "(Landroid/widget/PopupWindow;Landroid/view/View;IIIILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "lib_utils_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PopupKtxKt {
    public static final void showAsAutoLocation(PopupWindow popupWindow, View root, int i10, int i11, int i12, int i13, Integer num, Integer num2, Integer num3, Integer num4) {
        int i14;
        int i15;
        Intrinsics.checkNotNullParameter(popupWindow, "<this>");
        Intrinsics.checkNotNullParameter(root, "root");
        UiUtils uiUtils = UiUtils.INSTANCE;
        Application app = AppUtils.getApp();
        Intrinsics.checkNotNullExpressionValue(app, "getApp(...)");
        int screenWidth = uiUtils.getScreenWidth(app);
        Application app2 = AppUtils.getApp();
        Intrinsics.checkNotNullExpressionValue(app2, "getApp(...)");
        int screenHeight = uiUtils.getScreenHeight(app2);
        if (i12 + i10 > screenWidth) {
            i14 = i10 - i12;
        } else {
            i14 = i10;
        }
        if (i13 + i11 > screenHeight) {
            i15 = i11 - i13;
        } else {
            i15 = i11;
        }
        if (i14 == i10 && i15 != i11) {
            num = num3;
        } else if (i14 != i10 && i15 == i11) {
            num = num2;
        } else if (i14 == i10 || i15 == i11) {
            num = num4;
        }
        if (num != null) {
            popupWindow.setAnimationStyle(num.intValue());
        }
        popupWindow.showAtLocation(root, 0, i14, i15);
    }
}
