package com.midina.geoquiz


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProviders
import com.midina.geoquiz.databinding.FragmentGameBinding

private const val TAG = "MainActivity"
private const val KEY_INDEX = "index"
private const val KEY_CHEAT_COUNT = "cheat_count"
private const val REQUEST_CODE_CHEAT = 0

class GameFragment : Fragment() {

    private var cheatCount = 3
    private lateinit var binding: FragmentGameBinding


    private val quizViewModel: QuizViewModel by lazy {
        ViewModelProviders.of(this).get(QuizViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_game,
            container,
            false)

        setFragmentResultListener("requestKey") { key, bundle ->
            cheatCount = bundle.getInt("KEY_CHEAT_COUNT")
            quizViewModel.isCheater[quizViewModel.currentIndex] = bundle.getBoolean("KEY_SHOWN")
        }

        binding.trueButton.setOnClickListener {
            checkAnswer(true)
        }
        binding.falseButton.setOnClickListener {
            checkAnswer(false)
        }
        binding.nextButton.setOnClickListener {
            quizViewModel.moveToNext()
            updateQuestion()
        }
        binding.cheatButton.setOnClickListener { view ->
            val answerIsTrue = quizViewModel.currentQuestionAnswer

            val bundle = Bundle()
            bundle.putBoolean("KEY_ANSWER",answerIsTrue)
            bundle.putInt("KEY_CHEAT",cheatCount)

            val fragment = CheatFragment()
            fragment.setArguments(bundle)

            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.place_holder, fragment)
            transaction?.addToBackStack(null)
            transaction?.commit()

        }
        updateQuestion()

        return binding.root
    }

    private fun updateQuestion() {
        val questionTextResId = quizViewModel.currentQuestionText
        binding.questionTextView.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = quizViewModel.currentQuestionAnswer
        val messageResId = when {
            quizViewModel.isCheater[quizViewModel.currentIndex] -> R.string.judgment_toast
            userAnswer == correctAnswer -> R.string.correct_toast
            else -> R.string.incorrect_toast
        }
        Toast.makeText(context, messageResId, Toast.LENGTH_SHORT).show()
    }

}