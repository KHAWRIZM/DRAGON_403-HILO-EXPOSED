package com.qiahao.nextvideo.ui.home.discover;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.interfaceing.BaseDialogInterface;
import com.qiahao.base_common.model.common.Country;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.CheckUserInfo;
import com.qiahao.nextvideo.data.model.EditCountryData;
import com.qiahao.nextvideo.databinding.DialogChangeCountryBinding;
import java.io.File;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u001b\u001a\u00020\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020\u001eH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006!"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/discover/ChangeCountryDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogChangeCountryBinding;", "context", "Landroid/content/Context;", "editCountryData", "Lcom/qiahao/nextvideo/data/model/EditCountryData;", "checkUserInfo", "Lcom/qiahao/nextvideo/data/model/CheckUserInfo;", "<init>", "(Landroid/content/Context;Lcom/qiahao/nextvideo/data/model/EditCountryData;Lcom/qiahao/nextvideo/data/model/CheckUserInfo;)V", "getCheckUserInfo", "()Lcom/qiahao/nextvideo/data/model/CheckUserInfo;", "setCheckUserInfo", "(Lcom/qiahao/nextvideo/data/model/CheckUserInfo;)V", "listener", "Lcom/qiahao/base_common/interfaceing/BaseDialogInterface;", "getListener", "()Lcom/qiahao/base_common/interfaceing/BaseDialogInterface;", "setListener", "(Lcom/qiahao/base_common/interfaceing/BaseDialogInterface;)V", "timerTask", "Landroid/os/CountDownTimer;", "getTimerTask", "()Landroid/os/CountDownTimer;", "setTimerTask", "(Landroid/os/CountDownTimer;)V", "getLayoutResId", "", "onInitialize", "", "initView", "dismiss", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ChangeCountryDialog extends BaseBindingDialog<DialogChangeCountryBinding> {

    @Nullable
    private CheckUserInfo checkUserInfo;

    @Nullable
    private EditCountryData editCountryData;

    @Nullable
    private BaseDialogInterface listener;

    @Nullable
    private CountDownTimer timerTask;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChangeCountryDialog(@NotNull Context context, @Nullable EditCountryData editCountryData, @Nullable CheckUserInfo checkUserInfo) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.editCountryData = editCountryData;
        this.checkUserInfo = checkUserInfo;
    }

    public static final /* synthetic */ DialogChangeCountryBinding access$getBinding(ChangeCountryDialog changeCountryDialog) {
        return (DialogChangeCountryBinding) changeCountryDialog.getBinding();
    }

    private final void initView() {
        long j;
        String str;
        int i;
        String str2;
        String str3;
        String str4;
        Country countryInfo;
        Country countryInfo2;
        Integer editCountryDays;
        long j2;
        int i2;
        Long canEditCountryDiffSeconds;
        Integer editCountryDays2;
        Long canEditCountryDiffSeconds2;
        Long canEditCountryDiffSeconds3;
        CheckUserInfo checkUserInfo = this.checkUserInfo;
        long j3 = 0;
        if (checkUserInfo != null && (canEditCountryDiffSeconds3 = checkUserInfo.getCanEditCountryDiffSeconds()) != null) {
            j = canEditCountryDiffSeconds3.longValue();
        } else {
            j = 0;
        }
        if (j > 0) {
            ((DialogChangeCountryBinding) getBinding()).changeGroup.setVisibility(8);
            ((DialogChangeCountryBinding) getBinding()).time.setVisibility(0);
            TextView textView = ((DialogChangeCountryBinding) getBinding()).time;
            HiloUtils hiloUtils = HiloUtils.INSTANCE;
            CheckUserInfo checkUserInfo2 = this.checkUserInfo;
            if (checkUserInfo2 != null && (canEditCountryDiffSeconds2 = checkUserInfo2.getCanEditCountryDiffSeconds()) != null) {
                j2 = canEditCountryDiffSeconds2.longValue();
            } else {
                j2 = 0;
            }
            long j4 = 1000;
            textView.setText(hiloUtils.formatRemainingTime(j2 * j4));
            TextView textView2 = ((DialogChangeCountryBinding) getBinding()).content;
            String stringById = ResourcesKtxKt.getStringById(this, 2131952194);
            CheckUserInfo checkUserInfo3 = this.checkUserInfo;
            if (checkUserInfo3 != null && (editCountryDays2 = checkUserInfo3.getEditCountryDays()) != null) {
                i2 = editCountryDays2.intValue();
            } else {
                i2 = 0;
            }
            String format = String.format(stringById, Arrays.copyOf(new Object[]{Integer.valueOf(i2)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            textView2.setText(format);
            ((DialogChangeCountryBinding) getBinding()).confirmButton.setText(ResourcesKtxKt.getStringById(this, 2131953100));
            ((DialogChangeCountryBinding) getBinding()).cancelButton.setVisibility(8);
            CheckUserInfo checkUserInfo4 = this.checkUserInfo;
            if (checkUserInfo4 != null && (canEditCountryDiffSeconds = checkUserInfo4.getCanEditCountryDiffSeconds()) != null) {
                j3 = canEditCountryDiffSeconds.longValue();
            }
            final long j5 = j3 * j4;
            CountDownTimer countDownTimer = new CountDownTimer(j5) { // from class: com.qiahao.nextvideo.ui.home.discover.ChangeCountryDialog$initView$1
                @Override // android.os.CountDownTimer
                public void onFinish() {
                }

                @Override // android.os.CountDownTimer
                public void onTick(long millisUntilFinished) {
                    ChangeCountryDialog.access$getBinding(ChangeCountryDialog.this).time.setText(HiloUtils.INSTANCE.formatRemainingTime(millisUntilFinished));
                }
            };
            this.timerTask = countDownTimer;
            countDownTimer.start();
        } else {
            ((DialogChangeCountryBinding) getBinding()).changeGroup.setVisibility(0);
            ((DialogChangeCountryBinding) getBinding()).time.setVisibility(8);
            TextView textView3 = ((DialogChangeCountryBinding) getBinding()).content;
            String stringById2 = ResourcesKtxKt.getStringById(this, 2131954381);
            EditCountryData editCountryData = this.editCountryData;
            if (editCountryData == null || (str = editCountryData.getName()) == null) {
                str = "";
            }
            CheckUserInfo checkUserInfo5 = this.checkUserInfo;
            if (checkUserInfo5 != null && (editCountryDays = checkUserInfo5.getEditCountryDays()) != null) {
                i = editCountryDays.intValue();
            } else {
                i = 0;
            }
            String format2 = String.format(stringById2, Arrays.copyOf(new Object[]{str, Integer.valueOf(i)}, 2));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            textView3.setText(format2);
            ((DialogChangeCountryBinding) getBinding()).confirmButton.setText(ResourcesKtxKt.getStringById(this, 2131954168));
            ((DialogChangeCountryBinding) getBinding()).cancelButton.setVisibility(0);
            User user = UserStore.INSTANCE.getShared().getUser();
            ImageView imageView = ((DialogChangeCountryBinding) getBinding()).oldCountry;
            Intrinsics.checkNotNullExpressionValue(imageView, "oldCountry");
            String str5 = null;
            if (user != null && (countryInfo2 = user.getCountryInfo()) != null) {
                str2 = countryInfo2.getIcon();
            } else {
                str2 = null;
            }
            ImageKtxKt.loadImage$default(imageView, ImageSizeKt.image100(str2), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            TextView textView4 = ((DialogChangeCountryBinding) getBinding()).oldCountryName;
            if (user != null && (countryInfo = user.getCountryInfo()) != null) {
                str3 = countryInfo.getName();
            } else {
                str3 = null;
            }
            textView4.setText(str3);
            EditCountryData editCountryData2 = this.editCountryData;
            ImageView imageView2 = ((DialogChangeCountryBinding) getBinding()).newCountry;
            Intrinsics.checkNotNullExpressionValue(imageView2, "newCountry");
            if (editCountryData2 != null) {
                str4 = editCountryData2.getIcon();
            } else {
                str4 = null;
            }
            ImageKtxKt.loadImage$default(imageView2, str4, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            TextView textView5 = ((DialogChangeCountryBinding) getBinding()).newCountryName;
            if (editCountryData2 != null) {
                str5 = editCountryData2.getName();
            }
            textView5.setText(str5);
        }
        ((DialogChangeCountryBinding) getBinding()).cancelButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChangeCountryDialog.this.dismiss();
            }
        });
        ((DialogChangeCountryBinding) getBinding()).confirmButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChangeCountryDialog.initView$lambda$3(ChangeCountryDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(ChangeCountryDialog changeCountryDialog, View view) {
        long j;
        Long canEditCountryDiffSeconds;
        CheckUserInfo checkUserInfo = changeCountryDialog.checkUserInfo;
        if (checkUserInfo != null && (canEditCountryDiffSeconds = checkUserInfo.getCanEditCountryDiffSeconds()) != null) {
            j = canEditCountryDiffSeconds.longValue();
        } else {
            j = 0;
        }
        if (j > 0) {
            changeCountryDialog.dismiss();
            return;
        }
        BaseDialogInterface baseDialogInterface = changeCountryDialog.listener;
        if (baseDialogInterface != null) {
            baseDialogInterface.clickConfirm();
        }
        changeCountryDialog.dismiss();
    }

    public void dismiss() {
        super.dismiss();
        CountDownTimer countDownTimer = this.timerTask;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Nullable
    public final CheckUserInfo getCheckUserInfo() {
        return this.checkUserInfo;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_change_country;
    }

    @Nullable
    public final BaseDialogInterface getListener() {
        return this.listener;
    }

    @Nullable
    public final CountDownTimer getTimerTask() {
        return this.timerTask;
    }

    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        initView();
    }

    public final void setCheckUserInfo(@Nullable CheckUserInfo checkUserInfo) {
        this.checkUserInfo = checkUserInfo;
    }

    public final void setListener(@Nullable BaseDialogInterface baseDialogInterface) {
        this.listener = baseDialogInterface;
    }

    public final void setTimerTask(@Nullable CountDownTimer countDownTimer) {
        this.timerTask = countDownTimer;
    }

    public /* synthetic */ ChangeCountryDialog(Context context, EditCountryData editCountryData, CheckUserInfo checkUserInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : editCountryData, (i & 4) != 0 ? null : checkUserInfo);
    }
}
