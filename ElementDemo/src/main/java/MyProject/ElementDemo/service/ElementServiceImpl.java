package MyProject.ElementDemo.service;

import MyProject.ElementDemo.domain.Element;
import MyProject.ElementDemo.exception.ElementNotFoundException;
import MyProject.ElementDemo.repository.ElementRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@org.springframework.stereotype.Service
public class ElementServiceImpl implements Service{
    @Autowired
    ElementRepository elementRepository;
    @Override
    public List<Element> getAllElement() {
        return elementRepository.findAll();
    }

    @Override
    public Element getElementById(String id) {
        return elementRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(String id) {
        Element element= elementRepository.findById(id).orElse(null);
        if(element==null) {
            throw new ElementNotFoundException("Element not found");
        }else
        elementRepository.deleteById(id);
    }

    @Override
    public Element UpdateElementById(String id, Element element) {


        Element element1= elementRepository.findById(id).orElse(null);
        if(element1==null){
            throw new ElementNotFoundException("not found");

        }else
            element1.setType(element.getType());
            element1.setPrice(element.getPrice());
        return elementRepository.save(element1);
    }

    @Override
    public Element addElement( Element element) {
        return elementRepository.save(element);
    }
}
