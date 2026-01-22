package com.qmuiteam.qmui.widget.textview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;
import anet.channel.util.HttpConstant;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.alpha.QMUIAlphaTextView;
import com.qmuiteam.qmui.link.QMUILinkify;
import java.util.HashSet;
import java.util.Set;
import kotlin.KotlinVersion;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUILinkTextView extends QMUIAlphaTextView implements hc.a {

    /* renamed from: l, reason: collision with root package name */
    public static int f١٣٤٣٥l = 7;

    /* renamed from: m, reason: collision with root package name */
    private static Set f١٣٤٣٦m;

    /* renamed from: n, reason: collision with root package name */
    private static final long f١٣٤٣٧n;

    /* renamed from: f, reason: collision with root package name */
    private CharSequence f١٣٤٣٨f;

    /* renamed from: g, reason: collision with root package name */
    private ColorStateList f١٣٤٣٩g;

    /* renamed from: h, reason: collision with root package name */
    private ColorStateList f١٣٤٤٠h;

    /* renamed from: i, reason: collision with root package name */
    private int f١٣٤٤١i;

    /* renamed from: j, reason: collision with root package name */
    private long f١٣٤٤٢j;

    /* renamed from: k, reason: collision with root package name */
    private Handler f١٣٤٤٣k;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (1000 != message.what) {
                return;
            }
            Log.d("LinkTextView", "handleMessage: " + message.obj);
            Object obj = message.obj;
            if (obj instanceof String) {
                QMUILinkTextView.l(QMUILinkTextView.this);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface b {
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface c {
    }

    static {
        HashSet hashSet = new HashSet();
        f١٣٤٣٦m = hashSet;
        hashSet.add("tel");
        f١٣٤٣٦m.add("mailto");
        f١٣٤٣٦m.add(HttpConstant.HTTP);
        f١٣٤٣٦m.add(HttpConstant.HTTPS);
        f١٣٤٣٧n = ViewConfiguration.getDoubleTapTimeout();
    }

    public QMUILinkTextView(Context context) {
        this(context, null);
        this.f١٣٤٤٠h = null;
        this.f١٣٤٣٩g = androidx.core.content.a.getColorStateList(context, R.color.qmui_s_link_color);
    }

    static /* bridge */ /* synthetic */ b l(QMUILinkTextView qMUILinkTextView) {
        qMUILinkTextView.getClass();
        return null;
    }

    private void m() {
        this.f١٣٤٤٣k.removeMessages(1000);
        this.f١٣٤٤٢j = 0L;
    }

    @Override // hc.a
    public boolean a(String str) {
        if (str == null) {
            Log.w("LinkTextView", "onSpanClick interrupt null text");
            return true;
        }
        long uptimeMillis = SystemClock.uptimeMillis() - this.f١٣٤٤٢j;
        Log.w("LinkTextView", "onSpanClick clickUpTime: " + uptimeMillis);
        if (this.f١٣٤٤٣k.hasMessages(1000)) {
            m();
            return true;
        }
        if (200 < uptimeMillis) {
            Log.w("LinkTextView", "onSpanClick interrupted because of TAP_TIMEOUT: " + uptimeMillis);
            return true;
        }
        String scheme = Uri.parse(str).getScheme();
        if (scheme != null) {
            scheme = scheme.toLowerCase();
        }
        if (f١٣٤٣٦m.contains(scheme)) {
            long j10 = f١٣٤٣٧n - uptimeMillis;
            this.f١٣٤٤٣k.removeMessages(1000);
            Message obtain = Message.obtain();
            obtain.what = 1000;
            obtain.obj = str;
            this.f١٣٤٤٣k.sendMessageDelayed(obtain, j10);
            return true;
        }
        return false;
    }

    public int getAutoLinkMaskCompat() {
        return this.f١٣٤٤١i;
    }

    protected boolean n(String str) {
        return false;
    }

    @Override // com.qmuiteam.qmui.widget.textview.QMUISpanTouchFixTextView, android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & KotlinVersion.MAX_COMPONENT_VALUE) == 0) {
            boolean hasMessages = this.f١٣٤٤٣k.hasMessages(1000);
            Log.w("LinkTextView", "onTouchEvent hasSingleTap: " + hasMessages);
            if (!hasMessages) {
                this.f١٣٤٤٢j = SystemClock.uptimeMillis();
            } else {
                Log.w("LinkTextView", "onTouchEvent disallow onSpanClick mSingleTapConfirmedHandler because of DOUBLE TAP");
                m();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.qmuiteam.qmui.widget.textview.QMUISpanTouchFixTextView, android.widget.TextView, android.view.View
    public boolean performLongClick() {
        int selectionEnd = getSelectionEnd();
        if (selectionEnd > 0) {
            if (!n(getText().subSequence(getSelectionStart(), selectionEnd).toString()) && !super.performLongClick()) {
                return false;
            }
            return true;
        }
        return super.performLongClick();
    }

    public void setAutoLinkMaskCompat(int i10) {
        this.f١٣٤٤١i = i10;
    }

    public void setLinkColor(ColorStateList colorStateList) {
        this.f١٣٤٣٩g = colorStateList;
    }

    public void setOnLinkClickListener(b bVar) {
    }

    public void setOnLinkLongClickListener(c cVar) {
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.f١٣٤٣٨f = charSequence;
        if (!TextUtils.isEmpty(charSequence)) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
            QMUILinkify.a(spannableStringBuilder, this.f١٣٤٤١i, this.f١٣٤٣٩g, this.f١٣٤٤٠h, this);
            charSequence = spannableStringBuilder;
        }
        super.setText(charSequence, bufferType);
    }

    public QMUILinkTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f١٣٤٣٨f = null;
        this.f١٣٤٤٢j = 0L;
        this.f١٣٤٤٣k = new a(Looper.getMainLooper());
        this.f١٣٤٤١i = getAutoLinkMask() | f١٣٤٣٥l;
        setAutoLinkMask(0);
        setMovementMethodCompat(com.qmuiteam.qmui.link.c.getInstance());
        setHighlightColor(0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QMUILinkTextView);
        this.f١٣٤٤٠h = obtainStyledAttributes.getColorStateList(R.styleable.QMUILinkTextView_qmui_linkBackgroundColor);
        this.f١٣٤٣٩g = obtainStyledAttributes.getColorStateList(R.styleable.QMUILinkTextView_qmui_linkTextColor);
        obtainStyledAttributes.recycle();
        CharSequence charSequence = this.f١٣٤٣٨f;
        if (charSequence != null) {
            setText(charSequence);
        }
        setChangeAlphaWhenPress(false);
    }
}
