package com.google.protobuf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class f2 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f١١٠٠٥a;

        a(h hVar) {
            this.f١١٠٠٥a = hVar;
        }

        @Override // com.google.protobuf.f2.c
        public byte a(int i10) {
            return this.f١١٠٠٥a.f(i10);
        }

        @Override // com.google.protobuf.f2.c
        public int size() {
            return this.f١١٠٠٥a.size();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class b implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ byte[] f١١٠٠٦a;

        b(byte[] bArr) {
            this.f١١٠٠٦a = bArr;
        }

        @Override // com.google.protobuf.f2.c
        public byte a(int i10) {
            return this.f١١٠٠٦a[i10];
        }

        @Override // com.google.protobuf.f2.c
        public int size() {
            return this.f١١٠٠٦a.length;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface c {
        byte a(int i10);

        int size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(h hVar) {
        return b(new a(hVar));
    }

    static String b(c cVar) {
        StringBuilder sb = new StringBuilder(cVar.size());
        for (int i10 = 0; i10 < cVar.size(); i10++) {
            byte a10 = cVar.a(i10);
            if (a10 != 34) {
                if (a10 != 39) {
                    if (a10 != 92) {
                        switch (a10) {
                            case 7:
                                sb.append("\\a");
                                break;
                            case 8:
                                sb.append("\\b");
                                break;
                            case 9:
                                sb.append("\\t");
                                break;
                            case 10:
                                sb.append("\\n");
                                break;
                            case 11:
                                sb.append("\\v");
                                break;
                            case 12:
                                sb.append("\\f");
                                break;
                            case 13:
                                sb.append("\\r");
                                break;
                            default:
                                if (a10 >= 32 && a10 <= 126) {
                                    sb.append((char) a10);
                                    break;
                                } else {
                                    sb.append('\\');
                                    sb.append((char) (((a10 >>> 6) & 3) + 48));
                                    sb.append((char) (((a10 >>> 3) & 7) + 48));
                                    sb.append((char) ((a10 & 7) + 48));
                                    break;
                                }
                                break;
                        }
                    } else {
                        sb.append("\\\\");
                    }
                } else {
                    sb.append("\\'");
                }
            } else {
                sb.append("\\\"");
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(byte[] bArr) {
        return b(new b(bArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String d(String str) {
        return str.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String e(String str) {
        return a(h.o(str));
    }
}
