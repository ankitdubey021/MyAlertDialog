package org.ankit.perfectdialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.widget.Button;

/**
 * Created by Administrator on 11/20/2017.
 */

public class EasyDialog {
    private Dialog dialog;
    private AlertDialog.Builder builder;
    private EasyDialogListener confirmListener,cancelListener;
    private boolean cancellable;
    private int icon;

    private Context ctx;
    private String title,subtitle,confirmTitle,cancelTitle,confirmBtnColor,cancelBtnColor;



    private EasyDialog(Builder builder){
        this.dialog=builder.dialog;
        this.builder=builder.builder;

       this.ctx=builder.ctx;
        this.title=builder.title;
        this.subtitle=builder.subtitle;
        this.confirmTitle=builder.confirmTitle;
        this.cancelTitle=builder.cancelTitle;
        this.confirmListener=builder.confirmListener;
        this.cancelListener=builder.cancelListener;
        this.cancellable=builder.cancellable;
        this.confirmBtnColor=builder.confirmBtnColor;
        this.cancelBtnColor=builder.cancelBtnColor;
        this.icon=builder.icon;
   }





    public static class Builder{

        private Dialog dialog;
        private AlertDialog.Builder builder;

        private Context ctx;
        private String title,subtitle,confirmTitle,cancelTitle,confirmBtnColor="#4d0099",cancelBtnColor="#0066ff";
        private EasyDialogListener confirmListener,cancelListener;
        private boolean cancellable;
        private int icon;


        public Builder(Context ctx){
            this.ctx=ctx;
        }

        public Builder setTitle(String title){
            this.title=title;
            return this;
        }

        public Builder setSubtitle(String subtitle){
            this.subtitle=subtitle;
            return this;
        }


        public Builder setConfirmBtn(String confirmTitle,EasyDialogListener listener){
            this.confirmTitle=confirmTitle;
            this.confirmListener=listener;
            return this;
        }

        public Builder setCancelBtn(String cancelTitle,EasyDialogListener listener){
            this.cancelTitle=cancelTitle;
            this.cancelListener=listener;
            return this;
        }

        public Builder isCancellable(boolean cancellable){
            this.cancellable=cancellable;
            return this;
        }

        public Builder setConfirmBtnColor(String color){
            this.confirmBtnColor=color;
            return this;
        }
        public Builder setCancelBtnColor(String color){
            this.cancelBtnColor=color;
            return this;
        }

        public Builder setIcon(Icon icon){
            switch(icon){
                case INFO:
                    this.icon=R.drawable.ic_error_outline_black_24dp;break;
                case SUCCESS:
                    this.icon=R.drawable.ic_check_black_24dp;break;
                case PERSON:
                    this.icon=R.drawable.ic_person_black_24dp;break;
            }
            return this;
        }


        public EasyDialog build(){
            builder = new AlertDialog.Builder(ctx);

            if(title!=null)
            builder.setTitle(title);
            else
                builder.setTitle("Hello World!");


            if(confirmListener!=null)
            builder.setPositiveButton(confirmTitle,confirmListener);
            else{
                builder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
            }

            if(cancelListener!=null){
                builder.setNegativeButton(cancelTitle,cancelListener);
            }

            if(subtitle!=null)
            builder.setMessage(subtitle);

            if(cancellable==false)
                builder.setCancelable(cancellable);

            if(icon!=0){
                builder.setIcon(icon);
            }

            dialog=builder.create();

            dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                @Override
                public void onShow(DialogInterface dialogInterface) {
                    Button b1,b2;
                    b1=((AlertDialog) dialogInterface).getButton(DialogInterface.BUTTON_POSITIVE);
                    b2=((AlertDialog) dialogInterface).getButton(DialogInterface.BUTTON_NEGATIVE);
                    try {
                        b1.setTextColor(Color.parseColor(confirmBtnColor));
                        b2.setTextColor(Color.parseColor(cancelBtnColor));
                    }catch(Exception e){
                        b1.setTextColor(Color.parseColor("#4d0099"));
                        b2.setTextColor(Color.parseColor("#0066ff"));
                    }

                }
            });


            dialog.show();


            return new EasyDialog(this);
        }
    }


}
