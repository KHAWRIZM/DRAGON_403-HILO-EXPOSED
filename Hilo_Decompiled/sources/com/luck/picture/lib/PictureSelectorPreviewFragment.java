package com.luck.picture.lib;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.a;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.luck.picture.lib.adapter.PicturePreviewAdapter;
import com.luck.picture.lib.adapter.holder.BasePreviewHolder;
import com.luck.picture.lib.adapter.holder.PreviewGalleryAdapter;
import com.luck.picture.lib.adapter.holder.PreviewVideoHolder;
import com.luck.picture.lib.basic.IBridgeLoaderFactory;
import com.luck.picture.lib.basic.PictureCommonFragment;
import com.luck.picture.lib.basic.PictureMediaScannerConnection;
import com.luck.picture.lib.config.Crop;
import com.luck.picture.lib.config.InjectResourceSource;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.decoration.HorizontalItemDecoration;
import com.luck.picture.lib.decoration.WrapContentLinearLayoutManager;
import com.luck.picture.lib.dialog.PictureCommonDialog;
import com.luck.picture.lib.engine.ExtendLoaderEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.MediaExtraInfo;
import com.luck.picture.lib.interfaces.OnCallbackListener;
import com.luck.picture.lib.interfaces.OnExternalPreviewEventListener;
import com.luck.picture.lib.interfaces.OnQueryDataResultListener;
import com.luck.picture.lib.loader.IBridgeMediaLoader;
import com.luck.picture.lib.loader.LocalMediaLoader;
import com.luck.picture.lib.loader.LocalMediaPageLoader;
import com.luck.picture.lib.magical.BuildRecycleItemViewParams;
import com.luck.picture.lib.magical.MagicalView;
import com.luck.picture.lib.magical.OnMagicalViewCallback;
import com.luck.picture.lib.magical.ViewParams;
import com.luck.picture.lib.style.PictureWindowAnimationStyle;
import com.luck.picture.lib.style.SelectMainStyle;
import com.luck.picture.lib.utils.ActivityCompatHelper;
import com.luck.picture.lib.utils.DensityUtil;
import com.luck.picture.lib.utils.DownloadFileUtils;
import com.luck.picture.lib.utils.MediaUtils;
import com.luck.picture.lib.utils.SdkVersionUtils;
import com.luck.picture.lib.utils.StyleUtils;
import com.luck.picture.lib.utils.ToastUtils;
import com.luck.picture.lib.utils.ValueOf;
import com.luck.picture.lib.widget.BottomNavBar;
import com.luck.picture.lib.widget.CompleteSelectView;
import com.luck.picture.lib.widget.PreviewBottomNavBar;
import com.luck.picture.lib.widget.PreviewTitleBar;
import com.luck.picture.lib.widget.TitleBar;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class PictureSelectorPreviewFragment extends PictureCommonFragment {
    public static final String TAG = "PictureSelectorPreviewFragment";
    protected PreviewBottomNavBar bottomNarBar;
    protected CompleteSelectView completeSelectView;
    protected int curPosition;
    protected String currentAlbum;
    protected boolean isAnimationStart;
    protected boolean isDisplayDelete;
    protected boolean isExternalPreview;
    protected boolean isInternalBottomPreview;
    protected boolean isSaveInstanceState;
    protected boolean isShowCamera;
    protected PreviewGalleryAdapter mGalleryAdapter;
    protected RecyclerView mGalleryRecycle;
    protected MagicalView magicalView;
    protected int screenHeight;
    protected int screenWidth;
    protected View selectClickArea;
    protected PreviewTitleBar titleBar;
    protected int totalNum;
    protected TextView tvSelected;
    protected TextView tvSelectedWord;
    protected PicturePreviewAdapter viewPageAdapter;
    protected ViewPager2 viewPager;
    protected ArrayList<LocalMedia> mData = new ArrayList<>();
    protected boolean isHasMore = true;
    protected long mBucketId = -1;
    protected boolean needScaleBig = true;
    protected boolean needScaleSmall = false;
    protected List<View> mAnimViews = new ArrayList();
    private boolean isPause = false;
    private final ViewPager2.OnPageChangeCallback pageChangeCallback = new ViewPager2.OnPageChangeCallback() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.22
        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i10, float f10, int i11) {
            if (PictureSelectorPreviewFragment.this.mData.size() > i10) {
                PictureSelectorPreviewFragment pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.this;
                int i12 = pictureSelectorPreviewFragment.screenWidth / 2;
                ArrayList<LocalMedia> arrayList = pictureSelectorPreviewFragment.mData;
                if (i11 >= i12) {
                    i10++;
                }
                LocalMedia localMedia = arrayList.get(i10);
                PictureSelectorPreviewFragment pictureSelectorPreviewFragment2 = PictureSelectorPreviewFragment.this;
                pictureSelectorPreviewFragment2.tvSelected.setSelected(pictureSelectorPreviewFragment2.isSelected(localMedia));
                PictureSelectorPreviewFragment.this.notifyGallerySelectMedia(localMedia);
                PictureSelectorPreviewFragment.this.notifySelectNumberStyle(localMedia);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i10) {
            boolean z10;
            PictureSelectorPreviewFragment pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.this;
            pictureSelectorPreviewFragment.curPosition = i10;
            pictureSelectorPreviewFragment.titleBar.setTitle((PictureSelectorPreviewFragment.this.curPosition + 1) + "/" + PictureSelectorPreviewFragment.this.totalNum);
            if (PictureSelectorPreviewFragment.this.mData.size() > i10) {
                LocalMedia localMedia = PictureSelectorPreviewFragment.this.mData.get(i10);
                PictureSelectorPreviewFragment.this.notifySelectNumberStyle(localMedia);
                if (PictureSelectorPreviewFragment.this.isHasMagicalEffect()) {
                    PictureSelectorPreviewFragment.this.changeMagicalViewParams(i10);
                }
                if (((PictureCommonFragment) PictureSelectorPreviewFragment.this).selectorConfig.isPreviewZoomEffect) {
                    PictureSelectorPreviewFragment pictureSelectorPreviewFragment2 = PictureSelectorPreviewFragment.this;
                    if (pictureSelectorPreviewFragment2.isInternalBottomPreview && ((PictureCommonFragment) pictureSelectorPreviewFragment2).selectorConfig.isAutoVideoPlay) {
                        PictureSelectorPreviewFragment.this.startAutoVideoPlay(i10);
                    } else {
                        PictureSelectorPreviewFragment.this.viewPageAdapter.setVideoPlayButtonUI(i10);
                    }
                } else if (((PictureCommonFragment) PictureSelectorPreviewFragment.this).selectorConfig.isAutoVideoPlay) {
                    PictureSelectorPreviewFragment.this.startAutoVideoPlay(i10);
                }
                PictureSelectorPreviewFragment.this.notifyGallerySelectMedia(localMedia);
                PreviewBottomNavBar previewBottomNavBar = PictureSelectorPreviewFragment.this.bottomNarBar;
                if (!PictureMimeType.isHasVideo(localMedia.getMimeType()) && !PictureMimeType.isHasAudio(localMedia.getMimeType())) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                previewBottomNavBar.isDisplayEditor(z10);
                PictureSelectorPreviewFragment pictureSelectorPreviewFragment3 = PictureSelectorPreviewFragment.this;
                if (!pictureSelectorPreviewFragment3.isExternalPreview && !pictureSelectorPreviewFragment3.isInternalBottomPreview && !((PictureCommonFragment) pictureSelectorPreviewFragment3).selectorConfig.isOnlySandboxDir && ((PictureCommonFragment) PictureSelectorPreviewFragment.this).selectorConfig.isPageStrategy) {
                    if (PictureSelectorPreviewFragment.this.isHasMore) {
                        if (i10 == r0.viewPageAdapter.getItemCount() - 11 || i10 == PictureSelectorPreviewFragment.this.viewPageAdapter.getItemCount() - 1) {
                            PictureSelectorPreviewFragment.this.loadMoreData();
                        }
                    }
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class MyOnPreviewEventListener implements BasePreviewHolder.OnPreviewEventListener {
        private MyOnPreviewEventListener() {
        }

        @Override // com.luck.picture.lib.adapter.holder.BasePreviewHolder.OnPreviewEventListener
        public void onBackPressed() {
            if (((PictureCommonFragment) PictureSelectorPreviewFragment.this).selectorConfig.isPreviewFullScreenMode) {
                PictureSelectorPreviewFragment.this.previewFullScreenMode();
                return;
            }
            PictureSelectorPreviewFragment pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.this;
            if (pictureSelectorPreviewFragment.isExternalPreview) {
                if (!((PictureCommonFragment) pictureSelectorPreviewFragment).selectorConfig.isPreviewZoomEffect) {
                    PictureSelectorPreviewFragment.this.handleExternalPreviewBack();
                    return;
                } else {
                    PictureSelectorPreviewFragment.this.magicalView.backToMin();
                    return;
                }
            }
            if (pictureSelectorPreviewFragment.isInternalBottomPreview || !((PictureCommonFragment) pictureSelectorPreviewFragment).selectorConfig.isPreviewZoomEffect) {
                PictureSelectorPreviewFragment.this.onBackCurrentFragment();
            } else {
                PictureSelectorPreviewFragment.this.magicalView.backToMin();
            }
        }

        @Override // com.luck.picture.lib.adapter.holder.BasePreviewHolder.OnPreviewEventListener
        public void onLongPressDownload(LocalMedia localMedia) {
            if (((PictureCommonFragment) PictureSelectorPreviewFragment.this).selectorConfig.isHidePreviewDownload) {
                return;
            }
            PictureSelectorPreviewFragment pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.this;
            if (pictureSelectorPreviewFragment.isExternalPreview) {
                pictureSelectorPreviewFragment.onExternalLongPressDownload(localMedia);
            }
        }

        @Override // com.luck.picture.lib.adapter.holder.BasePreviewHolder.OnPreviewEventListener
        public void onPreviewVideoTitle(String str) {
            if (TextUtils.isEmpty(str)) {
                PictureSelectorPreviewFragment.this.titleBar.setTitle((PictureSelectorPreviewFragment.this.curPosition + 1) + "/" + PictureSelectorPreviewFragment.this.totalNum);
                return;
            }
            PictureSelectorPreviewFragment.this.titleBar.setTitle(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeMagicalViewParams(final int i10) {
        LocalMedia localMedia = this.mData.get(i10);
        if (PictureMimeType.isHasVideo(localMedia.getMimeType())) {
            getVideoRealSizeFromMedia(localMedia, false, new OnCallbackListener<int[]>() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.24
                @Override // com.luck.picture.lib.interfaces.OnCallbackListener
                public void onCall(int[] iArr) {
                    PictureSelectorPreviewFragment.this.setMagicalViewParams(iArr[0], iArr[1], i10);
                }
            });
        } else {
            getImageRealSizeFromMedia(localMedia, false, new OnCallbackListener<int[]>() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.25
                @Override // com.luck.picture.lib.interfaces.OnCallbackListener
                public void onCall(int[] iArr) {
                    PictureSelectorPreviewFragment.this.setMagicalViewParams(iArr[0], iArr[1], i10);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeViewParams(int[] iArr) {
        int i10;
        int i11;
        int i12;
        if (this.isShowCamera) {
            i10 = this.curPosition + 1;
        } else {
            i10 = this.curPosition;
        }
        ViewParams itemViewParams = BuildRecycleItemViewParams.getItemViewParams(i10);
        if (itemViewParams != null && (i11 = iArr[0]) != 0 && (i12 = iArr[1]) != 0) {
            this.magicalView.setViewParams(itemViewParams.left, itemViewParams.top, itemViewParams.width, itemViewParams.height, i11, i12);
            this.magicalView.resetStart();
        } else {
            this.magicalView.setViewParams(0, 0, 0, 0, iArr[0], iArr[1]);
            this.magicalView.resetStartNormal(iArr[0], iArr[1], false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NotifyDataSetChanged"})
    public void deletePreview() {
        OnExternalPreviewEventListener onExternalPreviewEventListener;
        if (this.isDisplayDelete && (onExternalPreviewEventListener = this.selectorConfig.onExternalPreviewEventListener) != null) {
            onExternalPreviewEventListener.onPreviewDelete(this.viewPager.getCurrentItem());
            int currentItem = this.viewPager.getCurrentItem();
            this.mData.remove(currentItem);
            if (this.mData.size() == 0) {
                handleExternalPreviewBack();
                return;
            }
            this.titleBar.setTitle(getString(R.string.ps_preview_image_num, Integer.valueOf(this.curPosition + 1), Integer.valueOf(this.mData.size())));
            this.totalNum = this.mData.size();
            this.curPosition = currentItem;
            if (this.viewPager.getAdapter() != null) {
                this.viewPager.setAdapter(null);
                this.viewPager.setAdapter(this.viewPageAdapter);
            }
            this.viewPager.setCurrentItem(this.curPosition, false);
        }
    }

    private void externalPreviewStyle() {
        int i10;
        ImageView imageDelete = this.titleBar.getImageDelete();
        if (this.isDisplayDelete) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        imageDelete.setVisibility(i10);
        this.tvSelected.setVisibility(8);
        this.bottomNarBar.setVisibility(8);
        this.completeSelectView.setVisibility(8);
    }

    private void getImageRealSizeFromMedia(final LocalMedia localMedia, boolean z10, final OnCallbackListener<int[]> onCallbackListener) {
        int i10;
        int i11;
        boolean z11 = true;
        if (MediaUtils.isLongImage(localMedia.getWidth(), localMedia.getHeight())) {
            i10 = this.screenWidth;
            i11 = this.screenHeight;
        } else {
            int width = localMedia.getWidth();
            int height = localMedia.getHeight();
            if (z10 && ((width <= 0 || height <= 0 || width > height) && this.selectorConfig.isSyncWidthAndHeight)) {
                this.viewPager.setAlpha(DownloadProgress.UNKNOWN_PROGRESS);
                MediaUtils.getImageSize(getContext(), localMedia.getAvailablePath(), new OnCallbackListener<MediaExtraInfo>() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.26
                    @Override // com.luck.picture.lib.interfaces.OnCallbackListener
                    public void onCall(MediaExtraInfo mediaExtraInfo) {
                        if (mediaExtraInfo.getWidth() > 0) {
                            localMedia.setWidth(mediaExtraInfo.getWidth());
                        }
                        if (mediaExtraInfo.getHeight() > 0) {
                            localMedia.setHeight(mediaExtraInfo.getHeight());
                        }
                        OnCallbackListener onCallbackListener2 = onCallbackListener;
                        if (onCallbackListener2 != null) {
                            onCallbackListener2.onCall(new int[]{localMedia.getWidth(), localMedia.getHeight()});
                        }
                    }
                });
                z11 = false;
            }
            i10 = width;
            i11 = height;
        }
        if (localMedia.isCut() && localMedia.getCropImageWidth() > 0 && localMedia.getCropImageHeight() > 0) {
            i10 = localMedia.getCropImageWidth();
            i11 = localMedia.getCropImageHeight();
        }
        if (z11) {
            onCallbackListener.onCall(new int[]{i10, i11});
        }
    }

    private void getVideoRealSizeFromMedia(final LocalMedia localMedia, boolean z10, final OnCallbackListener<int[]> onCallbackListener) {
        if (z10 && ((localMedia.getWidth() <= 0 || localMedia.getHeight() <= 0 || localMedia.getWidth() > localMedia.getHeight()) && this.selectorConfig.isSyncWidthAndHeight)) {
            this.viewPager.setAlpha(DownloadProgress.UNKNOWN_PROGRESS);
            MediaUtils.getVideoSize(getContext(), localMedia.getAvailablePath(), new OnCallbackListener<MediaExtraInfo>() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.27
                @Override // com.luck.picture.lib.interfaces.OnCallbackListener
                public void onCall(MediaExtraInfo mediaExtraInfo) {
                    if (mediaExtraInfo.getWidth() > 0) {
                        localMedia.setWidth(mediaExtraInfo.getWidth());
                    }
                    if (mediaExtraInfo.getHeight() > 0) {
                        localMedia.setHeight(mediaExtraInfo.getHeight());
                    }
                    OnCallbackListener onCallbackListener2 = onCallbackListener;
                    if (onCallbackListener2 != null) {
                        onCallbackListener2.onCall(new int[]{localMedia.getWidth(), localMedia.getHeight()});
                    }
                }
            });
        } else {
            onCallbackListener.onCall(new int[]{localMedia.getWidth(), localMedia.getHeight()});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleExternalPreviewBack() {
        if (!ActivityCompatHelper.isDestroy(getActivity())) {
            if (this.selectorConfig.isPreviewFullScreenMode) {
                hideFullScreenStatusBar();
            }
            onExitPictureSelector();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleMoreData(List<LocalMedia> list, boolean z10) {
        if (ActivityCompatHelper.isDestroy(getActivity())) {
            return;
        }
        this.isHasMore = z10;
        if (z10) {
            if (list.size() > 0) {
                int size = this.mData.size();
                this.mData.addAll(list);
                this.viewPageAdapter.notifyItemRangeChanged(size, this.mData.size());
                return;
            }
            loadMoreData();
        }
    }

    private void hideFullScreenStatusBar() {
        for (int i10 = 0; i10 < this.mAnimViews.size(); i10++) {
            this.mAnimViews.get(i10).setEnabled(true);
        }
        this.bottomNarBar.getEditor().setEnabled(true);
    }

    private void iniMagicalView() {
        float f10 = 1.0f;
        if (isHasMagicalEffect()) {
            if (!this.isSaveInstanceState) {
                f10 = DownloadProgress.UNKNOWN_PROGRESS;
            }
            this.magicalView.setBackgroundAlpha(f10);
            for (int i10 = 0; i10 < this.mAnimViews.size(); i10++) {
                if (!(this.mAnimViews.get(i10) instanceof TitleBar)) {
                    this.mAnimViews.get(i10).setAlpha(f10);
                }
            }
            return;
        }
        this.magicalView.setBackgroundAlpha(1.0f);
    }

    private void initBottomNavBar() {
        this.bottomNarBar.setBottomNavBarStyle();
        this.bottomNarBar.setSelectedChange();
        this.bottomNarBar.setOnBottomNavBarListener(new BottomNavBar.OnBottomNavBarListener() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.15
            @Override // com.luck.picture.lib.widget.BottomNavBar.OnBottomNavBarListener
            public void onCheckOriginalChange() {
                PictureSelectorPreviewFragment.this.sendSelectedOriginalChangeEvent();
            }

            @Override // com.luck.picture.lib.widget.BottomNavBar.OnBottomNavBarListener
            public void onEditImage() {
                if (((PictureCommonFragment) PictureSelectorPreviewFragment.this).selectorConfig.onEditMediaEventListener != null) {
                    PictureSelectorPreviewFragment pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.this;
                    ((PictureCommonFragment) PictureSelectorPreviewFragment.this).selectorConfig.onEditMediaEventListener.onStartMediaEdit(PictureSelectorPreviewFragment.this, pictureSelectorPreviewFragment.mData.get(pictureSelectorPreviewFragment.viewPager.getCurrentItem()), Crop.REQUEST_EDIT_CROP);
                }
            }

            @Override // com.luck.picture.lib.widget.BottomNavBar.OnBottomNavBarListener
            public void onFirstCheckOriginalSelectedChange() {
                int currentItem = PictureSelectorPreviewFragment.this.viewPager.getCurrentItem();
                if (PictureSelectorPreviewFragment.this.mData.size() > currentItem) {
                    PictureSelectorPreviewFragment.this.confirmSelect(PictureSelectorPreviewFragment.this.mData.get(currentItem), false);
                }
            }
        });
    }

    private void initComplete() {
        final SelectMainStyle selectMainStyle = this.selectorConfig.selectorStyle.getSelectMainStyle();
        if (StyleUtils.checkStyleValidity(selectMainStyle.getPreviewSelectBackground())) {
            this.tvSelected.setBackgroundResource(selectMainStyle.getPreviewSelectBackground());
        } else if (StyleUtils.checkStyleValidity(selectMainStyle.getSelectBackground())) {
            this.tvSelected.setBackgroundResource(selectMainStyle.getSelectBackground());
        }
        if (StyleUtils.checkStyleValidity(selectMainStyle.getPreviewSelectTextResId())) {
            this.tvSelectedWord.setText(getString(selectMainStyle.getPreviewSelectTextResId()));
        } else if (StyleUtils.checkTextValidity(selectMainStyle.getPreviewSelectText())) {
            this.tvSelectedWord.setText(selectMainStyle.getPreviewSelectText());
        } else {
            this.tvSelectedWord.setText("");
        }
        if (StyleUtils.checkSizeValidity(selectMainStyle.getPreviewSelectTextSize())) {
            this.tvSelectedWord.setTextSize(selectMainStyle.getPreviewSelectTextSize());
        }
        if (StyleUtils.checkStyleValidity(selectMainStyle.getPreviewSelectTextColor())) {
            this.tvSelectedWord.setTextColor(selectMainStyle.getPreviewSelectTextColor());
        }
        if (StyleUtils.checkSizeValidity(selectMainStyle.getPreviewSelectMarginRight())) {
            if (this.tvSelected.getLayoutParams() instanceof ConstraintLayout.b) {
                if (this.tvSelected.getLayoutParams() instanceof ConstraintLayout.b) {
                    ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) this.tvSelected.getLayoutParams())).rightMargin = selectMainStyle.getPreviewSelectMarginRight();
                }
            } else if (this.tvSelected.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) this.tvSelected.getLayoutParams()).rightMargin = selectMainStyle.getPreviewSelectMarginRight();
            }
        }
        this.completeSelectView.setCompleteSelectViewStyle();
        this.completeSelectView.setSelectedChange(true);
        if (selectMainStyle.isCompleteSelectRelativeTop()) {
            if (this.completeSelectView.getLayoutParams() instanceof ConstraintLayout.b) {
                ConstraintLayout.b bVar = (ConstraintLayout.b) this.completeSelectView.getLayoutParams();
                int i10 = R.id.title_bar;
                bVar.f٢٣١٥i = i10;
                ((ConstraintLayout.b) this.completeSelectView.getLayoutParams()).f٢٣٢١l = i10;
                if (this.selectorConfig.isPreviewFullScreenMode) {
                    ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) this.completeSelectView.getLayoutParams())).topMargin = DensityUtil.getStatusBarHeight(getContext());
                }
            } else if ((this.completeSelectView.getLayoutParams() instanceof RelativeLayout.LayoutParams) && this.selectorConfig.isPreviewFullScreenMode) {
                ((RelativeLayout.LayoutParams) this.completeSelectView.getLayoutParams()).topMargin = DensityUtil.getStatusBarHeight(getContext());
            }
        }
        if (selectMainStyle.isPreviewSelectRelativeBottom()) {
            if (this.tvSelected.getLayoutParams() instanceof ConstraintLayout.b) {
                ConstraintLayout.b bVar2 = (ConstraintLayout.b) this.tvSelected.getLayoutParams();
                int i11 = R.id.bottom_nar_bar;
                bVar2.f٢٣١٥i = i11;
                ((ConstraintLayout.b) this.tvSelected.getLayoutParams()).f٢٣٢١l = i11;
                ((ConstraintLayout.b) this.tvSelectedWord.getLayoutParams()).f٢٣١٥i = i11;
                ((ConstraintLayout.b) this.tvSelectedWord.getLayoutParams()).f٢٣٢١l = i11;
                ((ConstraintLayout.b) this.selectClickArea.getLayoutParams()).f٢٣١٥i = i11;
                ((ConstraintLayout.b) this.selectClickArea.getLayoutParams()).f٢٣٢١l = i11;
            }
        } else if (this.selectorConfig.isPreviewFullScreenMode) {
            if (this.tvSelectedWord.getLayoutParams() instanceof ConstraintLayout.b) {
                ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) this.tvSelectedWord.getLayoutParams())).topMargin = DensityUtil.getStatusBarHeight(getContext());
            } else if (this.tvSelectedWord.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) this.tvSelectedWord.getLayoutParams()).topMargin = DensityUtil.getStatusBarHeight(getContext());
            }
        }
        this.completeSelectView.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.6
            /* JADX WARN: Code restructure failed: missing block: B:20:0x0039, code lost:
            
                if (((com.luck.picture.lib.basic.PictureCommonFragment) r4.this$0).selectorConfig.getSelectCount() > 0) goto L١٢;
             */
            /* JADX WARN: Code restructure failed: missing block: B:6:0x002a, code lost:
            
                if (r5.confirmSelect(r5.mData.get(r5.viewPager.getCurrentItem()), false) == 0) goto L١٢;
             */
            /* JADX WARN: Code restructure failed: missing block: B:7:0x002d, code lost:
            
                r0 = false;
             */
            @Override // android.view.View.OnClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onClick(View view) {
                boolean z10 = true;
                if (selectMainStyle.isCompleteSelectRelativeTop() && ((PictureCommonFragment) PictureSelectorPreviewFragment.this).selectorConfig.getSelectCount() == 0) {
                    PictureSelectorPreviewFragment pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.this;
                }
                if (((PictureCommonFragment) PictureSelectorPreviewFragment.this).selectorConfig.isEmptyResultReturn && ((PictureCommonFragment) PictureSelectorPreviewFragment.this).selectorConfig.getSelectCount() == 0) {
                    PictureSelectorPreviewFragment.this.onExitPictureSelector();
                } else if (z10) {
                    PictureSelectorPreviewFragment.this.dispatchTransformResult();
                }
            }
        });
    }

    private void initTitleBar() {
        if (this.selectorConfig.selectorStyle.getTitleBarStyle().isHideTitleBar()) {
            this.titleBar.setVisibility(8);
        }
        this.titleBar.setTitleBarStyle();
        this.titleBar.setOnTitleBarListener(new TitleBar.OnTitleBarListener() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.7
            @Override // com.luck.picture.lib.widget.TitleBar.OnTitleBarListener
            public void onBackPressed() {
                PictureSelectorPreviewFragment pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.this;
                if (pictureSelectorPreviewFragment.isExternalPreview) {
                    if (!((PictureCommonFragment) pictureSelectorPreviewFragment).selectorConfig.isPreviewZoomEffect) {
                        PictureSelectorPreviewFragment.this.handleExternalPreviewBack();
                        return;
                    } else {
                        PictureSelectorPreviewFragment.this.magicalView.backToMin();
                        return;
                    }
                }
                if (pictureSelectorPreviewFragment.isInternalBottomPreview || !((PictureCommonFragment) pictureSelectorPreviewFragment).selectorConfig.isPreviewZoomEffect) {
                    PictureSelectorPreviewFragment.this.onBackCurrentFragment();
                } else {
                    PictureSelectorPreviewFragment.this.magicalView.backToMin();
                }
            }
        });
        this.titleBar.setTitle((this.curPosition + 1) + "/" + this.totalNum);
        this.titleBar.getImageDelete().setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PictureSelectorPreviewFragment.this.deletePreview();
            }
        });
        this.selectClickArea.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PictureSelectorPreviewFragment pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.this;
                if (pictureSelectorPreviewFragment.isExternalPreview) {
                    pictureSelectorPreviewFragment.deletePreview();
                    return;
                }
                LocalMedia localMedia = pictureSelectorPreviewFragment.mData.get(pictureSelectorPreviewFragment.viewPager.getCurrentItem());
                PictureSelectorPreviewFragment pictureSelectorPreviewFragment2 = PictureSelectorPreviewFragment.this;
                if (pictureSelectorPreviewFragment2.confirmSelect(localMedia, pictureSelectorPreviewFragment2.tvSelected.isSelected()) == 0) {
                    if (((PictureCommonFragment) PictureSelectorPreviewFragment.this).selectorConfig.onSelectAnimListener != null) {
                        ((PictureCommonFragment) PictureSelectorPreviewFragment.this).selectorConfig.onSelectAnimListener.onSelectAnim(PictureSelectorPreviewFragment.this.tvSelected);
                    } else {
                        PictureSelectorPreviewFragment pictureSelectorPreviewFragment3 = PictureSelectorPreviewFragment.this;
                        pictureSelectorPreviewFragment3.tvSelected.startAnimation(AnimationUtils.loadAnimation(pictureSelectorPreviewFragment3.getContext(), R.anim.ps_anim_modal_in));
                    }
                }
            }
        });
        this.tvSelected.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PictureSelectorPreviewFragment.this.selectClickArea.performClick();
            }
        });
    }

    private void initViewPagerData(ArrayList<LocalMedia> arrayList) {
        int i10;
        boolean z10;
        PicturePreviewAdapter createAdapter = createAdapter();
        this.viewPageAdapter = createAdapter;
        createAdapter.setData(arrayList);
        this.viewPageAdapter.setOnPreviewEventListener(new MyOnPreviewEventListener());
        this.viewPager.setOrientation(0);
        this.viewPager.setAdapter(this.viewPageAdapter);
        this.selectorConfig.selectedPreviewResult.clear();
        if (arrayList.size() != 0 && this.curPosition < arrayList.size() && (i10 = this.curPosition) >= 0) {
            LocalMedia localMedia = arrayList.get(i10);
            PreviewBottomNavBar previewBottomNavBar = this.bottomNarBar;
            if (!PictureMimeType.isHasVideo(localMedia.getMimeType()) && !PictureMimeType.isHasAudio(localMedia.getMimeType())) {
                z10 = false;
            } else {
                z10 = true;
            }
            previewBottomNavBar.isDisplayEditor(z10);
            this.tvSelected.setSelected(this.selectorConfig.getSelectedResult().contains(arrayList.get(this.viewPager.getCurrentItem())));
            this.viewPager.registerOnPageChangeCallback(this.pageChangeCallback);
            this.viewPager.setPageTransformer(new MarginPageTransformer(DensityUtil.dip2px(getAppContext(), 3.0f)));
            this.viewPager.setCurrentItem(this.curPosition, false);
            sendChangeSubSelectPositionEvent(false);
            notifySelectNumberStyle(arrayList.get(this.curPosition));
            startZoomEffect(localMedia);
            return;
        }
        onKeyBackFragmentFinish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHasMagicalEffect() {
        if (!this.isInternalBottomPreview && this.selectorConfig.isPreviewZoomEffect) {
            return true;
        }
        return false;
    }

    private boolean isPlaying() {
        PicturePreviewAdapter picturePreviewAdapter = this.viewPageAdapter;
        if (picturePreviewAdapter != null && picturePreviewAdapter.isPlaying(this.viewPager.getCurrentItem())) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadMoreData() {
        int i10 = this.mPage + 1;
        this.mPage = i10;
        SelectorConfig selectorConfig = this.selectorConfig;
        ExtendLoaderEngine extendLoaderEngine = selectorConfig.loaderDataEngine;
        if (extendLoaderEngine != null) {
            Context context = getContext();
            long j10 = this.mBucketId;
            int i11 = this.mPage;
            int i12 = this.selectorConfig.pageSize;
            extendLoaderEngine.loadMoreMediaData(context, j10, i11, i12, i12, new OnQueryDataResultListener<LocalMedia>() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.4
                @Override // com.luck.picture.lib.interfaces.OnQueryDataResultListener
                public void onComplete(ArrayList<LocalMedia> arrayList, boolean z10) {
                    PictureSelectorPreviewFragment.this.handleMoreData(arrayList, z10);
                }
            });
            return;
        }
        this.mLoader.loadPageMediaData(this.mBucketId, i10, selectorConfig.pageSize, new OnQueryDataResultListener<LocalMedia>() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.5
            @Override // com.luck.picture.lib.interfaces.OnQueryDataResultListener
            public void onComplete(ArrayList<LocalMedia> arrayList, boolean z10) {
                PictureSelectorPreviewFragment.this.handleMoreData(arrayList, z10);
            }
        });
    }

    public static PictureSelectorPreviewFragment newInstance() {
        PictureSelectorPreviewFragment pictureSelectorPreviewFragment = new PictureSelectorPreviewFragment();
        pictureSelectorPreviewFragment.setArguments(new Bundle());
        return pictureSelectorPreviewFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyGallerySelectMedia(LocalMedia localMedia) {
        if (this.mGalleryAdapter != null && this.selectorConfig.selectorStyle.getSelectMainStyle().isPreviewDisplaySelectGallery()) {
            this.mGalleryAdapter.isSelectMedia(localMedia);
        }
    }

    private void notifyPreviewGalleryData(boolean z10, LocalMedia localMedia) {
        if (this.mGalleryAdapter != null && this.selectorConfig.selectorStyle.getSelectMainStyle().isPreviewDisplaySelectGallery()) {
            if (this.mGalleryRecycle.getVisibility() == 4) {
                this.mGalleryRecycle.setVisibility(0);
            }
            if (z10) {
                if (this.selectorConfig.selectionMode == 1) {
                    this.mGalleryAdapter.clear();
                }
                this.mGalleryAdapter.addGalleryData(localMedia);
                this.mGalleryRecycle.smoothScrollToPosition(this.mGalleryAdapter.getItemCount() - 1);
                return;
            }
            this.mGalleryAdapter.removeGalleryData(localMedia);
            if (this.selectorConfig.getSelectCount() == 0) {
                this.mGalleryRecycle.setVisibility(4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onExternalLongPressDownload(final LocalMedia localMedia) {
        String string;
        OnExternalPreviewEventListener onExternalPreviewEventListener = this.selectorConfig.onExternalPreviewEventListener;
        if (onExternalPreviewEventListener != null && !onExternalPreviewEventListener.onLongPressDownload(getContext(), localMedia)) {
            if (!PictureMimeType.isHasAudio(localMedia.getMimeType()) && !PictureMimeType.isUrlHasAudio(localMedia.getAvailablePath())) {
                if (!PictureMimeType.isHasVideo(localMedia.getMimeType()) && !PictureMimeType.isUrlHasVideo(localMedia.getAvailablePath())) {
                    string = getString(R.string.ps_prompt_image_content);
                } else {
                    string = getString(R.string.ps_prompt_video_content);
                }
            } else {
                string = getString(R.string.ps_prompt_audio_content);
            }
            PictureCommonDialog.showDialog(getContext(), getString(R.string.ps_prompt), string).setOnDialogEventListener(new PictureCommonDialog.OnDialogEventListener() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.21
                @Override // com.luck.picture.lib.dialog.PictureCommonDialog.OnDialogEventListener
                public void onConfirm() {
                    String availablePath = localMedia.getAvailablePath();
                    if (PictureMimeType.isHasHttp(availablePath)) {
                        PictureSelectorPreviewFragment.this.showLoading();
                    }
                    DownloadFileUtils.saveLocalFile(PictureSelectorPreviewFragment.this.getContext(), availablePath, localMedia.getMimeType(), new OnCallbackListener<String>() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.21.1
                        @Override // com.luck.picture.lib.interfaces.OnCallbackListener
                        public void onCall(String str) {
                            String string2;
                            PictureSelectorPreviewFragment.this.dismissLoading();
                            if (TextUtils.isEmpty(str)) {
                                if (PictureMimeType.isHasAudio(localMedia.getMimeType())) {
                                    string2 = PictureSelectorPreviewFragment.this.getString(R.string.ps_save_audio_error);
                                } else if (PictureMimeType.isHasVideo(localMedia.getMimeType())) {
                                    string2 = PictureSelectorPreviewFragment.this.getString(R.string.ps_save_video_error);
                                } else {
                                    string2 = PictureSelectorPreviewFragment.this.getString(R.string.ps_save_image_error);
                                }
                                ToastUtils.showToast(PictureSelectorPreviewFragment.this.getContext(), string2);
                                return;
                            }
                            new PictureMediaScannerConnection(PictureSelectorPreviewFragment.this.getActivity(), str);
                            ToastUtils.showToast(PictureSelectorPreviewFragment.this.getContext(), PictureSelectorPreviewFragment.this.getString(R.string.ps_save_success) + "\n" + str);
                        }
                    });
                }
            });
        }
    }

    private void onKeyDownBackToMin() {
        if (!ActivityCompatHelper.isDestroy(getActivity())) {
            if (this.isExternalPreview) {
                if (this.selectorConfig.isPreviewZoomEffect) {
                    this.magicalView.backToMin();
                    return;
                } else {
                    onExitPictureSelector();
                    return;
                }
            }
            if (this.isInternalBottomPreview) {
                onBackCurrentFragment();
            } else if (this.selectorConfig.isPreviewZoomEffect) {
                this.magicalView.backToMin();
            } else {
                onBackCurrentFragment();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void previewFullScreenMode() {
        final boolean z10;
        float f10;
        float f11;
        float f12;
        if (this.isAnimationStart) {
            return;
        }
        float translationY = this.titleBar.getTranslationY();
        float f13 = DownloadProgress.UNKNOWN_PROGRESS;
        if (translationY == DownloadProgress.UNKNOWN_PROGRESS) {
            z10 = true;
        } else {
            z10 = false;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        if (z10) {
            f10 = DownloadProgress.UNKNOWN_PROGRESS;
        } else {
            f10 = -this.titleBar.getHeight();
        }
        if (z10) {
            f11 = -this.titleBar.getHeight();
        } else {
            f11 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        if (z10) {
            f12 = 1.0f;
        } else {
            f12 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        if (!z10) {
            f13 = 1.0f;
        }
        for (int i10 = 0; i10 < this.mAnimViews.size(); i10++) {
            View view = this.mAnimViews.get(i10);
            animatorSet.playTogether(ObjectAnimator.ofFloat(view, "alpha", f12, f13));
            if (view instanceof TitleBar) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(view, "translationY", f10, f11));
            }
        }
        animatorSet.setDuration(350L);
        animatorSet.start();
        this.isAnimationStart = true;
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.20
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            @SuppressLint({"WrongConstant"})
            public void onAnimationEnd(Animator animator) {
                PictureSelectorPreviewFragment.this.isAnimationStart = false;
                if (SdkVersionUtils.isP() && PictureSelectorPreviewFragment.this.isAdded()) {
                    Window window = PictureSelectorPreviewFragment.this.requireActivity().getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    if (z10) {
                        attributes.flags |= 1024;
                        attributes.layoutInDisplayCutoutMode = 1;
                        window.setAttributes(attributes);
                        window.addFlags(512);
                        return;
                    }
                    attributes.flags &= -1025;
                    window.setAttributes(attributes);
                    window.clearFlags(512);
                }
            }
        });
        if (z10) {
            showFullScreenStatusBar();
        } else {
            hideFullScreenStatusBar();
        }
    }

    private void resumePausePlay() {
        BasePreviewHolder currentHolder;
        PicturePreviewAdapter picturePreviewAdapter = this.viewPageAdapter;
        if (picturePreviewAdapter != null && (currentHolder = picturePreviewAdapter.getCurrentHolder(this.viewPager.getCurrentItem())) != null) {
            currentHolder.resumePausePlay();
        }
    }

    private void setMagicalViewBackgroundColor() {
        ArrayList<LocalMedia> arrayList;
        SelectMainStyle selectMainStyle = this.selectorConfig.selectorStyle.getSelectMainStyle();
        if (StyleUtils.checkStyleValidity(selectMainStyle.getPreviewBackgroundColor())) {
            this.magicalView.setBackgroundColor(selectMainStyle.getPreviewBackgroundColor());
            return;
        }
        if (this.selectorConfig.chooseMode != SelectMimeType.ofAudio() && ((arrayList = this.mData) == null || arrayList.size() <= 0 || !PictureMimeType.isHasAudio(this.mData.get(0).getMimeType()))) {
            this.magicalView.setBackgroundColor(a.getColor(getContext(), R.color.ps_color_black));
        } else {
            this.magicalView.setBackgroundColor(a.getColor(getContext(), R.color.ps_color_white));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMagicalViewParams(int i10, int i11, int i12) {
        this.magicalView.changeRealScreenHeight(i10, i11, true);
        if (this.isShowCamera) {
            i12++;
        }
        ViewParams itemViewParams = BuildRecycleItemViewParams.getItemViewParams(i12);
        if (itemViewParams != null && i10 != 0 && i11 != 0) {
            this.magicalView.setViewParams(itemViewParams.left, itemViewParams.top, itemViewParams.width, itemViewParams.height, i10, i11);
        } else {
            this.magicalView.setViewParams(0, 0, 0, 0, i10, i11);
        }
    }

    private void showFullScreenStatusBar() {
        for (int i10 = 0; i10 < this.mAnimViews.size(); i10++) {
            this.mAnimViews.get(i10).setEnabled(false);
        }
        this.bottomNarBar.getEditor().setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start(final int[] iArr) {
        int i10;
        int i11;
        this.magicalView.changeRealScreenHeight(iArr[0], iArr[1], false);
        if (this.isShowCamera) {
            i10 = this.curPosition + 1;
        } else {
            i10 = this.curPosition;
        }
        ViewParams itemViewParams = BuildRecycleItemViewParams.getItemViewParams(i10);
        if (itemViewParams != null && ((i11 = iArr[0]) != 0 || iArr[1] != 0)) {
            this.magicalView.setViewParams(itemViewParams.left, itemViewParams.top, itemViewParams.width, itemViewParams.height, i11, iArr[1]);
            this.magicalView.start(false);
        } else {
            this.viewPager.post(new Runnable() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.19
                @Override // java.lang.Runnable
                public void run() {
                    MagicalView magicalView = PictureSelectorPreviewFragment.this.magicalView;
                    int[] iArr2 = iArr;
                    magicalView.startNormal(iArr2[0], iArr2[1], false);
                }
            });
            this.magicalView.setBackgroundAlpha(1.0f);
            for (int i12 = 0; i12 < this.mAnimViews.size(); i12++) {
                this.mAnimViews.get(i12).setAlpha(1.0f);
            }
        }
        ObjectAnimator.ofFloat(this.viewPager, "alpha", DownloadProgress.UNKNOWN_PROGRESS, 1.0f).setDuration(50L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAutoVideoPlay(final int i10) {
        this.viewPager.post(new Runnable() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.23
            @Override // java.lang.Runnable
            public void run() {
                PictureSelectorPreviewFragment.this.viewPageAdapter.startAutoVideoPlay(i10);
            }
        });
    }

    public void addAminViews(View... viewArr) {
        Collections.addAll(this.mAnimViews, viewArr);
    }

    protected PicturePreviewAdapter createAdapter() {
        return new PicturePreviewAdapter(this.selectorConfig);
    }

    public PicturePreviewAdapter getAdapter() {
        return this.viewPageAdapter;
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment
    public String getFragmentTag() {
        return TAG;
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public int getResourceId() {
        int layoutResource = InjectResourceSource.getLayoutResource(getContext(), 2, this.selectorConfig);
        if (layoutResource != 0) {
            return layoutResource;
        }
        return R.layout.ps_fragment_preview;
    }

    public ViewPager2 getViewPager2() {
        return this.viewPager;
    }

    protected void initPreviewSelectGallery(ViewGroup viewGroup) {
        SelectMainStyle selectMainStyle = this.selectorConfig.selectorStyle.getSelectMainStyle();
        if (selectMainStyle.isPreviewDisplaySelectGallery()) {
            this.mGalleryRecycle = new RecyclerView(getContext());
            if (StyleUtils.checkStyleValidity(selectMainStyle.getAdapterPreviewGalleryBackgroundResource())) {
                this.mGalleryRecycle.setBackgroundResource(selectMainStyle.getAdapterPreviewGalleryBackgroundResource());
            } else {
                this.mGalleryRecycle.setBackgroundResource(R.drawable.ps_preview_gallery_bg);
            }
            viewGroup.addView(this.mGalleryRecycle);
            ViewGroup.LayoutParams layoutParams = this.mGalleryRecycle.getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.b) {
                ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
                ((ViewGroup.MarginLayoutParams) bVar).width = -1;
                ((ViewGroup.MarginLayoutParams) bVar).height = -2;
                bVar.f٢٣١٩k = R.id.bottom_nar_bar;
                bVar.f٢٣٣٧t = 0;
                bVar.f٢٣٤١v = 0;
            }
            WrapContentLinearLayoutManager wrapContentLinearLayoutManager = new WrapContentLinearLayoutManager(getContext()) { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.11
                @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i10) {
                    super.smoothScrollToPosition(recyclerView, state, i10);
                    LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext()) { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.11.1
                        @Override // androidx.recyclerview.widget.LinearSmoothScroller
                        protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                            return 300.0f / displayMetrics.densityDpi;
                        }
                    };
                    linearSmoothScroller.setTargetPosition(i10);
                    startSmoothScroll(linearSmoothScroller);
                }
            };
            RecyclerView.ItemAnimator itemAnimator = this.mGalleryRecycle.getItemAnimator();
            if (itemAnimator != null) {
                ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            }
            if (this.mGalleryRecycle.getItemDecorationCount() == 0) {
                this.mGalleryRecycle.addItemDecoration(new HorizontalItemDecoration(Integer.MAX_VALUE, DensityUtil.dip2px(getContext(), 6.0f)));
            }
            wrapContentLinearLayoutManager.setOrientation(0);
            this.mGalleryRecycle.setLayoutManager(wrapContentLinearLayoutManager);
            if (this.selectorConfig.getSelectCount() > 0) {
                this.mGalleryRecycle.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(getContext(), R.anim.ps_anim_layout_fall_enter));
            }
            this.mGalleryAdapter = new PreviewGalleryAdapter(this.selectorConfig, this.isInternalBottomPreview);
            notifyGallerySelectMedia(this.mData.get(this.curPosition));
            this.mGalleryRecycle.setAdapter(this.mGalleryAdapter);
            this.mGalleryAdapter.setItemClickListener(new PreviewGalleryAdapter.OnItemClickListener() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.12
                @Override // com.luck.picture.lib.adapter.holder.PreviewGalleryAdapter.OnItemClickListener
                public void onItemClick(final int i10, LocalMedia localMedia, View view) {
                    String str;
                    if (i10 == -1) {
                        return;
                    }
                    if (TextUtils.isEmpty(((PictureCommonFragment) PictureSelectorPreviewFragment.this).selectorConfig.defaultAlbumName)) {
                        str = PictureSelectorPreviewFragment.this.getString(R.string.ps_camera_roll);
                    } else {
                        str = ((PictureCommonFragment) PictureSelectorPreviewFragment.this).selectorConfig.defaultAlbumName;
                    }
                    PictureSelectorPreviewFragment pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.this;
                    if (pictureSelectorPreviewFragment.isInternalBottomPreview || TextUtils.equals(pictureSelectorPreviewFragment.currentAlbum, str) || TextUtils.equals(localMedia.getParentFolderName(), PictureSelectorPreviewFragment.this.currentAlbum)) {
                        PictureSelectorPreviewFragment pictureSelectorPreviewFragment2 = PictureSelectorPreviewFragment.this;
                        if (!pictureSelectorPreviewFragment2.isInternalBottomPreview) {
                            if (pictureSelectorPreviewFragment2.isShowCamera) {
                                i10 = localMedia.position - 1;
                            } else {
                                i10 = localMedia.position;
                            }
                        }
                        if (i10 == pictureSelectorPreviewFragment2.viewPager.getCurrentItem() && localMedia.isChecked()) {
                            return;
                        }
                        LocalMedia item = PictureSelectorPreviewFragment.this.viewPageAdapter.getItem(i10);
                        if (item != null && (!TextUtils.equals(localMedia.getPath(), item.getPath()) || localMedia.getId() != item.getId())) {
                            return;
                        }
                        if (PictureSelectorPreviewFragment.this.viewPager.getAdapter() != null) {
                            PictureSelectorPreviewFragment.this.viewPager.setAdapter(null);
                            PictureSelectorPreviewFragment pictureSelectorPreviewFragment3 = PictureSelectorPreviewFragment.this;
                            pictureSelectorPreviewFragment3.viewPager.setAdapter(pictureSelectorPreviewFragment3.viewPageAdapter);
                        }
                        PictureSelectorPreviewFragment.this.viewPager.setCurrentItem(i10, false);
                        PictureSelectorPreviewFragment.this.notifyGallerySelectMedia(localMedia);
                        PictureSelectorPreviewFragment.this.viewPager.post(new Runnable() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.12.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (((PictureCommonFragment) PictureSelectorPreviewFragment.this).selectorConfig.isPreviewZoomEffect) {
                                    PictureSelectorPreviewFragment.this.viewPageAdapter.setVideoPlayButtonUI(i10);
                                }
                            }
                        });
                    }
                }
            });
            if (this.selectorConfig.getSelectCount() > 0) {
                this.mGalleryRecycle.setVisibility(0);
            } else {
                this.mGalleryRecycle.setVisibility(4);
            }
            addAminViews(this.mGalleryRecycle);
            final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.13
                @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
                public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                    int lastCheckPosition;
                    viewHolder.itemView.setAlpha(1.0f);
                    PictureSelectorPreviewFragment pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.this;
                    if (pictureSelectorPreviewFragment.needScaleSmall) {
                        pictureSelectorPreviewFragment.needScaleSmall = false;
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(ObjectAnimator.ofFloat(viewHolder.itemView, "scaleX", 1.1f, 1.0f), ObjectAnimator.ofFloat(viewHolder.itemView, "scaleY", 1.1f, 1.0f));
                        animatorSet.setInterpolator(new LinearInterpolator());
                        animatorSet.setDuration(50L);
                        animatorSet.start();
                        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.13.2
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                PictureSelectorPreviewFragment.this.needScaleBig = true;
                            }
                        });
                    }
                    super.clearView(recyclerView, viewHolder);
                    PictureSelectorPreviewFragment.this.mGalleryAdapter.notifyItemChanged(viewHolder.getAbsoluteAdapterPosition());
                    PictureSelectorPreviewFragment pictureSelectorPreviewFragment2 = PictureSelectorPreviewFragment.this;
                    if (pictureSelectorPreviewFragment2.isInternalBottomPreview && PictureSelectorPreviewFragment.this.viewPager.getCurrentItem() != (lastCheckPosition = pictureSelectorPreviewFragment2.mGalleryAdapter.getLastCheckPosition()) && lastCheckPosition != -1) {
                        if (PictureSelectorPreviewFragment.this.viewPager.getAdapter() != null) {
                            PictureSelectorPreviewFragment.this.viewPager.setAdapter(null);
                            PictureSelectorPreviewFragment pictureSelectorPreviewFragment3 = PictureSelectorPreviewFragment.this;
                            pictureSelectorPreviewFragment3.viewPager.setAdapter(pictureSelectorPreviewFragment3.viewPageAdapter);
                        }
                        PictureSelectorPreviewFragment.this.viewPager.setCurrentItem(lastCheckPosition, false);
                    }
                    if (((PictureCommonFragment) PictureSelectorPreviewFragment.this).selectorConfig.selectorStyle.getSelectMainStyle().isSelectNumberStyle() && !ActivityCompatHelper.isDestroy(PictureSelectorPreviewFragment.this.getActivity())) {
                        List<Fragment> fragments = PictureSelectorPreviewFragment.this.getActivity().getSupportFragmentManager().getFragments();
                        for (int i10 = 0; i10 < fragments.size(); i10++) {
                            Fragment fragment = fragments.get(i10);
                            if (fragment instanceof PictureCommonFragment) {
                                ((PictureCommonFragment) fragment).sendChangeSubSelectPositionEvent(true);
                            }
                        }
                    }
                }

                @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
                public long getAnimationDuration(RecyclerView recyclerView, int i10, float f10, float f11) {
                    return super.getAnimationDuration(recyclerView, i10, f10, f11);
                }

                @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
                public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                    viewHolder.itemView.setAlpha(0.7f);
                    return ItemTouchHelper.Callback.makeMovementFlags(12, 0);
                }

                @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
                public boolean isLongPressDragEnabled() {
                    return true;
                }

                @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
                public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f10, float f11, int i10, boolean z10) {
                    PictureSelectorPreviewFragment pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.this;
                    if (pictureSelectorPreviewFragment.needScaleBig) {
                        pictureSelectorPreviewFragment.needScaleBig = false;
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(ObjectAnimator.ofFloat(viewHolder.itemView, "scaleX", 1.0f, 1.1f), ObjectAnimator.ofFloat(viewHolder.itemView, "scaleY", 1.0f, 1.1f));
                        animatorSet.setDuration(50L);
                        animatorSet.setInterpolator(new LinearInterpolator());
                        animatorSet.start();
                        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.13.1
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                PictureSelectorPreviewFragment.this.needScaleSmall = true;
                            }
                        });
                    }
                    super.onChildDraw(canvas, recyclerView, viewHolder, f10, f11, i10, z10);
                }

                @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
                public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
                    try {
                        int absoluteAdapterPosition = viewHolder.getAbsoluteAdapterPosition();
                        int absoluteAdapterPosition2 = viewHolder2.getAbsoluteAdapterPosition();
                        if (absoluteAdapterPosition < absoluteAdapterPosition2) {
                            int i10 = absoluteAdapterPosition;
                            while (i10 < absoluteAdapterPosition2) {
                                int i11 = i10 + 1;
                                Collections.swap(PictureSelectorPreviewFragment.this.mGalleryAdapter.getData(), i10, i11);
                                Collections.swap(((PictureCommonFragment) PictureSelectorPreviewFragment.this).selectorConfig.getSelectedResult(), i10, i11);
                                PictureSelectorPreviewFragment pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.this;
                                if (pictureSelectorPreviewFragment.isInternalBottomPreview) {
                                    Collections.swap(pictureSelectorPreviewFragment.mData, i10, i11);
                                }
                                i10 = i11;
                            }
                        } else {
                            for (int i12 = absoluteAdapterPosition; i12 > absoluteAdapterPosition2; i12--) {
                                int i13 = i12 - 1;
                                Collections.swap(PictureSelectorPreviewFragment.this.mGalleryAdapter.getData(), i12, i13);
                                Collections.swap(((PictureCommonFragment) PictureSelectorPreviewFragment.this).selectorConfig.getSelectedResult(), i12, i13);
                                PictureSelectorPreviewFragment pictureSelectorPreviewFragment2 = PictureSelectorPreviewFragment.this;
                                if (pictureSelectorPreviewFragment2.isInternalBottomPreview) {
                                    Collections.swap(pictureSelectorPreviewFragment2.mData, i12, i13);
                                }
                            }
                        }
                        PictureSelectorPreviewFragment.this.mGalleryAdapter.notifyItemMoved(absoluteAdapterPosition, absoluteAdapterPosition2);
                        return true;
                    } catch (Exception e10) {
                        e10.printStackTrace();
                        return true;
                    }
                }

                @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
                public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i10) {
                    super.onSelectedChanged(viewHolder, i10);
                }

                @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
                public void onSwiped(RecyclerView.ViewHolder viewHolder, int i10) {
                }
            });
            itemTouchHelper.attachToRecyclerView(this.mGalleryRecycle);
            this.mGalleryAdapter.setItemLongClickListener(new PreviewGalleryAdapter.OnItemLongClickListener() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.14
                @Override // com.luck.picture.lib.adapter.holder.PreviewGalleryAdapter.OnItemLongClickListener
                public void onItemLongClick(RecyclerView.ViewHolder viewHolder, int i10, View view) {
                    ((Vibrator) PictureSelectorPreviewFragment.this.getActivity().getSystemService("vibrator")).vibrate(50L);
                    if (PictureSelectorPreviewFragment.this.mGalleryAdapter.getItemCount() != ((PictureCommonFragment) PictureSelectorPreviewFragment.this).selectorConfig.maxSelectNum) {
                        itemTouchHelper.startDrag(viewHolder);
                    } else if (viewHolder.getLayoutPosition() != PictureSelectorPreviewFragment.this.mGalleryAdapter.getItemCount() - 1) {
                        itemTouchHelper.startDrag(viewHolder);
                    }
                }
            });
        }
    }

    protected boolean isSelected(LocalMedia localMedia) {
        return this.selectorConfig.getSelectedResult().contains(localMedia);
    }

    public void notifySelectNumberStyle(LocalMedia localMedia) {
        if (this.selectorConfig.selectorStyle.getSelectMainStyle().isPreviewSelectNumberStyle() && this.selectorConfig.selectorStyle.getSelectMainStyle().isSelectNumberStyle()) {
            this.tvSelected.setText("");
            for (int i10 = 0; i10 < this.selectorConfig.getSelectCount(); i10++) {
                LocalMedia localMedia2 = this.selectorConfig.getSelectedResult().get(i10);
                if (TextUtils.equals(localMedia2.getPath(), localMedia.getPath()) || localMedia2.getId() == localMedia.getId()) {
                    localMedia.setNum(localMedia2.getNum());
                    localMedia2.setPosition(localMedia.getPosition());
                    this.tvSelected.setText(ValueOf.toString(Integer.valueOf(localMedia.getNum())));
                }
            }
        }
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void onCheckOriginalChange() {
        this.bottomNarBar.setOriginalCheck();
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (isHasMagicalEffect()) {
            int size = this.mData.size();
            int i10 = this.curPosition;
            if (size > i10) {
                LocalMedia localMedia = this.mData.get(i10);
                if (PictureMimeType.isHasVideo(localMedia.getMimeType())) {
                    getVideoRealSizeFromMedia(localMedia, false, new OnCallbackListener<int[]>() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.2
                        @Override // com.luck.picture.lib.interfaces.OnCallbackListener
                        public void onCall(int[] iArr) {
                            PictureSelectorPreviewFragment.this.changeViewParams(iArr);
                        }
                    });
                } else {
                    getImageRealSizeFromMedia(localMedia, false, new OnCallbackListener<int[]>() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.3
                        @Override // com.luck.picture.lib.interfaces.OnCallbackListener
                        public void onCall(int[] iArr) {
                            PictureSelectorPreviewFragment.this.changeViewParams(iArr);
                        }
                    });
                }
            }
        }
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int i10, boolean z10, int i11) {
        int i12;
        if (isHasMagicalEffect()) {
            return null;
        }
        PictureWindowAnimationStyle windowAnimationStyle = this.selectorConfig.selectorStyle.getWindowAnimationStyle();
        if (windowAnimationStyle.activityPreviewEnterAnimation != 0 && windowAnimationStyle.activityPreviewExitAnimation != 0) {
            FragmentActivity activity = getActivity();
            if (z10) {
                i12 = windowAnimationStyle.activityPreviewEnterAnimation;
            } else {
                i12 = windowAnimationStyle.activityPreviewExitAnimation;
            }
            Animation loadAnimation = AnimationUtils.loadAnimation(activity, i12);
            if (z10) {
                onEnterFragment();
            } else {
                onExitFragment();
            }
            return loadAnimation;
        }
        return super.onCreateAnimation(i10, z10, i11);
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void onCreateLoader() {
        IBridgeMediaLoader localMediaLoader;
        if (this.isExternalPreview) {
            return;
        }
        SelectorConfig selectorConfig = this.selectorConfig;
        IBridgeLoaderFactory iBridgeLoaderFactory = selectorConfig.loaderFactory;
        if (iBridgeLoaderFactory != null) {
            IBridgeMediaLoader onCreateLoader = iBridgeLoaderFactory.onCreateLoader();
            this.mLoader = onCreateLoader;
            if (onCreateLoader == null) {
                throw new NullPointerException("No available " + IBridgeMediaLoader.class + " loader found");
            }
            return;
        }
        if (selectorConfig.isPageStrategy) {
            localMediaLoader = new LocalMediaPageLoader(getAppContext(), this.selectorConfig);
        } else {
            localMediaLoader = new LocalMediaLoader(getAppContext(), this.selectorConfig);
        }
        this.mLoader = localMediaLoader;
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        PicturePreviewAdapter picturePreviewAdapter = this.viewPageAdapter;
        if (picturePreviewAdapter != null) {
            picturePreviewAdapter.destroy();
        }
        ViewPager2 viewPager2 = this.viewPager;
        if (viewPager2 != null) {
            viewPager2.unregisterOnPageChangeCallback(this.pageChangeCallback);
        }
        super.onDestroy();
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void onEditMedia(Intent intent) {
        String str;
        if (this.mData.size() > this.viewPager.getCurrentItem()) {
            LocalMedia localMedia = this.mData.get(this.viewPager.getCurrentItem());
            Uri output = Crop.getOutput(intent);
            if (output != null) {
                str = output.getPath();
            } else {
                str = "";
            }
            localMedia.setCutPath(str);
            localMedia.setCropImageWidth(Crop.getOutputImageWidth(intent));
            localMedia.setCropImageHeight(Crop.getOutputImageHeight(intent));
            localMedia.setCropOffsetX(Crop.getOutputImageOffsetX(intent));
            localMedia.setCropOffsetY(Crop.getOutputImageOffsetY(intent));
            localMedia.setCropResultAspectRatio(Crop.getOutputCropAspectRatio(intent));
            localMedia.setCut(!TextUtils.isEmpty(localMedia.getCutPath()));
            localMedia.setCustomData(Crop.getOutputCustomExtraData(intent));
            localMedia.setEditorImage(localMedia.isCut());
            localMedia.setSandboxPath(localMedia.getCutPath());
            if (this.selectorConfig.getSelectedResult().contains(localMedia)) {
                LocalMedia compareLocalMedia = localMedia.getCompareLocalMedia();
                if (compareLocalMedia != null) {
                    compareLocalMedia.setCutPath(localMedia.getCutPath());
                    compareLocalMedia.setCut(localMedia.isCut());
                    compareLocalMedia.setEditorImage(localMedia.isEditorImage());
                    compareLocalMedia.setCustomData(localMedia.getCustomData());
                    compareLocalMedia.setSandboxPath(localMedia.getCutPath());
                    compareLocalMedia.setCropImageWidth(Crop.getOutputImageWidth(intent));
                    compareLocalMedia.setCropImageHeight(Crop.getOutputImageHeight(intent));
                    compareLocalMedia.setCropOffsetX(Crop.getOutputImageOffsetX(intent));
                    compareLocalMedia.setCropOffsetY(Crop.getOutputImageOffsetY(intent));
                    compareLocalMedia.setCropResultAspectRatio(Crop.getOutputCropAspectRatio(intent));
                }
                sendFixedSelectedChangeEvent(localMedia);
            } else {
                confirmSelect(localMedia, false);
            }
            this.viewPageAdapter.notifyItemChanged(this.viewPager.getCurrentItem());
            notifyGallerySelectMedia(localMedia);
        }
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void onExitFragment() {
        if (this.selectorConfig.isPreviewFullScreenMode) {
            hideFullScreenStatusBar();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.luck.picture.lib.basic.PictureCommonFragment
    public void onExitPictureSelector() {
        PicturePreviewAdapter picturePreviewAdapter = this.viewPageAdapter;
        if (picturePreviewAdapter != null) {
            picturePreviewAdapter.destroy();
        }
        super.onExitPictureSelector();
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void onKeyBackFragmentFinish() {
        onKeyDownBackToMin();
    }

    protected void onMojitoBackgroundAlpha(float f10) {
        for (int i10 = 0; i10 < this.mAnimViews.size(); i10++) {
            if (!(this.mAnimViews.get(i10) instanceof TitleBar)) {
                this.mAnimViews.get(i10).setAlpha(f10);
            }
        }
    }

    protected void onMojitoBeginAnimComplete(MagicalView magicalView, boolean z10) {
        int width;
        int height;
        BasePreviewHolder currentHolder = this.viewPageAdapter.getCurrentHolder(this.viewPager.getCurrentItem());
        if (currentHolder == null) {
            return;
        }
        LocalMedia localMedia = this.mData.get(this.viewPager.getCurrentItem());
        if (localMedia.isCut() && localMedia.getCropImageWidth() > 0 && localMedia.getCropImageHeight() > 0) {
            width = localMedia.getCropImageWidth();
            height = localMedia.getCropImageHeight();
        } else {
            width = localMedia.getWidth();
            height = localMedia.getHeight();
        }
        if (MediaUtils.isLongImage(width, height)) {
            currentHolder.coverImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            currentHolder.coverImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        if (currentHolder instanceof PreviewVideoHolder) {
            PreviewVideoHolder previewVideoHolder = (PreviewVideoHolder) currentHolder;
            if (this.selectorConfig.isAutoVideoPlay) {
                startAutoVideoPlay(this.viewPager.getCurrentItem());
            } else if (previewVideoHolder.ivPlayButton.getVisibility() == 8 && !isPlaying()) {
                previewVideoHolder.ivPlayButton.setVisibility(0);
            }
        }
    }

    protected void onMojitoBeginBackMinAnim() {
        BasePreviewHolder currentHolder = this.viewPageAdapter.getCurrentHolder(this.viewPager.getCurrentItem());
        if (currentHolder == null) {
            return;
        }
        if (currentHolder.coverImageView.getVisibility() == 8) {
            currentHolder.coverImageView.setVisibility(0);
        }
        if (currentHolder instanceof PreviewVideoHolder) {
            PreviewVideoHolder previewVideoHolder = (PreviewVideoHolder) currentHolder;
            if (previewVideoHolder.ivPlayButton.getVisibility() == 0) {
                previewVideoHolder.ivPlayButton.setVisibility(8);
            }
        }
    }

    protected void onMojitoBeginBackMinFinish(boolean z10) {
        int i10;
        BasePreviewHolder currentHolder;
        if (this.isShowCamera) {
            i10 = this.curPosition + 1;
        } else {
            i10 = this.curPosition;
        }
        ViewParams itemViewParams = BuildRecycleItemViewParams.getItemViewParams(i10);
        if (itemViewParams == null || (currentHolder = this.viewPageAdapter.getCurrentHolder(this.viewPager.getCurrentItem())) == null) {
            return;
        }
        currentHolder.coverImageView.getLayoutParams().width = itemViewParams.width;
        currentHolder.coverImageView.getLayoutParams().height = itemViewParams.height;
        currentHolder.coverImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    protected void onMojitoMagicalViewFinish() {
        if (this.isExternalPreview && isNormalDefaultEnter() && isHasMagicalEffect()) {
            onExitPictureSelector();
        } else {
            onBackCurrentFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (isPlaying()) {
            resumePausePlay();
            this.isPause = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.isPause) {
            resumePausePlay();
            this.isPause = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(PictureConfig.EXTRA_CURRENT_PAGE, this.mPage);
        bundle.putLong(PictureConfig.EXTRA_CURRENT_BUCKET_ID, this.mBucketId);
        bundle.putInt(PictureConfig.EXTRA_PREVIEW_CURRENT_POSITION, this.curPosition);
        bundle.putInt(PictureConfig.EXTRA_PREVIEW_CURRENT_ALBUM_TOTAL, this.totalNum);
        bundle.putBoolean(PictureConfig.EXTRA_EXTERNAL_PREVIEW, this.isExternalPreview);
        bundle.putBoolean(PictureConfig.EXTRA_EXTERNAL_PREVIEW_DISPLAY_DELETE, this.isDisplayDelete);
        bundle.putBoolean(PictureConfig.EXTRA_DISPLAY_CAMERA, this.isShowCamera);
        bundle.putBoolean(PictureConfig.EXTRA_BOTTOM_PREVIEW, this.isInternalBottomPreview);
        bundle.putString(PictureConfig.EXTRA_CURRENT_ALBUM_NAME, this.currentAlbum);
        this.selectorConfig.addSelectedPreviewResult(this.mData);
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void onSelectedChange(boolean z10, LocalMedia localMedia) {
        this.tvSelected.setSelected(this.selectorConfig.getSelectedResult().contains(localMedia));
        this.bottomNarBar.setSelectedChange();
        this.completeSelectView.setSelectedChange(true);
        notifySelectNumberStyle(localMedia);
        notifyPreviewGalleryData(z10, localMedia);
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        boolean z10;
        super.onViewCreated(view, bundle);
        reStartSavedInstance(bundle);
        if (bundle != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.isSaveInstanceState = z10;
        this.screenWidth = DensityUtil.getRealScreenWidth(getContext());
        this.screenHeight = DensityUtil.getScreenHeight(getContext());
        this.titleBar = (PreviewTitleBar) view.findViewById(R.id.title_bar);
        this.tvSelected = (TextView) view.findViewById(R.id.ps_tv_selected);
        this.tvSelectedWord = (TextView) view.findViewById(R.id.ps_tv_selected_word);
        this.selectClickArea = view.findViewById(R.id.select_click_area);
        this.completeSelectView = (CompleteSelectView) view.findViewById(R.id.ps_complete_select);
        this.magicalView = (MagicalView) view.findViewById(R.id.magical);
        this.viewPager = new ViewPager2(getContext());
        this.bottomNarBar = (PreviewBottomNavBar) view.findViewById(R.id.bottom_nar_bar);
        this.magicalView.setMagicalContent(this.viewPager);
        setMagicalViewBackgroundColor();
        setMagicalViewAction();
        addAminViews(this.titleBar, this.tvSelected, this.tvSelectedWord, this.selectClickArea, this.completeSelectView, this.bottomNarBar);
        onCreateLoader();
        initTitleBar();
        initViewPagerData(this.mData);
        if (this.isExternalPreview) {
            externalPreviewStyle();
        } else {
            initBottomNavBar();
            initPreviewSelectGallery((ViewGroup) view);
            initComplete();
        }
        iniMagicalView();
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void reStartSavedInstance(Bundle bundle) {
        if (bundle != null) {
            this.mPage = bundle.getInt(PictureConfig.EXTRA_CURRENT_PAGE, 1);
            this.mBucketId = bundle.getLong(PictureConfig.EXTRA_CURRENT_BUCKET_ID, -1L);
            this.curPosition = bundle.getInt(PictureConfig.EXTRA_PREVIEW_CURRENT_POSITION, this.curPosition);
            this.isShowCamera = bundle.getBoolean(PictureConfig.EXTRA_DISPLAY_CAMERA, this.isShowCamera);
            this.totalNum = bundle.getInt(PictureConfig.EXTRA_PREVIEW_CURRENT_ALBUM_TOTAL, this.totalNum);
            this.isExternalPreview = bundle.getBoolean(PictureConfig.EXTRA_EXTERNAL_PREVIEW, this.isExternalPreview);
            this.isDisplayDelete = bundle.getBoolean(PictureConfig.EXTRA_EXTERNAL_PREVIEW_DISPLAY_DELETE, this.isDisplayDelete);
            this.isInternalBottomPreview = bundle.getBoolean(PictureConfig.EXTRA_BOTTOM_PREVIEW, this.isInternalBottomPreview);
            this.currentAlbum = bundle.getString(PictureConfig.EXTRA_CURRENT_ALBUM_NAME, "");
            if (this.mData.size() == 0) {
                this.mData.addAll(new ArrayList(this.selectorConfig.selectedPreviewResult));
            }
        }
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void sendChangeSubSelectPositionEvent(boolean z10) {
        if (this.selectorConfig.selectorStyle.getSelectMainStyle().isPreviewSelectNumberStyle() && this.selectorConfig.selectorStyle.getSelectMainStyle().isSelectNumberStyle()) {
            int i10 = 0;
            while (i10 < this.selectorConfig.getSelectCount()) {
                LocalMedia localMedia = this.selectorConfig.getSelectedResult().get(i10);
                i10++;
                localMedia.setNum(i10);
            }
        }
    }

    public void setExternalPreviewData(int i10, int i11, ArrayList<LocalMedia> arrayList, boolean z10) {
        this.mData = arrayList;
        this.totalNum = i11;
        this.curPosition = i10;
        this.isDisplayDelete = z10;
        this.isExternalPreview = true;
    }

    public void setInternalPreviewData(boolean z10, String str, boolean z11, int i10, int i11, int i12, long j10, ArrayList<LocalMedia> arrayList) {
        this.mPage = i12;
        this.mBucketId = j10;
        this.mData = arrayList;
        this.totalNum = i11;
        this.curPosition = i10;
        this.currentAlbum = str;
        this.isShowCamera = z11;
        this.isInternalBottomPreview = z10;
    }

    protected void setMagicalViewAction() {
        if (isHasMagicalEffect()) {
            this.magicalView.setOnMojitoViewCallback(new OnMagicalViewCallback() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.1
                @Override // com.luck.picture.lib.magical.OnMagicalViewCallback
                public void onBackgroundAlpha(float f10) {
                    PictureSelectorPreviewFragment.this.onMojitoBackgroundAlpha(f10);
                }

                @Override // com.luck.picture.lib.magical.OnMagicalViewCallback
                public void onBeginBackMinAnim() {
                    PictureSelectorPreviewFragment.this.onMojitoBeginBackMinAnim();
                }

                @Override // com.luck.picture.lib.magical.OnMagicalViewCallback
                public void onBeginBackMinMagicalFinish(boolean z10) {
                    PictureSelectorPreviewFragment.this.onMojitoBeginBackMinFinish(z10);
                }

                @Override // com.luck.picture.lib.magical.OnMagicalViewCallback
                public void onBeginMagicalAnimComplete(MagicalView magicalView, boolean z10) {
                    PictureSelectorPreviewFragment.this.onMojitoBeginAnimComplete(magicalView, z10);
                }

                @Override // com.luck.picture.lib.magical.OnMagicalViewCallback
                public void onMagicalViewFinish() {
                    PictureSelectorPreviewFragment.this.onMojitoMagicalViewFinish();
                }
            });
        }
    }

    protected void startZoomEffect(LocalMedia localMedia) {
        if (!this.isSaveInstanceState && !this.isInternalBottomPreview && this.selectorConfig.isPreviewZoomEffect) {
            this.viewPager.post(new Runnable() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.16
                @Override // java.lang.Runnable
                public void run() {
                    PictureSelectorPreviewFragment pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.this;
                    pictureSelectorPreviewFragment.viewPageAdapter.setCoverScaleType(pictureSelectorPreviewFragment.curPosition);
                }
            });
            if (PictureMimeType.isHasVideo(localMedia.getMimeType())) {
                getVideoRealSizeFromMedia(localMedia, !PictureMimeType.isHasHttp(localMedia.getAvailablePath()), new OnCallbackListener<int[]>() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.17
                    @Override // com.luck.picture.lib.interfaces.OnCallbackListener
                    public void onCall(int[] iArr) {
                        PictureSelectorPreviewFragment.this.start(iArr);
                    }
                });
            } else {
                getImageRealSizeFromMedia(localMedia, !PictureMimeType.isHasHttp(localMedia.getAvailablePath()), new OnCallbackListener<int[]>() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.18
                    @Override // com.luck.picture.lib.interfaces.OnCallbackListener
                    public void onCall(int[] iArr) {
                        PictureSelectorPreviewFragment.this.start(iArr);
                    }
                });
            }
        }
    }
}
