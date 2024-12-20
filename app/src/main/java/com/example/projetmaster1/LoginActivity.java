package com.example.projetmaster1;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.projetmaster1.mydatabase.MyDatabase;

public class LoginActivity extends AppCompatActivity {
    EditText logintxt, passwordtxt;
    Button loginButton;
    TextView signupButton;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        logintxt = findViewById(R.id.edEmail);
        passwordtxt = findViewById(R.id.edPass);
        loginButton = findViewById(R.id.logButton);
        signupButton = findViewById(R.id.singupclic);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
    }

    public void login() {
        String login = logintxt.getText().toString();
        String enteredPassword = passwordtxt.getText().toString();

        MyDatabase myDatabase = new MyDatabase(getApplicationContext());
        SQLiteDatabase db = myDatabase.getReadableDatabase();

        try (Cursor cursor = db.rawQuery("SELECT password FROM client WHERE email = ?", new String[]{login})) {
            if (cursor.moveToFirst()) {
                String passwordData = cursor.getString(0);

                if (enteredPassword.equals(passwordData)) {
                    saveEmailInSession(login);
                    // Utilisez la méthode startDashboardActivity pour éviter la répétition du code
                    startDashboardActivity();
                } else {
                    logintxt.setError("Incorrect password");
                }
            } else {
                // L'email n'a pas été trouvé dans la base de données
                logintxt.setError("Email not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("LoginActivity", "Exception during login: " + e.getMessage());
            // Gérez l'exception de manière appropriée, en enregistrant ou en affichant un message d'erreur
        }
    }

    private void startDashboardActivity() {
        Log.d("LoginActivity", "Redirecting to dashboard activity");
        Intent intent = new Intent(this, dashboard_activity.class);
        startActivity(intent);
        // Assurez-vous de terminer l'activité de connexion pour que l'utilisateur ne puisse pas revenir en arrière
        finish();
    }




    private void signUp() {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    private void saveEmailInSession(String email) {
        SharedPreferences sharedPreferences = getSharedPreferences("session", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("email", email);
        editor.apply();
    }
}
