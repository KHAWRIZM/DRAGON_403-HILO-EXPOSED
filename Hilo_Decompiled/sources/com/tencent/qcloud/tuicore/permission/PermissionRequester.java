package com.tencent.qcloud.tuicore.permission;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.annotation.Size;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.interfaces.ITUINotification;
import com.tencent.qcloud.tuicore.util.TUIBuild;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class PermissionRequester {
    public static final String PERMISSION_NOTIFY_EVENT_KEY = "PERMISSION_NOTIFY_EVENT_KEY";
    public static final String PERMISSION_NOTIFY_EVENT_SUB_KEY = "PERMISSION_NOTIFY_EVENT_SUB_KEY";
    public static final String PERMISSION_REQUEST_KEY = "PERMISSION_REQUEST_KEY";
    public static final String PERMISSION_RESULT = "PERMISSION_RESULT";
    private static final String TAG = "PermissionRequester";
    private String mDescription;
    private PermissionCallback mPermissionCallback;
    private ITUINotification mPermissionNotification = new ITUINotification() { // from class: com.tencent.qcloud.tuicore.permission.f
        @Override // com.tencent.qcloud.tuicore.interfaces.ITUINotification
        public final void onNotifyEvent(String str, String str2, Map map) {
            PermissionRequester.this.lambda$new$0(str, str2, map);
        }
    };
    private String[] mPermissions;
    private String mSettingsTip;
    private String mTitle;
    private static final Object sLock = new Object();
    private static AtomicBoolean sIsRequesting = new AtomicBoolean(false);

    private PermissionRequester(String... strArr) {
        this.mPermissions = strArr;
    }

    private void afterPermissionDenied() {
        Log.i(TAG, "afterPermissionDenied");
        PermissionCallback permissionCallback = this.mPermissionCallback;
        if (permissionCallback != null) {
            permissionCallback.onDenied();
            this.mPermissionCallback = null;
        }
        TUICore.unRegisterEvent(PERMISSION_NOTIFY_EVENT_KEY, PERMISSION_NOTIFY_EVENT_SUB_KEY, this.mPermissionNotification);
        sIsRequesting.set(false);
    }

    private void afterPermissionGranted() {
        Log.i(TAG, "afterPermissionGranted");
        PermissionCallback permissionCallback = this.mPermissionCallback;
        if (permissionCallback != null) {
            permissionCallback.onGranted();
            this.mPermissionCallback = null;
        }
        TUICore.unRegisterEvent(PERMISSION_NOTIFY_EVENT_KEY, PERMISSION_NOTIFY_EVENT_SUB_KEY, this.mPermissionNotification);
        sIsRequesting.set(false);
    }

    private String[] findUnauthorizedPermissions(String[] strArr) {
        Context appContext = TUIConfig.getAppContext();
        if (appContext == null) {
            Log.e(TAG, "findUnauthorizedPermissions appContext is null");
            return strArr;
        }
        LinkedList linkedList = new LinkedList();
        for (String str : strArr) {
            if (androidx.core.content.a.checkSelfPermission(appContext, str) != 0) {
                linkedList.add(str);
            }
        }
        return (String[]) linkedList.toArray(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(String str, String str2, Map map) {
        Object obj;
        if (map != null && (obj = map.get(PERMISSION_RESULT)) != null && (obj instanceof Boolean)) {
            if (((Boolean) obj).booleanValue()) {
                afterPermissionGranted();
            } else {
                afterPermissionDenied();
            }
        }
    }

    public static PermissionRequester newInstance(@Size(min = 1) String... strArr) {
        return new PermissionRequester(strArr);
    }

    @RequiresApi(api = 23)
    private void startPermissionActivity(RequestData requestData) {
        Context appContext = TUIConfig.getAppContext();
        if (appContext == null) {
            return;
        }
        Intent intent = new Intent(appContext, (Class<?>) PermissionActivity.class);
        intent.putExtra(PERMISSION_REQUEST_KEY, requestData);
        appContext.startActivity(intent);
    }

    public PermissionRequester callback(PermissionCallback permissionCallback) {
        this.mPermissionCallback = permissionCallback;
        return this;
    }

    public PermissionRequester description(String str) {
        this.mDescription = str;
        return this;
    }

    @SuppressLint({"NewApi"})
    public void request() {
        synchronized (sLock) {
            try {
                if (sIsRequesting.get()) {
                    Log.e(TAG, "can not request during requesting");
                    this.mPermissionCallback.onDenied();
                    return;
                }
                sIsRequesting.set(true);
                TUICore.registerEvent(PERMISSION_NOTIFY_EVENT_KEY, PERMISSION_NOTIFY_EVENT_SUB_KEY, this.mPermissionNotification);
                if (TUIBuild.getVersionInt() < 23) {
                    Log.i(TAG, "current version is lower than 23");
                    afterPermissionGranted();
                    return;
                }
                String[] findUnauthorizedPermissions = findUnauthorizedPermissions(this.mPermissions);
                if (findUnauthorizedPermissions.length <= 0) {
                    afterPermissionGranted();
                } else {
                    startPermissionActivity(new RequestData(this.mTitle, this.mDescription, this.mSettingsTip, findUnauthorizedPermissions));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public PermissionRequester settingsTip(String str) {
        this.mSettingsTip = str;
        return this;
    }

    public PermissionRequester title(String str) {
        this.mTitle = str;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class RequestData implements Parcelable {
        public static final Parcelable.Creator<RequestData> CREATOR = new Parcelable.Creator<RequestData>() { // from class: com.tencent.qcloud.tuicore.permission.PermissionRequester.RequestData.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RequestData createFromParcel(Parcel parcel) {
                return new RequestData(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RequestData[] newArray(int i) {
                return new RequestData[i];
            }
        };
        private final String mDescription;
        private int mPermissionIconId;
        private final String[] mPermissions;
        private final String mSettingsTip;
        private final String mTitle;

        public RequestData(String str, String str2, String str3, String... strArr) {
            this.mTitle = str;
            this.mDescription = str2;
            this.mSettingsTip = str3;
            this.mPermissions = (String[]) strArr.clone();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getDescription() {
            return this.mDescription;
        }

        public int getPermissionIconId() {
            return this.mPermissionIconId;
        }

        public String[] getPermissions() {
            return (String[]) this.mPermissions.clone();
        }

        public String getSettingsTip() {
            return this.mSettingsTip;
        }

        public String getTitle() {
            return this.mTitle;
        }

        public boolean isPermissionsExistEmpty() {
            String[] strArr = this.mPermissions;
            if (strArr == null || strArr.length <= 0) {
                return true;
            }
            for (String str : strArr) {
                if (TextUtils.isEmpty(str)) {
                    return true;
                }
            }
            return false;
        }

        public void setPermissionIconId(int i) {
            this.mPermissionIconId = i;
        }

        public String toString() {
            return "PermissionRequest{mPermissions=" + Arrays.toString(this.mPermissions) + ", mTitle=" + this.mTitle + ", mDescription='" + this.mDescription + ", mSettingsTip='" + this.mSettingsTip + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeStringArray(this.mPermissions);
            parcel.writeString(this.mTitle);
            parcel.writeString(this.mDescription);
            parcel.writeString(this.mSettingsTip);
            parcel.writeInt(this.mPermissionIconId);
        }

        protected RequestData(Parcel parcel) {
            this.mPermissions = parcel.createStringArray();
            this.mTitle = parcel.readString();
            this.mDescription = parcel.readString();
            this.mSettingsTip = parcel.readString();
            this.mPermissionIconId = parcel.readInt();
        }
    }
}
