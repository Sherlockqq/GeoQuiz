package com.midina.geoquiz

import android.arch.lifecycle.ViewModel
import android.util.Log

private const val TAG = "QuizViewModel"

class QuizViewModel : ViewModel() {



    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true))

    var currentIndex = 0
    var isCheater = arrayOf(false,false,false,false,false,false)

    val currentQuestionAnswer: Boolean get() = questionBank[currentIndex].answer

    val currentQuestionText: Int get() = questionBank[currentIndex].textResId

    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }

}