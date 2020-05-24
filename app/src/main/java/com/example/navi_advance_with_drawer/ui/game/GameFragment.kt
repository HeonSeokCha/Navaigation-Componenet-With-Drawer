package com.example.navi_advance_with_drawer.ui.game

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.navi_advance_with_drawer.R
import kotlinx.android.synthetic.main.game_fragment.view.*

class GameFragment : Fragment() {

    companion object {
        fun newInstance() = GameFragment()
    }

    private lateinit var viewModel: GameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.game_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var cnt:Int = Integer.parseInt(view.btn_game.text.toString())
        view.btn_game.setOnClickListener {
            cnt+=1
            view.btn_game.text = (cnt).toString()
        }
    }

}
