package tech.sud.runtime.component.d;

import java.util.HashMap;
import java.util.Map;
import org.android.agoo.message.MessageService;
import org.json.JSONArray;
import tech.sud.runtime.a.a;
import tech.sud.runtime.component.h.f;
import tech.sud.runtime.core.g;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class a {
    private final Map<String, a.InterfaceC٠٠٥٦a> a = new HashMap();
    private final g b;

    public a(g gVar) {
        this.b = gVar;
    }

    public void a(String str, String str2) {
        if (str.equals("@onState") && this.a.containsKey("@sudGameStarted") && str2.contains("\"state\":\"running\"")) {
            a("@sudGameStarted", MessageService.MSG_DB_NOTIFY_REACHED);
        }
        if (!this.a.containsKey(str)) {
            f.d("SudNative", "J: " + str + " not found");
            return;
        }
        if (this.a.containsKey("@interfaceCounter2")) {
            this.a.get("@interfaceCounter2").a(new JSONArray().put(str).put(str2).toString());
        } else if (this.a.containsKey("@interfaceCounter")) {
            this.a.get("@interfaceCounter").a(str);
        }
        try {
            this.a.get(str).a(str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b(String str, String str2) {
        this.b.a(1, new JSONArray().put(str).put(str2).toString());
    }

    public boolean a(String str) {
        return this.a.containsKey(str);
    }

    public void a(String str, a.InterfaceC٠٠٥٦a r4) {
        if (this.a.containsKey(str)) {
            f.d("SudNative", "J: " + str + " has been registered");
        }
        this.a.put(str, r4);
    }

    public void a() {
        this.a.clear();
    }
}
