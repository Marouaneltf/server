package socialMediaApp.mappers;

import java.util.Arrays;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import socialMediaApp.models.Post;
import socialMediaApp.models.PostImage;
import socialMediaApp.responses.postImage.PostImageResponse;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-24T23:07:44+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21 (Oracle Corporation)"
)
@Component
public class PostImageMapperImpl implements PostImageMapper {

    @Override
    public PostImageResponse imageToResponse(PostImage postImage) {
        if ( postImage == null ) {
            return null;
        }

        PostImageResponse postImageResponse = new PostImageResponse();

        postImageResponse.setPostId( postImagePostId( postImage ) );
        postImageResponse.setId( postImage.getId() );
        postImageResponse.setName( postImage.getName() );
        postImageResponse.setType( postImage.getType() );
        byte[] data = postImage.getData();
        if ( data != null ) {
            postImageResponse.setData( Arrays.copyOf( data, data.length ) );
        }

        return postImageResponse;
    }

    private int postImagePostId(PostImage postImage) {
        if ( postImage == null ) {
            return 0;
        }
        Post post = postImage.getPost();
        if ( post == null ) {
            return 0;
        }
        int id = post.getId();
        return id;
    }
}
