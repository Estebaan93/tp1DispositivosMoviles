package com.example.tp1dispositivosmoviles;

import static android.content.Intent.ACTION_AIRPLANE_MODE_CHANGED;

import android.content.IntentFilter;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
  private ModoAvionCambio cambio;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    cambio= new ModoAvionCambio();
    }

    @Override
  protected void onResume(){
    super.onResume();
    registerReceiver(cambio, new IntentFilter(ACTION_AIRPLANE_MODE_CHANGED));
  }

  /*Desregistrar el receiver cuando la actividad deja de ser visible*/
  @Override
  protected void onStop(){
    super.onStop();
    unregisterReceiver(cambio);
  }
}