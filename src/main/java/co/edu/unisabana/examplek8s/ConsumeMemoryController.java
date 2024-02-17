package co.edu.unisabana.examplek8s;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumeMemoryController {

  private final MemoryConsume memoryConsume;

  @Value("${propiedad_cualquiera}")
  private String variable;

  public ConsumeMemoryController(MemoryConsume memoryConsume) {
    this.memoryConsume = memoryConsume;
  }
  @GetMapping(path = "/saludar")
  public String saludar() {
    return variable;
  }

  @GetMapping(path = "/consume/{memory}")
  public String consumeMemory(@PathVariable int memory) {
    memoryConsume.consume(memory);
    return "ok";
  }

  @GetMapping(path = "/consume/cpu")
  public String consumeCPU() {
    for (int x = 0; x < 100000; x++) {
      for (int y = 0; y < 10000; y++) {
        int suma = x + y;
      }
    }
    return "ok";
  }
}
