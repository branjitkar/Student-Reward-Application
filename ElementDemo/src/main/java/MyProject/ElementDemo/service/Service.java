package MyProject.ElementDemo.service;

import MyProject.ElementDemo.domain.Element;

import java.util.List;

public interface Service {
    List<Element> getAllElement();

    Element getElementById(String id);

    void deleteById(String id);

    Element UpdateElementById(String id, Element element);

    Element addElement(Element element);
}
