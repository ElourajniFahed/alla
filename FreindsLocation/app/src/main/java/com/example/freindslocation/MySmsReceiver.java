package com.example.freindslocation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MySmsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")){
            Bundle b=intent.getExtras();
            if(b!=null){
                Object[] pdus=(Object[]) b.get("pdus");
                SmsMessage [] msgs = new SmsMessage[pdus.length];
                for(int i=0 ; i<pdus.length;i++){

                    msgs[i]= SmsMessage.createFromPdu((byte[]) pdus[i]);//recuperer tout les messages

                }
                String adr = msgs[0].getOriginatingAddress();
                String contenu=msgs[0].getMessageBody();

                Toast.makeText(context,"Hello"+adr+"  contenu is : "+contenu,Toast.LENGTH_LONG);

            }
        }





        //throw new UnsupportedOperationException("Not yet implemented");
    }
}
