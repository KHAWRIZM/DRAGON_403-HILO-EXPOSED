package com.tencent.qcloud.tuicore.component.gatherimage;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.content.a;
import com.tencent.qcloud.tuicore.R;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class UserIconView extends RelativeLayout {
    private int mDefaultImageResId;
    private int mIconRadius;
    private SynthesizedImageView mIconView;

    public UserIconView(Context context) {
        super(context);
        init(null);
    }

    private void init(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        View.inflate(getContext(), R.layout.profile_icon_view, this);
        if (attributeSet != null && (obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.UserIconView)) != null) {
            this.mDefaultImageResId = obtainStyledAttributes.getResourceId(R.styleable.UserIconView_default_image, this.mDefaultImageResId);
            this.mIconRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.UserIconView_image_radius, this.mIconRadius);
            obtainStyledAttributes.recycle();
        }
        SynthesizedImageView synthesizedImageView = (SynthesizedImageView) findViewById(R.id.profile_icon);
        this.mIconView = synthesizedImageView;
        int i = this.mDefaultImageResId;
        if (i > 0) {
            synthesizedImageView.defaultImage(i);
        }
        int i2 = this.mIconRadius;
        if (i2 > 0) {
            this.mIconView.setRadius(i2);
        }
    }

    public SynthesizedImageView getAvatar() {
        return this.mIconView;
    }

    public void setDefaultImageResId(int i) {
        this.mDefaultImageResId = i;
        this.mIconView.defaultImage(i);
    }

    public void setIconUrls(List<Object> list) {
        this.mIconView.displayImage(list).load(null);
    }

    public void setImageResId(int i) {
        this.mIconView.setImageDrawable(a.getDrawable(getContext(), i));
    }

    public void setRadius(int i) {
        this.mIconRadius = i;
        this.mIconView.setRadius(i);
    }

    public UserIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public UserIconView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }
}
