package com.tencent.qcloud.tuicore.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.tencent.qcloud.tuicore.R;
import com.tencent.qcloud.tuicore.util.ScreenUtil;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class LineControllerView extends LinearLayout {
    private String mContent;
    private TextView mContentText;
    private boolean mIsBottom;
    private boolean mIsJump;
    private boolean mIsSwitch;
    private boolean mIsTop;
    private View mMask;
    private String mName;
    private TextView mNameText;
    private ImageView mNavArrowView;
    private Switch mSwitchView;

    public LineControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.line_controller_view, this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LineControllerView, 0, 0);
        try {
            this.mName = obtainStyledAttributes.getString(R.styleable.LineControllerView_name);
            this.mContent = obtainStyledAttributes.getString(R.styleable.LineControllerView_subject);
            this.mIsBottom = obtainStyledAttributes.getBoolean(R.styleable.LineControllerView_isBottom, false);
            this.mIsTop = obtainStyledAttributes.getBoolean(R.styleable.LineControllerView_isTop, false);
            this.mIsJump = obtainStyledAttributes.getBoolean(R.styleable.LineControllerView_canNav, false);
            this.mIsSwitch = obtainStyledAttributes.getBoolean(R.styleable.LineControllerView_isSwitch, false);
            setUpView();
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void setUpView() {
        int i;
        int i2;
        int i3;
        int i4;
        TextView textView = (TextView) findViewById(R.id.name);
        this.mNameText = textView;
        textView.setText(this.mName);
        TextView textView2 = (TextView) findViewById(R.id.content);
        this.mContentText = textView2;
        textView2.setText(this.mContent);
        View findViewById = findViewById(R.id.bottom_line);
        View findViewById2 = findViewById(R.id.top_line);
        int i5 = 8;
        if (this.mIsBottom) {
            i = 0;
        } else {
            i = 8;
        }
        findViewById.setVisibility(i);
        if (this.mIsTop) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        findViewById2.setVisibility(i2);
        ImageView imageView = (ImageView) findViewById(R.id.rightArrow);
        this.mNavArrowView = imageView;
        if (this.mIsJump) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.contentText);
        if (this.mIsSwitch) {
            i4 = 8;
        } else {
            i4 = 0;
        }
        relativeLayout.setVisibility(i4);
        Switch r0 = (Switch) findViewById(R.id.btnSwitch);
        this.mSwitchView = r0;
        if (this.mIsSwitch) {
            i5 = 0;
        }
        r0.setVisibility(i5);
        this.mMask = findViewById(R.id.disable_mask);
    }

    public String getContent() {
        return this.mContentText.getText().toString();
    }

    public boolean isChecked() {
        return this.mSwitchView.isChecked();
    }

    public void setCanNav(boolean z) {
        int i;
        this.mIsJump = z;
        ImageView imageView = this.mNavArrowView;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        imageView.setVisibility(i);
        if (z) {
            ViewGroup.LayoutParams layoutParams = this.mContentText.getLayoutParams();
            layoutParams.width = ScreenUtil.getPxByDp(120.0f);
            layoutParams.height = -2;
            this.mContentText.setLayoutParams(layoutParams);
            this.mContentText.setTextIsSelectable(false);
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = this.mContentText.getLayoutParams();
        layoutParams2.width = -2;
        layoutParams2.height = -2;
        this.mContentText.setLayoutParams(layoutParams2);
        this.mContentText.setTextIsSelectable(true);
    }

    public void setCheckListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.mSwitchView.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    public void setChecked(boolean z) {
        this.mSwitchView.setChecked(z);
    }

    public void setContent(String str) {
        this.mContent = str;
        this.mContentText.setText(str);
    }

    public void setMask(boolean z) {
        if (z) {
            this.mMask.setVisibility(0);
            this.mSwitchView.setEnabled(false);
        } else {
            this.mMask.setVisibility(8);
            this.mSwitchView.setEnabled(true);
        }
    }

    public void setSingleLine(boolean z) {
        this.mContentText.setSingleLine(z);
    }
}
