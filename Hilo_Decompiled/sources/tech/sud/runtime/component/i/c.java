package tech.sud.runtime.component.i;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import android.widget.MediaController;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import tech.sud.runtime.component.h.f;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class c extends SurfaceView implements MediaController.MediaPlayerControl {
    private float A;
    private int B;
    private a C;
    private boolean D;
    private boolean E;
    private String F;
    private boolean G;
    private MediaPlayer.OnCompletionListener H;
    private MediaPlayer.OnErrorListener I;
    private MediaPlayer.OnBufferingUpdateListener J;
    protected Context a;
    protected int b;
    protected int c;
    protected int d;
    protected int e;
    protected int f;
    protected int g;
    protected int h;
    protected int i;
    protected boolean j;
    protected int k;
    protected int l;
    MediaPlayer.OnPreparedListener m;
    SurfaceHolder.Callback n;
    private String o;
    private Uri p;
    private int q;
    private int r;
    private int s;
    private SurfaceHolder t;
    private MediaPlayer u;
    private int v;
    private int w;
    private d x;
    private int y;
    private int z;

    public c(Context context, int i) {
        super(context);
        this.o = "VideoView";
        this.r = 0;
        this.s = 0;
        this.t = null;
        this.u = null;
        this.v = 0;
        this.w = 0;
        this.a = null;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = false;
        this.k = 0;
        this.l = 0;
        this.B = 0;
        this.D = false;
        this.E = false;
        this.F = null;
        this.G = false;
        this.m = new MediaPlayer.OnPreparedListener() { // from class: tech.sud.runtime.component.i.c.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                c.this.r = 2;
                if (c.this.x != null) {
                    c.this.x.a(c.this.B, mediaPlayer.getDuration(), mediaPlayer.getCurrentPosition());
                }
                c.this.v = mediaPlayer.getVideoWidth();
                c.this.w = mediaPlayer.getVideoHeight();
                int i2 = c.this.z;
                if (i2 != 0) {
                    c.this.seekTo(i2);
                }
                c.this.u.setVolume(c.this.A, c.this.A);
                if (c.this.s == 3) {
                    c.this.start();
                }
            }
        };
        this.H = new MediaPlayer.OnCompletionListener() { // from class: tech.sud.runtime.component.i.c.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                c.this.r = 5;
                c.this.s = 5;
                if (c.this.x != null) {
                    c.this.x.a(c.this.B);
                }
            }
        };
        this.I = new MediaPlayer.OnErrorListener() { // from class: tech.sud.runtime.component.i.c.3
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                int identifier;
                f.b(c.this.o, "Error: " + i2 + "," + i3);
                c.this.r = -1;
                c.this.s = -1;
                if (c.this.x != null) {
                    c.this.x.b(c.this.B);
                    return true;
                }
                if (c.this.getWindowToken() != null) {
                    Resources resources = c.this.a.getResources();
                    if (i2 == 200) {
                        identifier = resources.getIdentifier("VideoView_error_text_invalid_progressive_playback", "string", "android");
                    } else {
                        identifier = resources.getIdentifier("VideoView_error_text_unknown", "string", "android");
                    }
                    new AlertDialog.Builder(c.this.a).setTitle(resources.getString(resources.getIdentifier("VideoView_error_title", "string", "android"))).setMessage(identifier).setPositiveButton(resources.getString(resources.getIdentifier("VideoView_error_button", "string", "android")), new DialogInterface.OnClickListener() { // from class: tech.sud.runtime.component.i.c.3.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i4) {
                            if (c.this.x != null) {
                                c.this.x.a(c.this.B);
                            }
                        }
                    }).setCancelable(false).show();
                }
                return true;
            }
        };
        this.J = new MediaPlayer.OnBufferingUpdateListener() { // from class: tech.sud.runtime.component.i.c.4
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
                c.this.y = i2;
            }
        };
        this.n = new SurfaceHolder.Callback() { // from class: tech.sud.runtime.component.i.c.5
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
                boolean z;
                boolean z2 = false;
                if (c.this.s == 3) {
                    z = true;
                } else {
                    z = false;
                }
                if (c.this.v == i3 && c.this.w == i4) {
                    z2 = true;
                }
                if (c.this.u != null && z && z2) {
                    if (c.this.z != 0) {
                        c cVar = c.this;
                        cVar.seekTo(cVar.z);
                    }
                    c.this.start();
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                c.this.t = surfaceHolder;
                c.this.e();
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                c.this.t = null;
                c.this.a(true);
            }
        };
        this.B = i;
        this.a = context;
        d();
        this.C = new a(context, this);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        return this.u.getAudioSessionId();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        if (this.u != null) {
            return this.y;
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (c()) {
            return this.u.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (c()) {
            int i = this.q;
            if (i > 0) {
                return i;
            }
            int duration = this.u.getDuration();
            this.q = duration;
            return duration;
        }
        this.q = -1;
        return -1;
    }

    public a getVideoControlView() {
        return this.C;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (c() && this.u.isPlaying()) {
            return true;
        }
        return false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        if (c() && this.u.isPlaying()) {
            this.u.pause();
            this.r = 4;
        }
        this.s = 4;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        if (c()) {
            this.u.seekTo(i);
            this.z = 0;
        } else {
            this.z = i;
        }
    }

    public void setEventCallback(d dVar) {
        this.x = dVar;
    }

    public void setKeepRatio(boolean z) {
        this.G = z;
    }

    public void setVideoFileName(String str) {
        if (str.startsWith("assets/")) {
            str = str.substring(7);
        }
        if (str.startsWith("/")) {
            this.E = false;
        } else {
            this.F = str;
            this.E = true;
        }
        a(Uri.fromFile(new File(str)), (Map<String, String>) null);
    }

    public void setVideoURL(String str) {
        this.E = false;
        a(Uri.parse(str), (Map<String, String>) null);
    }

    @Override // android.view.SurfaceView, android.view.View
    public void setVisibility(int i) {
        if (i == 4) {
            boolean isPlaying = isPlaying();
            this.D = isPlaying;
            if (isPlaying) {
                this.z = getCurrentPosition();
            }
        } else if (this.D) {
            start();
            this.D = false;
        }
        super.setVisibility(i);
    }

    public void setVolume(float f) {
        if (c()) {
            this.u.setVolume(f, f);
        }
        this.A = f;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (c()) {
            this.u.start();
            this.r = 3;
        }
        this.s = 3;
    }

    private void d() {
        this.v = 0;
        this.w = 0;
        getHolder().addCallback(this.n);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.r = 0;
        this.s = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.t == null) {
            return;
        }
        if (this.E) {
            if (this.F == null) {
                return;
            }
        } else if (this.p == null) {
            return;
        }
        a(false);
        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.u = mediaPlayer;
            mediaPlayer.setOnPreparedListener(this.m);
            this.u.setOnCompletionListener(this.H);
            this.u.setOnErrorListener(this.I);
            this.u.setOnBufferingUpdateListener(this.J);
            this.u.setDisplay(this.t);
            this.u.setAudioStreamType(3);
            this.u.setScreenOnWhilePlaying(true);
            this.q = -1;
            this.y = 0;
            if (this.E) {
                AssetFileDescriptor openFd = this.a.getAssets().openFd(this.F);
                this.u.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
            } else {
                this.u.setDataSource(this.a, this.p);
            }
            this.u.prepareAsync();
            this.r = 1;
        } catch (IOException e) {
            f.a(this.o, "Unable to open content: " + this.p, e);
            this.r = -1;
            this.s = -1;
            this.I.onError(this.u, 1, 0);
        } catch (IllegalArgumentException e2) {
            f.a(this.o, "Unable to open content: " + this.p, e2);
            this.r = -1;
            this.s = -1;
            this.I.onError(this.u, 1, 0);
        }
    }

    public void b() {
        pause();
        d dVar = this.x;
        if (dVar != null) {
            dVar.a(this.B);
        }
    }

    public boolean c() {
        int i;
        return (this.u == null || (i = this.r) == -1 || i == 0 || i == 1) ? false : true;
    }

    public void a(boolean z, int i, int i2) {
        this.j = z;
        this.C.a(z);
        if (i != 0 && i2 != 0) {
            this.k = i;
            this.l = i2;
        }
        a();
    }

    private void a(Uri uri, Map<String, String> map) {
        this.p = uri;
        this.z = 0;
        this.A = 1.0f;
        this.v = 0;
        this.w = 0;
        requestLayout();
        invalidate();
    }

    public void a() {
        if (this.j) {
            a(0, 0, this.k, this.l);
        } else {
            a(this.b, this.c, this.d, this.e);
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        int i5;
        int i6 = this.v;
        if (i6 == 0 || (i5 = this.w) == 0) {
            this.f = i;
            this.g = i2;
            this.h = i3;
            this.i = i4;
        } else if (i3 != 0 && i4 != 0) {
            if (this.G) {
                int i7 = i6 * i4;
                int i8 = i3 * i5;
                if (i7 > i8) {
                    this.h = i3;
                    this.i = i8 / i6;
                } else if (i7 < i8) {
                    this.h = i7 / i5;
                    this.i = i4;
                }
                this.f = ((i3 - this.h) / 2) + i;
                this.g = ((i4 - this.i) / 2) + i2;
            } else {
                this.f = i;
                this.g = i2;
                this.h = i3;
                this.i = i4;
            }
        } else {
            this.f = i;
            this.g = i2;
            this.h = i6;
            this.i = i5;
        }
        getHolder().setFixedSize(this.h, this.i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.f;
        layoutParams.topMargin = this.g;
        layoutParams.gravity = 51;
        setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        MediaPlayer mediaPlayer = this.u;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.u.release();
            this.u = null;
            this.r = 0;
            if (z) {
                this.s = 0;
            }
        }
    }
}
