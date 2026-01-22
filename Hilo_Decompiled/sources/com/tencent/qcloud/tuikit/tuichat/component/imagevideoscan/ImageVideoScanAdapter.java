package com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c5.h;
import com.bumptech.glide.Glide;
import com.tencent.imsdk.v2.V2TIMDownloadCallback;
import com.tencent.imsdk.v2.V2TIMElem;
import com.tencent.imsdk.v2.V2TIMImageElem;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMVideoElem;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.util.BackgroundTasks;
import com.tencent.qcloud.tuicore.util.DateTimeUtil;
import com.tencent.qcloud.tuicore.util.FileUtil;
import com.tencent.qcloud.tuicore.util.ImageUtil;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.photoview.listener.OnMatrixChangedListener;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.photoview.listener.OnPhotoTapListener;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.photoview.listener.OnSingleFlingListener;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.photoview.view.PhotoView;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.video.UIKitVideoView;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.video.proxy.IPlayer;
import com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanActivity;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomImageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomVideoBean;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ImageVideoScanAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final String BROADCAST_DOWNLOAD_COMPLETED_ACTION = "PhotoViewActivityDownloadOriginImageCompleted";
    private static final String DOWNLOAD_ORIGIN_IMAGE_PATH = "downloadOriginImagePath";
    private static final String TAG = "ImageVideoScanAdapter";
    private BroadcastReceiver downloadReceiver;
    private Handler durationHandler;
    private Context mContext;
    private TUIMessageBean mNewLocateMessage;
    private TUIMessageBean mOldLocateMessage;
    private ImageVideoScanActivity.OnItemClickListener onItemClickListener;
    private Runnable updateSeekBarTime;
    private List<TUIMessageBean> mDataSource = new ArrayList();
    private boolean mIsVideoPlay = false;
    private String mCacheImagePath = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanAdapter$3, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class AnonymousClass3 implements View.OnClickListener {
        final /* synthetic */ V2TIMImageElem.V2TIMImage val$finalMCurrentOriginalImage;
        final /* synthetic */ ViewHolder val$holder;

        AnonymousClass3(V2TIMImageElem.V2TIMImage v2TIMImage, ViewHolder viewHolder) {
            this.val$finalMCurrentOriginalImage = v2TIMImage;
            this.val$holder = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            V2TIMImageElem.V2TIMImage v2TIMImage = this.val$finalMCurrentOriginalImage;
            if (v2TIMImage == null) {
                TUIChatLog.e(ImageVideoScanAdapter.TAG, "finalMCurrentOriginalImage is null");
            } else {
                final String generateImagePath = ImageUtil.generateImagePath(v2TIMImage.getUUID(), this.val$finalMCurrentOriginalImage.getType());
                this.val$finalMCurrentOriginalImage.downloadImage(generateImagePath, new V2TIMDownloadCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanAdapter.3.1
                    @Override // com.tencent.imsdk.v2.V2TIMCallback
                    public void onError(int i, String str) {
                        ToastUtil.toastLongMessage("Download origin image failed , errCode = " + i + ", " + str);
                    }

                    @Override // com.tencent.imsdk.v2.V2TIMDownloadCallback
                    public void onProgress(V2TIMElem.V2ProgressInfo v2ProgressInfo) {
                        long round = Math.round(((v2ProgressInfo.getCurrentSize() * 1.0d) * 100.0d) / v2ProgressInfo.getTotalSize());
                        if (AnonymousClass3.this.val$holder.viewOriginalButton.getVisibility() != 4 && AnonymousClass3.this.val$holder.viewOriginalButton.getVisibility() != 8) {
                            AnonymousClass3.this.val$holder.viewOriginalButton.setText(round + "%");
                        }
                    }

                    @Override // com.tencent.imsdk.v2.V2TIMCallback
                    public void onSuccess() {
                        BackgroundTasks.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanAdapter.3.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                ImageVideoScanAdapter.this.loadImageIntoView(anonymousClass3.val$holder.photoView, generateImagePath);
                                AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                                anonymousClass32.val$holder.viewOriginalButton.setText(ImageVideoScanAdapter.this.mContext.getString(R.string.completed));
                                AnonymousClass3.this.val$holder.viewOriginalButton.setOnClickListener(null);
                                AnonymousClass3.this.val$holder.viewOriginalButton.setVisibility(4);
                                Intent intent = new Intent();
                                intent.setAction(ImageVideoScanAdapter.BROADCAST_DOWNLOAD_COMPLETED_ACTION);
                                intent.putExtra(ImageVideoScanAdapter.DOWNLOAD_ORIGIN_IMAGE_PATH, generateImagePath);
                                b3.a.b(ImageVideoScanAdapter.this.mContext).d(intent);
                            }
                        });
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanAdapter$5, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class AnonymousClass5 implements View.OnClickListener {
        final /* synthetic */ V2TIMImageElem.V2TIMImage val$finalMCurrentOriginalImage;
        final /* synthetic */ ViewHolder val$holder;

        AnonymousClass5(V2TIMImageElem.V2TIMImage v2TIMImage, ViewHolder viewHolder) {
            this.val$finalMCurrentOriginalImage = v2TIMImage;
            this.val$holder = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            V2TIMImageElem.V2TIMImage v2TIMImage = this.val$finalMCurrentOriginalImage;
            if (v2TIMImage == null) {
                TUIChatLog.e(ImageVideoScanAdapter.TAG, "finalMCurrentOriginalImage is null");
            } else {
                final String generateImagePath = ImageUtil.generateImagePath(v2TIMImage.getUUID(), this.val$finalMCurrentOriginalImage.getType());
                this.val$finalMCurrentOriginalImage.downloadImage(generateImagePath, new V2TIMDownloadCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanAdapter.5.1
                    @Override // com.tencent.imsdk.v2.V2TIMCallback
                    public void onError(int i, String str) {
                        ToastUtil.toastLongMessage("Download origin image failed , errCode = " + i + ", " + str);
                    }

                    @Override // com.tencent.imsdk.v2.V2TIMDownloadCallback
                    public void onProgress(V2TIMElem.V2ProgressInfo v2ProgressInfo) {
                        long round = Math.round(((v2ProgressInfo.getCurrentSize() * 1.0d) * 100.0d) / v2ProgressInfo.getTotalSize());
                        if (AnonymousClass5.this.val$holder.viewOriginalButton.getVisibility() != 4 && AnonymousClass5.this.val$holder.viewOriginalButton.getVisibility() != 8) {
                            AnonymousClass5.this.val$holder.viewOriginalButton.setText(round + "%");
                        }
                    }

                    @Override // com.tencent.imsdk.v2.V2TIMCallback
                    public void onSuccess() {
                        BackgroundTasks.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanAdapter.5.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                                ImageVideoScanAdapter.this.loadImageIntoView(anonymousClass5.val$holder.photoView, generateImagePath);
                                AnonymousClass5 anonymousClass52 = AnonymousClass5.this;
                                anonymousClass52.val$holder.viewOriginalButton.setText(ImageVideoScanAdapter.this.mContext.getString(R.string.completed));
                                AnonymousClass5.this.val$holder.viewOriginalButton.setOnClickListener(null);
                                AnonymousClass5.this.val$holder.viewOriginalButton.setVisibility(4);
                                Intent intent = new Intent();
                                intent.setAction(ImageVideoScanAdapter.BROADCAST_DOWNLOAD_COMPLETED_ACTION);
                                intent.putExtra(ImageVideoScanAdapter.DOWNLOAD_ORIGIN_IMAGE_PATH, generateImagePath);
                                b3.a.b(ImageVideoScanAdapter.this.mContext).d(intent);
                            }
                        });
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class MatrixChangeListener implements OnMatrixChangedListener {
        @Override // com.tencent.qcloud.tuikit.tuichat.classicui.component.photoview.listener.OnMatrixChangedListener
        public void onMatrixChanged(RectF rectF) {
        }

        private MatrixChangeListener() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class PhotoTapListener implements OnPhotoTapListener {
        @Override // com.tencent.qcloud.tuikit.tuichat.classicui.component.photoview.listener.OnPhotoTapListener
        public void onPhotoTap(ImageView imageView, float f, float f2) {
            if (ImageVideoScanAdapter.this.onItemClickListener != null) {
                ImageVideoScanAdapter.this.onItemClickListener.onClickItem();
            }
        }

        private PhotoTapListener() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class SingleFlingListener implements OnSingleFlingListener {
        @Override // com.tencent.qcloud.tuikit.tuichat.classicui.component.photoview.listener.OnSingleFlingListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return true;
        }

        private SingleFlingListener() {
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView closeButton;
        boolean downloadVideoFailed;
        boolean downloadVideoFinished;
        ProgressBar loadingView;
        ImageView pauseCenterView;
        PhotoView photoView;
        RelativeLayout photoViewLayout;
        ImageView playButton;
        LinearLayout playControlLayout;
        SeekBar playSeekBar;
        ImageView snapImageView;
        TextView timeBeginView;
        TextView timeEndView;
        UIKitVideoView videoView;
        FrameLayout videoViewLayout;
        TextView viewOriginalButton;

        public ViewHolder(View view) {
            super(view);
            this.downloadVideoFailed = false;
            this.downloadVideoFinished = false;
            this.photoViewLayout = (RelativeLayout) view.findViewById(R.id.photo_view_layout);
            this.photoView = (PhotoView) view.findViewById(R.id.photo_view);
            this.viewOriginalButton = (TextView) view.findViewById(R.id.view_original_btn);
            this.videoView = (UIKitVideoView) view.findViewById(R.id.video_play_view);
            this.closeButton = (ImageView) view.findViewById(R.id.close_button);
            this.playControlLayout = (LinearLayout) view.findViewById(R.id.play_control_layout);
            this.playButton = (ImageView) view.findViewById(R.id.play_button);
            this.playSeekBar = (SeekBar) view.findViewById(R.id.play_seek);
            this.timeEndView = (TextView) view.findViewById(R.id.time_end);
            this.timeBeginView = (TextView) view.findViewById(R.id.time_begin);
            this.pauseCenterView = (ImageView) view.findViewById(R.id.pause_button_center);
            this.snapImageView = (ImageView) view.findViewById(R.id.content_image_iv);
            this.loadingView = (ProgressBar) view.findViewById(R.id.message_sending_pb);
            this.videoViewLayout = (FrameLayout) view.findViewById(R.id.video_view_layout);
        }
    }

    public ImageVideoScanAdapter() {
        this.mContext = null;
        this.mContext = ServiceInitializer.getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clickPlayVideo(ViewHolder viewHolder) {
        if (!viewHolder.videoView.isPrepared()) {
            this.mIsVideoPlay = false;
            TUIChatLog.e(TAG, "!holder.videoView.isPrepared()");
            return;
        }
        if (viewHolder.videoView.isPlaying()) {
            TUIChatLog.d(TAG, "holder.videoView.isPlaying()");
            viewHolder.videoView.pause();
            viewHolder.playButton.setImageDrawable(androidx.core.content.a.getDrawable(this.mContext, R.drawable.ic_play_icon));
            viewHolder.pauseCenterView.setVisibility(0);
            viewHolder.loadingView.setVisibility(8);
            this.mIsVideoPlay = false;
            return;
        }
        if ((viewHolder.videoView.getDuration() * 1.0f) / 1000.0f <= 0.0f) {
            TUIChatLog.e(TAG, "onClick, downloading video");
            viewHolder.pauseCenterView.setVisibility(8);
            viewHolder.loadingView.setVisibility(0);
            resetVideo(viewHolder);
            return;
        }
        int round = Math.round((viewHolder.videoView.getDuration() * 1.0f) / 1000.0f);
        int round2 = Math.round((viewHolder.videoView.getCurrentPosition() * 1.0f) / 1000.0f);
        String str = TAG;
        TUIChatLog.d(str, "onClick playSeekBar duration == " + round + " playSeekBar progress = " + round2);
        if (viewHolder.playSeekBar.getProgress() >= round) {
            TUIChatLog.e(str, "getProgress() >= duration");
            resetVideo(viewHolder);
            return;
        }
        viewHolder.videoView.start();
        viewHolder.playButton.setImageDrawable(androidx.core.content.a.getDrawable(this.mContext, R.drawable.ic_pause_icon));
        viewHolder.pauseCenterView.setVisibility(8);
        viewHolder.loadingView.setVisibility(8);
        viewHolder.snapImageView.setVisibility(8);
        this.mIsVideoPlay = true;
        viewHolder.playSeekBar.setMax(round);
        viewHolder.playSeekBar.setProgress(round2);
        viewHolder.timeEndView.setText(DateTimeUtil.formatSecondsTo00(round));
        Handler handler = this.durationHandler;
        if (handler != null) {
            handler.postDelayed(this.updateSeekBarTime, 100L);
        }
    }

    private TUIMessageBean getItem(int i) {
        List<TUIMessageBean> list = this.mDataSource;
        if (list != null && !list.isEmpty()) {
            return this.mDataSource.get(i);
        }
        return null;
    }

    private void getRoomVideo(final ViewHolder viewHolder, String str, final RoomVideoBean roomVideoBean, final boolean z, final int i) {
        roomVideoBean.downloadVideo(str, new RoomVideoBean.VideoDownloadCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanAdapter.16
            @Override // com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomVideoBean.VideoDownloadCallback
            public void onError(int i2, String str2) {
                ToastUtil.toastLongMessage(ServiceInitializer.getAppContext().getString(R.string.download_file_error) + i2 + "=" + str2);
                roomVideoBean.setStatus(6);
                ImageVideoScanAdapter.this.notifyItemChanged(i);
                viewHolder.downloadVideoFailed = true;
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomVideoBean.VideoDownloadCallback
            public void onProgress(long j, long j2) {
                TUIChatLog.i("downloadVideo progress current:", j + ", total:" + j2);
                viewHolder.downloadVideoFinished = false;
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomVideoBean.VideoDownloadCallback
            public void onSuccess() {
                viewHolder.pauseCenterView.setVisibility(0);
                viewHolder.loadingView.setVisibility(8);
                ImageVideoScanAdapter.this.notifyItemChanged(i);
                ViewHolder viewHolder2 = viewHolder;
                viewHolder2.downloadVideoFailed = false;
                viewHolder2.downloadVideoFinished = true;
                if (z) {
                    ImageVideoScanAdapter.this.playRoomVideo(viewHolder2, roomVideoBean);
                }
            }
        });
    }

    private void getVideo(final ViewHolder viewHolder, String str, final VideoMessageBean videoMessageBean, final boolean z, final int i) {
        videoMessageBean.downloadVideo(str, new VideoMessageBean.VideoDownloadCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanAdapter.17
            @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean.VideoDownloadCallback
            public void onError(int i2, String str2) {
                ToastUtil.toastLongMessage(ServiceInitializer.getAppContext().getString(R.string.download_file_error) + i2 + "=" + str2);
                videoMessageBean.setStatus(6);
                ImageVideoScanAdapter.this.notifyItemChanged(i);
                viewHolder.downloadVideoFailed = true;
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean.VideoDownloadCallback
            public void onProgress(long j, long j2) {
                TUIChatLog.i("downloadVideo progress current:", j + ", total:" + j2);
                viewHolder.downloadVideoFinished = false;
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean.VideoDownloadCallback
            public void onSuccess() {
                viewHolder.pauseCenterView.setVisibility(0);
                viewHolder.loadingView.setVisibility(8);
                ImageVideoScanAdapter.this.notifyItemChanged(i);
                ViewHolder viewHolder2 = viewHolder;
                viewHolder2.downloadVideoFailed = false;
                viewHolder2.downloadVideoFinished = true;
                if (z) {
                    ImageVideoScanAdapter.this.playVideo(viewHolder2, videoMessageBean);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadImageIntoView(ImageView imageView, Object obj) {
        Glide.with(ServiceInitializer.getAppContext()).p(obj).d().q0(new h().j(android.R.drawable.ic_menu_report_image)).D0(imageView);
    }

    private void loadPhotoView(final ViewHolder viewHolder, final ImageMessageBean imageMessageBean, int i) {
        List<ImageMessageBean.ImageBean> imageBeanList = imageMessageBean.getImageBeanList();
        String dataPath = imageMessageBean.getDataPath();
        String originImagePath = TUIChatUtils.getOriginImagePath(imageMessageBean);
        if (!TextUtils.isEmpty(originImagePath)) {
            dataPath = originImagePath;
        }
        boolean z = true;
        if (TextUtils.isEmpty(dataPath)) {
            int i2 = 0;
            while (true) {
                if (i2 >= imageBeanList.size()) {
                    break;
                }
                ImageMessageBean.ImageBean imageBean = imageBeanList.get(i2);
                if (imageBean.getType() == 1) {
                    final String generateImagePath = ImageUtil.generateImagePath(imageBean.getUUID(), 1);
                    imageBean.downloadImage(generateImagePath, new ImageMessageBean.ImageBean.ImageDownloadCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanAdapter.4
                        @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean.ImageBean.ImageDownloadCallback
                        public void onError(int i3, String str) {
                            TUIChatLog.e("MessageAdapter img getImage", i3 + ":" + str);
                        }

                        @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean.ImageBean.ImageDownloadCallback
                        public void onProgress(long j, long j2) {
                            TUIChatLog.i("downloadImage progress current:", j + ", total:" + j2);
                        }

                        @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean.ImageBean.ImageDownloadCallback
                        public void onSuccess() {
                            viewHolder.loadingView.setVisibility(8);
                            imageMessageBean.setDataPath(generateImagePath);
                            BackgroundTasks.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanAdapter.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ImageVideoScanAdapter.this.notifyDataSetChanged();
                                }
                            });
                        }
                    });
                    break;
                }
                i2++;
            }
        }
        V2TIMImageElem.V2TIMImage v2TIMImage = null;
        String str = null;
        for (int i3 = 0; i3 < imageBeanList.size(); i3++) {
            ImageMessageBean.ImageBean imageBean2 = imageBeanList.get(i3);
            if (imageBean2.getType() == 0) {
                v2TIMImage = imageBean2.getV2TIMImage();
            }
            if (imageBean2.getType() == 1) {
                str = ImageUtil.generateImagePath(imageBean2.getUUID(), 1);
            }
        }
        String originImagePath2 = TUIChatUtils.getOriginImagePath(imageMessageBean);
        if (originImagePath2 == null || v2TIMImage == null || TextUtils.isEmpty(originImagePath2) || v2TIMImage.getSize() != FileUtil.getFileSize(originImagePath2)) {
            z = false;
        }
        if (z) {
            str = originImagePath2;
        }
        if (FileUtil.getUriFromPath(str) != null) {
            viewHolder.loadingView.setVisibility(8);
        }
        viewHolder.photoView.setDisplayMatrix(new Matrix());
        viewHolder.photoView.setOnMatrixChangeListener(new MatrixChangeListener());
        viewHolder.photoView.setOnPhotoTapListener(new PhotoTapListener());
        viewHolder.photoView.setOnSingleFlingListener(new SingleFlingListener());
        loadImageIntoView(viewHolder.photoView, str);
        if (!z) {
            viewHolder.viewOriginalButton.setOnClickListener(new AnonymousClass5(v2TIMImage, viewHolder));
            if (!TextUtils.isEmpty(originImagePath2)) {
                loadImageIntoView(viewHolder.photoView, originImagePath2);
                return;
            } else {
                viewHolder.viewOriginalButton.setVisibility(0);
                viewHolder.viewOriginalButton.setText(R.string.view_original_image);
                return;
            }
        }
        viewHolder.viewOriginalButton.setVisibility(4);
    }

    private void loadRoomPhotoView(final ViewHolder viewHolder, final RoomImageBean roomImageBean, int i) {
        List<RoomImageBean.ImageBean> imageBeanList = roomImageBean.getImageBeanList();
        String dataPath = roomImageBean.getDataPath();
        String originImagePath = TUIChatUtils.getOriginImagePath(roomImageBean);
        if (!TextUtils.isEmpty(originImagePath)) {
            dataPath = originImagePath;
        }
        boolean z = true;
        if (TextUtils.isEmpty(dataPath)) {
            int i2 = 0;
            while (true) {
                if (i2 >= imageBeanList.size()) {
                    break;
                }
                RoomImageBean.ImageBean imageBean = imageBeanList.get(i2);
                if (imageBean.getType() == 1) {
                    final String generateImagePath = ImageUtil.generateImagePath(imageBean.getUUID(), 1);
                    imageBean.downloadImage(generateImagePath, new RoomImageBean.ImageBean.ImageDownloadCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanAdapter.2
                        @Override // com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomImageBean.ImageBean.ImageDownloadCallback
                        public void onError(int i3, String str) {
                            TUIChatLog.e("MessageAdapter img getImage", i3 + ":" + str);
                        }

                        @Override // com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomImageBean.ImageBean.ImageDownloadCallback
                        public void onProgress(long j, long j2) {
                            TUIChatLog.i("downloadImage progress current:", j + ", total:" + j2);
                        }

                        @Override // com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomImageBean.ImageBean.ImageDownloadCallback
                        public void onSuccess() {
                            viewHolder.loadingView.setVisibility(8);
                            roomImageBean.setDataPath(generateImagePath);
                            BackgroundTasks.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanAdapter.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ImageVideoScanAdapter.this.notifyDataSetChanged();
                                }
                            });
                        }
                    });
                    break;
                }
                i2++;
            }
        }
        V2TIMImageElem.V2TIMImage v2TIMImage = null;
        String str = null;
        for (int i3 = 0; i3 < imageBeanList.size(); i3++) {
            RoomImageBean.ImageBean imageBean2 = imageBeanList.get(i3);
            if (imageBean2.getType() == 0) {
                v2TIMImage = imageBean2.getV2TIMImage();
            }
            if (imageBean2.getType() == 1) {
                str = ImageUtil.generateImagePath(imageBean2.getUUID(), 1);
            }
        }
        String originImagePath2 = TUIChatUtils.getOriginImagePath(roomImageBean);
        if (originImagePath2 == null || v2TIMImage == null || TextUtils.isEmpty(originImagePath2) || v2TIMImage.getSize() != FileUtil.getFileSize(originImagePath2)) {
            z = false;
        }
        if (z) {
            str = originImagePath2;
        }
        if (FileUtil.getUriFromPath(str) != null) {
            viewHolder.loadingView.setVisibility(8);
        }
        viewHolder.photoView.setDisplayMatrix(new Matrix());
        viewHolder.photoView.setOnMatrixChangeListener(new MatrixChangeListener());
        viewHolder.photoView.setOnPhotoTapListener(new PhotoTapListener());
        viewHolder.photoView.setOnSingleFlingListener(new SingleFlingListener());
        loadImageIntoView(viewHolder.photoView, str);
        if (!z) {
            viewHolder.viewOriginalButton.setOnClickListener(new AnonymousClass3(v2TIMImage, viewHolder));
            if (!TextUtils.isEmpty(originImagePath2)) {
                loadImageIntoView(viewHolder.photoView, originImagePath2);
                return;
            } else {
                viewHolder.viewOriginalButton.setVisibility(0);
                viewHolder.viewOriginalButton.setText(R.string.view_original_image);
                return;
            }
        }
        viewHolder.viewOriginalButton.setVisibility(4);
    }

    private void loadRoomVideoView(final ViewHolder viewHolder, final RoomVideoBean roomVideoBean, int i) {
        if (TextUtils.isEmpty(roomVideoBean.getDataPath())) {
            final String str = TUIConfig.getImageDownloadDir() + roomVideoBean.getSnapshotUUID();
            roomVideoBean.downloadSnapshot(str, new RoomVideoBean.VideoDownloadCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanAdapter.6
                @Override // com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomVideoBean.VideoDownloadCallback
                public void onError(int i2, String str2) {
                    TUIChatLog.e("MessageAdapter video getImage", i2 + ":" + str2);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomVideoBean.VideoDownloadCallback
                public void onProgress(long j, long j2) {
                    TUIChatLog.i("downloadSnapshot progress current:", j + ", total:" + j2);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomVideoBean.VideoDownloadCallback
                public void onSuccess() {
                    viewHolder.pauseCenterView.setVisibility(0);
                    viewHolder.loadingView.setVisibility(8);
                    roomVideoBean.setDataPath(str);
                    ImageVideoScanAdapter.this.mCacheImagePath = str;
                    viewHolder.snapImageView.setVisibility(0);
                    ImageVideoScanAdapter.this.loadImageIntoView(viewHolder.snapImageView, str);
                    Bitmap bitmapFormPath = ImageUtil.getBitmapFormPath(str);
                    if (bitmapFormPath != null) {
                        ImageVideoScanAdapter.this.updateVideoView(viewHolder, bitmapFormPath.getWidth(), bitmapFormPath.getHeight());
                    }
                }
            });
        } else {
            String dataPath = roomVideoBean.getDataPath();
            viewHolder.snapImageView.setVisibility(0);
            loadImageIntoView(viewHolder.snapImageView, dataPath);
            updateVideoViewSize(viewHolder, dataPath);
        }
        if (roomVideoBean.getStatus() == 1) {
            ToastUtil.toastShortMessage(this.mContext.getString(R.string.sending));
            return;
        }
        if (roomVideoBean.getStatus() == 3) {
            ToastUtil.toastShortMessage(this.mContext.getString(R.string.send_failed));
            viewHolder.loadingView.setVisibility(8);
            return;
        }
        String str2 = TUIConfig.getVideoDownloadDir() + roomVideoBean.getVideoUUID();
        File file = new File(str2);
        if (file.exists() && roomVideoBean.getVideoSize() == file.length()) {
            playRoomVideo(viewHolder, roomVideoBean);
        } else if (!viewHolder.downloadVideoFailed && !viewHolder.downloadVideoFinished) {
            getRoomVideo(viewHolder, str2, roomVideoBean, true, i);
        }
    }

    private void loadVideoView(final ViewHolder viewHolder, final VideoMessageBean videoMessageBean, int i) {
        if (TextUtils.isEmpty(videoMessageBean.getDataPath())) {
            final String str = TUIConfig.getImageDownloadDir() + videoMessageBean.getSnapshotUUID();
            videoMessageBean.downloadSnapshot(str, new VideoMessageBean.VideoDownloadCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanAdapter.7
                @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean.VideoDownloadCallback
                public void onError(int i2, String str2) {
                    TUIChatLog.e("MessageAdapter video getImage", i2 + ":" + str2);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean.VideoDownloadCallback
                public void onProgress(long j, long j2) {
                    TUIChatLog.i("downloadSnapshot progress current:", j + ", total:" + j2);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean.VideoDownloadCallback
                public void onSuccess() {
                    viewHolder.pauseCenterView.setVisibility(0);
                    viewHolder.loadingView.setVisibility(8);
                    videoMessageBean.setDataPath(str);
                    ImageVideoScanAdapter.this.mCacheImagePath = str;
                    viewHolder.snapImageView.setVisibility(0);
                    ImageVideoScanAdapter.this.loadImageIntoView(viewHolder.snapImageView, str);
                    Bitmap bitmapFormPath = ImageUtil.getBitmapFormPath(str);
                    if (bitmapFormPath != null) {
                        ImageVideoScanAdapter.this.updateVideoView(viewHolder, bitmapFormPath.getWidth(), bitmapFormPath.getHeight());
                    }
                }
            });
        } else {
            String dataPath = videoMessageBean.getDataPath();
            viewHolder.snapImageView.setVisibility(0);
            loadImageIntoView(viewHolder.snapImageView, dataPath);
            updateVideoViewSize(viewHolder, dataPath);
        }
        if (videoMessageBean.getStatus() == 1) {
            ToastUtil.toastShortMessage(this.mContext.getString(R.string.sending));
            return;
        }
        if (videoMessageBean.getStatus() == 3) {
            ToastUtil.toastShortMessage(this.mContext.getString(R.string.send_failed));
            viewHolder.loadingView.setVisibility(8);
            return;
        }
        String str2 = TUIConfig.getVideoDownloadDir() + videoMessageBean.getVideoUUID();
        File file = new File(str2);
        if (file.exists() && videoMessageBean.getVideoSize() == file.length()) {
            playVideo(viewHolder, videoMessageBean);
        } else if (!viewHolder.downloadVideoFailed && !viewHolder.downloadVideoFinished) {
            getVideo(viewHolder, str2, videoMessageBean, true, i);
        }
    }

    private void performPhotoView(ViewHolder viewHolder, TUIMessageBean tUIMessageBean, int i) {
        viewHolder.photoViewLayout.setVisibility(0);
        viewHolder.videoView.setVisibility(8);
        viewHolder.closeButton.setVisibility(8);
        viewHolder.playControlLayout.setVisibility(8);
        viewHolder.pauseCenterView.setVisibility(8);
        viewHolder.loadingView.setVisibility(0);
        viewHolder.videoViewLayout.setVisibility(8);
        if (tUIMessageBean instanceof ImageMessageBean) {
            loadPhotoView(viewHolder, (ImageMessageBean) tUIMessageBean, i);
        } else if (tUIMessageBean instanceof RoomImageBean) {
            loadRoomPhotoView(viewHolder, (RoomImageBean) tUIMessageBean, i);
        } else {
            TUIChatLog.e(TAG, "is not ImageMessageBean");
        }
    }

    private void performVideoView(ViewHolder viewHolder, TUIMessageBean tUIMessageBean, int i) {
        viewHolder.photoViewLayout.setVisibility(8);
        viewHolder.videoView.setVisibility(0);
        viewHolder.closeButton.setVisibility(0);
        viewHolder.playControlLayout.setVisibility(0);
        viewHolder.pauseCenterView.setVisibility(8);
        viewHolder.loadingView.setVisibility(0);
        viewHolder.videoViewLayout.setVisibility(0);
        if (tUIMessageBean instanceof VideoMessageBean) {
            this.mIsVideoPlay = false;
            playControlInit(viewHolder);
            loadVideoView(viewHolder, (VideoMessageBean) tUIMessageBean, i);
        } else {
            if (tUIMessageBean instanceof RoomVideoBean) {
                this.mIsVideoPlay = false;
                playControlInit(viewHolder);
                loadRoomVideoView(viewHolder, (RoomVideoBean) tUIMessageBean, i);
                return;
            }
            TUIChatLog.e(TAG, "is not VideoMessageBean");
        }
    }

    private void playControlInit(final ViewHolder viewHolder) {
        viewHolder.closeButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanAdapter.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UIKitVideoView uIKitVideoView = viewHolder.videoView;
                if (uIKitVideoView != null) {
                    uIKitVideoView.stop();
                } else {
                    TUIChatLog.e(ImageVideoScanAdapter.TAG, "videoView is null");
                }
                ImageVideoScanAdapter.this.onItemClickListener.onClickItem();
            }
        });
        viewHolder.playButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanAdapter.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ImageVideoScanAdapter.this.clickPlayVideo(viewHolder);
            }
        });
        viewHolder.playSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanAdapter.10
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                viewHolder.timeBeginView.setText(DateTimeUtil.formatSecondsTo00(i));
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                int progress = seekBar.getProgress();
                TUIChatLog.i(ImageVideoScanAdapter.TAG, "onStartTrackingTouch progress == " + progress);
                UIKitVideoView uIKitVideoView = viewHolder.videoView;
                if (uIKitVideoView != null) {
                    uIKitVideoView.seekTo(progress * 1000);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                int progress = seekBar.getProgress();
                TUIChatLog.i(ImageVideoScanAdapter.TAG, "onStopTrackingTouch progress == " + progress);
                UIKitVideoView uIKitVideoView = viewHolder.videoView;
                if (uIKitVideoView != null && uIKitVideoView.isPlaying()) {
                    viewHolder.videoView.seekTo(progress * 1000);
                    viewHolder.videoView.start();
                } else {
                    UIKitVideoView uIKitVideoView2 = viewHolder.videoView;
                    if (uIKitVideoView2 != null) {
                        uIKitVideoView2.seekTo(progress * 1000);
                    }
                }
            }
        });
        viewHolder.pauseCenterView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanAdapter.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ImageVideoScanAdapter.this.clickPlayVideo(viewHolder);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playRoomVideo(final ViewHolder viewHolder, final RoomVideoBean roomVideoBean) {
        Uri processRoomVideoMessage = processRoomVideoMessage(roomVideoBean);
        viewHolder.pauseCenterView.setVisibility(0);
        viewHolder.loadingView.setVisibility(8);
        if (processRoomVideoMessage == null) {
            TUIChatLog.e(TAG, "playVideo videoUri == null");
            return;
        }
        viewHolder.videoView.setVideoURI(processRoomVideoMessage);
        viewHolder.videoView.setOnPreparedListener(new IPlayer.OnPreparedListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanAdapter.12
            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.component.video.proxy.IPlayer.OnPreparedListener
            public void onPrepared(IPlayer iPlayer) {
                TUIChatLog.e(ImageVideoScanAdapter.TAG, "onPrepared()");
                viewHolder.videoView.start();
                viewHolder.videoView.pause();
                viewHolder.playButton.setImageDrawable(androidx.core.content.a.getDrawable(ImageVideoScanAdapter.this.mContext, R.drawable.ic_play_icon));
                viewHolder.pauseCenterView.setVisibility(0);
                viewHolder.loadingView.setVisibility(8);
                ImageVideoScanAdapter.this.updateVideoViewSize(viewHolder, roomVideoBean.getDataPath());
                ImageVideoScanAdapter.this.mIsVideoPlay = false;
                if (ImageVideoScanAdapter.this.durationHandler != null) {
                    ImageVideoScanAdapter.this.durationHandler = null;
                }
                if (ImageVideoScanAdapter.this.updateSeekBarTime != null) {
                    ImageVideoScanAdapter.this.updateSeekBarTime = null;
                }
                ImageVideoScanAdapter.this.durationHandler = new Handler();
                ImageVideoScanAdapter.this.updateSeekBarTime = new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanAdapter.12.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int currentPosition = viewHolder.videoView.getCurrentPosition();
                        if (viewHolder.playSeekBar.getProgress() >= viewHolder.playSeekBar.getMax()) {
                            TUIChatLog.e(ImageVideoScanAdapter.TAG, "getProgress() >= getMax()");
                            AnonymousClass12 anonymousClass12 = AnonymousClass12.this;
                            ImageVideoScanAdapter.this.resetVideo(viewHolder);
                        } else {
                            viewHolder.playSeekBar.setProgress(Math.round((currentPosition * 1.0f) / 1000.0f));
                            viewHolder.timeBeginView.setText(DateTimeUtil.formatSecondsTo00(Math.round((viewHolder.videoView.getCurrentPosition() * 1.0f) / 1000.0f)));
                            if (ImageVideoScanAdapter.this.mIsVideoPlay) {
                                ImageVideoScanAdapter.this.durationHandler.postDelayed(this, 100L);
                            }
                        }
                    }
                };
                int round = Math.round((iPlayer.getDuration() * 1.0f) / 1000.0f);
                int round2 = Math.round((iPlayer.getCurrentPosition() * 1.0f) / 1000.0f);
                viewHolder.playSeekBar.setMax(round);
                viewHolder.playSeekBar.setProgress(round2);
                viewHolder.timeEndView.setText(DateTimeUtil.formatSecondsTo00(round));
                ImageVideoScanAdapter.this.durationHandler.postDelayed(ImageVideoScanAdapter.this.updateSeekBarTime, 100L);
            }
        });
        viewHolder.videoView.setOnSeekCompleteListener(new IPlayer.OnSeekCompleteListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanAdapter.13
            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.component.video.proxy.IPlayer.OnSeekCompleteListener
            public void OnSeekComplete(IPlayer iPlayer) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playVideo(final ViewHolder viewHolder, final VideoMessageBean videoMessageBean) {
        Uri processVideoMessage = processVideoMessage(videoMessageBean);
        viewHolder.pauseCenterView.setVisibility(0);
        viewHolder.loadingView.setVisibility(8);
        if (processVideoMessage == null) {
            TUIChatLog.e(TAG, "playVideo videoUri == null");
            return;
        }
        viewHolder.videoView.setVideoURI(processVideoMessage);
        viewHolder.videoView.setOnPreparedListener(new IPlayer.OnPreparedListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanAdapter.14
            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.component.video.proxy.IPlayer.OnPreparedListener
            public void onPrepared(IPlayer iPlayer) {
                TUIChatLog.e(ImageVideoScanAdapter.TAG, "onPrepared()");
                viewHolder.videoView.start();
                viewHolder.videoView.pause();
                viewHolder.playButton.setImageDrawable(androidx.core.content.a.getDrawable(ImageVideoScanAdapter.this.mContext, R.drawable.ic_play_icon));
                viewHolder.pauseCenterView.setVisibility(0);
                viewHolder.loadingView.setVisibility(8);
                ImageVideoScanAdapter.this.updateVideoViewSize(viewHolder, videoMessageBean.getDataPath());
                ImageVideoScanAdapter.this.mIsVideoPlay = false;
                if (ImageVideoScanAdapter.this.durationHandler != null) {
                    ImageVideoScanAdapter.this.durationHandler = null;
                }
                if (ImageVideoScanAdapter.this.updateSeekBarTime != null) {
                    ImageVideoScanAdapter.this.updateSeekBarTime = null;
                }
                ImageVideoScanAdapter.this.durationHandler = new Handler();
                ImageVideoScanAdapter.this.updateSeekBarTime = new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanAdapter.14.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int currentPosition = viewHolder.videoView.getCurrentPosition();
                        if (viewHolder.playSeekBar.getProgress() >= viewHolder.playSeekBar.getMax()) {
                            TUIChatLog.e(ImageVideoScanAdapter.TAG, "getProgress() >= getMax()");
                            AnonymousClass14 anonymousClass14 = AnonymousClass14.this;
                            ImageVideoScanAdapter.this.resetVideo(viewHolder);
                        } else {
                            viewHolder.playSeekBar.setProgress(Math.round((currentPosition * 1.0f) / 1000.0f));
                            viewHolder.timeBeginView.setText(DateTimeUtil.formatSecondsTo00(Math.round((viewHolder.videoView.getCurrentPosition() * 1.0f) / 1000.0f)));
                            if (ImageVideoScanAdapter.this.mIsVideoPlay) {
                                ImageVideoScanAdapter.this.durationHandler.postDelayed(this, 100L);
                            }
                        }
                    }
                };
                int round = Math.round((iPlayer.getDuration() * 1.0f) / 1000.0f);
                int round2 = Math.round((iPlayer.getCurrentPosition() * 1.0f) / 1000.0f);
                viewHolder.playSeekBar.setMax(round);
                viewHolder.playSeekBar.setProgress(round2);
                viewHolder.timeEndView.setText(DateTimeUtil.formatSecondsTo00(round));
                ImageVideoScanAdapter.this.durationHandler.postDelayed(ImageVideoScanAdapter.this.updateSeekBarTime, 100L);
            }
        });
        viewHolder.videoView.setOnSeekCompleteListener(new IPlayer.OnSeekCompleteListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanAdapter.15
            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.component.video.proxy.IPlayer.OnSeekCompleteListener
            public void OnSeekComplete(IPlayer iPlayer) {
            }
        });
    }

    private Uri processRoomVideoMessage(RoomVideoBean roomVideoBean) {
        V2TIMMessage v2TIMMessage = roomVideoBean.getV2TIMMessage();
        V2TIMVideoElem videoElem = v2TIMMessage.getVideoElem();
        if (v2TIMMessage.isSelf() && !TextUtils.isEmpty(videoElem.getSnapshotPath())) {
            return FileUtil.getUriFromPath(videoElem.getVideoPath());
        }
        return Uri.parse(TUIConfig.getVideoDownloadDir() + videoElem.getVideoUUID());
    }

    private Uri processVideoMessage(VideoMessageBean videoMessageBean) {
        V2TIMMessage v2TIMMessage = videoMessageBean.getV2TIMMessage();
        V2TIMVideoElem videoElem = v2TIMMessage.getVideoElem();
        if (v2TIMMessage.isSelf() && !TextUtils.isEmpty(videoElem.getSnapshotPath())) {
            return FileUtil.getUriFromPath(videoElem.getVideoPath());
        }
        return Uri.parse(TUIConfig.getVideoDownloadDir() + videoElem.getVideoUUID());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVideoView(ViewHolder viewHolder, int i, int i2) {
        int max;
        int min;
        String str = TAG;
        TUIChatLog.i(str, "updateVideoView videoWidth: " + i + " videoHeight: " + i2);
        if (i <= 0 && i2 <= 0) {
            return;
        }
        if (this.mContext.getResources().getConfiguration().orientation == 1) {
            max = Math.min(ScreenUtil.getScreenWidth(this.mContext), ScreenUtil.getScreenHeight(this.mContext));
            min = Math.max(ScreenUtil.getScreenWidth(this.mContext), ScreenUtil.getScreenHeight(this.mContext));
        } else {
            max = Math.max(ScreenUtil.getScreenWidth(this.mContext), ScreenUtil.getScreenHeight(this.mContext));
            min = Math.min(ScreenUtil.getScreenWidth(this.mContext), ScreenUtil.getScreenHeight(this.mContext));
        }
        int[] scaledSize = ScreenUtil.scaledSize(max, min, i, i2);
        TUIChatLog.i(str, "scaled width: " + scaledSize[0] + " height: " + scaledSize[1]);
        ViewGroup.LayoutParams layoutParams = viewHolder.videoView.getLayoutParams();
        layoutParams.width = scaledSize[0];
        layoutParams.height = scaledSize[1];
        viewHolder.videoView.setLayoutParams(layoutParams);
        if (viewHolder.snapImageView.getVisibility() == 0) {
            viewHolder.snapImageView.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVideoViewSize(ViewHolder viewHolder, String str) {
        Bitmap bitmapFormPath;
        String str2 = this.mCacheImagePath;
        if ((str2 == null || !str2.equals(str)) && (bitmapFormPath = ImageUtil.getBitmapFormPath(str)) != null) {
            updateVideoView(viewHolder, bitmapFormPath.getWidth(), bitmapFormPath.getHeight());
        }
    }

    public int addDataToSource(List<TUIMessageBean> list, int i, int i2) {
        if (list != null && !list.isEmpty()) {
            List<TUIMessageBean> list2 = this.mDataSource;
            if (list2 == null) {
                TUIChatLog.e(TAG, "addDataToSource mDataSource is null");
                return i2;
            }
            TUIMessageBean tUIMessageBean = list2.get(i2);
            if (i == 0) {
                this.mOldLocateMessage = list.get(0);
                Log.d(TAG, "mOldLocateMessage seq:" + this.mOldLocateMessage.getV2TIMMessage().getSeq());
                this.mDataSource.addAll(0, list);
                i2 = list.size();
            } else if (i == 1) {
                this.mNewLocateMessage = list.get(list.size() - 1);
                Log.d(TAG, "mNewLocateMessage seq:" + this.mNewLocateMessage.getV2TIMMessage().getSeq());
                this.mDataSource.addAll(list);
            } else {
                TUIChatLog.e(TAG, "addDataToSource error type");
            }
            for (TUIMessageBean tUIMessageBean2 : this.mDataSource) {
                TUIChatLog.d(TAG, "message seq = " + tUIMessageBean2.getV2TIMMessage().getSeq());
            }
            if (tUIMessageBean == null) {
                TUIChatLog.e(TAG, "messageBean == null");
            }
        }
        return i2;
    }

    public void destroyView(RecyclerView recyclerView, int i) {
        View childAt = recyclerView.getChildAt(i);
        if (childAt != null) {
            UIKitVideoView uIKitVideoView = (UIKitVideoView) childAt.findViewById(R.id.video_play_view);
            SeekBar seekBar = (SeekBar) childAt.findViewById(R.id.play_seek);
            if (uIKitVideoView != null) {
                uIKitVideoView.stop();
            }
            if (seekBar != null) {
                seekBar.setProgress(0);
            }
        }
        if (this.downloadReceiver != null) {
            b3.a.b(this.mContext).e(this.downloadReceiver);
            this.downloadReceiver = null;
        }
    }

    public List<TUIMessageBean> getDataSource() {
        return this.mDataSource;
    }

    public int getItemCount() {
        return this.mDataSource.size();
    }

    public TUIMessageBean getNewLocateMessage() {
        return this.mNewLocateMessage;
    }

    public TUIMessageBean getOldLocateMessage() {
        return this.mOldLocateMessage;
    }

    public void onDataChanged(TUIMessageBean tUIMessageBean) {
        Iterator<TUIMessageBean> it = this.mDataSource.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TUIMessageBean next = it.next();
            if (TextUtils.equals(tUIMessageBean.getId(), next.getId())) {
                next.update(tUIMessageBean);
                break;
            }
        }
        notifyDataSetChanged();
    }

    public void resetVideo(ViewHolder viewHolder) {
        viewHolder.videoView.stop();
        viewHolder.videoView.resetVideo();
        viewHolder.playButton.setImageDrawable(androidx.core.content.a.getDrawable(this.mContext, R.drawable.ic_play_icon));
        viewHolder.pauseCenterView.setVisibility(0);
        viewHolder.snapImageView.setVisibility(8);
        viewHolder.loadingView.setVisibility(8);
        viewHolder.playSeekBar.setProgress(0);
        this.mIsVideoPlay = false;
        viewHolder.timeBeginView.setText(DateTimeUtil.formatSecondsTo00(0));
    }

    public void setDataSource(List<TUIMessageBean> list) {
        if (list != null && !list.isEmpty()) {
            this.mOldLocateMessage = list.get(0);
            this.mNewLocateMessage = list.get(list.size() - 1);
        } else {
            TUIChatLog.d(TAG, "setDataSource dataSource is Empty");
            this.mOldLocateMessage = null;
            this.mNewLocateMessage = null;
        }
        this.mDataSource = list;
        for (TUIMessageBean tUIMessageBean : list) {
            TUIChatLog.d(TAG, "message seq = " + tUIMessageBean.getV2TIMMessage().getSeq());
        }
        String str = TAG;
        Log.d(str, "mOldLocateMessage seq:" + this.mOldLocateMessage.getV2TIMMessage().getSeq());
        Log.d(str, "mNewLocateMessage seq:" + this.mNewLocateMessage.getV2TIMMessage().getSeq());
    }

    public void setOnItemClickListener(ImageVideoScanActivity.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        TUIMessageBean item = getItem(i);
        if (item == null) {
            return;
        }
        viewHolder.playSeekBar.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanAdapter.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        V2TIMMessage v2TIMMessage = item.getV2TIMMessage();
        if (v2TIMMessage.getElemType() == 3) {
            performPhotoView(viewHolder, item, i);
        } else if (v2TIMMessage.getElemType() == 5) {
            performVideoView(viewHolder, item, i);
        } else {
            TUIChatLog.d(TAG, "error message type");
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.image_video_scan_item, viewGroup, false));
    }
}
