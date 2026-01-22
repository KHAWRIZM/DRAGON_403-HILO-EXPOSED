package com.luck.picture.lib.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.a;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.style.BottomNavBarStyle;
import com.luck.picture.lib.utils.DensityUtil;
import com.luck.picture.lib.utils.PictureFileUtils;
import com.luck.picture.lib.utils.StyleUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class BottomNavBar extends RelativeLayout implements View.OnClickListener {
    protected OnBottomNavBarListener bottomNavBarListener;
    protected SelectorConfig config;
    private CheckBox originalCheckbox;
    protected TextView tvImageEditor;
    protected TextView tvPreview;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class OnBottomNavBarListener {
        public void onCheckOriginalChange() {
        }

        public void onEditImage() {
        }

        public void onFirstCheckOriginalSelectedChange() {
        }

        public void onPreview() {
        }
    }

    public BottomNavBar(Context context) {
        super(context);
        init();
    }

    private void calculateFileTotalSize() {
        if (this.config.isOriginalControl) {
            long j10 = 0;
            for (int i10 = 0; i10 < this.config.getSelectCount(); i10++) {
                j10 += this.config.getSelectedResult().get(i10).getSize();
            }
            if (j10 > 0) {
                this.originalCheckbox.setText(getContext().getString(R.string.ps_original_image, PictureFileUtils.formatAccurateUnitFileSize(j10)));
                return;
            } else {
                this.originalCheckbox.setText(getContext().getString(R.string.ps_default_original_image));
                return;
            }
        }
        this.originalCheckbox.setText(getContext().getString(R.string.ps_default_original_image));
    }

    protected void handleLayoutUI() {
    }

    protected void inflateLayout() {
        View.inflate(getContext(), R.layout.ps_bottom_nav_bar, this);
    }

    protected void init() {
        inflateLayout();
        setClickable(true);
        setFocusable(true);
        this.config = SelectorProviders.getInstance().getSelectorConfig();
        this.tvPreview = (TextView) findViewById(R.id.ps_tv_preview);
        this.tvImageEditor = (TextView) findViewById(R.id.ps_tv_editor);
        this.originalCheckbox = (CheckBox) findViewById(R.id.cb_original);
        this.tvPreview.setOnClickListener(this);
        this.tvImageEditor.setVisibility(8);
        setBackgroundColor(a.getColor(getContext(), R.color.ps_color_grey));
        this.originalCheckbox.setChecked(this.config.isCheckOriginalImage);
        this.originalCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.luck.picture.lib.widget.BottomNavBar.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                BottomNavBar bottomNavBar = BottomNavBar.this;
                bottomNavBar.config.isCheckOriginalImage = z10;
                bottomNavBar.originalCheckbox.setChecked(BottomNavBar.this.config.isCheckOriginalImage);
                OnBottomNavBarListener onBottomNavBarListener = BottomNavBar.this.bottomNavBarListener;
                if (onBottomNavBarListener != null) {
                    onBottomNavBarListener.onCheckOriginalChange();
                    if (z10 && BottomNavBar.this.config.getSelectCount() == 0) {
                        BottomNavBar.this.bottomNavBarListener.onFirstCheckOriginalSelectedChange();
                    }
                }
            }
        });
        handleLayoutUI();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bottomNavBarListener != null && view.getId() == R.id.ps_tv_preview) {
            this.bottomNavBarListener.onPreview();
        }
    }

    public void setBottomNavBarStyle() {
        String bottomPreviewNormalText;
        String bottomEditorText;
        String bottomOriginalText;
        String bottomOriginalText2;
        SelectorConfig selectorConfig = this.config;
        if (selectorConfig.isDirectReturnSingle) {
            setVisibility(8);
            return;
        }
        BottomNavBarStyle bottomBarStyle = selectorConfig.selectorStyle.getBottomBarStyle();
        if (this.config.isOriginalControl) {
            this.originalCheckbox.setVisibility(0);
            int bottomOriginalDrawableLeft = bottomBarStyle.getBottomOriginalDrawableLeft();
            if (StyleUtils.checkStyleValidity(bottomOriginalDrawableLeft)) {
                this.originalCheckbox.setButtonDrawable(bottomOriginalDrawableLeft);
            }
            if (StyleUtils.checkStyleValidity(bottomBarStyle.getBottomOriginalTextResId())) {
                bottomOriginalText2 = getContext().getString(bottomBarStyle.getBottomOriginalTextResId());
            } else {
                bottomOriginalText2 = bottomBarStyle.getBottomOriginalText();
            }
            if (StyleUtils.checkTextValidity(bottomOriginalText2)) {
                this.originalCheckbox.setText(bottomOriginalText2);
            }
            int bottomOriginalTextSize = bottomBarStyle.getBottomOriginalTextSize();
            if (StyleUtils.checkSizeValidity(bottomOriginalTextSize)) {
                this.originalCheckbox.setTextSize(bottomOriginalTextSize);
            }
            int bottomOriginalTextColor = bottomBarStyle.getBottomOriginalTextColor();
            if (StyleUtils.checkStyleValidity(bottomOriginalTextColor)) {
                this.originalCheckbox.setTextColor(bottomOriginalTextColor);
            }
        }
        int bottomNarBarHeight = bottomBarStyle.getBottomNarBarHeight();
        if (StyleUtils.checkSizeValidity(bottomNarBarHeight)) {
            getLayoutParams().height = bottomNarBarHeight;
        } else {
            getLayoutParams().height = DensityUtil.dip2px(getContext(), 46.0f);
        }
        int bottomNarBarBackgroundColor = bottomBarStyle.getBottomNarBarBackgroundColor();
        if (StyleUtils.checkStyleValidity(bottomNarBarBackgroundColor)) {
            setBackgroundColor(bottomNarBarBackgroundColor);
        }
        int bottomPreviewNormalTextColor = bottomBarStyle.getBottomPreviewNormalTextColor();
        if (StyleUtils.checkStyleValidity(bottomPreviewNormalTextColor)) {
            this.tvPreview.setTextColor(bottomPreviewNormalTextColor);
        }
        int bottomPreviewNormalTextSize = bottomBarStyle.getBottomPreviewNormalTextSize();
        if (StyleUtils.checkSizeValidity(bottomPreviewNormalTextSize)) {
            this.tvPreview.setTextSize(bottomPreviewNormalTextSize);
        }
        if (StyleUtils.checkStyleValidity(bottomBarStyle.getBottomPreviewNormalTextResId())) {
            bottomPreviewNormalText = getContext().getString(bottomBarStyle.getBottomPreviewNormalTextResId());
        } else {
            bottomPreviewNormalText = bottomBarStyle.getBottomPreviewNormalText();
        }
        if (StyleUtils.checkTextValidity(bottomPreviewNormalText)) {
            this.tvPreview.setText(bottomPreviewNormalText);
        }
        if (StyleUtils.checkStyleValidity(bottomBarStyle.getBottomEditorTextResId())) {
            bottomEditorText = getContext().getString(bottomBarStyle.getBottomEditorTextResId());
        } else {
            bottomEditorText = bottomBarStyle.getBottomEditorText();
        }
        if (StyleUtils.checkTextValidity(bottomEditorText)) {
            this.tvImageEditor.setText(bottomEditorText);
        }
        int bottomEditorTextSize = bottomBarStyle.getBottomEditorTextSize();
        if (StyleUtils.checkSizeValidity(bottomEditorTextSize)) {
            this.tvImageEditor.setTextSize(bottomEditorTextSize);
        }
        int bottomEditorTextColor = bottomBarStyle.getBottomEditorTextColor();
        if (StyleUtils.checkStyleValidity(bottomEditorTextColor)) {
            this.tvImageEditor.setTextColor(bottomEditorTextColor);
        }
        int bottomOriginalDrawableLeft2 = bottomBarStyle.getBottomOriginalDrawableLeft();
        if (StyleUtils.checkStyleValidity(bottomOriginalDrawableLeft2)) {
            this.originalCheckbox.setButtonDrawable(bottomOriginalDrawableLeft2);
        }
        if (StyleUtils.checkStyleValidity(bottomBarStyle.getBottomOriginalTextResId())) {
            bottomOriginalText = getContext().getString(bottomBarStyle.getBottomOriginalTextResId());
        } else {
            bottomOriginalText = bottomBarStyle.getBottomOriginalText();
        }
        if (StyleUtils.checkTextValidity(bottomOriginalText)) {
            this.originalCheckbox.setText(bottomOriginalText);
        }
        int bottomOriginalTextSize2 = bottomBarStyle.getBottomOriginalTextSize();
        if (StyleUtils.checkSizeValidity(bottomOriginalTextSize2)) {
            this.originalCheckbox.setTextSize(bottomOriginalTextSize2);
        }
        int bottomOriginalTextColor2 = bottomBarStyle.getBottomOriginalTextColor();
        if (StyleUtils.checkStyleValidity(bottomOriginalTextColor2)) {
            this.originalCheckbox.setTextColor(bottomOriginalTextColor2);
        }
    }

    public void setOnBottomNavBarListener(OnBottomNavBarListener onBottomNavBarListener) {
        this.bottomNavBarListener = onBottomNavBarListener;
    }

    public void setOriginalCheck() {
        this.originalCheckbox.setChecked(this.config.isCheckOriginalImage);
    }

    public void setSelectedChange() {
        String bottomPreviewNormalText;
        String bottomPreviewSelectText;
        calculateFileTotalSize();
        BottomNavBarStyle bottomBarStyle = this.config.selectorStyle.getBottomBarStyle();
        if (this.config.getSelectCount() > 0) {
            this.tvPreview.setEnabled(true);
            int bottomPreviewSelectTextColor = bottomBarStyle.getBottomPreviewSelectTextColor();
            if (StyleUtils.checkStyleValidity(bottomPreviewSelectTextColor)) {
                this.tvPreview.setTextColor(bottomPreviewSelectTextColor);
            } else {
                this.tvPreview.setTextColor(a.getColor(getContext(), R.color.ps_color_fa632d));
            }
            if (StyleUtils.checkStyleValidity(bottomBarStyle.getBottomPreviewSelectTextResId())) {
                bottomPreviewSelectText = getContext().getString(bottomBarStyle.getBottomPreviewSelectTextResId());
            } else {
                bottomPreviewSelectText = bottomBarStyle.getBottomPreviewSelectText();
            }
            if (StyleUtils.checkTextValidity(bottomPreviewSelectText)) {
                int formatCount = StyleUtils.getFormatCount(bottomPreviewSelectText);
                if (formatCount == 1) {
                    this.tvPreview.setText(String.format(bottomPreviewSelectText, Integer.valueOf(this.config.getSelectCount())));
                    return;
                } else if (formatCount == 2) {
                    this.tvPreview.setText(String.format(bottomPreviewSelectText, Integer.valueOf(this.config.getSelectCount()), Integer.valueOf(this.config.maxSelectNum)));
                    return;
                } else {
                    this.tvPreview.setText(bottomPreviewSelectText);
                    return;
                }
            }
            this.tvPreview.setText(getContext().getString(R.string.ps_preview_num, Integer.valueOf(this.config.getSelectCount())));
            return;
        }
        this.tvPreview.setEnabled(false);
        int bottomPreviewNormalTextColor = bottomBarStyle.getBottomPreviewNormalTextColor();
        if (StyleUtils.checkStyleValidity(bottomPreviewNormalTextColor)) {
            this.tvPreview.setTextColor(bottomPreviewNormalTextColor);
        } else {
            this.tvPreview.setTextColor(a.getColor(getContext(), R.color.ps_color_9b));
        }
        if (StyleUtils.checkStyleValidity(bottomBarStyle.getBottomPreviewNormalTextResId())) {
            bottomPreviewNormalText = getContext().getString(bottomBarStyle.getBottomPreviewNormalTextResId());
        } else {
            bottomPreviewNormalText = bottomBarStyle.getBottomPreviewNormalText();
        }
        if (StyleUtils.checkTextValidity(bottomPreviewNormalText)) {
            this.tvPreview.setText(bottomPreviewNormalText);
        } else {
            this.tvPreview.setText(getContext().getString(R.string.ps_preview));
        }
    }

    public BottomNavBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public BottomNavBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        init();
    }
}
