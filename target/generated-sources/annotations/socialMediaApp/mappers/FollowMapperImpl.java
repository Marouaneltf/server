package socialMediaApp.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import socialMediaApp.models.Follow;
import socialMediaApp.models.User;
import socialMediaApp.requests.FollowRequest;
import socialMediaApp.responses.follow.FollowResponse;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-24T23:07:44+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21 (Oracle Corporation)"
)
@Component
public class FollowMapperImpl implements FollowMapper {

    @Override
    public FollowResponse followToResponse(Follow follow) {
        if ( follow == null ) {
            return null;
        }

        FollowResponse followResponse = new FollowResponse();

        followResponse.setFollowingId( followFollowingId( follow ) );
        followResponse.setFollowerId( followUserId( follow ) );
        followResponse.setId( follow.getId() );

        followResponse.setFollowingName( follow.getFollowing().getName() + " "+follow.getFollowing().getLastName() );
        followResponse.setFollowerName( follow.getUser().getName() + " "+follow.getUser().getLastName() );

        return followResponse;
    }

    @Override
    public Follow addRequestToFollow(FollowRequest followAddRequest) {
        if ( followAddRequest == null ) {
            return null;
        }

        Follow follow = new Follow();

        follow.setUser( followRequestToUser( followAddRequest ) );
        follow.setFollowing( followRequestToUser1( followAddRequest ) );

        return follow;
    }

    @Override
    public List<FollowResponse> followsToResponses(List<Follow> follows) {
        if ( follows == null ) {
            return null;
        }

        List<FollowResponse> list = new ArrayList<FollowResponse>( follows.size() );
        for ( Follow follow : follows ) {
            list.add( followToResponse( follow ) );
        }

        return list;
    }

    private int followFollowingId(Follow follow) {
        if ( follow == null ) {
            return 0;
        }
        User following = follow.getFollowing();
        if ( following == null ) {
            return 0;
        }
        int id = following.getId();
        return id;
    }

    private int followUserId(Follow follow) {
        if ( follow == null ) {
            return 0;
        }
        User user = follow.getUser();
        if ( user == null ) {
            return 0;
        }
        int id = user.getId();
        return id;
    }

    protected User followRequestToUser(FollowRequest followRequest) {
        if ( followRequest == null ) {
            return null;
        }

        User user = new User();

        user.setId( followRequest.getUserId() );

        return user;
    }

    protected User followRequestToUser1(FollowRequest followRequest) {
        if ( followRequest == null ) {
            return null;
        }

        User user = new User();

        user.setId( followRequest.getFollowingId() );

        return user;
    }
}
