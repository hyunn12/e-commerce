package kr.hhplus.be.server.interfaces.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.hhplus.be.server.interfaces.dto.user.UserRequest;
import kr.hhplus.be.server.interfaces.dto.user.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name = "user", description = "사용자 관련 API")
public class UserController {

    // todo 사용자 포인트 조회
    @Operation(summary = "사용자 포인트 조회", description = "특정 사용자의 포인트 조회")
    @GetMapping("/{id}/points")
    public ResponseEntity<?> getPoint(@PathVariable("id") Long userId) {
        return ResponseEntity.ok().body(
                UserResponse.PointInfo.builder().point(100000).build()
        );
    }

    // todo 포인트 충전
    @PostMapping("/{id}/points/charge")
    @Operation(summary = "포인트 충전", description = "특정 사용자의 포인트 충전")
    public ResponseEntity<?> chargePoint(
            @PathVariable("id") Long userId,
            @RequestBody UserRequest.ChargePoint request
    ) {
        return ResponseEntity.ok().body(
                UserResponse.PointInfo.builder().point(request.getPoint()).build()
        );
    }

    // todo 사용자 쿠폰 목록 조회
    @Operation(summary = "사용자 쿠폰 목록 조회", description = "특정 사용자의 쿠폰 목록 조회")
    @GetMapping("/{id}/coupons")
    public ResponseEntity<?> getCoupon(
            @PathVariable("id") Long userId
    ) {
        return ResponseEntity.ok().body(
                List.of(
                        UserResponse.CouponInfo.builder().couponId(1L).name("쿠폰1").discountType("PRICE").discountValue(5000).minAmount(10000).status("USED").usedAt(LocalDateTime.now()).expiredAt(LocalDateTime.now()).build(),
                        UserResponse.CouponInfo.builder().couponId(2L).name("쿠폰2").discountType("RATE").discountValue(10).minAmount(10000).status("UNUSED").expiredAt(LocalDateTime.now()).build()
                )
        );
    }

    // todo 쿠폰 발급
    @PostMapping("/{id}/coupons")
    @Operation(summary = "쿠폰 발급", description = "특정 쿠폰 발급")
    public ResponseEntity<?> issueCoupon(
            @PathVariable("id") Long userId,
            @RequestBody UserRequest.IssueCoupon request
    ) {
        return ResponseEntity.ok().body(
                UserResponse.CouponInfo.builder().couponId(1L).name("쿠폰1").discountType("FIXED").discountValue(5000).minAmount(10000).status("USED").expiredAt(LocalDateTime.now()).build()
        );
    }

    // todo 장바구니 상품 추가
    @PostMapping("/{id}/carts")
    @Operation(summary = "장바구니 추가", description = "특정 사용자의 장바구니에 추가")
    public ResponseEntity<?> createCart(
            @PathVariable("id") Long userId,
            @RequestBody UserRequest.CreateCart request
    ) {
        return ResponseEntity.ok().body(
                UserResponse.CartInfo.builder().cartId(1L).productId(request.getProductId()).userId(request.getUserId()).quantity(request.getQuantity()).build()
        );
    }

    // todo 장바구니 상품 제거
    @DeleteMapping("/{id}/carts")
    @Operation(summary = "장바구니 제거", description = "특정 사용자의 장바구니에서 제거")
    public ResponseEntity<?> deleteCart(
            @PathVariable("id") Long userId,
            @RequestBody UserRequest.DeleteCart request
    ) {
        return ResponseEntity.ok().body(
                UserResponse.CartInfo.builder().cartId(request.getCartId()).build()
        );
    }

    // todo 장바구니 상품 수정
    @PatchMapping("/{id}/carts")
    @Operation(summary = "장바구니 수정", description = "특정 사용자의 장바구니에서 수정")
    public ResponseEntity<?> modifyCart(
            @PathVariable("id") Long userId,
            @RequestBody UserRequest.ModifyCart request
    ) {
        return ResponseEntity.ok().body(
                UserResponse.CartInfo.builder().cartId(request.getCartId()).productId(1L).userId(1L).quantity(request.getQuantity()).build()
        );
    }

}
