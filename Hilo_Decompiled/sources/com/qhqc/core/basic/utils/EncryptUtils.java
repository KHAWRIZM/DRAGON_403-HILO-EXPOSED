package com.qhqc.core.basic.utils;

import android.util.Base64;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0012\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006J\"\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/qhqc/core/basic/utils/EncryptUtils;", "", "()V", "HEX_DIGITS", "", "KEY_MAC", "", "getKEY_MAC", "()Ljava/lang/String;", "setKEY_MAC", "(Ljava/lang/String;)V", "aesDecryptWithNoPadding", "value", TransferTable.COLUMN_KEY, "keyHv", "aesEncryptWithNoPadding", "bytes2HexString", "bytes", "", "encryptHMAC", "content", "getMD5", "info", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nEncryptUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EncryptUtils.kt\ncom/qhqc/core/basic/utils/EncryptUtils\n+ 2 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n1#1,118:1\n108#2:119\n80#2,22:120\n108#2:142\n80#2,22:143\n*S KotlinDebug\n*F\n+ 1 EncryptUtils.kt\ncom/qhqc/core/basic/utils/EncryptUtils\n*L\n98#1:119\n98#1:120,22\n113#1:142\n113#1:143,22\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class EncryptUtils {

    @NotNull
    public static final EncryptUtils INSTANCE = new EncryptUtils();

    @NotNull
    private static String KEY_MAC = "";

    @NotNull
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private EncryptUtils() {
    }

    private final String bytes2HexString(byte[] bytes) {
        int length;
        if (bytes == null || (length = bytes.length) <= 0) {
            return null;
        }
        char[] cArr = new char[length << 1];
        int i10 = 0;
        for (byte b10 : bytes) {
            int i11 = i10 + 1;
            char[] cArr2 = HEX_DIGITS;
            cArr[i10] = cArr2[(b10 >> 4) & 15];
            i10 += 2;
            cArr[i11] = cArr2[b10 & 15];
        }
        return new String(cArr);
    }

    @Nullable
    public final String aesDecryptWithNoPadding(@Nullable String value, @NotNull String key, @NotNull String keyHv) {
        String str;
        int length;
        int i10;
        int i11;
        boolean z10;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(keyHv, "keyHv");
        if (value == null) {
            return null;
        }
        if (value.length() != 0) {
            try {
                Charset charset = Charsets.UTF_8;
                byte[] bytes = key.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
                Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
                byte[] bytes2 = keyHv.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
                cipher.init(2, secretKeySpec, new IvParameterSpec(bytes2));
                byte[] doFinal = cipher.doFinal(Base64.decode(value, 0));
                Intrinsics.checkNotNull(doFinal);
                str = new String(doFinal, charset);
                length = str.length() - 1;
                i10 = 0;
                boolean z11 = false;
                while (i10 <= length) {
                    if (!z11) {
                        i11 = i10;
                    } else {
                        i11 = length;
                    }
                    if (Intrinsics.compare((int) str.charAt(i11), 32) <= 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (!z11) {
                        if (!z10) {
                            z11 = true;
                        } else {
                            i10++;
                        }
                    } else {
                        if (!z10) {
                            break;
                        }
                        length--;
                    }
                }
            } catch (Exception unused) {
                return null;
            }
        }
        return str.subSequence(i10, length + 1).toString();
    }

    @Nullable
    public final String aesEncryptWithNoPadding(@Nullable String value, @NotNull String key, @NotNull String keyHv) {
        String str;
        int length;
        int i10;
        int i11;
        boolean z10;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(keyHv, "keyHv");
        if (value == null) {
            return null;
        }
        if (value.length() != 0) {
            try {
                Charset charset = Charsets.UTF_8;
                byte[] bytes = key.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
                Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
                byte[] bytes2 = keyHv.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
                cipher.init(1, secretKeySpec, new IvParameterSpec(bytes2));
                byte[] doFinal = cipher.doFinal(Base64.decode(value, 0));
                Intrinsics.checkNotNull(doFinal);
                str = new String(doFinal, charset);
                length = str.length() - 1;
                i10 = 0;
                boolean z11 = false;
                while (i10 <= length) {
                    if (!z11) {
                        i11 = i10;
                    } else {
                        i11 = length;
                    }
                    if (Intrinsics.compare((int) str.charAt(i11), 32) <= 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (!z11) {
                        if (!z10) {
                            z11 = true;
                        } else {
                            i10++;
                        }
                    } else {
                        if (!z10) {
                            break;
                        }
                        length--;
                    }
                }
            } catch (Exception unused) {
                return null;
            }
        }
        return str.subSequence(i10, length + 1).toString();
    }

    @NotNull
    public final String encryptHMAC(@Nullable String content) {
        if (content != null) {
            try {
                if (content.length() != 0) {
                    String str = KEY_MAC;
                    Charset charset = Charsets.UTF_8;
                    byte[] bytes = str.getBytes(charset);
                    Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                    SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "HmacMD5");
                    Mac mac = Mac.getInstance(secretKeySpec.getAlgorithm());
                    mac.init(secretKeySpec);
                    byte[] bytes2 = content.getBytes(charset);
                    Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
                    String bytes2HexString = bytes2HexString(mac.doFinal(bytes2));
                    if (bytes2HexString == null) {
                        bytes2HexString = "";
                    }
                    Locale ENGLISH = Locale.ENGLISH;
                    Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
                    String lowerCase = bytes2HexString.toLowerCase(ENGLISH);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    return lowerCase;
                }
            } catch (Exception unused) {
            }
        }
        return "";
    }

    @NotNull
    public final String getKEY_MAC() {
        return KEY_MAC;
    }

    @Nullable
    public final String getMD5(@Nullable String info) {
        StringBuffer stringBuffer;
        if (info == null) {
            return null;
        }
        if (info.length() != 0) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                Charset forName = Charset.forName("UTF-8");
                Intrinsics.checkNotNullExpressionValue(forName, "forName(...)");
                byte[] bytes = info.getBytes(forName);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                messageDigest.update(bytes);
                byte[] digest = messageDigest.digest();
                stringBuffer = new StringBuffer();
                int length = digest.length;
                for (int i10 = 0; i10 < length; i10++) {
                    if (Integer.toHexString(digest[i10] & UByte.MAX_VALUE).length() == 1) {
                        stringBuffer.append("0");
                        stringBuffer.append(Integer.toHexString(digest[i10] & UByte.MAX_VALUE));
                    } else {
                        stringBuffer.append(Integer.toHexString(digest[i10] & UByte.MAX_VALUE));
                    }
                }
            } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
                return null;
            }
        }
        return stringBuffer.toString();
    }

    public final void setKEY_MAC(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        KEY_MAC = str;
    }
}
