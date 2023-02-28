package com.example.spinner.listv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import com.example.spinner.listv.databinding.ActivityMainBinding


fun random(random:Int):String{
    var str="ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    var result=""
    for(i in 1..random)
    {
        result+=str.random().toString()
    }
    return result
}
class MainActivity : AppCompatActivity() {
    private val root: Int
        get() {
            TODO()
        }
    lateinit var binding: ActivityMainBinding
    lateinit var arrayAdapter: ArrayAdapter<String>
    var arrayList = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList)

        binding?.lvListView?.adapter = arrayAdapter

        binding?.fabBtn?.setOnClickListener {
            var alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle(resources.getString(R.string.Add_Data))
            alertDialog.setMessage(resources.getString(R.string.Add_Data_Msg))
            alertDialog.setCancelable(false)

            alertDialog.setNeutralButton(resources.getString(R.string.five)) { _, _ ->
                var result = random(3)
                arrayList.add((result.toString()))
                arrayAdapter.notifyDataSetChanged()
            }



            alertDialog.setNegativeButton(resources.getString(R.string.three)) { _, _ ->
                var result = random(4)
                arrayList.add((result.toString()))
                arrayAdapter.notifyDataSetChanged()
            }


            alertDialog.setPositiveButton(resources.getString(R.string.four)) { _, _ ->
                var result = random(5)
                arrayList.add((result.toString()))
                arrayAdapter.notifyDataSetChanged()
            }

            alertDialog.show()

        }

        binding.lvListView.setOnItemClickListener { _, _, position, _ ->
            System.out.println(" in click $position")
            var alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle(resources.getString(R.string.modify_data))
            alertDialog.setMessage(resources.getString(R.string.modify_data_msg))
            alertDialog.setCancelable(false)

            alertDialog.setNegativeButton(resources.getString(R.string.cancel)) { _, _ ->
                alertDialog.setCancelable(false)
            }
            alertDialog.setPositiveButton(resources.getString(R.string.delete)) { _, _ ->
                var result = ""
                arrayList.removeAt(position)
                arrayAdapter.notifyDataSetChanged()

            }
            alertDialog.show()

        }


    }


}