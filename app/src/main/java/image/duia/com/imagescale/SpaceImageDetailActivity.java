package image.duia.com.imagescale;

/**
 * Created by ruanpeiying on 15/12/25.
 */
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class SpaceImageDetailActivity extends Activity {

    private ArrayList<String> mDatas;
    private int mPosition;
    private int mLocationX;
    private int mLocationY;
    private int mWidth;
    private int mHeight;
    imageviewmy  imageView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLocationX = getIntent().getIntExtra("locationX", 0);
        mLocationY = getIntent().getIntExtra("locationY", 0);
        mWidth = getIntent().getIntExtra("width", 0);
        mHeight = getIntent().getIntExtra("height", 0);

        imageView = new imageviewmy(this);
        imageView.setOriginalInfo(mWidth, mHeight, mLocationX, mLocationY);
        imageView.transformIn();
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        imageView.setScaleType(ScaleType.FIT_CENTER);
        RelativeLayout v = (RelativeLayout)LayoutInflater.from(this).inflate(R.layout.activity_main,null);
//        LinearLayout l =(LinearLayout) v.getChildAt(0);
        imageView.setImageResource(R.drawable.ic_launcher);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imageView.setOnTransformListener(new imageviewmy.TransformListener() {
                    @Override
                    public void onTransformComplete(int mode) {
                        if (mode == 2) {
                            finish();
                        }
                    }
                });
                imageView.transformOut();
            }
        });
        v.addView(imageView);
        setContentView(v);
    }

    @Override
    public void onBackPressed() {
        imageView.setOnTransformListener(new imageviewmy.TransformListener() {
            @Override
            public void onTransformComplete(int mode) {
                if (mode == 2) {
                    finish();
                }
            }
        });
        imageView.transformOut();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isFinishing()) {
            overridePendingTransition(0, 0);
        }
    }
}
