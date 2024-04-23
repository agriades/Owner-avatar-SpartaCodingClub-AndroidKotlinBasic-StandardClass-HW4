## 2024-04-24

### 해야 할 일
1. activity_main.xml에 임시로 배치한 카드를 삭제하고, RecyclerView를 돌려놓기.
2. card_item_recycler_view.xml에 같은 방식으로 ViewModel을 가져오는 것이 가능한지 확인하기.
3. 가능할 경우: Card.kt의 getCardData()에서 return하는 초기값을 Card 단품이 아닌 List<Card> 또는 MutableList<Card> 등으로 변경하기.<br/>단 항이 여러개이면 복잡해지므로 우선 list 내에 카드 하나만 넣기.
4. card_item_recycler_view.xml에서 바인딩된 값을 불러올 수 있도록 수정하기. Card 단품 대신 List<Card>의 첫번째 인덱스 항이 불러와지면 된다.
5. 카드가 여러 장일 때의 문제를 해결하기.
   
## 2024-04-23
### 새로 배운 점
- 뷰바인딩 후 데이터 바인딩 사용 시, 바인딩 **값에 변화가 있으므로 lateinit var** binding으로 초기화해 두어야.
- ViewModel과 같은 data를 레이아웃 xml에 추가할 때에는 **xml version과 본격적인 layout widget 사이에 layout**을 넣어주어야 한다.

### 궁금한 점
- ##### viewModel.cardData.component1() 이런 식으로 변수명이 아닌 component라고 불려지는 이유?
  이왕이면 바로 변수명인 iName 등으로 xml 상에도 적고 싶다. 바로 보기 편하니까. 그런데 굳이 안 되는 이유가 있는지 궁금하다.
- ##### 왜 R.drawable 값은 바로 적용이 안 되는 것인지... 아하!
  android:src="@drawable/card_bg_grey" 값에 android:src=R.drawable.card_bg_deepblue (R.java 주소 int값) 이 들어가서 이게 뭐지? 한 듯!
- ##### 아직도 RecyclerView 활용이 어렵다.
  Adapter가 정보를 받아 AdapterView로 연결된 item에 뿌려준다면...<br/>**Adapter는 ViewModel과 연결**되어야 하는구나! data 속 값은 초기값이지 계속 갱신되지는 않을 테니?!

<br/>

||2024-04-23 23:08 현재 구현 상황|
|--|--|
|<img width="200" src="https://github.com/agriades/Owner-avatar-SpartaCodingClub-AndroidKotlinBasic-StandardClass-HW4/assets/75528131/1fbf7f72-8af9-4af4-9658-4ac2d341a4a7">|<br/>- RecyclerView와 ViewModel을 한 번에 다루려니 너무 복잡해서, ViewModel만 사용해 보았습니다.<br/>- MainActivity의 RecyclerView를 주석 처리하고, 테스트용 카드를 하나 만들었고 과정은 아래와 같습니다.<br/> <br/>1. activity_main과 MainActivity의 데이터 바인딩(DataBindingUtil으로 binding 변수 갱신)<br/>2. binding.viewModel = cardViewModel로 뷰모델을 바인딩에 설정함<br/>3. binding.lifecycleOwner = this [이해X] <br/> 4. cardViewModel.refreshCardData() 카드 데이터 갱신<br/><br/><br/> lifecycleOwner [이해X] 뭐하는 건지 모르겠는데 찾아본 Medium 코드에 있어서 우선 적음<br/>갱신이라고 해서 거창해 보이지만 그냥 변수 3개로 옮겨 담는 것 같아요.|
|<img width="200" src="https://github.com/agriades/Owner-avatar-SpartaCodingClub-AndroidKotlinBasic-StandardClass-HW4/assets/75528131/e285ca84-c2e9-45e8-9d3c-626c5fade13a">|- Card.kt에 Card 자료형 정의(data class) 및 테스트용 카드 1장(DailyExpenses 카드의 이름, 번호, 유효기간, 잔고, 배경색<br/><br/>[급한 해결이 필요]<br/>- 배경색이 왠지 iBackground로 인식이 안 되는 것 같다.<br/><br/>배경색 또한 카드 고유값으로 저장하고 싶은데, 그냥 android studio 버그라서 회색 글자가 빠진 건가? |
