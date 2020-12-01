package com.notin.senglish.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.notin.senglish.R
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {
    private var mAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
        if(FirebaseAuth.getInstance().uid!=null)
        {
            if(FirebaseAuth.getInstance().uid!=null)
            {
                val intent=Intent(this,MainActivity::class.java)
                intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK.or(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)
            }
        }
        listener()

    }
    fun init(){
        mAuth = FirebaseAuth.getInstance()
    }
    fun listener()
    {
        txtRegister.setOnClickListener {
            val intent=Intent(this,RegisterActivity::class.java)
            intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK.or(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
        }
        btnLogin.setOnClickListener {
            login()
        }
    }
    fun login(){
        var email = edtEmail.text.toString().trim()
        var password = edtPassword.text.toString().trim()
        var checkInfo = checkInformation(email, password)
        if(checkInfo){
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(
                    this
                ) { task ->
                    if (task.isSuccessful) {
                        val intent=Intent(this,MainActivity::class.java)
                        intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK.or(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        startActivity(intent)
                        //val user = mAuth!!.currentUser
                    } else {
                        Toast.makeText(this, "Đăng nhập lỗi!",Toast.LENGTH_LONG).show()
                    }
                }
        }
    }
    fun checkInformation(email:String, password:String): Boolean{
        var message:String=""
        if(email.trim() == "" || password.trim() == "") {
            message = "Vui lòng nhập đầy đủ thông tin!"
        }
        if(message != ""){
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            return false;
        }
        return true
    }
}