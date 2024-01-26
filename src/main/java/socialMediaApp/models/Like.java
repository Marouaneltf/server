package socialMediaApp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@EnableAutoConfiguration
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "likes")
public class Like {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private  int id;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "post_id")
    Post post;
}
