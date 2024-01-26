package socialMediaApp.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import socialMediaApp.models.Like;
import socialMediaApp.models.Post;
import socialMediaApp.models.User;
import socialMediaApp.requests.LikeRequest;
import socialMediaApp.responses.like.LikeResponse;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-24T23:07:44+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21 (Oracle Corporation)"
)
@Component
public class LikeMapperImpl implements LikeMapper {

    @Override
    public LikeResponse likeToPostLikeResponse(Like like) {
        if ( like == null ) {
            return null;
        }

        LikeResponse likeResponse = new LikeResponse();

        likeResponse.setUserId( likeUserId( like ) );
        likeResponse.setName( likeUserName( like ) );
        likeResponse.setLastName( likeUserLastName( like ) );
        likeResponse.setId( like.getId() );

        return likeResponse;
    }

    @Override
    public Like requestToLike(LikeRequest likeRequest) {
        if ( likeRequest == null ) {
            return null;
        }

        Like like = new Like();

        like.setPost( likeRequestToPost( likeRequest ) );
        like.setUser( likeRequestToUser( likeRequest ) );

        return like;
    }

    @Override
    public List<LikeResponse> likesToLikeResponses(List<Like> likes) {
        if ( likes == null ) {
            return null;
        }

        List<LikeResponse> list = new ArrayList<LikeResponse>( likes.size() );
        for ( Like like : likes ) {
            list.add( likeToPostLikeResponse( like ) );
        }

        return list;
    }

    private int likeUserId(Like like) {
        if ( like == null ) {
            return 0;
        }
        User user = like.getUser();
        if ( user == null ) {
            return 0;
        }
        int id = user.getId();
        return id;
    }

    private String likeUserName(Like like) {
        if ( like == null ) {
            return null;
        }
        User user = like.getUser();
        if ( user == null ) {
            return null;
        }
        String name = user.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String likeUserLastName(Like like) {
        if ( like == null ) {
            return null;
        }
        User user = like.getUser();
        if ( user == null ) {
            return null;
        }
        String lastName = user.getLastName();
        if ( lastName == null ) {
            return null;
        }
        return lastName;
    }

    protected Post likeRequestToPost(LikeRequest likeRequest) {
        if ( likeRequest == null ) {
            return null;
        }

        Post post = new Post();

        post.setId( likeRequest.getPostId() );

        return post;
    }

    protected User likeRequestToUser(LikeRequest likeRequest) {
        if ( likeRequest == null ) {
            return null;
        }

        User user = new User();

        user.setId( likeRequest.getUserId() );

        return user;
    }
}
