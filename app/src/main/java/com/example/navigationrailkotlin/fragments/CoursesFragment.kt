package com.example.navigationrailkotlin.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.navigationrailkotlin.Communicator
import com.example.navigationrailkotlin.R
import com.example.navigationrailkotlin.databinding.FragmentCoursesBinding

class CoursesFragment : Fragment(), Communicator {
    private lateinit var binding: FragmentCoursesBinding
    private var mIsDualPane = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding =  FragmentCoursesBinding.inflate(inflater, container, false)

        mIsDualPane = binding.fragmentB?.visibility == View.VISIBLE

        return binding.root
    }

    override fun passDataCom(courseName: String, description: String, fee: Long) {
        if (mIsDualPane) { // If we are in Tablet
            val fragmentB = childFragmentManager.findFragmentById(R.id.fragmentB) as FragmentB?
            fragmentB?.displayDetails(courseName, description, fee)
        } else { // When we are in Smart phone
            val bundle = Bundle()
            bundle.putString("Name", courseName)
            bundle.putString("Description", description)
            bundle.putString("Fee", fee.toString())

            val transaction = this.childFragmentManager.beginTransaction()
            val frag2 = FragmentB()
            frag2.arguments = bundle

            transaction.replace(R.id.fragmentA, frag2)
            transaction.addToBackStack(null)
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            transaction.commit()
        }
    }
}