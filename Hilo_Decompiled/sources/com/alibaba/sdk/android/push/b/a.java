package com.alibaba.sdk.android.push.b;

import android.content.Context;
import android.graphics.Bitmap;
import com.alibaba.sdk.android.ams.common.logger.AmsLogger;
import com.alibaba.sdk.android.error.ErrorCode;
import com.alibaba.sdk.android.push.CommonCallback;
import com.alibaba.sdk.android.push.g.g;
import com.alibaba.sdk.android.push.notification.CPushMessage;
import com.facebook.internal.security.CertificateUtil;
import com.taobao.agoo.ICallback;
import com.taobao.agoo.TaobaoRegister;
import com.ut.device.UTDevice;
import kotlinx.coroutines.DebugKt;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static final AmsLogger f٦٤٦٤b = AmsLogger.getLogger("MPS:CloudPushService");

    /* renamed from: a, reason: collision with root package name */
    private final Context f٦٤٦٥a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.alibaba.sdk.android.push.b.a$2, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class AnonymousClass2 implements CommonCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CommonCallback f٦٤٦٨a;

        /* renamed from: com.alibaba.sdk.android.push.b.a$2$1, reason: invalid class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        class AnonymousClass1 extends ICallback {
            AnonymousClass1() {
            }

            public void onFailure(String str, String str2) {
                ErrorCode build = com.alibaba.sdk.android.push.common.a.d.a(str, str2).detail("turnOffPushChannel unbindAgoo").build();
                CommonCallback commonCallback = AnonymousClass2.this.f٦٤٦٨a;
                if (commonCallback != null) {
                    commonCallback.onFailed(build.getCode(), build.getMsg());
                }
            }

            public void onSuccess() {
                g.a().d(new CommonCallback() { // from class: com.alibaba.sdk.android.push.b.a.2.1.1
                    @Override // com.alibaba.sdk.android.push.CommonCallback
                    public void onFailed(final String str, final String str2) {
                        TaobaoRegister.bindAgoo(a.this.f٦٤٦٥a, new ICallback() { // from class: com.alibaba.sdk.android.push.b.a.2.1.1.1
                            public void onFailure(String str3, String str4) {
                                ErrorCode build = com.alibaba.sdk.android.push.common.a.d.a(str3, str4).detail("turnOffPushChannel bindAgoo").build();
                                CommonCallback commonCallback = AnonymousClass2.this.f٦٤٦٨a;
                                if (commonCallback != null) {
                                    commonCallback.onFailed(build.getCode(), build.getMsg());
                                }
                            }

                            public void onSuccess() {
                                CommonCallback commonCallback = AnonymousClass2.this.f٦٤٦٨a;
                                if (commonCallback != null) {
                                    commonCallback.onFailed(str, str2);
                                }
                            }
                        });
                    }

                    @Override // com.alibaba.sdk.android.push.CommonCallback
                    public void onSuccess(String str) {
                        CommonCallback commonCallback = AnonymousClass2.this.f٦٤٦٨a;
                        if (commonCallback != null) {
                            commonCallback.onSuccess(str);
                        }
                    }
                });
            }
        }

        AnonymousClass2(CommonCallback commonCallback) {
            this.f٦٤٦٨a = commonCallback;
        }

        @Override // com.alibaba.sdk.android.push.CommonCallback
        public void onFailed(String str, String str2) {
            CommonCallback commonCallback = this.f٦٤٦٨a;
            if (commonCallback != null) {
                commonCallback.onFailed(str, str2);
            }
        }

        @Override // com.alibaba.sdk.android.push.CommonCallback
        public void onSuccess(String str) {
            if (!str.equals(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
                TaobaoRegister.unbindAgoo(a.this.f٦٤٦٥a, new AnonymousClass1());
                return;
            }
            a.f٦٤٦٤b.d("already off. return");
            CommonCallback commonCallback = this.f٦٤٦٨a;
            if (commonCallback != null) {
                commonCallback.onSuccess(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.alibaba.sdk.android.push.b.a$3, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class AnonymousClass3 implements CommonCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CommonCallback f٦٤٧٥a;

        /* renamed from: com.alibaba.sdk.android.push.b.a$3$1, reason: invalid class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        class AnonymousClass1 extends ICallback {
            AnonymousClass1() {
            }

            public void onFailure(String str, String str2) {
                ErrorCode build = com.alibaba.sdk.android.push.common.a.d.a(str, str2).detail("turnOnPushChannel bindAgoo").build();
                CommonCallback commonCallback = AnonymousClass3.this.f٦٤٧٥a;
                if (commonCallback != null) {
                    commonCallback.onFailed(build.getCode(), build.getMsg());
                }
            }

            public void onSuccess() {
                g.a().e(new CommonCallback() { // from class: com.alibaba.sdk.android.push.b.a.3.1.1
                    @Override // com.alibaba.sdk.android.push.CommonCallback
                    public void onFailed(final String str, final String str2) {
                        TaobaoRegister.unbindAgoo(a.this.f٦٤٦٥a, new ICallback() { // from class: com.alibaba.sdk.android.push.b.a.3.1.1.1
                            public void onFailure(String str3, String str4) {
                                ErrorCode build = com.alibaba.sdk.android.push.common.a.d.a(str3, str4).detail("turnOnPushChannel unbindAgoo").build();
                                CommonCallback commonCallback = AnonymousClass3.this.f٦٤٧٥a;
                                if (commonCallback != null) {
                                    commonCallback.onFailed(build.getCode(), build.getMsg());
                                }
                            }

                            public void onSuccess() {
                                CommonCallback commonCallback = AnonymousClass3.this.f٦٤٧٥a;
                                if (commonCallback != null) {
                                    commonCallback.onFailed(str, str2);
                                }
                            }
                        });
                    }

                    @Override // com.alibaba.sdk.android.push.CommonCallback
                    public void onSuccess(String str) {
                        CommonCallback commonCallback = AnonymousClass3.this.f٦٤٧٥a;
                        if (commonCallback != null) {
                            commonCallback.onSuccess(str);
                        }
                    }
                });
            }
        }

        AnonymousClass3(CommonCallback commonCallback) {
            this.f٦٤٧٥a = commonCallback;
        }

        @Override // com.alibaba.sdk.android.push.CommonCallback
        public void onFailed(String str, String str2) {
            CommonCallback commonCallback = this.f٦٤٧٥a;
            if (commonCallback != null) {
                commonCallback.onFailed(str, str2);
            }
        }

        @Override // com.alibaba.sdk.android.push.CommonCallback
        public void onSuccess(String str) {
            if (!str.equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                TaobaoRegister.bindAgoo(a.this.f٦٤٦٥a, new AnonymousClass1());
                return;
            }
            a.f٦٤٦٤b.d("already on. return");
            CommonCallback commonCallback = this.f٦٤٧٥a;
            if (commonCallback != null) {
                commonCallback.onSuccess(str);
            }
        }
    }

    public a(Context context) {
        this.f٦٤٦٥a = context;
        g.a(context);
    }

    public void b() {
        TaobaoRegister.clearNotificationCreatedByAliyun(this.f٦٤٦٥a);
    }

    public void d(CommonCallback commonCallback) {
        f(new AnonymousClass2(commonCallback));
    }

    public void e(CommonCallback commonCallback) {
        f(new AnonymousClass3(commonCallback));
    }

    public void f(CommonCallback commonCallback) {
        g.a().c(commonCallback);
    }

    public String a() {
        return com.alibaba.sdk.android.ams.common.b.c.a().b();
    }

    public void b(int i10, String[] strArr, String str, CommonCallback commonCallback) {
        g.a().b(i10, strArr, str, commonCallback);
    }

    public void c(CommonCallback commonCallback) {
        g.a().f(commonCallback);
    }

    public void d(String str, CommonCallback commonCallback) {
        g.a().d(str, commonCallback);
    }

    public String a(Context context) {
        return UTDevice.getUtdid(context);
    }

    public void b(Context context) {
        g.a().b(context);
    }

    public void c(String str) {
        com.alibaba.sdk.android.ams.common.b.c.a().e(str);
    }

    public void a(int i10) {
        com.alibaba.sdk.android.push.common.a.c.a(i10);
    }

    public void b(CommonCallback commonCallback) {
        g.a().b(commonCallback);
    }

    public void c(String str, CommonCallback commonCallback) {
        g.a().c(str, commonCallback);
    }

    public void a(int i10, int i11, int i12, int i13, final CommonCallback commonCallback) {
        f٦٤٦٤b.d("setDoNotDisturb " + i10 + CertificateUtil.DELIMITER + i11 + "-" + i12 + CertificateUtil.DELIMITER + i13);
        TaobaoRegister.setDoNotDisturb(i10, i11, i12, i13, new com.aliyun.ams.emas.push.a() { // from class: com.alibaba.sdk.android.push.b.a.1
            @Override // com.aliyun.ams.emas.push.a
            public void onFailed(String str, String str2) {
                ErrorCode build = com.alibaba.sdk.android.push.common.a.d.a(str, str2).build();
                commonCallback.onFailed(build.getCode(), build.getMsg());
            }

            @Override // com.aliyun.ams.emas.push.a
            public void onSuccess(String str) {
                commonCallback.onSuccess(str);
            }
        });
    }

    public void b(CPushMessage cPushMessage) {
        TaobaoRegister.dismissMessage(CPushMessage.to(cPushMessage));
    }

    public void a(int i10, CommonCallback commonCallback) {
        g.a().a(i10, commonCallback);
    }

    public void b(String str) {
        com.alibaba.sdk.android.ams.common.b.c.a().d(str);
    }

    public void a(int i10, String[] strArr, String str, CommonCallback commonCallback) {
        g.a().a(i10, strArr, str, commonCallback);
    }

    public void b(String str, CommonCallback commonCallback) {
        g.a().b(str, commonCallback);
    }

    public void a(Bitmap bitmap) {
        com.alibaba.sdk.android.push.common.a.c.a(bitmap);
    }

    public void b(boolean z10) {
        com.alibaba.sdk.android.push.common.a.c.a(z10);
    }

    public void a(CommonCallback commonCallback) {
        g.a().a(commonCallback);
    }

    public void a(CPushMessage cPushMessage) {
        TaobaoRegister.clickMessage(CPushMessage.to(cPushMessage));
    }

    public void a(Class<?> cls) {
        TaobaoRegister.setPushMsgReceiveService(cls);
    }

    public void a(String str) {
        com.alibaba.sdk.android.push.common.a.c.a(str);
    }

    public void a(String str, CommonCallback commonCallback) {
        g.a().a(str, commonCallback);
    }

    public void a(boolean z10) {
        TaobaoRegister.setDoNotDisturbMode(z10);
    }
}
