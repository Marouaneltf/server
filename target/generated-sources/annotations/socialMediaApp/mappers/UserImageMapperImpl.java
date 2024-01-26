package socialMediaApp.mappers;

import java.util.Arrays;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import socialMediaApp.models.User;
import socialMediaApp.models.UserImage;
import socialMediaApp.responses.userImage.UserImageResponse;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-24T23:07:44+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21 (Oracle Corporation)"
)
@Component
public class UserImageMapperImpl implements UserImageMapper {

    @Override
    public UserImageResponse userImageToResponse(UserImage userImage) {
        if ( userImage == null ) {
            return null;
        }

        UserImageResponse userImageResponse = new UserImageResponse();

        userImageResponse.setUserId( userImageUserId( userImage ) );
        userImageResponse.setId( userImage.getId() );
        userImageResponse.setName( userImage.getName() );
        userImageResponse.setType( userImage.getType() );
        byte[] data = userImage.getData();
        if ( data != null ) {
            userImageResponse.setData( Arrays.copyOf( data, data.length ) );
        }

        return userImageResponse;
    }

    private int userImageUserId(UserImage userImage) {
        if ( userImage == null ) {
            return 0;
        }
        User user = userImage.getUser();
        if ( user == null ) {
            return 0;
        }
        int id = user.getId();
        return id;
    }
}
