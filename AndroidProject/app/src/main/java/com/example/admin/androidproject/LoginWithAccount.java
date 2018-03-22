package com.example.admin.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.androidproject.DAO.LoginDAO;
import com.example.admin.androidproject.Entities.UserEntites;

public class LoginWithAccount extends AppCompatActivity {
    private UserEntites user;
    private EditText txtName;
    private EditText txtPassword;
    private String empId;
    private ImageView imgError;
    private TextView txtError;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_with_account);


    }

    public void clickLogin(View v) {
        try {
            txtName = (EditText) findViewById(R.id.txUsername);
            txtPassword = (EditText) findViewById(R.id.txtPassword);
            imgError = (ImageView) findViewById(R.id.imgError);
            txtError = (TextView) findViewById(R.id.txtMessenger);
            empId = "";

            user = new LoginDAO().loginAccount(txtName.getText().toString(), txtPassword.getText().toString());
            if (user != null && txtName.getText().toString() != null && txtPassword.getText().toString() != null) {

                Intent i ;
                switch (user.getRoleId()){
                    case 1 :
                         i = new Intent(this, ProductViewActivity.class);
                         i.putExtra("empID",user.getEmployeeID()+"");
                         i.putExtra("roleId",user.getRoleId());
                         startActivity(i);
                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                }

                Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
            } else {
                imgError.setVisibility(View.VISIBLE);
                if (txtPassword.getText().toString() == null) {
                    txtError.setText("Please enter username");
                } else if (txtName.getText().toString() == null) {
                    txtError.setText("Please enter password");
                } else if (txtPassword.getText().toString() == null && txtPassword.getText().toString() == null) {
                    txtError.setText("Please enter username and password");
                } else if (user == null) {
                    txtError.setText("Error Username or Password");
                }


            }
        } catch (Exception e) {
            Log.e("MSG", e.getMessage());
        }
    }
}
