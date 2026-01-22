package t6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class b implements r6.b {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f١٨١٣٠a = {"京", "津", "冀", "晋", "蒙", "辽", "吉", "黑", "沪", "苏", "浙", "皖", "闽", "赣", "鲁", "豫", "鄂", "湘", "粤", "桂", "琼", "渝", "川", "贵", "云", "藏", "陕", "甘", "青", "宁", "新"};

    @Override // r6.b
    public int a(Object obj) {
        if (obj == null) {
            return -1;
        }
        int length = f١٨١٣٠a.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (f١٨١٣٠a[i10].equals(obj.toString())) {
                return i10;
            }
        }
        return -1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0425, code lost:
    
        return r2;
     */
    @Override // r6.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List b(int i10) {
        char c10;
        ArrayList arrayList = new ArrayList();
        int i11 = i10;
        if (i11 == -1) {
            i11 = 0;
        }
        String str = (String) e().get(i11);
        str.hashCode();
        switch (str.hashCode()) {
            case 20113:
                if (str.equals("云")) {
                    c10 = 0;
                    break;
                }
                c10 = 65535;
                break;
            case 20140:
                if (str.equals("京")) {
                    c10 = 1;
                    break;
                }
                c10 = 65535;
                break;
            case 20864:
                if (str.equals("冀")) {
                    c10 = 2;
                    break;
                }
                c10 = 65535;
                break;
            case 21513:
                if (str.equals("吉")) {
                    c10 = 3;
                    break;
                }
                c10 = 65535;
                break;
            case 23425:
                if (str.equals("宁")) {
                    c10 = 4;
                    break;
                }
                c10 = 65535;
                break;
            case 24029:
                if (str.equals("川")) {
                    c10 = 5;
                    break;
                }
                c10 = 65535;
                break;
            case 26032:
                if (str.equals("新")) {
                    c10 = 6;
                    break;
                }
                c10 = 65535;
                break;
            case 26187:
                if (str.equals("晋")) {
                    c10 = 7;
                    break;
                }
                c10 = 65535;
                break;
            case 26690:
                if (str.equals("桂")) {
                    c10 = '\b';
                    break;
                }
                c10 = 65535;
                break;
            case 27818:
                if (str.equals("沪")) {
                    c10 = '\t';
                    break;
                }
                c10 = 65535;
                break;
            case 27941:
                if (str.equals("津")) {
                    c10 = '\n';
                    break;
                }
                c10 = 65535;
                break;
            case 27993:
                if (str.equals("浙")) {
                    c10 = 11;
                    break;
                }
                c10 = 65535;
                break;
            case 28189:
                if (str.equals("渝")) {
                    c10 = '\f';
                    break;
                }
                c10 = 65535;
                break;
            case 28248:
                if (str.equals("湘")) {
                    c10 = '\r';
                    break;
                }
                c10 = 65535;
                break;
            case 29756:
                if (str.equals("琼")) {
                    c10 = 14;
                    break;
                }
                c10 = 65535;
                break;
            case 29976:
                if (str.equals("甘")) {
                    c10 = 15;
                    break;
                }
                c10 = 65535;
                break;
            case 30358:
                if (str.equals("皖")) {
                    c10 = 16;
                    break;
                }
                c10 = 65535;
                break;
            case 31908:
                if (str.equals("粤")) {
                    c10 = 17;
                    break;
                }
                c10 = 65535;
                break;
            case 33487:
                if (str.equals("苏")) {
                    c10 = 18;
                    break;
                }
                c10 = 65535;
                break;
            case 33945:
                if (str.equals("蒙")) {
                    c10 = 19;
                    break;
                }
                c10 = 65535;
                break;
            case 34255:
                if (str.equals("藏")) {
                    c10 = 20;
                    break;
                }
                c10 = 65535;
                break;
            case 35947:
                if (str.equals("豫")) {
                    c10 = 21;
                    break;
                }
                c10 = 65535;
                break;
            case 36149:
                if (str.equals("贵")) {
                    c10 = 22;
                    break;
                }
                c10 = 65535;
                break;
            case 36195:
                if (str.equals("赣")) {
                    c10 = 23;
                    break;
                }
                c10 = 65535;
                break;
            case 36797:
                if (str.equals("辽")) {
                    c10 = 24;
                    break;
                }
                c10 = 65535;
                break;
            case 37122:
                if (str.equals("鄂")) {
                    c10 = 25;
                    break;
                }
                c10 = 65535;
                break;
            case 38397:
                if (str.equals("闽")) {
                    c10 = 26;
                    break;
                }
                c10 = 65535;
                break;
            case 38485:
                if (str.equals("陕")) {
                    c10 = 27;
                    break;
                }
                c10 = 65535;
                break;
            case 38738:
                if (str.equals("青")) {
                    c10 = 28;
                    break;
                }
                c10 = 65535;
                break;
            case 40065:
                if (str.equals("鲁")) {
                    c10 = 29;
                    break;
                }
                c10 = 65535;
                break;
            case 40657:
                if (str.equals("黑")) {
                    c10 = 30;
                    break;
                }
                c10 = 65535;
                break;
            default:
                c10 = 65535;
                break;
        }
        switch (c10) {
            case 0:
                arrayList.add("A-V");
                for (char c11 = 'A'; c11 <= 'S'; c11 = (char) (c11 + 1)) {
                    arrayList.add(String.valueOf(c11));
                }
                arrayList.remove("B");
                arrayList.remove("I");
                arrayList.remove("O");
                break;
            case 1:
                for (char c12 = 'A'; c12 <= 'M'; c12 = (char) (c12 + 1)) {
                    arrayList.add(String.valueOf(c12));
                }
                arrayList.remove("I");
                arrayList.add("Y");
                break;
            case 2:
                for (char c13 = 'A'; c13 <= 'H'; c13 = (char) (c13 + 1)) {
                    arrayList.add(String.valueOf(c13));
                }
                arrayList.add("J");
                arrayList.add("R");
                arrayList.add("S");
                arrayList.add("T");
                break;
            case 3:
            case 26:
                for (char c14 = 'A'; c14 <= 'K'; c14 = (char) (c14 + 1)) {
                    arrayList.add(String.valueOf(c14));
                }
                arrayList.remove("I");
                break;
            case 4:
            case 14:
                for (char c15 = 'A'; c15 <= 'E'; c15 = (char) (c15 + 1)) {
                    arrayList.add(String.valueOf(c15));
                }
                break;
            case 5:
                for (char c16 = 'A'; c16 <= 'Z'; c16 = (char) (c16 + 1)) {
                    arrayList.add(String.valueOf(c16));
                }
                arrayList.remove("G");
                arrayList.remove("I");
                arrayList.remove("O");
                break;
            case 6:
            case 30:
                for (char c17 = 'A'; c17 <= 'R'; c17 = (char) (c17 + 1)) {
                    arrayList.add(String.valueOf(c17));
                }
                arrayList.remove("I");
                arrayList.remove("O");
                break;
            case 7:
                for (char c18 = 'A'; c18 <= 'M'; c18 = (char) (c18 + 1)) {
                    arrayList.add(String.valueOf(c18));
                }
                arrayList.remove("G");
                arrayList.remove("I");
                break;
            case '\b':
                for (char c19 = 'A'; c19 <= 'P'; c19 = (char) (c19 + 1)) {
                    arrayList.add(String.valueOf(c19));
                }
                arrayList.remove("I");
                arrayList.remove("O");
                arrayList.add("R");
                break;
            case '\t':
                for (char c20 = 'A'; c20 <= 'D'; c20 = (char) (c20 + 1)) {
                    arrayList.add(String.valueOf(c20));
                }
                arrayList.add("R");
                break;
            case '\n':
            case 28:
                for (char c21 = 'A'; c21 <= 'H'; c21 = (char) (c21 + 1)) {
                    arrayList.add(String.valueOf(c21));
                }
                break;
            case 11:
                for (char c22 = 'A'; c22 <= 'L'; c22 = (char) (c22 + 1)) {
                    arrayList.add(String.valueOf(c22));
                }
                arrayList.remove("I");
                break;
            case '\f':
                for (char c23 = 'A'; c23 <= 'D'; c23 = (char) (c23 + 1)) {
                    arrayList.add(String.valueOf(c23));
                }
                arrayList.remove("D");
                arrayList.remove("E");
                break;
            case '\r':
                for (char c24 = 'A'; c24 <= 'N'; c24 = (char) (c24 + 1)) {
                    arrayList.add(String.valueOf(c24));
                }
                arrayList.remove("I");
                arrayList.remove("O");
                arrayList.add("U");
                break;
            case 15:
            case 24:
                for (char c25 = 'A'; c25 <= 'P'; c25 = (char) (c25 + 1)) {
                    arrayList.add(String.valueOf(c25));
                }
                arrayList.remove("I");
                arrayList.remove("O");
                break;
            case 16:
            case 25:
                for (char c26 = 'A'; c26 <= 'S'; c26 = (char) (c26 + 1)) {
                    arrayList.add(String.valueOf(c26));
                }
                arrayList.remove("I");
                arrayList.remove("O");
                break;
            case 17:
                for (char c27 = 'A'; c27 <= 'Z'; c27 = (char) (c27 + 1)) {
                    arrayList.add(String.valueOf(c27));
                }
                arrayList.remove("I");
                arrayList.remove("O");
                break;
            case 18:
                for (char c28 = 'A'; c28 <= 'N'; c28 = (char) (c28 + 1)) {
                    arrayList.add(String.valueOf(c28));
                }
                arrayList.remove("I");
                break;
            case 19:
            case 23:
                for (char c29 = 'A'; c29 <= 'M'; c29 = (char) (c29 + 1)) {
                    arrayList.add(String.valueOf(c29));
                }
                arrayList.remove("I");
                break;
            case 20:
            case 22:
                for (char c30 = 'A'; c30 <= 'J'; c30 = (char) (c30 + 1)) {
                    arrayList.add(String.valueOf(c30));
                }
                arrayList.remove("I");
                break;
            case 21:
                for (char c31 = 'A'; c31 <= 'U'; c31 = (char) (c31 + 1)) {
                    arrayList.add(String.valueOf(c31));
                }
                arrayList.remove("I");
                arrayList.remove("O");
                break;
            case 27:
                for (char c32 = 'A'; c32 <= 'K'; c32 = (char) (c32 + 1)) {
                    arrayList.add(String.valueOf(c32));
                }
                arrayList.remove("I");
                arrayList.add("V");
                break;
            case 29:
                for (char c33 = 'A'; c33 <= 'V'; c33 = (char) (c33 + 1)) {
                    arrayList.add(String.valueOf(c33));
                }
                arrayList.remove("I");
                arrayList.remove("O");
                arrayList.add("Y");
                break;
        }
    }

    @Override // r6.b
    public int c(int i10, Object obj) {
        if (obj == null) {
            return -1;
        }
        List b10 = b(i10);
        int size = b10.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (((String) b10.get(i11)).equals(obj.toString())) {
                return i11;
            }
        }
        return -1;
    }

    @Override // r6.b
    public int d(int i10, int i11, Object obj) {
        return 0;
    }

    @Override // r6.b
    public List e() {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, f١٨١٣٠a);
        return arrayList;
    }

    @Override // r6.b
    public boolean f() {
        return false;
    }

    @Override // r6.b
    public List g(int i10, int i11) {
        return new ArrayList();
    }

    @Override // r6.b
    public boolean h() {
        return true;
    }
}
