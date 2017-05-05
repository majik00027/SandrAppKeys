package sandroide.sadre;

import android.content.DialogInterface;
import android.os.Bundle;
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

    Button btnapertura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BLEContext.initBLE(this);


        txtVapertura = (TextView)findViewById(R.id.txtVstato);
        btnapertura = (Button) findViewById(R.id.btnApertura);

        ledGreen = (BLEGeneralIO) BLEContext.findViewById("arduino_rbs_general_io_10");
        ledRed = (BLEGeneralIO) BLEContext.findViewById("arduino_rbs_general_io_9");
        serratura = (BLEGeneralIO) BLEContext.findViewById("arduino_rbs_general_io_0");

        this.doSomething();//setta lo stato iniziale
    }

    public void doSomething()
    {
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
    }


}
