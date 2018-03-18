package com.example.palomera.practica007;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    ImageView imagen;
    SeekBar seekBar;
    private int iWidth = 65; private int iHeight = 52;
    float density ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   /// calcular el display de las metricas
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        density = displayMetrics.densityDpi;

        imagen = (ImageView) findViewById(R.id.imageView);
        seekBar = (SeekBar) findViewById(R.id.seekBar);

        //eventos para la redireccion de la pantalla
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {


                float ancho = (i + iWidth) * density / 160;
                float alto = (i+ iHeight) * density / 160;
                imagen.getLayoutParams().height = (int)alto;
                imagen.getLayoutParams().width = (int)ancho;
                imagen.requestLayout();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
