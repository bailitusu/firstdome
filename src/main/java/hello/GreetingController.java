package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GreetingController {

    @Autowired
    private GreetingRepository greetingRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private GreetingService greetingService;

    @GetMapping(value = "/greetings")
    public List<Greeting> greetingList() {
        return greetingRepository.findAll();
    }

    @PostMapping(value = "/greetings")
    public Greeting greetingAdd(@RequestParam("content") String content, @RequestParam("name") String authorName) {
        Greeting greeting = new Greeting();
        greeting.setContent(content);

        Author author = new Author();
        author.setName(authorName);

        greeting.getAuthors().add(author);
        authorRepository.save(author);
        greetingRepository.save(greeting);
        return greeting;
    }

    @GetMapping(value = "/greetings/{id}")
    public Greeting greetingFindOne(@PathVariable("id") Integer id) {
        return greetingRepository.findById(id).orElse(null);
    }

    @PutMapping(value = "/greetings/{id}")
    public Greeting greetingUpdate(@PathVariable("id") Integer id, @RequestParam("content") String content) {
        Greeting greeting = new Greeting();
        greeting.setContent(content);
        greeting.setId(id);
        return greetingRepository.save(greeting);
    }

    @DeleteMapping(value = "/greetings/{id}")
    public void greetDelete(@PathVariable("id") Integer id) {
        greetingRepository.deleteById(id);
    }

    @PostMapping(value = "/greetings/two")
    public void greetingTwo() {
        greetingService.insertTwoGreeting();
    }

}
