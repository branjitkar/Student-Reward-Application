package MyProject.ElementDemo.controller;

import MyProject.ElementDemo.domain.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import MyProject.ElementDemo.service.ElementServiceImpl;

@RestController
@RequestMapping("/element")
public class ElementController {
    @Autowired
    ElementServiceImpl elementServiceImpl;
    private static final Logger logger =
            LoggerFactory.getLogger(ElementController.class.getName());

    @GetMapping
    public ResponseEntity<?> getAllElement(){
        logger.info("Viewing all elements");
        return ResponseEntity.ok(elementServiceImpl.getAllElement());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Element> getElementById(@PathVariable String id){
        logger.info("calling  getElement By Id");
        return ResponseEntity.ok(elementServiceImpl.getElementById(id));
    }
    @PostMapping
    public ResponseEntity<Element> addElementById(@RequestBody Element element){
        logger.info("calling addElement");
        return ResponseEntity.ok(elementServiceImpl.addElement(element));
    }

    @DeleteMapping("/{id}")
    public void deleteElementById(@PathVariable String id){
        logger.info("calling deleteElement By Id ");
        elementServiceImpl.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateElementById(@PathVariable String id, @RequestBody Element element){
        logger.info("calling Editing Element ");
        return ResponseEntity.ok(elementServiceImpl.UpdateElementById(id,element));
    }


}
