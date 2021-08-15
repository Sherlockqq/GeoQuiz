package com.midina.geoquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.setFragmentResult
import com.midina.geoquiz.databinding.FragmentCheatBinding

class CheatFragment : Fragment() {

    private var answerIsTrue : Boolean? = false

    private var isAnswerShown = false
    private var cheatCount : Int? = 3

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding : FragmentCheatBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_cheat,
            container,
            false)

        val bundle = arguments

        answerIsTrue = bundle?.getBoolean("KEY_ANSWER")
        cheatCount = bundle?.getInt("KEY_CHEAT")


        binding.cheatCount.text = "Lives left $cheatCount"

        if(cheatCount == 0){
            binding.showAnswerButton.isEnabled=false
        }
        if(isAnswerShown){
            binding.showAnswerButton.isEnabled=false
        }
        binding.showAnswerButton.setOnClickListener {
            val answerText = when {
                answerIsTrue == true -> R.string.true_button
                else -> R.string.false_button
            }
            isAnswerShown = true
            cheatCount = cheatCount?.minus(1)
            binding.showAnswerButton.isEnabled=false
            binding.answerTextView.setText(answerText)
            binding.cheatCount.text = "Lives left $cheatCount"

            setFragmentResult("requestKey", bundleOf(
                "KEY_SHOWN" to isAnswerShown,
                "KEY_CHEAT_COUNT" to cheatCount
            ))
        }
        return binding.root
    }
}