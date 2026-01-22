package com.qhqc.core.basic.utils;

import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u00015B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fJ\u0018\u0010\u0014\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\fJ\u001d\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00192\u0006\u0010\u0016\u001a\u00020\fH\u0002¢\u0006\u0002\u0010\u001aJ\u000e\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fJ\u0018\u0010\u001b\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\fJ\u001b\u0010\u001c\u001a\u00020\f2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0019H\u0002¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"H\u0002J\u000e\u0010#\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fJ\u0018\u0010#\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\fJ\u000e\u0010$\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\fJ\u0010\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\fH\u0002J\u0014\u0010'\u001a\u00020\u00152\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010(J\u0014\u0010)\u001a\u00020\f2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010(J\u0010\u0010*\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fH\u0002J\u0018\u0010*\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010+\u001a\u00020,H\u0002J\u000e\u0010-\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\fJ\u000e\u0010.\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010/\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\nJ\u000e\u00100\u001a\u00020\u00152\u0006\u00101\u001a\u00020\fJ\u0016\u00102\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010+\u001a\u00020,J \u00102\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010+\u001a\u00020,J\u000e\u00102\u001a\u00020\u00152\u0006\u0010+\u001a\u00020,J\u000e\u00103\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fJ\u0018\u00103\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\fJ\u000e\u00104\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fJ\u0018\u00104\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/qhqc/core/basic/utils/LogUtil;", "", "()V", "DEBUG", "", "ERROR", "INFO", "MAX_LENGTH", "NONLOG", "PRINT", "", "TAG", "", "VERBOSE", "WARN", "filemane", FirebaseAnalytics.Param.LEVEL, "sField_TN", "Ljava/lang/reflect/Field;", "sField_TN_Handler", "d", "", "msg", "Tag", "divideLongString", "", "(Ljava/lang/String;)[Ljava/lang/String;", "e", "getTagInfo", "stackTraceElement", "Ljava/lang/StackTraceElement;", "([Ljava/lang/StackTraceElement;)Ljava/lang/String;", "hook", "toast", "Landroid/widget/Toast;", "i", "json", "jsonToLog", "jsonStr", "list", "", "listToLog", "print", "tr", "", "setFilemane", "setLevel", "setPRINT", "setTAG", "tAG", "t", "v", "w", "SafelyHandlerWarpper", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class LogUtil {
    public static final int DEBUG = 2;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    private static final int MAX_LENGTH = 4000;
    public static final int NONLOG = 0;
    private static boolean PRINT = false;
    public static final int VERBOSE = 1;
    public static final int WARN = 5;

    @Nullable
    private static Field sField_TN;

    @Nullable
    private static Field sField_TN_Handler;

    @NotNull
    public static final LogUtil INSTANCE = new LogUtil();
    private static int level = 6;

    @NotNull
    private static String TAG = "LogUtil";

    @NotNull
    private static String filemane = "loginfo";

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/qhqc/core/basic/utils/LogUtil$SafelyHandlerWarpper;", "Landroid/os/Handler;", "impl", "(Landroid/os/Handler;)V", "handleMessage", "", "msg", "Landroid/os/Message;", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    private static final class SafelyHandlerWarpper extends Handler {

        @Nullable
        private final Handler impl;

        public SafelyHandlerWarpper(@Nullable Handler handler) {
            this.impl = handler;
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            try {
                Handler handler = this.impl;
                Intrinsics.checkNotNull(handler);
                handler.handleMessage(msg);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    static {
        Field field;
        Class<?> type;
        if (Build.VERSION.SDK_INT == 25) {
            try {
                Field declaredField = Toast.class.getDeclaredField("mTN");
                sField_TN = declaredField;
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                }
                Field field2 = sField_TN;
                if (field2 != null && (type = field2.getType()) != null) {
                    field = type.getDeclaredField("mHandler");
                } else {
                    field = null;
                }
                sField_TN_Handler = field;
                if (field != null) {
                    field.setAccessible(true);
                }
            } catch (Exception unused) {
            }
        }
    }

    private LogUtil() {
    }

    private final String[] divideLongString(String msg) {
        if (msg.length() < 4000) {
            return new String[]{msg};
        }
        int length = (msg.length() / 4000) + 1;
        String[] strArr = new String[length];
        for (int i10 = 0; i10 < length; i10++) {
            String substring = msg.substring(i10 * 4000, (int) Math.min(msg.length(), r3 + 4000));
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            strArr[i10] = substring;
        }
        return strArr;
    }

    private final String getTagInfo(StackTraceElement[] stackTraceElement) {
        StringBuilder sb = new StringBuilder();
        int length = stackTraceElement.length;
        for (int i10 = 3; i10 < length; i10++) {
            String className = stackTraceElement[i10].getClassName();
            if (!Intrinsics.areEqual(className, LogUtil.class.getName())) {
                Intrinsics.checkNotNull(className);
                if (StringsKt.startsWith$default(className, "android", false, 2, (Object) null)) {
                    break;
                }
                Intrinsics.checkNotNull(className);
                if (StringsKt.startsWith$default(className, "java", false, 2, (Object) null)) {
                    break;
                }
                Intrinsics.checkNotNull(className);
                Intrinsics.checkNotNull(className);
                String substring = className.substring(StringsKt.lastIndexOf$default((CharSequence) className, InstructionFileId.DOT, 0, false, 6, (Object) null) + 1);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("%s.%s(%s:%d)", Arrays.copyOf(new Object[]{substring, stackTraceElement[i10].getMethodName(), stackTraceElement[i10].getFileName(), Integer.valueOf(stackTraceElement[i10].getLineNumber())}, 4));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                sb.append(format);
                sb.append("\n");
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    private final void hook(Toast toast) {
        try {
            Field field = sField_TN;
            Intrinsics.checkNotNull(field);
            Object obj = field.get(toast);
            Field field2 = sField_TN_Handler;
            Intrinsics.checkNotNull(field2);
            Object obj2 = field2.get(obj);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.os.Handler");
            Field field3 = sField_TN_Handler;
            Intrinsics.checkNotNull(field3);
            field3.set(obj, new SafelyHandlerWarpper((Handler) obj2));
        } catch (Exception unused) {
        }
    }

    private final String jsonToLog(String jsonStr) {
        String jSONArray;
        if (TextUtils.isEmpty(jsonStr)) {
            return "JSON{json is null}";
        }
        try {
            if (StringsKt.startsWith$default(jsonStr, "{", false, 2, (Object) null)) {
                jSONArray = new JSONObject(jsonStr).toString(4);
                Intrinsics.checkNotNullExpressionValue(jSONArray, "toString(...)");
            } else if (StringsKt.startsWith$default(jsonStr, "[", false, 2, (Object) null)) {
                jSONArray = new JSONArray(jsonStr).toString(4);
                Intrinsics.checkNotNullExpressionValue(jSONArray, "toString(...)");
            } else {
                return jsonStr;
            }
            return jSONArray;
        } catch (JSONException unused) {
            return jsonStr;
        }
    }

    private final void print(String msg) {
        String format = new SimpleDateFormat("yyyy_MM_dd_HH:mm:ss").format(new Date());
        String str = filemane + ".txt";
        String str2 = Environment.getExternalStorageDirectory().getPath() + "/DEBUG" + filemane;
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str3 = format + DispatchConstants.SIGN_SPLIT_SYMBOL + msg + "\n";
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(str2 + "/" + str));
            bufferedWriter.write(str3);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void d(@NotNull String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        d(null, msg);
    }

    public final void e(@NotNull String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        e(null, msg);
    }

    public final void i(@NotNull String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        i(null, msg);
    }

    public final void json(@NotNull String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        d(jsonToLog(json));
    }

    public final void list(@NotNull List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        d(listToLog(list));
    }

    @NotNull
    public final String listToLog(@NotNull List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        StringBuilder sb = new StringBuilder();
        sb.append(list.getClass().getSimpleName() + ",size = " + list.size() + "\n");
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            sb.append(i10 + "  " + list.get(i10) + "\n");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public final void setFilemane(@NotNull String filemane2) {
        Intrinsics.checkNotNullParameter(filemane2, "filemane");
        filemane = filemane2;
    }

    public final void setLevel(int level2) {
        level = level2;
    }

    public final void setPRINT(boolean PRINT2) {
        PRINT = PRINT2;
    }

    public final void setTAG(@NotNull String tAG) {
        Intrinsics.checkNotNullParameter(tAG, "tAG");
        TAG = tAG;
    }

    public final void t(@NotNull Throwable tr) {
        Intrinsics.checkNotNullParameter(tr, "tr");
        t(null, "", tr);
    }

    public final void v(@NotNull String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        v(null, msg);
    }

    public final void w(@NotNull String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        w(null, msg);
    }

    public final void d(@Nullable String Tag, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (level >= 2) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            Intrinsics.checkNotNull(stackTrace);
            String tagInfo = getTagInfo(stackTrace);
            for (String str : divideLongString(msg + "     " + tagInfo)) {
                if (Tag == null) {
                    String str2 = TAG;
                    if (str == null) {
                        str = "";
                    }
                    Log.d(str2, str);
                } else {
                    String str3 = TAG + "-" + Tag;
                    if (str == null) {
                        str = "";
                    }
                    Log.d(str3, str);
                }
            }
            if (PRINT) {
                print(tagInfo + DispatchConstants.SIGN_SPLIT_SYMBOL + msg);
            }
        }
    }

    public final void e(@Nullable String Tag, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (level >= 6) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            Intrinsics.checkNotNull(stackTrace);
            String tagInfo = getTagInfo(stackTrace);
            for (String str : divideLongString(msg + "     " + tagInfo)) {
                if (Tag == null) {
                    String str2 = TAG;
                    if (str == null) {
                        str = "";
                    }
                    Log.e(str2, str);
                } else {
                    String str3 = TAG + "-" + Tag;
                    if (str == null) {
                        str = "";
                    }
                    Log.e(str3, str);
                }
            }
            if (PRINT) {
                print(tagInfo + DispatchConstants.SIGN_SPLIT_SYMBOL + msg);
            }
        }
    }

    public final void i(@Nullable String Tag, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (level >= 4) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            Intrinsics.checkNotNull(stackTrace);
            String tagInfo = getTagInfo(stackTrace);
            for (String str : divideLongString(msg + "     " + tagInfo)) {
                if (Tag == null) {
                    String str2 = TAG;
                    if (str == null) {
                        str = "";
                    }
                    Log.i(str2, str);
                } else {
                    String str3 = TAG + "-" + Tag;
                    if (str == null) {
                        str = "";
                    }
                    Log.i(str3, str);
                }
            }
            if (PRINT) {
                print(tagInfo + DispatchConstants.SIGN_SPLIT_SYMBOL + msg);
            }
        }
    }

    public final void t(@NotNull String msg, @NotNull Throwable tr) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(tr, "tr");
        t(null, msg, tr);
    }

    public final void v(@Nullable String Tag, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (level >= 1) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            Intrinsics.checkNotNull(stackTrace);
            String tagInfo = getTagInfo(stackTrace);
            for (String str : divideLongString(msg + "     " + tagInfo)) {
                if (Tag == null) {
                    String str2 = TAG;
                    if (str == null) {
                        str = "";
                    }
                    Log.v(str2, str);
                } else {
                    String str3 = TAG + "-" + Tag;
                    if (str == null) {
                        str = "";
                    }
                    Log.v(str3, str);
                }
            }
            if (PRINT) {
                print(tagInfo + DispatchConstants.SIGN_SPLIT_SYMBOL + msg);
            }
        }
    }

    public final void w(@Nullable String Tag, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (level >= 5) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            Intrinsics.checkNotNull(stackTrace);
            String tagInfo = getTagInfo(stackTrace);
            for (String str : divideLongString(msg + "     " + tagInfo)) {
                if (Tag == null) {
                    String str2 = TAG;
                    if (str == null) {
                        str = "";
                    }
                    Log.w(str2, str);
                } else {
                    String str3 = TAG + "-" + Tag;
                    if (str == null) {
                        str = "";
                    }
                    Log.w(str3, str);
                }
            }
            if (PRINT) {
                print(tagInfo + DispatchConstants.SIGN_SPLIT_SYMBOL + msg);
            }
        }
    }

    public final void t(@Nullable String Tag, @NotNull String msg, @NotNull Throwable tr) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(tr, "tr");
        if (level >= 6) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            Intrinsics.checkNotNull(stackTrace);
            String tagInfo = getTagInfo(stackTrace);
            for (String str : divideLongString(msg + "     " + tagInfo)) {
                if (Tag == null) {
                    Log.e(TAG, str, tr);
                } else {
                    Log.e(TAG + "-" + Tag, str, tr);
                }
            }
            if (PRINT) {
                print(tagInfo + DispatchConstants.SIGN_SPLIT_SYMBOL + msg, tr);
            }
        }
    }

    private final void print(String msg, Throwable tr) {
        print(msg + "&Throwable:" + tr.getMessage());
    }
}
