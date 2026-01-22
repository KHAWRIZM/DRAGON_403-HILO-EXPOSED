package com.luck.picture.lib.basic;

import android.app.Activity;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.PictureSelectorPreviewFragment;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.engine.VideoPlayerEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnCustomLoadingListener;
import com.luck.picture.lib.interfaces.OnExternalPreviewEventListener;
import com.luck.picture.lib.interfaces.OnInjectActivityPreviewListener;
import com.luck.picture.lib.interfaces.OnInjectLayoutResourceListener;
import com.luck.picture.lib.magical.BuildRecycleItemViewParams;
import com.luck.picture.lib.style.PictureSelectorStyle;
import com.luck.picture.lib.utils.ActivityCompatHelper;
import com.luck.picture.lib.utils.DensityUtil;
import com.luck.picture.lib.utils.DoubleUtils;
import java.util.ArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class PictureSelectionPreviewModel {
    private final SelectorConfig selectionConfig;
    private final PictureSelector selector;

    public PictureSelectionPreviewModel(PictureSelector pictureSelector) {
        this.selector = pictureSelector;
        SelectorConfig selectorConfig = new SelectorConfig();
        this.selectionConfig = selectorConfig;
        SelectorProviders.getInstance().addSelectorConfigQueue(selectorConfig);
        selectorConfig.isPreviewZoomEffect = false;
    }

    public PictureSelectionPreviewModel isAutoVideoPlay(boolean z10) {
        this.selectionConfig.isAutoVideoPlay = z10;
        return this;
    }

    @Deprecated
    public PictureSelectionPreviewModel isEnableVideoSize(boolean z10) {
        this.selectionConfig.isSyncWidthAndHeight = z10;
        return this;
    }

    public PictureSelectionPreviewModel isHidePreviewDownload(boolean z10) {
        this.selectionConfig.isHidePreviewDownload = z10;
        return this;
    }

    public PictureSelectionPreviewModel isLoopAutoVideoPlay(boolean z10) {
        this.selectionConfig.isLoopAutoPlay = z10;
        return this;
    }

    public PictureSelectionPreviewModel isNewKeyBackMode(boolean z10) {
        this.selectionConfig.isNewKeyBackMode = z10;
        return this;
    }

    public PictureSelectionPreviewModel isPreviewFullScreenMode(boolean z10) {
        this.selectionConfig.isPreviewFullScreenMode = z10;
        return this;
    }

    public PictureSelectionPreviewModel isPreviewZoomEffect(boolean z10, ViewGroup viewGroup) {
        return isPreviewZoomEffect(z10, this.selectionConfig.isPreviewFullScreenMode, viewGroup);
    }

    public PictureSelectionPreviewModel isSyncWidthAndHeight(boolean z10) {
        this.selectionConfig.isSyncWidthAndHeight = z10;
        return this;
    }

    public PictureSelectionPreviewModel isUseSystemVideoPlayer(boolean z10) {
        this.selectionConfig.isUseSystemVideoPlayer = z10;
        return this;
    }

    public PictureSelectionPreviewModel isVideoPauseResumePlay(boolean z10) {
        this.selectionConfig.isPauseResumePlay = z10;
        return this;
    }

    public PictureSelectionPreviewModel setAttachViewLifecycle(IBridgeViewLifecycle iBridgeViewLifecycle) {
        this.selectionConfig.viewLifecycle = iBridgeViewLifecycle;
        return this;
    }

    public PictureSelectionPreviewModel setCustomLoadingListener(OnCustomLoadingListener onCustomLoadingListener) {
        this.selectionConfig.onCustomLoadingListener = onCustomLoadingListener;
        return this;
    }

    public PictureSelectionPreviewModel setDefaultLanguage(int i10) {
        this.selectionConfig.defaultLanguage = i10;
        return this;
    }

    public PictureSelectionPreviewModel setExternalPreviewEventListener(OnExternalPreviewEventListener onExternalPreviewEventListener) {
        this.selectionConfig.onExternalPreviewEventListener = onExternalPreviewEventListener;
        return this;
    }

    public PictureSelectionPreviewModel setImageEngine(ImageEngine imageEngine) {
        this.selectionConfig.imageEngine = imageEngine;
        return this;
    }

    public PictureSelectionPreviewModel setInjectActivityPreviewFragment(OnInjectActivityPreviewListener onInjectActivityPreviewListener) {
        this.selectionConfig.onInjectActivityPreviewListener = onInjectActivityPreviewListener;
        return this;
    }

    public PictureSelectionPreviewModel setInjectLayoutResourceListener(OnInjectLayoutResourceListener onInjectLayoutResourceListener) {
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

    public PictureSelectionPreviewModel setLanguage(int i10) {
        this.selectionConfig.language = i10;
        return this;
    }

    public PictureSelectionPreviewModel setSelectorUIStyle(PictureSelectorStyle pictureSelectorStyle) {
        if (pictureSelectorStyle != null) {
            this.selectionConfig.selectorStyle = pictureSelectorStyle;
        }
        return this;
    }

    public PictureSelectionPreviewModel setVideoPlayerEngine(VideoPlayerEngine videoPlayerEngine) {
        this.selectionConfig.videoPlayerEngine = videoPlayerEngine;
        return this;
    }

    public void startActivityPreview(int i10, boolean z10, ArrayList<LocalMedia> arrayList) {
        if (!DoubleUtils.isFastDoubleClick()) {
            Activity activity = this.selector.getActivity();
            if (activity != null) {
                SelectorConfig selectorConfig = this.selectionConfig;
                if (selectorConfig.imageEngine == null && selectorConfig.chooseMode != SelectMimeType.ofAudio()) {
                    throw new NullPointerException("imageEngine is null,Please implement ImageEngine");
                }
                if (arrayList != null && arrayList.size() != 0) {
                    Intent intent = new Intent(activity, (Class<?>) PictureSelectorTransparentActivity.class);
                    this.selectionConfig.addSelectedPreviewResult(arrayList);
                    intent.putExtra(PictureConfig.EXTRA_EXTERNAL_PREVIEW, true);
                    intent.putExtra(PictureConfig.EXTRA_MODE_TYPE_SOURCE, 2);
                    intent.putExtra(PictureConfig.EXTRA_PREVIEW_CURRENT_POSITION, i10);
                    intent.putExtra(PictureConfig.EXTRA_EXTERNAL_PREVIEW_DISPLAY_DELETE, z10);
                    Fragment fragment = this.selector.getFragment();
                    if (fragment != null) {
                        fragment.startActivity(intent);
                    } else {
                        activity.startActivity(intent);
                    }
                    SelectorConfig selectorConfig2 = this.selectionConfig;
                    if (selectorConfig2.isPreviewZoomEffect) {
                        int i11 = R.anim.ps_anim_fade_in;
                        activity.overridePendingTransition(i11, i11);
                        return;
                    } else {
                        activity.overridePendingTransition(selectorConfig2.selectorStyle.getWindowAnimationStyle().activityEnterAnimation, R.anim.ps_anim_fade_in);
                        return;
                    }
                }
                throw new NullPointerException("preview data is null");
            }
            throw new NullPointerException("Activity cannot be null");
        }
    }

    public void startFragmentPreview(int i10, boolean z10, ArrayList<LocalMedia> arrayList) {
        startFragmentPreview(null, i10, z10, arrayList);
    }

    public PictureSelectionPreviewModel isPreviewZoomEffect(boolean z10, boolean z11, ViewGroup viewGroup) {
        if (!(viewGroup instanceof RecyclerView) && !(viewGroup instanceof ListView)) {
            throw new IllegalArgumentException(viewGroup.getClass().getCanonicalName() + " Must be " + RecyclerView.class + " or " + ListView.class);
        }
        if (z10) {
            if (z11) {
                BuildRecycleItemViewParams.generateViewParams(viewGroup, 0);
            } else {
                BuildRecycleItemViewParams.generateViewParams(viewGroup, DensityUtil.getStatusBarHeight(this.selector.getActivity()));
            }
        }
        this.selectionConfig.isPreviewZoomEffect = z10;
        return this;
    }

    public void startFragmentPreview(PictureSelectorPreviewFragment pictureSelectorPreviewFragment, int i10, boolean z10, ArrayList<LocalMedia> arrayList) {
        String str;
        if (DoubleUtils.isFastDoubleClick()) {
            return;
        }
        Activity activity = this.selector.getActivity();
        if (activity != null) {
            SelectorConfig selectorConfig = this.selectionConfig;
            if (selectorConfig.imageEngine == null && selectorConfig.chooseMode != SelectMimeType.ofAudio()) {
                throw new NullPointerException("imageEngine is null,Please implement ImageEngine");
            }
            if (arrayList != null && arrayList.size() != 0) {
                FragmentManager supportFragmentManager = activity instanceof FragmentActivity ? ((FragmentActivity) activity).getSupportFragmentManager() : null;
                if (supportFragmentManager != null) {
                    if (pictureSelectorPreviewFragment != null) {
                        str = pictureSelectorPreviewFragment.getFragmentTag();
                    } else {
                        str = PictureSelectorPreviewFragment.TAG;
                        pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.newInstance();
                    }
                    if (ActivityCompatHelper.checkFragmentNonExits((FragmentActivity) activity, str)) {
                        ArrayList<LocalMedia> arrayList2 = new ArrayList<>(arrayList);
                        pictureSelectorPreviewFragment.setExternalPreviewData(i10, arrayList2.size(), arrayList2, z10);
                        FragmentInjectManager.injectSystemRoomFragment(supportFragmentManager, str, pictureSelectorPreviewFragment);
                        return;
                    }
                    return;
                }
                throw new NullPointerException("FragmentManager cannot be null");
            }
            throw new NullPointerException("preview data is null");
        }
        throw new NullPointerException("Activity cannot be null");
    }
}
