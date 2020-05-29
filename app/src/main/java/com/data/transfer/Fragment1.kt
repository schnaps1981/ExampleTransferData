package com.data.transfer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import kotlinx.android.synthetic.main.fragment_1.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "data"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment1.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment1 : Fragment(R.layout.fragment_1) {
    // TODO: Rename and change types of parameters
    private var data: Data? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            data = it.getParcelable(ARG_PARAM1)

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_fragment1_data.text = data.toString()

        btn_fragment1_to_activity.setOnClickListener {
            (activity as? SnackHandler)?.showSnack(data.toString())
        }

        btn_fragment1_to_fragment2.setOnClickListener {
            setFragmentResult(
                requestKey = Constants.KEY_REQUEST_TRANSFER_BETWEEN_FRAGMENT,
                result = bundleOf(Constants.KEY_BUNDLE_TRANSFER_BETWEEN_FRAGMENT to data)
            )
        }
    }

    companion object {
        fun newInstance(args: Bundle?): Fragment1 {
            val fragment1 = Fragment1()
            fragment1.arguments = args
            return fragment1
        }
    }
}
