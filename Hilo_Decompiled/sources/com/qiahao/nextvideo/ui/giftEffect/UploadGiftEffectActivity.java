package com.qiahao.nextvideo.ui.giftEffect;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import c5.g;
import cf.c;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnResultCallbackListener;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.player.combination.queue.LightQueueCombinationPlayer;
import com.qiahao.base_common.player.video.VideoMediaSource;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.PathHelper;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.picture.PictureSelector;
import com.qiahao.base_common.utils.picture.PictureSelectorConfigures;
import com.qiahao.hilo_message.data.RoomMessageMulti;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.giftRecord.UploadGiftConfirm;
import com.qiahao.nextvideo.databinding.ActivityGiftEffectBinding;
import com.qiahao.nextvideo.databinding.GiftEffectViewBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.room.help.VideoUploadManager;
import com.qiahao.nextvideo.utilities.StorageUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import o4.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import roomMessage.RoomMessage;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 G2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001GB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u001d\u0010\n\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0004J\r\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0004J\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0005H\u0014¢\u0006\u0004\b \u0010\u0004R\"\u0010\"\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010(\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010)\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R$\u00101\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u0010\u001b\"\u0004\b4\u00105R$\u00107\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010=\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010)\u001a\u0004\b>\u0010+\"\u0004\b?\u0010-R\"\u0010A\u001a\u00020@8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006H"}, d2 = {"Lcom/qiahao/nextvideo/ui/giftEffect/UploadGiftEffectActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityGiftEffectBinding;", "<init>", "()V", "", "initView", "Lcom/luck/picture/lib/interfaces/OnResultCallbackListener;", "Lcom/luck/picture/lib/entity/LocalMedia;", "listener", "choosePicture", "(Lcom/luck/picture/lib/interfaces/OnResultCallbackListener;)V", "", "getLayoutResId", "()I", "onInitialize", "refreshView", "", "checkSelect", "()Z", "", "imageUrl", "videoUrl", "uploadGiftEffect", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/qiahao/nextvideo/databinding/GiftEffectViewBinding;", "initGiftEffectView", "()Lcom/qiahao/nextvideo/databinding/GiftEffectViewBinding;", "giftBinding", "Landroid/graphics/Bitmap;", "toBitmap", "(Lcom/qiahao/nextvideo/databinding/GiftEffectViewBinding;)Landroid/graphics/Bitmap;", "onDestroy", "", "mDiamond", "J", "getMDiamond", "()J", "setMDiamond", "(J)V", "mEffectUrl", "Ljava/lang/String;", "getMEffectUrl", "()Ljava/lang/String;", "setMEffectUrl", "(Ljava/lang/String;)V", "mIconUrl", "getMIconUrl", "setMIconUrl", "mGiftBinding", "Lcom/qiahao/nextvideo/databinding/GiftEffectViewBinding;", "getMGiftBinding", "setMGiftBinding", "(Lcom/qiahao/nextvideo/databinding/GiftEffectViewBinding;)V", "Ljava/io/File;", "mVideoFile", "Ljava/io/File;", "getMVideoFile", "()Ljava/io/File;", "setMVideoFile", "(Ljava/io/File;)V", "mImagePath", "getMImagePath", "setMImagePath", "Lnd/a;", "compositeDisposable", "Lnd/a;", "getCompositeDisposable", "()Lnd/a;", "setCompositeDisposable", "(Lnd/a;)V", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUploadGiftEffectActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UploadGiftEffectActivity.kt\ncom/qiahao/nextvideo/ui/giftEffect/UploadGiftEffectActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 Bitmap.kt\nandroidx/core/graphics/BitmapKt\n*L\n1#1,286:1\n61#2,9:287\n61#2,9:296\n61#2,9:305\n61#2,9:314\n61#2,9:323\n84#3,6:332\n*S KotlinDebug\n*F\n+ 1 UploadGiftEffectActivity.kt\ncom/qiahao/nextvideo/ui/giftEffect/UploadGiftEffectActivity\n*L\n85#1:287,9\n134#1:296,9\n148#1:305,9\n152#1:314,9\n160#1:323,9\n259#1:332,6\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class UploadGiftEffectActivity extends HiloBaseBindingActivity<ActivityGiftEffectBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String EFFECT_URL = "EFFECT_URL";

    @NotNull
    public static final String EXTRA_DIAMOND = "EXTRA_DIAMOND";

    @NotNull
    public static final String ICON_URL = "ICON_URL";

    @NotNull
    private nd.a compositeDisposable = new nd.a();
    private long mDiamond;

    @Nullable
    private String mEffectUrl;

    @Nullable
    private GiftEffectViewBinding mGiftBinding;

    @Nullable
    private String mIconUrl;

    @Nullable
    private String mImagePath;

    @Nullable
    private File mVideoFile;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/qiahao/nextvideo/ui/giftEffect/UploadGiftEffectActivity$Companion;", "", "<init>", "()V", UploadGiftEffectActivity.EXTRA_DIAMOND, "", UploadGiftEffectActivity.EFFECT_URL, UploadGiftEffectActivity.ICON_URL, "startActivity", "", "context", "Landroid/content/Context;", "data", "Lcom/qiahao/nextvideo/data/giftRecord/UploadGiftConfirm;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void startActivity(@NotNull Context context, @Nullable UploadGiftConfirm data) {
            long j;
            String str;
            Long giftDiamond;
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) UploadGiftEffectActivity.class);
            if (data != null && (giftDiamond = data.getGiftDiamond()) != null) {
                j = giftDiamond.longValue();
            } else {
                j = 0;
            }
            intent.putExtra(UploadGiftEffectActivity.EXTRA_DIAMOND, j);
            String str2 = null;
            if (data != null) {
                str = data.getEffectUrl();
            } else {
                str = null;
            }
            intent.putExtra(UploadGiftEffectActivity.EFFECT_URL, str);
            if (data != null) {
                str2 = data.getIconUrl();
            }
            intent.putExtra(UploadGiftEffectActivity.ICON_URL, str2);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void choosePicture(OnResultCallbackListener<LocalMedia> listener) {
        PictureSelector.INSTANCE.selectorPicture(new PictureSelectorConfigures.Companion.Builder().setMShowType(2).isEnablePreviewImage(true).setWithCamera(true).setMVideoMaxSecond(10).setFileMaxSize(2048L).setMMaxSelect(1).isMEnableCrop(false).build(), listener);
    }

    private final void initView() {
        String str;
        this.mGiftBinding = initGiftEffectView();
        LinearLayoutCompat linearLayoutCompat = getBinding().title.linearLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayoutCompat, "linearLayout");
        setStatusBarTopOrBottom(linearLayoutCompat, false);
        getBinding().title.title.setText(ResourcesKtxKt.getStringById(this, 2131954375));
        getBinding().diamond.setText(String.valueOf(this.mDiamond));
        TextView textView = getBinding().userId;
        String stringById = ResourcesKtxKt.getStringById(this, 2131953102);
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            str = user.getCode();
        } else {
            str = null;
        }
        String format = String.format(stringById, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView.setText(format);
        refreshView();
        final ImageView imageView = getBinding().addImage;
        final long j = 800;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.giftEffect.UploadGiftEffectActivity$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                    final UploadGiftEffectActivity uploadGiftEffectActivity = this;
                    uploadGiftEffectActivity.choosePicture(new OnResultCallbackListener<LocalMedia>() { // from class: com.qiahao.nextvideo.ui.giftEffect.UploadGiftEffectActivity$initView$1$1
                        public void onCancel() {
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:27:0x00ba, code lost:
                        
                            if (r1 == null) goto L٤٠;
                         */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public void onResult(ArrayList<LocalMedia> result) {
                            String compressPath;
                            String str2;
                            if (result != null && (!result.isEmpty())) {
                                UploadGiftEffectActivity uploadGiftEffectActivity2 = UploadGiftEffectActivity.this;
                                for (LocalMedia localMedia : result) {
                                    if (localMedia.getMimeType() != null) {
                                        String mimeType = localMedia.getMimeType();
                                        Intrinsics.checkNotNullExpressionValue(mimeType, "getMimeType(...)");
                                        Bitmap bitmap = null;
                                        if (StringsKt.contains$default(mimeType, "video", false, 2, (Object) null)) {
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
                                            File fileCompat = StorageUtils.INSTANCE.getFileCompat(compressPath);
                                            if (fileCompat != null && fileCompat.exists()) {
                                                uploadGiftEffectActivity2.setMVideoFile(fileCompat);
                                                GiftEffectViewBinding mGiftBinding = uploadGiftEffectActivity2.getMGiftBinding();
                                                if (mGiftBinding != null) {
                                                    bitmap = uploadGiftEffectActivity2.toBitmap(mGiftBinding);
                                                }
                                                if (bitmap != null) {
                                                    str2 = VideoUploadManager.INSTANCE.saveBitmapToFile(bitmap, PathHelper.INSTANCE.getAppPrivateDownloadPath() + File.separator + System.currentTimeMillis() + ".png");
                                                }
                                                str2 = "";
                                                uploadGiftEffectActivity2.setMImagePath(str2);
                                                uploadGiftEffectActivity2.refreshView();
                                            } else {
                                                return;
                                            }
                                        } else {
                                            continue;
                                        }
                                    }
                                }
                            }
                        }
                    });
                }
            }
        });
        final TextView textView2 = getBinding().preview;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.giftEffect.UploadGiftEffectActivity$initView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActivityGiftEffectBinding binding;
                File mVideoFile;
                ActivityGiftEffectBinding binding2;
                String str2;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView2) > j || (textView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView2, currentTimeMillis);
                    if (this.getMVideoFile() != null && (mVideoFile = this.getMVideoFile()) != null && mVideoFile.exists()) {
                        binding2 = this.getBinding();
                        LightQueueCombinationPlayer lightQueueCombinationPlayer = binding2.queuePlayer;
                        VideoMediaSource videoMediaSource = new VideoMediaSource();
                        File mVideoFile2 = this.getMVideoFile();
                        if (mVideoFile2 != null) {
                            str2 = mVideoFile2.getAbsolutePath();
                        } else {
                            str2 = null;
                        }
                        videoMediaSource.setFilePath(str2);
                        lightQueueCombinationPlayer.addQueue(videoMediaSource);
                        return;
                    }
                    String mEffectUrl = this.getMEffectUrl();
                    if (mEffectUrl != null && mEffectUrl.length() > 0) {
                        binding = this.getBinding();
                        LightQueueCombinationPlayer lightQueueCombinationPlayer2 = binding.queuePlayer;
                        VideoMediaSource videoMediaSource2 = new VideoMediaSource();
                        videoMediaSource2.setUrl(this.getMEffectUrl());
                        lightQueueCombinationPlayer2.addQueue(videoMediaSource2);
                    }
                }
            }
        });
        final AppCompatImageView appCompatImageView = getBinding().title.backImageView;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.giftEffect.UploadGiftEffectActivity$initView$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView) > j || (appCompatImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView, currentTimeMillis);
                    AppCompatImageView appCompatImageView2 = appCompatImageView;
                    this.finish();
                }
            }
        });
        final ImageView imageView2 = getBinding().close;
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.giftEffect.UploadGiftEffectActivity$initView$$inlined$singleClick$default$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView2) > j || (imageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView2, currentTimeMillis);
                    this.setMVideoFile(null);
                    this.setMImagePath(null);
                    this.setMEffectUrl(null);
                    this.setMIconUrl(null);
                    this.refreshView();
                }
            }
        });
        final TextView textView3 = getBinding().submit;
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.giftEffect.UploadGiftEffectActivity$initView$$inlined$singleClick$default$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView3) > j || (textView3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView3, currentTimeMillis);
                    String mImagePath = this.getMImagePath();
                    if (mImagePath != null && mImagePath.length() != 0 && this.getMVideoFile() != null) {
                        HiloBaseActivity.showProgressDialog$default((HiloBaseActivity) this, (String) null, false, (Function0) null, 7, (Object) null);
                        VideoUploadManager videoUploadManager = VideoUploadManager.INSTANCE;
                        String mImagePath2 = this.getMImagePath();
                        if (mImagePath2 == null) {
                            mImagePath2 = "";
                        }
                        File mVideoFile = this.getMVideoFile();
                        Intrinsics.checkNotNull(mVideoFile);
                        final UploadGiftEffectActivity uploadGiftEffectActivity = this;
                        videoUploadManager.uploadGiftVideo(mImagePath2, mVideoFile, new VideoUploadManager.UploadCallback() { // from class: com.qiahao.nextvideo.ui.giftEffect.UploadGiftEffectActivity$initView$5$1
                            @Override // com.qiahao.nextvideo.room.help.VideoUploadManager.UploadCallback
                            public Object addMessageLocal(RoomMessageMulti roomMessageMulti, Continuation<? super Unit> continuation) {
                                return VideoUploadManager.UploadCallback.DefaultImpls.addMessageLocal(this, roomMessageMulti, continuation);
                            }

                            @Override // com.qiahao.nextvideo.room.help.VideoUploadManager.UploadCallback
                            public Object onUploadFailed(RoomMessageMulti roomMessageMulti, Exception exc, Continuation<? super Unit> continuation) {
                                return VideoUploadManager.UploadCallback.DefaultImpls.onUploadFailed(this, roomMessageMulti, exc, continuation);
                            }

                            @Override // com.qiahao.nextvideo.room.help.VideoUploadManager.UploadCallback
                            public void onUploadProgress(String str2, int i) {
                                VideoUploadManager.UploadCallback.DefaultImpls.onUploadProgress(this, str2, i);
                            }

                            @Override // com.qiahao.nextvideo.room.help.VideoUploadManager.UploadCallback
                            public Object onUploadSuccess(RoomMessage.GroupMessageSend groupMessageSend, boolean z, Continuation<? super Unit> continuation) {
                                return VideoUploadManager.UploadCallback.DefaultImpls.onUploadSuccess(this, groupMessageSend, z, continuation);
                            }

                            @Override // com.qiahao.nextvideo.room.help.VideoUploadManager.UploadCallback
                            public Object refreshLocalMessage(RoomMessageMulti roomMessageMulti, Continuation<? super Unit> continuation) {
                                return VideoUploadManager.UploadCallback.DefaultImpls.refreshLocalMessage(this, roomMessageMulti, continuation);
                            }

                            @Override // com.qiahao.nextvideo.room.help.VideoUploadManager.UploadCallback
                            public Object onUploadFailed(Exception exc, Continuation<? super Unit> continuation) {
                                String stringById2;
                                HiloBaseActivity.dismissProgressDialog$default(UploadGiftEffectActivity.this, false, null, 3, null);
                                HiloToasty.Companion companion = HiloToasty.Companion;
                                BaseActivity baseActivity = UploadGiftEffectActivity.this;
                                if (exc == null || (stringById2 = exc.getMessage()) == null) {
                                    stringById2 = ResourcesKtxKt.getStringById(this, 2131952667);
                                }
                                Toast normal$default = HiloToasty.Companion.normal$default(companion, baseActivity, stringById2, false, 4, (Object) null);
                                if (normal$default != null) {
                                    normal$default.show();
                                }
                                return Unit.INSTANCE;
                            }

                            @Override // com.qiahao.nextvideo.room.help.VideoUploadManager.UploadCallback
                            public Object onUploadSuccess(String str2, String str3, Continuation<? super Unit> continuation) {
                                UploadGiftEffectActivity.this.uploadGiftEffect(str2, str3);
                                return Unit.INSTANCE;
                            }
                        });
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit uploadGiftEffect$lambda$7(UploadGiftEffectActivity uploadGiftEffectActivity, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        HiloBaseActivity.dismissProgressDialog$default(uploadGiftEffectActivity, false, null, 3, null);
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, uploadGiftEffectActivity, ResourcesKtxKt.getStringById(uploadGiftEffectActivity, 2131954177), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        c.c().l("REFRESH_UPLOAD_GIFT");
        uploadGiftEffectActivity.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit uploadGiftEffect$lambda$8(UploadGiftEffectActivity uploadGiftEffectActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        HiloBaseActivity.dismissProgressDialog$default(uploadGiftEffectActivity, false, null, 3, null);
        HiloToasty.Companion companion = HiloToasty.Companion;
        String message = th.getMessage();
        if (message == null) {
            message = ResourcesKtxKt.getStringById(uploadGiftEffectActivity, 2131952667);
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, uploadGiftEffectActivity, message, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    public final boolean checkSelect() {
        String str;
        String str2;
        String str3 = this.mImagePath;
        if ((str3 != null && str3.length() > 0 && this.mVideoFile != null) || ((str = this.mEffectUrl) != null && str.length() > 0 && (str2 = this.mIconUrl) != null && str2.length() > 0)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final nd.a getCompositeDisposable() {
        return this.compositeDisposable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_gift_effect;
    }

    public final long getMDiamond() {
        return this.mDiamond;
    }

    @Nullable
    public final String getMEffectUrl() {
        return this.mEffectUrl;
    }

    @Nullable
    public final GiftEffectViewBinding getMGiftBinding() {
        return this.mGiftBinding;
    }

    @Nullable
    public final String getMIconUrl() {
        return this.mIconUrl;
    }

    @Nullable
    public final String getMImagePath() {
        return this.mImagePath;
    }

    @Nullable
    public final File getMVideoFile() {
        return this.mVideoFile;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final GiftEffectViewBinding initGiftEffectView() {
        String str = null;
        GiftEffectViewBinding inflate = GiftEffectViewBinding.inflate(LayoutInflater.from(this), null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        ImageView imageView = inflate.avatar;
        Intrinsics.checkNotNullExpressionValue(imageView, "avatar");
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            str = user.getAvatar();
        }
        ImageKtxKt.loadImage$default(imageView, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, 2131231655, 2131231655, (g) null, 40958, (Object) null);
        inflate.getRoot().measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        inflate.getRoot().layout(0, 0, inflate.getRoot().getMeasuredWidth(), inflate.getRoot().getMeasuredHeight());
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseBindingActivity, com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onDestroy() {
        super.onDestroy();
        this.mVideoFile = null;
        this.mImagePath = null;
        getBinding().queuePlayer.onDestroy();
        VideoUploadManager.INSTANCE.destroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        this.mDiamond = getIntent().getLongExtra(EXTRA_DIAMOND, 0L);
        this.mEffectUrl = getIntent().getStringExtra(EFFECT_URL);
        this.mIconUrl = getIntent().getStringExtra(ICON_URL);
        initView();
    }

    public final void refreshView() {
        if (checkSelect()) {
            getBinding().selectGroup.setVisibility(0);
            getBinding().addImage.setVisibility(8);
            View view = getBinding().backGround;
            ShapeUtil shapeUtil = ShapeUtil.INSTANCE;
            view.setBackground(ShapeUtil.createShapeStroke$default(shapeUtil, "#8833FF", 8, 1.0f, false, "#cc000000", (String) null, (GradientDrawable.Orientation) null, 104, (Object) null));
            getBinding().preview.setBackground(ShapeUtil.createShape$default(shapeUtil, "#9136FF", "#9136FF", 0, 0, 8, 8, (GradientDrawable.Orientation) null, 64, (Object) null));
            if (this.mVideoFile != null) {
                getBinding().submit.setBackground(ShapeUtil.createShape$default(shapeUtil, "#9136FF", "#9136FF", 24, (GradientDrawable.Orientation) null, 8, (Object) null));
            } else {
                getBinding().submit.setBackground(ShapeUtil.createShape$default(shapeUtil, "#7f9136FF", "#7f9136FF", 24, (GradientDrawable.Orientation) null, 8, (Object) null));
            }
            String str = this.mImagePath;
            if (str != null && str.length() > 0) {
                ImageView imageView = getBinding().giftEffect;
                Intrinsics.checkNotNullExpressionValue(imageView, "giftEffect");
                String str2 = this.mImagePath;
                if (str2 == null) {
                    str2 = "";
                }
                ImageKtxKt.loadImage$default(imageView, (String) null, (Uri) null, new File(str2), (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65531, (Object) null);
                return;
            }
            ImageView imageView2 = getBinding().giftEffect;
            Intrinsics.checkNotNullExpressionValue(imageView2, "giftEffect");
            ImageKtxKt.loadImage$default(imageView2, this.mIconUrl, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65534, (Object) null);
            return;
        }
        getBinding().selectGroup.setVisibility(8);
        getBinding().addImage.setVisibility(0);
        View view2 = getBinding().backGround;
        ShapeUtil shapeUtil2 = ShapeUtil.INSTANCE;
        view2.setBackground(ShapeUtil.createShapeStroke$default(shapeUtil2, "#8833FF", 8, 1.0f, false, "#198833FF", (String) null, (GradientDrawable.Orientation) null, 104, (Object) null));
        getBinding().submit.setBackground(ShapeUtil.createShape$default(shapeUtil2, "#7f9136FF", "#7f9136FF", 24, (GradientDrawable.Orientation) null, 8, (Object) null));
    }

    public final void setCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.compositeDisposable = aVar;
    }

    public final void setMDiamond(long j) {
        this.mDiamond = j;
    }

    public final void setMEffectUrl(@Nullable String str) {
        this.mEffectUrl = str;
    }

    public final void setMGiftBinding(@Nullable GiftEffectViewBinding giftEffectViewBinding) {
        this.mGiftBinding = giftEffectViewBinding;
    }

    public final void setMIconUrl(@Nullable String str) {
        this.mIconUrl = str;
    }

    public final void setMImagePath(@Nullable String str) {
        this.mImagePath = str;
    }

    public final void setMVideoFile(@Nullable File file) {
        this.mVideoFile = file;
    }

    @NotNull
    public final Bitmap toBitmap(@NotNull GiftEffectViewBinding giftBinding) {
        Intrinsics.checkNotNullParameter(giftBinding, "giftBinding");
        Bitmap createBitmap = Bitmap.createBitmap(giftBinding.getRoot().getWidth(), giftBinding.getRoot().getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Drawable background = giftBinding.getRoot().getBackground();
        if (background != null) {
            background.draw(canvas);
        } else {
            canvas.drawColor(0);
        }
        giftBinding.getRoot().draw(canvas);
        return createBitmap;
    }

    public final void uploadGiftEffect(@NotNull String imageUrl, @NotNull String videoUrl) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(videoUrl, "videoUrl");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().uploadGift(videoUrl, imageUrl), new Function1() { // from class: com.qiahao.nextvideo.ui.giftEffect.a
            public final Object invoke(Object obj) {
                Unit uploadGiftEffect$lambda$7;
                uploadGiftEffect$lambda$7 = UploadGiftEffectActivity.uploadGiftEffect$lambda$7(UploadGiftEffectActivity.this, (ApiResponse) obj);
                return uploadGiftEffect$lambda$7;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.giftEffect.b
            public final Object invoke(Object obj) {
                Unit uploadGiftEffect$lambda$8;
                uploadGiftEffect$lambda$8 = UploadGiftEffectActivity.uploadGiftEffect$lambda$8(UploadGiftEffectActivity.this, (Throwable) obj);
                return uploadGiftEffect$lambda$8;
            }
        }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
    }
}
