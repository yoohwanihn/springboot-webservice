package com.jvision.admin.web;


import com.jvision.admin.service.posts.PostsService;
import com.jvision.admin.web.dto.PostsResponseDto;
import com.jvision.admin.web.dto.PostsSaveRequestDto;
import com.jvision.admin.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

// Web Layer
// Controller와 JSP 등 뷰 템플릿 영역
// 이외에서 필터, 인터셉터, 컨트롤러 어드바이스 등 외부 요청과 응답에 대한 영역을 의미
@RequiredArgsConstructor
// Controller은 토스해주는 역할
@RestController
public class PostsApiController {
    private final PostsService postsService;

    // PostMapping은 입력값이 안보임
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    // @pathVariable => 밑에 id가 전달받는 id값이다 라는 걸 알려주기 위해
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }
}