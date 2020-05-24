package com.example.navi_advance_with_drawer.ui.movie

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.navi_advance_with_drawer.R
import kotlinx.android.synthetic.main.movie_fragment.view.*

class MovieFragment : Fragment() {

    companion object {
        fun newInstance() = MovieFragment()
    }

    private lateinit var viewModel: MovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movie_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.btn_calc.setOnClickListener {
            view.txt_result.text = " = "+(Integer.parseInt(view.editText2.text.toString())+Integer.parseInt(view.editText3.text.toString())).toString()
        }
    }
}
