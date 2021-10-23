package org.example.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/all")
public class Resource {

    private final UserRepository userRepository;

    public Resource(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public List<Users> all(){
        return userRepository.findAll();
    }

    @GetMapping("/create")
    public List<Users> users(){
        Users users = new Users();
        users.setId(1);
        users.setName("Sam");
        users.setSalary(3455);
        users.setTeamName("Development");
        userRepository.save(users);

        return userRepository.findAll();
    }

    @GetMapping("/remove")
    public String remove(){
        userRepository.deleteAll();
        return "Successfully deleted";
    }
}
