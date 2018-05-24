package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping(value = "/author/{id}")
    public Author authorFindOne(@PathVariable("id") Integer id) {
        return authorRepository.findById(id).orElse(null);
    }
}
