package tech.sud.logger;

import android.content.ClipData;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.android.agoo.message.MessageService;
import tech.sud.base.utils.UtilsBridge;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public abstract class Sudchar {
    public static String Suddo(int i, Object obj) {
        if (obj.getClass().isArray()) {
            if (obj instanceof Object[]) {
                return Arrays.deepToString((Object[]) obj);
            }
            if (obj instanceof boolean[]) {
                return Arrays.toString((boolean[]) obj);
            }
            if (obj instanceof byte[]) {
                return Arrays.toString((byte[]) obj);
            }
            if (obj instanceof char[]) {
                return Arrays.toString((char[]) obj);
            }
            if (obj instanceof double[]) {
                return Arrays.toString((double[]) obj);
            }
            if (obj instanceof float[]) {
                return Arrays.toString((float[]) obj);
            }
            if (obj instanceof int[]) {
                return Arrays.toString((int[]) obj);
            }
            if (obj instanceof long[]) {
                return Arrays.toString((long[]) obj);
            }
            if (obj instanceof short[]) {
                return Arrays.toString((short[]) obj);
            }
            throw new IllegalArgumentException("Array has incompatible type: " + obj.getClass());
        }
        if (obj instanceof Throwable) {
            return UtilsBridge.getFullStackTrace((Throwable) obj);
        }
        if (obj instanceof Bundle) {
            return Suddo((Bundle) obj);
        }
        if (obj instanceof Intent) {
            return Suddo((Intent) obj);
        }
        if (i == 32) {
            if (obj instanceof CharSequence) {
                return UtilsBridge.formatJson(obj.toString());
            }
            try {
                return obj.toString();
            } catch (Throwable unused) {
                return obj.toString();
            }
        }
        if (i == 48) {
            String obj2 = obj.toString();
            try {
                StreamSource streamSource = new StreamSource(new StringReader(obj2));
                StreamResult streamResult = new StreamResult(new StringWriter());
                Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
                newTransformer.setOutputProperty("indent", "yes");
                newTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", MessageService.MSG_DB_NOTIFY_CLICK);
                newTransformer.transform(streamSource, streamResult);
                return streamResult.getWriter().toString().replaceFirst(">", ">" + LogUtils.LINE_SEP);
            } catch (Exception e) {
                e.printStackTrace();
                return obj2;
            }
        }
        return obj.toString();
    }

    public static String Suddo(Bundle bundle) {
        Iterator<String> it = bundle.keySet().iterator();
        if (!it.hasNext()) {
            return "Bundle {}";
        }
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("Bundle { ");
        while (true) {
            String next = it.next();
            Object obj = bundle.get(next);
            sb2.append(next);
            sb2.append('=');
            if (obj instanceof Bundle) {
                sb2.append(obj == bundle ? "(this Bundle)" : Suddo((Bundle) obj));
            } else {
                sb2.append(LogUtils.Suddo(obj));
            }
            if (!it.hasNext()) {
                sb2.append(" }");
                return sb2.toString();
            }
            sb2.append(", ");
        }
    }

    public static String Suddo(Intent intent) {
        boolean z;
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("Intent { ");
        String action = intent.getAction();
        boolean z2 = false;
        boolean z3 = true;
        if (action != null) {
            sb2.append("act=");
            sb2.append(action);
            z = false;
        } else {
            z = true;
        }
        Set<String> categories = intent.getCategories();
        if (categories != null) {
            if (!z) {
                sb2.append(' ');
            }
            sb2.append("cat=[");
            for (String str : categories) {
                if (!z3) {
                    sb2.append(',');
                }
                sb2.append(str);
                z3 = false;
            }
            sb2.append("]");
            z = false;
        }
        Uri data = intent.getData();
        if (data != null) {
            if (!z) {
                sb2.append(' ');
            }
            sb2.append("dat=");
            sb2.append(data);
            z = false;
        }
        String type = intent.getType();
        if (type != null) {
            if (!z) {
                sb2.append(' ');
            }
            sb2.append("typ=");
            sb2.append(type);
            z = false;
        }
        int flags = intent.getFlags();
        if (flags != 0) {
            if (!z) {
                sb2.append(' ');
            }
            sb2.append("flg=0x");
            sb2.append(Integer.toHexString(flags));
            z = false;
        }
        String str2 = intent.getPackage();
        if (str2 != null) {
            if (!z) {
                sb2.append(' ');
            }
            sb2.append("pkg=");
            sb2.append(str2);
            z = false;
        }
        ComponentName component = intent.getComponent();
        if (component != null) {
            if (!z) {
                sb2.append(' ');
            }
            sb2.append("cmp=");
            sb2.append(component.flattenToShortString());
            z = false;
        }
        Rect sourceBounds = intent.getSourceBounds();
        if (sourceBounds != null) {
            if (!z) {
                sb2.append(' ');
            }
            sb2.append("bnds=");
            sb2.append(sourceBounds.toShortString());
            z = false;
        }
        ClipData clipData = intent.getClipData();
        if (clipData != null) {
            if (!z) {
                sb2.append(' ');
            }
            ClipData.Item itemAt = clipData.getItemAt(0);
            if (itemAt == null) {
                sb2.append("ClipData.Item {}");
            } else {
                sb2.append("ClipData.Item { ");
                String htmlText = itemAt.getHtmlText();
                if (htmlText != null) {
                    sb2.append("H:");
                    sb2.append(htmlText);
                    sb2.append("}");
                } else {
                    CharSequence text = itemAt.getText();
                    if (text != null) {
                        sb2.append("T:");
                        sb2.append(text);
                        sb2.append("}");
                    } else {
                        Uri uri = itemAt.getUri();
                        if (uri != null) {
                            sb2.append("U:");
                            sb2.append(uri);
                            sb2.append("}");
                        } else {
                            Intent intent2 = itemAt.getIntent();
                            if (intent2 != null) {
                                sb2.append("I:");
                                sb2.append(Suddo(intent2));
                                sb2.append("}");
                            } else {
                                sb2.append("NULL}");
                            }
                        }
                    }
                }
            }
            z = false;
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            if (!z) {
                sb2.append(' ');
            }
            sb2.append("extras={");
            sb2.append(Suddo(extras));
            sb2.append('}');
        } else {
            z2 = z;
        }
        Intent selector = intent.getSelector();
        if (selector != null) {
            if (!z2) {
                sb2.append(' ');
            }
            sb2.append("sel={");
            sb2.append(selector == intent ? "(this Intent)" : Suddo(selector));
            sb2.append("}");
        }
        sb2.append(" }");
        return sb2.toString();
    }
}
