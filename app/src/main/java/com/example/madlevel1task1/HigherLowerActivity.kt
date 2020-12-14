package com.example.madlevel1task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.madlevel1task1.databinding.ActivityHigherLowerBinding

class HigherLowerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHigherLowerBinding
    private var currentRoll: Int = 1
    private var previousRoll: Int = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHigherLowerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    /**
     * Set the initial (UI) state of the game.
     */
    private fun initViews() {
        binding.btnLower.setOnClickListener {
            onLowerClick()
        }
        binding.btnEqual.setOnClickListener {
            onEqualClick()
        }
        binding.btnHigher.setOnClickListener {
            onHigherClick()
        }
        updateUI()
    }

    /**
     * Update the last throw text and the dice image resource drawable with the current throw.
     */
    private fun updateUI() {
        binding.textPrevRoll.text = getString(R.string.base_previous_roll_text, previousRoll)
        when (currentRoll) {
            1 -> binding.imgDie.setImageResource(R.drawable.dice1)
            2 -> binding.imgDie.setImageResource(R.drawable.dice2)
            3 -> binding.imgDie.setImageResource(R.drawable.dice3)
            4 -> binding.imgDie.setImageResource(R.drawable.dice4)
            5 -> binding.imgDie.setImageResource(R.drawable.dice5)
            6 -> binding.imgDie.setImageResource(R.drawable.dice6)
        }
    }

    private fun rollDie() {
        previousRoll = currentRoll
        currentRoll = (1..6).random()
        updateUI()
    }

    /**
     * Calls [rollDie] and checks if the answer is correct.
     */
    private fun onHigherClick() {
        rollDie()
        if (currentRoll > previousRoll) {
            onAnswerCorrect()
        }
        else {
            onAnswerIncorrect()
        }
    }

    /**
     * Calls [rollDie] and checks if the answer is correct.
     */
    private fun onLowerClick() {
        rollDie()
        if (currentRoll < previousRoll) {
            onAnswerCorrect()
        }
        else {
            onAnswerIncorrect()
        }
    }

    /**
     * Calls [rollDie] and checks if the answer is correct.
     */
    private fun onEqualClick() {
        rollDie()
        if (currentRoll == previousRoll) {
            onAnswerCorrect()
        }
        else {
            onAnswerIncorrect()
        }
    }

    /**
     * Displays a successful Toast message.
     */
    private fun onAnswerCorrect() {
        val message = getString(R.string.correct)

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    /**
     * Displays an incorrect Toast message.
     */
    private fun onAnswerIncorrect() {
        val message = getString(R.string.incorrect)

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}