package com.alibaba.sdk.android.tbrest.rest;

import android.content.Context;
import com.alibaba.sdk.android.tbrest.utils.LogUtil;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class g {

    /* renamed from: b, reason: collision with other field name */
    private String f٢٥b;
    private Context mContext;

    /* renamed from: a, reason: collision with other field name */
    private Object f٢٣a = null;

    /* renamed from: b, reason: collision with root package name */
    private Object f٦٨٤٩b = null;

    /* renamed from: a, reason: collision with root package name */
    private Class f٦٨٤٨a = null;

    /* renamed from: a, reason: collision with other field name */
    private Field f٢٤a = null;

    /* renamed from: b, reason: collision with other field name */
    private Field f٢٦b = null;

    /* renamed from: c, reason: collision with root package name */
    private Field f٦٨٥٠c = null;

    /* renamed from: b, reason: collision with other field name */
    private Method f٢٧b = null;

    /* renamed from: h, reason: collision with root package name */
    private int f٦٨٥٢h = 1;

    /* renamed from: e, reason: collision with root package name */
    private boolean f٦٨٥١e = false;

    public g(Context context, String str) {
        this.mContext = context;
        this.f٢٥b = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized void g() {
        Class<?> cls;
        Method method;
        boolean z10;
        int i10;
        try {
            if (this.f٦٨٥١e) {
                return;
            }
            Class<?> cls2 = null;
            try {
                cls = Class.forName("com.taobao.wireless.security.sdk.SecurityGuardManager");
            } catch (Throwable unused) {
                cls = null;
            }
            try {
                this.f٢٣a = cls.getMethod("getInstance", Context.class).invoke(null, this.mContext);
                this.f٦٨٤٩b = cls.getMethod("getSecureSignatureComp", null).invoke(this.f٢٣a, null);
            } catch (Throwable unused2) {
                LogUtil.i("initSecurityCheck failure, It's ok ");
                if (cls != null) {
                }
                this.f٦٨٥١e = true;
            }
            if (cls != null) {
                try {
                    Class<?> cls3 = Class.forName("com.taobao.wireless.security.sdk.SecurityGuardParamContext");
                    this.f٦٨٤٨a = cls3;
                    this.f٢٤a = cls3.getDeclaredField("appKey");
                    this.f٢٦b = this.f٦٨٤٨a.getDeclaredField("paramMap");
                    this.f٦٨٥٠c = this.f٦٨٤٨a.getDeclaredField("requestType");
                    try {
                        method = cls.getMethod("isOpen", null);
                    } catch (Throwable unused3) {
                        LogUtil.i("initSecurityCheck failure, It's ok");
                        method = null;
                    }
                    if (method != null) {
                        z10 = ((Boolean) method.invoke(this.f٢٣a, null)).booleanValue();
                    } else {
                        try {
                            cls2 = Class.forName("com.taobao.wireless.security.sdk.securitybody.ISecurityBodyComponent");
                        } catch (Throwable unused4) {
                            LogUtil.i("initSecurityCheck failure, It's ok");
                        }
                        if (cls2 == null) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                    }
                    if (z10) {
                        i10 = 1;
                    } else {
                        i10 = 12;
                    }
                    this.f٦٨٥٢h = i10;
                    this.f٢٧b = Class.forName("com.taobao.wireless.security.sdk.securesignature.ISecureSignatureComponent").getMethod("signRequest", this.f٦٨٤٨a);
                } catch (Throwable unused5) {
                    LogUtil.i("initSecurityCheck failure, It's ok");
                }
            }
            this.f٦٨٥١e = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public String b(String str) {
        Class cls;
        if (!this.f٦٨٥١e) {
            g();
        }
        if (this.f٢٥b == null) {
            LogUtil.e("RestSecuritySDKRequestAuthentication:getSign There is no appkey,please check it!");
            return null;
        }
        if (str == null || this.f٢٣a == null || (cls = this.f٦٨٤٨a) == null || this.f٢٤a == null || this.f٢٦b == null || this.f٦٨٥٠c == null || this.f٢٧b == null || this.f٦٨٤٩b == null) {
            return null;
        }
        try {
            Object newInstance = cls.newInstance();
            this.f٢٤a.set(newInstance, this.f٢٥b);
            ((Map) this.f٢٦b.get(newInstance)).put("INPUT", str);
            this.f٦٨٥٠c.set(newInstance, Integer.valueOf(this.f٦٨٥٢h));
            return (String) this.f٢٧b.invoke(this.f٦٨٤٩b, newInstance);
        } catch (IllegalAccessException e10) {
            e10.printStackTrace();
            return null;
        } catch (IllegalArgumentException e11) {
            e11.printStackTrace();
            return null;
        } catch (InstantiationException e12) {
            e12.printStackTrace();
            return null;
        } catch (InvocationTargetException e13) {
            e13.printStackTrace();
            return null;
        }
    }
}
