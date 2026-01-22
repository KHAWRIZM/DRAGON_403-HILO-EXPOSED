package com.luck.picture.lib.basic;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import androidx.activity.result.d;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.luck.picture.lib.PictureSelectorFragment;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.engine.CompressEngine;
import com.luck.picture.lib.engine.CompressFileEngine;
import com.luck.picture.lib.engine.CropEngine;
import com.luck.picture.lib.engine.CropFileEngine;
import com.luck.picture.lib.engine.ExtendLoaderEngine;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.engine.SandboxFileEngine;
import com.luck.picture.lib.engine.UriToFileTransformEngine;
import com.luck.picture.lib.engine.VideoPlayerEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnBitmapWatermarkEventListener;
import com.luck.picture.lib.interfaces.OnCameraInterceptListener;
import com.luck.picture.lib.interfaces.OnCustomLoadingListener;
import com.luck.picture.lib.interfaces.OnGridItemSelectAnimListener;
import com.luck.picture.lib.interfaces.OnInjectLayoutResourceListener;
import com.luck.picture.lib.interfaces.OnMediaEditInterceptListener;
import com.luck.picture.lib.interfaces.OnPermissionDeniedListener;
import com.luck.picture.lib.interfaces.OnPermissionDescriptionListener;
import com.luck.picture.lib.interfaces.OnPermissionsInterceptListener;
import com.luck.picture.lib.interfaces.OnPreviewInterceptListener;
import com.luck.picture.lib.interfaces.OnQueryFilterListener;
import com.luck.picture.lib.interfaces.OnRecordAudioInterceptListener;
import com.luck.picture.lib.interfaces.OnResultCallbackListener;
import com.luck.picture.lib.interfaces.OnSelectAnimListener;
import com.luck.picture.lib.interfaces.OnSelectFilterListener;
import com.luck.picture.lib.interfaces.OnSelectLimitTipsListener;
import com.luck.picture.lib.interfaces.OnVideoThumbnailEventListener;
import com.luck.picture.lib.style.PictureSelectorStyle;
import com.luck.picture.lib.utils.DoubleUtils;
import com.luck.picture.lib.utils.SdkVersionUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class PictureSelectionModel {
    private final SelectorConfig selectionConfig;
    private final PictureSelector selector;

    public PictureSelectionModel(PictureSelector pictureSelector, int i10) {
        this.selector = pictureSelector;
        SelectorConfig selectorConfig = new SelectorConfig();
        this.selectionConfig = selectorConfig;
        SelectorProviders.getInstance().addSelectorConfigQueue(selectorConfig);
        selectorConfig.chooseMode = i10;
        setMaxVideoSelectNum(selectorConfig.maxVideoSelectNum);
    }

    public PictureSelectorFragment build() {
        Activity activity = this.selector.getActivity();
        if (activity != null) {
            if (activity instanceof IBridgePictureBehavior) {
                SelectorConfig selectorConfig = this.selectionConfig;
                selectorConfig.isResultListenerBack = false;
                selectorConfig.isActivityResultBack = true;
                selectorConfig.onResultCallListener = null;
                return new PictureSelectorFragment();
            }
            throw new NullPointerException("Use only build PictureSelectorFragment,Activity or Fragment interface needs to be implemented " + IBridgePictureBehavior.class);
        }
        throw new NullPointerException("Activity cannot be null");
    }

    public PictureSelectorFragment buildLaunch(int i10, OnResultCallbackListener<LocalMedia> onResultCallbackListener) {
        FragmentManager fragmentManager;
        Activity activity = this.selector.getActivity();
        if (activity != null) {
            if (onResultCallbackListener != null) {
                SelectorConfig selectorConfig = this.selectionConfig;
                selectorConfig.isResultListenerBack = true;
                selectorConfig.isActivityResultBack = false;
                selectorConfig.onResultCallListener = onResultCallbackListener;
                if (activity instanceof FragmentActivity) {
                    fragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
                } else {
                    fragmentManager = null;
                }
                if (fragmentManager != null) {
                    PictureSelectorFragment pictureSelectorFragment = new PictureSelectorFragment();
                    Fragment findFragmentByTag = fragmentManager.findFragmentByTag(pictureSelectorFragment.getFragmentTag());
                    if (findFragmentByTag != null) {
                        fragmentManager.beginTransaction().remove(findFragmentByTag).commitAllowingStateLoss();
                    }
                    fragmentManager.beginTransaction().add(i10, pictureSelectorFragment, pictureSelectorFragment.getFragmentTag()).addToBackStack(pictureSelectorFragment.getFragmentTag()).commitAllowingStateLoss();
                    return pictureSelectorFragment;
                }
                throw new NullPointerException("FragmentManager cannot be null");
            }
            throw new NullPointerException("OnResultCallbackListener cannot be null");
        }
        throw new NullPointerException("Activity cannot be null");
    }

    public void forResult(OnResultCallbackListener<LocalMedia> onResultCallbackListener) {
        if (DoubleUtils.isFastDoubleClick()) {
            return;
        }
        Activity activity = this.selector.getActivity();
        if (activity == null) {
            throw new NullPointerException("Activity cannot be null");
        }
        if (onResultCallbackListener != null) {
            SelectorConfig selectorConfig = this.selectionConfig;
            selectorConfig.isResultListenerBack = true;
            selectorConfig.isActivityResultBack = false;
            selectorConfig.onResultCallListener = onResultCallbackListener;
            if (selectorConfig.imageEngine == null && selectorConfig.chooseMode != SelectMimeType.ofAudio()) {
                throw new NullPointerException("imageEngine is null,Please implement ImageEngine");
            }
            activity.startActivity(new Intent(activity, (Class<?>) PictureSelectorSupporterActivity.class));
            activity.overridePendingTransition(this.selectionConfig.selectorStyle.getWindowAnimationStyle().activityEnterAnimation, R.anim.ps_anim_fade_in);
            return;
        }
        throw new NullPointerException("OnResultCallbackListener cannot be null");
    }

    public PictureSelectionModel isAutoVideoPlay(boolean z10) {
        this.selectionConfig.isAutoVideoPlay = z10;
        return this;
    }

    public PictureSelectionModel isAutomaticTitleRecyclerTop(boolean z10) {
        this.selectionConfig.isAutomaticTitleRecyclerTop = z10;
        return this;
    }

    public PictureSelectionModel isBmp(boolean z10) {
        this.selectionConfig.isBmp = z10;
        return this;
    }

    public PictureSelectionModel isCameraAroundState(boolean z10) {
        this.selectionConfig.isCameraAroundState = z10;
        return this;
    }

    public PictureSelectionModel isCameraForegroundService(boolean z10) {
        this.selectionConfig.isCameraForegroundService = z10;
        return this;
    }

    public PictureSelectionModel isCameraRotateImage(boolean z10) {
        this.selectionConfig.isCameraRotateImage = z10;
        return this;
    }

    public PictureSelectionModel isDirectReturnSingle(boolean z10) {
        boolean z11 = false;
        if (z10) {
            this.selectionConfig.isFastSlidingSelect = false;
        }
        SelectorConfig selectorConfig = this.selectionConfig;
        if (selectorConfig.selectionMode == 1 && z10) {
            z11 = true;
        }
        selectorConfig.isDirectReturnSingle = z11;
        return this;
    }

    public PictureSelectionModel isDisplayCamera(boolean z10) {
        this.selectionConfig.isDisplayCamera = z10;
        return this;
    }

    public PictureSelectionModel isDisplayTimeAxis(boolean z10) {
        this.selectionConfig.isDisplayTimeAxis = z10;
        return this;
    }

    public PictureSelectionModel isEmptyResultReturn(boolean z10) {
        this.selectionConfig.isEmptyResultReturn = z10;
        return this;
    }

    @Deprecated
    public PictureSelectionModel isEnableVideoSize(boolean z10) {
        this.selectionConfig.isSyncWidthAndHeight = z10;
        return this;
    }

    public PictureSelectionModel isFastSlidingSelect(boolean z10) {
        SelectorConfig selectorConfig = this.selectionConfig;
        if (selectorConfig.isDirectReturnSingle) {
            selectorConfig.isFastSlidingSelect = false;
        } else {
            selectorConfig.isFastSlidingSelect = z10;
        }
        return this;
    }

    public PictureSelectionModel isFilterSizeDuration(boolean z10) {
        this.selectionConfig.isFilterSizeDuration = z10;
        return this;
    }

    public PictureSelectionModel isGif(boolean z10) {
        this.selectionConfig.isGif = z10;
        return this;
    }

    public PictureSelectionModel isHeic(boolean z10) {
        this.selectionConfig.isHeic = z10;
        return this;
    }

    public PictureSelectionModel isLoopAutoVideoPlay(boolean z10) {
        this.selectionConfig.isLoopAutoPlay = z10;
        return this;
    }

    public PictureSelectionModel isMaxSelectEnabledMask(boolean z10) {
        this.selectionConfig.isMaxSelectEnabledMask = z10;
        return this;
    }

    public PictureSelectionModel isNewKeyBackMode(boolean z10) {
        this.selectionConfig.isNewKeyBackMode = z10;
        return this;
    }

    public PictureSelectionModel isOnlyObtainSandboxDir(boolean z10) {
        this.selectionConfig.isOnlySandboxDir = z10;
        return this;
    }

    public PictureSelectionModel isOpenClickSound(boolean z10) {
        this.selectionConfig.isOpenClickSound = z10;
        return this;
    }

    public PictureSelectionModel isOriginalControl(boolean z10) {
        this.selectionConfig.isOriginalControl = z10;
        return this;
    }

    public PictureSelectionModel isOriginalSkipCompress(boolean z10) {
        this.selectionConfig.isOriginalSkipCompress = z10;
        return this;
    }

    public PictureSelectionModel isPageStrategy(boolean z10) {
        this.selectionConfig.isPageStrategy = z10;
        return this;
    }

    public PictureSelectionModel isPageSyncAlbumCount(boolean z10) {
        this.selectionConfig.isPageSyncAsCount = z10;
        return this;
    }

    public PictureSelectionModel isPreloadFirst(boolean z10) {
        this.selectionConfig.isPreloadFirst = z10;
        return this;
    }

    public PictureSelectionModel isPreviewAudio(boolean z10) {
        this.selectionConfig.isEnablePreviewAudio = z10;
        return this;
    }

    public PictureSelectionModel isPreviewFullScreenMode(boolean z10) {
        this.selectionConfig.isPreviewFullScreenMode = z10;
        return this;
    }

    public PictureSelectionModel isPreviewImage(boolean z10) {
        this.selectionConfig.isEnablePreviewImage = z10;
        return this;
    }

    public PictureSelectionModel isPreviewVideo(boolean z10) {
        this.selectionConfig.isEnablePreviewVideo = z10;
        return this;
    }

    public PictureSelectionModel isPreviewZoomEffect(boolean z10) {
        if (this.selectionConfig.chooseMode == SelectMimeType.ofAudio()) {
            this.selectionConfig.isPreviewZoomEffect = false;
        } else {
            this.selectionConfig.isPreviewZoomEffect = z10;
        }
        return this;
    }

    public PictureSelectionModel isQuickCapture(boolean z10) {
        this.selectionConfig.isQuickCapture = z10;
        return this;
    }

    public PictureSelectionModel isSelectZoomAnim(boolean z10) {
        this.selectionConfig.isSelectZoomAnim = z10;
        return this;
    }

    public PictureSelectionModel isSyncCover(boolean z10) {
        this.selectionConfig.isSyncCover = z10;
        return this;
    }

    public PictureSelectionModel isSyncWidthAndHeight(boolean z10) {
        this.selectionConfig.isSyncWidthAndHeight = z10;
        return this;
    }

    public PictureSelectionModel isUseSystemVideoPlayer(boolean z10) {
        this.selectionConfig.isUseSystemVideoPlayer = z10;
        return this;
    }

    public PictureSelectionModel isVideoPauseResumePlay(boolean z10) {
        this.selectionConfig.isPauseResumePlay = z10;
        return this;
    }

    public PictureSelectionModel isWebp(boolean z10) {
        this.selectionConfig.isWebp = z10;
        return this;
    }

    public PictureSelectionModel isWithSelectVideoImage(boolean z10) {
        boolean z11;
        SelectorConfig selectorConfig = this.selectionConfig;
        if (selectorConfig.chooseMode == SelectMimeType.ofAll() && z10) {
            z11 = true;
        } else {
            z11 = false;
        }
        selectorConfig.isWithVideoImage = z11;
        return this;
    }

    public PictureSelectionModel setAddBitmapWatermarkListener(OnBitmapWatermarkEventListener onBitmapWatermarkEventListener) {
        if (this.selectionConfig.chooseMode != SelectMimeType.ofAudio()) {
            this.selectionConfig.onBitmapWatermarkListener = onBitmapWatermarkEventListener;
        }
        return this;
    }

    public PictureSelectionModel setAttachViewLifecycle(IBridgeViewLifecycle iBridgeViewLifecycle) {
        this.selectionConfig.viewLifecycle = iBridgeViewLifecycle;
        return this;
    }

    public PictureSelectionModel setCameraImageFormat(String str) {
        this.selectionConfig.cameraImageFormat = str;
        return this;
    }

    public PictureSelectionModel setCameraImageFormatForQ(String str) {
        this.selectionConfig.cameraImageFormatForQ = str;
        return this;
    }

    public PictureSelectionModel setCameraInterceptListener(OnCameraInterceptListener onCameraInterceptListener) {
        this.selectionConfig.onCameraInterceptListener = onCameraInterceptListener;
        return this;
    }

    public PictureSelectionModel setCameraVideoFormat(String str) {
        this.selectionConfig.cameraVideoFormat = str;
        return this;
    }

    public PictureSelectionModel setCameraVideoFormatForQ(String str) {
        this.selectionConfig.cameraVideoFormatForQ = str;
        return this;
    }

    @Deprecated
    public PictureSelectionModel setCompressEngine(CompressEngine compressEngine) {
        SelectorConfig selectorConfig = this.selectionConfig;
        selectorConfig.compressEngine = compressEngine;
        selectorConfig.isCompressEngine = true;
        return this;
    }

    @Deprecated
    public PictureSelectionModel setCropEngine(CropEngine cropEngine) {
        this.selectionConfig.cropEngine = cropEngine;
        return this;
    }

    public PictureSelectionModel setCustomLoadingListener(OnCustomLoadingListener onCustomLoadingListener) {
        this.selectionConfig.onCustomLoadingListener = onCustomLoadingListener;
        return this;
    }

    public PictureSelectionModel setDefaultAlbumName(String str) {
        this.selectionConfig.defaultAlbumName = str;
        return this;
    }

    public PictureSelectionModel setDefaultLanguage(int i10) {
        this.selectionConfig.defaultLanguage = i10;
        return this;
    }

    public PictureSelectionModel setEditMediaInterceptListener(OnMediaEditInterceptListener onMediaEditInterceptListener) {
        this.selectionConfig.onEditMediaEventListener = onMediaEditInterceptListener;
        return this;
    }

    @Deprecated
    public PictureSelectionModel setExtendLoaderEngine(ExtendLoaderEngine extendLoaderEngine) {
        SelectorConfig selectorConfig = this.selectionConfig;
        selectorConfig.loaderDataEngine = extendLoaderEngine;
        selectorConfig.isLoaderDataEngine = true;
        return this;
    }

    public PictureSelectionModel setFilterMaxFileSize(long j10) {
        if (j10 >= 1048576) {
            this.selectionConfig.filterMaxFileSize = j10;
        } else {
            this.selectionConfig.filterMaxFileSize = j10 * 1024;
        }
        return this;
    }

    public PictureSelectionModel setFilterMinFileSize(long j10) {
        if (j10 >= 1048576) {
            this.selectionConfig.filterMinFileSize = j10;
        } else {
            this.selectionConfig.filterMinFileSize = j10 * 1024;
        }
        return this;
    }

    public PictureSelectionModel setFilterVideoMaxSecond(int i10) {
        this.selectionConfig.filterVideoMaxSecond = i10 * 1000;
        return this;
    }

    public PictureSelectionModel setFilterVideoMinSecond(int i10) {
        this.selectionConfig.filterVideoMinSecond = i10 * 1000;
        return this;
    }

    public PictureSelectionModel setGridItemSelectAnimListener(OnGridItemSelectAnimListener onGridItemSelectAnimListener) {
        this.selectionConfig.onItemSelectAnimListener = onGridItemSelectAnimListener;
        return this;
    }

    public PictureSelectionModel setImageEngine(ImageEngine imageEngine) {
        this.selectionConfig.imageEngine = imageEngine;
        return this;
    }

    public PictureSelectionModel setImageSpanCount(int i10) {
        this.selectionConfig.imageSpanCount = i10;
        return this;
    }

    public PictureSelectionModel setInjectLayoutResourceListener(OnInjectLayoutResourceListener onInjectLayoutResourceListener) {
        boolean z10;
        SelectorConfig selectorConfig = this.selectionConfig;
        if (onInjectLayoutResourceListener != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        selectorConfig.isInjectLayoutResource = z10;
        selectorConfig.onLayoutResourceListener = onInjectLayoutResourceListener;
        return this;
    }

    public PictureSelectionModel setLanguage(int i10) {
        this.selectionConfig.language = i10;
        return this;
    }

    public PictureSelectionModel setLoaderFactoryEngine(IBridgeLoaderFactory iBridgeLoaderFactory) {
        SelectorConfig selectorConfig = this.selectionConfig;
        selectorConfig.loaderFactory = iBridgeLoaderFactory;
        selectorConfig.isLoaderFactoryEngine = true;
        return this;
    }

    public PictureSelectionModel setMagicalEffectInterpolator(InterpolatorFactory interpolatorFactory) {
        this.selectionConfig.interpolatorFactory = interpolatorFactory;
        return this;
    }

    public PictureSelectionModel setMaxSelectNum(int i10) {
        SelectorConfig selectorConfig = this.selectionConfig;
        if (selectorConfig.selectionMode == 1) {
            i10 = 1;
        }
        selectorConfig.maxSelectNum = i10;
        return this;
    }

    public PictureSelectionModel setMaxVideoSelectNum(int i10) {
        SelectorConfig selectorConfig = this.selectionConfig;
        if (selectorConfig.chooseMode == SelectMimeType.ofVideo()) {
            i10 = 0;
        }
        selectorConfig.maxVideoSelectNum = i10;
        return this;
    }

    public PictureSelectionModel setMinAudioSelectNum(int i10) {
        this.selectionConfig.minAudioSelectNum = i10;
        return this;
    }

    public PictureSelectionModel setMinSelectNum(int i10) {
        this.selectionConfig.minSelectNum = i10;
        return this;
    }

    public PictureSelectionModel setMinVideoSelectNum(int i10) {
        this.selectionConfig.minVideoSelectNum = i10;
        return this;
    }

    public PictureSelectionModel setOfAllCameraType(int i10) {
        this.selectionConfig.ofAllCameraType = i10;
        return this;
    }

    public PictureSelectionModel setOutputAudioDir(String str) {
        this.selectionConfig.outPutAudioDir = str;
        return this;
    }

    public PictureSelectionModel setOutputAudioFileName(String str) {
        this.selectionConfig.outPutAudioFileName = str;
        return this;
    }

    public PictureSelectionModel setOutputCameraDir(String str) {
        this.selectionConfig.outPutCameraDir = str;
        return this;
    }

    public PictureSelectionModel setOutputCameraImageFileName(String str) {
        this.selectionConfig.outPutCameraImageFileName = str;
        return this;
    }

    public PictureSelectionModel setOutputCameraVideoFileName(String str) {
        this.selectionConfig.outPutCameraVideoFileName = str;
        return this;
    }

    public PictureSelectionModel setPermissionDeniedListener(OnPermissionDeniedListener onPermissionDeniedListener) {
        this.selectionConfig.onPermissionDeniedListener = onPermissionDeniedListener;
        return this;
    }

    public PictureSelectionModel setPermissionDescriptionListener(OnPermissionDescriptionListener onPermissionDescriptionListener) {
        this.selectionConfig.onPermissionDescriptionListener = onPermissionDescriptionListener;
        return this;
    }

    public PictureSelectionModel setPermissionsInterceptListener(OnPermissionsInterceptListener onPermissionsInterceptListener) {
        this.selectionConfig.onPermissionsEventListener = onPermissionsInterceptListener;
        return this;
    }

    public PictureSelectionModel setPreviewInterceptListener(OnPreviewInterceptListener onPreviewInterceptListener) {
        this.selectionConfig.onPreviewInterceptListener = onPreviewInterceptListener;
        return this;
    }

    public PictureSelectionModel setQueryFilterListener(OnQueryFilterListener onQueryFilterListener) {
        this.selectionConfig.onQueryFilterListener = onQueryFilterListener;
        return this;
    }

    public PictureSelectionModel setQueryOnlyMimeType(String... strArr) {
        for (String str : strArr) {
            if (PictureMimeType.isHasImage(str)) {
                if (!this.selectionConfig.queryOnlyImageList.contains(str)) {
                    this.selectionConfig.queryOnlyImageList.add(str);
                }
            } else if (PictureMimeType.isHasVideo(str)) {
                if (!this.selectionConfig.queryOnlyVideoList.contains(str)) {
                    this.selectionConfig.queryOnlyVideoList.add(str);
                }
            } else if (PictureMimeType.isHasAudio(str) && !this.selectionConfig.queryOnlyAudioList.contains(str)) {
                this.selectionConfig.queryOnlyAudioList.add(str);
            }
        }
        return this;
    }

    public PictureSelectionModel setQuerySandboxDir(String str) {
        this.selectionConfig.sandboxDir = str;
        return this;
    }

    public PictureSelectionModel setQuerySortOrder(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.selectionConfig.sortOrder = str;
        }
        return this;
    }

    public PictureSelectionModel setRecordAudioInterceptListener(OnRecordAudioInterceptListener onRecordAudioInterceptListener) {
        this.selectionConfig.onRecordAudioListener = onRecordAudioInterceptListener;
        return this;
    }

    public PictureSelectionModel setRecordVideoMaxSecond(int i10) {
        this.selectionConfig.recordVideoMaxSecond = i10;
        return this;
    }

    public PictureSelectionModel setRecordVideoMinSecond(int i10) {
        this.selectionConfig.recordVideoMinSecond = i10;
        return this;
    }

    public PictureSelectionModel setRecyclerAnimationMode(int i10) {
        this.selectionConfig.animationMode = i10;
        return this;
    }

    public PictureSelectionModel setRequestedOrientation(int i10) {
        this.selectionConfig.requestedOrientation = i10;
        return this;
    }

    @Deprecated
    public PictureSelectionModel setSandboxFileEngine(SandboxFileEngine sandboxFileEngine) {
        if (SdkVersionUtils.isQ()) {
            SelectorConfig selectorConfig = this.selectionConfig;
            selectorConfig.sandboxFileEngine = sandboxFileEngine;
            selectorConfig.isSandboxFileEngine = true;
        } else {
            this.selectionConfig.isSandboxFileEngine = false;
        }
        return this;
    }

    public PictureSelectionModel setSelectAnimListener(OnSelectAnimListener onSelectAnimListener) {
        this.selectionConfig.onSelectAnimListener = onSelectAnimListener;
        return this;
    }

    public PictureSelectionModel setSelectFilterListener(OnSelectFilterListener onSelectFilterListener) {
        this.selectionConfig.onSelectFilterListener = onSelectFilterListener;
        return this;
    }

    public PictureSelectionModel setSelectLimitTipsListener(OnSelectLimitTipsListener onSelectLimitTipsListener) {
        this.selectionConfig.onSelectLimitTipsListener = onSelectLimitTipsListener;
        return this;
    }

    public PictureSelectionModel setSelectMaxDurationSecond(int i10) {
        this.selectionConfig.selectMaxDurationSecond = i10 * 1000;
        return this;
    }

    public PictureSelectionModel setSelectMaxFileSize(long j10) {
        if (j10 >= 1048576) {
            this.selectionConfig.selectMaxFileSize = j10;
        } else {
            this.selectionConfig.selectMaxFileSize = j10 * 1024;
        }
        return this;
    }

    public PictureSelectionModel setSelectMinDurationSecond(int i10) {
        this.selectionConfig.selectMinDurationSecond = i10 * 1000;
        return this;
    }

    public PictureSelectionModel setSelectMinFileSize(long j10) {
        if (j10 >= 1048576) {
            this.selectionConfig.selectMinFileSize = j10;
        } else {
            this.selectionConfig.selectMinFileSize = j10 * 1024;
        }
        return this;
    }

    public PictureSelectionModel setSelectedData(List<LocalMedia> list) {
        if (list == null) {
            return this;
        }
        SelectorConfig selectorConfig = this.selectionConfig;
        if (selectorConfig.selectionMode == 1 && selectorConfig.isDirectReturnSingle) {
            selectorConfig.selectedResult.clear();
        } else {
            selectorConfig.addAllSelectResult(new ArrayList<>(list));
        }
        return this;
    }

    public PictureSelectionModel setSelectionMode(int i10) {
        SelectorConfig selectorConfig = this.selectionConfig;
        selectorConfig.selectionMode = i10;
        int i11 = 1;
        if (i10 != 1) {
            i11 = selectorConfig.maxSelectNum;
        }
        selectorConfig.maxSelectNum = i11;
        return this;
    }

    public PictureSelectionModel setSelectorUIStyle(PictureSelectorStyle pictureSelectorStyle) {
        if (pictureSelectorStyle != null) {
            this.selectionConfig.selectorStyle = pictureSelectorStyle;
        }
        return this;
    }

    public PictureSelectionModel setSkipCropMimeType(String... strArr) {
        if (strArr != null && strArr.length > 0) {
            this.selectionConfig.skipCropList.addAll(Arrays.asList(strArr));
        }
        return this;
    }

    public PictureSelectionModel setVideoPlayerEngine(VideoPlayerEngine videoPlayerEngine) {
        this.selectionConfig.videoPlayerEngine = videoPlayerEngine;
        return this;
    }

    @Deprecated
    public PictureSelectionModel setVideoQuality(int i10) {
        this.selectionConfig.videoQuality = i10;
        return this;
    }

    public PictureSelectionModel setVideoThumbnailListener(OnVideoThumbnailEventListener onVideoThumbnailEventListener) {
        if (this.selectionConfig.chooseMode != SelectMimeType.ofAudio()) {
            this.selectionConfig.onVideoThumbnailEventListener = onVideoThumbnailEventListener;
        }
        return this;
    }

    public PictureSelectionModel isPageStrategy(boolean z10, int i10) {
        SelectorConfig selectorConfig = this.selectionConfig;
        selectorConfig.isPageStrategy = z10;
        if (i10 < 10) {
            i10 = 60;
        }
        selectorConfig.pageSize = i10;
        return this;
    }

    public PictureSelectionModel setCropEngine(CropFileEngine cropFileEngine) {
        this.selectionConfig.cropFileEngine = cropFileEngine;
        return this;
    }

    public PictureSelectionModel setCompressEngine(CompressFileEngine compressFileEngine) {
        SelectorConfig selectorConfig = this.selectionConfig;
        selectorConfig.compressFileEngine = compressFileEngine;
        selectorConfig.isCompressEngine = true;
        return this;
    }

    @Deprecated
    public PictureSelectionModel isPageStrategy(boolean z10, boolean z11) {
        SelectorConfig selectorConfig = this.selectionConfig;
        selectorConfig.isPageStrategy = z10;
        selectorConfig.isFilterInvalidFile = z11;
        return this;
    }

    public PictureSelectionModel setSandboxFileEngine(UriToFileTransformEngine uriToFileTransformEngine) {
        if (SdkVersionUtils.isQ()) {
            SelectorConfig selectorConfig = this.selectionConfig;
            selectorConfig.uriToFileTransformEngine = uriToFileTransformEngine;
            selectorConfig.isSandboxFileEngine = true;
        } else {
            this.selectionConfig.isSandboxFileEngine = false;
        }
        return this;
    }

    @Deprecated
    public PictureSelectionModel isPageStrategy(boolean z10, int i10, boolean z11) {
        SelectorConfig selectorConfig = this.selectionConfig;
        selectorConfig.isPageStrategy = z10;
        if (i10 < 10) {
            i10 = 60;
        }
        selectorConfig.pageSize = i10;
        selectorConfig.isFilterInvalidFile = z11;
        return this;
    }

    public void forResult(int i10) {
        if (DoubleUtils.isFastDoubleClick()) {
            return;
        }
        Activity activity = this.selector.getActivity();
        if (activity != null) {
            SelectorConfig selectorConfig = this.selectionConfig;
            selectorConfig.isResultListenerBack = false;
            selectorConfig.isActivityResultBack = true;
            if (selectorConfig.imageEngine == null && selectorConfig.chooseMode != SelectMimeType.ofAudio()) {
                throw new NullPointerException("imageEngine is null,Please implement ImageEngine");
            }
            Intent intent = new Intent(activity, (Class<?>) PictureSelectorSupporterActivity.class);
            Fragment fragment = this.selector.getFragment();
            if (fragment != null) {
                fragment.startActivityForResult(intent, i10);
            } else {
                activity.startActivityForResult(intent, i10);
            }
            activity.overridePendingTransition(this.selectionConfig.selectorStyle.getWindowAnimationStyle().activityEnterAnimation, R.anim.ps_anim_fade_in);
            return;
        }
        throw new NullPointerException("Activity cannot be null");
    }

    public void forResult(d dVar) {
        if (DoubleUtils.isFastDoubleClick()) {
            return;
        }
        Activity activity = this.selector.getActivity();
        if (activity == null) {
            throw new NullPointerException("Activity cannot be null");
        }
        if (dVar != null) {
            SelectorConfig selectorConfig = this.selectionConfig;
            selectorConfig.isResultListenerBack = false;
            selectorConfig.isActivityResultBack = true;
            if (selectorConfig.imageEngine == null && selectorConfig.chooseMode != SelectMimeType.ofAudio()) {
                throw new NullPointerException("imageEngine is null,Please implement ImageEngine");
            }
            dVar.launch(new Intent(activity, (Class<?>) PictureSelectorSupporterActivity.class));
            activity.overridePendingTransition(this.selectionConfig.selectorStyle.getWindowAnimationStyle().activityEnterAnimation, R.anim.ps_anim_fade_in);
            return;
        }
        throw new NullPointerException("ActivityResultLauncher cannot be null");
    }
}
