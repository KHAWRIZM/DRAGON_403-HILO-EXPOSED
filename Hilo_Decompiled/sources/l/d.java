package l;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class d extends c {
    @Override // j.t
    public final void a() {
        this.f١٥٠٣٩b.getClass();
        g();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0059, code lost:
    
        if (r7.equals(com.facebook.appevents.internal.ViewHierarchyConstants.DIMENSION_LEFT_KEY) == false) goto L٢١;
     */
    @Override // j.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean c(String str, JSONObject jSONObject) {
        char c10;
        char c11 = 2;
        str.getClass();
        switch (str.hashCode()) {
            case 3202370:
                if (str.equals("hide")) {
                    c10 = 0;
                    break;
                }
                c10 = 65535;
                break;
            case 3529469:
                if (str.equals("show")) {
                    c10 = 1;
                    break;
                }
                c10 = 65535;
                break;
            case 109780401:
                if (str.equals("style")) {
                    c10 = 2;
                    break;
                }
                c10 = 65535;
                break;
            default:
                c10 = 65535;
                break;
        }
        switch (c10) {
            case 2:
                String optString = jSONObject.optString("prop");
                optString.getClass();
                switch (optString.hashCode()) {
                    case -1221029593:
                        if (optString.equals(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY)) {
                            c11 = 0;
                            break;
                        }
                        c11 = 65535;
                        break;
                    case 115029:
                        if (optString.equals(ViewHierarchyConstants.DIMENSION_TOP_KEY)) {
                            c11 = 1;
                            break;
                        }
                        c11 = 65535;
                        break;
                    case 3317767:
                        break;
                    case 113126854:
                        if (optString.equals(ViewHierarchyConstants.DIMENSION_WIDTH_KEY)) {
                            c11 = 3;
                            break;
                        }
                        c11 = 65535;
                        break;
                    default:
                        c11 = 65535;
                        break;
                }
                switch (c11) {
                    case 0:
                        jSONObject.optInt("value");
                    case 1:
                        jSONObject.optInt("value");
                    case 2:
                        jSONObject.optInt("value");
                    case 3:
                        jSONObject.optInt("value");
                }
            case 0:
            case 1:
                return true;
            default:
                return false;
        }
    }

    @Override // j.t
    public final void d() {
    }
}
