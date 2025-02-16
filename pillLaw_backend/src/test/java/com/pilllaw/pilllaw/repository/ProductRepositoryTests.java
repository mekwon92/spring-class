package com.pilllaw.pilllaw.repository;


import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.pilllaw.pilllaw.entity.product.Product;
import com.pilllaw.pilllaw.entity.product.Product.ProductType;
import com.pilllaw.pilllaw.repository.ProductRepository;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
@Transactional
public class ProductRepositoryTests {

   @Autowired
    private ProductRepository productRepository;

    @Test
    @Rollback(false)
    public void testInsertProducts() {
        List<Product> products = List.of(
            Product.builder().pname("PainRelief").company("MediCorp").bestBefore(new Date()).effect("Relieves pain").precautions("Do not overdose").keep("Store in a cool place").cname("Paracetamol").type(ProductType.NORMAL).build(),
            Product.builder().pname("ColdCure").company("PharmaPlus").bestBefore(new Date()).effect("Treats cold symptoms").precautions("Consult doctor if pregnant").keep("Keep away from children").cname("Ibuprofen").type(ProductType.SUBONLY).build(),
            Product.builder().pname("EnergyBoost").company("HealthCo").bestBefore(new Date()).effect("Boosts energy levels").precautions("Not for heart patients").keep("Avoid direct sunlight").cname("Vitamin B12").type(ProductType.PACKAGE).build(),
            Product.builder().pname("ImmunityX").company("ImmunoLife").bestBefore(new Date()).effect("Strengthens immunity").precautions("Check for allergies").keep("Keep at room temperature").cname("Zinc").type(ProductType.NORMAL).build(),
            Product.builder().pname("DigestEase").company("GastroCare").bestBefore(new Date()).effect("Aids digestion").precautions("Not for children under 12").keep("Refrigerate after opening").cname("Probiotics").type(ProductType.SUBONLY).build(),
            Product.builder().pname("SleepWell").company("DreamPharma").bestBefore(new Date()).effect("Promotes restful sleep").precautions("Do not operate machinery").keep("Keep in original packaging").cname("Melatonin").type(ProductType.PACKAGE).build(),
            Product.builder().pname("HeartGuard").company("CardioMed").bestBefore(new Date()).effect("Supports heart health").precautions("Consult doctor before use").keep("Store in a dry place").cname("Omega-3").type(ProductType.EARLYBIRD).build(),
            Product.builder().pname("JointFlex").company("MoveWell").bestBefore(new Date()).effect("Reduces joint pain").precautions("Avoid if allergic to shellfish").keep("Keep sealed tightly").cname("Glucosamine").type(ProductType.NORMAL).build(),
            Product.builder().pname("SkinGlow").company("DermaCare").bestBefore(new Date()).effect("Improves skin health").precautions("Discontinue if rash occurs").keep("Store in a cool, dry place").cname("Collagen").type(ProductType.SUBONLY).build(),
            Product.builder().pname("VisionPlus").company("EyeHealth").bestBefore(new Date()).effect("Supports eye health").precautions("Consult eye specialist if needed").keep("Keep away from heat").cname("Lutein").type(ProductType.PACKAGE).build()
        );

        productRepository.saveAll(products);
    }
  
  
}
