package com.rdutta.meanstack.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rdutta.meanstack.model.Provider;
import com.rdutta.meanstack.service.ProviderService;


@RestController
@RequestMapping("/providers")
public class MainController {
	
    private ProviderService pService;

    @Autowired
    public MainController(ProviderService pService) {
        this.pService = pService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Provider>> readAll(){
        List<Provider> providers = pService.readAll();
        return new ResponseEntity<>(providers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Provider> readOneProvider(@PathVariable("id") Long id){
        Provider providers = pService.findOneProvider(id);
        return new ResponseEntity<>(providers, HttpStatus.OK);
    }

    @PostMapping("/create-provider")
    public ResponseEntity<Provider> createProvider(@RequestBody Provider provider){
       pService.createProvider(provider);
       return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Provider> updateProvider(@PathVariable("id") Long id, @RequestBody Provider provider){
        pService.findOneAndUpdate(id, provider);
        return new ResponseEntity<>(HttpStatus.CREATED);
     }

     @DeleteMapping("/deleteAll")
     public ResponseEntity<Provider> deleteAllProvider(){
        pService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
     }

     @DeleteMapping("/{id}")
     public ResponseEntity<Provider> deleteOneProvider(@PathVariable("id") Long id){
        pService.deleteOneProvider(id);
        return new ResponseEntity<>(HttpStatus.OK);
     }
    
}
