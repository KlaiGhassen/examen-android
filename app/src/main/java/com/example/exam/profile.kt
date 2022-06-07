package com.example.exam

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [profile.newInstance] factory method to
 * create an instance of this fragment.
 */
class profile : Fragment() {
    lateinit var mSharedPref: SharedPreferences
    lateinit var usernameProfile: TextView
    lateinit var email: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_profile, container, false)
        mSharedPref = requireActivity().getSharedPreferences("LOGIN_PREF_CAR", AppCompatActivity.MODE_PRIVATE);
        usernameProfile = rootView.findViewById<TextView?>(R.id.textView)
        email = rootView.findViewById<TextView?>(R.id.email)

        val nameStr: String = mSharedPref.getString("LOGIN", LOGIN).toString()
        val emailStr: String = mSharedPref.getString("EMAIL", EMAIL).toString()
email.text= emailStr
        usernameProfile.text = nameStr

        return rootView

        return inflater.inflate(R.layout.fragment_profile, container, false)
    }    }


