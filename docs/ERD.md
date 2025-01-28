## ERD

### 데이터 목록

- **USER**:  회원
- **POINT**: 포인트
- **PRODUCT**: 상품
- **PRODUCT_STOCK**: 재고
- **ORDER**: 주문
- **ORDER_ITEM**: 주문 상세
- **PAYMENT**: 결제
- **COUPON**: 쿠폰
- **USER_COUPON**: 사용자 쿠폰
- **CART**: 장바구니
- **SALES_RANK**: 판매순위


### ERD
```mermaid  
erDiagram  
    USER {  
        BIGINT USER_ID PK "회원 ID"  
        VARCHAR USER_NAME "회원명"  
        DATETIME CREATED_AT "생성일"  
        DATETIME UPDATED_AT "수정일"  
        DATETIME DELETED_AT "삭제일"  
    }  
  
    POINT {  
        INT POINT_ID PK "포인트 ID"  
        INT USER_ID FK "회원 ID"  
        INT POINT "포인트"  
        DATETIME CREATED_AT "생성일"  
        DATETIME UPDATED_AT "수정일"  
        DATETIME DELETED_AT "삭제일"  
    }  
  
    PRODUCT {  
        INT PRODUCT_ID PK "상품 ID"  
        VARCHAR NAME "상품명"  
        INT PRICE "가격"  
        DATETIME CREATED_AT "생성일"  
        DATETIME UPDATED_AT "수정일"  
        DATETIME DELETED_AT "삭제일"  
    }  
        
    PRODUCT_STOCK {  
        INT STOCK_ID PK "상품재고 ID"  
        INT PRODUCT_ID FK "상품 ID"  
        INT QUANTITY "수량"  
        DATETIME CREATED_AT "생성일"  
        DATETIME UPDATED_AT "수정일"  
        DATETIME DELETED_AT "삭제일"  
    }  
        
    ORDER {  
        INT ORDER_ID PK "주문 ID"  
        INT USER_ID FK "회원 ID"  
        INT COUPON_ID FK "쿠폰 ID"  
        INT TOTAL_AMOUNT "총금액"  
        INT FINAL_AMOUNT "최종금액"  
        VARCHAR STATUS "주문상태 (SUCCESS, FAIL, CANCEL)"  
        DATETIME CREATED_AT "생성일"  
        DATETIME UPDATED_AT "수정일"  
        DATETIME DELETED_AT "삭제일"  
    }  
        
    ORDER_ITEM {  
        INT ORDER_ITEM_ID PK "주문상세 ID"  
        INT ORDER_ID FK "주문 ID"  
        INT PRODUCT_ID FK "상품 ID"  
        INT QUANTITY "수량"  
        INT SUBTOTAL "소계"  
        DATETIME CREATED_AT "생성일"  
        DATETIME UPDATED_AT "수정일"  
        DATETIME DELETED_AT "삭제일"  
    }  
        
    PAYMENT {  
        INT PAYMENT_ID PK "결제 ID"  
        INT ORDER_ID FK "주문 ID"  
        INT USER_ID FK "회원 ID"  
        INT PAYMENT_AMOUNT "결제금액"  
        VARCHAR STATUS "결제상태 (SUCCESS, FAIL, CANCEL)"  
        DATETIME CREATED_AT "생성일"  
        DATETIME UPDATED_AT "수정일"  
        DATETIME DELETED_AT "삭제일"  
    }  
    
    COUPON {  
        INT COUPON_ID PK "쿠폰 ID"  
        VARCHAR NAME "쿠폰명"  
        INT MAX_COUNT "최대개수"  
        INT AVAILABLE_COUNT "발급가능개수"  
        VARCHAR DISCOUNT_TYPE "할인유형 (FIXED, PERCENTAGE)"
        INT DISCOUNT_VALUE "할인값"
        INT MIN_AMOUNT "최소금액"
        DATETIME EXPIRE_AT "만료일"
        DATETIME CREATED_AT "생성일"  
        DATETIME UPDATED_AT "수정일"  
        DATETIME DELETED_AT "삭제일"  
    }  
        
    USER_COUPON {
        INT USER_COUPON_ID PK "쿠폰 ID"  
        INT COUPON_ID FK "쿠폰 ID"  
        INT USER_ID FK "회원 ID"  
        VARCHAR STATUS "쿠폰상태 (UNUSED, USED, EXPIRED)"   
        DATETIME CREATED_AT "생성일"  
        DATETIME USED_AT "사용일"  
        DATETIME DELETED_AT "삭제일"  
    }  
  
    CART {  
        INT CART_ID PK "카트 ID"  
        INT USER_ID FK "회원 ID"  
        INT PRODUCT_ID FK "상품 ID"  
        INT QUANTITY "수량"  
        DATETIME CREATED_AT "생성일"  
        DATETIME UPDATED_AT "수정일"  
        DATETIME DELETED_AT "삭제일"  
    }

    SALES_RANK {  
        INT RANK_ID PK "순위 ID"  
        INT PRODUCT_ID "상품 ID"
        VARCHAR PRODUCT_NAME "상품명"
        INT RANK "순위"
        INT SALES_COUNT "판매수량"
        DATETIME RANKED_AT "순위기준일"
        DATETIME CREATED_AT "생성일"  
    }  
  
    USER ||--|| POINT : "1:1"  
    PRODUCT ||--|| PRODUCT_STOCK : "1:1"  
    USER ||--o{ ORDER : "1:N"  
    COUPON ||--o{ ORDER : "1:N"  
    ORDER ||--o{ ORDER_ITEM : "1:N"  
    PRODUCT ||--o{ ORDER_ITEM : "1:N"  
    ORDER ||--|| PAYMENT : "1:1"  
    USER ||--o{ PAYMENT : "1:N"  
    USER ||--o{ USER_COUPON : "1:N"  
    COUPON ||--o{ USER_COUPON : "1:N"  
    USER ||--o{ CART : "1:N"  
  
```

- 상품의 재고에 `lock` 을 걸어도 상품에는 영향이 가지 않도록 `PRODUCT` 테이블과 `PRODUCT_STOCK` 테이블을 분리한다.
- 주문에는 상태값이 존재하고 하나의 주문으로 해당 주문서에 포함된 주문 상품들이 관리되어야 하므로, `ORDER` 테이블과 `ORDER_ITEM` 테이블을 분리한다.
- 인기 상품 목록 조회 시, 조회 성능 최적화를 위해 `SALES_RANK` 테이블을 생성해 사전 집계 데이터를 저장한다.
