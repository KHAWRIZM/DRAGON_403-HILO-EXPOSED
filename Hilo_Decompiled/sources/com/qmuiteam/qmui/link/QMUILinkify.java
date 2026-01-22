package com.qmuiteam.qmui.link;

import android.R;
import android.content.res.ColorStateList;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.style.URLSpan;
import android.util.Patterns;
import android.view.View;
import android.webkit.WebView;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.oudi.utils.date.DateFormat;
import com.qiahao.base_common.network.interceptors.HeaderInterceptor;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class QMUILinkify {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f١٢٧٢٩a = Pattern.compile("\\+?(\\d{2,8}([- ]?\\d{3,8}){2,6}|\\d{5,20})");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f١٢٧٣٠b = Pattern.compile("^\\d+(\\.\\d+)+(-\\d+)*$");

    /* renamed from: c, reason: collision with root package name */
    public static final j f١٢٧٣١c = new a();

    /* renamed from: d, reason: collision with root package name */
    private static j f١٢٧٣٢d = new b();

    /* renamed from: e, reason: collision with root package name */
    public static final h f١٢٧٣٣e = new c();

    /* renamed from: f, reason: collision with root package name */
    public static final h f١٢٧٣٤f = new d();

    /* renamed from: g, reason: collision with root package name */
    public static final i f١٢٧٣٥g = new e();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    private static abstract class StyleableURLSpan extends URLSpan implements com.qmuiteam.qmui.link.a {

        /* renamed from: a, reason: collision with root package name */
        protected boolean f١٢٧٣٨a;

        /* renamed from: b, reason: collision with root package name */
        protected String f١٢٧٣٩b;

        /* renamed from: c, reason: collision with root package name */
        protected hc.a f١٢٧٤٠c;

        public StyleableURLSpan(String str, hc.a aVar) {
            super(str);
            this.f١٢٧٣٨a = false;
            this.f١٢٧٣٩b = str;
            this.f١٢٧٤٠c = aVar;
        }

        @Override // com.qmuiteam.qmui.link.a
        public void a(boolean z10) {
            this.f١٢٧٣٨a = z10;
        }

        @Override // android.text.style.URLSpan, android.text.style.ClickableSpan, com.qmuiteam.qmui.link.a
        public void onClick(View view) {
            if (this.f١٢٧٤٠c.a(this.f١٢٧٣٩b)) {
                return;
            }
            super.onClick(view);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class a implements j {
        a() {
        }

        @Override // com.qmuiteam.qmui.link.QMUILinkify.j
        public Pattern a() {
            return k.f١٢٧٤٥b;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class b implements j {
        b() {
        }

        @Override // com.qmuiteam.qmui.link.QMUILinkify.j
        public Pattern a() {
            return Patterns.WEB_URL;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class c implements h {
        c() {
        }

        @Override // com.qmuiteam.qmui.link.QMUILinkify.h
        public final boolean a(CharSequence charSequence, int i10, int i11) {
            for (int i12 = i10; i12 < i11; i12++) {
                try {
                    if (charSequence.charAt(i12) > 256) {
                        return false;
                    }
                } catch (Exception unused) {
                }
            }
            try {
                char charAt = charSequence.charAt(i11);
                if (charAt < 256 && "[$]".indexOf(charAt) < 0) {
                    if (!Character.isWhitespace(charAt)) {
                        return false;
                    }
                }
            } catch (Exception unused2) {
            }
            if (i10 == 0) {
                return true;
            }
            if (charSequence.charAt(i10 - 1) == '@') {
                return false;
            }
            return true;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class d implements h {
        d() {
        }

        @Override // com.qmuiteam.qmui.link.QMUILinkify.h
        public final boolean a(CharSequence charSequence, int i10, int i11) {
            int i12 = 0;
            while (i10 < i11) {
                if (Character.isDigit(charSequence.charAt(i10)) && (i12 = i12 + 1) >= 7) {
                    return true;
                }
                i10++;
            }
            return false;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class e implements i {
        e() {
        }

        @Override // com.qmuiteam.qmui.link.QMUILinkify.i
        public final String a(Matcher matcher, String str) {
            return Patterns.digitsAndPlusOnly(matcher);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class f implements Comparator {
        f() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final int compare(g gVar, g gVar2) {
            int i10;
            int i11;
            int i12 = gVar.f١٢٧٤٢b;
            int i13 = gVar2.f١٢٧٤٢b;
            if (i12 < i13) {
                return -1;
            }
            if (i12 > i13 || (i10 = gVar.f١٢٧٤٣c) < (i11 = gVar2.f١٢٧٤٣c)) {
                return 1;
            }
            if (i10 > i11) {
                return -1;
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        String f١٢٧٤١a;

        /* renamed from: b, reason: collision with root package name */
        int f١٢٧٤٢b;

        /* renamed from: c, reason: collision with root package name */
        int f١٢٧٤٣c;

        private g() {
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface h {
        boolean a(CharSequence charSequence, int i10, int i11);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface i {
        String a(Matcher matcher, String str);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface j {
        Pattern a();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    private static class k {

        /* renamed from: a, reason: collision with root package name */
        private static final String[] f١٢٧٤٤a = {ViewHierarchyConstants.DIMENSION_TOP_KEY, "com", "net", "org", "edu", "gov", "int", "mil", "tel", HeaderInterceptor.KEY, "cc", "tv", "info", "zw", "name", "hk", "mobi", "asia", "cd", "travel", "pro", "museum", "coop", "aero", "ad", "ae", "af", "ag", "ai", "al", "am", "an", "ao", "aq", "ar", "as", DynamicLink.ItunesConnectAnalyticsParameters.KEY_ITUNES_CONNECT_AT, "au", "aw", "az", "ba", "bb", "bd", "be", "bf", "bg", "bh", "bi", "bj", "bm", "bn", "bo", "br", "bs", "bt", "bv", "bw", "by", "bz", "ca", "cc", "cf", "cg", "ch", "ci", "ck", "cl", "cm", "cn", "co", "cq", "cr", "cu", DispatchConstants.CONFIG_VERSION, "cx", "cy", "cz", "de", "dj", "dk", "dm", "do", "dz", "ec", "ee", "eg", "eh", "es", "et", "ev", "fi", "fj", "fk", "fm", "fo", "fr", "ga", "gb", "gd", UserDataStore.GENDER, "gf", "gh", "gi", "gl", "gm", "gn", "gp", "gr", "gt", "gu", "gw", "gy", "hk", "hm", "hn", "hr", "ht", "hu", "id", "ie", "il", "in", "io", "iq", "ir", "is", "it", "jm", "jo", "jp", "ke", "kg", "kh", "ki", "km", "kn", "kp", "kr", "kw", "ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv", "ly", "ma", "mc", "md", "mg", "mh", "ml", DateFormat.MINUTE, "mn", "mo", "mp", "mq", "mr", "ms", "mt", "mv", "mw", "mx", "my", "mz", "na", "nc", "ne", "nf", "ng", "ni", "nl", "no", "np", "nr", "nt", "nu", "nz", "om", "qa", "pa", "pe", "pf", "pg", UserDataStore.PHONE, "pk", "pl", "pm", "pn", "pr", DynamicLink.ItunesConnectAnalyticsParameters.KEY_ITUNES_CONNECT_PT, "pw", "py", "re", "ro", "ru", "rw", "sa", "sb", "sc", DynamicLink.SocialMetaTagParameters.KEY_SOCIAL_DESCRIPTION, "se", "sg", "sh", DynamicLink.SocialMetaTagParameters.KEY_SOCIAL_IMAGE_LINK, "sj", "sk", "sl", "sm", "sn", "so", "sr", "st", "su", "sy", "sz", "tc", "td", "tf", "tg", "th", "tj", "tk", "tm", "tn", "to", "tp", "tr", "tt", "tv", "tw", "tz", "ua", "ug", "uk", "us", "uy", "va", "vc", "ve", "vg", "vn", "vu", "wf", "ws", "ye", "yu", "za", "zm", "zr"};

        /* renamed from: b, reason: collision with root package name */
        private static Pattern f١٢٧٤٥b;

        static {
            int i10 = 0;
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            while (true) {
                String[] strArr = f١٢٧٤٤a;
                if (i10 < strArr.length) {
                    if (i10 != 0) {
                        sb.append("|");
                    }
                    sb.append(strArr[i10]);
                    i10++;
                } else {
                    sb.append(")");
                    f١٢٧٤٥b = Pattern.compile("(((?i:http|https|rtsp)://)?(((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))|" + ("((?:(www\\.|[a-zA-Z\\.\\-]+\\.)?[a-zA-Z0-9\\-]+)\\." + sb.toString() + ")") + ")(\\:\\d{1,5})?([/\\?](?:(?:[a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]];/\\?:@&=#~\\-\\.\\+!\\*'\\(\\),_\\$])|(?:%[a-fA-F0-9]{2}))*)?)");
                    return;
                }
            }
        }
    }

    public static boolean a(Spannable spannable, int i10, ColorStateList colorStateList, ColorStateList colorStateList2, hc.a aVar) {
        if (i10 == 0) {
            return false;
        }
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (int length = uRLSpanArr.length - 1; length >= 0; length--) {
            spannable.removeSpan(uRLSpanArr[length]);
        }
        ArrayList arrayList = new ArrayList();
        if ((i10 & 1) != 0) {
            c(arrayList, spannable, f١٢٧٣٢d.a(), new String[]{"http://", "https://", "rtsp://"}, f١٢٧٣٣e, null);
        }
        if ((i10 & 2) != 0) {
            c(arrayList, spannable, Patterns.EMAIL_ADDRESS, new String[]{"mailto:"}, null, null);
        }
        if ((i10 & 4) != 0) {
            e(arrayList, spannable, f١٢٧٢٩a, new Pattern[]{f١٢٧٣٠b}, new String[]{"tel:"}, f١٢٧٣٤f, f١٢٧٣٥g);
        }
        if ((i10 & 8) != 0) {
            d(arrayList, spannable);
        }
        i(arrayList);
        if (arrayList.size() == 0) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            g gVar = (g) it.next();
            b(gVar.f١٢٧٤١a, gVar.f١٢٧٤٢b, gVar.f١٢٧٤٣c, spannable, colorStateList, colorStateList2, aVar);
        }
        return true;
    }

    private static void b(String str, int i10, int i11, Spannable spannable, final ColorStateList colorStateList, final ColorStateList colorStateList2, hc.a aVar) {
        spannable.setSpan(new StyleableURLSpan(str, aVar) { // from class: com.qmuiteam.qmui.link.QMUILinkify.6
            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                ColorStateList colorStateList3 = colorStateList;
                if (colorStateList3 != null) {
                    int colorForState = colorStateList3.getColorForState(new int[]{R.attr.state_enabled, -16842919}, 0);
                    int colorForState2 = colorStateList.getColorForState(new int[]{R.attr.state_pressed}, colorForState);
                    if (this.f١٢٧٣٨a) {
                        colorForState = colorForState2;
                    }
                    textPaint.linkColor = colorForState;
                }
                ColorStateList colorStateList4 = colorStateList2;
                if (colorStateList4 != null) {
                    int colorForState3 = colorStateList4.getColorForState(new int[]{R.attr.state_enabled, -16842919}, 0);
                    int colorForState4 = colorStateList2.getColorForState(new int[]{R.attr.state_pressed}, colorForState3);
                    if (this.f١٢٧٣٨a) {
                        colorForState3 = colorForState4;
                    }
                    textPaint.bgColor = colorForState3;
                }
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(false);
            }
        }, i10, i11, 33);
    }

    private static void c(ArrayList arrayList, Spannable spannable, Pattern pattern, String[] strArr, h hVar, i iVar) {
        Matcher matcher = pattern.matcher(spannable);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (hVar == null || hVar.a(spannable, start, end)) {
                g gVar = new g();
                gVar.f١٢٧٤١a = h(matcher.group(0), strArr, matcher, iVar);
                gVar.f١٢٧٤٢b = start;
                gVar.f١٢٧٤٣c = end;
                arrayList.add(gVar);
            }
        }
    }

    private static void d(ArrayList arrayList, Spannable spannable) {
        int indexOf;
        String obj = spannable.toString();
        int i10 = 0;
        while (true) {
            try {
                String findAddress = WebView.findAddress(obj);
                if (findAddress != null && (indexOf = obj.indexOf(findAddress)) >= 0) {
                    g gVar = new g();
                    int length = findAddress.length() + indexOf;
                    gVar.f١٢٧٤٢b = indexOf + i10;
                    i10 += length;
                    gVar.f١٢٧٤٣c = i10;
                    obj = obj.substring(length);
                    try {
                        gVar.f١٢٧٤١a = "geo:0,0?q=" + URLEncoder.encode(findAddress, "UTF-8");
                        arrayList.add(gVar);
                    } catch (UnsupportedEncodingException unused) {
                    }
                }
                return;
            } catch (UnsupportedOperationException unused2) {
                return;
            }
        }
    }

    private static void e(ArrayList arrayList, Spannable spannable, Pattern pattern, Pattern[] patternArr, String[] strArr, h hVar, i iVar) {
        Matcher matcher = pattern.matcher(spannable);
        while (matcher.find()) {
            if (!f(matcher.group(), patternArr)) {
                int start = matcher.start();
                int end = matcher.end();
                if (hVar == null || hVar.a(spannable, start, end)) {
                    g gVar = new g();
                    gVar.f١٢٧٤١a = h(matcher.group(0), strArr, matcher, iVar);
                    gVar.f١٢٧٤٢b = start;
                    gVar.f١٢٧٤٣c = end;
                    arrayList.add(gVar);
                }
            }
        }
    }

    private static boolean f(CharSequence charSequence, Pattern[] patternArr) {
        for (Pattern pattern : patternArr) {
            if (pattern.matcher(charSequence).find()) {
                return true;
            }
        }
        return g(charSequence);
    }

    private static boolean g(CharSequence charSequence) {
        if (charSequence.length() <= 21) {
            return false;
        }
        int length = charSequence.length();
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            if (Character.isDigit(charSequence.charAt(i11)) && (i10 = i10 + 1) > 21) {
                return true;
            }
        }
        return false;
    }

    private static String h(String str, String[] strArr, Matcher matcher, i iVar) {
        boolean z10;
        if (iVar != null) {
            str = iVar.a(matcher, str);
        }
        int length = strArr.length;
        int i10 = 0;
        while (true) {
            if (i10 < length) {
                String str2 = strArr[i10];
                if (str.regionMatches(true, 0, str2, 0, str2.length())) {
                    z10 = true;
                    if (!str.regionMatches(false, 0, str2, 0, str2.length())) {
                        str = str2 + str.substring(str2.length());
                    }
                } else {
                    i10++;
                }
            } else {
                z10 = false;
                break;
            }
        }
        if (!z10) {
            return strArr[0] + str;
        }
        return str;
    }

    private static void i(ArrayList arrayList) {
        int i10;
        int i11;
        Collections.sort(arrayList, new f());
        int size = arrayList.size();
        int i12 = 0;
        while (i12 < size - 1) {
            g gVar = (g) arrayList.get(i12);
            int i13 = i12 + 1;
            g gVar2 = (g) arrayList.get(i13);
            int i14 = gVar.f١٢٧٤٢b;
            int i15 = gVar2.f١٢٧٤٢b;
            if (i14 <= i15 && (i10 = gVar.f١٢٧٤٣c) > i15) {
                int i16 = gVar2.f١٢٧٤٣c;
                if (i16 <= i10 || i10 - i14 > i16 - i15) {
                    i11 = i13;
                } else if (i10 - i14 < i16 - i15) {
                    i11 = i12;
                } else {
                    i11 = -1;
                }
                if (i11 != -1) {
                    arrayList.remove(i11);
                    size--;
                }
            }
            i12 = i13;
        }
    }
}
