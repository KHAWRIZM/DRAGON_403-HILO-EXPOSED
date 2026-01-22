package com.qiahao.nextvideo.ui.cp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.oudi.utils.date.DateUtils;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.model.common.Special;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.utils.RelationTypeUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogCpCertificateBinding;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000f\u001a\u00020\u0010H\u0014J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0012H\u0003R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/ui/cp/CpCertificateDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogCpCertificateBinding;", "context", "Landroid/content/Context;", "user", "Lcom/qiahao/base_common/model/common/User;", "special", "Lcom/qiahao/base_common/model/common/Special;", "<init>", "(Landroid/content/Context;Lcom/qiahao/base_common/model/common/User;Lcom/qiahao/base_common/model/common/Special;)V", "getUser", "()Lcom/qiahao/base_common/model/common/User;", "getSpecial", "()Lcom/qiahao/base_common/model/common/Special;", "getLayoutResId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initView", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCpCertificateDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CpCertificateDialog.kt\ncom/qiahao/nextvideo/ui/cp/CpCertificateDialog\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,70:1\n1#2:71\n61#3,9:72\n61#3,9:81\n*S KotlinDebug\n*F\n+ 1 CpCertificateDialog.kt\ncom/qiahao/nextvideo/ui/cp/CpCertificateDialog\n*L\n61#1:72,9\n65#1:81,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CpCertificateDialog extends BaseBindingDialog<DialogCpCertificateBinding> {

    @NotNull
    private final Special special;

    @NotNull
    private final User user;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CpCertificateDialog(@NotNull Context context, @NotNull User user, @NotNull Special special) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(special, "special");
        this.user = user;
        this.special = special;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SetTextI18n"})
    private final void initView() {
        String str;
        String str2;
        int i;
        long j;
        String nick;
        AppCompatImageView appCompatImageView = ((DialogCpCertificateBinding) getBinding()).cpAvatar1;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "cpAvatar1");
        ImageKtxKt.loadImage$default(appCompatImageView, ImageSizeKt.image100(this.user.getAvatar()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
        AppCompatImageView appCompatImageView2 = ((DialogCpCertificateBinding) getBinding()).cpAvatar2;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "cpAvatar2");
        User user = this.special.getUser();
        Drawable drawable = null;
        if (user != null) {
            str = user.getAvatar();
        } else {
            str = null;
        }
        ImageKtxKt.loadImage$default(appCompatImageView2, ImageSizeKt.image100(str), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
        ((DialogCpCertificateBinding) getBinding()).cpNicke1.setText(this.user.getNick());
        TextView textView = ((DialogCpCertificateBinding) getBinding()).cpNicke2;
        User user2 = this.special.getUser();
        if (user2 != null && (nick = user2.getNick()) != null) {
            str2 = DataExternalKt.maxLengthSuffix(nick, 8, "...");
        } else {
            str2 = null;
        }
        textView.setText(str2);
        ImageView imageView = ((DialogCpCertificateBinding) getBinding()).model;
        RelationTypeUtils relationTypeUtils = RelationTypeUtils.INSTANCE;
        Integer level = this.special.getLevel();
        Integer type = this.special.getType();
        int i2 = 0;
        if (type != null) {
            i = type.intValue();
        } else {
            i = 0;
        }
        Integer relationMedal = relationTypeUtils.getRelationMedal(level, true, i);
        if (relationMedal != null) {
            drawable = androidx.core.content.a.getDrawable(getContext(), relationMedal.intValue());
        }
        imageView.setImageDrawable(drawable);
        TextView textView2 = ((DialogCpCertificateBinding) getBinding()).createTime;
        DateUtils dateUtils = DateUtils.INSTANCE;
        Long createdUnix = this.special.getCreatedUnix();
        long j2 = 0;
        if (createdUnix != null) {
            j = createdUnix.longValue();
        } else {
            j = 0;
        }
        textView2.setText(dateUtils.formatDate("yyyy-MM-dd", Long.valueOf(j * 1000)));
        TextView textView3 = ((DialogCpCertificateBinding) getBinding()).longTime;
        Integer days = this.special.getDays();
        if (days != null) {
            i2 = days.intValue();
        }
        textView3.setText(i2 + ResourcesKtxKt.getStringById(this, 2131952501));
        AppCompatTextView appCompatTextView = ((DialogCpCertificateBinding) getBinding()).cpRankIndex;
        String name = this.special.getName();
        if (name == null) {
            name = "";
        }
        appCompatTextView.setText(name);
        TextView textView4 = ((DialogCpCertificateBinding) getBinding()).cpValue;
        Long points = this.special.getPoints();
        if (points != null) {
            j2 = points.longValue();
        }
        textView4.setText(NumberUtilsKt.rankNumberFormat(j2));
        final AppCompatImageView appCompatImageView3 = ((DialogCpCertificateBinding) getBinding()).cpAvatar1;
        final long j3 = 800;
        appCompatImageView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpCertificateDialog$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView3) > j3 || (appCompatImageView3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView3, currentTimeMillis);
                    AppService service = AppController.INSTANCE.getService();
                    if (service != null) {
                        service.openPersonPage(this.getUser().getExternalId());
                    }
                }
            }
        });
        final AppCompatImageView appCompatImageView4 = ((DialogCpCertificateBinding) getBinding()).cpAvatar2;
        appCompatImageView4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpCertificateDialog$initView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                String str3;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView4) > j3 || (appCompatImageView4 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView4, currentTimeMillis);
                    AppService service = AppController.INSTANCE.getService();
                    if (service != null) {
                        User user3 = this.getSpecial().getUser();
                        if (user3 == null || (str3 = user3.getExternalId()) == null) {
                            str3 = "";
                        }
                        service.openPersonPage(str3);
                    }
                }
            }
        });
    }

    protected int getLayoutResId() {
        return R.layout.dialog_cp_certificate;
    }

    @NotNull
    public final Special getSpecial() {
        return this.special;
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super/*com.qiahao.base_common.common.BaseDialog*/.onCreate(savedInstanceState);
        initView();
    }
}
