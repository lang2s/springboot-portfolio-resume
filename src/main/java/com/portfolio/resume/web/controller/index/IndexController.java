package com.portfolio.resume.web.controller.index;

import com.portfolio.resume.config.auth.LoginUser;
import com.portfolio.resume.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {

       // SessionUser user = (SessionUser) httpSession.getAttribute("user");      // 로그인 성공시 Session 에 SessionUser 를 저장
                                                                                        // httpSession.getAttribute("user")에서 값을 가져올 수 있다
        if (user != null) { // 세션에 저장된 값이 있을때만 model에 userName으로 등록 세션에 저장된값이 없으면 model에 아무런 값이 없는 상태
            model.addAttribute("userList", user);
            System.out.println("=========== user_Role: " + user);
        }

        return "index";
    }

}
