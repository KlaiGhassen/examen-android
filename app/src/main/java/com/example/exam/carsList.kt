package com.example.exam

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [carsList.newInstance] factory method to
 * create an instance of this fragment.
 */
class carsList : Fragment() {
    lateinit var recylcerChampionAdapter: adapter
    lateinit var carRecyclerView: RecyclerView
    // TODO: Rename and change types of parameters


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var rootView= inflater.inflate(R.layout.fragment_cars_list, container, false)

        var champList : MutableList<car> = ArrayList()


        carRecyclerView = rootView.findViewById(R.id.recycler_champ)


        champList.add(car(id=0 ,carPic = R.drawable.ic_book1, Nom = "Programming Android with Kotlin", dispo = "Pierre-Olivier Laurence",prix = 85))
        champList.add(car(id=2 ,carPic = R.drawable.ic_book2, Nom = "Kotlin Programming", dispo = "David Greenhalgh",prix = 85 ))
        champList.add(car(id= 3,carPic = R.drawable.ic_book3, Nom = "Java to Kotlin", dispo = "Duncan McGregor",prix = 85 ))
        champList.add(car(id= 4,carPic = R.drawable.ic_book4, Nom = "Reactive Programming with Kotlin", dispo = "Ray Wenderlich",prix = 85 ))
        champList.add(car(id= 5,carPic = R.drawable.ic_book5, Nom = "Dagger by Tutorials", dispo = "Ray Wenderlich",prix = 85 ))
        champList.add(car(id= 6,carPic = R.drawable.ic_book6, Nom = "Kotlin and Android Development featuring Jetpack", dispo = "Ray Wenderlich",prix = 85 ))
        champList.add(car(id= 6,carPic = R.drawable.ic_book6, Nom = "Real-World Android by Tutorialsl", dispo = "Ray Wenderlich",prix = 85 ))
        champList.add(car(id= 6,carPic = R.drawable.ic_book7, Nom = "Android Studio 4.2 Development Essentials", dispo = "Ray Wenderlich",prix = 85 ))
        champList.add(car(id= 6,carPic = R.drawable.ic_book8, Nom = "Learn to Program with Kotlin", dispo = "Ray Wenderlich",prix = 85 ))

        recylcerChampionAdapter = adapter(champList)
        carRecyclerView.adapter = recylcerChampionAdapter

        carRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL ,
            false)


        return rootView
    }
    }


