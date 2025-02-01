package kr.hhplus.be.server.interfaces.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.hhplus.be.server.interfaces.dto.point.PointRequest;
import kr.hhplus.be.server.interfaces.dto.point.PointResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/point")
@Tag(name = "point", description = "포인트 관련 API")
public class PointController {

    // todo 포인트 충전
    @PostMapping("/charge")
    @Operation(summary = "포인트 충전", description = "특정 사용자의 포인트 충전")
    public ResponseEntity<?> charge(
            @RequestBody PointRequest.Charge request
    ) {
        return ResponseEntity.ok().body(
                PointResponse.Info.builder().point(request.getPoint()).build()
        );
    }

    // todo 포인트 사용
    @PostMapping("/use")
    @Operation(summary = "포인트 사용", description = "특정 사용자의 포인트 사용")
    public ResponseEntity<?> use(
            @RequestBody PointRequest.Use request
    ) {
        return ResponseEntity.ok().body(
                PointResponse.Info.builder().point(request.getPoint()).build()
        );
    }

}
