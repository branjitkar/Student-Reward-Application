package MyProject.AvatarDemo.Service;

import MyProject.AvatarDemo.avatarDomain.Avatar;

import java.util.List;

public interface AvatarServiceInter {
 List<Avatar> getAllAvatar();
    Avatar getAvatarById(String id);
    Avatar addAvatar(Avatar avatar);
    void deleteAvatarById(String id);
    Avatar editAvatar(String id, Avatar avatar);
}
