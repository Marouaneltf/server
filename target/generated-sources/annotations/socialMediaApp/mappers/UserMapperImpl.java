package socialMediaApp.mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import socialMediaApp.models.Follow;
import socialMediaApp.models.User;
import socialMediaApp.requests.UserAddRequest;
import socialMediaApp.responses.user.UserFollowerResponse;
import socialMediaApp.responses.user.UserFollowingResponse;
import socialMediaApp.responses.user.UserResponse;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-24T23:07:44+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserFollowerResponse followToFollowerResponse(Follow follow) {
        if ( follow == null ) {
            return null;
        }

        UserFollowerResponse userFollowerResponse = new UserFollowerResponse();

        userFollowerResponse.setUserId( followUserId( follow ) );
        userFollowerResponse.setName( followUserName( follow ) );
        userFollowerResponse.setLastName( followUserLastName( follow ) );

        return userFollowerResponse;
    }

    @Override
    public UserFollowingResponse followToFollowingResponse(Follow follow) {
        if ( follow == null ) {
            return null;
        }

        UserFollowingResponse userFollowingResponse = new UserFollowingResponse();

        userFollowingResponse.setUserId( followFollowingId( follow ) );
        userFollowingResponse.setLastName( followFollowingLastName( follow ) );
        userFollowingResponse.setName( followFollowingName( follow ) );

        return userFollowingResponse;
    }

    @Override
    public UserResponse userToResponse(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponse userResponse = new UserResponse();

        userResponse.setFollowers( followSetToUserFollowerResponseList( user.getFollowers() ) );
        userResponse.setFollowing( followSetToUserFollowingResponseList( user.getFollowing() ) );
        userResponse.setId( user.getId() );
        userResponse.setName( user.getName() );
        userResponse.setLastName( user.getLastName() );
        userResponse.setEmail( user.getEmail() );

        return userResponse;
    }

    @Override
    public User requestToUser(UserAddRequest userAddRequest) {
        if ( userAddRequest == null ) {
            return null;
        }

        User user = new User();

        user.setName( userAddRequest.getName() );
        user.setEmail( userAddRequest.getEmail() );
        user.setLastName( userAddRequest.getLastName() );
        user.setPassword( userAddRequest.getPassword() );

        return user;
    }

    @Override
    public List<UserResponse> usersToResponses(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserResponse> list = new ArrayList<UserResponse>( users.size() );
        for ( User user : users ) {
            list.add( userToResponse( user ) );
        }

        return list;
    }

    @Override
    public List<UserFollowingResponse> followsToFollowingResponses(List<Follow> follows) {
        if ( follows == null ) {
            return null;
        }

        List<UserFollowingResponse> list = new ArrayList<UserFollowingResponse>( follows.size() );
        for ( Follow follow : follows ) {
            list.add( followToFollowingResponse( follow ) );
        }

        return list;
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

    private String followUserName(Follow follow) {
        if ( follow == null ) {
            return null;
        }
        User user = follow.getUser();
        if ( user == null ) {
            return null;
        }
        String name = user.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String followUserLastName(Follow follow) {
        if ( follow == null ) {
            return null;
        }
        User user = follow.getUser();
        if ( user == null ) {
            return null;
        }
        String lastName = user.getLastName();
        if ( lastName == null ) {
            return null;
        }
        return lastName;
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

    private String followFollowingLastName(Follow follow) {
        if ( follow == null ) {
            return null;
        }
        User following = follow.getFollowing();
        if ( following == null ) {
            return null;
        }
        String lastName = following.getLastName();
        if ( lastName == null ) {
            return null;
        }
        return lastName;
    }

    private String followFollowingName(Follow follow) {
        if ( follow == null ) {
            return null;
        }
        User following = follow.getFollowing();
        if ( following == null ) {
            return null;
        }
        String name = following.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    protected List<UserFollowerResponse> followSetToUserFollowerResponseList(Set<Follow> set) {
        if ( set == null ) {
            return null;
        }

        List<UserFollowerResponse> list = new ArrayList<UserFollowerResponse>( set.size() );
        for ( Follow follow : set ) {
            list.add( followToFollowerResponse( follow ) );
        }

        return list;
    }

    protected List<UserFollowingResponse> followSetToUserFollowingResponseList(Set<Follow> set) {
        if ( set == null ) {
            return null;
        }

        List<UserFollowingResponse> list = new ArrayList<UserFollowingResponse>( set.size() );
        for ( Follow follow : set ) {
            list.add( followToFollowingResponse( follow ) );
        }

        return list;
    }
}
