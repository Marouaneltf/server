package socialMediaApp.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import socialMediaApp.models.Comment;
import socialMediaApp.models.Post;
import socialMediaApp.models.User;
import socialMediaApp.requests.CommentAddRequest;
import socialMediaApp.responses.comment.CommentGetResponse;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-24T23:07:44+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21 (Oracle Corporation)"
)
@Component
public class CommentMapperImpl implements CommentMapper {

    @Override
    public CommentGetResponse commentToResponse(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentGetResponse commentGetResponse = new CommentGetResponse();

        commentGetResponse.setUserId( commentUserId( comment ) );
        commentGetResponse.setPostId( commentPostId( comment ) );
        commentGetResponse.setUserName( commentUserName( comment ) );
        commentGetResponse.setUserLastName( commentUserLastName( comment ) );
        commentGetResponse.setId( comment.getId() );
        commentGetResponse.setDescription( comment.getDescription() );

        return commentGetResponse;
    }

    @Override
    public List<CommentGetResponse> commentsToResponses(List<Comment> comments) {
        if ( comments == null ) {
            return null;
        }

        List<CommentGetResponse> list = new ArrayList<CommentGetResponse>( comments.size() );
        for ( Comment comment : comments ) {
            list.add( commentToResponse( comment ) );
        }

        return list;
    }

    @Override
    public Comment addRequestToComment(CommentAddRequest commentAddRequest) {
        if ( commentAddRequest == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setUser( commentAddRequestToUser( commentAddRequest ) );
        comment.setPost( commentAddRequestToPost( commentAddRequest ) );
        comment.setDescription( commentAddRequest.getDescription() );

        return comment;
    }

    private int commentUserId(Comment comment) {
        if ( comment == null ) {
            return 0;
        }
        User user = comment.getUser();
        if ( user == null ) {
            return 0;
        }
        int id = user.getId();
        return id;
    }

    private int commentPostId(Comment comment) {
        if ( comment == null ) {
            return 0;
        }
        Post post = comment.getPost();
        if ( post == null ) {
            return 0;
        }
        int id = post.getId();
        return id;
    }

    private String commentUserName(Comment comment) {
        if ( comment == null ) {
            return null;
        }
        User user = comment.getUser();
        if ( user == null ) {
            return null;
        }
        String name = user.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String commentUserLastName(Comment comment) {
        if ( comment == null ) {
            return null;
        }
        User user = comment.getUser();
        if ( user == null ) {
            return null;
        }
        String lastName = user.getLastName();
        if ( lastName == null ) {
            return null;
        }
        return lastName;
    }

    protected User commentAddRequestToUser(CommentAddRequest commentAddRequest) {
        if ( commentAddRequest == null ) {
            return null;
        }

        User user = new User();

        user.setId( commentAddRequest.getUserId() );

        return user;
    }

    protected Post commentAddRequestToPost(CommentAddRequest commentAddRequest) {
        if ( commentAddRequest == null ) {
            return null;
        }

        Post post = new Post();

        post.setId( commentAddRequest.getPostId() );

        return post;
    }
}
