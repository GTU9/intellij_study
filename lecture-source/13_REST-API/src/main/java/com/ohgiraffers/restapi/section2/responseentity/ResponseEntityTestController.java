package com.ohgiraffers.restapi.section2.responseentity;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/entity")
public class ResponseEntityTestController {

    /*
    * [ ResponseEntity ]
    * 결과 데이터와 HTTP 상태 코드를 직접 제어할 수 있는 클래스이다.
    * HttpStatus, HttpHeaders, HttpBody를 포함한다.
    * */

    private List<UserDTO> users;

    public ResponseEntityTestController() {
        users=new ArrayList<>();

        users.add(new UserDTO(1,"ueser01","pass01","토끼",new Date()));
        users.add(new UserDTO(2,"ueser02","pass02","다람쥐",new Date()));
        users.add(new UserDTO(3,"ueser03","pass03","판다",new Date()));
    }
    @GetMapping("/users")
    public ResponseEntity<ResponseMessage> findAllUsers(){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("users", users);

        ResponseMessage responseMessage = new ResponseMessage(200,"조회 성공",responseMap);


        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    @GetMapping("/users/{userNo}")
    public ResponseEntity<ResponseMessage> findUserByNo(@PathVariable int userNo){
        UserDTO foundUser=users.stream().filter(user->user.getNo()==userNo)
                                .collect(Collectors.toList()).get(0);
    }
}
