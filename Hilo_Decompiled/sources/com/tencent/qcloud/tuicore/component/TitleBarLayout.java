package com.tencent.qcloud.tuicore.component;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qcloud.tuicore.R;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout;
import com.tencent.qcloud.tuicore.util.ScreenUtil;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class TitleBarLayout extends LinearLayout implements ITitleBarLayout {
    private TextView mCenterTitle;
    private LinearLayout mLeftGroup;
    private ImageView mLeftIcon;
    private TextView mLeftTitle;
    private LinearLayout mRightGroup;
    private ImageView mRightIcon;
    private TextView mRightTitle;
    private RelativeLayout mTitleLayout;
    private UnreadCountTextView unreadCountTextView;

    /* renamed from: com.tencent.qcloud.tuicore.component.TitleBarLayout$2, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$qcloud$tuicore$component$interfaces$ITitleBarLayout$Position;

        static {
            int[] iArr = new int[ITitleBarLayout.Position.values().length];
            $SwitchMap$com$tencent$qcloud$tuicore$component$interfaces$ITitleBarLayout$Position = iArr;
            try {
                iArr[ITitleBarLayout.Position.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$qcloud$tuicore$component$interfaces$ITitleBarLayout$Position[ITitleBarLayout.Position.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$qcloud$tuicore$component$interfaces$ITitleBarLayout$Position[ITitleBarLayout.Position.MIDDLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public TitleBarLayout(Context context) {
        super(context);
        init(context, null);
    }

    private void init(final Context context, AttributeSet attributeSet) {
        String str;
        boolean z = false;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TitleBarLayout);
            str = obtainStyledAttributes.getString(R.styleable.TitleBarLayout_title_bar_middle_title);
            z = obtainStyledAttributes.getBoolean(R.styleable.TitleBarLayout_title_bar_can_return, false);
            obtainStyledAttributes.recycle();
        } else {
            str = null;
        }
        View.inflate(context, R.layout.title_bar_layout, this);
        this.mTitleLayout = (RelativeLayout) findViewById(R.id.page_title_layout);
        this.mLeftGroup = (LinearLayout) findViewById(R.id.page_title_left_group);
        this.mRightGroup = (LinearLayout) findViewById(R.id.page_title_right_group);
        this.mLeftTitle = (TextView) findViewById(R.id.page_title_left_text);
        this.mRightTitle = (TextView) findViewById(R.id.page_title_right_text);
        this.mCenterTitle = (TextView) findViewById(R.id.page_title);
        this.mLeftIcon = (ImageView) findViewById(R.id.page_title_left_icon);
        this.mRightIcon = (ImageView) findViewById(R.id.page_title_right_icon);
        this.unreadCountTextView = (UnreadCountTextView) findViewById(R.id.new_message_total_unread);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mTitleLayout.getLayoutParams();
        layoutParams.height = ScreenUtil.getPxByDp(50.0f);
        this.mTitleLayout.setLayoutParams(layoutParams);
        setBackgroundResource(TUIThemeManager.getAttrResId(getContext(), R.attr.core_title_bar_bg));
        int dip2px = ScreenUtil.dip2px(20.0f);
        ViewGroup.LayoutParams layoutParams2 = this.mLeftIcon.getLayoutParams();
        layoutParams2.width = dip2px;
        layoutParams2.height = dip2px;
        this.mLeftIcon.setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = this.mRightIcon.getLayoutParams();
        layoutParams3.width = dip2px;
        layoutParams3.height = dip2px;
        this.mRightIcon.setLayoutParams(layoutParams3);
        if (z) {
            this.mLeftGroup.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuicore.component.TitleBarLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (context instanceof Activity) {
                        ((InputMethodManager) TitleBarLayout.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(TitleBarLayout.this.getWindowToken(), 0);
                        ((Activity) context).finish();
                    }
                }
            });
        }
        if (!TextUtils.isEmpty(str)) {
            this.mCenterTitle.setText(str);
        }
    }

    @Override // com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout
    public LinearLayout getLeftGroup() {
        return this.mLeftGroup;
    }

    @Override // com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout
    public ImageView getLeftIcon() {
        return this.mLeftIcon;
    }

    @Override // com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout
    public TextView getLeftTitle() {
        return this.mLeftTitle;
    }

    @Override // com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout
    public TextView getMiddleTitle() {
        return this.mCenterTitle;
    }

    @Override // com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout
    public LinearLayout getRightGroup() {
        return this.mRightGroup;
    }

    @Override // com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout
    public ImageView getRightIcon() {
        return this.mRightIcon;
    }

    @Override // com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout
    public TextView getRightTitle() {
        return this.mRightTitle;
    }

    public UnreadCountTextView getUnreadCountTextView() {
        return this.unreadCountTextView;
    }

    @Override // com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout
    public void setLeftIcon(int i) {
        this.mLeftIcon.setBackgroundResource(i);
    }

    @Override // com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout
    public void setOnLeftClickListener(View.OnClickListener onClickListener) {
        this.mLeftGroup.setOnClickListener(onClickListener);
    }

    @Override // com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout
    public void setOnRightClickListener(View.OnClickListener onClickListener) {
        this.mRightGroup.setOnClickListener(onClickListener);
    }

    @Override // com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout
    public void setRightIcon(int i) {
        this.mRightIcon.setBackgroundResource(i);
    }

    @Override // com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout
    public void setTitle(String str, ITitleBarLayout.Position position) {
        int i = AnonymousClass2.$SwitchMap$com$tencent$qcloud$tuicore$component$interfaces$ITitleBarLayout$Position[position.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    this.mCenterTitle.setText(str);
                    return;
                }
                return;
            }
            this.mRightTitle.setText(str);
            return;
        }
        this.mLeftTitle.setText(str);
    }

    public TitleBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public TitleBarLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }
}
