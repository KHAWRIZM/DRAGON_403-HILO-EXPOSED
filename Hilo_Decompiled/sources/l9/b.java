package l9;

import com.heytap.mcssdk.constant.MessageConstant$MessageType;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class b extends t9.a {

    /* renamed from: a, reason: collision with root package name */
    private String f١٥٨٣٣a;

    /* renamed from: b, reason: collision with root package name */
    private String f١٥٨٣٤b;

    /* renamed from: c, reason: collision with root package name */
    private String f١٥٨٣٥c;

    /* renamed from: d, reason: collision with root package name */
    private String f١٥٨٣٦d;

    /* renamed from: e, reason: collision with root package name */
    private int f١٥٨٣٧e;

    /* renamed from: f, reason: collision with root package name */
    private String f١٥٨٣٨f;

    /* renamed from: g, reason: collision with root package name */
    private int f١٥٨٣٩g = -2;

    /* renamed from: h, reason: collision with root package name */
    private String f١٥٨٤٠h;

    @Override // t9.a
    public int a() {
        return MessageConstant$MessageType.MESSAGE_CALL_BACK;
    }

    public int b() {
        return this.f١٥٨٣٧e;
    }

    public String c() {
        return this.f١٥٨٣٨f;
    }

    public int d() {
        return this.f١٥٨٣٩g;
    }

    public void e(String str) {
        this.f١٥٨٣٣a = str;
    }

    public void f(String str) {
        this.f١٥٨٤٠h = str;
    }

    public void g(String str) {
        this.f١٥٨٣٤b = str;
    }

    public void h(int i10) {
        this.f١٥٨٣٧e = i10;
    }

    public void i(String str) {
        this.f١٥٨٣٨f = str;
    }

    public void j(int i10) {
        this.f١٥٨٣٩g = i10;
    }

    public String toString() {
        return "CallBackResult{, mRegisterID='" + this.f١٥٨٣٥c + "', mSdkVersion='" + this.f١٥٨٣٦d + "', mCommand=" + this.f١٥٨٣٧e + "', mContent='" + this.f١٥٨٣٨f + "', mAppPackage=" + this.f١٥٨٤٠h + "', mResponseCode=" + this.f١٥٨٣٩g + '}';
    }
}
