package com.notin.senglish.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.notin.senglish.R
import com.notin.senglish.dao.EnglishViewModel
import com.notin.senglish.model.English
import kotlinx.android.synthetic.main.fragment_exam.*
import java.util.*
import kotlin.collections.ArrayList


class ExamFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    var listEnglish = ArrayList<English>()
    var count = 0
    @SuppressLint("FragmentLiveDataObserve")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_main_menu)
        super.onActivityCreated(savedInstanceState)

        var englishModel =  ViewModelProvider(this).get(EnglishViewModel::class.java)
        englishModel.getAllEnglish.observe(this, Observer {englishes->
            for(i in englishes){
                listEnglish.add(i)
            }
            startExam()
        })



    }
    var timer:CountDownTimer? = null
    fun startTimer() {
        if(timer != null){
            timer!!.cancel()
        }
        txtTimes.text = "30"
        timer = object: CountDownTimer(30000, 1000) {
            override fun onFinish() {
                loadQuestionByIndex(count++)
            }

            override fun onTick(millisUntilFinished: Long) {
                var time = txtTimes.text.toString().toInt()-1
                txtTimes.text = Integer.toString(time)
            }

        }
        timer!!.start()
    }
    fun startExam(){
        loadQuestionByIndex(0)
    }

    fun loadQuestionByIndex(index:Int){
        startTimer()
        txtTimes.text = "30"
        if(index <= listEnglish.size-1){
            txtQuestion.text = listEnglish[index].name
        }
        var indexAnswer:Array<Int> = arrayOf(-1, -1, -1, -1)
        println("size--tttt"+listEnglish.size)

        var rd = Random()
        for(i in 0..2){
            do{
                println("size english="+listEnglish.size)
                indexAnswer[i] = Math.min(93,rd.nextInt(listEnglish.size-1))
            }while(indexAnswer[i] == index && isHaveArray(indexAnswer, indexAnswer[i]))
        }

        var indexAnswerTrue = rd.nextInt(4)
        when(indexAnswerTrue){
            0->{
                setAnswer(index,indexAnswer[0], indexAnswer[1], indexAnswer[2])
            }
            1->{
                setAnswer(indexAnswer[0],index, indexAnswer[1], indexAnswer[2])
            }
            2->{
                setAnswer(indexAnswer[0], indexAnswer[1],index, indexAnswer[2])
            }
            3->{
                setAnswer(indexAnswer[0], indexAnswer[1], indexAnswer[2], index)
            }
        }
        listener(indexAnswerTrue)

    }

    fun isHaveArray(arr:Array<Int>, number:Int):Boolean{
        for(i in arr.indices){
            if(number == arr[i]){
                return true
            }
        }
        return false
    }
    fun setAnswer(a1:Int, a2:Int, a3:Int, a4:Int){
        btnA.text = listEnglish[a1].mean
        btnB.text = listEnglish[a2].mean
        btnC.text = listEnglish[a3].mean
        btnD.text = listEnglish[a4].mean
    }

    fun listener(indexAnswerTrue:Int){
        btnA.setOnClickListener {
             handleQuestion(indexAnswerTrue, 0)
        }
        btnB.setOnClickListener {
            handleQuestion(indexAnswerTrue, 1)
        }
        btnC.setOnClickListener {
            handleQuestion(indexAnswerTrue, 2)
        }
        btnD.setOnClickListener {
            handleQuestion(indexAnswerTrue, 3)
        }
    }
    fun handleQuestion(indexAnswerTrue: Int, indexAnswer:Int){
        count++
        var score = txtScores.text.toString().toInt()
        if(indexAnswerTrue == indexAnswer){
            txtScores.text = (score + 10).toString()
        }else{
            //dap an sai
        }
        timer!!.onFinish()
        loadQuestionByIndex(count)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exam, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ExamFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    override fun onDestroy() {
        if(timer!= null){
            timer!!.cancel()
        }
        super.onDestroy()
    }
}