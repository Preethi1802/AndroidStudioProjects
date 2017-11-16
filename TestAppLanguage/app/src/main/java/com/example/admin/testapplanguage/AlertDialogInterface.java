package com.example.admin.testapplanguage;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class AlertDialogInterface extends DialogFragment {

    static String[] code = new String[]{
            "Jelly Bean",
            "Ice Cream Sandwich",
            "Honeycomb",
            "Gingerbread",
            "Froyo",
            "Eclair",
            "Donut",
            "Cupcake"
    };

    static AlertPositiveListener alertPositiveListener;

    interface AlertPositiveListener {
        void onPositiveClick(int position);
    }

    public void onAttach(android.app.Activity activity) {
        super.onAttach(activity);
        try{
            alertPositiveListener = (AlertPositiveListener) activity;
        }catch(ClassCastException e){
            throw new ClassCastException(activity.toString() + " must implement AlertPositiveListener");
        }
    }

    DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            AlertDialog alert = (AlertDialog) dialog;
            int position = alert.getListView().getCheckedItemPosition();
            alertPositiveListener.onPositiveClick(position);
        }
    };

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Bundle bundle = getArguments();
        int position = bundle.getInt("position");
        AlertDialog.Builder b = new AlertDialog.Builder(getActivity());
        b.setTitle("Choose your version");
        b.setSingleChoiceItems(code, position, null);
        b.setPositiveButton("OK", listener);
        b.setNegativeButton("Cancel", null);
        AlertDialog d = b.create();
        return d;
    }
}