package com.example.spinwheel.javascript;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by amrut.bidri on 12-01-2017.
 */

public class WebAppInterface {
    Context mContext;

    /** Instantiate the interface and set the context */
    WebAppInterface(Context c) {
        mContext = c;
    }

    /**
     * Show Toast Message
     * @param toast
     */

    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }

    /**
     * Show Dialog
     * @param dialogMsg
     */
    @JavascriptInterface
    public void showDialog(String dialogMsg){
        AlertDialog alertDialog = new AlertDialog.Builder(mContext).create();

        // Setting Dialog Title
        alertDialog.setTitle("Congratulations!! You have won ");

        // Setting Dialog Message
        alertDialog.setMessage(dialogMsg);

        // Setting alert dialog icon
        //alertDialog.setIcon((status) ? R.drawable.success : R.drawable.fail);

        // Setting OK Button
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE,"OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(mContext, "Dialog dismissed!", Toast.LENGTH_SHORT).show();
            }
        });

        // Showing Alert Message
        alertDialog.show();
    }

    /**
     * Intent - Move to next screen
     */
    @JavascriptInterface
    public void moveToNextScreen(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);
        // Setting Dialog Title
        alertDialog.setTitle("Alert");
        // Setting Dialog Message
        alertDialog.setMessage("Are you sure you want to leave to next screen?");
        // Setting Positive "Yes" Button
        alertDialog.setPositiveButton("YES",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //Move to Next screen

                    }
                });
        // Setting Negative "NO" Button
        alertDialog.setNegativeButton("NO",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Cancel Dialog
                        dialog.cancel();
                    }
                });
        // Showing Alert Message
        alertDialog.show();
    }
}
