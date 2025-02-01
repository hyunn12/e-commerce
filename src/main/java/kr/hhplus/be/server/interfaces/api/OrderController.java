package kr.hhplus.be.server.interfaces.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.hhplus.be.server.interfaces.dto.order.OrderRequest;
import kr.hhplus.be.server.interfaces.dto.order.OrderResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@Tag(name = "order", description = "주문 관련 API")
public class OrderController {

    // todo 주문 추가
    @PostMapping("/insert")
    @Operation(summary = "주문 추가", description = "특정 사용자의 주문 추가")
    public ResponseEntity<?> insert(
            @RequestBody OrderRequest.Insert request
    ) {
        List<OrderResponse.ItemInfo> items = List.of(
                OrderResponse.ItemInfo.builder().orderItemId(1L).orderId(1L).productId(1L).quantity(1).subtotal(5000).build(),
                OrderResponse.ItemInfo.builder().orderItemId(2L).orderId(1L).productId(2L).quantity(2).subtotal(5000).build(),
                OrderResponse.ItemInfo.builder().orderItemId(3L).orderId(1L).productId(3L).quantity(1).subtotal(5000).build()
        );
        return ResponseEntity.ok().body(
                OrderResponse.Info.builder().orderId(1L).totalAmount(20000).finalAmount(15000).status("SUCCESS").items(items).build()
        );
    }

    // todo 주문 취소
    @PostMapping("/cancel")
    @Operation(summary = "주문 취소", description = "특정 주문 취소")
    public ResponseEntity<?> cancel(
            @RequestBody OrderRequest.Cancel request
    ) {
        return ResponseEntity.ok().body(
                OrderResponse.Info.builder().orderId(1L).status("CANCEL").build()
        );
    }

}
