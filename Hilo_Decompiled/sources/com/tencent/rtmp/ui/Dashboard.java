package com.tencent.rtmp.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.trtc.hardwareearmonitor.honor.HonorResultCode;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class Dashboard extends LinearLayout {
    private final StringBuilder a;
    private final SimpleDateFormat b;
    private TextView c;
    private TextView d;
    private ScrollView e;
    private int f;
    private boolean g;

    public Dashboard(Context context) {
        this(context, null);
    }

    private void a() {
        if (this.c != null) {
            return;
        }
        this.c = new TextView(getContext());
        this.d = new TextView(getContext());
        this.e = new ScrollView(getContext());
        this.c.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.c.setTextColor(-49023);
        this.c.setTypeface(Typeface.MONOSPACE);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.e.setPadding(0, 10, 0, 0);
        this.e.setLayoutParams(layoutParams);
        this.e.setVerticalScrollBarEnabled(true);
        this.e.setScrollbarFadingEnabled(true);
        this.d.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.d.setTextColor(-49023);
        this.e.addView(this.d);
        addView(this.c);
        addView(this.e);
        if (this.a.length() <= 0) {
            this.a.append("liteav sdk version:\n");
        }
        this.d.setText(this.a.toString());
    }

    public void setEventTextSize(float f) {
        TextView textView = this.d;
        if (textView != null) {
            textView.setTextSize(f);
        }
    }

    public void setMessageMaxLength(int i) {
        this.f = i;
    }

    public void setShowLevel(int i) {
        if (i != 0) {
            if (i != 1) {
                a();
                this.c.setVisibility(0);
                this.e.setVisibility(0);
                setVisibility(0);
                return;
            }
            a();
            this.c.setVisibility(0);
            this.e.setVisibility(4);
            setVisibility(0);
            return;
        }
        TextView textView = this.c;
        if (textView != null) {
            textView.setVisibility(4);
        }
        ScrollView scrollView = this.e;
        if (scrollView != null) {
            scrollView.setVisibility(4);
        }
        setVisibility(4);
    }

    public void setStatusText(CharSequence charSequence) {
        TextView textView = this.c;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void setStatusTextSize(float f) {
        TextView textView = this.c;
        if (textView != null) {
            textView.setTextSize(f);
        }
    }

    public Dashboard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new StringBuilder();
        this.b = new SimpleDateFormat("HH:mm:ss.SSS", Locale.ENGLISH);
        this.f = HonorResultCode.AUDIO_PLAY_SERVICE_SUCCESS;
        this.g = false;
        setOrientation(1);
        setVisibility(8);
    }
}
