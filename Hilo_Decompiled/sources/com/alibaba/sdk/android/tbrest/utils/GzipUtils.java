package com.alibaba.sdk.android.tbrest.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class GzipUtils {
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x002a -> B:15:0x0050). Please report as a decompilation issue!!! */
    public static byte[] gzip(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream;
        if (bArr != null && bArr.length != 0) {
            byte[] bArr2 = null;
            bArr2 = null;
            bArr2 = null;
            r0 = null;
            GZIPOutputStream gZIPOutputStream2 = null;
            try {
                try {
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream, bArr.length);
                            try {
                                gZIPOutputStream.write(bArr);
                                gZIPOutputStream.finish();
                                bArr2 = byteArrayOutputStream.toByteArray();
                                try {
                                    gZIPOutputStream.close();
                                } catch (IOException e10) {
                                    e10.printStackTrace();
                                }
                                byteArrayOutputStream.close();
                            } catch (Exception e11) {
                                e = e11;
                                e.printStackTrace();
                                if (gZIPOutputStream != null) {
                                    try {
                                        gZIPOutputStream.close();
                                    } catch (IOException e12) {
                                        e12.printStackTrace();
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                return bArr2;
                            }
                        } catch (Exception e13) {
                            e = e13;
                            gZIPOutputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            if (gZIPOutputStream2 != null) {
                                try {
                                    gZIPOutputStream2.close();
                                } catch (IOException e14) {
                                    e14.printStackTrace();
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                    throw th;
                                } catch (IOException e15) {
                                    e15.printStackTrace();
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                } catch (Exception e17) {
                    e = e17;
                    byteArrayOutputStream = null;
                    gZIPOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = null;
                }
                return bArr2;
            } catch (Throwable th3) {
                th = th3;
                gZIPOutputStream2 = gZIPOutputStream;
            }
        } else {
            return bArr;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:1|2|3|4|(3:6|7|8)|9|11|12|13|14|15|(1:(0))) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] gzipAndRc4Bytes(String str) {
        GZIPOutputStream gZIPOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream2 = null;
        GZIPOutputStream gZIPOutputStream3 = null;
        try {
            try {
                try {
                    gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e10) {
                e = e10;
            }
        } catch (Exception unused) {
        }
        try {
            ?? r12 = "UTF-8";
            gZIPOutputStream.write(str.getBytes("UTF-8"));
            gZIPOutputStream.flush();
            gZIPOutputStream.close();
            gZIPOutputStream2 = r12;
        } catch (IOException e11) {
            e = e11;
            gZIPOutputStream3 = gZIPOutputStream;
            e.printStackTrace();
            gZIPOutputStream2 = gZIPOutputStream3;
            if (gZIPOutputStream3 != null) {
                gZIPOutputStream3.close();
                gZIPOutputStream2 = gZIPOutputStream3;
            }
            byte[] rc4 = RC4.rc4(byteArrayOutputStream.toByteArray());
            byteArrayOutputStream.close();
            return rc4;
        } catch (Throwable th2) {
            th = th2;
            gZIPOutputStream2 = gZIPOutputStream;
            if (gZIPOutputStream2 != null) {
                try {
                    gZIPOutputStream2.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
        byte[] rc42 = RC4.rc4(byteArrayOutputStream.toByteArray());
        byteArrayOutputStream.close();
        return rc42;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0086 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x007c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:87:0x0041 -> B:22:0x0079). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] unGzip(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPInputStream gZIPInputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        GZIPInputStream gZIPInputStream2;
        byte[] bArr2 = null;
        try {
            try {
                try {
                    byteArrayInputStream = new ByteArrayInputStream(bArr);
                } catch (Throwable th) {
                    th = th;
                    gZIPInputStream2 = bArr;
                }
                try {
                    GZIPInputStream gZIPInputStream3 = new GZIPInputStream(byteArrayInputStream);
                    try {
                        byte[] bArr3 = new byte[1024];
                        byteArrayOutputStream2 = new ByteArrayOutputStream();
                        while (true) {
                            try {
                                int read = gZIPInputStream3.read(bArr3, 0, 1024);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream2.write(bArr3, 0, read);
                            } catch (Exception e10) {
                                e = e10;
                                gZIPInputStream = gZIPInputStream3;
                                e.printStackTrace();
                                if (byteArrayOutputStream2 != null) {
                                    try {
                                        byteArrayOutputStream2.close();
                                    } catch (Exception e11) {
                                        e11.printStackTrace();
                                    }
                                }
                                if (gZIPInputStream != null) {
                                    try {
                                        gZIPInputStream.close();
                                    } catch (IOException e12) {
                                        e12.printStackTrace();
                                    }
                                }
                                if (byteArrayInputStream != null) {
                                    byteArrayInputStream.close();
                                }
                                return bArr2;
                            }
                        }
                        byteArrayOutputStream2.flush();
                        bArr2 = byteArrayOutputStream2.toByteArray();
                        try {
                            byteArrayOutputStream2.close();
                        } catch (Exception e13) {
                            e13.printStackTrace();
                        }
                        try {
                            gZIPInputStream3.close();
                        } catch (IOException e14) {
                            e14.printStackTrace();
                        }
                        byteArrayInputStream.close();
                    } catch (Exception e15) {
                        e = e15;
                        byteArrayOutputStream2 = null;
                        gZIPInputStream = gZIPInputStream3;
                    } catch (Throwable th2) {
                        byteArrayOutputStream = null;
                        th = th2;
                        gZIPInputStream2 = gZIPInputStream3;
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e16) {
                                e16.printStackTrace();
                            }
                        }
                        if (gZIPInputStream2 != 0) {
                            try {
                                gZIPInputStream2.close();
                            } catch (IOException e17) {
                                e17.printStackTrace();
                            }
                        }
                        if (byteArrayInputStream == null) {
                            try {
                                byteArrayInputStream.close();
                                throw th;
                            } catch (IOException e18) {
                                e18.printStackTrace();
                                throw th;
                            }
                        }
                        throw th;
                    }
                } catch (Exception e19) {
                    e = e19;
                    gZIPInputStream = null;
                    byteArrayOutputStream2 = null;
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream = null;
                    th = th;
                    gZIPInputStream2 = byteArrayOutputStream;
                    if (byteArrayOutputStream != null) {
                    }
                    if (gZIPInputStream2 != 0) {
                    }
                    if (byteArrayInputStream == null) {
                    }
                }
            } catch (Exception e20) {
                e = e20;
                gZIPInputStream = null;
                byteArrayInputStream = null;
                byteArrayOutputStream2 = null;
            } catch (Throwable th4) {
                th = th4;
                byteArrayInputStream = null;
                byteArrayOutputStream = null;
            }
        } catch (IOException e21) {
            e21.printStackTrace();
        }
        return bArr2;
    }
}
