2024-04-23 23:08 현재 구현 상황:

<h3><img align="left" width="120" src="https://github.com/agriades/Owner-avatar-SpartaCodingClub-AndroidKotlinBasic-StandardClass-HW4/assets/75528131/1fbf7f72-8af9-4af4-9658-4ac2d341a4a7"/>

 # < 2024-04-23 23:08 현재 구현 상황
 
- RecyclerView와 ViewModel을 한 번에 다루려니 너무 복잡해서, ViewModel만 사용해 보았습니다.
- MainActivity의 RecyclerView를 주석 처리하고, 테스트용 카드를 하나 만들어
1. activity_main과 MainActivity의 데이터 바인딩 (뷰바인딩에 한번 더 DataBindingUtil 쓰는 데이터바인딩은 처음 해봐요!) > 바뀌니 처음 바인딩도 lateinit var binding으로 수정했음.
2. binding.viewModel = cardViewModel로 뷰모델을 바인딩에 설정함
3. binding.lifecycleOwner = this < 뭐하는 건지 모르겠는데 찾아본 Medium 코드에 있어서 우선 적음
4. cardViewModel.refreshCardData() < CardViewModel에 선언한 메소드로, 카드 데이터를 갱신해주는 역할을 합니다. 갱신이라고 해서 거창해 보이지만 그냥 변수 3개로 옮겨 담는 것 같아요.

참고한 블로그 코드를 따라해 보고 ViewModel 개념 이해를 먼저 해 보고 싶었기에 card 여러 개는 아직 다루지 않았습니다. 추후 수정해야겠죠...

- Card.kt에 Card 자료형 정의(data class) 및 테스트용 카드 1장(DailyExpenses 카드의 이름, 번호, 유효기간, 잔고, 배경색)

[급한 해결이 필요]
- 배경색이 왠지 iBackground로 인식이 안 되는 것 같다. ![image](https://github.com/agriades/Owner-avatar-SpartaCodingClub-AndroidKotlinBasic-StandardClass-HW4/assets/75528131/e285ca84-c2e9-45e8-9d3c-626c5fade13a)
배경색 또한 카드 고유값으로 저장하고 싶은데 (많은 금융앱에서 카드 이미지의 배경은 순서대로 랜덤이 아닌 저장된 이미지이므로...) 잘 인식되던 값이 홀랑 빠졌는지 모를 일. 그냥 android studio 버그라서 회색 글자가 빠진 건가?
 
  
