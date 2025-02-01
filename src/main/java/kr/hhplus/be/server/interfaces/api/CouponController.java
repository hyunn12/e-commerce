package kr.hhplus.be.server.interfaces.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.hhplus.be.server.interfaces.dto.coupon.CouponRequest;
import kr.hhplus.be.server.interfaces.dto.coupon.CouponResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/coupon")
@Tag(name = "coupon", description = "쿠폰 관련 API")
public class CouponController {

    // todo 쿠폰 발급
    @PostMapping("/issue")
    @Operation(summary = "쿠폰 발급", description = "특정 쿠폰 발급")
    public ResponseEntity<?> issue(
            @RequestBody CouponRequest.Issue request
    ) {
        return ResponseEntity.ok().body(
                CouponResponse.Info.builder().couponId(1L).name("쿠폰1").discountType("FIXED").discountValue(5000).minAmount(10000).status("USED").expiredAt(LocalDateTime.now()).build()
        );
    }

}
