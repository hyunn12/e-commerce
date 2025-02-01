package kr.hhplus.be.server.interfaces.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.hhplus.be.server.interfaces.dto.cart.CartRequest;
import kr.hhplus.be.server.interfaces.dto.cart.CartResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cart")
@Tag(name = "cart", description = "장바구니 관련 API")
public class CartController {

    // todo 장바구니 상품 추가
    @PostMapping("/insert")
    @Operation(summary = "장바구니 추가", description = "특정 사용자의 장바구니에 추가")
    public ResponseEntity<?> insert(
            @RequestBody CartRequest.Insert request
    ) {
        return ResponseEntity.ok().body(
                CartResponse.Info.builder().cartId(1L).productId(request.getProductId()).userId(request.getUserId()).quantity(request.getQuantity()).build()
        );
    }

    // todo 장바구니 상품 제거
    @PostMapping("/delete")
    @Operation(summary = "장바구니 제거", description = "특정 사용자의 장바구니에서 제거")
    public ResponseEntity<?> delete(
            @RequestBody CartRequest.Delete request
    ) {
        return ResponseEntity.ok().body(
                CartResponse.Info.builder().cartId(request.getCartId()).build()
        );
    }

    // todo 장바구니 상품 수정
    @PostMapping("/modify")
    @Operation(summary = "장바구니 수정", description = "특정 사용자의 장바구니에서 수정")
    public ResponseEntity<?> modify(
            @RequestBody CartRequest.Modify request
    ) {
        return ResponseEntity.ok().body(
                CartResponse.Info.builder().cartId(request.getCartId()).productId(1L).userId(1L).quantity(request.getQuantity()).build()
        );
    }

}
