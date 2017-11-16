package com.example.admin.testapplanguage;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.admin.testapplanguage.AlertDialogInterface.code;

public class LaguageSelectorActivity extends Activity implements AlertDialogInterface.AlertPositiveListener {
    /** Stores the selected item's position */
    int position = 0;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laguage_selector);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();

                AlertDialogInterface alert = new AlertDialogInterface();
                Bundle b  = new Bundle();
                b.putInt("position", position);
                alert.setArguments(b);
                alert.show(manager, "alert_dialog_radio");
            }
        };

        /** Getting the reference of the button from the main layout */
        Button btn = (Button) findViewById(R.id.btn_choose);

        /** Setting a button click listener for the choose button */
        btn.setOnClickListener(listener);
    }

    /** Defining button click listener for the OK button of the alert dialog window */
    @Override
    public void onPositiveClick(int position) {
        this.position = position;

        /** Getting the reference of the textview from the main layout */
        TextView tv = (TextView) findViewById(R.id.tv_android);
        /** Setting the selected android version in the textview */
        tv.setText("Your Choice : " + code[this.position]);
    }
}
