package com.qiahao.nextvideo.utilities;

import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import com.qiahao.base_common.utils.RxJava;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.HiloApplication;
import com.qiahao.nextvideo.data.service.AliCloudService;
import com.taobao.accs.utl.BaseMonitor;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002¨\u0006\r"}, d2 = {"Lcom/qiahao/nextvideo/utilities/ClientLogUtils;", "", "<init>", "()V", "loginException", "", BaseMonitor.COUNT_ERROR, "", "getTimeFormat", AgooConstants.MESSAGE_TIME, "", "format", "getPublicIpAddressInfo", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nClientLogUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClientLogUtils.kt\ncom/qiahao/nextvideo/utilities/ClientLogUtils\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,138:1\n13472#2:139\n13473#2:142\n1869#3,2:140\n*S KotlinDebug\n*F\n+ 1 ClientLogUtils.kt\ncom/qiahao/nextvideo/utilities/ClientLogUtils\n*L\n61#1:139\n61#1:142\n64#1:140,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ClientLogUtils {

    @NotNull
    public static final ClientLogUtils INSTANCE = new ClientLogUtils();

    private ClientLogUtils() {
    }

    private final String getPublicIpAddressInfo() {
        try {
            ResponseBody body = new OkHttpClient.Builder().connectTimeout(10000L, TimeUnit.MILLISECONDS).build().newCall(new Request.Builder().url("https://ifconfig.me/all").build()).execute().body();
            if (body != null) {
                String string = body.string();
                if (string != null) {
                    return string;
                }
            }
            return "not Available";
        } catch (Exception e) {
            String message = e.getMessage();
            if (message == null) {
                return "not Available";
            }
            return message;
        }
    }

    private final String getTimeFormat(long time, String format) {
        try {
            String format2 = new SimpleDateFormat(format, Locale.getDefault()).format(Long.valueOf(new Date(time).getTime()));
            Intrinsics.checkNotNull(format2);
            return format2;
        } catch (NumberFormatException unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loginException$lambda$7(String str, final io.reactivex.rxjava3.core.b0 b0Var) {
        ConnectivityManager connectivityManager;
        BufferedWriter bufferedWriter;
        NetworkInfo activeNetworkInfo;
        LinkProperties linkProperties;
        List<InetAddress> dnsServers;
        Intrinsics.checkNotNullParameter(b0Var, "emitter");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("error info: " + str + " \n\n");
        ClientLogUtils clientLogUtils = INSTANCE;
        sb2.append("log Time:" + clientLogUtils.getTimeFormat(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss") + "\n\n");
        sb2.append("timestamp:" + System.currentTimeMillis() + "\n\n");
        sb2.append("Device Info: \n " + Build.MODEL + " \n System Version:" + Build.VERSION.RELEASE + "\n\n");
        sb2.append("App Version:4.41.0(503)\n\n\n");
        sb2.append("----Public IP Address Info----\n\n");
        sb2.append(clientLogUtils.getPublicIpAddressInfo() + "\n\n");
        sb2.append("-------\n\n");
        Object systemService = HiloApplication.INSTANCE.getCONTEXT().getSystemService("connectivity");
        BufferedWriter bufferedWriter2 = null;
        if (systemService instanceof ConnectivityManager) {
            connectivityManager = (ConnectivityManager) systemService;
        } else {
            connectivityManager = null;
        }
        if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
            sb2.append("Local DNS Address:\n");
            Network[] allNetworks = connectivityManager.getAllNetworks();
            Intrinsics.checkNotNullExpressionValue(allNetworks, "getAllNetworks(...)");
            for (Network network : allNetworks) {
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(network);
                if (networkInfo != null && networkInfo.getType() == activeNetworkInfo.getType() && (linkProperties = connectivityManager.getLinkProperties(network)) != null && (dnsServers = linkProperties.getDnsServers()) != null) {
                    for (InetAddress inetAddress : dnsServers) {
                        sb2.append(inetAddress.getHostName());
                        sb2.append("\n");
                        sb2.append(inetAddress.getCanonicalHostName());
                        sb2.append("\n");
                        sb2.append(inetAddress.getHostAddress());
                        sb2.append("\n");
                    }
                }
            }
        }
        File file = new File(HiloApplication.INSTANCE.getCONTEXT().getCacheDir() + "/log/loginE/e-" + System.currentTimeMillis() + ".log");
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            file.createNewFile();
        }
        try {
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            bufferedWriter.write(sb2.toString());
            bufferedWriter.write("\r\n");
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception e2) {
            e = e2;
            bufferedWriter2 = bufferedWriter;
            e.printStackTrace();
            if (bufferedWriter2 != null) {
                bufferedWriter2.flush();
            }
            if (bufferedWriter2 != null) {
                bufferedWriter2.close();
            }
            RxUtilsKt.observeOnMainThread$default(AliCloudService.INSTANCE.getShared().uploadOperationFileToAWS(AliCloudService.OSS_FOLDER_CLIENT_LOG_LOGIN_E, file, "login"), new Function1() { // from class: com.qiahao.nextvideo.utilities.h0
                public final Object invoke(Object obj) {
                    Unit loginException$lambda$7$lambda$5;
                    loginException$lambda$7$lambda$5 = ClientLogUtils.loginException$lambda$7$lambda$5(b0Var, (Pair) obj);
                    return loginException$lambda$7$lambda$5;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.utilities.i0
                public final Object invoke(Object obj) {
                    Unit loginException$lambda$7$lambda$6;
                    loginException$lambda$7$lambda$6 = ClientLogUtils.loginException$lambda$7$lambda$6(b0Var, (Throwable) obj);
                    return loginException$lambda$7$lambda$6;
                }
            }, (Function0) null, false, 12, (Object) null);
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter2 = bufferedWriter;
            if (bufferedWriter2 != null) {
                bufferedWriter2.flush();
            }
            if (bufferedWriter2 != null) {
                bufferedWriter2.close();
            }
            throw th;
        }
        RxUtilsKt.observeOnMainThread$default(AliCloudService.INSTANCE.getShared().uploadOperationFileToAWS(AliCloudService.OSS_FOLDER_CLIENT_LOG_LOGIN_E, file, "login"), new Function1() { // from class: com.qiahao.nextvideo.utilities.h0
            public final Object invoke(Object obj) {
                Unit loginException$lambda$7$lambda$5;
                loginException$lambda$7$lambda$5 = ClientLogUtils.loginException$lambda$7$lambda$5(b0Var, (Pair) obj);
                return loginException$lambda$7$lambda$5;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.utilities.i0
            public final Object invoke(Object obj) {
                Unit loginException$lambda$7$lambda$6;
                loginException$lambda$7$lambda$6 = ClientLogUtils.loginException$lambda$7$lambda$6(b0Var, (Throwable) obj);
                return loginException$lambda$7$lambda$6;
            }
        }, (Function0) null, false, 12, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit loginException$lambda$7$lambda$5(io.reactivex.rxjava3.core.b0 b0Var, Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "it");
        if (!b0Var.isDisposed()) {
            b0Var.onNext("");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit loginException$lambda$7$lambda$6(io.reactivex.rxjava3.core.b0 b0Var, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (!b0Var.isDisposed()) {
            b0Var.onNext("");
        }
        return Unit.INSTANCE;
    }

    public final void loginException(@NotNull final String error) {
        Intrinsics.checkNotNullParameter(error, BaseMonitor.COUNT_ERROR);
        RxJava.INSTANCE.rx(new io.reactivex.rxjava3.core.c0() { // from class: com.qiahao.nextvideo.utilities.g0
            public final void a(io.reactivex.rxjava3.core.b0 b0Var) {
                ClientLogUtils.loginException$lambda$7(error, b0Var);
            }
        }, new pd.g() { // from class: com.qiahao.nextvideo.utilities.ClientLogUtils$loginException$2
            public final void accept(String str) {
                Intrinsics.checkNotNullParameter(str, "it");
            }
        });
    }
}
