package com.qiahao.nextvideo;

import com.qiahao.nextvideo.utilities.userproxy.UserProxyUtility;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.full.KClasses;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/qiahao/nextvideo/ReflectUnitTest;", "", "<init>", "()V", "testUserProxyReflection", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ReflectUnitTest {
    public final void testUserProxyReflection() {
        Collection staticFunctions;
        Object obj;
        KClass<?> kClass = UserProxyUtility.INSTANCE.getMessageKClassMap().get(1);
        if (kClass != null && (staticFunctions = KClasses.getStaticFunctions(kClass)) != null) {
            Iterator it = staticFunctions.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    KFunction kFunction = (KFunction) obj;
                    if (kFunction.getParameters().size() == 1 && StringsKt.contains(String.valueOf(((KParameter) CollectionsKt.first(kFunction.getParameters())).getType()), "bytearray", true)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            KFunction kFunction2 = (KFunction) obj;
            if (kFunction2 != null) {
                kFunction2.call(new Object[]{new byte[20]});
            }
        }
    }
}
