package br.eng.ailton.hellopost;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    private Mensageiro mensageiro;

    public void setMensageiro(Mensageiro msg)
    {
        mensageiro = msg;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setMensageiro(new Mensageiro());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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

    public void OnClickListener(View view){


        TextView txtEntrada = (TextView)findViewById(R.id.txtEnviar);
        String strEntrada = txtEntrada.getText().toString();

        new AsyncTask<String, Void, String>() {

            @Override
            protected String doInBackground(String... params) {

                return mensageiro.enviaMensagem(params[0]);
            }

            @Override
            protected void onPostExecute(String result){
                TextView txtSaida = (TextView)findViewById(R.id.txtRecebido);
                txtSaida.setText(result);
            }


        }.execute(strEntrada);


    }
}
