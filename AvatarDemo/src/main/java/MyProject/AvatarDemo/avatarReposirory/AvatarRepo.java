package MyProject.AvatarDemo.avatarReposirory;

import MyProject.AvatarDemo.avatarDomain.Avatar;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvatarRepo extends MongoRepository<Avatar,String> {
}
