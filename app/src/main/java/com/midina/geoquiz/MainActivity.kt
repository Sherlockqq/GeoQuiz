package com.midina.geoquiz


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

//private const val TAG = "MainActivity"
//private const val KEY_INDEX = "index"
//private const val KEY_CHEAT_COUNT = "cheat_count"
//private const val REQUEST_CODE_CHEAT = 0

class MainActivity : AppCompatActivity() {

//    private lateinit var trueButton: Button
//    private lateinit var falseButton: Button
//    private lateinit var nextButton: Button
//    private lateinit var cheatButton: Button
//    private lateinit var questionTextView: TextView
//    private lateinit var apiVersionTextView: TextView
//
//    private var cheatCount = 3
//
//    private val quizViewModel: QuizViewModel by lazy {
//        ViewModelProviders.of(this).get(QuizViewModel::class.java)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainFragment = GameFragment()
        supportFragmentManager.beginTransaction().add(R.id.place_holder, mainFragment)
            .commit()
    }
}
/*
        val currentIndex = savedInstanceState?.getInt(KEY_INDEX, 0) ?: 0
        cheatCount = savedInstanceState?.getInt(KEY_CHEAT_COUNT, 3) ?: 3
        quizViewModel.currentIndex = currentIndex

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)
        cheatButton = findViewById(R.id.cheat_button)
        questionTextView = findViewById(R.id.question_text_view)
        apiVersionTextView = findViewById(R.id.api_version_text_view)

        apiVersionTextView.append(" "+Build.VERSION.SDK_INT.toString())

        trueButton.setOnClickListener {
            checkAnswer(true)
        }
        falseButton.setOnClickListener {
            checkAnswer(false)
        }
        nextButton.setOnClickListener {
            quizViewModel.moveToNext()
            updateQuestion()
        }
        cheatButton.setOnClickListener { view ->
            val answerIsTrue = quizViewModel.currentQuestionAnswer
            val intent = CheatActivity.newIntent(this@MainActivity, answerIsTrue, cheatCount)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val options = ActivityOptions
                    .makeClipRevealAnimation(view, 0, 0, view.width, view.height)
                startActivityForResult(intent, REQUEST_CODE_CHEAT, options.toBundle())
            } else {
                startActivityForResult(intent, REQUEST_CODE_CHEAT)
            }
        }
        updateQuestion()
    }

    override fun onActivityResult(requestCode: Int,
                                  resultCode: Int,
                                  data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != Activity.RESULT_OK) {
            return
        }
        if (requestCode == REQUEST_CODE_CHEAT) {
            quizViewModel.isCheater[quizViewModel.currentIndex] =
                data?.getBooleanExtra(EXTRA_ANSWER_SHOWN, false) ?: false
            cheatCount = data?.getIntExtra(EXTRA_CHEAT_COUNT, 0) ?: 0
        }
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        Log.i(TAG, "onSaveInstanceState")
        savedInstanceState.putInt(KEY_INDEX, quizViewModel.currentIndex)
        savedInstanceState.putInt(KEY_CHEAT_COUNT, cheatCount)
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }

    private fun updateQuestion() {
        val questionTextResId = quizViewModel.currentQuestionText
        questionTextView.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = quizViewModel.currentQuestionAnswer
        val messageResId = when {
            quizViewModel.isCheater[quizViewModel.currentIndex] -> R.string.judgment_toast
            userAnswer == correctAnswer -> R.string.correct_toast
            else -> R.string.incorrect_toast
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
    }*/

