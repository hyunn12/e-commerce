package kr.hhplus.be.server.interfaces.api;

import kr.hhplus.be.server.interfaces.dto.coupon.CouponResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/coupon")
public class CouponController {

    // todo 쿠폰 발급
    @PostMapping("/issue")
    public ResponseEntity<?> issue() {
        return ResponseEntity.ok().body(
                CouponResponse.Info.builder().couponId(1L).userId(1L).build()
        );
    }

}
