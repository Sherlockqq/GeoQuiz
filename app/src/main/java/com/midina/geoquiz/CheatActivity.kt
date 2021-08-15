// package com.midina.geoquiz
//
//import android.app.Activity
//import android.content.Context
//import android.content.Intent
//
//import android.os.Bundle
//import android.widget.Button
//import android.widget.TextView
//
// const val EXTRA_ANSWER_SHOWN = "com.midina.geoquiz.answer_shown"
// const val EXTRA_CHEAT_COUNT = "com.midina.geoquiz.cheat_count"
// const val EXTRA_CHEAT_COUNT_RETRIEVE = "com.midina.geoquiz.cheat_count_retrieve"
// private const val EXTRA_ANSWER_IS_TRUE = "com.midina.geoquiz.answer_is_true"
// private const val KEY_CHEAT = "cheat"
// private const val KEY_CHEAT_COUNT = "cheat_count"
//
//class CheatActivity : AppCompatActivity() {
//
//    private var answerIsTrue = false
//    private var isAnswerShown = false
//    private var cheatCount = 3
//    private lateinit var answerTextView: TextView
//    private lateinit var showAnswerButton: Button
//    private lateinit var cheatTextView: TextView
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_cheat)
//
//        answerIsTrue = intent.getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false)
//        isAnswerShown = savedInstanceState?.getBoolean(KEY_CHEAT, false)?: false
//        cheatCount = savedInstanceState?.getInt(KEY_CHEAT_COUNT,3)?:
//                                        intent.getIntExtra(EXTRA_CHEAT_COUNT_RETRIEVE, 3)
//
//        answerTextView = findViewById(R.id.answer_text_view)
//        showAnswerButton = findViewById(R.id.show_answer_button)
//        cheatTextView = findViewById(R.id.cheat_count)
//
//
//        cheatTextView.text = "Lives left $cheatCount"
//
//        if(cheatCount == 0){
//            showAnswerButton.isEnabled=false
//        }
//        if(isAnswerShown){
//            setAnswerShownResult(isAnswerShown,cheatCount)
//        }
//
//        showAnswerButton.setOnClickListener {
//            val answerText = when {
//                answerIsTrue -> R.string.true_button
//                else -> R.string.false_button
//            }
//            isAnswerShown = true
//            cheatCount--
//            if(cheatCount == 0){
//                showAnswerButton.isEnabled=false
//            }
//            answerTextView.setText(answerText)
//            cheatTextView.text = "Lives left $cheatCount"
//            setAnswerShownResult(isAnswerShown,cheatCount)
//        }
//    }
//
//    override fun onSaveInstanceState(savedInstanceState: Bundle) {
//        super.onSaveInstanceState(savedInstanceState)
//        savedInstanceState.putBoolean(KEY_CHEAT, isAnswerShown)
//        savedInstanceState.putInt(KEY_CHEAT_COUNT, cheatCount)
//    }
//
//    private fun setAnswerShownResult(isAnswerShown: Boolean, cheatCount: Int) {
//        val data = Intent().apply {
//            putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown)
//            putExtra(EXTRA_CHEAT_COUNT, cheatCount)
//        }
//        setResult(Activity.RESULT_OK, data)
//    }
//
//    companion object {
//        fun newIntent(packageContext: Context, answerIsTrue: Boolean, cheat_count: Int): Intent {
//            return Intent(packageContext, CheatActivity::class.java).apply {
//                putExtra(EXTRA_CHEAT_COUNT_RETRIEVE, cheat_count)
//                putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue)
//            }
//        }
//    }
//}