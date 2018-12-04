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
        
        imgUrlT.add("http://images.ecosia.org/-IuTdx3GsM7qYS6yX74cqeY-PCU=/0x390/smart/https%3A%2F%2Fles-alpages.fr%2Fwp-content%2Fuploads%2F2014%2F08%2Ftomme-de-savoie-acheter-fromage.jpg");
        imgUrlT.add("http://media.tenor.com/images/dfd5671e5d4847a48be0d024abd03e72/tenor.gif");
        imgUrlB.add("http://media.melty.fr/article-1556261-ajust_930/mini-bob-razowski.jpg");
        imgUrlB.add("http://tse3.mm.bing.net/th?id=OIP.YLbsad5708TiCrOsxWaopwHaEA&pid=Api");
        imgUrlS.add("http://tse3.mm.bing.net/th?id=OIP.7bMB1AMVL6FXDbAratJJigHaEA&pid=Api");
        imgUrlS.add("http://images.ecosia.org/c32pApvhII2IZtLeMQCom73aEBw=/0x390/smart/http%3A%2F%2Fmedia.fan2.fr%2Farticle-1320833-ajust_930-f56093%2Fsulli-sera-present-sur-les-bancs-de-la-fac.jpg");
       
        	this.collegueRepo.save(new Collegue("thomas", imgUrlT, 0));
        	this.collegueRepo.save(new Collegue("bob", imgUrlB, 0));
        	this.collegueRepo.save(new Collegue("sullyvan", imgUrlS, 0));

    }
}
