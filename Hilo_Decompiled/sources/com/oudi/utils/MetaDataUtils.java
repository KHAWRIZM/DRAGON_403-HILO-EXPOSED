package com.oudi.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u001c\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007J!\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/oudi/utils/MetaDataUtils;", "", "<init>", "()V", "getMetaData", "Landroid/os/Bundle;", "context", "Landroid/content/Context;", "getStringData", "", TransferTable.COLUMN_KEY, "getIntData", "", "(Ljava/lang/String;Landroid/content/Context;)Ljava/lang/Integer;", "lib_utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class MetaDataUtils {
    public static final MetaDataUtils INSTANCE = new MetaDataUtils();

    private MetaDataUtils() {
    }

    public static /* synthetic */ Integer getIntData$default(MetaDataUtils metaDataUtils, String str, Context context, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            context = AppUtils.getApp();
        }
        return metaDataUtils.getIntData(str, context);
    }

    public static /* synthetic */ Bundle getMetaData$default(MetaDataUtils metaDataUtils, Context context, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            context = AppUtils.getApp();
        }
        return metaDataUtils.getMetaData(context);
    }

    public static /* synthetic */ String getStringData$default(MetaDataUtils metaDataUtils, String str, Context context, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            context = AppUtils.getApp();
        }
        return metaDataUtils.getStringData(str, context);
    }

    public final Integer getIntData(String key, Context context) {
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle metaData = getMetaData(context);
        if (metaData != null) {
            return Integer.valueOf(metaData.getInt(key));
        }
        return null;
    }

    public final Bundle getMetaData(Context context) {
        if (context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
            return applicationInfo.metaData;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public final String getStringData(String key, Context context) {
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle metaData = getMetaData(context);
        if (metaData != null) {
            return metaData.getString(key);
        }
        return null;
    }
}
