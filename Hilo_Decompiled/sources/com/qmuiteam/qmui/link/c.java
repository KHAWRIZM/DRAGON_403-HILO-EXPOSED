package com.qmuiteam.qmui.link;

import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.method.Touch;
import android.view.MotionEvent;
import android.widget.TextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class c extends LinkMovementMethod {

    /* renamed from: a, reason: collision with root package name */
    private static c f١٢٧٤٧a;

    /* renamed from: b, reason: collision with root package name */
    private static b f١٢٧٤٨b = new b();

    public static MovementMethod getInstance() {
        if (f١٢٧٤٧a == null) {
            f١٢٧٤٧a = new c();
        }
        return f١٢٧٤٧a;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        if (!f١٢٧٤٨b.b(textView, spannable, motionEvent) && !Touch.onTouchEvent(textView, spannable, motionEvent)) {
            return false;
        }
        return true;
    }
}
