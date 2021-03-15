package com.example.hellokotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener { // extends AppCompatActivity
    /*
        null 을 허용하는 inputMsg 필드를 선언하고 null 로 초기화 하기
     */
    var inputMsg: EditText? = null
    //위의 표현식이 번거로우면 아래처럼 lateinit 예약어를 이용한다.
    lateinit  var console: TextView

    // onCreate() 메소드 오버라이드
    override fun onCreate(savedInstanceState: Bundle?) { // ?는 null 가능
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //EditText 객체의 참조값 얻어오기
        inputMsg= findViewById(R.id.inputMsg)
        //TextView 객체의 참조값 얻어오기
        console= findViewById(R.id.console)
        //Button 의 참조값 얻어와서 리스너 등록
        val sendBtn:Button = findViewById(R.id.sendBtn)
        sendBtn.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        /*
            getter, setter 메소드는 필드를 참조하는 형식으로 사용한다.
            ? 는 null 일 가능성이 있는 자원을 참조할때 뒤에 붙여야 한다.
         */

        // in java =>  String msg=inputMsg.getText().toString()
        val msg=inputMsg?.text.toString()
        console.setText(msg)
        // console.text=msg //이것도 가능
    }
}
