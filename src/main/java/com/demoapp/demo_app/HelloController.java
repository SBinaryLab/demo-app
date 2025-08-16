// package com.demoapp.demo_app;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.ui.Model;

// @RestController
// public class HelloController {

//     @GetMapping("/hello")
//     public String sayHello(Model model) {
//         return "hello";
//     }
// }

package com.demoapp.demo_app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/")
    public String sayHello(Model model) {
        return "hello"; // This should resolve to hello.html in templates
    }
}