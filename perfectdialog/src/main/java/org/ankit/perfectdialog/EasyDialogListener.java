package org.ankit.perfectdialog;

import android.content.DialogInterface;

/**
 * Created by Administrator on 11/20/2017.
 */

public interface EasyDialogListener extends DialogInterface.OnClickListener {
    @Override
    void onClick(DialogInterface dialogInterface, int i);
}
