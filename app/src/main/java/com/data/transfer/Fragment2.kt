package com.data.transfer

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentResultListener
import androidx.fragment.app.setFragmentResultListener
import kotlinx.android.synthetic.main.fragment_2.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "data"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment2 : Fragment(R.layout.fragment_2) {
    // TODO: Rename and change types of parameters
    private var param1: Data? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getParcelable(ARG_PARAM1)
        }

        setFragmentResultListener(requestKey = Constants.KEY_REQUEST_TRANSFER_BETWEEN_FRAGMENT) { key, bundle ->
            val result = bundle.getParcelable<Data>(Constants.KEY_BUNDLE_TRANSFER_BETWEEN_FRAGMENT)
            tv_fragment2_data.text = result.toString()
        }
    }



    companion object {
        fun newInstance(args: Bundle?) : Fragment2{
            val fragment2 = Fragment2()
            fragment2.arguments = args
            return fragment2
        }
    }
}
