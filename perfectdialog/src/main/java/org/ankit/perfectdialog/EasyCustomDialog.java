package org.ankit.perfectdialog;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Ankit Dubey on 22/11/2017.
 */

public class EasyCustomDialog {

    private String title,subTitle,header,positiveBtnText,negativeBtnText;
    private Activity activity;
    private Drawable icon;
    private EasyCustomDialogListener pListener,nListener;
    private int pBtnColor,nBtnColor;
    private boolean cancel;



    private EasyCustomDialog(Builder builder){
        this.title=builder.title;
        this.subTitle=builder.subTitle;
        this.activity=builder.activity;
        this.header=builder.header;
        this.icon=builder.icon;
        this.pListener=builder.pListener;
        this.nListener=builder.nListener;
        this.positiveBtnText=builder.positiveBtnText;
        this.negativeBtnText=builder.negativeBtnText;
        this.pBtnColor=builder.pBtnColor;
        this.nBtnColor=builder.nBtnColor;
        this.cancel=builder.cancel;
    }


    public static class Builder{
        private String title,subTitle,header,positiveBtnText,negativeBtnText;
        private Activity activity;
        private Drawable icon;
        private EasyCustomDialogListener pListener,nListener;
        private int pBtnColor,nBtnColor;
        private boolean cancel;

        public Builder(Activity activity,String title){
            this.activity=activity;
            this.title=title;
        }

        public Builder setSubTitle(String subTitle){
            this.subTitle=subTitle;
            return this;
        }

        public Builder setHeader(String header){
            this.header=header;
            return this;
        }

        public Builder setPositiveBtnText(String positiveBtnText){
            this.positiveBtnText=positiveBtnText;
            return this;
        }

        private Builder setPositiveBtnBackground(int pBtnColor){
            this.pBtnColor=pBtnColor;
            return this;
        }

        private Builder setNegativeBtnBackground(int nBtnColor){
            this.nBtnColor=nBtnColor;
            return this;
        }


        public Builder setNegativeBtnText(String negativeBtnText){
            this.negativeBtnText=negativeBtnText;
            return this;
        }
        //setIcon
        public Builder setIcon(Drawable icon){
            this.icon=icon;
            return this;
        }

        //set Positive listener
        public Builder onConfirm(EasyCustomDialogListener pListener){
            this.pListener=pListener;
            return this;
        }

        //set Negative listener
        public Builder onCancel(EasyCustomDialogListener nListener){
            this.nListener=nListener;
            return this;
        }

        public Builder isCancellable(boolean cancel){
            this.cancel=cancel;
            return this;
        }

        public EasyCustomDialog build(){
            TextView headerTv,titleTv,subTitleTv;
            ImageView iconImg;
            Button nBtn,pBtn;

            final Dialog dialog=new Dialog(activity);

            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


            dialog.setCancelable(cancel);

            dialog.setContentView(R.layout.custom_dialog);

            //getting resources
            headerTv = (TextView) dialog.findViewById(R.id.header);
            titleTv= (TextView) dialog.findViewById(R.id.title);
            subTitleTv=(TextView)dialog.findViewById(R.id.subtitle);

            iconImg=(ImageView)dialog.findViewById(R.id.icon);
            nBtn=(Button)dialog.findViewById(R.id.negativeBtn);
            pBtn=(Button)dialog.findViewById(R.id.positiveBtn);

            headerTv.setText(activity.getTitle()+"");
            titleTv.setText(title);

            if(subTitle!=null){
                subTitleTv.setVisibility(View.VISIBLE);
                subTitleTv.setText(subTitle);
            }
            if(header!=null)
                headerTv.setText(header);

            if(positiveBtnText!=null)
                pBtn.setText(positiveBtnText);

            if(pBtnColor!=0){
                pBtn.setBackgroundColor(pBtnColor);
            }
            if(nBtnColor!=0){
                nBtn.setBackgroundColor(nBtnColor);
            }


            if(negativeBtnText!=null)
                nBtn.setText(negativeBtnText);

            iconImg.setBackground(activity.getApplicationInfo().loadIcon(activity.getPackageManager()));
            iconImg.setVisibility(View.VISIBLE);

            //set icon
            if(icon!=null) {
                try {
                    iconImg.setBackground(icon);
                }
                catch(Exception e){
                    iconImg.setBackground(activity.getApplicationInfo().loadIcon(activity.getPackageManager()));
                }
            }


            if(pListener!=null) {
                pBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        pListener.execute();
                        dialog.dismiss();
                    }
                });
            }
            else{
                pBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }

                });
            }

            if(nListener!=null){
                nBtn.setVisibility(View.VISIBLE);
                nBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        nListener.execute();
                        dialog.dismiss();
                    }
                });
            }


            dialog.show();

            return new EasyCustomDialog(this);

        }
    }

}
