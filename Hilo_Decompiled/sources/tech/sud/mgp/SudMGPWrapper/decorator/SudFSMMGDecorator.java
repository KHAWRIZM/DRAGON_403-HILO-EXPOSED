package tech.sud.mgp.SudMGPWrapper.decorator;

import tech.sud.gip.core.ISudFSMMG;
import tech.sud.gip.core.ISudFSMStateHandle;
import tech.sud.mgp.SudMGPWrapper.state.SudMGPMGState;
import tech.sud.mgp.SudMGPWrapper.utils.ISudFSMStateHandleUtils;
import tech.sud.mgp.SudMGPWrapper.utils.SudJsonUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class SudFSMMGDecorator implements ISudFSMMG {
    private final SudFSMMGCache sudFSMMGCache = new SudFSMMGCache();
    private SudFSMMGListener sudFSMMGListener;

    public void destroyMG() {
        this.sudFSMMGCache.destroyMG();
        this.sudFSMMGListener = null;
    }

    public String getCaptainUserId() {
        return this.sudFSMMGCache.getCaptainUserId();
    }

    public int getGameState() {
        return this.sudFSMMGCache.getGameState();
    }

    public int getPlayerInNumber() {
        return this.sudFSMMGCache.getPlayerInNumber();
    }

    public SudFSMMGCache getSudFSMMGCache() {
        return this.sudFSMMGCache;
    }

    public boolean isHitBomb() {
        return this.sudFSMMGCache.isHitBomb();
    }

    @Override // tech.sud.gip.core.ISudFSMMG
    public void onExpireCode(ISudFSMStateHandle iSudFSMStateHandle, String str) {
        SudFSMMGListener sudFSMMGListener = this.sudFSMMGListener;
        if (sudFSMMGListener != null) {
            sudFSMMGListener.onExpireCode(iSudFSMStateHandle, str);
        }
    }

    @Override // tech.sud.gip.core.ISudFSMMG
    public void onGameDestroyed() {
        SudFSMMGListener sudFSMMGListener = this.sudFSMMGListener;
        if (sudFSMMGListener != null) {
            sudFSMMGListener.onGameDestroyed();
        }
    }

    @Override // tech.sud.gip.core.ISudFSMMG
    public void onGameLoadingProgress(int i, int i2, int i3) {
        SudFSMMGListener sudFSMMGListener = this.sudFSMMGListener;
        if (sudFSMMGListener != null) {
            sudFSMMGListener.onGameLoadingProgress(i, i2, i3);
        }
    }

    @Override // tech.sud.gip.core.ISudFSMMG
    public void onGameLog(String str) {
        SudFSMMGListener sudFSMMGListener = this.sudFSMMGListener;
        if (sudFSMMGListener != null) {
            sudFSMMGListener.onGameLog(str);
        }
    }

    @Override // tech.sud.gip.core.ISudFSMMG
    public void onGameStarted() {
        SudFSMMGListener sudFSMMGListener = this.sudFSMMGListener;
        if (sudFSMMGListener != null) {
            sudFSMMGListener.onGameStarted();
        }
    }

    @Override // tech.sud.gip.core.ISudFSMMG
    public void onGameStateChange(ISudFSMStateHandle iSudFSMStateHandle, String str, String str2) {
        SudFSMMGListener sudFSMMGListener = this.sudFSMMGListener;
        if (sudFSMMGListener == null || !sudFSMMGListener.onGameStateChange(iSudFSMStateHandle, str, str2)) {
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -2118673438:
                    if (str.equals(SudMGPMGState.MG_COMMON_GAME_ASR)) {
                        c = 0;
                        break;
                    }
                    break;
                case -2118668725:
                    if (str.equals(SudMGPMGState.MG_COMMON_GAME_FPS)) {
                        c = 1;
                        break;
                    }
                    break;
                case -2069568135:
                    if (str.equals(SudMGPMGState.MG_COMMON_GAME_DISCO_ACTION)) {
                        c = 2;
                        break;
                    }
                    break;
                case -2023077693:
                    if (str.equals(SudMGPMGState.MG_COMMON_GAME_SOUND_STATE)) {
                        c = 3;
                        break;
                    }
                    break;
                case -1992822984:
                    if (str.equals(SudMGPMGState.MG_CUSTOM_ROCKET_PLAY_EFFECT_FINISH)) {
                        c = 4;
                        break;
                    }
                    break;
                case -1864332851:
                    if (str.equals(SudMGPMGState.MG_CUSTOM_ROCKET_PREPARE_FINISH)) {
                        c = 5;
                        break;
                    }
                    break;
                case -1812197903:
                    if (str.equals(SudMGPMGState.MG_COMMON_SELF_CLICK_CANCEL_JOIN_BTN)) {
                        c = 6;
                        break;
                    }
                    break;
                case -1809949382:
                    if (str.equals(SudMGPMGState.MG_CUSTOM_ROCKET_SET_CLICK_RECT)) {
                        c = 7;
                        break;
                    }
                    break;
                case -1628413997:
                    if (str.equals(SudMGPMGState.MG_COMMON_DESTROY_GAME_SCENE)) {
                        c = '\b';
                        break;
                    }
                    break;
                case -1602173366:
                    if (str.equals(SudMGPMGState.MG_COMMON_SELF_HEADPHONE)) {
                        c = '\t';
                        break;
                    }
                    break;
                case -1411738428:
                    if (str.equals(SudMGPMGState.MG_COMMON_SELF_CLICK_START_BTN)) {
                        c = '\n';
                        break;
                    }
                    break;
                case -1396115934:
                    if (str.equals(SudMGPMGState.MG_COMMON_GAME_NETWORK_STATE)) {
                        c = 11;
                        break;
                    }
                    break;
                case -1359655285:
                    if (str.equals(SudMGPMGState.MG_CUSTOM_ROCKET_UPLOAD_MODEL_ICON)) {
                        c = '\f';
                        break;
                    }
                    break;
                case -1253858854:
                    if (str.equals(SudMGPMGState.MG_COMMON_GAME_RULE)) {
                        c = '\r';
                        break;
                    }
                    break;
                case -1216469555:
                    if (str.equals(SudMGPMGState.MG_BASEBALL_MY_RANKING)) {
                        c = 14;
                        break;
                    }
                    break;
                case -1189063208:
                    if (str.equals(SudMGPMGState.MG_COMMON_SELF_CLICK_GOOD)) {
                        c = 15;
                        break;
                    }
                    break;
                case -1188795077:
                    if (str.equals(SudMGPMGState.MG_COMMON_SELF_CLICK_POOP)) {
                        c = 16;
                        break;
                    }
                    break;
                case -1146281537:
                    if (str.equals(SudMGPMGState.MG_CUSTOM_ROCKET_SHOW_GAME_SCENE)) {
                        c = 17;
                        break;
                    }
                    break;
                case -1133601021:
                    if (str.equals(SudMGPMGState.MG_COMMON_APP_COMMON_SELF_X_RESP)) {
                        c = 18;
                        break;
                    }
                    break;
                case -1077772147:
                    if (str.equals(SudMGPMGState.MG_COMMON_ALERT)) {
                        c = 19;
                        break;
                    }
                    break;
                case -994374560:
                    if (str.equals(SudMGPMGState.MG_CUSTOM_ROCKET_USER_INFO)) {
                        c = 20;
                        break;
                    }
                    break;
                case -989429003:
                    if (str.equals(SudMGPMGState.MG_BASEBALL_PREPARE_FINISH)) {
                        c = 21;
                        break;
                    }
                    break;
                case -982131123:
                    if (str.equals(SudMGPMGState.MG_CUSTOM_ROCKET_FLY_END)) {
                        c = 22;
                        break;
                    }
                    break;
                case -966306398:
                    if (str.equals(SudMGPMGState.MG_CUSTOM_ROCKET_COMPONENT_LIST)) {
                        c = 23;
                        break;
                    }
                    break;
                case -965513184:
                    if (str.equals(SudMGPMGState.MG_COMMON_PUBLIC_MESSAGE)) {
                        c = 24;
                        break;
                    }
                    break;
                case -939009322:
                    if (str.equals(SudMGPMGState.MG_COMMON_SELF_CLICK_CANCEL_READY_BTN)) {
                        c = 25;
                        break;
                    }
                    break;
                case -935045534:
                    if (str.equals(SudMGPMGState.MG_BASEBALL_SET_CLICK_RECT)) {
                        c = 26;
                        break;
                    }
                    break;
                case -864478783:
                    if (str.equals(SudMGPMGState.MG_COMMON_SELF_CLICK_SHARE_BTN)) {
                        c = 27;
                        break;
                    }
                    break;
                case -807856060:
                    if (str.equals(SudMGPMGState.MG_CUSTOM_ROCKET_CONFIG)) {
                        c = 28;
                        break;
                    }
                    break;
                case -690928683:
                    if (str.equals(SudMGPMGState.MG_COMMON_SELF_CLICK_EXIT_GAME_BTN)) {
                        c = 29;
                        break;
                    }
                    break;
                case -581417994:
                    if (str.equals(SudMGPMGState.MG_CUSTOM_ROCKET_MODEL_LIST)) {
                        c = 30;
                        break;
                    }
                    break;
                case -572535400:
                    if (str.equals(SudMGPMGState.MG_COMMON_SELF_CLICK_GOLD_BTN)) {
                        c = 31;
                        break;
                    }
                    break;
                case -473500139:
                    if (str.equals(SudMGPMGState.MG_COMMON_PLAYER_ROLE_ID)) {
                        c = ' ';
                        break;
                    }
                    break;
                case -389544267:
                    if (str.equals(SudMGPMGState.MG_COMMON_KEY_WORD_TO_HIT)) {
                        c = '!';
                        break;
                    }
                    break;
                case -372825723:
                    if (str.equals(SudMGPMGState.MG_COMMON_SELF_CLICK_READY_BTN)) {
                        c = '\"';
                        break;
                    }
                    break;
                case -329058019:
                    if (str.equals(SudMGPMGState.MG_CUSTOM_ROCKET_PLAY_EFFECT_START)) {
                        c = '#';
                        break;
                    }
                    break;
                case -285257195:
                    if (str.equals(SudMGPMGState.MG_COMMON_WORST_TEAMMATE)) {
                        c = '$';
                        break;
                    }
                    break;
                case -266215845:
                    if (str.equals(SudMGPMGState.MG_COMMON_GAME_BG_MUSIC_STATE)) {
                        c = '%';
                        break;
                    }
                    break;
                case -251682319:
                    if (str.equals(SudMGPMGState.MG_COMMON_GAME_PLAYER_MANAGED_STATE)) {
                        c = '&';
                        break;
                    }
                    break;
                case -214165007:
                    if (str.equals(SudMGPMGState.MG_COMMON_GAME_SOUND)) {
                        c = '\'';
                        break;
                    }
                    break;
                case -214035085:
                    if (str.equals(SudMGPMGState.MG_COMMON_GAME_STATE)) {
                        c = '(';
                        break;
                    }
                    break;
                case -151096742:
                    if (str.equals(SudMGPMGState.MG_CUSTOM_ROCKET_HIDE_GAME_SCENE)) {
                        c = ')';
                        break;
                    }
                    break;
                case -145921380:
                    if (str.equals(SudMGPMGState.MG_CUSTOM_CR_ROOM_INIT_DATA)) {
                        c = '*';
                        break;
                    }
                    break;
                case -100255749:
                    if (str.equals(SudMGPMGState.MG_COMMON_SELF_CLICK_GAME_SETTLE_AGAIN_BTN)) {
                        c = '+';
                        break;
                    }
                    break;
                case -65479124:
                    if (str.equals(SudMGPMGState.MG_COMMON_GAME_SOUND_LIST)) {
                        c = ',';
                        break;
                    }
                    break;
                case 39615015:
                    if (str.equals(SudMGPMGState.MG_COMMON_SET_CLICK_RECT)) {
                        c = '-';
                        break;
                    }
                    break;
                case 48534186:
                    if (str.equals(SudMGPMGState.MG_BASEBALL_TEXT_CONFIG)) {
                        c = '.';
                        break;
                    }
                    break;
                case 109255767:
                    if (str.equals(SudMGPMGState.MG_COMMON_GAME_SET_SCORE)) {
                        c = '/';
                        break;
                    }
                    break;
                case 188550499:
                    if (str.equals(SudMGPMGState.MG_COMMON_GAME_PLAYER_COLOR)) {
                        c = '0';
                        break;
                    }
                    break;
                case 188616609:
                    if (str.equals(SudMGPMGState.MG_CUSTOM_ROCKET_SAVE_SIGN_COLOR)) {
                        c = '1';
                        break;
                    }
                    break;
                case 197610850:
                    if (str.equals(SudMGPMGState.MG_BASEBALL_SEND_DISTANCE)) {
                        c = '2';
                        break;
                    }
                    break;
                case 200827714:
                    if (str.equals(SudMGPMGState.MG_COMMON_GAME_PIECE_ARRIVE_END)) {
                        c = '3';
                        break;
                    }
                    break;
                case 201988039:
                    if (str.equals(SudMGPMGState.MG_COMMON_GAME_PLAYER_RANKS)) {
                        c = '4';
                        break;
                    }
                    break;
                case 205933975:
                    if (str.equals(SudMGPMGState.MG_BASEBALL_SHOW_GAME_SCENE)) {
                        c = '5';
                        break;
                    }
                    break;
                case 272905218:
                    if (str.equals(SudMGPMGState.MG_CUSTOM_ROCKET_CLICK_LOCK_COMPONENT)) {
                        c = '6';
                        break;
                    }
                    break;
                case 284276066:
                    if (str.equals(SudMGPMGState.MG_COMMON_SELF_CLICK_JOIN_BTN)) {
                        c = '7';
                        break;
                    }
                    break;
                case 323872843:
                    if (str.equals(SudMGPMGState.MG_COMMON_GAME_GET_SCORE)) {
                        c = '8';
                        break;
                    }
                    break;
                case 355639922:
                    if (str.equals(SudMGPMGState.MG_COMMON_SHOW_GAME_SCENE)) {
                        c = '9';
                        break;
                    }
                    break;
                case 375966530:
                    if (str.equals(SudMGPMGState.MG_CUSTOM_ROCKET_BUY_COMPONENT)) {
                        c = ':';
                        break;
                    }
                    break;
                case 428773104:
                    if (str.equals(SudMGPMGState.MG_CUSTOM_ROCKET_REPLACE_COMPONENT)) {
                        c = ';';
                        break;
                    }
                    break;
                case 435942017:
                    if (str.equals(SudMGPMGState.MG_COMMON_GAME_IS_APP_CHIP)) {
                        c = '<';
                        break;
                    }
                    break;
                case 442579031:
                    if (str.equals(SudMGPMGState.MG_COMMON_GAME_ADD_AI_PLAYERS)) {
                        c = '=';
                        break;
                    }
                    break;
                case 522049171:
                    if (str.equals(SudMGPMGState.MG_COMMON_SELF_CLICK_GAME_SETTLE_CLOSE_BTN)) {
                        c = '>';
                        break;
                    }
                    break;
                case 600926786:
                    if (str.equals(SudMGPMGState.MG_COMMON_GAME_SEND_BURST_WORD)) {
                        c = '?';
                        break;
                    }
                    break;
                case 677686785:
                    if (str.equals(SudMGPMGState.MG_CUSTOM_ROCKET_VERIFY_SIGN)) {
                        c = '@';
                        break;
                    }
                    break;
                case 749777882:
                    if (str.equals(SudMGPMGState.MG_CUSTOM_ROCKET_USER_RECORD_LIST)) {
                        c = 'A';
                        break;
                    }
                    break;
                case 755301913:
                    if (str.equals(SudMGPMGState.MG_CUSTOM_ROCKET_ORDER_RECORD_LIST)) {
                        c = 'B';
                        break;
                    }
                    break;
                case 766039042:
                    if (str.equals(SudMGPMGState.MG_CUSTOM_ROCKET_DYNAMIC_FIRE_PRICE)) {
                        c = 'C';
                        break;
                    }
                    break;
                case 790960641:
                    if (str.equals(SudMGPMGState.MG_BASEBALL_DEFUALT_STATE)) {
                        c = 'D';
                        break;
                    }
                    break;
                case 880818453:
                    if (str.equals(SudMGPMGState.MG_COMMON_GAME_DISCO_ACTION_END)) {
                        c = 'E';
                        break;
                    }
                    break;
                case 918556302:
                    if (str.equals(SudMGPMGState.MG_COMMON_GAME_OVER_TIP)) {
                        c = 'F';
                        break;
                    }
                    break;
                case 927974169:
                    if (str.equals(SudMGPMGState.MG_COMMON_GAME_MONEY_NOT_ENOUGH)) {
                        c = 'G';
                        break;
                    }
                    break;
                case 959137262:
                    if (str.equals(SudMGPMGState.MG_COMMON_SELF_MICROPHONE)) {
                        c = 'H';
                        break;
                    }
                    break;
                case 982389212:
                    if (str.equals(SudMGPMGState.MG_COMMON_GAME_PLAYER_PAIR_SINGULAR)) {
                        c = 'I';
                        break;
                    }
                    break;
                case 993850963:
                    if (str.equals(SudMGPMGState.MG_COMMON_GAME_PLAYER_MONOPOLY_CARDS)) {
                        c = 'J';
                        break;
                    }
                    break;
                case 1008767052:
                    if (str.equals(SudMGPMGState.MG_CUSTOM_ROCKET_SET_DEFAULT_MODEL)) {
                        c = 'K';
                        break;
                    }
                    break;
                case 1062897274:
                    if (str.equals(SudMGPMGState.MG_CUSTOM_ROCKET_FLY_CLICK)) {
                        c = 'L';
                        break;
                    }
                    break;
                case 1201118770:
                    if (str.equals(SudMGPMGState.MG_BASEBALL_HIDE_GAME_SCENE)) {
                        c = 'M';
                        break;
                    }
                    break;
                case 1252536554:
                    if (str.equals(SudMGPMGState.MG_CUSTOM_ROCKET_ROOM_RECORD_LIST)) {
                        c = 'N';
                        break;
                    }
                    break;
                case 1291082572:
                    if (str.equals(SudMGPMGState.MG_BASEBALL_RANKING)) {
                        c = 'O';
                        break;
                    }
                    break;
                case 1304163316:
                    if (str.equals(SudMGPMGState.MG_COMMON_USERS_INFO)) {
                        c = 'P';
                        break;
                    }
                    break;
                case 1319344098:
                    if (str.equals(SudMGPMGState.MG_CUSTOM_ROCKET_FIRE_MODEL)) {
                        c = 'Q';
                        break;
                    }
                    break;
                case 1350824717:
                    if (str.equals(SudMGPMGState.MG_COMMON_HIDE_GAME_SCENE)) {
                        c = 'R';
                        break;
                    }
                    break;
                case 1673698728:
                    if (str.equals(SudMGPMGState.MG_CUSTOM_ROCKET_CREATE_MODEL)) {
                        c = 'S';
                        break;
                    }
                    break;
                case 1694475305:
                    if (str.equals(SudMGPMGState.MG_COMMON_GAME_PREPARE_FINISH)) {
                        c = 'T';
                        break;
                    }
                    break;
                case 1823746049:
                    if (str.equals(SudMGPMGState.MG_COMMON_GAME_SETTINGS)) {
                        c = 'U';
                        break;
                    }
                    break;
                case 1825518490:
                    if (str.equals(SudMGPMGState.MG_BASEBALL_RANGE_INFO)) {
                        c = 'V';
                        break;
                    }
                    break;
                case 1861544291:
                    if (str.equals(SudMGPMGState.MG_CUSTOM_CR_CLICK_SEAT)) {
                        c = 'W';
                        break;
                    }
                    break;
                case 1912659779:
                    if (str.equals(SudMGPMGState.MG_COMMON_GAME_UI_CUSTOM_CONFIG)) {
                        c = 'X';
                        break;
                    }
                    break;
                case 1941560489:
                    if (str.equals(SudMGPMGState.MG_COMMON_GAME_SETTLE)) {
                        c = 'Y';
                        break;
                    }
                    break;
                case 1987717929:
                    if (str.equals(SudMGPMGState.MG_COMMON_GAME_CREATE_ORDER)) {
                        c = 'Z';
                        break;
                    }
                    break;
                case 1997174305:
                    if (str.equals(SudMGPMGState.MG_COMMON_GAME_PLAYER_SCORES)) {
                        c = '[';
                        break;
                    }
                    break;
                case 2130207791:
                    if (str.equals(SudMGPMGState.MG_COMMON_GAME_PLAYER_ICON_POSITION)) {
                        c = '\\';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    SudMGPMGState.MGCommonGameASR mGCommonGameASR = (SudMGPMGState.MGCommonGameASR) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonGameASR.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonGameASR(iSudFSMStateHandle, mGCommonGameASR);
                        return;
                    }
                case 1:
                    SudMGPMGState.MGCommonGameFps mGCommonGameFps = (SudMGPMGState.MGCommonGameFps) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonGameFps.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonGameFps(iSudFSMStateHandle, mGCommonGameFps);
                        return;
                    }
                case 2:
                    SudMGPMGState.MGCommonGameDiscoAction mGCommonGameDiscoAction = (SudMGPMGState.MGCommonGameDiscoAction) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonGameDiscoAction.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonGameDiscoAction(iSudFSMStateHandle, mGCommonGameDiscoAction);
                        return;
                    }
                case 3:
                    SudMGPMGState.MGCommonGameSoundState mGCommonGameSoundState = (SudMGPMGState.MGCommonGameSoundState) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonGameSoundState.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonGameSoundState(iSudFSMStateHandle, mGCommonGameSoundState);
                        return;
                    }
                case 4:
                    SudMGPMGState.MGCustomRocketPlayEffectFinish mGCustomRocketPlayEffectFinish = (SudMGPMGState.MGCustomRocketPlayEffectFinish) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCustomRocketPlayEffectFinish.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCustomRocketPlayEffectFinish(iSudFSMStateHandle, mGCustomRocketPlayEffectFinish);
                        return;
                    }
                case 5:
                    SudMGPMGState.MGCustomRocketPrepareFinish mGCustomRocketPrepareFinish = (SudMGPMGState.MGCustomRocketPrepareFinish) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCustomRocketPrepareFinish.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCustomRocketPrepareFinish(iSudFSMStateHandle, mGCustomRocketPrepareFinish);
                        return;
                    }
                case 6:
                    SudMGPMGState.MGCommonSelfClickCancelJoinBtn mGCommonSelfClickCancelJoinBtn = (SudMGPMGState.MGCommonSelfClickCancelJoinBtn) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonSelfClickCancelJoinBtn.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonSelfClickCancelJoinBtn(iSudFSMStateHandle, mGCommonSelfClickCancelJoinBtn);
                        return;
                    }
                case 7:
                    SudMGPMGState.MGCustomRocketSetClickRect mGCustomRocketSetClickRect = (SudMGPMGState.MGCustomRocketSetClickRect) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCustomRocketSetClickRect.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCustomRocketSetClickRect(iSudFSMStateHandle, mGCustomRocketSetClickRect);
                        return;
                    }
                case '\b':
                    SudMGPMGState.MGCommonDestroyGameScene mGCommonDestroyGameScene = (SudMGPMGState.MGCommonDestroyGameScene) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonDestroyGameScene.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonDestroyGameScene(iSudFSMStateHandle, mGCommonDestroyGameScene);
                        return;
                    }
                case '\t':
                    SudMGPMGState.MGCommonSelfHeadphone mGCommonSelfHeadphone = (SudMGPMGState.MGCommonSelfHeadphone) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonSelfHeadphone.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonSelfHeadphone(iSudFSMStateHandle, mGCommonSelfHeadphone);
                        return;
                    }
                case '\n':
                    SudMGPMGState.MGCommonSelfClickStartBtn mGCommonSelfClickStartBtn = (SudMGPMGState.MGCommonSelfClickStartBtn) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonSelfClickStartBtn.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonSelfClickStartBtn(iSudFSMStateHandle, mGCommonSelfClickStartBtn);
                        return;
                    }
                case 11:
                    SudMGPMGState.MGCommonGameNetworkState mGCommonGameNetworkState = (SudMGPMGState.MGCommonGameNetworkState) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonGameNetworkState.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonGameNetworkState(iSudFSMStateHandle, mGCommonGameNetworkState);
                        return;
                    }
                case '\f':
                    SudMGPMGState.MGCustomRocketUploadModelIcon mGCustomRocketUploadModelIcon = (SudMGPMGState.MGCustomRocketUploadModelIcon) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCustomRocketUploadModelIcon.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCustomRocketUploadModelIcon(iSudFSMStateHandle, mGCustomRocketUploadModelIcon);
                        return;
                    }
                case '\r':
                    SudMGPMGState.MGCommonGameRule mGCommonGameRule = (SudMGPMGState.MGCommonGameRule) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonGameRule.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonGameRule(iSudFSMStateHandle, mGCommonGameRule);
                        return;
                    }
                case 14:
                    SudMGPMGState.MGBaseballMyRanking mGBaseballMyRanking = (SudMGPMGState.MGBaseballMyRanking) SudJsonUtils.fromJson(str2, SudMGPMGState.MGBaseballMyRanking.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGBaseballMyRanking(iSudFSMStateHandle, mGBaseballMyRanking);
                        return;
                    }
                case 15:
                    SudMGPMGState.MGCommonSelfClickGood mGCommonSelfClickGood = (SudMGPMGState.MGCommonSelfClickGood) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonSelfClickGood.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonSelfClickGood(iSudFSMStateHandle, mGCommonSelfClickGood);
                        return;
                    }
                case 16:
                    SudMGPMGState.MGCommonSelfClickPoop mGCommonSelfClickPoop = (SudMGPMGState.MGCommonSelfClickPoop) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonSelfClickPoop.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonSelfClickPoop(iSudFSMStateHandle, mGCommonSelfClickPoop);
                        return;
                    }
                case 17:
                    SudMGPMGState.MGCustomRocketShowGameScene mGCustomRocketShowGameScene = (SudMGPMGState.MGCustomRocketShowGameScene) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCustomRocketShowGameScene.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCustomRocketShowGameScene(iSudFSMStateHandle, mGCustomRocketShowGameScene);
                        return;
                    }
                case 18:
                    SudMGPMGState.MGCommonAPPCommonSelfXResp mGCommonAPPCommonSelfXResp = (SudMGPMGState.MGCommonAPPCommonSelfXResp) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonAPPCommonSelfXResp.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonAPPCommonSelfXResp(iSudFSMStateHandle, mGCommonAPPCommonSelfXResp);
                        return;
                    }
                case 19:
                    SudMGPMGState.MGCommonAlert mGCommonAlert = (SudMGPMGState.MGCommonAlert) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonAlert.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonAlert(iSudFSMStateHandle, mGCommonAlert);
                        return;
                    }
                case 20:
                    SudMGPMGState.MGCustomRocketUserInfo mGCustomRocketUserInfo = (SudMGPMGState.MGCustomRocketUserInfo) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCustomRocketUserInfo.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCustomRocketUserInfo(iSudFSMStateHandle, mGCustomRocketUserInfo);
                        return;
                    }
                case 21:
                    SudMGPMGState.MGBaseballPrepareFinish mGBaseballPrepareFinish = (SudMGPMGState.MGBaseballPrepareFinish) SudJsonUtils.fromJson(str2, SudMGPMGState.MGBaseballPrepareFinish.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGBaseballPrepareFinish(iSudFSMStateHandle, mGBaseballPrepareFinish);
                        return;
                    }
                case 22:
                    SudMGPMGState.MGCustomRocketFlyEnd mGCustomRocketFlyEnd = (SudMGPMGState.MGCustomRocketFlyEnd) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCustomRocketFlyEnd.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCustomRocketFlyEnd(iSudFSMStateHandle, mGCustomRocketFlyEnd);
                        return;
                    }
                case 23:
                    SudMGPMGState.MGCustomRocketComponentList mGCustomRocketComponentList = (SudMGPMGState.MGCustomRocketComponentList) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCustomRocketComponentList.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCustomRocketComponentList(iSudFSMStateHandle, mGCustomRocketComponentList);
                        return;
                    }
                case 24:
                    SudMGPMGState.MGCommonPublicMessage mGCommonPublicMessage = (SudMGPMGState.MGCommonPublicMessage) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonPublicMessage.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonPublicMessage(iSudFSMStateHandle, mGCommonPublicMessage);
                        return;
                    }
                case 25:
                    SudMGPMGState.MGCommonSelfClickCancelReadyBtn mGCommonSelfClickCancelReadyBtn = (SudMGPMGState.MGCommonSelfClickCancelReadyBtn) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonSelfClickCancelReadyBtn.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonSelfClickCancelReadyBtn(iSudFSMStateHandle, mGCommonSelfClickCancelReadyBtn);
                        return;
                    }
                case 26:
                    SudMGPMGState.MGBaseballSetClickRect mGBaseballSetClickRect = (SudMGPMGState.MGBaseballSetClickRect) SudJsonUtils.fromJson(str2, SudMGPMGState.MGBaseballSetClickRect.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGBaseballSetClickRect(iSudFSMStateHandle, mGBaseballSetClickRect);
                        return;
                    }
                case 27:
                    SudMGPMGState.MGCommonSelfClickShareBtn mGCommonSelfClickShareBtn = (SudMGPMGState.MGCommonSelfClickShareBtn) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonSelfClickShareBtn.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonSelfClickShareBtn(iSudFSMStateHandle, mGCommonSelfClickShareBtn);
                        return;
                    }
                case 28:
                    SudMGPMGState.MGCustomRocketConfig mGCustomRocketConfig = (SudMGPMGState.MGCustomRocketConfig) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCustomRocketConfig.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCustomRocketConfig(iSudFSMStateHandle, mGCustomRocketConfig);
                        return;
                    }
                case 29:
                    SudMGPMGState.MGCommonSelfClickExitGameBtn mGCommonSelfClickExitGameBtn = (SudMGPMGState.MGCommonSelfClickExitGameBtn) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonSelfClickExitGameBtn.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonSelfClickExitGameBtn(iSudFSMStateHandle, mGCommonSelfClickExitGameBtn);
                        return;
                    }
                case 30:
                    SudMGPMGState.MGCustomRocketModelList mGCustomRocketModelList = (SudMGPMGState.MGCustomRocketModelList) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCustomRocketModelList.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCustomRocketModelList(iSudFSMStateHandle, mGCustomRocketModelList);
                        return;
                    }
                case 31:
                    SudMGPMGState.MGCommonSelfClickGoldBtn mGCommonSelfClickGoldBtn = (SudMGPMGState.MGCommonSelfClickGoldBtn) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonSelfClickGoldBtn.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonSelfClickGoldBtn(iSudFSMStateHandle, mGCommonSelfClickGoldBtn);
                        return;
                    }
                case ' ':
                    SudMGPMGState.MGCommonPlayerRoleId mGCommonPlayerRoleId = (SudMGPMGState.MGCommonPlayerRoleId) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonPlayerRoleId.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonPlayerRoleId(iSudFSMStateHandle, mGCommonPlayerRoleId);
                        return;
                    }
                case '!':
                    SudMGPMGState.MGCommonKeyWordToHit mGCommonKeyWordToHit = (SudMGPMGState.MGCommonKeyWordToHit) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonKeyWordToHit.class);
                    this.sudFSMMGCache.onGameMGCommonKeyWordToHit(mGCommonKeyWordToHit);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonKeyWordToHit(iSudFSMStateHandle, mGCommonKeyWordToHit);
                        return;
                    }
                case '\"':
                    SudMGPMGState.MGCommonSelfClickReadyBtn mGCommonSelfClickReadyBtn = (SudMGPMGState.MGCommonSelfClickReadyBtn) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonSelfClickReadyBtn.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonSelfClickReadyBtn(iSudFSMStateHandle, mGCommonSelfClickReadyBtn);
                        return;
                    }
                case '#':
                    SudMGPMGState.MGCustomRocketPlayEffectStart mGCustomRocketPlayEffectStart = (SudMGPMGState.MGCustomRocketPlayEffectStart) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCustomRocketPlayEffectStart.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCustomRocketPlayEffectStart(iSudFSMStateHandle, mGCustomRocketPlayEffectStart);
                        return;
                    }
                case '$':
                    SudMGPMGState.MGCommonWorstTeammate mGCommonWorstTeammate = (SudMGPMGState.MGCommonWorstTeammate) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonWorstTeammate.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonWorstTeammate(iSudFSMStateHandle, mGCommonWorstTeammate);
                        return;
                    }
                case '%':
                    SudMGPMGState.MGCommonGameBgMusicState mGCommonGameBgMusicState = (SudMGPMGState.MGCommonGameBgMusicState) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonGameBgMusicState.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonGameBgMusicState(iSudFSMStateHandle, mGCommonGameBgMusicState);
                        return;
                    }
                case '&':
                    SudMGPMGState.MGCommonGamePlayerManagedState mGCommonGamePlayerManagedState = (SudMGPMGState.MGCommonGamePlayerManagedState) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonGamePlayerManagedState.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonGamePlayerManagedState(iSudFSMStateHandle, mGCommonGamePlayerManagedState);
                        return;
                    }
                case '\'':
                    SudMGPMGState.MGCommonGameSound mGCommonGameSound = (SudMGPMGState.MGCommonGameSound) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonGameSound.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonGameSound(iSudFSMStateHandle, mGCommonGameSound);
                        return;
                    }
                case '(':
                    SudMGPMGState.MGCommonGameState mGCommonGameState = (SudMGPMGState.MGCommonGameState) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonGameState.class);
                    this.sudFSMMGCache.onGameMGCommonGameState(mGCommonGameState);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonGameState(iSudFSMStateHandle, mGCommonGameState);
                        return;
                    }
                case ')':
                    SudMGPMGState.MGCustomRocketHideGameScene mGCustomRocketHideGameScene = (SudMGPMGState.MGCustomRocketHideGameScene) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCustomRocketHideGameScene.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCustomRocketHideGameScene(iSudFSMStateHandle, mGCustomRocketHideGameScene);
                        return;
                    }
                case '*':
                    SudMGPMGState.MGCustomCrRoomInitData mGCustomCrRoomInitData = (SudMGPMGState.MGCustomCrRoomInitData) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCustomCrRoomInitData.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCustomCrRoomInitData(iSudFSMStateHandle, mGCustomCrRoomInitData);
                        return;
                    }
                case '+':
                    SudMGPMGState.MGCommonSelfClickGameSettleAgainBtn mGCommonSelfClickGameSettleAgainBtn = (SudMGPMGState.MGCommonSelfClickGameSettleAgainBtn) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonSelfClickGameSettleAgainBtn.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonSelfClickGameSettleAgainBtn(iSudFSMStateHandle, mGCommonSelfClickGameSettleAgainBtn);
                        return;
                    }
                case ',':
                    SudMGPMGState.MGCommonGameSoundList mGCommonGameSoundList = (SudMGPMGState.MGCommonGameSoundList) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonGameSoundList.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonGameSoundList(iSudFSMStateHandle, mGCommonGameSoundList);
                        return;
                    }
                case '-':
                    SudMGPMGState.MGCommonSetClickRect mGCommonSetClickRect = (SudMGPMGState.MGCommonSetClickRect) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonSetClickRect.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonSetClickRect(iSudFSMStateHandle, mGCommonSetClickRect);
                        return;
                    }
                case '.':
                    SudMGPMGState.MGBaseballTextConfig mGBaseballTextConfig = (SudMGPMGState.MGBaseballTextConfig) SudJsonUtils.fromJson(str2, SudMGPMGState.MGBaseballTextConfig.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGBaseballTextConfig(iSudFSMStateHandle, mGBaseballTextConfig);
                        return;
                    }
                case '/':
                    SudMGPMGState.MGCommonGameSetScore mGCommonGameSetScore = (SudMGPMGState.MGCommonGameSetScore) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonGameSetScore.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonGameSetScore(iSudFSMStateHandle, mGCommonGameSetScore);
                        return;
                    }
                case '0':
                    SudMGPMGState.MGCommonGamePlayerColor mGCommonGamePlayerColor = (SudMGPMGState.MGCommonGamePlayerColor) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonGamePlayerColor.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonGamePlayerColor(iSudFSMStateHandle, mGCommonGamePlayerColor);
                        return;
                    }
                case '1':
                    SudMGPMGState.MGCustomRocketSaveSignColor mGCustomRocketSaveSignColor = (SudMGPMGState.MGCustomRocketSaveSignColor) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCustomRocketSaveSignColor.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCustomRocketSaveSignColor(iSudFSMStateHandle, mGCustomRocketSaveSignColor);
                        return;
                    }
                case '2':
                    SudMGPMGState.MGBaseballSendDistance mGBaseballSendDistance = (SudMGPMGState.MGBaseballSendDistance) SudJsonUtils.fromJson(str2, SudMGPMGState.MGBaseballSendDistance.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGBaseballSendDistance(iSudFSMStateHandle, mGBaseballSendDistance);
                        return;
                    }
                case '3':
                    SudMGPMGState.MGCommonGamePieceArriveEnd mGCommonGamePieceArriveEnd = (SudMGPMGState.MGCommonGamePieceArriveEnd) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonGamePieceArriveEnd.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonGamePieceArriveEnd(iSudFSMStateHandle, mGCommonGamePieceArriveEnd);
                        return;
                    }
                case '4':
                    SudMGPMGState.MGCommonGamePlayerRanks mGCommonGamePlayerRanks = (SudMGPMGState.MGCommonGamePlayerRanks) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonGamePlayerRanks.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonGamePlayerRanks(iSudFSMStateHandle, mGCommonGamePlayerRanks);
                        return;
                    }
                case '5':
                    SudMGPMGState.MGBaseballShowGameScene mGBaseballShowGameScene = (SudMGPMGState.MGBaseballShowGameScene) SudJsonUtils.fromJson(str2, SudMGPMGState.MGBaseballShowGameScene.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGBaseballShowGameScene(iSudFSMStateHandle, mGBaseballShowGameScene);
                        return;
                    }
                case '6':
                    SudMGPMGState.MGCustomRocketClickLockComponent mGCustomRocketClickLockComponent = (SudMGPMGState.MGCustomRocketClickLockComponent) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCustomRocketClickLockComponent.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCustomRocketClickLockComponent(iSudFSMStateHandle, mGCustomRocketClickLockComponent);
                        return;
                    }
                case '7':
                    SudMGPMGState.MGCommonSelfClickJoinBtn mGCommonSelfClickJoinBtn = (SudMGPMGState.MGCommonSelfClickJoinBtn) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonSelfClickJoinBtn.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonSelfClickJoinBtn(iSudFSMStateHandle, mGCommonSelfClickJoinBtn);
                        return;
                    }
                case '8':
                    SudMGPMGState.MGCommonGameGetScore mGCommonGameGetScore = (SudMGPMGState.MGCommonGameGetScore) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonGameGetScore.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonGameGetScore(iSudFSMStateHandle, mGCommonGameGetScore);
                        return;
                    }
                case '9':
                    SudMGPMGState.MGCommonShowGameScene mGCommonShowGameScene = (SudMGPMGState.MGCommonShowGameScene) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonShowGameScene.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonShowGameScene(iSudFSMStateHandle, mGCommonShowGameScene);
                        return;
                    }
                case ':':
                    SudMGPMGState.MGCustomRocketBuyComponent mGCustomRocketBuyComponent = (SudMGPMGState.MGCustomRocketBuyComponent) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCustomRocketBuyComponent.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCustomRocketBuyComponent(iSudFSMStateHandle, mGCustomRocketBuyComponent);
                        return;
                    }
                case ';':
                    SudMGPMGState.MGCustomRocketReplaceComponent mGCustomRocketReplaceComponent = (SudMGPMGState.MGCustomRocketReplaceComponent) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCustomRocketReplaceComponent.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCustomRocketReplaceComponent(iSudFSMStateHandle, mGCustomRocketReplaceComponent);
                        return;
                    }
                case '<':
                    SudMGPMGState.MGCommonGameIsAppChip mGCommonGameIsAppChip = (SudMGPMGState.MGCommonGameIsAppChip) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonGameIsAppChip.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonGameIsAppChip(iSudFSMStateHandle, mGCommonGameIsAppChip);
                        return;
                    }
                case '=':
                    SudMGPMGState.MGCommonGameAddAIPlayers mGCommonGameAddAIPlayers = (SudMGPMGState.MGCommonGameAddAIPlayers) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonGameAddAIPlayers.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonGameAddAIPlayers(iSudFSMStateHandle, mGCommonGameAddAIPlayers);
                        return;
                    }
                case '>':
                    SudMGPMGState.MGCommonSelfClickGameSettleCloseBtn mGCommonSelfClickGameSettleCloseBtn = (SudMGPMGState.MGCommonSelfClickGameSettleCloseBtn) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonSelfClickGameSettleCloseBtn.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonSelfClickGameSettleCloseBtn(iSudFSMStateHandle, mGCommonSelfClickGameSettleCloseBtn);
                        return;
                    }
                case '?':
                    SudMGPMGState.MGCommonGameSendBurstWord mGCommonGameSendBurstWord = (SudMGPMGState.MGCommonGameSendBurstWord) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonGameSendBurstWord.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonGameSendBurstWord(iSudFSMStateHandle, mGCommonGameSendBurstWord);
                        return;
                    }
                case '@':
                    SudMGPMGState.MGCustomRocketVerifySign mGCustomRocketVerifySign = (SudMGPMGState.MGCustomRocketVerifySign) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCustomRocketVerifySign.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCustomRocketVerifySign(iSudFSMStateHandle, mGCustomRocketVerifySign);
                        return;
                    }
                case 'A':
                    SudMGPMGState.MGCustomRocketUserRecordList mGCustomRocketUserRecordList = (SudMGPMGState.MGCustomRocketUserRecordList) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCustomRocketUserRecordList.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCustomRocketUserRecordList(iSudFSMStateHandle, mGCustomRocketUserRecordList);
                        return;
                    }
                case 'B':
                    SudMGPMGState.MGCustomRocketOrderRecordList mGCustomRocketOrderRecordList = (SudMGPMGState.MGCustomRocketOrderRecordList) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCustomRocketOrderRecordList.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCustomRocketOrderRecordList(iSudFSMStateHandle, mGCustomRocketOrderRecordList);
                        return;
                    }
                case 'C':
                    SudMGPMGState.MGCustomRocketDynamicFirePrice mGCustomRocketDynamicFirePrice = (SudMGPMGState.MGCustomRocketDynamicFirePrice) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCustomRocketDynamicFirePrice.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCustomRocketDynamicFirePrice(iSudFSMStateHandle, mGCustomRocketDynamicFirePrice);
                        return;
                    }
                case 'D':
                    SudMGPMGState.MGBaseballDefaultState mGBaseballDefaultState = (SudMGPMGState.MGBaseballDefaultState) SudJsonUtils.fromJson(str2, SudMGPMGState.MGBaseballDefaultState.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGBaseballDefaultState(iSudFSMStateHandle, mGBaseballDefaultState);
                        return;
                    }
                case 'E':
                    SudMGPMGState.MGCommonGameDiscoActionEnd mGCommonGameDiscoActionEnd = (SudMGPMGState.MGCommonGameDiscoActionEnd) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonGameDiscoActionEnd.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonGameDiscoActionEnd(iSudFSMStateHandle, mGCommonGameDiscoActionEnd);
                        return;
                    }
                case 'F':
                    SudMGPMGState.MGCommonGameOverTip mGCommonGameOverTip = (SudMGPMGState.MGCommonGameOverTip) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonGameOverTip.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonGameOverTip(iSudFSMStateHandle, mGCommonGameOverTip);
                        return;
                    }
                case 'G':
                    SudMGPMGState.MGCommonGameMoneyNotEnough mGCommonGameMoneyNotEnough = (SudMGPMGState.MGCommonGameMoneyNotEnough) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonGameMoneyNotEnough.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonGameMoneyNotEnough(iSudFSMStateHandle, mGCommonGameMoneyNotEnough);
                        return;
                    }
                case 'H':
                    SudMGPMGState.MGCommonSelfMicrophone mGCommonSelfMicrophone = (SudMGPMGState.MGCommonSelfMicrophone) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonSelfMicrophone.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonSelfMicrophone(iSudFSMStateHandle, mGCommonSelfMicrophone);
                        return;
                    }
                case 'I':
                    SudMGPMGState.MGCommonGamePlayerPairSingular mGCommonGamePlayerPairSingular = (SudMGPMGState.MGCommonGamePlayerPairSingular) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonGamePlayerPairSingular.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonGamePlayerPairSingular(iSudFSMStateHandle, mGCommonGamePlayerPairSingular);
                        return;
                    }
                case 'J':
                    SudMGPMGState.MGCommonGamePlayerMonopolyCards mGCommonGamePlayerMonopolyCards = (SudMGPMGState.MGCommonGamePlayerMonopolyCards) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonGamePlayerMonopolyCards.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonGamePlayerMonopolyCards(iSudFSMStateHandle, mGCommonGamePlayerMonopolyCards);
                        return;
                    }
                case 'K':
                    SudMGPMGState.MGCustomRocketSetDefaultModel mGCustomRocketSetDefaultModel = (SudMGPMGState.MGCustomRocketSetDefaultModel) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCustomRocketSetDefaultModel.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCustomRocketSetDefaultModel(iSudFSMStateHandle, mGCustomRocketSetDefaultModel);
                        return;
                    }
                case 'L':
                    SudMGPMGState.MGCustomRocketFlyClick mGCustomRocketFlyClick = (SudMGPMGState.MGCustomRocketFlyClick) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCustomRocketFlyClick.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCustomRocketFlyClick(iSudFSMStateHandle, mGCustomRocketFlyClick);
                        return;
                    }
                case 'M':
                    SudMGPMGState.MGBaseballHideGameScene mGBaseballHideGameScene = (SudMGPMGState.MGBaseballHideGameScene) SudJsonUtils.fromJson(str2, SudMGPMGState.MGBaseballHideGameScene.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGBaseballHideGameScene(iSudFSMStateHandle, mGBaseballHideGameScene);
                        return;
                    }
                case 'N':
                    SudMGPMGState.MGCustomRocketRoomRecordList mGCustomRocketRoomRecordList = (SudMGPMGState.MGCustomRocketRoomRecordList) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCustomRocketRoomRecordList.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCustomRocketRoomRecordList(iSudFSMStateHandle, mGCustomRocketRoomRecordList);
                        return;
                    }
                case 'O':
                    SudMGPMGState.MGBaseballRanking mGBaseballRanking = (SudMGPMGState.MGBaseballRanking) SudJsonUtils.fromJson(str2, SudMGPMGState.MGBaseballRanking.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGBaseballRanking(iSudFSMStateHandle, mGBaseballRanking);
                        return;
                    }
                case 'P':
                    SudMGPMGState.MGCommonUsersInfo mGCommonUsersInfo = (SudMGPMGState.MGCommonUsersInfo) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonUsersInfo.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonUsersInfo(iSudFSMStateHandle, mGCommonUsersInfo);
                        return;
                    }
                case 'Q':
                    SudMGPMGState.MGCustomRocketFireModel mGCustomRocketFireModel = (SudMGPMGState.MGCustomRocketFireModel) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCustomRocketFireModel.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCustomRocketFireModel(iSudFSMStateHandle, mGCustomRocketFireModel);
                        return;
                    }
                case 'R':
                    SudMGPMGState.MGCommonHideGameScene mGCommonHideGameScene = (SudMGPMGState.MGCommonHideGameScene) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonHideGameScene.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonHideGameScene(iSudFSMStateHandle, mGCommonHideGameScene);
                        return;
                    }
                case 'S':
                    SudMGPMGState.MGCustomRocketCreateModel mGCustomRocketCreateModel = (SudMGPMGState.MGCustomRocketCreateModel) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCustomRocketCreateModel.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCustomRocketCreateModel(iSudFSMStateHandle, mGCustomRocketCreateModel);
                        return;
                    }
                case 'T':
                    SudMGPMGState.MGCommonGamePrepareFinish mGCommonGamePrepareFinish = (SudMGPMGState.MGCommonGamePrepareFinish) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonGamePrepareFinish.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonGamePrepareFinish(iSudFSMStateHandle, mGCommonGamePrepareFinish);
                        return;
                    }
                case 'U':
                    SudMGPMGState.MGCommonGameSettings mGCommonGameSettings = (SudMGPMGState.MGCommonGameSettings) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonGameSettings.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonGameSettings(iSudFSMStateHandle, mGCommonGameSettings);
                        return;
                    }
                case 'V':
                    SudMGPMGState.MGBaseballRangeInfo mGBaseballRangeInfo = (SudMGPMGState.MGBaseballRangeInfo) SudJsonUtils.fromJson(str2, SudMGPMGState.MGBaseballRangeInfo.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGBaseballRangeInfo(iSudFSMStateHandle, mGBaseballRangeInfo);
                        return;
                    }
                case 'W':
                    SudMGPMGState.MGCustomCrClickSeat mGCustomCrClickSeat = (SudMGPMGState.MGCustomCrClickSeat) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCustomCrClickSeat.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCustomCrClickSeat(iSudFSMStateHandle, mGCustomCrClickSeat);
                        return;
                    }
                case 'X':
                    SudMGPMGState.MGCommonGameUiCustomConfig mGCommonGameUiCustomConfig = (SudMGPMGState.MGCommonGameUiCustomConfig) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonGameUiCustomConfig.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonGameUiCustomConfig(iSudFSMStateHandle, mGCommonGameUiCustomConfig);
                        return;
                    }
                case 'Y':
                    SudMGPMGState.MGCommonGameSettle mGCommonGameSettle = (SudMGPMGState.MGCommonGameSettle) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonGameSettle.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonGameSettle(iSudFSMStateHandle, mGCommonGameSettle);
                        return;
                    }
                case 'Z':
                    SudMGPMGState.MGCommonGameCreateOrder mGCommonGameCreateOrder = (SudMGPMGState.MGCommonGameCreateOrder) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonGameCreateOrder.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonGameCreateOrder(iSudFSMStateHandle, mGCommonGameCreateOrder);
                        return;
                    }
                case '[':
                    SudMGPMGState.MGCommonGamePlayerScores mGCommonGamePlayerScores = (SudMGPMGState.MGCommonGamePlayerScores) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonGamePlayerScores.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonGamePlayerScores(iSudFSMStateHandle, mGCommonGamePlayerScores);
                        return;
                    }
                case '\\':
                    SudMGPMGState.MGCommonGamePlayerIconPosition mGCommonGamePlayerIconPosition = (SudMGPMGState.MGCommonGamePlayerIconPosition) SudJsonUtils.fromJson(str2, SudMGPMGState.MGCommonGamePlayerIconPosition.class);
                    if (sudFSMMGListener == null) {
                        ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                        return;
                    } else {
                        sudFSMMGListener.onGameMGCommonGamePlayerIconPosition(iSudFSMStateHandle, mGCommonGamePlayerIconPosition);
                        return;
                    }
                default:
                    ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                    return;
            }
        }
    }

    @Override // tech.sud.gip.core.ISudFSMMG
    public void onGetGameCfg(ISudFSMStateHandle iSudFSMStateHandle, String str) {
        SudFSMMGListener sudFSMMGListener = this.sudFSMMGListener;
        if (sudFSMMGListener != null) {
            sudFSMMGListener.onGetGameCfg(iSudFSMStateHandle, str);
        }
    }

    @Override // tech.sud.gip.core.ISudFSMMG
    public void onGetGameViewInfo(ISudFSMStateHandle iSudFSMStateHandle, String str) {
        SudFSMMGListener sudFSMMGListener = this.sudFSMMGListener;
        if (sudFSMMGListener != null) {
            sudFSMMGListener.onGetGameViewInfo(iSudFSMStateHandle, str);
        }
    }

    @Override // tech.sud.gip.core.ISudFSMMG
    public void onPlayerStateChange(ISudFSMStateHandle iSudFSMStateHandle, String str, String str2, String str3) {
        SudFSMMGListener sudFSMMGListener = this.sudFSMMGListener;
        if (sudFSMMGListener != null && sudFSMMGListener.onPlayerStateChange(iSudFSMStateHandle, str, str2, str3)) {
            return;
        }
        str2.hashCode();
        char c = 65535;
        switch (str2.hashCode()) {
            case -1984464519:
                if (str2.equals(SudMGPMGState.MG_COMMON_GAME_COUNTDOWN_TIME)) {
                    c = 0;
                    break;
                }
                break;
            case -1941248683:
                if (str2.equals(SudMGPMGState.MG_COMMON_SELF_DIE_STATUS)) {
                    c = 1;
                    break;
                }
                break;
            case -1654460091:
                if (str2.equals(SudMGPMGState.MG_COMMON_PLAYER_CHANGE_SEAT)) {
                    c = 2;
                    break;
                }
                break;
            case -1400129573:
                if (str2.equals(SudMGPMGState.MG_DG_PAINTING)) {
                    c = 3;
                    break;
                }
                break;
            case -1297818699:
                if (str2.equals(SudMGPMGState.MG_COMMON_PLAYER_CAPTAIN)) {
                    c = 4;
                    break;
                }
                break;
            case -810961105:
                if (str2.equals(SudMGPMGState.MG_DG_SELECTING)) {
                    c = 5;
                    break;
                }
                break;
            case -155635375:
                if (str2.equals(SudMGPMGState.MG_COMMON_SELF_SELECT_STATUS)) {
                    c = 6;
                    break;
                }
                break;
            case 8137332:
                if (str2.equals(SudMGPMGState.MG_COMMON_PLAYER_READY)) {
                    c = 7;
                    break;
                }
                break;
            case 96096997:
                if (str2.equals(SudMGPMGState.MG_COMMON_SELF_CLICK_GAME_PLAYER_ICON)) {
                    c = '\b';
                    break;
                }
                break;
            case 167958004:
                if (str2.equals(SudMGPMGState.MG_COMMON_PLAYER_IN)) {
                    c = '\t';
                    break;
                }
                break;
            case 175013794:
                if (str2.equals(SudMGPMGState.MG_COMMON_PLAYER_ONLINE)) {
                    c = '\n';
                    break;
                }
                break;
            case 649971354:
                if (str2.equals(SudMGPMGState.MG_COMMON_SELF_OB_STATUS)) {
                    c = 11;
                    break;
                }
                break;
            case 965267675:
                if (str2.equals(SudMGPMGState.MG_DG_SCORE)) {
                    c = '\f';
                    break;
                }
                break;
            case 969613744:
                if (str2.equals(SudMGPMGState.MG_COMMON_SELF_TURN_STATUS)) {
                    c = '\r';
                    break;
                }
                break;
            case 1360159567:
                if (str2.equals(SudMGPMGState.MG_DG_ERRORANSWER)) {
                    c = 14;
                    break;
                }
                break;
            case 1597915429:
                if (str2.equals(SudMGPMGState.MG_DG_TOTALSCORE)) {
                    c = 15;
                    break;
                }
                break;
            case 1951019199:
                if (str2.equals(SudMGPMGState.MG_COMMON_PLAYER_PLAYING)) {
                    c = 16;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                SudMGPMGState.MGCommonGameCountdownTime mGCommonGameCountdownTime = (SudMGPMGState.MGCommonGameCountdownTime) SudJsonUtils.fromJson(str3, SudMGPMGState.MGCommonGameCountdownTime.class);
                if (sudFSMMGListener == null) {
                    ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                    return;
                } else {
                    sudFSMMGListener.onPlayerMGCommonGameCountdownTime(iSudFSMStateHandle, str, mGCommonGameCountdownTime);
                    return;
                }
            case 1:
                SudMGPMGState.MGCommonSelfDieStatus mGCommonSelfDieStatus = (SudMGPMGState.MGCommonSelfDieStatus) SudJsonUtils.fromJson(str3, SudMGPMGState.MGCommonSelfDieStatus.class);
                if (sudFSMMGListener == null) {
                    ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                    return;
                } else {
                    sudFSMMGListener.onPlayerMGCommonSelfDieStatus(iSudFSMStateHandle, str, mGCommonSelfDieStatus);
                    return;
                }
            case 2:
                SudMGPMGState.MGCommonPlayerChangeSeat mGCommonPlayerChangeSeat = (SudMGPMGState.MGCommonPlayerChangeSeat) SudJsonUtils.fromJson(str3, SudMGPMGState.MGCommonPlayerChangeSeat.class);
                if (sudFSMMGListener == null) {
                    ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                    return;
                } else {
                    sudFSMMGListener.onPlayerMGCommonPlayerChangeSeat(iSudFSMStateHandle, str, mGCommonPlayerChangeSeat);
                    return;
                }
            case 3:
                SudMGPMGState.MGDGPainting mGDGPainting = (SudMGPMGState.MGDGPainting) SudJsonUtils.fromJson(str3, SudMGPMGState.MGDGPainting.class);
                if (sudFSMMGListener == null) {
                    ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                    return;
                } else {
                    sudFSMMGListener.onPlayerMGDGPainting(iSudFSMStateHandle, str, mGDGPainting);
                    return;
                }
            case 4:
                SudMGPMGState.MGCommonPlayerCaptain mGCommonPlayerCaptain = (SudMGPMGState.MGCommonPlayerCaptain) SudJsonUtils.fromJson(str3, SudMGPMGState.MGCommonPlayerCaptain.class);
                this.sudFSMMGCache.onPlayerMGCommonPlayerCaptain(str, mGCommonPlayerCaptain);
                if (sudFSMMGListener == null) {
                    ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                    return;
                } else {
                    sudFSMMGListener.onPlayerMGCommonPlayerCaptain(iSudFSMStateHandle, str, mGCommonPlayerCaptain);
                    return;
                }
            case 5:
                SudMGPMGState.MGDGSelecting mGDGSelecting = (SudMGPMGState.MGDGSelecting) SudJsonUtils.fromJson(str3, SudMGPMGState.MGDGSelecting.class);
                if (sudFSMMGListener == null) {
                    ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                    return;
                } else {
                    sudFSMMGListener.onPlayerMGDGSelecting(iSudFSMStateHandle, str, mGDGSelecting);
                    return;
                }
            case 6:
                SudMGPMGState.MGCommonSelfSelectStatus mGCommonSelfSelectStatus = (SudMGPMGState.MGCommonSelfSelectStatus) SudJsonUtils.fromJson(str3, SudMGPMGState.MGCommonSelfSelectStatus.class);
                if (sudFSMMGListener == null) {
                    ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                    return;
                } else {
                    sudFSMMGListener.onPlayerMGCommonSelfSelectStatus(iSudFSMStateHandle, str, mGCommonSelfSelectStatus);
                    return;
                }
            case 7:
                SudMGPMGState.MGCommonPlayerReady mGCommonPlayerReady = (SudMGPMGState.MGCommonPlayerReady) SudJsonUtils.fromJson(str3, SudMGPMGState.MGCommonPlayerReady.class);
                this.sudFSMMGCache.onPlayerMGCommonPlayerReady(str, mGCommonPlayerReady);
                if (sudFSMMGListener == null) {
                    ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                    return;
                } else {
                    sudFSMMGListener.onPlayerMGCommonPlayerReady(iSudFSMStateHandle, str, mGCommonPlayerReady);
                    return;
                }
            case '\b':
                SudMGPMGState.MGCommonSelfClickGamePlayerIcon mGCommonSelfClickGamePlayerIcon = (SudMGPMGState.MGCommonSelfClickGamePlayerIcon) SudJsonUtils.fromJson(str3, SudMGPMGState.MGCommonSelfClickGamePlayerIcon.class);
                if (sudFSMMGListener == null) {
                    ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                    return;
                } else {
                    sudFSMMGListener.onPlayerMGCommonSelfClickGamePlayerIcon(iSudFSMStateHandle, str, mGCommonSelfClickGamePlayerIcon);
                    return;
                }
            case '\t':
                SudMGPMGState.MGCommonPlayerIn mGCommonPlayerIn = (SudMGPMGState.MGCommonPlayerIn) SudJsonUtils.fromJson(str3, SudMGPMGState.MGCommonPlayerIn.class);
                this.sudFSMMGCache.onPlayerMGCommonPlayerIn(str, mGCommonPlayerIn);
                if (sudFSMMGListener == null) {
                    ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                    return;
                } else {
                    sudFSMMGListener.onPlayerMGCommonPlayerIn(iSudFSMStateHandle, str, mGCommonPlayerIn);
                    return;
                }
            case '\n':
                SudMGPMGState.MGCommonPlayerOnline mGCommonPlayerOnline = (SudMGPMGState.MGCommonPlayerOnline) SudJsonUtils.fromJson(str3, SudMGPMGState.MGCommonPlayerOnline.class);
                if (sudFSMMGListener == null) {
                    ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                    return;
                } else {
                    sudFSMMGListener.onPlayerMGCommonPlayerOnline(iSudFSMStateHandle, str, mGCommonPlayerOnline);
                    return;
                }
            case 11:
                SudMGPMGState.MGCommonSelfObStatus mGCommonSelfObStatus = (SudMGPMGState.MGCommonSelfObStatus) SudJsonUtils.fromJson(str3, SudMGPMGState.MGCommonSelfObStatus.class);
                if (sudFSMMGListener == null) {
                    ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                    return;
                } else {
                    sudFSMMGListener.onPlayerMGCommonSelfObStatus(iSudFSMStateHandle, str, mGCommonSelfObStatus);
                    return;
                }
            case '\f':
                SudMGPMGState.MGDGScore mGDGScore = (SudMGPMGState.MGDGScore) SudJsonUtils.fromJson(str3, SudMGPMGState.MGDGScore.class);
                if (sudFSMMGListener == null) {
                    ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                    return;
                } else {
                    sudFSMMGListener.onPlayerMGDGScore(iSudFSMStateHandle, str, mGDGScore);
                    return;
                }
            case '\r':
                SudMGPMGState.MGCommonSelfTurnStatus mGCommonSelfTurnStatus = (SudMGPMGState.MGCommonSelfTurnStatus) SudJsonUtils.fromJson(str3, SudMGPMGState.MGCommonSelfTurnStatus.class);
                if (sudFSMMGListener == null) {
                    ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                    return;
                } else {
                    sudFSMMGListener.onPlayerMGCommonSelfTurnStatus(iSudFSMStateHandle, str, mGCommonSelfTurnStatus);
                    return;
                }
            case 14:
                SudMGPMGState.MGDGErroranswer mGDGErroranswer = (SudMGPMGState.MGDGErroranswer) SudJsonUtils.fromJson(str3, SudMGPMGState.MGDGErroranswer.class);
                if (sudFSMMGListener == null) {
                    ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                    return;
                } else {
                    sudFSMMGListener.onPlayerMGDGErroranswer(iSudFSMStateHandle, str, mGDGErroranswer);
                    return;
                }
            case 15:
                SudMGPMGState.MGDGTotalscore mGDGTotalscore = (SudMGPMGState.MGDGTotalscore) SudJsonUtils.fromJson(str3, SudMGPMGState.MGDGTotalscore.class);
                if (sudFSMMGListener == null) {
                    ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                    return;
                } else {
                    sudFSMMGListener.onPlayerMGDGTotalscore(iSudFSMStateHandle, str, mGDGTotalscore);
                    return;
                }
            case 16:
                SudMGPMGState.MGCommonPlayerPlaying mGCommonPlayerPlaying = (SudMGPMGState.MGCommonPlayerPlaying) SudJsonUtils.fromJson(str3, SudMGPMGState.MGCommonPlayerPlaying.class);
                this.sudFSMMGCache.onPlayerMGCommonPlayerPlaying(str, mGCommonPlayerPlaying);
                if (sudFSMMGListener == null) {
                    ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                    return;
                } else {
                    sudFSMMGListener.onPlayerMGCommonPlayerPlaying(iSudFSMStateHandle, str, mGCommonPlayerPlaying);
                    return;
                }
            default:
                ISudFSMStateHandleUtils.handleSuccess(iSudFSMStateHandle);
                return;
        }
    }

    public boolean playerIsIn(String str) {
        return this.sudFSMMGCache.playerIsIn(str);
    }

    public boolean playerIsPlaying(String str) {
        return this.sudFSMMGCache.playerIsPlaying(str);
    }

    public boolean playerIsReady(String str) {
        return this.sudFSMMGCache.playerIsReady(str);
    }

    public void setSudFSMMGListener(SudFSMMGListener sudFSMMGListener) {
        this.sudFSMMGListener = sudFSMMGListener;
    }
}
