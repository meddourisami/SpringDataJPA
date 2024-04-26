package tp.fst.tp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tp.fst.tp.entities.Product;
import tp.fst.tp.repository.ProductRepository;

import java.util.List;


@SpringBootApplication
public class TpApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(TpApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //productRepository.save(new Product(null,"Computer", 2000,20));
        //productRepository.save(new Product(null,"Printer", 500,5));
        //productRepository.save(new Product(null,"Smart Phone", 900,30));
        List<Product> products = productRepository.findAll();
        products.forEach(product ->{
            System.out.println(product.toString());
        });
        Product product = productRepository.findById(1L).get();
        System.out.println("********************************");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        System.out.println(product.getQuantity());
        System.out.println("********************************");

        List<Product> productList = productRepository.findByNameContains("C");
        productList.forEach(p ->{
            System.out.println(p);
        });
        System.out.println("---------------------------------");
        List<Product> productList2 = productRepository.search("%C%");
        productList2.forEach(p ->{
            System.out.println(p);
        });

    }
}
