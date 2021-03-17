package nl.hu.bep.example.fancyfishpro.service;

import nl.hu.bep.example.fancyfishpro.InzetRepository;
import nl.hu.bep.example.fancyfishpro.model.Inzet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InzetService {

    @Autowired
    private InzetRepository inzetRepository;

    public List<Inzet> list(){
        return inzetRepository.findAll();
    }
}
