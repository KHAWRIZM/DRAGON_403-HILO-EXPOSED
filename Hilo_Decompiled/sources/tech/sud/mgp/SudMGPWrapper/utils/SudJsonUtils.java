package tech.sud.mgp.SudMGPWrapper.utils;

import com.google.gson.d;
import com.google.gson.e;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class SudJsonUtils {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static class InnerClass {
        public static d gson = new e().c().b();
    }

    public static <T> T fromJson(String str, Class<T> cls) {
        try {
            return (T) getGson().j(str, cls);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static d getGson() {
        return InnerClass.gson;
    }

    public static String toJson(Object obj) {
        return getGson().s(obj);
    }
}
