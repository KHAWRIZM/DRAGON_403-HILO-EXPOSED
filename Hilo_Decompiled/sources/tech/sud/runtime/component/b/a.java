package tech.sud.runtime.component.b;

import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import java.util.ArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class a {
    private Context a;
    private final ArrayList<String> b = new ArrayList<>();
    private AlertDialog c = null;

    public a(Context context) {
        this.a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.b.isEmpty() || this.a == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
        builder.setMessage(this.b.get(0));
        this.b.remove(0);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: tech.sud.runtime.component.b.a.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog show = builder.show();
        this.c = show;
        show.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: tech.sud.runtime.component.b.a.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.c = null;
                a.this.b();
            }
        });
    }

    public void a(String str) {
        this.b.add(str);
        if (this.c == null) {
            b();
        }
    }

    public void a() {
        this.b.clear();
        AlertDialog alertDialog = this.c;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }
}
