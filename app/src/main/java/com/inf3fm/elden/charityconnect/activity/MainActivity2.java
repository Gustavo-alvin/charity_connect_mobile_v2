package com.inf3fm.elden.charityconnect.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.inf3fm.elden.charityconnect.R;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class MainActivity2 extends AppCompatActivity {

    private EditText edtMotivo, edtPergunta, edtNome, edtSobrenome, edtEmail, edtCelular;
    private Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        edtNome = findViewById(R.id.nome);

        edtSobrenome = findViewById(R.id.sobrenome);

        edtPergunta = findViewById(R.id.pergunta);

        edtEmail = findViewById(R.id.email);

        edtMotivo = findViewById(R.id.motivo);

        edtCelular = findViewById(R.id.celular);

        enviar = findViewById(R.id.enviar);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inserirUsuario();
            }
            public Connection conexaoBD() {
                Connection conexao = null;
                try {
                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                    StrictMode.setThreadPolicy(policy);

                    Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
                    conexao = DriverManager.getConnection("jdbc:jtds:sqlserver://bd_CharityConnect_INF3FM.mssql.somee.com;databaseName=bd_CharityConnect_INF3FM;user=gustavo;password=41943419;");
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                return conexao;

            }

            private void inserirUsuario() {
                try {
                    PreparedStatement pst = conexaoBD().prepareStatement("INSERT INTO Contato (motivoContato, dataContato, pergunta, nome, sobrenome, email, telefone) VALUES (?, ?, ?,?,?,?,?)");

                    String nome = edtNome.getText().toString().trim();
                    String sobrenome = edtSobrenome.getText().toString().trim();
                    String email = edtEmail.getText().toString().trim();
                    String pergunta = edtPergunta.getText().toString().trim();
                    String motivo = edtMotivo.getText().toString().trim();
                    String celular = edtCelular.getText().toString().trim();

                    if(motivo.isEmpty() || motivo.equals("")){
                        Toast.makeText(getApplicationContext(), "Digite o Motivo do Contato", Toast.LENGTH_SHORT).show();
                        edtMotivo.setFocusable(true);
                    }else{
                        pst.setString(1, motivo);
                    }

                    if(pergunta.isEmpty() || pergunta.equals("")){
                        Toast.makeText(getApplicationContext(), "Digite sua pergunta", Toast.LENGTH_SHORT).show();
                        edtPergunta.setFocusable(true);
                    }else{
                        pst.setString(3, pergunta);
                    }

                    if(nome.isEmpty() || nome.equals("")){
                        Toast.makeText(getApplicationContext(), "Digite seu nome", Toast.LENGTH_SHORT).show();
                        edtNome.setFocusable(true);
                    }else{
                        pst.setString(4, nome);
                    }

                    if(sobrenome.isEmpty() || sobrenome.equals("")){
                        Toast.makeText(getApplicationContext(), "Digite seu sobrenome", Toast.LENGTH_SHORT).show();
                        edtSobrenome.setFocusable(true);
                    }else{
                        pst.setString(5, sobrenome);
                    }

                    if(email.isEmpty() || email.equals("")){
                        Toast.makeText(getApplicationContext(), "Digite seu email", Toast.LENGTH_SHORT).show();
                        edtEmail.setFocusable(true);
                    }else{
                        pst.setString(6, email);
                    }

                    if(celular.isEmpty() || celular.equals("")){
                        Toast.makeText(getApplicationContext(), "Digite seu celular", Toast.LENGTH_SHORT).show();
                        edtCelular.setFocusable(true);
                    }else{
                        pst.setString(7, celular);
                    }

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        pst.setString(2, LocalDate.now().toString());
                    }

                    pst.executeUpdate();
                    Toast.makeText(getApplicationContext(),"USUARIO INSERIDO COM SUCESSO", Toast.LENGTH_SHORT).show();
                }catch (SQLException e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
































        });









    }
}