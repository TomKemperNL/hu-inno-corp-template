package nl.hu.inno.hulp.democlient;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    @Value("${message}")
    private String message;

    @GetMapping("/message")
    public String getMessage(){
        return this.message;
    }


    @Autowired
    private EurekaClient discoveryClient;

    @GetMapping("/services")
    public List<InstanceInfo> services(){
        return this.discoveryClient.getApplication("demo").getInstances();
    }
}
