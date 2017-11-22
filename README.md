# MyAlertDialog

<img src="https://github.com/ankitdubey021/MyAlertDialog/blob/master/snapshot%5B1%5D.png" width="300" height="500"/>

```diff
+ compile 'com.github.ankitdubey021:MyAlertDialog:1.0.1'
```

```diff
+ new EasyCustomDialog.Builder(this,"Exit!")
                .setSubTitle("Are you Sure?")
                //.setHeader("Hello Guest")
                //.setIcon(getResources().getDrawable(R.drawable.ic_error_outline_black_24dp))
                //.setIcon(ContextCompat.getDrawable(this, R.drawable.animlogo))
                .setPositiveBtnText("Yes")
                .setNegativeBtnText("No")
                .onConfirm(new EasyCustomDialogListener() {
                    @Override
                    public void execute() {
                        Toast.makeText(getApplicationContext(),"Ok",Toast.LENGTH_LONG).show();
                    }
                })
                .onCancel(new EasyCustomDialogListener() {
                    @Override
                    public void execute() {
                        Toast.makeText(getApplicationContext(),"Cancel",Toast.LENGTH_LONG).show();
                    }
                })
                .build();
```

<h2> Simple Default Dialog</h2>

```diff
+ new EasyDialog.Builder(this)
                .setTitle("Exit!")
                .setSubtitle("Are you sure?")
                .isCancellable(true)
                .setCancelBtnColor("#008000")
                .setIcon(Icon.INFO)
                .setConfirmBtn("yes", new EasyDialogListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"done",Toast.LENGTH_LONG).show();
                    }
                })
                .setCancelBtn("no", new EasyDialogListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"cancelled!",Toast.LENGTH_LONG).show();
                    }
                })
                .build();
```
