package com.qiahao.nextvideo.ui.peopleCertification;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnResultCallbackListener;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.picture.PictureSelector;
import com.qiahao.base_common.utils.picture.PictureSelectorConfigures;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.service.AliCloudService;
import com.qiahao.nextvideo.databinding.ActivityPeopleCertificationBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.utilities.StorageUtils;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0011\u0010\u0004R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/qiahao/nextvideo/ui/peopleCertification/PeopleCertificationActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityPeopleCertificationBinding;", "<init>", "()V", "", "initView", "choosePicture", "confirmUpload", "", "url", "realCertification", "(Ljava/lang/String;)V", "", "getLayoutResId", "()I", "onInitialize", "onDestroy", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "getMCompositeDisposable", "()Lnd/a;", "setMCompositeDisposable", "(Lnd/a;)V", "Ljava/io/File;", "videoFile", "Ljava/io/File;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPeopleCertificationActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PeopleCertificationActivity.kt\ncom/qiahao/nextvideo/ui/peopleCertification/PeopleCertificationActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,176:1\n61#2,9:177\n61#2,9:186\n*S KotlinDebug\n*F\n+ 1 PeopleCertificationActivity.kt\ncom/qiahao/nextvideo/ui/peopleCertification/PeopleCertificationActivity\n*L\n65#1:177,9\n68#1:186,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PeopleCertificationActivity extends HiloBaseBindingActivity<ActivityPeopleCertificationBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private nd.a mCompositeDisposable = new nd.a();

    @Nullable
    private File videoFile;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/qiahao/nextvideo/ui/peopleCertification/PeopleCertificationActivity$Companion;", "", "<init>", "()V", "start", "", "context", "Landroid/content/Context;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, (Class<?>) PeopleCertificationActivity.class));
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"SourceLockedOrientationActivity"})
    public final void choosePicture() {
        PictureSelector.INSTANCE.selectorPicture(new PictureSelectorConfigures.Companion.Builder().isEnablePreviewImage(true).setWithCamera(true).setMShowType(SelectMimeType.ofVideo()).setMVideoMinSecond(3).setMVideoMaxSecond(100).build(), new OnResultCallbackListener<LocalMedia>() { // from class: com.qiahao.nextvideo.ui.peopleCertification.PeopleCertificationActivity$choosePicture$1
            public void onCancel() {
            }

            public void onResult(ArrayList<LocalMedia> result) {
                String compressPath;
                File file;
                File file2;
                ActivityPeopleCertificationBinding binding;
                File file3;
                if (result != null && result.size() > 0) {
                    LocalMedia localMedia = result.get(0);
                    if (localMedia.isCut() && !localMedia.isCompressed()) {
                        compressPath = localMedia.getCutPath();
                    } else if (!localMedia.isCompressed() && (!localMedia.isCut() || !localMedia.isCompressed())) {
                        if (!TextUtils.isEmpty(localMedia.getRealPath())) {
                            compressPath = localMedia.getRealPath();
                        } else {
                            compressPath = localMedia.getPath();
                        }
                    } else {
                        compressPath = localMedia.getCompressPath();
                    }
                    PeopleCertificationActivity.this.videoFile = StorageUtils.INSTANCE.getFileCompat(compressPath);
                    file = PeopleCertificationActivity.this.videoFile;
                    if (file != null) {
                        file2 = PeopleCertificationActivity.this.videoFile;
                        if (file2 == null || file2.exists()) {
                            binding = PeopleCertificationActivity.this.getBinding();
                            QMUIRadiusImageView qMUIRadiusImageView = binding.cameraImg;
                            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "cameraImg");
                            file3 = PeopleCertificationActivity.this.videoFile;
                            ImageKtxKt.loadImage$default(qMUIRadiusImageView, (String) null, (Uri) null, file3, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65531, (Object) null);
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void confirmUpload() {
        File file = this.videoFile;
        if (file != null) {
            if (file == null || file.exists()) {
                HiloBaseActivity.showProgressDialog$default((HiloBaseActivity) this, (String) null, false, (Function0) null, 7, (Object) null);
                AliCloudService shared = AliCloudService.INSTANCE.getShared();
                File file2 = this.videoFile;
                Intrinsics.checkNotNull(file2);
                RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(shared.uploadFile(AliCloudService.OSS_SCREENSHOT, file2, true, new Function2() { // from class: com.qiahao.nextvideo.ui.peopleCertification.c
                    public final Object invoke(Object obj, Object obj2) {
                        Unit confirmUpload$lambda$4;
                        confirmUpload$lambda$4 = PeopleCertificationActivity.confirmUpload$lambda$4(((Long) obj).longValue(), ((Long) obj2).longValue());
                        return confirmUpload$lambda$4;
                    }
                }), new Function1() { // from class: com.qiahao.nextvideo.ui.peopleCertification.d
                    public final Object invoke(Object obj) {
                        Unit confirmUpload$lambda$6;
                        confirmUpload$lambda$6 = PeopleCertificationActivity.confirmUpload$lambda$6(PeopleCertificationActivity.this, (Pair) obj);
                        return confirmUpload$lambda$6;
                    }
                }, new Function1() { // from class: com.qiahao.nextvideo.ui.peopleCertification.e
                    public final Object invoke(Object obj) {
                        Unit confirmUpload$lambda$8;
                        confirmUpload$lambda$8 = PeopleCertificationActivity.confirmUpload$lambda$8(PeopleCertificationActivity.this, (Throwable) obj);
                        return confirmUpload$lambda$8;
                    }
                }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirmUpload$lambda$4(long j, long j2) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit confirmUpload$lambda$6(PeopleCertificationActivity peopleCertificationActivity, Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "it");
        HiloBaseActivity.dismissProgressDialog$default(peopleCertificationActivity, false, new Function0() { // from class: com.qiahao.nextvideo.ui.peopleCertification.a
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, 1, null);
        if (((Boolean) pair.getFirst()).booleanValue()) {
            peopleCertificationActivity.realCertification("https://image.whoisamy.shop/" + pair.getSecond());
        } else {
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, peopleCertificationActivity, ResourcesKtxKt.getStringById(peopleCertificationActivity, 2131952667), false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit confirmUpload$lambda$8(PeopleCertificationActivity peopleCertificationActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        HiloBaseActivity.dismissProgressDialog$default(peopleCertificationActivity, false, new Function0() { // from class: com.qiahao.nextvideo.ui.peopleCertification.b
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, 1, null);
        HiloToasty.Companion companion = HiloToasty.Companion;
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = ResourcesKtxKt.getStringById(peopleCertificationActivity, 2131952667);
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, peopleCertificationActivity, localizedMessage, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    private final void initView() {
        View view = getBinding().titleLayout.bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.peopleCertification.f
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$0;
                initView$lambda$0 = PeopleCertificationActivity.initView$lambda$0(PeopleCertificationActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$0;
            }
        });
        getBinding().titleLayout.backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.peopleCertification.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PeopleCertificationActivity.this.finish();
            }
        });
        getBinding().titleLayout.title.setText(ResourcesKtxKt.getStringById(this, 2131953836));
        final QMUIRadiusImageView qMUIRadiusImageView = getBinding().cameraImg;
        final long j = 800;
        qMUIRadiusImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.peopleCertification.PeopleCertificationActivity$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(qMUIRadiusImageView) > j || (qMUIRadiusImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(qMUIRadiusImageView, currentTimeMillis);
                    QMUIRadiusImageView qMUIRadiusImageView2 = qMUIRadiusImageView;
                    this.choosePicture();
                }
            }
        });
        final TextView textView = getBinding().confirm;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.peopleCertification.PeopleCertificationActivity$initView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    this.confirmUpload();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$0(PeopleCertificationActivity peopleCertificationActivity, int i, int i2) {
        peopleCertificationActivity.getBinding().titleLayout.bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    private final void realCertification(String url) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().realCertification(url), new Function1() { // from class: com.qiahao.nextvideo.ui.peopleCertification.j
            public final Object invoke(Object obj) {
                Unit realCertification$lambda$10;
                realCertification$lambda$10 = PeopleCertificationActivity.realCertification$lambda$10(PeopleCertificationActivity.this, (ApiResponse) obj);
                return realCertification$lambda$10;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.peopleCertification.k
            public final Object invoke(Object obj) {
                Unit realCertification$lambda$12;
                realCertification$lambda$12 = PeopleCertificationActivity.realCertification$lambda$12(PeopleCertificationActivity.this, (Throwable) obj);
                return realCertification$lambda$12;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit realCertification$lambda$10(PeopleCertificationActivity peopleCertificationActivity, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, peopleCertificationActivity, ResourcesKtxKt.getStringById(peopleCertificationActivity, 2131954177), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        HiloBaseActivity.dismissProgressDialog$default(peopleCertificationActivity, false, new Function0() { // from class: com.qiahao.nextvideo.ui.peopleCertification.i
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, 1, null);
        peopleCertificationActivity.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit realCertification$lambda$12(PeopleCertificationActivity peopleCertificationActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = ResourcesKtxKt.getStringById(peopleCertificationActivity, 2131952667);
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, peopleCertificationActivity, localizedMessage, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        HiloBaseActivity.dismissProgressDialog$default(peopleCertificationActivity, false, new Function0() { // from class: com.qiahao.nextvideo.ui.peopleCertification.h
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_people_certification;
    }

    @NotNull
    public final nd.a getMCompositeDisposable() {
        return this.mCompositeDisposable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseBindingActivity, com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onDestroy() {
        super.onDestroy();
        this.mCompositeDisposable.d();
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
    }

    public final void setMCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mCompositeDisposable = aVar;
    }
}
