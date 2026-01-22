package com.qiahao.nextvideo.room.dialog;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.qiahao.nextvideo.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH&¨\u0006\u000e"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/BaseBottomSheetDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "context", "Landroid/content/Context;", "theme", "", "<init>", "(Landroid/content/Context;I)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initStyle", "initDataBinding", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class BaseBottomSheetDialog extends BottomSheetDialog {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseBottomSheetDialog(@NotNull Context context, int i) {
        super(context, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public abstract void initDataBinding();

    /* JADX WARN: Multi-variable type inference failed */
    public void initStyle() {
        setCanceledOnTouchOutside(true);
        FrameLayout frameLayout = (FrameLayout) findViewById(2131362643);
        if (frameLayout != null) {
            BottomSheetBehavior.s0(frameLayout).c1(false);
            BottomSheetBehavior.s0(frameLayout).Y0(-1);
            frameLayout.setBackgroundDrawable(new ColorDrawable(0));
        }
        Object systemService = getContext().getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(new DisplayMetrics());
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        attributes.horizontalMargin = 0.0f;
        Window window2 = getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setAttributes(attributes);
        Window window3 = getWindow();
        Intrinsics.checkNotNull(window3);
        window3.setDimAmount(0.0f);
        Window window4 = getWindow();
        Intrinsics.checkNotNull(window4);
        window4.getDecorView().setPadding(0, 0, 0, 0);
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setDismissWithAnimation(true);
        initDataBinding();
        initStyle();
    }

    public /* synthetic */ BaseBottomSheetDialog(Context context, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? R.style.HiloBottomSheetDialog : i);
    }
}
