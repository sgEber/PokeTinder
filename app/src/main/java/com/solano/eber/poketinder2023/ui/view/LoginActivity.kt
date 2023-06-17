package com.solano.eber.poketinder2023.ui.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.solano.eber.poketinder2023.util.SharedPreferenceUtil
import com.solano.eber.poketinder2023.data.model.User
import com.solano.eber.poketinder2023.databinding.ActivityLoginBinding
import com.solano.eber.poketinder2023.ui.viewmodel.LoginViewModel

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {

    private lateinit var LoginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        LoginViewModel = LoginViewModel(context = this)

        LoginViewModel.onCreate()

        LoginViewModel.emptyFieldsError.observe(this){
            Toast.makeText(this, "Ingrese los datos de Usuario",Toast.LENGTH_SHORT).show()
        }

        LoginViewModel.fieldsAuthenticateError.observe(this){
            Toast.makeText(this, "Error Usuario",Toast.LENGTH_SHORT).show()
        }

        LoginViewModel.goSuccessActivity.observe(this){
            val intent = Intent( this,MainActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener{
            LoginViewModel.validateInputs(
                binding.edtEmail.text.toString(),
                binding.edtPassword.text.toString()
            )
        }

        binding.btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}