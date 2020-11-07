package aws.learnig;

import java.util.List;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
  @Autowired
  private BookRepository bookRepository;

  @PostMapping
  public Book saveBook(@RequestBody Book book) {
    return bookRepository.save(book);
  }

  @GetMapping
  public List<Book> findBooks() {
    return bookRepository.findAll();
  }

  @SneakyThrows
  @GetMapping("/{id}")
  public Book findBook(@PathVariable int id) {
    Book book = bookRepository.findById(id).orElseThrow(() -> new Exception("Book not available"));
    return book;
  }

  @DeleteMapping("/{id}")
  public void deleteBook(@PathVariable int id) {
    bookRepository.deleteById(id);
  }

  @PutMapping("/{id}")
  public Book updateBook(@RequestBody Book book) {
    return bookRepository.save(book);
  }

}
