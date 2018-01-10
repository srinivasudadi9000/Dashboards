package schemax.brandix_charts;

import android.animation.Animator;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends Activity {
    ImageView brandix_logo_img;
    Animator animator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        brandix_logo_img = (ImageView) findViewById(R.id.brandix_logo_img);
        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.zoomin);
        brandix_logo_img.startAnimation(hyperspaceJumpAnimation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent cipp = new Intent(SplashScreen.this,Cipp.class);
                startActivity(cipp);
            }
        },3000);

    }
}
