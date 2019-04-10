package com.example.frescodemo;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends AppCompatActivity {

    private SimpleDraweeView simpleDraweeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        simpleDraweeView = (SimpleDraweeView) findViewById(R.id.main_sdv);
        Uri imageUri = Uri.parse("https://is2-ssl.mzstatic.com/image/thumb/Video128/v4/60/72/2c/60722c73-3669-caea-a84b-cafbce0c5dc2/contsched.esfbfryu.lsr/268x0w.jpg");
        simpleDraweeView.setImageURI(imageUri);
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(imageUri)
                .setTapToRetryEnabled(true)
                .setOldController(simpleDraweeView.getController())
                .build();
        simpleDraweeView.setController(controller);
    }
}
