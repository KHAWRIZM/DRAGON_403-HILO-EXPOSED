package com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.face;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import c5.h;
import com.bumptech.glide.Glide;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class FaceGroupIcon extends RelativeLayout {
    private ImageView faceTabIcon;

    public FaceGroupIcon(Context context) {
        super(context);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.face_group_icon, this);
        this.faceTabIcon = (ImageView) findViewById(R.id.face_group_tab_icon);
    }

    public void setFaceTabIcon(String str) {
        Glide.with(this).q(str).q0(new h().j(android.R.drawable.ic_menu_report_image)).D0(this.faceTabIcon);
    }

    public FaceGroupIcon(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public FaceGroupIcon(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
