package com.amazonaws.util.json;

import com.amazonaws.util.DateUtils;
import com.google.gson.g;
import com.google.gson.h;
import com.google.gson.i;
import com.google.gson.m;
import com.google.gson.o;
import com.google.gson.p;
import com.google.gson.q;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class DateDeserializer implements h, q {
    private final List<String> dateFormats;
    private final SimpleDateFormat mIso8601DateFormat = new SimpleDateFormat(DateUtils.ISO8601_DATE_PATTERN);
    private SimpleDateFormat mSimpleDateFormat;

    public DateDeserializer(String[] strArr) {
        this.dateFormats = Arrays.asList(strArr);
    }

    @Override // com.google.gson.h
    public Date deserialize(i iVar, Type type, g gVar) {
        String h10 = iVar.h();
        for (String str : this.dateFormats) {
            try {
                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
                this.mSimpleDateFormat = simpleDateFormat;
                date.setTime(simpleDateFormat.parse(h10).getTime());
                return date;
            } catch (ParseException unused) {
            }
        }
        try {
            return DateFormat.getDateInstance(2).parse(h10);
        } catch (ParseException e10) {
            throw new m(e10.getMessage(), e10);
        }
    }

    @Override // com.google.gson.q
    public i serialize(Date date, Type type, p pVar) {
        o oVar;
        synchronized (this.mIso8601DateFormat) {
            oVar = new o(this.mIso8601DateFormat.format(date));
        }
        return oVar;
    }
}
