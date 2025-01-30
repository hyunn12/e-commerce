package kr.hhplus.be.server.interfaces.api;

import kr.hhplus.be.server.interfaces.dto.order.OrderResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    // todo 주문 추가
    @PostMapping("/insert")
    public ResponseEntity<?> insert() {
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
    public ResponseEntity<?> cancel() {
        return ResponseEntity.ok().body(
                OrderResponse.Info.builder().orderId(1L).status("CANCEL").build()
        );
    }

}
