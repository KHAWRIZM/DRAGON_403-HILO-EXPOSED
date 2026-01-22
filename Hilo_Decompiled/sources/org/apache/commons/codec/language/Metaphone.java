package org.apache.commons.codec.language;

import java.util.Locale;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class Metaphone implements StringEncoder {
    private static final String FRONTV = "EIY";
    private static final String VARSON = "CSPTG";
    private static final String VOWELS = "AEIOU";
    private int maxCodeLen = 4;

    private boolean isLastChar(int i, int i2) {
        return i2 + 1 == i;
    }

    private boolean isNextChar(StringBuilder sb2, int i, char c) {
        if (i < 0 || i >= sb2.length() - 1 || sb2.charAt(i + 1) != c) {
            return false;
        }
        return true;
    }

    private boolean isPreviousChar(StringBuilder sb2, int i, char c) {
        if (i <= 0 || i >= sb2.length() || sb2.charAt(i - 1) != c) {
            return false;
        }
        return true;
    }

    private boolean isVowel(StringBuilder sb2, int i) {
        if (VOWELS.indexOf(sb2.charAt(i)) >= 0) {
            return true;
        }
        return false;
    }

    private boolean regionMatch(StringBuilder sb2, int i, String str) {
        if (i >= 0 && (str.length() + i) - 1 < sb2.length()) {
            return sb2.substring(i, str.length() + i).equals(str);
        }
        return false;
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return metaphone((String) obj);
        }
        throw new EncoderException("Parameter supplied to Metaphone encode is not of type java.lang.String");
    }

    public int getMaxCodeLen() {
        return this.maxCodeLen;
    }

    public boolean isMetaphoneEqual(String str, String str2) {
        return metaphone(str).equals(metaphone(str2));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x028f, code lost:
    
        r5 = r5 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String metaphone(String str) {
        int length;
        if (str != null && (length = str.length()) != 0) {
            if (length == 1) {
                return str.toUpperCase(Locale.ENGLISH);
            }
            char[] charArray = str.toUpperCase(Locale.ENGLISH).toCharArray();
            StringBuilder sb2 = new StringBuilder(40);
            StringBuilder sb3 = new StringBuilder(10);
            int i = 0;
            char c = charArray[0];
            if (c != 'A') {
                if (c != 'G' && c != 'K' && c != 'P') {
                    if (c != 'W') {
                        if (c != 'X') {
                            sb2.append(charArray);
                        } else {
                            charArray[0] = 'S';
                            sb2.append(charArray);
                        }
                    } else {
                        char c2 = charArray[1];
                        if (c2 == 'R') {
                            sb2.append(charArray, 1, charArray.length - 1);
                        } else if (c2 == 'H') {
                            sb2.append(charArray, 1, charArray.length - 1);
                            sb2.setCharAt(0, 'W');
                        } else {
                            sb2.append(charArray);
                        }
                    }
                } else if (charArray[1] == 'N') {
                    sb2.append(charArray, 1, charArray.length - 1);
                } else {
                    sb2.append(charArray);
                }
            } else if (charArray[1] == 'E') {
                sb2.append(charArray, 1, charArray.length - 1);
            } else {
                sb2.append(charArray);
            }
            int length2 = sb2.length();
            while (sb3.length() < getMaxCodeLen() && i < length2) {
                char charAt = sb2.charAt(i);
                if (charAt != 'C' && isPreviousChar(sb2, i, charAt)) {
                    i++;
                } else {
                    switch (charAt) {
                        case 'A':
                        case 'E':
                        case 'I':
                        case 'O':
                        case 'U':
                            if (i == 0) {
                                sb3.append(charAt);
                                break;
                            }
                            break;
                        case 'B':
                            if (!isPreviousChar(sb2, i, 'M') || !isLastChar(length2, i)) {
                                sb3.append(charAt);
                                break;
                            }
                            break;
                        case 'C':
                            if (!isPreviousChar(sb2, i, 'S') || isLastChar(length2, i) || FRONTV.indexOf(sb2.charAt(i + 1)) < 0) {
                                if (regionMatch(sb2, i, "CIA")) {
                                    sb3.append('X');
                                    break;
                                } else if (!isLastChar(length2, i) && FRONTV.indexOf(sb2.charAt(i + 1)) >= 0) {
                                    sb3.append('S');
                                    break;
                                } else if (isPreviousChar(sb2, i, 'S') && isNextChar(sb2, i, 'H')) {
                                    sb3.append('K');
                                    break;
                                } else if (isNextChar(sb2, i, 'H')) {
                                    if (i == 0 && length2 >= 3 && isVowel(sb2, 2)) {
                                        sb3.append('K');
                                        break;
                                    } else {
                                        sb3.append('X');
                                        break;
                                    }
                                } else {
                                    sb3.append('K');
                                    break;
                                }
                            }
                            break;
                        case 'D':
                            if (!isLastChar(length2, i + 1) && isNextChar(sb2, i, 'G')) {
                                int i2 = i + 2;
                                if (FRONTV.indexOf(sb2.charAt(i2)) >= 0) {
                                    sb3.append('J');
                                    i = i2;
                                    break;
                                }
                            }
                            sb3.append('T');
                            break;
                        case 'F':
                        case 'J':
                        case 'L':
                        case 'M':
                        case 'N':
                        case 'R':
                            sb3.append(charAt);
                            break;
                        case 'G':
                            int i3 = i + 1;
                            if ((!isLastChar(length2, i3) || !isNextChar(sb2, i, 'H')) && ((isLastChar(length2, i3) || !isNextChar(sb2, i, 'H') || isVowel(sb2, i + 2)) && (i <= 0 || (!regionMatch(sb2, i, "GN") && !regionMatch(sb2, i, "GNED"))))) {
                                boolean isPreviousChar = isPreviousChar(sb2, i, 'G');
                                if (!isLastChar(length2, i) && FRONTV.indexOf(sb2.charAt(i3)) >= 0 && !isPreviousChar) {
                                    sb3.append('J');
                                    break;
                                } else {
                                    sb3.append('K');
                                    break;
                                }
                            }
                            break;
                        case 'H':
                            if (!isLastChar(length2, i) && ((i <= 0 || VARSON.indexOf(sb2.charAt(i - 1)) < 0) && isVowel(sb2, i + 1))) {
                                sb3.append('H');
                                break;
                            }
                            break;
                        case 'K':
                            if (i > 0) {
                                if (!isPreviousChar(sb2, i, 'C')) {
                                    sb3.append(charAt);
                                    break;
                                }
                            } else {
                                sb3.append(charAt);
                                break;
                            }
                            break;
                        case 'P':
                            if (isNextChar(sb2, i, 'H')) {
                                sb3.append('F');
                                break;
                            } else {
                                sb3.append(charAt);
                                break;
                            }
                        case 'Q':
                            sb3.append('K');
                            break;
                        case 'S':
                            if (!regionMatch(sb2, i, "SH") && !regionMatch(sb2, i, "SIO") && !regionMatch(sb2, i, "SIA")) {
                                sb3.append('S');
                                break;
                            } else {
                                sb3.append('X');
                                break;
                            }
                            break;
                        case 'T':
                            if (!regionMatch(sb2, i, "TIA") && !regionMatch(sb2, i, "TIO")) {
                                if (!regionMatch(sb2, i, "TCH")) {
                                    if (regionMatch(sb2, i, "TH")) {
                                        sb3.append('0');
                                        break;
                                    } else {
                                        sb3.append('T');
                                        break;
                                    }
                                }
                            } else {
                                sb3.append('X');
                                break;
                            }
                            break;
                        case 'V':
                            sb3.append('F');
                            break;
                        case 'W':
                        case 'Y':
                            if (!isLastChar(length2, i) && isVowel(sb2, i + 1)) {
                                sb3.append(charAt);
                                break;
                            }
                            break;
                        case 'X':
                            sb3.append('K');
                            sb3.append('S');
                            break;
                        case 'Z':
                            sb3.append('S');
                            break;
                    }
                }
                if (sb3.length() > getMaxCodeLen()) {
                    sb3.setLength(getMaxCodeLen());
                }
            }
            return sb3.toString();
        }
        return "";
    }

    public void setMaxCodeLen(int i) {
        this.maxCodeLen = i;
    }

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) {
        return metaphone(str);
    }
}
