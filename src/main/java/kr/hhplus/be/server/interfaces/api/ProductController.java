package kr.hhplus.be.server.interfaces.api;

import kr.hhplus.be.server.interfaces.dto.product.ProductResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    // todo 상품 목록 조회
    @GetMapping("/list")
    public ResponseEntity<?> list() {
        return ResponseEntity.ok().body(
                List.of(
                        ProductResponse.Info.builder().productId(1L).name("상품명1").price(10000).createdAt(LocalDateTime.now()).build(),
                        ProductResponse.Info.builder().productId(2L).name("상품명2").price(20000).createdAt(LocalDateTime.now()).build()
                )
        );
    }

    // todo 상품 상세 조회
    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detail(@PathVariable("id") Long productId) {
        return ResponseEntity.ok().body(
                ProductResponse.Info.builder().productId(1L).name("상품명1").price(10000).createdAt(LocalDateTime.now()).build()
        );
    }

}
