package com.example.gf_managerapp

import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import androidx.fragment.app.Fragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [gf_home_screen.newInstance] factory method to
 * create an instance of this fragment.
 */
class gf_home_screen : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var manager: PackageManager
    var listApps = ArrayList<ImageModel>()
    var customerAdapter: CustomAdapter? = null
    lateinit var list: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*List Apps*/
        loadApps()


        val view: View = inflater.inflate(R.layout.fragment_gf_home_screen, container, false)
        val btnGoLauncher = view.findViewById<Button>(R.id.btn_go_launcher)


        var lv = view?.findViewById<ListView>(R.id.gf_lv_apps)
        customerAdapter = context?.let { CustomAdapter(it, listApps) }
        lv?.adapter = customerAdapter


        btnGoLauncher.setOnClickListener {
            Log.e("UX_UI", "IR A HOME LAUNCHER")
            val intentLauncher = Intent(context, gf_home_launcher::class.java)
            startActivity(intentLauncher)

        }
        // Inflate the layout for this fragment
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment gf_home_screen.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            gf_home_screen().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    fun loadApps(){
        manager = activity?.packageManager ?: manager

        var i: Intent  = Intent(Intent.ACTION_MAIN, null);
        i.addCategory(Intent.CATEGORY_LAUNCHER)
        var infos: List<ResolveInfo> = manager.queryIntentActivities(i, 0)
        var apps = arrayOfNulls<String>(infos.size)
        for ((i, info) in infos.withIndex()){
            val imageModel = ImageModel()
            imageModel.setNames(info.loadLabel(manager).toString())
            imageModel.setImage_drawables(info.loadIcon(manager))
            listApps.add(imageModel)
        }
        loadListView()
    }
    private fun loadListView(){


    }
}