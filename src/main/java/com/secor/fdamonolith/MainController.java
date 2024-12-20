package com.secor.fdamonolith;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("app")
public class MainController
{
    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    //@Autowired // One way to ask for a Bean to be Injected
    private  CredentialRepository credentialRepository;

    @Autowired
    @Qualifier("AnotherDummyCredential")  // NAME OF THE BEAN TO BE INJECTED
    Credential dummyCredential;

    public MainController(CredentialRepository credentialRepository)
    {
        this.credentialRepository = credentialRepository;
        // Main Controller Object will get ready only after all the dependencies are injected
    }

    @GetMapping("testB")
    public String testButton(Model model,
                             HttpServletRequest request
                             ) // DATA TO BE EXTRACTED FROM THE INCOMING REQUEST
    {
        //Integer s = Integer.valueOf(num1) + Integer.valueOf(num2);
       // model.addAttribute("sum", s);

        // response.out("<h1>hello  this is from he  + someJava VARIABLE  +</h1>");
        // response.out("     ")

        log.info(" Request ID is "+request.getRequestId());
        model.addAttribute("reqid", request.getRequestId());
        log.info(" username is :"+dummyCredential.getUsername());
        log.info(" password is :"+dummyCredential.getPassword());
        model.addAttribute("username", dummyCredential.getUsername());
        model.addAttribute("password", dummyCredential.getPassword());
        return "testpage";
    }

    @PostMapping("/signup")
    public String signup(@RequestParam("username") String username,
                         @RequestParam("password") String password)
    {
        // If the object lifetime is pretty small and if you don't need to share it with other objects
        //then you may create it with the NEW KEYWORD
        Credential credential = new Credential(); //POJO Object Created here
        credential.setUsername(username);
        credential.setPassword(password);
        credentialRepository.save(credential); // INSERT INTO...
        return "redirect:/index.html";

        // Object destroyed here
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model)
    {
        Credential credential = credentialRepository.findById(username).orElse(null);
        if (credential != null && credential.getPassword().equals(password))
        {
            model.addAttribute("username", username);
            return "dashboard";
        }
        else
        {
            return "redirect:/index.html";
        }
    }

}
