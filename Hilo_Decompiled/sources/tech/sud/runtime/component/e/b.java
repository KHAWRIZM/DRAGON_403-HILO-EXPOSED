package tech.sud.runtime.component.e;

import android.widget.FrameLayout;
import org.json.JSONObject;
import tech.sud.runtime.component.e.a;
import tech.sud.runtime.core.g;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class b {
    private final FrameLayout a;
    private a b;
    private a.InterfaceC٠٠٥٨a c;
    private JSONObject d = null;
    private final g e;
    private Integer f;

    public b(FrameLayout frameLayout, g gVar, Integer num) {
        this.a = frameLayout;
        this.e = gVar;
        this.f = num;
    }

    private static int d(String str) {
        str.getClass();
        char c = 65535;
        switch (str.hashCode()) {
            case -906336856:
                if (str.equals("search")) {
                    c = 0;
                    break;
                }
                break;
            case 3304:
                if (str.equals("go")) {
                    c = 1;
                    break;
                }
                break;
            case 3377907:
                if (str.equals("next")) {
                    c = 2;
                    break;
                }
                break;
            case 3526536:
                if (str.equals("send")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return 2;
            case 1:
                return 3;
            case 2:
                return 1;
            case 3:
                return 4;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        this.e.a(9, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str) {
        this.e.a(10, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str) {
        this.e.a(11, str);
    }

    private void c(String str) {
        if (str.length() == 0) {
            this.b.c();
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.b.a(jSONObject.optString("defaultValue"), jSONObject.optInt("maxLength"), jSONObject.optBoolean("multiple"), jSONObject.optBoolean("confirmHold", true), d(jSONObject.optString("confirmType")));
        } catch (Exception e) {
            e.printStackTrace();
            b();
        }
    }

    public void b(String str) {
        a aVar = this.b;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    public void a(String str) {
        if (this.d == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                this.d = jSONObject;
                jSONObject.put("errorMsg", "ok");
            } catch (Exception unused) {
                this.d = null;
                a(-5);
                return;
            }
        }
        if (this.c == null) {
            this.c = new a.InterfaceC٠٠٥٨a() { // from class: tech.sud.runtime.component.e.b.1
                @Override // tech.sud.runtime.component.e.a.InterfaceC٠٠٥٨a
                public void a(String str2) {
                    try {
                        b.this.g(str2);
                    } catch (Exception unused2) {
                    }
                }

                @Override // tech.sud.runtime.component.e.a.InterfaceC٠٠٥٨a
                public void b(String str2) {
                    try {
                        b.this.e(str2);
                    } catch (Exception unused2) {
                    }
                }

                @Override // tech.sud.runtime.component.e.a.InterfaceC٠٠٥٨a
                public void c(String str2) {
                    try {
                        b.this.f(str2);
                    } catch (Exception unused2) {
                    }
                }

                @Override // tech.sud.runtime.component.e.a.InterfaceC٠٠٥٨a
                public void a(int i) {
                    b.this.a(i);
                }
            };
        }
        FrameLayout frameLayout = this.a;
        if (frameLayout == null) {
            a(-1);
            return;
        }
        if (this.b == null) {
            this.b = new a(frameLayout.getContext(), this.c, this.f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 80;
            frameLayout.addView(this.b, layoutParams);
        }
        c(str);
    }

    private void b() {
        a(-2);
    }

    public void a() {
        a aVar = this.b;
        if (aVar != null) {
            this.a.removeView(aVar);
            this.b.a();
            this.b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        this.e.b(8, i);
    }
}
