package com.qiahao.base_common.utils.image;

import com.luck.picture.lib.config.PictureMimeType;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0006J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002R\u001c\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00060\bj\b\u0012\u0004\u0012\u00020\u0006`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/qiahao/base_common/utils/image/ImageTypeUtils;", "", "<init>", "()V", "mFileTypes", "Ljava/util/HashMap;", "", "imageType", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "checkImageType", "", "filePath", "getFileType", "getFileHeader", "bytesToHexString", "src", "", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nImageTypeUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImageTypeUtils.kt\ncom/qiahao/base_common/utils/image/ImageTypeUtils\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,99:1\n1869#2,2:100\n*S KotlinDebug\n*F\n+ 1 ImageTypeUtils.kt\ncom/qiahao/base_common/utils/image/ImageTypeUtils\n*L\n33#1:100,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ImageTypeUtils {

    @NotNull
    public static final ImageTypeUtils INSTANCE = new ImageTypeUtils();

    @NotNull
    private static final ArrayList<String> imageType;

    @NotNull
    private static final HashMap<String, String> mFileTypes;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("FFD8FF", PictureMimeType.JPG);
        hashMap.put("89504E47", ".png");
        hashMap.put("47494638", ".gif");
        hashMap.put("49492A00", ".tif");
        hashMap.put("424D", PictureMimeType.BMP);
        mFileTypes = hashMap;
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(PictureMimeType.JPG);
        arrayList.add(".png");
        arrayList.add(".gif");
        arrayList.add(PictureMimeType.JPEG);
        arrayList.add(".tif");
        arrayList.add(PictureMimeType.BMP);
        imageType = arrayList;
    }

    private ImageTypeUtils() {
    }

    private final String bytesToHexString(byte[] src) {
        StringBuilder sb = new StringBuilder();
        if (src != null && src.length != 0) {
            for (byte b10 : src) {
                String hexString = Integer.toHexString(Util.and(b10, KotlinVersion.MAX_COMPONENT_VALUE));
                Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(...)");
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                String upperCase = hexString.toUpperCase(locale);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                if (upperCase.length() < 2) {
                    sb.append(0);
                }
                sb.append(upperCase);
            }
            return sb.toString();
        }
        return null;
    }

    private final String getFileHeader(String filePath) {
        FileInputStream fileInputStream;
        String str = null;
        str = null;
        str = null;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(filePath);
            } catch (IOException unused) {
            }
        } catch (Exception unused2) {
            fileInputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[3];
            fileInputStream.read(bArr, 0, 3);
            str = bytesToHexString(bArr);
            fileInputStream.close();
        } catch (Exception unused3) {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return str;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
        return str;
    }

    public final boolean checkImageType(@Nullable String filePath) {
        boolean z10 = false;
        for (String str : imageType) {
            if (filePath != null && StringsKt.contains$default((CharSequence) filePath, (CharSequence) str, false, 2, (Object) null)) {
                z10 = true;
            }
        }
        return z10;
    }

    @NotNull
    public final String getFileType(@Nullable String filePath) {
        String str = mFileTypes.get(getFileHeader(filePath));
        if (str == null) {
            return PictureMimeType.JPG;
        }
        return str;
    }
}
