package com.ohgiraffers.restapi.section2.responseentity;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.PrintStream;
import java.net.URI;
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
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        UserDTO foundUser=users.stream().filter(user->user.getNo()==userNo)
                                .collect(Collectors.toList()).get(0);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("user",foundUser);

        return ResponseEntity.ok().headers(headers).body(new ResponseMessage(200,"조회 성공",responseMap));

    }

    @PostMapping("/users")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO newUser){
        System.out.println("[nesUser]"+newUser);

        int lastUserNo=users.get(users.size()-1).getNo();
        newUser.setNo(lastUserNo+1);

        users.add(newUser);

        return ResponseEntity.created(URI.create("/entity/users/"+users.get(users.size()-1).getNo()))
                .build();
    }

    @PutMapping("/users/{userNo}")
    public ResponseEntity<?> modifyUser(@PathVariable int userNo, @RequestBody UserDTO modifyInfo){
        UserDTO foundUser=users.stream().filter(user->user.getNo()==userNo).
                collect(Collectors.toList()).get(0);

        foundUser.setId(modifyInfo.getId());
        foundUser.setPwd(modifyInfo.getPwd());
        foundUser.setName(modifyInfo.getName());

        return ResponseEntity.created(URI.create("/entity/users/"+userNo)).build();
    }

    @DeleteMapping("/users/{userNo}")
    public ResponseEntity<?> removeUser(@PathVariable int userNo){
        UserDTO foundUser=users.stream().filter(user->user.getNo()==userNo)
                .collect(Collectors.toList()).get(0);
        users.remove(foundUser);

        return ResponseEntity.noContent().build();
    }
}
