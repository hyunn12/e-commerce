package kr.hhplus.be.server.interfaces.api;

import kr.hhplus.be.server.interfaces.dto.cart.CartResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    // todo 장바구니 상품 추가
    @PostMapping("/insert")
    public ResponseEntity<?> insert() {
        return ResponseEntity.ok().body(
                CartResponse.Info.builder().cartId(1L).productId(1L).userId(1L).quantity(1).build()
        );
    }

    // todo 장바구니 상품 제거
    @PostMapping("/delete")
    public ResponseEntity<?> delete() {
        return ResponseEntity.ok().body(
                CartResponse.Info.builder().cartId(1L).productId(1L).userId(1L).quantity(1).build()
        );
    }

    // todo 장바구니 상품 수정
    @PostMapping("/modify")
    public ResponseEntity<?> modify() {
        return ResponseEntity.ok().body(
                CartResponse.Info.builder().cartId(1L).productId(1L).userId(1L).quantity(1).build()
        );
    }

}
