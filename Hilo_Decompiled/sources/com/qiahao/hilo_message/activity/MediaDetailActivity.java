package com.qiahao.hilo_message.activity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.s;
import androidx.lifecycle.LifecycleOwnerKt;
import com.github.chrisbanes.photoview.PhotoView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.permission.PermissionInterceptor;
import com.qiahao.base_common.player.MediaDownloader;
import com.qiahao.base_common.room.dataBase.AppDataBase;
import com.qiahao.base_common.room.roomDao.DownloadFileDao;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.hilo_message.R;
import com.qiahao.hilo_message.activity.MediaDetailActivity;
import com.qiahao.hilo_message.databinding.ActivityMediaViewBinding;
import com.tencent.qcloud.tuikit.tuichat.util.FileUtil;
import java.io.File;
import java.util.ArrayList;
import k3.b;
import k3.c;
import k3.d;
import k3.f;
import k3.h;
import k3.j;
import k3.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 82\u00020\u0001:\u00029:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0003J\r\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0003J\r\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0003J\u001f\u0010\u0019\u001a\u00020\u00182\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u001f\u0010\u0003R\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010'R\u0018\u0010)\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010'R\u0016\u0010+\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010'R\u001b\u00104\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0018\u00106\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107¨\u0006;"}, d2 = {"Lcom/qiahao/hilo_message/activity/MediaDetailActivity;", "Lcom/qiahao/base_common/common/BaseActivity;", "<init>", "()V", "", "initData", "setupListeners", "loadMedia", "loadOriginalImage", "prepareVideo", "playVideo", "downloadMedia", "Ljava/io/File;", "file", "saveToGallery", "(Ljava/io/File;)V", "", "getLayoutResId", "()I", "onInitialize", "initView", "refreshVisibleView", "Lkotlin/Function0;", "success", "", "checkWriteOrStoragePermission", "(Lkotlin/jvm/functions/Function0;)Z", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "onDestroy", "Lcom/qiahao/hilo_message/databinding/ActivityMediaViewBinding;", "binding", "Lcom/qiahao/hilo_message/databinding/ActivityMediaViewBinding;", "mediaType", "I", "", "mUrl", "Ljava/lang/String;", "mLocalUrl", "videoUrl", "videoLocalPath", "isShowingOriginal", "Z", "isVideoPlaying", "downloadPath", "Lcom/qiahao/base_common/room/roomDao/DownloadFileDao;", "downloadFileDao$delegate", "Lkotlin/Lazy;", "getDownloadFileDao", "()Lcom/qiahao/base_common/room/roomDao/DownloadFileDao;", "downloadFileDao", "Landroidx/core/view/s;", "gestureDetector", "Landroidx/core/view/s;", "Companion", "b/a", "b/b", "hilo_message_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class MediaDetailActivity extends BaseActivity {

    @NotNull
    public static final b Companion = new b();

    @NotNull
    public static final String EXTRA_LOCAL_URL = "local_url";

    @NotNull
    public static final String EXTRA_MEDIA_TYPE = "media_type";

    @NotNull
    public static final String EXTRA_URL = "url";

    @NotNull
    public static final String EXTRA_VIDEO_LOCAL_PATH = "video_local_path";

    @NotNull
    public static final String EXTRA_VIDEO_URL = "video_url";
    public static final int MEDIA_TYPE_IMAGE = 0;
    public static final int MEDIA_TYPE_VIDEO = 1;

    @NotNull
    private static final String TAG = "MediaDetailActivity";

    @Nullable
    private ActivityMediaViewBinding binding;

    @Nullable
    private String downloadPath;

    @Nullable
    private s gestureDetector;
    private boolean isShowingOriginal;
    private boolean isVideoPlaying;

    @Nullable
    private String mLocalUrl;
    private int mediaType;

    @Nullable
    private String videoLocalPath;

    @Nullable
    private String videoUrl;

    @NotNull
    private String mUrl = "";

    /* renamed from: downloadFileDao$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy downloadFileDao = LazyKt.lazy(new Function0() { // from class: ib.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            DownloadFileDao downloadFileDao_delegate$lambda$0;
            downloadFileDao_delegate$lambda$0 = MediaDetailActivity.downloadFileDao_delegate$lambda$0(MediaDetailActivity.this);
            return downloadFileDao_delegate$lambda$0;
        }
    });

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean checkWriteOrStoragePermission$default(MediaDetailActivity mediaDetailActivity, Function0 function0, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            function0 = null;
        }
        return mediaDetailActivity.checkWriteOrStoragePermission(function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DownloadFileDao downloadFileDao_delegate$lambda$0(MediaDetailActivity mediaDetailActivity) {
        return AppDataBase.INSTANCE.getDatabase(mediaDetailActivity).downloadFileDao();
    }

    private final void downloadMedia() {
        String str;
        String str2;
        int i10;
        PhotoView photoView;
        if (this.mediaType == 0) {
            if (this.isShowingOriginal) {
                str = this.mUrl;
            } else {
                String str3 = this.mUrl;
                ActivityMediaViewBinding activityMediaViewBinding = this.binding;
                if (activityMediaViewBinding != null && (photoView = activityMediaViewBinding.photoView) != null) {
                    i10 = photoView.getWidth();
                } else {
                    i10 = 0;
                }
                str = ImageSizeKt.imageSize(str3, i10);
            }
        } else {
            str = this.videoUrl;
        }
        if (TextUtils.isEmpty(str)) {
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.INSTANCE, this, ResourcesKtxKt.getStringById(this, R.string.fail), false, 4, null);
            if (normal$default != null) {
                normal$default.show();
                return;
            }
            return;
        }
        MediaDownloader.MediaDownloaderImpl mediaDownloaderImpl = new MediaDownloader.MediaDownloaderImpl(0L, 1, null);
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        mediaDownloaderImpl.download(str2, new f(this, str), Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DownloadFileDao getDownloadFileDao() {
        return (DownloadFileDao) this.downloadFileDao.getValue();
    }

    private final void initData() {
        this.gestureDetector = new s(this, new c(this));
        this.mediaType = getIntent().getIntExtra(EXTRA_MEDIA_TYPE, 0);
        String stringExtra = getIntent().getStringExtra("url");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.mUrl = stringExtra;
        this.mLocalUrl = getIntent().getStringExtra(EXTRA_LOCAL_URL);
        this.videoUrl = getIntent().getStringExtra(EXTRA_VIDEO_URL);
        this.videoLocalPath = getIntent().getStringExtra(EXTRA_VIDEO_LOCAL_PATH);
        if (this.mediaType == 0) {
            if (TextUtils.isEmpty(this.mLocalUrl) || !new File(this.mLocalUrl).exists()) {
                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new h(this, null), 2, null);
                return;
            }
            this.downloadPath = this.mLocalUrl;
            this.isShowingOriginal = true;
            refreshVisibleView();
            return;
        }
        if (!TextUtils.isEmpty(this.videoUrl)) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new j(this, null), 2, null);
        } else if (new File(this.videoLocalPath).exists()) {
            this.downloadPath = this.videoLocalPath;
            this.isShowingOriginal = true;
            refreshVisibleView();
        }
    }

    private final void loadMedia() {
        PhotoView photoView;
        PhotoView photoView2;
        int i10 = this.mediaType;
        if (i10 != 0) {
            if (i10 == 1) {
                prepareVideo();
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(this.downloadPath) && new File(this.downloadPath).exists()) {
            ActivityMediaViewBinding activityMediaViewBinding = this.binding;
            if (activityMediaViewBinding != null && (photoView2 = activityMediaViewBinding.photoView) != null) {
                File file = new File(this.downloadPath);
                int i11 = R.drawable.group_placeholde;
                ImageKtxKt.loadImage$default(photoView2, null, null, file, null, null, null, false, 0, false, null, null, null, null, Integer.valueOf(i11), Integer.valueOf(i11), null, 40955, null);
                return;
            }
            return;
        }
        ActivityMediaViewBinding activityMediaViewBinding2 = this.binding;
        if (activityMediaViewBinding2 != null && (photoView = activityMediaViewBinding2.photoView) != null) {
            String imageSize = ImageSizeKt.imageSize(this.mUrl, UiKtxKt.toPX(200));
            int i12 = R.drawable.group_placeholde;
            ImageKtxKt.loadImage$default(photoView, imageSize, null, null, null, null, null, false, 0, false, null, null, null, null, Integer.valueOf(i12), Integer.valueOf(i12), null, 40958, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadOriginalImage() {
        PhotoView photoView;
        this.isShowingOriginal = true;
        ActivityMediaViewBinding activityMediaViewBinding = this.binding;
        if (activityMediaViewBinding != null && (photoView = activityMediaViewBinding.photoView) != null) {
            String str = this.mUrl;
            int i10 = R.drawable.group_placeholde;
            ImageKtxKt.loadImage$default(photoView, str, null, null, null, null, null, false, 0, false, null, null, null, null, Integer.valueOf(i10), Integer.valueOf(i10), null, 40958, null);
        }
        refreshVisibleView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$3$lambda$2(MediaDetailActivity mediaDetailActivity, int i10, int i11) {
        ViewGroup.LayoutParams layoutParams;
        FrameLayout frameLayout;
        ImageView imageView;
        ActivityMediaViewBinding activityMediaViewBinding = mediaDetailActivity.binding;
        ViewGroup.LayoutParams layoutParams2 = null;
        if (activityMediaViewBinding != null && (imageView = activityMediaViewBinding.downloadButton) != null) {
            layoutParams = imageView.getLayoutParams();
        } else {
            layoutParams = null;
        }
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ((ConstraintLayout.b) layoutParams).setMargins(0, 0, 0, UiKtxKt.toPX(20) + i11);
        ActivityMediaViewBinding activityMediaViewBinding2 = mediaDetailActivity.binding;
        if (activityMediaViewBinding2 != null && (frameLayout = activityMediaViewBinding2.contentContainer) != null) {
            layoutParams2 = frameLayout.getLayoutParams();
        }
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ((ConstraintLayout.b) layoutParams2).setMargins(0, i10, 0, i11);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$4(MediaDetailActivity mediaDetailActivity) {
        mediaDetailActivity.initView();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void playVideo() {
        ImageView imageView;
        ImageView imageView2;
        VideoView videoView;
        VideoView videoView2;
        ImageView imageView3;
        ImageView imageView4;
        if (!this.isVideoPlaying) {
            ActivityMediaViewBinding activityMediaViewBinding = this.binding;
            if (activityMediaViewBinding != null && (imageView4 = activityMediaViewBinding.videoPlayButton) != null) {
                imageView4.setVisibility(8);
            }
            ActivityMediaViewBinding activityMediaViewBinding2 = this.binding;
            if (activityMediaViewBinding2 != null && (imageView3 = activityMediaViewBinding2.videoThumbnail) != null) {
                imageView3.setVisibility(8);
            }
            ActivityMediaViewBinding activityMediaViewBinding3 = this.binding;
            if (activityMediaViewBinding3 != null && (videoView2 = activityMediaViewBinding3.videoView) != null) {
                videoView2.start();
            }
            this.isVideoPlaying = true;
            return;
        }
        ActivityMediaViewBinding activityMediaViewBinding4 = this.binding;
        if (activityMediaViewBinding4 != null && (videoView = activityMediaViewBinding4.videoView) != null) {
            videoView.pause();
        }
        ActivityMediaViewBinding activityMediaViewBinding5 = this.binding;
        if (activityMediaViewBinding5 != null && (imageView2 = activityMediaViewBinding5.videoPlayButton) != null) {
            imageView2.setVisibility(0);
        }
        ActivityMediaViewBinding activityMediaViewBinding6 = this.binding;
        if (activityMediaViewBinding6 != null && (imageView = activityMediaViewBinding6.videoThumbnail) != null) {
            imageView.setVisibility(0);
        }
        this.isVideoPlaying = false;
    }

    private final void prepareVideo() {
        ImageView imageView;
        VideoView videoView;
        ProgressBar progressBar;
        VideoView videoView2;
        ProgressBar progressBar2;
        ImageView imageView2;
        if (new File(this.mLocalUrl).exists()) {
            ActivityMediaViewBinding activityMediaViewBinding = this.binding;
            if (activityMediaViewBinding != null && (imageView2 = activityMediaViewBinding.videoThumbnail) != null) {
                File file = new File(this.mLocalUrl);
                int i10 = R.drawable.group_placeholde;
                ImageKtxKt.loadImage$default(imageView2, null, null, file, null, null, null, false, 0, false, null, null, null, null, Integer.valueOf(i10), Integer.valueOf(i10), null, 40955, null);
            }
        } else {
            ActivityMediaViewBinding activityMediaViewBinding2 = this.binding;
            if (activityMediaViewBinding2 != null && (imageView = activityMediaViewBinding2.videoThumbnail) != null) {
                String str = this.mUrl;
                int i11 = R.drawable.group_placeholde;
                ImageKtxKt.loadImage$default(imageView, str, null, null, null, null, null, false, 0, false, null, null, null, null, Integer.valueOf(i11), Integer.valueOf(i11), null, 40958, null);
            }
        }
        try {
            if (!TextUtils.isEmpty(this.downloadPath) && new File(this.downloadPath).exists()) {
                ActivityMediaViewBinding activityMediaViewBinding3 = this.binding;
                if (activityMediaViewBinding3 != null && (progressBar2 = activityMediaViewBinding3.loadingProgress) != null) {
                    progressBar2.setVisibility(0);
                }
                ActivityMediaViewBinding activityMediaViewBinding4 = this.binding;
                if (activityMediaViewBinding4 != null && (videoView2 = activityMediaViewBinding4.videoView) != null) {
                    videoView2.setVideoPath(this.downloadPath);
                    return;
                }
                return;
            }
            String str2 = this.videoUrl;
            if (str2 != null) {
                ActivityMediaViewBinding activityMediaViewBinding5 = this.binding;
                if (activityMediaViewBinding5 != null && (progressBar = activityMediaViewBinding5.loadingProgress) != null) {
                    progressBar.setVisibility(0);
                }
                ActivityMediaViewBinding activityMediaViewBinding6 = this.binding;
                if (activityMediaViewBinding6 != null && (videoView = activityMediaViewBinding6.videoView) != null) {
                    videoView.setVideoURI(Uri.parse(str2));
                }
            }
        } catch (Exception e10) {
            Log.e(TAG, "Error preparing video", e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveToGallery(File file) {
        try {
            int i10 = this.mediaType;
            if (i10 == 0) {
                if (Build.VERSION.SDK_INT >= 29) {
                    FileUtil.saveImageToGalleryByMediaStore(this, file.getAbsolutePath());
                } else {
                    FileUtil.saveImageToGalleryByFile(this, file.getAbsolutePath());
                }
            } else if (i10 == 1) {
                if (Build.VERSION.SDK_INT >= 29) {
                    FileUtil.saveVideoToGalleryByMediaStore(this, file.getAbsolutePath());
                } else {
                    FileUtil.saveVideoToGalleryByFile(this, file.getAbsolutePath());
                }
            }
        } catch (Exception e10) {
            Log.e(TAG, "保存到相册失败", e10);
        }
    }

    private final void setupListeners() {
        PhotoView photoView;
        VideoView videoView;
        VideoView videoView2;
        VideoView videoView3;
        ImageView imageView;
        TextView textView;
        ImageView imageView2;
        ImageView imageView3;
        ActivityMediaViewBinding activityMediaViewBinding = this.binding;
        if (activityMediaViewBinding != null && (imageView3 = activityMediaViewBinding.closeButton) != null) {
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: ib.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MediaDetailActivity.this.finish();
                }
            });
        }
        ActivityMediaViewBinding activityMediaViewBinding2 = this.binding;
        if (activityMediaViewBinding2 != null && (imageView2 = activityMediaViewBinding2.downloadButton) != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: ib.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MediaDetailActivity.setupListeners$lambda$7(MediaDetailActivity.this, view);
                }
            });
        }
        ActivityMediaViewBinding activityMediaViewBinding3 = this.binding;
        if (activityMediaViewBinding3 != null && (textView = activityMediaViewBinding3.viewOriginalBtn) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: ib.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MediaDetailActivity.this.loadOriginalImage();
                }
            });
        }
        ActivityMediaViewBinding activityMediaViewBinding4 = this.binding;
        if (activityMediaViewBinding4 != null && (imageView = activityMediaViewBinding4.videoPlayButton) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: ib.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MediaDetailActivity.this.playVideo();
                }
            });
        }
        ActivityMediaViewBinding activityMediaViewBinding5 = this.binding;
        if (activityMediaViewBinding5 != null && (videoView3 = activityMediaViewBinding5.videoView) != null) {
            videoView3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: ib.i
                @Override // android.media.MediaPlayer.OnCompletionListener
                public final void onCompletion(MediaPlayer mediaPlayer) {
                    MediaDetailActivity.setupListeners$lambda$10(MediaDetailActivity.this, mediaPlayer);
                }
            });
        }
        ActivityMediaViewBinding activityMediaViewBinding6 = this.binding;
        if (activityMediaViewBinding6 != null && (videoView2 = activityMediaViewBinding6.videoView) != null) {
            videoView2.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: ib.j
                @Override // android.media.MediaPlayer.OnPreparedListener
                public final void onPrepared(MediaPlayer mediaPlayer) {
                    MediaDetailActivity.setupListeners$lambda$11(MediaDetailActivity.this, mediaPlayer);
                }
            });
        }
        ActivityMediaViewBinding activityMediaViewBinding7 = this.binding;
        if (activityMediaViewBinding7 != null && (videoView = activityMediaViewBinding7.videoView) != null) {
            videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: ib.k
                @Override // android.media.MediaPlayer.OnErrorListener
                public final boolean onError(MediaPlayer mediaPlayer, int i10, int i11) {
                    boolean z10;
                    z10 = MediaDetailActivity.setupListeners$lambda$12(MediaDetailActivity.this, mediaPlayer, i10, i11);
                    return z10;
                }
            });
        }
        ActivityMediaViewBinding activityMediaViewBinding8 = this.binding;
        if (activityMediaViewBinding8 != null && (photoView = activityMediaViewBinding8.photoView) != null) {
            photoView.setOnDoubleTapListener(new k(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$10(MediaDetailActivity mediaDetailActivity, MediaPlayer mediaPlayer) {
        ProgressBar progressBar;
        ImageView imageView;
        mediaDetailActivity.isVideoPlaying = false;
        ActivityMediaViewBinding activityMediaViewBinding = mediaDetailActivity.binding;
        if (activityMediaViewBinding != null && (imageView = activityMediaViewBinding.videoPlayButton) != null) {
            imageView.setVisibility(0);
        }
        ActivityMediaViewBinding activityMediaViewBinding2 = mediaDetailActivity.binding;
        if (activityMediaViewBinding2 != null && (progressBar = activityMediaViewBinding2.loadingProgress) != null) {
            progressBar.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$11(MediaDetailActivity mediaDetailActivity, MediaPlayer mediaPlayer) {
        ImageView imageView;
        ImageView imageView2;
        ProgressBar progressBar;
        ActivityMediaViewBinding activityMediaViewBinding = mediaDetailActivity.binding;
        if (activityMediaViewBinding != null && (progressBar = activityMediaViewBinding.loadingProgress) != null) {
            progressBar.setVisibility(8);
        }
        ActivityMediaViewBinding activityMediaViewBinding2 = mediaDetailActivity.binding;
        if (activityMediaViewBinding2 != null && (imageView2 = activityMediaViewBinding2.videoPlayButton) != null) {
            imageView2.setVisibility(0);
        }
        ActivityMediaViewBinding activityMediaViewBinding3 = mediaDetailActivity.binding;
        if (activityMediaViewBinding3 != null && (imageView = activityMediaViewBinding3.videoThumbnail) != null) {
            imageView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupListeners$lambda$12(MediaDetailActivity mediaDetailActivity, MediaPlayer mediaPlayer, int i10, int i11) {
        ImageView imageView;
        ProgressBar progressBar;
        ImageView imageView2;
        ActivityMediaViewBinding activityMediaViewBinding = mediaDetailActivity.binding;
        if (activityMediaViewBinding != null && (imageView2 = activityMediaViewBinding.videoPlayButton) != null) {
            imageView2.setVisibility(0);
        }
        ActivityMediaViewBinding activityMediaViewBinding2 = mediaDetailActivity.binding;
        if (activityMediaViewBinding2 != null && (progressBar = activityMediaViewBinding2.loadingProgress) != null) {
            progressBar.setVisibility(8);
        }
        ActivityMediaViewBinding activityMediaViewBinding3 = mediaDetailActivity.binding;
        if (activityMediaViewBinding3 != null && (imageView = activityMediaViewBinding3.videoThumbnail) != null) {
            imageView.setVisibility(0);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$7(final MediaDetailActivity mediaDetailActivity, View view) {
        if (mediaDetailActivity.checkWriteOrStoragePermission(new Function0() { // from class: ib.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = MediaDetailActivity.setupListeners$lambda$7$lambda$6(MediaDetailActivity.this);
                return unit;
            }
        })) {
            mediaDetailActivity.downloadMedia();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$7$lambda$6(MediaDetailActivity mediaDetailActivity) {
        mediaDetailActivity.downloadMedia();
        return Unit.INSTANCE;
    }

    public final boolean checkWriteOrStoragePermission(@Nullable Function0<Unit> success) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(fa.b.k());
        arrayList.add(fa.b.l());
        arrayList.add(fa.b.j());
        arrayList.add(fa.b.m());
        arrayList.add(fa.b.p());
        boolean n10 = w9.h.n(this, arrayList);
        if (!n10) {
            w9.h.t(this).p(fa.b.k()).p(fa.b.l()).p(fa.b.j()).p(fa.b.m()).p(fa.b.p()).j(new PermissionInterceptor()).r(new d(success));
        }
        return n10;
    }

    @Override // com.oudi.core.component.SuperActivity
    public int getLayoutResId() {
        return R.layout.activity_media_view;
    }

    public final void initView() {
        initData();
        setupListeners();
    }

    @Override // com.qiahao.base_common.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        ActivityMediaViewBinding activityMediaViewBinding;
        VideoView videoView;
        super.onDestroy();
        if (this.mediaType == 1 && this.isVideoPlaying && (activityMediaViewBinding = this.binding) != null && (videoView = activityMediaViewBinding.videoView) != null) {
            videoView.stopPlayback();
        }
    }

    @Override // com.oudi.core.component.SuperActivity, com.oudi.core.component.IVmComponent, com.oudi.core.component.IComponent
    public void onInitialize() {
        super.onInitialize();
        ActivityMediaViewBinding inflate = ActivityMediaViewBinding.inflate(getLayoutInflater());
        setContentView(inflate.getRoot());
        this.binding = inflate;
        FrameLayout frameLayout = inflate.contentContainer;
        if (frameLayout != null) {
            getStatusBarTopOrBottom(frameLayout, new Function2() { // from class: ib.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit onInitialize$lambda$3$lambda$2;
                    onInitialize$lambda$3$lambda$2 = MediaDetailActivity.onInitialize$lambda$3$lambda$2(MediaDetailActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                    return onInitialize$lambda$3$lambda$2;
                }
            });
        }
        if (checkWriteOrStoragePermission(new Function0() { // from class: ib.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit onInitialize$lambda$4;
                onInitialize$lambda$4 = MediaDetailActivity.onInitialize$lambda$4(MediaDetailActivity.this);
                return onInitialize$lambda$4;
            }
        })) {
            initView();
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        s sVar = this.gestureDetector;
        if ((sVar != null && sVar.a(event)) || super.onTouchEvent(event)) {
            return true;
        }
        return false;
    }

    public final void refreshVisibleView() {
        ImageView imageView;
        TextView textView;
        ConstraintLayout constraintLayout;
        PhotoView photoView;
        ImageView imageView2;
        TextView textView2;
        int i10;
        ConstraintLayout constraintLayout2;
        PhotoView photoView2;
        int i11 = 0;
        if (this.mediaType == 0) {
            ActivityMediaViewBinding activityMediaViewBinding = this.binding;
            if (activityMediaViewBinding != null && (photoView2 = activityMediaViewBinding.photoView) != null) {
                photoView2.setVisibility(0);
            }
            ActivityMediaViewBinding activityMediaViewBinding2 = this.binding;
            if (activityMediaViewBinding2 != null && (constraintLayout2 = activityMediaViewBinding2.videoContainer) != null) {
                constraintLayout2.setVisibility(8);
            }
            ActivityMediaViewBinding activityMediaViewBinding3 = this.binding;
            if (activityMediaViewBinding3 != null && (textView2 = activityMediaViewBinding3.viewOriginalBtn) != null) {
                if (this.isShowingOriginal) {
                    i10 = 8;
                } else {
                    i10 = 0;
                }
                textView2.setVisibility(i10);
            }
            ActivityMediaViewBinding activityMediaViewBinding4 = this.binding;
            if (activityMediaViewBinding4 != null && (imageView2 = activityMediaViewBinding4.downloadButton) != null) {
                if (this.isShowingOriginal && !TextUtils.isEmpty(this.downloadPath)) {
                    i11 = 8;
                }
                imageView2.setVisibility(i11);
            }
        } else {
            ActivityMediaViewBinding activityMediaViewBinding5 = this.binding;
            if (activityMediaViewBinding5 != null && (photoView = activityMediaViewBinding5.photoView) != null) {
                photoView.setVisibility(8);
            }
            ActivityMediaViewBinding activityMediaViewBinding6 = this.binding;
            if (activityMediaViewBinding6 != null && (constraintLayout = activityMediaViewBinding6.videoContainer) != null) {
                constraintLayout.setVisibility(0);
            }
            ActivityMediaViewBinding activityMediaViewBinding7 = this.binding;
            if (activityMediaViewBinding7 != null && (textView = activityMediaViewBinding7.viewOriginalBtn) != null) {
                textView.setVisibility(8);
            }
            ActivityMediaViewBinding activityMediaViewBinding8 = this.binding;
            if (activityMediaViewBinding8 != null && (imageView = activityMediaViewBinding8.downloadButton) != null) {
                if (this.isShowingOriginal && !TextUtils.isEmpty(this.downloadPath)) {
                    i11 = 8;
                }
                imageView.setVisibility(i11);
            }
        }
        loadMedia();
    }
}
