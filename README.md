# MyAlertDialog

<img src="https://github.com/ankitdubey021/MyAlertDialog/blob/master/snapshot%5B1%5D.png" width="300" height="500"/>

## Releases
**this is the first release of library, which contains buttons in rectangle form.**
```groovy
compile 'com.github.ankitdubey021:MyAlertDialog:1.0.2'
```

**In this release, buttons are added in circular shape.**
```groovy
compile 'com.github.ankitdubey021:MyAlertDialog:1.0.3'
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

<h2> Custom Alert Dialog</h2>

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


<h2>MIT License</h2>

Copyright (c) 2017 Ankit Dubey

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
