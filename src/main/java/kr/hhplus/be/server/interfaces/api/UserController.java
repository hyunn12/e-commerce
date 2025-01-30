package kr.hhplus.be.server.interfaces.api;

import kr.hhplus.be.server.interfaces.dto.user.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    // todo 사용자 포인트 조회
    @GetMapping("/point/{id}")
    public ResponseEntity<?> getPoint(@PathVariable("id") Long userId) {
        return ResponseEntity.ok().body(
                UserResponse.PointInfo.builder().point(100000).build()
        );
    }

    // todo 사용자 쿠폰 목록 조회
    @GetMapping("/coupons/{id}")
    public ResponseEntity<?> getCoupon(@PathVariable("id") Long userId) {
        return ResponseEntity.ok().body(
                List.of(
                        UserResponse.CouponInfo.builder().couponId(1L).name("쿠폰1").discountType("FIXED").discountValue(5000).minAmount(10000).status("USED").expiredAt(LocalDateTime.now()).build(),
                        UserResponse.CouponInfo.builder().couponId(2L).name("쿠폰2").discountType("PERCENTAGE").discountValue(10).minAmount(10000).status("UNUSED").expiredAt(LocalDateTime.now()).build()
                )
        );
    }

}
