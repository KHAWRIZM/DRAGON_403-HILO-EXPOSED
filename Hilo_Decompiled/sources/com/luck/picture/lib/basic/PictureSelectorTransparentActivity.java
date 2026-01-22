package com.luck.picture.lib.basic;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.a;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.luck.picture.lib.PictureOnlyCameraFragment;
import com.luck.picture.lib.PictureSelectorPreviewFragment;
import com.luck.picture.lib.PictureSelectorSystemFragment;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.immersive.ImmersiveManager;
import com.luck.picture.lib.interfaces.OnInjectActivityPreviewListener;
import com.luck.picture.lib.style.SelectMainStyle;
import com.luck.picture.lib.utils.StyleUtils;
import java.util.ArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class PictureSelectorTransparentActivity extends AppCompatActivity {
    private SelectorConfig selectorConfig;

    private void immersive() {
        if (this.selectorConfig.selectorStyle == null) {
            SelectorProviders.getInstance().getSelectorConfig();
        }
        SelectMainStyle selectMainStyle = this.selectorConfig.selectorStyle.getSelectMainStyle();
        int statusBarColor = selectMainStyle.getStatusBarColor();
        int navigationBarColor = selectMainStyle.getNavigationBarColor();
        boolean isDarkStatusBarBlack = selectMainStyle.isDarkStatusBarBlack();
        if (!StyleUtils.checkStyleValidity(statusBarColor)) {
            statusBarColor = a.getColor(this, R.color.ps_color_grey);
        }
        if (!StyleUtils.checkStyleValidity(navigationBarColor)) {
            navigationBarColor = a.getColor(this, R.color.ps_color_grey);
        }
        ImmersiveManager.immersiveAboveAPI23(this, statusBarColor, navigationBarColor, isDarkStatusBarBlack);
    }

    private void initSelectorConfig() {
        this.selectorConfig = SelectorProviders.getInstance().getSelectorConfig();
    }

    private boolean isExternalPreview() {
        if (getIntent().getIntExtra(PictureConfig.EXTRA_MODE_TYPE_SOURCE, 0) != 2) {
            return false;
        }
        return true;
    }

    @SuppressLint({"RtlHardcoded"})
    private void setActivitySize() {
        Window window = getWindow();
        window.setGravity(51);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        attributes.height = 1;
        attributes.width = 1;
        window.setAttributes(attributes);
    }

    private void setupFragment() {
        String str;
        PictureSelectorPreviewFragment pictureSelectorPreviewFragment;
        PictureSelectorPreviewFragment pictureSelectorPreviewFragment2;
        Fragment fragment;
        int intExtra = getIntent().getIntExtra(PictureConfig.EXTRA_MODE_TYPE_SOURCE, 0);
        if (intExtra == 1) {
            str = PictureSelectorSystemFragment.TAG;
            fragment = PictureSelectorSystemFragment.newInstance();
        } else if (intExtra == 2) {
            OnInjectActivityPreviewListener onInjectActivityPreviewListener = this.selectorConfig.onInjectActivityPreviewListener;
            if (onInjectActivityPreviewListener != null) {
                pictureSelectorPreviewFragment = onInjectActivityPreviewListener.onInjectPreviewFragment();
            } else {
                pictureSelectorPreviewFragment = null;
            }
            if (pictureSelectorPreviewFragment != null) {
                pictureSelectorPreviewFragment2 = pictureSelectorPreviewFragment;
                str = pictureSelectorPreviewFragment.getFragmentTag();
            } else {
                str = PictureSelectorPreviewFragment.TAG;
                pictureSelectorPreviewFragment2 = PictureSelectorPreviewFragment.newInstance();
            }
            int intExtra2 = getIntent().getIntExtra(PictureConfig.EXTRA_PREVIEW_CURRENT_POSITION, 0);
            ArrayList<LocalMedia> arrayList = new ArrayList<>(this.selectorConfig.selectedPreviewResult);
            pictureSelectorPreviewFragment2.setExternalPreviewData(intExtra2, arrayList.size(), arrayList, getIntent().getBooleanExtra(PictureConfig.EXTRA_EXTERNAL_PREVIEW_DISPLAY_DELETE, false));
            fragment = pictureSelectorPreviewFragment2;
        } else {
            str = PictureOnlyCameraFragment.TAG;
            fragment = PictureOnlyCameraFragment.newInstance();
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(str);
        if (findFragmentByTag != null) {
            supportFragmentManager.beginTransaction().remove(findFragmentByTag).commitAllowingStateLoss();
        }
        FragmentInjectManager.injectSystemRoomFragment(supportFragmentManager, str, fragment);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if (getIntent().getIntExtra(PictureConfig.EXTRA_MODE_TYPE_SOURCE, 0) == 2) {
            SelectorConfig selectorConfig = this.selectorConfig;
            if (!selectorConfig.isPreviewZoomEffect) {
                overridePendingTransition(0, selectorConfig.selectorStyle.getWindowAnimationStyle().activityExitAnimation);
                return;
            }
        }
        overridePendingTransition(0, R.anim.ps_anim_fade_out);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initSelectorConfig();
        immersive();
        setContentView(R.layout.ps_empty);
        if (!isExternalPreview()) {
            setActivitySize();
        }
        setupFragment();
    }
}
