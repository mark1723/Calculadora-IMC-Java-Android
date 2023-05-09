package com.dev.stackmd;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.File;

public class MainActivity extends Activity {
	EditText p, a;
	float ps, at;
	TextView rs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		p = (EditText) findViewById(R.id.peso);
		a = (EditText) findViewById(R.id.altura);
		rs = (TextView) findViewById(R.id.res);

		Button bt = (Button) findViewById(R.id.calc);
		bt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				try {
					ps = Float.parseFloat(p.getText().toString());
					at = Float.parseFloat(a.getText().toString());

					float rImc = ps / (at * at);

					String nm = "<u><b><i>Entre 18,5 e 24,9</i></b></u>: Normal;";
					String sp = "<u><b><i>Entre 25 e 29,9</i></b></u>: Sobrepeso;";
					String ob = "<u><b><i>Entre 30 e 39,9</i></b></u>: Obesidade;";
					String mb = "<u><b><i>Abaixo de 18,5</i></b></u>: Esta abaixo demais atenção;";
					String obs = "<u><b><i>Acima de 39,9</i></b></u>: Obesidade Atenção;";

					if (rImc < 18.5) {
						rs.setText(Html.fromHtml(rImc + "<br/>" + mb));
					}
					if (rImc >= 18.5 && rImc <= 24.9) {
						rs.setText(Html.fromHtml(rImc + "<br/>" + nm));
					}
					if (rImc >= 25.0 && rImc <= 29.9) {
						rs.setText(Html.fromHtml(rImc + "<br/>" + sp));
					}
					if (rImc >= 30.0 && rImc <= 39.9) {
						rs.setText(Html.fromHtml(rImc + "<br/>" + ob));
					}
					if (rImc > 39.9) {
						rs.setText(Html.fromHtml(rImc + "<br/>" + obs));
					}

				} catch (Throwable ex) {

					Toast.makeText(MainActivity.this, "Erro.", Toast.LENGTH_LONG).show();
				}

			}

		});

	}
}