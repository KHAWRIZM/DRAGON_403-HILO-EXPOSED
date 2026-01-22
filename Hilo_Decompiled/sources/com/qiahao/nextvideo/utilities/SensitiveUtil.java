package com.qiahao.nextvideo.utilities;

import com.google.gson.reflect.TypeToken;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.BaseApplication;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\u00020\t2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007J\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/qiahao/nextvideo/utilities/SensitiveUtil;", "", "<init>", "()V", "dataList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "saveData", "", "data", "getSensitiveList", "checkSensitive", "", "str", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSensitiveUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SensitiveUtil.kt\ncom/qiahao/nextvideo/utilities/SensitiveUtil\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,47:1\n1869#2,2:48\n*S KotlinDebug\n*F\n+ 1 SensitiveUtil.kt\ncom/qiahao/nextvideo/utilities/SensitiveUtil\n*L\n39#1:48,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SensitiveUtil {

    @NotNull
    public static final SensitiveUtil INSTANCE = new SensitiveUtil();

    @NotNull
    private static ArrayList<String> dataList = new ArrayList<>();

    private SensitiveUtil() {
    }

    public final boolean checkSensitive(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        for (String str2 : getSensitiveList()) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String lowerCase = str.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            Locale locale2 = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale2, "getDefault(...)");
            String lowerCase2 = str2.toLowerCase(locale2);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            if (StringsKt.contains$default(lowerCase, lowerCase2, false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final ArrayList<String> getSensitiveList() {
        ArrayList<String> arrayList = dataList;
        if (arrayList.isEmpty()) {
            String str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "SENSITIVE_WORD_LIST", "", (String) null, 4, (Object) null);
            try {
                dataList.addAll((ArrayList) BaseApplication.Companion.getGSON().k(str, new TypeToken<ArrayList<String>>() { // from class: com.qiahao.nextvideo.utilities.SensitiveUtil$getSensitiveList$1$type$1
                }.getType()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return dataList;
        }
        return arrayList;
    }

    public final void saveData(@NotNull ArrayList<String> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "SENSITIVE_WORD_LIST", BaseApplication.Companion.getGSON().s(data), (String) null, 4, (Object) null);
    }
}
