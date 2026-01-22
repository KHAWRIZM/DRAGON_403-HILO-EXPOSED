package tech.sud.runtime.component.c;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.qcloud.tuicore.TUIConstants;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class a {
    private AudioManager a;
    private final tech.sud.runtime.core.g b;
    private AudioManager.OnAudioFocusChangeListener c = new AudioManager.OnAudioFocusChangeListener() { // from class: tech.sud.runtime.component.c.a.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            if (i != -2 && i != -1) {
                if (i != 1) {
                    return;
                }
                a.this.b.b(13, 0);
                return;
            }
            a.this.b.b(13, 1);
        }
    };

    public a(tech.sud.runtime.core.g gVar, Context context) {
        this.a = null;
        this.b = gVar;
        if (this.a == null) {
            this.a = (AudioManager) context.getApplicationContext().getSystemService(TUIConstants.TUICalling.TYPE_AUDIO);
            c();
        }
    }

    public void b() {
        AudioManager audioManager = this.a;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(this.c);
        }
    }

    public void c() {
        AudioManager audioManager = this.a;
        if (audioManager != null) {
            audioManager.requestAudioFocus(this.c, 3, 3);
        }
    }

    public void a() {
        b();
        this.a = null;
    }
}
