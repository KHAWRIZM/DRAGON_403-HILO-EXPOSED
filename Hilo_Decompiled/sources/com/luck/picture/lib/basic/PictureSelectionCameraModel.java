package com.luck.picture.lib.basic;

import android.app.Activity;
import android.content.Intent;
import androidx.activity.result.d;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.luck.picture.lib.PictureOnlyCameraFragment;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.engine.CompressEngine;
import com.luck.picture.lib.engine.CompressFileEngine;
import com.luck.picture.lib.engine.CropEngine;
import com.luck.picture.lib.engine.CropFileEngine;
import com.luck.picture.lib.engine.SandboxFileEngine;
import com.luck.picture.lib.engine.UriToFileTransformEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnBitmapWatermarkEventListener;
import com.luck.picture.lib.interfaces.OnCameraInterceptListener;
import com.luck.picture.lib.interfaces.OnCustomLoadingListener;
import com.luck.picture.lib.interfaces.OnPermissionDeniedListener;
import com.luck.picture.lib.interfaces.OnPermissionDescriptionListener;
import com.luck.picture.lib.interfaces.OnPermissionsInterceptListener;
import com.luck.picture.lib.interfaces.OnRecordAudioInterceptListener;
import com.luck.picture.lib.interfaces.OnResultCallbackListener;
import com.luck.picture.lib.interfaces.OnSelectLimitTipsListener;
import com.luck.picture.lib.interfaces.OnVideoThumbnailEventListener;
import com.luck.picture.lib.utils.DoubleUtils;
import com.luck.picture.lib.utils.SdkVersionUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class PictureSelectionCameraModel {
    private final SelectorConfig selectionConfig;
    private final PictureSelector selector;

    public PictureSelectionCameraModel(PictureSelector pictureSelector, int i10) {
        this.selector = pictureSelector;
        SelectorConfig selectorConfig = new SelectorConfig();
        this.selectionConfig = selectorConfig;
        SelectorProviders.getInstance().addSelectorConfigQueue(selectorConfig);
        selectorConfig.chooseMode = i10;
        selectorConfig.isOnlyCamera = true;
        selectorConfig.isDisplayTimeAxis = false;
        selectorConfig.isPreviewFullScreenMode = false;
        selectorConfig.isPreviewZoomEffect = false;
        selectorConfig.isOpenClickSound = false;
    }

    private PictureSelectionCameraModel setMaxSelectNum(int i10) {
        SelectorConfig selectorConfig = this.selectionConfig;
        if (selectorConfig.selectionMode == 1) {
            i10 = 1;
        }
        selectorConfig.maxSelectNum = i10;
        return this;
    }

    public PictureOnlyCameraFragment build() {
        Activity activity = this.selector.getActivity();
        if (activity != null) {
            if (activity instanceof IBridgePictureBehavior) {
                SelectorConfig selectorConfig = this.selectionConfig;
                selectorConfig.isResultListenerBack = false;
                selectorConfig.isActivityResultBack = true;
                selectorConfig.onResultCallListener = null;
                return new PictureOnlyCameraFragment();
            }
            throw new NullPointerException("Use only build PictureOnlyCameraFragment,Activity or Fragment interface needs to be implemented " + IBridgePictureBehavior.class);
        }
        throw new NullPointerException("Activity cannot be null");
    }

    public PictureOnlyCameraFragment buildLaunch(int i10, OnResultCallbackListener<LocalMedia> onResultCallbackListener) {
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
                    PictureOnlyCameraFragment pictureOnlyCameraFragment = new PictureOnlyCameraFragment();
                    Fragment findFragmentByTag = fragmentManager.findFragmentByTag(pictureOnlyCameraFragment.getFragmentTag());
                    if (findFragmentByTag != null) {
                        fragmentManager.beginTransaction().remove(findFragmentByTag).commitAllowingStateLoss();
                    }
                    fragmentManager.beginTransaction().add(i10, pictureOnlyCameraFragment, pictureOnlyCameraFragment.getFragmentTag()).addToBackStack(pictureOnlyCameraFragment.getFragmentTag()).commitAllowingStateLoss();
                    return pictureOnlyCameraFragment;
                }
                throw new NullPointerException("FragmentManager cannot be null");
            }
            throw new NullPointerException("OnResultCallbackListener cannot be null");
        }
        throw new NullPointerException("Activity cannot be null");
    }

    public void forResult() {
        if (DoubleUtils.isFastDoubleClick()) {
            return;
        }
        Activity activity = this.selector.getActivity();
        if (activity != null) {
            SelectorConfig selectorConfig = this.selectionConfig;
            selectorConfig.isResultListenerBack = false;
            selectorConfig.isActivityResultBack = true;
            FragmentManager supportFragmentManager = activity instanceof FragmentActivity ? ((FragmentActivity) activity).getSupportFragmentManager() : null;
            if (supportFragmentManager != null) {
                if (activity instanceof IBridgePictureBehavior) {
                    String str = PictureOnlyCameraFragment.TAG;
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(str);
                    if (findFragmentByTag != null) {
                        supportFragmentManager.beginTransaction().remove(findFragmentByTag).commitAllowingStateLoss();
                    }
                    FragmentInjectManager.injectSystemRoomFragment(supportFragmentManager, str, PictureOnlyCameraFragment.newInstance());
                    return;
                }
                throw new NullPointerException("Use only camera openCamera mode,Activity or Fragment interface needs to be implemented " + IBridgePictureBehavior.class);
            }
            throw new NullPointerException("FragmentManager cannot be null");
        }
        throw new NullPointerException("Activity cannot be null");
    }

    public void forResultActivity(int i10) {
        if (DoubleUtils.isFastDoubleClick()) {
            return;
        }
        Activity activity = this.selector.getActivity();
        if (activity != null) {
            SelectorConfig selectorConfig = this.selectionConfig;
            selectorConfig.isResultListenerBack = false;
            selectorConfig.isActivityResultBack = true;
            Intent intent = new Intent(activity, (Class<?>) PictureSelectorTransparentActivity.class);
            Fragment fragment = this.selector.getFragment();
            if (fragment != null) {
                fragment.startActivityForResult(intent, i10);
            } else {
                activity.startActivityForResult(intent, i10);
            }
            activity.overridePendingTransition(R.anim.ps_anim_fade_in, 0);
            return;
        }
        throw new NullPointerException("Activity cannot be null");
    }

    public PictureSelectionCameraModel isCameraAroundState(boolean z10) {
        this.selectionConfig.isCameraAroundState = z10;
        return this;
    }

    public PictureSelectionCameraModel isCameraForegroundService(boolean z10) {
        this.selectionConfig.isCameraForegroundService = z10;
        return this;
    }

    public PictureSelectionCameraModel isCameraRotateImage(boolean z10) {
        this.selectionConfig.isCameraRotateImage = z10;
        return this;
    }

    public PictureSelectionCameraModel isNewKeyBackMode(boolean z10) {
        this.selectionConfig.isNewKeyBackMode = z10;
        return this;
    }

    public PictureSelectionCameraModel isOriginalControl(boolean z10) {
        SelectorConfig selectorConfig = this.selectionConfig;
        selectorConfig.isOriginalControl = z10;
        selectorConfig.isCheckOriginalImage = z10;
        return this;
    }

    public PictureSelectionCameraModel isOriginalSkipCompress(boolean z10) {
        this.selectionConfig.isOriginalSkipCompress = z10;
        return this;
    }

    public PictureSelectionCameraModel isQuickCapture(boolean z10) {
        this.selectionConfig.isQuickCapture = z10;
        return this;
    }

    public PictureSelectionCameraModel setAddBitmapWatermarkListener(OnBitmapWatermarkEventListener onBitmapWatermarkEventListener) {
        if (this.selectionConfig.chooseMode != SelectMimeType.ofAudio()) {
            this.selectionConfig.onBitmapWatermarkListener = onBitmapWatermarkEventListener;
        }
        return this;
    }

    public PictureSelectionCameraModel setCameraImageFormat(String str) {
        this.selectionConfig.cameraImageFormat = str;
        return this;
    }

    public PictureSelectionCameraModel setCameraImageFormatForQ(String str) {
        this.selectionConfig.cameraImageFormatForQ = str;
        return this;
    }

    public PictureSelectionCameraModel setCameraInterceptListener(OnCameraInterceptListener onCameraInterceptListener) {
        this.selectionConfig.onCameraInterceptListener = onCameraInterceptListener;
        return this;
    }

    public PictureSelectionCameraModel setCameraVideoFormat(String str) {
        this.selectionConfig.cameraVideoFormat = str;
        return this;
    }

    public PictureSelectionCameraModel setCameraVideoFormatForQ(String str) {
        this.selectionConfig.cameraVideoFormatForQ = str;
        return this;
    }

    @Deprecated
    public PictureSelectionCameraModel setCompressEngine(CompressEngine compressEngine) {
        SelectorConfig selectorConfig = this.selectionConfig;
        selectorConfig.compressEngine = compressEngine;
        selectorConfig.isCompressEngine = true;
        return this;
    }

    @Deprecated
    public PictureSelectionCameraModel setCropEngine(CropEngine cropEngine) {
        this.selectionConfig.cropEngine = cropEngine;
        return this;
    }

    public PictureSelectionCameraModel setCustomLoadingListener(OnCustomLoadingListener onCustomLoadingListener) {
        this.selectionConfig.onCustomLoadingListener = onCustomLoadingListener;
        return this;
    }

    public PictureSelectionCameraModel setDefaultLanguage(int i10) {
        this.selectionConfig.defaultLanguage = i10;
        return this;
    }

    public PictureSelectionCameraModel setLanguage(int i10) {
        this.selectionConfig.language = i10;
        return this;
    }

    public PictureSelectionCameraModel setMaxVideoSelectNum(int i10) {
        SelectorConfig selectorConfig = this.selectionConfig;
        if (selectorConfig.chooseMode == SelectMimeType.ofVideo()) {
            i10 = 0;
        }
        selectorConfig.maxVideoSelectNum = i10;
        return this;
    }

    public PictureSelectionCameraModel setOfAllCameraType(int i10) {
        this.selectionConfig.ofAllCameraType = i10;
        return this;
    }

    public PictureSelectionCameraModel setOutputAudioDir(String str) {
        this.selectionConfig.outPutAudioDir = str;
        return this;
    }

    public PictureSelectionCameraModel setOutputAudioFileName(String str) {
        this.selectionConfig.outPutAudioFileName = str;
        return this;
    }

    public PictureSelectionCameraModel setOutputCameraDir(String str) {
        this.selectionConfig.outPutCameraDir = str;
        return this;
    }

    public PictureSelectionCameraModel setOutputCameraImageFileName(String str) {
        this.selectionConfig.outPutCameraImageFileName = str;
        return this;
    }

    public PictureSelectionCameraModel setOutputCameraVideoFileName(String str) {
        this.selectionConfig.outPutCameraVideoFileName = str;
        return this;
    }

    public PictureSelectionCameraModel setPermissionDeniedListener(OnPermissionDeniedListener onPermissionDeniedListener) {
        this.selectionConfig.onPermissionDeniedListener = onPermissionDeniedListener;
        return this;
    }

    public PictureSelectionCameraModel setPermissionDescriptionListener(OnPermissionDescriptionListener onPermissionDescriptionListener) {
        this.selectionConfig.onPermissionDescriptionListener = onPermissionDescriptionListener;
        return this;
    }

    public PictureSelectionCameraModel setPermissionsInterceptListener(OnPermissionsInterceptListener onPermissionsInterceptListener) {
        this.selectionConfig.onPermissionsEventListener = onPermissionsInterceptListener;
        return this;
    }

    public PictureSelectionCameraModel setRecordAudioInterceptListener(OnRecordAudioInterceptListener onRecordAudioInterceptListener) {
        this.selectionConfig.onRecordAudioListener = onRecordAudioInterceptListener;
        return this;
    }

    public PictureSelectionCameraModel setRecordVideoMaxSecond(int i10) {
        this.selectionConfig.recordVideoMaxSecond = i10;
        return this;
    }

    public PictureSelectionCameraModel setRecordVideoMinSecond(int i10) {
        this.selectionConfig.recordVideoMinSecond = i10;
        return this;
    }

    public PictureSelectionCameraModel setRequestedOrientation(int i10) {
        this.selectionConfig.requestedOrientation = i10;
        return this;
    }

    @Deprecated
    public PictureSelectionCameraModel setSandboxFileEngine(SandboxFileEngine sandboxFileEngine) {
        if (SdkVersionUtils.isQ()) {
            SelectorConfig selectorConfig = this.selectionConfig;
            selectorConfig.sandboxFileEngine = sandboxFileEngine;
            selectorConfig.isSandboxFileEngine = true;
        } else {
            this.selectionConfig.isSandboxFileEngine = false;
        }
        return this;
    }

    public PictureSelectionCameraModel setSelectLimitTipsListener(OnSelectLimitTipsListener onSelectLimitTipsListener) {
        this.selectionConfig.onSelectLimitTipsListener = onSelectLimitTipsListener;
        return this;
    }

    public PictureSelectionCameraModel setSelectMaxDurationSecond(int i10) {
        this.selectionConfig.selectMaxDurationSecond = i10 * 1000;
        return this;
    }

    public PictureSelectionCameraModel setSelectMaxFileSize(long j10) {
        if (j10 >= 1048576) {
            this.selectionConfig.selectMaxFileSize = j10;
        } else {
            this.selectionConfig.selectMaxFileSize = j10 * 1024;
        }
        return this;
    }

    public PictureSelectionCameraModel setSelectMinDurationSecond(int i10) {
        this.selectionConfig.selectMinDurationSecond = i10 * 1000;
        return this;
    }

    public PictureSelectionCameraModel setSelectMinFileSize(long j10) {
        if (j10 >= 1048576) {
            this.selectionConfig.selectMinFileSize = j10;
        } else {
            this.selectionConfig.selectMinFileSize = j10 * 1024;
        }
        return this;
    }

    public PictureSelectionCameraModel setSelectedData(List<LocalMedia> list) {
        if (list == null) {
            return this;
        }
        setMaxSelectNum(list.size() + 1);
        setMaxVideoSelectNum(list.size() + 1);
        SelectorConfig selectorConfig = this.selectionConfig;
        if (selectorConfig.selectionMode == 1 && selectorConfig.isDirectReturnSingle) {
            selectorConfig.selectedResult.clear();
        } else {
            selectorConfig.addAllSelectResult(new ArrayList<>(list));
        }
        return this;
    }

    @Deprecated
    public PictureSelectionCameraModel setVideoQuality(int i10) {
        this.selectionConfig.videoQuality = i10;
        return this;
    }

    public PictureSelectionCameraModel setVideoThumbnailListener(OnVideoThumbnailEventListener onVideoThumbnailEventListener) {
        if (this.selectionConfig.chooseMode != SelectMimeType.ofAudio()) {
            this.selectionConfig.onVideoThumbnailEventListener = onVideoThumbnailEventListener;
        }
        return this;
    }

    public PictureSelectionCameraModel setCropEngine(CropFileEngine cropFileEngine) {
        this.selectionConfig.cropFileEngine = cropFileEngine;
        return this;
    }

    public PictureSelectionCameraModel setCompressEngine(CompressFileEngine compressFileEngine) {
        SelectorConfig selectorConfig = this.selectionConfig;
        selectorConfig.compressFileEngine = compressFileEngine;
        selectorConfig.isCompressEngine = true;
        return this;
    }

    public PictureSelectionCameraModel setSandboxFileEngine(UriToFileTransformEngine uriToFileTransformEngine) {
        if (SdkVersionUtils.isQ()) {
            SelectorConfig selectorConfig = this.selectionConfig;
            selectorConfig.uriToFileTransformEngine = uriToFileTransformEngine;
            selectorConfig.isSandboxFileEngine = true;
        } else {
            this.selectionConfig.isSandboxFileEngine = false;
        }
        return this;
    }

    public void forResultActivity(d dVar) {
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
            dVar.launch(new Intent(activity, (Class<?>) PictureSelectorTransparentActivity.class));
            activity.overridePendingTransition(R.anim.ps_anim_fade_in, 0);
            return;
        }
        throw new NullPointerException("ActivityResultLauncher cannot be null");
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
            FragmentManager supportFragmentManager = activity instanceof FragmentActivity ? ((FragmentActivity) activity).getSupportFragmentManager() : null;
            if (supportFragmentManager != null) {
                String str = PictureOnlyCameraFragment.TAG;
                Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(str);
                if (findFragmentByTag != null) {
                    supportFragmentManager.beginTransaction().remove(findFragmentByTag).commitAllowingStateLoss();
                }
                FragmentInjectManager.injectSystemRoomFragment(supportFragmentManager, str, PictureOnlyCameraFragment.newInstance());
                return;
            }
            throw new NullPointerException("FragmentManager cannot be null");
        }
        throw new NullPointerException("OnResultCallbackListener cannot be null");
    }

    public void forResultActivity(OnResultCallbackListener<LocalMedia> onResultCallbackListener) {
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
            activity.startActivity(new Intent(activity, (Class<?>) PictureSelectorTransparentActivity.class));
            activity.overridePendingTransition(R.anim.ps_anim_fade_in, 0);
            return;
        }
        throw new NullPointerException("OnResultCallbackListener cannot be null");
    }
}
