package dev.top;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.top.entities.Collegue;
import dev.top.entities.Version;
import dev.top.repos.CollegueRepository;
import dev.top.repos.VersionRepo;

@Component
public class StartupDataInit {

    @Autowired
    VersionRepo versionRepo;
    @Autowired
    CollegueRepository collegueRepo;
    @EventListener(ContextRefreshedEvent.class)
    public void init() {

        if(this.versionRepo.count() <= 0) {
            this.versionRepo.save(new Version("v1"));
            this.versionRepo.save(new Version("v2"));
            this.versionRepo.save(new Version("v3"));
            this.versionRepo.save(new Version("v4"));
        }
        
        List<String> imgUrlT = new ArrayList<>();
        List<String> imgUrlB = new ArrayList<>();
        List<String> imgUrlS = new ArrayList<>();
        
        imgUrlT.add("./src/main/resources/images/tomme.jpg");
        imgUrlT.add("./src/main/resources/images/giphy.gif");
        imgUrlB.add("./src/main/resources/images/BobRazowsky.jpg");
        imgUrlB.add("./src/main/resources/images/bobRazowsky2.jpg");
        imgUrlS.add("./src/main/resources/images/sully.jpg");
        imgUrlS.add("./src/main/resources/images/sullYoung.jpg");
        
        if(this.collegueRepo.count()<=0) {
        	this.collegueRepo.save(new Collegue("thomas", imgUrlT, 0));
        	this.collegueRepo.save(new Collegue("bob", imgUrlB, 0));
        	this.collegueRepo.save(new Collegue("sullyvan", imgUrlS, 0));
        }
    }
}
