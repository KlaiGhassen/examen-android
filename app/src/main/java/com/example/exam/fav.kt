package com.example.exam

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exm.AppDataBase

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fav.newInstance] factory method to
 * create an instance of this fragment.
 */
class fav : Fragment() {
    lateinit var recylcerChampionAdapter: adapter2
    lateinit var carRecyclerView: RecyclerView
    lateinit var dataBase: AppDataBase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView= inflater.inflate(R.layout.fragment_fav, container, false)

        var champList : MutableList<car> = ArrayList()
        dataBase = AppDataBase.getDatabase(requireActivity())

        carRecyclerView = rootView.findViewById(R.id.fav)

        champList =  dataBase.championDao().getAllchamps()

        recylcerChampionAdapter = adapter2(champList)
        carRecyclerView.adapter = recylcerChampionAdapter

        carRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL ,
            false)


        return rootView
    }

}