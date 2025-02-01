package kr.hhplus.be.server.interfaces.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.hhplus.be.server.interfaces.dto.rank.RankResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/rank")
@Tag(name = "rank", description = "상품 랭킹 관련 API")
public class RankController {

    // todo 인기 상품 목록 조회
    @GetMapping("/list")
    @Operation(summary = "인기 상품 목록 조회", description = "인기 상품 목록 조회")
    public ResponseEntity<?> list() {
        return ResponseEntity.ok().body(
                List.of(
                        RankResponse.Info.builder().rankId(1L).productId(1L).productName("상품명1").rank(1).salesCount(1000).rankedAt(LocalDateTime.now()).build(),
                        RankResponse.Info.builder().rankId(2L).productId(2L).productName("상품명2").rank(1).salesCount(100).rankedAt(LocalDateTime.now()).build(),
                        RankResponse.Info.builder().rankId(3L).productId(3L).productName("상품명3").rank(1).salesCount(10).rankedAt(LocalDateTime.now()).build(),
                        RankResponse.Info.builder().rankId(4L).productId(4L).productName("상품명4").rank(1).salesCount(5).rankedAt(LocalDateTime.now()).build(),
                        RankResponse.Info.builder().rankId(5L).productId(5L).productName("상품명5").rank(1).salesCount(1).rankedAt(LocalDateTime.now()).build()
                )
        );
    }

}
