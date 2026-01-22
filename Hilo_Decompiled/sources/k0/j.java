package k0;

import java.lang.Character;
import java.util.Arrays;
import kotlin.KotlinVersion;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class j {
    public static String a(String str) {
        char[] copyOf;
        Character.UnicodeBlock of;
        char[] charArray = str.toCharArray();
        if (charArray.length <= 255) {
            copyOf = charArray;
        } else {
            copyOf = Arrays.copyOf(charArray, KotlinVersion.MAX_COMPONENT_VALUE);
        }
        if (charArray.length > 255) {
            for (int i10 = 252; i10 < 255; i10++) {
                copyOf[i10] = '.';
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c10 : copyOf) {
            if (!Character.isISOControl(c10) && (of = Character.UnicodeBlock.of(c10)) != null && of != Character.UnicodeBlock.SPECIALS) {
                sb.append(c10);
            } else {
                sb.append('?');
            }
        }
        return sb.toString();
    }
}
