package wuhao.service;

import org.springframework.stereotype.Service;
import wuhao.dto.BookDTO;

import java.util.List;

@Service
public class BookService {
    public List<BookDTO> getAllBooks(){
        return List.of(
                new BookDTO(1l,"java Programming","Alice",29.99),
                new BookDTO(2L,"Spring Boot Action","Bob",39.99)
        );
    }
}
