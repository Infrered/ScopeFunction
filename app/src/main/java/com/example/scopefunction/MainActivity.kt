package com.example.scopefunction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val person = Person(_name = "Mike")

        val result = person.let{//uses 'it' as its object function
            it.name = "Kevin" //Returns UNIT i.e. Void in java
            it.name//Returns the New name
        }
        val result1 = person.run {//uses 'this' as its object function
            this.name = "Kevin"
            this.name
        }

        val result2 = with(person) {//'person' is passed as an argument, not an extension function
            this.name = "Kevin"
            this.name
        }

        val result3 = person.apply{//you can manipulate code, but it will return the person object reference
            name = "Kevin"
        }.name //use the entire object to return the 'name'

        val result4 = person.also{//uses 'it' as its object reference
            it.name = "Kevin"
            it.name
        }.run {

        }.apply {//scope functions like apply, and also, can chain multiple scope functions

        }

        println("Result: $result")


    }
}