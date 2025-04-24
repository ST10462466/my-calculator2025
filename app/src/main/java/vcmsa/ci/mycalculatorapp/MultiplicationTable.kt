package vcmsa.ci.mycalculatorapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Toast

class MultiplicationTable : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_multiplication_table)
        // get the table number from bundle
        val bundle: Bundle? = intent.extras
       val tableString: String? = bundle?.getString("tableNumber")
        // IMAD5112/p/w
        //Module Manual 2025.p 58-69

        // convert the table number to an integer
        val tableNumber = tableString?.toIntOrNull() ?: 1
        // OpenAI (2025) ChatGPT (GPT-4) [Computer software].
        // Available at: https://chatgpt.com/c/68011741-29e8-8004-8f2d-8a4af2c9635f/ (Accessed: 25 April 2025).

        // display the heading so we can see the value in action
        val displayingmultiplicationtables =
            findViewById<TextView>(R.id.displayingmultiplicationtables)
        // IMAD5112/p/w
        //Module Manual 2025.p 58-69

        displayingmultiplicationtables.text = "$tableNumber x table"

        // start with the heading and add two new lines
        var tableDisplay: String = "$tableNumber x table\n\n"

        // loop ten times and keep adding to the string

        // declare the control variable
        var counter = 1
        while (counter <= 10) { // check the control variable
            // skip 3
            if ( counter == 3){
                counter++
                continue
            }
            // IMAD5112/p/w
            //Module Manual 2025.p 58-69

                val answer = tableNumber * counter
            tableDisplay += "$tableNumber x $counter = ${answer} \n"
            counter++     // update the control variable
        }
        // IMAD5112/p/w
        //Module Manual 2025.p 58-69

        // set the string onto the display
        displayingmultiplicationtables.text = tableDisplay

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

