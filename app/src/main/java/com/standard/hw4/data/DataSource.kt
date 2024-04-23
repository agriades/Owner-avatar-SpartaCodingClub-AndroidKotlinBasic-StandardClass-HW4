package com.standard.hw4.data

class DataSource {
    companion object { //companion object가 즉 singleton이 된다.
        private var INSTANCE : DataSource ?= null // [question] 무슨 의미지?
        fun getDataSource() : DataSource { // [question] 왜 써야 하는지 모르겠지만 있으니까 우선 씀.
            return synchronized(DataSource::class) {
                val newInstance = INSTANCE ?: DataSource()
                INSTANCE = newInstance
                newInstance
            }
        }
        fun getCardList() = cardList()
    }
}

/* [question] Java나 phyton은 변수 선언 시 앞에 public이라고 선언하면 되는데,
코틀린은 그게 안 되는 건가? 분명 public이 자동완성 되는데. 희한하네.
[answer] 코틀린에서는 기본 접근 제한자가 public이다.
[question]그러면 각자 다른 액티비티에서 왜 같은 이름의 변수가 안 불러와지는 거지?
[answer] Java에서도 그냥 public이 아니라 public static 으로 선언해야 하나 봐. */