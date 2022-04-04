package java.com.cesi.ressourcesrelationnelles.test.features.comments;

import com.cesi.ressourcesrelationnelles.domain.Comment;
import com.cesi.ressourcesrelationnelles.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CommentServiceMockedTest {

    private final List<Comment> commentMockList;
    @Mock
    private CommentRepository commentRepository;
    @InjectMocks
    private CommentService commentService;

    public CommentServiceMockedTest() {
        commentMockList = new ArrayList<>();
        commentMockList.add(new Comment("Paul", "Comment 1"));
        commentMockList.add(new Comment("Romain", "Comment 2"));
        commentMockList.add(new Comment("Jean", "Comment 4"));
        commentMockList.add(new Comment("Guy", "Comment 999"));
    }

    @BeforeTestClass
    public void initMock() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findUsersByAuthorTest() {
        // given
        Mockito.when(commentRepository.findAll()).thenReturn(commentMockList);
        // when
        List<Comment> comments = commentService.getList("Romain", null);
        // then
        Mockito.verify(commentRepository, Mockito.times(1)).findAll();
        assertNotNull(comments);
        assertEquals(1, comments.size());
        assertEquals("Romain", comments.get(0).getAuthor());
    }

    @Test
    void findUsersByAuthorNotFindTest() {
        //given
        Mockito.when(commentRepository.findAll()).thenReturn(commentMockList);
        // when
        List<Comment> comments = commentService.getList("Jack", null);
        // then
        Mockito.verify(commentRepository, Mockito.times(1)).findAll();
        assertNotNull(comments);
        assertEquals(0, comments.size());
    }

    @Test
    void findUsersByTitleTest() {
        //given
        Mockito.when(commentRepository.findAll()).thenReturn(commentMockList);
        // when
        List<Comment> comments = commentService.getList(null, "Comment 1");
        // then
        Mockito.verify(commentRepository, Mockito.times(1)).findAll();
        assertEquals(1, comments.size());
        assertEquals("Comment 1", comments.get(0).getTitle());
    }

    @Test
    void findUsersByTitleNotFindTest() {
        //given
        Mockito.when(commentRepository.findAll()).thenReturn(commentMockList);
        // when
        List<Comment> comments = commentService.getList(null, "Comment 1000");
        // then
        Mockito.verify(commentRepository, Mockito.times(1)).findAll();
        assertNotNull(comments);
        assertEquals(0, comments.size());
    }

    @Test
    void findUsersByAuthorAndTitleTest() {
        // given
        Mockito.when(commentRepository.findAll()).thenReturn(commentMockList);
        // when
        List<Comment> comments = commentService.getList("Romain", "Comment 2");
        // then
        Mockito.verify(commentRepository, Mockito.times(1)).findAll();
        assertEquals(1, comments.size());
        assertEquals("Comment 2", comments.get(0).getTitle());
        assertEquals("Romain", comments.get(0).getAuthor());

    }

    @Test
    void findUsersByAuthorAndTitleNotFindTest() {
        // given
        Mockito.when(commentRepository.findAll()).thenReturn(commentMockList);
        // when
        List<Comment> comments = commentService.getList("Jean", "Comment 999");
        // then
        Mockito.verify(commentRepository, Mockito.times(1)).findAll();
        assertNotNull(comments);
        assertEquals(0, comments.size());
    }

    // Test pour information sur MOCKITO
    @Test
    void findUsersByIdTest() throws NotFoundException {
        // given
        Comment comment1 = new Comment("Romain", "Comment");
        Comment comment2 = new Comment("Romain", "Comment2");
        Mockito.when(commentRepository.findById(14L)).thenReturn(Optional.of(comment1));
        Mockito.when(commentRepository.findById(28L)).thenReturn(Optional.of(comment2));
        // when
        Comment comment = commentService.getById(14L);
        // then
        assertEquals("Comment", comment.getTitle());
    }
}
