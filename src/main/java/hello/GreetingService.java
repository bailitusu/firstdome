package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    @Transactional
    public void insertTwoGreeting() {
        Author author = new Author();
        author.setName("xiaowang");
        Greeting greetingA = new Greeting();
        greetingA.setContent("AAAAA hello");

        greetingA.getAuthors().add(author);
        greetingRepository.save(greetingA);

        Greeting greetingB = new Greeting();
        greetingB.setContent("BBBBB hello");
        greetingB.getAuthors().add(author);
        greetingRepository.save(greetingB);
    }
}
