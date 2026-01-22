package tech.sud.mgp.SudMGPWrapper.utils;

import android.text.TextUtils;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import java.util.List;
import tech.sud.mgp.SudMGPWrapper.state.SudMGPMGState;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class GameCommonStateUtils {
    private static String i18nPrecise(String str, SudMGPMGState.MGCommonPublicMessage.MGCommonPublicMessageMsgText mGCommonPublicMessageMsgText) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 93023594:
                if (str.equals("ar-SA")) {
                    c = 0;
                    break;
                }
                break;
            case 96598143:
                if (str.equals("en-GB")) {
                    c = 1;
                    break;
                }
                break;
            case 96598594:
                if (str.equals("en-US")) {
                    c = 2;
                    break;
                }
                break;
            case 96747053:
                if (str.equals("es-ES")) {
                    c = 3;
                    break;
                }
                break;
            case 99994381:
                if (str.equals("id-ID")) {
                    c = 4;
                    break;
                }
                break;
            case 100828572:
                if (str.equals("ja-JP")) {
                    c = 5;
                    break;
                }
                break;
            case 102169200:
                if (str.equals("ko-KR")) {
                    c = 6;
                    break;
                }
                break;
            case 104135123:
                if (str.equals("ms-BN")) {
                    c = 7;
                    break;
                }
                break;
            case 104135475:
                if (str.equals("ms-MY")) {
                    c = '\b';
                    break;
                }
                break;
            case 110272621:
                if (str.equals("th-TH")) {
                    c = '\t';
                    break;
                }
                break;
            case 110570541:
                if (str.equals("tr-TR")) {
                    c = '\n';
                    break;
                }
                break;
            case 111493931:
                if (str.equals("ur-PK")) {
                    c = 11;
                    break;
                }
                break;
            case 112149522:
                if (str.equals("vi-VN")) {
                    c = '\f';
                    break;
                }
                break;
            case 115813226:
                if (str.equals("zh-CN")) {
                    c = '\r';
                    break;
                }
                break;
            case 115813378:
                if (str.equals("zh-HK")) {
                    c = 14;
                    break;
                }
                break;
            case 115813537:
                if (str.equals("zh-MO")) {
                    c = 15;
                    break;
                }
                break;
            case 115813715:
                if (str.equals("zh-SG")) {
                    c = 16;
                    break;
                }
                break;
            case 115813762:
                if (str.equals("zh-TW")) {
                    c = 17;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return mGCommonPublicMessageMsgText.ar_SA;
            case 1:
                return mGCommonPublicMessageMsgText.en_GB;
            case 2:
                return mGCommonPublicMessageMsgText.en_US;
            case 3:
                return mGCommonPublicMessageMsgText.es_ES;
            case 4:
                return mGCommonPublicMessageMsgText.id_ID;
            case 5:
                return mGCommonPublicMessageMsgText.ja_JP;
            case 6:
                return mGCommonPublicMessageMsgText.ko_KR;
            case 7:
                return mGCommonPublicMessageMsgText.ms_BN;
            case '\b':
                return mGCommonPublicMessageMsgText.ms_MY;
            case '\t':
                return mGCommonPublicMessageMsgText.th_TH;
            case '\n':
                return mGCommonPublicMessageMsgText.tr_TR;
            case 11:
                return mGCommonPublicMessageMsgText.ur_PK;
            case '\f':
                return mGCommonPublicMessageMsgText.vi_VN;
            case '\r':
                return mGCommonPublicMessageMsgText.zh_CN;
            case 14:
                return mGCommonPublicMessageMsgText.zh_HK;
            case 15:
                return mGCommonPublicMessageMsgText.zh_MO;
            case 16:
                return mGCommonPublicMessageMsgText.zh_SG;
            case 17:
                return mGCommonPublicMessageMsgText.zh_TW;
            default:
                return null;
        }
    }

    private static boolean isMatchLanguage(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        if (!str2.equals(str)) {
            if (!str.startsWith(str2 + "-")) {
                return false;
            }
        }
        return true;
    }

    public static String parseI18nText(String str, SudMGPMGState.MGCommonPublicMessage.MGCommonPublicMessageMsgText mGCommonPublicMessageMsgText) {
        if (mGCommonPublicMessageMsgText == null) {
            return null;
        }
        if (str == null) {
            return mGCommonPublicMessageMsgText.defaultStr;
        }
        String i18nPrecise = i18nPrecise(str, mGCommonPublicMessageMsgText);
        if (TextUtils.isEmpty(i18nPrecise)) {
            if (isMatchLanguage(str, TUIThemeManager.LANGUAGE_ZH_CN)) {
                return mGCommonPublicMessageMsgText.zh_CN;
            }
            return mGCommonPublicMessageMsgText.en_US;
        }
        return i18nPrecise;
    }

    public static String parseMGCommonPublicMessage(SudMGPMGState.MGCommonPublicMessage mGCommonPublicMessage, String str) {
        List<SudMGPMGState.MGCommonPublicMessage.MGCommonPublicMessageMsg> list;
        SudMGPMGState.MGCommonPublicMessage.MGCommonPublicMessageMsgUser mGCommonPublicMessageMsgUser;
        String str2;
        if (mGCommonPublicMessage != null && (list = mGCommonPublicMessage.msg) != null && list.size() != 0) {
            StringBuilder sb2 = new StringBuilder();
            for (SudMGPMGState.MGCommonPublicMessage.MGCommonPublicMessageMsg mGCommonPublicMessageMsg : mGCommonPublicMessage.msg) {
                int i = mGCommonPublicMessageMsg.phrase;
                if (i != 1) {
                    if (i == 2 && (mGCommonPublicMessageMsgUser = mGCommonPublicMessageMsg.user) != null && (str2 = mGCommonPublicMessageMsgUser.name) != null) {
                        sb2.append(str2);
                    }
                } else {
                    String parseI18nText = parseI18nText(str, mGCommonPublicMessageMsg.text);
                    if (parseI18nText != null) {
                        sb2.append(parseI18nText);
                    }
                }
            }
            return sb2.toString();
        }
        return null;
    }
}
