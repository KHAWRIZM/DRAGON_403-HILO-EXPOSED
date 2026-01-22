package anet.channel.appmonitor;

import android.text.TextUtils;
import anet.channel.statist.AlarmObject;
import anet.channel.statist.CountObject;
import anet.channel.statist.Dimension;
import anet.channel.statist.Measure;
import anet.channel.statist.Monitor;
import anet.channel.statist.StatObject;
import anet.channel.util.ALog;
import anet.channel.util.StringUtils;
import anetwork.channel.config.NetworkConfigCenter;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.qiahao.base_common.network.interceptors.LoggingInterceptor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a implements IAppMonitor {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f٤٦٧٦a;

    /* renamed from: b, reason: collision with root package name */
    private static Map<Class<?>, List<Field>> f٤٦٧٧b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private static Map<Class<?>, List<Field>> f٤٦٧٨c = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    private static Map<Field, String> f٤٦٧٩d = new ConcurrentHashMap();

    /* renamed from: e, reason: collision with root package name */
    private static Random f٤٦٨٠e = new Random();

    /* renamed from: f, reason: collision with root package name */
    private static Set<Class<?>> f٤٦٨١f = Collections.newSetFromMap(new ConcurrentHashMap());

    public a() {
        try {
            Class.forName("com.alibaba.mtl.appmonitor.AppMonitor");
            f٤٦٧٦a = true;
        } catch (Exception unused) {
            f٤٦٧٦a = false;
        }
    }

    synchronized void a(Class<?> cls) {
        String name;
        String name2;
        if (cls != null) {
            try {
                if (f٤٦٧٦a) {
                    try {
                    } catch (Exception e10) {
                        ALog.e("awcn.DefaultAppMonitor", "register fail", null, e10, new Object[0]);
                    }
                    if (f٤٦٨١f.contains(cls)) {
                        return;
                    }
                    Monitor monitor = (Monitor) cls.getAnnotation(Monitor.class);
                    if (monitor == null) {
                        return;
                    }
                    Field[] fields = cls.getFields();
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    DimensionSet create = DimensionSet.create();
                    MeasureSet create2 = MeasureSet.create();
                    for (Field field : fields) {
                        Dimension dimension = (Dimension) field.getAnnotation(Dimension.class);
                        if (dimension != null) {
                            field.setAccessible(true);
                            arrayList.add(field);
                            if (dimension.name().equals("")) {
                                name2 = field.getName();
                            } else {
                                name2 = dimension.name();
                            }
                            f٤٦٧٩d.put(field, name2);
                            create.addDimension(name2);
                        } else {
                            Measure measure = (Measure) field.getAnnotation(Measure.class);
                            if (measure != null) {
                                field.setAccessible(true);
                                arrayList2.add(field);
                                if (measure.name().equals("")) {
                                    name = field.getName();
                                } else {
                                    name = measure.name();
                                }
                                f٤٦٧٩d.put(field, name);
                                if (measure.max() != Double.MAX_VALUE) {
                                    create2.addMeasure(new com.alibaba.mtl.appmonitor.model.Measure(name, Double.valueOf(measure.constantValue()), Double.valueOf(measure.min()), Double.valueOf(measure.max())));
                                } else {
                                    create2.addMeasure(name);
                                }
                            }
                        }
                    }
                    f٤٦٧٧b.put(cls, arrayList);
                    f٤٦٧٨c.put(cls, arrayList2);
                    com.alibaba.mtl.appmonitor.AppMonitor.register(monitor.module(), monitor.monitorPoint(), create2, create);
                    f٤٦٨١f.add(cls);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // anet.channel.appmonitor.IAppMonitor
    public void commitAlarm(AlarmObject alarmObject) {
        if (f٤٦٧٦a && alarmObject != null && !TextUtils.isEmpty(alarmObject.module) && !TextUtils.isEmpty(alarmObject.modulePoint)) {
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.DefaultAppMonitor", "commit alarm: " + alarmObject, null, new Object[0]);
            }
            if (!alarmObject.isSuccess) {
                AppMonitor.Alarm.commitFail(alarmObject.module, alarmObject.modulePoint, StringUtils.stringNull2Empty(alarmObject.arg), StringUtils.stringNull2Empty(alarmObject.errorCode), StringUtils.stringNull2Empty(alarmObject.errorMsg));
            } else {
                AppMonitor.Alarm.commitSuccess(alarmObject.module, alarmObject.modulePoint, StringUtils.stringNull2Empty(alarmObject.arg));
            }
        }
    }

    @Override // anet.channel.appmonitor.IAppMonitor
    public void commitCount(CountObject countObject) {
        if (f٤٦٧٦a && countObject != null && !TextUtils.isEmpty(countObject.module) && !TextUtils.isEmpty(countObject.modulePoint)) {
            if (ALog.isPrintLog(2)) {
                ALog.i("awcn.DefaultAppMonitor", "commit count: " + countObject, null, new Object[0]);
            }
            AppMonitor.Counter.commit(countObject.module, countObject.modulePoint, StringUtils.stringNull2Empty(countObject.arg), countObject.value);
        }
    }

    @Override // anet.channel.appmonitor.IAppMonitor
    public void commitStat(StatObject statObject) {
        HashMap hashMap;
        String obj;
        if (f٤٦٧٦a && statObject != null) {
            Class<?> cls = statObject.getClass();
            Monitor monitor = (Monitor) cls.getAnnotation(Monitor.class);
            if (monitor == null) {
                return;
            }
            if (!f٤٦٨١f.contains(cls)) {
                a(cls);
            }
            if (!statObject.beforeCommit()) {
                return;
            }
            if (monitor.monitorPoint().equals(LoggingInterceptor.TAG)) {
                int requestStatisticSampleRate = NetworkConfigCenter.getRequestStatisticSampleRate();
                if (requestStatisticSampleRate > 10000 || requestStatisticSampleRate < 0) {
                    requestStatisticSampleRate = 10000;
                }
                if (requestStatisticSampleRate != 10000 && f٤٦٨٠e.nextInt(10000) >= requestStatisticSampleRate) {
                    return;
                }
            }
            try {
                DimensionValueSet create = DimensionValueSet.create();
                MeasureValueSet create2 = MeasureValueSet.create();
                List<Field> list = f٤٦٧٧b.get(cls);
                if (ALog.isPrintLog(1)) {
                    hashMap = new HashMap();
                } else {
                    hashMap = null;
                }
                if (list != null) {
                    for (Field field : list) {
                        Object obj2 = field.get(statObject);
                        String str = f٤٦٧٩d.get(field);
                        if (obj2 == null) {
                            obj = "";
                        } else {
                            obj = obj2.toString();
                        }
                        create.setValue(str, obj);
                    }
                    for (Field field2 : f٤٦٧٨c.get(cls)) {
                        double d10 = field2.getDouble(statObject);
                        Double valueOf = Double.valueOf(d10);
                        create2.setValue(f٤٦٧٩d.get(field2), d10);
                        if (hashMap != null) {
                            hashMap.put(f٤٦٧٩d.get(field2), valueOf);
                        }
                    }
                }
                AppMonitor.Stat.commit(monitor.module(), monitor.monitorPoint(), create, create2);
                if (ALog.isPrintLog(1)) {
                    ALog.d("awcn.DefaultAppMonitor", "commit stat: " + monitor.monitorPoint(), null, "\nDimensions", create.getMap().toString(), "\nMeasures", hashMap.toString());
                }
            } catch (Throwable th) {
                ALog.e("awcn.DefaultAppMonitor", "commit monitor point failed", null, th, new Object[0]);
            }
        }
    }

    @Override // anet.channel.appmonitor.IAppMonitor
    @Deprecated
    public void register() {
    }

    @Override // anet.channel.appmonitor.IAppMonitor
    @Deprecated
    public void register(Class<?> cls) {
    }
}
