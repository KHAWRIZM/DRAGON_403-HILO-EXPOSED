package com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.inputmore;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.InputMoreActionUnit;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class InputMoreLayout extends LinearLayout {
    public InputMoreLayout(Context context) {
        super(context);
        init();
    }

    private void init() {
        View.inflate(getContext(), R.layout.chat_inputmore_layout, this);
    }

    public void init(List<InputMoreActionUnit> list) {
        ViewPager findViewById = findViewById(R.id.viewPager);
        findViewById.setAdapter(new ActionsPagerAdapter(findViewById, list));
    }

    public InputMoreLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public InputMoreLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
