package tech.sud.runtime.component.a;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import tech.sud.runtime.core.JNIShell;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class a {
    static int a = 64;
    static float b = 20.0f;
    private boolean c;
    private TextView d;
    private TextView e;
    private b f;
    private FrameLayout g;
    private int h;
    private int i;
    private String j;

    private a(Context context, FrameLayout frameLayout) {
        this.c = false;
        this.g = null;
        this.h = 0;
        this.i = 0;
        this.j = "";
        this.d = new TextView(context);
        this.e = new TextView(context);
        frameLayout.addView(this.d);
        frameLayout.addView(this.e);
    }

    private void b() {
        FrameLayout frameLayout = this.g;
        if (frameLayout != null) {
            frameLayout.removeView(this.d);
            this.g.removeView(this.e);
            this.g.removeView(this.f);
        }
    }

    public void a(int i, int i2, String str) {
        int i3;
        if (this.c) {
            if (this.j.compareTo(str) != 0 || this.h != i || this.i != i2) {
                this.h = i;
                this.i = i2;
                this.j = str;
                String str2 = "FPS: ";
                if (i >= 0) {
                    str2 = "FPS: " + this.h + " / ";
                }
                String str3 = str2 + this.i + "\nDraw: " + str;
                int i4 = this.h;
                if (i4 >= 58) {
                    i3 = -1;
                } else {
                    i3 = i4 > this.i ? -256 : -30720;
                }
                this.d.setText(str3);
                this.d.setTextColor(i3);
            }
            this.d.bringToFront();
            this.f.a();
        }
    }

    public a(Context context, FrameLayout frameLayout, int i, String str, boolean z) {
        this(context, frameLayout);
        int i2;
        int i3;
        this.c = z;
        if (z) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int i4 = displayMetrics.heightPixels;
            if (750 > i4) {
                i3 = i4 / 30;
                i2 = i3 * 10;
                b = i3 * 0.8f;
            } else {
                i2 = RoomEvent.ROOM_CURRENT_USER_ONLINE;
                i3 = 25;
            }
            String str2 = "[ " + JNIShell.version(0) + "." + JNIShell.version(1) + " ]";
            if (str.length() > 0) {
                str2 = str2 + "[ " + str + " ]";
            }
            int i5 = i3 * 2;
            this.d.setLayoutParams(new FrameLayout.LayoutParams(i2, i5));
            this.d.setBackgroundColor(-65536);
            this.d.getBackground().setAlpha(a);
            this.d.setText("FPS: 0\nDraw: 0");
            this.d.setTextSize(0, b);
            this.d.setGravity(16);
            this.d.setPadding(5, 0, 0, 0);
            this.e.setLayoutParams(new FrameLayout.LayoutParams(i2, i3));
            this.e.setY(i5);
            this.e.setBackgroundColor(-65536);
            this.e.getBackground().setAlpha(a);
            this.e.setText(str2);
            this.e.setTextSize(0, b);
            this.e.setGravity(16);
            this.e.setPadding(5, 0, 0, 0);
            this.d.setTextColor(-1);
            this.e.setTextColor(-1);
            this.f = new b(context, i);
            this.f.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.f.setY(i3 * 3);
            this.f.setPadding(5, 0, 0, 0);
            this.g = frameLayout;
            frameLayout.bringChildToFront(this.d);
            this.g.bringChildToFront(this.e);
            this.g.addView(this.f);
            this.g.bringChildToFront(this.f);
        }
    }

    public void a() {
        b();
    }

    private void a(int i) {
        this.d.setBackgroundColor(i);
        this.e.setBackgroundColor(i);
        this.d.getBackground().setAlpha(a);
        this.e.getBackground().setAlpha(a);
        this.d.setTextColor(-1);
        this.e.setTextColor(-1);
    }

    public void a(boolean z) {
        if (this.c) {
            if (z) {
                a(-16711936);
            } else {
                a(-65536);
            }
        }
    }

    public void a(int i, String str) {
        if (this.c) {
            this.f.a(i, str);
        }
    }
}
