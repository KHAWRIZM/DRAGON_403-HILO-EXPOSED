package com.oudi.utils.date;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0014\u0010\u0010\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0019\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001d\u0010\u0016¨\u0006\u001e"}, d2 = {"Lcom/oudi/utils/date/TimeConstants;", "", "<init>", "()V", "MSEC", "", "getMSEC", "()I", "SEC", "getSEC", "MIN", "getMIN", "HOUR", "getHOUR", "DAY", "getDAY", "WEEK", "getWEEK", "CHINESE_ZODIAC", "", "", "getCHINESE_ZODIAC", "()[Ljava/lang/String;", "[Ljava/lang/String;", "ZODIAC_FLAGS", "", "getZODIAC_FLAGS", "()[I", "ZODIAC", "getZODIAC", "lib_utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class TimeConstants {
    public static final TimeConstants INSTANCE = new TimeConstants();
    private static final int MSEC = 1;
    private static final int SEC = 1000;
    private static final int MIN = DateUtils.MINUTE;
    private static final int HOUR = DateUtils.HOUR;
    private static final int DAY = DateUtils.DAY;
    private static final int WEEK = 604800000;
    private static final String[] CHINESE_ZODIAC = {"猴", "鸡", "狗", "猪", "鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊"};
    private static final int[] ZODIAC_FLAGS = {20, 19, 21, 21, 21, 22, 23, 23, 23, 24, 23, 22};
    private static final String[] ZODIAC = {"水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "魔羯座"};

    private TimeConstants() {
    }

    public final String[] getCHINESE_ZODIAC() {
        return CHINESE_ZODIAC;
    }

    public final int getDAY() {
        return DAY;
    }

    public final int getHOUR() {
        return HOUR;
    }

    public final int getMIN() {
        return MIN;
    }

    public final int getMSEC() {
        return MSEC;
    }

    public final int getSEC() {
        return SEC;
    }

    public final int getWEEK() {
        return WEEK;
    }

    public final String[] getZODIAC() {
        return ZODIAC;
    }

    public final int[] getZODIAC_FLAGS() {
        return ZODIAC_FLAGS;
    }
}
