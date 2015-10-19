package contacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class ContactController {
    private ContactRepository repo;
    @Autowired
    public ContactController(ContactRepository repo){
        this.repo = repo;
    }
    @RequestMapping(method = RequestMethod.GET)
    public String home(Map<String,Object> model){
        List<Contact> contacts = repo.findAll();
        model.put("contacts", contacts);
        return "home";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String submit(Contact contact){
        repo.save(contact);
        return "redirect:/";
    }

//    public static void main(String[] args) throws Exception {
//        SpringApplication.run(ContactController.class, args);
//    }
}
