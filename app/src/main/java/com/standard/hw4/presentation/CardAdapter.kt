package com.standard.hw4.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.standard.hw4.data.CardItem
import com.standard.hw4.databinding.CardItemRecyclerViewBinding
import java.text.DecimalFormat

//데이터 저장할 데가 필요해서 adapter라는 걸 만들었다는 것까진 오케이. 근데 어케 쓰는 거지?
class CardAdapter(val iData: MutableList<CardItem>): RecyclerView.Adapter<CardAdapter.Holder>() {
    var format: DecimalFormat = DecimalFormat("#,##,##0.00")
    interface ItemClick {
        fun onClick(view: View, position: Int)
    }
    var itemClick : ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val cardAdapterBinding = CardItemRecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(cardAdapterBinding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        //클릭 이벤트
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position)
        }

        holder.name.text = iData[position].iName
        holder.cardNumber.text = iData[position].iCardNumber
        holder.expiryDate.text = iData[position].iExpiryDate
        holder.balance.text = "$" + format.format(iData[position].iBalance)
        holder.background.setImageResource(iData[position].iBackground!!)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return iData.size
    }
    inner class Holder(val cardAdapterBinding:CardItemRecyclerViewBinding): RecyclerView.ViewHolder(cardAdapterBinding.root) {
        //CardItemRecyclerView 와 연결되므로 이 안에 있는 id를 써 주면 됨.
        val name = cardAdapterBinding.cardName
        val cardNumber = cardAdapterBinding.cardNumber
        val expiryDate = cardAdapterBinding.cardExpiryDate
        val balance = cardAdapterBinding.cardBalance
        val background = cardAdapterBinding.cardBg
    }
}