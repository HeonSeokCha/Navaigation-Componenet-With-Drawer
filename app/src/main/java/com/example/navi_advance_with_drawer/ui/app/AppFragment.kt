package com.example.navi_advance_with_drawer.ui.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navi_advance_with_drawer.R
import kotlinx.android.synthetic.main.app_fragment.view.btn_app


class AppFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.app_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var cnt:Int = Integer.parseInt(view.btn_app.text.toString())
        view.btn_app.setOnClickListener {
            cnt+=1
            view.btn_app.text = (cnt+1).toString()
        }
    }

}
