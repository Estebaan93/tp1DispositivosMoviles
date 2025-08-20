package com.example.tp1dispositivosmoviles;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

public class ModoAvionCambio extends BroadcastReceiver {
  private Intent llamada;

  @Override
  public void onReceive(Context context, Intent intent) {
    if(Intent.ACTION_AIRPLANE_MODE_CHANGED.equals((intent.getAction()))){
      boolean modoAvionActivado= intent.getBooleanExtra("state", false);
      if(modoAvionActivado){
        Toast.makeText(context, "MODO AVIÓN ACTIVADO", Toast.LENGTH_LONG).show();
        llamada= new Intent(Intent.ACTION_DIAL);
        llamada.setData(Uri.parse("tel: 2664553747"));
        llamada.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(llamada);
        Log.d("salida", "onReceive:");
      }else{
        Toast.makeText(context, "MODO AVIÓN DESACTIVADO", Toast.LENGTH_LONG).show();
      }
    }
  }
}