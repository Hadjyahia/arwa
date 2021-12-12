package hadj.tn.projetmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        openSignupActivity();

        openForgetPassActivity();

        openHomeActivity();


    }

    public void openSignupActivity(){
        TextView signup = (TextView) findViewById(R.id.textViewSignup);

        signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(LoginActivity.this, SignupActivity.class);

                startActivity(nextScreen);
            }
        });
    }

    public void openForgetPassActivity(){
        TextView forgetpass = (TextView) findViewById(R.id.textViewForgetPass);

        forgetpass.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(LoginActivity.this, ForgetPassActivity.class);

                startActivity(nextScreen);
            }
        });
    }

    public void openHomeActivity(){
        Button signin = (Button) findViewById(R.id.loginButton);

        signin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(LoginActivity.this, HomeActivity.class);

                startActivity(nextScreen);
            }
        });
    }

}