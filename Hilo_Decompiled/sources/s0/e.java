package s0;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import e0.a0;
import e0.d0;
import e0.e0;
import e0.g0;
import e0.p0;
import e0.u0;
import org.json.JSONObject;
import tech.sud.gip.R;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class e extends l {

    /* renamed from: v, reason: collision with root package name */
    public static final String f١٧٥٤٥v = "SudGIP ".concat(e.class.getSimpleName());

    /* renamed from: c, reason: collision with root package name */
    public int f١٧٥٤٦c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f١٧٥٤٧d = 0;

    /* renamed from: e, reason: collision with root package name */
    public final Context f١٧٥٤٨e;

    /* renamed from: f, reason: collision with root package name */
    public final View f١٧٥٤٩f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f١٧٥٥٠g;

    /* renamed from: h, reason: collision with root package name */
    public final ImageView f١٧٥٥١h;

    /* renamed from: i, reason: collision with root package name */
    public final ProgressBar f١٧٥٥٢i;

    /* renamed from: j, reason: collision with root package name */
    public final View f١٧٥٥٣j;

    /* renamed from: k, reason: collision with root package name */
    public final TextView f١٧٥٥٤k;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f١٧٥٥٥l;

    /* renamed from: m, reason: collision with root package name */
    public final View f١٧٥٥٦m;

    /* renamed from: n, reason: collision with root package name */
    public final View f١٧٥٥٧n;

    /* renamed from: o, reason: collision with root package name */
    public final View f١٧٥٥٨o;

    /* renamed from: p, reason: collision with root package name */
    public final TextView f١٧٥٥٩p;

    /* renamed from: q, reason: collision with root package name */
    public final TextView f١٧٥٦٠q;

    /* renamed from: r, reason: collision with root package name */
    public final TextView f١٧٥٦١r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f١٧٥٦٢s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f١٧٥٦٣t;

    /* renamed from: u, reason: collision with root package name */
    public ValueAnimator f١٧٥٦٤u;

    public e(Context context) {
        String charSequence;
        e.c cVar;
        h0.a aVar = h0.b.f١٤٤٨٧a;
        boolean z10 = aVar.f١٤٤٨٤b;
        this.f١٧٥٦٢s = z10;
        boolean z11 = aVar.f١٤٤٨٣a;
        this.f١٧٥٦٣t = z11;
        this.f١٧٥٤٨e = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.fsm_mgp_game_loading_layout, (ViewGroup) null);
        this.f١٧٥٤٩f = inflate;
        TextView textView = (TextView) inflate.findViewById(R.id.reload_btn);
        this.f١٧٥٥٠g = textView;
        ImageView imageView = (ImageView) inflate.findViewById(R.id.big_loading_pic);
        this.f١٧٥٥١h = imageView;
        this.f١٧٥٥٢i = (ProgressBar) inflate.findViewById(R.id.loading_progress);
        this.f١٧٥٥٣j = inflate.findViewById(R.id.fsm_mgp_game_loading_progress);
        TextView textView2 = (TextView) inflate.findViewById(R.id.loading_tip);
        this.f١٧٥٥٤k = textView2;
        TextView textView3 = (TextView) inflate.findViewById(R.id.loading_tip_result);
        this.f١٧٥٥٥l = textView3;
        this.f١٧٥٥٦m = inflate.findViewById(R.id.loading_panel);
        View findViewById = inflate.findViewById(R.id.container_progress);
        this.f١٧٥٥٧n = findViewById;
        this.f١٧٥٥٨o = inflate.findViewById(R.id.fsm_mgp_container_timeout);
        this.f١٧٥٥٩p = (TextView) inflate.findViewById(R.id.fsm_mgp_tv_timeout_tip);
        TextView textView4 = (TextView) inflate.findViewById(R.id.fsm_mgp_tv_continue_wait);
        this.f١٧٥٦٠q = textView4;
        TextView textView5 = (TextView) inflate.findViewById(R.id.fsm_mgp_tv_timeout_reload);
        this.f١٧٥٦١r = textView5;
        d.g e10 = e.d.e();
        if (e10 != null && (cVar = e10.f١٣٥٠٠d) != null) {
            charSequence = cVar.a(e.d.f١٣٧٢١d);
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = context.getText(R.string.fsm_mgp_loading_reload_game).toString();
            }
        } else {
            charSequence = context.getText(R.string.fsm_mgp_loading_reload_game).toString();
        }
        textView.setText(charSequence);
        textView.setOnClickListener(new View.OnClickListener() { // from class: s0.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.this.e(view);
            }
        });
        if (!z11) {
            imageView.setVisibility(4);
        }
        if (z10) {
            findViewById.setVisibility(4);
            textView2.setVisibility(4);
            textView3.setVisibility(4);
        }
        textView4.setOnClickListener(new r(this));
        textView5.setOnClickListener(new t(this));
    }

    public final void a() {
        if (this.f١٧٥٦٢s) {
            return;
        }
        this.f١٧٥٥٨o.setVisibility(8);
    }

    public final void b(int i10, JSONObject jSONObject) {
        if (i10 == 1) {
            this.f١٧٥٤٦c = 20;
            this.f١٧٥٨٥a.f١٧٠٧٨a.f١٧٠٧٣w.d("getMgInfo", 20, jSONObject);
        } else if (i10 == 2) {
            this.f١٧٥٤٦c = 40;
            this.f١٧٥٨٥a.f١٧٠٧٨a.f١٧٠٧٣w.d("downloadCore", 40, jSONObject);
        } else if (i10 == 3) {
            this.f١٧٥٤٦c = 80;
            this.f١٧٥٨٥a.f١٧٠٧٨a.f١٧٠٧٣w.d("checkoutGamePackage", 80, jSONObject);
        } else if (i10 == 5) {
            this.f١٧٥٤٦c = 100;
            this.f١٧٥٨٥a.f١٧٠٧٨a.f١٧٠٧٣w.d("loadGamePercent", 100, jSONObject);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.f١٧٥٥٢i.setProgress(this.f١٧٥٤٦c, true);
        } else {
            this.f١٧٥٥٢i.setProgress(this.f١٧٥٤٦c);
        }
        q0.e eVar = this.f١٧٥٨٥a;
        eVar.f١٧٠٧٨a.b(2, 0, this.f١٧٥٤٦c, false);
        g();
        a();
        c(0, true, this.f١٧٥٤٦c, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(int i10, boolean z10, int i11, boolean z11) {
        String str;
        String charSequence;
        String sb;
        e.c cVar;
        ViewGroup.LayoutParams layoutParams;
        String str2;
        e.c cVar2;
        String charSequence2;
        String sb2;
        e.c cVar3;
        ViewGroup.LayoutParams layoutParams2;
        String charSequence3;
        e.c cVar4;
        if (!z11) {
            this.f١٧٥٤٧d = i11;
        }
        int measuredWidth = this.f١٧٥٥٣j.getMeasuredWidth();
        if (measuredWidth <= 0) {
            measuredWidth = (int) ((234 * this.f١٧٥٤٨e.getResources().getDisplayMetrics().density) + 0.5f);
        }
        int i12 = 0;
        if (i10 == 0) {
            int i13 = -(measuredWidth - ((measuredWidth * i11) / 100));
            String str3 = e.d.f١٣٧٢١d;
            if (str3 != null) {
                String substring = str3.substring(0, 2);
                if (substring.equals("ar") || substring.equals("fa")) {
                    StringBuilder sb3 = new StringBuilder();
                    d.g e10 = e.d.e();
                    if (e10 != null && (cVar4 = e10.f١٣٤٩٧a) != null) {
                        charSequence3 = cVar4.a(e.d.f١٣٧٢١d);
                        if (TextUtils.isEmpty(charSequence3)) {
                            charSequence3 = this.f١٧٥٤٨e.getText(R.string.fsm_mgp_loading_tip_loading).toString();
                        }
                    } else {
                        charSequence3 = this.f١٧٥٤٨e.getText(R.string.fsm_mgp_loading_tip_loading).toString();
                    }
                    sb3.append(charSequence3);
                    sb3.append(" (٪");
                    sb3.append(i11);
                    sb3.append(")");
                    sb2 = sb3.toString();
                    if (i13 <= 0) {
                        i12 = i13;
                    }
                    this.f١٧٥٥٥l.setText(sb2);
                    if (z10) {
                        this.f١٧٥٥٥l.setTextColor(this.f١٧٥٤٨e.getResources().getColor(R.color.fsm_mgp_loading_tip_loading));
                    }
                    layoutParams2 = this.f١٧٥٥٣j.getLayoutParams();
                    if (!(layoutParams2 instanceof ViewGroup.MarginLayoutParams)) {
                        ((ViewGroup.MarginLayoutParams) layoutParams2).setMarginStart(i12);
                        this.f١٧٥٥٣j.setLayoutParams(layoutParams2);
                        return;
                    }
                    return;
                }
            }
            StringBuilder sb4 = new StringBuilder();
            d.g e11 = e.d.e();
            if (e11 != null && (cVar3 = e11.f١٣٤٩٧a) != null) {
                charSequence2 = cVar3.a(e.d.f١٣٧٢١d);
                if (TextUtils.isEmpty(charSequence2)) {
                    charSequence2 = this.f١٧٥٤٨e.getText(R.string.fsm_mgp_loading_tip_loading).toString();
                }
            } else {
                charSequence2 = this.f١٧٥٤٨e.getText(R.string.fsm_mgp_loading_tip_loading).toString();
            }
            sb4.append(charSequence2);
            sb4.append(" (");
            sb4.append(i11);
            sb4.append("%)");
            sb2 = sb4.toString();
            if (i13 <= 0) {
            }
            this.f١٧٥٥٥l.setText(sb2);
            if (z10) {
            }
            layoutParams2 = this.f١٧٥٥٣j.getLayoutParams();
            if (!(layoutParams2 instanceof ViewGroup.MarginLayoutParams)) {
            }
        } else {
            int i14 = -(measuredWidth - ((measuredWidth * i11) / 100));
            if (i14 > 0) {
                i14 = 0;
            }
            String str4 = e.d.f١٣٧٢١d;
            if (str4 != null) {
                String substring2 = str4.substring(0, 2);
                if (substring2.equals("ar") || substring2.equals("fa")) {
                    str = " (٪" + i11 + ") " + i10;
                    if (-10100 != i10) {
                        StringBuilder sb5 = new StringBuilder();
                        d.g e12 = e.d.e();
                        if (e12 != null && (cVar2 = e12.f١٣٤٩٩c) != null) {
                            str2 = cVar2.a(e.d.f١٣٧٢١d);
                            if (TextUtils.isEmpty(str2)) {
                                str2 = this.f١٧٥٤٨e.getText(R.string.fsm_mgp_loading_tip_fail_upgrade).toString();
                            }
                        } else {
                            String str5 = e.d.f١٣٧٢١d;
                            if (str5 != null && str5.equals("zh-CN")) {
                                str2 = this.f١٧٥٤٨e.getText(R.string.fsm_mgp_loading_tip_fail_upgrade).toString();
                            } else {
                                str2 = "Load fail, Please upgrade";
                            }
                        }
                        sb5.append(str2);
                        sb5.append(str);
                        sb = sb5.toString();
                    } else {
                        StringBuilder sb6 = new StringBuilder();
                        d.g e13 = e.d.e();
                        if (e13 != null && (cVar = e13.f١٣٤٩٨b) != null) {
                            charSequence = cVar.a(e.d.f١٣٧٢١d);
                            if (TextUtils.isEmpty(charSequence)) {
                                charSequence = this.f١٧٥٤٨e.getText(R.string.fsm_mgp_loading_tip_fail).toString();
                            }
                        } else {
                            charSequence = this.f١٧٥٤٨e.getText(R.string.fsm_mgp_loading_tip_fail).toString();
                        }
                        sb6.append(charSequence);
                        sb6.append(str);
                        sb = sb6.toString();
                    }
                    this.f١٧٥٥٥l.setText(sb);
                    if (z10) {
                        this.f١٧٥٥٥l.setTextColor(this.f١٧٥٤٨e.getResources().getColor(R.color.fsm_mgp_loading_tip_fail));
                    }
                    layoutParams = this.f١٧٥٥٣j.getLayoutParams();
                    if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).setMarginStart(i14);
                        this.f١٧٥٥٣j.setLayoutParams(layoutParams);
                        return;
                    }
                    return;
                }
            }
            str = " (" + i11 + "%) " + i10;
            if (-10100 != i10) {
            }
            this.f١٧٥٥٥l.setText(sb);
            if (z10) {
            }
            layoutParams = this.f١٧٥٥٣j.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            }
        }
    }

    public final void d(long j10, long j11, int i10, int i11) {
        int i12 = (int) ((i10 * j10) / j11);
        if (i12 < 0) {
            i12 = 0;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.f١٧٥٥٢i.setProgress(this.f١٧٥٤٦c + i12, true);
        } else {
            this.f١٧٥٥٢i.setProgress(this.f١٧٥٤٦c + i12);
        }
        this.f١٧٥٨٥a.f١٧٠٧٨a.b(2, 0, this.f١٧٥٤٦c + i12, false);
        g();
        a();
        c(0, false, this.f١٧٥٤٦c + i12, false);
        if (j10 == j11) {
            this.f١٧٥٤٦c = i11;
        }
    }

    public final void e(View view) {
        q0.e eVar = this.f١٧٥٨٥a;
        eVar.getClass();
        LogUtils.file("ProxySudFSTAPPImpl", "onLoadingRetry");
        SudLogger.d(q0.c.F, "onLoadingRetry");
        eVar.f١٧٠٧٨a.f١٧٠٧٣w.h();
        eVar.f١٧٠٧٨a.a();
        q0.c cVar = eVar.f١٧٠٧٨a;
        cVar.c(cVar.f١٧٠٥٧g);
        this.f١٧٥٥٠g.setVisibility(4);
    }

    public final void f(String str) {
        e0.a aVar;
        int i10;
        if (this.f١٧٥٦٣t && !this.f١٧٥٦٢s && !TextUtils.isEmpty(str)) {
            Context context = this.f١٧٥٤٨e;
            if (e0.b.f١٣٧٣٤j == null) {
                synchronized (e0.b.class) {
                    try {
                        if (e0.b.f١٣٧٣٤j == null) {
                            if (context != null) {
                                Context applicationContext = context.getApplicationContext();
                                if (applicationContext != null) {
                                    Context applicationContext2 = applicationContext.getApplicationContext();
                                    g0 g0Var = new g0(applicationContext2);
                                    e0.r rVar = new e0.r(applicationContext2);
                                    e0.q qVar = new e0.q();
                                    p0 p0Var = new p0(rVar);
                                    e0.b.f١٣٧٣٤j = new e0.b(applicationContext2, new e0.c(applicationContext2, qVar, e0.b.f١٣٧٣٣i, g0Var, rVar, p0Var), rVar, p0Var);
                                } else {
                                    throw new IllegalArgumentException("Context must not be null.");
                                }
                            } else {
                                throw new IllegalStateException("context == null");
                            }
                        }
                    } finally {
                    }
                }
            }
            e0.b bVar = e0.b.f١٣٧٣٤j;
            bVar.getClass();
            if (str == null) {
                aVar = new e0.a(bVar, null);
            } else if (str.trim().length() != 0) {
                aVar = new e0.a(bVar, Uri.parse(str));
            } else {
                throw new IllegalArgumentException("Path must not be empty.");
            }
            int i11 = aVar.f١٣٧٣١c | 1;
            aVar.f١٣٧٣١c = i11;
            int i12 = new int[]{2}[0];
            if (i12 != 0) {
                if (i12 != 1) {
                    if (i12 == 2) {
                        i10 = 2;
                    } else {
                        throw null;
                    }
                } else {
                    i10 = 1;
                }
                aVar.f١٣٧٣١c = i10 | i11;
                ImageView imageView = this.f١٧٥٥١h;
                System.nanoTime();
                u0.d();
                if (imageView != null) {
                    if (aVar.f١٣٧٣٠b.f١٣٧٨١a == null) {
                        aVar.f١٣٧٢٩a.b(imageView);
                        e0.k.a(imageView);
                        return;
                    }
                    e0.a.f١٣٧٢٨d.getAndIncrement();
                    d0 d0Var = aVar.f١٣٧٣٠b;
                    if (d0Var.f١٣٧٨٢b == 0) {
                        d0Var.f١٣٧٨٢b = 2;
                    }
                    Uri uri = d0Var.f١٣٧٨١a;
                    e0 e0Var = new e0(uri, d0Var.f١٣٧٨٢b);
                    StringBuilder sb = u0.f١٣٨٣٥a;
                    if (uri != null) {
                        String uri2 = uri.toString();
                        sb.ensureCapacity(uri2.length() + 50);
                        sb.append(uri2);
                    } else {
                        sb.ensureCapacity(50);
                        sb.append(0);
                    }
                    sb.append('\n');
                    String sb2 = sb.toString();
                    sb.setLength(0);
                    if ((aVar.f١٣٧٣١c & 1) == 0) {
                        e0.b bVar2 = aVar.f١٣٧٢٩a;
                        Bitmap b10 = bVar2.f١٣٧٣٨d.b(sb2);
                        if (b10 != null) {
                            bVar2.f١٣٧٣٩e.f١٣٨٠٩b.sendEmptyMessage(0);
                        } else {
                            bVar2.f١٣٧٣٩e.f١٣٨٠٩b.sendEmptyMessage(1);
                        }
                        if (b10 != null) {
                            aVar.f١٣٧٢٩a.b(imageView);
                            e0.k.b(imageView, aVar.f١٣٧٢٩a.f١٣٧٣٦b, b10, 1);
                            return;
                        }
                    }
                    e0.k.a(imageView);
                    e0.h hVar = new e0.h(aVar.f١٣٧٢٩a, imageView, e0Var, aVar.f١٣٧٣١c, sb2);
                    e0.b bVar3 = aVar.f١٣٧٢٩a;
                    Object b11 = hVar.b();
                    if (b11 != null && bVar3.f١٣٧٤٠f.get(b11) != hVar) {
                        bVar3.b(b11);
                        bVar3.f١٣٧٤٠f.put(b11, hVar);
                    }
                    a0 a0Var = bVar3.f١٣٧٣٧c.f١٣٧٥٢h;
                    a0Var.sendMessage(a0Var.obtainMessage(1, hVar));
                    return;
                }
                throw new IllegalArgumentException("Target must not be null.");
            }
            throw new IllegalArgumentException("Memory policy cannot be null.");
        }
    }

    public final void g() {
        ValueAnimator valueAnimator = this.f١٧٥٦٤u;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f١٧٥٦٤u = null;
        }
    }

    public final void h() {
        g();
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 80);
        this.f١٧٥٦٤u = ofInt;
        ofInt.setDuration(1000L);
        this.f١٧٥٦٤u.setInterpolator(new LinearInterpolator());
        this.f١٧٥٦٤u.addUpdateListener(new b(this));
        this.f١٧٥٦٤u.start();
    }
}
