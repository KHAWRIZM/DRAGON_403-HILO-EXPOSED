package sf;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public enum a {
    SINGLE;

    private final byte[] a = {-1, -40, -1};

    a() {
    }

    private int e(byte[] bArr) {
        int i;
        boolean z;
        if (bArr == null) {
            return 0;
        }
        int i2 = 0;
        while (i2 + 3 < bArr.length) {
            int i3 = i2 + 1;
            if ((bArr[i2] & 255) == 255) {
                int i4 = bArr[i3] & 255;
                if (i4 != 255) {
                    i3 = i2 + 2;
                    if (i4 != 216 && i4 != 1) {
                        if (i4 != 217 && i4 != 218) {
                            int j = j(bArr, i3, 2, false);
                            if (j >= 2 && (i3 = i3 + j) <= bArr.length) {
                                if (i4 == 225 && j >= 8 && j(bArr, i2 + 4, 4, false) == 1165519206 && j(bArr, i2 + 8, 2, false) == 0) {
                                    i2 += 10;
                                    i = j - 8;
                                    break;
                                }
                            } else {
                                Log.e("Luban", "Invalid length");
                                return 0;
                            }
                        }
                    }
                }
                i2 = i3;
            }
            i2 = i3;
        }
        i = 0;
        if (i > 8) {
            int j2 = j(bArr, i2, 4, false);
            if (j2 != 1229531648 && j2 != 1296891946) {
                Log.e("Luban", "Invalid byte order");
                return 0;
            }
            if (j2 == 1229531648) {
                z = true;
            } else {
                z = false;
            }
            int j3 = j(bArr, i2 + 4, 4, z) + 2;
            if (j3 >= 10 && j3 <= i) {
                int i5 = i2 + j3;
                int i6 = i - j3;
                int j4 = j(bArr, i5 - 2, 2, z);
                while (true) {
                    int i7 = j4 - 1;
                    if (j4 <= 0 || i6 < 12) {
                        break;
                    }
                    if (j(bArr, i5, 2, z) == 274) {
                        int j5 = j(bArr, i5 + 8, 2, z);
                        if (j5 == 1) {
                            return 0;
                        }
                        if (j5 != 3) {
                            if (j5 != 6) {
                                if (j5 != 8) {
                                    Log.e("Luban", "Unsupported orientation");
                                    return 0;
                                }
                                return 270;
                            }
                            return 90;
                        }
                        return 180;
                    }
                    i5 += 12;
                    i6 -= 12;
                    j4 = i7;
                }
            } else {
                Log.e("Luban", "Invalid offset");
                return 0;
            }
        }
        Log.e("Luban", "Orientation not found");
        return 0;
    }

    public static boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("content://");
    }

    private boolean h(byte[] bArr) {
        if (bArr == null || bArr.length < 3) {
            return false;
        }
        return Arrays.equals(this.a, new byte[]{bArr[0], bArr[1], bArr[2]});
    }

    private int j(byte[] bArr, int i, int i2, boolean z) {
        int i3;
        if (z) {
            i += i2 - 1;
            i3 = -1;
        } else {
            i3 = 1;
        }
        int i4 = 0;
        while (true) {
            int i5 = i2 - 1;
            if (i2 > 0) {
                i4 = (bArr[i] & 255) | (i4 << 8);
                i += i3;
                i2 = i5;
            } else {
                return i4;
            }
        }
    }

    private byte[] k(InputStream inputStream) {
        if (inputStream == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                try {
                    int read = inputStream.read(bArr, 0, 4096);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        try {
                            break;
                        } catch (IOException unused) {
                        }
                    }
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException unused2) {
                    }
                    throw th;
                }
            } catch (Exception unused3) {
                byte[] bArr2 = new byte[0];
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused4) {
                }
                return bArr2;
            }
        }
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c(e eVar) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(eVar.open(), null, options);
            return options.outMimeType.replace("image/", ".");
        } catch (Exception unused) {
            return ".jpg";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d(InputStream inputStream) {
        return e(k(inputStream));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g(InputStream inputStream) {
        return h(k(inputStream));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i(int i, String str) {
        if (i <= 0) {
            return true;
        }
        File file = new File(str);
        if (file.exists() && file.length() > (i << 10)) {
            return true;
        }
        return false;
    }
}
