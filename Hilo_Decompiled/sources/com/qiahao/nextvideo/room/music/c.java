package com.qiahao.nextvideo.room.music;

import android.util.Log;
import com.qiahao.nextvideo.agoraadapter.IRTCEngine;
import com.qiahao.nextvideo.data.service.agora.HiloRtcEngine;
import com.qiahao.nextvideo.room.music.MusicCache;
import com.qiahao.nextvideo.room.music.MusicLoader;
import io.reactivex.rxjava3.core.b0;
import io.reactivex.rxjava3.core.c0;
import io.reactivex.rxjava3.core.g0;
import io.reactivex.rxjava3.core.z;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class c {
    private final MusicLoader a;
    private int b;
    private Integer d;
    private InterfaceC٠٠٠٢c f;
    private boolean c = false;
    private MusicStatus e = MusicStatus.STOP;
    private final ArrayList g = new ArrayList();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public interface b {
        void onLoadingFinish();
    }

    /* renamed from: com.qiahao.nextvideo.room.music.c$c, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public interface InterfaceC٠٠٠٢c {
        void lastOne(MusicLoader.MusicInfo musicInfo);

        void nextOne(MusicLoader.MusicInfo musicInfo);

        void onPause();

        void onResume();

        void onStop();

        void start(MusicLoader.MusicInfo musicInfo);
    }

    public c(MusicLoader musicLoader) {
        this.b = 20;
        this.d = 0;
        this.a = musicLoader;
        MusicCache.Companion companion = MusicCache.INSTANCE;
        this.b = companion.getLocalVolume();
        this.d = Integer.valueOf(companion.getLocalRotateType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(b0 b0Var, List list) {
        this.c = true;
        b0Var.onNext(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(final b0 b0Var) {
        this.a.g(new d() { // from class: com.qiahao.nextvideo.room.music.b
            @Override // com.qiahao.nextvideo.room.music.d
            public final void onResult(Object obj) {
                c.this.l(b0Var, (List) obj);
            }
        }, false);
    }

    public Integer d() {
        if (this.d.intValue() == 0) {
            this.d = 1;
        } else {
            this.d = 0;
        }
        MusicCache.INSTANCE.saveLocalRotateType(this.d.intValue());
        return this.d;
    }

    public MusicLoader.MusicInfo e() {
        MusicLoader.MusicInfo m = MusicLoader.m();
        if (m == null && this.a.j().size() > 0) {
            MusicLoader.o((MusicLoader.MusicInfo) this.a.j().get(0));
            return (MusicLoader.MusicInfo) this.a.j().get(0);
        }
        return m;
    }

    public MusicLoader.MusicInfo f() {
        MusicLoader.MusicInfo m = MusicLoader.m();
        if (m == null) {
            return null;
        }
        this.d.intValue();
        return this.a.e(m.c());
    }

    public MusicLoader g() {
        return this.a;
    }

    public Integer h() {
        return this.d;
    }

    public MusicStatus i() {
        return this.e;
    }

    public MusicLoader.MusicInfo j(boolean z) {
        MusicLoader.MusicInfo m = MusicLoader.m();
        if (m == null) {
            return null;
        }
        if (z) {
            if (this.d.intValue() != 1) {
                return this.a.k(m.c());
            }
            return m;
        }
        this.d.intValue();
        return this.a.k(m.c());
    }

    public int k() {
        int i = this.b;
        if (i > 100) {
            return 100;
        }
        if (i < 0) {
            return 0;
        }
        return i;
    }

    public void n() {
        MusicLoader.MusicInfo f = f();
        InterfaceC٠٠٠٢c r1 = this.f;
        if (r1 != null && f != null) {
            r1.lastOne(f);
        }
    }

    public void o() {
        if (this.c) {
            if (!this.g.isEmpty()) {
                for (int i = 0; i < this.g.size(); i++) {
                    try {
                        ((b) this.g.get(i)).onLoadingFinish();
                    } catch (Exception e) {
                        Log.d("MusicManager", "loading: 防止数组越界奔溃" + e.getLocalizedMessage());
                    }
                }
                return;
            }
            return;
        }
        z.create(new c0() { // from class: com.qiahao.nextvideo.room.music.a
            public final void a(b0 b0Var) {
                c.this.m(b0Var);
            }
        }).subscribeOn(ke.a.b()).observeOn(md.b.c()).subscribe(new a());
    }

    public void p(boolean z) {
        MusicLoader.MusicInfo j = j(z);
        InterfaceC٠٠٠٢c r0 = this.f;
        if (r0 != null && j != null) {
            r0.nextOne(j);
        } else if (j != null) {
            HiloRtcEngine.INSTANCE.startAudioMixing(j.e(), false, 1);
            this.e = MusicStatus.PLAY;
        }
    }

    public void q() {
        InterfaceC٠٠٠٢c r0 = this.f;
        if (r0 != null) {
            r0.onPause();
        } else {
            HiloRtcEngine.INSTANCE.pauseAudioMixing();
            this.e = MusicStatus.PAUSE;
        }
    }

    public void r() {
        if (this.f != null && e() != null) {
            this.f.start(e());
        }
    }

    public void removeOnLoadingListener(b bVar) {
        Log.d("MusicManager", "removeOnLoadingListener: remove---");
        this.g.remove(bVar);
    }

    public void s() {
        if (this.f != null && e() != null) {
            this.f.onResume();
        }
    }

    public void setOnLoadingListener(b bVar) {
        Log.d("MusicManager", "removeOnLoadingListener: add---");
        if (this.g.contains(bVar)) {
            return;
        }
        this.g.add(bVar);
    }

    public void setOnMusicActionListener(InterfaceC٠٠٠٢c r1) {
        this.f = r1;
    }

    public void t(MusicStatus musicStatus) {
        this.e = musicStatus;
    }

    public void u(int i) {
        MusicCache.INSTANCE.saveLocalVolume(i);
        this.b = i;
    }

    public void v() {
        InterfaceC٠٠٠٢c r0 = this.f;
        if (r0 != null) {
            r0.onStop();
            return;
        }
        IRTCEngine engine = HiloRtcEngine.INSTANCE.getEngine();
        if (engine != null) {
            engine.stopAudioMixing();
        }
        this.e = MusicStatus.STOP;
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    class a implements g0 {
        a() {
        }

        public void onComplete() {
        }

        public void onError(Throwable th) {
        }

        public void onNext(Object obj) {
            if (!c.this.g.isEmpty()) {
                for (int i = 0; i < c.this.g.size(); i++) {
                    try {
                        ((b) c.this.g.get(i)).onLoadingFinish();
                    } catch (Exception e) {
                        Log.d("MusicManager", "loading: 防止数组越界奔溃" + e.getLocalizedMessage());
                    }
                }
            }
            Log.d("MusicManager", "onNext: 加载结束～～～");
        }

        public void onSubscribe(nd.c cVar) {
        }
    }
}
