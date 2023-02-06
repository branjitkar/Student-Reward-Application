package MyProject.AvatarDemo.avatarController;
import MyProject.AvatarDemo.avatarDomain.Avatar;
import MyProject.AvatarDemo.Service.AvatarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/avatar")
public class AvatarController {
    @Autowired
    AvatarService avatarService;
    private static final Logger logger =
            LoggerFactory.getLogger(AvatarController.class.getName());
    @GetMapping
    public ResponseEntity<?> getAllAvatar() {
        logger.info("calling getAllAvatar");

        return ResponseEntity.ok(avatarService.getAllAvatar());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Avatar> getAvatarById(@PathVariable String id){
        logger.info("call  getAvatarById");
        return ResponseEntity.ok(avatarService.getAvatarById(id));
    }
    @PostMapping
    public ResponseEntity <Avatar> addProduct(@RequestBody Avatar avatar){
        logger.info("calling addProduct");
        return ResponseEntity.ok(avatarService.addAvatar(avatar));
    }

    @DeleteMapping("/{id}")
    public void deleteAvatarById(@PathVariable String id){
        logger.info("calling deleteAvatarById ");
        avatarService.deleteAvatarById(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Avatar> EditAvatar(@PathVariable String id,@RequestBody Avatar avatar){
        logger.info("calling EditingByAvatarById ");
        return ResponseEntity.ok(avatarService.editAvatar(id,avatar));
    }







}
