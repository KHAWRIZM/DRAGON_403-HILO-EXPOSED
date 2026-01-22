package y0;

import android.text.TextUtils;
import android.widget.TextView;
import tech.sud.gip.R;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f١٩٠٧٧a;

    public f(a aVar) {
        this.f١٩٠٧٧a = aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x009f A[Catch: all -> 0x0036, TryCatch #0 {all -> 0x0036, blocks: (B:4:0x0003, B:10:0x0009, B:12:0x0016, B:14:0x001a, B:16:0x0028, B:18:0x002e, B:21:0x003d, B:24:0x0045, B:26:0x0059, B:29:0x005e, B:31:0x006a, B:32:0x0083, B:34:0x008e, B:37:0x0093, B:39:0x009f, B:40:0x00b8, B:42:0x00c3, B:45:0x00c8, B:47:0x00d4, B:49:0x00ef, B:50:0x00f2, B:52:0x00e2, B:53:0x00ac, B:54:0x0077, B:55:0x00f4, B:58:0x0105, B:60:0x00fc, B:61:0x0109, B:62:0x010c), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c3 A[Catch: all -> 0x0036, TryCatch #0 {all -> 0x0036, blocks: (B:4:0x0003, B:10:0x0009, B:12:0x0016, B:14:0x001a, B:16:0x0028, B:18:0x002e, B:21:0x003d, B:24:0x0045, B:26:0x0059, B:29:0x005e, B:31:0x006a, B:32:0x0083, B:34:0x008e, B:37:0x0093, B:39:0x009f, B:40:0x00b8, B:42:0x00c3, B:45:0x00c8, B:47:0x00d4, B:49:0x00ef, B:50:0x00f2, B:52:0x00e2, B:53:0x00ac, B:54:0x0077, B:55:0x00f4, B:58:0x0105, B:60:0x00fc, B:61:0x0109, B:62:0x010c), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d4 A[Catch: all -> 0x0036, TryCatch #0 {all -> 0x0036, blocks: (B:4:0x0003, B:10:0x0009, B:12:0x0016, B:14:0x001a, B:16:0x0028, B:18:0x002e, B:21:0x003d, B:24:0x0045, B:26:0x0059, B:29:0x005e, B:31:0x006a, B:32:0x0083, B:34:0x008e, B:37:0x0093, B:39:0x009f, B:40:0x00b8, B:42:0x00c3, B:45:0x00c8, B:47:0x00d4, B:49:0x00ef, B:50:0x00f2, B:52:0x00e2, B:53:0x00ac, B:54:0x0077, B:55:0x00f4, B:58:0x0105, B:60:0x00fc, B:61:0x0109, B:62:0x010c), top: B:3:0x0003 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        String charSequence;
        d.g e10;
        String charSequence2;
        d.g e11;
        String charSequence3;
        String str;
        e.c cVar;
        e.c cVar2;
        e.c cVar3;
        a aVar = this.f١٩٠٧٧a;
        synchronized (aVar) {
            try {
                if (aVar.f١٩٠٥٢e) {
                    long j10 = aVar.f١٩٠٤٩b - aVar.f١٩٠٥٣f;
                    aVar.f١٩٠٤٩b = j10;
                    if (j10 <= 0) {
                        g gVar = aVar.f١٩٠٥٠c;
                        if (gVar != null) {
                            q0.c cVar4 = (q0.c) gVar;
                            LogUtils.file("ProxySudFSTAPPImpl", "onLoadGameTimeout:");
                            s0.e eVar = cVar4.f١٧٠٦٦p;
                            if (eVar != null) {
                                int i10 = eVar.f١٧٥٤٧d;
                                if (cVar4.f١٧٠٦٢l) {
                                    cVar4.f١٧٠٦٢l = false;
                                    cVar4.f١٧٠٧٣w.b(i10);
                                }
                                if (i10 >= 80) {
                                    s0.e eVar2 = cVar4.f١٧٠٦٦p;
                                    if (!eVar2.f١٧٥٦٢s) {
                                        eVar2.f١٧٥٥٤k.setText("");
                                        eVar2.f١٧٥٥٨o.setVisibility(0);
                                        TextView textView = eVar2.f١٧٥٥٩p;
                                        d.g e12 = e.d.e();
                                        if (e12 != null && (cVar3 = e12.f١٣٥٠١e) != null) {
                                            charSequence = cVar3.a(e.d.f١٣٧٢١d);
                                            if (TextUtils.isEmpty(charSequence)) {
                                                charSequence = eVar2.f١٧٥٤٨e.getText(R.string.fsm_mgp_continue_wait_tip).toString();
                                            }
                                            textView.setText(charSequence);
                                            TextView textView2 = eVar2.f١٧٥٦٠q;
                                            e10 = e.d.e();
                                            if (e10 != null && (cVar2 = e10.f١٣٥٠٢f) != null) {
                                                charSequence2 = cVar2.a(e.d.f١٣٧٢١d);
                                                if (TextUtils.isEmpty(charSequence2)) {
                                                    charSequence2 = eVar2.f١٧٥٤٨e.getText(R.string.fsm_mgp_continue_wait).toString();
                                                }
                                                textView2.setText(charSequence2);
                                                TextView textView3 = eVar2.f١٧٥٦١r;
                                                e11 = e.d.e();
                                                if (e11 != null && (cVar = e11.f١٣٥٠٠d) != null) {
                                                    str = cVar.a(e.d.f١٣٧٢١d);
                                                    if (TextUtils.isEmpty(str)) {
                                                        charSequence3 = eVar2.f١٧٥٤٨e.getText(R.string.fsm_mgp_loading_reload_game).toString();
                                                        str = charSequence3;
                                                    }
                                                    textView3.setText(str);
                                                    return;
                                                }
                                                charSequence3 = eVar2.f١٧٥٤٨e.getText(R.string.fsm_mgp_loading_reload_game).toString();
                                                str = charSequence3;
                                                textView3.setText(str);
                                                return;
                                            }
                                            charSequence2 = eVar2.f١٧٥٤٨e.getText(R.string.fsm_mgp_continue_wait).toString();
                                            textView2.setText(charSequence2);
                                            TextView textView32 = eVar2.f١٧٥٦١r;
                                            e11 = e.d.e();
                                            if (e11 != null) {
                                                str = cVar.a(e.d.f١٣٧٢١d);
                                                if (TextUtils.isEmpty(str)) {
                                                }
                                                textView32.setText(str);
                                                return;
                                            }
                                            charSequence3 = eVar2.f١٧٥٤٨e.getText(R.string.fsm_mgp_loading_reload_game).toString();
                                            str = charSequence3;
                                            textView32.setText(str);
                                            return;
                                        }
                                        charSequence = eVar2.f١٧٥٤٨e.getText(R.string.fsm_mgp_continue_wait_tip).toString();
                                        textView.setText(charSequence);
                                        TextView textView22 = eVar2.f١٧٥٦٠q;
                                        e10 = e.d.e();
                                        if (e10 != null) {
                                            charSequence2 = cVar2.a(e.d.f١٣٧٢١d);
                                            if (TextUtils.isEmpty(charSequence2)) {
                                            }
                                            textView22.setText(charSequence2);
                                            TextView textView322 = eVar2.f١٧٥٦١r;
                                            e11 = e.d.e();
                                            if (e11 != null) {
                                            }
                                            charSequence3 = eVar2.f١٧٥٤٨e.getText(R.string.fsm_mgp_loading_reload_game).toString();
                                            str = charSequence3;
                                            textView322.setText(str);
                                            return;
                                        }
                                        charSequence2 = eVar2.f١٧٥٤٨e.getText(R.string.fsm_mgp_continue_wait).toString();
                                        textView22.setText(charSequence2);
                                        TextView textView3222 = eVar2.f١٧٥٦١r;
                                        e11 = e.d.e();
                                        if (e11 != null) {
                                        }
                                        charSequence3 = eVar2.f١٧٥٤٨e.getText(R.string.fsm_mgp_loading_reload_game).toString();
                                        str = charSequence3;
                                        textView3222.setText(str);
                                        return;
                                    }
                                }
                            }
                            cVar4.a();
                            if (!cVar4.f١٧٠٦٠j) {
                                cVar4.f١٧٠٦٠j = true;
                                cVar4.b(3, 0, 100, true);
                            }
                        }
                    } else {
                        aVar.a();
                    }
                }
            } finally {
            }
        }
    }
}
