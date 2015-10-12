package com.aremox.lamorana.lamoraa;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class PuebloActivity extends AppCompatActivity {

    private Toolbar appbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pueblo);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.color_primary_dark));
        }

        //Localizar los controles
        TextView txtSaludo = (TextView)findViewById(R.id.puebloTitulo);

        //Recuperamos la información pasada en el intent
        Bundle bundle = this.getIntent().getExtras();

        //Construimos el mensaje a mostrar
        txtSaludo.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras sit amet aliquet ligula. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Aenean placerat ultrices purus. Donec sed nisl orci. Nulla dapibus tincidunt metus quis dignissim. Duis ante ante, gravida vitae leo vitae, imperdiet sagittis metus. Etiam ac orci id nisi mattis vulputate. Aenean id urna at turpis sagittis faucibus et ac tellus. Duis tellus dui, ornare ac mauris ut, congue feugiat erat. Donec risus tellus, molestie eget eleifend vel, sodales id tellus. Nullam ex velit, viverra eget massa sit amet, interdum molestie metus.\n" +
                "\n" +
                "Donec posuere ipsum a condimentum tristique. Mauris scelerisque dignissim convallis. Donec ultricies libero at dui convallis, ac scelerisque nibh bibendum. Morbi lorem dolor, elementum sed volutpat eget, suscipit sed dui. Aliquam sodales enim mattis justo convallis, ac faucibus ligula vehicula. Integer ullamcorper eleifend facilisis. Mauris dignissim elit et diam ultrices commodo. Pellentesque sit amet sapien et ipsum congue posuere. Maecenas porta leo magna, ac ultricies orci mattis nec. Morbi porta vestibulum dui, eget ultrices dolor aliquam eget. Etiam eu finibus tellus.\n" +
                "\n" +
                "Curabitur non velit lorem. Vestibulum in est vel orci interdum maximus. Praesent lectus ante, lacinia eu leo et, pharetra pretium nisi. Nunc porta gravida metus id rhoncus. Donec in vehicula diam. Suspendisse et purus placerat, tristique nisl eget, luctus ligula. Nam suscipit at erat non convallis. Sed a ante in dui aliquam rutrum vel sed est. Nullam mattis libero eget ligula sollicitudin, quis maximus justo pulvinar. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Phasellus felis quam, pellentesque nec aliquet sit amet, placerat sed erat. Aliquam a eleifend ligula, sed egestas leo. Donec porttitor ante in massa iaculis interdum.\n" +
                "\n" +
                "Maecenas gravida non nunc sed scelerisque. Pellentesque eu massa ultricies, rhoncus elit nec, sodales lectus. Suspendisse faucibus, felis nec dapibus pellentesque, neque felis pellentesque enim, vitae euismod est nunc eget massa. Phasellus tristique vehicula est non cursus. Morbi eget venenatis nisi, ac tincidunt leo. Nam luctus justo tempor, vehicula lacus quis, lobortis mi. Maecenas lacus purus, convallis sed suscipit in, egestas quis lacus. Proin vitae lectus enim. Donec eu sodales tellus. Vivamus suscipit, lectus sit amet porttitor dapibus, dolor nisl dignissim orci, vel volutpat elit enim eget nunc. Quisque viverra rhoncus rhoncus.\n" +
                "\n" +
                "Nunc ligula lectus, lacinia eu odio eget, tempor dignissim nisl. In consectetur dignissim semper. Aliquam vitae massa dapibus nunc auctor egestas. Ut feugiat sem id leo consequat finibus. Curabitur lectus ex, aliquet eu blandit a, tincidunt ullamcorper turpis. Sed molestie sem magna, eget sagittis augue consequat nec. Vivamus quis leo diam. Proin ac nunc vitae felis tempus convallis at eget urna. Vivamus vitae consectetur neque.\n" +
                "\n");

        appbar = (Toolbar)findViewById(R.id.puebloBar);
        setSupportActionBar(appbar);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_action_retorno);
        getSupportActionBar().setTitle(bundle.getString("NOMBRE"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pueblo, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
