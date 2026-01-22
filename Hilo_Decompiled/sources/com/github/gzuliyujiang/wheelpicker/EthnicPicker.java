package com.github.gzuliyujiang.wheelpicker;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import q6.g;
import s6.d;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class EthnicPicker extends OptionPicker {

    /* renamed from: r, reason: collision with root package name */
    public static String f٧٩٦١r = "[{\"code\":\"01\",\"name\":\"汉族\",\"spelling\":\"Han\"},{\"code\":\"02\",\"name\":\"蒙古族\",\"spelling\":\"Mongol\"},{\"code\":\"03\",\"name\":\"回族\",\"spelling\":\"Hui\"},{\"code\":\"04\",\"name\":\"藏族\",\"spelling\":\"Zang\"},{\"code\":\"05\",\"name\":\"维吾尔族\",\"spelling\":\"Uygur\"},{\"code\":\"06\",\"name\":\"苗族\",\"spelling\":\"Miao\"},{\"code\":\"07\",\"name\":\"彝族\",\"spelling\":\"Yi\"},{\"code\":\"08\",\"name\":\"壮族\",\"spelling\":\"Zhuang\"},{\"code\":\"09\",\"name\":\"布依族\",\"spelling\":\"Buyei\"},{\"code\":\"10\",\"name\":\"朝鲜族\",\"spelling\":\"Chosen\"},{\"code\":\"11\",\"name\":\"满族\",\"spelling\":\"Man\"},{\"code\":\"12\",\"name\":\"侗族\",\"spelling\":\"Dong\"},{\"code\":\"13\",\"name\":\"瑶族\",\"spelling\":\"Yao\"},{\"code\":\"14\",\"name\":\"白族\",\"spelling\":\"Bai\"},{\"code\":\"15\",\"name\":\"土家族\",\"spelling\":\"Tujia\"},{\"code\":\"16\",\"name\":\"哈尼族\",\"spelling\":\"Hani\"},{\"code\":\"17\",\"name\":\"哈萨克族\",\"spelling\":\"Kazak\"},{\"code\":\"18\",\"name\":\"傣族\",\"spelling\":\"Dai\"},{\"code\":\"19\",\"name\":\"黎族\",\"spelling\":\"Li\"},{\"code\":\"20\",\"name\":\"傈僳族\",\"spelling\":\"Lisu\"},{\"code\":\"21\",\"name\":\"佤族\",\"spelling\":\"Va\"},{\"code\":\"22\",\"name\":\"畲族\",\"spelling\":\"She\"},{\"code\":\"23\",\"name\":\"高山族\",\"spelling\":\"Gaoshan\"},{\"code\":\"24\",\"name\":\"拉祜族\",\"spelling\":\"Lahu\"},{\"code\":\"25\",\"name\":\"水族\",\"spelling\":\"Sui\"},{\"code\":\"26\",\"name\":\"东乡族\",\"spelling\":\"Dongxiang\"},{\"code\":\"27\",\"name\":\"纳西族\",\"spelling\":\"Naxi\"},{\"code\":\"28\",\"name\":\"景颇族\",\"spelling\":\"Jingpo\"},{\"code\":\"29\",\"name\":\"柯尔克孜族\",\"spelling\":\"Kirgiz\"},{\"code\":\"30\",\"name\":\"土族\",\"spelling\":\"Tu\"},{\"code\":\"31\",\"name\":\"达斡尔族\",\"spelling\":\"Daur\"},{\"code\":\"32\",\"name\":\"仫佬族\",\"spelling\":\"Mulao\"},{\"code\":\"33\",\"name\":\"羌族\",\"spelling\":\"Qiang\"},{\"code\":\"34\",\"name\":\"布朗族\",\"spelling\":\"Blang\"},{\"code\":\"35\",\"name\":\"撒拉族\",\"spelling\":\"Salar\"},{\"code\":\"36\",\"name\":\"毛难族\",\"spelling\":\"Maonan\"},{\"code\":\"37\",\"name\":\"仡佬族\",\"spelling\":\"Gelao\"},{\"code\":\"38\",\"name\":\"锡伯族\",\"spelling\":\"Xibe\"},{\"code\":\"39\",\"name\":\"阿昌族\",\"spelling\":\"Achang\"},{\"code\":\"40\",\"name\":\"普米族\",\"spelling\":\"Pumi\"},{\"code\":\"41\",\"name\":\"塔吉克族\",\"spelling\":\"Tajik\"},{\"code\":\"42\",\"name\":\"怒族\",\"spelling\":\"Nu\"},{\"code\":\"43\",\"name\":\"乌孜别克族\",\"spelling\":\"Uzbek\"},{\"code\":\"44\",\"name\":\"俄罗斯族\",\"spelling\":\"Russ\"},{\"code\":\"45\",\"name\":\"鄂温克族\",\"spelling\":\"Ewenki\"},{\"code\":\"46\",\"name\":\"德昂族\",\"spelling\":\"Deang\"},{\"code\":\"47\",\"name\":\"保安族\",\"spelling\":\"Bonan\"},{\"code\":\"48\",\"name\":\"裕固族\",\"spelling\":\"Yugur\"},{\"code\":\"49\",\"name\":\"京族\",\"spelling\":\"Gin\"},{\"code\":\"50\",\"name\":\"塔塔尔族\",\"spelling\":\"Tatar\"},{\"code\":\"51\",\"name\":\"独龙族\",\"spelling\":\"Derung\"},{\"code\":\"52\",\"name\":\"鄂伦春族\",\"spelling\":\"Oroqen\"},{\"code\":\"53\",\"name\":\"赫哲族\",\"spelling\":\"Hezhen\"},{\"code\":\"54\",\"name\":\"门巴族\",\"spelling\":\"Monba\"},{\"code\":\"55\",\"name\":\"珞巴族\",\"spelling\":\"Lhoba\"},{\"code\":\"56\",\"name\":\"基诺族\",\"spelling\":\"Jino\"}]";

    /* renamed from: q, reason: collision with root package name */
    private int f٧٩٦٢q;

    @Override // com.github.gzuliyujiang.wheelpicker.OptionPicker
    protected List L() {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(f٧٩٦١r);
            int length = jSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                d dVar = new d();
                dVar.b(jSONObject.getString("code"));
                dVar.c(jSONObject.getString("name"));
                dVar.d(jSONObject.getString("spelling"));
                arrayList.add(dVar);
            }
        } catch (JSONException e10) {
            g.a(e10);
        }
        int i11 = this.f٧٩٦٢q;
        if (i11 != 1) {
            if (i11 == 3) {
                d dVar2 = new d();
                dVar2.b("97");
                dVar2.c("未定族称人口");
                dVar2.d("Unrecognized");
                arrayList.add(dVar2);
                d dVar3 = new d();
                dVar3.b("98");
                dVar3.c("入籍");
                dVar3.d("Naturalization");
                arrayList.add(dVar3);
            }
        } else {
            d dVar4 = new d();
            dVar4.b("97");
            dVar4.c("其他");
            dVar4.d("Other");
            arrayList.add(dVar4);
            d dVar5 = new d();
            dVar5.b("98");
            dVar5.c("外国血统");
            dVar5.d("Foreign");
            arrayList.add(dVar5);
        }
        return arrayList;
    }
}
