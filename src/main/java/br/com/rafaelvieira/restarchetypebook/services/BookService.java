package br.com.rafaelvieira.restarchetypebook.services;

import br.com.rafaelvieira.restarchetypebook.data.model.Book;
import br.com.rafaelvieira.restarchetypebook.data.vo.BookVO;
import br.com.rafaelvieira.restarchetypebook.exception.ResourceNotFoundException;
import br.com.rafaelvieira.restarchetypebook.repository.BookRepository;
import br.com.rafaelvieira.restarchetypebook.utils.DozerConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class BookService {

    @Autowired
    BookRepository repository;

    public BookVO create(BookVO book) {
        var entity = DozerConverter.parseObject(book, Book.class);
        var vo = DozerConverter.parseObject(repository.save(entity), BookVO.class);
        return vo;
    }

    public Page<BookVO> findAll(Pageable pageable) {
        var page = repository.findAll(pageable);
        return page.map(this::convertToBookVO);
    }

    private BookVO convertToBookVO(Book entity) {
        return DozerConverter.parseObject(entity, BookVO.class);
    }

    public BookVO findById(Long id) {

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return DozerConverter.parseObject(entity, BookVO.class);
    }

    public BookVO update(BookVO book) {
        var entity = repository.findById(book.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setAuthor(book.getAuthor());
        entity.setLaunchDate(book.getLaunchDate());
        entity.setPrice(book.getPrice());
        entity.setTitle(book.getTitle());

        var vo = DozerConverter.parseObject(repository.save(entity), BookVO.class);
        return vo;
    }

    public void delete(Long id) {
        Book entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);
    }

}
