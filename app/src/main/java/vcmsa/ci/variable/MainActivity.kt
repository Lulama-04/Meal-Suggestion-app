package vcmsa.ci.variable

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //Find the UI values of texts/buttons by ID//
        //TextView for output text//
        val resultTextView = findViewById<TextView>(R.id.resultText)
        //EditText for user input for Time of Day//
        val timeOfDayInput = findViewById<EditText>(R.id.TimeOfDayET)
        //Button that displays meal suggestions when clicked//
        val mealSuggestionButton = findViewById<Button>(R.id.generate)
        //Button that resets the inputs when clicked//
        val resetButton = findViewById<Button>(R.id.ResetButton)

        //Set onClickListener for the resetButton//
        resetButton.setOnClickListener {
            //clear text in the timeOfDay input field//
            timeOfDayInput.text.clear()
            //Reset the meal suggestion text view to default//
            resultTextView.text = ""
        }
        //Set onClickListener for mealSuggestionButton//
        mealSuggestionButton.setOnClickListener {
            // Get the time of day input as a string
            val timeOfDay = timeOfDayInput.text.toString().trim()

            // Check if input is empty
            if (timeOfDay.isEmpty()) {
                resultTextView.text = "Please enter a valid time of day."
                return@setOnClickListener
            }

            // Define meal options
            val morningMeals = listOf("English-Breakfast", "Kellogg's Cornflakes", "Pancakes")
            val midMorningMeals = listOf("Fruits salad", "Cashews", "Oats Cookies")
            val afternoonMeals =
                listOf("Ham-Cheese Toast", "Burger patty Sandwich", "Egg-mayo Cold sandwich")
            val midAfternoonMeals = listOf("Popcorn", "Plain yogurt with Berries", "Puff Pastry")
            val dinnerMeals = listOf("Chicken curry", "Spaghetti and meatballs", "Cottage Pie")
            val afterDinnerMeals = listOf("Ice-cream", "Cake", "Creme Brulee")

            // Select a meal suggestion based on input
            val mealSuggestion = when (timeOfDay.lowercase()) {
                "morning" -> morningMeals.random()
                "mid-morning" -> midMorningMeals.random()
                "afternoon" -> afternoonMeals.random()
                "mid-afternoon" -> midAfternoonMeals.random()
                "dinner" -> dinnerMeals.random()
                "after-dinner" -> afterDinnerMeals.random()
                else -> "Invalid time of day. Please enter Morning, Mid-Morning, Afternoon, Mid-Afternoon, Dinner, or After-Dinner."
            }
            /*
            Title:OpenAI prompt
            Author:CHatGPT
            Date: 1 Apr. 2025(acquired date )
            Version:"1.0"
            Additional: chatgpt.com/c/67eb892e-5d50-8002-ac5c-556dd5bff025

            Title:w3schools.com
            Author:w3schools
            Date:1 APr. 2025(acquired date)
            Version:"1.0"
            Additional:https://www.w3schools.com/kotlin/index.php

            Title:Kotlin statement examples
            Author:Java Guides
            Date:1 APr. 2025(acquired date)
            Version:"1.0"
            Additional:https://www.javaguides.net/2022/11/kotlin-if-else-if-else-if-and-nested-if-st.html  */

            // Display the meal suggestion
            resultTextView.text = mealSuggestion
        }
    }
}

