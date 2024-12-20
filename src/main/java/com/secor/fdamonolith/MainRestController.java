package com.secor.fdamonolith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class MainRestController {

    @Autowired
    UserdetailRepository userdetailRepository;

    @PostMapping("update/user/details") // URIs SERVE CHUNKS OF DATA UNLIKE URLs WHICH SERVE PAGES
    public Response updateUserDetails(@RequestBody Userdetail userdetail)
    {
        userdetailRepository.save(userdetail);
        Response response = new Response();
        response.setResponseText("User details updated successfully");
        return response;
    }


}
