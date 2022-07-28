package com.example.phonenumber.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.phonenumber.MessageActivity
import com.example.phonenumber.adapter.NumberListAdapter
import com.example.phonenumber.databinding.FragmentListNumberBinding
import com.example.phonenumber.model.NumberModel
import com.example.phonenumber.network.ClickListener
import com.example.phonenumber.util.BaseFragment

class ListNumberFragment : BaseFragment(),ClickListener {

    private lateinit var binding: FragmentListNumberBinding
    private lateinit var listNumberAdapter: NumberListAdapter
    private lateinit var numberListList: ArrayList<NumberModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListNumberBinding.inflate(inflater, container, false)
        numberListList = getNumberList()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setAdapter()
    }

    private fun init() {
//        numberList.getNumberList()
    }

    private fun setAdapter() {
        listNumberAdapter = NumberListAdapter(requireActivity(), numberListList,this)
        binding.rvNumberList.adapter = listNumberAdapter

    }

    override fun onClickItem(position: Int) {
      var intent=Intent(requireActivity(),MessageActivity::class.java)
        startActivity(intent)
    }


}