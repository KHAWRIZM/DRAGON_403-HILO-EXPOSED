package j;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class o extends t {

    /* renamed from: c, reason: collision with root package name */
    public Button f١٥٠١٩c;

    /* renamed from: d, reason: collision with root package name */
    public ImageButton f١٥٠٢٠d;

    /* renamed from: e, reason: collision with root package name */
    public float f١٥٠٢١e;

    /* renamed from: f, reason: collision with root package name */
    public final String f١٥٠٢٢f;

    /* renamed from: g, reason: collision with root package name */
    public String f١٥٠٢٣g;

    /* renamed from: h, reason: collision with root package name */
    public String f١٥٠٢٤h;

    /* renamed from: i, reason: collision with root package name */
    public int f١٥٠٢٥i;

    /* renamed from: j, reason: collision with root package name */
    public int f١٥٠٢٦j;

    /* renamed from: k, reason: collision with root package name */
    public int f١٥٠٢٧k;

    /* renamed from: l, reason: collision with root package name */
    public int f١٥٠٢٨l;

    /* renamed from: m, reason: collision with root package name */
    public String f١٥٠٢٩m;

    /* renamed from: n, reason: collision with root package name */
    public String f١٥٠٣٠n;

    /* renamed from: o, reason: collision with root package name */
    public String f١٥٠٣١o;

    /* renamed from: p, reason: collision with root package name */
    public int f١٥٠٣٢p;

    /* renamed from: q, reason: collision with root package name */
    public int f١٥٠٣٣q;

    /* renamed from: r, reason: collision with root package name */
    public int f١٥٠٣٤r;

    public o(JSONObject jSONObject) {
        this.f١٥٠٢٢f = jSONObject.optString("type");
        this.f١٥٠٢٣g = jSONObject.optString(ViewHierarchyConstants.TEXT_KEY);
        this.f١٥٠٢٤h = jSONObject.optString("image");
        JSONObject optJSONObject = jSONObject.optJSONObject("style");
        if (optJSONObject != null) {
            this.f١٥٠٢٥i = optJSONObject.optInt(ViewHierarchyConstants.DIMENSION_LEFT_KEY);
            this.f١٥٠٢٦j = optJSONObject.optInt(ViewHierarchyConstants.DIMENSION_TOP_KEY);
            this.f١٥٠٢٧k = optJSONObject.optInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
            this.f١٥٠٢٨l = optJSONObject.optInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
            this.f١٥٠٢٩m = optJSONObject.optString("color");
            this.f١٥٠٣٠n = optJSONObject.optString("backgroundColor");
            this.f١٥٠٣١o = optJSONObject.optString("borderColor");
            this.f١٥٠٣٢p = optJSONObject.optInt("borderWidth");
            this.f١٥٠٣٣q = optJSONObject.optInt("borderRadius");
            optJSONObject.optString("textAlign");
            this.f١٥٠٣٤r = optJSONObject.optInt("fontSize");
            optJSONObject.optInt("lineHeight");
        }
    }

    public static int g(String str) {
        if ((str.length() == 7 || str.length() == 9) && str.charAt(0) == '#') {
            return Color.parseColor(str);
        }
        return -16777216;
    }

    @Override // j.t
    public final void a() {
        d dVar = this.f١٥٠٣٩b;
        this.f١٥٠٢١e = dVar.f١٤٩٩٤i;
        FrameLayout frameLayout = dVar.f١٤٩٩٨m;
        if (this.f١٥٠٢٢f.equals("image")) {
            ImageButton imageButton = new ImageButton(this.f١٥٠٣٩b.f١٤٩٨٧b);
            imageButton.setLayoutParams(new FrameLayout.LayoutParams(0, 0));
            imageButton.setOnClickListener(new x(this));
            imageButton.setBackgroundColor(0);
            imageButton.setScaleType(ImageView.ScaleType.FIT_XY);
            this.f١٥٠٢٠d = imageButton;
            String str = this.f١٥٠٢٤h;
            if (str != null && !str.isEmpty()) {
                this.f١٥٠٢٠d.setImageBitmap(BitmapFactory.decodeFile(this.f١٥٠٢٤h));
            }
            frameLayout.addView(imageButton);
        } else {
            Button button = new Button(this.f١٥٠٣٩b.f١٤٩٨٧b);
            button.setLayoutParams(new FrameLayout.LayoutParams(0, 0));
            this.f١٥٠١٩c = button;
            button.setPadding(0, 0, 0, 0);
            button.setMinWidth(0);
            button.setMinHeight(0);
            button.setMinimumHeight(0);
            button.setMinimumWidth(0);
            button.setText(this.f١٥٠٢٣g);
            button.setBackground(new GradientDrawable());
            button.setTextSize(this.f١٥٠٣٤r);
            button.setTextColor(g(this.f١٥٠٢٩m));
            h();
            button.setOnClickListener(new a0(this));
            frameLayout.addView(button);
        }
        Button button2 = this.f١٥٠١٩c;
        if (button2 != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) button2.getLayoutParams();
            float f10 = this.f١٥٠٢٧k;
            float f11 = this.f١٥٠٢١e;
            layoutParams.width = (int) (f10 * f11);
            layoutParams.height = (int) (this.f١٥٠٢٨l * f11);
            layoutParams.leftMargin = (int) (this.f١٥٠٢٥i * f11);
            layoutParams.topMargin = (int) (this.f١٥٠٢٦j * f11);
            button2.setLayoutParams(layoutParams);
        }
        ImageButton imageButton2 = this.f١٥٠٢٠d;
        if (imageButton2 != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) imageButton2.getLayoutParams();
            float f12 = this.f١٥٠٢٧k;
            float f13 = this.f١٥٠٢١e;
            layoutParams2.width = (int) (f12 * f13);
            layoutParams2.height = (int) (this.f١٥٠٢٨l * f13);
            layoutParams2.leftMargin = (int) (this.f١٥٠٢٥i * f13);
            layoutParams2.topMargin = (int) (this.f١٥٠٢٦j * f13);
            imageButton2.setLayoutParams(layoutParams2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00ae, code lost:
    
        if (r10.equals(com.facebook.appevents.internal.ViewHierarchyConstants.DIMENSION_LEFT_KEY) == false) goto L٢٥;
     */
    @Override // j.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean c(String str, JSONObject jSONObject) {
        char c10;
        char c11 = 4;
        str.getClass();
        switch (str.hashCode()) {
            case 3202370:
                if (str.equals("hide")) {
                    c10 = 0;
                    break;
                }
                c10 = 65535;
                break;
            case 3449699:
                if (str.equals("prop")) {
                    c10 = 1;
                    break;
                }
                c10 = 65535;
                break;
            case 3529469:
                if (str.equals("show")) {
                    c10 = 2;
                    break;
                }
                c10 = 65535;
                break;
            case 109780401:
                if (str.equals("style")) {
                    c10 = 3;
                    break;
                }
                c10 = 65535;
                break;
            default:
                c10 = 65535;
                break;
        }
        switch (c10) {
            case 0:
                Button button = this.f١٥٠١٩c;
                if (button != null) {
                    button.setVisibility(4);
                }
                ImageButton imageButton = this.f١٥٠٢٠d;
                if (imageButton != null) {
                    imageButton.setVisibility(4);
                }
                return true;
            case 1:
                String optString = jSONObject.optString("prop");
                String optString2 = jSONObject.optString("value");
                optString.getClass();
                if (!optString.equals(ViewHierarchyConstants.TEXT_KEY)) {
                    if (optString.equals("image")) {
                        this.f١٥٠٢٤h = optString2;
                        if (this.f١٥٠٢٠d != null && optString2 != null && !optString2.isEmpty()) {
                            this.f١٥٠٢٠d.setImageBitmap(BitmapFactory.decodeFile(this.f١٥٠٢٤h));
                        }
                    }
                } else {
                    this.f١٥٠٢٣g = optString2;
                    Button button2 = this.f١٥٠١٩c;
                    if (button2 != null) {
                        button2.setText(optString2);
                    }
                }
                return true;
            case 2:
                Button button3 = this.f١٥٠١٩c;
                if (button3 != null) {
                    button3.setVisibility(0);
                }
                ImageButton imageButton2 = this.f١٥٠٢٠d;
                if (imageButton2 != null) {
                    imageButton2.setVisibility(0);
                }
                return true;
            case 3:
                String optString3 = jSONObject.optString("prop");
                optString3.getClass();
                switch (optString3.hashCode()) {
                    case -1221029593:
                        if (optString3.equals(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY)) {
                            c11 = 0;
                            break;
                        }
                        c11 = 65535;
                        break;
                    case -1065511464:
                        if (optString3.equals("textAlign")) {
                            c11 = 1;
                            break;
                        }
                        c11 = 65535;
                        break;
                    case -515807685:
                        if (optString3.equals("lineHeight")) {
                            c11 = 2;
                            break;
                        }
                        c11 = 65535;
                        break;
                    case 115029:
                        if (optString3.equals(ViewHierarchyConstants.DIMENSION_TOP_KEY)) {
                            c11 = 3;
                            break;
                        }
                        c11 = 65535;
                        break;
                    case 3317767:
                        break;
                    case 94842723:
                        if (optString3.equals("color")) {
                            c11 = 5;
                            break;
                        }
                        c11 = 65535;
                        break;
                    case 113126854:
                        if (optString3.equals(ViewHierarchyConstants.DIMENSION_WIDTH_KEY)) {
                            c11 = 6;
                            break;
                        }
                        c11 = 65535;
                        break;
                    case 365601008:
                        if (optString3.equals("fontSize")) {
                            c11 = 7;
                            break;
                        }
                        c11 = 65535;
                        break;
                    case 722830999:
                        if (optString3.equals("borderColor")) {
                            c11 = '\b';
                            break;
                        }
                        c11 = 65535;
                        break;
                    case 741115130:
                        if (optString3.equals("borderWidth")) {
                            c11 = '\t';
                            break;
                        }
                        c11 = 65535;
                        break;
                    case 1287124693:
                        if (optString3.equals("backgroundColor")) {
                            c11 = '\n';
                            break;
                        }
                        c11 = 65535;
                        break;
                    case 1349188574:
                        if (optString3.equals("borderRadius")) {
                            c11 = 11;
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
                        this.f١٥٠٢٨l = jSONObject.optInt("value");
                        Button button4 = this.f١٥٠١٩c;
                        if (button4 != null) {
                            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) button4.getLayoutParams();
                            float f10 = this.f١٥٠٢٧k;
                            float f11 = this.f١٥٠٢١e;
                            layoutParams.width = (int) (f10 * f11);
                            layoutParams.height = (int) (this.f١٥٠٢٨l * f11);
                            layoutParams.leftMargin = (int) (this.f١٥٠٢٥i * f11);
                            layoutParams.topMargin = (int) (this.f١٥٠٢٦j * f11);
                            button4.setLayoutParams(layoutParams);
                        }
                        ImageButton imageButton3 = this.f١٥٠٢٠d;
                        if (imageButton3 != null) {
                            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) imageButton3.getLayoutParams();
                            float f12 = this.f١٥٠٢٧k;
                            float f13 = this.f١٥٠٢١e;
                            layoutParams2.width = (int) (f12 * f13);
                            layoutParams2.height = (int) (this.f١٥٠٢٨l * f13);
                            layoutParams2.leftMargin = (int) (this.f١٥٠٢٥i * f13);
                            layoutParams2.topMargin = (int) (this.f١٥٠٢٦j * f13);
                            imageButton3.setLayoutParams(layoutParams2);
                            break;
                        }
                        break;
                    case 1:
                        jSONObject.optString("value");
                        break;
                    case 2:
                        jSONObject.optInt("value");
                        break;
                    case 3:
                        this.f١٥٠٢٦j = jSONObject.optInt("value");
                        Button button5 = this.f١٥٠١٩c;
                        if (button5 != null) {
                            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) button5.getLayoutParams();
                            float f14 = this.f١٥٠٢٧k;
                            float f15 = this.f١٥٠٢١e;
                            layoutParams3.width = (int) (f14 * f15);
                            layoutParams3.height = (int) (this.f١٥٠٢٨l * f15);
                            layoutParams3.leftMargin = (int) (this.f١٥٠٢٥i * f15);
                            layoutParams3.topMargin = (int) (this.f١٥٠٢٦j * f15);
                            button5.setLayoutParams(layoutParams3);
                        }
                        ImageButton imageButton4 = this.f١٥٠٢٠d;
                        if (imageButton4 != null) {
                            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) imageButton4.getLayoutParams();
                            float f16 = this.f١٥٠٢٧k;
                            float f17 = this.f١٥٠٢١e;
                            layoutParams4.width = (int) (f16 * f17);
                            layoutParams4.height = (int) (this.f١٥٠٢٨l * f17);
                            layoutParams4.leftMargin = (int) (this.f١٥٠٢٥i * f17);
                            layoutParams4.topMargin = (int) (this.f١٥٠٢٦j * f17);
                            imageButton4.setLayoutParams(layoutParams4);
                            break;
                        }
                        break;
                    case 4:
                        this.f١٥٠٢٥i = jSONObject.optInt("value");
                        Button button6 = this.f١٥٠١٩c;
                        if (button6 != null) {
                            FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) button6.getLayoutParams();
                            float f18 = this.f١٥٠٢٧k;
                            float f19 = this.f١٥٠٢١e;
                            layoutParams5.width = (int) (f18 * f19);
                            layoutParams5.height = (int) (this.f١٥٠٢٨l * f19);
                            layoutParams5.leftMargin = (int) (this.f١٥٠٢٥i * f19);
                            layoutParams5.topMargin = (int) (this.f١٥٠٢٦j * f19);
                            button6.setLayoutParams(layoutParams5);
                        }
                        ImageButton imageButton5 = this.f١٥٠٢٠d;
                        if (imageButton5 != null) {
                            FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) imageButton5.getLayoutParams();
                            float f20 = this.f١٥٠٢٧k;
                            float f21 = this.f١٥٠٢١e;
                            layoutParams6.width = (int) (f20 * f21);
                            layoutParams6.height = (int) (this.f١٥٠٢٨l * f21);
                            layoutParams6.leftMargin = (int) (this.f١٥٠٢٥i * f21);
                            layoutParams6.topMargin = (int) (this.f١٥٠٢٦j * f21);
                            imageButton5.setLayoutParams(layoutParams6);
                            break;
                        }
                        break;
                    case 5:
                        String optString4 = jSONObject.optString("value");
                        this.f١٥٠٢٩m = optString4;
                        Button button7 = this.f١٥٠١٩c;
                        if (button7 != null) {
                            button7.setTextColor(g(optString4));
                            break;
                        }
                        break;
                    case 6:
                        this.f١٥٠٢٧k = jSONObject.optInt("value");
                        Button button8 = this.f١٥٠١٩c;
                        if (button8 != null) {
                            FrameLayout.LayoutParams layoutParams7 = (FrameLayout.LayoutParams) button8.getLayoutParams();
                            float f22 = this.f١٥٠٢٧k;
                            float f23 = this.f١٥٠٢١e;
                            layoutParams7.width = (int) (f22 * f23);
                            layoutParams7.height = (int) (this.f١٥٠٢٨l * f23);
                            layoutParams7.leftMargin = (int) (this.f١٥٠٢٥i * f23);
                            layoutParams7.topMargin = (int) (this.f١٥٠٢٦j * f23);
                            button8.setLayoutParams(layoutParams7);
                        }
                        ImageButton imageButton6 = this.f١٥٠٢٠d;
                        if (imageButton6 != null) {
                            FrameLayout.LayoutParams layoutParams8 = (FrameLayout.LayoutParams) imageButton6.getLayoutParams();
                            float f24 = this.f١٥٠٢٧k;
                            float f25 = this.f١٥٠٢١e;
                            layoutParams8.width = (int) (f24 * f25);
                            layoutParams8.height = (int) (this.f١٥٠٢٨l * f25);
                            layoutParams8.leftMargin = (int) (this.f١٥٠٢٥i * f25);
                            layoutParams8.topMargin = (int) (this.f١٥٠٢٦j * f25);
                            imageButton6.setLayoutParams(layoutParams8);
                            break;
                        }
                        break;
                    case 7:
                        int optInt = jSONObject.optInt("value");
                        this.f١٥٠٣٤r = optInt;
                        Button button9 = this.f١٥٠١٩c;
                        if (button9 != null) {
                            button9.setTextSize(optInt);
                            break;
                        }
                        break;
                    case '\b':
                        this.f١٥٠٣١o = jSONObject.optString("value");
                        h();
                        break;
                    case '\t':
                        this.f١٥٠٣٢p = jSONObject.optInt("value");
                        h();
                        break;
                    case '\n':
                        this.f١٥٠٣٠n = jSONObject.optString("value");
                        h();
                        break;
                    case 11:
                        this.f١٥٠٣٣q = jSONObject.optInt("value");
                        h();
                        break;
                }
                return true;
            default:
                return false;
        }
    }

    @Override // j.t
    public final void d() {
        Button button = this.f١٥٠١٩c;
        if (button != null) {
            this.f١٥٠٣٩b.f١٤٩٩٨m.removeView(button);
            this.f١٥٠١٩c = null;
        }
        ImageButton imageButton = this.f١٥٠٢٠d;
        if (imageButton != null) {
            this.f١٥٠٣٩b.f١٤٩٩٨m.removeView(imageButton);
            this.f١٥٠٢٠d = null;
        }
    }

    public final void h() {
        Button button = this.f١٥٠١٩c;
        if (button != null) {
            GradientDrawable gradientDrawable = (GradientDrawable) button.getBackground();
            gradientDrawable.setColor(g(this.f١٥٠٣٠n));
            gradientDrawable.setCornerRadius(this.f١٥٠٣٣q * this.f١٥٠٢١e);
            gradientDrawable.setStroke((int) (this.f١٥٠٣٢p * this.f١٥٠٢١e), g(this.f١٥٠٣١o));
            this.f١٥٠١٩c.setBackground(gradientDrawable);
        }
    }
}
