## 시퀀스 다이어그램

### 상품 조회
> 사용자가 상품 정보를 조회한다.

```mermaid
sequenceDiagram
    actor User

    User->>API: [GET] 상품 정보 조회 
    API->>+PRODUCT: 상품 정보 조회 요청
    PRODUCT-->>-API: 조회 정보 반환
    API-->>User: 결과 응답

```

### 포인트 충전 / 조회
> 사용자가 결제에 사용될 포인트를 충전 및 조회한다.

```mermaid
sequenceDiagram
    actor User

    User->>API: [PATCH] 포인트 충전
    API->>+POINT: 포인트 충전 요청
    
    alt 유효하지 않은 충전값인 경우
        POINT -->> User: 포인트 충전 Exception 반환
    else 유효한 충전값인 경우
        POINT-->>-API: 충전 결과 반환
        API-->>User: 결과 응답
    end
    User->>API: [GET] 포인트 조회
    API->>+POINT: 포인트 조회 요청
    POINT-->>-API: 조회 결과 반환
    API-->>User: 결과 응답

```

### 선착순 쿠폰 발급
> 사용자가 쿠폰을 발급받는다.

```mermaid
sequenceDiagram
    actor User

    User->>API: [POST] 쿠폰 발급
    API->>+COUPON: 쿠폰 잔여 수량 조회
    alt 잔여 수량이 없을 경우
        COUPON-->>User: 쿠폰 잔여 수량 부족 Exception 반환
    else 잔여 수량이 있을 경우
        COUPON->>COUPON: 쿠폰 발급 가능 수량 차감
        COUPON->>COUPON: 사용자쿠폰 정보 생성 요청
        COUPON-->>-API: 생성 결과 반환
        API-->>User: 결과 응답
    end

```

### 장바구니
> 사용자가 상품을 장바구니에 추가한다.

```mermaid
sequenceDiagram
    actor User

    User->>API: [POST] 장바구니 상품 추가
    API->>+CART: 장바구니 상품 추가 요청
    CART->>+STOCK: 상품 재고 조회
    STOCK-->>-CART: 재고 조회 결과
    
    alt 재고가 없는 경우
        CART-->>User: 상품 재고 Exception 반환
    else 재고가 있는 경우
        CART->>CART: 상품 장바구니 정보 생성 요청
        CART-->>-API: 생성 결과 반환
        API-->>User: 결과 응답
    end

```

### 주문
> 사용자가 상품을 주문한다.

```mermaid
sequenceDiagram
    actor User

    User->>API: [POST] 주문 요청
    API->>+ORDER: 주문 요청 전달

    ORDER->>+STOCK: 상품 재고 조회
    STOCK-->>-ORDER: 재고 조회 결과

    alt 재고 없음
        ORDER-->>API: 상품 재고 Exception 반환
        API-->>User: 결과 응답
    else 재고 있음
        ORDER->>+COUPON: 쿠폰 상태 조회
        COUPON-->>-ORDER: 상태 조회 결과

        alt 쿠폰 유효하지 않음
            ORDER-->>API: 쿠폰 Exception 반환
            API-->>User: 결과 응답
        else 쿠폰 유효
            ORDER->>ORDER: 주문 정보 생성 요청
            
            ORDER->>+COUPON: 쿠폰 사용 상태 변경 요청
            COUPON-->>-ORDER: 변경 결과 반환

            ORDER--)CART: 장바구니 상품 제거 요청

            ORDER->>+STOCK: 재고 차감 요청
            STOCK-->>-ORDER: 차감 결과 반환

            ORDER-->>-API: 주문 결과 반환
            API-->>User: 결과 응답
        end
    end

```

재고 락 -> 분산락 걸기
멀티락 오키..


### 결제
> 사용자가 기충전된 포인트를 사용해 결제한다.

```mermaid
sequenceDiagram
    actor User

    User->>API: [POST] 결제 요청
    API->>+PAYMENT: 결제 요청
    
    PAYMENT->>+POINT: 포인트 조회 요청
    POINT-->>-PAYMENT: 조회 결과 반환
    
    alt 사용 포인트가 잔여 포인트보다 큰 경우
        PAYMENT-->>API: 포인트 사용 Exception 반환
        API-->>User: 결과 응답
    else 사용 포인트가 잔여 포인트보다 작거나 같은 경우
        PAYMENT->>PAYMENT: 결제 정보 생성 요청
        
        PAYMENT->>+POINT: 포인트 차감 요청
        POINT-->>-PAYMENT: 차감 결과 반환
        
        PAYMENT->>+ORDER: 주문 상태 변경 요청
        ORDER-->>-PAYMENT: 변경 결과 반환
        
        PAYMENT--)External API: 결제 데이터 전송
        PAYMENT-->>-API: 결제 결과 반환
        API-->>User: 결과 응답
    end

```


### 인기 상품 조회
> 주문 내역을 기반으로 최근 3일간 가장 많이 판매된 상위 5개 상품 목록을 조회한다.

```mermaid
sequenceDiagram
    actor User
    
    User->>API: [GET] 인기 상품 조회
    API->>+SALES_RANK: 인기 상품 조회
    SALES_RANK-->>-API: 조회 결과 반환
    API-->>User: 결과 응답

```

