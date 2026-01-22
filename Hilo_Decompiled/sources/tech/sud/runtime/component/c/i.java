package tech.sud.runtime.component.c;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class i {
    private tech.sud.runtime.core.b a;
    private SensorManager b = null;
    private a c = null;
    private a d = null;
    private a e = null;
    private a f = null;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static class a {
        private Sensor a;
        private SensorEventListener b;
        private int c;

        /* JADX INFO: Access modifiers changed from: private */
        public void a(SensorManager sensorManager) {
            sensorManager.registerListener(this.b, this.a, this.c);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(SensorManager sensorManager) {
            sensorManager.unregisterListener(this.b, this.a);
        }

        private a(tech.sud.runtime.core.b bVar, SensorManager sensorManager, int i, int i2) {
            this.a = sensorManager.getDefaultSensor(i);
            this.b = new b(bVar);
            this.c = i2;
        }

        private a(tech.sud.runtime.core.b bVar, SensorManager sensorManager, int i, int i2, int i3) {
            this.a = sensorManager.getDefaultSensor(i);
            this.b = new b(bVar, i3);
            this.c = i2;
        }
    }

    public i(tech.sud.runtime.core.b bVar) {
        this.a = bVar;
    }

    private static int b(int i) {
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                return 3;
            }
        }
        return i2;
    }

    public void a() {
        this.a = null;
        a aVar = this.c;
        if (aVar != null) {
            aVar.b(this.b);
            this.c = null;
        }
        a aVar2 = this.d;
        if (aVar2 != null) {
            aVar2.b(this.b);
            this.d = null;
        }
        a aVar3 = this.e;
        if (aVar3 != null) {
            aVar3.b(this.b);
            this.e = null;
        }
        a aVar4 = this.f;
        if (aVar4 != null) {
            aVar4.b(this.b);
            this.f = null;
        }
        this.b = null;
    }

    public void c() {
        SensorManager sensorManager = this.b;
        if (sensorManager != null) {
            a aVar = this.c;
            if (aVar != null) {
                aVar.a(sensorManager);
            }
            a aVar2 = this.d;
            if (aVar2 != null) {
                aVar2.a(this.b);
            }
            a aVar3 = this.e;
            if (aVar3 != null) {
                aVar3.a(this.b);
            }
            a aVar4 = this.f;
            if (aVar4 != null) {
                aVar4.a(this.b);
            }
        }
    }

    public void b() {
        SensorManager sensorManager = this.b;
        if (sensorManager != null) {
            a aVar = this.c;
            if (aVar != null) {
                aVar.b(sensorManager);
            }
            a aVar2 = this.d;
            if (aVar2 != null) {
                aVar2.b(this.b);
            }
            a aVar3 = this.e;
            if (aVar3 != null) {
                aVar3.b(this.b);
            }
            a aVar4 = this.f;
            if (aVar4 != null) {
                aVar4.b(this.b);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static class b implements SensorEventListener {
        private tech.sud.runtime.core.b a;
        private int b;
        private String c = "low";

        public b(tech.sud.runtime.core.b bVar) {
            this.a = bVar;
        }

        private void a(String str, JSONObject jSONObject) {
            tech.sud.runtime.core.b bVar = this.a;
            if (bVar == null) {
                return;
            }
            bVar.a(str, jSONObject);
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
            if (sensor.getType() == 3) {
                if (i != 2) {
                    if (i != 3) {
                        this.c = "low";
                        return;
                    } else {
                        this.c = "high";
                        return;
                    }
                }
                this.c = "medium";
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            int type = sensorEvent.sensor.getType();
            if (type != 1) {
                if (type != 3) {
                    if (type == 4) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("x", sensorEvent.values[0]);
                            jSONObject.put("y", sensorEvent.values[1]);
                            jSONObject.put("z", sensorEvent.values[2]);
                        } catch (JSONException unused) {
                        }
                        a("GyroscopeChange", jSONObject);
                        return;
                    }
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                if (this.b == 3) {
                    try {
                        jSONObject2.put("alpha", sensorEvent.values[0]);
                        jSONObject2.put("beta", sensorEvent.values[1]);
                        jSONObject2.put("gamma", sensorEvent.values[2]);
                    } catch (JSONException unused2) {
                    }
                    a("DeviceMotionChange", jSONObject2);
                    return;
                }
                try {
                    jSONObject2.put("direction", sensorEvent.values[0]);
                    jSONObject2.put("accuracy", this.c);
                } catch (JSONException unused3) {
                }
                a("CompassChange", jSONObject2);
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("x", sensorEvent.values[0] * (-0.1d));
                jSONObject3.put("y", sensorEvent.values[1] * (-0.1d));
                jSONObject3.put("z", sensorEvent.values[2] * (-0.1d));
            } catch (JSONException unused4) {
            }
            a("AccelerometerChange", jSONObject3);
        }

        public b(tech.sud.runtime.core.b bVar, int i) {
            this.a = bVar;
            this.b = i;
        }
    }

    public void a(int i, int i2) {
        Context d;
        tech.sud.runtime.core.b bVar = this.a;
        if (bVar == null || (d = bVar.d()) == null) {
            return;
        }
        if (this.b == null) {
            this.b = (SensorManager) d.getSystemService("sensor");
        }
        int b2 = b(i2);
        if (i == 1) {
            if (this.c == null) {
                a aVar = new a(bVar, this.b, 1, b2);
                this.c = aVar;
                aVar.a(this.b);
                return;
            }
            return;
        }
        if (i == 2) {
            if (this.d == null) {
                a aVar2 = new a(bVar, this.b, 3, 3);
                this.d = aVar2;
                aVar2.a(this.b);
                return;
            }
            return;
        }
        if (i != 3) {
            if (i == 4 && this.e == null) {
                a aVar3 = new a(bVar, this.b, 4, b2);
                this.e = aVar3;
                aVar3.a(this.b);
                return;
            }
            return;
        }
        if (this.f == null) {
            a aVar4 = new a(bVar, this.b, 3, b2, 3);
            this.f = aVar4;
            aVar4.a(this.b);
        }
    }

    public void a(int i) {
        a aVar;
        if (i == 1) {
            a aVar2 = this.c;
            if (aVar2 != null) {
                aVar2.b(this.b);
                this.c = null;
                return;
            }
            return;
        }
        if (i == 2) {
            a aVar3 = this.d;
            if (aVar3 != null) {
                aVar3.b(this.b);
                this.d = null;
                return;
            }
            return;
        }
        if (i != 3) {
            if (i == 4 && (aVar = this.e) != null) {
                aVar.b(this.b);
                this.e = null;
                return;
            }
            return;
        }
        a aVar4 = this.f;
        if (aVar4 != null) {
            aVar4.b(this.b);
            this.f = null;
        }
    }
}
