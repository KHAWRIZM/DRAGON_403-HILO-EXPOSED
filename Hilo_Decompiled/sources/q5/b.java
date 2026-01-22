package q5;

import x5.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class b implements a {
    private static String a(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 10);
        String[] split = str.split(c.f١٨٩٣٠a);
        int length = split.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 != 0) {
                sb.append(c.f١٨٩٣٠a);
            }
            String str2 = split[i10];
            sb.append((char) 9553);
            sb.append(str2);
        }
        return sb.toString();
    }

    @Override // p5.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String format(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        String[] strArr2 = new String[strArr.length];
        int i10 = 0;
        for (String str : strArr) {
            if (str != null) {
                strArr2[i10] = str;
                i10++;
            }
        }
        if (i10 == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("╔═══════════════════════════════════════════════════════════════════════════════════════════════════");
        sb.append(c.f١٨٩٣٠a);
        for (int i11 = 0; i11 < i10; i11++) {
            sb.append(a(strArr2[i11]));
            if (i11 != i10 - 1) {
                sb.append(c.f١٨٩٣٠a);
                sb.append("╟───────────────────────────────────────────────────────────────────────────────────────────────────");
                sb.append(c.f١٨٩٣٠a);
            } else {
                sb.append(c.f١٨٩٣٠a);
                sb.append("╚═══════════════════════════════════════════════════════════════════════════════════════════════════");
            }
        }
        return sb.toString();
    }
}
