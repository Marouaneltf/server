package socialMediaApp.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import socialMediaApp.models.Post;
import socialMediaApp.models.User;
import socialMediaApp.requests.PostAddRequest;
import socialMediaApp.responses.post.PostGetResponse;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-24T23:07:44+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21 (Oracle Corporation)"
)
@Component
public class PostMapperImpl implements PostMapper {

    @Override
    public PostGetResponse postToGetResponse(Post post) {
        if ( post == null ) {
            return null;
        }

        PostGetResponse postGetResponse = new PostGetResponse();

        postGetResponse.setUserId( postUserId( post ) );
        postGetResponse.setUserLastName( postUserLastName( post ) );
        postGetResponse.setUserName( postUserName( post ) );
        postGetResponse.setId( post.getId() );
        postGetResponse.setDescription( post.getDescription() );

        return postGetResponse;
    }

    @Override
    public Post postAddRequestToPost(PostAddRequest postAddRequest) {
        if ( postAddRequest == null ) {
            return null;
        }

        Post post = new Post();

        post.setUser( postAddRequestToUser( postAddRequest ) );
        post.setDescription( postAddRequest.getDescription() );

        return post;
    }

    @Override
    public List<PostGetResponse> postsToGetResponses(List<Post> posts) {
        if ( posts == null ) {
            return null;
        }

        List<PostGetResponse> list = new ArrayList<PostGetResponse>( posts.size() );
        for ( Post post : posts ) {
            list.add( postToGetResponse( post ) );
        }

        return list;
    }

    private int postUserId(Post post) {
        if ( post == null ) {
            return 0;
        }
        User user = post.getUser();
        if ( user == null ) {
            return 0;
        }
        int id = user.getId();
        return id;
    }

    private String postUserLastName(Post post) {
        if ( post == null ) {
            return null;
        }
        User user = post.getUser();
        if ( user == null ) {
            return null;
        }
        String lastName = user.getLastName();
        if ( lastName == null ) {
            return null;
        }
        return lastName;
    }

    private String postUserName(Post post) {
        if ( post == null ) {
            return null;
        }
        User user = post.getUser();
        if ( user == null ) {
            return null;
        }
        String name = user.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    protected User postAddRequestToUser(PostAddRequest postAddRequest) {
        if ( postAddRequest == null ) {
            return null;
        }

        User user = new User();

        user.setId( postAddRequest.getUserId() );

        return user;
    }
}
