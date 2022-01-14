package com.psp.mvpexample.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.psp.mvpexample.R;
import com.psp.mvpexample.contract.LoginContract;
import com.psp.mvpexample.databinding.ActivityLoginBinding;
import com.psp.mvpexample.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements LoginContract.ViewContract {

    ActivityLoginBinding binding;

    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        presenter = new LoginPresenter(this);

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = binding.edtUsername.getText().toString();
                String password = binding.edtPassword.getText().toString();

                if(username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(v.getContext(), "Please fill out all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                presenter.doLogin(username,password);
            }
        });
    }

    @Override
    public void showProgress() {
        Toast.makeText(this, "Show progress", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void stopProgress() {
        Toast.makeText(this, "Stop progress", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "Login success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFailed() {
        Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show();
    }
}