package kr.hhplus.be.server.interfaces.api;

import kr.hhplus.be.server.interfaces.dto.point.PointResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/point")
public class PointController {

    // todo 포인트 충전
    @PostMapping("/charge")
    public ResponseEntity<?> charge() {
        return ResponseEntity.ok().body(
                PointResponse.Info.builder().point(10000).build()
        );
    }

    // todo 포인트 사용
    @PostMapping("/use")
    public ResponseEntity<?> use() {
        return ResponseEntity.ok().body(
                PointResponse.Info.builder().point(10000).build()
        );
    }

}
