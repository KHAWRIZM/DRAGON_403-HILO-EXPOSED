package com.luck.picture.lib.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.content.FileProvider;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectMimeType;
import java.io.File;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class IntentUtils {
    public static void startSystemPlayerVideo(Context context, String str) {
        boolean z10;
        Uri fromFile;
        Intent intent = new Intent("android.intent.action.VIEW");
        if (!PictureMimeType.isContent(str) && !PictureMimeType.isHasHttp(str)) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (SdkVersionUtils.isQ()) {
            if (z10) {
                fromFile = Uri.parse(str);
            } else {
                fromFile = Uri.fromFile(new File(str));
            }
        } else if (SdkVersionUtils.isMaxN()) {
            if (z10) {
                fromFile = Uri.parse(str);
            } else {
                fromFile = FileProvider.getUriForFile(context, context.getPackageName() + ".luckProvider", new File(str));
            }
        } else if (z10) {
            fromFile = Uri.parse(str);
        } else {
            fromFile = Uri.fromFile(new File(str));
        }
        intent.addFlags(268468224);
        intent.addFlags(1);
        intent.setDataAndType(fromFile, SelectMimeType.SYSTEM_VIDEO);
        context.startActivity(intent);
    }
}
