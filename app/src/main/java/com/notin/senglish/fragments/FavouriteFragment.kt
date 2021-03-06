package com.notin.senglish.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.notin.senglish.R
import com.notin.senglish.adapter.CustomFavouriteAdapter
import com.notin.senglish.model.Word
import kotlinx.android.synthetic.main.fragment_favourite.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class FavouriteFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_main_menu)
        var share = context?.getSharedPreferences("SEnglish", Context.MODE_PRIVATE)
        var indexLove = share!!.getString("indexLove","")
        var arrWords = ArrayList<Word>()
        if(indexLove !=""){
            var arrListLove = indexLove!!.split(",")
            for(love in arrListLove){
                if(love != ""){
                    arrWords.add(Word(love,""))
                }
            }
        }
//        arrWords.add(Word("Hello","Xin chào"))
//        arrWords.add(Word("Good","Tốt"))
//        arrWords.add(Word("Think","Suy nghĩ"))
//        arrWords.add(Word("Many","Nhiều"))
//        arrWords.add(Word("Love","Yêu"))
        var adapter = CustomFavouriteAdapter(activity as Context, arrWords)
        rvWordFavourite.adapter = adapter

        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favourite, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FavouriteFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FavouriteFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}