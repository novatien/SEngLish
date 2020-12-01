package com.notin.senglish.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.notin.senglish.R
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.edtEmail


class RegisterActivity : AppCompatActivity() {
    private var mAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        init()
        listener()

    }
    fun init(){
        mAuth = FirebaseAuth.getInstance()
    }
    fun listener()
    {
        txtLogin.setOnClickListener {
            val intent= Intent(this,LoginActivity::class.java)
            intent.flags= Intent.FLAG_ACTIVITY_NEW_TASK.or(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
        }
        btnRegister.setOnClickListener {
            register()
        }
    }
    fun register(){
        var email = edtEmail.text.trim().toString()
        var password1 = edtPassword1.text.trim().toString()
        var password2 = edtPassword2.text.trim().toString()
        var checkInfo = checkInformation(email, password1, password2)
        if(checkInfo){
            mAuth!!.createUserWithEmailAndPassword(email, password1)
                .addOnCompleteListener(
                    this
                ) { task ->
                    if (task.isSuccessful) {
                        val intent=Intent(this,MainActivity::class.java)
                        intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK.or(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Đăng kí thất bại!",Toast.LENGTH_LONG).show()
                    }


                }
        }
    }
    fun checkInformation(email:String, password1:String, password2:String): Boolean{
        var message:String=""
        if(email.trim() == "" || password1.trim() == "" || password2.trim() == ""){
            message = "Vui lòng nhập đầy đủ thông tin!"
        }else if(password1 != password2){
            message = "Vui lòng nhập khớp mật khẩu"
        }
        if(message != ""){
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            return false;
        }
        return true
    }
}