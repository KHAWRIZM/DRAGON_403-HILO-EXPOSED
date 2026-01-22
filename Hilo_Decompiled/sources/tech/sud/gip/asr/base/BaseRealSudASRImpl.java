package tech.sud.gip.asr.base;

import a1.a;
import a1.b;
import a1.c;
import a1.e;
import android.text.TextUtils;
import com.qiahao.nextvideo.ui.family.FamilySettingFragment;
import f.d;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
import tech.sud.gip.asr.base.model.InitASRParamModel;
import tech.sud.gip.core.ISudFSTAPP;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;
import tech.sud.mgp.SudMGPWrapper.state.SudMGPAPPState;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public abstract class BaseRealSudASRImpl implements Sudtry {
    private static final String FILE_TAG = "BaseRealSudASRImpl";
    private c _matchASRInfoEvent;
    protected final InitASRParamModel _paramModel;
    protected boolean isIntentRunning;
    protected String mLanguage;
    protected b mgCommonGameASR;
    private final String _TAG = "SudGIP ".concat(getClass().getSimpleName());
    protected HashSet<String> hitKeywordSet = new HashSet<>();

    public BaseRealSudASRImpl(InitASRParamModel initASRParamModel) {
        this._paramModel = initASRParamModel;
    }

    private void numberConver(String str, b bVar) {
        Matcher matcher = Pattern.compile("[0-9]+").matcher(str);
        ArrayList arrayList = new ArrayList();
        while (matcher.find()) {
            try {
                arrayList.add(Integer.valueOf(matcher.group()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (arrayList.size() > 0) {
            notifyAppCommonSelfTextHit(false, null, null, bVar.d, null, arrayList);
        }
    }

    private void numberMatch(String str, b bVar) {
        List<Integer> list;
        ArrayList arrayList = bVar.b;
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList arrayList2 = bVar.b;
            int size = arrayList2.size();
            int i = 0;
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList2.get(i2);
                i2++;
                String str2 = (String) obj;
                if (str2 != null && str.contains(str2)) {
                    this.hitKeywordSet.add(str2);
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(str2);
                    try {
                        int parseInt = Integer.parseInt(str2);
                        ArrayList arrayList4 = new ArrayList();
                        arrayList4.add(Integer.valueOf(parseInt));
                        list = arrayList4;
                    } catch (Exception e) {
                        e.printStackTrace();
                        list = null;
                    }
                    notifyAppCommonSelfTextHit(true, str2, null, bVar.d, arrayList3, list);
                }
            }
            ArrayList arrayList5 = bVar.b;
            int size2 = arrayList5.size();
            while (i < size2) {
                Object obj2 = arrayList5.get(i);
                i++;
                if (!this.hitKeywordSet.contains((String) obj2)) {
                    return;
                }
            }
            stopASR(true);
        }
    }

    private void textMatch(String str, b bVar) {
        ArrayList arrayList = bVar.b;
        if (arrayList != null && arrayList.size() != 0 && str != null) {
            String lowerCase = str.toLowerCase(Locale.getDefault());
            ArrayList arrayList2 = bVar.b;
            int size = arrayList2.size();
            int i = 0;
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList2.get(i2);
                i2++;
                String str2 = (String) obj;
                if (str2 != null && lowerCase.contains(str2.toLowerCase(Locale.getDefault()))) {
                    this.hitKeywordSet.add(str2);
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(str2);
                    notifyAppCommonSelfTextHit(true, str2, null, bVar.d, arrayList3, null);
                }
            }
            ArrayList arrayList4 = bVar.b;
            int size2 = arrayList4.size();
            while (i < size2) {
                Object obj2 = arrayList4.get(i);
                i++;
                if (!this.hitKeywordSet.contains((String) obj2)) {
                    return;
                }
            }
            stopASR(true);
        }
    }

    public void displayException(Exception exc) {
        LogUtils.file(FILE_TAG, "displayException:" + LogUtils.getErrorInfo(exc));
        SudLogger.e(this._TAG, exc.getMessage() + System.lineSeparator() + TextUtils.join(System.lineSeparator(), exc.getStackTrace()));
    }

    @Override // tech.sud.gip.asr.base.Sudtry
    public void handleGameASR(String str) {
        LogUtils.file(FILE_TAG, "handleGameASR:" + str);
        SudLogger.d(this._TAG, "handleGameASR:" + str);
        if (TextUtils.isEmpty(str)) {
            this.mgCommonGameASR = null;
            stopASR(false);
            return;
        }
        b a = b.a(str);
        this.mgCommonGameASR = a;
        if (a == null) {
            stopASR(false);
            return;
        }
        if (a.a) {
            if (!isSupportWordType(a.d)) {
                SudLogger.d(this._TAG, "handleGameASR nonsupport:" + a.d);
                LogUtils.file(FILE_TAG, "handleGameASR nonsupport:" + a.d);
                return;
            }
            if ("text".equals(a.d) && !isValidLanguage(this._paramModel.supportTextLanguageList, a.c)) {
                SudLogger.d(this._TAG, "handleGameASR nonsupport:" + a.c);
                LogUtils.file(FILE_TAG, "handleGameASR nonsupport:" + a.c);
                return;
            }
            if (FamilySettingFragment.FAMILY_NUMBER.equals(a.d) && !isValidLanguage(this._paramModel.supportNumberLanguageList, a.c)) {
                SudLogger.d(this._TAG, "handleGameASR nonsupport:" + a.c);
                LogUtils.file(FILE_TAG, "handleGameASR nonsupport:" + a.c);
                return;
            }
            this.isIntentRunning = true;
            String str2 = a.c;
            this.mLanguage = str2;
            startASR(str2);
            return;
        }
        this.isIntentRunning = false;
        stopASR(true);
    }

    public boolean isSupportWordType(String str) {
        if ("text".equals(str) || FamilySettingFragment.FAMILY_NUMBER.equals(str)) {
            return true;
        }
        return false;
    }

    public boolean isValidLanguage(JSONArray jSONArray, String str) {
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                String string = jSONArray.getString(i);
                if (string != null && !string.isEmpty() && string.equals(str)) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public void notifyAppCommonSelfTextHit(boolean z, String str, String str2, String str3, List<String> list, List<Integer> list2) {
        a aVar = new a();
        aVar.a = z;
        aVar.b = str;
        aVar.c = str2;
        aVar.d = str3;
        aVar.e = list;
        aVar.f = list2;
        ISudFSTAPP iSudFSTAPP = this._paramModel.iSudFSTAPP.get();
        if (iSudFSTAPP != null) {
            iSudFSTAPP.notifyStateChange(SudMGPAPPState.APP_COMMON_SELF_TEXT_HIT, aVar.a(), null);
            SudLogger.d(this._TAG, "hit:" + aVar.a());
            LogUtils.file(FILE_TAG, "hit:" + aVar.a());
        }
    }

    public void onRecognizingResult(String str) {
        b bVar;
        e eVar = this._matchASRInfoEvent;
        if (eVar != null) {
            e eVar2 = eVar;
            if (!eVar2.d.booleanValue()) {
                eVar2.d = Boolean.TRUE;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("type", eVar2.a);
                    jSONObject.put("date", eVar2.c);
                    eVar2.b.j.put("matchASR", jSONObject);
                    d.b(eVar2.b);
                    d0.a.a("TechSudMGPGlobal.sp").c("key_sud_mgp_match_asr_last_date", eVar2.c, false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (!TextUtils.isEmpty(str) && (bVar = this.mgCommonGameASR) != null && bVar.a) {
            if ("text".equals(bVar.d)) {
                if (bVar.e) {
                    textMatch(str, bVar);
                }
                if (bVar.f) {
                    notifyAppCommonSelfTextHit(false, null, str, bVar.d, null, null);
                    return;
                }
                return;
            }
            if (FamilySettingFragment.FAMILY_NUMBER.equals(bVar.d)) {
                if (bVar.e) {
                    numberMatch(str, bVar);
                }
                if (bVar.f) {
                    numberConver(str, bVar);
                }
            }
        }
    }

    @Override // tech.sud.gip.asr.base.Sudtry
    public abstract /* synthetic */ void pushAudio(ByteBuffer byteBuffer, int i);

    public void setMatchASREvent(c cVar) {
        this._matchASRInfoEvent = cVar;
    }

    public void startASR(String str) {
        this.hitKeywordSet.clear();
    }

    @Override // tech.sud.gip.asr.base.Sudtry
    public void stopASR(boolean z) {
        if (z) {
            this.isIntentRunning = false;
        }
        this.hitKeywordSet.clear();
    }
}
