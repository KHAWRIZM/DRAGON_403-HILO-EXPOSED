package com.taobao.agoo.a;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.sdk.android.error.ErrorCode;
import com.taobao.accs.AccsErrorCode;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.JsonUtility;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.agoo.ICallback;
import com.taobao.agoo.IListAliasCallback;
import com.taobao.agoo.IListAliasCallbackInner;
import com.taobao.agoo.IRegister;
import com.taobao.agoo.a.a.c;
import com.taobao.agoo.a.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.android.agoo.common.Config;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class b extends AccsAbstractDataListener {
    public static a b;
    public Map<String, ICallback> a = new HashMap();

    public b(Context context) {
        if (b == null) {
            b = new a(context.getApplicationContext());
        }
    }

    private void a(JSONObject jSONObject, IListAliasCallback iListAliasCallback) {
        Map<String, String> map = JsonUtility.getMap(jSONObject, com.taobao.agoo.a.a.a.JSON_ALIAS_TOKEN_MAP);
        if (map == null) {
            map = new HashMap<>();
        }
        if (iListAliasCallback != null) {
            if (iListAliasCallback instanceof IListAliasCallbackInner) {
                ((IListAliasCallbackInner) iListAliasCallback).onSuccess(map);
            } else {
                iListAliasCallback.onSuccess(new ArrayList(map.keySet()));
            }
        }
    }

    @Override // com.taobao.accs.base.AccsAbstractDataListener, com.taobao.accs.base.AccsDataListener
    public void onBind(String str, int i, TaoBaseService.ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onData(String str, String str2, String str3, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x0192, code lost:
    
        r5.onSuccess();
     */
    @Override // com.taobao.accs.base.AccsAbstractDataListener, com.taobao.accs.base.AccsDataListenerV2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onResponse(String str, String str2, int i, String str3, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
        String string;
        boolean equals;
        try {
            if ("AgooDeviceCmd".equals(str)) {
                ICallback iCallback = this.a.get(str2);
                if (i == AccsErrorCode.SUCCESS.getCodeInt()) {
                    String str4 = new String(bArr, "utf-8");
                    ALog.i("RequestListener", "RequestListener onResponse", Constants.KEY_DATA_ID, str2, "listener", iCallback, "json", str4);
                    JSONObject jSONObject = new JSONObject(str4);
                    String string2 = JsonUtility.getString(jSONObject, com.taobao.agoo.a.a.b.JSON_ERRORCODE, null);
                    String string3 = JsonUtility.getString(jSONObject, com.taobao.agoo.a.a.b.JSON_CMD, null);
                    if (!com.taobao.agoo.a.a.b.JSON_SUCCESS.equals(string2)) {
                        if (iCallback != null) {
                            ErrorCode build = com.taobao.agoo.a.a(string2, string3 + "报错").build();
                            iCallback.onFailure(build.getCode(), build.getMsg());
                        }
                        if (equals) {
                            return;
                        } else {
                            return;
                        }
                    }
                    if (c.JSON_CMD_REGISTER.equals(string3)) {
                        String string4 = JsonUtility.getString(jSONObject, "deviceId", null);
                        if (TextUtils.isEmpty(string4)) {
                            if (iCallback != null) {
                                ErrorCode build2 = com.taobao.agoo.a.a(com.taobao.agoo.a.a.b.JSON_SUCCESS, string3 + "成功，但是未返回deviceId").detail(str4).build();
                                iCallback.onFailure(build2.getCode(), build2.getMsg());
                            }
                        } else {
                            Config.b(GlobalClientInfo.getContext(), string4);
                            b.a(GlobalClientInfo.getContext().getPackageName());
                            if (iCallback instanceof IRegister) {
                                UtilityImpl.saveUtdid(Config.PREFERENCES, GlobalClientInfo.getContext());
                                ((IRegister) iCallback).onSuccess(string4);
                            }
                        }
                        if ("AgooDeviceCmd".equals(str)) {
                            this.a.remove(str2);
                            return;
                        }
                        return;
                    }
                    if (com.taobao.agoo.a.a.a.JSON_CMD_ADDALIAS.equals(string3) && (string = JsonUtility.getString(jSONObject, "pushAliasToken", null)) != null && iCallback.extra != null) {
                        com.taobao.agoo.b.a(GlobalClientInfo.getContext(), iCallback.extra, string);
                    }
                    if (com.taobao.agoo.a.a.a.JSON_CMD_REMOVEALIAS.equals(string3) && iCallback.extra != null) {
                        com.taobao.agoo.b.a(GlobalClientInfo.getContext(), iCallback.extra, null);
                    }
                    if (!com.taobao.agoo.a.a.a.JSON_CMD_ADDALIAS.equals(string3) && !com.taobao.agoo.a.a.a.JSON_CMD_REMOVEALIAS.equals(string3) && !com.taobao.agoo.a.a.a.JSON_CMD_REMOVEALLALIAS.equals(string3) && !com.taobao.agoo.a.a.a.JSON_CMD_REMOVEALLALIASANDADDALIAS.equals(string3) && !com.taobao.agoo.a.a.a.JSON_CMD_RESETAlIASANDBINDCURRENT.equals(string3) && !com.taobao.agoo.a.a.a.JSON_CMD_RESETALIASDEVICEONE2ONE.equals(string3)) {
                        if (com.taobao.agoo.a.a.a.JSON_CMD_LISTALIAS.equals(string3)) {
                            a(jSONObject, (IListAliasCallback) iCallback);
                            if ("AgooDeviceCmd".equals(str)) {
                                this.a.remove(str2);
                                return;
                            }
                            return;
                        }
                        if ((d.JSON_CMD_ENABLEPUSH.equals(string3) || d.JSON_CMD_DISABLEPUSH.equals(string3)) && iCallback != null) {
                            iCallback.onSuccess();
                        }
                    }
                    if ("AgooDeviceCmd".equals(str)) {
                        this.a.remove(str2);
                        return;
                    }
                    return;
                }
                if (iCallback != null) {
                    ErrorCode build3 = com.taobao.agoo.a.a(i, str3).build();
                    iCallback.onFailure(build3.getCode(), build3.getMsg());
                }
            }
            if (!"AgooDeviceCmd".equals(str)) {
                return;
            }
        } catch (Throwable th) {
            try {
                ALog.e("RequestListener", "onResponse", th, new Object[0]);
                if (!"AgooDeviceCmd".equals(str)) {
                    return;
                }
            } finally {
                if ("AgooDeviceCmd".equals(str)) {
                    this.a.remove(str2);
                }
            }
        }
        this.a.remove(str2);
    }

    @Override // com.taobao.accs.base.AccsAbstractDataListener, com.taobao.accs.base.AccsDataListener
    public void onSendData(String str, String str2, int i, TaoBaseService.ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsAbstractDataListener, com.taobao.accs.base.AccsDataListener
    public void onUnbind(String str, int i, TaoBaseService.ExtraInfo extraInfo) {
    }
}
