package MyProject.AvatarDemo.avatarDomain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Avatar {
   @Id
   private String  id;
   private String head, hair, eye, eyebrow, nose, mouth, ears, body, hat, top, topColour, hatColour;
}
