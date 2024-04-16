package com.standard.hw4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

//데이터 저장할 데가 필요해서 adapter라는 걸 만들었다는 것까진 오케이. 근데 어케 쓰는 거지?
class CardAdapter(val iData: List<CardItem>): BaseAdapter() {
    override fun getCount(): Int = iData.size
    override fun getItem(position: Int): Any = iData[position]
    override fun getItemId(position: Int): Long = position.toLong()
    //위에는 그냥 데이터 list의 size, position, position의 toLong값을 항상 추가하나 보다.
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        //매개변수는 다른 코드 예시에서도 같은 것으로 보아 항상 이렇게 쓰나 봐.
        val cardView: View
        cardView = convertView as View
        return cardView
    }
}