package image.duia.com.imagescale;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by ruanpeiying on 15/12/25.
 */
public class myActivity extends Activity {
    imageviewmy imageView,imageView1,imageView2,imageView3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        imageView= (imageviewmy) findViewById(R.id.icon_image);

        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setOnClickListener(clicklenter);

    }
    private View.OnClickListener clicklenter=new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(myActivity.this, SpaceImageDetailActivity.class);
            int[] location = new int[2];
            v.getLocationOnScreen(location);
            intent.putExtra("locationX", location[0]);
            intent.putExtra("locationY", location[1]);

            intent.putExtra("width", v.getWidth());
            intent.putExtra("height", v.getHeight());
            startActivity(intent);
            overridePendingTransition(0, 0);
        }
    };
}
