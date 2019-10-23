package Main;

import Service.ServiceController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableAutoConfiguration
@SpringBootApplication
@EntityScan(basePackages = "DataBase.Entities")
@ComponentScan(basePackages = "Service")
@EnableJpaRepositories(basePackages = "DataBase.repository")
public class Main {

    public static void main(String [] args)
    {

        System.out.println("hello");


        //SpringApplication.run(Main.class, args);
        ConfigurableApplicationContext context = SpringApplication.run(Main.class);
        ServiceController.setContext(context);
        int a=1;
        //GoodsRepo repository = context.getBean(GoodsRepo.class);
        /*Goods e=new Goods(2,"pumpkin",15.0);
        repository.save(e);
        Goods d=repository.findById(2);
        System.out.println(d.toString());*/
        /*
        repository.save(new Goods("Cucumber",1.0));
        repository.save(new Goods("Tomato",3.0));
        Iterable<Goods> arr= repository.findAll();
        for (Goods goods : arr) {
            System.out.println(goods);

        }*/
        //System.exit(0);

    }


}
