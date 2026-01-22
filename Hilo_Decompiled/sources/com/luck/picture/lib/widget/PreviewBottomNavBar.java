package com.luck.picture.lib.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.style.BottomNavBarStyle;
import com.luck.picture.lib.utils.StyleUtils;
import com.luck.picture.lib.widget.BottomNavBar;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class PreviewBottomNavBar extends BottomNavBar {
    public PreviewBottomNavBar(Context context) {
        super(context);
    }

    public TextView getEditor() {
        return this.tvImageEditor;
    }

    @Override // com.luck.picture.lib.widget.BottomNavBar
    protected void handleLayoutUI() {
        int i10 = 8;
        this.tvPreview.setVisibility(8);
        this.tvImageEditor.setOnClickListener(this);
        TextView textView = this.tvImageEditor;
        if (this.config.onEditMediaEventListener != null) {
            i10 = 0;
        }
        textView.setVisibility(i10);
    }

    public void isDisplayEditor(boolean z10) {
        int i10;
        TextView textView = this.tvImageEditor;
        if (this.config.onEditMediaEventListener != null && !z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        textView.setVisibility(i10);
    }

    @Override // com.luck.picture.lib.widget.BottomNavBar, android.view.View.OnClickListener
    public void onClick(View view) {
        BottomNavBar.OnBottomNavBarListener onBottomNavBarListener;
        super.onClick(view);
        if (view.getId() == R.id.ps_tv_editor && (onBottomNavBarListener = this.bottomNavBarListener) != null) {
            onBottomNavBarListener.onEditImage();
        }
    }

    @Override // com.luck.picture.lib.widget.BottomNavBar
    public void setBottomNavBarStyle() {
        super.setBottomNavBarStyle();
        BottomNavBarStyle bottomBarStyle = this.config.selectorStyle.getBottomBarStyle();
        if (StyleUtils.checkStyleValidity(bottomBarStyle.getBottomPreviewNarBarBackgroundColor())) {
            setBackgroundColor(bottomBarStyle.getBottomPreviewNarBarBackgroundColor());
        } else if (StyleUtils.checkSizeValidity(bottomBarStyle.getBottomNarBarBackgroundColor())) {
            setBackgroundColor(bottomBarStyle.getBottomNarBarBackgroundColor());
        }
    }

    public PreviewBottomNavBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PreviewBottomNavBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
