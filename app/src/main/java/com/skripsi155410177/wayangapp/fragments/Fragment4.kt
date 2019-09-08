package com.skripsi155410177.wayangapp.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_fragment4.*

import com.skripsi155410177.wayangapp.R
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class Fragment4 : Fragment() {

    var arr = arrayListOf<String>()
    var arr2 = arrayListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_fragment4, container, false)

        arr.clear()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        read_json()
    }

    fun read_json(){
        var json : String? = null
        try{
            val inputStream: InputStream = getContext()!!.assets.open("data_perang.json")
            json = inputStream.bufferedReader().use{it.readText()}

            var jsonarr = JSONArray(json)
            for(i in 0 until jsonarr.length()-1){
                var jsonobj = jsonarr.getJSONObject(i)
                arr.add(jsonobj.getString("nama"))
                arr2.add(jsonobj.getString("detail"))
            }

            var adp = ArrayAdapter(activity,android.R.layout.simple_list_item_1,arr)
            list4.adapter = adp

            list4.onItemClickListener = AdapterView.OnItemClickListener{ parent, view, position, id ->
                val toast = Toast.makeText(activity, arr2[position], Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER,0,0)
                toast.show()
            }
        }catch (e: IOException){

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}
