package com.google.android.material.timepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.d1;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import com.google.android.material.timepicker.ClockHandView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class TimePickerView extends ConstraintLayout {

    /* renamed from: a, reason: collision with root package name */
    private final Chip f١٠٣٢٧a;

    /* renamed from: b, reason: collision with root package name */
    private final Chip f١٠٣٢٨b;

    /* renamed from: c, reason: collision with root package name */
    private final ClockHandView f١٠٣٢٩c;

    /* renamed from: d, reason: collision with root package name */
    private final ClockFaceView f١٠٣٣٠d;

    /* renamed from: e, reason: collision with root package name */
    private final MaterialButtonToggleGroup f١٠٣٣١e;

    /* renamed from: f, reason: collision with root package name */
    private final View.OnClickListener f١٠٣٣٢f;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TimePickerView.o(TimePickerView.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            TimePickerView.p(TimePickerView.this);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class c implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GestureDetector f١٠٣٣٥a;

        c(GestureDetector gestureDetector) {
            this.f١٠٣٣٥a = gestureDetector;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (((Checkable) view).isChecked()) {
                return this.f١٠٣٣٥a.onTouchEvent(motionEvent);
            }
            return false;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    interface d {
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    interface e {
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    interface f {
    }

    public TimePickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    static /* synthetic */ f o(TimePickerView timePickerView) {
        timePickerView.getClass();
        return null;
    }

    static /* synthetic */ d p(TimePickerView timePickerView) {
        timePickerView.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(MaterialButtonToggleGroup materialButtonToggleGroup, int i10, boolean z10) {
    }

    private void r() {
        Chip chip = this.f١٠٣٢٧a;
        int i10 = R.id.selection_type;
        chip.setTag(i10, 12);
        this.f١٠٣٢٨b.setTag(i10, 10);
        this.f١٠٣٢٧a.setOnClickListener(this.f١٠٣٣٢f);
        this.f١٠٣٢٨b.setOnClickListener(this.f١٠٣٣٢f);
        this.f١٠٣٢٧a.setAccessibilityClassName("android.view.View");
        this.f١٠٣٢٨b.setAccessibilityClassName("android.view.View");
    }

    private void s() {
        c cVar = new c(new GestureDetector(getContext(), new b()));
        this.f١٠٣٢٧a.setOnTouchListener(cVar);
        this.f١٠٣٢٨b.setOnTouchListener(cVar);
    }

    private void t(Chip chip, boolean z10) {
        int i10;
        chip.setChecked(z10);
        if (z10) {
            i10 = 2;
        } else {
            i10 = 0;
        }
        chip.setAccessibilityLiveRegion(i10);
    }

    public void addOnRotateListener(ClockHandView.c cVar) {
        this.f١٠٣٢٩c.addOnRotateListener(cVar);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        if (view == this && i10 == 0) {
            this.f١٠٣٢٨b.sendAccessibilityEvent(8);
        }
    }

    public void setActiveSelection(int i10) {
        boolean z10;
        Chip chip = this.f١٠٣٢٧a;
        boolean z11 = false;
        if (i10 == 12) {
            z10 = true;
        } else {
            z10 = false;
        }
        t(chip, z10);
        Chip chip2 = this.f١٠٣٢٨b;
        if (i10 == 10) {
            z11 = true;
        }
        t(chip2, z11);
    }

    public void setAnimateOnTouchUp(boolean z10) {
        this.f١٠٣٢٩c.setAnimateOnTouchUp(z10);
    }

    public void setHandRotation(float f10) {
        this.f١٠٣٢٩c.setHandRotation(f10);
    }

    public void setHourClickDelegate(androidx.core.view.a aVar) {
        d1.q0(this.f١٠٣٢٧a, aVar);
    }

    public void setMinuteHourDelegate(androidx.core.view.a aVar) {
        d1.q0(this.f١٠٣٢٨b, aVar);
    }

    public void setOnActionUpListener(ClockHandView.b bVar) {
        this.f١٠٣٢٩c.setOnActionUpListener(bVar);
    }

    void setOnDoubleTapListener(d dVar) {
    }

    void setOnPeriodChangeListener(e eVar) {
    }

    public TimePickerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٠٣٣٢f = new a();
        LayoutInflater.from(context).inflate(R.layout.material_timepicker, this);
        this.f١٠٣٣٠d = (ClockFaceView) findViewById(R.id.material_clock_face);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(R.id.material_clock_period_toggle);
        this.f١٠٣٣١e = materialButtonToggleGroup;
        materialButtonToggleGroup.addOnButtonCheckedListener(new MaterialButtonToggleGroup.b() { // from class: com.google.android.material.timepicker.e
            @Override // com.google.android.material.button.MaterialButtonToggleGroup.b
            public final void a(MaterialButtonToggleGroup materialButtonToggleGroup2, int i11, boolean z10) {
                TimePickerView.this.q(materialButtonToggleGroup2, i11, z10);
            }
        });
        this.f١٠٣٢٧a = (Chip) findViewById(R.id.material_minute_tv);
        this.f١٠٣٢٨b = (Chip) findViewById(R.id.material_hour_tv);
        this.f١٠٣٢٩c = (ClockHandView) findViewById(R.id.material_clock_hand);
        s();
        r();
    }
}
