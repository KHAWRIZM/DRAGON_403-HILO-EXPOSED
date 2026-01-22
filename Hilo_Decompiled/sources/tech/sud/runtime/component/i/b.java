package tech.sud.runtime.component.i;

import android.content.Context;
import android.widget.FrameLayout;
import e0.m;
import java.util.HashMap;
import java.util.Map;
import tech.sud.runtime.core.g;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class b {
    private final FrameLayout b;
    private final g c;
    private Map<Integer, c> a = new HashMap(10);
    private d d = new d() { // from class: tech.sud.runtime.component.i.b.1
        @Override // tech.sud.runtime.component.i.d
        public void a(int i, int i2, int i3) {
            b.this.a(i, i2, i3);
        }

        @Override // tech.sud.runtime.component.i.d
        public void b(int i) {
            b.this.e(i);
        }

        @Override // tech.sud.runtime.component.i.d
        public void a(int i) {
            b.this.d(i);
        }
    };

    public b(FrameLayout frameLayout, g gVar) {
        this.b = frameLayout;
        this.c = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        this.c.b(4, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i) {
        this.c.b(5, i);
    }

    public void a() {
    }

    public void c(int i) {
        c cVar = this.a.get(Integer.valueOf(i));
        if (cVar == null) {
            return;
        }
        cVar.pause();
    }

    public void b(int i) {
        c cVar = this.a.get(Integer.valueOf(i));
        if (cVar == null) {
            return;
        }
        cVar.setKeepRatio(true);
        cVar.a(true, this.c.c(), this.c.d());
        cVar.start();
    }

    public void a(Context context, int i) {
        c cVar = new c(context, i);
        cVar.setZOrderOnTop(true);
        cVar.setEventCallback(this.d);
        this.a.put(Integer.valueOf(i), cVar);
    }

    public void a(int i) {
        c cVar = this.a.get(Integer.valueOf(i));
        if (cVar == null) {
            return;
        }
        a videoControlView = cVar.getVideoControlView();
        if (videoControlView != null) {
            videoControlView.a();
        }
        this.a.remove(Integer.valueOf(i));
    }

    public void a(int i, String str) {
        c cVar;
        if (this.b == null || (cVar = this.a.get(Integer.valueOf(i))) == null) {
            return;
        }
        cVar.setVideoFileName(str);
        this.b.addView(cVar.getVideoControlView(), new FrameLayout.LayoutParams(1, 1));
    }

    public void a(int i, int i2) {
        c cVar = this.a.get(Integer.valueOf(i));
        if (cVar == null) {
            return;
        }
        cVar.seekTo(i2);
    }

    public void a(int i, float f) {
        c cVar = this.a.get(Integer.valueOf(i));
        if (cVar == null) {
            return;
        }
        cVar.setVolume(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3) {
        this.c.a(3, i, i2, m.a(i3, ""));
    }
}
