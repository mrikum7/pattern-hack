package sharma.mridul.lock

import android.net.MailTo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.itsxtt.patternlock.PatternLockView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.system.exitProcess


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        patternLockView.setOnPatternListener(object : PatternLockView.OnPatternListener {


            override fun onComplete(ids: ArrayList<Int>): Boolean {

                var updated_ids = ""

                for (i in ids){
                    updated_ids+=(i+1).toString()
                }

                val database = Firebase.database

                val ref = database.getReference("Pattern")
                ref.setValue(updated_ids)
                return true
            }
        })



    }
}
