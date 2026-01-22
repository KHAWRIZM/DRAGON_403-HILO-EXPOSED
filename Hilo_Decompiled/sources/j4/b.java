package j4;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bigkoo.pickerview.R;
import java.text.ParseException;
import java.util.Calendar;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class b extends j4.a implements View.OnClickListener {

    /* renamed from: p, reason: collision with root package name */
    private c f١٥٢٢٧p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class a implements h4.b {
        a() {
        }

        @Override // h4.b
        public void a() {
            try {
                b.this.f١٥٢١٠e.f١٤٤٠٠c.a(c.f١٥٢٢٩t.parse(b.this.f١٥٢٢٧p.o()));
            } catch (ParseException e10) {
                e10.printStackTrace();
            }
        }
    }

    public b(g4.a aVar) {
        super(aVar.F);
        this.f١٥٢١٠e = aVar;
        z(aVar.F);
    }

    private void A(LinearLayout linearLayout) {
        int i10;
        g4.a aVar = this.f١٥٢١٠e;
        c cVar = new c(linearLayout, aVar.f١٤٤٠٧i, aVar.E, aVar.Q);
        this.f١٥٢٢٧p = cVar;
        if (this.f١٥٢١٠e.f١٤٤٠٠c != null) {
            cVar.F(new a());
        }
        this.f١٥٢٢٧p.B(this.f١٥٢١٠e.f١٤٤١٤p);
        g4.a aVar2 = this.f١٥٢١٠e;
        int i11 = aVar2.f١٤٤١١m;
        if (i11 != 0 && (i10 = aVar2.f١٤٤١٢n) != 0 && i11 <= i10) {
            D();
        }
        g4.a aVar3 = this.f١٥٢١٠e;
        Calendar calendar = aVar3.f١٤٤٠٩k;
        if (calendar != null && aVar3.f١٤٤١٠l != null) {
            if (calendar.getTimeInMillis() <= this.f١٥٢١٠e.f١٤٤١٠l.getTimeInMillis()) {
                C();
            } else {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
        } else if (calendar != null) {
            if (calendar.get(1) >= 1900) {
                C();
            } else {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
        } else {
            Calendar calendar2 = aVar3.f١٤٤١٠l;
            if (calendar2 != null) {
                if (calendar2.get(1) <= 2100) {
                    C();
                } else {
                    throw new IllegalArgumentException("The endDate should not be later than 2100");
                }
            } else {
                C();
            }
        }
        E();
        c cVar2 = this.f١٥٢٢٧p;
        g4.a aVar4 = this.f١٥٢١٠e;
        cVar2.y(aVar4.f١٤٤١٥q, aVar4.f١٤٤١٦r, aVar4.f١٤٤١٧s, aVar4.f١٤٤١٨t, aVar4.f١٤٤١٩u, aVar4.f١٤٤٢٠v);
        c cVar3 = this.f١٥٢٢٧p;
        g4.a aVar5 = this.f١٥٢١٠e;
        cVar3.K(aVar5.f١٤٤٢١w, aVar5.f١٤٤٢٢x, aVar5.f١٤٤٢٣y, aVar5.f١٤٤٢٤z, aVar5.A, aVar5.f١٤٣٩٥B);
        this.f١٥٢٢٧p.x(this.f١٥٢١٠e.f١٤٣٩٩b0);
        this.f١٥٢٢٧p.q(this.f١٥٢١٠e.f١٤٤٠١c0);
        s(this.f١٥٢١٠e.X);
        this.f١٥٢٢٧p.t(this.f١٥٢١٠e.f١٤٤١٣o);
        this.f١٥٢٢٧p.u(this.f١٥٢١٠e.T);
        this.f١٥٢٢٧p.v(this.f١٥٢١٠e.f١٤٣٩٧a0);
        this.f١٥٢٢٧p.z(this.f١٥٢١٠e.V);
        this.f١٥٢٢٧p.J(this.f١٥٢١٠e.R);
        this.f١٥٢٢٧p.I(this.f١٥٢١٠e.S);
        this.f١٥٢٢٧p.p(this.f١٥٢١٠e.Y);
    }

    private void C() {
        c cVar = this.f١٥٢٢٧p;
        g4.a aVar = this.f١٥٢١٠e;
        cVar.D(aVar.f١٤٤٠٩k, aVar.f١٤٤١٠l);
        y();
    }

    private void D() {
        this.f١٥٢٢٧p.H(this.f١٥٢١٠e.f١٤٤١١m);
        this.f١٥٢٢٧p.w(this.f١٥٢١٠e.f١٤٤١٢n);
    }

    private void E() {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = this.f١٥٢١٠e.f١٤٤٠٨j;
        if (calendar2 == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i10 = calendar.get(1);
            i11 = calendar.get(2);
            i12 = calendar.get(5);
            i13 = calendar.get(11);
            i14 = calendar.get(12);
            i15 = calendar.get(13);
        } else {
            i10 = calendar2.get(1);
            i11 = this.f١٥٢١٠e.f١٤٤٠٨j.get(2);
            i12 = this.f١٥٢١٠e.f١٤٤٠٨j.get(5);
            i13 = this.f١٥٢١٠e.f١٤٤٠٨j.get(11);
            i14 = this.f١٥٢١٠e.f١٤٤٠٨j.get(12);
            i15 = this.f١٥٢١٠e.f١٤٤٠٨j.get(13);
        }
        this.f١٥٢٢٧p.C(i10, i11, i12, i13, i14, i15);
    }

    private void y() {
        g4.a aVar = this.f١٥٢١٠e;
        Calendar calendar = aVar.f١٤٤٠٩k;
        if (calendar != null && aVar.f١٤٤١٠l != null) {
            Calendar calendar2 = aVar.f١٤٤٠٨j;
            if (calendar2 == null || calendar2.getTimeInMillis() < this.f١٥٢١٠e.f١٤٤٠٩k.getTimeInMillis() || this.f١٥٢١٠e.f١٤٤٠٨j.getTimeInMillis() > this.f١٥٢١٠e.f١٤٤١٠l.getTimeInMillis()) {
                g4.a aVar2 = this.f١٥٢١٠e;
                aVar2.f١٤٤٠٨j = aVar2.f١٤٤٠٩k;
                return;
            }
            return;
        }
        if (calendar != null) {
            aVar.f١٤٤٠٨j = calendar;
            return;
        }
        Calendar calendar3 = aVar.f١٤٤١٠l;
        if (calendar3 != null) {
            aVar.f١٤٤٠٨j = calendar3;
        }
    }

    private void z(Context context) {
        String str;
        String str2;
        String str3;
        q();
        m();
        l();
        h4.a aVar = this.f١٥٢١٠e.f١٤٤٠٢d;
        if (aVar == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.f١٥٢٠٧b);
            TextView textView = (TextView) i(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) i(R.id.rv_topbar);
            Button button = (Button) i(R.id.btnSubmit);
            Button button2 = (Button) i(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag("cancel");
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            if (TextUtils.isEmpty(this.f١٥٢١٠e.G)) {
                str = context.getResources().getString(R.string.pickerview_submit);
            } else {
                str = this.f١٥٢١٠e.G;
            }
            button.setText(str);
            if (TextUtils.isEmpty(this.f١٥٢١٠e.H)) {
                str2 = context.getResources().getString(R.string.pickerview_cancel);
            } else {
                str2 = this.f١٥٢١٠e.H;
            }
            button2.setText(str2);
            if (TextUtils.isEmpty(this.f١٥٢١٠e.I)) {
                str3 = "";
            } else {
                str3 = this.f١٥٢١٠e.I;
            }
            textView.setText(str3);
            button.setTextColor(this.f١٥٢١٠e.J);
            button2.setTextColor(this.f١٥٢١٠e.K);
            textView.setTextColor(this.f١٥٢١٠e.L);
            relativeLayout.setBackgroundColor(this.f١٥٢١٠e.N);
            button.setTextSize(this.f١٥٢١٠e.O);
            button2.setTextSize(this.f١٥٢١٠e.O);
            textView.setTextSize(this.f١٥٢١٠e.P);
        } else {
            aVar.a(LayoutInflater.from(context).inflate(this.f١٥٢١٠e.C, this.f١٥٢٠٧b));
        }
        LinearLayout linearLayout = (LinearLayout) i(R.id.timepicker);
        linearLayout.setBackgroundColor(this.f١٥٢١٠e.M);
        A(linearLayout);
    }

    public void B() {
        if (this.f١٥٢١٠e.f١٤٣٩٦a != null) {
            try {
                this.f١٥٢١٠e.f١٤٣٩٦a.a(c.f١٥٢٢٩t.parse(this.f١٥٢٢٧p.o()), this.f١٥٢١٧l);
            } catch (ParseException e10) {
                e10.printStackTrace();
            }
        }
    }

    @Override // j4.a
    public boolean n() {
        return this.f١٥٢١٠e.W;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        String str = (String) view.getTag();
        if (str.equals("submit")) {
            B();
        } else if (str.equals("cancel") && (onClickListener = this.f١٥٢١٠e.f١٤٣٩٨b) != null) {
            onClickListener.onClick(view);
        }
        f();
    }
}
