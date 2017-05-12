package sandroide.sadre;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import it.unibs.sandroide.lib.BLEContext;
import it.unibs.sandroide.lib.activities.SandroideBaseActivity;
import it.unibs.sandroide.lib.item.generalIO.BLEGeneralIO;
import it.unibs.sandroide.lib.item.generalIO.BLEGeneralIOEvent;
import it.unibs.sandroide.lib.item.generalIO.BLEOnGeneralIOEventListener;

public class MainActivity extends SandroideBaseActivity {

    TextView txtVapertura;
    BLEGeneralIO ledGreen;
    BLEGeneralIO ledRed;
    BLEGeneralIO serratura;

    String NAME ="myBLE_rbs";
    String TAG ="Renegade";
    Button btnapertura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BLEContext.initBLE(this);

        ledGreen = (BLEGeneralIO) BLEContext.findViewById(NAME+"_general_io_10");
        ledRed = (BLEGeneralIO) BLEContext.findViewById(NAME+"_general_io_9");
        serratura = (BLEGeneralIO) BLEContext.findViewById(NAME+"_general_io_0");
        ledRed.setOnGeneralIOEventListener(new BLEOnGeneralIOEventListener() {
            @Override
            public void onBoardInitEnded() {
                ledRed.setStatus(BLEGeneralIO.GENERAL_IO_DO);
            }

            @Override
            public void onDigitalInputValueChanged(BLEGeneralIOEvent bleGeneralIOEvent) {

            }

            @Override
            public void onAnalogValueChanged(BLEGeneralIOEvent bleGeneralIOEvent) {

            }

            @Override
            public void onDigitalOutputValueChanged(BLEGeneralIOEvent bleGeneralIOEvent) {

            }

            @Override
            public void onServoValueChanged(BLEGeneralIOEvent bleGeneralIOEvent) {

            }

            @Override
            public void onPWMValueChanged(BLEGeneralIOEvent bleGeneralIOEvent) {

            }

            @Override
            public void onGeneralIOStatusChanged(BLEGeneralIOEvent bleGeneralIOEvent) {

            }

            @Override
            public void onSetGeneralIOParameter(BLEGeneralIOEvent bleGeneralIOEvent) {

            }
        });
        ledGreen.setOnGeneralIOEventListener(new BLEOnGeneralIOEventListener() {
            @Override
            public void onBoardInitEnded() {
                ledGreen.setStatus(BLEGeneralIO.GENERAL_IO_DIO);
            }

            @Override
            public void onDigitalInputValueChanged(BLEGeneralIOEvent bleGeneralIOEvent) {

            }

            @Override
            public void onAnalogValueChanged(BLEGeneralIOEvent bleGeneralIOEvent) {

            }

            @Override
            public void onDigitalOutputValueChanged(BLEGeneralIOEvent bleGeneralIOEvent) {

            }

            @Override
            public void onServoValueChanged(BLEGeneralIOEvent bleGeneralIOEvent) {

            }

            @Override
            public void onPWMValueChanged(BLEGeneralIOEvent bleGeneralIOEvent) {

            }

            @Override
            public void onGeneralIOStatusChanged(BLEGeneralIOEvent bleGeneralIOEvent) {

            }

            @Override
            public void onSetGeneralIOParameter(BLEGeneralIOEvent bleGeneralIOEvent) {

            }
        });
        serratura.setOnGeneralIOEventListener(new BLEOnGeneralIOEventListener() {
            @Override
            public void onBoardInitEnded() {
                serratura.setStatus(BLEGeneralIO.GENERAL_IO_DI);
            }

            @Override
            public void onDigitalInputValueChanged(BLEGeneralIOEvent bleGeneralIOEvent) {

            }

            @Override
            public void onAnalogValueChanged(BLEGeneralIOEvent bleGeneralIOEvent) {

            }

            @Override
            public void onDigitalOutputValueChanged(BLEGeneralIOEvent bleGeneralIOEvent) {

            }

            @Override
            public void onServoValueChanged(BLEGeneralIOEvent bleGeneralIOEvent) {

            }

            @Override
            public void onPWMValueChanged(BLEGeneralIOEvent bleGeneralIOEvent) {

            }

            @Override
            public void onGeneralIOStatusChanged(BLEGeneralIOEvent bleGeneralIOEvent) {

            }

            @Override
            public void onSetGeneralIOParameter(BLEGeneralIOEvent bleGeneralIOEvent) {

            }
        });

        txtVapertura = (TextView)findViewById(R.id.txtVstato);
        btnapertura = (Button) findViewById(R.id.btnApertura);

        //this.doSomething();//setta lo stato iniziale
    }

/*    public void doSomething()
    {
        Log.d(TAG, "doSomething: "+serratura.getDigitalValue());
        serratura.setDigitalValueHigh(!serratura.getDigitalValue());
        if(serratura.getDigitalValue())
        {
            ledRed.setDigitalValueHigh(false);
            ledGreen.setDigitalValueHigh(true);
            txtVapertura.setText("La serratura è aperta");//led acceso->serratura aperta->led verde acceso
        }
        else
        {
            ledRed.setDigitalValueHigh(true);
            ledGreen.setDigitalValueHigh(false);
            txtVapertura.setText("La serratura è chiusa");//led spento->serratura chiusa->led rosso acceso
        }
    }*/


}
