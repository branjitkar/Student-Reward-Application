package MyProject.AvatarDemo.Service;

import MyProject.AvatarDemo.avatarDomain.Avatar;
import MyProject.AvatarDemo.avatarReposirory.AvatarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import MyProject.AvatarDemo.Exception.AvatarNotFoundException;

import java.util.List;
@Service
public class AvatarService implements AvatarServiceInter{
    @Autowired
    AvatarRepo avatarRepo;
    @Override
    public List<Avatar> getAllAvatar() {
        return avatarRepo.findAll();
    }

    @Override
    public Avatar getAvatarById(String id) {
        Avatar avatar= avatarRepo.findById(id).orElse(null);
        return avatar;
        }

    @Override
    public Avatar addAvatar(Avatar avatar) {
        return avatarRepo.save(avatar);
    }

    @Override
    public void deleteAvatarById(String head) {
        Avatar avatar= avatarRepo.findById(head).orElse(null);
        if(avatar==null){
            throw new AvatarNotFoundException("Avatar not found");
        }
        avatarRepo.deleteById(head);

    }

    @Override
    public Avatar editAvatar(String id, Avatar avatar) {
        Avatar avatar1= avatarRepo.findById(id).orElse(null);
        if(avatar1==null){
           throw  new AvatarNotFoundException("Avatar not found");

        }
        avatar1.setBody(avatar.getBody());
        avatar1.setEars(avatar.getEars());
        avatar1.setHat(avatar.getHat());
        avatar1.setEye(avatar.getEye());
        avatar1.setHatColour(avatar1.getHatColour());
        avatar1.setMouth(avatar.getMouth());
        avatar1.setTop(avatar.getTop());
        avatar1.setEyebrow(avatar.getEyebrow());
        avatar1.setNose(avatar.getNose());
        avatar1.setTopColour(avatar.getTopColour());
        avatar1.setHair(avatar.getHair());
        avatar1.setHead(avatar.getHead());

        return avatarRepo.save(avatar1);

    }

}
