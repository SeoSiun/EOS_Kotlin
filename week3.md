
# <Recycler View>

## [Recycler View 란?]

- Recycler : 자원을 재활용한다.
    - 원래의 리스트뷰는 리스트 항목이 갱신될 때마다 매번 새로운 아이템 뷰를 새로 구성해야 함
    - 이와 달리 리사이클러뷰는 아이템뷰를 지속적으로 재활용한다. ⇒ 더 효율적

## [Recycler View의 구성요소]


### -Adapter

- 리사이클러뷰에 표시될 아이템 뷰를 생성하는 역할
- 사용자의 데이터 리스트로부터 아이템 뷰를 만드는 것

### -LayoutManager

- 아이템 뷰들이 리사이클러뷰 내부에서 배치되는 형태를 관리


### -ViewHolder

- 화면에 표시될 아이템 뷰를 저장

# + TextView

- maxLines : 최대 몇 줄까지 보여줄지 설정
- ellipsize를 end로 설정하면 나머지는 ...으로 보여줌
    
